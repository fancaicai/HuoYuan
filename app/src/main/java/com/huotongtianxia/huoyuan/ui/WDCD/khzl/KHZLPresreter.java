package com.huotongtianxia.huoyuan.ui.WDCD.khzl;


import android.content.Context;
import android.os.Handler;

import com.huotongtianxia.huoyuan.bean.FHRBean;
import com.huotongtianxia.huoyuan.bean.KHZLBean;
import com.huotongtianxia.huoyuan.bean.SHRBean;
import com.huotongtianxia.huoyuan.ui.WDCD.gyszl.GYSZLView;
import com.huotongtianxia.huoyuan.ui.WDCD.login.DLActivity;
import com.huotongtianxia.huoyuan.util.ToastUtil;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Administrator on 2017/2/17 0017.
 */

public class KHZLPresreter implements KHZLContract.Presreter{
    private KHZLContract.View view;
    private KHZLContract.Mode mode;
    private GYSZLView gyszlView;
    Context context;
    public KHZLPresreter (KHZLContract.View view , GYSZLView gyszlView, Context context){
        this.gyszlView=gyszlView;
        this.view = view;
        this.context=context;
        this.mode = new KHZLMode();
    }

    @Override
    public void getData() {
        String factory_id = DLActivity.id;
        gyszlView.showProgressBa();
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
                    gyszlView.hideProgressBa();
                    ToastUtil.showShortToast(context,"数据获取成功！");
                }
            }

            @Override
            public void onFailure(Call<FHRBean> call, Throwable t) {
                gyszlView.hideProgressBa();
                ToastUtil.showShortToast(context,"数据获取失败！");
            }
        },factory_id);
    }

    @Override
    public void getData1() {
        String factory_id = DLActivity.id;
        gyszlView.showProgressBa();
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
                    gyszlView.hideProgressBa();
                    ToastUtil.showShortToast(context,"数据获取成功！");

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
