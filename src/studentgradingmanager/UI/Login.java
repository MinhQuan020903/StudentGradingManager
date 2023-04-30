/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package studentgradingmanager.UI;

import java.awt.BorderLayout;
import javax.swing.JOptionPane;
import studentgradingmanager.UI.student.StudentMainScreen;

/**
 *
 * @author Quan
 */
public class Login extends javax.swing.JFrame {
   

    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
        // This function runs after the auto-run initComponents() function
        // generated by JavaSwingUI
        continueInitComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpLoginScreen = new javax.swing.JPanel();
        jpTitle = new javax.swing.JPanel();
        jlbTitle = new javax.swing.JLabel();
        jbUserIcon = new javax.swing.JLabel();
        jtfUserEmail = new javax.swing.JTextField();
        jlbUserPassword = new javax.swing.JLabel();
        jtfUserPassword = new javax.swing.JPasswordField();
        jcbRememberPassword = new javax.swing.JCheckBox();
        jbForgetPassword = new javax.swing.JButton();
        jbLogin = new javax.swing.JButton();
        jbShowPassword = new javax.swing.JToggleButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jpLoginScreen.setBackground(new java.awt.Color(255, 255, 255));
        jpLoginScreen.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jpLoginScreen.setForeground(new java.awt.Color(255, 255, 255));
        jpLoginScreen.setMaximumSize(new java.awt.Dimension(960, 540));
        jpLoginScreen.setPreferredSize(new java.awt.Dimension(960, 540));

        jpTitle.setBackground(new java.awt.Color(111, 142, 222));
        jpTitle.setForeground(new java.awt.Color(111, 142, 222));

        jlbTitle.setBackground(new java.awt.Color(255, 255, 255));
        jlbTitle.setFont(new java.awt.Font("Noto Sans", 1, 24)); // NOI18N
        jlbTitle.setForeground(new java.awt.Color(255, 255, 255));
        jlbTitle.setText("QUẢN LÝ ĐIỂM HỌC SINH");

