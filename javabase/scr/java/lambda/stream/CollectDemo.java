package lambda.stream;

import java.util.stream.Stream;

public class CollectDemo {
    public static void main(String[] args) {
        String s = Stream.of("aaa","bbb","ccc").
                collect(() -> new StringBuilder(),
                (sb, str) -> sb.append(str),
                (sb1, sb2) -> sb1.append(sb2)).toString();
        System.out.println(s);
        String a = Stream.of("aaa","bbb","ccc").
                collect(StringBuilder::new,
                        StringBuilder::append,
                        StringBuilder::append).toString();
        System.out.println(a);
    }
}
