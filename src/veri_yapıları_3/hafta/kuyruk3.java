package veri_yapıları_3.hafta;

class kuyruk3dugum
{
    int eleman;
    kuyruk3dugum sonraki;

    public kuyruk3dugum(int eleman) 
    {
        this.eleman=eleman;
        this.sonraki=null;
    }   
}
 class kuyruk3 {
    private kuyruk3dugum ilk=null,son=null;
 
    public boolean bosmu()
    {
        return ilk==null;
    }
    
    public void ekle(int yeni)
    {  //dizinin son elemanına ekleme yapıyoruz
    kuyruk3dugum k=new kuyruk3dugum(yeni); 
    if(ilk ==null)
    {
        ilk=k;
        son=k;
    }
    else
    {
        son.sonraki=k;
        son=k;
        son.sonraki=null; //yazmasamda sıkıntı olmuyor
    }
    }
    public void sil()  //silme işleminde ilki bir sonrakine götürüyoruz böylece ilk elemanın adresi boşa düşer ==silinir
    {
        if(bosmu())
        {
            System.out.println("Baglı liste zaten boş");
        }
        else
        {
        int çıkartılan=ilk.eleman;
        ilk=ilk.sonraki;
        System.out.println("çıkartılan eleman ="+çıkartılan); //diziden silinen yani bir sonraki elemana gidince baglantısız
        }                                                     //kalan
    }
     public static void main(String[] args) {
      kuyruk3 k =new kuyruk3();
      
         System.out.println(k.bosmu());//true dizi boş
         k.ekle(5);
         k.ekle(15);
         System.out.println(k.bosmu());//false dizi boş deyil
         k.ekle(25);
         k.ekle(35);
         k.sil();//5 i silecek
         k.sil();//15 i silecek
         k.sil();//25 i silecek
         k.sil();//35 i silecek    //dizinin ilk elemanından son elemanına dogru siliyoruz
         k.sil();//dizide silinecek eleman bulunamadı
         System.out.println(k.bosmu());//true dizi boş
     }
}
