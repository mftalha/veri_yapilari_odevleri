package veri_yapıları_4.hafta;
class ekran
{
    eleman bas=null, son=null;
            
    void işlem(int x)
    {
        while(x!=0)
        {
       int a= x%2;
       x=x/2;
       eleman y= new eleman(a);
       if(bas==null)
       {
           bas=y;
       son=y;   
       }
       else
        { y.ileri=bas;
          bas=y;
        }
       }
   }
 void goster()
 {
     eleman gecici=bas;
     while(gecici!=null)
     {
         System.out.print(gecici.icerik);
         gecici=gecici.ileri;
     }
     System.out.println("");
 }   
    public static void main(String[] args) {
        ekran e=new ekran();
        e.işlem(26);
        e.goster();
    }
}
class eleman
{
    int icerik;
    eleman ileri;
    public eleman(int icerik){
        this.icerik=icerik;
        ileri=null;
    }
}
