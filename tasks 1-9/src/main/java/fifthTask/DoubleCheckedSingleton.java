package fifthTask;

public class DoubleCheckedSingleton {
    private static volatile DoubleCheckedSingleton instance;

    public static DoubleCheckedSingleton getInstance() {
        DoubleCheckedSingleton localInstance = instance;
        if (localInstance == null) {
            synchronized (DoubleCheckedSingleton.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new DoubleCheckedSingleton();
                }
            }
        }
        return localInstance;
    }
}
