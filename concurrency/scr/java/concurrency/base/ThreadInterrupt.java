package concurrency.base;

public class ThreadInterrupt {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(){
            @Override
            public void run(){
                while (true){
                    if(Thread.currentThread().isInterrupted()){
                        System.out.println("Interrupted");
                        break;
                    }
                }
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    System.out.println("Interrupted when sleep");
                    //set the interrupt stat
                    Thread.currentThread().interrupt();
                    e.printStackTrace();
                }
            }
        };
        t1.start();
        Thread.sleep(200);
        t1.interrupt();
    }
}
