package templatemethod;

public class StrategyTest {

    public static void main(String[] args) {
        String exp = "8+6";
        AbstractCalculator cal = new Plus();
        int result = cal.calculate(exp, "\\+");
        System.out.println(result);
    }
}