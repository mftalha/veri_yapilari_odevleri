package veri_yapıları_7.hafta;

class dugum2 {

    private int sayı;
    private int deger;
    private dugum2 next;

    dugum2(int say, int deger) {
        sayı = say;
        next = null;
    }

    public void setSayı(int sayı) {
        this.sayı = sayı;
    }

    public int getSayı() {
        return sayı;
    }

    public void setDeger(int deger) {
        this.deger = deger;
    }

    public int getDeger() {
        return deger;
    }

    public void setNext(dugum2 next) {
        this.next = next;
    }

    public dugum2 getNext() {
        return next;
    }
}

class metotlarr {

    dugum2[] tablo;
    int boyut;

    //int dboyut=0;//dizi boyutu
    metotlarr(int s1) {
        boyut = s1;
        tablo = new dugum2[boyut];
        //dboyut=s1;
        for (int i = 0; i < s1; i++) {
            tablo[i] = null;
        }
    }

    void ekle(int gsayı, int deger) {
        int hash = gsayı % tablo.length;
        if (tablo[hash] == null) {
            tablo[hash] = new dugum2(gsayı, deger);
        } else //eyer dizinin ilk zinciri doluysa
        {

            dugum2 ek = tablo[hash];
            while (ek.getNext() != null && ek.getSayı() != gsayı) //zincir boşalana kadar devam ediyorum
            {
                ek = ek.getNext();
            }
            if (ek.getSayı() == gsayı) {
                ek.setSayı(deger);
            } else {
                ek.setNext(new dugum2(gsayı, deger));
            }
        }
    }

    int göster(int aranacak) {
        if (tablo[aranacak % tablo.length] == null) {
            System.out.println("aranan eleman dizide yoktur");
            return 0;
        } else {
            dugum2 konturol = tablo[aranacak % tablo.length];
            while (konturol != null && konturol.getSayı() != aranacak) {
                konturol = konturol.getNext();
            }
            if (konturol == null) {
                return 0;
            } else {
                return aranacak;
            }
        }
    }

    public static void main(String[] args) {
        metotlar m = new metotlar(5);
        
    }
}
