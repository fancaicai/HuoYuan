package com.huotongtianxia.huoyuan.ui.WDCD.zxcc;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.huotongtianxia.huoyuan.R;
import com.huotongtianxia.huoyuan.bean.ZXCCBBean;
import com.huotongtianxia.huoyuan.widget.MyListView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class BDCFragment extends Fragment implements ZXCCBContract.View, ZXCCView {
    @Bind(R.id.bdc_list)
    MyListView bdcList;
    @Bind(R.id.bdc_preb)
    ProgressBar bdcPreb;
    private View view;
    private Context context;
    private List<ZXCCBBean.DataBean> list = new ArrayList<>();
    private ZXCCBAdapter adapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getContext();
        adapter = new ZXCCBAdapter(context, list);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_bdc, container, false);
        ButterKnife.bind(this, view);
        ZXCCBPresreter presreter = new ZXCCBPresreter(this, this, context);
        presreter.getData();
        bdcList.setAdapter(adapter);
        return view;

    }

    @Override
    public void onResponse(ZXCCBBean zxccbBean) {
        adapter.reload(zxccbBean.getData());
    }

    @Override
    public void onFailure(String s) {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    public void showProgressBar() {
        bdcPreb.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBa() {
        bdcPreb.setVisibility(View.GONE);
    }
}
