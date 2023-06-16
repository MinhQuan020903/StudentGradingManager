/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package studentgradingmanager.UI.frame;

import Database.DBConnect;
import java.awt.GraphicsEnvironment;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import TransferData.MessageBroker;
import java.awt.GraphicsEnvironment;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import studentgradingmanager.UI.student.StudentMainScreen;
import studentgradingmanager.UI.teacher.TeacherMainScreen;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Quan
 */
public class ChangePassword extends javax.swing.JFrame {

    private String passoword;
    private String matkGV;

    /**
     * Creates new form ChangePassword
     */
    private String maTKHS;
    private StudentMainScreen mainScreen;
    public ChangePassword() {
    }

    public ChangePassword(String matkGV, String passoword) {
        initComponents();
        this.maTKHS = maTKHS;
        setTitle("ĐỔI MẬT KHẨU");
        continueInitComponents();

        this.passoword = passoword;
        this.matkGV = matkGV;
    }
    public ChangePassword(String maTK, StudentMainScreen screen) {
        initComponents();
        // This function runs after the auto-run initComponents() function
        // generated by JavaSwingUI
        this.maTKHS = maTK;
        this.mainScreen = screen;
        setTitle("ĐỔI MẬT KHẨU");
        continueInitComponents();
        this.passoword = passoword;
        this.matkGV = matkGV;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpChangePassword = new javax.swing.JPanel();
        jpTitle = new javax.swing.JPanel();
        jlbTitle = new javax.swing.JLabel();
        jbBack = new javax.swing.JButton();
        jtfNewPassword = new javax.swing.JPasswordField();
        jbShowPassword = new javax.swing.JToggleButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jtfConfirmPassword = new javax.swing.JPasswordField();
        jbShowConfirmPassword = new javax.swing.JToggleButton();
        jbSave = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jpChangePassword.setBackground(new java.awt.Color(255, 255, 255));
        jpChangePassword.setPreferredSize(new java.awt.Dimension(960, 540));

        jpTitle.setBackground(new java.awt.Color(111, 142, 222));
        jpTitle.setForeground(new java.awt.Color(111, 142, 222));

        jlbTitle.setBackground(new java.awt.Color(255, 255, 255));
        jlbTitle.setFont(new java.awt.Font("Noto Sans", 1, 24)); // NOI18N
        jlbTitle.setForeground(new java.awt.Color(255, 255, 255));
        jlbTitle.setText("QUẢN LÝ ĐIỂM HỌC SINH");

        jbBack.setBackground(new java.awt.Color(153, 204, 255));
        jbBack.setForeground(new java.awt.Color(255, 255, 255));
        jbBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/studentgradingmanager/images/icon-back-48.png"))); // NOI18N
        jbBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpTitleLayout = new javax.swing.GroupLayout(jpTitle);
        jpTitle.setLayout(jpTitleLayout);
        jpTitleLayout.setHorizontalGroup(
            jpTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpTitleLayout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jbBack)
                .addGap(206, 206, 206)
                .addComponent(jlbTitle)
                .addContainerGap(359, Short.MAX_VALUE))
        );
        jpTitleLayout.setVerticalGroup(
            jpTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpTitleLayout.createSequentialGroup()
                .addGroup(jpTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpTitleLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jbBack))
                    .addGroup(jpTitleLayout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jlbTitle)))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        jtfNewPassword.setBackground(new java.awt.Color(217, 217, 217));
        jtfNewPassword.setForeground(new java.awt.Color(153, 153, 153));
        jtfNewPassword.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

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
        jLabel1.setText("Mật khẩu mới");

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Xác nhận mật khẩu");

        jtfConfirmPassword.setBackground(new java.awt.Color(217, 217, 217));
        jtfConfirmPassword.setForeground(new java.awt.Color(153, 153, 153));
        jtfConfirmPassword.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jbShowConfirmPassword.setBackground(new java.awt.Color(255, 255, 255));
        jbShowConfirmPassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/studentgradingmanager/images/icon-hide-30.png"))); // NOI18N
        jbShowConfirmPassword.setBorder(null);
        jbShowConfirmPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbShowConfirmPasswordActionPerformed(evt);
            }
        });

        jbSave.setBackground(new java.awt.Color(111, 142, 222));
        jbSave.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jbSave.setForeground(new java.awt.Color(255, 255, 255));
        jbSave.setText("Lưu");
        jbSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpChangePasswordLayout = new javax.swing.GroupLayout(jpChangePassword);
        jpChangePassword.setLayout(jpChangePasswordLayout);
        jpChangePasswordLayout.setHorizontalGroup(
            jpChangePasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpChangePasswordLayout.createSequentialGroup()
                .addComponent(jpTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpChangePasswordLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jpChangePasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpChangePasswordLayout.createSequentialGroup()
                        .addGroup(jpChangePasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpChangePasswordLayout.createSequentialGroup()
                                .addComponent(jtfConfirmPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jbShowConfirmPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel2)
                            .addGroup(jpChangePasswordLayout.createSequentialGroup()
                                .addGroup(jpChangePasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtfNewPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jbShowPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(293, 293, 293))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpChangePasswordLayout.createSequentialGroup()
                        .addComponent(jbSave)
                        .addGap(472, 472, 472))))
        );
        jpChangePasswordLayout.setVerticalGroup(
            jpChangePasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpChangePasswordLayout.createSequentialGroup()
                .addComponent(jpTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jpChangePasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpChangePasswordLayout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addComponent(jbShowPassword)
                        .addGap(78, 78, 78)
                        .addComponent(jbShowConfirmPassword))
                    .addGroup(jpChangePasswordLayout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtfNewPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jLabel2)
                        .addGap(12, 12, 12)
                        .addComponent(jtfConfirmPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(38, 38, 38)
                .addComponent(jbSave, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(101, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpChangePassword, javax.swing.GroupLayout.PREFERRED_SIZE, 970, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpChangePassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbShowPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbShowPasswordActionPerformed

        if (jbShowPassword.isSelected()) {
            jbShowPassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/studentgradingmanager/images/icon-eye-30.png")));
            jtfNewPassword.setEchoChar((char) 0);

        } else {
            jbShowPassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/studentgradingmanager/images/icon-hide-30.png")));
            jtfNewPassword.setEchoChar('*');
            jbShowPassword.setSelected(false);
        }
    }//GEN-LAST:event_jbShowPasswordActionPerformed

    private void jbShowConfirmPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbShowConfirmPasswordActionPerformed

        // Check conditions for show / hide password buttons
        if (jbShowConfirmPassword.isSelected()) {
            jbShowConfirmPassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/studentgradingmanager/images/icon-eye-30.png")));
            jtfConfirmPassword.setEchoChar((char) 0);

        } else {
            jbShowConfirmPassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/studentgradingmanager/images/icon-hide-30.png")));
            jtfConfirmPassword.setEchoChar('*');
            jbShowConfirmPassword.setSelected(false);
        }
    }//GEN-LAST:event_jbShowConfirmPasswordActionPerformed

    private void jbSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSaveActionPerformed
    
        // Navigate to Login screen when finish change password
        if (maTKHS != null) {
            if (!checkValueValid())
                 return;
            try {
                changePasswordInDatabse();
            } catch (SQLException ex) {
                Logger.getLogger(ChangePassword.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            Login login = new Login();
            login.show();
            login.setLocationRelativeTo(null);
            login.requestFocusInWindow();
        } else {
             if (jtfNewPassword.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui Lòng Nhập Mật Khẩu Mới! ");
        } else {
            if (jtfConfirmPassword.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Vui Lòng Xác Nhận Mật Khẩu Mới!");
            } else {
                if (!jtfNewPassword.getText().equals(jtfConfirmPassword.getText())) {
                    JOptionPane.showMessageDialog(this, "Mật Khẩu Không Trùng Khớp, Vui Lòng Nhập Lại");
                    jtfConfirmPassword.setText("");
                    jtfNewPassword.setText("");
                } else {
                    if (jtfNewPassword.getText().equals(passoword)) {
                        JOptionPane.showMessageDialog(this, "Mật Khẩu Mới Phải Khác Mật Khẩu Cũ!");
                        jtfConfirmPassword.setText("");
                        jtfNewPassword.setText("");
                    } else {
                        try {
                            String newPassword = jtfConfirmPassword.getText().toString().trim();

                            // udpate password
                            java.sql.Connection connection = DBConnect.getConnection();
                            String sql = "Update TAIKHOAN Set MATKHAU = ? Where MATK = ? ";

                            try {
                                PreparedStatement ps = connection.prepareCall(sql);
                                ps.setString(1, newPassword);
                                ps.setString(2, matkGV);
                                ps.executeUpdate();
                                if (!ps.isClosed()) {
                                    ps.close();
                                    System.out.println("Closed to database ChangePassword!");
                                }
                            } catch (Exception e) {
                                Logger.getLogger(ChangePassword.class.getName()).log(Level.SEVERE, null, e);
                            }

                            // Navigate to Login screen when finish change password
                            try {
                                MessageBroker.getInstance().sendMessage("Data updated");
                                dispose();

                            } catch (Exception ex) {
                                JOptionPane.showMessageDialog(null, ex);
                            }
                        } catch (SQLException ex) {
                            Logger.getLogger(ChangePassword.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            }
        }
    }

        


    }//GEN-LAST:event_jbSaveActionPerformed

    private void jbBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBackActionPerformed

        // Navigate to Login screen when click Back
        switch (message) {
            case "FROM_LOGIN": {
                Login login = new Login();
                login.show();
                login.setLocationRelativeTo(null);
                login.setVisible(true);
                login.requestFocusInWindow();
                dispose();
                break;
            }
            default: {
                dispose();
                break;
            }
        }


    }//GEN-LAST:event_jbBackActionPerformed

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
            java.util.logging.Logger.getLogger(ChangePassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChangePassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChangePassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChangePassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ChangePassword changePassword = new ChangePassword();

                changePassword.setLocationRelativeTo(null);
                changePassword.setVisible(true);
                changePassword.requestFocusInWindow();
            }
        });
    }

    private String message = "";

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton jbBack;
    private javax.swing.JButton jbSave;
    private javax.swing.JToggleButton jbShowConfirmPassword;
    private javax.swing.JToggleButton jbShowPassword;
    private javax.swing.JLabel jlbTitle;
    private javax.swing.JPanel jpChangePassword;
    private javax.swing.JPanel jpTitle;
    private javax.swing.JPasswordField jtfConfirmPassword;
    private javax.swing.JPasswordField jtfNewPassword;
    // End of variables declaration//GEN-END:variables

    // This function runs after the auto-run initComponents() function
    // generated by JavaSwingUI
    private void continueInitComponents() {
        jbShowPassword.setContentAreaFilled(false);
        jbShowConfirmPassword.setContentAreaFilled(false);
    }

    private void changePasswordInDatabse() throws SQLException {
        String newPassword = jtfNewPassword.getText().toString();
        java.sql.Connection connection = DBConnect.getConnection();
        
        String sql = "UPDATE TAIKHOAN SET MATKHAU = ? WHERE MATK = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, newPassword);
        statement.setString(2, maTKHS);
        statement.execute();
        JOptionPane.showMessageDialog(null, "Đổi mật khẩu thành công! Mời đăng nhập lại!");
        this.mainScreen.setVisible(false);
        this.setVisible(false);
    }

    private boolean checkValueValid() {
        String newPassword = jtfNewPassword.getText().toString();
        String confirmPassword = jtfConfirmPassword.getText().toString();
        if (!newPassword.equals(confirmPassword)) {
            JOptionPane.showMessageDialog(null, "Mật khẩu mới và xác nhận mật khẩu không giống nhau!");
            return false;
        }
        return true;
    }
}
