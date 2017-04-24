package com.huotongtianxia.huoyuan.ui.WDCD.sscl;

import com.huotongtianxia.huoyuan.base.IBaseMode;
import com.huotongtianxia.huoyuan.base.IBasePresenter;
import com.huotongtianxia.huoyuan.base.IBaseView;
import com.huotongtianxia.huoyuan.bean.SSCLBean;
import com.huotongtianxia.huoyuan.bean.TJCLBean;
import com.huotongtianxia.huoyuan.bean.WDCDSCBean;

import retrofit2.Callback;

/**
 * Created by Administrator on 2017/1/18 0018.
 */

public class SSCLContract {
    public interface View extends IBaseView {
        void onResponse(SSCLBean ssclBean);
        void onResponse1(WDCDSCBean ssclBean);
        void onResponse(TJCLBean tjclBean);
        void onFailure(String  s);
    }

    public interface Mode extends IBaseMode {
        void  loadSSCL(Callback<SSCLBean> callback, String factory_id,String plate_number );
        void  loadWDCDSS(Callback<WDCDSCBean> callback,String plate_number );
        void  loadTJCL(Callback<TJCLBean> callback, String factory_id, String driver_id);

    }

    public interface Presreter extends IBasePresenter {
        void getData();
        void getData1();
        void getData2();
    }
}
