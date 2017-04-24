package com.huotongtianxia.huoyuan.ui.WDCD.khzl;

import com.huotongtianxia.huoyuan.base.IBaseMode;
import com.huotongtianxia.huoyuan.base.IBasePresenter;
import com.huotongtianxia.huoyuan.base.IBaseView;
import com.huotongtianxia.huoyuan.bean.FHRBean;
import com.huotongtianxia.huoyuan.bean.KHZLBean;
import com.huotongtianxia.huoyuan.bean.SCKHZLBean;
import com.huotongtianxia.huoyuan.bean.SHRBean;

import retrofit2.Callback;

/**
 * Created by Administrator on 2017/2/17 0017.
 */

public class KHZLContract {
    public interface View extends IBaseView {
        void onResponse(FHRBean khzlBean);
        void onResponse1(SHRBean khzlBean);
        void onResponse2(SCKHZLBean sckhzlBean);
        void onFailure(String  s);
    }

    public interface Mode extends IBaseMode {
        void  loadFHR(Callback<FHRBean> callback, String factory_id);
        void  loadSHR(Callback<SHRBean> callback, String factory_id);
        void  loadSCKHZL(Callback<SCKHZLBean> callback, String uid, String member_type ,String cus_id);
    }

    public interface Presreter extends IBasePresenter {
        void getData();
        void getData1();
        void getData2();
    }
}
