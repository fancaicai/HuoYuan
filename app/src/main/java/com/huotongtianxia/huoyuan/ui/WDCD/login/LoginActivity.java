package com.huotongtianxia.huoyuan.ui.WDCD.login;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.huotongtianxia.huoyuan.R;
import com.huotongtianxia.huoyuan.bean.GenBean;
import com.huotongtianxia.huoyuan.config.UrlConfig;
import com.huotongtianxia.huoyuan.ui.WDCD.GenActivity;
import com.huotongtianxia.huoyuan.ui.WDCD.gen.GenContract;
import com.huotongtianxia.huoyuan.ui.WDCD.gen.GenPresreter;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class LoginActivity extends AppCompatActivity implements GenContract.View{

    @Bind(R.id.login_dl)
    Button loginDl;
    @Bind(R.id.login_zc)
    Button loginZc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS | WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN  | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        GenPresreter presreter = new GenPresreter(this);
        presreter.getData();
    }

    @OnClick({R.id.login_dl, R.id.login_zc})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.login_dl:
                Intent intent = new Intent(LoginActivity.this, DLActivity.class);
                LoginActivity.this.finish();
                startActivity(intent);
                break;
            case R.id.login_zc:
                intent = new Intent(LoginActivity.this, DLActivity.class);
                LoginActivity.this.finish();
                startActivity(intent);
                break;
        }
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
    public void onResponse(GenBean genBean) {
        UrlConfig.URL = genBean.getData().getApk_url();
        int count = genBean.getCode();
        if (count == 100){

        }else if (count == 101){
            AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                builder.setMessage("您的版本需要更新\n当前版本号："+UrlConfig.GEN+"\n"+"更新后版本号"+genBean.getData().getVersion_id());
                builder.setTitle("提示");
                builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                       LoginActivity.this.finish();
                       Intent intent = new Intent(LoginActivity.this, GenActivity.class);
                       startActivity(intent);
                       }
                  });
              builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                       LoginActivity.this.finish();
                      }
                  });
            builder.setCancelable(false);
            builder.create().show();
        }
    }

    @Override
    public void onFailure(String s) {

    }
}
