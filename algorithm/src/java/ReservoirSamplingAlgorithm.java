import java.util.Arrays;
import java.util.Random;

public class ReservoirSamplingAlgorithm {
    public static void main(String[] args) {
        int k=10;
        int n=1000;
        int[] data=new int[n];
        for(int i=0;i<n;i++){
            data[i]=i;
        }
        int[] result=reservoirSampling(data,k);
        System.out.println(Arrays.toString(result));
    }
    

    public static int[] reservoirSampling(int[] data,int k){
        if(data==null){
            return new int[0];
        }
        if(data.length<k){
            return new int[0];
        }
        int[] result=new int[k];
        int n=data.length;
        for(int i=0;i<n;i++){
            if(i<k){
                result[i]=data[i];
            }else{
                int j=new Random().nextInt(i);
                if(j<k){
                    result[j]=data[i];
                }
            }
        }
        return result;
    }
}
