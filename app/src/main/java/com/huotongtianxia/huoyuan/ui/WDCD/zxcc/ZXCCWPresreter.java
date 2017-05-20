package com.huotongtianxia.huoyuan.ui.WDCD.zxcc;

import android.content.Context;
import android.os.Handler;

import com.huotongtianxia.huoyuan.MyApplication;
import com.huotongtianxia.huoyuan.bean.ZXCCWBean;
import com.huotongtianxia.huoyuan.util.LogUtils;
import com.huotongtianxia.huoyuan.util.ToastUtil;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Administrator on 2017/1/17 0017.
 */

public class ZXCCWPresreter implements ZXCCWContract.Presreter{
    private ZXCCWContract.View view;
    private ZXCCWContract.Mode mode;
    private ZXCCView zxccView;
    private Context context;
    public ZXCCWPresreter(ZXCCWContract.View view, ZXCCView zxccView, Context context){
        this.zxccView=zxccView;
        this.context=context;
        this.view = view;
        this.mode = new ZXCCWMode();
    }

    @Override
    public void getData() {
        String locality = MyApplication.city;
        //LogUtils.i("回程车定位0", ""+MyApplication.city);
        zxccView.showProgressBar();
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
                    zxccView.hideProgressBa();
                    ToastUtil.showShortToast(context,"数据加载成功");
                }
            }

            @Override
            public void onFailure(Call<ZXCCWBean> call, Throwable t) {
                zxccView.hideProgressBa();
                LogUtils.i("回程车",t.toString());
                ToastUtil.showShortToast(context,"数据加载失败");
            }
        },locality);
        //LogUtils.i("回程车定位",locality);
    }
}
