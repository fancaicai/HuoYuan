package com.huotongtianxia.huoyuan.ui.WDCD.wdhy;

import com.huotongtianxia.huoyuan.base.IBaseMode;
import com.huotongtianxia.huoyuan.base.IBasePresenter;
import com.huotongtianxia.huoyuan.base.IBaseView;
import com.huotongtianxia.huoyuan.bean.WDHYBBean;
import com.huotongtianxia.huoyuan.bean.WDHYBean;
import com.huotongtianxia.huoyuan.bean.WDHYQXBean;
import com.huotongtianxia.huoyuan.bean.WDHYSCBean;

import retrofit2.Callback;

/**
 * Created by Administrator on 2017/1/17 0017.
 */

public class WDHYContract {
    public interface View extends IBaseView {
        void onResponse(WDHYBean wdhyBean);
        void onResponse1(WDHYBBean wdhyBBean);
        void onResponse2(WDHYQXBean wdhyqxBean);
        void onResponse3(WDHYSCBean wdhyscBean);
        void onFailure(String  s);
    }

    public interface Mode extends IBaseMode {
        void  loadWDHY(Callback<WDHYBean> callback, String factory_id,int status);
        void  loadWDHYB(Callback<WDHYBBean> callback, String factory_id,int status);
        void  loadWDHYQX(Callback<WDHYQXBean> callback, String id);
        void  loadWDHYSC(Callback<WDHYSCBean> callback, String member_typeint, String order_num);
    }

    public interface Presreter extends IBasePresenter {
        void getData();
        void getData1();
        void getData2();
        void getData3();
    }
}
