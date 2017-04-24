package com.huotongtianxia.huoyuan.ui.WDCD.gszl;

import com.huotongtianxia.huoyuan.base.IBaseMode;
import com.huotongtianxia.huoyuan.base.IBasePresenter;
import com.huotongtianxia.huoyuan.base.IBaseView;
import com.huotongtianxia.huoyuan.bean.BJGSZLBean;
import com.huotongtianxia.huoyuan.bean.GSZLBean;

import retrofit2.Callback;

/**
 * Created by Administrator on 2017/2/17 0017.
 */

public class BJGSZLContract {
    public interface View extends IBaseView {
        void onResponse(BJGSZLBean bjgszlBean);
        void onResponse2(GSZLBean gszlBean);
        void onFailure(String  s);
    }

    public interface Mode extends IBaseMode {
        void  loadBJGSZL(Callback<BJGSZLBean> callback, String factory_id, String company, String address, String main_products, String truck_type, String head,String mobile);
        void  loadGSZL(Callback<GSZLBean> callback, String factory_id);
    }

    public interface Presreter extends IBasePresenter {
        void getData();
        void getData1();
    }
}
