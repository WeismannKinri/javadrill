package prime;

public class GetPrime {
    public static void main(String[]args){
        int n=39;
        getPrime(n);
    }

    private static void getPrime(int n) {
        // TODO Auto-generated method stub
        System.out.print("质数（素数）有： 2,");

        //2是质数，偶数都不是质数（素数）两个数的积为定值n，则一个数变大一个数一定变小，其中一个数必小于等于sqrt(n)，则只要整除sqrt(n)以内的数就可以判断是否是质数
        for (int i = 3; i < n; i+=2) {
            boolean isPrime=true;
            for (int j = 3; j <= Math.sqrt(i); j++) {
                if(i%j==0)
                {
                    isPrime=false;
                    break;
                }
            }
            if(isPrime){
                System.out.print(" "+i+";");
            }
        }
    }
}