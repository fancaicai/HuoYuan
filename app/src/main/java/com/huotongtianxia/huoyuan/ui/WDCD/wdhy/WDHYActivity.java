package com.huotongtianxia.huoyuan.ui.WDCD.wdhy;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.huotongtianxia.huoyuan.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class WDHYActivity extends AppCompatActivity {
    @Bind(R.id.wdhy_tab)
    TabLayout wdhyTab;
    @Bind(R.id.wdhy_pager)
    ViewPager wdhyPager;
    @Bind(R.id.wdhy_text01)
    TextView wdhyText01;
    @Bind(R.id.hygl_tv)
    TextView hyglTv;
    private String[] arrTabTitle = null;
    private List<Fragment> fragmentlist = new ArrayList<>();
    private HYXXPagerAdapter adapter;
    private TextView wdhytext01;
    private ImageView wdhyimg01;
    private Intent intent;
    private Bundle num1;
    private int requestCode;
    private boolean sended = false;
    private String INTENTNAME = "intentName";
    private String string;

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
        setContentView(R.layout.activity_wdhy);
        ButterKnife.bind(this);
        initDate();
        wdhyText01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
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

    private void initDate() {
        arrTabTitle = getResources().getStringArray(R.array.wdysdTab);
        YSZFragment yszFragment = new YSZFragment();
        YWCFragment ywcFragment = new YWCFragment();
        DJDFragment djdFragment = new DJDFragment();
        fragmentlist.add(djdFragment);
        fragmentlist.add(yszFragment);
        fragmentlist.add(ywcFragment);
        wdhyTab.setTabMode(wdhyTab.MODE_FIXED);
        adapter = new HYXXPagerAdapter(getSupportFragmentManager(), fragmentlist, arrTabTitle);
        wdhyPager.setAdapter(adapter);
        string = getIntent().getExtras().getString(INTENTNAME);
        if (string.equals("1")) {
            wdhyPager.setCurrentItem(1, true);
        }
        wdhyTab.setupWithViewPager(wdhyPager);
    }


    //黄油刀解绑
    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }
}
