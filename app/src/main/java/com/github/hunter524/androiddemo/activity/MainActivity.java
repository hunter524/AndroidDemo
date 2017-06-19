package com.github.hunter524.androiddemo.activity;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.github.hunter524.androiddemo.Handler.WorkHandler;
import com.github.hunter524.androiddemo.Handler.WorkThread;
import com.github.hunter524.androiddemo.R;
import com.github.hunter524.androiddemo.service.MainLocalService;
import com.github.hunter524.util.LogUtil;

import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends AppCompatActivity {

    private String Tag = "MainActivity";

    @BindView(R.id.button)
    Button button;
    @BindView(R.id.single_task_bt)
    Button mSingleTaskBt;
    @BindView(R.id.single_instance_bt)
    Button mSingleInstanceBt;
    @BindView(R.id.Normal_bt)
    Button mNormalBt;







    private WorkThread mWorkThread;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mWorkThread = new WorkThread();
        mWorkThread.start();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @OnClick({R.id.single_task_bt, R.id.single_instance_bt, R.id.Normal_bt,R.id.button,R.id.start_rmote_act})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.single_task_bt:
                Intent intent = new Intent(this,SingleTaskActivity.class);
                startActivity(intent);
                break;
            case R.id.single_instance_bt:
                Intent intent1 = new Intent(this,SingleInstanceActivity.class);
                startActivity(intent1);
                break;
            case R.id.Normal_bt:
                Intent intent2 = new Intent(this,MainActivity.class);
                startActivity(intent2);
                break;
            case R.id.button:
                LogUtil.i(Tag,"Click butto Time"+Calendar.getInstance().getTimeInMillis());
                Message messageSleep = Message.obtain();
                messageSleep.what = WorkHandler.MESSAGE_WHAT_SLEEP;
                Message messageOutPutData = Message.obtain();
                messageOutPutData.what = WorkHandler.MESSAGE_WHAT_OUT_PUT_DATA;
                messageOutPutData.obj = new String("out put data");
                mWorkThread.getWorkHandler().sendMessage(messageSleep);
                mWorkThread.getWorkHandler().sendMessage(messageOutPutData);
                LogUtil.i(Tag,"Called Send Time:"+ Calendar.getInstance().getTimeInMillis()+"Current Thread:"+Thread.currentThread());
                break;
            case  R.id.start_rmote_act:
                Intent intent3 = new Intent(this,ServiceDemoAct.class);
                startActivity(intent3);
                break;
            case R.id.start_local_service:
                Intent intent4 = new Intent(this, MainLocalService.class);
                startService(intent4);
                bindService(intent4, new ServiceConnection() {
                    @Override public void onServiceConnected(ComponentName name, IBinder service) {
                        Log.d(Tag,"name"+name+"service"+service);
                    }

                    @Override public void onServiceDisconnected(ComponentName name) {
                        Log.d(Tag,"name"+name);
                    }
                }, Context.BIND_AUTO_CREATE);
        }
    }
}
