package yılan_oyunu;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;

public class Yilan extends JLabel {
    public Kutu mHead = new Kutu();
    
    public Timer mTimer = null;
    
    public Yem mYem = new Yem();
    
    public Random mRandom = null;
    
    public ArrayList<Kutu> Liste = new ArrayList<Kutu>();
    
  
    
    Yilan()
    {
       
       mRandom = new Random(System.currentTimeMillis()); 
        addKeyListener(new KlavyeKontrol());
        setFocusable(true);
        
        mTimer = new Timer(100,new TimerControl());
        mTimer.start();
        
        Liste.add(mHead);
        for(int i=1;i<10;i++)
        {
            KuyrukEkle();
        }
        
         add(mHead);
         add(mYem);
        
    }
    public void KuyrukEkle()
    {
        Kutu K = Liste.get(Liste.size()-1).KutuOlustur();
            
            Liste.add(K);
            add(K);
    }

    public void YemEkle()
    {
        int Width= getWidth()-30-mYem.mGenislik;
        int Height = getHeight()- 30-mYem.mGenislik;
        
        int PosX = 20+Math.abs(mRandom.nextInt())%Width;
        int PosY = 20+Math.abs(mRandom.nextInt())%Height;
        
        PosX=PosX-PosX%20;
        PosY=PosY-PosY%20;
        for (int i = 0; i < Liste.size(); i++) {
            if ((PosX == Liste.get(i).getX()) && (PosY==Liste.get(i).getY())) {
                YemEkle();
                return; 
            }
        }
        
        mYem.setPosition(PosX, PosY);
        
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
    
    public boolean CarpısmaVarmı()
    {
        int kalem = 10 ;
        
        int genislik = getWidth();
        int yukseklik = getHeight();
        
        if(mHead.getX()<=10||mHead.getX()+mHead.mGenislik>=genislik-kalem)
        return true;
         if(mHead.getY()<=10||mHead.getY()+mHead.mGenislik>=yukseklik-kalem)
        return true;
         
        for(int i=1;i<Liste.size();i++)
         {
             int x=Liste.get(i).getX();
             int y=Liste.get(i).getY();
             if((x==mHead.getX())&&y==mHead.getY())
                 return true;
         }
        
        if(mYem.getX()==mHead.getX()&&mYem.getY()==mHead.getY())
        {
            KuyrukEkle();
            YemEkle();
        }
        
        return false;
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
                if(mHead.mYon!=YON.SAG)
                mHead.mYon = YON.SOL;
            }
            
             if(ke.getKeyCode()== KeyEvent.VK_RIGHT)
            {
                if(mHead.mYon!=YON.SOL) 
                mHead.mYon = YON.SAG;
            }
             
              if(ke.getKeyCode()== KeyEvent.VK_UP)
            {
                if(mHead.mYon!=YON.ASAGİ)
              mHead.mYon = YON.YUKARİ;
            }
              
               if(ke.getKeyCode()== KeyEvent.VK_DOWN)
            {
                if(mHead.mYon!=YON.YUKARİ)
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
            if(CarpısmaVarmı())
                mTimer.stop();
        }
         
    }
}
