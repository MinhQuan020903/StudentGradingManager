/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentgradingmanager.controller;

import OOP.StudentBase;
import OOP.Teacher;
import TransferData.MessageBroker;
import TransferData.MessageListener;
import java.awt.BorderLayout;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import studentgradingmanager.UI.teacher.jpanel.TeacherSearch;
import studentgradingmanager.UI.teacher.jpanel.TeacherSearchBasePanel;
import studentgradingmanager.UI.teacher.jpanel.TeacherSearchResultPanel;

/**
 *
 * @author Quan
 */
public class TeacherSearchController {

    private TeacherSearch teacherSearch;
    private TeacherSearchBasePanel teacherSearchBasePanel;
    private TeacherSearchResultPanel teacherSearchResultPanel;
    private Teacher teacherItem;

    public TeacherSearchController(TeacherSearch ts, Teacher teacherItem) {
        this.teacherItem = teacherItem;
        teacherSearch = ts;
        teacherSearchBasePanel = new TeacherSearchBasePanel(teacherItem);
        teacherSearchResultPanel = new TeacherSearchResultPanel();

        // Add action listener to the JTable in the TeacherSearchBasePanel
        teacherSearchBasePanel.getJtStudents().getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int selectedRow = teacherSearchBasePanel.getJtStudents().getSelectedRow();
                if (selectedRow != -1) {
                    // Get the selected row data

                    Object[] rowData = ((DefaultTableModel) teacherSearchBasePanel.getJtStudents().getModel()).getDataVector().elementAt(selectedRow).toArray();
                    JTable table = teacherSearchBasePanel.getJtStudents();
                    StudentBase studentBase = new StudentBase(table.getValueAt(selectedRow, 1).toString(),
                             table.getValueAt(selectedRow, 2).toString(),
                             table.getValueAt(selectedRow, 3).toString(),
                             null,
                             null,
                             null,
                             null);
                    TeacherSearchResultPanel temp = new TeacherSearchResultPanel(studentBase);
                    //teacherSearchResultPanel = new TeacherSearchResultPanel();
                    teacherSearchResultPanel = temp;
                    // Replace the TeacherSearchBasePanel with TeacherSearchResultPanel
                    teacherSearch.remove(teacherSearchBasePanel);
                    teacherSearch.add(teacherSearchResultPanel, BorderLayout.CENTER);
                    teacherSearch.revalidate();
                    teacherSearch.repaint();
                }
            }
        });

        // Add action listener to the Back button in the TeacherSearchResultPanel
        teacherSearchResultPanel.getJbBack().addActionListener(e -> {
            // Replace the TeacherSearchResultPanel with TeacherSearchBasePanel
            teacherSearch.remove(teacherSearchResultPanel);
            teacherSearch.add(teacherSearchBasePanel, BorderLayout.CENTER);
            teacherSearch.revalidate();
            teacherSearch.repaint();
            System.out.println("Click");
        });

        // Set the TeacherSearchBasePanel as the initial panel
        teacherSearch.add(teacherSearchBasePanel, BorderLayout.CENTER);
    }

}
