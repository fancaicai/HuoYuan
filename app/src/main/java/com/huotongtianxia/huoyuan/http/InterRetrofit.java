package com.huotongtianxia.huoyuan.http;

import com.huotongtianxia.huoyuan.bean.BJGSZLBean;
import com.huotongtianxia.huoyuan.bean.BXBean;
import com.huotongtianxia.huoyuan.bean.CLRZBean;
import com.huotongtianxia.huoyuan.bean.DDXQBean;
import com.huotongtianxia.huoyuan.bean.DLBean;
import com.huotongtianxia.huoyuan.bean.FCTJBean;
import com.huotongtianxia.huoyuan.bean.FHRBean;
import com.huotongtianxia.huoyuan.bean.GRZLBean;
import com.huotongtianxia.huoyuan.bean.GRZXBean;
import com.huotongtianxia.huoyuan.bean.GSZLBean;
import com.huotongtianxia.huoyuan.bean.GYSBean;
import com.huotongtianxia.huoyuan.bean.GenBean;
import com.huotongtianxia.huoyuan.bean.HYFB2Bean;
import com.huotongtianxia.huoyuan.bean.HYFBBean;
import com.huotongtianxia.huoyuan.bean.HYFBSHBean;
import com.huotongtianxia.huoyuan.bean.KHZLBean;
import com.huotongtianxia.huoyuan.bean.PJBean;
import com.huotongtianxia.huoyuan.bean.QRSHBean;
import com.huotongtianxia.huoyuan.bean.SCKHZLBean;
import com.huotongtianxia.huoyuan.bean.SHRBean;
import com.huotongtianxia.huoyuan.bean.SJLIDWBean;
import com.huotongtianxia.huoyuan.bean.SJRZ1Bean;
import com.huotongtianxia.huoyuan.bean.SSCLBean;
import com.huotongtianxia.huoyuan.bean.TJCLBean;
import com.huotongtianxia.huoyuan.bean.TJGYSBean;
import com.huotongtianxia.huoyuan.bean.TJKHZLBean;
import com.huotongtianxia.huoyuan.bean.WDCDBean;
import com.huotongtianxia.huoyuan.bean.WDCDSCBean;
import com.huotongtianxia.huoyuan.bean.WDCDSCSJBean;
import com.huotongtianxia.huoyuan.bean.WDHYBBean;
import com.huotongtianxia.huoyuan.bean.WDHYBean;
import com.huotongtianxia.huoyuan.bean.WDHYQXBean;
import com.huotongtianxia.huoyuan.bean.WDHYSCBean;
import com.huotongtianxia.huoyuan.bean.WDZHBean;
import com.huotongtianxia.huoyuan.bean.WZBean;
import com.huotongtianxia.huoyuan.bean.ZXCCBBean;
import com.huotongtianxia.huoyuan.bean.ZXCCWBean;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

/**
 * Created by Administrator on 2016/9/6.
 *
 */
public interface InterRetrofit {

    @FormUrlEncoded
    @POST("api/GoodsCenter/localityTruck")
    Call<ZXCCBBean> loadZXCCBBean(@Field("locality") String locality);

    @FormUrlEncoded
    @POST("api/GoodsCenter/otherTruck")
    Call<ZXCCWBean> loadZXCCWBean(@Field("locality") String locality);

    @FormUrlEncoded
    @POST("api/Supplier/index")
    Call<GYSBean> loadGYSBean(@Field("uid") String uid,@Field("member_type") String member_type);

    @FormUrlEncoded
    @POST("api/FactoryInfo/index")
    Call<GRZXBean> loadGRZXBean(@Field("uid") String uid, @Field("member_type") String member_type);

    @FormUrlEncoded
    @POST("api/Supplier/add")
    Call<TJGYSBean> loadTJGYSBean(@Field("uid") String uid, @Field("member_type") String member_type,@Field("name") String name,@Field("head") String head,@Field("tel") String tel,@Field("address") String address );

    @FormUrlEncoded
    @POST("api/MyGoods/orderList")
    Call<WDHYBean> loadWDHYBean(@Field("factory_id") String factory_id,@Field("status") int status);

