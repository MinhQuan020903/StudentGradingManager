/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentgradingmanager.utils;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;
import studentgradingmanager.bean.Category;

/**
 *
 * @author Quan
 */
public abstract class NavController {
    protected JPanel root;
    protected String typeSelected = "";
    
    protected ArrayList<Category> listCategory = null;
    
    public NavController(JPanel jpRoot) {
        this.root = jpRoot;
    }
    
    public abstract void setView (JPanel jpItem, JLabel jlbItem);
//    {
//        typeSelected = "Thông tin tài khoản";
//        setColorOnMousePressed(jpItem, jlbItem);
//        
//        //root.removeAll();
//        root.setLayout(new BorderLayout());
//        
//        root.add(new StudentAccountInfo());
//        root.validate();
//        root.repaint();
//    }
    
    public abstract void setEvent(ArrayList<Category> listCategory);

    public void setColorOnMouseExited(JPanel jpItem, JLabel jlbItem) {
        jpItem.setBackground(new Color(111, 142, 222));
        jlbItem.setBackground(new Color(111, 142, 222));
    }
    
    public void setColorOnMousePressed(JPanel jpItem, JLabel jlbItem) {
        jpItem.setBackground(new Color(81, 102, 159));
        jlbItem.setBackground(new Color(81, 102, 159));
    }
    
    public void setColorOnMouseEntered(JPanel jpItem, JLabel jlbItem) {
        jpItem.setBackground(new Color(0, 154, 255));
        jlbItem.setBackground(new Color(0, 154, 255));
    }
    
    public void setColorOnItems(String type) {
        for (Category category : listCategory) {
            if (!typeSelected.equalsIgnoreCase(category.getType())) {
                setColorOnMouseExited(category.getJp(), category.getJlb());
            } else {
                setColorOnMousePressed(category.getJp(), category.getJlb());
            }
        }
    }
}
