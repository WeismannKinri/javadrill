package leetcode.easy.AddStrings;

public class AddStrings {
    public String addStrings(String num1, String num2) {
        String bigStr = null;
        String smallStr = null;

        if (num1.length() >= num2.length()) {
            bigStr = num1;
            smallStr = num2;
        } else {
            bigStr = num2;
            smallStr = num1;
        }

        int big = bigStr.length();
        int small = smallStr.length();
        int carry = 0;
        char []ra = new char[big + 1];
        for (int i = 0; i < small; i++) {
            int b = Character.getNumericValue(bigStr.charAt(big - i - 1));
            int s = Character.getNumericValue(smallStr.charAt(small - i - 1));
            ra[big - i] = Character.forDigit((b + s + carry) % 10, 10);
            carry = (b + s + carry) / 10;
        }

        for (int i = 0; i < big - small; i++) {
            int b = Character.getNumericValue(bigStr.charAt(big - small - i - 1));
            ra[big - small - i] = Character.forDigit((b+ carry) % 10, 10);
            carry = (b + carry)/ 10;
        }
        if (carry != 0) {
            ra[0] = Character.forDigit(carry % 10, 10);
        }

        String ret = new String(ra).trim();
        return ret;
    }


    public String addStringsNiuRen(String num1, String num2) {
        int i = num1.length() - 1, j = num2.length() - 1, carry = 0;
        String res = "";
        while (i >= 0 || j >= 0) {
            if (i >= 0)
                carry += num1.charAt(i--) - '0';
            if (j >= 0)
                carry += num2.charAt(j--) - '0';
            res = Integer.toString(carry % 10) + res;
            carry /= 10;
        }
        return carry != 0 ? "1" + res : res;
    }
}
