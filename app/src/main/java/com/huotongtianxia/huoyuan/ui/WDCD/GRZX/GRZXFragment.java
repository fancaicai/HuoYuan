package com.huotongtianxia.huoyuan.ui.WDCD.GRZX;


import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.huotongtianxia.huoyuan.R;
import com.huotongtianxia.huoyuan.bean.GRZXBean;
import com.huotongtianxia.huoyuan.ui.WDCD.clrz.CLRZActivity;
import com.huotongtianxia.huoyuan.ui.WDCD.fctj.FCTJActivity;
import com.huotongtianxia.huoyuan.ui.WDCD.gszl.GSZLActivity;
import com.huotongtianxia.huoyuan.ui.WDCD.gyszl.GYSZLActivity;
import com.huotongtianxia.huoyuan.ui.WDCD.khzl.KHZLActivity;
import com.huotongtianxia.huoyuan.ui.WDCD.wdhy.WDHYActivity;
import com.huotongtianxia.huoyuan.ui.WDCD.wdzh.WDZHActivity;
import com.huotongtianxia.huoyuan.ui.WDCD.zxcc.ZXCCActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 * 个人中心
 */
public class GRZXFragment extends Fragment implements GRZXContract.View {

    @Bind(R.id.grzx_text1)
    TextView grzxText1;
    @Bind(R.id.grzx_text2)
    TextView grzxText2;
    @Bind(R.id.grzx_img11)
    ImageView grzxImg11;
    @Bind(R.id.grzx_text11)
    TextView grzxText11;
    @Bind(R.id.grzx_lin11)
    LinearLayout grzxLin11;
    @Bind(R.id.grzx_img55)
    ImageView grzxImg55;
    @Bind(R.id.grzx_text55)
    TextView grzxText55;
    @Bind(R.id.grzx_lin55)
    LinearLayout grzxLin55;
    @Bind(R.id.grzx_img66)
    ImageView grzxImg66;
    @Bind(R.id.grzx_text66)
    TextView grzxText66;
    @Bind(R.id.grzx_lin66)
    LinearLayout grzxLin66;
    @Bind(R.id.grzx_img33)
    ImageView grzxImg33;
    @Bind(R.id.grzx_text33)
    TextView grzxText33;
    @Bind(R.id.grzx_lin33)
    LinearLayout grzxLin33;
    @Bind(R.id.grzx_img77)
    ImageView grzxImg77;
    @Bind(R.id.grzx_text77)
    TextView grzxText77;
    @Bind(R.id.grzx_lin77)
    LinearLayout grzxLin77;
    @Bind(R.id.grzx_img44)
    ImageView grzxImg44;
    @Bind(R.id.grzx_text44)
    TextView grzxText44;
    @Bind(R.id.grzx_lin44)
    LinearLayout grzxLin44;
    @Bind(R.id.textView)
    TextView textView;
    @Bind(R.id.wdcd_img1)
    SimpleDraweeView wdcdImg1;
    private Activity activity;
    private ImageView grzximg01;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = getActivity();
        Fresco.initialize(activity);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_grzx, container, false);
        ButterKnife.bind(this, view);
        grzximg01 = (ImageView) view.findViewById(R.id.grzx_img01);
        GRZXPresreter presreter = new GRZXPresreter(this);
        presreter.getData();
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }


    @OnClick({R.id.grzx_text1, R.id.grzx_text2, R.id.grzx_img11, R.id.grzx_text11, R.id.grzx_lin11, R.id.grzx_img55, R.id.grzx_text55, R.id.grzx_lin55, R.id.grzx_img66, R.id.grzx_text66, R.id.grzx_lin66, R.id.grzx_img33, R.id.grzx_text33, R.id.grzx_lin33, R.id.grzx_img77, R.id.grzx_text77, R.id.grzx_lin77, R.id.grzx_img44, R.id.grzx_text44, R.id.grzx_lin44})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.grzx_text1:
                Intent intent = new Intent(activity, GSZLActivity.class);
                startActivity(intent);
                break;
            case R.id.grzx_text2:
                intent = new Intent(activity, WDZHActivity.class);
                startActivity(intent);
                break;
            case R.id.grzx_img11:
                grzxImg11.setImageResource(R.mipmap.grzxzxcc_2);
                grzxImg33.setImageResource(R.mipmap.grzxkf_2);
                grzxImg44.setImageResource(R.mipmap.grzxshdz_2);
                grzxImg55.setImageResource(R.mipmap.grzxfhd_2);
                grzxImg66.setImageResource(R.mipmap.grzxfh_2);
                grzxImg77.setImageResource(R.mipmap.grzxfctj_2);
                grzxText11.setTextColor(activity.getResources().getColor(R.color.zi));
                grzxText33.setTextColor(activity.getResources().getColor(R.color.home1));
                grzxText44.setTextColor(activity.getResources().getColor(R.color.home1));
                grzxText55.setTextColor(activity.getResources().getColor(R.color.home1));
                grzxText66.setTextColor(activity.getResources().getColor(R.color.home1));
                grzxText77.setTextColor(activity.getResources().getColor(R.color.home1));
                intent = new Intent(activity, ZXCCActivity.class);
                startActivity(intent);
                break;
            case R.id.grzx_text11:
                grzxImg11.setImageResource(R.mipmap.grzxzxcc_2);
                grzxImg33.setImageResource(R.mipmap.grzxkf_2);
                grzxImg44.setImageResource(R.mipmap.grzxshdz_2);
                grzxImg55.setImageResource(R.mipmap.grzxfhd_2);
                grzxImg66.setImageResource(R.mipmap.grzxfh_2);
                grzxImg77.setImageResource(R.mipmap.grzxfctj_2);
                grzxText11.setTextColor(activity.getResources().getColor(R.color.zi));
                grzxText33.setTextColor(activity.getResources().getColor(R.color.home1));
                grzxText44.setTextColor(activity.getResources().getColor(R.color.home1));
                grzxText55.setTextColor(activity.getResources().getColor(R.color.home1));
                grzxText66.setTextColor(activity.getResources().getColor(R.color.home1));
                grzxText77.setTextColor(activity.getResources().getColor(R.color.home1));
                intent = new Intent(activity, ZXCCActivity.class);
                startActivity(intent);
                break;
            case R.id.grzx_lin11:
                grzxImg11.setImageResource(R.mipmap.grzxzxcc_2);
                grzxImg33.setImageResource(R.mipmap.grzxkf_2);
                grzxImg44.setImageResource(R.mipmap.grzxshdz_2);
                grzxImg55.setImageResource(R.mipmap.grzxfhd_2);
                grzxImg66.setImageResource(R.mipmap.grzxfh_2);
                grzxImg77.setImageResource(R.mipmap.grzxfctj_2);
                grzxText11.setTextColor(activity.getResources().getColor(R.color.zi));
                grzxText33.setTextColor(activity.getResources().getColor(R.color.home1));
                grzxText44.setTextColor(activity.getResources().getColor(R.color.home1));
                grzxText55.setTextColor(activity.getResources().getColor(R.color.home1));
                grzxText66.setTextColor(activity.getResources().getColor(R.color.home1));
                grzxText77.setTextColor(activity.getResources().getColor(R.color.home1));
                intent = new Intent(activity, ZXCCActivity.class);
                startActivity(intent);
                break;
            case R.id.grzx_img55:
                grzxImg11.setImageResource(R.mipmap.grzxzxcc_1);
                grzxImg33.setImageResource(R.mipmap.grzxkf_2);
                grzxImg44.setImageResource(R.mipmap.grzxshdz_2);
                grzxImg55.setImageResource(R.mipmap.grzxfhd_1);
                grzxImg66.setImageResource(R.mipmap.grzxfh_2);
                grzxImg77.setImageResource(R.mipmap.grzxfctj_2);
                grzxText11.setTextColor(activity.getResources().getColor(R.color.home1));
                grzxText33.setTextColor(activity.getResources().getColor(R.color.home1));
                grzxText44.setTextColor(activity.getResources().getColor(R.color.home1));
                grzxText55.setTextColor(activity.getResources().getColor(R.color.zi));
                grzxText66.setTextColor(activity.getResources().getColor(R.color.home1));
                grzxText77.setTextColor(activity.getResources().getColor(R.color.home1));
                intent = new Intent(activity, WDHYActivity.class);
                startActivity(intent);
                break;
            case R.id.grzx_text55:
                grzxImg11.setImageResource(R.mipmap.grzxzxcc_1);
                grzxImg33.setImageResource(R.mipmap.grzxkf_2);
                grzxImg44.setImageResource(R.mipmap.grzxshdz_2);
                grzxImg55.setImageResource(R.mipmap.grzxfhd_1);
                grzxImg66.setImageResource(R.mipmap.grzxfh_2);
                grzxImg77.setImageResource(R.mipmap.grzxfctj_2);
                grzxText11.setTextColor(activity.getResources().getColor(R.color.home1));
                grzxText33.setTextColor(activity.getResources().getColor(R.color.home1));
                grzxText44.setTextColor(activity.getResources().getColor(R.color.home1));
                grzxText55.setTextColor(activity.getResources().getColor(R.color.zi));
                grzxText66.setTextColor(activity.getResources().getColor(R.color.home1));
                grzxText77.setTextColor(activity.getResources().getColor(R.color.home1));
                intent = new Intent(activity, WDHYActivity.class);
                startActivity(intent);
                break;
            case R.id.grzx_lin55:
                grzxImg11.setImageResource(R.mipmap.grzxzxcc_1);
                grzxImg33.setImageResource(R.mipmap.grzxkf_2);
                grzxImg44.setImageResource(R.mipmap.grzxshdz_2);
                grzxImg55.setImageResource(R.mipmap.grzxfhd_1);
                grzxImg66.setImageResource(R.mipmap.grzxfh_2);
                grzxImg77.setImageResource(R.mipmap.grzxfctj_2);
                grzxText11.setTextColor(activity.getResources().getColor(R.color.home1));
                grzxText33.setTextColor(activity.getResources().getColor(R.color.home1));
                grzxText44.setTextColor(activity.getResources().getColor(R.color.home1));
                grzxText55.setTextColor(activity.getResources().getColor(R.color.zi));
                grzxText66.setTextColor(activity.getResources().getColor(R.color.home1));
                grzxText77.setTextColor(activity.getResources().getColor(R.color.home1));
                intent = new Intent(activity, WDHYActivity.class);
                startActivity(intent);
                break;
            case R.id.grzx_img66:
                grzxImg11.setImageResource(R.mipmap.grzxzxcc_1);
                grzxImg33.setImageResource(R.mipmap.grzxkf_2);
                grzxImg44.setImageResource(R.mipmap.grzxshdz_2);
                grzxImg55.setImageResource(R.mipmap.grzxfhd_2);
                grzxImg66.setImageResource(R.mipmap.grzxfh_1);
                grzxImg77.setImageResource(R.mipmap.grzxfctj_2);
                grzxText11.setTextColor(activity.getResources().getColor(R.color.home1));
                grzxText33.setTextColor(activity.getResources().getColor(R.color.home1));
                grzxText44.setTextColor(activity.getResources().getColor(R.color.home1));
                grzxText55.setTextColor(activity.getResources().getColor(R.color.home1));
                grzxText66.setTextColor(activity.getResources().getColor(R.color.zi));
                grzxText77.setTextColor(activity.getResources().getColor(R.color.home1));
                intent = new Intent(activity, GYSZLActivity.class);
                startActivity(intent);
                break;
            case R.id.grzx_text66:
                grzxImg11.setImageResource(R.mipmap.grzxzxcc_1);
                grzxImg33.setImageResource(R.mipmap.grzxkf_2);
                grzxImg44.setImageResource(R.mipmap.grzxshdz_2);
                grzxImg55.setImageResource(R.mipmap.grzxfhd_2);
                grzxImg66.setImageResource(R.mipmap.grzxfh_1);
                grzxImg77.setImageResource(R.mipmap.grzxfctj_2);
                grzxText11.setTextColor(activity.getResources().getColor(R.color.home1));
                grzxText33.setTextColor(activity.getResources().getColor(R.color.home1));
                grzxText44.setTextColor(activity.getResources().getColor(R.color.home1));
                grzxText55.setTextColor(activity.getResources().getColor(R.color.home1));
                grzxText66.setTextColor(activity.getResources().getColor(R.color.zi));
                grzxText77.setTextColor(activity.getResources().getColor(R.color.home1));
                intent = new Intent(activity, GYSZLActivity.class);
                startActivity(intent);
                break;
            case R.id.grzx_lin66:
                grzxImg11.setImageResource(R.mipmap.grzxzxcc_1);
                grzxImg33.setImageResource(R.mipmap.grzxkf_2);
                grzxImg44.setImageResource(R.mipmap.grzxshdz_2);
                grzxImg55.setImageResource(R.mipmap.grzxfhd_2);
                grzxImg66.setImageResource(R.mipmap.grzxfh_1);
                grzxImg77.setImageResource(R.mipmap.grzxfctj_2);
                grzxText11.setTextColor(activity.getResources().getColor(R.color.home1));
                grzxText33.setTextColor(activity.getResources().getColor(R.color.home1));
                grzxText44.setTextColor(activity.getResources().getColor(R.color.home1));
                grzxText55.setTextColor(activity.getResources().getColor(R.color.home1));
                grzxText66.setTextColor(activity.getResources().getColor(R.color.zi));
                grzxText77.setTextColor(activity.getResources().getColor(R.color.home1));
                intent = new Intent(activity, GYSZLActivity.class);
                startActivity(intent);
                break;
            case R.id.grzx_img33:
                grzxImg11.setImageResource(R.mipmap.grzxzxcc_1);
                grzxImg33.setImageResource(R.mipmap.grzxkf_1);
                grzxImg44.setImageResource(R.mipmap.grzxshdz_2);
                grzxImg55.setImageResource(R.mipmap.grzxfhd_2);
                grzxImg66.setImageResource(R.mipmap.grzxfh_2);
                grzxImg77.setImageResource(R.mipmap.grzxfctj_2);
                grzxText11.setTextColor(activity.getResources().getColor(R.color.home1));
                grzxText33.setTextColor(activity.getResources().getColor(R.color.zi));
                grzxText44.setTextColor(activity.getResources().getColor(R.color.home1));
                grzxText55.setTextColor(activity.getResources().getColor(R.color.home1));
                grzxText66.setTextColor(activity.getResources().getColor(R.color.home1));
                grzxText77.setTextColor(activity.getResources().getColor(R.color.home1));
                intent = new Intent(activity, CLRZActivity.class);
                startActivity(intent);
                break;
            case R.id.grzx_text33:
                grzxImg11.setImageResource(R.mipmap.grzxzxcc_1);
                grzxImg33.setImageResource(R.mipmap.grzxkf_1);
                grzxImg44.setImageResource(R.mipmap.grzxshdz_2);
                grzxImg55.setImageResource(R.mipmap.grzxfhd_2);
                grzxImg66.setImageResource(R.mipmap.grzxfh_2);
                grzxImg77.setImageResource(R.mipmap.grzxfctj_2);
                grzxText11.setTextColor(activity.getResources().getColor(R.color.home1));
                grzxText33.setTextColor(activity.getResources().getColor(R.color.zi));
                grzxText44.setTextColor(activity.getResources().getColor(R.color.home1));
                grzxText55.setTextColor(activity.getResources().getColor(R.color.home1));
                grzxText66.setTextColor(activity.getResources().getColor(R.color.home1));
                grzxText77.setTextColor(activity.getResources().getColor(R.color.home1));
                intent = new Intent(activity, CLRZActivity.class);
                startActivity(intent);
                break;
            case R.id.grzx_lin33:
                grzxImg11.setImageResource(R.mipmap.grzxzxcc_1);
                grzxImg33.setImageResource(R.mipmap.grzxkf_1);
                grzxImg44.setImageResource(R.mipmap.grzxshdz_2);
                grzxImg55.setImageResource(R.mipmap.grzxfhd_2);
                grzxImg66.setImageResource(R.mipmap.grzxfh_2);
                grzxImg77.setImageResource(R.mipmap.grzxfctj_2);
                grzxText11.setTextColor(activity.getResources().getColor(R.color.home1));
                grzxText33.setTextColor(activity.getResources().getColor(R.color.zi));
                grzxText44.setTextColor(activity.getResources().getColor(R.color.home1));
                grzxText55.setTextColor(activity.getResources().getColor(R.color.home1));
                grzxText66.setTextColor(activity.getResources().getColor(R.color.home1));
                grzxText77.setTextColor(activity.getResources().getColor(R.color.home1));
                intent = new Intent(activity, CLRZActivity.class);
                startActivity(intent);
                break;
            case R.id.grzx_img77:
                grzxImg11.setImageResource(R.mipmap.grzxzxcc_1);
                grzxImg33.setImageResource(R.mipmap.grzxkf_2);
                grzxImg44.setImageResource(R.mipmap.grzxshdz_2);
                grzxImg55.setImageResource(R.mipmap.grzxfhd_2);
                grzxImg66.setImageResource(R.mipmap.grzxfh_2);
                grzxImg77.setImageResource(R.mipmap.grzxfc_1);
                grzxText11.setTextColor(activity.getResources().getColor(R.color.home1));
                grzxText33.setTextColor(activity.getResources().getColor(R.color.home1));
                grzxText44.setTextColor(activity.getResources().getColor(R.color.home1));
                grzxText55.setTextColor(activity.getResources().getColor(R.color.home1));
                grzxText66.setTextColor(activity.getResources().getColor(R.color.home1));
                grzxText77.setTextColor(activity.getResources().getColor(R.color.zi));
                intent = new Intent(activity, FCTJActivity.class);
                startActivity(intent);
                break;
            case R.id.grzx_text77:
                grzxImg11.setImageResource(R.mipmap.grzxzxcc_1);
                grzxImg33.setImageResource(R.mipmap.grzxkf_2);
                grzxImg44.setImageResource(R.mipmap.grzxshdz_2);
                grzxImg55.setImageResource(R.mipmap.grzxfhd_2);
                grzxImg66.setImageResource(R.mipmap.grzxfh_2);
                grzxImg77.setImageResource(R.mipmap.grzxfc_1);
                grzxText11.setTextColor(activity.getResources().getColor(R.color.home1));
                grzxText33.setTextColor(activity.getResources().getColor(R.color.home1));
                grzxText44.setTextColor(activity.getResources().getColor(R.color.home1));
                grzxText55.setTextColor(activity.getResources().getColor(R.color.home1));
                grzxText66.setTextColor(activity.getResources().getColor(R.color.home1));
                grzxText77.setTextColor(activity.getResources().getColor(R.color.zi));
                intent = new Intent(activity, FCTJActivity.class);
                startActivity(intent);
                break;
            case R.id.grzx_lin77:
                grzxImg11.setImageResource(R.mipmap.grzxzxcc_1);
                grzxImg33.setImageResource(R.mipmap.grzxkf_2);
                grzxImg44.setImageResource(R.mipmap.grzxshdz_2);
                grzxImg55.setImageResource(R.mipmap.grzxfhd_2);
                grzxImg66.setImageResource(R.mipmap.grzxfh_2);
                grzxImg77.setImageResource(R.mipmap.grzxfc_1);
                grzxText11.setTextColor(activity.getResources().getColor(R.color.home1));
                grzxText33.setTextColor(activity.getResources().getColor(R.color.home1));
                grzxText44.setTextColor(activity.getResources().getColor(R.color.home1));
                grzxText55.setTextColor(activity.getResources().getColor(R.color.home1));
                grzxText66.setTextColor(activity.getResources().getColor(R.color.home1));
                grzxText77.setTextColor(activity.getResources().getColor(R.color.zi));
                intent = new Intent(activity, FCTJActivity.class);
                startActivity(intent);
                break;
            case R.id.grzx_img44:
                grzxImg11.setImageResource(R.mipmap.grzxzxcc_1);
                grzxImg33.setImageResource(R.mipmap.grzxkf_2);
                grzxImg44.setImageResource(R.mipmap.grzxshdz_1);
                grzxImg55.setImageResource(R.mipmap.grzxfhd_2);
                grzxImg66.setImageResource(R.mipmap.grzxfh_2);
                grzxImg77.setImageResource(R.mipmap.grzxfctj_2);
                grzxText11.setTextColor(activity.getResources().getColor(R.color.home1));
                grzxText33.setTextColor(activity.getResources().getColor(R.color.home1));
                grzxText44.setTextColor(activity.getResources().getColor(R.color.zi));
                grzxText55.setTextColor(activity.getResources().getColor(R.color.home1));
                grzxText66.setTextColor(activity.getResources().getColor(R.color.home1));
                grzxText77.setTextColor(activity.getResources().getColor(R.color.home1));
                intent = new Intent(activity, KHZLActivity.class);
                startActivity(intent);
                break;
            case R.id.grzx_text44:
                grzxImg11.setImageResource(R.mipmap.grzxzxcc_1);
                grzxImg33.setImageResource(R.mipmap.grzxkf_2);
                grzxImg44.setImageResource(R.mipmap.grzxshdz_1);
                grzxImg55.setImageResource(R.mipmap.grzxfhd_2);
                grzxImg66.setImageResource(R.mipmap.grzxfh_2);
                grzxImg77.setImageResource(R.mipmap.grzxfctj_2);
                grzxText11.setTextColor(activity.getResources().getColor(R.color.home1));
                grzxText33.setTextColor(activity.getResources().getColor(R.color.home1));
                grzxText44.setTextColor(activity.getResources().getColor(R.color.zi));
                grzxText55.setTextColor(activity.getResources().getColor(R.color.home1));
                grzxText66.setTextColor(activity.getResources().getColor(R.color.home1));
                grzxText77.setTextColor(activity.getResources().getColor(R.color.home1));
                intent = new Intent(activity, KHZLActivity.class);
                startActivity(intent);
                break;
            case R.id.grzx_lin44:
                grzxImg11.setImageResource(R.mipmap.grzxzxcc_1);
                grzxImg33.setImageResource(R.mipmap.grzxkf_2);
                grzxImg44.setImageResource(R.mipmap.grzxshdz_1);
                grzxImg55.setImageResource(R.mipmap.grzxfhd_2);
                grzxImg66.setImageResource(R.mipmap.grzxfh_2);
                grzxImg77.setImageResource(R.mipmap.grzxfctj_2);
                grzxText11.setTextColor(activity.getResources().getColor(R.color.home1));
                grzxText33.setTextColor(activity.getResources().getColor(R.color.home1));
                grzxText44.setTextColor(activity.getResources().getColor(R.color.zi));
                grzxText55.setTextColor(activity.getResources().getColor(R.color.home1));
                grzxText66.setTextColor(activity.getResources().getColor(R.color.home1));
                grzxText77.setTextColor(activity.getResources().getColor(R.color.home1));
                intent = new Intent(activity, KHZLActivity.class);
                startActivity(intent);
                break;
        }
    }

    @Override
    public void onResponse(GRZXBean grzxBean) {
        textView.setText(grzxBean.getData().getCompany());
        DraweeController failureImageDraweeController = Fresco.newDraweeControllerBuilder()
                .setUri("http://www.cnhttx.com//uploads/logo/" + grzxBean.getData().getLogo())
                .setTapToRetryEnabled(false)  //同时设置不可重试.
                .setOldController(wdcdImg1.getController())
                .build();
        wdcdImg1.setController(failureImageDraweeController);
     //   Glide.with(this).load("http://www.cnhttx.com//uploads/logo/" + grzxBean.getData().getLogo()).into(wdcdImg1);
        Glide.with(this).load("http://www.cnhttx.com//uploads/door/" + grzxBean.getData().getDoor()).into(grzximg01);
    }

    @Override
    public void onFailure(String s) {

    }
}
