import java.util.Arrays;
import java.util.List;

public class DobleColron {

    public static void main(String[] args) {
        List<Integer> names = Arrays.asList(1, 2, 3, 4, 5);

        names.forEach(x -> {
            System.out.println(x+1);
        });

        names.forEach(System.out::println);
    }
}
