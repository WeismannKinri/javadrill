package math;

public class Fibonacci {
    public static void main(String[] args) {
        int i1 = 1;
        int i2 = 1;
        int index=6;
        int fibonacciNumber=1;
        for(int i=3;i<=index;i++){
            fibonacciNumber=i1+i2;
            i1=i2;
            i2=fibonacciNumber;
        }
        System.out.println(fibonacciNumber);

    }
}
