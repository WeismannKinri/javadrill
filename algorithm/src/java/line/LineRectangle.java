package line;

import java.util.Scanner;

public class LineRectangle {
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);
        String lengthStr = scanner.next();
        String widthStr = scanner.next();
        int length = Integer.parseInt(lengthStr);
        int width = Integer.parseInt(widthStr);
        if(length < 0 || length > 1024 || width < 0 || width > 1024){
            throw new IllegalArgumentException();
        }
        System.out.println(length * width);
    }
}
