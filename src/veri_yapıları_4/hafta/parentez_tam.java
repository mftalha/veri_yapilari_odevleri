package veri_yapıları_4.hafta;

import java.util.Stack;

class yap //yapamadım tam
{
    int t1=0,t2=0,t3=1,t4=0;
    Stack s1=new Stack();
    Stack s2=new Stack();
    void ekle(String a)
    {
        for(int i=0,j=a.length()-1;i<a.length();i++,j--)
        {
            if(a.charAt(i) =='(' || a.charAt(i)== '[' || a.charAt(i) == '{')
            {
                s1.push(a.charAt(i));
                t1++;
                t4++;
            }
            
            else if(a.charAt(i) == ')' || a.charAt(i) == ']' || a.charAt(i) == '}')
                t4--;
            
            if(t4  <= 0)
            {
                t4=0;
                i=a.length();
            }
             if(a.charAt(j) ==')' || a.charAt(j)== ']' || a.charAt(j) == '}')
            {
                s2.push(a.charAt(j));
                t2++;
            }
        }
    }
    void konturol()
    {
     if((t1 == t2) && (t1!=0))
     {
         for(int i=0;i<t1;i++)
         {
             System.out.println("s1 ="+s1.peek());
             System.out.println("s2 ="+s2.peek());
             if((s1.peek().equals('(') && s2.peek().equals(')')) || (s1.peek().equals('{') && s2.peek().equals('}')) ||
                     (s1.peek().equals('[') && s2.peek().equals(']')))
             {
                 s1.pop();
                 s2.pop();
             }
             else
             {
              i=t1;
              System.out.println("Parentezler birbirini tutmuyor");
              t3=0;
             }
         }
     }
     else
     {
            System.out.println("açma parentez sayısı kapama parentez sayısından farklıdır");
            t3=0;
     }
     if(t3==1)
            System.out.println("parentez sırası ve sayısı dogru girilmiştir");
    }
    public static void main(String[] args) {
        yap y =new yap();
        y.ekle("( { ( ) [ { } ] } ( ) )");
        y.konturol();
    }
}