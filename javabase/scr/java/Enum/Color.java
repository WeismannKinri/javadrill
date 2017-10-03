package Enum;

public enum Color implements Behaviour{
    //in fact it runs 4 times to create these things
    RED("红色", 1), GREEN("绿色", 2), BLANK("白色", 3), YELLO("黄色", 4);
    // 成员变量
    private String name;
    private int index;
    // 构造方法
    private Color(String name, int index) {
        this.name = name;
        this.index = index;
    }
    //interface function
    @Override
    public String getInfo() {
        return this.name;
    }
    public int getIndex(){
        return this.index;
    }
    //interface function
    @Override
    public void print() {
        System.out.println(this.index+":"+this.name);
    }
}