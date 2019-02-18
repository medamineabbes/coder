import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
public class main 
{   
    public static int len(int a)
    {
        int l=0;
        while(a!=0)
        {
            a=a/10;
            l++;
        }
        return l;
    }
    /*
    power of a with b
    works fine
    */
    public static int power(int a,int b)
    {
        if(b==0)
            return 1;
        else
        {
            int c=1;
            for(int i=0;i<b;i++)
                c=c*a;
            return c;
        }
    }
    /*
    ///////////////////////01100001////////////////////////////////////////////////////////////////////
    convert a list of strings to a list of integers
    works fine
     */
    public static List<Integer> getstrings(List<String> s) {
        List<Integer> a = new ArrayList<Integer>();
        for (int i = 0; i < s.size(); i++) {

            try {
                a.add(Integer.parseInt(s.get(i)));
            } catch (NumberFormatException e) {
                a.add(0);
            }
        }
        return a;
    }

    /*
    conver a String to a list of strings
    works fine
     */
    public static List<String> boucher(String s) {
        List<String> a = new ArrayList<String>();
        String sc = "";
        
        for (int i = 1; i <= s.length(); i++) {
            sc += s.charAt(i-1);
            if (i % 8 == 0 && i!=0) 
            {  
                
                a.add(sc);
                sc = "";
            }
        }
        return a;
    }
    /* 
    convert an integer in binary to an integer in decimale
    works fine
    */
    //////////// compleated ///////////////////
    public static int decimal(int a)
    {
        int d=0;
        for(int i=0;i<len(a);i++)
	{
		d+=power(2,i)*((a%power(10,i+1)/power(10,i)));
	}
        return d;
    }
    /*
    convert a list of binary to a list of bytes
    works fine
     */
    public static List<Integer> byter(List<Integer> b)
    {
        List<Integer> a = new ArrayList<Integer>();
        for(int i=0;i<b.size();i++)
        {
            a.add(decimal(b.get(i)));
        }
        return a;
    }
    /*
    convert integer to byte works
    */
    public static byte int_to_byte(int a)
    {
        byte b=0;
        for(int i=0;i<a;i++)
        b++;
        return b;
    }
    public static void decode() 
    {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        List<String> a= boucher(s);
        List<Integer> b= getstrings(a);
        b=byter(b);
        for(int i=0;i<b.size();i++)
            System.out.print((char) (int_to_byte(b.get(i))));  
        System.out.println("");
    }
    public static int binary(byte b)
    {
        int a=b%2;
        b=(byte) (b/2);
        int c=10;
        do{
         a+=(b%2)*c;
            c*=10;
            b=(byte) (b/2);
        }while(b!=0);
        return a;
    }
    public static byte[] code(String s)
    {
         byte[] b=new byte[s.length()];
        for(int i=0;i<s.length();i++)
        {
            b[i]=(byte) (int) (s.charAt(i));
        }
        return b;
        
    }
    public static void send()
    {
        Scanner sc= new Scanner(System.in);
        
       String s=sc.nextLine();
       byte b[]=code(s);
       int c=s.length();
       List<Integer> a = new ArrayList<Integer>();
       
       int i;
       int l;
       for(i=0;i<b.length;i++)
       {  
           a.add(binary(b[i]));
           l=len(a.get(i));
           while(l<8)
           {
                l++;
                System.out.print("0");
           }
           System.out.print(a.get(i));
       }
       System.out.println("");
    }
    public static void main(String[] args)
    {   
        int a=0;
       while(a!=2)
       {
        System.out.println("[0] to send \n[1] to receive\n[2] to exit");
       Scanner sc= new Scanner(System.in);
       a=sc.nextInt();
       if(a==0)
       {
           System.out.println("inter the message to send");
           send();
       }
       else if(a==1)
       {
           System.out.println("inter the recieved String");
           decode();
       }
       else
       {
        
       }
       }
    }
}