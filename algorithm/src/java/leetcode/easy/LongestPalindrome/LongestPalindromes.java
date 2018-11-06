package leetcode.easy.LongestPalindrome;

import java.util.BitSet;

public class LongestPalindromes {
    private int getIndex(char ch) {
        return (int)ch >= 'a' ? ch - 'a' + ('Z' - 'A') : ch - 'A';
    }

    public int longestPalindrome(String s) {
        int ret = 0;
        BitSet bs = new BitSet(26 * 2);
        for (int i = 0; i < s.length(); i++) {
            int index = getIndex(s.charAt(i));
            bs.set(index, !bs.get(index));
            // 如果之为false，说明取反之前是true，则这是第二次遇到该字母了，回文长度+2
            if (!bs.get(index)) {
                ret += 2;
            }
        }
        // 不为空说明还有字母，可选择一个作为回文字符串的中间字符。
        if (!bs.isEmpty()) {
            ret += 1;
        }

        return ret;
    }

    public static void main(String[] args) {
        LongestPalindromes s = new LongestPalindromes();
        assert(s.longestPalindrome("abcba") == 5);
        assert(s.longestPalindrome("aa") == 2);
        assert(s.longestPalindrome("abccccdd") == 7);
        assert(s.longestPalindrome("Abccccdd") == 7);
        assert(s.longestPalindrome("a") == 1);
        assert(s.longestPalindrome("") == 0);
    }
}
