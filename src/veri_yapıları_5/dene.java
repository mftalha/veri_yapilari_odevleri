package veri_yapıları_5;
class tut
{
    int x;
   tut next;
   tut prev;
   tut(int x)
   {
       this.x=x;
       this.next=null;
       this.prev=null;
   }
}
class ekrann
{
    tut ilk=null,son =null;
    void ekle(int x)
    {
        tut t=new tut(x);//deger
        if(ilk== null)
        {
            ilk=t;//adres yolu
            son=t;
        }
        else
        {
            son.next=t;
            t.prev=son;
            son=t;
        }
    }
}