public class JavaNull {
    public static void main(String[] args) {
        func(new String[]{null});
        func((String)null);
        //This is a wrong invoke
        func(null);
        func(null,null);

    }
    public static void func(String...arg){
        System.out.println("arg length = "+arg.length);
    }
}
