package com.javalei.mainTest.AbstractQueuedSynchronizerTEST;

import com.javalei.mainTest.SleepUtils;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SnycTest {



        public void test(){
            final Lock lock = new ReentrantLock();
            class Worker extends Thread {
                public void run() {
                    while (true) {
                        lock.lock();
                        try {
                            SleepUtils.second(1);
                            System.out.println(Thread.currentThread().getName());
                            SleepUtils.second(1);
                        } finally {
                            lock.unlock();
                        }
                        SleepUtils.second(2);
                    }
                }
            }
            // 启动10个子线程
            for (int i = 0; i < 10; i++) {
                Worker w = new Worker();
                w.setDaemon(true);
                w.start();
            }
            // 主线程每隔1秒换行
            for (int i = 0; i < 10; i++) {
                SleepUtils.second(1);
                System.out.println("--------");
            }
        }

        public static void main(String[] args) {
            SnycTest testMyLock = new SnycTest();
            testMyLock.test();
        }
    }

