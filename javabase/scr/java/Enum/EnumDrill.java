package Enum;

public class EnumDrill {
    public static void main(String[] args) {

        for (EnumTest e : EnumTest.values()) {
            System.out.println(e.toString());
        }

        System.out.println("----------------Line------------------");

        EnumTest test = EnumTest.THU;
        switch (test) {
            case MON:
                System.out.println("Today is Monday");
                break;
            case TUE:
                System.out.println("Today is Muesday");
                break;
            // ... ...
            default:
                System.out.println(test);
                break;
        }

        //compareTo(E o)
        System.out.println("compareTo:" + test.compareTo(EnumTest.MON));

        //getDeclaringClass()
        System.out.println("getDeclaringClass(): " + test.getDeclaringClass().getName());

        //name() and toString()
        System.out.println("name(): " + test.name());
        System.out.println("toString(): " + test.toString());

        //ordinal()， the return value begins from 0
        System.out.println("ordinal(): " + test.ordinal());
    }
}
