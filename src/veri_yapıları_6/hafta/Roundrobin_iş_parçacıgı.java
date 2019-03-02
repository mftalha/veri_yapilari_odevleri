package veri_yapıları_6.hafta;
public class Roundrobin_iş_parçacıgı
{
    tut ilk=null,son=null;
    int kilk=0,kson=0;//kilk dizi o anki eleman sayısı , kson dizideki toplam eleman sayısı
   public void ekle(int s)//gelen eleman iş parçacık boyutu
   {
       tut t =new tut(s);
       if(ilk==null) //ilk eleman bossa ilk elemana atıyorum degeri
       {
           ilk=t;
           son=t;
           System.out.println("ilk="+ilk.t);
           kilk++;
           kson++;
       }
       else//dizi boş deyilse en sona ekleme yapıyorum
       {
           son.next=t;
           son=t;
           kson++;
       }
   }
   public void islem(int z)//iş parçacıgı boyutu
   {
     if(kson >= kilk)//dizide eleman varsa
     {
         if(ilk.t>z) //eyer gelen iş parcagı yapılacak işden büyükse iş parçacıgından gelen elemanı çıkartıp en sona atıyoruz
         { //ilk elemanıda siliyorum
             ilk.t-=z;
             son.next=ilk;
             son=ilk;
             ilk=ilk.next;
             System.out.println("sona eklendi="+son.t);
             kilk++;
             kson++;        
         }
         else
         {//eyer gelen eleman iş parçacıgına eşitse ve küçükse ilk elemanı siliyorum
             System.out.println("silindi="+ilk.t);
             ilk=ilk.next;
             kilk++;
         }
     }
     else
           System.out.println("dizi boş !!!");
   }
    public static void main(String[] args) {
        Roundrobin_iş_parçacıgı r=new Roundrobin_iş_parçacıgı(); //clasdaki metotları çagırmak için 
        r.ekle(18);                                              //class degişkeni oluşturuyorum
        r.ekle(9);
        r.ekle(12);
        r.islem(10);//dizi sonuna 8 eklendi 
        r.islem(10);//9 silindi
        r.islem(10);//2 sona eklendi
        r.islem(10);//8 silindi
        r.islem(10);//2 silindi
        r.islem(10);//dizi boş
        r.islem(10);//dizi boş
    }
}
class tut
{
    int t;
    tut next;
    tut(int t)//gelen elemanları tutacak =kuyruk yapısı
    {
        this.t=t;
        this.next=null;
    }
}
