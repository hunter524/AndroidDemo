package com.github.hunter524.androiddemo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by hunter on 2016/9/26.
 */

public class TencentX5Activity extends Activity {
    @BindView(R.id.go)
    Button go;
    @BindView(R.id.url)
    EditText url;
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.webview)
    WebView webview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        QbSdk.allowThirdPartyAppDownload(true);
        QbSdk.initX5Environment(this, QbSdk.WebviewInitType.FIRSTUSE_AND_PRELOAD, new QbSdk.PreInitCallback() {
            @Override
            public void onCoreInitFinished() {
                Toast.makeText(TencentX5Activity.this,"x5加载完成",Toast.LENGTH_LONG).show();
            }

            @Override
            public void onViewInitFinished(boolean b) {

            }
        });
        // TODO: add setContentView(...) invocation
        setContentView(R.layout.activity_demo_for_tencent_x5_webview);
        ButterKnife.bind(this);
        webview.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onReceivedTitle(WebView webView, String s) {
                super.onReceivedTitle(webView, s);
                title.setText(s);
            }
        });
    }

    @OnClick(R.id.go)
    public void onClick() {
        webview.loadUrl(url.getText().toString());
    }
}
