package com.huotongtianxia.huoyuan.ui.WDCD.gszl;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;

import com.huotongtianxia.huoyuan.R;
import com.huotongtianxia.huoyuan.bean.DoorPhotoBean;
import com.huotongtianxia.huoyuan.bean.HuoYuanPhoto;
import com.huotongtianxia.huoyuan.bean.HuoyuanPhotoBean;
import com.huotongtianxia.huoyuan.common.adapter.GridAddimgAdapter;
import com.huotongtianxia.huoyuan.common.view.ProgressbarView;
import com.huotongtianxia.huoyuan.icallback.ICallbackAddimg;
import com.huotongtianxia.huoyuan.network.NetWorkRequest;
import com.huotongtianxia.huoyuan.util.Check;
import com.huotongtianxia.huoyuan.util.Path;
import com.huotongtianxia.huoyuan.util.RxUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import me.nereo.multi_image_selector.MultiImageSelector;
import me.nereo.multi_image_selector.MultiImageSelectorActivity;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

import static com.huotongtianxia.huoyuan.MyApplication.REQUEST_IMAGE;

public class PhotosActivity extends AppCompatActivity implements ICallbackAddimg {



    @Bind(R.id.photos_grid)
    GridView photosGrid;
    List<Map<String, String>> dataImgs;
    GridAddimgAdapter gridAddimgAdapter;
    private int numPhoto=1;//上传的照片数量
    private ProgressbarView progressbarView;

