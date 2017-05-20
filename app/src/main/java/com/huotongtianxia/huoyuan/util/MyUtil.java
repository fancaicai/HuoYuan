package com.huotongtianxia.huoyuan.util;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.text.Html;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.huotongtianxia.huoyuan.R;

import org.xutils.image.ImageOptions;
import org.xutils.x;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Gjl on 2016/7/7 10:41.
 */
public class MyUtil {

    public static String str;

    //根据作业题目的提交数和老师的批改数判断作业的状态
    public static String getCorrectType(int total, int correct){
        String str=null;
        if(total==0){
            //未交
           str="未交";
        }else {
            if(total==correct){
                //已批改
                str="已批";
            }else{
                str="未批";
            }
        }
        return str;
    }

    //根据作业题目的提交数和老师的批改数判断作业的状态(新版）
    public static String getCorrectType(int correct){
        String str=null;
        switch (correct){
            case 0:
                str="未交";
                break;
            case 1:
                str="未批";
                break;
            case 2:
                str="已批";
                break;
            default:
                break;
        }
        return str;
    }

    // 设置加载图片的参数
  public static ImageOptions imageOptions = new ImageOptions.Builder()
            .setSize(org.xutils.common.util.DensityUtil.dip2px(120), org.xutils.common.util.DensityUtil.dip2px(120))
            // 是否忽略GIF格式的图片
            .setIgnoreGif(false)
                    // 图片缩放模式
//                .setCrop(true)
            .setImageScaleType(ImageView.ScaleType.CENTER_CROP)
                    // 下载中显示的图片
            .setLoadingDrawableId(R.drawable.img_loading)
                    // 下载失败显示的图片
            .setFailureDrawableId(R.drawable.img_loading)
                    // 得到ImageOptions对象
            .build();
    // 设置加载图片的参数
    public static ImageOptions imageYuanOptions = new ImageOptions.Builder()
            //.setSize(org.xutils.common.com.example.administrator.freedomlearing.util.DensityUtil.dip2px(120), org.xutils.common.com.example.administrator.freedomlearing.util.DensityUtil.dip2px(120))
            // 是否忽略GIF格式的图片
            .setIgnoreGif(false)
            // 图片缩放模式
//                .setCrop(true)
            .setImageScaleType(ImageView.ScaleType.CENTER)
            // 下载中显示的图片
            .setLoadingDrawableId(R.drawable.img_loading)
            // 下载失败显示的图片
            .setFailureDrawableId(R.drawable.img_loading)
            // 得到ImageOptions对象
            .build();

//    // 设置加载方形头像的参数
//    public static ImageOptions headOptions = new ImageOptions.Builder()
//            .setSize(org.xutils.common.util.DensityUtil.dip2px(120), org.xutils.common.util.DensityUtil.dip2px(120))
//                    // 是否忽略GIF格式的图片
//            .setIgnoreGif(false)
//                    // 图片缩放模式
////            .setCrop(true)
//            .setImageScaleType(ImageView.ScaleType.CENTER_CROP)
//                    // 下载中显示的图片
//            .setLoadingDrawableId(R.drawable.square_head_loading)
//                    // 下载失败显示的图片
//            .setFailureDrawableId(R.drawable.square_head_loading)
//                    // 得到ImageOptions对象
//            .build();
//
//    // 设置加载头像的参数
//    public static ImageOptions headCircleOptions = new ImageOptions.Builder()
//            .setSize(org.xutils.common.util.DensityUtil.dip2px(120), org.xutils.common.util.DensityUtil.dip2px(120))
//            // 是否忽略GIF格式的图片
//            .setIgnoreGif(false)
//            // 图片缩放模式
//            .setCrop(false)
////            .setImageScaleType(ImageView.ScaleType.CENTER_CROP)
//            // 下载中显示的图片
//            .setLoadingDrawableId(R.drawable.head_loading)
//            // 下载失败显示的图片
//            .setFailureDrawableId(R.drawable.head_loading)
//            // 得到ImageOptions对象
//            .build();


