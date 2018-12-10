package future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureTast {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture.supplyAsync(() -> "hello").thenAccept(s -> System.out.println(s+" world")).get();
        CompletableFuture.supplyAsync(() ->{
            String a = "123";
            if(1==1)
                throw new RuntimeException("123");
            System.out.println(312);
            return null;
                }


        ).exceptionally(e -> {
            System.out.println(e);
            return null;
        }).join();
    }
}

