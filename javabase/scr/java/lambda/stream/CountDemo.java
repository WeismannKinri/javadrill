package lambda.stream;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.OptionalInt;

public class CountDemo {
    public static void main(String[] args) {
        String[] strings = "this is a".split(" ");
        long count = Arrays.stream(strings).map(String::length).count();
        System.out.println(count);
        count = Arrays.stream(strings).mapToInt(String::length).sum();
        System.out.println(count);
        OptionalDouble ave = Arrays.stream(strings).mapToInt(String::length).average();
        System.out.println(ave.getAsDouble());
        OptionalInt max = Arrays.stream(strings).mapToInt(String::length).max();
        System.out.println(max.getAsInt());
        OptionalInt min = Arrays.stream(strings).mapToInt(String::length).min();
        System.out.println(min.getAsInt());
    }
}
