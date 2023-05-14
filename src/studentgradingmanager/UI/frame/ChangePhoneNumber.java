/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package studentgradingmanager.UI.frame;

import Database.DBConnect;
import java.awt.desktop.ScreenSleepEvent;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import studentgradingmanager.UI.student.StudentMainScreen;
import studentgradingmanager.UI.teacher.TeacherMainScreen;

/**
 *
 * @author Quan
 */
public class ChangePhoneNumber extends javax.swing.JFrame {

    /**
     * Creates new form ChangePhoneNumbere
     */
    private String maHS;
    private StudentMainScreen mainScreen;
    public ChangePhoneNumber() {
        initComponents();
    }
    public ChangePhoneNumber(String maHS, StudentMainScreen screen) {
        initComponents();
        this.maHS = maHS;
        this.mainScreen = screen;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpChangePhoneNumber = new javax.swing.JPanel();
        jpTitle = new javax.swing.JPanel();
        jlbTitle = new javax.swing.JLabel();
        jbBack = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jtfNewPhoneNumber = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jtfConfirmPhoneNumber = new javax.swing.JTextField();
        jbSave = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jpChangePhoneNumber.setBackground(new java.awt.Color(255, 255, 255));
        jpChangePhoneNumber.setPreferredSize(new java.awt.Dimension(960, 540));

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
                .addGap(216, 216, 216)
                .addComponent(jlbTitle)
                .addContainerGap(349, Short.MAX_VALUE))
        );
        jpTitleLayout.setVerticalGroup(
            jpTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpTitleLayout.createSequentialGroup()
                .addGroup(jpTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpTitleLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jbBack))
                    .addGroup(jpTitleLayout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jlbTitle)))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("SĐT mới");

        jtfNewPhoneNumber.setBackground(new java.awt.Color(217, 217, 217));
        jtfNewPhoneNumber.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jtfNewPhoneNumber.setForeground(new java.awt.Color(153, 153, 153));
        jtfNewPhoneNumber.setText("Nhập SĐT...");
        jtfNewPhoneNumber.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtfNewPhoneNumberMouseClicked(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Xác nhận SĐT");

        jtfConfirmPhoneNumber.setBackground(new java.awt.Color(217, 217, 217));
        jtfConfirmPhoneNumber.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jtfConfirmPhoneNumber.setForeground(new java.awt.Color(153, 153, 153));
        jtfConfirmPhoneNumber.setText("Nhập lại SĐT mới...");
        jtfConfirmPhoneNumber.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtfConfirmPhoneNumberMouseClicked(evt);
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

        javax.swing.GroupLayout jpChangePhoneNumberLayout = new javax.swing.GroupLayout(jpChangePhoneNumber);
        jpChangePhoneNumber.setLayout(jpChangePhoneNumberLayout);
        jpChangePhoneNumberLayout.setHorizontalGroup(
            jpChangePhoneNumberLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpChangePhoneNumberLayout.createSequentialGroup()
                .addComponent(jpTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jpChangePhoneNumberLayout.createSequentialGroup()
                .addGap(318, 318, 318)
                .addGroup(jpChangePhoneNumberLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpChangePhoneNumberLayout.createSequentialGroup()
                        .addComponent(jbSave)
                        .addGap(125, 125, 125))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpChangePhoneNumberLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jtfConfirmPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jtfNewPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpChangePhoneNumberLayout.setVerticalGroup(
            jpChangePhoneNumberLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpChangePhoneNumberLayout.createSequentialGroup()
                .addComponent(jpTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jtfNewPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfConfirmPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(jbSave, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(88, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpChangePhoneNumber, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 976, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpChangePhoneNumber, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBackActionPerformed

        dispose();
    }//GEN-LAST:event_jbBackActionPerformed

    private void jbSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSaveActionPerformed

        // Navigate to Login screen when finish change password
        try {
            
            
            if (checkValueValid()){
            } else {
                return;
            }
            changePhoneNumberInDatabase();
            Login login = new Login();
            login.show();
            login.setLocationRelativeTo(null);
            login.requestFocusInWindow();
            dispose();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_jbSaveActionPerformed

    private void jtfNewPhoneNumberMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtfNewPhoneNumberMouseClicked
        if (jtfNewPhoneNumber.getText().equals("Nhập SĐT...")) {
            jtfNewPhoneNumber.setText("");
        }
    }//GEN-LAST:event_jtfNewPhoneNumberMouseClicked

    private void jtfConfirmPhoneNumberMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtfConfirmPhoneNumberMouseClicked
        if (jtfConfirmPhoneNumber.getText().equals("Nhập lại SĐT mới...")) {
            jtfConfirmPhoneNumber.setText("");
        }
    }//GEN-LAST:event_jtfConfirmPhoneNumberMouseClicked

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
            java.util.logging.Logger.getLogger(ChangePhoneNumber.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChangePhoneNumber.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChangePhoneNumber.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChangePhoneNumber.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChangePhoneNumber().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton jbBack;
    private javax.swing.JButton jbSave;
    private javax.swing.JLabel jlbTitle;
    private javax.swing.JPanel jpChangePhoneNumber;
    private javax.swing.JPanel jpTitle;
    private javax.swing.JTextField jtfConfirmPhoneNumber;
    private javax.swing.JTextField jtfNewPhoneNumber;
    // End of variables declaration//GEN-END:variables

    private void changePhoneNumberInDatabase() throws SQLException{
        String newPhone = jtfNewPhoneNumber.getText().toString();
        java.sql.Connection connection = DBConnect.getConnection();
        
        String sql = "UPDATE HOCSINH SET SDT = ? WHERE MAHS = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, newPhone);
        statement.setString(2, maHS);
        statement.execute();
        JOptionPane.showMessageDialog(null, "Đổi số điện thoại thành công! Mời đăng nhập lại!");
        this.mainScreen.setVisible(false);
        this.setVisible(false);
    }

    private boolean checkValueValid() {
       String newPhone = jtfNewPhoneNumber.getText().toString();
       String confirmPhoneNumber = jtfConfirmPhoneNumber.getText().toString();
       if (!newPhone.equals(confirmPhoneNumber)) {
           JOptionPane.showMessageDialog(null, "Số điện thoại mới và xác nhận số điện thoại không giống nhau!");
            return false;
       }
       if (newPhone.length() != 10) {
           JOptionPane.showMessageDialog(null, "Số điện thoại mới không hợp lệ!");
            return false;
       }
       try {
           long newPhoneNumber = Long.parseLong(newPhone);
           return true;
       } catch (Exception e) {
           JOptionPane.showMessageDialog(null, "Số điện thoại mới không hợp lệ!");
            return false;
       }
    }
}
