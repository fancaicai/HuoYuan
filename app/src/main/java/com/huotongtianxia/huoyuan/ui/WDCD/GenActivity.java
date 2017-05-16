package com.huotongtianxia.huoyuan.ui.WDCD;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.huotongtianxia.huoyuan.R;
import com.huotongtianxia.huoyuan.config.UrlConfig;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

//版本检测类
public class GenActivity extends AppCompatActivity {
    private static final String TAG = "ActivityDemo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gen);
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        Uri content_url = Uri.parse(UrlConfig.URL);
        intent.setData(content_url);
        startActivity(intent);
    }


    /**
     * 自定义字体
     * @param newBase
     */
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @Override
    protected void onResume() {
        super.onResume();
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        Uri content_url = Uri.parse(UrlConfig.URL);
        intent.setData(content_url);
        startActivity(intent);
        Log.e(TAG, "start onResume~~~");
    }

    @Override
    protected void onStop() {
        super.onStop();
        this.finish();
        Log.e(TAG, "start onStop~~~");
    }
}
