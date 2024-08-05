
public class DivisionProcessor {
    public static int performDivision(int numerator, int denominator) throws ArithmeticException {
        if (denominator == 0) {
            throw new ArithmeticException("Division by zero is not allowed");
        }
        return numerator / denominator;
    }
    public static int calculate(int numerator, int denominator) throws ArithmeticException {
        try {
            return performDivision(numerator, denominator);
        } catch (ArithmeticException e) {
            throw new ArithmeticException("Error occurred in calculate method: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        int numerator = 10;
        int denominator = 0;

        try {
            int result = calculate(numerator, denominator);
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.err.println("Caught an exception: " + e.getMessage());
        }
    }
}
