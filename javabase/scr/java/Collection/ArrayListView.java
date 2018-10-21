package Collection;

import java.util.ArrayList;
import java.util.List;

public class ArrayListView {
    public static void main(String[] args) {
        ArrayList<Long> al = new ArrayList();
        al.add(1L);
        al.add(2L);
        al.add(3L);
        List<Long> sublist= al.subList(1,1);
        sublist.add(4L);
        System.out.println(al.size());
    }
}
