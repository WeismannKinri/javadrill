package leetcode.easy.RotateArray;

public class RotateArray {
    public void rotate(int[] nums, int k) {
        k = (nums.length + (k % nums.length)) % nums.length; // 保证k为正
        int tmp;

        for (int i = 0, j = nums.length - 1; i < j; i++, j--) {
            tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
        for (int i = 0, j = k - 1; i < j; i++, j--) {
            tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
        for (int i = k, j = nums.length - 1; i < j; i++, j--) {
            tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }


    public void rotate2(int[] nums, int k) {
        if(k==0 || nums==null ) return;
        k = k%nums.length;
        int tmp;
        for (int i = 0; i < (nums.length-k)/2; i++) {
            tmp = nums[i];
            nums[i] = nums[nums.length-k-1-i];
            nums[nums.length-k-1-i] = tmp;
        }
        /*for (int i : nums) {
            System.out.print(i+"-");
        }
        System.out.println();*/

        for (int i = 0; i < k/2; i++) {
            tmp = nums[i+nums.length-k];
            nums[i+nums.length-k] = nums[nums.length-1-i];
            nums[nums.length-1-i] = tmp;
        }

        /*for (int i : nums) {
            System.out.print(i+" ");
        }
        System.out.println();*/

        for (int i = 0; i < nums.length/2; i++) {
            tmp = nums[i];
            nums[i] = nums[nums.length-1-i];
            nums[nums.length-1-i] = tmp;
        }
    }

}