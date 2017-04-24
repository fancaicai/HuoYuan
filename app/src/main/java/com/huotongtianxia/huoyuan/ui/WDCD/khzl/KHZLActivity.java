package com.huotongtianxia.huoyuan.ui.WDCD.khzl;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
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
import com.huotongtianxia.huoyuan.bean.KHZLBean;
import com.huotongtianxia.huoyuan.bean.SCKHZLBean;
import com.huotongtianxia.huoyuan.bean.SHRBean;
import com.huotongtianxia.huoyuan.ui.WDCD.HYFB.HYFBActivity;
import com.huotongtianxia.huoyuan.widget.MyListView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
//客户资料
public class KHZLActivity extends AppCompatActivity implements KHZLContract.View {
    @Bind(R.id.khzl_listview)
    MyListView khzlListview;
    private TextView kezltext, khzltext01;
    private ImageView khzlimg;
    private List<SHRBean.DataBean> list = new ArrayList<>();
    private KHZLAdapter adapter;
    public static String i1 , i2 , i3 , i4 ,i5 ,i6;
    public static int lon = 0;
    public static String customer;
    public static int shrid;
    public static String cityS,addressS;

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
        setContentView(R.layout.activity_khzl);
        ButterKnife.bind(this);
        kezltext = (TextView) findViewById(R.id.khzl_text);
        khzltext01 = (TextView) findViewById(R.id.khzl_text01);
        khzlimg = (ImageView) findViewById(R.id.khzl_img);
        initView();
        KHZLPresreter presreter = new KHZLPresreter(this);
        presreter.getData1();
        adapter = new KHZLAdapter(this, list);
        khzlListview.setAdapter(adapter);
//        khzlListview.setDivider(new ColorDrawable(Color.GRAY));
//        khzlListview.setDividerHeight(1);
        khzlListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                shrid = list.get(i).getId();
                cityS = list.get(i).getProvince()+list.get(i).getCity()+list.get(i).getArea();
                addressS = list.get(i).getAddress();
                KHZLActivity.this.finish();
            }
        });


    }

    public void initView() {
        kezltext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                KHZLActivity.this.finish();
            }
        });
        khzlimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                KHZLActivity.this.finish();
            }
        });
        khzltext01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(KHZLActivity.this, TJKHZLActivity.class);
                KHZLActivity.this.finish();

                startActivity(intent);
            }
        });
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
}
