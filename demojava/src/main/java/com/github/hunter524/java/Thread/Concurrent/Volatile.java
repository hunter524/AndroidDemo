package com.github.hunter524.java.Thread.Concurrent;

/**
 * Created by hunter on 2017/3/10.
 */

public class Volatile {
    public static Long i = Long.MIN_VALUE;
    public static void main(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    i++;
                    System.out.println("Tread add"+"i:"+i+"time:"+System.nanoTime());
                }

            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    System.out.println("Tread out1"+"i:"+i+"time:"+System.nanoTime());
                }

            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    System.out.println("Tread out 2"+"i:"+i+"time:"+System.nanoTime());
                }

            }
        }).start();
    }
}
