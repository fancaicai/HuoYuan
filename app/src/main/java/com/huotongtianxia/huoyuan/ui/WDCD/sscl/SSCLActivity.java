package com.huotongtianxia.huoyuan.ui.WDCD.sscl;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.huotongtianxia.huoyuan.R;
import com.huotongtianxia.huoyuan.bean.SSCLBean;
import com.huotongtianxia.huoyuan.bean.TJCLBean;
import com.huotongtianxia.huoyuan.bean.WDCDSCBean;
import com.huotongtianxia.huoyuan.ui.WDCD.clrz.RZActivity;
import com.huotongtianxia.huoyuan.ui.WDCD.grzl.GRZLActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

//搜索车辆
public class SSCLActivity extends AppCompatActivity implements SSCLContract.View {

    @Bind(R.id.sscl_edt)
    EditText ssclEdt;
    @Bind(R.id.sscl_ss)
    ImageButton ssclImgbt;
    @Bind(R.id.sscl_list)
    ListView ssclList;
    @Bind(R.id.back_tv)
    TextView backTv;
    @Bind(R.id.activity_sscl)
    LinearLayout activitySscl;
    private String tel;
    private List<WDCDSCBean.DataBean> list = new ArrayList<>();
    private WDCDSSAdapter adapter;
    private Context context;
    public static int idd;

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
        setContentView(R.layout.activity_sscl);
        ButterKnife.bind(this);
        adapter = new WDCDSSAdapter(this, list);
        context = getApplicationContext();
        initView();
    }

    public void initView() {
        backTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SSCLActivity.this.finish();
            }
        });
        ssclList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(SSCLActivity.this, GRZLActivity.class);
                idd = list.get(i).getDriver_id();
                Bundle bundle = new Bundle();
                bundle.putInt("idd", idd);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }

    public void login() {                                              //登录按钮监听事件
        if (isUserNameAndPwdValid()) {
            tel = ssclEdt.getText().toString().trim();    //获取当前输入的用户名和密码信息
        }
    }

    public boolean isUserNameAndPwdValid() {
        if (ssclEdt.getText().toString().trim().equals("")) {
            Toast.makeText(this, getString(R.string.sscl),
                    Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    @Override
    public void onResponse(SSCLBean ssclBean) {

    }

    @Override
    public void onResponse1(WDCDSCBean ssclBean) {
        adapter.reload(ssclBean.getData());
        int cointt = ssclBean.getCode();
        if (cointt == 101) {
            Toast.makeText(this, "司机不存在，请添加", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(SSCLActivity.this, RZActivity.class);
            SSCLActivity.this.finish();
            startActivity(intent);
        }
    }

    @Override
    public void onResponse(TJCLBean tjclBean) {

    }

    @Override
    public void onFailure(String s) {

    }

    @OnClick({R.id.sscl_edt, R.id.sscl_ss})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.sscl_edt:
                break;
            case R.id.sscl_ss:
                login();
                list.clear();
                SSCLPresreter presreter = new SSCLPresreter(this, tel, context);
                presreter.getData2();
                ssclList.setAdapter(adapter);
                break;
        }
    }
}
