package com.github.hunter524.androiddemo.Handler;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;

/**
 * Created by hunter on 2017/2/27.
 */

public class WorkHandlerThread extends HandlerThread {

    private Handler mHandler;

    public WorkHandlerThread(String name) {
        super(name);
    }

    @Override
    protected void onLooperPrepared() {
        mHandler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
            }
        };
//        super.onLooperPrepared();
    }

    public Handler getHandler() {
        return mHandler;
    }

    public void setHandler(Handler handler) {
        mHandler = handler;
    }
}
