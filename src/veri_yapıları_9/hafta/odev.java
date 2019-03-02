package veri_yapıları_9.hafta;


import java.util.LinkedList;

import java.util.Queue;

 

class düğüm {
    int numarası, borcu, yükseklik;
    String adı;
    düğüm sol;
    düğüm sağ;

    düğüm(int numarası, String adı, int borcu) {
        this.numarası = numarası;
        this.adı = adı;
        this.borcu = borcu;
        yükseklik = 1;
    }
}

class Agac {

    düğüm kök;
 

    int yükseklik(düğüm N) 
    {

        if (N == null)
        {
            return 0;
        }

        return N.yükseklik;

    }


    int azami(int a, int b) 
    {

        return (a > b) ? a : b;

    }


    düğüm sağrotasyon(düğüm y) {

        düğüm x = y.sol;

        düğüm T2 = x.sağ;
 

        x.sağ = y;

        y.sol = T2;


        y.yükseklik = azami(yükseklik(y.sol), yükseklik(y.sağ)) + 1;

        x.yükseklik = azami(yükseklik(x.sol), yükseklik(x.sağ)) + 1;


        return x;

    }

    düğüm solrotasyon(düğüm x) {

        düğüm y = x.sağ;

        düğüm T2 = y.sol;


        y.sol = x;

        x.sağ = T2;

 

        x.yükseklik = azami(yükseklik(x.sol), yükseklik(x.sağ)) + 1;

        y.yükseklik = azami(yükseklik(y.sol), yükseklik(y.sağ)) + 1;


        return y;

    }


    int getDenge(düğüm N) {

        if (N == null) {

            return 0;

        }

        return yükseklik(N.sol) - yükseklik(N.sağ);

    }

    düğüm ekleme(düğüm hata, int no, String adı, int borcu) {


        if (hata == null) { //hata boşa düştü ise 

            return (new düğüm(no, adı, borcu));

        }
       
        if (no < hata.numarası) {//gelen numara konturol edilen kökün numarasından küçükse

            hata.sol = ekleme(hata.sol, no, adı, borcu);//hatayı sola kaydırıp tekrar çagırıyoruz metodu

        } else if (no > hata.numarası) { //tersi

            hata.sağ = ekleme(hata.sağ, no, adı, borcu);

        } else  //aynı sayı geldiyse

        {
           return hata;
        }
 

        hata.yükseklik = 1 + azami(yükseklik(hata.sol), yükseklik(hata.sağ));//dügüme yüksekligini veriyorum


        int balance = getDenge(hata);//dengeden kökün sol sag oranlarınu alıyorum 1 -1 0 -2 2 gibi


        if (balance > 1 && no < hata.sol.numarası) {//sol - sol hata var demek

            return sağrotasyon(hata);

        }

        if (balance < -1 && no > hata.sağ.numarası) { //sag - sag hata var demek

            return solrotasyon(hata);

        }


        if (balance > 1 && no > hata.sol.numarası) { //sol - sag hata

            hata.sol = solrotasyon(hata.sol);

            return sağrotasyon(hata);

        }
 
        if (balance < -1 && no < hata.sağ.numarası) {//sag - sol hata

            hata.sağ = sağrotasyon(hata.sağ);

            return solrotasyon(hata);

        }

        return hata;

    }

    public void göster(düğüm u)
    {
        System.out.println(u.numarası);
    }

    public static void levelOrder(düğüm kökdüğüm) {

        Queue<düğüm> queue = new LinkedList<düğüm>();

        queue.add(kökdüğüm);

        while (!queue.isEmpty()) {

            düğüm gecicidüğüm = queue.poll();

            System.out.printf("%d ", gecicidüğüm.numarası);

            if (gecicidüğüm.sol != null) {

                queue.add(gecicidüğüm.sol);

            }

            if (gecicidüğüm.sağ != null) {

                queue.add(gecicidüğüm.sağ);

            }
        }
   }

    public boolean ikilimi(düğüm kökdüğüm) {

        Queue<düğüm> kuyruk = new LinkedList<düğüm>();

        boolean sonuç = true;

        kuyruk.add(kökdüğüm);

        while (!kuyruk.isEmpty()) {

            int tut1 = 0, tut2 = 0;

            düğüm gecicidüğüm = kuyruk.poll();

            if (gecicidüğüm.sol != null) {

                tut1 = gecicidüğüm.sol.numarası;

                kuyruk.add(gecicidüğüm.sol);

            }

            if (gecicidüğüm.sağ != null) {

                tut2 = gecicidüğüm.sağ.numarası;

                kuyruk.add(gecicidüğüm.sağ);

            }

            if ((gecicidüğüm.sol != null) && (gecicidüğüm.sağ != null)) {

                if (tut1 > tut2) {

                    sonuç = false;

                }

            }

        }

        return sonuç;

    }

    public düğüm borç(düğüm kökdüğüm) {

        Queue<düğüm> queue = new LinkedList<düğüm>();

        int borcu = 0;

        düğüm tut = null;

        queue.add(kökdüğüm);

        while (!queue.isEmpty()) {
            
            düğüm gecicidüğüm = queue.poll();

            if (borcu < gecicidüğüm.borcu) {

                borcu = gecicidüğüm.borcu;

                tut = gecicidüğüm;

            }

            if (gecicidüğüm.sol != null) {

                queue.add(gecicidüğüm.sol);

            }
            if (gecicidüğüm.sağ != null) {

                queue.add(gecicidüğüm.sağ);
            }
        }
      return tut;
    }

    public static void main(String[] args) {

        Agac t = new Agac();

        t.kök = t.ekleme(t.kök, 30, "ali", 50);
        t.kök = t.ekleme(t.kök, 25, "veli", 40);
        t.kök = t.ekleme(t.kök, 28, "cevdet", 90);
        t.kök = t.ekleme(t.kök, 12, "ahmet", 10);
        t.kök = t.ekleme(t.kök, 17, "hakkı", 0);
        t.kök = t.ekleme(t.kök, 24, "nazım ", 100);
        t.kök = t.ekleme(t.kök, 27, "cevo", 70);
        t.kök = t.ekleme(t.kök, 26, "jay", 50);

       
        System.out.println("levelorder sıralaması");
        levelOrder(t.kök);
        System.out.println("");
       // System.out.println("preorder sıralaması");
       // tree.preOrder(tree.kök);
        System.out.println("");
        System.out.println("borç");
        System.out.println(t.borç(t.kök).numarası + "-" + t.borç(t.kök).adı + "-" + t.borç(t.kök).borcu);
        System.out.println("ikili mi?");
        boolean b= t.ikilimi(t.kök);
        if(b==true)
            System.out.println("Agaç ikilidir");
        else
            System.out.println("Agaç ikili deyildir");
        
        
    }
}