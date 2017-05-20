package com.huotongtianxia.huoyuan.ui.WDCD.khzl;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.huotongtianxia.huoyuan.R;
import com.huotongtianxia.huoyuan.bean.FHRBean;
import com.huotongtianxia.huoyuan.bean.SCKHZLBean;
import com.huotongtianxia.huoyuan.bean.SHRBean;
import com.huotongtianxia.huoyuan.ui.WDCD.gyszl.GYSZLView;
import com.huotongtianxia.huoyuan.ui.WDCD.login.DLActivity;
import com.huotongtianxia.huoyuan.widget.ChangeAddressPopwindow;

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
    @Bind(R.id.khzl_chooseaddress_tv)
    TextView khzlChooseaddressTv;
    @Bind(R.id.khzl_fhdz_line)
    RelativeLayout khzlFhdzLine;
    private List<SHRBean.DataBean> list = new ArrayList<>();
    private KHZLAdapter adapter;
    public static String i1, i2, i3, i4, i5, i6;
    public static int lon = 0;
    public static String customer;
    public static int shrid;
    public static String cityS, addressS;
    private Context context;
    private KHZLPresreter khzlPresreter;
    private DLActivity dlActivity;
    private String factoryId;

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
        dlActivity = new DLActivity();
        factoryId = dlActivity.getFactoryId();
        initView();
        context = getApplicationContext();
        khzlPresreter = new KHZLPresreter(this, this, context);
        khzlPresreter.getData1();
        adapter = new KHZLAdapter(this, list);
        khzlListview.setAdapter(adapter);
        khzlListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                shrid = list.get(i).getId();
                cityS = list.get(i).getProvince() + list.get(i).getCity() + list.get(i).getArea();
                addressS = list.get(i).getAddress();
                finish();
            }
        });


    }

    /**
     * 自定义字体
     *
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

                finish();
            }
        });
        //        选择省市区的监听
        khzlFhdzLine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChangeAddressPopwindow mChangeAddressPopwindow = new ChangeAddressPopwindow(KHZLActivity.this);
                mChangeAddressPopwindow.setAddress("广东", "深圳", "福田区");
                mChangeAddressPopwindow.showAtLocation(khzlFhdzLine, Gravity.CENTER, 0, 0);
                mChangeAddressPopwindow.setAddresskListener(new ChangeAddressPopwindow.OnAddressCListener() {
                    @Override
                    public void onClick(String province, String city, String area) {
                        String yun_end = province + "-" + city + "-" + area;
                        khzlChooseaddressTv.setText(yun_end);
                        adapter.clear();
                        khzlPresreter.getSearchData(factoryId, province, city, area);
                    }

                });
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
        if (shdzPbr != null) {
            shdzPbr.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void hideProgressBa() {
        if (shdzPbr != null) {
            shdzPbr.setVisibility(View.GONE);
        }
    }

    @Override
    public void setSearchData(List<SHRBean.DataBean> list) {
        adapter.clear();
        adapter.reload(list);
    }
}
