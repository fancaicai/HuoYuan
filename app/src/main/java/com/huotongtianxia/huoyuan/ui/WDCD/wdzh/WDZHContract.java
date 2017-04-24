package com.huotongtianxia.huoyuan.ui.WDCD.wdzh;

import com.huotongtianxia.huoyuan.base.IBaseMode;
import com.huotongtianxia.huoyuan.base.IBasePresenter;
import com.huotongtianxia.huoyuan.base.IBaseView;
import com.huotongtianxia.huoyuan.bean.WDZHBean;

import retrofit2.Callback;

/**
 * Created by Administrator on 2017/1/20 0020.
 */

public class WDZHContract {
    public interface View extends IBaseView {
        void onResponse(WDZHBean wdzhBean);
        void onFailure(String  s);
    }

    public interface Mode extends IBaseMode {
        void  loadWDZH(Callback<WDZHBean> callback, String factory_id);
    }

    public interface Presreter extends IBasePresenter {
        void getData();
    }
}
