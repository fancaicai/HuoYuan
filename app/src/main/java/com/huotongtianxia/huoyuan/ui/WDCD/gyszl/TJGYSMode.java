package com.huotongtianxia.huoyuan.ui.WDCD.gyszl;

import com.huotongtianxia.huoyuan.bean.TJGYSBean;
import com.huotongtianxia.huoyuan.http.HttpUtils;

import retrofit2.Callback;

/**
 * Created by Administrator on 2017/2/28 0028.
 */

public class TJGYSMode implements TJGYSContract.Mode{
    @Override
    public void loadTJGYS(Callback<TJGYSBean> callback, String uid, String member_type, String name, String head, String tel, String address) {
        HttpUtils.newInstance().loadTJGYSBean(callback,uid,member_type,name,head,tel,address);
    }
}
