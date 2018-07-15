package hello.drill;

public class HelloWorld {
    private String name;
    private H2 h2;
    private H3 h3;

    public H3 getH3() {
        return h3;
    }

    public void setH3(H3 h3) {
        this.h3 = h3;
    }

    public H2 getH2() {
        return h2;
    }

    public void setH2(H2 h2) {
        this.h2 = h2;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void sayHello(){
        System.out.println(name);
        if(h2==null)
            System.out.println("h2 is null");
        else
            System.out.println(h2.getName());

        System.out.println(h3.getName());

    }


}
