/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentgradingmanager.bean;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Quan
 */
public class Category {
    private String type;
    private JPanel jp;
    private JLabel jlb;

    public Category() {
    }

    
    public Category(String type, JPanel jp, JLabel jlb) {
        this.type = type;
        this.jp = jp;
        this.jlb = jlb;
    }

    
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public JPanel getJp() {
        return jp;
    }

    public void setJp(JPanel jp) {
        this.jp = jp;
    }

    public JLabel getJlb() {
        return jlb;
    }

    public void setJlb(JLabel jlb) {
        this.jlb = jlb;
    }
    
        
            
}
