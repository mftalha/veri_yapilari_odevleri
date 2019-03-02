package veri_yapıları_3.hafta;

public class ögrenci {
    String ad;
    String soyad;
    int no;
    ögrenci next;
    
    public ögrenci(String ad,String soyad,int no)
    {
        this.ad=ad;
        this.soyad=soyad;
        this.no=no;
        this.next=null;
                
    }
}
class metotlar{
    ögrenci ilk=null,son=null;
    public void ekle(String ad,String soyad,int no)
    {
        ögrenci o=new ögrenci(ad, soyad, no);
        if(ilk==null){
            ilk=o;
            son=o;
        }
        else{
            son.next=o;
        son=o;
        son.next=null;
        }        
       
    }
    public void listele()
    {
        ögrenci gecici=ilk;
      while(gecici !=null)
      {
          System.out.println(gecici.ad+" "+gecici.soyad); 
          gecici=gecici.next;
      }
    }
    public static void main(String[] args) {
     
        metotlar m =new metotlar();
        m.ekle("elif", "yıldız", 554);
        m.ekle("merve","yılmaz" , 7765);
        m.ekle("ufuk", "ucar", 4587);
        m.listele();
        
    }      
}