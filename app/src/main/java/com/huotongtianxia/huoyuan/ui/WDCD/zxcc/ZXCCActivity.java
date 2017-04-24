package com.huotongtianxia.huoyuan.ui.WDCD.zxcc;

import android.Manifest;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.huotongtianxia.huoyuan.R;
import com.yanzhenjie.permission.AndPermission;
import com.yanzhenjie.permission.PermissionListener;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ZXCCActivity extends AppCompatActivity {
    private static final int REQUEST_CODE_SETTING = 300;
    @Bind(R.id.zxcc_hcc2)
    ImageView zxccHcc2;
    @Bind(R.id.zxcc_hcc3)
    TextView zxccHcc3;
    @Bind(R.id.zxcc_hcc1)
    LinearLayout zxccHcc1;
    @Bind(R.id.zxcc_bdc2)
    ImageView zxccBdc2;
    @Bind(R.id.zxcc_bdc3)
    TextView zxccBdc3;
    @Bind(R.id.zxcc_bdc1)
    LinearLayout zxccBdc1;
    @Bind(R.id.zxcc_view1)
    View zxccView1;
    @Bind(R.id.zxcc_view2)
    View zxccView2;
    private BDCFragment bdcFragment;
    private FragmentManager manager;
    private HCCFragment hccFragment;
    private TextView zxcctext01,zxcctext1;
    private ImageView zxccimg01;

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
        setContentView(R.layout.activity_zxcc);
        ButterKnife.bind(this);
        zxcctext01 = (TextView) findViewById(R.id.zxcc_text01);
        zxccimg01 = (ImageView) findViewById(R.id.zxcc_img01);
        zxcctext1 = (TextView) findViewById(R.id.zxcc_text1);
        InitView();
        initView();
        if (AndPermission.hasPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION,Manifest.permission.CHANGE_WIFI_STATE,Manifest.permission.CHANGE_CONFIGURATION, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.ACCESS_NETWORK_STATE,Manifest.permission.READ_PHONE_STATE,Manifest.permission.ACCESS_WIFI_STATE,Manifest.permission.INTERNET)){

        }else {
            AndPermission.with(this)
                    .requestCode(101)
                    .permission(Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION,Manifest.permission.CHANGE_WIFI_STATE,Manifest.permission.CHANGE_CONFIGURATION, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.ACCESS_NETWORK_STATE,Manifest.permission.READ_PHONE_STATE,Manifest.permission.ACCESS_WIFI_STATE,Manifest.permission.INTERNET)
                    .send();
        }
    }

    public void initView(){
        zxcctext01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ZXCCActivity.this.finish();
            }
        });
        zxccimg01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ZXCCActivity.this.finish();
            }
        });
    }

    @OnClick({R.id.zxcc_hcc2, R.id.zxcc_hcc3, R.id.zxcc_hcc1, R.id.zxcc_bdc2, R.id.zxcc_bdc3, R.id.zxcc_bdc1})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.zxcc_hcc2:
                zxccView1.setVisibility(View.VISIBLE);
                zxccView2.setVisibility(View.GONE);
                Switchfragment(0);
                break;
            case R.id.zxcc_hcc3:
                zxccView1.setVisibility(View.VISIBLE);
                zxccView2.setVisibility(View.GONE);
                Switchfragment(0);
                break;
            case R.id.zxcc_hcc1:
                zxccView1.setVisibility(View.VISIBLE);
                zxccView2.setVisibility(View.GONE);
                Switchfragment(0);
                break;
            case R.id.zxcc_bdc2:
                zxccView1.setVisibility(View.GONE);
                zxccView2.setVisibility(View.VISIBLE);
                Switchfragment(1);
                break;
            case R.id.zxcc_bdc3:
                zxccView1.setVisibility(View.GONE);
                zxccView2.setVisibility(View.VISIBLE);
                Switchfragment(1);
                break;
            case R.id.zxcc_bdc1:
                zxccView1.setVisibility(View.GONE);
                zxccView2.setVisibility(View.VISIBLE);
                Switchfragment(1);
                break;
        }
    }

    private void InitView() {
        manager = getSupportFragmentManager();
        Switchfragment(0);
    }

    //切换碎片的方法,根据索引对碎片进行切换
    private void Switchfragment(int index) {
        //创建碎片管理器
        FragmentTransaction transaction = manager.beginTransaction();
        AddTransaction(transaction);
        //根据id对碎片进行切换 ,如果碎片开始为空 进行创建
        switch (index) {
            case 0:
            if (bdcFragment == null) {
                bdcFragment = new BDCFragment();
                transaction.add(R.id.main_framelayout, bdcFragment);
            } else {
                transaction.show(bdcFragment);
            }
            break;
            case 1:
                if (hccFragment == null) {
                hccFragment = new HCCFragment();
                transaction.add(R.id.main_framelayout, hccFragment);
            } else {
                transaction.show(hccFragment);
            }
                break;

        }
        transaction.commit();
    }

    private void AddTransaction(FragmentTransaction transaction) {
        if (bdcFragment != null) {
            if (bdcFragment.isVisible()) {
                transaction.hide(bdcFragment);
            }
        }
        if (hccFragment != null) {
            transaction.hide(hccFragment);
        }
    }
}
