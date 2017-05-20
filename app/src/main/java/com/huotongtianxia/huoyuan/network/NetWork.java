package com.huotongtianxia.huoyuan.network;


import com.huotongtianxia.huoyuan.util.LogUtils;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.ResponseBody;
import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * 类描述:    [网络操作接口的实现]
 * 创建人:    Gjl
 * 创建时间:  2016/8/7 18:28
 * 修改人:
 * 修改时间:  2016/8/7 18:28
 * 修改备注:  [说明本次修改内容]
 * 版本:      [v1.0]
 */
public class NetWork {

    private static API api;
    private static final Converter.Factory gsonConverterFactory = GsonConverterFactory.create();
    private static final CallAdapter.Factory rxJavaCallAdapterFactory = RxJavaCallAdapterFactory.create();

//
//    //测试
//    public static API getApiTest() {
//        if (api == null) {
//            api = getRetrofit(URLHttp.servertest).create(API.class);
//        }
//        return api;
//    }


    public static API getApi() {
        if (api == null) {
            api = getRetrofit(URLHttp.server).create(API.class);
        }
        return api;
    }


    private static Retrofit getRetrofit(String baseUrl) {

        return new Retrofit.Builder()
                .client(new OkHttpClient.Builder().addInterceptor(new LogInterceptor()).build())
                .baseUrl(baseUrl)
                .addConverterFactory(gsonConverterFactory)
                .addCallAdapterFactory(rxJavaCallAdapterFactory)
                .build();
    }



    public static API getApi1() {
        if (api == null) {
            api = getRetrofit1(URLHttp.server).create(API.class);
        }
        return api;
    }

    private static Retrofit getRetrofit1(String baseUrl) {

        return new Retrofit.Builder()
                .client(new OkHttpClient.Builder().addInterceptor(new LogInterceptor()).build())
                .baseUrl(baseUrl)
               // .addConverterFactory(gsonConverterFactory)
               // .addCallAdapterFactory(rxJavaCallAdapterFactory)
                .build();
    }

    private static class LogInterceptor implements Interceptor {
        @Override
        public okhttp3.Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            LogUtils.i("LogUtils--> ", "request:" + request.toString());
            okhttp3.Response response = chain.proceed(chain.request());
            okhttp3.MediaType mediaType = response.body().contentType();
            String content = response.body().string();
            LogUtils.i("LogUtils--> ", "response body:" + content);
            if (response.body() != null) {
                ResponseBody body = ResponseBody.create(mediaType, content);
                return response.newBuilder().body(body).build();
            } else {
                return response;
            }
        }
    }
}
