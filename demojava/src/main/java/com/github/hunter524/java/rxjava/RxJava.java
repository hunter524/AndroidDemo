package com.github.hunter524.java.rxjava;

import rx.Observable;
import rx.Scheduler;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by hunter on 2016/10/11.
 */

public class RxJava {
    public static void main() {
//        Thread.currentThread().setDaemon(true);
        String string = new String();
        Scheduler scheduler = Schedulers.trampoline();
        System.out.println("main:"+Thread.currentThread());
        Observable.just("").flatMap(new Func1<String, Observable<?>>() {
            @Override
            public Observable<?> call(String s) {
                System.out.println("flatMap call:"+Thread.currentThread());
                return null;
            }
        }).subscribeOn(Schedulers.computation()).observeOn(scheduler).subscribe(new Action1<Object>() {
            @Override
            public void call(Object o) {
//                string.notify();
                System.out.println("subscribe call:"+Thread.currentThread());
            }
        });
//        synchronized (string){
//            try {
//                string.wait();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
    }
}
