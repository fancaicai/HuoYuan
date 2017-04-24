package com.huotongtianxia.huoyuan.ui.WDCD.ddxq;

import android.os.Handler;

import com.huotongtianxia.huoyuan.bean.PJBean;
import com.huotongtianxia.huoyuan.ui.WDCD.login.DLActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Administrator on 2017/3/28 0028.
 */

public class PJPresreter implements PJContract.Presreter{
    private PJContract.View view;
    private PJContract.Mode mode;
    private String num;
    private int estimate;

    public PJPresreter(PJContract.View view,String num,int estimate){
        this.view = view;
        this.mode = new PJMode();
        this.num = num;
        this.estimate = estimate;
    }

    @Override
    public void getData() {
        String uid = DLActivity.id;
        String order_num = num;
        int estimate_id = estimate;
        mode.loadPJ(new Callback<PJBean>() {
            @Override
            public void onResponse(Call<PJBean> call, Response<PJBean> response) {
                if (response.isSuccessful()){
                    final PJBean body = response.body();
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
            public void onFailure(Call<PJBean> call, Throwable t) {

            }
        },uid,estimate_id,order_num);
    }
}
