package lambda.function.consumer;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ComsumerDemo {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("this","is","a","list","of","strings");
        strings.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });
        System.out.println("======");
        strings.forEach(s -> System.out.println(s));
        System.out.println("======");
        strings.forEach(System.out::println);
    }
}
