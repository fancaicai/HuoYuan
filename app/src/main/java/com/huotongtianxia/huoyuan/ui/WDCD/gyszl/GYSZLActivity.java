package com.huotongtianxia.huoyuan.ui.WDCD.gyszl;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.huotongtianxia.huoyuan.R;
import com.huotongtianxia.huoyuan.bean.FHRBean;
import com.huotongtianxia.huoyuan.bean.SCKHZLBean;
import com.huotongtianxia.huoyuan.bean.SHRBean;
import com.huotongtianxia.huoyuan.ui.WDCD.khzl.KHZLContract;
import com.huotongtianxia.huoyuan.ui.WDCD.khzl.KHZLPresreter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
//供应商资料也就是我们现在的发货地址页面
public class GYSZLActivity extends AppCompatActivity implements KHZLContract.View {
    @Bind(R.id.gyszl_list)
    ListView gyszlList;
    @Bind(R.id.wlgs_tjgys)
    TextView wlgsTjgys;
    private List<FHRBean.DataBean> list = new ArrayList<>();
    private GYSListApadter apadter;
    private TextView gyszltext01;
    private ImageView gyszlimg01;
    public static int fhrid;
    public static String cityF,addressF;

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
        setContentView(R.layout.activity_gyszl);
        ButterKnife.bind(this);
        gyszltext01 = (TextView) findViewById(R.id.grszl_text01);
//        点击事件的监听
        initView();
        KHZLPresreter presreter = new KHZLPresreter(this);
        presreter.getData();
        apadter = new GYSListApadter(this, list);
        gyszlList.setAdapter(apadter);
//        点击intem的监听
        gyszlList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                fhrid = list.get(i).getId();
                cityF = list.get(i).getProvince()+list.get(i).getCity()+list.get(i).getArea();
                addressF = list.get(i).getAddress();
                GYSZLActivity.this.finish();
            }
        });
    }
/**
 * 控件的点击事件的监听
 * */
    public void initView() {
//        点击增加的监听事件，点击增加跳转到了添加供应商的页面
        wlgsTjgys.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GYSZLActivity.this,TJGYSActivity.class);
                GYSZLActivity.this.finish();
                startActivity(intent);
            }
        });
//点击左上角的返回的时候的监听
        gyszltext01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GYSZLActivity.this.finish();
            }
        });
    }
    /**
     * 网络请求的发货人数据处理
     * */
    @Override
    public void onResponse(FHRBean khzlBean) {
        apadter.reload(khzlBean.getData());
    }
    /**
     * 网络请求的收货人
     * */
    @Override
    public void onResponse1(SHRBean khzlBean) {

    }

    @Override
    public void onResponse2(SCKHZLBean sckhzlBean) {

    }

    @Override
    public void onFailure(String s) {

    }

}
