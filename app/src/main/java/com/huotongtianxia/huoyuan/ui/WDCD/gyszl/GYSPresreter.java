package com.huotongtianxia.huoyuan.ui.WDCD.gyszl;

import android.os.Handler;

import com.huotongtianxia.huoyuan.bean.GYSBean;
import com.huotongtianxia.huoyuan.ui.WDCD.login.DLActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Administrator on 2017/1/17 0017.
 */

public class GYSPresreter implements GYSContract.Presreter{
    private GYSContract.View view;
    private GYSContract.Mode mode;

    public GYSPresreter(GYSContract.View view){
        this.view = view;
        this.mode = new GYSZMode();
    }

    @Override
    public void getData() {
        String uid = DLActivity.id;
        String member_type = DLActivity.membertype;
        mode.loadGYS(new Callback<GYSBean>() {
            @Override
            public void onResponse(Call<GYSBean> call, Response<GYSBean> response) {
                if (response.isSuccessful()){
                    final GYSBean body = response.body();
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
            public void onFailure(Call<GYSBean> call, Throwable t) {

            }
        },uid,member_type);
    }

}
