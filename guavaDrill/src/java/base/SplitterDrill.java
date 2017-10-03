package base;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.sun.javafx.stage.StagePeerListener;

import java.util.List;
import java.util.Map;

public class SplitterDrill {
    public static void main(String[] args) {
        SplitterDrill.turnStringToList();
        SplitterDrill.turnStringToMap();
        SplitterDrill.turnStringToListWithLimit();
    }

    public static void turnStringToList(){
        String input = "apple - banana - orange";
        List<String> result = Splitter.on("-").trimResults()
                .splitToList(input);
        System.out.println(Joiner.on(",").join(result));
    }

    public static void turnStringToMap(){
        String input = "John=first,Adam=second";
        Map result = Splitter.on(",").trimResults()
                .withKeyValueSeparator("=").split(input);
        System.out.println(Joiner.on(",").withKeyValueSeparator("==").join(result));
    }

    public static void turnStringToListWithLimit(){
        String input = "apple - banana - orange - kincolle1 - kincolle2 - kincolle3";
        List<String> result1 = Splitter.on("-").trimResults().limit(4)
                .splitToList(input);
        System.out.println(Joiner.on(",").join(result1));
        List<String> result2 = Splitter.on("-").trimResults().limit(5)
                .splitToList(input);
        System.out.println(Joiner.on(",").join(result2));
    }
}
