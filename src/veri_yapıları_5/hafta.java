package veri_yapıları_5;

import java.util.Scanner;

class ekran
{
    deger ilk=null,son=null;
public void ekle(String s)
{
 for(int i=0;i<s.length();i++)
 {
     if(s.charAt(i) == '+' || s.charAt(i) == '-' || s.charAt(i) == '/' || s.charAt(i) == '*' || s.charAt(i) == '0' 
             || s.charAt(i) == '1' || s.charAt(i) == '2' || s.charAt(i) == '3' || s.charAt(i) == '4'
             || s.charAt(i) == '5' || s.charAt(i) == '6' || s.charAt(i) == '7' || s.charAt(i) == '8' || s.charAt(i) == '9')
     {
         deger d =new deger(s.charAt(i));
         if(ilk ==null)
         {
             ilk=d;
             son=d;
         }
         else
         {
             son.next=d;
             d.önceki=son;
             son=d;
         }
     }
 }
}
public void göster()
{
    deger gecici=ilk;
    while(gecici !=null)
    {
        System.out.println(gecici.c);
        gecici=gecici.next;
    }
}
public void işlem()
{
     char d1=0,d2=0,d3=0;
     int t1=0,t2=0;
     int sayaç=1;
     int k=0;
    deger gecici=ilk;
    char z=0;
        
        while(gecici != null)
         {
            
        d1=d2;
        d2=d3;
        d3=gecici.c;
        if((d3 == '+' || d3 == '-' || d3 == '*' || d3 == '/') && (d2 != '+' || d2 != '-' || d2 != '*' || d2 != '/')
              && (d3 != '+' || d3 != '-' || d3 != '*' || d3 != '/'))
        {
            t1=Character.getNumericValue(d1);                                            //d1
            System.out.println("t1 ilk="+t1);
            t2=Character.getNumericValue(d2);                                              //d2
            System.out.println("t1="+t1);
            System.out.println("t2="+t2);
            if(d3 == '/')
            t1=t1/t2;
            else if(d3 == '*')
                t1=t1*t2;
            else if(d3 == '-')
                t1=t1-t2;
            else if(d3 == '+')
                t1=t1+t2;
            z=(char)('0'+t1);
            System.out.println( z );
            deger d =new deger(z);
            System.out.println("t1 t2 ="+t1);
            System.out.println("sayaç="+sayaç);
            if(gecici.next != null)
            {
            gecici.next.önceki.önceki.önceki=d;
            d.next=gecici.next;
            }
            else
            {
                gecici.önceki.önceki=d;
                d.next=null;
            }
            
        }
        if(gecici.next==null)
                 System.out.println(gecici.c);
        gecici=gecici.next;
           }
       gecici=ilk;
       
        
}
    public static void main(String[] args) {
        Scanner k=new Scanner(System.in);
        System.out.println("String giriniz");
        String s=k.next();
        ekran e =new ekran();
        e.ekle(s);
        e.işlem();
        System.out.println("ali");
        e.göster();
        
    }
}
class deger
{
    char c;
    deger next;
    deger önceki;
    deger(char c)
    {
        this.c=c;
        this.next=null;
        this.önceki=null;
    }
}