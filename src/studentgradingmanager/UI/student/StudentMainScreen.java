/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package studentgradingmanager.UI.student;

import java.awt.Color;
import java.awt.Container;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import studentgradingmanager.UI.frame.ChangePassword;
import studentgradingmanager.UI.dialog.SignOut;
import studentgradingmanager.bean.Category;
import studentgradingmanager.controller.StudentNavController;


/**
 *
 * @author Quan
 */
public class StudentMainScreen extends javax.swing.JFrame{

    /**
     * Creates new form StudentMainScreen
     */
    public StudentMainScreen() {
        initComponents();
        StudentNavController controller = new StudentNavController(jpMainScreenContent);
        controller.setView(jpStudentAccountInfoSelector, jlbStudentAccountInfoSelector);
        
        ArrayList<Category> listCategory = new ArrayList<>();
        listCategory.add(new Category("Thông tin tài khoản", jpStudentAccountInfoSelector, jlbStudentAccountInfoSelector));
        listCategory.add(new Category("Kết quả học tập", jpStudentGradeResultSelector, jlbStudentGradeResultSelector));
        controller.setEvent(listCategory); 
        //Init user avatar jpanel
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
        jpStudentAccountInfoSelector = new javax.swing.JPanel();
        jlbStudentAccountInfoSelector = new javax.swing.JLabel();
        jlbStudentName = new javax.swing.JLabel();
        jlbStudentId = new javax.swing.JLabel();
        jpStudentGradeResultSelector = new javax.swing.JPanel();
        jlbStudentGradeResultSelector = new javax.swing.JLabel();
        jpStudentSignOutSelector = new javax.swing.JPanel();
        jlbStudentSignOutSelector = new javax.swing.JLabel();
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

        jpStudentAccountInfoSelector.setBackground(new java.awt.Color(111, 142, 222));
        jpStudentAccountInfoSelector.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jlbStudentAccountInfoSelector.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jlbStudentAccountInfoSelector.setForeground(new java.awt.Color(255, 255, 255));
        jlbStudentAccountInfoSelector.setIcon(new javax.swing.ImageIcon(getClass().getResource("/studentgradingmanager/images/icon-user-16.png"))); // NOI18N
        jlbStudentAccountInfoSelector.setText("Thông tin tài khoản");
        jlbStudentAccountInfoSelector.setPreferredSize(new java.awt.Dimension(90, 48));

        javax.swing.GroupLayout jpStudentAccountInfoSelectorLayout = new javax.swing.GroupLayout(jpStudentAccountInfoSelector);
        jpStudentAccountInfoSelector.setLayout(jpStudentAccountInfoSelectorLayout);
        jpStudentAccountInfoSelectorLayout.setHorizontalGroup(
            jpStudentAccountInfoSelectorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpStudentAccountInfoSelectorLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jlbStudentAccountInfoSelector, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jpStudentAccountInfoSelectorLayout.setVerticalGroup(
            jpStudentAccountInfoSelectorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpStudentAccountInfoSelectorLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jlbStudentAccountInfoSelector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jlbStudentName.setBackground(new java.awt.Color(255, 255, 255));
        jlbStudentName.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jlbStudentName.setForeground(new java.awt.Color(255, 255, 255));
        jlbStudentName.setText("TÊN HỌC SINH");

        jlbStudentId.setBackground(new java.awt.Color(255, 255, 255));
        jlbStudentId.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jlbStudentId.setForeground(new java.awt.Color(255, 255, 255));
        jlbStudentId.setText("ID HỌC SINH");

        jpStudentGradeResultSelector.setBackground(new java.awt.Color(111, 142, 222));
        jpStudentGradeResultSelector.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jlbStudentGradeResultSelector.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jlbStudentGradeResultSelector.setForeground(new java.awt.Color(255, 255, 255));
        jlbStudentGradeResultSelector.setIcon(new javax.swing.ImageIcon(getClass().getResource("/studentgradingmanager/images/icon-report-card-16.png"))); // NOI18N
        jlbStudentGradeResultSelector.setText(" Kết quả học tập");
        jlbStudentGradeResultSelector.setPreferredSize(new java.awt.Dimension(90, 48));

        javax.swing.GroupLayout jpStudentGradeResultSelectorLayout = new javax.swing.GroupLayout(jpStudentGradeResultSelector);
        jpStudentGradeResultSelector.setLayout(jpStudentGradeResultSelectorLayout);
        jpStudentGradeResultSelectorLayout.setHorizontalGroup(
            jpStudentGradeResultSelectorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpStudentGradeResultSelectorLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jlbStudentGradeResultSelector, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(19, 19, 19))
        );
        jpStudentGradeResultSelectorLayout.setVerticalGroup(
            jpStudentGradeResultSelectorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpStudentGradeResultSelectorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbStudentGradeResultSelector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        jpStudentSignOutSelector.setBackground(new java.awt.Color(111, 142, 222));
        jpStudentSignOutSelector.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jpStudentSignOutSelector.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpStudentSignOutSelectorMouseClicked(evt);
            }
        });

        jlbStudentSignOutSelector.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jlbStudentSignOutSelector.setForeground(new java.awt.Color(255, 51, 51));
        jlbStudentSignOutSelector.setIcon(new javax.swing.ImageIcon(getClass().getResource("/studentgradingmanager/images/icon-logout-16.png"))); // NOI18N
        jlbStudentSignOutSelector.setText(" Đăng xuất");
        jlbStudentSignOutSelector.setPreferredSize(new java.awt.Dimension(90, 48));

