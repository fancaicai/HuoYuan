package com.huotongtianxia.huoyuan.ui.WDCD.zxcc;

import android.content.Context;
import android.os.Handler;

import com.huotongtianxia.huoyuan.bean.ZXCCBBean;
import com.huotongtianxia.huoyuan.util.LogUtils;
import com.huotongtianxia.huoyuan.util.ToastUtil;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Administrator on 2017/1/17 0017.
 */

public class ZXCCBPresreter implements ZXCCBContract.Presreter{
    private ZXCCBContract.View view;
    private ZXCCBContract.Mode mode;
    private ZXCCView bdcView;
    private Context context;
    public ZXCCBPresreter(ZXCCBContract.View view, ZXCCView bdcView, Context context){
        this.context=context;
        this.bdcView=bdcView;
        this.view = view;
        this.mode = new ZXCCBMode();
    }

    @Override
    public void getData() {
        String locality = "太原市";
        bdcView.showProgressBar();
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
                    bdcView.hideProgressBa();
                    ToastUtil.showShortToast(context,"数据加载成功！");
                }
            }

            @Override
            public void onFailure(Call<ZXCCBBean> call, Throwable t) {
                bdcView.hideProgressBa();
                LogUtils.i("本地车",t.toString());
                ToastUtil.showShortToast(context,"数据加载失败！！！");
            }
        },locality);

    }
}
