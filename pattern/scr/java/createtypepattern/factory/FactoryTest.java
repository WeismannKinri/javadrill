package createtypepattern.factory;

public class FactoryTest {
    public static void main(String[] args) {
        SenderFactory.SmsSender().send();
        SenderFactory.MailSender().send();
    }
}
