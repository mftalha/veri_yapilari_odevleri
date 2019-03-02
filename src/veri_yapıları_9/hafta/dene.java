package veri_yapıları_9.hafta;
public class dene {
int sayaç=0;
class dugum
{
    
}
 int azami(int a, int b) 
    {

        return (a > b) ? 5 : 3;

    }    
  void ekle(int no)
  {
      if(no<3)
      {
          System.out.println("n"+no);
          no++;        
          ekle(no);
          sayaç++;
      }
      System.out.println("s"+sayaç);
       ekle(no);
  }
 
    public static void main(String[] args) {
        dene d =new dene();
       // System.out.println(d.azami(8,11)); 
       d.ekle(0);
    }
}
