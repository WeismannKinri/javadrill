package Enum;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ColorDrill {
    public static void main(String[] args) {
        System.out.println(Color.BLANK.getInfo());
        System.out.println("---------------");
        System.out.println(Color.BLANK.getIndex());
        System.out.println("---------------");
        Color.BLANK.print();
        List<String> list = new ArrayList<>();
        Stream<String> stream = list.stream();
    }
}
