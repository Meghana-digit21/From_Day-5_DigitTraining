import java.util.*;
public class FunctionalInterfaceImplementation
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();
        FunInterface q=(x,y)-> {
            //System.out.println("hello");
            return x+y;

        };
        System.out.println(q.sum(a,b));

    }
}
 