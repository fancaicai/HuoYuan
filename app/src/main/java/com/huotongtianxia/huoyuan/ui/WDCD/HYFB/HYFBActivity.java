package com.huotongtianxia.huoyuan.ui.WDCD.HYFB;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.bigkoo.pickerview.TimePopupWindow;
import com.huotongtianxia.huoyuan.R;
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
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

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
    @Bind(R.id.back_tv)
    TextView backTv;
    @Bind(R.id.sendgoods_lin)
    LinearLayout sendgoodsLin;
    @Bind(R.id.endgood_lin)
    LinearLayout endgoodLin;
    private String name, we, send, truck_type, truck_length, provinc, cit, rmb;
    private LoadingDialog loadingDialog;
    private int fhrid, shrid;
    TimePopupWindow pwTime;


    @OnClick(R.id.hyfb_et1)
    void hyfb() {

        final PopupWindow popupWindow = new PopupWindow(this);
        popupWindow.setWidth(WindowManager.LayoutParams.MATCH_PARENT);
        popupWindow.setHeight(WindowManager.LayoutParams.MATCH_PARENT);
        popupWindow.setTouchable(true);
        popupWindow.setFocusable(true);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setAnimationStyle(R.style.AnimBottom);
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.goodsname_layout, null);
        popupWindow.setContentView(view);
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);

//        popupWindow = new PopupWindow(view, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//         popupWindow.setBackgroundDrawable(new ColorDrawable(0x50000000));
//        final WindowManager.LayoutParams wlBackground = getWindow().getAttributes();
//        wlBackground.alpha = 0.5f;      // 0.0 完全不透明,1.0完全透明
//        getWindow().setAttributes(wlBackground);
//        popupWindow.setTouchable(true);
//        popupWindow.setFocusable(false);
//        popupWindow.setOutsideTouchable(false);
        popupWindow.showAtLocation(hyfbEt1, Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);
        ViewHolder viewHolder = new ViewHolder(view);
        viewHolder.phTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popupWindow.dismiss();
                hyfbEt1.setText("普货");
            }
        });
        viewHolder.zhTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popupWindow.dismiss();
                hyfbEt1.setText("重货");
            }
        });
        viewHolder.paohTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popupWindow.dismiss();
                hyfbEt1.setText("泡货");
            }
        });
        viewHolder.sbTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popupWindow.dismiss();
                hyfbEt1.setText("设备");
            }
        });
        viewHolder.pjTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popupWindow.dismiss();
                hyfbEt1.setText("配件");
            }
        });
        viewHolder.bhTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popupWindow.dismiss();
                hyfbEt1.setText("百货");
            }
        });
        viewHolder.jcTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popupWindow.dismiss();
                hyfbEt1.setText("建材");
            }
        });
        viewHolder.spTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popupWindow.dismiss();
                hyfbEt1.setText("食品");
            }
        });
        viewHolder.ylTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popupWindow.dismiss();
                hyfbEt1.setText("饮料");
            }
        });
        viewHolder.hgTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popupWindow.dismiss();
                hyfbEt1.setText("化工");
            }
        });
        viewHolder.sgTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popupWindow.dismiss();
                hyfbEt1.setText("水果");
            }
        });
        viewHolder.scTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popupWindow.dismiss();
                hyfbEt1.setText("蔬菜");
            }
        });
        viewHolder.mcTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popupWindow.dismiss();
                hyfbEt1.setText("木材");
            }
        });
        viewHolder.mtTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popupWindow.dismiss();
                hyfbEt1.setText("煤炭");
            }
        });
        viewHolder.shicaiTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popupWindow.dismiss();
                hyfbEt1.setText("石材");
            }
        });
        viewHolder.jjTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popupWindow.dismiss();
                hyfbEt1.setText("家具");
            }
        });
        viewHolder.smTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popupWindow.dismiss();
                hyfbEt1.setText("树苗");
            }
        });
        viewHolder.hfTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popupWindow.dismiss();
                hyfbEt1.setText("化肥");
            }
        });
        viewHolder.lsTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popupWindow.dismiss();
                hyfbEt1.setText("粮食");
            }
        });
        viewHolder.gcTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popupWindow.dismiss();
                hyfbEt1.setText("钢材");
            }
        });
        viewHolder.pijTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popupWindow.dismiss();
                hyfbEt1.setText("啤酒");
            }
        });
        viewHolder.nnTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popupWindow.dismiss();
                hyfbEt1.setText("牛奶");
            }
        });
        viewHolder.kqsTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popupWindow.dismiss();
                hyfbEt1.setText("矿泉水");
            }
        });
        viewHolder.thTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popupWindow.dismiss();
                hyfbEt1.setText("炭黑");
            }
        });
        viewHolder.qtTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popupWindow.dismiss();
                final PopupWindow popupWindow = new PopupWindow(HYFBActivity.this);
                popupWindow.setWidth(WindowManager.LayoutParams.MATCH_PARENT);
                popupWindow.setHeight(WindowManager.LayoutParams.MATCH_PARENT);
                popupWindow.setTouchable(true);
                popupWindow.setFocusable(true);
                popupWindow.setOutsideTouchable(true);
                popupWindow.setAnimationStyle(R.style.AnimBottom);
                LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View view1 = inflater.inflate(R.layout.goodsname_other_layout, null);
                TextView enter = (TextView) view1.findViewById(R.id.enter_tv);
                final EditText inputtype = (EditText) view1.findViewById(R.id.inputtype_tv);
                enter.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        popupWindow.dismiss();
                        hyfbEt1.setText(inputtype.getText());

                    }
                });
                popupWindow.setContentView(view1);
