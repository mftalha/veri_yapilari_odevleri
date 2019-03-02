package veri_yapıları_5;

import java.util.Stack;

public class odev_3 {  //posfix hesaplama
Stack s =new Stack();

public void hesaplama(String k)
{
    int sy1=0;
    int z=0;
    int tut1=0,tut2=0;
    String k1="";
    while(k.length()>z)
    {
     if(k.charAt(sy1)=='+')
      {
          k1+=s.pop();
          tut1=Integer.valueOf(k1);
          k1="";
          k1+=s.pop();
          tut2=Integer.valueOf(k1);
          tut1=tut1+tut2;
          k1="";
         s.push(tut1);
      } 
   else if(k.charAt(sy1)=='*')
      {
          k1+=s.pop();
          tut1=Integer.valueOf(k1);
          k1="";
          k1+=s.pop();
          tut2=Integer.valueOf(k1);
          tut1=tut1*tut2;
          k1="";
         s.push(tut1);
      } 
    else if(k.charAt(sy1)=='-')
      {
          k1+=s.pop();
          tut1=Integer.valueOf(k1);
          k1="";
          k1+=s.pop();
          tut2=Integer.valueOf(k1);
          tut1=tut2-tut1;
          k1="";
         s.push(tut1);
      } 
    else if(k.charAt(sy1)=='/')
      {
          k1+=s.pop();
          tut1=Integer.valueOf(k1);
          k1="";
          k1+=s.pop();
          tut2=Integer.valueOf(k1);
          tut1=tut2/tut1;
          k1="";
         s.push(tut1);
      } 
    else if(k.charAt(sy1)=='^')
      {
          k1+=s.pop();
          tut1=Integer.valueOf(k1);
          k1="";
          k1+=s.pop();
          tut2=Integer.valueOf(k1);
          tut1=(int) Math.pow(tut2,tut1);
          k1="";
         s.push(tut1);
      } 
      else if( k.charAt(sy1)=='0' ||  k.charAt(sy1)=='1' || k.charAt(sy1)=='2' || k.charAt(sy1)=='3' || k.charAt(sy1)=='4'
              || k.charAt(sy1)=='5' || k.charAt(sy1)=='6' || k.charAt(sy1)=='7' || k.charAt(sy1)=='8' || k.charAt(sy1)=='9')
      {
          s.push(k.charAt(sy1));
      }
      sy1++;
      z++;
    }
    k1+=s.pop();
    System.out.println(k1);
}
    public static void main(String[] args) {
        odev_3 o =new odev_3();
        o.hesaplama("23^");
    }
}
