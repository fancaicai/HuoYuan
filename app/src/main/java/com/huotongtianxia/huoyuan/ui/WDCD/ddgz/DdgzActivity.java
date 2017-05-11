package com.huotongtianxia.huoyuan.ui.WDCD.ddgz;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Handler;
import android.os.SystemClock;
import android.provider.SyncStateContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.BounceInterpolator;
import android.view.animation.Interpolator;
import android.widget.Toast;


import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.location.CoordinateConverter;
import com.amap.api.location.DPoint;
import com.amap.api.maps2d.AMap;

import com.amap.api.maps2d.AMapOptions;
import com.amap.api.maps2d.AMapUtils;
import com.amap.api.maps2d.CameraUpdate;
import com.amap.api.maps2d.CameraUpdateFactory;
import com.amap.api.maps2d.MapView;
import com.amap.api.maps2d.Projection;
import com.amap.api.maps2d.model.BitmapDescriptor;
import com.amap.api.maps2d.model.BitmapDescriptorFactory;
import com.amap.api.maps2d.model.CameraPosition;
import com.amap.api.maps2d.model.LatLng;
import com.amap.api.maps2d.model.LatLngBounds;
import com.amap.api.maps2d.model.Marker;
import com.amap.api.maps2d.model.MarkerOptions;

import com.amap.api.maps2d.model.Text;
import com.amap.api.maps2d.model.TextOptions;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.geocoder.GeocodeResult;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.amap.api.services.geocoder.RegeocodeQuery;
import com.amap.api.services.geocoder.RegeocodeResult;
import com.huotongtianxia.huoyuan.R;
import com.huotongtianxia.huoyuan.bean.DDXQBean;
import com.huotongtianxia.huoyuan.bean.SJLIDWBean;
import com.huotongtianxia.huoyuan.ui.WDCD.WDCD.WZActivity;
import com.huotongtianxia.huoyuan.util.LogUtils;
import com.huotongtianxia.huoyuan.util.ToastUtil;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;

