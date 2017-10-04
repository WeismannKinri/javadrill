package Singleton;

public class SingletonWithProblemOfConcurrency1 {
    private static SingletonWithProblemOfConcurrency1 singleton = null;
    private SingletonWithProblemOfConcurrency1(){}
    public static SingletonWithProblemOfConcurrency1 getInstance(){
        if(singleton ==null)
            singleton = new SingletonWithProblemOfConcurrency1();
        return singleton;
    }
}

