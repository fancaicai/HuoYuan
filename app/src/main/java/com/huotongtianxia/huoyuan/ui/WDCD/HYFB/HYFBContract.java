package com.huotongtianxia.huoyuan.ui.WDCD.HYFB;

import com.huotongtianxia.huoyuan.base.IBaseMode;
import com.huotongtianxia.huoyuan.base.IBasePresenter;
import com.huotongtianxia.huoyuan.base.IBaseView;
import com.huotongtianxia.huoyuan.bean.GSZLBean;
import com.huotongtianxia.huoyuan.bean.HYFB2Bean;
import com.huotongtianxia.huoyuan.bean.HYFBBean;
import com.huotongtianxia.huoyuan.bean.HYFBSHBean;

import retrofit2.Callback;

/**
 * Created by Administrator on 2017/2/18 0018.
 */

public class HYFBContract {
    public interface View extends IBaseView {
        void onResponse(HYFBBean hyfbBean);
        void onResponse1(HYFBSHBean hyfbshBean);
        void onResponse3(HYFB2Bean hyfb2Bean);
        void onFailure(String  s);
    }

    public interface Mode extends IBaseMode {
        void  loadHYFB(Callback<HYFBBean> callback, String factory_id, int shi_id, int customer_id, String send_time, String goods_type, String require_truck_weight, String require_truck_length, String require_truck_type,String offer_price);
        void  loadHYFBSH(Callback<HYFBSHBean> callback, String uid, String member_type, String province, String city);
        void  loadHYFB2(Callback<HYFB2Bean> callback, String uid, String member_type, String province, String city);
    }

    public interface Presreter extends IBasePresenter {
        void getData();
        void getData1();
        void getData3();
    }
}
