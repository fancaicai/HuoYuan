package com.huotongtianxia.huoyuan.ui.WDCD.WDCD;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.huotongtianxia.huoyuan.R;
import com.huotongtianxia.huoyuan.bean.WDCD1Bean;
import com.huotongtianxia.huoyuan.bean.WDCD2Bean;
import com.huotongtianxia.huoyuan.bean.WDCDBean;
import com.huotongtianxia.huoyuan.bean.WDCDSCSJBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class WDCDActivity extends AppCompatActivity implements WDCDContract.View {
    @Bind(R.id.wdcd2_bendi)
    TextView wdcd2Bendi;
    @Bind(R.id.wdcd2_quanbu)
    TextView wdcd2Quanbu;
    @Bind(R.id.wdcd2_frame)
    FrameLayout wdcd2Frame;
    private List<WDCDBean.DataBean> list = new ArrayList<>();
    private List<WDCD1Bean.DataBean> list1 = new ArrayList<>();
    private List<WDCD2Bean.DataBean> list2 = new ArrayList<>();
    private WDCDAdapter adapter;
    private WDCD1Adapter adapter1;
    private WDCD2Adapter adapter2;
    private TextView wdcdtext01;
    private ImageView wdcdimg01;
    private int idd;
    private int name;
    private FragmentManager manager;
    private WDCDBFragment wdcdbFragment;
    private WDCDQFragment wdcdqFragment;

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
        setContentView(R.layout.activity_wdcd2);
        ButterKnife.bind(this);
        wdcdtext01 = (TextView) findViewById(R.id.wdcd_text01);
        wdcdimg01 = (ImageView) findViewById(R.id.wdcd_img01);
        initView();
        Bundle bundle = this.getIntent().getExtras();
        name = bundle.getInt("name");
        initView2();
        InitView();
//        wdcdList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Intent intent = new Intent(WDCDActivity.this, GRZLActivity.class);
//                if (name == 0){
//                    idd = Integer.parseInt(list1.get(i).getDriver_id());
//                }else if (name == 1){
//                    idd = Integer.parseInt(list.get(i).getDriver_id());
//                }else if (name == 2){
//                    idd = Integer.parseInt(list2.get(i).getDriver_id());
//                }
//                Bundle bundle1 = new Bundle();
//                bundle1.putInt("idd",idd);
//                intent.putExtras(bundle1);
//                startActivity(intent);
//            }
//        });
//        wdcdList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
//            @Override
//            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
//                if (name == 0){
//                    idd = Integer.parseInt(list1.get(i).getDriver_id());
//                }else if (name == 1){
//                    idd = Integer.parseInt(list.get(i).getDriver_id());
//                }else if (name == 2){
//                    idd = Integer.parseInt(list2.get(i).getDriver_id());
//                }
//                dialog();
//                return true;
//            }
//        });
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
                if (wdcdbFragment == null) {
                    wdcdbFragment = new WDCDBFragment();
                    transaction.add(R.id.wdcd2_frame, wdcdbFragment);
                } else {
                    transaction.show(wdcdbFragment);
                }
                break;
            case 1:
                if (wdcdqFragment == null) {
                    wdcdqFragment = new WDCDQFragment();
                    transaction.add(R.id.wdcd2_frame, wdcdqFragment);
                } else {
                    transaction.show(wdcdqFragment);
                }
                break;
        }
        transaction.commit();
    }

    private void AddTransaction(FragmentTransaction transaction) {
        if (wdcdbFragment != null) {
            if (wdcdbFragment.isVisible()) {
                transaction.hide(wdcdbFragment);
            }
        }
        if (wdcdqFragment != null) {
            transaction.hide(wdcdqFragment);
        }
    }

    protected void dialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(WDCDActivity.this);
        builder.setMessage("确认删除吗");
        builder.setTitle("提示");
        builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                WDCDPresreter presreter = new WDCDPresreter(WDCDActivity.this,idd);
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        builder.create().show();
    }

    public void initView2() {
        if (name == 0) {
            list1.clear();
            WDCDPresreter presreter = new WDCDPresreter(WDCDActivity.this,idd);
            presreter.getData1();
            adapter1 = new WDCD1Adapter(WDCDActivity.this, list1);
            //wdcdList.setAdapter(adapter1);
        } else if (name == 1) {
            list.clear();
            WDCDPresreter presreter = new WDCDPresreter(WDCDActivity.this,idd);
            presreter.getData();
            adapter = new WDCDAdapter(WDCDActivity.this, list);
            // wdcdList.setAdapter(adapter);
        } else if (name == 2) {
            list2.clear();
            WDCDPresreter presreter = new WDCDPresreter(WDCDActivity.this,idd);
            adapter2 = new WDCD2Adapter(WDCDActivity.this, list2);
            //wdcdList.setAdapter(adapter2);
        }
    }

    public void initView() {
        wdcdtext01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WDCDActivity.this.finish();
            }
        });
        wdcdimg01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WDCDActivity.this.finish();
            }
        });
    }

    @Override
    public void onResponse(WDCDBean wdcdBean) {
        String count = String.valueOf(wdcdBean.getCount());
        //wdcdTextItem1.setText(count);
        adapter.reload(wdcdBean.getData());
    }

    @Override
    public void onResponse1(WDCDBean wdcdBean) {
        String count = String.valueOf(wdcdBean.getCount());
        //wdcdTextItem1.setText(count);
        adapter1.reload(wdcdBean.getData());
    }

    @Override
    public void onResponse2(WDCDSCSJBean wdcdBean) {

    }

    @Override
    public void onFailure(String s) {

    }

    @OnClick({R.id.wdcd2_bendi, R.id.wdcd2_quanbu})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.wdcd2_bendi:
                wdcd2Bendi.setBackgroundResource(R.drawable.shapee7);
                wdcd2Quanbu.setBackgroundResource(R.drawable.shapee8);
                wdcd2Bendi.setTextColor(this.getResources().getColor(R.color.ffffff));
                wdcd2Quanbu.setTextColor(this.getResources().getColor(R.color.hei));
                Switchfragment(0);
                break;
            case R.id.wdcd2_quanbu:
                wdcd2Bendi.setBackgroundResource(R.drawable.shapee6);
                wdcd2Quanbu.setBackgroundResource(R.drawable.shapee5);
                wdcd2Bendi.setTextColor(this.getResources().getColor(R.color.hei));
                wdcd2Quanbu.setTextColor(this.getResources().getColor(R.color.ffffff));
                Switchfragment(1);
                break;
        }
    }
}
