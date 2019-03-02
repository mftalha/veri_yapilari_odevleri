package veri_yapıları_8.hafta;

import java.util.Stack;

class dugum
{
    int numara;
    int not;
    String ad;
    dugum sol,sag;
    dugum(int numara,int not,String ad)
    {
        this.numara=numara;
        this.not=not;
        this.ad=ad;
        sol=sag=null;
    }
}

class agac
{
    dugum kök=null;
    void ekle(int numara,int not,String ad)
    {
        dugum yedek=kök;
         dugum yedek2=null;
        dugum d=new dugum(numara, not, ad);
        if(kök ==null) //kök bossa (ilk eleman)
        {
            kök=d;
            yedek=d;
        }
        else //(kök boş deyilse)
        {
           while(yedek !=null)
           {
              if(d.numara >= yedek.numara)
              {
                  yedek2=yedek;
                  yedek=yedek.sag;
              }
              else
              {
                  yedek2=yedek;//bir önceki degeri tutar
                  yedek=yedek.sol;//boş olana kadar gidecek
              }
            }
        if(d.numara>yedek2.numara) //gelen numara büyükse dügümdeki numaradan saga ekle
            yedek2.sag=d;
        else                       //gelen numara küçükse dügümdeki numaradan sola ekle
            yedek2.sol=d;
        }
    }
    void sil(int numara)
    {
        int z=0;//aranan elemnın agaçta olmama durumu konturolü için
        int konturol=0;
        dugum yedek=kök;//ilerlettigim degişken
        dugum yedek2=null;//ilerlerlettigim elemanın(yedek) bir önceki degerini tutar
        dugum yedek3=null;//konturol = 3 için
        
        while(z==0 && yedek.numara != numara  )//z=arananın agaçta olmaması ,ve , aranan numaranın bulunması halinde çık
        {
            if(yedek.numara <= numara)
            {//saga gir
                yedek2=yedek;
                yedek=yedek.sag;
                yedek3=yedek;
            }
            else
            {//sola git
                yedek2=yedek;
                yedek=yedek.sol;
                yedek3=yedek;
            }
            if(yedek.sag ==null && yedek.sol ==null && yedek.numara != numara) //aranan elemanın dizide olmaması durumu
                z=1;// bu ifin sebebi yedek'in nula düşmemesi için whilen şartında yedek.numara dedigim için sıkıntı veriyor
        }
        if(yedek != null && z==0)
        {
        if((yedek.sol == null) && (yedek.sag ==null))//eyer yapraksa yani altında başka eleman yoksa
            konturol=1;
        else if(yedek.sol !=null && yedek.sag ==null && yedek.sol.sol ==null && yedek.sol.sag==null)//eyer tek yapragı olan
           konturol =2;                                                                             //ara dügüm ise
        else if(yedek.sol ==null && yedek.sag !=null && yedek.sag.sol ==null && yedek.sag.sag==null)// ......
           konturol =2;       
        else//birden fazla yapragı olan ara dügümse veya birden fazla yapragı aradügümü olan kök
            konturol=3;
        }
        else
            System.out.println(numara+"elemanı dizide bulunmamaktadır"); 
        
        //buradan önce elemanı nereye ekleyecegimi belirlemeydi bundan sonrası ekleme
          
        if(konturol ==1)//yaprak olma durumu
        {
        if(yedek2.sag.numara == numara  )
            yedek2.sag =null;
        else
            yedek2.sol =null;
          }
        else if(konturol ==2)//eyer tek yapragı olan aradügüm ise
        {
            if(yedek2.numara>yedek.numara && yedek.sol !=null)//eyer birönceki(yedek2) numara bir sonraki numaradan büyükse
                yedek2.sol=yedek.sol;                         //sola kaymıştır ve sol boş deyilse 
            else if(yedek2.numara > yedek.numara &&yedek.sag !=null) //yine sola kayacak (yedek2)>yedek ve sag boş deyil 
                yedek2.sol=yedek.sag;
            else if(yedek2.numara<=yedek.numara && yedek.sol !=null)//eyer yedek>yedek2 ise saga gitmiş demektir
                yedek2.sag=yedek.sol;
            else if(yedek2.numara<=yedek.numara && yedek.sag !=null)
                yedek2.sag=yedek.sag;
        }
        
        else if(konturol ==3)//birden fazla yaprak ve arakökü olan dügüm
        {
            yedek3 =yedek;
            yedek2=yedek;
            if(yedek.sol !=null) //eyer altında sol boş deyilse 
            {
                yedek=yedek.sol; //bir sola kay
                if(yedek.sag ==null)//eyer ilk soldan sonra saga gidemezse
                {
                    yedek3.numara=yedek.numara;yedek3.not=yedek.not;yedek3.ad=yedek.ad; //yerine yaz
                    yedek2.sol=yedek.sol;//aradaki elemanı atlatıyorum
                }
                else
                {
                    while(yedek.sag !=null  ) //en büyük degeri bul
                  {
                   yedek2=yedek;
                   yedek=yedek.sag;
                  }
                yedek3.numara=yedek.numara;yedek3.not=yedek.not;yedek3.ad=yedek.ad; //yerine yaz
                yedek2.sag=null; //en büyük degeri sil
                }   
            }
            
            else //sag tarafta işlem yapma
            {  
                yedek=yedek.sag; //bir saga kay
                if(yedek.sag ==null)//eyer ilk soldan sonra saga gidemezse
                {
                    yedek3.numara=yedek.numara;yedek3.not=yedek.not;yedek3.ad=yedek.ad; //yerine yaz
                    yedek2.sag=yedek.sag;//aradaki elemanı atlatıyorum
                }
                else
                {
               while(yedek.sol !=null  ) //sagdaki degerin en küçük degerini bul
              {
                yedek2=yedek; //bir önceki bir sonrakini silecegim için
                yedek=yedek.sol;
              }
               yedek3.numara=yedek.numara;yedek3.not=yedek.not;yedek3.ad=yedek.ad;
               yedek2.sol=null;
                }
            }
        } 
    }
    void arama(int numara)
    {
        int z=0;
        dugum yedek=kök;
        dugum yedek2=null;
        
        while(z==0 && yedek.numara != numara  )//z=arananın agaçta olmaması ,ve , aranan numaranın bulunması halinde çık
        {
            if(yedek.numara <= numara)
            {//saga gir
                yedek2=yedek;
                yedek=yedek.sag;       
            }
            else
            {//sola git
                yedek2=yedek;
                yedek=yedek.sol;
            }
            if(yedek.sag ==null && yedek.sol ==null && yedek.numara != numara) //aranan elemanın dizide olmaması durumu
                z=1;// bu ifin sebebi yedek'in nula düşmemesi için whilen şartında yedek.numara dedigim için sıkıntı veriyor
    }
       if(z !=1)
            System.out.println("Numara:"+yedek.numara+", Ad:"+yedek.ad+", Not:"+yedek.not);
       else
            System.out.println("Aradıgınız eleman dizide bulunmamaktadır");
    }
    void min()
    {
       dugum yedek=kök;
       while(yedek.sol !=null)
       {
           yedek=yedek.sol;
       }
        System.out.println("Numara :"+yedek.numara+", Ad:"+yedek.ad+", Not:"+yedek.not);
    }
    void max()
    {
        dugum yedek=kök;
        while(yedek.sag !=null)
        {
            yedek=yedek.sag;
        }
        System.out.println("Numara :"+yedek.numara+", Ad:"+yedek.ad+", Not:"+yedek.not);
    }
    int sayaç=0;
    void postorder()//sol kök ,sag kök,orta kök
    {
      dugum yedek=kök,yedek2=null;
      int z=0;
      while(z==0)
      {
          if(kök.sol == null && kök.sag ==null)
      {
          z=1;
      }
          while(yedek.sol !=null)//en sola in
      {
          yedek2=yedek;
          yedek=yedek.sol;
      }
       if(yedek.sag !=null)//eyer sola dogru sona geldik ve sag tarafta daha eleman varsa yedegi saga kaydırdım
       {
           yedek2=yedek;
           yedek=yedek.sag;
       }
    
          if(yedek.sol ==null && yedek.sag ==null)//yedek iç bir noktaya geldiyse
       {
           System.out.println(yedek.numara);
           sayaç++;                                    
           if(yedek2.sol !=null)
               yedek2.sol=null;
           else
               yedek2.sag=null;
           
           yedek=kök;
          // if(z==1)          //dizide kaç eleman var yada dizideki nesneleri konturol
          //     System.out.println("sayaç="+sayaç++);
       }
      }
    }
    void inorder() //sol kök sag
    {
       dugum yedek=kök,yedek2=null,yedek3=null,yedek4=kök;
      while(yedek4 !=null) 
      {
          while(yedek.sol !=null)//en sola in
      {    
          yedek3=yedek2;    
          yedek2=yedek;
          yedek=yedek.sol;
      }
       if(yedek.sag !=null)//eyer sola dogru sona geldik ve sag tarafta daha eleman varsa yedegi saga kaydırma //karışık
       {
           yedek3=yedek2;
           yedek2=yedek;
           yedek=yedek.sag;
           System.out.println(yedek2.numara); //yedek2 yi yazdırıp kökü onun sagına atıyorum
           if(yedek3.sol !=null && yedek3.sol.numara==yedek2.numara)
               yedek3.sol=null;
           else if(yedek3.sag.numara==yedek2.numara)
                   yedek3.sag=null;
           kök=yedek; //kökü yedek2 nin sagı yapıyorum
       }
       if(kök != null && yedek2.numara == kök.numara) //eyer sol tarafın silme işlemi bitti ve kök siliniyorsa kökü saga kaydırmalıyım
       {
           if(kök.sag !=null)//burada silme işlemi köke geldiyse ve kökün sagında eleman varsa
               kök =kök.sag; //kökü saga kaydırdım
           else //////
               kök=null;
       }
          if(yedek.sol ==null && yedek.sag ==null)//yedek iç bir noktaya geldiyse
       {
           if(yedek2.sol !=null &&(yedek2.sol.numara ==yedek.numara)) //silinen eleman bir önceki elemanın solunda ise
           {
               System.out.println(yedek.numara);
               yedek2.sol=null;
           }
         else  if(yedek2.sag !=null&&(yedek2.sag.numara == yedek.numara))
           {
               System.out.println(yedek.numara);
               yedek2.sag=null;
           }
         else //bunlara girmiyorsa parçalı bölgede en son elemandadır hepsi ondan yedek4ü köke atarım
         {
             System.out.println(yedek.numara);
             yedek4=kök;
         }
           
           if(yedek2.sol == null && yedek2.sag != null) //solda eleman yok ve sagda dallanma varsa 
           { 
               System.out.println(yedek2.numara);
               yedek=yedek2.sag; //saga geçiş için ilk adım
               if((yedek3.sol !=null &&yedek3.sol.numara ==yedek2.numara ) || yedek3.numara ==yedek2.numara)
               {
                   yedek3.sol=null; //bunu alttaki ifin elsesinde deniyecem
                   if(yedek2.numara == yedek3.numara) //demekki parçada yedek4 ün hemen solundaki eleman silinmiş
                       yedek4=yedek4.sag;
               }
               else
               yedek3.sag=null;
               yedek4=yedek; 
           }
           if(yedek4 ==null) //yedek boş deyilse kökü yedege baglarım
               yedek4=kök;  //////burasız halledebiliyorum gibi 275. satır sayesidne bakalım!!!
           else //eyer hala dallanmanın içerisinde ise yedek3
           {
               yedek=yedek4;
               yedek2=yedek4;
               yedek3=yedek4;
           }
       }
      } 
    }
    void göster()
    {
       // System.out.println("7 ="+kök.sag.sag.numara+","+kök.sag.sag.ad);
       // System.out.println("1 ="+kök.numara+","+kök.not+","+kök.ad);
        System.out.println("2 ="+kök.sag.numara+","+kök.sag.not+","+kök.sag.ad);
        //System.out.println("5 ="+kök.sag.numara);
    }
    public static void main(String[] args) {
        agac m =new agac();
        m.ekle(50, 10, "ahmet");
        m.ekle(30, 30, "yakup");
        m.ekle(20, 50, "mehmet");
        m.ekle(10, 60, "sinan");
        m.ekle(24, 70, "mustafa");
        m.ekle(26, 65, "kemal");
        m.ekle(28, 90, "sinan");
        m.ekle(29, 87, "yusuf");
        m.ekle(27, 97, "ishak");
        m.ekle(35, 98, "orhan");
        m.ekle(40, 55, "pelin");
        m.ekle(23, 85, "ss");
        m.ekle(25, 34, "ishak");
        m.ekle(22, 78,"kenan");
        m.ekle(60, 55, "cemre");
        m.ekle(57, 87, "tahsin");
        m.ekle(54, 87, "tahsin");
        m.ekle(55, 87, "tahsin");
        m.ekle(52, 87, "tahsin");
        m.ekle(70, 78, "pelin");
        m.ekle(65, 46, "sanem");
        
    //  m.göster();
    //  m.sil(30);
    //  m.göster();
    // m.arama(98);
    // m.min();
    // m.max();
     m.postorder();
     //  m.inorder();
    }
}