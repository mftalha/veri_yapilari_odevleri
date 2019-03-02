package veri_yapıları_4.hafta;

import java.util.Scanner;
import java.util.Stack;

public class stact_yapısı {
    public static void main(String[] args) {
     Scanner k =new Scanner(System.in);
        Stack stack =new Stack();
        Stack stack2 =new Stack();
         
        System.out.println("decimal den binary sisteme çevrilecek sayı ?");
        int x=k.nextInt();
        int tut=0;
        while(x>=1)
        {
            tut=x%2;
            x/=2;
            stack.push(tut);
        }
        System.out.println(stack);

        int c=stack.search(0);
        System.out.println(c);
        for(int i=0;i<stack.size();i++)
        {
            
        }
    }
}
