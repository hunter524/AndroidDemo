package com.github.hunter524.java.Thread.Lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by hunter on 2017/5/3.
 */

public class ReentranteLockDemo {

    public static void main(){
        ReentrantLock reentrantLock = new ReentrantLock();
        Thread demoThread = new Thread(){
            @Override
            public void run() {
                reentrantLock.lock();
                reentrantLock.lock();
                System.out.println("hold count:"+reentrantLock.getHoldCount());
                reentrantLock.unlock();
                System.out.println("hold count:"+reentrantLock.getHoldCount());
                System.out.println("is hold:"+reentrantLock.isHeldByCurrentThread());
                reentrantLock.unlock();
                System.out.println("is hold:"+reentrantLock.isHeldByCurrentThread());
            }
        };
        demoThread.start();
    }
}
