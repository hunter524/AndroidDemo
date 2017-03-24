package com.github.hunter524.java.Thread;


import com.github.hunter524.java.Thread.Concurrent.MethodSyncronized;

import java.util.concurrent.CountDownLatch;

/**
 * Created by hunter on 2016/9/27.
 */

public class ThreadMain {
    public static void main(){
//        ThreadLocal<String> mainThreadLocal = new ThreadLocal<>();
//        mainThreadLocal.set(new String("mainThreadLocal"));
//        mainThreadLocal.set(new String("mainThreadLocal2"));
//        Thread thread = new Thread(){
//            @Override
//            public void run() {
//                System.out.println(mainThreadLocal.get());
//                super.run();
//            }
//        };
//        thread.start();
//        System.out.println(mainThreadLocal.get());
        CountDownLatch mCountDownLatch = new CountDownLatch(2);
        MethodSyncronized methodSyncronized = new MethodSyncronized();
        new Thread(new Runnable() {
            @Override
            public void run() {
                methodSyncronized.getLock();
                mCountDownLatch.countDown();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                methodSyncronized.getLockAgain();
                mCountDownLatch.countDown();
            }
        }).start();
//        try {
//            mCountDownLatch.await();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }
}