//                隐藏键盘
//                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
//                imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
                popupWindow.showAtLocation(hyfbEt1, Gravity.CENTER, 0, 0);
            }
        });
        viewHolder.btncal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popupWindow.dismiss();
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        设置隐藏状态栏，并改变状态栏的颜色
        getWindow().requestFeature(Window.FEATURE_NO_TITLE);
//        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            Window window = getWindow();
//            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS | WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
//            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN  | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
//            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
//            window.setStatusBarColor(Color.TRANSPARENT);
//        }
        setContentView(R.layout.activity_hyfb);
        ButterKnife.bind(this);
        loadingDialog = new LoadingDialog(getApplicationContext());
        //下拉列表
        initView();
        //点击事件
        initView1();
        //时间选择器
        pwTime = new TimePopupWindow(this, TimePopupWindow.Type.YEAR_MONTH_DAY);
        //时间选择后回调
        pwTime.setOnTimeSelectListener(new TimePopupWindow.OnTimeSelectListener() {
            //时间选择完成后，将选择的时间设置到相应的控件上
            @Override
            public void onTimeSelect(Date date) {
                send = getTime(date);
                hyfbShijian1.setText(getTime(date));
            }
        });
        //点击选择装货时间，弹出时间选择器
        hyfbShijian1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                pwTime.showAtLocation(hyfbShijian1, Gravity.BOTTOM, 0, 0, new Date());
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

    @Override
    public void onResume() {
        super.onResume();
        initView2();
    }

    @OnClick(R.id.hyfb_btn)
    public void onClick() {
        login();
    }

    //发货页面的点击事件
    public void initView1() {
//        点击发货常用地址，跳转到了发货常用地址页面
        sendgoodsLin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HYFBActivity.this, GYSZLActivity.class);
                startActivity(intent);
            }
        });
//        点击收货常用地址跳转到收货常用地址
        endgoodLin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HYFBActivity.this, KHZLActivity.class);
                startActivity(intent);
            }
        });
        backTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
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
            HYFBPresreter presreter = new HYFBPresreter(this, fhrid, shrid, name, we, send, truck_length, truck_type, cit, provinc, rmb);
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
        } else if (send == null) {
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


    static class ViewHolder {
        @Bind(R.id.ph_tv)
        TextView phTv;
        @Bind(R.id.zh_tv)
        TextView zhTv;
        @Bind(R.id.paoh_tv)
        TextView paohTv;
        @Bind(R.id.sb_tv)
        TextView sbTv;
        @Bind(R.id.pj_tv)
        TextView pjTv;
        @Bind(R.id.tableRow1)
        TableRow tableRow1;
        @Bind(R.id.bh_tv)
        TextView bhTv;
        @Bind(R.id.jc_tv)
        TextView jcTv;
        @Bind(R.id.sp_tv)
        TextView spTv;
        @Bind(R.id.yl_tv)
        TextView ylTv;
        @Bind(R.id.hg_tv)
        TextView hgTv;
        @Bind(R.id.tableRow2)
        TableRow tableRow2;
        @Bind(R.id.sg_tv)
        TextView sgTv;
        @Bind(R.id.sc_tv)
        TextView scTv;
        @Bind(R.id.mc_tv)
        TextView mcTv;
        @Bind(R.id.mt_tv)
        TextView mtTv;
        @Bind(R.id.shicai_tv)
        TextView shicaiTv;
        @Bind(R.id.jj_tv)
        TextView jjTv;
        @Bind(R.id.sm_tv)
        TextView smTv;
        @Bind(R.id.hf_tv)
        TextView hfTv;
        @Bind(R.id.ls_tv)
        TextView lsTv;
        @Bind(R.id.gc_tv)
        TextView gcTv;
        @Bind(R.id.pij_tv)
        TextView pijTv;
        @Bind(R.id.nn_tv)
        TextView nnTv;
        @Bind(R.id.kqs_tv)
        TextView kqsTv;
        @Bind(R.id.th_tv)
        TextView thTv;
        @Bind(R.id.qt_tv)
        TextView qtTv;
        @Bind(R.id.btncal)
        TextView btncal;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
