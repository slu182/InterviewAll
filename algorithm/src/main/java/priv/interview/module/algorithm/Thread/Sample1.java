package priv.interview.module.algorithm.Thread;

import sun.rmi.runtime.Log;

import java.util.concurrent.*;


/**
 * ExecutorService 基本用法 submit和execute的区别
 */
public class Sample1 {
    static int count = 0;
    static ExecutorService executorService = Executors.newFixedThreadPool(5);


    public static void excute() {
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    count++;
                }
            }
        });
        while (executorService.isTerminated()) {
            System.out.println(count);

        }
    }

    public static void submit() throws ExecutionException, InterruptedException {
        Future future = executorService.submit(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    count++;
                }
            }
        });

//        Thread.sleep(3000);
        System.out.println(future.isDone());
        Long start = System.nanoTime();

        // 下面这个代码是重点代码，怎么判断线程池的任务已经完成，isDone来控制
        while (future.isDone()) {
            break;
        }
        Long end = System.nanoTime();
        System.out.println(count + ":" + (end - start) + "ns");
        executorService.shutdown();

    }

    public static void submit2() throws ExecutionException, InterruptedException {
        Future<Integer> future = executorService.submit(new Callable<Integer>() {

            @Override
            public Integer call() throws Exception {
                for (int i = 0; i < 10000; i++) {
                    count++;
                }
                return count;
            }
        });
        System.out.println(future.get());

        executorService.shutdown();
    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {

        submit();

//        submit2();

    }
}
