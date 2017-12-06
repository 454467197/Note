package com.javalei.mainTest.AbstractQueuedSynchronizerTEST;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class MyShaerQuenedSynchronizer implements Lock{

    private static class sync extends AbstractQueuedSynchronizer{

        sync(int arg){
            if(arg<0)
               throw  new Error("线程数必须大于0");
            setState(arg);
        }

        //TODO 共享锁没有理解清楚
        @Override
        protected int tryAcquireShared(int arg) {
            //首先获取正在使用的线程数
            int count=getState()-arg;
            //如果count小于0 那么已经占用的锁的数量肯定是小于你这次需要获取的锁的数量的 所以直接返回负数
            if(count<0)
                return  count;
            // 如果不小于0的话 那么我就必须要尝试获取锁 使用cas进行锁的获取 如果获取失败 返回 count
            if(!compareAndSetState(count,arg))
                return  count;

            return  1;
        }

        @Override
        protected boolean tryReleaseShared(int arg) {
            return super.tryReleaseShared(arg);
        }


    }

    @Override
    public void lock() {

    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void unlock() {

    }

    @Override
    public Condition newCondition() {
        return null;
    }
}
