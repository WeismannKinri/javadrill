package lambda;

import java.util.function.Consumer;
import java.util.stream.Stream;

public class MethodDemo {
    public static void main(String[] args) {
        Stream.of(3,1,3,4).forEach(x -> System.out.println(x));
        System.out.println("========");
        Stream.of(3,1,3,4).forEach(System.out::println);
        System.out.println("========");
        Consumer<Integer> printer = System.out::println;
        Stream.of(3,1,3,4).forEach(printer);
        System.out.println("========");
        Stream.generate(Math::random).limit(10).forEach(System.out::println);


    }
}
