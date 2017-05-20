package com.huotongtianxia.huoyuan.util;

import android.os.Environment;

import java.io.File;

/**
 * 1.文件路径操作类
 * 2.包含获取文件的后缀
 * 3.判断文件是否存在
 * Created by Gjl on 2016/6/2.
 */
public class Path {

    private static final String PATHVIDEO="/AndyDemo/ScreenImage";

    public static String getYasuo() {
        String savePath = getSDCardPath() + "/HuoYuan/Yasuo/";
        File path = new File(savePath);
        if (!path.exists()) {
            path.mkdirs();
        }
        return savePath;
    }

    public static String getPathvideo() {

        String savePath = getSDCardPath() + "/FreedomLearing/Video/";
        File path = new File(savePath);
        if (!path.exists()) {
            path.mkdirs();
        }
        return savePath;
    }

    public static String getPathFujian() {

        String savePath = getSDCardPath() + "/FreedomLearing/Fujian/";
        File path = new File(savePath);
        if (!path.exists()) {
            path.mkdirs();
        }
        return savePath;
    }

    public static String getPathSpeech() {

        String savePath = getSDCardPath() + "/FreedomLearing/Speech/";
        File path = new File(savePath);
        if (!path.exists()) {
            path.mkdirs();
        }
        return savePath;
    }

    public static String getPathPdf() {

        String savePath = getSDCardPath() + "/FreedomLearing/PDF/";
        File path = new File(savePath);
        if (!path.exists()) {
            path.mkdirs();
        }
        return savePath;
    }

    /**
     * 获取SDCard的目录路径功能
     *
     * @return
     */
    private static String getSDCardPath() {
        File sdcardDir = null;
        //判断SDCard是否存在
        boolean sdcardExist = Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);
        if (sdcardExist) {
            sdcardDir = Environment.getExternalStorageDirectory();
        }
        return sdcardDir.toString();
    }

    //获取文件的后缀
    public static String getPostfix(String filePath){

        String postfix="";
        int dotIndex = filePath.lastIndexOf(".");
        if(dotIndex < 0){
            return postfix;
        }
        postfix=filePath.substring(filePath.lastIndexOf("."));
        return postfix;
    }


    //获取文件名
    public static String getFileName(String filePath){

        String name="";
        int dotIndex = filePath.lastIndexOf(".");
        if(dotIndex < 0){
            return name;
        }
        name=filePath.substring(filePath.lastIndexOf("/")+1);
        return name;
    }

    public static boolean fileIsExists(String filepath){
        try{
            File f=new File(filepath);
            if(!f.exists()){
                return false;
            }

        }catch (Exception e) {

            return false;
        }
        return true;
    }
}
