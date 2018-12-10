package synchronize;

public class ReSync {
    Integer i=0;
    public static void main(String[] args) {
    }
    public void aa(){
        synchronized (i){
            synchronized (i){

            }
        }
    }
}

