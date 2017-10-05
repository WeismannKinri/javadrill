package structuretype.adapter.adapterinterface;

public class Adapter {
    public static void main(String[] args) {
        Sourceable source1 = new  SourceFun1();
        Sourceable source2 = new  SourceFun2();
        source1.method1();
        source1.method2();
        source2.method1();
        source2.method2();
    }
}
