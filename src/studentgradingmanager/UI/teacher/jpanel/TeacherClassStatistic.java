/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package studentgradingmanager.UI.teacher.jpanel;

import Chart.ShowChart;
import Database.DBConnect;
import OOP.LOAIDIEM;
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
import javax.swing.JOptionPane;
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

        jrbGradeStatistic.setSelected(true);
        System.err.println(teacherItem.getMalopchunghiemGV());
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

        if (jrbGradeStatistic.isSelected() == true) {
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
        jrbGradeStatistic = new javax.swing.JRadioButton();
        jrbClassStatistic = new javax.swing.JRadioButton();
        jbtThongKe = new javax.swing.JButton();
        jpGradeStatisticChart = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(760, 540));

        jpTeacherClassStatistic.setBackground(new java.awt.Color(255, 255, 255));
        jpTeacherClassStatistic.setPreferredSize(new java.awt.Dimension(760, 540));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Năm học");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Học kỳ");

        jcbSemester.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbSemesterActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Môn học");

        buttonGroup1.add(jrbGradeStatistic);
        jrbGradeStatistic.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jrbGradeStatistic.setText("Thống kê theo khối");
        jrbGradeStatistic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbGradeStatisticActionPerformed(evt);
            }
        });

        buttonGroup1.add(jrbClassStatistic);
        jrbClassStatistic.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jrbClassStatistic.setText("Thống kê lớp chủ nhiệm ");
        jrbClassStatistic.addActionListener(new java.awt.event.ActionListener() {
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

        jpGradeStatisticChart.setBackground(new java.awt.Color(255, 255, 255));
        jpGradeStatisticChart.setPreferredSize(new java.awt.Dimension(0, 349));

        javax.swing.GroupLayout jpGradeStatisticChartLayout = new javax.swing.GroupLayout(jpGradeStatisticChart);
        jpGradeStatisticChart.setLayout(jpGradeStatisticChartLayout);
        jpGradeStatisticChartLayout.setHorizontalGroup(
            jpGradeStatisticChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jpGradeStatisticChartLayout.setVerticalGroup(
            jpGradeStatisticChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 349, Short.MAX_VALUE)
        );

        jLabel4.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel4.setText("Chọn loại thống kê");

        javax.swing.GroupLayout jpTeacherClassStatisticLayout = new javax.swing.GroupLayout(jpTeacherClassStatistic);
        jpTeacherClassStatistic.setLayout(jpTeacherClassStatisticLayout);
        jpTeacherClassStatisticLayout.setHorizontalGroup(
            jpTeacherClassStatisticLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpTeacherClassStatisticLayout.createSequentialGroup()
                .addGroup(jpTeacherClassStatisticLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jpTeacherClassStatisticLayout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(jrbGradeStatistic)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jrbClassStatistic))
                    .addGroup(jpTeacherClassStatisticLayout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addGroup(jpTeacherClassStatisticLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jpTeacherClassStatisticLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jcbYear, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jpTeacherClassStatisticLayout.createSequentialGroup()
                                .addGroup(jpTeacherClassStatisticLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addGap(120, 120, 120)
                                .addGroup(jpTeacherClassStatisticLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jcbSemester, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jcbSubject, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel4))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpGradeStatisticChart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 169, Short.MAX_VALUE)
                .addComponent(jbtThongKe)
                .addGap(76, 76, 76))
        );
        jpTeacherClassStatisticLayout.setVerticalGroup(
            jpTeacherClassStatisticLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpTeacherClassStatisticLayout.createSequentialGroup()
                .addGroup(jpTeacherClassStatisticLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpTeacherClassStatisticLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(jpTeacherClassStatisticLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpTeacherClassStatisticLayout.createSequentialGroup()
                                .addGap(49, 49, 49)
                                .addGroup(jpTeacherClassStatisticLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpTeacherClassStatisticLayout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(36, 36, 36))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpTeacherClassStatisticLayout.createSequentialGroup()
                                        .addComponent(jcbYear, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(25, 25, 25)))
                                .addGroup(jpTeacherClassStatisticLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpTeacherClassStatisticLayout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(5, 5, 5))
                                    .addComponent(jcbSemester, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(28, 28, 28)
                                .addGroup(jpTeacherClassStatisticLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(jcbSubject, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(31, 31, 31)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jpTeacherClassStatisticLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jrbGradeStatistic)
                                    .addComponent(jrbClassStatistic)))
                            .addComponent(jpGradeStatisticChart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jpTeacherClassStatisticLayout.createSequentialGroup()
                        .addGap(147, 147, 147)
                        .addComponent(jbtThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(156, 156, 156))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpTeacherClassStatistic, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpTeacherClassStatistic, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        // TODO add your handling code here:
        setSubject();
        jcbSemester.setVisible(false);
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jbtThongKeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtThongKeActionPerformed
        // TODO add your handling code here:
        if (jrbGradeStatistic.isSelected() == true) {
            try {
                String namhoc = jcbYear.getSelectedItem().toString();
                String hocki = jcbSemester.getSelectedItem().toString();
                String monhocchuaxuli = jcbSubject.getSelectedItem().toString();

                int index = monhocchuaxuli.indexOf('-');

                String mamonhoc = monhocchuaxuli.substring(0, index - 1);
                String mahocki = "HK0" + hocki;
                System.err.println(mamonhoc);
                //JOptionPane.showMessageDialog(this, "Xin chào giáo viên " + mamonhoc + "-" + mahocki);

                java.sql.Connection connection = DBConnect.getConnection();
                //JOptionPane.showMessageDialog(this, "Xin chào giáo viên " + matkGV);

                String sql = "select * FROM DIEM WHERE MAMH = ? AND MAHK = ?";
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1, mamonhoc);
                statement.setString(2, mahocki);
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

                List<LOAIDIEM> listData = new ArrayList<>();
                listData.add(new LOAIDIEM(String.valueOf(count0To5), "Điểm từ 0 - 5"));
                listData.add(new LOAIDIEM(String.valueOf(count5To7), "Điểm từ 5 - 7"));
                listData.add(new LOAIDIEM(String.valueOf(count7To9), "Điểm từ 7 - 9"));
                listData.add(new LOAIDIEM(String.valueOf(count9To10), "Điểm từ 9 - 10"));

                ShowChart sc = new ShowChart(monhocchuaxuli, listData);
                sc.show();

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
            try {
                String namhoc = jcbYear.getSelectedItem().toString();
                String hocki = jcbYear.getSelectedItem().toString();
                String monhocchuaxuli = jcbSubject.getSelectedItem().toString();

                int index = monhocchuaxuli.indexOf('-');

                String mamonhoc = monhocchuaxuli.substring(0, index);
                System.err.println("MA MON HOC" + mamonhoc);

                java.sql.Connection connection = DBConnect.getConnection();

                List<String> dsLop = new ArrayList<>();

                String sql = "SELECT * FROM LOP";
                PreparedStatement statement = connection.prepareStatement(sql);
                ResultSet resultSet = statement.executeQuery();

                while (resultSet.next()) {
                    dsLop.add(resultSet.getString("MALOP"));
                }

                List<LOAIDIEM> listData = new ArrayList<>();
                sql = "SELECT * FROM HOCSINH, DIEM, LOP WHERE DIEM.MAHS = HOCSINH.MAHS AND LOP.MALOP = HOCSINH.MALOP AND LOP.MALOP = ? and DIEM.MAMH = ?";
                statement = connection.prepareCall(sql);
                System.err.println(mamonhoc.trim() + teacherItem.getMalopchunghiemGV().charAt(1));
                statement.setString(1, teacherItem.getMalopchunghiemGV());
                statement.setString(2, mamonhoc.trim() + teacherItem.getMalopchunghiemGV().charAt(1));
                resultSet = statement.executeQuery();

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
                bcGradeStatisticChart = new BarChart("Thông Kê Môn " + teacherItem.getMalopchunghiemGV() + " " +monhocchuaxuli);
                bcGradeStatisticChart.addData(count0To5, "Điểm từ 0 - 5");
                bcGradeStatisticChart.addData(count5To7, "Điểm từ 5 - 7");
                bcGradeStatisticChart.addData(count7To9, "Điểm từ 7 - 9");
                bcGradeStatisticChart.addData(count9To10, "Điểm từ 9 - 10");
                jpGradeStatisticChart.add(bcGradeStatisticChart, BorderLayout.CENTER);

                listData.add(new LOAIDIEM(String.valueOf(count0To5), "Điểm từ 0 - 5"));
                listData.add(new LOAIDIEM(String.valueOf(count5To7), "Điểm từ 5 - 7"));
                listData.add(new LOAIDIEM(String.valueOf(count7To9), "Điểm từ 7 - 9"));
                listData.add(new LOAIDIEM(String.valueOf(count9To10), "Điểm từ 9 - 10"));

                ShowChart sc = new ShowChart(monhocchuaxuli, listData);
                sc.show();

                if (!statement.isClosed()) {
                    statement.close();
                    System.out.println("Close SEARCH MAHK");
                }

            } catch (SQLException ex) {
                Logger.getLogger(TeacherClassStatistic.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jbtThongKeActionPerformed

    private void jcbSemesterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbSemesterActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbSemesterActionPerformed

    private void jbChangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbChangeActionPerformed
        jpGradeStatisticChart.remove(bcGradeStatisticChart);
        jpGradeStatisticChart.revalidate();
        jpGradeStatisticChart.repaint();
        bcGradeStatisticChart = new BarChart("Thống kê môn Lý");
        bcGradeStatisticChart.addData(2, "1");
        bcGradeStatisticChart.addData(4, "2");
        bcGradeStatisticChart.addData(8, "3");
        bcGradeStatisticChart.addData(5, "4");
        jpGradeStatisticChart.add(bcGradeStatisticChart, BorderLayout.CENTER);
    }//GEN-LAST:event_jbChangeActionPerformed

    private void jrbGradeStatisticActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbGradeStatisticActionPerformed
        // TODO add your handling code here:
        setSubject();
        jcbSemester.setVisible(true);
    }//GEN-LAST:event_jrbGradeStatisticActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JButton jbtThongKe;
    private javax.swing.JComboBox<String> jcbSemester;
    private javax.swing.JComboBox<String> jcbSubject;
    private javax.swing.JComboBox<String> jcbYear;
    private javax.swing.JPanel jpGradeStatisticChart;
    private javax.swing.JPanel jpTeacherClassStatistic;
    private javax.swing.JRadioButton jrbClassStatistic;
    private javax.swing.JRadioButton jrbGradeStatistic;
    // End of variables declaration//GEN-END:variables
}
