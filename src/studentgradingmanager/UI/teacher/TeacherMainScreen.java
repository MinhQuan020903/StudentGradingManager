/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package studentgradingmanager.UI.teacher;

import Database.DBConnect;
import TransferData.MessageListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import studentgradingmanager.UI.dialog.SignOut;
import studentgradingmanager.UI.student.StudentMainScreen;
import studentgradingmanager.bean.Category;
import studentgradingmanager.controller.TeacherNavController;
import javax.swing.JOptionPane;
import studentgradingmanager.UI.student.StudentMainScreen;
import studentgradingmanager.UI.teacher.TeacherMainScreen;

import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Quan
 */
public class TeacherMainScreen extends javax.swing.JFrame implements MessageListener{

    private String emailGV;
    private String matkhauGV;
    private String matkGV;
    private String maGV;
    private String hotenGV;
    private String sdtGV;
    private String ngsinhGV;
    private String gioitinhGV;

    /**
     * Creates new form TeacherMainScreen
     */
    public TeacherMainScreen() {
    }

    public TeacherMainScreen(String email, String matkhauGV, String matkGV) throws SQLException {
        initComponents();
        setTitle("QUẢN LÝ ĐIỂM HỌC SINH");
        this.matkhauGV = matkhauGV;
        this.emailGV = email;
        this.matkGV = matkGV;
        //JOptionPane.showMessageDialog(this, "Xin chào giáo viên " + matkhauGV);
        findInformationTeacher();
        
        TeacherNavController controller = new TeacherNavController(jpMainScreenContent, emailGV, matkhauGV, matkGV);
        controller.setView(jpTeacherAccountInfoSelector, jlbTeacherAccountInfoSelector);

        ArrayList<Category> listCategory = new ArrayList<>();
        listCategory.add(new Category("Thông tin tài khoản", jpTeacherAccountInfoSelector, jlbTeacherAccountInfoSelector));
        listCategory.add(new Category("Tra cứu kết quả học sinh", jpTeacherSearchSelector, jlbTeacherSearchSelector));
        listCategory.add(new Category("Thống kê điểm học sinh", jpTeacherClassStatisticSelector, jlbTeacherClassStatisticSelector));
        controller.setEvent(listCategory);
        
        
        //jpTeacherGradingManagementSelector.setVisible(false);

    }

