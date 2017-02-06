package com.github.hunter524.java.Thread.Concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by hunter on 2017/1/24.
 */

public class UnSafeAdd {
//    100个线程同时并发出现此问题
    private static int threadCount=100;
    private static CountDownLatch countDown=new CountDownLatch(threadCount);
//    private static int count=0;
    private static AtomicInteger count = new AtomicInteger(0);
    private static class Counter implements Runnable{
        @Override
        public void run() {
            for(int i=0;i<100000;i++){
//                count++;//非原子操作
//                count.incrementAndGet(); /*原子递增操作*/
//                CAS原子操作 执行递增操作
                int expect,update;
                int k = 0;
                do {
                    expect = count.get();
                    update = expect+2;
                    k++;
                }while (!count.compareAndSet(expect,update));
                System.out.println("retry times:"+k);
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
