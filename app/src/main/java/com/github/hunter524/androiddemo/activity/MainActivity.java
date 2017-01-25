package com.github.hunter524.androiddemo.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.widget.Button;

import com.github.hunter524.androiddemo.Handler.LooperMain;
import com.github.hunter524.androiddemo.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends Activity {


    @BindView(R.id.button)
    Button button;
    LooperMain.WorkThread mWorkThread;
    @BindView(R.id.single_task_bt)
    Button mSingleTaskBt;
    @BindView(R.id.single_instance_bt)
    Button mSingleInstanceBt;
    @BindView(R.id.Normal_bt)
    Button mNormalBt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mWorkThread = new LooperMain.WorkThread();
        mWorkThread.setName("mWorkThread");
        mWorkThread.start();
    }

    @OnClick({R.id.single_task_bt, R.id.single_instance_bt, R.id.Normal_bt,R.id.button})
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
                Message message1 = Message.obtain();
                message1.what = 1;
                message1.arg1 = 1;
                Message message2 = Message.obtain();
                message1.what = 2;
                message1.arg1 = 2;
                mWorkThread.mHandler.sendMessage(message1);
                mWorkThread.mHandler.sendMessage(message2);
                Intent intent3 = new Intent();
                //包名 包名+类名（全路径）
                intent3.setClassName("com.hexin.zhanghu", "com.hexin.zhanghu.main.WelcomeActivity");
                startActivity(intent3);
                break;
        }
    }
}
