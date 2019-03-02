package veri_yapıları_3.hafta;
public class kuyruk2 { //static dizide sondan ekleme baştan silme(yıgın yapısı)
int n=5;
int K[]=new int[n];
int ilk;
int son;
int elemansayısı;

public kuyruk2()
{
    ilk = son =elemansayısı =0;
}

public boolean bosmu()  
{
   return elemansayısı==0;
}
public boolean dolumu()
{
    return elemansayısı ==n;
}
public void ekle(int yeni)
{ //eklemeyi dizinin sonuna yapıyoruz
    if(dolumu())
    {
        System.out.println("Dizi dolu");
    }
    else
    {
        K[son]=yeni;
        son++;
        elemansayısı++;
    }
}
public void sil()
{ //silme işleminin dizinin ilk elemanından yapıyoruz
    int id=0;
    if(bosmu())
    {
        System.out.println("dizi zaten boş");
    }
    else
    {
        id=ilk;
        ilk++;
        elemansayısı--;
        System.out.println("silinen eleman="+K[id]);
    }
}
    public static void main(String[] args) {
        kuyruk2 k =new kuyruk2();
        k.ekle(15);
        k.ekle(27);
        k.ekle(69);
        k.ekle(78);
        k.ekle(97);
        k.ekle(5);//dizi dolu dedigi yer 6. eleman oldugu için
        k.sil();
        k.sil();
        k.sil();
        k.sil();
        k.sil();
        k.sil();//5 eleman silindigi için burda dizi zaten boş diyecek
        
    }
}
