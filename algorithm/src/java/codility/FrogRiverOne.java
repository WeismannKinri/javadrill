package codility;

public class FrogRiverOne {
    public int solution(int X, int Y, int D) {
        // write your code in Java SE 8
        return (((Y-X)/D) +((((Y-X)%D)==0)?0:1));
    }
}
