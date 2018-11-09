package leetcode.medium;

public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        String T = "#";
        for(int i = 0; i < s.length(); ++i){
            T += s.charAt(i) + "#";
        }
        T = "^" + T + "$";
        int n = T.length();
        int[] P = new int[n];
        int C = 0, L = 0, R = 0;
        int maxCenter = 0;
        int maxLen = 0;
        for(int i = 1; i < n - 1; ++i){
            int i_mirror = 2 * C - i;
            //以i'为中心的回文串 达到/超出 了LR边界
            if(i_mirror < 0 || i_mirror - P[i_mirror] <= L){
                P[i] = (R > i) ? (R-i) : 0;
                //对P扩展
                while(T.charAt(i - 1 - P[i]) == T.charAt(i + 1 + P[i])){
                    ++P[i];
                }
                R = i + P[i];
                L = i - P[i];
                C = i;
            }
            //以i'为中心的回文串未达到LR边界
            else{
                P[i] = P[i_mirror];
            }
            //保存最长回文串的信息，
            if(P[i] > maxLen){
                maxLen = P[i];
                maxCenter = i;
            }
        }
        int start = (maxCenter - 1 - maxLen) / 2;
        return s.substring(start, start + maxLen);
    }


    public String longestPalindromeWithDP(String s)
    {
        if(s.length() <= 1) return s;

        boolean[][] P = new boolean[s.length()][s.length()];
        String res = new String();
        for(int i = 0; i < s.length();i++) P[i][i] = true;
        int max = 0;
        for(int i = 0; i < s.length();i++)
        {
            for(int j = 0; j < i; j++)
            {
                P[j][i] = (s.charAt(j) == s.charAt(i) && (i-j <= 2 || P[j+1][i-1]));
                if(P[j][i])
                {
                    if(i-j + 1 > max)
                    {
                        max = i-j+1;
                        res = new String(s.substring(j,i+1));
                    }


                }
            }
        }

        return res;


    }


}
