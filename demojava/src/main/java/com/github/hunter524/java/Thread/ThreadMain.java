package com.github.hunter524.java.Thread;


/**
 * Created by hunter on 2016/9/27.
 */

public class ThreadMain {
    public static void main(){
        ThreadLocal<String> mainThreadLocal = new ThreadLocal<>();
        mainThreadLocal.set(new String("mainThreadLocal"));
        mainThreadLocal.set(new String("mainThreadLocal2"));
        Thread thread = new Thread(){
            @Override
            public void run() {
                System.out.println(mainThreadLocal.get());
                super.run();
            }
        };
        thread.start();
        System.out.println(mainThreadLocal.get());
    }
}
