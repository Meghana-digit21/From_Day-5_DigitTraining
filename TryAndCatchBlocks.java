import java.util.Scanner;

public class TryAndCatchBlocks {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number: ");
        int n = sc.nextInt();
        int result;
        try{
            result = 100/n;
        } catch (ArithmeticException e){
            System.out.println("Please enter a valid number");
            return;
        }
        System.out.println("The result is "+ result);
    }
}