        javax.swing.GroupLayout jpStudentSignOutSelectorLayout = new javax.swing.GroupLayout(jpStudentSignOutSelector);
        jpStudentSignOutSelector.setLayout(jpStudentSignOutSelectorLayout);
        jpStudentSignOutSelectorLayout.setHorizontalGroup(
            jpStudentSignOutSelectorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpStudentSignOutSelectorLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jlbStudentSignOutSelector, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(40, 40, 40))
        );
        jpStudentSignOutSelectorLayout.setVerticalGroup(
            jpStudentSignOutSelectorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpStudentSignOutSelectorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbStudentSignOutSelector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jpMainScreenSelectorLayout = new javax.swing.GroupLayout(jpMainScreenSelector);
        jpMainScreenSelector.setLayout(jpMainScreenSelectorLayout);
        jpMainScreenSelectorLayout.setHorizontalGroup(
            jpMainScreenSelectorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpMainScreenSelectorLayout.createSequentialGroup()
                .addGroup(jpMainScreenSelectorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpMainScreenSelectorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jpStudentSignOutSelector, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jpStudentGradeResultSelector, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jpStudentAccountInfoSelector, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jpMainScreenSelectorLayout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(jpMainScreenSelectorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jpUserAvatar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlbStudentName, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jpMainScreenSelectorLayout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(jlbStudentId)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpMainScreenSelectorLayout.setVerticalGroup(
            jpMainScreenSelectorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpMainScreenSelectorLayout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(jpUserAvatar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlbStudentName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlbStudentId)
                .addGap(38, 38, 38)
                .addComponent(jpStudentAccountInfoSelector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpStudentGradeResultSelector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpStudentSignOutSelector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(72, Short.MAX_VALUE))
        );

        jpMainScreenContent.setBackground(new java.awt.Color(255, 255, 255));
        jpMainScreenContent.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jpMainScreenContentLayout = new javax.swing.GroupLayout(jpMainScreenContent);
        jpMainScreenContent.setLayout(jpMainScreenContentLayout);
        jpMainScreenContentLayout.setHorizontalGroup(
            jpMainScreenContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 785, Short.MAX_VALUE)
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
                .addComponent(jpMainScreenContent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
            .addComponent(jpMainScreen, javax.swing.GroupLayout.DEFAULT_SIZE, 999, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpMainScreen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jpStudentSignOutSelectorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpStudentSignOutSelectorMouseClicked
        
        SignOut signOut = new SignOut(this, true);
        signOut.setLocationRelativeTo(null);
        signOut.setVisible(true);
        signOut.requestFocusInWindow();
    }//GEN-LAST:event_jpStudentSignOutSelectorMouseClicked

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
            java.util.logging.Logger.getLogger(StudentMainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StudentMainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StudentMainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentMainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                StudentMainScreen studentMainScreen = new StudentMainScreen();  

                studentMainScreen.setLocationRelativeTo(null);
                studentMainScreen.setVisible(true);
                studentMainScreen.requestFocusInWindow();
                
            }
        });
    }

    public JLabel getJlbStudentAccountInfoSelector() {
        return jlbStudentAccountInfoSelector;
    }

    public void setJlbStudentAccountInfoSelector(JLabel jlbStudentAccountInfoSelector) {
        this.jlbStudentAccountInfoSelector = jlbStudentAccountInfoSelector;
    }

    public JLabel getJlbStudentGradeResultSelector() {
        return jlbStudentGradeResultSelector;
    }

    public void setJlbStudentGradeResultSelector(JLabel jlbStudentGradeResultSelector) {
        this.jlbStudentGradeResultSelector = jlbStudentGradeResultSelector;
    }

    public JPanel getJpStudentAccountInfoSelector() {
        return jpStudentAccountInfoSelector;
    }

    public void setJpStudentAccountInfoSelector(JPanel jpStudentAccountInfoSelector) {
        this.jpStudentAccountInfoSelector = jpStudentAccountInfoSelector;
    }

    public JPanel getJpStudentGradeResultSelector() {
        return jpStudentGradeResultSelector;
    }

    public void setJpStudentGradeResultSelector(JPanel jpStudentGradeResultSelector) {
        this.jpStudentGradeResultSelector = jpStudentGradeResultSelector;
    }
    
    public void setColorOnMousePressed(JPanel jpItem, JLabel jlbItem) {
        jpItem.setBackground(new Color(81, 102, 159));
        jlbItem.setBackground(new Color(81, 102, 159));
    }
    
    public void setColorOnMouseEntered(JPanel jpItem, JLabel jlbItem) {
        jpItem.setBackground(new Color(0, 154, 255));
        jlbItem.setBackground(new Color(0, 154, 255));
    }
    
    public void setColorOnMouseExited(JPanel jpItem, JLabel jlbItem) {
        jpItem.setBackground(new Color(111, 142, 222));
        jlbItem.setBackground(new Color(111, 142, 222));
    }
    

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jlbStudentAccountInfoSelector;
    private javax.swing.JLabel jlbStudentGradeResultSelector;
    private javax.swing.JLabel jlbStudentId;
    private javax.swing.JLabel jlbStudentName;
    private javax.swing.JLabel jlbStudentSignOutSelector;
    private javax.swing.JLabel jlbUserAvatar;
    private javax.swing.JPanel jpMainScreen;
    private javax.swing.JPanel jpMainScreenContent;
    private javax.swing.JPanel jpMainScreenSelector;
    private javax.swing.JPanel jpStudentAccountInfoSelector;
    private javax.swing.JPanel jpStudentGradeResultSelector;
    private javax.swing.JPanel jpStudentSignOutSelector;
    private javax.swing.JPanel jpUserAvatar;
    // End of variables declaration//GEN-END:variables


}


