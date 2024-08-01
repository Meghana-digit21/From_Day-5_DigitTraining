
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SetOperationsWithSubsets {
    public static void main(String args[]){
        List<Integer> setA = new ArrayList<>(Arrays.asList(1,2,3));
        List<Integer> setB = new ArrayList<>(Arrays.asList(1,2,3,4));
        int count=0;
        for(Integer a:setA){
            for(Integer b:setB){
                if(a.equals(b)){
                    count++;
                }
            }
        }
        if(count==setA.size()){
            System.out.println("true");
        }
        else{
            System.out.println("False");
        }

    }
}
