package com.huotongtianxia.huoyuan.ui.WDCD.HYFB;


import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
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
import com.huotongtianxia.huoyuan.ui.WDCD.gszl.BJGSZLActivity;
import com.huotongtianxia.huoyuan.ui.WDCD.khzl.KHZLActivity;
import com.huotongtianxia.huoyuan.ui.WDCD.khzl.TJKHZLActivity;
import com.huotongtianxia.huoyuan.ui.WDCD.wdhy.WDHYActivity;
import com.huotongtianxia.huoyuan.widget.LoadingDialog;

import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class HYFBFragment extends Fragment implements HYFBContract.View {
    TimePopupWindow pwTime;
    @Bind(R.id.hyfb_et1)
    EditText hyfbEt1;
    @Bind(R.id.hyfb_et2)
    EditText hyfbEt2;
    @Bind(R.id.hyfb_btn)
    Button hyfbBtn;
    @Bind(R.id.hyfb_fhdz_tiaoz)
    LinearLayout hyfbFhdzTiaoz;
    @Bind(R.id.hyfb_fhdz_tiaoz2)
    LinearLayout hyfbFhdzTiaoz2;
    @Bind(R.id.hyfb_fhdz_tiaoz4)
    ImageView hyfbFhdzTiaoz4;
    @Bind(R.id.hyfb_fhdz_tiaoz5)
    TextView hyfbFhdzTiaoz5;
    @Bind(R.id.hyfb_fhdz_tiaoz3)
    LinearLayout hyfbFhdzTiaoz3;
    @Bind(R.id.hyfb_spinner)
    Spinner hyfbSpinner;
    @Bind(R.id.hyfb_spinner2)
    Spinner hyfbSpinner2;
    @Bind(R.id.hyfb_shdz_text1)
    TextView hyfbShdzText1;
    @Bind(R.id.hyfb_shdz_text2)
    TextView hyfbShdzText2;
    @Bind(R.id.hyfb_et3)
    EditText hyfbEt3;
    private TextView hyfbshijian1, hyfbfhdz, hyfbshdz, hyfbfhdzfhdw;
    private View view;
    private Context context;
    private Spinner spinner, spinner2;
    private String fac_i, customer_i, name, we, send, truck_type, truck_length,rmb;
    private String provinc, cit;
    private LoadingDialog loadingDialog;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getContext();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_hyfb, container, false);
        hyfbshijian1 = (TextView) view.findViewById(R.id.hyfb_shijian1);
        hyfbfhdzfhdw = (TextView) view.findViewById(R.id.hyfb_fhdz_fhdw);
        hyfbfhdz = (TextView) view.findViewById(R.id.hyfb_fhdz);
        hyfbshdz = (TextView) view.findViewById(R.id.hyfb_shdz);
        spinner = (Spinner) view.findViewById(R.id.spinner);
        spinner2 = (Spinner) view.findViewById(R.id.spinner2);
//        hyfbkefudh = (TextView) view.findViewById(R.id.wdcd_kefudh);
//        hyfbkefu = (ImageView) view.findViewById(R.id.wdcd_kefu);
        ButterKnife.bind(this, view);
//        HYFBPresreter presreter = new HYFBPresreter(this, fac_i, customer_i, name, we, send, truck_type, truck_length, provinc, cit,rmb);
        loadingDialog = new LoadingDialog(context);
