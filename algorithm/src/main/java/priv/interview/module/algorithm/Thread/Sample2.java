package priv.interview.module.algorithm.Thread;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * 原子工具类
 */
public class Sample2 {

    static AtomicInteger ai = new AtomicInteger(100);

    public static void atomicInt() {
        System.out.println(ai.getAndIncrement());
        System.out.println(ai.get());
    }

    static int[] value = new int[]{1, 2};
    static AtomicIntegerArray aiArr = new AtomicIntegerArray(value);


    //arr.clone();
    public static void atomicArr() {
        aiArr.getAndSet(0, 10);
        System.out.println(aiArr.get(0));
        System.out.println(value[0]);
    }


    public static void main(String[] args) {
        atomicInt();
        atomicArr();
    }
}
