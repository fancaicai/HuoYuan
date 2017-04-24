package com.huotongtianxia.huoyuan.ui.WDCD.clrz;

import com.huotongtianxia.huoyuan.bean.CLRZBean;
import com.huotongtianxia.huoyuan.bean.SJRZ1Bean;
import com.huotongtianxia.huoyuan.http.HttpUtils;

import okhttp3.RequestBody;
import retrofit2.Callback;

/**
 * Created by Administrator on 2017/1/16 0016.
 */

public class CLRZMode implements CLRZContract.Mode{
    @Override
    public void loadCLRZ(Callback<CLRZBean> callback, String id, RequestBody id_card_a, RequestBody id_card_b, RequestBody drive_card_a, RequestBody drive_card_b) {
        HttpUtils.newInstance().loadCLRZBean(callback,id,id_card_a,id_card_b,drive_card_a,drive_card_b);
    }

    @Override
    public void loadSJRZ1(Callback<SJRZ1Bean> callback, String factory_id, String name, String tel, String plate_number, String weight, String length, String type, String advantage_way, String register_place) {
        HttpUtils.newInstance().loadSJRZ1Bean(callback,factory_id,name,tel,plate_number,weight,length,type,advantage_way,register_place);
    }
}