    //TextView中的图片处理
   public static Html.ImageGetter imageGetter = new Html.ImageGetter() {

        public Drawable getDrawable(String source) {
            Drawable drawable = null;
            URL url;
            try {
                url = new URL(source);
                drawable = Drawable.createFromStream(url.openStream(), "");
            } catch (Exception e) {
//                String[] splitAddress = source.split(",");
//                byte[] img = Base64.decode(splitAddress[1].getBytes(),
//                        Base64.DEFAULT);
//                Bitmap bitmap;
//                if (img != null) {
//
//                    // ByteArrayInputStream bais = new
//                    // ByteArrayInputStream(img);
//                    // drawable= Drawable.createFromStream(bais, "img");
//                    Log.i("图文混排解析", "******解析已经执行");
//                    bitmap = BitmapFactory.decodeByteArray(img, 0, img.length);
//                    drawable = new BitmapDrawable(bitmap);
//                }
                e.printStackTrace();
            }
            if (drawable != null) {
                drawable.setBounds(0, 0, 5 * drawable.getIntrinsicWidth(),
                        5 * drawable.getIntrinsicHeight());
            } else {
                //com.example.administrator.freedomlearing.handler.post(toast);
            }
            return drawable;
        }
    };

    //处理Textview中的<img />标签
    public static CharSequence imgFromHtml(String str){
        return Html.fromHtml(str, imageGetter, null);
    }

    //上传图片
//    public static String  imgUpload(String url,String imgPath, final String tag){
//
//
//        RequestParams params = new RequestParams(url);
//        params.setMultipart(true);
//        params.addBodyParameter(
//                "file",
//                new OpenFile(imgPath),
//                null);
//        x.http().post(params, new Callback.CommonCallback<String>() {
//            @Override
//            public void onSuccess(String result) {
//
//             str=result;
//
//            }
//
//            @Override
//            public void onError(Throwable ex, boolean isOnCallback) {
//
//                Log.i(tag, ex.getMessage());
//            }
//
//            @Override
//            public void onCancelled(CancelledException cex) {
//
//                Log.i(tag,"cancelled");
//            }
//
//            @Override
//            public void onFinished() {
//
//            }
//        });
//            return str;
//
//    }

    //md5加密
    public static String md5(String string) {
        byte[] hash;
        try {
            hash = MessageDigest.getInstance("MD5").digest(string.getBytes("UTF-8"));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Huh, MD5 should be supported?", e);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("Huh, UTF-8 should be supported?", e);
        }

        StringBuilder hex = new StringBuilder(hash.length * 2);
        for (byte b : hash) {
            if ((b & 0xFF) < 0x10) hex.append("0");
            hex.append(Integer.toHexString(b & 0xFF));
        }
        return hex.toString();
    }

    //检测字符串中是否有汉字
    public static boolean matcherChinese(String str){

        Pattern pattern = Pattern.compile("[\u4E00-\u9FA5]");
        Matcher matcher = pattern.matcher(str);
        if(matcher.find()){
            return true;
        }else{
            return false;
        }
    }

    //根据月、日返回星座
    public static String getConstellation(int month, int day){
        String str=null;
        if ((month == 1 && day > 19) || (month == 2 && day < 19)) {
            str="水瓶座";
        } else if ((month == 2 && day > 18) || (month == 3 && day < 21)) {
            str="双鱼座";
        }
        else if ((month == 3 && day > 20) || (month == 4 && day < 20)) {
            str="白羊座";
        } else if ((month == 4 && day > 19) || (month == 5 && day < 21)) {
            str="金牛座";
        } else if ((month == 5 && day > 20) || (month == 6 && day < 22)) {
            str="双子座";
        } else if ((month == 6 && day > 21) || (month == 7 && day < 23)) {
            str="巨蟹座";
        } else if ((month == 7 && day > 22) || (month == 8 && day < 23)) {
            str="狮子座";
        } else if ((month == 8 && day > 22) || (month == 9 && day < 23)) {
            str="处女座";
        } else if ((month == 9 && day > 22) || (month == 10 && day < 24)) {
            str="天秤座";
        } else if ((month == 10 && day > 23) || (month == 11 && day < 23)) {
            str="天蝎座";
        } else if ((month == 11 && day > 22) || (month == 12 && day < 22)) {
            str="射手座";
        } else if ((month == 12 && day > 21) || (month == 1 && day < 20)) {
            str="摩羯座";
        }
        return str;
    }

    //若数字位数为1位在前面加0
    public static String addZero(int i){
        //String str=String.valueOf(i);
        StringBuffer buf=new StringBuffer(i);
        if(buf.length()<2){
            buf.insert(0,"0");
        }
        return buf.toString();
    }

    public static boolean emailValidate(String str){
        boolean flag = false;
        try{
            String check = "^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
            Pattern regex = Pattern.compile(check);
            Matcher matcher = regex.matcher(str);
            flag = matcher.matches();
        }catch(Exception e){
            flag = false;
        }
        return flag;
    }

