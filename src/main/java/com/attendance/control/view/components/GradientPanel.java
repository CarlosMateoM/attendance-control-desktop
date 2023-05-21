package com.attendance.control.view.components;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.RenderingHints;
import javax.swing.JPanel;

public class GradientPanel extends JPanel{

    private int round = 0;
    private Color color1 = Color.decode("#2193b0");
    private Color color2 = Color.decode("#6dd5ed");

    public GradientPanel() {
        setOpaque(false);
    }
    
    public Color getColor1() {
        return color1;
    }

    public void setColor1(Color color1) {
        this.color1 = color1;
    }

    public Color getColor2() {
        return color2;
    }

    public void setColor2(Color color2) {
        this.color2 = color2;
    }

    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
         if (g instanceof Graphics2D) { 
            int width = this.getWidth(); 
            int height = this.getHeight();
            
            ((Graphics2D) g).setRenderingHint(
                    RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
            
            float startPointX = 0.0f; 
            float startPointY = 0.0f; 
            float endPointX = width; 
            float endPointY = 0.0f; 
           
            
            Paint paint = new GradientPaint(
                    startPointX, 
                    startPointY, 
                    getColor1(), 
                    endPointX,
                    endPointY,
                    getColor2()); 

            Graphics2D g2D = (Graphics2D) g; 
            g2D.setPaint(paint); 
            g2D.fillRoundRect(0, 0, width, height, round, round); 
        } 
    }

}
