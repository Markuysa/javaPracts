package fourthTask;

import java.util.ArrayList;
import java.util.concurrent.*;

public class myExecutor {

    static class threadsWorker extends Thread{
        @Override
        public void run() {
            while(!Thread.currentThread().isInterrupted()) {
                Runnable task = null;
                try {
                    task = tasksQueue.take();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                task.run();
            }
        }
    }

    public static BlockingQueue<Runnable> getTasksQueue() {
        return tasksQueue;
    }

    private static boolean condition = false;
    private final ArrayList<Thread> threadsPull;
    private static BlockingQueue<Runnable> tasksQueue;
    myExecutor(int threadsCount){
        threadsPull = new ArrayList<>();
        tasksQueue = new LinkedBlockingQueue<>();
        for (int i = 0;i<threadsCount;i++){
            threadsPull.add(new threadsWorker());
            threadsPull.get(i).start();
        }
    }
    void execute(Runnable task){
        tasksQueue.add(task);

    }
    void halt(){
        for(Thread i:threadsPull){
            i.interrupt();
        }
        condition = false;
    }




}
