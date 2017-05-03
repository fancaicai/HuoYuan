package com.huotongtianxia.huoyuan.ui.WDCD.ddgz;

import android.os.Handler;

import com.huotongtianxia.huoyuan.bean.SJLIDWBean;
import com.huotongtianxia.huoyuan.http.HttpUtils;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Administrator on 2017/4/26 0026.
 */
//获取订单跟踪数据的业务类
public class DdgzPresreter {
   private DdgzView mDdgzView;
public DdgzPresreter (DdgzView ddgzView){
    this.mDdgzView=ddgzView;
}
    // 获取司机的经纬度信息
    public void getSJlocation(String drivertel){
        HttpUtils.newInstance().getTreasureApi().getSJLSDW(drivertel).enqueue(new Callback<SJLIDWBean>() {
            @Override
            public void onResponse(Call<SJLIDWBean> call, final Response<SJLIDWBean> response) {
                if (response.isSuccessful()) {
                    final SJLIDWBean body = response.body();
                    Handler handler=new Handler();
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            mDdgzView.setData(body);
                        }
                    });

                }
            }

            @Override
            public void onFailure(Call<SJLIDWBean> call, Throwable t) {

            }
        });

    }
}
