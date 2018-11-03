package PermutationAndCombination;

public class Quqiu {
    public static void main(String[] args) {

        int sum = f(6,5);//这个方法是从m个球中取n个球出来,返回取球方案数目
        System.out.println("共有" + sum + "种取法");
    }

    public static int f(int m, int n) {
        if(m==n){
            return 1;
        }
        if(n==0){
            return 1;
        }

        //假设有一个特殊球,有两种情况,从除特殊球剩下的球中，取n个球，另一种一定不取特殊球
        return f(m-1,n)+f(m-1,n-1);
    }
}
