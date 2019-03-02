package veri_yapıları_6.hafta;
class tutt//dizim
{
    int x;
    tutt next;
    tutt prev;
   tutt(int x)
   {
       this.x=x;
       this.next=null;
       this.prev=null;
   }
} 
class yap//metotlarım             //P(x)= x3+3x2+5x+10 ==arreyliste bu elemanları atıyorum
{
    int zz=1;
    tutt ilk=null,son=null;  
    int ıslem(int x) //polinomu oluşturdugum yer
    {
     int t1=1,t2=1,t3=0;  
     for(int i=0;i<3;i++)//x3 ve x2 degerlerinin buluyorum
     {
         t1*=x;//x3 degeri
         if(i<2)
         {
             t2*=x;//x2 degeri
         }
     }
     t3=t1+3*t2+5*x+10;
     return t3;   
    }
    void başaekle(int x) //dizinin başına ekleme yapma
    {
        zz++;
        yap y =new yap();
        int t1=y.ıslem(x);
        tutt t =new tutt(t1);
        if(ilk==null)
        {
            ilk=t;
            son=t;
        }
        else
        {           
            t.next=ilk;
            ilk.prev=t;
            ilk=t;
        }
    }
    void sonaekle(int x)//dizinin sonuna ekleme yapma
    {
        zz++;
        yap y =new yap();
        int t1=y.ıslem(x);
        tutt t =new tutt(t1);
        if(ilk==null)
        {
            ilk=t;
            son=t;
        }
        else
        {
            son.next=t;
            t.prev=son;
            son=t;
        }
    }
    void isteke(int x,int z)//istedigim yere elemanı atma
    {
        yap y =new yap();
        int p=1;//sayaç olarak kullanıyorum
        tutt gecici=ilk,gecici2=gecici;     
        int t1=y.ıslem(x); //verdigim x degerine göre x degerini alıyorum
        tutt t =new tutt(t1);
        if(z==1)//eyer gelen eleman dizi aralıgında biryere atılmak istniyorsa
        {
           t.next=ilk;
           ilk.prev=t;
           ilk=t;
        }
        else if(zz<=z) //eyer eklenmek istenen aralık son indisse veya daha fazlası ise son indise eklenir eleman
        {
            son.next=t;
            t.prev=son;
            son=t;
        }
        else //eyer deger dizi içindeki bir aralıga atılmak isteniyorsa
        {
        while(gecici !=null)
        {
            if(p==z)//eyer istedigim indisi gelirse ==araya ekleme
            {
                gecici2.next=t;
                t.prev=gecici2;
                t.next=gecici;
                gecici.prev=t;
            }
            gecici2=gecici;//degişiklik yapacagım indisin bir öncesi
            gecici=gecici.next;//degişiklik yapacagım indisin bir sonrası
            p++;
        }    
        }
    }
    void sondansil()
    {
        son=son.prev;
        son.next=null;
    }
    void ilksil()
    {
        ilk=ilk.next;
        ilk.prev=null;
    }
    void isteks(int x)
    {//x istedigim indis =istedigim indisden elemanı silme
        int y=1;
        tutt gecici=ilk,gecici2=gecici;//gecici2 bir önceki elemanı gecici o anki elemanı tutuyor
        while(gecici !=null)
        {
            if(y==x && y!=1 && y!=zz)
            {
                gecici2.next=gecici.next;//gecici2 yi tutmadan yapamadım
                gecici.next.prev=gecici2;
            }
            y++;
            gecici2=gecici;
            gecici=gecici.next;
        }
    }
    int  topla() //dizideki elemanları toplama
    {
        tutt gecici=ilk;
        int toplam=0;
        while(gecici !=null)
        {
            toplam+=gecici.x;
            gecici=gecici.next;
        }
        return toplam;
    }
    void göster()
    {
        tutt gecici=ilk;
        while(gecici !=null)
        {
            System.out.println(gecici.x);
            gecici=gecici.next;
        }
    }
    public static void main(String[] args) {
       yap y =new yap();
       y.başaekle(5);
       y.başaekle(0);
       y.sonaekle(2);
       y.başaekle(3);
       y.sonaekle(1);
       y.sonaekle(4);
      // y.başaekle(2);
       y.isteke(5, 1);
       y.isteks(2);
       y.isteks(3);
       y.göster();
        System.out.println("Toplam ="+y.topla());
    }
}