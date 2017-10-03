package Reflection;

import java.lang.reflect.Field;

public class GetValue {
    public static void main(String[] args) throws NoSuchMethodException, ClassNotFoundException, IllegalAccessException {
        TestClassEx t = new TestClassEx();

        for (Field f : t.getClass().getDeclaredFields()) {
            f.setAccessible(true);
            Object value = f.get(t);
            System.out.println(f.getName() + ":" + value);
        }
    }
}

class TestClassEx{
    private String kincolle = "This is kincolle\'s reflection drill test.";
}