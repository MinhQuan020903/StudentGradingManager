/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentgradingmanager.controller;

import Database.DBConnect;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;
import studentgradingmanager.UI.student.jpanel.StudentAccountInfo;
import studentgradingmanager.UI.student.jpanel.StudentGradeResult;
import studentgradingmanager.bean.Category;
import studentgradingmanager.utils.NavController;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 *
 * @author Quan
 */
public class StudentNavController extends NavController{
    
    private String hoTen;
    private String id;
    private String email;
    private String matKhau;
    private String maTK;
    private String sdt;
    private String ngaySinh;
    private String gioiTinh;
    private String khoi;
    private String lop;
    private String maLop;
    private ArrayList<String> monHocArray = new ArrayList<String>();
    private ArrayList<String> hocKyArray = new ArrayList<String>();
    private String[] namHocArray;
    private String[] maMH;
    public StudentNavController(JPanel jpRoot, String email, String password, String maTK) throws SQLException{
        super(jpRoot);
        this.email = email;
        this.matKhau = password; 
        this.maTK = maTK;
        findInformationStudent();
    }
    
    public void setView (JPanel jpItem, JLabel jlbItem) {
        typeSelected = "Thông tin tài khoản";
        setColorOnMousePressed(jpItem, jlbItem);
        
        //root.removeAll();
        root.setLayout(new BorderLayout());
        String[] info = {
            hoTen, id, email, matKhau, sdt, ngaySinh, gioiTinh, khoi, lop
        };
        
        
        root.add(new StudentAccountInfo(info));
        root.validate();
        root.repaint();
    }
    
    public void setEvent(ArrayList<Category> listCategory) {
        this.listCategory = listCategory;
        
        for (Category category : listCategory) {
            category.getJlb().addMouseListener(new LabelEvent(category.getType(), category.getJp(), category.getJlb()));
        }
    }

    private void findInformationStudent() throws SQLException {
        java.sql.Connection connection = DBConnect.getConnection();
        
        String sql = "SELECT * FROM HOCSINH WHERE MATK = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, maTK);
        
        ResultSet resultSet = statement.executeQuery();
            
       
        if (resultSet.next()) {
            // Lấy thông tin của giáo viên có MATK = matkGV
            this.hoTen = resultSet.getString("HOTEN");
            this.id = resultSet.getString("MAHS");
            this.sdt = resultSet.getString("SDT");
            this.ngaySinh = resultSet.getString("NGSINH").substring(0, 10);
            this.gioiTinh = resultSet.getString("GIOITINH");
            this.maLop = resultSet.getString("MALOP");
        }
        sql = "SELECT * FROM LOP WHERE MALOP = ?";
        statement = connection.prepareStatement(sql);
        statement.setString(1, maLop);
        resultSet = statement.executeQuery();
        if (resultSet.next()) {
            this.lop = resultSet.getString("TENLOP");
            this.khoi = resultSet.getString("KHOI");
        }
        
        sql = "SELECT * FROM DIEM WHERE MAHS = ?";
        statement = connection.prepareStatement(id);
        statement.setString(1, id);
        resultSet = statement.executeQuery();
        if (resultSet.next()) {
            
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
            switch(type) {
                case "Thông tin tài khoản" : {
                    String[] info = {hoTen, id, email, matKhau, sdt, ngaySinh, gioiTinh, khoi, lop};
                    node = new StudentAccountInfo(info);
                    break;
                }
                case "Kết quả học tập" : {
                    node = new StudentGradeResult();
                    break;
                }
                
                default : {
                    node = new StudentAccountInfo();
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
