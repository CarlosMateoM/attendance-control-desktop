package com.attendance.control.view.components.table;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JScrollBar;
import javax.swing.plaf.basic.BasicScrollBarUI;

public class ScrollBarCustom extends JScrollBar {

    private int round = 5;
    ModernScrollBarUI UI = new ModernScrollBarUI();

    public ScrollBarCustom() {
        init();
    }

    private void init() {
        setUI(UI);
        setPreferredSize(new Dimension(10, 0));
        setForeground(new Color(94, 139, 231));
        setUnitIncrement(20);
        setOpaque(false);
    }

    public int getRound() {
        return UI.getRound();
    }

    public void setRound(int round) {
        this.round = round;
        UI.setRound(round);
    }

    private class ModernScrollBarUI extends BasicScrollBarUI {

        private final int THUMB_SIZE = 80;

        private int round = 5;

        @Override
        protected Dimension getMaximumThumbSize() {
            if (scrollbar.getOrientation() == JScrollBar.VERTICAL) {
                return new Dimension(0, THUMB_SIZE);
            } else {
                return new Dimension(THUMB_SIZE, 0);
            }
        }

        @Override
        protected Dimension getMinimumThumbSize() {
            if (scrollbar.getOrientation() == JScrollBar.VERTICAL) {
                return new Dimension(0, THUMB_SIZE);
            } else {
                return new Dimension(THUMB_SIZE, 0);
            }
        }

        @Override
        protected JButton createIncreaseButton(int i) {
            return new ScrollBarButton();
        }

        @Override
        protected JButton createDecreaseButton(int i) {
            return new ScrollBarButton();
        }

        @Override
        protected void paintTrack(Graphics grphcs, JComponent jc, Rectangle rctngl) {
        }

        @Override
        protected void paintThumb(Graphics grphcs, JComponent jc, Rectangle rctngl) {
            Graphics2D g2 = (Graphics2D) grphcs;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            int x = rctngl.x;
            int y = rctngl.y;
            int width = rctngl.width;
            int height = rctngl.height;
            if (scrollbar.getOrientation() == JScrollBar.VERTICAL) {
                y += 8;
                height -= 16;
            } else {
                x += 8;
                width -= 16;
            }
            g2.setColor(scrollbar.getForeground());
            g2.fillRoundRect(x, y, width, height, round, round);
        }

        private class ScrollBarButton extends JButton {

            public ScrollBarButton() {
                setBorder(BorderFactory.createEmptyBorder());
            }

            @Override
            public void paint(Graphics grphcs) {
            }
        }

        public int getRound() {
            return round;

        }

        public void setRound(int round) {
            this.round = round;
            repaint();
        }

    }

}