    private void findInformationTeacher() throws SQLException {
        java.sql.Connection connection = DBConnect.getConnection();
        //JOptionPane.showMessageDialog(this, "Xin chào giáo viên " + matkGV);

        String sql = "SELECT * FROM GIAOVIEN WHERE MATK = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, matkGV);

        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            // Lấy thông tin của giáo viên có MATK = matkGV
            this.hotenGV = resultSet.getString("HOTEN");
            this.maGV = resultSet.getString("MAGV");
            this.sdtGV = resultSet.getString("SDT");
            this.ngsinhGV = resultSet.getString("NGSINH");
            this.gioitinhGV = resultSet.getString("GIOITINH");

            jlbTeacherName.setText(hotenGV);
            jlbTeacherId.setText(maGV);

            JOptionPane.showMessageDialog(this, "Xin chào giáo viên " + hotenGV);
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

        jpMainScreen = new javax.swing.JPanel();
        jpMainScreenSelector = new javax.swing.JPanel();
        jpUserAvatar = new javax.swing.JPanel();
        jlbUserAvatar = new javax.swing.JLabel();
        jpTeacherAccountInfoSelector = new javax.swing.JPanel();
        jlbTeacherAccountInfoSelector = new javax.swing.JLabel();
        jlbTeacherName = new javax.swing.JLabel();
        jlbTeacherId = new javax.swing.JLabel();
        jpTeacherSearchSelector = new javax.swing.JPanel();
        jlbTeacherSearchSelector = new javax.swing.JLabel();
        jpTeacherSignOutSelector = new javax.swing.JPanel();
        jlbTeacherSignOutSelector = new javax.swing.JLabel();
        jpTeacherClassStatisticSelector = new javax.swing.JPanel();
        jlbTeacherClassStatisticSelector = new javax.swing.JLabel();
        jpMainScreenContent = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jpMainScreen.setBackground(new java.awt.Color(255, 255, 255));
        jpMainScreen.setForeground(new java.awt.Color(255, 255, 255));
        jpMainScreen.setPreferredSize(new java.awt.Dimension(960, 540));

        jpMainScreenSelector.setBackground(new java.awt.Color(111, 142, 222));
        jpMainScreenSelector.setForeground(new java.awt.Color(255, 255, 255));

        jpUserAvatar.setBackground(new java.awt.Color(255, 255, 255));

        jlbUserAvatar.setBackground(new java.awt.Color(255, 255, 255));
        jlbUserAvatar.setForeground(new java.awt.Color(255, 255, 255));
        jlbUserAvatar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/studentgradingmanager/images/icon-person-male.png"))); // NOI18N
        jlbUserAvatar.setText("jLabel1");
        jlbUserAvatar.setMaximumSize(new java.awt.Dimension(80, 80));
        jlbUserAvatar.setMinimumSize(new java.awt.Dimension(80, 80));

        javax.swing.GroupLayout jpUserAvatarLayout = new javax.swing.GroupLayout(jpUserAvatar);
        jpUserAvatar.setLayout(jpUserAvatarLayout);
        jpUserAvatarLayout.setHorizontalGroup(
            jpUserAvatarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpUserAvatarLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jlbUserAvatar, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jpUserAvatarLayout.setVerticalGroup(
            jpUserAvatarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpUserAvatarLayout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(jlbUserAvatar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jpTeacherAccountInfoSelector.setBackground(new java.awt.Color(111, 142, 222));
        jpTeacherAccountInfoSelector.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jlbTeacherAccountInfoSelector.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jlbTeacherAccountInfoSelector.setForeground(new java.awt.Color(255, 255, 255));
        jlbTeacherAccountInfoSelector.setIcon(new javax.swing.ImageIcon(getClass().getResource("/studentgradingmanager/images/icon-user-16.png"))); // NOI18N
        jlbTeacherAccountInfoSelector.setText("Thông tin tài khoản");
        jlbTeacherAccountInfoSelector.setPreferredSize(new java.awt.Dimension(90, 48));

        javax.swing.GroupLayout jpTeacherAccountInfoSelectorLayout = new javax.swing.GroupLayout(jpTeacherAccountInfoSelector);
        jpTeacherAccountInfoSelector.setLayout(jpTeacherAccountInfoSelectorLayout);
        jpTeacherAccountInfoSelectorLayout.setHorizontalGroup(
            jpTeacherAccountInfoSelectorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpTeacherAccountInfoSelectorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbTeacherAccountInfoSelector, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
        );
        jpTeacherAccountInfoSelectorLayout.setVerticalGroup(
            jpTeacherAccountInfoSelectorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpTeacherAccountInfoSelectorLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jlbTeacherAccountInfoSelector, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jlbTeacherName.setBackground(new java.awt.Color(255, 255, 255));
        jlbTeacherName.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jlbTeacherName.setForeground(new java.awt.Color(255, 255, 255));
        jlbTeacherName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbTeacherName.setText("TÊN GIÁO VIÊN");

        jlbTeacherId.setBackground(new java.awt.Color(255, 255, 255));
        jlbTeacherId.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jlbTeacherId.setForeground(new java.awt.Color(255, 255, 255));
        jlbTeacherId.setText("ID01");

        jpTeacherSearchSelector.setBackground(new java.awt.Color(111, 142, 222));
        jpTeacherSearchSelector.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jpTeacherSearchSelector.setPreferredSize(new java.awt.Dimension(200, 54));

        jlbTeacherSearchSelector.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jlbTeacherSearchSelector.setForeground(new java.awt.Color(255, 255, 255));
        jlbTeacherSearchSelector.setIcon(new javax.swing.ImageIcon(getClass().getResource("/studentgradingmanager/images/icon-search-16.png"))); // NOI18N
        jlbTeacherSearchSelector.setText("Tra cứu kết quả học sinh");
        jlbTeacherSearchSelector.setPreferredSize(new java.awt.Dimension(90, 48));

        javax.swing.GroupLayout jpTeacherSearchSelectorLayout = new javax.swing.GroupLayout(jpTeacherSearchSelector);
        jpTeacherSearchSelector.setLayout(jpTeacherSearchSelectorLayout);
        jpTeacherSearchSelectorLayout.setHorizontalGroup(
            jpTeacherSearchSelectorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpTeacherSearchSelectorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbTeacherSearchSelector, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(16, 16, 16))
        );
        jpTeacherSearchSelectorLayout.setVerticalGroup(
            jpTeacherSearchSelectorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpTeacherSearchSelectorLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jlbTeacherSearchSelector, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jpTeacherSignOutSelector.setBackground(new java.awt.Color(111, 142, 222));
        jpTeacherSignOutSelector.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jpTeacherSignOutSelector.setPreferredSize(new java.awt.Dimension(200, 54));
        jpTeacherSignOutSelector.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpTeacherSignOutSelectorMouseClicked(evt);
            }
        });

        jlbTeacherSignOutSelector.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jlbTeacherSignOutSelector.setForeground(new java.awt.Color(255, 51, 51));
        jlbTeacherSignOutSelector.setIcon(new javax.swing.ImageIcon(getClass().getResource("/studentgradingmanager/images/icon-logout-16.png"))); // NOI18N
        jlbTeacherSignOutSelector.setText(" Đăng xuất");
        jlbTeacherSignOutSelector.setPreferredSize(new java.awt.Dimension(90, 48));

        javax.swing.GroupLayout jpTeacherSignOutSelectorLayout = new javax.swing.GroupLayout(jpTeacherSignOutSelector);
        jpTeacherSignOutSelector.setLayout(jpTeacherSignOutSelectorLayout);
        jpTeacherSignOutSelectorLayout.setHorizontalGroup(
            jpTeacherSignOutSelectorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpTeacherSignOutSelectorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbTeacherSignOutSelector, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpTeacherSignOutSelectorLayout.setVerticalGroup(
            jpTeacherSignOutSelectorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpTeacherSignOutSelectorLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jlbTeacherSignOutSelector, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jpTeacherClassStatisticSelector.setBackground(new java.awt.Color(111, 142, 222));
        jpTeacherClassStatisticSelector.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jpTeacherClassStatisticSelector.setPreferredSize(new java.awt.Dimension(200, 54));

        jlbTeacherClassStatisticSelector.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jlbTeacherClassStatisticSelector.setForeground(new java.awt.Color(255, 255, 255));
        jlbTeacherClassStatisticSelector.setIcon(new javax.swing.ImageIcon(getClass().getResource("/studentgradingmanager/images/icon-report-card-16.png"))); // NOI18N
        jlbTeacherClassStatisticSelector.setText("Thống kê điểm học sinh");
        jlbTeacherClassStatisticSelector.setPreferredSize(new java.awt.Dimension(90, 48));

        javax.swing.GroupLayout jpTeacherClassStatisticSelectorLayout = new javax.swing.GroupLayout(jpTeacherClassStatisticSelector);
        jpTeacherClassStatisticSelector.setLayout(jpTeacherClassStatisticSelectorLayout);
        jpTeacherClassStatisticSelectorLayout.setHorizontalGroup(
            jpTeacherClassStatisticSelectorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpTeacherClassStatisticSelectorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbTeacherClassStatisticSelector, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(30, 30, 30))
        );
        jpTeacherClassStatisticSelectorLayout.setVerticalGroup(
            jpTeacherClassStatisticSelectorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpTeacherClassStatisticSelectorLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jlbTeacherClassStatisticSelector, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jpMainScreenSelectorLayout = new javax.swing.GroupLayout(jpMainScreenSelector);
        jpMainScreenSelector.setLayout(jpMainScreenSelectorLayout);
        jpMainScreenSelectorLayout.setHorizontalGroup(
            jpMainScreenSelectorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpTeacherClassStatisticSelector, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
            .addComponent(jpTeacherSearchSelector, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
            .addComponent(jpTeacherAccountInfoSelector, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jpTeacherSignOutSelector, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
            .addGroup(jpMainScreenSelectorLayout.createSequentialGroup()
                .addGroup(jpMainScreenSelectorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpMainScreenSelectorLayout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(jlbTeacherId))
                    .addGroup(jpMainScreenSelectorLayout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jpUserAvatar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpMainScreenSelectorLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jlbTeacherName, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpMainScreenSelectorLayout.setVerticalGroup(
            jpMainScreenSelectorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpMainScreenSelectorLayout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(jpUserAvatar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlbTeacherName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlbTeacherId)
                .addGap(36, 36, 36)
                .addComponent(jpTeacherAccountInfoSelector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpTeacherSearchSelector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpTeacherClassStatisticSelector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpTeacherSignOutSelector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(54, Short.MAX_VALUE))
        );

        jpMainScreenContent.setBackground(new java.awt.Color(255, 255, 255));
        jpMainScreenContent.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jpMainScreenContentLayout = new javax.swing.GroupLayout(jpMainScreenContent);
        jpMainScreenContent.setLayout(jpMainScreenContentLayout);
        jpMainScreenContentLayout.setHorizontalGroup(
            jpMainScreenContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 742, Short.MAX_VALUE)
        );
        jpMainScreenContentLayout.setVerticalGroup(
            jpMainScreenContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 540, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jpMainScreenLayout = new javax.swing.GroupLayout(jpMainScreen);
        jpMainScreen.setLayout(jpMainScreenLayout);
        jpMainScreenLayout.setHorizontalGroup(
            jpMainScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpMainScreenLayout.createSequentialGroup()
                .addComponent(jpMainScreenSelector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpMainScreenContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpMainScreenLayout.setVerticalGroup(
            jpMainScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpMainScreenSelector, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jpMainScreenContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpMainScreen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpMainScreen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jpTeacherSignOutSelectorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpTeacherSignOutSelectorMouseClicked

        SignOut signOut = new SignOut(this, true);
        signOut.setLocationRelativeTo(null);
        signOut.setVisible(true);
        signOut.requestFocusInWindow();
    }//GEN-LAST:event_jpTeacherSignOutSelectorMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TeacherMainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TeacherMainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TeacherMainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TeacherMainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TeacherMainScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jlbTeacherAccountInfoSelector;
    private javax.swing.JLabel jlbTeacherClassStatisticSelector;
    private javax.swing.JLabel jlbTeacherId;
    private javax.swing.JLabel jlbTeacherName;
    private javax.swing.JLabel jlbTeacherSearchSelector;
    private javax.swing.JLabel jlbTeacherSignOutSelector;
    private javax.swing.JLabel jlbUserAvatar;
    private javax.swing.JPanel jpMainScreen;
    private javax.swing.JPanel jpMainScreenContent;
    private javax.swing.JPanel jpMainScreenSelector;
    private javax.swing.JPanel jpTeacherAccountInfoSelector;
    private javax.swing.JPanel jpTeacherClassStatisticSelector;
    private javax.swing.JPanel jpTeacherSearchSelector;
    private javax.swing.JPanel jpTeacherSignOutSelector;
    private javax.swing.JPanel jpUserAvatar;
    // End of variables declaration//GEN-END:variables

    @Override
    public void onMessageReceived(String message) {
        try {
            findInformationTeacher();
            System.err.println("Tranfers");
        } catch (SQLException ex) {
            Logger.getLogger(TeacherMainScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
