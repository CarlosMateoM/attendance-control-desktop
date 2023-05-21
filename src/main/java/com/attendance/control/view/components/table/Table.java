package com.attendance.control.view.components.table;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;

public class Table extends JTable {

    private Color headerBackground = Color.WHITE;
    private Color headerForeground = Color.BLACK;
    private Font headerFont = new Font("sansserif", 1, 12);
    private Color cellColorSelected = new Color(239, 244, 255);
    private Color cellBackground = Color.WHITE;
    private int cellEditorColumn;

    public Table() {
        init();
        cellEditorColumn = 4;
    }

    private void init() {
        setShowHorizontalLines(true);
        setGridColor(new Color(230, 230, 230));
        setRowHeight(40);

        getTableHeader().setReorderingAllowed(false);
        getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(
                    JTable jtable,
                    Object value,
                    boolean isSelected,
                    boolean hasFocus,
                    int row,
                    int column) {

                TableHeader header = new TableHeader(value + "");
                header.setBackground(getHeaderBackground());
                header.setForeground(getHeaderForeground());
                header.setFont(getHeaderFont());
                return header;
            }
        });

        setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(
                    JTable jtable,
                    Object o,
                    boolean selected,
                    boolean focus,
                    int i,
                    int i1) {

                if (o instanceof ModelAction) {
                    ModelAction data = (ModelAction) o;
                    Action cell = new Action(data);
                    if (selected) {
                        cell.setBackground(new Color(239, 244, 255));
                    } else {
                        cell.setBackground(Color.WHITE);
                    }
                    return cell;
                } else {
                    Component com = super.getTableCellRendererComponent(jtable, o, selected, focus, i, i1);
                    setBorder(noFocusBorder);
                    com.setForeground(new Color(102, 102, 102));
                    if (selected) {
                        com.setBackground(getCellColorSelected());
                    } else {
                        com.setBackground(getCellBackground());
                    }
                    return com;
                }

            }
        });
    }
    
    public void addRow(Object[] row) {
        DefaultTableModel mod = (DefaultTableModel) getModel();
        mod.addRow(row);
    }

    public void clearTable() {
        DefaultTableModel mod = (DefaultTableModel) getModel();
        mod.setRowCount(0);
          
    }

    public void fixTable(JScrollPane scroll) {
        scroll.getViewport().setBackground(Color.WHITE);
        JPanel p = new JPanel();
        p.setBackground(Color.WHITE);
        scroll.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);
        scroll.setBorder(new EmptyBorder(5, 10, 5, 10));
    }

    @Override
    public TableCellEditor getCellEditor(int row, int col) {
        if (col == cellEditorColumn) {
            return new TableCellAction();
        } else {
        }
            return super.getCellEditor(row, col);
    }

    public Color getCellColorSelected() {
        return cellColorSelected;
    }

    public void setCellColorSelected(Color cellColorSelected) {
        this.cellColorSelected = cellColorSelected;
    }

    public Color getCellBackground() {
        return cellBackground;
    }

    public void setCellBackground(Color cellBackground) {
        this.cellBackground = cellBackground;
    }

    public Color getHeaderBackground() {
        return headerBackground;
    }

    public void setHeaderBackground(Color headerBackground) {
        this.headerBackground = headerBackground;
    }

    public Color getHeaderForeground() {
        return headerForeground;
    }

    public void setHeaderForeground(Color headerForeground) {
        this.headerForeground = headerForeground;
    }

    public Font getHeaderFont() {
        return headerFont;
    }

    public void setHeaderFont(Font headerFont) {
        this.headerFont = headerFont;
    }

    public int getCellEditorColumn() {
        return cellEditorColumn;
    }

    public void setCellEditorColumn(int cellEditorColumn) {
        this.cellEditorColumn = cellEditorColumn;
    }
}


/*
                
                Código faltante en el método:
                
                setDefaultRenderer();

                para la añadir foto y nombre en la tabla como en el 
                dashboard del proyecto school-dashboard de Ra Ven.
                

                if (o instanceof ModelProfile) {
                    ModelProfile data = (ModelProfile) o;
                    Profile cell = new Profile(data);
                    if (selected) {
                        cell.setBackground(new Color(239, 244, 255));
                    } else {
                        cell.setBackground(Color.WHITE);
                    }
                    return cell;

                } else if..                   

 */
