package concurrency.base;

public class InterruptTest2 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(){
            @Override
            public void run(){
                while (true){
                    if(Thread.currentThread().isInterrupted()){
                        System.out.println("it is interrupted");
                        break;
                    }
                    Thread.yield();
                }
            }
        };
        thread1.start();
        Thread.sleep(2000);
        thread1.interrupt();
    }
}
