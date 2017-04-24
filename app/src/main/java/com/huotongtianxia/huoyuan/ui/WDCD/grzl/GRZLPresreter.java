package com.huotongtianxia.huoyuan.ui.WDCD.grzl;

import android.os.Handler;

import com.huotongtianxia.huoyuan.bean.GRZLBean;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Administrator on 2017/1/20 0020.
 */

public class GRZLPresreter implements GRZLContract.Presreter{
    private GRZLContract.View view;
    private GRZLContract.Mode mode;
    private int idd;

    public GRZLPresreter (GRZLContract.View view,int idd){
        this.view = view;
        this.mode = new GRZLMode();
        this.idd = idd;
    }

    @Override
    public void getData() {
        int driver_id = idd;
        mode.loadGRZL(new Callback<GRZLBean>() {
            @Override
            public void onResponse(Call<GRZLBean> call, Response<GRZLBean> response) {
                if (response.isSuccessful()){
                    final GRZLBean body = response.body();
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
            public void onFailure(Call<GRZLBean> call, Throwable t) {

            }
        },driver_id);
    }
}
