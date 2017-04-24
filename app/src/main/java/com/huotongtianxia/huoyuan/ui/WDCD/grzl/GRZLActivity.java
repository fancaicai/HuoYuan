package com.huotongtianxia.huoyuan.ui.WDCD.grzl;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;
import com.huotongtianxia.huoyuan.R;
import com.huotongtianxia.huoyuan.bean.GRZLBean;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class GRZLActivity extends AppCompatActivity implements GRZLContract.View {

    @Bind(R.id.grzl_img01)
    ImageView grzlImg01;
    @Bind(R.id.grzl_text01)
    TextView grzlText01;
    @Bind(R.id.sjzl_name)
    TextView sjzlName;
    @Bind(R.id.sjzl_tel)
    TextView sjzlTel;
    @Bind(R.id.sjzl_cp)
    TextView sjzlCp;
    @Bind(R.id.grzl_text5)
    TextView grzlText5;
    @Bind(R.id.grzl_text6)
    TextView grzlText6;
    @Bind(R.id.grzl_text7)
    TextView grzlText7;
    @Bind(R.id.grzl_jy)
    TextView grzlJy;
    @Bind(R.id.grzl_hp)
    TextView grzlHp;
    @Bind(R.id.grzl_cp)
    TextView grzlCp;
    @Bind(R.id.grzl_text8)
    TextView grzlText8;
//    @Bind(R.id.grzl_text9)
//    TextView grzlText9;
    @Bind(R.id.grzl_tx)
    SimpleDraweeView grzlTx;
    private Button geisjddh;
    private String sjdh;
    private int idd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(this);
        getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS | WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }
        setContentView(R.layout.activity_grzl);
        ButterKnife.bind(this);
        Bundle bundle = this.getIntent().getExtras();
        idd = bundle.getInt("idd");
        GRZLPresreter presreter = new GRZLPresreter(this, idd);
        presreter.getData();
        geisjddh = (Button) findViewById(R.id.geisjddh);
        geisjddh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                call(sjdh);
            }
        });
    }

    private void call(String phone) {
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phone));
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    @Override
    public void onResponse(GRZLBean grzlBean) {
        sjdh = grzlBean.getData().getTel();
        sjzlName.setText(grzlBean.getData().getName());
        sjzlTel.setText(grzlBean.getData().getTel());
        sjzlCp.setText(grzlBean.getData().getPlate_number());
        grzlText6.setText(grzlBean.getData().getWeight());
        grzlText7.setText(grzlBean.getData().getType());
        String ji = String.valueOf(grzlBean.getData().getJiaoyi());
        String len = String.valueOf(grzlBean.getData().getLength());
        String hao = String.valueOf(grzlBean.getData().getHao());
        String cha = String.valueOf(grzlBean.getData().getCha());
        grzlText5.setText(len);
        grzlJy.setText(ji);
        grzlHp.setText(hao);
        grzlCp.setText(cha);
        grzlText8.setText(grzlBean.getData().getAdvantage()+"\n"+grzlBean.getData().getAccept());
    }

    @Override
    public void onFailure(String s) {

    }

    @OnClick({R.id.grzl_img01, R.id.grzl_text01})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.grzl_img01:
                GRZLActivity.this.finish();
                break;
            case R.id.grzl_text01:
                GRZLActivity.this.finish();
                break;
        }
    }
}
