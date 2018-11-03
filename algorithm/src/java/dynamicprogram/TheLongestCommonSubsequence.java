package dynamicprogram;

import java.util.ArrayList;
import java.util.List;

public class TheLongestCommonSubsequence {
    public static List<String> getLCSstring(char[] str1, char[] str2) {
        int i, j;
        int len1, len2;
        len1 = str1.length;
        len2 = str2.length;
        int maxLen = len1 > len2 ? len1 : len2;
        int[] max = new int[maxLen];
        int[] maxIndex = new int[maxLen];
        int[] c = new int[maxLen];
        List<String> list = new ArrayList<>();
        //生成矩阵
        for (i = 0; i < len2; i++) {
            for (j = len1 - 1; j >= 0; j--) {
                if (str2[i] == str1[j]) {
                    if ((i == 0) || (j == 0))
                        c[j] = 1;
                    else
                        c[j] = c[j - 1] + 1;
                } else {
                    c[j] = 0;
                }

                if (c[j] > max[0]) {   //如果是大于那暂时只有一个是最长的,而且要把后面的清0;
                    max[0] = c[j];
                    maxIndex[0] = j;

                    for (int k = 1; k < maxLen; k++) {
                        max[k] = 0;
                        maxIndex[k] = 0;
                    }
                } else if (c[j] == max[0]) {   //有多个是相同长度的子串
                    for (int k = 1; k < maxLen; k++) {
                        if (max[k] == 0) {
                            max[k] = c[j];
                            maxIndex[k] = j;
                            break;  //在后面加一个就要退出循环了
                        }

                    }
                }
            }
        }

        for (j = 0; j < maxLen; j++) {
            if (max[j] > 0) {

                StringBuffer sb = new StringBuffer();
                for (i = maxIndex[j] - max[j] + 1; i <= maxIndex[j]; i++) {
                    sb.append(str1[i]);
                }
                String lcs = sb.toString();
                list.add(lcs);
            }
        }
        return list;
    }

    public static void main(String[] args) {

        String str1 = new String("adbba12345");
        String str2 = new String("adbbf1234sa");
        List<String> list = getLCSstring(str1.toCharArray(), str2.toCharArray());
        for (int i = 0; i < list.size(); i++) {
            System.out.println("第" + (i + 1) + "个公共子串:" + list.get(i));
        }

        str1 = new String("adbab1234");
        str2 = new String("adbbf123s4a");
        list = getLCSstring(str1.toCharArray(), str2.toCharArray());
        for (int i = 0; i < list.size(); i++) {
            System.out.println("第" + (i + 1) + "个公共子串:" + list.get(i));
        }

    }


    public static int[][] lengthofLCS(char[] X, char[] Y){
        /* 构造二维数组c[][]记录X[i]和Y[j]的LCS长度 (i,j)是前缀
         * c[i][j]=0; 当 i = j = 0;
         * c[i][j]=c[i-1][j-1]+1; 当 i = j > 0; Xi == Y[i]
         * c[i][j]=max(c[i-1][j],c[i][j+1]); 当 i = j > 0; Xi != Y[i]
         * 需要计算 m*n 个子问题的长度 即 任意c[i][j]的长度
         * -- 填表过程
         */
        int[][]c = new int[X.length+1][Y.length+1];

        // 动态规划计算所有子问题
        for(int i=1;i<=X.length;i++){
            for (int j=1;j<=Y.length;j++){
                if(X[i-1]==Y[j-1]){
                    c[i][j] = c[i-1][j-1]+1;
                }
                else if(c[i-1][j] >= c[i][j-1]){
                    c[i][j] = c[i-1][j];
                }
                else{
                    c[i][j] = c[i][j-1];
                }
            }
        }

        // 打印C数组
        for(int i=0;i<=X.length;i++){
            for (int j=0;j<=Y.length;j++){
                System.out.print(c[i][j]+" ");
            }
            System.out.println();
        }
        return c;
    }
    // 输出LCS序列
    public static void print(int[][] arr, char[] X, char[] Y, int i, int j) {
        if(i == 0 || j == 0)
            return;
        if(X[i-1] == Y[j-1]) {
            System.out.print("element " + X[i-1] + " ");
            // 寻找的
            print(arr, X, Y, i-1, j-1);
        }else if(arr[i-1][j] >= arr[i][j-1]) {
            print(arr, X, Y, i-1, j);
        }else{
            print(arr, X, Y, i, j-1);
        }
    }
    public static void mai2(String[] args) {
        // TODO Auto-generated method stub
        char[] x ={'A','B','C','B','D','A','B'};
        char[] y ={'B','D','C','A','B','A'};
        int[][] c = lengthofLCS(x,y);
        print(c, x, y, x.length, y.length);
    }

}
