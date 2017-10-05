package structuretype.bridge;

public class BridgeTest {
    public static void main(String[] args) {
        Bridge bridge = new Bridge();
        Sourceable source = new Source1();
        bridge.setSource(source);
        bridge.run();;
        source = new Source2();
        bridge.setSource(source);
        bridge.run();
    }
}
