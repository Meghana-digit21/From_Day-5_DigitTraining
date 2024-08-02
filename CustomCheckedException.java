import java.sql.SQLOutput;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CustomCheckedException {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try{
            System.out.println("Enter your age: ");
            int age = sc.nextInt();
            if(age<18){
                throw new InvalidAgeException("Age must be 18 or older");
            }
            System.out.println("Age is valid. You are " +age+ "years older");
        } catch(InvalidAgeException e){
            System.out.println("InvalidAgeException: "+ e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("ERROR: Please enter a valid integer value");
        } finally {
            sc.close();
        }

    }
}


class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}

