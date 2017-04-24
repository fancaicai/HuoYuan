package com.huotongtianxia.huoyuan.ui.WDCD.WDCD;


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
public class WDCDQFragment extends Fragment implements WDCDContract.View ,SSCLContract.View{
    @Bind(R.id.wdcdq_list)
    ListView wdcdqList;
    @Bind(R.id.wdcdq_edit)
    EditText wdcdqEdit;
    @Bind(R.id.wdcdq_ss)
    ImageView wdcdqSs;
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
        View view = inflater.inflate(R.layout.fragment_wdcdq, container, false);
        ButterKnife.bind(this, view);
        list1.clear();
        WDCDPresreter presreter = new WDCDPresreter(WDCDQFragment.this,idd);
        presreter.getData1();
        adapter = new WDCDAdapter(context, list);
        wdcdqList.setAdapter(adapter);
        wdcdqSs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iddid = 1;
                login();
                list.clear();
                SSCLPresreter presreter = new SSCLPresreter(WDCDQFragment.this,tel,context);
                presreter.getData();
                adapter1 = new SSCLAdapter(context,list1);
                wdcdqList.setAdapter(adapter1);
            }
        });
        wdcdqList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(context, GRZLActivity.class);
                Log.i("asd", "onItemClick: ========"+iddid);
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
        wdcdqList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (iddid == 0){
                    idd = list.get(i).getDriver_id();
                }else if (iddid == 1){
                    idd = list1.get(i).getDriver_id();
                }
                dialog();
                return true;
            }
        });
        return view;
    }

    protected void dialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage("确认删除吗");
        builder.setTitle("提示");
        builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                WDCDPresreter presreter = new WDCDPresreter(WDCDQFragment.this,idd);
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

    public void login() {                                              //登录按钮监听事件
        if (isUserNameAndPwdValid()) {
            tel = wdcdqEdit.getText().toString().trim();    //获取当前输入的用户名和密码信息
        }
    }

    public boolean isUserNameAndPwdValid() {
        if (wdcdqEdit.getText().toString().trim().equals("")) {
            Toast.makeText(context, getString(R.string.sscl), Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    @Override
    public void onResponse(WDCDBean wdcdBean) {

    }

    @Override
    public void onResponse1(WDCDBean wdcdBean) {
        adapter.reload(wdcdBean.getData());
    }

    @Override
    public void onResponse2(WDCDSCSJBean wdcdBean) {
        if (iddid == 0){
            list.clear();
            WDCDPresreter presreter = new WDCDPresreter(WDCDQFragment.this,idd);
            presreter.getData();
        }else if (iddid == 1){
            list1.clear();
            WDCDPresreter presreter = new WDCDPresreter(WDCDQFragment.this,idd);
            presreter.getData1();
        }


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

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
