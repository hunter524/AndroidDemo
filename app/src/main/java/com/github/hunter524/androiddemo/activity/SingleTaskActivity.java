package com.github.hunter524.androiddemo.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.github.hunter524.androiddemo.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by hunter on 2017/1/11.
 */

public class SingleTaskActivity extends Activity {
    @BindView(R.id.textView2)
    TextView mTextView2;
    @BindView(R.id.single_task_bt)
    Button mSingleTaskBt;
    @BindView(R.id.single_instance_bt)
    Button mSingleInstanceBt;
    @BindView(R.id.Normal_bt)
    Button mNormalBt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.single_task_activity);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.single_task_bt, R.id.single_instance_bt, R.id.Normal_bt})
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
        }
    }
}
