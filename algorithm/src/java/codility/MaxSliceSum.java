package codility;

public class MaxSliceSum {
    public int solution(int[] A){
        int size = A.length;
        int value = A[0];
        int last = value;
        for(int i=1;i<size;i++){
            last=Math.max(A[i],A[i]+last);
            if(last>value){
                value=last;
            }
        }
        return value;
    }
}