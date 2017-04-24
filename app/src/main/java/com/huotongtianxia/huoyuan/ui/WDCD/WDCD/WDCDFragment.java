package com.huotongtianxia.huoyuan.ui.WDCD.WDCD;


import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.huotongtianxia.huoyuan.MainActivity;
import com.huotongtianxia.huoyuan.R;
import com.huotongtianxia.huoyuan.bean.WDCD1Bean;
import com.huotongtianxia.huoyuan.bean.WDCD2Bean;
import com.huotongtianxia.huoyuan.bean.WDCDBean;
import com.huotongtianxia.huoyuan.bean.WDCDSCSJBean;
import com.huotongtianxia.huoyuan.ui.WDCD.sscl.SSCLActivity;
import com.huotongtianxia.huoyuan.ui.WDCD.tjcl.TJCLActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class WDCDFragment extends Fragment implements WDCDContract.View {
    @Bind(R.id.qiehuan)
    TextView qiehuan;
    @Bind(R.id.wdcd_img5)
    ImageView wdcdImg5;
    @Bind(R.id.wdcd_text5)
    TextView wdcdText5;
    @Bind(R.id.wdcd_lin5)
    LinearLayout wdcdLin5;
    @Bind(R.id.wdcd_img66)
    ImageView wdcdImg66;
    @Bind(R.id.wdcd_text6)
    TextView wdcdText6;
    @Bind(R.id.wdcd_lin6)
    LinearLayout wdcdLin6;
    @Bind(R.id.wdcd_img77)
    ImageView wdcdImg77;
    @Bind(R.id.wdcd_text7)
    TextView wdcdText7;
    @Bind(R.id.wdcd_lin7)
    LinearLayout wdcdLin7;
    private Activity activity;
    private TextView wdcd_kefudh;
    private ImageView wdcd_kefu;
    private int idd;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_wdcd, container, false);
        ButterKnife.bind(this, view);
        wdcd_kefu = (ImageView) view.findViewById(R.id.wdcd_kefu);
        wdcd_kefudh = (TextView) view.findViewById(R.id.wdcd_kefudh);
        wdcd_kefu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                call("03512340094");
            }
        });
        wdcd_kefudh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                call("03512340094");
            }
        });
        WDCDPresreter presreter = new WDCDPresreter(this,idd);
        presreter.getData();
        qiehuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.Switchfragment(0);
            }
        });

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    private void call(String phone) {
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phone));
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        activity.startActivity(intent);
    }

    @Override
    public void onResponse(WDCDBean wdcdBean) {
        String count = String.valueOf(wdcdBean.getCount());
        wdcdText5.setText(count);
    }

    @Override
    public void onResponse1(WDCDBean wdcdBean) {
        String count = String.valueOf(wdcdBean.getCount());
        //wdcdText2.setText(count);
    }

    @Override
    public void onResponse2(WDCDSCSJBean wdcdBean) {

    }

    @Override
    public void onFailure(String s) {

    }

    @OnClick({R.id.wdcd_img5, R.id.wdcd_text5, R.id.wdcd_lin5, R.id.wdcd_img66, R.id.wdcd_text6, R.id.wdcd_lin6, R.id.wdcd_img77, R.id.wdcd_text7, R.id.wdcd_lin7})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.wdcd_img5:
                Intent intent = new Intent(activity, WDCDActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("name", 1);
                intent.putExtras(bundle);
                startActivity(intent);
                break;
            case R.id.wdcd_text5:
                intent = new Intent(activity, WDCDActivity.class);
                bundle = new Bundle();
                bundle.putInt("name", 1);
                intent.putExtras(bundle);
                startActivity(intent);
                break;
            case R.id.wdcd_lin5:
                intent = new Intent(activity, WDCDActivity.class);
                bundle = new Bundle();
                bundle.putInt("name", 1);
                intent.putExtras(bundle);
                startActivity(intent);
                break;
            case R.id.wdcd_img66:
                intent = new Intent(activity, TJCLActivity.class);
                startActivity(intent);
                break;
            case R.id.wdcd_text6:
                intent = new Intent(activity, TJCLActivity.class);
                startActivity(intent);
                break;
            case R.id.wdcd_lin6:
                intent = new Intent(activity, TJCLActivity.class);
                startActivity(intent);
                break;
            case R.id.wdcd_img77:
                intent = new Intent(activity, SSCLActivity.class);
                startActivity(intent);
                break;
            case R.id.wdcd_text7:
                intent = new Intent(activity, SSCLActivity.class);
                startActivity(intent);
                break;
            case R.id.wdcd_lin7:
                intent = new Intent(activity, SSCLActivity.class);
                startActivity(intent);
                break;
        }
    }
}
