package fifthTask;

public class Singleton {
    private  Singleton singleton;

    public synchronized Singleton getInstance(){

        if (singleton == null){
            singleton = new Singleton();
        }
        return singleton;
    }
}
