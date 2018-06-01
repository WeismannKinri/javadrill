package others;

public class SyncDubbol {

        public synchronized void method1(){
            System.out.println("method1....");
            method2();
        }
        public synchronized void method2(){
            System.out.println("method2....");
            method3();
        }
        public synchronized void method3(){
            System.out.println("method3....");
        }

        public static void main(String[] args) {
            final SyncDubbol sd=new SyncDubbol();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    sd.method1();
                }
            }).start();
        }

}
