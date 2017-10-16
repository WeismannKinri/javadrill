package strategy;

public class StrategyTest {
    public static void main(String[] args) {
        String exp = "2+3";
        ICalculator calculator = new Plus();
        System.out.println(calculator.calculator(exp));
    }
}
