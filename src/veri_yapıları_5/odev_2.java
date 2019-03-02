package veri_yapıları_5; //netfixden posfixe çevirme

import java.util.Stack;

class yap
{
   Stack k =new Stack();
   String s1="";//sııralı cümleyi tutacam
   int t1=0,t2=0;//t1 =açmaparentezinin içinde durmak için //t2=açma parentezinin içindeki eleman sayısı sayacı
   String islem(String a1)
   {
       for(int i=0;i<a1.length();i++)
       {
           if(a1.charAt(i)== '+' || a1.charAt(i)== '-')
           {
                if(k.size() == 0)
                   k.push(a1.charAt(i));
  else if(k.peek().equals('/') || k.peek().equals('*') || k.peek().equals('^') || k.peek().equals('+') || k.peek().equals('-'))
                   s1+=k.pop();
                k.push(a1.charAt(i));
           } //-----------
           else if(a1.charAt(i) == '*' || a1.charAt(i) == '/')
           { 
             if(k.peek().equals('/') || k.peek().equals('*') || k.peek().equals('^'))
               {
                   s1+=k.pop();
                   k.push(a1.charAt(i));
               }
             else
                 k.push(a1.charAt(i));
               
               System.out.println(k);
                   
           }  //---------------
         else if(a1.charAt(i) == '(' || t1 ==1)//açma parentezinin içi kapanana kadar
           {
               t1=1;
               if(a1.charAt(i) == ')')//açma parentezinin içinde kapatma parentezi gelirse
               {
                   while(t2>0)
                   {
                      if(!k.peek().equals('(')) 
                          
                       s1+=k.pop();
                      else
                      {
                       k.pop();
                       t1=0;
                      }   
                      t2--;
                   }
               }
               else //kapatma parentezi deyilse
               {
                   t2++;
                   k.push(a1.charAt(i));
               }
                   
           } //----------------------
       }
       System.out.println(k);
       while(k.size() !=0)
       {
           s1+=k.pop();
       }
       return s1;
   }
    public static void main(String[] args) 
    {
     yap y =new yap();
     System.out.println( y.islem("(4*5)"));
    }
}