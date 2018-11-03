package dynamicprogram;

public class NCoin {
    public static void nCoin(int targetValue, int [] coinValue){
        // 存放每个金额需要的最小硬币数
        int[] coinUsed = new int[targetValue + 1];
        // 当金额为0，初始化需要硬币数为0
        coinUsed[1] = 1;
        for (int i = 1; i <= targetValue; i++) {
            // 申请一个变量存储临时的money,初始化无限大
            coinUsed[i]  = i;
            for (int j = 1; j <= coinValue.length; j++) {
                if(coinValue[j-1]<=i){
                    int temp = coinUsed[i - coinValue[j-1]] + 1;
                    if(temp < coinUsed[i]){
                        coinUsed[i] = temp;
                    }
                }
            }
            System.out.println(i + "最小硬币数：" + coinUsed[i]);
        }
    }
    public static void main(String[] args) {
        int[] value = new int[]{2,4};
        int targetValue = 12;
        nCoin(targetValue,value);
    }
}