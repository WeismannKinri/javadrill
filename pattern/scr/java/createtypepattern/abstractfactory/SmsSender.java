package createtypepattern.abstractfactory;

public class SmsSender implements Sender {
    @Override
    public void send(){
        System.out.println("This is createtypepattern.builder.SmsSender");
    }
}
