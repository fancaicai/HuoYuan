package com.huotongtianxia.huoyuan.ui.WDCD.bx;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bigkoo.pickerview.TimePopupWindow;
import com.huotongtianxia.huoyuan.R;
import com.huotongtianxia.huoyuan.bean.BXBean;
import com.huotongtianxia.huoyuan.widget.ChangeAddressPopwindow;
import com.huotongtianxia.huoyuan.widget.LoadingDialog;

import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class BXFragment extends Fragment implements BXContract.View {
    @Bind(R.id.bx_zk_text)
    TextView bxZkText;
    @Bind(R.id.bx_zk_img)
    ImageView bxZkImg;
    @Bind(R.id.bx_meiy_text2)
    TextView bxMeiyText2;
    @Bind(R.id.bx_sq_text)
    TextView bxSqText;
    @Bind(R.id.bx_sq_img)
    ImageView bxSqImg;
    @Bind(R.id.bx_edt1)
    EditText bxEdt1;
    @Bind(R.id.bx_edt2)
    EditText bxEdt2;
    @Bind(R.id.bx_edt3)
    EditText bxEdt3;
    @Bind(R.id.bx_edt4)
    EditText bxEdt4;
    @Bind(R.id.bx_edt5)
    EditText bxEdt5;
    @Bind(R.id.bx_edt6)
    EditText bxEdt6;
    @Bind(R.id.bx_edt7)
    EditText bxEdt7;
    @Bind(R.id.bx_edt8)
    EditText bxEdt8;
    @Bind(R.id.bx_edt9)
    EditText bxEdt9;
    @Bind(R.id.bx_edt10)
    EditText bxEdt10;
    @Bind(R.id.bx_edt11)
    EditText bxEdt11;
    @Bind(R.id.bx_text1)
    TextView bxText1;
    @Bind(R.id.bx_text2)
    TextView bxText2;
    @Bind(R.id.bx_text3)
    TextView bxText3;
    @Bind(R.id.bx_btn)
    Button bxBtn;
    private View view;
    private Context context;
    private String insure_name, insure_tel, recognizee_name, recognizee_tel, plate_number, yun_number, sum_assured, good_basic, goods_quantity,
            goods_name, goods_pack, goods_value, yun_start, yun_end, create_time;
    private LoadingDialog loadingDialog;
    TimePopupWindow pwTime;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_bx, container, false);
        context = getContext();
        ButterKnife.bind(this, view);
        loadingDialog = new LoadingDialog(context);
        initView();
        initView2();
        initView3();
        //时间选择器
        pwTime = new TimePopupWindow(context, TimePopupWindow.Type.YEAR_MONTH_DAY);
        //时间选择后回调
        pwTime.setOnTimeSelectListener(new TimePopupWindow.OnTimeSelectListener() {

            @Override
            public void onTimeSelect(Date date) {
                create_time = getTime(date);
                bxText3.setText(getTime(date));
            }
        });
        //弹出时间选择器
        bxText3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                pwTime.showAtLocation(bxText3, Gravity.BOTTOM, 0, 0, new Date());
            }
        });
        return view;
    }

    public void initView() {
        bxText1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChangeAddressPopwindow mChangeAddressPopwindow = new ChangeAddressPopwindow(context);
                mChangeAddressPopwindow.setAddress("广东", "深圳", "福田区");
                mChangeAddressPopwindow.showAtLocation(bxText1, Gravity.BOTTOM, 0, 0);
                mChangeAddressPopwindow.setAddresskListener(new ChangeAddressPopwindow.OnAddressCListener() {
                    @Override
                    public void onClick(String province, String city, String area) {
                        Toast.makeText(context,
                                province + "-" + city + "-" + area,
                                Toast.LENGTH_LONG).show();
                        yun_start = province + "-" + city + "-" + area;
                        bxText1.setText(province + city + area);
                    }
                });
            }
        });
    }

    public void initView2() {
        bxText2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChangeAddressPopwindow mChangeAddressPopwindow = new ChangeAddressPopwindow(context);
                mChangeAddressPopwindow.setAddress("广东", "深圳", "福田区");
                mChangeAddressPopwindow.showAtLocation(bxText1, Gravity.BOTTOM, 0, 0);
                mChangeAddressPopwindow.setAddresskListener(new ChangeAddressPopwindow.OnAddressCListener() {
                    @Override
                    public void onClick(String province, String city, String area) {
                        Toast.makeText(context,
                                province + "-" + city + "-" + area,
                                Toast.LENGTH_LONG).show();
                        yun_end = province + "-" + city + "-" + area;
                        bxText2.setText(province + city + area);
                    }
                });
            }
        });
    }

    public void initView3() {
        bxBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    public static String getTime(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(date);
    }

    @OnClick({R.id.bx_zk_text, R.id.bx_zk_img, R.id.bx_sq_text, R.id.bx_sq_img})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bx_zk_text:
                bxZkText.setVisibility(View.GONE);
                bxSqImg.setVisibility(View.GONE);
                bxMeiyText2.setVisibility(View.INVISIBLE);
                bxZkText.setVisibility(View.INVISIBLE);
                bxZkImg.setVisibility(View.INVISIBLE);
                break;
            case R.id.bx_zk_img:
                bxZkText.setVisibility(View.GONE);
                bxSqImg.setVisibility(View.GONE);
                bxMeiyText2.setVisibility(View.INVISIBLE);
                bxZkText.setVisibility(View.INVISIBLE);
                bxZkImg.setVisibility(View.INVISIBLE);
                break;
            case R.id.bx_sq_text:
                bxZkText.setVisibility(View.INVISIBLE);
                bxSqImg.setVisibility(View.INVISIBLE);
                bxMeiyText2.setVisibility(View.GONE);
                bxZkText.setVisibility(View.GONE);
                bxZkImg.setVisibility(View.GONE);
                break;
            case R.id.bx_sq_img:
                bxZkText.setVisibility(View.INVISIBLE);
                bxSqImg.setVisibility(View.INVISIBLE);
                bxMeiyText2.setVisibility(View.GONE);
                bxZkText.setVisibility(View.GONE);
                bxZkImg.setVisibility(View.GONE);
                break;
        }
    }

    public void login() {                                              //登录按钮监听事件
        if (isUserNameAndPwdValid()) {
            loadingDialog.show();
            insure_name = bxEdt1.getText().toString().trim();    //获取当前输入的用户名和密码信息
            insure_tel = bxEdt2.getText().toString().trim();
            recognizee_name = bxEdt3.getText().toString().trim();
            recognizee_tel = bxEdt4.getText().toString().trim();
            plate_number = bxEdt5.getText().toString().trim();
            yun_number = bxEdt6.getText().toString().trim();
            sum_assured = bxEdt7.getText().toString().trim();
            goods_quantity = bxEdt8.getText().toString().trim();
            goods_name = bxEdt9.getText().toString().trim();
            goods_pack = bxEdt10.getText().toString().trim();
            goods_value = bxEdt11.getText().toString().trim();
        }
        good_basic = "1";
        BXPresreter presreter = new BXPresreter(this,insure_name, insure_tel, recognizee_name, recognizee_tel, plate_number, yun_number, sum_assured, good_basic, goods_quantity,
                goods_name, goods_pack, goods_value, yun_start, yun_end, create_time);
        presreter.getData();
    }

    public boolean isUserNameAndPwdValid() {
        if (bxEdt1.getText().toString().trim().equals("")) {
            Toast.makeText(context, "请输入投保人电话", Toast.LENGTH_SHORT).show();
            return false;
        } else if (bxEdt2.getText().toString().trim().equals("")) {
            Toast.makeText(context, "请输入投保人电话", Toast.LENGTH_SHORT).show();
            return false;
        } else if (bxEdt3.getText().toString().trim().equals("")) {
            Toast.makeText(context, "请输入被保人姓名", Toast.LENGTH_SHORT).show();
            return false;
        } else if (bxEdt4.getText().toString().trim().equals("")) {
            Toast.makeText(context, "请输入被保人电话", Toast.LENGTH_SHORT).show();
            return false;
        } else if (bxEdt5.getText().toString().trim().equals("")) {
            Toast.makeText(context, "请输入车牌号", Toast.LENGTH_SHORT).show();
            return false;
        } else if (bxEdt6.getText().toString().trim().equals("")) {
            Toast.makeText(context, "请输入运单号", Toast.LENGTH_SHORT).show();
            return false;
        } else if (bxEdt7.getText().toString().trim().equals("")) {
            Toast.makeText(context, "请输入保额", Toast.LENGTH_SHORT).show();
            return false;
        } else if (bxEdt8.getText().toString().trim().equals("")) {
            Toast.makeText(context, "请输入货物数量", Toast.LENGTH_SHORT).show();
            return false;
        } else if (bxEdt9.getText().toString().trim().equals("")) {
            Toast.makeText(context, "请输入货物名称", Toast.LENGTH_SHORT).show();
            return false;
        } else if (bxEdt10.getText().toString().trim().equals("")) {
            Toast.makeText(context, "请输入货物包装", Toast.LENGTH_SHORT).show();
            return false;
        } else if (bxEdt11.getText().toString().trim().equals("")) {
            Toast.makeText(context, "请输入货物价值", Toast.LENGTH_SHORT).show();
            return false;
        }else if (yun_start == null ){
            Toast.makeText(context, "请选择起运地", Toast.LENGTH_SHORT).show();
            return false;
        }else if (yun_end == null){
            Toast.makeText(context, "请选择目的地", Toast.LENGTH_SHORT).show();
            return false;
        }else if (create_time == null){
            Toast.makeText(context, "请选择起运时间", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    @Override
    public void onResponse(BXBean bxBean) {
        int count = bxBean.getCode();
        if (count == 100){
            if (loadingDialog.isShowing()) {
                loadingDialog.dismiss();
            }
            Toast.makeText(context, "提交成功", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onFailure(String s) {

    }
}
