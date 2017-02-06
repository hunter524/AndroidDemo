package com.github.hunter524.java.Thread.Lock;

import com.github.hunter524.java.Thread.Concurrent.UnSafeAdd;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by hunter on 2017/2/4.
 */

public class LockDemo {
    private static int threadCount=100;
    private static CountDownLatch countDown=new CountDownLatch(threadCount);
    static ReentrantLock lock = new ReentrantLock();
    public static int count = 0;

    public static void unSafeAdd(){
//使用ReentrantLock保持原子操作和同步
        lock.lock();
        count++;
        lock.unlock();
    }

    public static class AddRunnalble implements Runnable{
        @Override
        public void run() {
            for (int i = 0;i<1000;i++){
                unSafeAdd();
            }
            countDown.countDown();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads=new Thread[threadCount];
        for(int i=0;i<threadCount;i++){
            threads[i]=new Thread(new AddRunnalble());
        }
        for(int i=0;i<threadCount;i++){
            threads[i].start();
        }
        countDown.await();
        System.out.println(count);
        try {
            throw new Exception("exception!");
        }
        catch (Exception e){
            System.out.println(e);
        }
        finally {
            System.out.println("finally!");
        }
    }


}
