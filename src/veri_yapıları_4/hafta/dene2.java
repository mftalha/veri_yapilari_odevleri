package veri_yapıları_4.hafta;

import java.util.Stack;

public class dene2 {
    public static void main(String[] args) {
        Stack s =new Stack();
        dene2 y=new dene2();
         System.out.println(y.işlem(25));
    }
    String işlem(int x){
        String b="";
        Stack s=new Stack();
        
        int sayaç=0;
        while(x!=0)
        {
            int a=x%2;
            x=x/2;
            s.push(a);
            sayaç++;
        }
        for(int i=0;i<sayaç;i++)
        {
            b+=s.pop();
        }   
          return b;
    }
}
