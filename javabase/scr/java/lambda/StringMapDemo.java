package lambda;

import java.util.stream.Stream;

public class StringMapDemo {

    public static void main(String[] args) {
        Stream.of("this","is","a","list","of","strings").map(String::length).forEach(System.out::println);
        System.out.println("======");
        Stream.of("this","is","a","list","of","strings").map(x -> x.length()).forEach(y -> System.out.println(y));
    }
}
