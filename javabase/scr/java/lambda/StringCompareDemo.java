package lambda;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringCompareDemo {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("this","is","a","list","of","strings");
        List<String> sortedOne = strings.stream().sorted((s1, s2) -> s1.compareTo(s2)).collect(Collectors.toList());
        List<String> sortedTwo = strings.stream().sorted(String::compareTo).collect(Collectors.toList());
        System.out.println(sortedOne);
        System.out.println("===========");
        System.out.println(sortedTwo);

    }
}
