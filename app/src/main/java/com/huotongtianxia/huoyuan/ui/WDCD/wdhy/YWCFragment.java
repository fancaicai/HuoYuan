package com.huotongtianxia.huoyuan.ui.WDCD.wdhy;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.huotongtianxia.huoyuan.R;
import com.huotongtianxia.huoyuan.bean.WDHYBBean;
import com.huotongtianxia.huoyuan.bean.WDHYBean;
import com.huotongtianxia.huoyuan.bean.WDHYQXBean;
import com.huotongtianxia.huoyuan.bean.WDHYSCBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class YWCFragment extends Fragment implements WDHYContract.View {
    @Bind(R.id.ysz_ywc)
    ListView yszYwc;
    private Context context;
    private View view;
    private int status1 = 2;
    private List<WDHYBean.DataBean> list = new ArrayList<>();
    private WDHYAdapter adapter;
    private String id;
    private String order_num;
    private Activity activity;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getContext();
        activity = getActivity();
        adapter = new WDHYAdapter(context, list, status1);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_ywc, container, false);
        ButterKnife.bind(this, view);
        initView();
        yszYwc.setAdapter(adapter);
        yszYwc.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                order_num = list.get(i).getOrder_num();
                dialog();
                return true;
            }
        });
        return view;
    }

    public void initView(){
        list.clear();
        WDHYPresreter presreter = new WDHYPresreter(this, status1,id,order_num);
        presreter.getData();
    }

    protected void dialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage("确认删除吗");
        builder.setTitle("提示");
        builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                WDHYPresreter presreter = new WDHYPresreter(YWCFragment.this,status1,id,order_num);
                presreter.getData3();
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

    @Override
    public void onResponse(WDHYBean wdhyBean) {
        adapter.reload(wdhyBean.getData());
    }

    @Override
    public void onResponse1(WDHYBBean wdhyBBean) {

    }

    @Override
    public void onResponse2(WDHYQXBean wdhyqxBean) {

    }

    @Override
    public void onResponse3(WDHYSCBean wdhyscBean) {
        int code = wdhyscBean.getCode();
        if (code == 100){
            activity.finish();
        }
    }

    @Override
    public void onFailure(String s) {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
