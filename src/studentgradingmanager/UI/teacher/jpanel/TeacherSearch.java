/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package studentgradingmanager.UI.teacher.jpanel;

import OOP.Teacher;
import TransferData.MessageListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import Database.DBConnect;
import OOP.StudentBase;
import OOP.Teacher;
import TransferData.MessageBroker;
import java.awt.BorderLayout;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.accessibility.AccessibleContext;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.EventListenerList;
import javax.swing.plaf.ComponentUI;
import javax.swing.table.DefaultTableModel;
import studentgradingmanager.UI.frame.ChangePassword;

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
public class TeacherSearch extends javax.swing.JPanel {

    private Teacher teacherItem;
    private List<StudentBase> listStudent = new ArrayList<>();
    private List<StudentBase> searchList;

    /**
     * Creates new form TeacherSearch
     */
    public TeacherSearch(Teacher teacherItem) {
        initComponents();
        this.teacherItem = teacherItem;

        importDataToStudent();

    }

    private void importDataToStudent() {
        try {
            DefaultTableModel model = (DefaultTableModel) jtStudents.getModel();
            int i = 0;

            List<String> listClass = new ArrayList<>();

            java.sql.Connection connection = DBConnect.getConnection();
            //JOptionPane.showMessageDialog(this, "Xin chào giáo viên " + matkGV);

            //String sql = "SELECT * FROM GIANGDAY WHERE MAGV = ?";
            String sql = "select DISTINCT HOCSINH.MAHS, HOCSINH.HOTEN as TENHS, HOCSINH.MALOP, GIAOVIEN.HOTEN AS TENGV\n"
                    + "from HOCSINH, DIEM, GIAOVIEN, LOP\n"
                    + "WHERE LOP.MAGVCN = GIAOVIEN.MAGV \n"
                    + "AND HOCSINH.MALOP = LOP.MALOP\n"
                    + "AND HOCSINH.MAHS = DIEM.MAHS\n"
                    + "AND GIAOVIEN.MAGV = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, teacherItem.getMaGV());

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
//                if (!listClass.contains(resultSet.getString("MALOP"))) {
//                    listClass.add(resultSet.getString("MALOP"));
//                    System.out.println(listClass);
//                }
                listStudent.add(new StudentBase(resultSet.getString("MAHS"),
                        resultSet.getString("TENHS"),
                        resultSet.getString("MALOP"),
                        null,
                        null,
                        null,
                        resultSet.getString("TENGV")));
            }

//            for (String item : listClass) {
//                sql = "SELECT * FROM HOCSINH WHERE MALOP = ?";
//                statement = connection.prepareStatement(sql);
//                statement.setString(1, item);
//                resultSet = statement.executeQuery();
//                System.out.println(item);
//
//                while (resultSet.next()) {
//                    if (resultSet.getString("MALOP").equals(item)) {
//                        listStudent.add(new StudentBase(resultSet.getString("MAHS"),
//                                resultSet.getString("HOTEN"),
//                                resultSet.getString("MALOP"),
//                                resultSet.getString("SDT"),
//                                resultSet.getString("NGSINH"),
//                                resultSet.getString("GIOITINH"),
//                                resultSet.getString("MATK")));
//                    }
//
//                }
//            }

            if (!statement.isClosed()) {
                statement.close();
                System.out.println("Closed to database import data student!");
            }

        } catch (SQLException ex) {
            Logger.getLogger(TeacherSearch.class.getName()).log(Level.SEVERE, null, ex);
        }

        DefaultTableModel model = (DefaultTableModel) jtStudents.getModel();

