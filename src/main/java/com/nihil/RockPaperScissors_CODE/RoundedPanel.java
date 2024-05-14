/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nihil.RockPaperScissors_CODE;

/**
 *
 * @author LATITUDE 5410
 */
import javax.swing.*;
import java.awt.*;

public class RoundedPanel extends JPanel
{
    private int radius;
    private Color backcolor;
    
    public RoundedPanel(){
        this.radius = 10;
        this.backcolor = new Color(41,41,41);
    }
    public RoundedPanel(int radius){
        this.radius = radius;
        this.backcolor = new Color(41,41,41);
    }
    
    public RoundedPanel(int radius, Color color){
        this.radius = radius;
        this.backcolor = color;
    }
    
    
    @Override
    public void paintComponent(Graphics graphic){
        
       Dimension arc = new Dimension(radius, radius);
       int width = this.getWidth();
       int height = this.getHeight();
       
       Graphics2D g2d = (Graphics2D) graphic;
       g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        if(backcolor == null) {
            g2d.setColor(this.getBackground());
        }
        else {
             g2d.setColor(this.getBackground());
        }
       g2d.fillRoundRect(0, 0, width-1, height-1, arc.width, arc.height);
       g2d.setColor(this.getForeground());
    }
    
}