    @FormUrlEncoded
    @POST("api/MyGoods/orderDetails")
    Call<DDXQBean> loadDDXQBean( @Field("order_num") String order_num);

    @FormUrlEncoded
    @POST("api/MyGoods/estimate")
    Call<PJBean> loadPJBean(@Field("uid") String uid, @Field("estimate_id") int estimate_id, @Field("order_num") String order_num);

    @FormUrlEncoded
    @POST("api/MyGoods/verify")
    Call<QRSHBean> loadQRSHBean(@Field("uid") String uid, @Field("order_num") String order_num,@Field("yun_status") String yun_status);

    @FormUrlEncoded
    @POST("api/MyGoods/orderList")
    Call<WDHYBBean> loadWDHYBBean(@Field("factory_id") String factory_id, @Field("status") int status);

    @FormUrlEncoded
    @POST("api/GoodsHome/myMotorcade")
    Call<WDCDBean> loadWDCDBean(@Field("factory_id") String factory_id);

    @FormUrlEncoded
    @POST("api/MyGoods/delGoods")
    Call<WDHYQXBean> loadWDHYQXBean(@Field("id") String id);

    @FormUrlEncoded
    @POST("api/MyGoods/delOrder")
    Call<WDHYSCBean> loadWDHYSCBean(@Field("member_type") String member_type, @Field("order_num") String order_num);

    @FormUrlEncoded
    @POST("api/GoodsHome/location")
    Call<WDCDBean> loadWDCD1Bean(@Field("factory_id") String factory_id, @Field("locality") String locality);

    @FormUrlEncoded
    @POST("api/GoodsHome/souTurck")
    Call<WDCDSCBean> loadWDCDSSBean(@Field("plate_number") String plate_number);

    @FormUrlEncoded
    @POST("api/GoodsHome/searchTurck")
    Call<SSCLBean> loadSSCLBean(@Field("factory_id") String factory_id,@Field("plate_number") String plate_number);

    @FormUrlEncoded
    @POST("api/GoodsHome/addTurck")
    Call<TJCLBean> loadTJCLBean(@Field("factory_id") String factory_id,@Field("driver_id") String driver_id);

    @FormUrlEncoded
    @POST("api/GoodsCenter/statistics")
    Call<FCTJBean> loadFCTJBean(@Field("create_time") String create_time, @Field("factory_id") String factory_id);

    @FormUrlEncoded
    @POST("api/GoodsPublish/userInfo")
    Call<GSZLBean> loadGSZLBean( @Field("factory_id") String factory_id);

    @FormUrlEncoded
    @POST("api/GoodsPublish/updateFactory")
    Call<BJGSZLBean> loadBJGSZLBean( @Field("factory_id") String factory_id,@Field("company") String company ,@Field("address") String address ,@Field("main_products") String main_products,@Field("truck_type") String truck_type,@Field("head") String head ,@Field("mobile") String mobile );

    @FormUrlEncoded
    @POST("api/GoodsPublish/customerAdd")
    Call<KHZLBean> loadKHZLBean(@Field("uid") String uid, @Field("member_type") String member_type);

    @FormUrlEncoded
    @POST("api/FactoryCustomer/add")
    Call<TJKHZLBean> loadTJKHZLBean(@Field("uid") String uid, @Field("member_type") String member_type,@Field("company_name") String company_name,@Field("contacts") String contacts ,@Field("tel") String tel,@Field("province") String province,@Field("city") String city,@Field("address")String address );

    @FormUrlEncoded
    @POST("api/GoodsCenter/myAccount")
    Call<WDZHBean> loadWDZHBean( @Field("factory_id") String factory_id);

    @FormUrlEncoded
    @POST("api/GoodsHome/siji")
    Call<GRZLBean> loadGRZLBean(@Field("driver_id") int driver_id);

    @FormUrlEncoded
    @POST("api/GoodsHome/delSiji")
    Call<WDCDSCSJBean> loadWDCDSCSJBean(@Field("driver_id") String driver_id,@Field("factory_id") String factory_id);

