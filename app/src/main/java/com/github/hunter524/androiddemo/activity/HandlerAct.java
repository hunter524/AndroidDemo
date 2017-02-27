package com.github.hunter524.androiddemo.activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.PersistableBundle;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.github.hunter524.androiddemo.Handler.WorkHandlerThread;
import com.github.hunter524.androiddemo.R;
import com.github.hunter524.util.ToastUtil;

import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HandlerAct extends Activity {

    Handler mMainHander = new Handler();
    WorkHandlerThread mWorkHandlerThread = new WorkHandlerThread("work thread");
    @BindView(R.id.refresh)
    Button mRefresh;
    @BindView(R.id.activity_handler)
    RelativeLayout mActivityHandler;



    class WorkRunnable implements Runnable {
        @Override
        public void run() {
//            模拟网络请求
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            刷新主页面
            mMainHander.post(new Runnable() {
                @Override
                public void run() {
                    ToastUtil.show(Calendar.getInstance().getTime().toString(), HandlerAct.this);
                }
            });
        }
    }

    ;

    class PollRunnable implements Runnable {
        @Override
        public void run() {
//            延时5秒自动刷新一次
            mMainHander.postDelayed(new PollRunnable(), 5000);
            mWorkHandlerThread.getHandler().post(new WorkRunnable());
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler);
        ButterKnife.bind(this);
    }

    @Override
    protected void onStart() {
        mWorkHandlerThread.start();
        super.onStart();
    }

    @Override
    protected void onResume() {
        ToastUtil.show("启动自动刷新！", this);
        mMainHander.postDelayed(new PollRunnable(),1000);
        super.onResume();

    }

    @Override
    protected void onPause() {
        mWorkHandlerThread.quit();
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @OnClick(R.id.refresh)
    public void onClick() {
        mWorkHandlerThread.getHandler().post(new WorkRunnable());
    }

}
