package createtypepattern.factory;

public class SenderFactory {
    public static Sender MailSender(){
        return new MailSender();
    }
    public static Sender SmsSender(){
        return new SmsSender();
    }


}
