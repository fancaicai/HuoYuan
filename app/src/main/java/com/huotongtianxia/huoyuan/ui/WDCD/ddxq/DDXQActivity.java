package com.huotongtianxia.huoyuan.ui.WDCD.ddxq;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.huotongtianxia.huoyuan.R;
import com.huotongtianxia.huoyuan.bean.DDXQBean;
import com.huotongtianxia.huoyuan.bean.QRSHBean;
import com.huotongtianxia.huoyuan.ui.WDCD.ddgz.DdgzActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class DDXQActivity extends AppCompatActivity implements DDXQContract.View, DDXQView {

    @Bind(R.id.ddxq_text1)
    TextView ddxqText1;
    @Bind(R.id.ddxq_text2)
    TextView ddxqText2;
    @Bind(R.id.ddxq_text3)
    TextView ddxqText3;
    @Bind(R.id.ddxq_text4)
    TextView ddxqText4;
    @Bind(R.id.ddxq_text5)
    TextView ddxqText5;
    @Bind(R.id.ddxq_text6)
    TextView ddxqText6;
    @Bind(R.id.ddxq_text7)
    TextView ddxqText7;
    @Bind(R.id.ddxq_text8)
    TextView ddxqText8;
    @Bind(R.id.ddxq_text9)
    TextView ddxqText9;
    @Bind(R.id.ddxq_text10)
    TextView ddxqText10;
    @Bind(R.id.ddxq_button)
    Button ddxqButton;
    @Bind(R.id.back_tv)
    TextView back_tv;
    @Bind(R.id.ddxq_prb)
    ProgressBar ddxqPrb;
    private String num;
    private DDXQBean ddxqBean;
    private String Drivertel, order_num;
    private Context context;
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
        ddxqBean = new DDXQBean();
        setContentView(R.layout.activity_ddxq);
        context = getApplicationContext();
        Bundle bundle = this.getIntent().getExtras();
        num = bundle.getString("num");
//        这是页面订单详情页面的网络请求
        DDXQPresreter presreter = new DDXQPresreter(this, num,this,context);
        presreter.getData();
        ButterKnife.bind(this);
    }

    /**
     * 自定义字体
     * @param newBase
     */
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @OnClick({R.id.ddxq_hwwzbtn, R.id.ddxq_button, R.id.back_tv})
    public void onClick(View view) {
        switch (view.getId()) {
//            点击确认收货的按钮的时候进行网络请求
            case R.id.ddxq_button:
                DDXQPresreter presreter1 = new DDXQPresreter(this, num,this,context);
                presreter1.getData1();
                break;
//            点击返回按钮的时候关闭当前页面，返回上一个页面
            case R.id.back_tv:
                finish();
                break;
//            点击货物追踪的时候跳到地图界面
            case R.id.ddxq_hwwzbtn:
                DdgzActivity.open(this, order_num);
                break;
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
    }

    @Override
    public void onResponse(DDXQBean ddxqBean) {
        Drivertel = ddxqBean.getData().getDriver_tel();
        order_num = ddxqBean.getData().getOrder_num();
        ddxqText1.setText(ddxqBean.getData().getCreate_time());
        ddxqText2.setText(ddxqBean.getData().getGoods_name());
        ddxqText3.setText(ddxqBean.getData().getWeight());
        ddxqText4.setText(ddxqBean.getData().getOrder_num());
        ddxqText5.setText(ddxqBean.getData().getShipper_address());
        ddxqText6.setText(ddxqBean.getData().getReceive_address());
        ddxqText7.setText(ddxqBean.getData().getDriver_name());
        ddxqText8.setText(ddxqBean.getData().getDriver_card());
        ddxqText9.setText(ddxqBean.getData().getShipper());
        ddxqText10.setText(ddxqBean.getData().getDriver_tel());
    }

    @Override
    public void onResponse1(QRSHBean qrshBean) {
        int cont = qrshBean.getCode();
        if (cont == 100) {
            Intent intent = new Intent(DDXQActivity.this, PJActivity.class);
            Bundle bundle1 = new Bundle();
            bundle1.putString("num", num);
            intent.putExtras(bundle1);
            DDXQActivity.this.finish();
            startActivity(intent);
        }
        Toast.makeText(this, qrshBean.getMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFailure(String s) {

    }

    @Override
    public void showProgressBa() {
        if (ddxqPrb!=null) {
            ddxqPrb.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void hideProgressBa() {
        if (ddxqPrb!=null) {
            ddxqPrb.setVisibility(View.GONE);
        }
    }
}
