/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package studentgradingmanager.UI.teacher.jpanel;

import Database.DBConnect;
import OOP.DIEM;
import OOP.StudentBase;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Quan
 */
public class TeacherSearchResultFrame extends javax.swing.JFrame {

    private StudentBase studentBase;
    private List<String> listMAHK;
    private List<String> listNAMHOC;
    private List<DIEM> listDIEM = new ArrayList<>();
    private DefaultTableModel model;
    private Boolean ChoPhepChinhSua = false;

    /**
     * Creates new form TeacherSearchResultFrame
     */
    public TeacherSearchResultFrame(StudentBase studentBase) {
        initComponents();
        this.studentBase = studentBase;
        model = (DefaultTableModel) jtStudentResult.getModel();
        mirrorData();
        findSemester();
        //importData();

        if (ChoPhepChinhSua == false) {
            jbEdit.setBackground(Color.red);
        }

    }

    private void importData() {
        try {
            java.sql.Connection connection = DBConnect.getConnection();
            //JOptionPane.showMessageDialog(this, "Xin chào giáo viên " + matkGV);
            listDIEM.clear();
            String sql = "SELECT * FROM DIEM WHERE MAHS = ? AND MAHK = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, studentBase.getMAHS());
            if (jcbSemester.getSelectedItem().equals("1")) {
                statement.setString(2, "HK01");
            } else {
                statement.setString(2, "HK02");
            }
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                listDIEM.add(new DIEM(
                        resultSet.getString("MAMH"),
                        resultSet.getString("MAHS"),
                        resultSet.getString("DIEMQT"),
                        resultSet.getString("DIEMGK"),
                        resultSet.getString("DIEMCK"),
                        resultSet.getString("DIEMTBHK"),
                        resultSet.getString("GHICHU"),
                        resultSet.getString("MAHK"),
                        null));

            }

            for (int i = 0; i < listDIEM.size(); i++) {
                System.out.println(listDIEM.get(i).getMAMH());
            }

            for (int i = 0; i < listDIEM.size(); i++) {
                sql = "SELECT * FROM MONHOC WHERE MAMH = ?";
                statement = connection.prepareStatement(sql);
                statement.setString(1, listDIEM.get(i).getMAMH());
                resultSet = statement.executeQuery();

                if (resultSet.next()) {
                    listDIEM.get(i).setTenMonHoc(resultSet.getString("TENMH"));
                }

            }

            if (!statement.isClosed()) {
                statement.close();
                System.out.println("Close SEARCH MAHK");
            }

            model.setRowCount(0);
            for (int i = 0; i < listDIEM.size(); i++) {
                String[] stu = {String.valueOf(i),
                    listDIEM.get(i).getTenMonHoc(),
                    listDIEM.get(i).getDIEMQT(),
                    listDIEM.get(i).getDIEMGK(),
                    listDIEM.get(i).getDIEMCK(),
                    listDIEM.get(i).getDEIMTBHK(),
                    listDIEM.get(i).getGHICHU()};
                model.addRow(stu);
            }

            jtStudentResult.revalidate();
            jtStudentResult.repaint();
        } catch (SQLException ex) {
            Logger.getLogger(TeacherSearchResultFrame.class.getName()).log(Level.SEVERE, null, ex);
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
                System.out.println("Close SEARCH NAMHOC");
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

    private void mirrorData() {
        StudentBase student = studentBase;
        jlbStudentName.setText(student.getHOTEN());
        jlbStudentId.setText(student.getMAHS());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpTeacherSearchResult = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jcbYear = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jcbSemester = new javax.swing.JComboBox<>();
        jbEdit = new javax.swing.JButton();
        jspStudentResultTable = new javax.swing.JScrollPane();
        jtStudentResult = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jlbYearResult = new javax.swing.JLabel();
        jlbSemesterResult = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jlbStudentName = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jlbStudentId = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jbBack = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jbAddSubject = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jpTeacherSearchResult.setBackground(new java.awt.Color(255, 255, 255));
        jpTeacherSearchResult.setForeground(new java.awt.Color(255, 255, 255));
        jpTeacherSearchResult.setPreferredSize(new java.awt.Dimension(960, 540));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Năm học");

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Điểm TB năm học");

        jcbSemester.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbSemesterItemStateChanged(evt);
            }
        });

        jbEdit.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jbEdit.setText("CHỈNH SỬA");
        jbEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEditActionPerformed(evt);
            }
        });

        jtStudentResult.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black));
        jtStudentResult.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Tên môn học", "Điểm QT", "Điểm GK", "Điểm CK", "Điểm TBHK", "Ghi chú"
            }
        ));
        jtStudentResult.setGridColor(new java.awt.Color(0, 0, 0));
        jtStudentResult.setShowGrid(true);
        jtStudentResult.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtStudentResultMouseClicked(evt);
            }
        });
        jspStudentResultTable.setViewportView(jtStudentResult);

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Tên học sinh:");

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Điểm TB học kỳ");

        jlbYearResult.setBackground(new java.awt.Color(255, 255, 255));
        jlbYearResult.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jlbYearResult.setForeground(new java.awt.Color(255, 0, 51));
        jlbYearResult.setText("1.0");

        jlbSemesterResult.setBackground(new java.awt.Color(255, 255, 255));
        jlbSemesterResult.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jlbSemesterResult.setForeground(new java.awt.Color(255, 0, 51));
        jlbSemesterResult.setText("10.0");

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Học kỳ");

        jlbStudentName.setBackground(new java.awt.Color(255, 255, 255));
        jlbStudentName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jlbStudentName.setText("Nguyễn Văn A");

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Mã học sinh:");

        jlbStudentId.setBackground(new java.awt.Color(255, 255, 255));
        jlbStudentId.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jlbStudentId.setText("12345678");

        jPanel1.setBackground(new java.awt.Color(102, 255, 255));
        jPanel1.setForeground(new java.awt.Color(51, 255, 255));

        jbBack.setBackground(new java.awt.Color(255, 51, 51));
        jbBack.setForeground(new java.awt.Color(255, 255, 255));
        jbBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/studentgradingmanager/images/icon-exit-48.png"))); // NOI18N
        jbBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBackActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("THÔNG TIN HỌC SINH");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(334, 334, 334)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 262, Short.MAX_VALUE)
                .addComponent(jbBack, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jbBack, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jbAddSubject.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jbAddSubject.setText("Thêm Môn Học");
        jbAddSubject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAddSubjectActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpTeacherSearchResultLayout = new javax.swing.GroupLayout(jpTeacherSearchResult);
        jpTeacherSearchResult.setLayout(jpTeacherSearchResultLayout);
        jpTeacherSearchResultLayout.setHorizontalGroup(
            jpTeacherSearchResultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jpTeacherSearchResultLayout.createSequentialGroup()
                .addGap(129, 129, 129)
                .addGroup(jpTeacherSearchResultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jpTeacherSearchResultLayout.createSequentialGroup()
                        .addGroup(jpTeacherSearchResultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpTeacherSearchResultLayout.createSequentialGroup()
                                .addGroup(jpTeacherSearchResultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jcbSemester, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6))
                                .addGap(73, 73, 73)
                                .addGroup(jpTeacherSearchResultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jcbYear, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jpTeacherSearchResultLayout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jlbStudentName))
                            .addGroup(jpTeacherSearchResultLayout.createSequentialGroup()
                                .addGap(237, 237, 237)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jlbStudentId)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpTeacherSearchResultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jbAddSubject, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jpTeacherSearchResultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jspStudentResultTable, javax.swing.GroupLayout.PREFERRED_SIZE, 703, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jpTeacherSearchResultLayout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(25, 25, 25)
                                .addComponent(jlbSemesterResult, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(jlbYearResult, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(128, Short.MAX_VALUE))
        );
        jpTeacherSearchResultLayout.setVerticalGroup(
            jpTeacherSearchResultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpTeacherSearchResultLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jpTeacherSearchResultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpTeacherSearchResultLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(jpTeacherSearchResultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jlbStudentName)
                            .addComponent(jLabel7)
                            .addComponent(jlbStudentId))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2))
                    .addGroup(jpTeacherSearchResultLayout.createSequentialGroup()
                        .addGroup(jpTeacherSearchResultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpTeacherSearchResultLayout.createSequentialGroup()
                                .addGap(82, 82, 82)
                                .addComponent(jLabel6)
                                .addGap(4, 4, 4))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpTeacherSearchResultLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)))
                        .addGroup(jpTeacherSearchResultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jcbSemester, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcbYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbAddSubject, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(20, 20, 20)
                .addComponent(jspStudentResultTable, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jpTeacherSearchResultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jlbSemesterResult, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jlbYearResult, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(64, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpTeacherSearchResult, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpTeacherSearchResult, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBackActionPerformed
        dispose();
    }//GEN-LAST:event_jbBackActionPerformed

    private void jcbSemesterItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbSemesterItemStateChanged
        // TODO add your handling code here:
        importData();
    }//GEN-LAST:event_jcbSemesterItemStateChanged

    private void jbEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEditActionPerformed
        // TODO add your handling code here:
        if(ChoPhepChinhSua == true) {
            ChoPhepChinhSua = false;
            jbEdit.setBackground(Color.red);
        } else {
            ChoPhepChinhSua = true;
            jbEdit.setBackground(Color.green);
        }
        
    }//GEN-LAST:event_jbEditActionPerformed

    private void jbAddSubjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAddSubjectActionPerformed
        // TODO add your handling code here:
        TeacherSearchNewSubjectFrame frame = new TeacherSearchNewSubjectFrame();
        frame.show();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.requestFocusInWindow();
    }//GEN-LAST:event_jbAddSubjectActionPerformed

    private void jtStudentResultMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtStudentResultMouseClicked
        // TODO add your handling code here:
        int selectedRow = jtStudentResult.rowAtPoint(evt.getPoint());
        int selectedColumn = jtStudentResult.columnAtPoint(evt.getPoint());
        if (!ChoPhepChinhSua) {
            boolean a = jtStudentResult.isEditing();
            if (a == false) {
                JOptionPane.showMessageDialog(null, "Restricted Editting");
            }
        }
    }//GEN-LAST:event_jtStudentResultMouseClicked

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbAddSubject;
    private javax.swing.JButton jbBack;
    private javax.swing.JButton jbEdit;
    private javax.swing.JComboBox<String> jcbSemester;
    private javax.swing.JComboBox<String> jcbYear;
    private javax.swing.JLabel jlbSemesterResult;
    private javax.swing.JLabel jlbStudentId;
    private javax.swing.JLabel jlbStudentName;
    private javax.swing.JLabel jlbYearResult;
    private javax.swing.JPanel jpTeacherSearchResult;
    private javax.swing.JScrollPane jspStudentResultTable;
    private javax.swing.JTable jtStudentResult;
    // End of variables declaration//GEN-END:variables

}
