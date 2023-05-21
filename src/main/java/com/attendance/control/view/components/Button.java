package com.attendance.control.view.components;

//import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
//import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;
/*
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;
*/
public class Button extends JButton {

    //public Animator animator;
    public int targetSize;
    public float animatSize;
    public Point pressedPoint;
    public float alpha;
    public Color effectColor = new Color(255, 255, 255);
    
    private int round;
    private Color hoverColor = new Color(255, 255, 255);
    private Color backgroundColor = new Color(255, 255, 255);

    public Button() {
        super();
        init();
        
    }
    
    private void init(){
        setOpaque(false);
        setContentAreaFilled(false);
        setBorder(new EmptyBorder(5, 0, 5, 0));
        setBackground(null);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e) {
                setBackground(getHoverColor());
            }
            @Override
            public void mouseExited(MouseEvent e) {
                setBackground(getBackgroundColor());
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                setBackground(getBackgroundColor());
            }

            @Override
            public void mousePressed(MouseEvent e) {
                setBackground(getBackgroundColor());
            } 
        });
        
        
    }    
    
    @Override
    protected void paintComponent(Graphics grphcs) {
        int width = getWidth();
        int height = getHeight();
        
        BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        
        Graphics2D g2 = img.createGraphics();
        
        if(round == 0){
            round = height;
        }
        
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, width, height, round, round);
//        
//        if (pressedPoint != null) {
//            g2.setColor(effectColor);
//            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, alpha));
//            g2.fillOval((int) (pressedPoint.x - animatSize / 2), (int) (pressedPoint.y - animatSize / 2), (int) animatSize, (int) animatSize);
//        }
        g2.dispose();
        grphcs.drawImage(img, 0, 0, null);
        super.paintComponent(grphcs);
    }
    
        public Color getEffectColor() {
        return effectColor;
    }

    public void setEffectColor(Color effectColor) {
        this.effectColor = effectColor;
    }

    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
        repaint();
    }

    public Color getHoverColor() {
        return hoverColor;
    }

    public void setHoverColor(Color hoverColor) {
        this.hoverColor = hoverColor;
    }

    public Color getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
    }
    
}
