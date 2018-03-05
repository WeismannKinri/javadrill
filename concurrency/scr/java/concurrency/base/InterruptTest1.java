package concurrency.base;

public class InterruptTest1 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(){
            @Override
            public void run(){
                while (true){
                    Thread.yield();
                }
            }
        };
        thread1.start();
        Thread.sleep(2000);
        thread1.interrupt();
    }
}
