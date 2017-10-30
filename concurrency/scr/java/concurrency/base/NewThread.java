package concurrency.base;

public class NewThread {
    public static void main(String[] args) {
        Thread t1 = new Thread();
        //start a new thread and do sth
        t1.start();
        //only do sth at the current thread
        t1.run();
    }
}
