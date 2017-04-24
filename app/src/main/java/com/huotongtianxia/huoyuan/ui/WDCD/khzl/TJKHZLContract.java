package com.huotongtianxia.huoyuan.ui.WDCD.khzl;

import com.huotongtianxia.huoyuan.base.IBaseMode;
import com.huotongtianxia.huoyuan.base.IBasePresenter;
import com.huotongtianxia.huoyuan.base.IBaseView;
import com.huotongtianxia.huoyuan.bean.TJKHZLBean;

import retrofit2.Callback;

/**
 * Created by Administrator on 2017/2/20 0020.
 */

public class TJKHZLContract {
    public interface View extends IBaseView {
        void onResponse(TJKHZLBean tjkhzlBean);
        void onFailure(String  s);
    }

    public interface Mode extends IBaseMode {
        void  loadTJKHZL(Callback<TJKHZLBean> callback, String uid, String member_type, String company_name, String contacts, String tel, String province, String city, String address);
    }

    public interface Presreter extends IBasePresenter {
        void getData();
    }
}
