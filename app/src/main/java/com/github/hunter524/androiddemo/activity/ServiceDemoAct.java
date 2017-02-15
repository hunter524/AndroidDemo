package com.github.hunter524.androiddemo.activity;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Process;
import android.os.RemoteException;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.github.hunter524.androiddemo.R;
import com.github.hunter524.androiddemo.service.IRemoteService;
import com.github.hunter524.androiddemo.service.RemoteService;
import com.github.hunter524.util.LogUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by hunter on 2017/2/13.
 */

public class ServiceDemoAct extends Activity {

    private final String TAG = "ServiceDemoAct";
    @BindView(R.id.service_bind_bt)
    Button mServiceBindBt;
    @BindView(R.id.service_unbind_bt)
    Button mServiceUnbindBt;
    @BindView(R.id.service_kill_bt)
    Button mServiceKillBt;

    IRemoteService mIRemoteService;
    ServiceConnection mServiceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            LogUtil.i(TAG, "onServiceConnected");
            mIRemoteService = IRemoteService.Stub.asInterface(service);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            LogUtil.i(TAG, "onServiceConnected");
        }
    };
    @BindView(R.id.get_pid)
    Button mGetPid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_demo);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.service_bind_bt, R.id.service_unbind_bt, R.id.service_kill_bt,R.id.get_pid})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.service_bind_bt:
                bindRemoteService();
                break;
            case R.id.service_unbind_bt:
                unbindRemoteService();
                break;
            case R.id.service_kill_bt:
                killRemoteService();
                break;
            case R.id.get_pid:
                int pid = 0;
                try {
                    pid = mIRemoteService.getPid();
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
                Toast.makeText(this,pid+"",Toast.LENGTH_LONG).show();
                break;
        }
    }

    /**
     * 绑定远程服务
     */
    private void bindRemoteService() {
        LogUtil.i(TAG, "[ClientActivity] bindRemoteService");
        Intent intent = new Intent(ServiceDemoAct.this, RemoteService.class);
        intent.setAction(IRemoteService.class.getName());
        bindService(intent, mServiceConnection, Context.BIND_AUTO_CREATE);
//
//        mIsBound = true;
//        mCallBackTv.setText(R.string.binding);
    }

    /**
     * 解除绑定远程服务
     */
    private void unbindRemoteService() {
//        if(!mIsBound){
//            return;
//        }
        LogUtil.i(TAG, "[ClientActivity] unbindRemoteService ==>");
        unbindService(mServiceConnection);
//        mIsBound = false;
//        mCallBackTv.setText(R.string.unbinding);
    }

    /**
     * 杀死远程服务
     */
    private void killRemoteService() {
        LogUtil.i(TAG, "[ClientActivity] killRemoteService");
        try {
            Process.killProcess(mIRemoteService.getPid());
//            mCallBackTv.setText(R.string.kill_success);
        } catch (RemoteException e) {
            e.printStackTrace();
            Toast.makeText(ServiceDemoAct.this, "kill process fail！", Toast.LENGTH_SHORT).show();
        }
    }
}
