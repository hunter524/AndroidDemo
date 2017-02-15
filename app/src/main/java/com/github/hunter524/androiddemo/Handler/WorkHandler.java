package com.github.hunter524.androiddemo.Handler;

import android.os.Handler;
import android.os.Message;

import com.github.hunter524.util.LogUtil;

import java.util.Calendar;

/**
 * Created by hunter on 2017/2/8.
 */

public class WorkHandler extends Handler {

    private static final String Tag = "WorkHandler";
    public static final int MESSAGE_WHAT_SLEEP = 1001;
    public static final int MESSAGE_WHAT_OUT_PUT_DATA = 1002;
    /*此处省略其他处理状况*/

    /**
     * 该方法必须覆
     * 处理Message
     * @param msg
     */
    @Override
    public void handleMessage(Message msg) {
        super.handleMessage(msg);
        switch (msg.what){
            case MESSAGE_WHAT_SLEEP:
                doSleep();
                break;
            case MESSAGE_WHAT_OUT_PUT_DATA:
                LogUtil.i(Tag,"out_put_data",Calendar.getInstance().getTimeInMillis()+"");
                LogUtil.i(Tag,msg.obj.toString());
                break;
        }
        LogUtil.i(Tag,"Handler current Thread："+Thread.currentThread());
    }

    private void doSleep(){
        LogUtil.i(Tag,"Thread Sleep Start:", Calendar.getInstance().getTimeInMillis()+"");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        LogUtil.i(Tag,"Thread Sleep End:", Calendar.getInstance().getTimeInMillis()+"");
    }
}
