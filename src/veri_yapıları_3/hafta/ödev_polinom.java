package veri_yapıları_3.hafta;

class tut
{
    int x;
    tut sonraki;
    tut(int x)
    {
        this.x=x;
        this.sonraki=null;
       
    }
     
}

public class ödev_polinom { //4x'+2
    tut ilk=null,son=null;
    public void işlem(int sayı,int üst,int üst2) //işlem yapıp diziye elemanı ekliyorum
    {
        
        int sonuc=0;// işlem sonucu 
        int hesap=1;//x üzeri y
        int hesap2=1;
        for(int i=1;i<=üst;i++) //burda üsteli hesaplıyorum
        {
            hesap*=sayı;
        }
        for(int i=1;i<=üst2;i++){
            hesap2*=sayı;
        }
        sonuc=4*hesap+5*hesap2+2;//işlem sonucu
        tut t =new tut(sonuc);
        System.out.println("bu elemanın sonucu="+sonuc);
        if(ilk==null)
        {
            ilk=t;
            son=t;
        }
        else
        {
            son.sonraki=t;
            son=t;
            son.sonraki=null;
        }
    }
    public void hesapla()//dizideki elemanları topluyorum
    {
        int topla=0;
        tut gecici=ilk;
        while(gecici !=null)
        {
            topla+=gecici.x;
            gecici=gecici.sonraki;
        }
        System.out.println("bagıl listedeki elemanların toplamı="+topla);
    }
    
    public static void main(String[] args) {
        
        ödev_polinom ö =new ödev_polinom(); //(işlemyapılacak sayı,üstel)
        ö.işlem(3, 2,3);//38
        ö.işlem(2, 2,3);//18
        ö.işlem(2, 4,3);//66
      
        ö.hesapla();        
    }
}
