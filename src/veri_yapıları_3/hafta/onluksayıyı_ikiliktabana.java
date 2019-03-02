package veri_yapıları_3.hafta;

import java.util.Stack;

class yapp //10 luk basamaktaki sayıyı 2 lik tabana çevirme
{
    Stack s =new Stack();
    void islem(int x)
    {
        while(x>0)
        {
         int t1;
         s.push(x%2); 
         x/=2;   
        }
    }
    void göster()
    {
    while(s.size()>0)
    {
        System.out.println( s.pop());
    }
    }
    public static void main(String[] args) {
        yapp y =new yapp();
        y.islem(24);
        y.göster();
    }
}