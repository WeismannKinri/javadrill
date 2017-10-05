package createtypepattern.builder;

import java.util.ArrayList;
import java.util.List;

public class Builder {
    private List<Sender> list = new ArrayList<>();

    public void produceMailSender(int number) {
        for(int i=0;i<number;i++){
            list.add(new MailSender());
        }
    }

    public void produceSmsSender(int number) {
        for(int i=0;i<number;i++){
            list.add(new SmsSender());
        }
    }
}
