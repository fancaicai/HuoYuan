package com.huotongtianxia.huoyuan.ui.WDCD.zxcc;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
public class HCCFragment extends Fragment implements ZXCCWContract.View {
    @Bind(R.id.HCC_list)
    MyListView HCCList;
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
        ZXCCWPresreter presreter = new ZXCCWPresreter(this);
        presreter.getData();
        ButterKnife.bind(this, view);
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
}
