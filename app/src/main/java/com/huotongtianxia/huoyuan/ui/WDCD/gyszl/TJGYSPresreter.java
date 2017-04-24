package com.huotongtianxia.huoyuan.ui.WDCD.gyszl;

import android.os.Handler;

import com.huotongtianxia.huoyuan.bean.TJGYSBean;
import com.huotongtianxia.huoyuan.ui.WDCD.login.DLActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Administrator on 2017/2/28 0028.
 */

public class TJGYSPresreter implements TJGYSContract.Presreter{
    private TJGYSContract.View view;
    private TJGYSContract.Mode mode;
    private String tjgyszl1,tjgyszl2,tjgyszl3,tjgyszl4;


    public TJGYSPresreter(TJGYSContract.View view,String tjgyszl1,String tjgyszl2,String tjgyszl3,String tjgyszl4){
        this.view = view;
        this.mode = new TJGYSMode();
        this.tjgyszl1 = tjgyszl1;
        this.tjgyszl2 = tjgyszl2;
        this.tjgyszl3 = tjgyszl3;
        this.tjgyszl4 = tjgyszl4;
    }


    @Override
    public void getData() {
        String uid = DLActivity.id;
        String member_type = DLActivity.membertype;
        String name = tjgyszl1;
        String head = tjgyszl2;
        String tel = tjgyszl3;
        String address = tjgyszl4;
        mode.loadTJGYS(new Callback<TJGYSBean>() {
            @Override
            public void onResponse(Call<TJGYSBean> call, Response<TJGYSBean> response) {
                if (response.isSuccessful()){
                    final TJGYSBean body = response.body();
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
            public void onFailure(Call<TJGYSBean> call, Throwable t) {

            }
        },uid,member_type,name,head,tel,address);
    }
}
