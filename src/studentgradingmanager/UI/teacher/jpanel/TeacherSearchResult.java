/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package studentgradingmanager.UI.teacher.jpanel;

/**
 *
 * @author Quan
 */
public class TeacherSearchResult extends javax.swing.JPanel {

    /**
     * Creates new form TeacherSearchResult
     */
    public TeacherSearchResult() {
        initComponents();
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
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Năm học");

        jcbYear.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Điểm TB năm học");

        jcbSemester.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jbSearch.setText("Tìm kiếm");

        jtStudentResult.setBackground(new java.awt.Color(255, 255, 255));
        jtStudentResult.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black));
        jtStudentResult.setForeground(new java.awt.Color(0, 0, 0));
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
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Tên học sinh:");

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
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
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Học kỳ");

        jlbStudentName.setBackground(new java.awt.Color(255, 255, 255));
        jlbStudentName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jlbStudentName.setForeground(new java.awt.Color(0, 0, 0));
        jlbStudentName.setText("Nguyễn Văn A");

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Mã học sinh:");

        jlbStudentId.setBackground(new java.awt.Color(255, 255, 255));
        jlbStudentId.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jlbStudentId.setForeground(new java.awt.Color(0, 0, 0));
        jlbStudentId.setText("12345678");

        jbBack.setBackground(new java.awt.Color(153, 204, 255));
        jbBack.setForeground(new java.awt.Color(255, 255, 255));
        jbBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/studentgradingmanager/images/icon-back-48.png"))); // NOI18N
        jbBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbBackMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jpTeacherSearchResultLayout = new javax.swing.GroupLayout(jpTeacherSearchResult);
        jpTeacherSearchResult.setLayout(jpTeacherSearchResultLayout);
        jpTeacherSearchResultLayout.setHorizontalGroup(
            jpTeacherSearchResultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpTeacherSearchResultLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jpTeacherSearchResultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpTeacherSearchResultLayout.createSequentialGroup()
                        .addGroup(jpTeacherSearchResultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(jpTeacherSearchResultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlbSemesterResult, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlbYearResult, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jpTeacherSearchResultLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlbStudentName)
                        .addGap(147, 147, 147)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlbStudentId)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpTeacherSearchResultLayout.createSequentialGroup()
                .addContainerGap(45, Short.MAX_VALUE)
                .addGroup(jpTeacherSearchResultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbBack, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpTeacherSearchResultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jpTeacherSearchResultLayout.createSequentialGroup()
                            .addComponent(jspStudentResultTable, javax.swing.GroupLayout.PREFERRED_SIZE, 703, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addContainerGap())
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpTeacherSearchResultLayout.createSequentialGroup()
                            .addGroup(jpTeacherSearchResultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jcbSemester, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel6))
                            .addGap(42, 42, 42)
                            .addGroup(jpTeacherSearchResultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(jcbYear, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jbSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(154, 154, 154)))))
        );
        jpTeacherSearchResultLayout.setVerticalGroup(
            jpTeacherSearchResultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpTeacherSearchResultLayout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
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
                            .addComponent(jLabel6)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpTeacherSearchResultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jcbSemester, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcbYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpTeacherSearchResultLayout.createSequentialGroup()
                        .addComponent(jbSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(jspStudentResultTable, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
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
