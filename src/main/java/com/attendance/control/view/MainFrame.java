package com.attendance.control.view;

import java.awt.Color;
import java.awt.Component;

public class MainFrame extends javax.swing.JFrame {
    
    public static MainFrame instance = null;

    private MainFrame() {
        initComponents();
        setBackground(new Color(0, 0, 0, 0));
        init();
    }
    
    private void init(){
        this.windowBar1.setjFrame(this);
    }
   
    public static MainFrame getInstance(){
        if(instance == null){
            instance = new MainFrame();
        }
        return instance;
    }
    
    public void setPanel(Component component){
        mainPanel.removeAll();
        mainPanel.revalidate();
        mainPanel.add(component);
        mainPanel.repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gradientPanel3 = new com.attendance.control.view.components.GradientPanel();
        windowBar1 = new com.attendance.control.view.components.WindowBar();
        mainPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        gradientPanel3.setColor1(new java.awt.Color(255, 255, 255));
        gradientPanel3.setColor2(new java.awt.Color(255, 255, 255));
        gradientPanel3.setOpaque(true);
        gradientPanel3.setRound(20);

        mainPanel.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout gradientPanel3Layout = new javax.swing.GroupLayout(gradientPanel3);
        gradientPanel3.setLayout(gradientPanel3Layout);
        gradientPanel3Layout.setHorizontalGroup(
            gradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(windowBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 934, Short.MAX_VALUE)
            .addGroup(gradientPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        gradientPanel3Layout.setVerticalGroup(
            gradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gradientPanel3Layout.createSequentialGroup()
                .addComponent(windowBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 471, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(gradientPanel3, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.attendance.control.view.components.GradientPanel gradientPanel3;
    private javax.swing.JPanel mainPanel;
    private com.attendance.control.view.components.WindowBar windowBar1;
    // End of variables declaration//GEN-END:variables
}
