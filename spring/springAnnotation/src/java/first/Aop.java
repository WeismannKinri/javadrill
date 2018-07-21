package first;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class Aop {

    @After("")
    public void after(){
        System.out.println("after");
    }
}


