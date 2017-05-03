package com.huotongtianxia.huoyuan.ui.WDCD.gyszl;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.huotongtianxia.huoyuan.R;
import com.huotongtianxia.huoyuan.bean.TJGYSBean;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
//常用地址页面
public class TJGYSActivity extends AppCompatActivity implements TJGYSContract.View{

    Button jtgysBtn;
    private String tjgyszl1,tjgyszl2,tjgyszl3,tjgyszl4;

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
        setContentView(R.layout.activity_tjgys);
        ButterKnife.bind(this);
    }

//    @OnClick({R.id.tjgrs_img01, R.id.tjgrs_text01, R.id.jtgys_btn})
//    public void onClick(View view) {
//        switch (view.getId()) {
//            case R.id.tjgrs_img01:
//                TJGYSActivity.this.finish();
//                break;
//            case R.id.tjgrs_text01:
//                TJGYSActivity.this.finish();
//                break;
//            case R.id.jtgys_btn:
//                login();
//                TJGYSPresreter presreter = new TJGYSPresreter(this,tjgyszl1,tjgyszl2,tjgyszl3,tjgyszl4);
//                presreter.getData();
//                break;
//        }
//    }
//
//    public void login() {                                              //登录按钮监听事件
//        if (isUserNameAndPwdValid()) {
//            tjgyszl1 = tjgysEt1.getText().toString().trim();    //获取当前输入的用户名和密码信息
//            tjgyszl2 = tjgysEt2.getText().toString().trim();
//            tjgyszl3 = tjgysEt3.getText().toString().trim();
//            tjgyszl4 = tjgysEt4.getText().toString().trim();
//        }
//    }
//
//    public boolean isUserNameAndPwdValid() {
//        if (tjgysEt1.getText().toString().trim().equals("")) {
//            Toast.makeText(this, getString(R.string.tjgys1),
//                    Toast.LENGTH_SHORT).show();
//            return false;
//        } else if (tjgysEt2.getText().toString().trim().equals("")) {
//            Toast.makeText(this, getString(R.string.tjgys2),
//                    Toast.LENGTH_SHORT).show();
//            return false;
//        }else if (tjgysEt3.getText().toString().trim().equals("")) {
//            Toast.makeText(this, getString(R.string.tjgys3),
//                    Toast.LENGTH_SHORT).show();
//            return false;
//        }else if (tjgysEt4.getText().toString().trim().equals("")) {
//            Toast.makeText(this, getString(R.string.tjgys4),
//                    Toast.LENGTH_SHORT).show();
//            return false;
//        }
//        return true;
//    }

    @Override
    public void onResponse(TJGYSBean tjgysBean) {
        int count = tjgysBean.hashCode();
        if (count == 202){
            Toast.makeText(this, "物流公司已存在", Toast.LENGTH_SHORT).show();
        }
        Intent intent = new Intent(TJGYSActivity.this,GYSZLActivity.class);
        TJGYSActivity.this.finish();
        startActivity(intent);
    }

    @Override
    public void onFailure(String s) {

    }
}
