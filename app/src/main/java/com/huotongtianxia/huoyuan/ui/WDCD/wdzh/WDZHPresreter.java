package com.huotongtianxia.huoyuan.ui.WDCD.wdzh;

import android.os.Handler;

import com.huotongtianxia.huoyuan.bean.WDZHBean;
import com.huotongtianxia.huoyuan.ui.WDCD.login.DLActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Administrator on 2017/1/20 0020.
 */

public class WDZHPresreter implements WDZHContract.Presreter{
    private WDZHContract.View view;
    private WDZHContract.Mode mode;

    public WDZHPresreter (WDZHContract.View view){
        this.view = view;
        this.mode = new WDZHMode();
    }

    @Override
    public void getData() {
        String factory_id = DLActivity.id;
        mode.loadWDZH(new Callback<WDZHBean>() {
            @Override
            public void onResponse(Call<WDZHBean> call, Response<WDZHBean> response) {
                if (response.isSuccessful()){
                    final WDZHBean body = response.body();
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
            public void onFailure(Call<WDZHBean> call, Throwable t) {

            }
        },factory_id);
    }
}
