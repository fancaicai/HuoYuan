package com.huotongtianxia.huoyuan.ui.WDCD.tjcl;

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
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.huotongtianxia.huoyuan.R;
import com.huotongtianxia.huoyuan.bean.SSCLBean;
import com.huotongtianxia.huoyuan.bean.TJCLBean;
import com.huotongtianxia.huoyuan.bean.WDCDSCBean;
import com.huotongtianxia.huoyuan.ui.WDCD.WDCD.WDCDActivity;
import com.huotongtianxia.huoyuan.ui.WDCD.clrz.CLRZActivity;
import com.huotongtianxia.huoyuan.ui.WDCD.sscl.SSCLAdapter;
import com.huotongtianxia.huoyuan.ui.WDCD.sscl.SSCLContract;
import com.huotongtianxia.huoyuan.ui.WDCD.sscl.SSCLPresreter;
import com.huotongtianxia.huoyuan.ui.WDCD.sscl.WDCDSSAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
//添加车辆
public class TJCLActivity extends AppCompatActivity implements SSCLContract.View{

    @Bind(R.id.tjcl_edt)
    EditText tjclEdt;
    @Bind(R.id.tjcl_img)
    ImageView tjclImg;
    @Bind(R.id.zjcl_list)
    ListView zjclList;
    @Bind(R.id.tjcl_btn)
    Button tjclBtn;
    private TextView tjcltext01;
    private ImageView tjclimg01;
    private String tel,tell;
    private List<WDCDSCBean.DataBean> list = new ArrayList<>();
    private WDCDSSAdapter adapter;
    private Spinner tjclSpinner;
    private String cpo;
    private Context context;

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
        setContentView(R.layout.activity_tjcl);
        ButterKnife.bind(this);
        context = getApplicationContext();
        adapter = new WDCDSSAdapter(this,list);
        tjclSpinner = (Spinner) findViewById(R.id.tjcl_spinner);
        tjcltext01 = (TextView) findViewById(R.id.tjcl_text01);
        tjclimg01 = (ImageView) findViewById(R.id.tjcl_img01);
        initView();
    }
    public void initView(){
        tjcltext01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TJCLActivity.this.finish();
            }
        });
        tjclimg01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TJCLActivity.this.finish();
            }
        });
        String[] spinercp = getResources().getStringArray(R.array.cp);
        ArrayAdapter<String> sortcpAdapter = new ArrayAdapter(TJCLActivity.this, android.R.layout.simple_spinner_item, spinercp);
        sortcpAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        tjclSpinner.setAdapter(sortcpAdapter);
        tjclSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                cpo = tjclSpinner.getSelectedItem().toString();
                adapterView.setVisibility(View.VISIBLE);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                adapterView.setVisibility(View.VISIBLE);
            }
        });
    }
    @OnClick({R.id.tjcl_img, R.id.tjcl_btn})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tjcl_img:
                login();
                list.clear();
                tel = cpo+tell;
                SSCLPresreter presreter = new SSCLPresreter(this,tel,context);
                presreter.getData2();
                zjclList.setAdapter(adapter);
                break;
            case R.id.tjcl_btn:
                login();
                tel = cpo+tell;
                SSCLPresreter presreter1 = new SSCLPresreter(this,tel,context);
                presreter1.getData1();
                break;
        }
    }

    public void login() {                                              //登录按钮监听事件
        if (isUserNameAndPwdValid()) {
            tell = tjclEdt.getText().toString().trim();    //获取当前输入的用户名和密码信息
        }
    }

    public boolean isUserNameAndPwdValid() {
        if (tjclEdt.getText().toString().trim().equals("")) {
            Toast.makeText(this, getString(R.string.sscl),
                    Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    @Override
    public void onResponse(SSCLBean ssclBean) {
        int count = ssclBean.getCode();
        if (count == 200){
        }
        adapter.reload(ssclBean.getData());
    }

    @Override
    public void onResponse1(WDCDSCBean ssclBean) {
        int count = ssclBean.getCode();
        if (count == 200){
        }
        adapter.reload(ssclBean.getData());
    }

    @Override
    public void onResponse(TJCLBean tjclBean) {
        int cointt = tjclBean.getCode();
        if (cointt == 100){
            Toast.makeText(this, "添加成功", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(TJCLActivity.this, WDCDActivity.class);
            Bundle bundle = new Bundle();
            bundle.putInt("name",1);
            intent.putExtras(bundle);
            TJCLActivity.this.finish();
            startActivity(intent);
        }else if (cointt == 201){
            Toast.makeText(this, "司机已存在", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(TJCLActivity.this, WDCDActivity.class);
            Bundle bundle = new Bundle();
            bundle.putInt("name",1);
            intent.putExtras(bundle);
            TJCLActivity.this.finish();
            startActivity(intent);
        }else if (cointt == 202){
            Intent intent = new Intent(TJCLActivity.this, CLRZActivity.class);
            Toast.makeText(this, "没有找到车辆，请先认证", Toast.LENGTH_SHORT).show();
            TJCLActivity.this.finish();
            startActivity(intent);
        }
    }

    @Override
    public void onFailure(String s) {

    }
}
