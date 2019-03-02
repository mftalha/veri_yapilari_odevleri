package veri_yapıları_4.hafta;

import java.util.Scanner;

public class ekranPrntz 
{
    dizi ilk=null,son=null;
   public void stringal(String a) //Stringi aldıgım ve parantezleri diziye ekledigim metot
   {
       for(int i=0;i<a.length();i++) //Stringdeki her kelimeyi ayrı ayrı konturol etmek için kelime sayısı kadar dönecek
       {
          if(a.charAt(i) == '{' || a.charAt(i) == '(' || a.charAt(i) == '[' || a.charAt(i) == '}'  //konturol noktası
                  || a.charAt(i) == ']'  || a.charAt(i) == ')') //eyer bunlardan birisiyse diziye ekle demek istedim
          {
              dizi d =new dizi(a.charAt(i));
              
              if(ilk ==null)//ilk eleman bossa
              {
                  ilk =d;
                  son=d;
              }
              else //ilk eleman bos deyilse
              {
                  
                  ilk.önceki=d; // gelen elemanları başa ekleme
                  d.sonraki=ilk;
                  ilk=d;
              }                     
          }
       }
   }
    public void konturol()
    {
       dizi gecici=ilk;
       int a1=0,k1=0,a2=0,k2=0,a3=0,k3=0,z=0; // a1=( ,a2 =[ , a3={  ,, k lerde tersi aynı
       while(gecici != null)        
       {                        
        if(gecici.s == '(')
            a1+=1;    
        else if(gecici.s == '[')
        a2+=1;
        else if(gecici.s == '{')
        a3+=1;
        else if(gecici.s == ')')
           k1+=1;
        else if(gecici.s == ']')
           k2+=1;
        else if(gecici.s == '}')
           k3+=1;
       
        if(a1 > k1 || a2>k2 || a3 >k3 ) //diziye ekleme mantıgımız son ekledigimiz en başta oldugu için
        {                               //kapatma sayısı açma sayısından fazla olmalı tersiyse açma sırası yanlışlıgı vardır
            System.out.println("Parentez açma sırasında hata"); // kapatma parentezi açma parentezinden önce açılırsa
            z=-1;
            break;
        }
        gecici =gecici.sonraki;
       }
 
       if(z != -1)
       {
        if(a1 == k1 && a2==k2 && a3==k3)
     {
         System.out.println("Girilen Stringde Parantez sayısı ve sırası dogrudur");
     }
     else
     {
         System.out.println("Girilen Stringde açılan parentez kapanan parentez orantısı yanlıştır");
     }    
       }
    
    }
    
    public static void main(String[] args) {
      
        ekranPrntz e =new ekranPrntz();
        Scanner k =new Scanner(System.in);
        System.out.println("Konturol Edilecek String ?");
        String s=k.nextLine(); 
        e.stringal(s);  //stringi alıyorum
        e.konturol();   //yapmak istedigim işlemin konturolü
    }
}

class dizi
{
    char s;
    dizi sonraki,önceki;
   dizi(char s)
   {
       this.s=s;
       this.sonraki=null;
       this.önceki=null;
   }
}