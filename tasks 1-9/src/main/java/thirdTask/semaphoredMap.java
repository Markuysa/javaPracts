package thirdTask;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Semaphore;

public class semaphoredMap<T,K> {
    private int size;
    private final Semaphore syncSemaphore;
    private Map<T,K> map;

    semaphoredMap(int permits){
        this.map = new HashMap<>();
        this.syncSemaphore = new Semaphore(permits);
    }

    void add(T key, K value){
        try{
            syncSemaphore.acquire();
            map.put(key,value);
            syncSemaphore.release();
        }
        catch(InterruptedException e){System.out.println(e.getMessage());}
    }
    void remove(T key){
        try{
            syncSemaphore.acquire();
            map.remove(key);
            syncSemaphore.release();
        }
        catch(InterruptedException e){System.out.println(e.getMessage());}
    }
}