        javax.swing.GroupLayout jpTitleLayout = new javax.swing.GroupLayout(jpTitle);
        jpTitle.setLayout(jpTitleLayout);
        jpTitleLayout.setHorizontalGroup(
            jpTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpTitleLayout.createSequentialGroup()
                .addContainerGap(355, Short.MAX_VALUE)
                .addComponent(jlbTitle)
                .addGap(316, 316, 316))
        );
        jpTitleLayout.setVerticalGroup(
            jpTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpTitleLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jlbTitle)
                .addContainerGap(44, Short.MAX_VALUE))
        );

        jbUserIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/studentgradingmanager/images/icon-user-48.png"))); // NOI18N

        jtfUserEmail.setBackground(new java.awt.Color(217, 217, 217));
        jtfUserEmail.setForeground(new java.awt.Color(153, 153, 153));
        jtfUserEmail.setText("Nhập email...");
        jtfUserEmail.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jtfUserEmail.setMargin(new java.awt.Insets(6, 50, 2, 6));
        jtfUserEmail.setSelectionColor(new java.awt.Color(102, 102, 102));
        jtfUserEmail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtfUserEmailFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtfUserEmailFocusLost(evt);
            }
        });

        jlbUserPassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/studentgradingmanager/images/icon-password-48.png"))); // NOI18N

        jtfUserPassword.setBackground(new java.awt.Color(217, 217, 217));
        jtfUserPassword.setForeground(new java.awt.Color(153, 153, 153));
        jtfUserPassword.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jcbRememberPassword.setBackground(new java.awt.Color(255, 255, 255));
        jcbRememberPassword.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jcbRememberPassword.setText(" Nhớ mật khẩu");
        jcbRememberPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbRememberPasswordActionPerformed(evt);
            }
        });

        jbForgetPassword.setBackground(new java.awt.Color(255, 255, 255));
        jbForgetPassword.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jbForgetPassword.setText("Quên mật khẩu?");
        jbForgetPassword.setBorder(null);
        jbForgetPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbForgetPasswordActionPerformed(evt);
            }
        });

        jbLogin.setBackground(new java.awt.Color(111, 142, 222));
        jbLogin.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jbLogin.setForeground(new java.awt.Color(255, 255, 255));
        jbLogin.setText("Đăng nhập");
        jbLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbLoginActionPerformed(evt);
            }
        });

        jbShowPassword.setBackground(new java.awt.Color(255, 255, 255));
        jbShowPassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/studentgradingmanager/images/icon-hide-30.png"))); // NOI18N
        jbShowPassword.setBorder(null);
        jbShowPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbShowPasswordActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Email");

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Email");

        javax.swing.GroupLayout jpLoginScreenLayout = new javax.swing.GroupLayout(jpLoginScreen);
        jpLoginScreen.setLayout(jpLoginScreenLayout);
        jpLoginScreenLayout.setHorizontalGroup(
            jpLoginScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpLoginScreenLayout.createSequentialGroup()
                .addComponent(jpTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jpLoginScreenLayout.createSequentialGroup()
                .addGroup(jpLoginScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpLoginScreenLayout.createSequentialGroup()
                        .addGap(320, 320, 320)
                        .addComponent(jcbRememberPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(105, 105, 105)
                        .addComponent(jbForgetPassword))
                    .addGroup(jpLoginScreenLayout.createSequentialGroup()
                        .addGroup(jpLoginScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpLoginScreenLayout.createSequentialGroup()
                                .addGap(292, 292, 292)
                                .addComponent(jlbUserPassword)
                                .addGap(18, 18, 18)
                                .addComponent(jtfUserPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jpLoginScreenLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jbUserIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jpLoginScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtfUserEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbShowPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpLoginScreenLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jbLogin)
                .addGap(407, 407, 407))
        );
        jpLoginScreenLayout.setVerticalGroup(
            jpLoginScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpLoginScreenLayout.createSequentialGroup()
                .addComponent(jpTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpLoginScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jbUserIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jtfUserEmail))
                .addGroup(jpLoginScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpLoginScreenLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpLoginScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlbUserPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jtfUserPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18))
                    .addGroup(jpLoginScreenLayout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jbShowPassword)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jpLoginScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbForgetPassword)
                    .addComponent(jcbRememberPassword))
                .addGap(18, 18, 18)
                .addComponent(jbLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpLoginScreen, javax.swing.GroupLayout.DEFAULT_SIZE, 980, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpLoginScreen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jcbRememberPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbRememberPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbRememberPasswordActionPerformed

    private void jbForgetPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbForgetPasswordActionPerformed
        
        // Navigate to ChangePassword screen
        try {
            ChangePassword changePassword = new ChangePassword();
            changePassword.show();
            changePassword.setLocationRelativeTo(null);
            changePassword.requestFocusInWindow(); 
            dispose();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

    }//GEN-LAST:event_jbForgetPasswordActionPerformed

    private void jbLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLoginActionPerformed
        
        //TODO: Add sign-in condition here:
        if (true) {
            StudentMainScreen studentMainScreen = new StudentMainScreen();
            studentMainScreen.show();
            studentMainScreen.setLocationRelativeTo(null);
            studentMainScreen.requestFocusInWindow(); 
            dispose();
        }
    }//GEN-LAST:event_jbLoginActionPerformed

    private void jbShowPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbShowPasswordActionPerformed
        
        // Check conditions for show / hide password button
        if (jbShowPassword.isSelected()) {
            jbShowPassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/studentgradingmanager/images/icon-eye-30.png")));
            jtfUserPassword.setEchoChar((char)0);

        } else {               
            jbShowPassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/studentgradingmanager/images/icon-hide-30.png")));
            jtfUserPassword.setEchoChar('*');
            jbShowPassword.setSelected(false);
        }
    }//GEN-LAST:event_jbShowPasswordActionPerformed

    private void jtfUserEmailFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtfUserEmailFocusGained
        // TODO add your handling code here:
        if (jtfUserEmail.getText().equals("Nhập email...")) {
            jtfUserEmail.setText("");
        }
    }//GEN-LAST:event_jtfUserEmailFocusGained

    private void jtfUserEmailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtfUserEmailFocusLost
        // TODO add your handling code here:
        if (jtfUserEmail.getText().equals("")) {
            jtfUserEmail.setText("Nhập email...");
        }
    }//GEN-LAST:event_jtfUserEmailFocusLost

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Login login = new Login();
                
                //Center the screen
                login.setLocationRelativeTo(null);
                login.setVisible(true);
                login.requestFocusInWindow();
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton jbForgetPassword;
    private javax.swing.JButton jbLogin;
    private javax.swing.JToggleButton jbShowPassword;
    private javax.swing.JLabel jbUserIcon;
    private javax.swing.JCheckBox jcbRememberPassword;
    private javax.swing.JLabel jlbTitle;
    private javax.swing.JLabel jlbUserPassword;
    private javax.swing.JPanel jpLoginScreen;
    private javax.swing.JPanel jpTitle;
    private javax.swing.JTextField jtfUserEmail;
    private javax.swing.JPasswordField jtfUserPassword;
    // End of variables declaration//GEN-END:variables

    
    // This function runs after the auto-run initComponents() function
    // generated by JavaSwingUI
    private void continueInitComponents() {
        //Hide borders of jbShowPassword
        jbShowPassword.setContentAreaFilled(false);
    }
}
