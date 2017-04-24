package com.huotongtianxia.huoyuan.ui.WDCD.gszl;

import android.os.Handler;

import com.huotongtianxia.huoyuan.bean.GSZLBean;
import com.huotongtianxia.huoyuan.ui.WDCD.login.DLActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Administrator on 2017/1/20 0020.
 */

public class GSZLPresreter implements GSZLContract.Presreter{
    private GSZLContract.View view;
    private GSZLContract.Mode mode;


    public GSZLPresreter (GSZLContract.View view ){
        this.view = view;
        this.mode = new GSZLMode();
    }

    @Override
    public void getData() {
        String factory_id = DLActivity.id;
        mode.loadGSZL(new Callback<GSZLBean>() {
            @Override
            public void onResponse(Call<GSZLBean> call, Response<GSZLBean> response) {
                if (response.isSuccessful()){
                    final GSZLBean body = response.body();
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
            public void onFailure(Call<GSZLBean> call, Throwable t) {

            }
        },factory_id);
    }

}
