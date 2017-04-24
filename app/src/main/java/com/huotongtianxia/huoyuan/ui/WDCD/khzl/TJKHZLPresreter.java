package com.huotongtianxia.huoyuan.ui.WDCD.khzl;

import android.os.Handler;

import com.huotongtianxia.huoyuan.bean.TJKHZLBean;
import com.huotongtianxia.huoyuan.ui.WDCD.login.DLActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Administrator on 2017/2/20 0020.
 */

public class TJKHZLPresreter implements TJKHZLContract.Presreter{
    private TJKHZLContract.View view;
    private TJKHZLContract.Mode mode;
    private String a1,a2,a3,a5,provinc,cit;

    public TJKHZLPresreter (TJKHZLContract.View view ,String a1 , String a2 , String a3,String a5,String provinc ,String cit){
        this.view = view;
        this.mode = new TJKHZLMode();
        this.a1 = a1;
        this.a2 = a2;
        this.a3 = a3;
        this.a5 = a5;
        this.provinc = provinc;
        this.cit = cit;
    }


    @Override
    public void getData() {
        String uid = DLActivity.id;
        String member_type = DLActivity.membertype;
        String company_name = a1;
        String contacts = a2;
        String tel = a3;
        String province = provinc;
        String city = cit;
        String address = a5;
        mode.loadTJKHZL(new Callback<TJKHZLBean>() {
            @Override
            public void onResponse(Call<TJKHZLBean> call, Response<TJKHZLBean> response) {
                if (response.isSuccessful()){
                    final TJKHZLBean body = response.body();
                    Handler handler = new Handler();
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            view.onResponse(body);
                        }
                    });
                }
            }

            @Override
            public void onFailure(Call<TJKHZLBean> call, Throwable t) {

            }
        },uid,member_type,company_name,contacts,tel,province,city,address);
    }
}
