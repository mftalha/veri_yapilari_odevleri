package veri_yapıları_4.hafta;
public class ekran_dnsm 
{
    dizii ilk=null,son=null;
    public void ekle(int x) //10 luk tabanda gelip 2 lik tabana çevirecegim sayı
    {
        int tut=0;
       while (x>=1)
       {
           tut=x%2;//x in 2 ye bölümünden kalan bunu dizinin en üstüne atıyorum
           x=x/2;
           dizii d =new dizii(tut);//diziye eleman alma
           if(ilk==null)
           {
            ilk=d;
            son=d;
           }
           else
           {
             ilk.previous=d; //dizinin ilk elemanına deger verme
             d.next=ilk;
             ilk=d;
           }
       }
    }
    public String döndür()
    {
        String döndür="";
        dizii gecici=ilk;
        while(gecici != null)
        {
            döndür+=gecici.s; //string ile dizinin gelen degerini toplama
            gecici=gecici.next;
        }
        return döndür; //stringi geri döndürdüm
    }
    public static void main(String[] args) {
        
        ekran_dnsm e =new ekran_dnsm();
        e.ekle(20);
        System.out.println(e.döndür());
    }
}

class dizii
{
   int s;
   dizii previous,next;
   dizii(int s)
   {
     this.s=s;
     this.next=null;
     this.previous=null;
   }
}