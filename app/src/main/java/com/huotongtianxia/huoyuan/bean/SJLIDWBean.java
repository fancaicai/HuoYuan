package com.huotongtianxia.huoyuan.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2017/4/26 0026.
 */
//司机历史定位Result类
public class SJLIDWBean {
    @SerializedName("code")
    public final int code;
    @SerializedName("lng")
    public final double lng;
    @SerializedName("lat")
    public final double lat;
    @SerializedName("update_time")
    public final String updateTime;
    @SerializedName("message")
    public final String message;

    public SJLIDWBean(int code, double lng, double lat, String updateTime, String message) {
        this.code = code;
        this.lng = lng;
        this.lat = lat;
        this.updateTime = updateTime;
        this.message = message;
    }
}
