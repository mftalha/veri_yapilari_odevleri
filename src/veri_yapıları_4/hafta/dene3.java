package veri_yapıları_4.hafta;
import java.util.Stack;
public class dene3 {
    elemann bas=null , son=null;  
    void ekle(String s){
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='(' || s.charAt(i)=='{'|| s.charAt(i)=='[' || s.charAt(i)==')' || s.charAt(i)==']' || s.charAt(i)=='}' )
          {
          elemann e =new elemann(s.charAt(i));
            if(bas==null){
                bas=e;
                son=e;
            }
            else 
            {
           e.ileri=bas;
            bas=e;
            }           
        }
            
        }   
    } 
    void göster2()
    {
        elemann gecici =bas;
        while(gecici !=null)
        {
            System.out.println(gecici.icerik);
            gecici=gecici.ileri;
        }
    }
    void goster(){
        elemann gecici=bas;
        int a1=0,a2=0,a3=0,k1=0,k2=0,k3=0,z=1;
        while(gecici!=null){
           if(gecici.icerik == '(')
               a1++;
           else if(gecici.icerik == '[')
               a2++;
           else if(gecici.icerik == '{')
               a3++;
           else if(gecici.icerik == ')')
               k1++;
           else if(gecici.icerik == ']')
               k2++;
           else if(gecici.icerik == '}')
               k3++;
           
            if(a1>k1 || a2>k2 || a3>k3)
        {
            System.out.println("parantez açma sırasında hata");
            z=0;
            return;
        }
        if(a1+2==k1 || a2+2==k2 || a3+2==k3){
            System.out.println("parantez sırası hatası");
            z=0;
            return;
        }
        gecici=gecici.ileri;
        }
        
        if(a1+a2+a3!=k1+k2+k3)
        {
            System.out.println("parantez açma kapatma sayıları orantısızdır");
        z=0;
        }
        if(z==1)
        {
            System.out.println("Stringde parantez sayısı ve sırası dogrudur");
        }
}
    public static void main(String[] args) {
        dene3 y=new dene3();
        y.ekle("{}()[]");
        y.goster();
    }
}
   class elemann
   {
        char icerik;
        elemann ileri;
        public elemann(char icerik)
        {
            this.icerik=icerik;
            this.ileri=null;
        }
    }  