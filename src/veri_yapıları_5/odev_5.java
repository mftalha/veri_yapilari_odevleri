package veri_yapıları_5;

import java.util.Stack;

public class odev_5 {
Stack s =new Stack(); //lnfix posfixe çevirme
    
public String in_pr(String inf) //gelen string
{
    String pos=""; //stringin poss hale dönüşümü
    String knt="";
    int s1=0;
    int s2=0;
    int s3=1;
    char c=0; //char at i ayrı ayrı yazmamak için aldım
    for(int i=0;i<inf.length();i++)
    {
        c=inf.charAt(i); //gelen stringin elemanını bir char degişkene atıyorum
        if(c == '(')//c eyer açma parenteziyse diziye direk at
           s.push(c); 
        else if(c == ')')
        { 
            s1=1;//while girme şartı devam etsin diye aç parantezi gelene kadar
            while(s1 ==1)
            {
             knt+=s.peek();//gelen elemanın aç parantezi olup olmadıgını konturol etmek için
            if(knt.equals("("))
            {
                s.pop();    //açma parantezinide silip whilden çıkıyoruz
                s1=0;
            }
            else
            {
              pos+=s.pop();
            }
            knt="";            
        }
        }
        else if(c=='0' || c=='1' || c=='2' || c=='3' || c=='4' || c=='5' || c=='6' || c=='7' || c=='8' 
                || c=='9' )//eyer gelen sayıysa direk pos stringine atıyorum
            pos+=c;     
           
        else if(c == '^') //gelen üst se eyer direk yıgıta atıyoruz //işlem önceligi bunda oldugundan en üstte durabilir
        {
            s.push(c);
            
        }
        else if(c =='/')
        {
            if(s.size() == 0)
                s.push(c);
          else if(s.peek().equals('*') || s.peek().equals('^') || s.peek().equals('/') )
          {
              while(s3==1)
               {
                pos+=s.pop();//yıgıttın üstündeki elemanı yıgıttan silip posa atıyorum 
                if(s.size() !=0 &&(s.peek().equals('*') || s.peek().equals('^') || s.peek().equals('/'))) 
                    s3=1;
                else
                {
                  s3=0;
                  s.push(c);
                }     
          }
              s3=1;
          }
            else
              s.push(c);
                
        }
        else if(c =='*')
        {
             if(s.size() == 0)
                s.push(c);
          else if(s.peek().equals('/') || s.peek().equals('^') || s.peek().equals('*'))
          {
               while(s3==1)
               {
                pos+=s.pop();//yıgıttın üstündeki elemanı yıgıttan silip posa atıyorum 
                if(s.size() !=0 &&(s.peek().equals('*') || s.peek().equals('^') || s.peek().equals('/'))) 
                    s3=1;
                else
                {
                  s3=0;
                  s.push(c);
                }
               }
               s3=1;
          }
             else
              s.push(c);
        }
        
        else if(c =='+')
        {
             if(s.size() == 0) //eyer dizide eleman yoksa
                s.push(c);
           else if(s.peek().equals('*') || s.peek().equals('^') || s.peek().equals('/') || s.peek().equals('-') 
                   || s.peek().equals('+') )
           {
               while(s3==1)
               {
                pos+=s.pop();//yıgıttın üstündeki elemanı yıgıttan silip posa atıyorum 
                if(s.size() !=0 &&(s.peek().equals('*') || s.peek().equals('^') || s.peek().equals('/') || s.peek().equals('-') 
                   || s.peek().equals('+')) )
                    s3=1;
                else
                {
                  s3=0;
                  s.push(c);
                }
                    
               }
               s3=1;
           }
             else
               s.push(c);
        }
        
        else if(c =='-')
        {
             if(s.size() == 0)
                s.push(c);
           else if(s.peek().equals('*') || s.peek().equals('^') || s.peek().equals('/') || s.peek().equals('+') 
                 || s.peek().equals('-'))
           {
                while(s3==1)
               {
                pos+=s.pop();//yıgıttın üstündeki elemanı yıgıttan silip posa atıyorum 
                if(s.size() !=0 &&(s.peek().equals('*') || s.peek().equals('^') || s.peek().equals('/') || s.peek().equals('-') 
                   || s.peek().equals('+')) )
                    s3=1;
                else
                {
                  s3=0;
                  s.push(c);
                }
                    
               }
                s3=1;
           }
             else
               s.push(c);
        } 
}
   while(s.size() !=0)
   {
       pos+=s.pop();
   }
    return pos;
}    
    public static void main(String[] args) {
         odev_5 o =new odev_5();
         String s1="";
         String a="2*(3+5)-7^(2+1)";
         for(int i=a.length()-1;i>=0;i--)
         {
             s1+=a.charAt(i);
         }
         a=o.in_pr(s1);
         s1="";
         for(int i=a.length()-1;i>=0;i--)
         {
            s1+=a.charAt(i);
         }
         System.out.println(s1);
       //  System.out.println(o.in_pr("2*(3+5)-7^(2+1)"));//(8+4)/2+(7-2)*3
    }
    
}
