package lambda.function.predicate;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateDemo {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("this","is","a","list","of","strings","oh");
        System.out.println(strings.stream().filter(s -> s.length()==4).collect(Collectors.toList()));
        System.out.println(strings.stream().filter(s -> s.startsWith("o")).collect(Collectors.joining(",")));
        System.out.println("===");
        Predicate<String> start_with = s -> s.startsWith("o");
        System.out.println(strings.stream().filter(start_with).collect(Collectors.joining(",")));
    }
}
