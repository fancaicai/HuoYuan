package com.huotongtianxia.huoyuan.ui.WDCD.GRZX;


import android.os.Handler;

import com.huotongtianxia.huoyuan.bean.GRZXBean;
import com.huotongtianxia.huoyuan.ui.WDCD.login.DLActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Administrator on 2017/3/8 0008.
 */

public class GRZXPresreter implements GRZXContract.Presreter{
    private GRZXContract.Mode mode;
    private GRZXContract.View view;

    public GRZXPresreter (GRZXContract.View view){
        this.view = view;
        this.mode = new RGZXMode();
    }

    @Override
    public void getData() {
        String uid = DLActivity.id;
        String member_type = DLActivity.membertype;
        mode.loadGRZX(new Callback<GRZXBean>() {
            @Override
            public void onResponse(Call<GRZXBean> call, Response<GRZXBean> response) {
                if (response.isSuccessful()){
                    final GRZXBean body = response.body();
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
            public void onFailure(Call<GRZXBean> call, Throwable t) {

            }
        },uid,member_type);
    }
}
