package structuretype.adapter.adapterinstance;

public class AdapterTest {
    public static void main(String[] args) {
        Source source = new Source();
        Targetable wrapper = new Wrapper(source);
        wrapper.method1();
        wrapper.method2();
    }
}