        for (int i = 0; i < listStudent.size(); i++) {
            String[] stu = {String.valueOf(i), listStudent.get(i).getMAHS(), listStudent.get(i).getHOTEN(), listStudent.get(i).getMALOP(), listStudent.get(i).getMATK()};
            model.addRow(stu);
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

        jpTeacherSearch = new javax.swing.JPanel();
        jpTeacherSearchBase = new javax.swing.JPanel();
        jtfSearchForStudent = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jbSearch = new javax.swing.JButton();
        jScrollPane = new javax.swing.JScrollPane();
        jtStudents = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();

        jpTeacherSearch.setBackground(new java.awt.Color(255, 255, 255));
        jpTeacherSearch.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jpTeacherSearchLayout = new javax.swing.GroupLayout(jpTeacherSearch);
        jpTeacherSearch.setLayout(jpTeacherSearchLayout);
        jpTeacherSearchLayout.setHorizontalGroup(
            jpTeacherSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 760, Short.MAX_VALUE)
        );
        jpTeacherSearchLayout.setVerticalGroup(
            jpTeacherSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 540, Short.MAX_VALUE)
        );

        setBackground(new java.awt.Color(255, 255, 255));
        setForeground(new java.awt.Color(255, 255, 255));
        setLayout(new java.awt.BorderLayout());

        jpTeacherSearchBase.setBackground(new java.awt.Color(255, 255, 255));
        jpTeacherSearchBase.setForeground(new java.awt.Color(255, 255, 255));
        jpTeacherSearchBase.setPreferredSize(new java.awt.Dimension(785, 540));

        jtfSearchForStudent.setBackground(new java.awt.Color(217, 217, 217));
        jtfSearchForStudent.setForeground(new java.awt.Color(153, 153, 153));
        jtfSearchForStudent.setText("Nhập tên / mã học sinh cần tìm");
        jtfSearchForStudent.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jtfSearchForStudent.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtfSearchForStudentMouseClicked(evt);
            }
        });
        jtfSearchForStudent.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfSearchForStudentKeyReleased(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/studentgradingmanager/images/icon-search-16.png"))); // NOI18N

        jbSearch.setBackground(new java.awt.Color(169, 186, 247));
        jbSearch.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jbSearch.setForeground(new java.awt.Color(255, 255, 255));
        jbSearch.setText("Tìm kiếm");
        jbSearch.setBorder(null);
        jbSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSearchActionPerformed(evt);
            }
        });

        jScrollPane.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane.setForeground(new java.awt.Color(255, 255, 255));
        jScrollPane.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPaneMouseClicked(evt);
            }
        });

        jtStudents.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã học sinh", "Tên học sinh", "Lớp", "GVCN"
            }
        ));
        jtStudents.setGridColor(new java.awt.Color(0, 0, 0));
        jtStudents.setShowGrid(true);
        jtStudents.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtStudentsMouseClicked(evt);
            }
        });
        jScrollPane.setViewportView(jtStudents);

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setText("Bấm vào học sinh để xem thông tin ");

        javax.swing.GroupLayout jpTeacherSearchBaseLayout = new javax.swing.GroupLayout(jpTeacherSearchBase);
        jpTeacherSearchBase.setLayout(jpTeacherSearchBaseLayout);
        jpTeacherSearchBaseLayout.setHorizontalGroup(
            jpTeacherSearchBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpTeacherSearchBaseLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jpTeacherSearchBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 680, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpTeacherSearchBaseLayout.createSequentialGroup()
                        .addComponent(jtfSearchForStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addGap(108, 108, 108)
                        .addComponent(jbSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        jpTeacherSearchBaseLayout.setVerticalGroup(
            jpTeacherSearchBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpTeacherSearchBaseLayout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addGroup(jpTeacherSearchBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpTeacherSearchBaseLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(52, 52, 52))
                    .addGroup(jpTeacherSearchBaseLayout.createSequentialGroup()
                        .addGroup(jpTeacherSearchBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jbSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfSearchForStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(92, 92, 92))
        );

        add(jpTeacherSearchBase, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void jtfSearchForStudentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtfSearchForStudentMouseClicked
        if (jtfSearchForStudent.getText().equals("Nhập tên / mã học sinh cần tìm")) {
            jtfSearchForStudent.setText("");
        }
    }//GEN-LAST:event_jtfSearchForStudentMouseClicked

    private void jtfSearchForStudentKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfSearchForStudentKeyReleased
        // TODO add your handling code here:
        String searchString = jtfSearchForStudent.getText().trim();
        // Thực hiện các hành động tương ứng khi người dùng gõ phím

        if (searchString.equals("Nhập tên / mã học sinh cần tìm") || searchString.isEmpty()) {
            searchList = listStudent;
            //System.out.println("Vo day");
        } else {
            searchList = new ArrayList<>(); // Gán lại giá trị cho searchList trước khi tìm kiếm mới

            for (int i = 0; i < listStudent.size(); i++) {
                if (listStudent.get(i).getMAHS().toLowerCase().contains(searchString.toLowerCase())
                        || listStudent.get(i).getHOTEN().toLowerCase().contains(searchString.toLowerCase())) {
                    //System.out.println("Them Phan Tu");
                    searchList.add(listStudent.get(i));
                } else {
                    //System.out.println("Ra khoi if");
                }
            }
            // System.out.println("Click");
        }

        DefaultTableModel model = (DefaultTableModel) jtStudents.getModel();

        // Xóa bỏ các dòng hiện có trong JTable
        model.setRowCount(0);

        // Thêm dữ liệu mới vào JTable
        for (int i = 0; i < searchList.size(); i++) {
            String[] stu = {String.valueOf(i),
                searchList.get(i).getMAHS(),
                searchList.get(i).getHOTEN(),
                searchList.get(i).getMALOP(),
                teacherItem.getHotenGV()};
            model.addRow(stu);
        }

        // Cập nhật lại giao diện JTable
        jtStudents.revalidate();
        jtStudents.repaint();

        //System.out.println(searchList.size());
    }//GEN-LAST:event_jtfSearchForStudentKeyReleased

    private void jbSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSearchActionPerformed
        // TODO add your handling code here:
//        String searchString = jtfSearchForStudent.getText().trim();
//
//        if (searchString.equals("Nhập tên / mã học sinh cần tìm") || searchString.isEmpty()) {
//            searchList = listStudent;
//            //System.out.println("Vo day");
//        } else {
//            searchList = new ArrayList<>(); // Gán lại giá trị cho searchList trước khi tìm kiếm mới
//
//            for (int i = 0; i < listStudent.size(); i++) {
//                if (listStudent.get(i).getMAHS().toLowerCase().contains(searchString.toLowerCase())
//                    || listStudent.get(i).getHOTEN().toLowerCase().contains(searchString.toLowerCase())) {
//                    //System.out.println("Them Phan Tu");
//                    searchList.add(listStudent.get(i));
//                } else {
//                    //System.out.println("Ra khoi if");
//                }
//            }
//            //System.out.println("Click");
//        }
//
//        DefaultTableModel model = (DefaultTableModel) jtStudents.getModel();
//
//        // Xóa bỏ các dòng hiện có trong JTable
//        model.setRowCount(0);
//
//        // Thêm dữ liệu mới vào JTable
//        for (int i = 0; i < searchList.size(); i++) {
//            String[] stu = {String.valueOf(i),
//                searchList.get(i).getMAHS(),
//                searchList.get(i).getHOTEN(),
//                searchList.get(i).getMALOP(),
//                teacherItem.getHotenGV()};
//            model.addRow(stu);
//        }
//
//        // Cập nhật lại giao diện JTable
//        jtStudents.revalidate();
//        jtStudents.repaint();

        //System.out.println(searchList.size());
    }//GEN-LAST:event_jbSearchActionPerformed

    private void jtStudentsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtStudentsMouseClicked
        int selectedRow = jtStudents.rowAtPoint(evt.getPoint());
        int selectedColumn = jtStudents.columnAtPoint(evt.getPoint());

        if (selectedRow != -1) {
            // Get the selected row data

            JTable table = jtStudents;
            StudentBase studentBase = new StudentBase(table.getValueAt(selectedRow, 1).toString(),
                    table.getValueAt(selectedRow, 2).toString(),
                    table.getValueAt(selectedRow, 3).toString(),
                    null,
                    null,
                    null,
                    null);
            TeacherSearchResultFrame frame = new TeacherSearchResultFrame(studentBase);
            frame.show();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
            frame.requestFocusInWindow();

        }


    }//GEN-LAST:event_jtStudentsMouseClicked

    private void jScrollPaneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPaneMouseClicked
//        // TODO add your handling code here:
//        int row = jtStudents.rowAtPoint(evt.getPoint());
//        int column = jtStudents.columnAtPoint(evt.getPoint());
//        System.out.println(row + " " + column);
//        MessageBroker.getInstance().sendMessage("Click " + row);
    }//GEN-LAST:event_jScrollPaneMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JButton jbSearch;
    private javax.swing.JPanel jpTeacherSearch;
    private javax.swing.JPanel jpTeacherSearchBase;
    private javax.swing.JTable jtStudents;
    private javax.swing.JTextField jtfSearchForStudent;
    // End of variables declaration//GEN-END:variables

}