    public static String getPercent(long total, long current){

        // 创建一个数值格式化对象

        NumberFormat numberFormat = NumberFormat.getInstance();

        // 设置精确到小数点后2位

        numberFormat.setMaximumFractionDigits(0);
        double d=(double)current / (double)total;
        String result = numberFormat.format(d*100)+"%";
        //Log.i("util进度",result);
        return result;
    }



    //根据上传文件的大小获得上传进度
    public static int getProgress(long total,long current){

        // 创建一个数值格式化对象

        NumberFormat numberFormat = NumberFormat.getInstance();

        // 设置精确到小数点后0位
        numberFormat.setMaximumFractionDigits(0);
        double d=(double)current / (double)total;
        int result= Integer.parseInt(numberFormat.format(d*100)) ;
        //Log.i("util进度",result);
        return result;
    }




//
//    //处理文本中的表情
//    public static SpannableString matcherFace(Context context, String str){
//
//        return  FaceConversionUtil.getInstace().getExpressionString(context,str);
//    }

    //kb转为M
    public static String kb2M(long total){

        // 创建一个数值格式化对象

        NumberFormat numberFormat = NumberFormat.getInstance();

        // 设置精确到小数点后0位
        numberFormat.setMaximumFractionDigits(2);
        double d=(double)total / (double)1024 / (double)1024;
        String result=numberFormat.format(d)+"M" ;
        return result;
    }



//    //跳转到视频播放
//    public static void toVideoPlady(Context context, String vuid){
//
//        Intent intent=new Intent(context, VideoPlayActivity.class);
//        Bundle mBundle = new Bundle();
//        // 配置播放类型为 点播
//        mBundle.putInt(PlayerParams.KEY_PLAY_MODE, PlayerParams.VALUE_PLAYER_VOD);
//        // UUID和VUID配置
//        mBundle.putString(PlayerParams.KEY_PLAY_UUID, MyApplication.uuid);
//        mBundle.putString(PlayerParams.KEY_PLAY_VUID, vuid.trim());
////                    mBundle.putString(PlayerParams.KEY_PLAY_CHECK_CODE, "");
////                    mBundle.putString(PlayerParams.KEY_PLAY_PAYNAME, "0");
////                    mBundle.putString(PlayerParams.KEY_PLAY_USERKEY, "151398");
////                    mBundle.putString(PlayerParams.KEY_PLAY_BUSINESSLINE, IS_SAAS ? "120" : "101");
//        intent.putExtra("data",mBundle);
//
//        context.startActivity(intent);
//    }

    //获取录音时长
    public static String getRecordTime(MediaPlayer mediaPlayer, String path){

        try {
            mediaPlayer.setDataSource(path);
            mediaPlayer.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ""+mediaPlayer.getDuration()/1000;
    }


    //单击点的Y超出View的底部就隐藏View
    public static boolean isHideMenu(View v, MotionEvent ev) {
        if (v != null) {
            int[] l = { 0, 0 };

            v.getLocationInWindow(l);
            //System.out.println("******" + l[1]+";"+v1.getHeight());
            int left = l[0], top = l[1], bottom = top + v.getHeight(), right = left
                    + v.getWidth();
            if (ev.getY() > bottom) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    public static void toastDataError(Context context){
        Toast.makeText(context,"请求失败,请稍后再试...", Toast.LENGTH_SHORT).show();
    }

    public static void toastInfo(String info){
        Toast.makeText(x.app(), info, Toast.LENGTH_SHORT).show();
    }

    public static String getDate(String date){

        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
        if(Check.checkNotNull(date)){
            Long temp= Long.parseLong(date);
            return dateFormat.format(temp);
        }else{
            return "";
        }
    }

    /**
     * 从asset路径下读取对应文件转String输出
     * @param mContext
     * @return
     */
    public static String getJson(Context mContext, String fileName) {

        StringBuilder sb = new StringBuilder();
        AssetManager am = mContext.getAssets();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    am.open(fileName)));
            String next = "";
            while (null != (next = br.readLine())) {
                sb.append(next);
            }
        } catch (IOException e) {

            e.printStackTrace();
            sb.delete(0, sb.length());
        }
        return sb.toString().trim();
    }

    /** * 删除方法 这里只会删除某个文件夹下的文件，如果传入的directory是个文件，将不做处理 * * @param directory */
    public static void deleteFilesByDirectory(File directory) {
        if (directory != null && directory.exists() && directory.isDirectory()) {
            for (File item : directory.listFiles()) {
                item.delete();
            }
        }
    }

}
