package first;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan
public class Application {

//    @Bean
//    first.MessageService mockMessageService() {
//        return new first.MessageService() {
//            public String getMessage() {
//                return "Hello World!";
//            }
//        };
//    }

    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(Application.class);
        first.MessagePrinter printer = context.getBean(first.MessagePrinter.class);
        printer.printMessage();
        System.out.println("1");
    }
}