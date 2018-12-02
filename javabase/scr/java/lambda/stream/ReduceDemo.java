package lambda.stream;

import java.util.stream.Stream;

public class ReduceDemo {
    public static void main(String[] args) {
        int sum = Stream.of(1,2,3,4).reduce(0,Integer::sum);
        System.out.println(sum);
        int max = Stream.of(1,2,3,4).reduce(0,Integer::max);
        System.out.println(max);
        String concat = Stream.of("aaa","bbb").reduce("",String::concat);
        System.out.println(concat);

    }
}
