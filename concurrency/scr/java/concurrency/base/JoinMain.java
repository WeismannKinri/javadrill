package concurrency.base;

public class JoinMain {
    public volatile static int i = 0;
    public static class addThread extends Thread{
        @Override
        public void run() {
            for(i=0;i<10000000;i++);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        addThread addThread = new addThread();
        addThread.start();
        addThread.join();
        System.out.println(i);
    }
}
