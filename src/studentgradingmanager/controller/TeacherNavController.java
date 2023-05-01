/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentgradingmanager.controller;

import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JLabel;
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
public class TeacherNavController extends NavController{

    public TeacherNavController(JPanel jpRoot) {
        super(jpRoot);
    }

    @Override
    public void setView(JPanel jpItem, JLabel jlbItem) {
        typeSelected = "Thông tin tài khoản";
        setColorOnMousePressed(jpItem, jlbItem);
        
        root.removeAll();
        root.setLayout(new BorderLayout());
        
        root.add(new TeacherAccountInfo());
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
                switch(type) {
                    case "Thông tin tài khoản" : {
                        node = new TeacherAccountInfo();
                        break;
                    }
                    case "Tra cứu kết quả học sinh" : {
                        node = new TeacherSearch();
                        break;
                    }
                    case "Quản lý điểm lớp học" : {
                        node = new TeacherGradingManagement();
                        break;
                    }
                    default : {
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
