package com.github.hunter524.androiddemo.Handler;

import android.os.Looper;

/**
 * Created by hunter on 2017/2/9.
 */

public class WorkThread extends Thread {
    private WorkHandler mWorkHandler;
    @Override
    public void run() {
        super.run();
        Looper.prepare();
        mWorkHandler = new WorkHandler();
        Looper.loop();
    }

    public WorkHandler getWorkHandler() {
        return mWorkHandler;
    }
}
