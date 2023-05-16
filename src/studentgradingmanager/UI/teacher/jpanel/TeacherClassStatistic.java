/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package studentgradingmanager.UI.teacher.jpanel;

import Database.DBConnect;
import OOP.MONHOC;
import OOP.Teacher;
import java.awt.BorderLayout;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import studentgradingmanager.utils.BarChart;

import java.awt.Dimension;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;


/**
 *
 * @author Quan
 */
public class TeacherClassStatistic extends javax.swing.JPanel {

    private Teacher teacherItem;
    private List<String> listMAHK;
    private List<String> listNAMHOC;
    private List<MONHOC> listMONHOC = new ArrayList<>();
    private BarChart bcGradeStatisticChart;

    /**
     * Creates new form TeacherClassStatistic
     */
    public TeacherClassStatistic(Teacher teacherItem) {
        initComponents();
        this.teacherItem = teacherItem;
        //Add data to chart

        jRadioButton1.setSelected(true);

        importData();
        findSemester();
        setSubject();
        jpGradeStatisticChart.setLayout(new BorderLayout());
        bcGradeStatisticChart = new BarChart("Thống kê môn Toán");
        bcGradeStatisticChart.addData(100, "1");
        bcGradeStatisticChart.addData(3, "2");
        bcGradeStatisticChart.addData(6, "3");
        bcGradeStatisticChart.addData(9, "4");
        jpGradeStatisticChart.add(bcGradeStatisticChart, BorderLayout.CENTER);
    }

    private void importData() {

    }

