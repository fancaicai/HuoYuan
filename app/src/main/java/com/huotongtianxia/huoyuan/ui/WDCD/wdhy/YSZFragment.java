package com.huotongtianxia.huoyuan.ui.WDCD.wdhy;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
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
import com.huotongtianxia.huoyuan.ui.WDCD.WDCD.WDCDActivity;
import com.huotongtianxia.huoyuan.ui.WDCD.ddxq.DDXQActivity;
import com.huotongtianxia.huoyuan.ui.WDCD.grzl.GRZLActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class YSZFragment extends Fragment implements WDHYContract.View {
    @Bind(R.id.ysz_list)
    ListView yszList;
    private Context context;
    private View view;
    private int status1 = 1;
    private List<WDHYBean.DataBean> list = new ArrayList<>();
    private WDHYAdapter adapter;
    private String num;
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
        view = inflater.inflate(R.layout.fragment_ysz, container, false);
        list.clear();
        WDHYPresreter presreter = new WDHYPresreter(this, status1,id,order_num);
        presreter.getData();
        ButterKnife.bind(this, view);
        yszList.setAdapter(adapter);
        yszList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(context, DDXQActivity.class);
                num = list.get(i).getOrder_num();
                Bundle bundle1 = new Bundle();
                bundle1.putString("num",num);
                intent.putExtras(bundle1);
                activity.finish();
                startActivity(intent);

            }
        });
        return view;
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
