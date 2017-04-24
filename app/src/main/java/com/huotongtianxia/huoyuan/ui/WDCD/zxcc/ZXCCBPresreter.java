package com.huotongtianxia.huoyuan.ui.WDCD.zxcc;

import android.os.Handler;

import com.huotongtianxia.huoyuan.bean.ZXCCBBean;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Administrator on 2017/1/17 0017.
 */

public class ZXCCBPresreter implements ZXCCBContract.Presreter{
    private ZXCCBContract.View view;
    private ZXCCBContract.Mode mode;

    public ZXCCBPresreter(ZXCCBContract.View view){
        this.view = view;
        this.mode = new ZXCCBMode();
    }

    @Override
    public void getData() {
        String locality = "太原市";
        mode.loadZXCCB(new Callback<ZXCCBBean>() {
            @Override
            public void onResponse(Call<ZXCCBBean> call, Response<ZXCCBBean> response) {
                if (response.isSuccessful()){
                    final ZXCCBBean body = response.body();
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
            public void onFailure(Call<ZXCCBBean> call, Throwable t) {

            }
        },locality);

    }
}
