package com.huotongtianxia.huoyuan.ui.WDCD.gszl;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.huotongtianxia.huoyuan.R;
import com.huotongtianxia.huoyuan.bean.BJGSZLBean;
import com.huotongtianxia.huoyuan.bean.GSZLBean;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
//编辑公司资料
public class BJGSZLActivity extends AppCompatActivity implements BJGSZLContract.View {

    @Bind(R.id.bjgszl_img)
    ImageView bjgszlImg;
    @Bind(R.id.bjgszl_text01)
    TextView bjgszlText01;
    @Bind(R.id.bjgszl_text02)
    TextView bjgszlText02;
    @Bind(R.id.bjgszl_text1)
    EditText bjgszlText1;
    public static String id, q1, q2, q3, q4, q5, q6;
    @Bind(R.id.bjgszl_text2)
    TextView bjgszlText2;
    private int codea;
    private String provinc, cit;
    private int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS | WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }
        setContentView(R.layout.activity_bjgszl);
        ButterKnife.bind(this);
        Bundle bundle = this.getIntent().getExtras();
        count = bundle.getInt("count");
        if (count ==1){
            bjgszlText2.setText("公司名称");
        }else if (count == 2){
            bjgszlText2.setText("工厂地址");
        }else if (count == 3){
            bjgszlText2.setText("主营产品");
        }else if (count == 4){
            bjgszlText2.setText("常用地址");
        }else if (count == 5){
            bjgszlText2.setText("负责人");
        }else if (count == 6){
            bjgszlText2.setText("联系电话");
        }
    }

    @OnClick({R.id.bjgszl_img, R.id.bjgszl_text01, R.id.bjgszl_text02})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bjgszl_img:
                BJGSZLActivity.this.finish();
                break;
            case R.id.bjgszl_text01:
                BJGSZLActivity.this.finish();
                break;
            case R.id.bjgszl_text02:
                login();
                break;
        }
    }

    public void login() {
        if (isUserNameAndPwdValid()) {
            id = bjgszlText1.getText().toString().trim();
        }
        BJGSZLPresreter presreter = new BJGSZLPresreter(this, id, count);
        presreter.getData();
    }

    public boolean isUserNameAndPwdValid() {
        if (bjgszlText1.getText().toString().trim().equals("")) {
            Toast.makeText(this, "请输入信息",
                    Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    @Override
    public void onResponse(BJGSZLBean bjgszlBean) {
        codea = bjgszlBean.getCode();
        if (codea == 100) {
            BJGSZLActivity.this.finish();
            Toast.makeText(this, "修改成功", Toast.LENGTH_SHORT).show();
        } else if (codea == 200) {
            Toast.makeText(this, "您的数据未进行修改", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onResponse2(GSZLBean gszlBean) {

    }

    @Override
    public void onFailure(String s) {

    }

}