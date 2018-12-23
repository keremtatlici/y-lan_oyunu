package yılan_oyunu;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.*;
import yılan_oyunu.Yilan;

public class AnaPencere extends JFrame 
{
    private int mGenislik = 600, mYukseklik = 600;//genislik ve yükseklik
    
    private static AnaPencere mPencere=null;//static fonksiyonunda çekilmesi için 
   
    private AnaPencere()//pencerenin boyutunun değiştirilmemesi için private.
    {
        setDefaultCloseOperation(EXIT_ON_CLOSE);//Pencere kapatıldığında uygulamanında kapatılması için.
        
        SetDimension(mGenislik,mYukseklik);//yükseklik ,genişliğini ayarlıyor.
        setResizable(false);//Pencerenin büyültülüp küçültmesini önlemek için. 
        
        Yilan Y = new Yilan();//Yeni Yılan ekranı
        add(Y);
    }
    public static AnaPencere PencereGetir()//oluşan bir ekran varsa yenisini oluşturmamak için
    {
        if(mPencere ==null)
            return new AnaPencere();
        
        return mPencere;
    }
   
    public void SetDimension (int Genislik , int Yukseklik)//Bu fonksiyon bilgisayarın çözünürlüğünü çekip pencerenin tam ortaya yerleşmesi içindir.
    {
        Dimension Dim =  Toolkit.getDefaultToolkit().getScreenSize();
        
        int PosX=0;
        int PosY=0;
        
        if(Genislik+100>Dim.width)    //buradaki kod pencerenin bilgisayar çözünürlüğünü aşmasını önlemek için    
            mGenislik = Dim.width-100;
        
        if(Yukseklik+100>Dim.height)
            Yukseklik=Dim.height-100;
        
        PosX = (Dim.width-mGenislik)/2;
        PosY =(Dim.height-mYukseklik)/2;
        
        setBounds(PosX, PosY, mGenislik , mYukseklik); 
    }
}
