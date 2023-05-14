/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package studentgradingmanager.UI.teacher.jpanel;

import Database.DBConnect;
import OOP.Teacher;
import TransferData.MessageBroker;
import TransferData.MessageListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import studentgradingmanager.UI.frame.ChangePassword;
import studentgradingmanager.UI.frame.ChangePhoneNumber;

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
public class TeacherAccountInfo extends javax.swing.JPanel implements MessageListener {

    private Teacher teacherItem;

    /**
     * Creates new form TeacherAccountInfo
     */
    public TeacherAccountInfo() {
        
    }

    public TeacherAccountInfo(Teacher teacherItem) {
        this.teacherItem = teacherItem;
        initComponents();
        jbChangePassword.setContentAreaFilled(false);
        jbChangePhoneNumber.setContentAreaFilled(false);
        MessageBroker.getInstance().addListener(this);
        setInfomationToPanel();
    }

    private void setInfomationToPanel() {
        String hoten = teacherItem.getHotenGV();
        String maGV = teacherItem.getMaGV();
        String email = teacherItem.getEmailGV();
        String matkhau = teacherItem.getMatkhauGV();
        String sdt = teacherItem.getSdtGV();
        String ngaysinh = teacherItem.getNgsinhGV();
        String gioitinh = teacherItem.getGioitinhGV();
        String monhoc = teacherItem.getMamonhocGV();
        String lopchunhiem = teacherItem.getMalopchunghiemGV();

        jlbTeacherName.setText(hoten);
        jlbTeacherId.setText(maGV);
        jlbTeacherEmail.setText(email);
        jlbTeacherPassword.setText(matkhau);
        jlbTeacherPhoneNumber.setText(sdt);
        jlbTeacherDob.setText(ngaysinh);
        jlbTeacherSubject.setText(monhoc);
        jlbTeacherClass.setText(lopchunhiem);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpTeacherAccountInfo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jlbTeacherName = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jlbTeacherId = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jlbTeacherEmail = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jlbTeacherPassword = new javax.swing.JLabel();
        jbChangePassword = new javax.swing.JButton();
        jbChangePhoneNumber = new javax.swing.JButton();
        jlbTeacherPhoneNumber = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jlbTeacherDob = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jlbTeacherGender = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jlbTeacherSubject = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jlbTeacherClass = new javax.swing.JLabel();

        jpTeacherAccountInfo.setBackground(new java.awt.Color(255, 255, 255));
        jpTeacherAccountInfo.setForeground(new java.awt.Color(255, 255, 255));
        jpTeacherAccountInfo.setPreferredSize(new java.awt.Dimension(760, 540));
        jpTeacherAccountInfo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpTeacherAccountInfoMouseClicked(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Họ tên giáo viên");

        jlbTeacherName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jlbTeacherName.setForeground(new java.awt.Color(0, 0, 0));
        jlbTeacherName.setText("Trần Văn B");
        jlbTeacherName.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Mã giáo viên");

        jlbTeacherId.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jlbTeacherId.setForeground(new java.awt.Color(0, 0, 0));
        jlbTeacherId.setText("12345678");
        jlbTeacherId.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel5.setBackground(new java.awt.Color(0, 0, 0));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Email");

        jlbTeacherEmail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jlbTeacherEmail.setForeground(new java.awt.Color(0, 0, 0));
        jlbTeacherEmail.setText("12345678@edu.vn");
        jlbTeacherEmail.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel6.setBackground(new java.awt.Color(0, 0, 0));
        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Mật khẩu");

        jlbTeacherPassword.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jlbTeacherPassword.setForeground(new java.awt.Color(0, 0, 0));
        jlbTeacherPassword.setText("12345678");
        jlbTeacherPassword.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jbChangePassword.setBackground(new java.awt.Color(255, 255, 255));
        jbChangePassword.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jbChangePassword.setForeground(new java.awt.Color(0, 51, 204));
        jbChangePassword.setText("Đổi");
        jbChangePassword.setBorder(null);
        jbChangePassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbChangePasswordActionPerformed(evt);
            }
        });

        jbChangePhoneNumber.setBackground(new java.awt.Color(255, 255, 255));
        jbChangePhoneNumber.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jbChangePhoneNumber.setForeground(new java.awt.Color(0, 51, 204));
        jbChangePhoneNumber.setText("Đổi");
        jbChangePhoneNumber.setBorder(null);
        jbChangePhoneNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbChangePhoneNumberActionPerformed(evt);
            }
        });

        jlbTeacherPhoneNumber.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jlbTeacherPhoneNumber.setForeground(new java.awt.Color(0, 0, 0));
        jlbTeacherPhoneNumber.setText("1234567890");
        jlbTeacherPhoneNumber.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel7.setBackground(new java.awt.Color(0, 0, 0));
        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("SĐT");

        jlbTeacherDob.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jlbTeacherDob.setForeground(new java.awt.Color(0, 0, 0));
        jlbTeacherDob.setText("30/4/2023");
        jlbTeacherDob.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel8.setBackground(new java.awt.Color(0, 0, 0));
        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Ngày sinh");

        jLabel9.setBackground(new java.awt.Color(0, 0, 0));
        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Giới tính");

        jlbTeacherGender.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jlbTeacherGender.setForeground(new java.awt.Color(0, 0, 0));
        jlbTeacherGender.setText("Nam");
        jlbTeacherGender.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel10.setBackground(new java.awt.Color(0, 0, 0));
        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Môn học");

        jlbTeacherSubject.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jlbTeacherSubject.setForeground(new java.awt.Color(0, 0, 0));
        jlbTeacherSubject.setText("Tiếng Anh");
        jlbTeacherSubject.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel11.setBackground(new java.awt.Color(0, 0, 0));
        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Lớp chủ nhiệm");

        jlbTeacherClass.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jlbTeacherClass.setForeground(new java.awt.Color(0, 0, 0));
        jlbTeacherClass.setText("12A1");
        jlbTeacherClass.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jpTeacherAccountInfoLayout = new javax.swing.GroupLayout(jpTeacherAccountInfo);
        jpTeacherAccountInfo.setLayout(jpTeacherAccountInfoLayout);
        jpTeacherAccountInfoLayout.setHorizontalGroup(
            jpTeacherAccountInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpTeacherAccountInfoLayout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(jpTeacherAccountInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpTeacherAccountInfoLayout.createSequentialGroup()
                        .addComponent(jlbTeacherPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbChangePhoneNumber))
                    .addGroup(jpTeacherAccountInfoLayout.createSequentialGroup()
                        .addComponent(jlbTeacherPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbChangePassword))
                    .addComponent(jlbTeacherId, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlbTeacherEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlbTeacherName, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1)
                    .addGroup(jpTeacherAccountInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpTeacherAccountInfoLayout.createSequentialGroup()
                            .addComponent(jlbTeacherDob, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jlbTeacherGender, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpTeacherAccountInfoLayout.createSequentialGroup()
                            .addGroup(jpTeacherAccountInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jlbTeacherSubject, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel10)
                                .addComponent(jLabel8))
                            .addGroup(jpTeacherAccountInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jpTeacherAccountInfoLayout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(jpTeacherAccountInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel11)
                                        .addComponent(jlbTeacherClass, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jpTeacherAccountInfoLayout.createSequentialGroup()
                                    .addGap(12, 12, 12)
                                    .addComponent(jLabel9))))))
                .addContainerGap(424, Short.MAX_VALUE))
        );
        jpTeacherAccountInfoLayout.setVerticalGroup(
            jpTeacherAccountInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpTeacherAccountInfoLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlbTeacherName, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlbTeacherId, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlbTeacherEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpTeacherAccountInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbTeacherPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbChangePassword))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpTeacherAccountInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbChangePhoneNumber)
                    .addComponent(jlbTeacherPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jpTeacherAccountInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpTeacherAccountInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbTeacherDob, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlbTeacherGender, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpTeacherAccountInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpTeacherAccountInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbTeacherSubject, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlbTeacherClass, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(112, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpTeacherAccountInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpTeacherAccountInfo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 581, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jbChangePhoneNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbChangePhoneNumberActionPerformed
        ChangePhoneNumber changePhoneNumber = new ChangePhoneNumber(teacherItem.getMatkGV(), teacherItem.getSdtGV());
        changePhoneNumber.show();
        changePhoneNumber.setLocationRelativeTo(null);
        changePhoneNumber.requestFocusInWindow();
        
    }//GEN-LAST:event_jbChangePhoneNumberActionPerformed

    private void jbChangePasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbChangePasswordActionPerformed
        ChangePassword changePassword = new ChangePassword(teacherItem.getMatkGV(), teacherItem.getMatkhauGV());
        changePassword.setMessage("FROM_TEACHER_ACCOUNT_INFO");
        changePassword.show();
        changePassword.setLocationRelativeTo(null);
        changePassword.requestFocusInWindow();
    }//GEN-LAST:event_jbChangePasswordActionPerformed

    private void jpTeacherAccountInfoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpTeacherAccountInfoMouseClicked
       
    }//GEN-LAST:event_jpTeacherAccountInfoMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JButton jbChangePassword;
    private javax.swing.JButton jbChangePhoneNumber;
    private javax.swing.JLabel jlbTeacherClass;
    private javax.swing.JLabel jlbTeacherDob;
    private javax.swing.JLabel jlbTeacherEmail;
    private javax.swing.JLabel jlbTeacherGender;
    private javax.swing.JLabel jlbTeacherId;
    private javax.swing.JLabel jlbTeacherName;
    private javax.swing.JLabel jlbTeacherPassword;
    private javax.swing.JLabel jlbTeacherPhoneNumber;
    private javax.swing.JLabel jlbTeacherSubject;
    private javax.swing.JPanel jpTeacherAccountInfo;
    // End of variables declaration//GEN-END:variables

    @Override
    public void onMessageReceived(String message) {
        try {
            findInformationTeacher();
            updatePasswordAndPhoneNumber();
            System.out.println("Update Password and Phone Number");
        } catch (SQLException ex) {
            Logger.getLogger(TeacherAccountInfo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void findInformationTeacher() throws SQLException {
        java.sql.Connection connection = DBConnect.getConnection();
        //JOptionPane.showMessageDialog(this, "Xin chào giáo viên " + matkGV);

        String sql = "SELECT * FROM TAIKHOAN WHERE MATK = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, teacherItem.getMatkGV());

        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            teacherItem.setMatkhauGV(resultSet.getString("MATKHAU"));
        }
        
        sql = "SELECT * FROM GIAOVIEN WHERE MATK = ?";
        statement = connection.prepareStatement(sql);
        statement.setString(1, teacherItem.getMatkGV());
        resultSet = statement.executeQuery();
        if (resultSet.next()) {
            teacherItem.setSdtGV(resultSet.getString("SDT"));
        }      
      
        if(!statement.isClosed()) {
            statement.close();
            System.out.println("Close update Info");
        }
    }
    private void updatePasswordAndPhoneNumber() {
        jlbTeacherPassword.setText(teacherItem.getMatkhauGV());
        jlbTeacherPhoneNumber.setText(teacherItem.getSdtGV());
        //System.out.println("updated");
    }



}
