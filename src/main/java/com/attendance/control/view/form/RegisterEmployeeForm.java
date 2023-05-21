package com.attendance.control.view.form;

import com.attendance.control.view.components.Button;
import java.awt.Color;
import javax.swing.DefaultListModel;
import javax.swing.ListModel;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;

public class RegisterEmployeeForm extends javax.swing.JDialog {
    
    private final Animator animator;
    private boolean show = true;

    public RegisterEmployeeForm(java.awt.Frame parent, boolean modal) {
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

    public String getCc() {
        return ccTxt.getText();
    }

    public Button getCloseBtn() {
        return closeBtn;
    }

    public String getFirstName() {
        return firstNameTxt.getText();
    }

    public String getLastName() {
        return lastNameTxt.getText();
    }

    public void getLogArduinoList(ListModel<String> model) {
        logArduinoList.setModel(model);
    }

    public Button getRegisterFingerprintBtn() {
        return registerFingerprintBtn;
    }

    public Button getSaveEmployeeBtn() {
        return saveEmployeeBtn;
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
        closeBtn = new com.attendance.control.view.components.Button();
        jLabel5 = new javax.swing.JLabel();
        ccTxt = new com.attendance.control.view.components.textfield.TextFieldSuggestion();
        firstNameTxt = new com.attendance.control.view.components.textfield.TextFieldSuggestion();
        jScrollPane1 = new javax.swing.JScrollPane();
        logArduinoList = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        registerFingerprintBtn = new com.attendance.control.view.components.Button();
        lastNameTxt = new com.attendance.control.view.components.textfield.TextFieldSuggestion();
        gradientPanel1 = new com.attendance.control.view.components.GradientPanel();

        scrollBarCustom1.setBackground(new java.awt.Color(255, 255, 255));
        scrollBarCustom1.setForeground(new java.awt.Color(51, 204, 0));

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(75, 134, 253)));

        saveEmployeeBtn.setBackground(new java.awt.Color(51, 204, 0));
        saveEmployeeBtn.setForeground(new java.awt.Color(255, 255, 255));
        saveEmployeeBtn.setText("Guardar");
        saveEmployeeBtn.setBackgroundColor(new java.awt.Color(51, 204, 0));
        saveEmployeeBtn.setFocusPainted(false);
        saveEmployeeBtn.setFont(new java.awt.Font("Droid Sans", 1, 14)); // NOI18N
        saveEmployeeBtn.setHoverColor(new java.awt.Color(0, 255, 0));
        saveEmployeeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveEmployeeBtnActionPerformed(evt);
            }
        });

        closeBtn.setBackground(new java.awt.Color(204, 0, 51));
        closeBtn.setForeground(new java.awt.Color(255, 255, 255));
        closeBtn.setText("CANCELAR");
        closeBtn.setBackgroundColor(new java.awt.Color(204, 0, 51));
        closeBtn.setFocusPainted(false);
        closeBtn.setFont(new java.awt.Font("Droid Sans", 1, 14)); // NOI18N
        closeBtn.setHoverColor(new java.awt.Color(255, 0, 0));
        closeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeBtnActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Droid Sans", 1, 24)); // NOI18N
        jLabel5.setText("REGISTRAR EMPLEADO");

        ccTxt.setHint("CC");
        ccTxt.setHintColor(new java.awt.Color(153, 153, 153));
        ccTxt.setSelectionColor(new java.awt.Color(51, 204, 0));

        firstNameTxt.setHint("Nombres");
        firstNameTxt.setHintColor(new java.awt.Color(153, 153, 153));
        firstNameTxt.setSelectionColor(new java.awt.Color(51, 204, 0));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(null);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBar(scrollBarCustom1);

        logArduinoList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { " " };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(logArduinoList);

        jLabel1.setFont(new java.awt.Font("Droid Sans", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 153, 153));
        jLabel1.setText("Huella");

        registerFingerprintBtn.setBackground(new java.awt.Color(153, 153, 153));
        registerFingerprintBtn.setForeground(new java.awt.Color(255, 255, 255));
        registerFingerprintBtn.setText("INICIAR REGISTRO HUELLA");
        registerFingerprintBtn.setBackgroundColor(new java.awt.Color(153, 153, 153));
        registerFingerprintBtn.setFocusPainted(false);
        registerFingerprintBtn.setFont(new java.awt.Font("Droid Sans", 1, 14)); // NOI18N
        registerFingerprintBtn.setHoverColor(new java.awt.Color(183, 183, 183));
        registerFingerprintBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerFingerprintBtnActionPerformed(evt);
            }
        });

        lastNameTxt.setHint("Apellidos");
        lastNameTxt.setHintColor(new java.awt.Color(153, 153, 153));
        lastNameTxt.setSelectionColor(new java.awt.Color(51, 204, 0));

        gradientPanel1.setColor1(new java.awt.Color(51, 204, 0));
        gradientPanel1.setColor2(new java.awt.Color(41, 168, 0));

        javax.swing.GroupLayout gradientPanel1Layout = new javax.swing.GroupLayout(gradientPanel1);
        gradientPanel1.setLayout(gradientPanel1Layout);
        gradientPanel1Layout.setHorizontalGroup(
            gradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        gradientPanel1Layout.setVerticalGroup(
            gradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(gradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(saveEmployeeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(closeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(registerFingerprintBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(lastNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(ccTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE)
                                .addComponent(firstNameTxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(gradientPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(12, 12, 12)
                .addComponent(ccTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(firstNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lastNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(registerFingerprintBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveEmployeeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(closeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        
    }//GEN-LAST:event_saveEmployeeBtnActionPerformed

    private void registerFingerprintBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerFingerprintBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_registerFingerprintBtnActionPerformed

    private void closeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeBtnActionPerformed
        // TODO add your handling code here:
        closeMenu();
    }//GEN-LAST:event_closeBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.attendance.control.view.components.textfield.TextFieldSuggestion ccTxt;
    private com.attendance.control.view.components.Button closeBtn;
    private com.attendance.control.view.components.textfield.TextFieldSuggestion firstNameTxt;
    private com.attendance.control.view.components.GradientPanel gradientPanel1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private com.attendance.control.view.components.textfield.TextFieldSuggestion lastNameTxt;
    private javax.swing.JList<String> logArduinoList;
    private com.attendance.control.view.components.Button registerFingerprintBtn;
    private com.attendance.control.view.components.Button saveEmployeeBtn;
    private com.attendance.control.view.components.ScrollBarCustom scrollBarCustom1;
    // End of variables declaration//GEN-END:variables
}
