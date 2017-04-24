package com.huotongtianxia.huoyuan.ui.WDCD.fctj;

import android.os.Handler;

import com.huotongtianxia.huoyuan.bean.FCTJBean;
import com.huotongtianxia.huoyuan.ui.WDCD.login.DLActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Administrator on 2017/1/20 0020.
 */

public class FCTJPresreter implements FCTJContract.Presreter{
    private FCTJContract.View view;
    private FCTJContract.Mode mode;

    public FCTJPresreter(FCTJContract.View view){
        this.view = view;
        this.mode = new FCTJMode();
    }

    @Override
    public void getData() {
        String create_time = FCTJActivity.b1;
        String factory_id = DLActivity.id;
        mode.loadFCTJ(new Callback<FCTJBean>() {
            @Override
            public void onResponse(Call<FCTJBean> call, Response<FCTJBean> response) {
                if (response.isSuccessful()){
                    final FCTJBean body = response.body();
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
            public void onFailure(Call<FCTJBean> call, Throwable t) {

            }
        },create_time,factory_id);
    }
}
