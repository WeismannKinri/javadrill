package createtypepattern.singleton;

public class SingletonWithProblemOfConcurrency2 {
    private static SingletonWithProblemOfConcurrency2 singletonWithProblemOfConcurrency2 = null;
    private SingletonWithProblemOfConcurrency2(){}
    public static SingletonWithProblemOfConcurrency2 getInstance(){
        if(singletonWithProblemOfConcurrency2==null)
            synchronized (singletonWithProblemOfConcurrency2){
                if(singletonWithProblemOfConcurrency2==null){
                    //with JMM problem
                    singletonWithProblemOfConcurrency2=new SingletonWithProblemOfConcurrency2();
                    return singletonWithProblemOfConcurrency2;
                }
            }
        return singletonWithProblemOfConcurrency2;
    }
}
