import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer
    ) {
        T min = null;
        T max = null;
        List<? extends T> list =
                stream.sorted(order).
                        collect(Collectors.toList());
        if (list.size() != 0) {
            min = list.get(0);
            max = list.get(list.size()-1);
        }
        minMaxConsumer.accept(min,max);
    }
    public static void main(String[] args) {


        findMinMax(Stream.of(),Integer::compareTo,(min,max)-> System.out.println("Min: "+min + ", Max: " + max));

        evenNumbers(List.of(1,2,3,4,5,6,7,8,9,10,11,12));

    }

    public static void evenNumbers(List<Integer> list) {
        long count = list.stream().filter(i -> i % 2 == 0).count();
        System.out.println("Even Numbers: " + count);
    }
}