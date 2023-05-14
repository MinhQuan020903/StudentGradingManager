/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentgradingmanager.controller;

import Database.DBConnect;
import OOP.Teacher;
import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import studentgradingmanager.UI.teacher.jpanel.TeacherAccountInfo;
import studentgradingmanager.UI.teacher.jpanel.TeacherGradingManagement;
import studentgradingmanager.UI.teacher.jpanel.TeacherGradingManagementBasePanel;
import studentgradingmanager.UI.teacher.jpanel.TeacherGradingManagementNewSubjectPanel;
import studentgradingmanager.UI.teacher.jpanel.TeacherGradingManagementUpdateSubjectPanel;
import studentgradingmanager.UI.teacher.jpanel.TeacherSearch;
import studentgradingmanager.bean.Category;
import studentgradingmanager.utils.NavController;

/**
 *
 * @author Quan
 */
public class TeacherNavController extends NavController {

    private String emailGV;
    private String matkhauGV;
    private String matkGV;
    private String maGV;
    private String hotenGV;
    private String sdtGV;
    private String ngsinhGV;
    private String gioitinhGV;
    private String mamonhocGV;
    private String malopchunhiemGV;
    Teacher teacherItem;
    Teacher temp;

    public TeacherNavController(JPanel jpRoot, String emailGV, String matkhauGV, String matkGV) throws SQLException {
        super(jpRoot);
        this.emailGV = emailGV;
        this.matkGV = matkGV;
        this.matkhauGV = matkhauGV;
        findInformationTeacher();
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
        }

        sql = "SELECT * FROM GIANGDAY WHERE MAGV = ?";
        statement = connection.prepareStatement(sql);
        statement.setString(1, maGV);
        resultSet = statement.executeQuery();
        if (resultSet.next()) {
            this.mamonhocGV = resultSet.getString("MAMH");
            this.malopchunhiemGV = resultSet.getString("MALOP");
        }

        if (!statement.isClosed()) {
            statement.close();
            System.out.println("Closed to database findInformationTeacher!");
        }
    }

    @Override
    public void setView(JPanel jpItem, JLabel jlbItem) {
        typeSelected = "Thông tin tài khoản";
        setColorOnMousePressed(jpItem, jlbItem);

        String infor[] = {hotenGV, maGV, emailGV, matkhauGV, sdtGV, ngsinhGV, gioitinhGV, mamonhocGV, malopchunhiemGV};
        teacherItem = new Teacher(matkGV, matkhauGV, maGV, hotenGV, emailGV, sdtGV, ngsinhGV, gioitinhGV, mamonhocGV, malopchunhiemGV);

        root.removeAll();
        root.setLayout(new BorderLayout());

        root.add(new TeacherAccountInfo(teacherItem));
        root.validate();
        root.repaint();
    }

    @Override
    public void setEvent(ArrayList<Category> listCategory) {
        this.listCategory = listCategory;

        for (Category category : listCategory) {
            category.getJlb().addMouseListener(new TeacherNavController.LabelEvent(category.getType(), category.getJp(), category.getJlb()));
        }
    }

    class LabelEvent implements MouseListener {

        private JPanel node;
        private String type;
        private JPanel jpItem;
        private JLabel jlbItem;

        public LabelEvent(String type, JPanel jpItem, JLabel jlbItem) {
            this.type = type;
            this.jpItem = jpItem;
            this.jlbItem = jlbItem;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            switch (type) {
                case "Thông tin tài khoản": {
                    node = new TeacherAccountInfo(teacherItem);
                    System.out.println("Create new panel");
                    break;
                }

                case "Tra cứu kết quả học sinh": {
                    node = new TeacherSearch();
                    break;
                }
                case "Quản lý điểm lớp học": {
                    node = new TeacherGradingManagement();
                    break;
                }
                default: {
                    node = new TeacherAccountInfo();
                    break;
                }
            }
            root.removeAll();
            root.setLayout(new BorderLayout());
            root.add(node);
            root.validate();
            root.repaint();
            setColorOnItems(type);
        }

        @Override
        public void mousePressed(MouseEvent e) {
            typeSelected = type;
            setColorOnMousePressed(jpItem, jlbItem);
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            setColorOnMouseEntered(jpItem, jlbItem);
        }

        @Override
        public void mouseExited(MouseEvent e) {
            if (!typeSelected.equalsIgnoreCase(type)) {
                setColorOnMouseExited(jpItem, jlbItem);

            }
        }
    }
}
