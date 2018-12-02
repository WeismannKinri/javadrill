package lambda.function.function;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FunctionDemo {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("this","is","a","list","of","strings");
        List<Integer> nameLength  = strings.stream().map(new Function<String,Integer>(){
            @Override
            public Integer apply(String s){
                return s.length();
            }
        }).collect(Collectors.toList());
        System.out.println(nameLength);
        System.out.println("=====");
        nameLength = strings.stream().map(s -> s.length()).collect(Collectors.toList());
        System.out.println(nameLength);
        System.out.println("=====");
        nameLength = strings.stream().map(String::length).collect(Collectors.toList());
        System.out.println(nameLength);
    }
}
