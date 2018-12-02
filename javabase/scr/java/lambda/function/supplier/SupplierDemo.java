package lambda.function.supplier;

import java.util.function.DoubleSupplier;
import java.util.logging.Logger;

public class SupplierDemo {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger("...");
        DoubleSupplier randomSupplier = new DoubleSupplier() {
            @Override
            public double getAsDouble() {
                return Math.random();
            }
        };
        System.out.println(randomSupplier.getAsDouble());
        System.out.println("=====");
        randomSupplier = () -> Math.random();
        System.out.println(randomSupplier.getAsDouble());
        System.out.println("=====");
        randomSupplier = Math::random;
        System.out.println(randomSupplier.getAsDouble());
    }
}
