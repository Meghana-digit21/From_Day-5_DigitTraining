public class ExceptionHierarchy {

    public static void main(String[] args) {
        try{
            int a = 10;
            int b = 0;
            int result = a/b;

            String str = null;
            int length = str.length();
        } catch(ArithmeticException e) {
            System.out.println("Arithmetic Exception caught: Division by zero is not allowed");
        } catch(NullPointerException e){
            System.out.println("Null pointer Exception caught: Cannot perform on a null object");
        } catch(Exception e){
            System.out.println("ERROR: "+e.getMessage());
        }
    }
}
