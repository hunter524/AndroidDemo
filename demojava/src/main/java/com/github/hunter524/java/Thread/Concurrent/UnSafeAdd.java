package com.github.hunter524.java.Thread.Concurrent;

import java.util.concurrent.CountDownLatch;

/**
 * Created by hunter on 2017/1/24.
 */

public class UnSafeAdd {
//    100个线程同时并发出现此问题
    private static int threadCount=100;
    private static CountDownLatch countDown=new CountDownLatch(threadCount);
    private static int count=0;
    private static class Counter implements Runnable{
        @Override
        public void run() {
            for(int i=0;i<1000;i++){
                count++;//非原子操作
            }
            countDown.countDown();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads=new Thread[threadCount];
        for(int i=0;i<threadCount;i++){
            threads[i]=new Thread(new Counter());
        }
        for(int i=0;i<threadCount;i++){
            threads[i].start();
        }
        countDown.await();
        System.out.println(count);
    }
}
