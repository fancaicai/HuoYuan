package com.huotongtianxia.huoyuan.ui.WDCD.wdhy;


import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
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
public class DJDFragment extends Fragment implements WDHYContract.View {
    @Bind(R.id.djd_list)
    ListView djdList;
    private Context context;
    private View view;
    private int status1 = 0;
    private List<WDHYBBean.DataBean> list = new ArrayList<>();
    private WDHYBAdapter adapter;
    private String id;
    private String order_num;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getContext();
        adapter = new WDHYBAdapter(context,list);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_djd, container, false);
        list.clear();
        WDHYPresreter presreter = new WDHYPresreter(this, status1,id,order_num);
        presreter.getData1();
        ButterKnife.bind(this, view);
        djdList.setAdapter(adapter);
        djdList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                id = list.get(i).getId();
                dialog();
                return true;
            }
        });
        return view;
    }

    protected void dialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage("确认删除吗");
        builder.setTitle("提示");
        builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                WDHYPresreter presreter = new WDHYPresreter(DJDFragment.this,status1,id,order_num);
                presreter.getData2();
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

    }

    @Override
    public void onResponse1(WDHYBBean wdhyBBean) {

        adapter.reload(wdhyBBean.getData());
        Log.e("11111111111111",wdhyBBean.getData()+"");
    }

    @Override
    public void onResponse2(WDHYQXBean wdhyqxBean) {
        int code = wdhyqxBean.getCode();
        if (code == 100){
            list.clear();
            WDHYPresreter presreter = new WDHYPresreter(this, status1,id,order_num);
            presreter.getData1();
        }
    }

    @Override
    public void onResponse3(WDHYSCBean wdhyscBean) {

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
