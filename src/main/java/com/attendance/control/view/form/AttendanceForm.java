package com.attendance.control.view.form;

import com.attendance.control.view.components.Button;
import com.attendance.control.view.components.GradientPanel;
import com.attendance.control.view.components.datechooser.DateChooser;
import com.attendance.control.view.components.datechooser.SelectedAction;
import com.attendance.control.view.components.datechooser.SelectedDate;
import com.attendance.control.view.components.table.Table;


public class AttendanceForm extends GradientPanel {

    public AttendanceForm() {
        initComponents();
        this.attendanceTable.fixTable(jScrollPane1);
        configDateChooser();
    }

    private void configDateChooser() {
        dateAttendances.addEventDateChooser((SelectedAction action, SelectedDate date) -> {
            if (action.getAction() == SelectedAction.DAY_SELECTED) {
                dateAttendances.hidePopup();
            }
        });
    }

    public Button getBackRegistrationForm() {
        return backRegistrationForm;
    }

    public Button getSearchButton() {
        return searchButton;
    }

    public Button getEmployeeFormButton() {
        return employeeFormButton;
    }
    
    public String getDateTextField() {
        return dateTextField.getText();
    }

    public Table getAttendanceTable() {
        return attendanceTable;
    }

    public Button getCurrentDateBtn() {
        return currentDateBtn;
    }

    public DateChooser getDateAttendances() {
        return dateAttendances;
    }

    public void setTotalAttendancesLb(int totalAttendances) {
        totalAttendanceLb.setText(
                totalAttendances + " empleados registrados"
        );
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollBarCustom1 = new com.attendance.control.view.components.ScrollBarCustom();
        dateAttendances = new com.attendance.control.view.components.datechooser.DateChooser();
        searchButton = new com.attendance.control.view.components.Button();
        dateTextField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        attendanceTable = new com.attendance.control.view.components.table.Table();
        backRegistrationForm = new com.attendance.control.view.components.Button();
        employeeFormButton = new com.attendance.control.view.components.Button();
        totalAttendanceLb = new javax.swing.JLabel();
        currentDateBtn = new com.attendance.control.view.components.Button();

        scrollBarCustom1.setBackground(new java.awt.Color(255, 255, 255));
        scrollBarCustom1.setForeground(new java.awt.Color(51, 204, 0));

        dateAttendances.setForeground(new java.awt.Color(51, 204, 0));
        dateAttendances.setTextRefernce(dateTextField);

        setColor1(new java.awt.Color(255, 255, 255));
        setColor2(new java.awt.Color(255, 255, 255));

        searchButton.setBackground(new java.awt.Color(51, 204, 0));
        searchButton.setForeground(new java.awt.Color(255, 255, 255));
        searchButton.setText("BUSCAR");
        searchButton.setBackgroundColor(new java.awt.Color(51, 204, 0));
        searchButton.setFocusPainted(false);
        searchButton.setFont(new java.awt.Font("Droid Sans", 1, 14)); // NOI18N
        searchButton.setHoverColor(new java.awt.Color(0, 255, 0));

        dateTextField.setBackground(new java.awt.Color(255, 255, 255));
        dateTextField.setFont(new java.awt.Font("Droid Sans", 1, 11)); // NOI18N
        dateTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        dateTextField.setBorder(null);

        jLabel7.setBackground(new java.awt.Color(51, 204, 0));
        jLabel7.setFont(new java.awt.Font("Droid Sans", 2, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 204, 0));
        jLabel7.setText("fecha");

        jLabel5.setFont(new java.awt.Font("Droid Sans", 1, 24)); // NOI18N
        jLabel5.setText("LISTA DE ASISTENCIA");

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(null);
        jScrollPane1.setVerticalScrollBar(scrollBarCustom1);

        attendanceTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "NOMBRE", "CC"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        attendanceTable.setFont(new java.awt.Font("Droid Sans", 0, 14)); // NOI18N
        attendanceTable.setShowVerticalLines(false);
        jScrollPane1.setViewportView(attendanceTable);

        backRegistrationForm.setBackground(new java.awt.Color(255, 255, 255));
        backRegistrationForm.setForeground(new java.awt.Color(51, 204, 0));
        backRegistrationForm.setText("panel de inicio");
        backRegistrationForm.setAutoscrolls(true);
        backRegistrationForm.setFocusPainted(false);
        backRegistrationForm.setFont(new java.awt.Font("Droid Sans", 2, 12)); // NOI18N
        backRegistrationForm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backRegistrationFormActionPerformed(evt);
            }
        });

        employeeFormButton.setBackground(new java.awt.Color(255, 255, 255));
        employeeFormButton.setForeground(new java.awt.Color(51, 204, 0));
        employeeFormButton.setText("empleados");
        employeeFormButton.setAutoscrolls(true);
        employeeFormButton.setFocusPainted(false);
        employeeFormButton.setFont(new java.awt.Font("Droid Sans", 2, 12)); // NOI18N
        employeeFormButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employeeFormButtonActionPerformed(evt);
            }
        });

        totalAttendanceLb.setFont(new java.awt.Font("Droid Sans", 1, 11)); // NOI18N
        totalAttendanceLb.setForeground(new java.awt.Color(153, 153, 153));
        totalAttendanceLb.setText("0 registros de asistencias");

        currentDateBtn.setBackground(new java.awt.Color(51, 204, 0));
        currentDateBtn.setForeground(new java.awt.Color(255, 255, 255));
        currentDateBtn.setText("FECHA ACTUAL");
        currentDateBtn.setBackgroundColor(new java.awt.Color(51, 204, 0));
        currentDateBtn.setFocusPainted(false);
        currentDateBtn.setFont(new java.awt.Font("Droid Sans", 1, 14)); // NOI18N
        currentDateBtn.setHoverColor(new java.awt.Color(0, 255, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(dateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(currentDateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(totalAttendanceLb)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(backRegistrationForm, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(726, 726, 726)
                                .addComponent(employeeFormButton, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(backRegistrationForm, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(employeeFormButton, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel7)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(dateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(currentDateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 379, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(totalAttendanceLb)
                .addGap(4, 4, 4))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void backRegistrationFormActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backRegistrationFormActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_backRegistrationFormActionPerformed

    private void employeeFormButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_employeeFormButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_employeeFormButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.attendance.control.view.components.table.Table attendanceTable;
    private com.attendance.control.view.components.Button backRegistrationForm;
    private com.attendance.control.view.components.Button currentDateBtn;
    private com.attendance.control.view.components.datechooser.DateChooser dateAttendances;
    private javax.swing.JTextField dateTextField;
    private com.attendance.control.view.components.Button employeeFormButton;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private com.attendance.control.view.components.ScrollBarCustom scrollBarCustom1;
    private com.attendance.control.view.components.Button searchButton;
    private javax.swing.JLabel totalAttendanceLb;
    // End of variables declaration//GEN-END:variables
}
