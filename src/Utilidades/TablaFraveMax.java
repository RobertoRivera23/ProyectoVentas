/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilidades;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;

/**
 *
 * @author Diosito
 */
public class TablaFraveMax extends JTable {

    public TablaFraveMax() {
        this.setFillsViewportHeight(true);
        this.getScroll().getViewport().setBackground(new Color(10, 170, 140));
        this.setBackground(new Color(10, 170, 140));
        this.getTableHeader().setFont(new Font("Corbel", Font.BOLD, 14));
        this.getTableHeader().setForeground(Color.white);
        this.setFont(new Font("Corbel", Font.PLAIN, 12));
        //this.getTableHeader().setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 102, 102), new Color(0, 51, 51)));
        this.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 102, 102), new Color(0, 51, 51)));
    }
    
    private JScrollPane getScroll(){
        JScrollPane scroll = new JScrollPane();
        scroll.add(this);
        return scroll;
    }
}
