package com.huotongtianxia.huoyuan.ui.WDCD.gen;


import android.os.Handler;

import com.huotongtianxia.huoyuan.bean.GenBean;
import com.huotongtianxia.huoyuan.config.UrlConfig;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Administrator on 2017/4/20 0020.
 */

public class GenPresreter implements GenContract.Presreter{
    private GenContract.Mode mode;
    private GenContract.View view;

    public GenPresreter(GenContract.View view){
        this.view = view;
        this.mode = new GenMode();
    }

    @Override
    public void getData() {
        String app_id = "0";
        String version_id = UrlConfig.GEN;
        String version_mini = UrlConfig.GEN2;
        mode.loadGen(new Callback<GenBean>() {
            @Override
            public void onResponse(Call<GenBean> call, Response<GenBean> response) {
                if (response.isSuccessful()){
                    final GenBean body = response.body();
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
            public void onFailure(Call<GenBean> call, Throwable t) {

            }
        },app_id,version_id,version_mini);
    }
}
