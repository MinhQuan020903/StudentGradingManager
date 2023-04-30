/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentgradingmanager.controller;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;
import studentgradingmanager.UI.student.jpanel.StudentAccountInfo;
import studentgradingmanager.UI.student.jpanel.StudentGradeResult;
import studentgradingmanager.bean.Category;
import studentgradingmanager.utils.NavController;

/**
 *
 * @author Quan
 */
public class StudentNavController extends NavController{

    public StudentNavController(JPanel jpRoot) {
        super(jpRoot);
    }
    
    public void setView (JPanel jpItem, JLabel jlbItem) {
        typeSelected = "Thông tin tài khoản";
        setColorOnMousePressed(jpItem, jlbItem);
        
        //root.removeAll();
        root.setLayout(new BorderLayout());
        
        root.add(new StudentAccountInfo());
        root.validate();
        root.repaint();
    }
    
    public void setEvent(ArrayList<Category> listCategory) {
        this.listCategory = listCategory;
        
        for (Category category : listCategory) {
            category.getJlb().addMouseListener(new LabelEvent(category.getType(), category.getJp(), category.getJlb()));
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
                    node = new StudentAccountInfo();
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
