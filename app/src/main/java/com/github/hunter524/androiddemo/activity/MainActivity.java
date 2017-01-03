package com.github.hunter524.androiddemo.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.github.hunter524.androiddemo.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends Activity {


    @BindView(R.id.button)
    Button button;
    @BindView(R.id.textView)
    TextView textView;
    LooperMain.WorkThread mWorkThread;
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

    @OnClick({R.id.button, R.id.textView})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button:
                Message message1 = Message.obtain();
                message1.what = 1;
                message1.arg1 = 1;
                Message message2 = Message.obtain();
                message1.what = 2;
                message1.arg1 = 2;
                mWorkThread.mHandler.sendMessage(message1);
                mWorkThread.mHandler.sendMessage(message2);
                textView.setText("textView!");
                Intent intent = new Intent("com.hexin.zhanghu.main.WelcomeActivity");
                startActivity(intent);
                break;
            case R.id.textView:
                break;
        }
    }
}
