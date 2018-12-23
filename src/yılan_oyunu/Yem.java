/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yılan_oyunu;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import javax.swing.*;

public class Yem extends JLabel{
    public int mGenislik = 20;
    
    Yem()
    {
        setPosition(200,200);
    }
    
     @Override
    public void paint(Graphics g)
    {
          Graphics2D g2=(Graphics2D)g;
        
        Ellipse2D ellipse = new Ellipse2D.Double(1,1,mGenislik-2,mGenislik-2);
        g2.setColor(Color.black);
        
        g2.setStroke(new BasicStroke(1));
        
        g2.draw(ellipse);
        
        g2.setColor(Color.gray);
        g2.fill(ellipse);
    }
    
    public void setPosition(int PosX,int PosY)
    {
        setBounds(PosX,PosY,mGenislik,mGenislik);
    }
}
