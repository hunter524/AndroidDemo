package com.github.hunter524.java.Thread.Lock;

import java.util.concurrent.CountDownLatch;

/**
 * Created by hunter on 2017/2/6.
 * Demo for  {@link Object#wait()}
 *           {@link Object#notify()}
 * And Thread state {@link java.lang.Thread.State}
 * 对象也存在等待队列 如果调用对象的wait方法，则必须获得该对象的锁（即monitor）
 */

public class ObjectWaitDemo {

    public static int threadCount = 2;
    public static Object waitObj = new Object();
    public static boolean condition = false;
    public static CountDownLatch countDownLatch = new CountDownLatch(threadCount);
    public static Thread waitThread = new Thread(new WaitRunnable());
    public static Thread notifyThread = new Thread(new NotifyRunnable());

    public static class WaitRunnable implements Runnable {
        @Override
        public void run() {
            synchronized (waitObj){
                while (!condition){
                    try {
                        System.out.println("WaitRunnable waitThread state before wait:"+Thread.currentThread().getState());
                        System.out.println("WaitRunnable waitThread state before wait time:"+System.nanoTime());
                        waitObj.wait();
                        System.out.println("WaitRunnable waitThread state after wait:"+Thread.currentThread().getState());
                        System.out.println("WaitRunnable waitThread state after wait time:"+System.nanoTime());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                countDownLatch.countDown();
            }
        }
    }

    public static class NotifyRunnable implements Runnable {
        @Override
        public void run() {
            synchronized (waitObj){
                try {
                    System.out.println("NotifyRunnable waitThread state:"+waitThread.getState());
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                condition = true;
                waitObj.notify();
            }
            countDownLatch.countDown();
        }
    }



    public static void main(String[] args) throws InterruptedException{
        waitThread.start();
        notifyThread.start();
        countDownLatch.await();
    }
}
