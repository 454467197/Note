package com.javalei.mainTest;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Locktest {

        static ReadWriteLock readWriteLock=new ReentrantReadWriteLock();

        static Lock writeLock= readWriteLock.writeLock();

        static  Lock readLock= readWriteLock.readLock();

        public void put(){

            writeLock.tryLock();
            try {

            }finally {

            }

        }

}
