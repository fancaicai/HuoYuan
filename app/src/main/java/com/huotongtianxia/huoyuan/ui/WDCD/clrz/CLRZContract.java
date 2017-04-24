package com.huotongtianxia.huoyuan.ui.WDCD.clrz;

import com.huotongtianxia.huoyuan.base.IBaseMode;
import com.huotongtianxia.huoyuan.base.IBasePresenter;
import com.huotongtianxia.huoyuan.base.IBaseView;
import com.huotongtianxia.huoyuan.bean.CLRZBean;
import com.huotongtianxia.huoyuan.bean.SJRZ1Bean;

import okhttp3.RequestBody;
import retrofit2.Callback;

/**
 * Created by Administrator on 2017/2/21 0021.
 */

public class CLRZContract {
    public interface View extends IBaseView {
        void onResponse(CLRZBean clrzBean);
        void onResponse1(SJRZ1Bean clrzBean);
        void onFailure(String  s);
    }

    public interface Mode extends IBaseMode {
        void  loadCLRZ(Callback<CLRZBean> callback, String id, RequestBody id_card_a, RequestBody id_card_b, RequestBody drive_card_a, RequestBody drive_card_b);
        void  loadSJRZ1(Callback<SJRZ1Bean> callback, String factory_id, String name, String tel, String plate_number, String weight, String length, String type, String advantage_way,String register_place);
    }

    public interface Presreter extends IBasePresenter {
        void getData();
        void getData1();
    }
}
