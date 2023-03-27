package fifthTask;

public class SingletonOnDemandHolder {
    public static final SingletonOnDemandHolder HOLDER_INSTANCE = new SingletonOnDemandHolder();

    public static SingletonOnDemandHolder getInstance() {
        return SingletonOnDemandHolder.HOLDER_INSTANCE;
    }
}
