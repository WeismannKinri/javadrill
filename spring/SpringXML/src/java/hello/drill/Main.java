package hello.drill;

import initial.ClientService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        HelloWorld helloWorld = (HelloWorld)context.getBean("leijun",HelloWorld.class);
        helloWorld.sayHello();
        ClientService clientService = context.getBean("clientService",ClientService.class);
        if(clientService!=null)
            System.out.println("cs is not null");

    }
}
