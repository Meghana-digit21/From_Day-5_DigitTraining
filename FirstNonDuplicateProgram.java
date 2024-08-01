import java.util.*;
public class FirstNonDuplicateProgram
{
    public static void main(String[] args)
    {
        LinkedHashSet<Integer> ln=new LinkedHashSet<>();
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the size of the array :");
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++) arr[i]=sc.nextInt();
        for(int j: arr)
        {
            if(ln.contains(j)) ln.remove(j);
            else ln.add(j);
        }
        for(int j :ln)
        {
            System.out.println(j);
            return;
        }
        System.out.println(-1);
    }
}