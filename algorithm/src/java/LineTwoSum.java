
import java.util.HashSet;
import java.util.Scanner;
//The computing time is O(n) since there are only one loop
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
        HashSet<Integer> result = twoSum(boshi,target);
        int smallestNum = Integer.MAX_VALUE;
        for (Object obj: result) {
            if(obj instanceof Integer){
                int resultNumber = (Integer)obj;
                if(resultNumber==-1) {
                    System.out.println(-1);
                    return;
                }
                if(smallestNum>resultNumber)
                    smallestNum=resultNumber;
            }
        }

        System.out.println(smallestNum + " " + (target-smallestNum));
    }

    public static HashSet<Integer> twoSum(int[] nums, int target) {
        HashSet<Integer> result = new HashSet<>();
        HashSet<Integer> tmpResult = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (tmpResult.contains(complement)) {
                result.add(complement<(target/2)?complement:target-complement);
            }
            tmpResult.add(nums[i]);
        }
        if(result.size()!=0){
            return result;
        }else {
            return new HashSet<Integer>(){{add(-1);}};
        }
    }
}
