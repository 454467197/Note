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
            final  Thread thread=Thread.currentThread();
            for(;;){
                int c=arg+1;
                if(getExclusiveOwnerThread()!=thread&&compareAndSetState(arg,c)){
                    setExclusiveOwnerThread(thread);
                    return  c;
                }else {

                }

            }
            return super.tryAcquireShared(arg);
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
