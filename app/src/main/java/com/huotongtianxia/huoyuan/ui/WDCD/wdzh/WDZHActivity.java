package com.huotongtianxia.huoyuan.ui.WDCD.wdzh;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.huotongtianxia.huoyuan.R;
import com.huotongtianxia.huoyuan.bean.WDZHBean;

import butterknife.Bind;
import butterknife.ButterKnife;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class WDZHActivity extends AppCompatActivity implements WDZHContract.View {

    @Bind(R.id.wdzh_text1)
    TextView wdzhText1;
    @Bind(R.id.wdzh_text2)
    TextView wdzhText2;
    @Bind(R.id.wdzh_text3)
    TextView wdzhText3;
    @Bind(R.id.wdzh_text4)
    TextView wdzhText4;
    @Bind(R.id.wdzh_text5)
    TextView wdzhText5;
    @Bind(R.id.wdzh_text6)
    TextView wdzhText6;
    @Bind(R.id.wdzh_text7)
    TextView wdzhText7;
    @Bind(R.id.back_iv)
    ImageView backIv;
    @Bind(R.id.back_tv)
    TextView backTv;
    @Bind(R.id.textView4)
    TextView textView4;
    @Bind(R.id.activity_wdzh)
    LinearLayout activityWdzh;

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
        setContentView(R.layout.activity_wdzh);
        ButterKnife.bind(this);
        initView();

        WDZHPresreter presreter = new WDZHPresreter(this);
        presreter.getData();

    }

    /**
     * 自定义字体
     * @param newBase
     */
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    public void initView() {
        backTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WDZHActivity.this.finish();
            }
        });
        backIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WDZHActivity.this.finish();
            }
        });
    }


    @Override
    public void onResponse(WDZHBean wdzhBean) {
        wdzhText1.setText(wdzhBean.getData().getCompany());
        wdzhText3.setText(wdzhBean.getData().getMobile());
        String count = String.valueOf(wdzhBean.getCount());
        wdzhText4.setText(count);
        String Bankid = String.valueOf(wdzhBean.getData().getBankid());
        wdzhText5.setText(Bankid);
        wdzhText6.setText(wdzhBean.getData().getOwner());
        wdzhText7.setText(wdzhBean.getData().getBank());
    }

    @Override
    public void onFailure(String s) {

    }
}
