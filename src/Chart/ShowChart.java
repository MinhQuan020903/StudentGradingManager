/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Chart;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.jfree.chart.ChartPanel;
import studentgradingmanager.utils.BarChart;

/**
 *
 * @author quocd
 */
public class ShowChart extends javax.swing.JFrame {

    private BarChart bcGradeStatisticChart;
    private List<String> listData;
    private String tenMH;

    /**
     * Creates new form ShowChart
     */
    public ShowChart(String tenMH, List<String> listData) {
        initComponents();
        this.listData = listData;
        this.tenMH = tenMH;

        jpnChart.setLayout(new BorderLayout());
        bcGradeStatisticChart = new BarChart("Thống kê môn " + tenMH);
        bcGradeStatisticChart.addData(Integer.valueOf(listData.get(0)), "Điểm từ 0 - 5");
        bcGradeStatisticChart.addData(Integer.valueOf(listData.get(1)), "Điểm từ 5 - 7");
        bcGradeStatisticChart.addData(Integer.valueOf(listData.get(2)), "Điểm từ 7 - 59");
        bcGradeStatisticChart.addData(Integer.valueOf(listData.get(3)), "Điểm từ 9 - 10");
        jpnChart.add(bcGradeStatisticChart, BorderLayout.CENTER);
        
        
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
         this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpnChart = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jpnChartLayout = new javax.swing.GroupLayout(jpnChart);
        jpnChart.setLayout(jpnChartLayout);
        jpnChartLayout.setHorizontalGroup(
            jpnChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 730, Short.MAX_VALUE)
        );
        jpnChartLayout.setVerticalGroup(
            jpnChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 415, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnChart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnChart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jpnChart;
    // End of variables declaration//GEN-END:variables
}
