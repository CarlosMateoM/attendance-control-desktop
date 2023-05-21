package com.attendance.control.view.form;

import com.attendance.control.view.components.Button;
import com.attendance.control.view.components.GradientPanel;
import com.attendance.control.view.components.table.Table;
import com.attendance.control.view.components.textfield.TextFieldSuggestion;
import javax.swing.table.TableModel;

public class EmployeeForm extends GradientPanel {

    public EmployeeForm() {
        initComponents();
        employeeTable.fixTable(jScrollPane1);
    }

    public Button getAttendanceFormButton() {
        return attendanceFormButton;
    }

    public Button getRegistrationFormButton() {
        return registrationFormButton;
    }

    public Table getEmployeeTable() {
        return employeeTable;
    }

    public TableModel getEmployeeTableModel() {
        return employeeTable.getModel();
    }
    
    public void setTotalEmployeesLb(int totalEmployees){
        totalEmployeesLb.setText(
                totalEmployees + " empleados registrados"
        );
    }
    
    public Button getNewEmployeeBtn() {
        return newEmployeeBtn;
    }

    public Button getRefreshTableBtn() {
        return refreshTableBtn;
    }

    public TextFieldSuggestion getSearchEmployeeTxt() {
        return searchEmployeeTxt;
    }
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollBarCustom1 = new com.attendance.control.view.components.ScrollBarCustom();
        refreshTableBtn = new com.attendance.control.view.components.Button();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        employeeTable = new com.attendance.control.view.components.table.Table();
        attendanceFormButton = new com.attendance.control.view.components.Button();
        registrationFormButton = new com.attendance.control.view.components.Button();
        searchEmployeeTxt = new com.attendance.control.view.components.textfield.TextFieldSuggestion();
        totalEmployeesLb = new javax.swing.JLabel();
        newEmployeeBtn = new com.attendance.control.view.components.Button();

        scrollBarCustom1.setBackground(new java.awt.Color(255, 255, 255));
        scrollBarCustom1.setForeground(new java.awt.Color(51, 204, 0));

        setColor1(new java.awt.Color(255, 255, 255));
        setColor2(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        refreshTableBtn.setBackground(new java.awt.Color(51, 204, 0));
        refreshTableBtn.setForeground(new java.awt.Color(255, 255, 255));
        refreshTableBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-refresh-29.png"))); // NOI18N
        refreshTableBtn.setBackgroundColor(new java.awt.Color(51, 204, 0));
        refreshTableBtn.setFocusPainted(false);
        refreshTableBtn.setFont(new java.awt.Font("Droid Sans", 1, 14)); // NOI18N
        refreshTableBtn.setHoverColor(new java.awt.Color(0, 255, 0));
        add(refreshTableBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 31, 30, 29));

        jLabel5.setFont(new java.awt.Font("Droid Sans", 1, 24)); // NOI18N
        jLabel5.setText("LISTA DE EMPLEADOS");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 32, 384, -1));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(null);
        jScrollPane1.setVerticalScrollBar(scrollBarCustom1);

        employeeTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NOMBRE", "CC", ""
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        employeeTable.setCellEditorColumn(3);
        employeeTable.setFont(new java.awt.Font("Droid Sans", 0, 14)); // NOI18N
        employeeTable.setShowVerticalLines(false);
        jScrollPane1.setViewportView(employeeTable);
        if (employeeTable.getColumnModel().getColumnCount() > 0) {
            employeeTable.getColumnModel().getColumn(3).setMinWidth(100);
            employeeTable.getColumnModel().getColumn(3).setPreferredWidth(100);
            employeeTable.getColumnModel().getColumn(3).setMaxWidth(100);
        }

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 73, 886, 352));

        attendanceFormButton.setBackground(new java.awt.Color(255, 255, 255));
        attendanceFormButton.setForeground(new java.awt.Color(51, 204, 0));
        attendanceFormButton.setText("regresar al registro de asistencia");
        attendanceFormButton.setAutoscrolls(true);
        attendanceFormButton.setFocusPainted(false);
        attendanceFormButton.setFont(new java.awt.Font("Droid Sans", 2, 12)); // NOI18N
        attendanceFormButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                attendanceFormButtonActionPerformed(evt);
            }
        });
        add(attendanceFormButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 5, -1, 15));

        registrationFormButton.setBackground(new java.awt.Color(255, 255, 255));
        registrationFormButton.setForeground(new java.awt.Color(51, 204, 0));
        registrationFormButton.setText("panel de inicio");
        registrationFormButton.setAutoscrolls(true);
        registrationFormButton.setFocusPainted(false);
        registrationFormButton.setFont(new java.awt.Font("Droid Sans", 2, 12)); // NOI18N
        registrationFormButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrationFormButtonActionPerformed(evt);
            }
        });
        add(registrationFormButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(818, 5, -1, 15));

        searchEmployeeTxt.setFont(new java.awt.Font("Droid Sans", 0, 14)); // NOI18N
        searchEmployeeTxt.setHint("buscar por nombre...");
        searchEmployeeTxt.setHintColor(new java.awt.Color(153, 153, 153));
        searchEmployeeTxt.setSelectionColor(new java.awt.Color(51, 204, 0));
        add(searchEmployeeTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(348, 21, 430, 40));

        totalEmployeesLb.setFont(new java.awt.Font("Droid Sans", 1, 11)); // NOI18N
        totalEmployeesLb.setForeground(new java.awt.Color(153, 153, 153));
        totalEmployeesLb.setText("0 empleados registrados");
        add(totalEmployeesLb, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 437, -1, -1));

        newEmployeeBtn.setBackground(new java.awt.Color(51, 204, 0));
        newEmployeeBtn.setForeground(new java.awt.Color(255, 255, 255));
        newEmployeeBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add-employee.png"))); // NOI18N
        newEmployeeBtn.setBackgroundColor(new java.awt.Color(51, 204, 0));
        newEmployeeBtn.setFocusPainted(false);
        newEmployeeBtn.setFont(new java.awt.Font("Droid Sans", 1, 14)); // NOI18N
        newEmployeeBtn.setHoverColor(new java.awt.Color(0, 255, 0));
        add(newEmployeeBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(844, 32, 54, 29));
    }// </editor-fold>//GEN-END:initComponents

    private void attendanceFormButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_attendanceFormButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_attendanceFormButtonActionPerformed

    private void registrationFormButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrationFormButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_registrationFormButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.attendance.control.view.components.Button attendanceFormButton;
    private com.attendance.control.view.components.table.Table employeeTable;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private com.attendance.control.view.components.Button newEmployeeBtn;
    private com.attendance.control.view.components.Button refreshTableBtn;
    private com.attendance.control.view.components.Button registrationFormButton;
    private com.attendance.control.view.components.ScrollBarCustom scrollBarCustom1;
    private com.attendance.control.view.components.textfield.TextFieldSuggestion searchEmployeeTxt;
    private javax.swing.JLabel totalEmployeesLb;
    // End of variables declaration//GEN-END:variables
}
