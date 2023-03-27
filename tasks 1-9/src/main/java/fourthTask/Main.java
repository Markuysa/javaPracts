package fourthTask;

public class Main {
    static int sharedVar;

    public static void main(String[] args) {
        myExecutor executor = new myExecutor(5);

        for (int i = 0; i < 10; i++) {
            final int taskId = i;
            executor.execute(() -> {
                System.out.println(Thread.currentThread().getName() + " is running with task" + taskId);
                try {
                    Thread.sleep(1000);

                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }

        while (!Thread.currentThread().isInterrupted() && executor.getTasksQueue().size() > 0) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        executor.halt();
    }
}

