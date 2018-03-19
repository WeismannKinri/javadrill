package javautildrill.lock;

import java.util.concurrent.locks.ReentrantLock;

public class FairLock implements Runnable{
    public static ReentrantLock fairLock = new ReentrantLock(true);
    @Override
    public void run() {
        while (true){
            try{
                fairLock.lock();
                System.out.println(Thread.currentThread().getName()+" get the lock");
            }finally {
                fairLock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        FairLock fr = new FairLock();
        Thread t1 = new Thread(fr,"t1");
        Thread t2 = new Thread(fr,"t2");
        t1.start();
        t2.start();
    }
}
