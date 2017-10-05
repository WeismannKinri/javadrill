package structuretype.bridge;

public class Bridge {
    private Sourceable source;
    public Sourceable getSource() {
        return source;
    }

    public void setSource(Sourceable source) {
        this.source = source;
    }

    public void run(){
        this.source.method();
    }
}
