package leetcode.easy.ReverseInteger;

import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Queue;

public class ReverseInteger {
    public int reverse(int x) {
        Queue<Integer> q = new LinkedList<Integer>();
        int count = 0;
        while(x!=0){
            count++;
            int r=x%10;
            q.add(r);
            x=(x-r)/10;
        }

        int nx = 0;
        for(int i=count;i>0;i--){
            int temp = q.poll();
            int j=i;
            int carry=1;
            while(j>1){
                carry=carry*10;
                j--;
            }
            nx = nx+temp*carry;
        }
        return nx;
    }


    public int reverse1(int x) throws Exception {
        int result = 0;

        while (x != 0)
        {
            int tail = x % 10;
            int newResult = result * 10 + tail;
            if ((newResult - tail) / 10 != result)
            { return 0; }
            result = newResult;
            x = x / 10;
        }

        return result;
    }

}
