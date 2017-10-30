package javautildrill.lock;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {
    public static class Soldier implements Runnable{
        private String soldier;
        private final CyclicBarrier cyclic;

        Soldier(CyclicBarrier cyclic, String soldierName){
            this.cyclic=cyclic;
            this.soldier=soldierName;
        }

        @Override
        public void run() {
            try {
                //wait for all soldier
                cyclic.await();
                doWork();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
        void doWork(){
            try {
                Thread.sleep(Math.abs(new Random().nextInt()%10000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(soldier+":mission completed");
        }
    }

    public static class BarrierRun implements Runnable{
        boolean flag;
        int N;
        public BarrierRun(Boolean flag,int N){
            this.flag=flag;
            this.N=N;
        }

        @Override
        public void run() {
            if(flag){
                System.out.println("Commander:"+N+"soldiers are mission completed");
            }else{
                System.out.println("Commander:"+N+"soldiers are assembled");
                flag=true;
            }
        }
    }

    public static void main(String[] args) {
        final int N=10;
        Thread[] allSoldier = new Thread[N];
        boolean flag =false;
        CyclicBarrier cyclic = new CyclicBarrier(N,new BarrierRun(flag,N));

        System.out.println("assemble");
        for(int i = 0 ; i<N;++i){
            System.out.println(N+"th soldier report");
            allSoldier[i]=new Thread(new Soldier(cyclic,"soldier"+i));
            allSoldier[i].start();
        }
    }
}
