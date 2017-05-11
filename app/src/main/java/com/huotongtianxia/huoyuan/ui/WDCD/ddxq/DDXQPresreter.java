package com.huotongtianxia.huoyuan.ui.WDCD.ddxq;

import android.content.Context;
import android.os.Handler;

import com.huotongtianxia.huoyuan.bean.DDXQBean;
import com.huotongtianxia.huoyuan.bean.QRSHBean;
import com.huotongtianxia.huoyuan.ui.WDCD.login.DLActivity;
import com.huotongtianxia.huoyuan.util.ToastUtil;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Administrator on 2017/3/27 0027.
 */

public class DDXQPresreter implements DDXQContract.Presreter{
    private DDXQContract.Mode mode;
    private DDXQContract.View view;
    private String num;
    private DDXQView ddxqView;
    private Context context;
    public DDXQPresreter(DDXQContract.View view,String num,DDXQView ddxqView,Context context){
        this.context=context;
        this.ddxqView=ddxqView;
        this.view = view;
        this.mode = new DDXQMode();
        this.num = num;
    }

    @Override
    public void getData() {
        String order_num = num;
        ddxqView.showProgressBa();
        mode.loadDDXQ(new Callback<DDXQBean>() {
            @Override
            public void onResponse(Call<DDXQBean> call, Response<DDXQBean> response) {

                if (response.isSuccessful()){
                    final DDXQBean body = response.body();
                    Handler handler = new Handler();
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            view.onResponse(body);
                        }
                    });
                    ddxqView.hideProgressBa();
                    ToastUtil.showShortToast(context,"数据获取成功");
                }
            }

            @Override
            public void onFailure(Call<DDXQBean> call, Throwable t) {
                ddxqView.hideProgressBa();
                ToastUtil.showShortToast(context,"数据获取失败");
            }
        },order_num);
    }

    @Override
    public void getData1() {
        String uid = DLActivity.id;
        String order_num = num;
        String yun_status = "2";
        mode.loadQRSH(new Callback<QRSHBean>() {
            @Override
            public void onResponse(Call<QRSHBean> call, Response<QRSHBean> response) {
                if (response.isSuccessful()){
                    final QRSHBean body = response.body();
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
            public void onFailure(Call<QRSHBean> call, Throwable t) {

            }
        },uid,order_num,yun_status);
    }
}
