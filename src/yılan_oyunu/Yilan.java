package yılan_oyunu;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.util.ArrayList;
import javax.swing.*;

public class Yilan extends JLabel {
    public Kutu mHead = new Kutu();
    
    public Timer mTimer = null;
    
    public ArrayList<Kutu> Liste = new ArrayList<Kutu>();
    
  
    
    Yilan()
    {
       
       
        addKeyListener(new KlavyeKontrol());
        setFocusable(true);
        
        mTimer = new Timer(150,new TimerControl());
        mTimer.start();
        
        Liste.add(mHead);
        for(int i=1;i<10;i++)
        {
            KuyrukEkle();
        }
        
         add(mHead);
        
    }
    public void KuyrukEkle()
    {
        Kutu K = Liste.get(Liste.size()-1).KutuOlustur();
            
            Liste.add(K);
            add(K);
    }

    
    public void HepsiniOynat()
    {
                  mHead.Hareket();

          for(int i =Liste.size()-1; i>0; i--)
            {
                
                Kutu Onceki = Liste.get(i-1);
                Kutu Sonraki = Liste.get(i);
                
                Liste.get(i).Hareket();
                Sonraki.mYon=Onceki.mYon;
            }
    }
    
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        
        Graphics2D g2=(Graphics2D)g;
        
        Rectangle2D rect = new Rectangle2D.Double(5,5,getWidth()-10,getHeight()-10);
        g2.setColor(Color.red);
        
        g2.setStroke(new BasicStroke(10));
        
        g2.draw(rect);
    }
  
    
    
    class KlavyeKontrol implements KeyListener
    {

        @Override
        public void keyTyped(KeyEvent ke) {
         
        }

        @Override
        public void keyPressed(KeyEvent ke) {
            if(ke.getKeyCode()== KeyEvent.VK_LEFT)
            {
                mHead.mYon = YON.SOL;
            }
            
             if(ke.getKeyCode()== KeyEvent.VK_RIGHT)
            {
                 mHead.mYon = YON.SAG;
            }
             
              if(ke.getKeyCode()== KeyEvent.VK_UP)
            {
              mHead.mYon = YON.YUKARİ;
            }
              
               if(ke.getKeyCode()== KeyEvent.VK_DOWN)
            {
              mHead.mYon = YON.ASAGİ;
            }
        }

        @Override
        public void keyReleased(KeyEvent ke) {
            
        }
        
    }
    class TimerControl implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent ae) {
            HepsiniOynat();
        }
         
    }
}
