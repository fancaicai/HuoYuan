package com.huotongtianxia.huoyuan.ui.WDCD.clrz;

import android.os.Handler;

import com.huotongtianxia.huoyuan.bean.CLRZBean;
import com.huotongtianxia.huoyuan.bean.SJRZ1Bean;
import com.huotongtianxia.huoyuan.ui.WDCD.login.DLActivity;

import java.io.File;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Administrator on 2017/2/21 0021.
 */

public class CLRZPresreter implements CLRZContract.Presreter{
    private CLRZContract.View view;
    private CLRZContract.Mode mode;
    private File w1,w2,w3,w4;
    private String truck_type,truck_length,truck_cp,namee,tell,cph,cz,cit,provinc2,cit2,id;

    public CLRZPresreter (CLRZContract.View view,File w1,File w2,File w3,File w4,String truck_type,String truck_length,String truck_cp,String namee,String tell,String cph,String cz,String cit,String provinc2,String cit2,String id){
        this.view = view;
        this.mode = new CLRZMode();
        this.w1 = w1;
        this.w2 = w2;
        this.w3 = w3;
        this.w4 = w4;
        this.truck_type = truck_type;
        this.truck_length = truck_length;
        this.truck_cp = truck_cp;
        this.namee = namee;
        this.tell = tell;
        this.cph = cph;
        this.cz = cz;
        this.cit = cit;
        this.provinc2 = provinc2;
        this.cit2 = cit2;
        this.id = id;
    }

    @Override
    public void getData() {
        RequestBody id_card_a = RequestBody.create(MediaType.parse("multipart/form-data"), w1);
        RequestBody id_card_b = RequestBody.create(MediaType.parse("multipart/form-data"), w2);
        RequestBody drive_card_a = RequestBody.create(MediaType.parse("multipart/form-data"), w3);
        RequestBody drive_card_b = RequestBody.create(MediaType.parse("multipart/form-data"), w4);
        mode.loadCLRZ(new Callback<CLRZBean>() {
            @Override
            public void onResponse(Call<CLRZBean> call, Response<CLRZBean> response) {
                if (response.isSuccessful()){
                    final CLRZBean body = response.body();
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
            public void onFailure(Call<CLRZBean> call, Throwable t) {

            }
        },id,id_card_a,id_card_b,drive_card_a,drive_card_b);
    }

    @Override
    public void getData1() {
        String factory_id = DLActivity.id;
        String name = namee;
        String tel = tell;
        String plate_number = truck_cp+cph;
        String weight = cz;
        String length = truck_length;
        String type = truck_type;
        String advantage_way = provinc2 + "省" + cit2 + "市";
        String register_place = cit+"市";
        mode.loadSJRZ1(new Callback<SJRZ1Bean>() {
            @Override
            public void onResponse(Call<SJRZ1Bean> call, Response<SJRZ1Bean> response) {
                if (response.isSuccessful()){
                    final SJRZ1Bean body = response.body();
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
            public void onFailure(Call<SJRZ1Bean> call, Throwable t) {

            }
        },factory_id,name,tel,plate_number,weight,length,type,advantage_way,register_place);
    }
}
