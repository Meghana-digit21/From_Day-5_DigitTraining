
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class OptionalHandling {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(3, 5, 7, 2, 8);
        Optional<Integer> max = findMax(numbers);
        max.ifPresentOrElse(
                value -> System.out.println("Maximum value: " + value),
                () -> System.out.println("List is empty")
        );
    }
    public static Optional<Integer> findMax(List<Integer> list) {
        return list.stream().max(Integer::compareTo);
    }

}
