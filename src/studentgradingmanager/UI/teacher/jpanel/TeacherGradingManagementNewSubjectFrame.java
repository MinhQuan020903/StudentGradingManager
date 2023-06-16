/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package studentgradingmanager.UI.teacher.jpanel;

import Database.DBConnect;
import OOP.StudentBase;
import TransferData.MessageBroker;
import java.awt.Dimension;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Quan
 */
public class TeacherGradingManagementNewSubjectFrame extends javax.swing.JFrame {

    private StudentBase studentBase;
    private List<String> listMAHK;
    private List<String> listNAMHOC;

    public TeacherGradingManagementNewSubjectFrame() {

        mirrorData();
        findSemester();
    }

    public TeacherGradingManagementNewSubjectFrame(StudentBase studentBase) {
        initComponents();
        setTitle("THÊM MÔN HỌC MỚI");
        this.studentBase = studentBase;
        mirrorData();
        findSemester();
    }

    private void mirrorData() {
        jlbAddSubjectFor.setText("Thêm môn học cho học sinh " + studentBase.getHOTEN());
        jlbAddSubjectFor.setPreferredSize(new Dimension(0, 0));

    }

    private void findSemester() {
        listMAHK = new ArrayList<>();
        // tim MAHK
        try {
            java.sql.Connection connection = DBConnect.getConnection();
            //JOptionPane.showMessageDialog(this, "Xin chào giáo viên " + matkGV);

            String sql = "SELECT * FROM HOCKYNAMHOC";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                listMAHK.add(resultSet.getString("MAHK"));
            }
            if (!statement.isClosed()) {
                statement.close();
                System.out.println("Close SEARCH MAHK");
            }
        } catch (SQLException ex) {
            Logger.getLogger(TeacherSearchResultFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

        // add data vao jComboBox
        listNAMHOC = new ArrayList<>();
        try {
            java.sql.Connection connection = DBConnect.getConnection();
            //JOptionPane.showMessageDialog(this, "Xin chào giáo viên " + matkGV);

            String sql = "SELECT * FROM HOCKYNAMHOC";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            boolean isPresent = false;
            while (resultSet.next()) {
                if (listNAMHOC.size() != 0) {
                    for (int i = 0; i < listNAMHOC.size(); i++) {
                        if (listNAMHOC.get(i).equals(resultSet.getString("NAMHOC"))) {
                            isPresent = true;
                            //System.out.println("Kiem tra");
                            break;
                        }
                    }
                    if (!isPresent) {
                        listNAMHOC.add(resultSet.getString("NAMHOC"));
                        //System.out.println("Kiem tra 1");
                        isPresent = false;
                    }
                } else {
                    listNAMHOC.add(resultSet.getString("NAMHOC"));
                    ///System.out.println("Kiem tra 2");
                }

            }
            if (!statement.isClosed()) {
                statement.close();
                System.out.println("Close SEARCH NAMHOC");
            }
            jcbSemester.addItem("1");
            jcbSemester.addItem("2");

            for (String item : listNAMHOC) {
                if (listNAMHOC == null) {
                    break;
                } else {
                    jcbYear.addItem(item);
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(TeacherSearchResultFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private boolean checkNumber(String input) {
        if (input.matches("-?\\d+")) {
            System.out.println("Giá trị nhập vào là số nguyên.");
            return true;
        } else {
            System.out.println("Giá trị nhập vào không phải là số nguyên.");
            return false;
        }
    }

    private void updateDB() {
        System.err.println("Chay upate");
        if (jtfNewSubjectName.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vui Lòng Điền Tên Môn Học");
        } else {
            try {
                if (checkNumber(jtfNewSubjectProgressGrade.getText().trim())) {
                    if (checkNumber(jtfNewSubjectMidTermGrade.getText().trim())) {
                        if (checkNumber(jtfNewSubjectFinalTermScore.getText().trim())) {
                            String fullMon = jtfNewSubjectName.getText().toString().trim();
                            String[] tachTungTu = fullMon.split(" ");
                            if(tachTungTu.length > 2) {
                                JOptionPane.showMessageDialog(this, "Tên môn học quá dài");
                            } else {
                                String maMHNew = "";
                            for (String item : tachTungTu) {
                                maMHNew += item.substring(0, 1).toUpperCase();
                            }
                            maMHNew += studentBase.getMALOP().substring(1, 2);
                            System.err.println(maMHNew);

                            java.sql.Connection connection = DBConnect.getConnection();
                            //JOptionPane.showMessageDialog(this, "Xin chào giáo viên " + matkGV);

                            String checkSql = "SELECT MAMH FROM MONHOC WHERE MAMH = ?";
                            PreparedStatement checkStatement = connection.prepareStatement(checkSql);
                            checkStatement.setString(1, maMHNew);
                            ResultSet _resultSet = checkStatement.executeQuery();

                            if (_resultSet.next()) {
                                JOptionPane.showMessageDialog(null, maMHNew + " Đã tồn tại không thể thêm mới môn này!");
                            } else {
                                // them mon hoc moi
                                String sql = "INSERT INTO MONHOC VALUES (?, ?)";
                                PreparedStatement statement = connection.prepareStatement(sql);
                                statement.setString(1, maMHNew);
                                statement.setString(2, fullMon.toUpperCase());

                                int rowsInserted = statement.executeUpdate();

                                if (rowsInserted > 0) {
                                    System.out.println("Dữ liệu môn học đã được thêm thành công vào cơ sở dữ liệu.");
                                }

                                sql = "INSERT INTO DIEM VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
                                statement = connection.prepareCall(sql);

                                String ghichu = jtfNewSubjectNote.getText().toString().trim();
                                String mahk;
                                if (jcbSemester.getSelectedItem().equals("1")) {
                                    mahk = "HK01";
                                } else {
                                    mahk = "HK02";
                                }

                                String namhoc = jcbYear.getSelectedItem().toString();

                                String diemQT = !jtfNewSubjectProgressGrade.getText().toString().trim().isEmpty() ? jtfNewSubjectProgressGrade.getText().toString().trim() : "";

                                String diemGk = !jtfNewSubjectMidTermGrade.getText().toString().trim().isEmpty() ? jtfNewSubjectMidTermGrade.getText().toString().toString().trim() : "";

                                String diemCK = !jtfNewSubjectFinalTermScore.getText().toString().trim().isEmpty() ? jtfNewSubjectFinalTermScore.getText().toString().toString().trim() : "";

                                String diemTBHK = !diemQT.equals("") || !diemGk.equals("") || !diemCK.equals("")
                                        ? String.valueOf((Double.valueOf(diemGk) + Double.valueOf(diemQT) + Double.valueOf(diemCK)) / 3) : "";

                                System.err.println(jtfNewSubjectProgressGrade.getText().toString().trim());

                                statement.setString(1, maMHNew);
                                statement.setString(2, studentBase.getMAHS());
                                statement.setString(3, diemQT);
                                statement.setString(4, diemGk);
                                statement.setString(5, diemCK);
                                statement.setString(6, diemTBHK);
                                statement.setString(7, ghichu);
                                statement.setString(8, mahk);

                                rowsInserted = statement.executeUpdate();

                                if (rowsInserted > 0) {
                                    System.err.println("Thêm Điểm Và Môn Học Thành Công");
                                }
                                System.err.println(maMHNew + " " + studentBase.getMAHS() + " " + diemQT + " " + diemGk + " " + diemCK + " " + diemTBHK + " " + ghichu + " " + mahk);
                                statement.close();
                            }

                            checkStatement.close();
                            connection.close();
                            }
                                 
                            
                        } else {
                            JOptionPane.showMessageDialog(null, "Điểm Cuối Kì Phải Là Số");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Điểm Giữa Kì Phải Là Số");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Điểm Quá Trình Phải Là Số");
                }

            } catch (SQLException ex) {
                Logger.getLogger(TeacherGradingManagementNewSubjectFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * Creates new form NewJFrame
     */
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpTeacherGradingManagementNewSubjectPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jtfNewSubjectName = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jtfNewSubjectNote = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jtfNewSubjectProgressGrade = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jtfNewSubjectMidTermGrade = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jtfNewSubjectFinalTermScore = new javax.swing.JTextField();
        jbSaveNewSubject = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jlbAddSubjectFor = new javax.swing.JLabel();
        jbExit = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jcbSemester = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jcbYear = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jpTeacherGradingManagementNewSubjectPanel.setBackground(new java.awt.Color(255, 255, 255));
        jpTeacherGradingManagementNewSubjectPanel.setForeground(new java.awt.Color(255, 255, 255));
        jpTeacherGradingManagementNewSubjectPanel.setPreferredSize(new java.awt.Dimension(960, 540));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Tên môn học:");

        jtfNewSubjectName.setBackground(new java.awt.Color(217, 217, 217));
        jtfNewSubjectName.setForeground(new java.awt.Color(153, 153, 153));
        jtfNewSubjectName.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jtfNewSubjectName.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtfNewSubjectNameMouseClicked(evt);
            }
        });
        jtfNewSubjectName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfNewSubjectNameActionPerformed(evt);
            }
        });

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Ghi chú (nếu có):");

        jtfNewSubjectNote.setBackground(new java.awt.Color(217, 217, 217));
        jtfNewSubjectNote.setForeground(new java.awt.Color(153, 153, 153));
        jtfNewSubjectNote.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jtfNewSubjectNote.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtfNewSubjectNoteMouseClicked(evt);
            }
        });
        jtfNewSubjectNote.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfNewSubjectNoteActionPerformed(evt);
            }
        });

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Điểm QT");

        jtfNewSubjectProgressGrade.setBackground(new java.awt.Color(217, 217, 217));
        jtfNewSubjectProgressGrade.setForeground(new java.awt.Color(153, 153, 153));
        jtfNewSubjectProgressGrade.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jtfNewSubjectProgressGrade.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtfNewSubjectProgressGradeMouseClicked(evt);
            }
        });
        jtfNewSubjectProgressGrade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfNewSubjectProgressGradeActionPerformed(evt);
            }
        });

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Điểm GK");

        jtfNewSubjectMidTermGrade.setBackground(new java.awt.Color(217, 217, 217));
        jtfNewSubjectMidTermGrade.setForeground(new java.awt.Color(153, 153, 153));
        jtfNewSubjectMidTermGrade.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jtfNewSubjectMidTermGrade.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtfNewSubjectMidTermGradeMouseClicked(evt);
            }
        });
        jtfNewSubjectMidTermGrade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfNewSubjectMidTermGradeActionPerformed(evt);
            }
        });

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Điểm CK");

        jtfNewSubjectFinalTermScore.setBackground(new java.awt.Color(217, 217, 217));
        jtfNewSubjectFinalTermScore.setForeground(new java.awt.Color(153, 153, 153));
        jtfNewSubjectFinalTermScore.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jtfNewSubjectFinalTermScore.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtfNewSubjectFinalTermScoreMouseClicked(evt);
            }
        });
        jtfNewSubjectFinalTermScore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfNewSubjectFinalTermScoreActionPerformed(evt);
            }
        });

        jbSaveNewSubject.setBackground(new java.awt.Color(169, 186, 247));
        jbSaveNewSubject.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jbSaveNewSubject.setForeground(new java.awt.Color(255, 255, 255));
        jbSaveNewSubject.setText("Thêm");
        jbSaveNewSubject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSaveNewSubjectActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(102, 255, 255));
        jPanel3.setForeground(new java.awt.Color(51, 255, 255));

        jlbAddSubjectFor.setBackground(new java.awt.Color(0, 0, 0));
        jlbAddSubjectFor.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jlbAddSubjectFor.setForeground(new java.awt.Color(255, 255, 255));
        jlbAddSubjectFor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbAddSubjectFor.setText("THÊM MÔN HỌC");

        jbExit.setBackground(new java.awt.Color(255, 51, 51));
        jbExit.setForeground(new java.awt.Color(255, 255, 255));
        jbExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/studentgradingmanager/images/icon-exit-48.png"))); // NOI18N
        jbExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jlbAddSubjectFor, javax.swing.GroupLayout.PREFERRED_SIZE, 589, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(87, 87, 87)
                .addComponent(jbExit, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jbExit, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jlbAddSubjectFor, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16))))
        );

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Học kỳ");

        jcbSemester.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbSemesterItemStateChanged(evt);
            }
        });

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("Năm học");

        jcbYear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbYearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpTeacherGradingManagementNewSubjectPanelLayout = new javax.swing.GroupLayout(jpTeacherGradingManagementNewSubjectPanel);
        jpTeacherGradingManagementNewSubjectPanel.setLayout(jpTeacherGradingManagementNewSubjectPanelLayout);
        jpTeacherGradingManagementNewSubjectPanelLayout.setHorizontalGroup(
            jpTeacherGradingManagementNewSubjectPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jpTeacherGradingManagementNewSubjectPanelLayout.createSequentialGroup()
                .addContainerGap(108, Short.MAX_VALUE)
                .addGroup(jpTeacherGradingManagementNewSubjectPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpTeacherGradingManagementNewSubjectPanelLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jtfNewSubjectProgressGrade, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(jtfNewSubjectMidTermGrade, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfNewSubjectFinalTermScore, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpTeacherGradingManagementNewSubjectPanelLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jpTeacherGradingManagementNewSubjectPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jpTeacherGradingManagementNewSubjectPanelLayout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(jcbYear, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
                                .addComponent(jLabel7)
                                .addGap(31, 31, 31)
                                .addComponent(jcbSemester, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jpTeacherGradingManagementNewSubjectPanelLayout.createSequentialGroup()
                                .addGroup(jpTeacherGradingManagementNewSubjectPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel6))
                                .addGap(34, 34, 34)
                                .addGroup(jpTeacherGradingManagementNewSubjectPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jtfNewSubjectNote, javax.swing.GroupLayout.DEFAULT_SIZE, 391, Short.MAX_VALUE)
                                    .addComponent(jtfNewSubjectName))))))
                .addGap(75, 75, 75)
                .addComponent(jbSaveNewSubject)
                .addGap(136, 136, 136))
        );
        jpTeacherGradingManagementNewSubjectPanelLayout.setVerticalGroup(
            jpTeacherGradingManagementNewSubjectPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpTeacherGradingManagementNewSubjectPanelLayout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jpTeacherGradingManagementNewSubjectPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpTeacherGradingManagementNewSubjectPanelLayout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(jbSaveNewSubject, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpTeacherGradingManagementNewSubjectPanelLayout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(jpTeacherGradingManagementNewSubjectPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpTeacherGradingManagementNewSubjectPanelLayout.createSequentialGroup()
                                .addGroup(jpTeacherGradingManagementNewSubjectPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(jcbYear, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(19, 19, 19))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpTeacherGradingManagementNewSubjectPanelLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jpTeacherGradingManagementNewSubjectPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(jcbSemester, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)))
                        .addGroup(jpTeacherGradingManagementNewSubjectPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfNewSubjectName, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(39, 39, 39)
                        .addGroup(jpTeacherGradingManagementNewSubjectPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfNewSubjectNote, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGroup(jpTeacherGradingManagementNewSubjectPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jpTeacherGradingManagementNewSubjectPanelLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtfNewSubjectFinalTermScore, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpTeacherGradingManagementNewSubjectPanelLayout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addGroup(jpTeacherGradingManagementNewSubjectPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jtfNewSubjectProgressGrade, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jtfNewSubjectMidTermGrade, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5))))))
                .addContainerGap(177, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpTeacherGradingManagementNewSubjectPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 946, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jpTeacherGradingManagementNewSubjectPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 564, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtfNewSubjectNameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtfNewSubjectNameMouseClicked
        if (jtfNewSubjectName.getText().equals("Nhập tên môn học...")) {
            jtfNewSubjectName.setText("");
        }
    }//GEN-LAST:event_jtfNewSubjectNameMouseClicked

    private void jtfNewSubjectNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfNewSubjectNameActionPerformed

    }//GEN-LAST:event_jtfNewSubjectNameActionPerformed

    private void jtfNewSubjectNoteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtfNewSubjectNoteMouseClicked
        if (jtfNewSubjectNote.getText().equals("Nhập ghi chú...")) {
            jtfNewSubjectNote.setText("");
        }
    }//GEN-LAST:event_jtfNewSubjectNoteMouseClicked

    private void jtfNewSubjectNoteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfNewSubjectNoteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfNewSubjectNoteActionPerformed

    private void jtfNewSubjectProgressGradeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtfNewSubjectProgressGradeMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfNewSubjectProgressGradeMouseClicked

    private void jtfNewSubjectProgressGradeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfNewSubjectProgressGradeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfNewSubjectProgressGradeActionPerformed

    private void jtfNewSubjectMidTermGradeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtfNewSubjectMidTermGradeMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfNewSubjectMidTermGradeMouseClicked

    private void jtfNewSubjectMidTermGradeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfNewSubjectMidTermGradeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfNewSubjectMidTermGradeActionPerformed

    private void jtfNewSubjectFinalTermScoreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtfNewSubjectFinalTermScoreMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfNewSubjectFinalTermScoreMouseClicked

    private void jtfNewSubjectFinalTermScoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfNewSubjectFinalTermScoreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfNewSubjectFinalTermScoreActionPerformed

    private void jbSaveNewSubjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSaveNewSubjectActionPerformed
        // TODO add your handling code here:
        try {
            updateDB();

            MessageBroker.getInstance().sendMessage("Data mon hoc");
            dispose();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_jbSaveNewSubjectActionPerformed

    private void jbExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbExitActionPerformed

        dispose();
    }//GEN-LAST:event_jbExitActionPerformed

    private void jcbSemesterItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbSemesterItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbSemesterItemStateChanged

    private void jcbYearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbYearActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbYearActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TeacherGradingManagementNewSubjectFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TeacherGradingManagementNewSubjectFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TeacherGradingManagementNewSubjectFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TeacherGradingManagementNewSubjectFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TeacherGradingManagementNewSubjectFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JButton jbExit;
    private javax.swing.JButton jbSaveNewSubject;
    private javax.swing.JComboBox<String> jcbSemester;
    private javax.swing.JComboBox<String> jcbYear;
    private javax.swing.JLabel jlbAddSubjectFor;
    private javax.swing.JPanel jpTeacherGradingManagementNewSubjectPanel;
    private javax.swing.JTextField jtfNewSubjectFinalTermScore;
    private javax.swing.JTextField jtfNewSubjectMidTermGrade;
    private javax.swing.JTextField jtfNewSubjectName;
    private javax.swing.JTextField jtfNewSubjectNote;
    private javax.swing.JTextField jtfNewSubjectProgressGrade;
    // End of variables declaration//GEN-END:variables
}
