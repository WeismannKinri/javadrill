package concurrency.base;

public class NewThreadUsingRannable implements Runnable{

    public static void main(String[] args) {
        Thread t1 = new Thread(new NewThreadUsingRannable());
        t1.start();
    }
    @Override
    public void run(){
        System.out.println("This is using Runnable interface");
    }
}
