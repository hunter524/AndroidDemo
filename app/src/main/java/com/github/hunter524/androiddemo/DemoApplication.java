package com.github.hunter524.androiddemo;

import android.app.Application;
import android.os.Process;

import com.github.hunter524.util.LogUtil;

/**
 * Created by hunter on 2017/2/15.
 */

public class DemoApplication extends Application {
    private String TAG = "DemoApplication";
    @Override
    public void onCreate() {
        super.onCreate();
//        不同进程的用户id相关 因为是同一个Linux用户
//        不同进程的pid 必定不同 tid 为ThreadId
        LogUtil.i(TAG,"DemoApplication:"+"onCreate");
        LogUtil.i(TAG,"DemoApplication:"+"Process pid:"+Process.myPid(),"Process uid:"+Process.myUid(),"Process tid:"+Process.myTid());
    }
}
