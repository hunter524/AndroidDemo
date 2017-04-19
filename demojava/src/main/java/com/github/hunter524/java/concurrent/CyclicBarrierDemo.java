package com.github.hunter524.java.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Created by hunter on 2017/4/18.
 */

public class CyclicBarrierDemo {
    Runnable mBarrierRunnable = new Runnable() {
        @Override
        public void run() {
            System.out.println("mBarrierRunnable run!");
        }
    };

    CyclicBarrier mCyclicBarrier = new CyclicBarrier(5,mBarrierRunnable);

    public void startNormalBarrier(){
        int i = 0;
        while (i<5){
            Thread thread = new NormalWorkRunnable(i,mCyclicBarrier);
            thread.start();
            i++;
        }
    }

    static class NormalWorkRunnable extends Thread{
        public int currentNum;
        public CyclicBarrier mCyclicBarrier;
        public NormalWorkRunnable(int currentNum,CyclicBarrier cyclicBarrier) {
            this.currentNum = currentNum;
            this.mCyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            System.out.println("the"+currentNum+"thread start!"+System.currentTimeMillis()/1000);
            try {
                System.out.println("the"+currentNum+"thread sleep start!"+System.currentTimeMillis()/1000);
                long sleepTime = 5000/(currentNum+1);
                System.out.println("the"+currentNum+"thread sleep how long :"+sleepTime);
                Thread.sleep(sleepTime);
                System.out.println("the"+currentNum+"thread sleep end!"+System.currentTimeMillis()/1000);
//                第五个线程 使用time out 的wait 方法进行等待 最大等待 1s
                if (currentNum == 4){
                    mCyclicBarrier.await(1, TimeUnit.SECONDS);
                }
                else {
                    mCyclicBarrier.await();
                }

            } catch (InterruptedException e) {
                System.out.println(""+e.getMessage());
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                System.out.println(""+e.getMessage());
                e.printStackTrace();
            } catch (TimeoutException e) {
                System.out.println(""+e.getMessage());
                e.printStackTrace();
            }
            System.out.println("the"+currentNum+"thread go over Barrier!"+System.currentTimeMillis()/1000);


        }
    }
}
