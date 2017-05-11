package com.huotongtianxia.huoyuan.ui.WDCD.WDCD;


import android.content.Context;
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

import com.huotongtianxia.huoyuan.MainActivity;
import com.huotongtianxia.huoyuan.R;
import com.huotongtianxia.huoyuan.ui.WDCD.HYFB.HYFBActivity;
import com.huotongtianxia.huoyuan.ui.WDCD.wdhy.WDHYActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {
    @Bind(R.id.qiehuan1)
    TextView qiehuan1;
    @Bind(R.id.wdcd_kefu1)
    ImageView wdcdKefu1;
    @Bind(R.id.wdcd_kefudh1)
    TextView wdcdKefudh1;
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
    TextView mDdgzTv;
    @Bind(R.id.wdcd_lin7)
    LinearLayout wdcdLin7;
    private View view;
    private Context context;
    private String INTENTNAME="intentName";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getContext();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @OnClick({R.id.qiehuan1, R.id.wdcd_kefu1, R.id.wdcd_kefudh1, R.id.wdcd_img5, R.id.wdcd_text5, R.id.wdcd_lin5, R.id.wdcd_img66, R.id.wdcd_text6, R.id.wdcd_lin6, R.id.wdcd_img77, R.id.wdcd_text7, R.id.wdcd_lin7})
    public void onClick(View view) {
        Bundle  bundle=new Bundle();
        switch (view.getId()) {
//            点击车队切换到车队页面
            case R.id.qiehuan1:
                MainActivity.Switchfragment(1);
                break;
            case R.id.wdcd_kefu1:
                call("03512340094");
                break;
            case R.id.wdcd_kefudh1:
                call("03512340094");
                break;
            case R.id.wdcd_img5:
                Intent intent = new Intent(context, HYFBActivity.class);
                startActivity(intent);
                break;
            case R.id.wdcd_text5:
                intent = new Intent(context, HYFBActivity.class);
                startActivity(intent);
                break;
            case R.id.wdcd_lin5:
                intent = new Intent(context, HYFBActivity.class);
                startActivity(intent);
                break;
            case R.id.wdcd_img66:
                String num0="0";
                intent = new Intent();
                bundle.putString(INTENTNAME,num0);
                intent.putExtras(bundle);
                intent.setClass(context, WDHYActivity.class);
                startActivity(intent);
                break;
            case R.id.wdcd_text6:
                String num1="0";
                intent = new Intent();
                bundle.putString(INTENTNAME,num1);
                intent.putExtras(bundle);
                intent.setClass(context, WDHYActivity.class);
                startActivity(intent);
                break;
//            case R.id.wdcd_lin6:
//                intent = new Intent(context, WDHYActivity.class);
//                startActivity(intent);
//                break;
            case R.id.wdcd_img77:
                String num2 = "1";
                intent = new Intent();
                bundle.putString(INTENTNAME,num2);
                intent.putExtras(bundle);
                intent.setClass(context, WDHYActivity.class);
                startActivity(intent);
                break;
            case R.id.wdcd_text7:
                String num3 = "1";
                intent = new Intent();
                bundle.putString(INTENTNAME,num3);
                intent.putExtras(bundle);
                intent.setClass(context, WDHYActivity.class);
                startActivity(intent);
                break;
            case R.id.wdcd_lin7:
                break;
        }
    }

    private void call(String phone) {
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phone));
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }
}
