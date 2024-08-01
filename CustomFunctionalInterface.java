
import java.util.Scanner;

interface SquareCalculator {
    int calculateSquare(int num);

    default void printSquare(int num) {
        int result = calculateSquare(num);
        System.out.println("The square of " + num + " is " + result);
    }
}
public class CustomFunctionalInterface {
    public static void main(String[] args) {
        SquareCalculator sq = number -> number * number;

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number: ");
        int num = sc.nextInt();
        sq.printSquare(num);
    }
}
