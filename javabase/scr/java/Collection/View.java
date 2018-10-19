package Collection;

import java.util.Arrays;
import java.util.List;

public class View {
    public static void main(String[] args) {
        View[] tests = new View[10];
        List<View> testList = Arrays.asList(tests);
        View b = new View();
        testList.add(b);
    }
}
