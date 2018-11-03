package dynamicprogram;

import java.util.Arrays;

public class LongestCommonSubString {
    public static String commonSub(String st1, String st2){
        int index1 = 0;
        int index2 = 0;
        int maxLength = -1;

        if(st1==null || st2 == null){
            return null;
        }
        int[][] cache = new int[st1.length()][st2.length()];

        for(int[] row: cache){
            Arrays.fill(row, -1);
        }

        //initialize boarder
        for(int i=0; i<st2.length();i++){
            if(st1.charAt(0)==st2.charAt(i)){
                cache[0][i] = (st1.charAt(0)==st2.charAt(i)?1:0);
            }
        }

        for(int i=1; i<st1.length();i++){
            if(st2.charAt(0)==st1.charAt(i)){
                cache[i][0] = (st2.charAt(0)==st1.charAt(i)?1:0);
            }
        }

        for(int i = 0 ; i < st1.length(); i++){
            for(int j = 0 ; j <  st2.length(); j++){
                int length = calcLength(st1, st2, i, j, cache);
                if(length>maxLength){
                    maxLength = length;
                    index1 = i;
                    index2 = j;
                }
            }
        }
        return st1.substring(index1-maxLength+1, index1+1);
    }

    public static int calcLength(String st1, String st2, int i, int j, int[][] cache){
        if(cache[i][j]!=-1){
            return cache[i][j];
        }else{
            return cache[i][j]=(st1.charAt(i)==st2.charAt(j)?calcLength(st1, st2, i-1, j-1, cache)+1:0);
        }
    }


    public static int compute(char[] str1, char[] str2){
        int size1 = str1.length;
        int size2 = str2.length;
        if (size1 == 0 || size2 == 0) return 0;

        // 原始字符串中最长子串的起始位置
        int start1 = -1;
        int start2 = -1;
        int longest = 0;

        //拿字符串1做基准，检索最长连续子串
        for (int i = 0; i < size1; ++i){
            int m = i;
            int n = 0;
            int length = 0;
            while (m < size1 && n < size2){
                if (str1[m] != str2[n]){  //遇到不相等，则需要重新开始
                    length = 0;
                }
                else{
                    ++length;
                    if (longest < length){
                        longest = length;
                        start1 = m - longest + 1;  //记录下最长公共子串的起始位置
                        start2 = n - longest + 1;
                    }
                }
                ++m;
                ++n;
            }
        }
        // 拿字符串2做基准，进行再次搜索
        for (int j = 1; j < size2; ++j){
            int m = 0;
            int n = j;
            int length = 0;
            while (m < size1 && n < size2){
                if (str1[m] != str2[n]){
                    length = 0;
                }
                else {
                    ++length;
                    if (longest < length){
                        longest = length;
                        start1 = m - longest + 1;
                        start2 = n - longest + 1;
                    }
                }
                ++m;
                ++n;
            }
        }
        System.out.printf("from %d of str1 and %d of str2\n", start1, start2);
        return longest;
    }


    public static void main(String[] str){
        String str1 = "abdwhatthefuckdsgsd";
        String str2 = "634whatthefuck8gsg";
        System.out.println(commonSub(str1, str2));
    }




}
