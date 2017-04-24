package com.huotongtianxia.huoyuan.ui.WDCD.khzl;


import android.os.Handler;

import com.huotongtianxia.huoyuan.bean.FHRBean;
import com.huotongtianxia.huoyuan.bean.KHZLBean;
import com.huotongtianxia.huoyuan.bean.SHRBean;
import com.huotongtianxia.huoyuan.ui.WDCD.login.DLActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Administrator on 2017/2/17 0017.
 */

public class KHZLPresreter implements KHZLContract.Presreter{
    private KHZLContract.View view;
    private KHZLContract.Mode mode;

    public KHZLPresreter (KHZLContract.View view ){
        this.view = view;
        this.mode = new KHZLMode();
    }

    @Override
    public void getData() {
        String factory_id = DLActivity.id;
        mode.loadFHR(new Callback<FHRBean>() {
            @Override
            public void onResponse(Call<FHRBean> call, Response<FHRBean> response) {
                if (response.isSuccessful()){
                    final FHRBean body = response.body();
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
            public void onFailure(Call<FHRBean> call, Throwable t) {

            }
        },factory_id);
    }

    @Override
    public void getData1() {
        String factory_id = DLActivity.id;
        mode.loadSHR(new Callback<SHRBean>() {
            @Override
            public void onResponse(Call<SHRBean> call, Response<SHRBean> response) {
                if (response.isSuccessful()){
                    final SHRBean body = response.body();
                    Handler handler = new Handler();
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            view.onResponse1(body);
                        }
                    });
                }
            }

            @Override
            public void onFailure(Call<SHRBean> call, Throwable t) {

            }
        },factory_id);
    }

    @Override
    public void getData2() {

    }
}
