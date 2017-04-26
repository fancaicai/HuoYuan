package com.huotongtianxia.huoyuan.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2017/4/26 0026.
 */

public class SJID {

    @SerializedName("SJID")
    private final int SJId;
    public SJID(int sjId) {
       this.SJId = sjId;
    }
}
