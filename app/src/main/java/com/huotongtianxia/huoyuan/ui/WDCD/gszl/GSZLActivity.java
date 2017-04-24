package com.huotongtianxia.huoyuan.ui.WDCD.gszl;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.huotongtianxia.huoyuan.R;
import com.huotongtianxia.huoyuan.bean.GSZLBean;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class GSZLActivity extends AppCompatActivity implements GSZLContract.View {

    @Bind(R.id.gszl_text1)
    TextView gszlText1;
    @Bind(R.id.gszl_text2)
    TextView gszlText2;
    @Bind(R.id.gszl_text3)
    TextView gszlText3;
    @Bind(R.id.gszl_text4)
    TextView gszlText4;
    @Bind(R.id.gszl_text5)
    TextView gszlText5;
    @Bind(R.id.gszl_text6)
    TextView gszlText6;
    private TextView gszltext01;
    private ImageView gszlimg;
    public static String fac;
    public static String b1, b2, b3, b4, b5, b6, b7, b8;
    private int count = 0;

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
        setContentView(R.layout.activity_gszl);
        ButterKnife.bind(this);
        gszltext01 = (TextView) findViewById(R.id.gszl_text01);
        gszlimg = (ImageView) findViewById(R.id.gszl_img);
        GSZLPresreter presreter = new GSZLPresreter(this);
        presreter.getData();
        initView();
    }

    @Override
    public void onResume() {
        super.onResume();
        GSZLPresreter presreter = new GSZLPresreter(this);
        presreter.getData();
    }

    public void initView() {
        gszltext01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GSZLActivity.this.finish();
            }
        });
        gszlimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GSZLActivity.this.finish();
            }
        });
    }


    @Override
    public void onResponse(GSZLBean gszlBean) {
        b1 = gszlBean.getData().getCompany();
        b2 = gszlBean.getData().getAddress();
        b3 = gszlBean.getData().getMain_products();
        b4 = gszlBean.getData().getTruck_type();
        b5 = gszlBean.getData().getHead();
        b6 = gszlBean.getData().getMobile();
        gszlText1.setText(gszlBean.getData().getCompany());
        gszlText2.setText(gszlBean.getData().getAddress());
        gszlText3.setText(gszlBean.getData().getMain_products());
        gszlText4.setText(gszlBean.getData().getTruck_type());
        gszlText5.setText(gszlBean.getData().getHead());
        gszlText6.setText(gszlBean.getData().getMobile());
    }

    @Override
    public void onFailure(String s) {

    }

    @OnClick({R.id.gszl_text1, R.id.gszl_text2, R.id.gszl_text3, R.id.gszl_text4, R.id.gszl_text5, R.id.gszl_text6})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.gszl_text1:
                count = 1;
                Intent intent = new Intent(GSZLActivity.this, BJGSZLActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("count",count);
                intent.putExtras(bundle);
                startActivity(intent);
                break;
            case R.id.gszl_text2:
                count = 2;
                intent = new Intent(GSZLActivity.this, BJGSZLActivity.class);
                bundle = new Bundle();
                bundle.putInt("count",count);
                intent.putExtras(bundle);
                startActivity(intent);
                break;
            case R.id.gszl_text3:
                count = 3;
                intent = new Intent(GSZLActivity.this, BJGSZLActivity.class);
                bundle = new Bundle();
                bundle.putInt("count",count);
                intent.putExtras(bundle);
                startActivity(intent);
                break;
            case R.id.gszl_text4:
                count = 4;
                intent = new Intent(GSZLActivity.this, BJGSZLActivity.class);
                bundle = new Bundle();
                bundle.putInt("count",count);
                intent.putExtras(bundle);
                startActivity(intent);
                break;
            case R.id.gszl_text5:
                count = 5;
                intent = new Intent(GSZLActivity.this, BJGSZLActivity.class);
                bundle = new Bundle();
                bundle.putInt("count",count);
                intent.putExtras(bundle);
                startActivity(intent);
                break;
            case R.id.gszl_text6:
                count = 6;
                intent = new Intent(GSZLActivity.this, BJGSZLActivity.class);
                bundle = new Bundle();
                bundle.putInt("count",count);
                intent.putExtras(bundle);
                startActivity(intent);
                break;
        }
    }
}
