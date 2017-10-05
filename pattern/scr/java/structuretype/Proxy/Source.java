package structuretype.Proxy;

public class Source implements Sourceable {
    @Override
    public void method() {
        System.out.println("This is the original method.");
    }
}
