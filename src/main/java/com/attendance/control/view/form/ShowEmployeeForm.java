package com.attendance.control.view.form;

import com.attendance.control.view.components.Button;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ListModel;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;

public class ShowEmployeeForm extends javax.swing.JDialog {
    
    private final Animator animator;
    private boolean show = true;

    public ShowEmployeeForm(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setOpacity(0f);
        getContentPane().setBackground(Color.WHITE);
        TimingTarget target = new TimingTargetAdapter() {
            @Override
            public void timingEvent(float fraction) {
                if (show) {
                    setOpacity(fraction);
                } else {
                    setOpacity(1f - fraction);
                }
            }

            @Override
            public void end() {
                if (show == false) {
                    setVisible(false);
                }
            }

        };
        animator = new Animator(200, target);
        animator.setResolution(0);
        animator.setAcceleration(0.5f);
    }

    public void setAttendanceListModel(ListModel<String> model) {
        AttendanceList.setModel(model);
    }

    public JLabel getEmployeeCCLb() {
        return employeeCCLb;
    }

    public void setEmployeeCCLb(JLabel employeeCCLb) {
        this.employeeCCLb = employeeCCLb;
    }

    public JLabel getEmployeeNameLb() {
        return employeeNameLb;
    }

    public void setEmployeeNameLb(JLabel employeeNameLb) {
        this.employeeNameLb = employeeNameLb;
    }
    
    
    
    public void showDialog() {
        animator.start();
        setVisible(true);
    }
    
    public void closeMenu() {
        if (animator.isRunning()) {
            animator.stop();
        }
        show = false;
        animator.start();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollBarCustom1 = new com.attendance.control.view.components.ScrollBarCustom();
        jPanel1 = new javax.swing.JPanel();
        saveEmployeeBtn = new com.attendance.control.view.components.Button();
        jScrollPane1 = new javax.swing.JScrollPane();
        AttendanceList = new javax.swing.JList<>();
        gradientPanel1 = new com.attendance.control.view.components.GradientPanel();
        employeeNameLb = new javax.swing.JLabel();
        gradientPanel2 = new com.attendance.control.view.components.GradientPanel();
        jLabel6 = new javax.swing.JLabel();
        employeeCCLb = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        scrollBarCustom1.setBackground(new java.awt.Color(255, 255, 255));
        scrollBarCustom1.setForeground(new java.awt.Color(51, 204, 0));

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(75, 134, 253)));

        saveEmployeeBtn.setBackground(new java.awt.Color(51, 204, 0));
        saveEmployeeBtn.setForeground(new java.awt.Color(255, 255, 255));
        saveEmployeeBtn.setText("Aceptar");
        saveEmployeeBtn.setBackgroundColor(new java.awt.Color(51, 204, 0));
        saveEmployeeBtn.setFocusPainted(false);
        saveEmployeeBtn.setFont(new java.awt.Font("Droid Sans", 1, 14)); // NOI18N
        saveEmployeeBtn.setHoverColor(new java.awt.Color(0, 255, 0));
        saveEmployeeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveEmployeeBtnActionPerformed(evt);
            }
        });

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(null);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBar(scrollBarCustom1);

        AttendanceList.setFont(new java.awt.Font("Droid Sans", 1, 11)); // NOI18N
        AttendanceList.setForeground(new java.awt.Color(102, 102, 102));
        jScrollPane1.setViewportView(AttendanceList);

        gradientPanel1.setColor1(new java.awt.Color(51, 204, 0));
        gradientPanel1.setColor2(new java.awt.Color(41, 168, 0));

        employeeNameLb.setBackground(new java.awt.Color(254, 254, 254));
        employeeNameLb.setFont(new java.awt.Font("Droid Sans", 1, 14)); // NOI18N
        employeeNameLb.setForeground(new java.awt.Color(254, 254, 254));
        employeeNameLb.setText("XXXXXXXXXXXXXX");

        javax.swing.GroupLayout gradientPanel1Layout = new javax.swing.GroupLayout(gradientPanel1);
        gradientPanel1.setLayout(gradientPanel1Layout);
        gradientPanel1Layout.setHorizontalGroup(
            gradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, gradientPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(employeeNameLb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        gradientPanel1Layout.setVerticalGroup(
            gradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(employeeNameLb, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
        );

        gradientPanel2.setColor1(new java.awt.Color(51, 204, 0));
        gradientPanel2.setColor2(new java.awt.Color(41, 168, 0));
        gradientPanel2.setRound(10);

        jLabel6.setBackground(new java.awt.Color(254, 254, 254));
        jLabel6.setFont(new java.awt.Font("Droid Sans", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(254, 254, 254));
        jLabel6.setText(" Asistencias registradas");

        javax.swing.GroupLayout gradientPanel2Layout = new javax.swing.GroupLayout(gradientPanel2);
        gradientPanel2.setLayout(gradientPanel2Layout);
        gradientPanel2Layout.setHorizontalGroup(
            gradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gradientPanel2Layout.createSequentialGroup()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        gradientPanel2Layout.setVerticalGroup(
            gradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
        );

        employeeCCLb.setBackground(new java.awt.Color(254, 254, 254));
        employeeCCLb.setFont(new java.awt.Font("Droid Sans", 1, 14)); // NOI18N
        employeeCCLb.setForeground(new java.awt.Color(153, 153, 153));
        employeeCCLb.setText("XXXXXXXXX");

        jLabel8.setBackground(new java.awt.Color(254, 254, 254));
        jLabel8.setFont(new java.awt.Font("Droid Sans", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(153, 153, 153));
        jLabel8.setText("CC:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(gradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(employeeCCLb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(172, 172, 172)
                                .addComponent(saveEmployeeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(gradientPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jScrollPane1)))
                        .addGap(0, 3, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(gradientPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(employeeCCLb, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE))
                .addGap(20, 20, 20)
                .addComponent(gradientPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(saveEmployeeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void saveEmployeeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveEmployeeBtnActionPerformed
        closeMenu();
    }//GEN-LAST:event_saveEmployeeBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> AttendanceList;
    private javax.swing.JLabel employeeCCLb;
    private javax.swing.JLabel employeeNameLb;
    private com.attendance.control.view.components.GradientPanel gradientPanel1;
    private com.attendance.control.view.components.GradientPanel gradientPanel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private com.attendance.control.view.components.Button saveEmployeeBtn;
    private com.attendance.control.view.components.ScrollBarCustom scrollBarCustom1;
    // End of variables declaration//GEN-END:variables
}
