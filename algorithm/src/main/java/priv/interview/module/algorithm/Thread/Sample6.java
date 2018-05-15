package priv.interview.module.algorithm.Thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * fork/join condition LockSupport
 */
public class Sample6 {
    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    public void add() {
        lock.lock();
        try {
            while (Boolean.TRUE) {
                condition.await();
            }

/**
 *
 * 业务逻辑执行模块
 */
            condition.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }


}
