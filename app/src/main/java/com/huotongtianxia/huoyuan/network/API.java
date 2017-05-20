package com.huotongtianxia.huoyuan.network;

import com.huotongtianxia.huoyuan.bean.DoorPhotoBean;
import com.huotongtianxia.huoyuan.bean.HuoYuanPhoto;
import com.huotongtianxia.huoyuan.bean.HuoyuanPhotoBean;

import java.util.Map;

import okhttp3.RequestBody;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PartMap;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by GJL on 2017/5/19 0019.
 */

public interface API {


    //上传图片
    @Multipart
    @POST(URLHttp.uploadImgs)
    Observable<HuoYuanPhoto> iuploadImgs(@Query("factory_id") String factory_id,@Query("data") String des,
                                         @PartMap Map<String, RequestBody> imgs);

    @POST(URLHttp.getImgs)
    Observable<DoorPhotoBean> igetDoorImgs(@Query("factory_id") String factory_id, @Query("action") String info);

    @POST(URLHttp.getImgs)
    Observable<HuoyuanPhotoBean> igetHuoyuanImgs(@Query("factory_id") String factory_id, @Query("action") String info);
}
