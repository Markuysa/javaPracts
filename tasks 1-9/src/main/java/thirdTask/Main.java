package thirdTask;

import java.util.HashMap;
import java.util.Map;

public class Main {
    static int sharedVar;
    public static void main(String[] args) {
        semaphoredMap<Integer,Integer> map = new semaphoredMap<>(2);
        syncSet<Integer> set = new syncSet<>();
            new ThreadRunner() {
                @Override
                public void thread1() {
                    map.add(1,2);
                    set.add(1);
                }
                @Override
                public void thread2() {
                    map.remove(1);
                    set.remove(1);
                }
            };
        }

    }

