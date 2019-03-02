package veri_yapıları_10;

import java.util.Scanner;

 class heap
{
    char dizi[];
    int boyut;
    heap(int N)
    {
        dizi=new char[N];
        boyut=0;
    }
//    void ekle(char yeni)
//    {
//        boyut++;
//        dizi[boyut-1]=yeni;//dizinin son elemanına yeni gelen elemanı ekliyorum
//        yukarıçık(boyut-1);//yukarı çık metodunu çagırdım ve paremetresine ekledigim indisi attım
//    }
    char[] ekle(char d[])
    {
        for(int i=0;i<d.length;i++)
        {
            boyut++;
        dizi[boyut-1]=d[i];//dizinin son indisine yeni gelen elemanı ekliyorum
        yukarıçık(boyut-1);//yukarı çık metodunu çagırdım ve paremetresine ekledigim indisi attım
        }
        return dizi;
    }
    void yukarıçık(int no)//ekleme metoduna yardımcı
    {
        int ata=(no-1)/2; //degeri ekledigim indisin üst kökünün indisini attım ata degişkenine 
        while(ata >=0 && dizi[ata] <dizi[no]) //eklenen deger atasından küçükse yer degiştiriyorum
        {
            char ara =dizi[ata];
            dizi[ata]=dizi[no];
            dizi[no]=ara;
            no=ata;
            ata=(no-1)/2;
        }
    }
    void ara(char ara) //istedigim eleman dizide varmı konturolü
    {
       int a=0;//birleşim için konturol için
        for(int i=0;i<boyut;i++)//dizi boyutu kadar gidip konturolümü yapıyorum
        {
            if(dizi[i] ==ara)
            {
                System.out.println(ara+" elemanı dizide mevcuttur");
                a=1;
                i=boyut;
            } 
         }
           if(a==0)
            System.out.println("aradıgınız eleman dizide mevcut deyildir");   
    }
    void göster()
    {
        for(int i=0;i<boyut;i++)
        {
            System.out.print(dizi[i]);
            System.out.print(",");
        }
        System.out.println("");
    }
    char[] sil()//mantık= dizi[ilk] =dizi[son] , son-- =ve sonrada dizi Max kurallara uygun şekilde düzenlenir
    {
        char tmp;
        tmp=dizi[0];
        dizi[0]=dizi[boyut-1];
        assagıin(0);
        boyut=boyut-1;
        dizi[boyut]=0;//son elemanı sıfır yapıyorumki geri döndürülen dizidede sıfır dönsün birleşim kesisim de sorun olmasın
        System.out.println(tmp);
        return dizi;
    }
    void assagıin(int no) //silmeye yardımcı
    {
        int sol=2*no+1,sag=2*no+2;
        while((sol < boyut && dizi[no] <dizi[sol]) || (sag <boyut && dizi[no] < dizi[sag]))
        {
            if(sag>= boyut || dizi[sol] > dizi[sag])
            {
                char ara =dizi[no];
                dizi[no]=dizi[sol];
                dizi[sol]=ara;
                no=sol;
            }
            else
            {
                char ara=dizi[no];
                dizi[no]=dizi[sag];
                dizi[sag]=ara;
                no =sag;
            }
            sol=2*no+1;
            sag=2*no+2;
        }
    }
     void kesisim(char d1[],char d2[])//mantık=birinci dizide ve ikinci dizide olan elemanı ekrana bas
    {
        int sayac=0;
        for(int i=0;i<d1.length;i++)
        {
            for(int j=0;j<d2.length;j++)
            {
                if((d1[i] !=0 && d2[i] !=0 ) && (d1[i] == d2[j]))
                {
                    System.out.print(d1[i]);
                    System.out.print(",");
                }  
            }
        }
         System.out.println("");
    }
     void birleşim(char d1[],char d2[]) //genel mantıgım =dizi2 yi tamamen yazdır,&& dizi2 de olmayıp dizi 1 de olanları yazdır
     {
        int a=0;//birleşimde ikinci kümede olmayıp birinci kümede olanları bulma kısmında konturol için kullandım
         for(int i=0;i<=d1.length;i++)//bunda d1.length = koyma sebebim son seferde d2 kümesini yazdırması için
         {
             for(int j=0;j<d2.length;j++)
             {
                 if(i == d1.length) //eşitse eyer son turdur ve d2 leri yazdır
                 {
                     System.out.print(d2[j]);
                     System.out.print(",");
                     a=1;
                 }
                 else //son tur deyildir
                 {
                     if(d1[i] == d2[j]) //d1 deki eleman eyer d2 deki elemana eşitse birleşime almıyacam
                         a=1; //yani a =1 e eşit oldugunda ekrana yazdırmıyorum
                 }
             }
             if(a ==0) //a ==0 sa ikinci kümede olmayıp birinci kümede olandır böylece ekrana yazdırıyorum
             {
                 System.out.print(d1[i]); 
                 System.out.print(",");
             }
             a=0;
         }
         System.out.println("");
     }
    
     public static void main(String[] args) {
         //a b c ç d e f g ğ h i ı j k l m n o ö p r s ş t u ü v y z
         Scanner k =new Scanner(System.in);
          System.out.println("dizi boyutunu giriniz");
         int boyut=k.nextInt();
         char c=0;
         char d1[]=new char[boyut];//birleşim kesişim işlemleri için 2 dizide lazım bana ondan girilenleri dizide tuttum
         char d2[]=new char[boyut];
         heap h1 =new heap(boyut);
         heap h2 =new heap(boyut);
         for(int i=0;i<boyut;i++) //birinci diziye eleman girme
         {
             System.out.println("Birinci kümenin "+i+". elemanını giriniz");
             d1[i]=k.next().charAt(0);
         }
         d1=h1.ekle(d1);
         for(int i=0;i<boyut;i++) //ikinci diziye eleman girme
         {
             System.out.println("ikinci kümenin "+i+". elemanını giriniz");
             d2[i]=k.next().charAt(0);
         }
         d2=h2.ekle(d2);//burda dizinin düzenlenmiş halini tekrar d2 ye atıyorum
       // d2 = h2.sil(); // silme işlemindede dizinin düzenlenmiş halini d2 ye atıyorum 
         System.out.println("-------");
       //  h1.kesisim(d1, d2);
         h1.birleşim(d1, d2);
          
//         h1.ekle('a');
//         h1.ekle('b');
//         h1.ekle('c');
//         h1.ekle('g');
//         h1.ekle('d');
//         h1.göster();
//        
//         heap h2 =new heap(5);
//         h2.ekle('m');
//         h2.ekle('n');
//         h2.ekle('z');
//         h2.ekle('k');
//         h2.ekle('y');
//         h2.göster();
//        
     }
}