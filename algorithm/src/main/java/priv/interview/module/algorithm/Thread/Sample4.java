package priv.interview.module.algorithm.Thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * CyclicBarrier
 */
public class Sample4 implements Runnable {

    static CyclicBarrier cyclicBarrier = new CyclicBarrier(5);
    static ExecutorService executorService = Executors.newFixedThreadPool(10);
    static int count = 0;

    private void count() {
        for (int i = 0; i < 4; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("count id:" + Thread.currentThread().getId());

                    // 这里可以是费时的计算
                    try {
                        Thread.sleep(5000);
                        count++;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    try {
                        cyclicBarrier.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }

                }
            });
            System.out.println("count:" + count);
        }
    }

    @Override
    public void run() {
        System.out.println("run id:" + Thread.currentThread().getId());

        System.out.println("run:" + count);
    }


    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
        System.out.println("main id：" + Thread.currentThread().getId());

        Sample4 sample4 = new Sample4();
        sample4.run();
        sample4.count();
//        cyclicBarrier.await();
        System.out.println("end");

        executorService.shutdown();
        while (executorService.isShutdown()) {
            break;
        }
        System.out.println(executorService);


    }
}
