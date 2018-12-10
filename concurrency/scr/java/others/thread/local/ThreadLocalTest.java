package others.thread.local;

public class ThreadLocalTest {
    public static void main(String[] args) {
        ThreadLocal<String> a = new ThreadLocal();
        ThreadLocal<String> b = new ThreadLocal();
        a.set("a");
        b.set("b");
        System.out.println(a.get());
        System.out.println(b.get());
    }
}
