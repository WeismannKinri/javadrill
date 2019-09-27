import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class TestC extends TestAC {

    public void nb() {

    }

    public static void main(String[] args) {

        ExecutorService nb = Executors.newCachedThreadPool();


//
//        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> 100).thenApply(i -> -i);
//
//
//
//
//        CompletableFuture<Integer> other = CompletableFuture.supplyAsync(() -> 200);
//        future.thenAcceptBoth(other, (x, y) -> System.out.println(x + y));

//        ReentrantLock a= new ReentrantLock();
//        a.lock();
//        a.unlock();
//
//        ReentrantReadWriteLock b = new ReentrantReadWriteLock();
//
//        Callable<Integer> calculateCallable = new Callable<Integer>() {
//            @Override
//            public Integer call() throws Exception {
//                // TODO Auto-generated method stub
//                Thread.sleep(2000);//模拟耗时时间
//                int result = 1+2;
//                return result;
//            }
//        };
//
//
//        FutureTask<Integer> calculateFutureTask = new FutureTask<>(calculateCallable);
//
//        Thread t1 = new Thread(calculateFutureTask);
//        t1.start();

          int i = 0;


        if( 1==(i=1) || true) {
            System.out.println(i);
        }

//        threadLocal1.set(1);
//        threadLocal2.set(2);
//        System.out.println(threadLocal1.get());
//        System.out.println(threadLocal2.get());
//        TestI a = new TestC();
//        a.nb();
    }
}
