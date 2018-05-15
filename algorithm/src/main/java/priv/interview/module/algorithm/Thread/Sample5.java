package priv.interview.module.algorithm.Thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.Semaphore;

/**
 * Semaphore
 */
public class Sample5 {
    static int MAX_Count = 30;
    static ExecutorService executorService = Executors.newFixedThreadPool(MAX_Count);
    static Semaphore semaphore = new Semaphore(5);

    public static void main(String[] args) {
        for (int i = 0; i < MAX_Count; i++) {

            int finalI = i;
            Future future = executorService.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        semaphore.acquire();
                        System.out.println("save data" + finalI);
                        semaphore.release();

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }


        executorService.shutdown();
    }
}
