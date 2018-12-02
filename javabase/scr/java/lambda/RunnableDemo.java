package lambda;

public class RunnableDemo {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Test 1");
            }
        }).start();

        new Thread(() -> System.out.println("Test 2")).start();

        Runnable r = () -> System.out.println("Test 2");
        new Thread(r).start();
    }
}
