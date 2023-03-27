package fifthTask;

public class Main {

    public static void main(String[] args) {
        DoubleCheckedSingleton dbcSingleton = new DoubleCheckedSingleton();
        dbcSingleton.getInstance();
    }


}
