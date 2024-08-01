
import java.util.*;
public class ClassSpecificSetBehavior
{
    public void setbehav()
    {
        List<Integer>l=new ArrayList<>();
        Scanner sc=new Scanner(System.in);
        while(true)
        {
            System.out.println("enter elements to linkedlist");
            System.out.println("enter -1 to stop adding");
            int t=sc.nextInt();
            if(t!=-1) l.add(t);
            else break;
        }
        HashSet<Integer> set=new HashSet<>();
        LinkedHashSet<Integer> lset=new LinkedHashSet<>();
        TreeSet<Integer> Tset=new TreeSet<>();
        for(int i=0;i<l.size();i++)
        {
            set.add(l.get(i));
            lset.add(l.get(i));
            Tset.add(l.get(i));
        }
        System.out.print("HashSet :");
        for(int j: set)
        {
            System.out.print(j+" ");
        }
        System.out.println();
        System.out.print("LinkedHashSet :");
        for(int j: lset)
        {
            System.out.print(j+" ");
        }
        System.out.println();
        System.out.print("TreeSet :");
        for(int j: lset)
        {
            System.out.print(j+" ");
        }
        System.out.println();

    }
    public static void main(String[] args) {

        ClassSpecificSetBehavior sb=new ClassSpecificSetBehavior();
        sb.setbehav();
    }
}
