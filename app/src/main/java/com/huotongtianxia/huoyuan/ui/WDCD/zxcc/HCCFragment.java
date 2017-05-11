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
import com.huotongtianxia.huoyuan.bean.ZXCCWBean;
import com.huotongtianxia.huoyuan.widget.MyListView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class HCCFragment extends Fragment implements ZXCCWContract.View ,ZXCCView {
    @Bind(R.id.HCC_list)
    MyListView HCCList;
    @Bind(R.id.hcc_preb)
    ProgressBar hccPreb;
    private View view;
    private Context context;
    private List<ZXCCWBean.DataBean> list = new ArrayList<>();
    private ZXCCWAdapter adapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getContext();
        adapter = new ZXCCWAdapter(context, list);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_hcc, container, false);
        ButterKnife.bind(this, view);
        ZXCCWPresreter presreter = new ZXCCWPresreter(this,this,context);
        presreter.getData();
        HCCList.setAdapter(adapter);
        return view;
    }

    @Override
    public void onResponse(ZXCCWBean zxccwBean) {
        adapter.reload(zxccwBean.getData());
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
        hccPreb.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBa() {
        hccPreb.setVisibility(View.GONE);
    }
}
