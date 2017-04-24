package com.huotongtianxia.huoyuan.ui.WDCD.WDCD;

import com.huotongtianxia.huoyuan.base.IBaseMode;
import com.huotongtianxia.huoyuan.base.IBasePresenter;
import com.huotongtianxia.huoyuan.base.IBaseView;
import com.huotongtianxia.huoyuan.bean.WDCD1Bean;
import com.huotongtianxia.huoyuan.bean.WDCD2Bean;
import com.huotongtianxia.huoyuan.bean.WDCDBean;
import com.huotongtianxia.huoyuan.bean.WDCDSCSJBean;

import retrofit2.Callback;

/**
 * Created by Administrator on 2017/1/18 0018.
 */

public class WDCDContract {
    public interface View extends IBaseView {
        void onResponse(WDCDBean wdcdBean);
        void onResponse1(WDCDBean wdcdBean);
        void onResponse2(WDCDSCSJBean wdcdBean);
        void onFailure(String  s);
    }

    public interface Mode extends IBaseMode {
        void  loadWDCD(Callback<WDCDBean> callback, String factory_id);
        void  loadWDCD1(Callback<WDCDBean> callback, String factory_id, String locality);
        void  loadWDCD2(Callback<WDCDSCSJBean> callback, String driver_id, String factory_id);
    }

    public interface Presreter extends IBasePresenter {
        void getData();
        void getData1();
        void getData2();
    }
}
