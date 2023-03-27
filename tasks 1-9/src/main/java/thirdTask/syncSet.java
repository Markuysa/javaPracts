package thirdTask;

import java.util.HashSet;
import java.util.Set;

public class syncSet<T> {

    private Set<T> set;

    syncSet(){
        set = new HashSet<>();
    }
    synchronized void add(T object){
        set.add(object);
    }
    synchronized void remove(T object){
        set.remove(object);
    }

}