import butterknife.Bind;
import butterknife.ButterKnife;
//订单跟踪页面
public class DdgzActivity extends AppCompatActivity implements AMap.OnMarkerClickListener, GeocodeSearch.OnGeocodeSearchListener,DdgzView, AMap.OnMapLoadedListener, AMap.OnMarkerDragListener, AMap.OnInfoWindowClickListener, AMap.InfoWindowAdapter {
    private Marker mCurrentMarker;
    private GeocodeSearch geocoderSearch;
    private ExecutorService mExecutorService;
    private String item;
    private View infoWindow ;
    private String item1;
    private double lng;
    private double lat;
    private String Fac_point;
    private DDXQBean ddxqbean;
    private AMap aMap = null;
    private LatLng latLng,latLng1;
    private String extra;
    private DdgzPresreter mDdgzPresreter;
    private ProgressDialog progDialog = null;
    private  MarkerOptions markerOption;
    private  SJLIDWBean sjlidwBean;
    private String strlng1,strlat1;
    private Double lat1,lng1;
    private CameraUpdate mCameraUpdate;
    private AMapLocationClient mLocationClient = null;
    //声明AMapLocationClientOption对象
    public AMapLocationClientOption mLocationOption = null;
     @Bind(R.id.wz_mapview)
     MapView mMapView;
    private static final String KEY_TREASURE = "key_ddxq";
    /**
     * 对外提供一个方法，跳转到本页面
     * 规范一下传递的数据：需要什么参数就必须要传入
     */
    public static void open(Context context, String order_num) {
        Intent intent = new Intent(context, DdgzActivity.class);
        intent.putExtra(KEY_TREASURE,order_num );
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_NO_TITLE);
//        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            Window window = getWindow();
//            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS | WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
//            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN  | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
//            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
//            window.setStatusBarColor(Color.TRANSPARENT);
//        }
        setContentView(R.layout.activity_ddgz);
        mDdgzPresreter=new DdgzPresreter(this);
        ButterKnife.bind(this);
        extra = getIntent().getStringExtra(KEY_TREASURE );
        //设置希望展示的地图缩放级别
        //mCameraUpdate = CameraUpdateFactory.zoomTo(17);
        mCameraUpdate = CameraUpdateFactory.newCameraPosition(new CameraPosition(new LatLng(37.802357,112.551579),12,30,0));
        //在activity执行onCreate时执行mMapView.onCreate(savedInstanceState)，创建地图
        mMapView.onCreate(savedInstanceState);//此方法必须重写
//      初始化AMap对象
        initMapView();
        //初始化定位
        initlocation();

    }

    /**
     * 初始化定位
     *
     * @since 2.8.0
     * @author hongming.wang
     *
     */
    private void initlocation() {
        //初始化client
        mLocationOption = new AMapLocationClientOption();
        //设置定位参数
        mLocationClient.setLocationOption(getDefaultOption());
        // 设置定位监听
        mLocationClient.setLocationListener(locationListener);
    }
    /**
     * 定位监听
     */
    AMapLocationListener locationListener = new AMapLocationListener() {
        @Override
        public void onLocationChanged(AMapLocation loc) {
            if (loc!=null) {
                if (loc.getErrorCode()==0) {
                    Log.e("当前位置",loc.getStreetNum());//街道门牌号信息
                }else {
                    //定位失败时，可通过ErrCode（错误码）信息来确定失败的原因，errInfo是错误信息，详见错误码表。
                    Log.e("AmapError","location Error, ErrCode:"
                            + loc.getErrorCode() + ", errInfo:"
                            + loc.getErrorInfo());
                }
            }
        }
    };
    /**
     * 默认的定位参数
     * @since 2.8.0
     * @author hongming.wang
     *
     */
    private AMapLocationClientOption getDefaultOption(){
        AMapLocationClientOption mOption = new AMapLocationClientOption();
        mOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);//可选，设置定位模式，可选的模式有高精度、仅设备、仅网络。默认为高精度模式
        mOption.setGpsFirst(false);//可选，设置是否gps优先，只在高精度模式下有效。默认关闭
        mOption.setHttpTimeOut(30000);//可选，设置网络请求超时时间。默认为30秒。在仅设备模式下无效
        mOption.setInterval(2000);//可选，设置定位间隔。默认为2秒
        mOption.setNeedAddress(true);//可选，设置是否返回逆地理地址信息。默认是true
        mOption.setOnceLocation(false);//可选，设置是否单次定位。默认是false
        mOption.setOnceLocationLatest(false);//可选，设置是否等待wifi刷新，默认为false.如果设置为true,会自动变为单次定位，持续定位时不要使用
        AMapLocationClientOption.setLocationProtocol(AMapLocationClientOption.AMapLocationProtocol.HTTP);//可选， 设置网络请求的协议。可选HTTP或者HTTPS。默认为HTTP
        mOption.setSensorEnable(false);//可选，设置是否使用传感器。默认是false
        mOption.setWifiScan(true); //可选，设置是否开启wifi扫描。默认为true，如果设置为false会同时停止主动刷新，停止以后完全依赖于系统刷新，定位位置可能存在误差
        mOption.setLocationCacheEnable(true); //可选，设置是否使用缓存定位，默认为true
        return mOption;
    }
    /**
     * 初始化AMap对象
     */
    private void initMapView() {
        if (aMap == null) {
            aMap = mMapView.getMap();
            //设置希望展示的地图缩放级别
            aMap.moveCamera(mCameraUpdate);
            setUpMap();
        }
        mLocationClient=new AMapLocationClient(this.getApplicationContext());
        progDialog = new ProgressDialog(this);
        mDdgzPresreter.getSJlocation(extra);

    }

    private void setUpMap() {
        aMap.setOnMapLoadedListener(this);// 设置amap加载成功事件监听器
        aMap.setOnMarkerDragListener(this);// 设置marker可拖拽事件监听器
        aMap.setOnMapLoadedListener(this);// 设置amap加载成功事件监听器
        aMap.setOnMarkerClickListener(this);// 设置点击marker事件监听器
        aMap.setOnInfoWindowClickListener(this);// 设置点击infoWindow事件监听器
        aMap.setInfoWindowAdapter(this);// 设置自定义InfoWindow样式
    }

    private void jumpPoint(final Marker marker) {
        final Handler handler = new Handler();
        final long start = SystemClock.uptimeMillis();
        final long duration = 1500;
        final Interpolator interpolator = new BounceInterpolator();
        handler.post(new Runnable() {
            @Override
            public void run() {
                long elapsed = SystemClock.uptimeMillis() - start;
                float t = interpolator.getInterpolation((float) elapsed
                        / duration);
                marker.setPosition(new LatLng(lat, lng));
                aMap.invalidate();// 刷新地图
                if (t < 1.0) {
                    handler.postDelayed(this, 16);
                }
            }
        });
    }


    @Override
    protected void onResume() {
        super.onResume();
        //在activity执行onResume时执行mMapView.onResume ()，重新绘制加载地图
        mMapView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        //在activity执行onPause时执行mMapView.onPause ()，暂停地图的绘制
        mMapView.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mLocationClient.stopLocation();//停止定位后，本地定位服务并不会被销毁
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        //在activity执行onSaveInstanceState时执行mMapView.onSaveInstanceState (outState)，保存地图当前的状态
        mMapView.onSaveInstanceState(outState);
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        //在activity执行onDestroy时执行mMapView.onDestroy()，销毁地图
        mMapView.onDestroy();
        mLocationClient.onDestroy();//销毁定位客户端，同时销毁本地定位服务。
        if (mExecutorService != null) {
            mExecutorService.shutdownNow();
        }
    }

    /**
     * 对marker标注点点击响应事件
     */
    @Override
    public boolean onMarkerClick(final Marker marker) {
        return false;
    }
    @Override
    public void onRegeocodeSearched(RegeocodeResult result, int rCode) {

    }

    @Override
    public void onGeocodeSearched(GeocodeResult geocodeResult, int i) {

    }
    @Override
    public void showMessage(String msg) {
        ToastUtil.show(getApplicationContext(),msg);
    }

    @Override
    public void setData(SJLIDWBean sjlidwBean) {
        final Handler handler = new Handler();
        this.sjlidwBean=sjlidwBean;
//        获取司机的位置
        lat=Double.parseDouble(sjlidwBean.getData().getLat());
        lng=Double.parseDouble(sjlidwBean.getData().getLng());
        latLng=new LatLng(lat,lng);
        Log.e("纬度",lat+"");
        Log.e("经度",lng+"");
        //        获取厂家的位置
        Fac_point=sjlidwBean.getData().getFac_point();
        Log.e("厂家的位置",Fac_point+"");
//        对获取回来的厂家的位置进行字符的截取，应为请求回来的厂家位置是一个点，（111.22222,32.44444）这种格式必须进行截取
        String spStr[] = Fac_point.split(",");
        strlng1 = spStr[0];
        strlat1=spStr[1];
        lat1= Double.parseDouble(strlat1);
        lng1= Double.parseDouble(strlng1);
//        lat1=37.802357;
//        lng1=113.551579;
        latLng1=new LatLng(lat1,lng1);
        // 定义了一个配置 AMap 对象的参数类
        AMapOptions aMapOptions=new AMapOptions();
        // 设置了一个可视范围的初始化位置
// CameraPosition 第一个参数： 目标位置的屏幕中心点经纬度坐标。
// CameraPosition 第二个参数： 目标可视区域的缩放级别
// CameraPosition 第三个参数： 目标可视区域的倾斜度，以角度为单位。
// CameraPosition 第四个参数： 可视区域指向的方向，以角度为单位，从正北向顺时针方向计算，从0度到360度

        //两点间中点坐标
        double midLat=(lat+lat1)/2;
        double midLng=(lng+lng1)/2;

        //屏幕像素
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int widthPixels= dm.widthPixels;


        //mMapView=new MapView(DdgzActivity.this,aMapOptions);

        if (latLng!=null) {

            aMap.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory
                    .fromResource(R.mipmap.driver_icn)).anchor(0.5f, 0.5f)
                    .position(latLng).title("太原市")
                    .snippet( lat+","+lng+"").draggable(true));

        }else {
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    ToastUtil.show(getApplicationContext(),"数据获取失败");
                }
            },16);
        }

        if (latLng1!=null) {
            aMap.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory
                    .fromResource(R.mipmap.factory_icn)).anchor(0.5f,0.5f).position(latLng1).title("太原市").snippet(strlat1+","+strlng1).draggable(true));
        }else {
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    ToastUtil.show(getApplicationContext(),"数据获取失败");
                }
            },16);

        }

        //修正经度,纬度
