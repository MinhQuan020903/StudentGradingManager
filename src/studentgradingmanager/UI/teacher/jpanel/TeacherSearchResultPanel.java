/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package studentgradingmanager.UI.teacher.jpanel;

import Database.DBConnect;
import OOP.StudentBase;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author Quan
 */
public class TeacherSearchResultPanel extends javax.swing.JPanel {

    private StudentBase studentBase;
    private List

    /**
     * Creates new form TeacherSearchResult
     */
    public TeacherSearchResultPanel() {
        initComponents();
    }

    public TeacherSearchResultPanel(StudentBase studentBase) {
        initComponents();
        this.studentBase = studentBase;

        mirrorData();
    }

    private void mirrorData() {
        try {
            StudentBase item = studentBase;
            
            jlbStudentName.setText(item.getHOTEN());
            jlbStudentId.setText(item.getMAHS());
            
            java.sql.Connection connection = DBConnect.getConnection();
         

            String sql = "SELECT * FROM DIEM WHERE MAHS = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, item.getMAHS());
            
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(TeacherSearchResultPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public JLabel getjLabel2() {
        return jLabel2;
    }

    public void setjLabel2(JLabel jLabel2) {
        this.jLabel2 = jLabel2;
    }

    public JLabel getjLabel3() {
        return jLabel3;
    }

    public void setjLabel3(JLabel jLabel3) {
        this.jLabel3 = jLabel3;
    }

    public JLabel getjLabel4() {
        return jLabel4;
    }

    public void setjLabel4(JLabel jLabel4) {
        this.jLabel4 = jLabel4;
    }

    public JLabel getjLabel5() {
        return jLabel5;
    }

    public void setjLabel5(JLabel jLabel5) {
        this.jLabel5 = jLabel5;
    }

    public JLabel getjLabel6() {
        return jLabel6;
    }

    public void setjLabel6(JLabel jLabel6) {
        this.jLabel6 = jLabel6;
    }

    public JLabel getjLabel7() {
        return jLabel7;
    }

    public void setjLabel7(JLabel jLabel7) {
        this.jLabel7 = jLabel7;
    }

    public JButton getJbBack() {
        return jbBack;
    }

    public void setJbBack(JButton jbBack) {
        this.jbBack = jbBack;
        
    }

    public JButton getJbSearch() {
        return jbSearch;
    }

    public void setJbSearch(JButton jbSearch) {
        this.jbSearch = jbSearch;
    }

    public JComboBox<String> getJcbSemester() {
        return jcbSemester;
    }

    public void setJcbSemester(JComboBox<String> jcbSemester) {
        this.jcbSemester = jcbSemester;
    }

    public JComboBox<String> getJcbYear() {
        return jcbYear;
    }

    public void setJcbYear(JComboBox<String> jcbYear) {
        this.jcbYear = jcbYear;
    }

    public JLabel getJlbSemesterResult() {
        return jlbSemesterResult;
    }

    public void setJlbSemesterResult(JLabel jlbSemesterResult) {
        this.jlbSemesterResult = jlbSemesterResult;
    }

    public JLabel getJlbStudentId() {
        return jlbStudentId;
    }

    public void setJlbStudentId(JLabel jlbStudentId) {
        this.jlbStudentId = jlbStudentId;
    }

    public JLabel getJlbStudentName() {
        return jlbStudentName;
    }

    public void setJlbStudentName(JLabel jlbStudentName) {
        this.jlbStudentName = jlbStudentName;
    }

    public JLabel getJlbYearResult() {
        return jlbYearResult;
    }

    public void setJlbYearResult(JLabel jlbYearResult) {
        this.jlbYearResult = jlbYearResult;
    }

    public JPanel getJpTeacherSearchResult() {
        return jpTeacherSearchResult;
    }

    public void setJpTeacherSearchResult(JPanel jpTeacherSearchResult) {
        this.jpTeacherSearchResult = jpTeacherSearchResult;
    }

    public JScrollPane getJspStudentResultTable() {
        return jspStudentResultTable;
    }

    public void setJspStudentResultTable(JScrollPane jspStudentResultTable) {
        this.jspStudentResultTable = jspStudentResultTable;
    }

    public JTable getJtStudentResult() {
        return jtStudentResult;
    }

    public void setJtStudentResult(JTable jtStudentResult) {
        this.jtStudentResult = jtStudentResult;
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
        jbSearch = new javax.swing.JButton();
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
        jbBack = new javax.swing.JButton();

        jpTeacherSearchResult.setBackground(new java.awt.Color(255, 255, 255));
        jpTeacherSearchResult.setForeground(new java.awt.Color(255, 255, 255));
        jpTeacherSearchResult.setPreferredSize(new java.awt.Dimension(782, 549));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Năm học");

        jcbYear.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Điểm TB năm học");

        jcbSemester.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jbSearch.setText("Tìm kiếm");

        jtStudentResult.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black));
        jtStudentResult.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
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

        jbBack.setBackground(new java.awt.Color(153, 204, 255));
        jbBack.setForeground(new java.awt.Color(255, 255, 255));
        jbBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/studentgradingmanager/images/icon-back-48.png"))); // NOI18N
        jbBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbBackMouseClicked(evt);
            }
        });
        jbBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpTeacherSearchResultLayout = new javax.swing.GroupLayout(jpTeacherSearchResult);
        jpTeacherSearchResult.setLayout(jpTeacherSearchResultLayout);
        jpTeacherSearchResultLayout.setHorizontalGroup(
            jpTeacherSearchResultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpTeacherSearchResultLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jpTeacherSearchResultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpTeacherSearchResultLayout.createSequentialGroup()
                        .addGroup(jpTeacherSearchResultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jbBack, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpTeacherSearchResultLayout.createSequentialGroup()
                                .addGroup(jpTeacherSearchResultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jpTeacherSearchResultLayout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jlbStudentName)
                                        .addGap(119, 119, 119)
                                        .addComponent(jLabel7))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpTeacherSearchResultLayout.createSequentialGroup()
                                        .addGroup(jpTeacherSearchResultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jcbSemester, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel6))
                                        .addGap(64, 64, 64)
                                        .addGroup(jpTeacherSearchResultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2)
                                            .addComponent(jcbYear, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGroup(jpTeacherSearchResultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jpTeacherSearchResultLayout.createSequentialGroup()
                                        .addGap(61, 61, 61)
                                        .addComponent(jbSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jpTeacherSearchResultLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jlbStudentId)))))
                        .addGap(0, 153, Short.MAX_VALUE))
                    .addGroup(jpTeacherSearchResultLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jspStudentResultTable, javax.swing.GroupLayout.PREFERRED_SIZE, 703, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addGroup(jpTeacherSearchResultLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jpTeacherSearchResultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jpTeacherSearchResultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlbSemesterResult, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlbYearResult, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 418, Short.MAX_VALUE))
        );
        jpTeacherSearchResultLayout.setVerticalGroup(
            jpTeacherSearchResultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpTeacherSearchResultLayout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(jbBack, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpTeacherSearchResultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbStudentName)
                    .addComponent(jLabel4)
                    .addComponent(jLabel7)
                    .addComponent(jlbStudentId))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpTeacherSearchResultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpTeacherSearchResultLayout.createSequentialGroup()
                        .addGroup(jpTeacherSearchResultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpTeacherSearchResultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jcbYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcbSemester))
                        .addGap(22, 22, 22))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpTeacherSearchResultLayout.createSequentialGroup()
                        .addComponent(jbSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)))
                .addComponent(jspStudentResultTable, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addGroup(jpTeacherSearchResultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jlbSemesterResult, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpTeacherSearchResultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jlbYearResult, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpTeacherSearchResult, javax.swing.GroupLayout.DEFAULT_SIZE, 754, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpTeacherSearchResult, javax.swing.GroupLayout.DEFAULT_SIZE, 542, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jbBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbBackMouseClicked


    }//GEN-LAST:event_jbBackMouseClicked

    private void jbBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBackActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbBackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JButton jbBack;
    private javax.swing.JButton jbSearch;
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
