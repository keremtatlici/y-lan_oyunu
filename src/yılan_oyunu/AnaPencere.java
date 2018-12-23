package yılan_oyunu;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.*;

public class AnaPencere extends JFrame {
    
    private int mGenislik = 600, mYukseklik = 600;
    
    
   private static AnaPencere mPencere=null;
   private AnaPencere()
    {
        setDefaultCloseOperation(EXIT_ON_CLOSE);  
        SetDimension(mGenislik,mYukseklik);
        setResizable(false);
        
        Yilan Y = new Yilan();
        
        add(Y);
    }
    public static AnaPencere PencereGetir()
    {
        if(mPencere ==null)
        {
            return new AnaPencere();
        } 
        return mPencere;
      
    }
    //Bilgisayarın çözünürlüğünü çeken fonk
    public void SetDimension (int Genislik , int Yukseklik)
    {
        Dimension Dim =  Toolkit.getDefaultToolkit().getScreenSize();
        
        int PosX=0;
        int PosY=0;
        
        if(Genislik+100>Dim.width)
        {
            mGenislik = Dim.width-100;
        }
        if(Yukseklik+100>Dim.height)
        {
            Yukseklik=Dim.height-100;
        }
        PosX = (Dim.width-mGenislik)/2;
        PosY =(Dim.height-mYukseklik)/2;
        
        setBounds(PosX, PosY, mGenislik , mYukseklik);
                    
        
    }
}