//        if(lng<lng1){
//            lng-=0.01;
//            lng1+=0.01;
//        }else {
//            lng1-=0.01;
//            lng+=0.01;
//        }
//
//        if(lat<lat1){
//            lat-=0.01;
//            lat1+=0.01;
//        }else{
//            lat+=0.01;
//            lat1-=0.01;
//        }

        //起点和终点的距离
        LatLng start = new LatLng(lat, lng);
        LatLng end = new LatLng(lat1,lng1);
        float distance=  AMapUtils.calculateLineDistance(start, end);
        float scalePerPixel = aMap.getScalePerPixel();
        float scalePerPixel1=distance/widthPixels;

//        int scale= (int) (scalePerPixel1*12/scalePerPixel);
//        LogUtils.i("比例"," "+(scalePerPixel1/scalePerPixel)+";;;;;;"+scale+";;;;"+scalePerPixel);
        //mCameraUpdate = CameraUpdateFactory.newCameraPosition(new CameraPosition(new LatLng(midLat,midLng),scale,30,0));
        mCameraUpdate = CameraUpdateFactory.newLatLngBounds(LatLngBounds.builder().include(start).include(end).build(), 60);
        //aMapOptions.camera(new CameraPosition(latLng1,10f,0, 0));
        if (latLng1!=null)
        aMap.moveCamera(mCameraUpdate);
}
    /**
     * 监听amap地图加载成功事件回调
     */
    @Override
    public void onMapLoaded() {
        // 设置所有maker显示在当前可视区域地图中
        LatLngBounds bounds = new LatLngBounds.Builder()
                .include(latLng)
                .build();
        aMap.moveCamera(CameraUpdateFactory.newLatLngBounds(bounds, 10));
    }
//++++++++++++++++++++++marker可拖拽事件的监听++++++++++++++++
    @Override
    public void onMarkerDragStart(Marker marker) {

    }

    @Override
    public void onMarkerDrag(Marker marker) {
        String curDes = marker.getTitle() + "拖动时当前位置:(lat,lng)\n("
                + marker.getPosition().latitude + ","
                + marker.getPosition().longitude + ")";
//        markerText.setText(curDes);
    }

    @Override
    public void onMarkerDragEnd(Marker marker) {

    }
//+++++++++++++++++++++++点击infowindows点击事件的监听+++++++++++++++++
    @Override
    public void onInfoWindowClick(Marker marker) {
        ToastUtil.show(this, "你点击了infoWindow窗口" + marker.getTitle());
    }
    //+++++++++++++++++++++++点击infowindows点击事件的监听+++++++++++++++++
 //+++++++++++++++++++++ 设置自定义InfoWindow样式++++++++++++++++++++++++
    @Override
    public View getInfoWindow(Marker marker) {
        return null;
    }

    @Override
    public View getInfoContents(Marker marker) {
        return null;
    }
//+++++++++++++++++++++ 设置自定义InfoWindow样式++++++++++++++++++++++++
}
