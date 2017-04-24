package com.huotongtianxia.huoyuan.ui.WDCD.WDCD;

import com.huotongtianxia.huoyuan.base.IBaseMode;
import com.huotongtianxia.huoyuan.base.IBasePresenter;
import com.huotongtianxia.huoyuan.base.IBaseView;
import com.huotongtianxia.huoyuan.bean.WZBean;

import retrofit2.Callback;

/**
 * Created by Administrator on 2017/3/31 0031.
 */

public class WZContract {
    public interface View extends IBaseView {
        void onResponse(WZBean wzBean);
        void onFailure(String  s);
    }

    public interface Mode extends IBaseMode {
        void  loadWZ(Callback<WZBean> callback, int driver_id);
    }

    public interface Presreter extends IBasePresenter {
        void getData();
    }
}
