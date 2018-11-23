package line;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LineTwoSum {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String arrayStr[] = scanner.nextLine().split("\\s+");
        String targetStr = scanner.nextLine();

        int[] boshi = new int[arrayStr.length];
        for(int i = 0; i < arrayStr.length; i++){
            boshi[i] = Integer.parseInt(arrayStr[i]);
        }
        Integer target = Integer.parseInt(targetStr);
        int[] value = twoSum(boshi,target);
        if(value[0]==-1){
            System.out.println(-1);
        }else {
            System.out.println(boshi[value[0]-1] + " "+ (target-boshi[value[0]-1]));
        }
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        int []none = new int[]{-1};
        return none;
    }
}
