public class JavaString {
    String a = "a";

    public static void main(String[] args) {
        JavaString js1 = new JavaString();
        System.out.println(js1.a.equals("a"));
        System.out.println(js1.a == "a");

        String a1 = new String("a");
        String a2 = new String("a");
        System.out.println(a1==a2);
        System.out.println(a1.equals(a2));
        System.out.println(a1=="a");
        System.out.println(a1.equals("a"));
        System.out.println("a".equals(a1));

        Long b1= new Long(2);
        Long b2= new Long(2);
        System.out.println(b1==b2);
    }
}
