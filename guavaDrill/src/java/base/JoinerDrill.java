package base;

import com.google.common.base.Joiner;

import java.util.*;

//the Joiner is immutable, so it is thread safe
public class JoinerDrill {
    public static void main(String[] args) {
        JoinerDrill.joinerList();
        JoinerDrill.joinerIterator();
        JoinerDrill.joinerNoNull();
        JoinerDrill.joinerReplaceNull();
        JoinerDrill.joinerMultipleElements();
        JoinerDrill.joinerWithStringsAndList();
        JoinerDrill.joinerWithMap();
    }

    public static void joinerList(){
        List<Object> list = new ArrayList<>();
        list.add("kincolle2");
        list.add("kincolle1");
        System.out.println(Joiner.on(",").join(list));
    }

    public static void joinerIterator(){
        List<Object> list = new ArrayList<>();
        list.add("kincolle2");
        list.add("kincolle1");
        Iterator iterator = list.iterator();
        System.out.println(Joiner.on(",").join(iterator));
    }

    public static void joinerNoNull(){
        List<Object> list = new ArrayList<>();
        list.add("kincolle2");
        list.add(null);
        list.add("kincolle1");
        System.out.println(Joiner.on(",").skipNulls().join(list));
    }

    public static void joinerReplaceNull(){
        List<Object> list = new ArrayList<>();
        list.add("kincolle2");
        list.add(null);
        list.add("kincolle1");
        System.out.println(Joiner.on(",").useForNull("ForNullReplace").join(list));
    }

    public static void joinerMultipleElements(){
        Joiner joiner =  Joiner.on(",");
        System.out.println(joiner.join("123","345","56","43"));
    }

    public static void joinerWithStringsAndList(){
        Joiner joiner =  Joiner.on(",").skipNulls();
        List<String> list =new ArrayList<String>();
        list.add("kincolle1");
        list.add(null);
        list.add("kincolle2");
        list.add("kincolle3");
        StringBuilder builder1=new StringBuilder("kincolle4");
        System.out.println(joiner.appendTo(builder1,list));
        StringBuilder builder2=new StringBuilder("kincolle4");
        System.out.println(joiner.appendTo(builder2,"1","2"));
    }

    public static void joinerWithMap(){
        Map<String, String> map = new HashMap<>();
        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");
        Joiner.MapJoiner mapJoiner = Joiner.on(",").withKeyValueSeparator("=");
        System.out.println(mapJoiner.join(map));
    }
}
