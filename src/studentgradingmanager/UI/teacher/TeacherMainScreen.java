/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package studentgradingmanager.UI.teacher;

import java.util.ArrayList;
import studentgradingmanager.UI.dialog.SignOut;
import studentgradingmanager.bean.Category;
import studentgradingmanager.controller.TeacherNavController;

/**
 *
 * @author Quan
 */
public class TeacherMainScreen extends javax.swing.JFrame {

    /**
     * Creates new form TeacherMainScreen
     */
    public TeacherMainScreen() {
        initComponents();
        TeacherNavController controller = new TeacherNavController(jpMainScreenContent);
        controller.setView(jpTeacherAccountInfoSelector, jlbTeacherAccountInfoSelector);
        
        ArrayList<Category> listCategory = new ArrayList<>();
        listCategory.add(new Category("Thông tin tài khoản", jpTeacherAccountInfoSelector, jlbTeacherAccountInfoSelector));
        listCategory.add(new Category("Tra cứu kết quả học sinh", jpTeacherSearchSelector, jlbTeacherSearchSelector));
        listCategory.add(new Category("Quản lý điểm lớp học", jpTeacherGradingManagementSelector, jlbTeacherGradingManagementSelector));
        controller.setEvent(listCategory); 
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
        jpTeacherGradingManagementSelector = new javax.swing.JPanel();
        jlbTeacherGradingManagementSelector = new javax.swing.JLabel();
        jpMainScreenContent = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(960, 540));

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
                .addGap(14, 14, 14)
                .addComponent(jlbUserAvatar, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
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
                .addContainerGap(40, Short.MAX_VALUE))
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
        jlbTeacherName.setText("TÊN GIÁO VIÊN");

        jlbTeacherId.setBackground(new java.awt.Color(255, 255, 255));
        jlbTeacherId.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jlbTeacherId.setForeground(new java.awt.Color(255, 255, 255));
        jlbTeacherId.setText("ID GIÁO VIÊN");

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

        jpTeacherGradingManagementSelector.setBackground(new java.awt.Color(111, 142, 222));
        jpTeacherGradingManagementSelector.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jpTeacherGradingManagementSelector.setPreferredSize(new java.awt.Dimension(200, 54));

        jlbTeacherGradingManagementSelector.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jlbTeacherGradingManagementSelector.setForeground(new java.awt.Color(255, 255, 255));
        jlbTeacherGradingManagementSelector.setIcon(new javax.swing.ImageIcon(getClass().getResource("/studentgradingmanager/images/icon-report-card-16.png"))); // NOI18N
        jlbTeacherGradingManagementSelector.setText("Quản lý điểm lớp học");
        jlbTeacherGradingManagementSelector.setPreferredSize(new java.awt.Dimension(90, 48));

        javax.swing.GroupLayout jpTeacherGradingManagementSelectorLayout = new javax.swing.GroupLayout(jpTeacherGradingManagementSelector);
        jpTeacherGradingManagementSelector.setLayout(jpTeacherGradingManagementSelectorLayout);
        jpTeacherGradingManagementSelectorLayout.setHorizontalGroup(
            jpTeacherGradingManagementSelectorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpTeacherGradingManagementSelectorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbTeacherGradingManagementSelector, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(30, 30, 30))
        );
        jpTeacherGradingManagementSelectorLayout.setVerticalGroup(
            jpTeacherGradingManagementSelectorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpTeacherGradingManagementSelectorLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jlbTeacherGradingManagementSelector, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jpMainScreenSelectorLayout = new javax.swing.GroupLayout(jpMainScreenSelector);
        jpMainScreenSelector.setLayout(jpMainScreenSelectorLayout);
        jpMainScreenSelectorLayout.setHorizontalGroup(
            jpMainScreenSelectorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpMainScreenSelectorLayout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(jlbTeacherId))
            .addComponent(jpTeacherGradingManagementSelector, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jpTeacherSearchSelector, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jpTeacherAccountInfoSelector, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jpMainScreenSelectorLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jpMainScreenSelectorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpUserAvatar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlbTeacherName, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addComponent(jpTeacherSignOutSelector, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addGap(30, 30, 30)
                .addComponent(jpTeacherAccountInfoSelector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpTeacherSearchSelector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpTeacherGradingManagementSelector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpTeacherSignOutSelector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jpMainScreenContent.setBackground(new java.awt.Color(255, 255, 255));
        jpMainScreenContent.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jpMainScreenContentLayout = new javax.swing.GroupLayout(jpMainScreenContent);
        jpMainScreenContent.setLayout(jpMainScreenContentLayout);
        jpMainScreenContentLayout.setHorizontalGroup(
            jpMainScreenContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 760, Short.MAX_VALUE)
        );
        jpMainScreenContentLayout.setVerticalGroup(
            jpMainScreenContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 542, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jpMainScreenLayout = new javax.swing.GroupLayout(jpMainScreen);
        jpMainScreen.setLayout(jpMainScreenLayout);
        jpMainScreenLayout.setHorizontalGroup(
            jpMainScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpMainScreenLayout.createSequentialGroup()
                .addComponent(jpMainScreenSelector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jpMainScreenContent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
            .addComponent(jpMainScreen, javax.swing.GroupLayout.DEFAULT_SIZE, 966, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpMainScreen, javax.swing.GroupLayout.DEFAULT_SIZE, 542, Short.MAX_VALUE)
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
    private javax.swing.JLabel jlbTeacherGradingManagementSelector;
    private javax.swing.JLabel jlbTeacherId;
    private javax.swing.JLabel jlbTeacherName;
    private javax.swing.JLabel jlbTeacherSearchSelector;
    private javax.swing.JLabel jlbTeacherSignOutSelector;
    private javax.swing.JLabel jlbUserAvatar;
    private javax.swing.JPanel jpMainScreen;
    private javax.swing.JPanel jpMainScreenContent;
    private javax.swing.JPanel jpMainScreenSelector;
    private javax.swing.JPanel jpTeacherAccountInfoSelector;
    private javax.swing.JPanel jpTeacherGradingManagementSelector;
    private javax.swing.JPanel jpTeacherSearchSelector;
    private javax.swing.JPanel jpTeacherSignOutSelector;
    private javax.swing.JPanel jpUserAvatar;
    // End of variables declaration//GEN-END:variables
}