//        presreter.getData2();
        //下拉列表
        initView();
        //点击事件
        initView1();
        //时间选择器
        pwTime = new TimePopupWindow(context, TimePopupWindow.Type.YEAR_MONTH_DAY);
        //时间选择后回调
        pwTime.setOnTimeSelectListener(new TimePopupWindow.OnTimeSelectListener() {

            @Override
            public void onTimeSelect(Date date) {
                send = getTime(date);
                hyfbshijian1.setText(getTime(date));
            }
        });
        //弹出时间选择器
        hyfbshijian1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                pwTime.showAtLocation(hyfbshijian1, Gravity.BOTTOM, 0, 0, new Date());
            }
        });

        //省市联动
        ArrayAdapter adapter = ArrayAdapter.createFromResource(context, R.array.province, R.layout.support_simple_spinner_dropdown_item);
        hyfbSpinner.setAdapter(adapter);
        hyfbSpinner.setOnItemSelectedListener(new spinnerItemSelected());
        hyfbSpinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                TextView tv = (TextView) view;
                tv.setTextColor(getResources().getColor(R.color.ffffff));
                cit = hyfbSpinner2.getSelectedItem().toString();
                if (provinc.toString().trim().equals("省份")) {

                } else {
                    initView2();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        initView1();
    }

    public static String getTime(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(date);
    }

    public void initView1() {
        customer_i = KHZLActivity.customer;
        hyfbshdz.setText(KHZLActivity.i5);
        hyfbShdzText1.setText(KHZLActivity.i2);
        hyfbShdzText2.setText(KHZLActivity.i3
        );
//        HYFBPresreter presreter = new HYFBPresreter(this, fac_i, customer_i, name, we, send, truck_type, truck_length, provinc, cit,rmb);
//        presreter.getData2();

        hyfbFhdzTiaoz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, BJGSZLActivity.class);
                startActivity(intent);
            }
        });
        hyfbFhdzTiaoz2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, KHZLActivity.class);
                startActivity(intent);
            }
        });
        hyfbFhdzTiaoz3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, TJKHZLActivity.class);
                startActivity(intent);
            }
        });
        hyfbFhdzTiaoz4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, TJKHZLActivity.class);
                startActivity(intent);
            }
        });
        hyfbFhdzTiaoz5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, TJKHZLActivity.class);
                startActivity(intent);
            }
        });
    }

    public void initView2() {
//        HYFBPresreter presreter2 = new HYFBPresreter(this, fac_i, customer_i, name, we, send, truck_type, truck_length, provinc, cit,rmb);
//        presreter2.getData1();
//        presreter2.getData3();
    }

    //下拉列表
    public void initView() {
        //添加一个下拉列表项的数组，这里存的项就是下拉列表的菜单项
        String[] spiner = getResources().getStringArray(R.array.buy_cars);
        String[] spinersort = getResources().getStringArray(R.array.buy_cars_sort);
        //为下拉列表定义一个适配器，这里就用到里前面定义的list。
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter(context, android.R.layout.simple_spinner_item, spiner);
        ArrayAdapter<String> sortAdapter = new ArrayAdapter(context, android.R.layout.simple_spinner_item, spinersort);
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

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @OnClick({R.id.hyfb_btn, R.id.hyfb_fhdz_tiaoz})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.hyfb_btn:
                login();
//                HYFBPresreter presreter = new HYFBPresreter(this, fac_i, customer_i, name, we, send, truck_type, truck_length, provinc, cit,rmb);
//                presreter.getData();
                break;
            case R.id.hyfb_fhdz_tiaoz:

                break;
        }
    }

    public void login() {                                              //登录按钮监听事件
        if (isUserNameAndPwdValid()) {
            loadingDialog.show();
            name = hyfbEt1.getText().toString().trim();    //获取当前输入的用户名和密码信息
            we = hyfbEt2.getText().toString().trim();
            rmb = hyfbEt3.getText().toString().trim();
        }
    }

    public boolean isUserNameAndPwdValid() {
        if (hyfbEt1.getText().toString().trim().equals("")) {
            Toast.makeText(context, getString(R.string.hyfb_tepy),
                    Toast.LENGTH_SHORT).show();
            return false;
        } else if (hyfbEt2.getText().toString().trim().equals("")) {
            Toast.makeText(context, getString(R.string.hyfb_we),
                    Toast.LENGTH_SHORT).show();
            return false;
        } else if (hyfbEt3.getText().toString().trim().equals("")) {
            Toast.makeText(context, getString(R.string.hyfb_rmb),
                    Toast.LENGTH_SHORT).show();
            return false;
        }else if (send == null) {
            Toast.makeText(context, "请选择发货时间", Toast.LENGTH_SHORT).show();
            return false;
        } else if (truck_type.toString().trim().equals("车型")) {
            Toast.makeText(context, "请选择车型", Toast.LENGTH_SHORT).show();
            return false;
        } else if (truck_length.toString().trim().equals("车长")) {
            Toast.makeText(context, "请选择车长", Toast.LENGTH_SHORT).show();
            return false;
        }else if (customer_i == null) {
            Toast.makeText(context, "请选择收货地址",
                    Toast.LENGTH_SHORT).show();
            return false;
        }else if (fac_i == null) {
            Toast.makeText(context, "请选择发货地址",
                    Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    @Override
    public void onResponse(HYFBBean hyfbBean) {
        int count = hyfbBean.getCode();
        if (count == 100) {
            Intent intent = new Intent(context, WDHYActivity.class);
            startActivity(intent);
            if (loadingDialog.isShowing()) {
                loadingDialog.dismiss();
            }
            Toast.makeText(context, "发布成功", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onResponse1(HYFBSHBean hyfbshBean) {
        hyfbFhdzTiaoz3.setVisibility(View.GONE);
        hyfbFhdzTiaoz4.setVisibility(View.GONE);
        hyfbFhdzTiaoz5.setVisibility(View.GONE);
        hyfbFhdzTiaoz2.setVisibility(View.VISIBLE);
        customer_i = String.valueOf(hyfbshBean.getData().getId());
        hyfbshdz.setText(hyfbshBean.getData().getAddress());
        hyfbShdzText1.setText(hyfbshBean.getData().getContacts());
        hyfbShdzText2.setText(hyfbshBean.getData().getTel());
    }

    @Override
    public void onResponse3(HYFB2Bean hyfb2Bean) {
        Toast.makeText(context, "当前城市没有匹配的数据", Toast.LENGTH_SHORT).show();
        hyfbFhdzTiaoz3.setVisibility(View.VISIBLE);
        hyfbFhdzTiaoz4.setVisibility(View.VISIBLE);
        hyfbFhdzTiaoz5.setVisibility(View.VISIBLE);
        hyfbFhdzTiaoz2.setVisibility(View.GONE);
    }

    @Override
    public void onFailure(String s) {

    }

    private class spinnerItemSelected implements AdapterView.OnItemSelectedListener {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            TextView tv = (TextView) view;
            tv.setTextColor(getResources().getColor(R.color.ffffff));
            Spinner spinner = (Spinner) parent;
            String pro = (String) spinner.getItemAtPosition(position);
            provinc = spinner.getSelectedItem().toString();
            ArrayAdapter cityadapter = ArrayAdapter.createFromResource(context, R.array.def, R.layout.support_simple_spinner_dropdown_item);
            if (pro.equals("北京")) {
                cityadapter = ArrayAdapter.createFromResource(context, R.array.北京,
                        R.layout.support_simple_spinner_dropdown_item);
            } else if (pro.equals("天津")) {
                cityadapter = ArrayAdapter.createFromResource(context, R.array.天津,
                        R.layout.support_simple_spinner_dropdown_item);
            } else if (pro.equals("河北")) {
                cityadapter = ArrayAdapter.createFromResource(context, R.array.河北,
                        R.layout.support_simple_spinner_dropdown_item);
            } else if (pro.equals("山西")) {
                cityadapter = ArrayAdapter.createFromResource(context, R.array.山西,
                        R.layout.support_simple_spinner_dropdown_item);
            } else if (pro.equals("内蒙古")) {
                cityadapter = ArrayAdapter.createFromResource(context, R.array.内蒙古,
                        R.layout.support_simple_spinner_dropdown_item);
            } else if (pro.equals("辽宁")) {
                cityadapter = ArrayAdapter.createFromResource(context, R.array.辽宁,
                        R.layout.support_simple_spinner_dropdown_item);
            } else if (pro.equals("吉林")) {
                cityadapter = ArrayAdapter.createFromResource(context, R.array.吉林,
                        R.layout.support_simple_spinner_dropdown_item);
            } else if (pro.equals("黑龙江")) {
                cityadapter = ArrayAdapter.createFromResource(context, R.array.黑龙江,
                        R.layout.support_simple_spinner_dropdown_item);
            } else if (pro.equals("上海")) {
                cityadapter = ArrayAdapter.createFromResource(context, R.array.上海,
                        R.layout.support_simple_spinner_dropdown_item);
            } else if (pro.equals("江苏")) {
                cityadapter = ArrayAdapter.createFromResource(context, R.array.江苏,
                        R.layout.support_simple_spinner_dropdown_item);
            } else if (pro.equals("浙江")) {
                cityadapter = ArrayAdapter.createFromResource(context, R.array.浙江,
                        R.layout.support_simple_spinner_dropdown_item);
            } else if (pro.equals("安徽")) {
                cityadapter = ArrayAdapter.createFromResource(context, R.array.安徽,
                        R.layout.support_simple_spinner_dropdown_item);
            } else if (pro.equals("福建")) {
                cityadapter = ArrayAdapter.createFromResource(context, R.array.福建,
                        R.layout.support_simple_spinner_dropdown_item);
            } else if (pro.equals("江西")) {
                cityadapter = ArrayAdapter.createFromResource(context, R.array.江西,
                        R.layout.support_simple_spinner_dropdown_item);
            } else if (pro.equals("山东")) {
                cityadapter = ArrayAdapter.createFromResource(context, R.array.山东,
                        R.layout.support_simple_spinner_dropdown_item);
            } else if (pro.equals("河南")) {
                cityadapter = ArrayAdapter.createFromResource(context, R.array.河南,
                        R.layout.support_simple_spinner_dropdown_item);
            } else if (pro.equals("湖北")) {
                cityadapter = ArrayAdapter.createFromResource(context, R.array.湖北,
                        R.layout.support_simple_spinner_dropdown_item);
            } else if (pro.equals("湖南")) {
                cityadapter = ArrayAdapter.createFromResource(context, R.array.湖南,
                        R.layout.support_simple_spinner_dropdown_item);
            } else if (pro.equals("广东")) {
                cityadapter = ArrayAdapter.createFromResource(context, R.array.广东,
                        R.layout.support_simple_spinner_dropdown_item);
            } else if (pro.equals("广西")) {
                cityadapter = ArrayAdapter.createFromResource(context, R.array.广西,
                        R.layout.support_simple_spinner_dropdown_item);
            } else if (pro.equals("海南")) {
                cityadapter = ArrayAdapter.createFromResource(context, R.array.海南,
                        R.layout.support_simple_spinner_dropdown_item);
            } else if (pro.equals("重庆")) {
                cityadapter = ArrayAdapter.createFromResource(context, R.array.重庆,
                        R.layout.support_simple_spinner_dropdown_item);
            } else if (pro.equals("四川")) {
                cityadapter = ArrayAdapter.createFromResource(context, R.array.四川,
                        R.layout.support_simple_spinner_dropdown_item);
            } else if (pro.equals("贵州")) {
                cityadapter = ArrayAdapter.createFromResource(context, R.array.贵州,
                        R.layout.support_simple_spinner_dropdown_item);
            } else if (pro.equals("云南")) {
                cityadapter = ArrayAdapter.createFromResource(context, R.array.云南,
                        R.layout.support_simple_spinner_dropdown_item);
            } else if (pro.equals("西藏")) {
                cityadapter = ArrayAdapter.createFromResource(context, R.array.西藏,
                        R.layout.support_simple_spinner_dropdown_item);
            } else if (pro.equals("陕西")) {
                cityadapter = ArrayAdapter.createFromResource(context, R.array.陕西,
                        R.layout.support_simple_spinner_dropdown_item);
            } else if (pro.equals("甘肃")) {
                cityadapter = ArrayAdapter.createFromResource(context, R.array.甘肃,
                        R.layout.support_simple_spinner_dropdown_item);
            } else if (pro.equals("青海")) {
                cityadapter = ArrayAdapter.createFromResource(context, R.array.青海,
                        R.layout.support_simple_spinner_dropdown_item);
            } else if (pro.equals("宁夏")) {
                cityadapter = ArrayAdapter.createFromResource(context, R.array.宁夏,
                        R.layout.support_simple_spinner_dropdown_item);
            } else if (pro.equals("新疆")) {
                cityadapter = ArrayAdapter.createFromResource(context, R.array.新疆,
                        R.layout.support_simple_spinner_dropdown_item);
            } else if (pro.equals("台湾")) {
                cityadapter = ArrayAdapter.createFromResource(context, R.array.台湾,
                        R.layout.support_simple_spinner_dropdown_item);
            } else if (pro.equals("香港")) {
                cityadapter = ArrayAdapter.createFromResource(context, R.array.香港,
                        R.layout.support_simple_spinner_dropdown_item);
            } else if (pro.equals("澳门")) {
                cityadapter = ArrayAdapter.createFromResource(context, R.array.澳门,
                        R.layout.support_simple_spinner_dropdown_item);
            }
            hyfbSpinner2.setAdapter(cityadapter);
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }
}
