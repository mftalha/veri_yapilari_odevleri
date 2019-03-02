package veri_yapıları_5;

import java.util.Stack;
        
public class odev_4 {   //dizi sorusu
   static  Stack s1=new Stack();
    static  Stack s2=new Stack();
   static String d[];
    int tb=0,ts=d.length-1;  
   
    public void bas(String d[],String deger)
    {
        if(d[tb] ==null)
        {
            d[tb]=deger;
            s1.push(deger);
            tb++;
        }
        else
        {
            System.out.println("stack basa daha fazla eleman eklenemez");
        }
    }
    public void son(String d[],String deger)
    {
        if(d[ts] ==null)
        {
            d[ts]=deger;
            s2.push(deger);
            ts--;
        }
        else
        {
            System.out.println("stack son a  daha fazla eleman eklenemez");
        }
    }
    public void göster()
    {
        System.out.println("stack bas="+s1);
        System.out.println("stack son"+s2);
    }
     public static void main(String[] args) {
         d=new String[5];
       odev_4 o =new odev_4();
       o.bas(d, "k");
       o.bas(d, "l");
       o.son(d, "m");
       o.son(d, "z");
       o.bas(d, "f");
       o.bas(d, "y");//taşma olan yer bunu almadı
       o.göster();
    }
}
