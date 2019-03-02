package veri_yapıları_3.hafta;
public class kuyruk {
int N=4;
private int K[]=new int[N];
private int on;//kuyruk başı
private int arka;//kuyruk sonu
private int elemansayısı;

public kuyruk()
{
    on = arka =elemansayısı=0;
}
public boolean bosmu()
{
    return elemansayısı==0;
}
public boolean dolumu()
{
    return elemansayısı==N;
}
public int Ekle(int yeni)
{
    if(dolumu())
    {
        System.out.println("Kuyruk Dolu");
        return -1;
    }
    else
    {
        K[arka]=yeni;
        arka++;
        if(arka == N) arka=0;
        elemansayısı++;
        return 0;
    }
}
public int cikart()
{
    int id =-1;
    if(bosmu())
    {
        System.out.println("Dizide elenan bulunmamakta");
        return -1;
    }
    else
    {
        id=on;
        on++;
        if(on ==N) on=0;
        elemansayısı--;
        return K[id]; //sildigimiz elemanı döndrüyor
    }
}
    public static void main(String[] args) {
        kuyruk k =new kuyruk();
        
        k.Ekle(15);
        k.Ekle(27);
        k.Ekle(36);
        k.Ekle(45);
        System.out.println(k.cikart());
        System.out.println(k.cikart());
        System.out.println(k.cikart());
        System.out.println(k.cikart());
        k.Ekle(65);
        System.out.println(k.cikart());
    }
}
