package com.github.hunter524.java.Thread.Concurrent;

import java.util.Calendar;

/**
 * Created by hunter on 2017/3/13.
 */

public class MethodSyncronized {

    synchronized public void getLock(){
        System.out.println("first Lock start:"+Calendar.getInstance().getTime());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("first Lock end:"+Calendar.getInstance().getTime());
    }

    synchronized public void getLockAgain(){
        System.out.println("Sencond Lock start:"+Calendar.getInstance().getTime());
    }
}
