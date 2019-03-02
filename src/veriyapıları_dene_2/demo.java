package veriyapıları_dene_2;

import java.util.Scanner;

public class demo {
    public static void main(String[] args) {
     Scanner k=new Scanner(System.in);
     int seç=-1;
        Listele ögrenci =new Listele();
        do
        {
        System.out.println("1-Eklemeİşlemi \n2-Listelemeİşlemi \n3-Silmeİşlemi \n4-Arama \n0-Çıkış");
        seç=k.nextInt();
        switch(seç)
        {
            case 1:
                System.out.println("Ögrenci No ?");
                int no=k.nextInt();
                System.out.println("Ögrenici Ad ?");
                String isim=k.next();
                System.out.println("Ögrenci Soyİsim ?");
                String soyisim=k.next();
                ögrenci.ekle(no, isim, soyisim);
                System.out.println("Ekleme İşlemi Gerçekleştirildi");
                break;
            case 2:
                ögrenci.Listele();
                break;
            case 3:
                System.out.println("Silmek İstediginiz Ögrencinin Numarası?");
                int numara=k.nextInt();
                ögrenci.sil(numara);
                System.out.println("Silme İşlemi Gerçekleşti");
                break;
            case 4:
                System.out.println("Arama yapmak istediginiz Numara ?");
                int arama=k.nextInt();
                ögrenci.Arama(arama);
                break;
        }
    }while(seç !=0);
        
    }    
}
