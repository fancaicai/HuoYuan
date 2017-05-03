package com.huotongtianxia.huoyuan.http;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
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
import com.huotongtianxia.huoyuan.bean.SJRZ1Bean;
import com.huotongtianxia.huoyuan.bean.SSCLBean;
import com.huotongtianxia.huoyuan.bean.TJCLBean;
import com.huotongtianxia.huoyuan.bean.TJGYSBean;
import com.huotongtianxia.huoyuan.bean.TJKHZLBean;
import com.huotongtianxia.huoyuan.bean.WDCD1Bean;
import com.huotongtianxia.huoyuan.bean.WDCD2Bean;
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
import com.huotongtianxia.huoyuan.config.UrlConfig;

import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2016/9/6.
 * 网络请求封装类
 */
public class HttpUtils {
    public static final String BASE_URL = "http://192.168.0.6/httx/public/index.php/";
    private static HttpUtils utile;
    private final OkHttpClient mOkHttpClient;
    private final Gson mGson;
    private final Retrofit mRetrofit;
    private InterRetrofit mTreasureApi;
    private HttpUtils(){

        // 设置GSON的非严格模式setLenient()
        mGson = new GsonBuilder().setLenient().create();

        // 日志拦截器
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        // 需要设置打印级别
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        // OkHttpClient的单例化
        mOkHttpClient = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build();

        // Retrofit的创建
        // 必须要加的BASEURL
        // 添加OkHttpClient
        mRetrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)// 必须要加的BASEURL
                .client(mOkHttpClient)// 添加OkHttpClient
                // 添加转换器
                .addConverterFactory(GsonConverterFactory.create(mGson))
                .build();
    };
    public static synchronized HttpUtils newInstance(){
        if (utile==null) {
            utile=new HttpUtils();
        }
        return utile;
    }
    // 将TreasureApi怎么对外提供处理：提供一个方法getTreasureApi()
    public InterRetrofit getTreasureApi(){

        if (mTreasureApi==null){
            // 对请求接口的具体实现
            mTreasureApi = mRetrofit.create(InterRetrofit.class);
        }
        return mTreasureApi;
    }
    public void loadZXCCBBean(Callback<ZXCCBBean> callback, String locality){
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();
        Retrofit retrofit = new Retrofit.Builder().client(okHttpClient).baseUrl(UrlConfig.HOME).addConverterFactory(GsonConverterFactory.create(new Gson())).build();
        InterRetrofit retrofitInter = retrofit.create(InterRetrofit.class);
        Call<ZXCCBBean> leftBeanCall = retrofitInter.loadZXCCBBean(locality);
        leftBeanCall.enqueue(callback);
    }

    public void loadZXCCWBean(Callback<ZXCCWBean> callback, String locality){
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();
        Retrofit retrofit = new Retrofit.Builder().client(okHttpClient).baseUrl(UrlConfig.HOME).addConverterFactory(GsonConverterFactory.create(new Gson())).build();
        InterRetrofit retrofitInter = retrofit.create(InterRetrofit.class);
        Call<ZXCCWBean> leftBeanCall = retrofitInter.loadZXCCWBean(locality);

        leftBeanCall.enqueue(callback);
    }

    public void loadGYSBean(Callback<GYSBean> callback, String uid,String member_type){
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();
        Retrofit retrofit = new Retrofit.Builder().client(okHttpClient).baseUrl(UrlConfig.HOME).addConverterFactory(GsonConverterFactory.create(new Gson())).build();
        InterRetrofit retrofitInter = retrofit.create(InterRetrofit.class);
        Call<GYSBean> leftBeanCall = retrofitInter.loadGYSBean(uid,member_type);

        leftBeanCall.enqueue(callback);
    }

    public void loadWZBean(Callback<WZBean> callback, int driver_id){
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();
        Retrofit retrofit = new Retrofit.Builder().client(okHttpClient).baseUrl(UrlConfig.HOME).addConverterFactory(GsonConverterFactory.create(new Gson())).build();
        InterRetrofit retrofitInter = retrofit.create(InterRetrofit.class);
        Call<WZBean> leftBeanCall = retrofitInter.loadWZBean(driver_id);

        leftBeanCall.enqueue(callback);
    }

    public void loadGRZXBean(Callback<GRZXBean> callback, String uid, String member_type){
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();
        Retrofit retrofit = new Retrofit.Builder().client(okHttpClient).baseUrl(UrlConfig.HOME).addConverterFactory(GsonConverterFactory.create(new Gson())).build();
        InterRetrofit retrofitInter = retrofit.create(InterRetrofit.class);
        Call<GRZXBean> leftBeanCall = retrofitInter.loadGRZXBean(uid,member_type);

        leftBeanCall.enqueue(callback);
    }

    public void loadTJGYSBean(Callback<TJGYSBean> callback, String uid, String member_type,String name,String head,String tel,String address){
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();
        Retrofit retrofit = new Retrofit.Builder().client(okHttpClient).baseUrl(UrlConfig.HOME).addConverterFactory(GsonConverterFactory.create(new Gson())).build();
        InterRetrofit retrofitInter = retrofit.create(InterRetrofit.class);
        Call<TJGYSBean> leftBeanCall = retrofitInter.loadTJGYSBean(uid,member_type,name,head,tel,address);

        leftBeanCall.enqueue(callback);
    }

    public void loadWDHYBean(Callback<WDHYBean> callback, String factory_id,int status){
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();
        Retrofit retrofit = new Retrofit.Builder().client(okHttpClient).baseUrl(UrlConfig.HOME).addConverterFactory(GsonConverterFactory.create(new Gson())).build();
        InterRetrofit retrofitInter = retrofit.create(InterRetrofit.class);
        Call<WDHYBean> leftBeanCall = retrofitInter.loadWDHYBean(factory_id,status);

        leftBeanCall.enqueue(callback);
    }
    public void loadWDHYBBean(Callback<WDHYBBean> callback, String factory_id, int status){
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();
        Retrofit retrofit = new Retrofit.Builder().client(okHttpClient).baseUrl(UrlConfig.HOME).addConverterFactory(GsonConverterFactory.create(new Gson())).build();
        InterRetrofit retrofitInter = retrofit.create(InterRetrofit.class);
        Call<WDHYBBean> leftBeanCall = retrofitInter.loadWDHYBBean(factory_id,status);

        leftBeanCall.enqueue(callback);
    }

    public void loadDDXQBean(Callback<DDXQBean> callback, String order_num){
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();
        Retrofit retrofit = new Retrofit.Builder().client(okHttpClient).baseUrl(UrlConfig.HOME).addConverterFactory(GsonConverterFactory.create(new Gson())).build();
        InterRetrofit retrofitInter = retrofit.create(InterRetrofit.class);
        Call<DDXQBean> leftBeanCall = retrofitInter.loadDDXQBean(order_num);

        leftBeanCall.enqueue(callback);
    }

    public void loadWDHYQXBean(Callback<WDHYQXBean> callback, String id){
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();
        Retrofit retrofit = new Retrofit.Builder().client(okHttpClient).baseUrl(UrlConfig.HOME).addConverterFactory(GsonConverterFactory.create(new Gson())).build();
        InterRetrofit retrofitInter = retrofit.create(InterRetrofit.class);
        Call<WDHYQXBean> leftBeanCall = retrofitInter.loadWDHYQXBean(id);

        leftBeanCall.enqueue(callback);
    }

    public void loadWDHYSCBean(Callback<WDHYSCBean> callback, String member_type, String order_num){
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();
        Retrofit retrofit = new Retrofit.Builder().client(okHttpClient).baseUrl(UrlConfig.HOME).addConverterFactory(GsonConverterFactory.create(new Gson())).build();
        InterRetrofit retrofitInter = retrofit.create(InterRetrofit.class);
        Call<WDHYSCBean> leftBeanCall = retrofitInter.loadWDHYSCBean(member_type,order_num);

        leftBeanCall.enqueue(callback);
    }

    public void loadQRSHBean(Callback<QRSHBean> callback, String uid, String order_num, String yun_status){
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();
        Retrofit retrofit = new Retrofit.Builder().client(okHttpClient).baseUrl(UrlConfig.HOME).addConverterFactory(GsonConverterFactory.create(new Gson())).build();
        InterRetrofit retrofitInter = retrofit.create(InterRetrofit.class);
        Call<QRSHBean> leftBeanCall = retrofitInter.loadQRSHBean(uid,order_num,yun_status);

        leftBeanCall.enqueue(callback);
    }

    public void loadPJBean(Callback<PJBean> callback, String uid, String order_num, int estimate_id){
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();
        Retrofit retrofit = new Retrofit.Builder().client(okHttpClient).baseUrl(UrlConfig.HOME).addConverterFactory(GsonConverterFactory.create(new Gson())).build();
        InterRetrofit retrofitInter = retrofit.create(InterRetrofit.class);
        Call<PJBean> leftBeanCall = retrofitInter.loadPJBean(uid,estimate_id,order_num);

        leftBeanCall.enqueue(callback);
    }

    public void loadWDCDBean(Callback<WDCDBean> callback, String factory_id){
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();
        Retrofit retrofit = new Retrofit.Builder().client(okHttpClient).baseUrl(UrlConfig.HOME).addConverterFactory(GsonConverterFactory.create(new Gson())).build();
        InterRetrofit retrofitInter = retrofit.create(InterRetrofit.class);
        Call<WDCDBean> leftBeanCall = retrofitInter.loadWDCDBean(factory_id);
        leftBeanCall.enqueue(callback);
    }

    public void loadWDCD1Bean(Callback<WDCDBean> callback, String factory_id , String locality){
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();
        Retrofit retrofit = new Retrofit.Builder().client(okHttpClient).baseUrl(UrlConfig.HOME).addConverterFactory(GsonConverterFactory.create(new Gson())).build();
        InterRetrofit retrofitInter = retrofit.create(InterRetrofit.class);
        Call<WDCDBean> leftBeanCall = retrofitInter.loadWDCD1Bean(factory_id,locality);

        leftBeanCall.enqueue(callback);
    }

    public void loadWDCDSS(Callback<WDCDSCBean> callback, String plate_number ){
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();
        Retrofit retrofit = new Retrofit.Builder().client(okHttpClient).baseUrl(UrlConfig.HOME).addConverterFactory(GsonConverterFactory.create(new Gson())).build();
        InterRetrofit retrofitInter = retrofit.create(InterRetrofit.class);
        Call<WDCDSCBean> leftBeanCall = retrofitInter.loadWDCDSSBean(plate_number);

        leftBeanCall.enqueue(callback);
    }

    public void loadSSCLBean(Callback<SSCLBean> callback,String factory_id,String plate_number ){
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();
        Retrofit retrofit = new Retrofit.Builder().client(okHttpClient).baseUrl(UrlConfig.HOME).addConverterFactory(GsonConverterFactory.create(new Gson())).build();
        InterRetrofit retrofitInter = retrofit.create(InterRetrofit.class);
        Call<SSCLBean> leftBeanCall = retrofitInter.loadSSCLBean(factory_id, plate_number);

        leftBeanCall.enqueue(callback);
    }

    public void loadTJCLBean(Callback<TJCLBean> callback, String factory_id, String driver_id){
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();
        Retrofit retrofit = new Retrofit.Builder().client(okHttpClient).baseUrl(UrlConfig.HOME).addConverterFactory(GsonConverterFactory.create(new Gson())).build();
        InterRetrofit retrofitInter = retrofit.create(InterRetrofit.class);
        Call<TJCLBean> leftBeanCall = retrofitInter.loadTJCLBean(factory_id,driver_id);

        leftBeanCall.enqueue(callback);
    }

    public void loadFHRBean(Callback<FHRBean> callback, String factory_id){
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();
        Retrofit retrofit = new Retrofit.Builder().client(okHttpClient).baseUrl(UrlConfig.HOME).addConverterFactory(GsonConverterFactory.create(new Gson())).build();
        InterRetrofit retrofitInter = retrofit.create(InterRetrofit.class);
        Call<FHRBean> leftBeanCall = retrofitInter.loadFHRBean(factory_id);

        leftBeanCall.enqueue(callback);
    }

    public void loadSHRBean(Callback<SHRBean> callback, String factory_id){
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();
        Retrofit retrofit = new Retrofit.Builder().client(okHttpClient).baseUrl(UrlConfig.HOME).addConverterFactory(GsonConverterFactory.create(new Gson())).build();
        InterRetrofit retrofitInter = retrofit.create(InterRetrofit.class);
        Call<SHRBean> leftBeanCall = retrofitInter.loadSHRBean(factory_id);

        leftBeanCall.enqueue(callback);
    }
    public void loadFCTJBean(Callback<FCTJBean> callback, String create_time, String factory_id){
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();
        Retrofit retrofit = new Retrofit.Builder().client(okHttpClient).baseUrl(UrlConfig.HOME).addConverterFactory(GsonConverterFactory.create(new Gson())).build();
        InterRetrofit retrofitInter = retrofit.create(InterRetrofit.class);
        Call<FCTJBean> leftBeanCall = retrofitInter.loadFCTJBean(create_time,factory_id);

        leftBeanCall.enqueue(callback);
    }

    public void loadGSZLBean(Callback<GSZLBean> callback, String factory_id){
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();
        Retrofit retrofit = new Retrofit.Builder().client(okHttpClient).baseUrl(UrlConfig.HOME).addConverterFactory(GsonConverterFactory.create(new Gson())).build();
        InterRetrofit retrofitInter = retrofit.create(InterRetrofit.class);
        Call<GSZLBean> leftBeanCall = retrofitInter.loadGSZLBean(factory_id);

        leftBeanCall.enqueue(callback);
    }

    public void loadBJGSZLBean(Callback<BJGSZLBean> callback, String factory_id, String company, String address, String main_products, String truck_type, String head,String mobile){
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();
        Retrofit retrofit = new Retrofit.Builder().client(okHttpClient).baseUrl(UrlConfig.HOME).addConverterFactory(GsonConverterFactory.create(new Gson())).build();
        InterRetrofit retrofitInter = retrofit.create(InterRetrofit.class);
        Call<BJGSZLBean> leftBeanCall = retrofitInter.loadBJGSZLBean(factory_id,company,address,main_products,truck_type,head,mobile);

        leftBeanCall.enqueue(callback);
    }

    public void loadKHZLBean(Callback<KHZLBean> callback, String uid, String member_type){
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();
        Retrofit retrofit = new Retrofit.Builder().client(okHttpClient).baseUrl(UrlConfig.HOME).addConverterFactory(GsonConverterFactory.create(new Gson())).build();
        InterRetrofit retrofitInter = retrofit.create(InterRetrofit.class);
        Call<KHZLBean> leftBeanCall = retrofitInter.loadKHZLBean(uid,member_type);

        leftBeanCall.enqueue(callback);
    }

    public void loadWDZHBean(Callback<WDZHBean> callback, String factory_id){
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();
        Retrofit retrofit = new Retrofit.Builder().client(okHttpClient).baseUrl(UrlConfig.HOME).addConverterFactory(GsonConverterFactory.create(new Gson())).build();
        InterRetrofit retrofitInter = retrofit.create(InterRetrofit.class);
        Call<WDZHBean> leftBeanCall = retrofitInter.loadWDZHBean(factory_id);

        leftBeanCall.enqueue(callback);
    }

    public void loadGRZLBean(Callback<GRZLBean> callback, int driver_id){
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();
        Retrofit retrofit = new Retrofit.Builder().client(okHttpClient).baseUrl(UrlConfig.HOME).addConverterFactory(GsonConverterFactory.create(new Gson())).build();
        InterRetrofit retrofitInter = retrofit.create(InterRetrofit.class);
        Call<GRZLBean> leftBeanCall = retrofitInter.loadGRZLBean(driver_id);

        leftBeanCall.enqueue(callback);
    }

    public void loadWDCDSCSJBean(Callback<WDCDSCSJBean> callback, String driver_id,String factory_id){
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();
        Retrofit retrofit = new Retrofit.Builder().client(okHttpClient).baseUrl(UrlConfig.HOME).addConverterFactory(GsonConverterFactory.create(new Gson())).build();
        InterRetrofit retrofitInter = retrofit.create(InterRetrofit.class);
        Call<WDCDSCSJBean> leftBeanCall = retrofitInter.loadWDCDSCSJBean(driver_id,factory_id);

        leftBeanCall.enqueue(callback);
    }

    public void loadDLBean(Callback<DLBean> callback, String tel , String password){
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();
        Retrofit retrofit = new Retrofit.Builder().client(okHttpClient).baseUrl(UrlConfig.HOME).addConverterFactory(GsonConverterFactory.create(new Gson())).build();
        InterRetrofit retrofitInter = retrofit.create(InterRetrofit.class);
        Call<DLBean> leftBeanCall = retrofitInter.loadDLBean(tel,password);

        leftBeanCall.enqueue(callback);
    }

    public void loadHYFBSHBean(Callback<HYFBSHBean> callback,String uid ,String member_type , String province , String city){
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();
        Retrofit retrofit = new Retrofit.Builder().client(okHttpClient).baseUrl(UrlConfig.HOME).addConverterFactory(GsonConverterFactory.create(new Gson())).build();
        InterRetrofit retrofitInter = retrofit.create(InterRetrofit.class);
        Call<HYFBSHBean> leftBeanCall = retrofitInter.loadHYFBSHBean(uid,member_type,province,city);

        leftBeanCall.enqueue(callback);
    }

    public void loadHYFB2Bean(Callback<HYFB2Bean> callback, String uid , String member_type , String province , String city){
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();
        Retrofit retrofit = new Retrofit.Builder().client(okHttpClient).baseUrl(UrlConfig.HOME).addConverterFactory(GsonConverterFactory.create(new Gson())).build();
        InterRetrofit retrofitInter = retrofit.create(InterRetrofit.class);
        Call<HYFB2Bean> leftBeanCall = retrofitInter.loadHYFB2Bean(uid,member_type,province,city);

        leftBeanCall.enqueue(callback);
    }

    public void loadHYFBBean(Callback<HYFBBean> callback, String factory_id, int shi_id, int customer_id, String send_time, String goods_type, String require_truck_weight, String require_truck_length, String require_truck_type,String offer_price){
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();
        Retrofit retrofit = new Retrofit.Builder().client(okHttpClient).baseUrl(UrlConfig.HOME).addConverterFactory(GsonConverterFactory.create(new Gson())).build();
        InterRetrofit retrofitInter = retrofit.create(InterRetrofit.class);
        Call<HYFBBean> leftBeanCall = retrofitInter.loadHYFBBean(factory_id,shi_id,customer_id,send_time,goods_type,require_truck_weight,require_truck_length,require_truck_type,offer_price);

        leftBeanCall.enqueue(callback);
    }

    public void loadTJKHZLBean(Callback<TJKHZLBean> callback, String uid, String member_type, String company_name, String contacts, String tel, String province, String city, String address){
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();
        Retrofit retrofit = new Retrofit.Builder().client(okHttpClient).baseUrl(UrlConfig.HOME).addConverterFactory(GsonConverterFactory.create(new Gson())).build();
        InterRetrofit retrofitInter = retrofit.create(InterRetrofit.class);
        Call<TJKHZLBean> leftBeanCall = retrofitInter.loadTJKHZLBean(uid,member_type,company_name,contacts,tel,province,city,address);

        leftBeanCall.enqueue(callback);
    }

    public void loadSCKHZLBean(Callback<SCKHZLBean> callback, String uid, String member_type, String cus_id){
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();
        Retrofit retrofit = new Retrofit.Builder().client(okHttpClient).baseUrl(UrlConfig.HOME).addConverterFactory(GsonConverterFactory.create(new Gson())).build();
        InterRetrofit retrofitInter = retrofit.create(InterRetrofit.class);
        Call<SCKHZLBean> leftBeanCall = retrofitInter.loadSCKHZLBean(uid,member_type,cus_id);

        leftBeanCall.enqueue(callback);
    }


    public void loadBXBean(Callback<BXBean> callback, String insure_name, String insure_tel, String recognizee_name, String recognizee_tel, String plate_number, String yun_number, String sum_assured, String good_basic, String goods_quantity, String goods_name, String goods_pack, String goods_value, String yun_start, String yun_end, String create_time){
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();
        Retrofit retrofit = new Retrofit.Builder().client(okHttpClient).baseUrl(UrlConfig.HOME).addConverterFactory(GsonConverterFactory.create(new Gson())).build();
        InterRetrofit retrofitInter = retrofit.create(InterRetrofit.class);
        Call<BXBean> leftBeanCall = retrofitInter.loadBXBean(insure_name, insure_tel, recognizee_name, recognizee_tel, plate_number, yun_number, sum_assured, good_basic, goods_quantity, goods_name, goods_pack, goods_value, yun_start, yun_end, create_time);

        leftBeanCall.enqueue(callback);
    }

    public void loadCLRZBean(Callback<CLRZBean> callback, String id,
                             RequestBody id_card_a, RequestBody id_card_b,
                             RequestBody drive_card_a, RequestBody drive_card_b
                             ){
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();
        Retrofit retrofit = new Retrofit.Builder().client(okHttpClient).baseUrl(UrlConfig.HOME).addConverterFactory(GsonConverterFactory.create(new Gson())).build();
        InterRetrofit retrofitInter = retrofit.create(InterRetrofit.class);
        Call<CLRZBean> leftBeanCall = retrofitInter.loadCLRZBean(id, id_card_a,id_card_b,drive_card_a,drive_card_b);

        leftBeanCall.enqueue(callback);
    }

    public void loadSJRZ1Bean(Callback<SJRZ1Bean> callback, String factory_id, String name,
                             String tel, String plate_number, String weight,
                             String length, String type, String advantage_way,
                             String register_place){
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();
        Retrofit retrofit = new Retrofit.Builder().client(okHttpClient).baseUrl(UrlConfig.HOME).addConverterFactory(GsonConverterFactory.create(new Gson())).build();
        InterRetrofit retrofitInter = retrofit.create(InterRetrofit.class);
        Call<SJRZ1Bean> leftBeanCall = retrofitInter.loadSJRZ1Bean(factory_id,name,tel,
                plate_number,weight,length,type,advantage_way, register_place);

        leftBeanCall.enqueue(callback);
    }

    public void loadGenBean(Callback<GenBean> callback, String app_id, String version_id,String version_mini){
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();
        Retrofit retrofit = new Retrofit.Builder().client(okHttpClient).baseUrl(UrlConfig.HOME).addConverterFactory(GsonConverterFactory.create(new Gson())).build();
        InterRetrofit retrofitInter = retrofit.create(InterRetrofit.class);
        Call<GenBean> leftBeanCall = retrofitInter.loadGenBean(app_id,version_id,version_mini);
        leftBeanCall.enqueue(callback);
    }
}
