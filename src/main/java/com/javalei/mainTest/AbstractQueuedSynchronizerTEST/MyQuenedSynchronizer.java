package com.javalei.mainTest.AbstractQueuedSynchronizerTEST;



import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

    /**
     *
     * 如果你看到了这里  首先你肯定是需要用到线程类了
     *
     * 记住 1.8的synchronized 要比Lock的性能更高
     *
     * 如果不是需要完成特定的需求
     *
     * 请使用synchronized的关键字来完成同步操作
     *
     * 独占锁的Lock-AbstractQueuedSynchronizer 实现类
     * <p>
     *
     *
     * zzw 2017-12-03
     */

public class MyQuenedSynchronizer implements Lock {

    private static class  Sync extends AbstractQueuedSynchronizer {

        /**
         * 可重入
         * @param acquires
         * @return
         */
        @Override
        protected boolean tryAcquire(int acquires) {

            final Thread current = Thread.currentThread();//可重入

            int c = getState();   //获取当前的线程数

            if (acquires != 1||c>=1)  //独占所必须等于1
                throw new Error("独占锁必须是1个线程");



            //如果线程数只有一个的情况的下
            if (compareAndSetState(0, 1)) {   //调用了jdk  unsafe的指针偏移, 使用cpu硬件来进行原子操作
                //将此线程设置为当前线程
                setExclusiveOwnerThread(current);
                return true;
            }

            return false;
            // 可重入
            //setExclusiveOwnerThread(Thread.currentThread());
        }

        @Override
        protected boolean tryRelease(int arg) {
            //如果当前线程不是存放的线程
            if(Thread.currentThread()!=getExclusiveOwnerThread())
                throw  new IllegalMonitorStateException();
            setState(0);
            setExclusiveOwnerThread(null);
            return true;
        }


        @Override
        protected boolean isHeldExclusively() {
            return getState()==1;
        }

        /***
         * 返回一个ConditionObject 每一个ConditionObject 都包含了一个Condition队列
         * @return
         */
        Condition newCondition(){
            return  new ConditionObject();
        }
    }

    private  final Sync sync=new Sync();

    @Override
    public void lock() {
            sync.acquire(1);
    }

    /**
     *  尝试做一次快速的获取锁,
     *
     *  如果没有获取成功加入同步队列的尾部
     *
     *  等待前面一个节点完成work来唤醒这个线程
     *
     * @throws InterruptedException
     */
    @Override
    public void lockInterruptibly() throws InterruptedException
        {
            sync.acquireInterruptibly(1);
        }
    @Override
    public boolean tryLock() {
        return sync.tryAcquire(1);
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        //转成毫秒级别
        return sync.tryAcquireNanos(1,unit.toNanos(time));
    }

    @Override
    public void unlock() {
        sync.release(1);
    }

    @Override
    public Condition newCondition() {
        return newCondition();
    }

}
