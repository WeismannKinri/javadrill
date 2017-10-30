package concurrency.base;

public class NewThreadDoSth {
    public static void main(String[] args) {
        Thread t1 =new Thread(){
            @Override
            public void run(){
                System.out.println("This is t1 thread");
            }
        };
        t1.start();
    }
}
