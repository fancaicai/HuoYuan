package com.huotongtianxia.huoyuan.icallback;

/**
 * GridAddimgAdapter中引用该接口
 * 主要实现12张图片的点击删除，根据图片数量自动伸缩Gridview的适配器
 * Created by Gjl on 2016/7/8 11:15.
 *
 */
public interface ICallbackAddimg {

    public void addImg();//点击添加图片按钮后添加图片
    public void notifyDataSetChanged();//点击删除按钮后adapter刷新
}
