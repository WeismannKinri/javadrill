package leetcode.easy.LongestPalindrome;

public class Solution {
    public int longestPalindrome(String s) {
        int []cnt=new int[58];
        int max=0;
        int len=0;
        for(int i=0;i<s.length();i++){
            cnt[s.charAt(i)-'A']++;
        }
        for(int i=0;i<58;i++){
            if(cnt[i]%2==0)
                len+=cnt[i];
            else {
                if(cnt[i]>max){
                    len+=max-1;
                    max=cnt[i];
                }
                else len=len+cnt[i]-1;
            }
        }
        return max==0?len:len+max+1;
    }
}
