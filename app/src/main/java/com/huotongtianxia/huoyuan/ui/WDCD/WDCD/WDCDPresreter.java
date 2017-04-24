package com.huotongtianxia.huoyuan.ui.WDCD.WDCD;

import android.os.Handler;
import android.util.Log;

import com.huotongtianxia.huoyuan.bean.WDCD1Bean;
import com.huotongtianxia.huoyuan.bean.WDCD2Bean;
import com.huotongtianxia.huoyuan.bean.WDCDBean;
import com.huotongtianxia.huoyuan.bean.WDCDSCSJBean;
import com.huotongtianxia.huoyuan.config.UrlConfig;
import com.huotongtianxia.huoyuan.ui.WDCD.login.DLActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Administrator on 2017/1/18 0018.
 */

public class WDCDPresreter implements WDCDContract.Presreter{
    private WDCDContract.View view;
    private WDCDContract.Mode mode;
    private int idd;

    public WDCDPresreter (WDCDContract.View view,int idd){
        this.view = view;
        this.mode = new WDCDMode();
        this.idd = idd;
    }

    @Override
    public void getData() {
        String factory_id = DLActivity.id;
        mode.loadWDCD(new Callback<WDCDBean>() {
            @Override
            public void onResponse(Call<WDCDBean> call, Response<WDCDBean> response) {
                if (response.isSuccessful()){
                    final WDCDBean body = response.body();
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
            public void onFailure(Call<WDCDBean> call, Throwable t) {
            }
        },factory_id);
    }

    @Override
    public void getData1() {
        String factory_id = DLActivity.id;
        String locality = UrlConfig.city;
        mode.loadWDCD1(new Callback<WDCDBean>() {
            @Override
            public void onResponse(Call<WDCDBean> call, Response<WDCDBean> response) {
                if (response.isSuccessful()){
                    final WDCDBean body = response.body();
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
            public void onFailure(Call<WDCDBean> call, Throwable t) {

            }
        },factory_id,locality);
    }

    @Override
    public void getData2() {
        String driver_id = String.valueOf(idd);
        String factory_id = DLActivity.id;
        Log.i("asd", "getData2: ============"+driver_id);
        mode.loadWDCD2(new Callback<WDCDSCSJBean>() {
            @Override
            public void onResponse(Call<WDCDSCSJBean> call, Response<WDCDSCSJBean> response) {
                if (response.isSuccessful()){
                    final WDCDSCSJBean body = response.body();
                    Handler handler = new Handler();
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            view.onResponse2(body);
                        }
                    });
                }
            }

            @Override
            public void onFailure(Call<WDCDSCSJBean> call, Throwable t) {

            }
        },driver_id,factory_id);
    }


}
