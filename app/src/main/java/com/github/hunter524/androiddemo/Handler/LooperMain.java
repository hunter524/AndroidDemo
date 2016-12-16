package com.github.hunter524.androiddemo.Handler;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

/**
 * Created by hunter on 2016/12/16.
 */

public class LooperMain {

    public static final String TAG = "LooperMain";
    public static class WorkThread extends Thread {

        public Handler mHandler;

        @Override
        public void run() {
            super.run();
            Looper.prepare();
            mHandler = new Handler(){
                @Override
                public void handleMessage(Message msg) {
                    super.handleMessage(msg);
                    try {
                        Thread.sleep(1000l);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Log.d(TAG,"Threade"+Thread.currentThread());
                    Log.d(TAG,msg.toString());
                }
            };
            Looper.loop();
        }
    }
}
