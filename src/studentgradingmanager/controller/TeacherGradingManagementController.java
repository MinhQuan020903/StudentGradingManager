/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentgradingmanager.controller;

import java.awt.BorderLayout;
import studentgradingmanager.UI.teacher.jpanel.TeacherGradingManagement;
import studentgradingmanager.UI.teacher.jpanel.TeacherGradingManagementBasePanel;
import studentgradingmanager.UI.teacher.jpanel.TeacherGradingManagementUpdateSubjectPanel;
import studentgradingmanager.UI.teacher.jpanel.TeacherGradingManagementNewSubjectPanel;

/**
 *
 * @author Quan
 */
public class TeacherGradingManagementController {
    
    private TeacherGradingManagement teacherGradingManagement;
    private TeacherGradingManagementBasePanel teacherGradingManagementBasePanel;
    private TeacherGradingManagementNewSubjectPanel teacherGradingManagementNewSubjectPanel;
    private TeacherGradingManagementUpdateSubjectPanel teacherGradingManagementUpdateSubjectPanel;

    public TeacherGradingManagementController(TeacherGradingManagement tgm) {
        
        teacherGradingManagement = tgm;
        teacherGradingManagementBasePanel = new TeacherGradingManagementBasePanel();
        teacherGradingManagementNewSubjectPanel = new TeacherGradingManagementNewSubjectPanel();
        teacherGradingManagementUpdateSubjectPanel = new TeacherGradingManagementUpdateSubjectPanel();
        
        // Add action listener to the "Cập nhật điểm" button in the BasePanel
        teacherGradingManagementBasePanel.getJbUpdateSubject().addActionListener(e -> {
            // Replace the BasePanel with UpdateSubjectPanel
            teacherGradingManagement.remove(teacherGradingManagementBasePanel);
            teacherGradingManagement.add(teacherGradingManagementUpdateSubjectPanel, BorderLayout.CENTER);
            teacherGradingManagement.revalidate();
            teacherGradingManagement.repaint();
        });
        
        // Add action listener to the "Thêm môn mới" button in the BasePanel
        teacherGradingManagementBasePanel.getJbNewSubject().addActionListener(e -> {
            // Replace the BasePanel with NewSubjectPanel
            teacherGradingManagement.remove(teacherGradingManagementBasePanel);
            teacherGradingManagement.add(teacherGradingManagementNewSubjectPanel, BorderLayout.CENTER);
            teacherGradingManagement.revalidate();
            teacherGradingManagement.repaint();
        });
        
        
        // Add action listener to the "Back" button in the UpdateSubjectPanel
            teacherGradingManagementUpdateSubjectPanel.getJbBack().addActionListener(e -> {
            // Replace the UpdateSubjectPanel with BasePanel
            teacherGradingManagement.remove(teacherGradingManagementUpdateSubjectPanel);
            teacherGradingManagement.add(teacherGradingManagementBasePanel, BorderLayout.CENTER);
            teacherGradingManagement.revalidate();
            teacherGradingManagement.repaint();
        });
            
        // Add action listener to the "Back" button in the NewSubjectPanel
            teacherGradingManagementNewSubjectPanel.getJbBack().addActionListener(e -> {
            // Replace the UpdateSubjectPanel with BasePanel
            teacherGradingManagement.remove(teacherGradingManagementNewSubjectPanel);
            teacherGradingManagement.add(teacherGradingManagementBasePanel, BorderLayout.CENTER);
            teacherGradingManagement.revalidate();
            teacherGradingManagement.repaint();
        });

        // Set the TeacherSearchBasePanel as the initial panel
        teacherGradingManagement.add(teacherGradingManagementBasePanel, BorderLayout.CENTER);
        
    }
}
