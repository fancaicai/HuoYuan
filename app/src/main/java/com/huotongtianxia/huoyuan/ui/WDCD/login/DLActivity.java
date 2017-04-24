package com.huotongtianxia.huoyuan.ui.WDCD.login;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.huotongtianxia.huoyuan.MainActivity;
import com.huotongtianxia.huoyuan.R;
import com.huotongtianxia.huoyuan.bean.DLBean;
import com.huotongtianxia.huoyuan.bean.GenBean;
import com.huotongtianxia.huoyuan.ui.WDCD.gen.GenContract;
import com.huotongtianxia.huoyuan.ui.WDCD.gen.GenPresreter;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DLActivity extends AppCompatActivity implements DLContract.View ,GenContract.View{

    @Bind(R.id.login_et1)
    EditText loginEt1;
    @Bind(R.id.login_et2)
    EditText loginEt2;
    @Bind(R.id.login_btn)
    Button loginBtn;
    @Bind(R.id.login_tv2)
    TextView loginTv2;
    @Bind(R.id.Login_Remember)
    CheckBox LoginRemember;
    private String userName;
    private String userPwd;
    private int count;
    public static String id;
    private Context context;
    public static String membertype;
    private SharedPreferences login_sp;

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
        setContentView(R.layout.activity_dl);
        context = getApplicationContext();
        ButterKnife.bind(this);

        GenPresreter presreter = new GenPresreter(this);
        presreter.getData();

        login_sp = getSharedPreferences("userInfo", 0);
        String name = login_sp.getString("USER_NAME", "");
        String pwd = login_sp.getString("PASSWORD", "");
        boolean choseRemember = login_sp.getBoolean("mRememberCheck", false);
        boolean choseAutoLogin = login_sp.getBoolean("mAutologinCheck", false);
        //如果上次选了记住密码，那进入登录页面也自动勾选记住密码，并填上用户名和密码
        if (choseRemember) {
            loginEt1.setText(name);
            loginEt2.setText(pwd);
            LoginRemember.setChecked(true);
        }

        Intent intent = getIntent();
        membertype = intent.getStringExtra("membertype");
    }

    @OnClick({R.id.login_btn, R.id.login_tv2})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.login_btn:
                login();
                DLPresreter presreter = new DLPresreter(this, userName, userPwd, context);
                presreter.getData();
                break;
            case R.id.login_tv2:
                Intent intent = new Intent(DLActivity.this, ZHMMActivity.class);
                DLActivity.this.finish();
                startActivity(intent);
                break;
        }
    }

    public void login() {                                              //登录按钮监听事件
        if (isUserNameAndPwdValid()) {
            userName = loginEt1.getText().toString().trim();    //获取当前输入的用户名和密码信息
            userPwd = loginEt2.getText().toString().trim();
        }
    }

    public boolean isUserNameAndPwdValid() {
        if (loginEt1.getText().toString().trim().equals("")) {
            Toast.makeText(this, getString(R.string.account_empty),
                    Toast.LENGTH_SHORT).show();
            return false;
        } else if (loginEt2.getText().toString().trim().equals("")) {
            Toast.makeText(this, getString(R.string.pwd_empty),
                    Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    @Override
    public void onResponse(DLBean dlBean) {
        id = String.valueOf(dlBean.getData().get(0).getFactory_id());
        count = dlBean.getCode();
        SharedPreferences.Editor editor =login_sp.edit();
        if (count == 100) {
            //保存用户名和密码
            editor.putString("USER_NAME", userName);
            editor.putString("PASSWORD", userPwd);
            //是否记住密码
            if(LoginRemember.isChecked()){
                editor.putBoolean("mRememberCheck", true);
            }else{
                editor.putBoolean("mRememberCheck", false);
            }
            editor.commit();
            Intent intent = new Intent(this, MainActivity.class);
            DLActivity.this.finish();
            startActivity(intent);
        } else if (count == 200) {
            Toast.makeText(this, "用户名或密码错误", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onResponse(GenBean genBean) {

    }

    @Override
    public void onFailure(String s) {

    }
}
