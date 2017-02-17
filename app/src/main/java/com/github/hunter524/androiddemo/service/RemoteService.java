package com.github.hunter524.androiddemo.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Process;
import android.os.RemoteException;
import android.provider.Settings;

import com.github.hunter524.util.LogUtil;

import java.util.Calendar;

public class RemoteService extends Service {
    private final String TAG = "RemoteService";
    public RemoteService() {
        LogUtil.i(TAG,"RemoteService","Constructor");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        LogUtil.i(TAG,"RemoteService","onCreate");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        LogUtil.i(TAG,"RemoteService","onDestroy");
    }

    @Override
    public boolean onUnbind(Intent intent) {
        LogUtil.i(TAG,"RemoteService","onUnbind");
        return super.onUnbind(intent);
    }

    @Override
    public void onRebind(Intent intent) {
        LogUtil.i(TAG,"RemoteService","onRebind");
        super.onRebind(intent);
    }

    @Override
    public IBinder onBind(Intent intent) {
        LogUtil.i(TAG,"RemoteService","onBind");
        return mBinde;
    }

    private IRemoteService.Stub mBinde = new IRemoteService.Stub() {
        @Override
        public int getPid() throws RemoteException{
//            调用线程会被阻塞死对其他无响应
            LogUtil.i(TAG,Thread.currentThread()+ "start Time"+Calendar.getInstance().getTime());
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return Process.myPid();
        }

        @Override
        public RSDataBean getMyData(int i) throws RemoteException {
            return new RSDataBean();
        }
    };
}