    @OnClick(R.id.photos_back)
    void back(){
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photos);
        ButterKnife.bind(this);
        init();
    }

    private void init() {

        Intent intent=getIntent();
        numPhoto=intent.getIntExtra("numPhoto",1);
        dataImgs=new ArrayList<Map<String,String>>();
        Map<String, String> map = new HashMap<String, String>();
        map.put("suo", "assets://grid_addimage.png");
        map.put("yuan", "assets://grid_addimage.png");
        dataImgs.add(map);
        progressbarView=new ProgressbarView(this);
        progressbarView.showDialog();
        //根据门头还是货源进行不同的设置
        if(1==numPhoto){
            photosGrid.setNumColumns(1);
            RxUtils.subscription = NetWorkRequest.getDoorImgs("89", "door")
                    .subscribe(new Subscriber<DoorPhotoBean>() {
                        @Override
                        public void onCompleted() {

                            progressbarView.dismissDialog();
                            gridAddimgAdapter=new GridAddimgAdapter(PhotosActivity.this,dataImgs,PhotosActivity.this);
                            gridAddimgAdapter.setNumPhoto(numPhoto);
                            photosGrid.setAdapter(gridAddimgAdapter);
                        }

                        @Override
                        public void onError(Throwable e) {

                        }

                        @Override
                        public void onNext(DoorPhotoBean doorPhotoBean) {

                                Map<String, String> map = new HashMap<String, String>();
                                map.put("suo", doorPhotoBean.getData().getDoor());
                                map.put("yuan", doorPhotoBean.getData().getDoor());
                                dataImgs.add(0, map);
                            progressbarView.dismissDialog();
                            gridAddimgAdapter=new GridAddimgAdapter(PhotosActivity.this,dataImgs,PhotosActivity.this);
                            gridAddimgAdapter.setNumPhoto(numPhoto);
                            photosGrid.setAdapter(gridAddimgAdapter);
                        }
                    });
        }else{
            photosGrid.setNumColumns(2);
            RxUtils.subscription = NetWorkRequest.getHuoyuanImgs("89", "photo")
                    .subscribe(new Subscriber<HuoyuanPhotoBean>() {
                        @Override
                        public void onCompleted() {

                            progressbarView.dismissDialog();
                            gridAddimgAdapter=new GridAddimgAdapter(PhotosActivity.this,dataImgs,PhotosActivity.this);
                            gridAddimgAdapter.setNumPhoto(numPhoto);
                            photosGrid.setAdapter(gridAddimgAdapter);
                        }

                        @Override
                        public void onError(Throwable e) {

                        }

                        @Override
                        public void onNext(HuoyuanPhotoBean huoyuanPhotoBean) {

                           HuoyuanPhotoBean.DataBean dataBean= huoyuanPhotoBean.getData();
                            Map<String, String> map;
                            if(Check.checkNotNull(dataBean.getPhoto())){
                                map= new HashMap<String, String>();
                                map.put("suo", dataBean.getPhoto());
                                map.put("yuan", dataBean.getPhoto());
                                dataImgs.add(0, map);
                            }
                            if(Check.checkNotNull(dataBean.getPhoto2())){
                                map= new HashMap<String, String>();
                                map.put("suo", dataBean.getPhoto2());
                                map.put("yuan", dataBean.getPhoto2());
                                dataImgs.add(0, map);
                            }
                            if(Check.checkNotNull(dataBean.getPhoto3())){
                                map= new HashMap<String, String>();
                                map.put("suo", dataBean.getPhoto3());
                                map.put("yuan", dataBean.getPhoto3());
                                dataImgs.add(0, map);
                            }
                            if(Check.checkNotNull(dataBean.getPhoto4())){
                                map= new HashMap<String, String>();
                                map.put("suo", dataBean.getPhoto4());
                                map.put("yuan", dataBean.getPhoto4());
                                dataImgs.add(0, map);
                            }
                            if(Check.checkNotNull(dataBean.getPhoto5())){
                                map= new HashMap<String, String>();
                                map.put("suo", dataBean.getPhoto5());
                                map.put("yuan", dataBean.getPhoto5());
                                dataImgs.add(0, map);
                            }
                            if(Check.checkNotNull(dataBean.getPhoto6())){
                                map= new HashMap<String, String>();
                                map.put("suo", dataBean.getPhoto6());
                                map.put("yuan", dataBean.getPhoto6());
                                dataImgs.add(0, map);
                            }
                            progressbarView.dismissDialog();
                            gridAddimgAdapter=new GridAddimgAdapter(PhotosActivity.this,dataImgs,PhotosActivity.this);
                            gridAddimgAdapter.setNumPhoto(numPhoto);
                            photosGrid.setAdapter(gridAddimgAdapter);
                        }
                    });
        }





    }

    @Override
    public void addImg() {
        MultiImageSelector.create(this)
                .count(numPhoto) // 最大选择图片数量, 默认为9. 只有在选择模式为多选时有效
                .multi() // 多选模式, 默认模式;
                .start(this, REQUEST_IMAGE);
    }

    @Override
    public void notifyDataSetChanged() {

        gridAddimgAdapter.notifyDataSetChanged();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_IMAGE){
            if(resultCode == RESULT_OK){

                // 获取返回的图片列表
                final List<String> path = data.getStringArrayListExtra(MultiImageSelectorActivity.EXTRA_RESULT);
                // 处理你自己的逻辑
                Observable.create(new Observable.OnSubscribe<List<String>>() {

                    @Override
                    public void call(Subscriber<? super List<String>> subscriber) {
                        subscriber.onNext(getimage(path));
                        subscriber.onCompleted();
                    }
                })
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Action1<List<String>>() {
                            @Override
                            public void call(List<String> strings) {

                                RxUtils.unsubscribe();
                                if (1 == numPhoto) {
                                    RxUtils.subscription = NetWorkRequest.uploadImgs("89",strings, "door")
                                            .subscribe(new Subscriber<HuoYuanPhoto>() {
                                                @Override
                                                public void onCompleted() {

                                                }

                                                @Override
                                                public void onError(Throwable e) {

                                                }

                                                @Override
                                                public void onNext(HuoYuanPhoto huoYuanPhoto) {

                                                    for (String str : path) {
                                                        Map<String, String> map = new HashMap<String, String>();
                                                        map.put("suo", str);
                                                        map.put("yuan", str);
                                                        dataImgs.add(0, map);
                                                    }
                                                    gridAddimgAdapter.notifyDataSetChanged();
                                                }
                                            });
                                }else{

                                    RxUtils.subscription = NetWorkRequest.uploadImgs("89",strings, "photo")
                                            .subscribe(new Subscriber<HuoYuanPhoto>() {
                                                @Override
                                                public void onCompleted() {

                                                }

                                                @Override
                                                public void onError(Throwable e) {

                                                }

                                                @Override
                                                public void onNext(HuoYuanPhoto huoYuanPhoto) {

                                                    for (String str : path) {
                                                        Map<String, String> map = new HashMap<String, String>();
                                                        map.put("suo", str);
                                                        map.put("yuan", str);
                                                        dataImgs.add(0, map);
                                                    }
                                                    gridAddimgAdapter.notifyDataSetChanged();
                                                }
                                            });
                                }

                            }
                        });



            }
        }
    }

    /**
     * 图片按比例大小压缩方法
     *
     *
     * @return
     */
    private List<String>  getimage(List<String> srcPaths) {

        List<String> yasuoPaths=new ArrayList<String>();
        for(String srcPath:srcPaths) {
            BitmapFactory.Options newOpts = new BitmapFactory.Options();
            // 开始读入图片，此时把options.inJustDecodeBounds 设回true了
            newOpts.inJustDecodeBounds = true;
            Bitmap bitmap = BitmapFactory.decodeFile(srcPath, newOpts);// 此时返回bm为空

            newOpts.inJustDecodeBounds = false;
            int w = newOpts.outWidth;
            int h = newOpts.outHeight;
            // 现在主流手机比较多是800*480分辨率，所以高和宽我们设置为
            float hh = 800f;// 这里设置高度为800f
            float ww = 480f;// 这里设置宽度为480f
            // 缩放比。由于是固定比例缩放，只用高或者宽其中一个数据进行计算即可
            int be = 1;// be=1表示不缩放
            if (w > h && w > ww) {// 如果宽度大的话根据宽度固定大小缩放
                be = (int) (newOpts.outWidth / ww);
            } else if (w < h && h > hh) {// 如果高度高的话根据宽度固定大小缩放
                be = (int) (newOpts.outHeight / hh);
            }
            if (be <= 0)
                be = 1;
            newOpts.inSampleSize = be;// 设置缩放比例
            // 重新读入图片，注意此时已经把options.inJustDecodeBounds 设回false了
            bitmap = BitmapFactory.decodeFile(srcPath, newOpts);
//
//            //图片允许最大空间   单位：KB
//            double maxSize =1024.00;
//            //将bitmap放至数组中，意在bitmap的大小（与实际读取的原文件要大）
//            ByteArrayOutputStream baos = new ByteArrayOutputStream();
//            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
//            byte[] b = baos.toByteArray();
//            //将字节换成KB
//            double mid = bitmap.getByteCount()/1024;
//            //判断bitmap占用空间是否大于允许最大空间  如果大于则压缩 小于则不压缩
//            if (mid > maxSize) {
//                //获取bitmap大小 是允许最大大小的多少倍
//                double i = mid / maxSize;
//                //开始压缩  此处用到平方根 将宽带和高度压缩掉对应的平方根倍 （1.保持刻度和高度和原bitmap比率一致，压缩后也达到了最大大小占用空间的大小）
//                bitmap = zoomImage(bitmap, bitmap.getWidth() / Math.sqrt(i),
//                        bitmap.getHeight() / Math.sqrt(i));
//            }

            String path=Path.getYasuo()+srcPath.substring(srcPath.lastIndexOf("/"));
            File outputFile=new File(path);
            FileOutputStream out = null;
            try {
                out = new FileOutputStream(outputFile);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            bitmap.compress(Bitmap.CompressFormat.JPEG, 50, out);
            yasuoPaths.add(path);
        }
        return yasuoPaths;// 压缩好比例大小后再进行质量压缩
    }

    /***
     * 图片的缩放方法
     *
     * @param bgimage
     *            ：源图片资源
     * @param newWidth
     *            ：缩放后宽度
     * @param newHeight
     *            ：缩放后高度
     * @return
     */
//    public static Bitmap zoomImage(Bitmap bgimage, double newWidth,
//                                   double newHeight) {
//        // 获取这个图片的宽和高
//        float width = bgimage.getWidth();
//        float height = bgimage.getHeight();
//        // 创建操作图片用的matrix对象
//        Matrix matrix = new Matrix();
//        // 计算宽高缩放率
//        float scaleWidth = ((float) newWidth) / width;
//        float scaleHeight = ((float) newHeight) / height;
//        // 缩放图片动作
//        matrix.postScale(scaleWidth, scaleHeight);
//        Bitmap bitmap = Bitmap.createBitmap(bgimage, 0, 0, (int) width,
//                (int) height, matrix, true);
//        return bitmap;
//    }
}
