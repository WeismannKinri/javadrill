import java.util.Scanner;

class LineSlideWindow{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int W = sc.nextInt();
        int[] arrays = new int[W+1];
        for(int i =0; i<W+1;i++){
            arrays[0] = sc.nextInt();
        }
        quickSort(arrays);
        int largest = arrays[arrays.length-1];
        while(sc.hasNext()){
            int newNum = sc.nextInt();
            if(newNum > largest){
                largest=newNum;
            }
            System.out.println(largest);
        }
    }

    public static void quickSort(int[] arrays)
    {
        subQuickSort(arrays, 0, arrays.length - 1);
    }

    public static void subQuickSort(int[] arrays, int start, int end)
    {
        if (start >= end)
        {
            return;
        }
        int middleIndex = subQuickSortCore(arrays, start, end);
        subQuickSort(arrays, start, middleIndex - 1);
        subQuickSort(arrays, middleIndex + 1, end);
    }

    public static int subQuickSortCore(int[] arrays, int start, int end)
    {
        int middleValue = arrays[start];
        while (start < end)
        {
            while (arrays[end] >= middleValue && start < end)
            {
                end--;
            }
            arrays[start] = arrays[end];
            while (arrays[start] <= middleValue && start < end)
            {
                start++;
            }
            arrays[end] = arrays[start];
        }
        arrays[start] = middleValue;
        return start;
    }
}