package veri_yapıları_7.hafta;

import java.util.Scanner;

public class odev_2 {//lineer yerlleştirme =diziye eleman atıyoruz eyer o indis doluysa bir sonraki indise atıyor elemanı
    
    int boyut;
     int d[];
     String s[];
     odev_2(int boyut)
     {
         this.boyut=boyut;
          d =new int [boyut];
          s=new String[boyut];
     }
     
     int indis=0,konturol=0;//indis dizide kaçıncı indise ekleyecegim,konturol dizinin o elemanı boş deyilse indisi arttıracam
        boolean b=true;
     public void ekle(int numara,String isim)
     {
          indis=numara%d.length;
         konturol=indis;
         int sayaç=0;
         b=false; //elemanı ekledikten sonra dizinin sonuna kadar gitmemek için 
         while(b == false && sayaç<d.length)//sayacı d.length den küçük yapma sebebim dizinin ful dolumu diye konturolü için
         {
             if(d[konturol] ==0)
             {
                 d[konturol] =numara;
                 s[konturol] =isim;
                 b=true;
             }
             sayaç++;
             if(konturol ==d.length-1)//konturol dizinin son elemanına geldiyse 0. elemana atıyorrum konturolü
             konturol=0;
             konturol++;
         }
     }
     public void sil(int sil)
     {
         for(int i=0;i<d.length;i++)
         {
             if(d[i]==sil)//sil ==numara 
             {
                 d[i]=0;
                 s[i]=null;
             }
         }
     }
     public void göster()
     {
         for(int i=0;i<d.length;i++)
         {
             System.out.println(i+".indis="+d[i]+","+s[i]);
         }
     }
     public void arama(int aranacak)//dizi indisine göre arama işlemini yaptım
     {
         for(int i=0;i<d.length;i++)
         {
             if(d[i]%d.length == aranacak%d.length && s[i]!=null )//ve baglacını koyma sebebim 0.modu ararken dizinin boş 
             {                                                    //oldugu yerleride çagırması
                 System.out.println(i+".indis="+d[i]+","+s[i]);
             }
         }
     }
     
     public static void main(String[] args) {
         Scanner k =new Scanner(System.in);
         System.out.println("dizi boyutu ?");
         int boyut=k.nextInt();
         odev_2 o =new odev_2(boyut);//dizi boyutubu paremetre gönderdim
        o.ekle(2, "ahmet");
        o.ekle(7, "celil");
        o.ekle(5, "canan");
        o.ekle(26, "ismail");
        o.ekle(39, "yakup");
        o.ekle(13, "feyza");
        o.göster();
         System.out.println("---------------------------------------------------");
        o.sil(5);
        o.göster();
         System.out.println("---------------------------------------------------");
         o.arama(2);
    }
}
