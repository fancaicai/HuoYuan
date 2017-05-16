package com.huotongtianxia.huoyuan.ui.WDCD.khzl;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.huotongtianxia.huoyuan.R;
import com.huotongtianxia.huoyuan.bean.FHRBean;
import com.huotongtianxia.huoyuan.bean.SCKHZLBean;
import com.huotongtianxia.huoyuan.bean.SHRBean;
import com.huotongtianxia.huoyuan.ui.WDCD.gyszl.GYSZLView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

//客户资料
public class KHZLActivity extends AppCompatActivity implements KHZLContract.View, GYSZLView {
    @Bind(R.id.khzl_listview)
    ListView khzlListview;
    @Bind(R.id.back_tv)
    TextView backTv;
    @Bind(R.id.add_tv)
    TextView addTv;
    @Bind(R.id.shdz_pbr)
    ProgressBar shdzPbr;
    private List<SHRBean.DataBean> list = new ArrayList<>();
    private KHZLAdapter adapter;
    public static String i1, i2, i3, i4, i5, i6;
    public static int lon = 0;
    public static String customer;
    public static int shrid;
    public static String cityS, addressS;
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
        setContentView(R.layout.activity_khzl);
        ButterKnife.bind(this);
        initView();
        context = getApplicationContext();
        KHZLPresreter presreter = new KHZLPresreter(this, this, context);
        presreter.getData1();
        adapter = new KHZLAdapter(this, list);
        khzlListview.setAdapter(adapter);
        khzlListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                shrid = list.get(i).getId();
                cityS = list.get(i).getProvince() + list.get(i).getCity() + list.get(i).getArea();
                addressS = list.get(i).getAddress();
                KHZLActivity.this.finish();
            }
        });


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
//        返回的处理
        backTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
//        添加的处理
        addTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(KHZLActivity.this, TJKHZLActivity.class);
                KHZLActivity.this.finish();

                startActivity(intent);
            }
        });
//        listview条目的处理
        khzlListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                lon = 1;

                KHZLActivity.this.finish();
            }
        });
    }

    @Override
    public void onResponse(FHRBean khzlBean) {

    }

    @Override
    public void onResponse1(SHRBean khzlBean) {
        adapter.reload(khzlBean.getData());
    }

    @Override
    public void onResponse2(SCKHZLBean sckhzlBean) {

    }

    @Override
    public void onFailure(String s) {

    }

    @Override
    public void showProgressBa() {
        if (shdzPbr!=null) {
            shdzPbr.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void hideProgressBa() {
        if (shdzPbr!=null) {
            shdzPbr.setVisibility(View.GONE);
        }
    }
}
