package com.huotongtianxia.huoyuan.ui.WDCD.WDCD;

import android.content.Context;
import android.os.Handler;
import android.util.Log;

import com.huotongtianxia.huoyuan.bean.WDCD1Bean;
import com.huotongtianxia.huoyuan.bean.WDCD2Bean;
import com.huotongtianxia.huoyuan.bean.WDCDBean;
import com.huotongtianxia.huoyuan.bean.WDCDSCSJBean;
import com.huotongtianxia.huoyuan.config.UrlConfig;
import com.huotongtianxia.huoyuan.ui.WDCD.login.DLActivity;
import com.huotongtianxia.huoyuan.util.ToastUtil;

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
    private  WDCDView wdcdView;
    private Context context;
    public WDCDPresreter(WDCDContract.View view, int idd, WDCDView wdcdView, Context context){
        this.context=context;
        this.wdcdView=wdcdView;
        this.view = view;
        this.mode = new WDCDMode();
        this.idd = idd;
    }

    @Override
    public void getData() {
        String factory_id = DLActivity.id;
        wdcdView.showProgressBa();
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
                    wdcdView.hideProgressBa();
//                    ToastUtil.showShortToast(context,"数据获取成功");
                }
            }

            @Override
            public void onFailure(Call<WDCDBean> call, Throwable t) {
                wdcdView.hideProgressBa();
//                ToastUtil.showShortToast(context,"数据获取失败");
            }
        },factory_id);
    }

    @Override
    public void getData1() {
        String factory_id = DLActivity.id;
        String locality = UrlConfig.city;
        wdcdView.showProgressBa();
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
                    wdcdView.hideProgressBa();
//                    ToastUtil.showShortToast(context,"数据获取成功");
                }
            }

            @Override
            public void onFailure(Call<WDCDBean> call, Throwable t) {
                wdcdView.hideProgressBa();
//                ToastUtil.showShortToast(context,"数据获取失败");
            }
        },factory_id,locality);
    }

    @Override
    public void getData2() {
        String driver_id = String.valueOf(idd);
        String factory_id = DLActivity.id;
        wdcdView.showProgressBa();
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
                    wdcdView.hideProgressBa();
//                    ToastUtil.showShortToast(context,"数据获取成功");
                }
            }

            @Override
            public void onFailure(Call<WDCDSCSJBean> call, Throwable t) {
                wdcdView.hideProgressBa();
//                ToastUtil.showShortToast(context,"数据获取失败");
            }
        },driver_id,factory_id);
    }


}
