package com.huotongtianxia.huoyuan.ui.WDCD.khzl;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.huotongtianxia.huoyuan.R;
import com.huotongtianxia.huoyuan.bean.TJKHZLBean;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TJKHZLActivity extends AppCompatActivity implements TJKHZLContract.View{

    @Bind(R.id.tjkhzl_img)
    ImageView tjkhzlImg;
    @Bind(R.id.tjkhzl_text)
    TextView tjkhzlText;
    @Bind(R.id.tjkhzl_text01)
    TextView tjkhzlText01;
    @Bind(R.id.tjkhzl_edit2)
    EditText tjkhzlEdit2;
    @Bind(R.id.tjkhzl_edit3)
    EditText tjkhzlEdit3;
    @Bind(R.id.tjkhzl_edit5)
    EditText tjkhzlEdit5;
    public static String a1;
    public static String a2;
    public static String a3;
    public static String a5;
    public static String provinc,cit;

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
        setContentView(R.layout.activity_tjkhzl);
        ButterKnife.bind(this);

        //省市联动
    }

    @OnClick({R.id.tjkhzl_img, R.id.tjkhzl_text, R.id.tjkhzl_text01})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tjkhzl_img:
                TJKHZLActivity.this.finish();
                break;
            case R.id.tjkhzl_text:
                TJKHZLActivity.this.finish();
                break;
            case R.id.tjkhzl_text01:
                login();
                TJKHZLPresreter presreter = new TJKHZLPresreter(this,a1,a2,a3,a5,provinc,cit);
                presreter.getData();
                TJKHZLActivity.this.finish();
                break;
        }
    }

    public void login() {
        if (isUserNameAndPwdValid()) {
            a2 = tjkhzlEdit2.getText().toString().trim();
            a3 = tjkhzlEdit3.getText().toString().trim();
            a5 = tjkhzlEdit5.getText().toString().trim();
        }
    }

    public boolean isUserNameAndPwdValid() {
       if (tjkhzlEdit2.getText().toString().trim().equals("")) {
            Toast.makeText(this, getString(R.string.q5),
                    Toast.LENGTH_SHORT).show();
            return false;
        }else if (tjkhzlEdit3.getText().toString().trim().equals("")) {
            Toast.makeText(this, getString(R.string.q6),
                    Toast.LENGTH_SHORT).show();
            return false;
        }else if (tjkhzlEdit5.getText().toString().trim().equals("")) {
            Toast.makeText(this, getString(R.string.a5),
                    Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    @Override
    public void onResponse(TJKHZLBean tjkhzlBean) {

    }

    @Override
    public void onFailure(String s) {

    }
}