    @FormUrlEncoded
    @POST("api/GoodsHome/sjdw")
    Call<WZBean> loadWZBean(@Field("driver_id") int driver_id);

    @FormUrlEncoded
    @POST("api/Login/login")
    Call<DLBean> loadDLBean(@Field("tel") String tel, @Field("password") String password);

    @FormUrlEncoded
    @POST("api/GoodsPublish/facList")
    Call<FHRBean> loadFHRBean(@Field("factory_id") String factory_id);

    @FormUrlEncoded
    @POST("api/GoodsPublish/facList")
    Call<SHRBean> loadFHRBean1(@Field("factory_id") String factory_id);

    @FormUrlEncoded
    @POST("api/GoodsPublish/customerList")
    Call<SHRBean> loadSHRBean(@Field("factory_id") String factory_id);

    @FormUrlEncoded
    @POST("api/GoodsPublish/address")
    Call<HYFBSHBean> loadHYFBSHBean(@Field("uid") String uid,@Field("member_type") String member_type, @Field("province") String province, @Field("city") String city);

    @FormUrlEncoded
    @POST("api/GoodsPublish/address")
    Call<HYFB2Bean> loadHYFB2Bean(@Field("uid") String uid, @Field("member_type") String member_type, @Field("province") String province, @Field("city") String city);

    @FormUrlEncoded
    @POST("api/GoodsPublish/pubGoods")
    Call<HYFBBean> loadHYFBBean(@Field("factory_id") String factory_id, @Field("shi_id") int shi_id , @Field("customer_id") int customer_id , @Field("send_time") String send_time, @Field("goods_type") String goods_type, @Field("require_truck_weight") String require_truck_weight, @Field("require_truck_length") String require_truck_length , @Field("require_truck_type") String require_truck_type ,@Field("offer_price") String offer_price);

    @FormUrlEncoded
    @POST("api/FactoryCustomer/delete")
    Call<SCKHZLBean> loadSCKHZLBean(@Field("uid") String uid, @Field("member_type") String member_type,@Field("cus_id") String cus_id);

    @FormUrlEncoded
    @POST("api/Insurance/index")
    Call<BXBean> loadBXBean(@Field("insure_name") String insure_name, @Field("insure_tel") String insure_tel , @Field("recognizee_name") String recognizee_name , @Field("recognizee_tel") String recognizee_tel,
                            @Field("plate_number") String plate_number, @Field("yun_number") String yun_number, @Field("sum_assured") String sum_assured , @Field("good_basic") String good_basic ,
                            @Field("goods_quantity") String goods_quantity, @Field("goods_name") String goods_name, @Field("goods_pack") String goods_pack , @Field("goods_value") String goods_value ,
                            @Field("yun_start") String yun_start, @Field("yun_end") String yun_end, @Field("create_time") String create_time);

    @Multipart
    @POST("api/GoodsCenter/driverPic")
    Call<CLRZBean> loadCLRZBean(@Part("id") String id,
                                @Part("id_card_a") RequestBody id_card_a,
                                @Part("id_card_b") RequestBody id_card_b,
                                @Part("drive_card_a") RequestBody drive_card_a,
                                @Part("drive_card_b") RequestBody drive_card_b
                                );
    @FormUrlEncoded
    @POST("api/GoodsCenter/driverInfo")
    Call<SJRZ1Bean> loadSJRZ1Bean(@Field("factory_id") String factory_id,
                                 @Field("name") String name, @Field("tel") String tel,
                                 @Field("plate_number") String plate_number,
                                 @Field("weight") String weight, @Field("length") String length,
                                 @Field("type") String type, @Field("advantage_way") String advantage_way,
                                 @Field("register_place") String register_place
    );

    @FormUrlEncoded
    @POST("api/Version/appVersion")
    Call<GenBean> loadGenBean(@Field("app_id") String app_id,@Field("version_id") String version_id,@Field("version_mini") String version_mini);
    // 司机历史位置
    @FormUrlEncoded
    @POST("api/MyGoods/trace ")
    Call<SJLIDWBean> getSJLSDW(@Field("order_num") String sjtel);
}
