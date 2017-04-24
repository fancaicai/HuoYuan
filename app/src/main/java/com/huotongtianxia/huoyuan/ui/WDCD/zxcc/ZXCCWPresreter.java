package com.huotongtianxia.huoyuan.ui.WDCD.zxcc;

import android.os.Handler;

import com.huotongtianxia.huoyuan.bean.ZXCCWBean;
import com.huotongtianxia.huoyuan.config.UrlConfig;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Administrator on 2017/1/17 0017.
 */

public class ZXCCWPresreter implements ZXCCWContract.Presreter{
    private ZXCCWContract.View view;
    private ZXCCWContract.Mode mode;

    public ZXCCWPresreter(ZXCCWContract.View view){
        this.view = view;
        this.mode = new ZXCCWMode();
    }

    @Override
    public void getData() {
        String locality = UrlConfig.city;
        mode.loadZXCCW(new Callback<ZXCCWBean>() {
            @Override
            public void onResponse(Call<ZXCCWBean> call, Response<ZXCCWBean> response) {
                if (response.isSuccessful()){
                    final ZXCCWBean body = response.body();
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
            public void onFailure(Call<ZXCCWBean> call, Throwable t) {

            }
        },locality);
    }
}
