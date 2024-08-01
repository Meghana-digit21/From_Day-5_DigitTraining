
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class CustomObjectSetOperations {
    public static void main(String[] args) {
        HashSet<Person> hashset= new HashSet<>();
        Scanner scanner= new Scanner(System.in);
        String choice="y";
        do{
            System.out.println("Enter your choice : \n1.add\n2.check");
            String ch=scanner.next();
            switch(ch){
                case "1" ->add(hashset);
                case "2"->check(hashset);
                default -> System.out.println("Invalid choice ");
            }
            System.out.println("Do you wish to continue ( y/ n)");
            choice=scanner.next();
            choice=choice.toLowerCase();
        }while(choice.equals("y"));

    }

    private static void check(HashSet<Person> hashset) {
        System.out.println("Enter your name to search in the set");
        Scanner scanner= new Scanner(System.in);
        String name=scanner.next();
        Iterator<Person> it = hashset.iterator();
        while(it.hasNext()){
            Person person= it.next();
            if(person.getName().equals(name)){
                System.out.println(person.getName()+" is present ");
                break;
            }
        }
    }

    private static void add(HashSet<Person> hashset) {
        Person person = new Person();
        Scanner scanner= new Scanner(System.in);

        System.out.println("Enter Name : ");
        person.setName(scanner.next());

        System.out.println("Enter Age : ");
        person.setAge(scanner.nextInt());

        hashset.add(person);
    }
}
