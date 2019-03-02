package veriyapıları_dene_2;
public class Listele {
    Ogrenci ilk=null,son=null;
    public void ekle(int no,String isim,String soyisim)
    {
        Ogrenci ögr =new Ogrenci(no, isim, soyisim);
        if(ilk ==null)
        {
           ilk=ögr;
           son=ögr;
        }
        else
        {
            son.next=ögr;
            son=ögr;
        }
    }
    public void Listele()
    {
       Ogrenci geçici=ilk;
       while(geçici !=null)
       {
           System.out.println(geçici.no+" "+geçici.isim+" "+geçici.soyisim);
           geçici=geçici.next;
       }
    }
    public void sil(int no)
    {
       Ogrenci geçici=ilk,birönceki =ilk;
       while(geçici !=null)
       {
       if(geçici.no == no)
       {
           break;
       }
       birönceki=geçici;
       geçici=geçici.next;
       }
       if(geçici == null)
       {
           System.out.println("Silmek İstediginiz Ögrenci Listede Bulunmamaktadır...");
       }
       else
       {
           if(ilk == son)
           {
               ilk=null;
               son=null;
           }
           else
           {
               if(geçici == ilk)
               {
                   ilk=ilk.next;
               }
               else
               {
                   if(geçici == son)
               {
                   son=birönceki;
                   son.next=null;
               }
               else
               {
                   birönceki.next=geçici.next;
               }
               }
           }
       }
    }
    public void Arama(int no)
    {
        Ogrenci geçici=ilk;
        while(geçici != null)
        {
            if(geçici.no == no)
            {
                System.out.println(geçici.no+" "+geçici.isim+" "+geçici.soyisim);
                break;
            }
        }
        if(geçici == null)
        {
            System.out.println("girmiş oldugunuz ögrenci numarası listede bulunmamaktadır");
        }
    }
}
class Ogrenci
{
   int no;
   String isim,soyisim;
   Ogrenci next;
   public Ogrenci(int no,String isim,String soyisim)
   {
       this.no=no;
       this.isim=isim;
       this.soyisim=soyisim;
       this.next=null;
   }
}