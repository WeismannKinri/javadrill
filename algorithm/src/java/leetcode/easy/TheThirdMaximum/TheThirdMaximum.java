package leetcode.easy.TheThirdMaximum;

public class TheThirdMaximum {
    public int thirdMax(int[] nums) {
        double nFirst = Double.NEGATIVE_INFINITY;
        double nSecond = Double.NEGATIVE_INFINITY;
        double nThird = Double.NEGATIVE_INFINITY;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > nThird) {
                if (nums[i] < nSecond) {
                    nThird = nums[i];
                } else if (nums[i] > nSecond && nums[i] < nFirst) {
                    nThird = nSecond;
                    nSecond = nums[i];
                } else if (nums[i] > nFirst) {
                    nThird = nSecond;
                    nSecond = nFirst;
                    nFirst = nums[i];
                }
            }
        }
        return (int) (nThird == Double.NEGATIVE_INFINITY ? nFirst : nThird);
    }
}
