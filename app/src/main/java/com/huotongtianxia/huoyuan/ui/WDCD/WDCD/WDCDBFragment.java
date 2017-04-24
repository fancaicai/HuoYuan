package com.huotongtianxia.huoyuan.ui.WDCD.WDCD;


import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.huotongtianxia.huoyuan.R;
import com.huotongtianxia.huoyuan.bean.SSCLBean;
import com.huotongtianxia.huoyuan.bean.TJCLBean;
import com.huotongtianxia.huoyuan.bean.WDCDBean;
import com.huotongtianxia.huoyuan.bean.WDCDSCBean;
import com.huotongtianxia.huoyuan.bean.WDCDSCSJBean;
import com.huotongtianxia.huoyuan.ui.WDCD.grzl.GRZLActivity;
import com.huotongtianxia.huoyuan.ui.WDCD.sscl.SSCLAdapter;
import com.huotongtianxia.huoyuan.ui.WDCD.sscl.SSCLContract;
import com.huotongtianxia.huoyuan.ui.WDCD.sscl.SSCLPresreter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class WDCDBFragment extends Fragment implements WDCDContract.View ,SSCLContract.View{
    @Bind(R.id.wdcdb_list)
    ListView wdcdbList;
    @Bind(R.id.wdcdb_edit)
    EditText wdcdbEdit;
    @Bind(R.id.wdcdb_ss)
    ImageView wdcdbSs;
    private List<WDCDBean.DataBean> list = new ArrayList<>();
    private WDCDAdapter adapter;
    private List<SSCLBean.DataBean> list1 = new ArrayList<>();
    private SSCLAdapter adapter1;
    private Context context;
    private String tel;
    private int idd;
    private int iddid = 0;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getContext();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_wdcdb, container, false);
        ButterKnife.bind(this, view);
        WDCDPresreter presreter = new WDCDPresreter(this,idd);
        presreter.getData();
        adapter = new WDCDAdapter(context, list);
        wdcdbList.setAdapter(adapter);
        wdcdbSs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
                iddid = 1;
                list.clear();
                SSCLPresreter presreter = new SSCLPresreter(WDCDBFragment.this,tel,context);
                presreter.getData();
                adapter1 = new SSCLAdapter(context,list1);
                wdcdbList.setAdapter(adapter1);
            }
        });
        wdcdbList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(context, GRZLActivity.class);
                if (iddid == 0){
                    idd = list.get(i).getDriver_id();
                }else if (iddid == 1){
                    idd = list1.get(i).getDriver_id();
                }
                Bundle bundle1 = new Bundle();
                bundle1.putInt("idd",idd);
                intent.putExtras(bundle1);
                startActivity(intent);
            }
        });
        return view;
    }


    public void login() {                                              //登录按钮监听事件
        if (isUserNameAndPwdValid()) {
            tel = wdcdbEdit.getText().toString().trim();    //获取当前输入的用户名和密码信息
        }
    }
    public boolean isUserNameAndPwdValid() {
        if (wdcdbEdit.getText().toString().trim().equals("")) {
            Toast.makeText(context, getString(R.string.sscl), Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    public void onResponse(WDCDBean wdcdBean) {
        adapter.reload(wdcdBean.getData());
    }

    @Override
    public void onResponse1(WDCDBean wdcdBean) {

    }

    @Override
    public void onResponse2(WDCDSCSJBean wdcdBean) {
    }

    @Override
    public void onResponse(SSCLBean ssclBean) {
        adapter1.reload(ssclBean.getData());
    }

    @Override
    public void onResponse1(WDCDSCBean ssclBean) {

    }

    @Override
    public void onResponse(TJCLBean tjclBean) {

    }

    @Override
    public void onFailure(String s) {

    }
}
