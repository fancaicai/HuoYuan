package com.huotongtianxia.huoyuan.ui.WDCD.HYFB;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.bigkoo.pickerview.TimePopupWindow;
import com.huotongtianxia.huoyuan.R;
import com.huotongtianxia.huoyuan.bean.GSZLBean;
import com.huotongtianxia.huoyuan.bean.HYFB2Bean;
import com.huotongtianxia.huoyuan.bean.HYFBBean;
import com.huotongtianxia.huoyuan.bean.HYFBSHBean;
import com.huotongtianxia.huoyuan.ui.WDCD.gyszl.GYSZLActivity;
import com.huotongtianxia.huoyuan.ui.WDCD.khzl.KHZLActivity;
import com.huotongtianxia.huoyuan.ui.WDCD.wdhy.WDHYActivity;
import com.huotongtianxia.huoyuan.widget.LoadingDialog;

import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
//货源发布
public class HYFBActivity extends AppCompatActivity implements HYFBContract.View {

    @Bind(R.id.hyfb_shijian1)
    TextView hyfbShijian1;
    @Bind(R.id.hyfb_et1)
    EditText hyfbEt1;
    @Bind(R.id.hyfb_et2)
    EditText hyfbEt2;
    @Bind(R.id.spinner)
    Spinner spinner;
    @Bind(R.id.spinner2)
    Spinner spinner2;
    @Bind(R.id.hyfb_et3)
    EditText hyfbEt3;
    @Bind(R.id.hyfb_fhdz_text1)
    TextView hyfbFhdzText1;
    @Bind(R.id.hyfb_fhdz_text2)
    TextView hyfbFhdzText2;
    @Bind(R.id.hyfb_fhdz_lin)
    LinearLayout hyfbFhdzLin;
    @Bind(R.id.hyfb_shdz_text1)
    TextView hyfbShdzText1;
    @Bind(R.id.hyfb_shdz_text2)
    TextView hyfbShdzText2;
    @Bind(R.id.hyfb_shdz_lin)
    LinearLayout hyfbShdzLin;
    @Bind(R.id.hyfb_btn)
    Button hyfbBtn;
    private String name,we,send,truck_type,truck_length,provinc,cit,rmb;
    private LoadingDialog loadingDialog;
    private int fhrid, shrid;
    TimePopupWindow pwTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hyfb);
        ButterKnife.bind(this);
        loadingDialog = new LoadingDialog(this);
        //下拉列表
        initView();
        //点击事件
        initView1();
        //时间选择器
        pwTime = new TimePopupWindow(this, TimePopupWindow.Type.YEAR_MONTH_DAY);
        //时间选择后回调
        pwTime.setOnTimeSelectListener(new TimePopupWindow.OnTimeSelectListener() {

            @Override
            public void onTimeSelect(Date date) {
                send = getTime(date);
                hyfbShijian1.setText(getTime(date));
            }
        });
        //弹出时间选择器
        hyfbShijian1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                pwTime.showAtLocation(hyfbShijian1, Gravity.BOTTOM, 0, 0, new Date());
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        initView2();
    }

    @OnClick(R.id.hyfb_btn)
    public void onClick() {
        login();
    }

    public void initView1() {
        hyfbFhdzLin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HYFBActivity.this, GYSZLActivity.class);
                startActivity(intent);
            }
        });
        hyfbShdzLin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HYFBActivity.this, KHZLActivity.class);
                startActivity(intent);
            }
        });
    }

    public void initView2() {
        if (GYSZLActivity.fhrid != 0) {
            fhrid = GYSZLActivity.fhrid;
        }
        if (KHZLActivity.shrid != 0) {
            shrid = KHZLActivity.shrid;
        }
        if (GYSZLActivity.cityF != null) {
            hyfbFhdzText1.setText(GYSZLActivity.cityF);
        }
        if (GYSZLActivity.addressF != null) {
            hyfbFhdzText2.setText(GYSZLActivity.addressF);
        }
        if (KHZLActivity.cityS != null) {
            hyfbShdzText1.setText(KHZLActivity.cityS);
        }
        if (KHZLActivity.addressS != null) {
            hyfbShdzText2.setText(KHZLActivity.addressS);
        }
    }

    public static String getTime(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(date);
    }

    //下拉列表
    public void initView() {
        //添加一个下拉列表项的数组，这里存的项就是下拉列表的菜单项
        String[] spiner = getResources().getStringArray(R.array.buy_cars);
        String[] spinersort = getResources().getStringArray(R.array.buy_cars_sort);
        //为下拉列表定义一个适配器，这里就用到里前面定义的list。
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, spiner);
        ArrayAdapter<String> sortAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, spinersort);
        //为适配器设置下拉列表下拉时的菜单样式。
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sortAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //将适配器添加到下拉列表上
        spinner.setAdapter(arrayAdapter);
        spinner2.setAdapter(sortAdapter);
        //为下拉列表设置各种事件的响应，这个事响应菜单被选中
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                TextView tv = (TextView) view;
                tv.setTextColor(getResources().getColor(R.color.ffffff));
                tv.setTextSize(13.0f);    //设置大小
                truck_type = spinner.getSelectedItem().toString();
                parent.setVisibility(View.VISIBLE);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                parent.setVisibility(View.VISIBLE);
            }
        });
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                TextView tv = (TextView) view;
                tv.setTextColor(getResources().getColor(R.color.ffffff));
                truck_length = spinner2.getSelectedItem().toString();
                parent.setVisibility(View.VISIBLE);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                parent.setVisibility(View.VISIBLE);
            }
        });
    }

    public void login() {                                              //登录按钮监听事件
        if (isUserNameAndPwdValid()) {
            loadingDialog.show();
            name = hyfbEt1.getText().toString().trim();    //获取当前输入的用户名和密码信息
            we = hyfbEt2.getText().toString().trim();
            rmb = hyfbEt3.getText().toString().trim();
            HYFBPresreter presreter = new HYFBPresreter(this,fhrid,shrid,name,we,send,truck_length,truck_type,cit,provinc,rmb);
            presreter.getData();
        }
    }

    public boolean isUserNameAndPwdValid() {
        if (shrid == 0) {
            Toast.makeText(this, "请选择收货地址",
                    Toast.LENGTH_SHORT).show();
            return false;
        } else if (fhrid == 0) {
            Toast.makeText(this, "请选择发货地址",
                    Toast.LENGTH_SHORT).show();
            return false;
        }
        if (hyfbEt1.getText().toString().trim().equals("")) {
            Toast.makeText(this, getString(R.string.hyfb_tepy),
                    Toast.LENGTH_SHORT).show();
            return false;
        } else if (hyfbEt2.getText().toString().trim().equals("")) {
            Toast.makeText(this, getString(R.string.hyfb_we),
                    Toast.LENGTH_SHORT).show();
            return false;
        }  else if (send == null) {
            Toast.makeText(this, "请选择发货时间", Toast.LENGTH_SHORT).show();
            return false;
        } else if (truck_type.toString().trim().equals("车型")) {
            Toast.makeText(this, "请选择车型", Toast.LENGTH_SHORT).show();
            return false;
        } else if (truck_length.toString().trim().equals("车长")) {
            Toast.makeText(this, "请选择车长", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    @Override
    public void onResponse(HYFBBean hyfbBean) {
        int count = hyfbBean.getCode();
        if (count == 100) {
            Intent intent = new Intent(this, WDHYActivity.class);
            startActivity(intent);
            if (loadingDialog.isShowing()) {
                loadingDialog.dismiss();
            }
            Toast.makeText(this, "发布成功", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onResponse1(HYFBSHBean hyfbshBean) {

    }

    @Override
    public void onResponse3(HYFB2Bean hyfb2Bean) {

    }

    @Override
    public void onFailure(String s) {

    }

}
