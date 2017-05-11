package com.huotongtianxia.huoyuan.ui.WDCD.ddxq;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.huotongtianxia.huoyuan.R;
import com.huotongtianxia.huoyuan.bean.PJBean;
import com.huotongtianxia.huoyuan.ui.WDCD.wdhy.WDHYActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PJActivity extends AppCompatActivity implements PJContract.View {

    @Bind(R.id.pj_hao)
    ImageView pjHao;
    @Bind(R.id.pj_cha)
    ImageView pjCha;
    @Bind(R.id.pj_hao2)
    TextView pjHao2;
    @Bind(R.id.pj_cha2)
    TextView pjCha2;
    @Bind(R.id.pj_tj)
    Button pjTj;
    @Bind(R.id.back_tv)
    TextView backTv;
    private String num;
    private int estimate = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_NO_TITLE);
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            Window window = getWindow();
//            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS | WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
//            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
//            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
//            window.setStatusBarColor(Color.TRANSPARENT);
//        }
        setContentView(R.layout.activity_pj);
        ButterKnife.bind(this);
        Bundle bundle = this.getIntent().getExtras();
        num = bundle.getString("num");
    }

    @OnClick({R.id.back_tv,R.id.pj_hao, R.id.pj_cha, R.id.pj_tj})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back_tv:
                finish();
                break;
            case R.id.pj_hao:
                pjHao.setImageResource(R.mipmap.ha2);
                pjHao2.setTextColor(this.getResources().getColor(R.color.huang));
                pjCha.setImageResource(R.mipmap.ca1);
                pjCha2.setTextColor(this.getResources().getColor(R.color.hui));
                estimate = 1;
                break;
            case R.id.pj_cha:
                pjHao.setImageResource(R.mipmap.ha1);
                pjHao2.setTextColor(this.getResources().getColor(R.color.hui));
                pjCha.setImageResource(R.mipmap.ca2);
                pjCha2.setTextColor(this.getResources().getColor(R.color.huang));
                estimate = 3;
                break;
            case R.id.pj_tj:
                PJPresreter pjPresreter = new PJPresreter(this, num, estimate);
                Intent intent = new Intent(PJActivity.this, WDHYActivity.class);
                PJActivity.this.finish();
                startActivity(intent);
                pjPresreter.getData();
                break;
        }
    }

    @Override
    public void onResponse(PJBean pjBean) {
        Toast.makeText(this, pjBean.getMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFailure(String s) {

    }
}
