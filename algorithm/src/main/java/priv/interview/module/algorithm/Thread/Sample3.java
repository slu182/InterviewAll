package priv.interview.module.algorithm.Thread;

import java.util.concurrent.CountDownLatch;

/**
 * CountDownLatch
 */
public class Sample3 {

    static CountDownLatch countDownLatch = new CountDownLatch(2);

    public static void main(String[] args) throws InterruptedException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("1");
                countDownLatch.countDown();
                System.out.println("2");
                countDownLatch.countDown();
            }
        }).start();

        System.out.println("3");
        countDownLatch.await();
        System.out.println("4");

        // 3 1 2 4
    }
}