    private void setSubject() {
        listMONHOC.clear();
        jcbSubject.removeAllItems();

        if (jRadioButton1.isSelected() == true) {
            try {
                java.sql.Connection connection = DBConnect.getConnection();
                //JOptionPane.showMessageDialog(this, "Xin chào giáo viên " + matkGV);

                String sql = "SELECT * FROM MONHOC";
                PreparedStatement statement = connection.prepareStatement(sql);
                ResultSet resultSet = statement.executeQuery();

                while (resultSet.next()) {
                    listMONHOC.add(new MONHOC(resultSet.getString("MAMH"), resultSet.getString("TENMH")));
                }

                if (!statement.isClosed()) {
                    statement.close();
                    System.out.println("Close SEARCH monhoc");
                }

                for (int i = 0; i < listMONHOC.size(); i++) {
                    jcbSubject.addItem(listMONHOC.get(i).getMAMH() + " - " + listMONHOC.get(i).getTENMH());
                }

            } catch (SQLException ex) {
                Logger.getLogger(TeacherSearchResultFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                java.sql.Connection connection = DBConnect.getConnection();
                //JOptionPane.showMessageDialog(this, "Xin chào giáo viên " + matkGV);

                String sql = "SELECT * FROM MONHOC";
                PreparedStatement statement = connection.prepareStatement(sql);
                ResultSet resultSet = statement.executeQuery();
                boolean isPresent = false;
//                while (resultSet.next()) {
//                    //listMONHOC.add(new MONHOC(resultSet.getString("MAMH"), resultSet.getString("TENMH")));
//                    System.err.println(resultSet.getString("TENMH"));
//                    if (listMONHOC.size() != 0) {
//                        for (int i = 0; i < listMONHOC.size(); i++) {
//                            if (listMONHOC.get(i).getMAMH().substring(0,2).equals(resultSet.getString("MAMH").substring(0,2))) {
//                                isPresent = true;
//                                System.out.println(listMONHOC.get(i).getMAMH().substring(0,2) + " -  " + resultSet.getString("MAMH").substring(0,2));
//                                break;
//                            }
//                        }
//                        if (isPresent == false) {
//                            listMONHOC.add(new MONHOC(resultSet.getString("MAMH"), resultSet.getString("TENMH")));
//                            //System.out.println("Kiem tra 1");
//                            isPresent = false;
//                        }
//                    } else {
//                        listMONHOC.add(new MONHOC(resultSet.getString("MAMH"), resultSet.getString("TENMH")));
//                        ///System.out.println("Kiem tra 2");
//                    }
//                }

                Set<String> distinctPrefixes = new HashSet<>();

                while (resultSet.next()) {
                    String mamh = resultSet.getString("MAMH");
                    String tenmh = resultSet.getString("TENMH");
                    String prefix = mamh.substring(0, 2);

                    if (!distinctPrefixes.contains(prefix)) {
                        distinctPrefixes.add(prefix);
                        listMONHOC.add(new MONHOC(mamh, tenmh));
                    }
                }

                if (!statement.isClosed()) {
                    statement.close();
                    System.out.println("Close SEARCH monhoc");
                }

                for (int i = 0; i < listMONHOC.size(); i++) {
                    jcbSubject.addItem(listMONHOC.get(i).getMAMH().substring(0, 2) + " - " + listMONHOC.get(i).getTENMH());
                }

            } catch (SQLException ex) {
                Logger.getLogger(TeacherSearchResultFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void findSemester() {
        listMAHK = new ArrayList<>();
        // tim MAHK
        try {
            java.sql.Connection connection = DBConnect.getConnection();
            //JOptionPane.showMessageDialog(this, "Xin chào giáo viên " + matkGV);

            String sql = "SELECT * FROM HOCKYNAMHOC";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                listMAHK.add(resultSet.getString("MAHK"));
            }

            if (!statement.isClosed()) {
                statement.close();
                System.out.println("Close SEARCH MAHK");
            }
        } catch (SQLException ex) {
            Logger.getLogger(TeacherSearchResultFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

        // add data vao jComboBox
        listNAMHOC = new ArrayList<>();
        try {
            java.sql.Connection connection = DBConnect.getConnection();
            //JOptionPane.showMessageDialog(this, "Xin chào giáo viên " + matkGV);

            String sql = "SELECT * FROM HOCKYNAMHOC";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            boolean isPresent = false;
            while (resultSet.next()) {
                if (listNAMHOC.size() != 0) {
                    for (int i = 0; i < listNAMHOC.size(); i++) {
                        if (listNAMHOC.get(i).equals(resultSet.getString("NAMHOC"))) {
                            isPresent = true;
                            //System.out.println("Kiem tra");
                            break;
                        }
                    }
                    if (!isPresent) {
                        listNAMHOC.add(resultSet.getString("NAMHOC"));
                        //System.out.println("Kiem tra 1");
                        isPresent = false;
                    }
                } else {
                    listNAMHOC.add(resultSet.getString("NAMHOC"));
                    ///System.out.println("Kiem tra 2");
                }

            }

            if (!statement.isClosed()) {
                statement.close();
                System.out.println("Close SEARCH MAHK");
            }

            jcbSemester.addItem("1");
            jcbSemester.addItem("2");

            for (String item : listNAMHOC) {
                if (listNAMHOC == null) {
                    break;
                } else {
                    jcbYear.addItem(item);
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(TeacherSearchResultFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jpTeacherClassStatistic = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jcbYear = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jcbSemester = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jcbSubject = new javax.swing.JComboBox<>();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jbtThongKe = new javax.swing.JButton();
        jpGradeStatisticChart = new javax.swing.JPanel();

        setPreferredSize(new java.awt.Dimension(760, 540));

        jpTeacherClassStatistic.setBackground(new java.awt.Color(255, 255, 255));
        jpTeacherClassStatistic.setPreferredSize(new java.awt.Dimension(760, 540));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Năm học");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Học kỳ");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Môn học");

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jRadioButton1.setText("Thống kê lớp học");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jRadioButton2.setText("Thống kê cả khối");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        jbtThongKe.setBackground(new java.awt.Color(102, 255, 102));
        jbtThongKe.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jbtThongKe.setText("Thống Kê");
        jbtThongKe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtThongKeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpGradeStatisticChartLayout = new javax.swing.GroupLayout(jpGradeStatisticChart);
        jpGradeStatisticChart.setLayout(jpGradeStatisticChartLayout);
        jpGradeStatisticChartLayout.setHorizontalGroup(
            jpGradeStatisticChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 587, Short.MAX_VALUE)
        );
        jpGradeStatisticChartLayout.setVerticalGroup(
            jpGradeStatisticChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 355, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jpTeacherClassStatisticLayout = new javax.swing.GroupLayout(jpTeacherClassStatistic);
        jpTeacherClassStatistic.setLayout(jpTeacherClassStatisticLayout);
        jpTeacherClassStatisticLayout.setHorizontalGroup(
            jpTeacherClassStatisticLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpTeacherClassStatisticLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpTeacherClassStatisticLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jpGradeStatisticChart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpTeacherClassStatisticLayout.createSequentialGroup()
                        .addGroup(jpTeacherClassStatisticLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jcbYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(72, 72, 72)
                        .addGroup(jpTeacherClassStatisticLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jcbSemester, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(63, 63, 63)
                        .addGroup(jpTeacherClassStatisticLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jcbSubject, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(61, 61, 61)
                        .addGroup(jpTeacherClassStatisticLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jRadioButton1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jRadioButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jbtThongKe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(161, Short.MAX_VALUE))
        );
        jpTeacherClassStatisticLayout.setVerticalGroup(
            jpTeacherClassStatisticLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpTeacherClassStatisticLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jpTeacherClassStatisticLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jRadioButton1)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpTeacherClassStatisticLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbSemester, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioButton2)
                    .addComponent(jcbSubject))
                .addGap(18, 18, 18)
                .addComponent(jbtThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpGradeStatisticChart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpTeacherClassStatistic, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpTeacherClassStatistic, javax.swing.GroupLayout.DEFAULT_SIZE, 542, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:
        setSubject();
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        // TODO add your handling code here:
        setSubject();
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jbtThongKeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtThongKeActionPerformed
        // TODO add your handling code here:
        if (jRadioButton1.isSelected() == true) {
            try {
                String namhoc = jcbYear.getSelectedItem().toString();
                String hocki = jcbYear.getSelectedItem().toString();
                String monhocchuaxuli = jcbSubject.getSelectedItem().toString();

                int index = monhocchuaxuli.indexOf('-');

                String mamonhoc = monhocchuaxuli.substring(0, index - 1);

                java.sql.Connection connection = DBConnect.getConnection();
                //JOptionPane.showMessageDialog(this, "Xin chào giáo viên " + matkGV);

                String sql = "SELECT * FROM DIEM WHERE MAMH = ?";
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1, mamonhoc);
                ResultSet resultSet = statement.executeQuery();
                int count0To5 = 0;
                int count5To7 = 0;
                int count7To9 = 0;
                int count9To10 = 0;
                while (resultSet.next()) {
                    String value = resultSet.getString("DIEMTBHK");
                    if (value != null && !value.isEmpty()) {
                        // Thực hiện các thao tác với chuỗi khi nó không rỗng
                        if (Double.valueOf(resultSet.getString("DIEMTBHK")) >= 0 && Double.valueOf(resultSet.getString("DIEMTBHK")) < 5) {
                            count0To5++;
                        } else if (Double.valueOf(resultSet.getString("DIEMTBHK")) < 7) {
                            count5To7++;
                        } else if (Double.valueOf(resultSet.getString("DIEMTBHK")) < 9) {
                            count7To9++;
                        } else {
                            count9To10++;
                        }
                    } else {
                        // Xử lý trường hợp chuỗi là null hoặc rỗng
                        System.err.println("nul;");
                    }

                }
                
                
                jpGradeStatisticChart.remove(bcGradeStatisticChart);
                jpGradeStatisticChart.revalidate();
                jpGradeStatisticChart.repaint(); 
                bcGradeStatisticChart = new BarChart("Thông Kê Môn " + monhocchuaxuli);
                bcGradeStatisticChart.addData(count0To5, "Điểm từ 0 - 5");
                bcGradeStatisticChart.addData(count5To7, "Điểm từ 5 - 7");
                bcGradeStatisticChart.addData(count7To9, "Điểm từ 7 - 9");
                bcGradeStatisticChart.addData(count9To10, "Điểm từ 9 - 10");
                jpGradeStatisticChart.add(bcGradeStatisticChart, BorderLayout.CENTER);
                
                

                
                
//                System.err.println(count0To5 + " " + count5To7 + " " + count7To9 + " " + count9To10);
//                jpGradeStatisticChart.setLayout(new BorderLayout());
//                BarChart bcGradeStatisticChart = new BarChart("Thống kê môn Toán");     
//                bcGradeStatisticChart.addData(count0To5, "Điểm từ 0 - 5");
//                bcGradeStatisticChart.addData(count5To7, "Điểm từ 5 - 7");
//                bcGradeStatisticChart.addData(count7To9, "Điểm từ 7 - 9");
//                bcGradeStatisticChart.addData(count9To10, "Điểm từ 9 - 10");
//                jpGradeStatisticChart.add(bcGradeStatisticChart, BorderLayout.CENTER);
                if (!statement.isClosed()) {
                    statement.close();
                    System.out.println("Close SEARCH MAHK");
                }

            } catch (SQLException ex) {
                Logger.getLogger(TeacherClassStatistic.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {

        }
    }//GEN-LAST:event_jbtThongKeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JButton jbtThongKe;
    private javax.swing.JComboBox<String> jcbSemester;
    private javax.swing.JComboBox<String> jcbSubject;
    private javax.swing.JComboBox<String> jcbYear;
    private javax.swing.JPanel jpGradeStatisticChart;
    private javax.swing.JPanel jpTeacherClassStatistic;
    // End of variables declaration//GEN-END:variables
}
