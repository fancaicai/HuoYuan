package com.huotongtianxia.huoyuan.ui.WDCD.ddgz;

import android.app.ProgressDialog;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;



import com.amap.api.maps2d.AMap;

import com.amap.api.maps2d.MapView;
import com.amap.api.maps2d.model.BitmapDescriptorFactory;
import com.amap.api.maps2d.model.LatLng;
import com.amap.api.maps2d.model.Marker;
import com.amap.api.maps2d.model.MarkerOptions;

import com.amap.api.services.geocoder.GeocodeResult;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.amap.api.services.geocoder.RegeocodeResult;
import com.huotongtianxia.huoyuan.R;
import com.huotongtianxia.huoyuan.bean.SJLIDWBean;
import com.huotongtianxia.huoyuan.util.ToastUtil;


import java.util.List;
import java.util.concurrent.ExecutorService;

import butterknife.Bind;
import butterknife.ButterKnife;

public class DdgzActivity extends AppCompatActivity implements AMap.OnMarkerClickListener, GeocodeSearch.OnGeocodeSearchListener,DdgzView {
    private Marker mCurrentMarker;
    private Marker regeoMarker;
    private GeocodeSearch geocoderSearch;
    private ExecutorService mExecutorService;
    private String item;
    private View infoWindow ;
    private String item1;
    private Marker currentMark;
    private double lng;
    private double lat;
    private AMap aMap = null;
    private ProgressDialog progDialog = null;
     @Bind(R.id.wz_mapview)
     MapView mMapView;

    @Override
    public void showMessage(String msg) {
        ToastUtil.show(getApplicationContext(),msg);
    }

    @Override
    public void setData(List<SJLIDWBean> list) {
        if (list.size()>1) {
            SJLIDWBean sjlidwBean = list.get(0);
            lng = sjlidwBean.lng;
            lat = sjlidwBean.lat;
        }

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ddgz);
        ButterKnife.bind(this);
        //在activity执行onCreate时执行mMapView.onCreate(savedInstanceState)，创建地图
        mMapView.onCreate(savedInstanceState);

//        初始化地图相关
        initMapView();


    }


    private void initMapView() {

        if (aMap == null) {
            aMap = mMapView.getMap();
            LatLng latLng = new LatLng(lng,lat);
//            final Marker marker = aMap.addMarker(new MarkerOptions().position(latLng).title("北京").snippet("DefaultMarker"));
            MarkerOptions markerOption = new MarkerOptions();
            markerOption.title("北京市").snippet("北京市：34.341568, 108.940174").position(latLng);
            markerOption.draggable(true);//设置Marker可拖动
            markerOption.icon(BitmapDescriptorFactory.fromBitmap(BitmapFactory
                    .decodeResource(getResources(),R.drawable.dir13)));
            // 将Marker设置为贴地显示，可以双指下拉地图查看效果
//            markerOption.setFlat(true);//设置marker平贴地图效果
             aMap.addMarker(markerOption);
//自定义 infoWindo
            AMap.InfoWindowAdapter infoWindowAdapter=new AMap.InfoWindowAdapter() {
                /**
                 * 监听自定义infowindow窗口的infowindow事件回调
                 */

                @Override
                public View getInfoWindow(Marker marker) {
                    if(infoWindow == null) {
                        infoWindow = LayoutInflater.from(DdgzActivity.this).inflate(
                                R.layout.custom_info_window, null);
                    }
                    View infowindowtitle = infoWindow.findViewById(R.id.infowindows_title);
                    View info = infoWindow.findViewById(R.id.infowindows_info);
                    return infoWindow;
                }
                /**
                 * 监听自定义infowindow窗口的infocontents事件回调
                 */
                @Override
                public View getInfoContents(Marker marker) {
                    return null;
                }
            };
            aMap.setInfoWindowAdapter(infoWindowAdapter);
            aMap.setOnMarkerClickListener(this);
        }
        geocoderSearch = new GeocodeSearch(this);
        geocoderSearch.setOnGeocodeSearchListener(this);
        progDialog = new ProgressDialog(this);
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
        if (mExecutorService != null) {
            mExecutorService.shutdownNow();
        }
    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        if (currentMark!=null) {
            infoWindow.setVisibility(View.INVISIBLE);
        }
        currentMark=marker;
        marker.showInfoWindow();
        return false;
    }
    @Override
    public void onRegeocodeSearched(RegeocodeResult result, int rCode) {

    }

    @Override
    public void onGeocodeSearched(GeocodeResult geocodeResult, int i) {

    }

}
