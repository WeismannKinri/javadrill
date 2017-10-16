import java.util.List;
import java.util.Vector;

public class ListDrill {
    public static void main(String[] args) {
        //without <E> List can add any type
        List list = new Vector();
        list.add(1);
        list.add("22");
        for(Object a:list){
            System.out.println(a.toString());
        }
        System.out.println("-----------------");
        list.add(1,2);
        for(Object a:list){
            System.out.println(a.toString());
        }
        System.out.println("---------");
        System.out.println("size is "+list.size());
        System.out.println(list.get(1));
        list.set(1,3);
        System.out.println(list.get(1));
//        list.clear();
//        System.out.println("-------");
//        for(Object a:list){
//            System.out.println(a.toString());
//        }
        System.out.println(list.contains(1));
        System.out.println("--------");

        list.clear();
        System.out.println(list.isEmpty());

    }
}
