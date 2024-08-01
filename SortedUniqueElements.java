
import java.util.*;
public class SortedUniqueElements {
    public static void main(String args[]){
        List<Integer> list = new ArrayList<>(Arrays.asList(7,2,9,1,2,9));
        TreeSet<Integer>treeSet= treeset(list);
        print(treeSet);
    }

    private static void print(TreeSet<Integer> treeSet) {
        Iterator<Integer> it = treeSet.iterator();

        while(it.hasNext()){
            System.out.print(it.next()+" ");
        }
    }

    private static TreeSet<Integer> treeset(List<Integer> list) {
        TreeSet<Integer> treeSet= new TreeSet<>();
        for(Integer a:list){
            treeSet.add(a);
        }
        return treeSet;
    }
}
