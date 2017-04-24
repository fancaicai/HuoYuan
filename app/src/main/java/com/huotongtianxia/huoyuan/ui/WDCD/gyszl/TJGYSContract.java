package com.huotongtianxia.huoyuan.ui.WDCD.gyszl;

import com.huotongtianxia.huoyuan.base.IBaseMode;
import com.huotongtianxia.huoyuan.base.IBasePresenter;
import com.huotongtianxia.huoyuan.base.IBaseView;
import com.huotongtianxia.huoyuan.bean.TJGYSBean;

import retrofit2.Callback;

/**
 * Created by Administrator on 2017/2/28 0028.
 */

public class TJGYSContract {
    public interface View extends IBaseView {
        void onResponse(TJGYSBean tjgysBean);
        void onFailure(String  s);
    }

    public interface Mode extends IBaseMode {
        void  loadTJGYS(Callback<TJGYSBean> callback, String uid, String member_type,String name,String head,String tel,String address);
    }

    public interface Presreter extends IBasePresenter {
        void getData();
    }
}
