package com.huotongtianxia.huoyuan.ui.WDCD.WDCD;

import android.os.Handler;

import com.huotongtianxia.huoyuan.bean.WZBean;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Administrator on 2017/3/31 0031.
 */

public class WZPresreter implements WZContract.Presreter{
    private WZContract.View view;
    private WZContract.Mode mode;
    private int driver_id;

    public WZPresreter(WZContract.View view,int driver_id){
        this.view = view;
        this.mode = new WZMode();
        this.driver_id = driver_id;
    }

    @Override
    public void getData() {
        mode.loadWZ(new Callback<WZBean>() {
            @Override
            public void onResponse(Call<WZBean> call, Response<WZBean> response) {
                if (response.isSuccessful()){
                    final WZBean bofy = response.body();
                    Handler handler = new Handler();
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            view.onResponse(bofy);
                        }
                    });
                }
            }

            @Override
            public void onFailure(Call<WZBean> call, Throwable t) {

            }
        },driver_id);
    }
}
