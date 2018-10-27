package codility;

public class NGap {

    public static void main(String[] args) {
        System.out.println(solution(1041));
    }
    static public int solution(int N) {
        // write your code in Java SE 8
        String result = Integer.toBinaryString(N);
        String[] listOfZero = result.split("1");
        int length = 0;
        for(String zeroString:listOfZero){
            if(zeroString.length()>length){
                length=zeroString.length();
            }
        }
        return length;
    }
}
