package com.huotongtianxia.huoyuan.ui.WDCD.bx;

import com.huotongtianxia.huoyuan.base.IBaseMode;
import com.huotongtianxia.huoyuan.base.IBasePresenter;
import com.huotongtianxia.huoyuan.base.IBaseView;
import com.huotongtianxia.huoyuan.bean.BXBean;

import retrofit2.Callback;

/**
 * Created by Administrator on 2017/4/19 0019.
 */

public class BXContract {
    public interface View extends IBaseView {
        void onResponse(BXBean bxBean);
        void onFailure(String  s);
    }

    public interface Mode extends IBaseMode {
        void  loadBXB(Callback<BXBean> callback, String insure_name, String insure_tel, String recognizee_name, String recognizee_tel, String plate_number, String yun_number, String sum_assured, String good_basic, String goods_quantity, String goods_name, String goods_pack, String goods_value, String yun_start, String yun_end, String create_time);
    }

    public interface Presreter extends IBasePresenter {
        void getData();
    }
}
