package veri_yapıları_7.hafta;

import java.util.Scanner;

class dugum
{
    int sayı;
    dugum next;
    dugum(int say)
    {
        sayı=say;
        next=null;
    }
}
class  metotlar
{
    dugum []tablo; //zinciri oluşturuyorum
    metotlar(int s1)//dizi boyutunu aldım parametre olarak
    {
     tablo= new dugum[s1];//zincir metodu
     for(int i=0;i<s1;i++) //zincir dizisinin ilk elemanınlarına null atıyorum
    {
      tablo[i]=null;
    }
    }
    
    void ekle(int gsayı)//zincire eleman ekleme
    {
        
       if(tablo[gsayı%tablo.length] == null)//zincirin ilk elemanına deger atama
       {
        tablo[gsayı%tablo.length] =new dugum(gsayı);   
       }
       else //eyer zinirin ilk elemanı doluysa
       {
          dugum ek= tablo[gsayı%tablo.length];
           while(ek.next !=null ) //zincirin bir sonraki elemanı boş olana kadar devam ediyor
           {                      //2. elemandan başlıyor konturole zaten birinci eleman dolu olmasa elseye girmez
               ek=ek.next; 
           }
                ek.next=new dugum(gsayı);//ek.next yapmam sebebim ek yapınca yol belirtmemiş oldugumdan sona eklemiyor
       }
    }
     void göster(int aranacak) //bu metodu zincir kuralını çalıştırabiliyormuyum konturolü için oluşturdum
     { //zincirin herhangi bir indisindeki degerlere ulaşmamı saglıyor
         if(tablo[aranacak%tablo.length] ==null)
             System.out.println("aranan eleman dizide yoktur");
         else
         {
            dugum konturol =tablo[aranacak%tablo.length];
            while(konturol !=null )
            {
                if(konturol.sayı == aranacak )
                {
                  //  System.out.println(konturol.sayı);
                }
                System.out.println("yy"+konturol.sayı);
                konturol=konturol.next;
            }
         }
     }
     int konturol(int knt)//buradan döndürdügüm deger eyer 1 se aranan eleman dizide var demektir ==sayaç için
     {
        int x=0;
        dugum konturol =tablo[knt%tablo.length];
        while(konturol !=null ) //eyer zincir bossa hiç girmez doluysada boş olana kadar ilerler
         {
            if(konturol.sayı == knt )
            x=1;//eyer ikinci dizideki eleman birinci dizide varsa sayacı arttırmak için geriye bir döndürüyorum
            konturol=konturol.next;
         }
         return x;
     }
      int altkümemi(int d[])
     {
         int sayaç=0;//dizinin lengtine eşitmi diye bakacagım için 1 den başlattım
         for(int i=0;i<d.length;i++)
         {
            if(konturol(d[i]) ==1)//eyer gellen deger 1 se sayacı arttırırım
                sayaç++;
         }
         return sayaç; //ikinci dizideki kaç elemanın birinci dizide bulunduguna bakıyoruz
     }
     public static void main(String[] args) {
         int eleman=0;
         Scanner k =new Scanner(System.in);
         System.out.println("zincir dizisinin boyutunu giriniz");
         int dboyut=k.nextInt();
        metotlar m =new metotlar(dboyut);
         System.out.println("zincir dizisine kaç eleman eklemek istiyorsunuz ?");
         int zboyut=k.nextInt();
         for(int i=0;i<zboyut;i++)
         {
             System.out.println((i+1)+". eleman ?");
             eleman=k.nextInt();
             m.ekle(eleman);
         }
         System.out.println("ikinci dizinin boyutunu giriniz");
         int d2=k.nextInt();
        int d[]=new int[d2];
        for(int i=0;i<d.length;i++)
        {
            System.out.println("dizinin "+(i+1)+". elemanını giriniz");
            d[i]=k.nextInt();
        }
        if(m.altkümemi(d) == d.length) 
             System.out.println("ikinci dizi birinci dizinin alt kümüsidir");
        else
             System.out.println("ikinci küme birinci kümenin alt kümesi deyildir");
    }
}