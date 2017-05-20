package com.huotongtianxia.huoyuan.common.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.huotongtianxia.huoyuan.R;
import com.huotongtianxia.huoyuan.common.view.ImageBrowserActivity;
import com.huotongtianxia.huoyuan.icallback.ICallbackAddimg;
import com.huotongtianxia.huoyuan.util.MyUtil;

import org.xutils.x;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by Gjl on 2016/7/8 09:56.
 * 最多添加numPhoto张图片的GridView展现效果
 * 每张图片
 * 注意：使用处要实现ICallbackAddimg接口
 */
public class GridAddimgAdapter extends BaseAdapter {


    private Context context;
    private ICallbackAddimg callbackAddimg;
//    private boolean flagSubmit=false;//学案或作业的状态，默认未交，图片右上角显示删除按钮，末位显示添加图片
    private List<Map<String,String>> dataGrid;//说一说上传的图片
    private int numPhoto=1;//限制要显示的图片数量

    public GridAddimgAdapter(Context context, List<Map<String,String>> dataGrid, ICallbackAddimg callbackAddimg){

        this.context=context;
        this.dataGrid=dataGrid;
        this.callbackAddimg=callbackAddimg;

    }

//    public boolean isFlagSubmit() {
//        return flagSubmit;
//    }
//
//    public void setFlagSubmit(boolean flagSubmit) {
//        this.flagSubmit = flagSubmit;
//    }


    public int getNumPhoto() {
        return numPhoto;
    }

    public void setNumPhoto(int numPhoto) {
        this.numPhoto = numPhoto;
    }

    @Override
    public int getCount() {
        return dataGrid.size()>numPhoto?numPhoto:dataGrid.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }



    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        ViewHolder holder;
        if(convertView==null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_grid_img, null);
            holder=new ViewHolder();
            holder.img = (ImageView) convertView.findViewById(R.id.item_grid_img);
            holder.imgDel = (ImageView) convertView.findViewById(R.id.item_grid_delete);
            convertView.setTag(holder);
        }else{
            holder= (ViewHolder) convertView.getTag();
        }

//        if (flagSubmit) {
//            if (holder.imgDel.getVisibility() != View.GONE) {
//                holder.imgDel.setVisibility(View.GONE);
//            }
//            convertView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    toPictureBrowser(position);
//                }
//            });
//
//        } else {

            if(position == (dataGrid.size() - 1)) {
                if (holder.imgDel.getVisibility() != View.GONE) {
                    holder.imgDel.setVisibility(View.GONE);
                }
                convertView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        callbackAddimg.addImg();
                    }
                });
            }else{
                if (holder.imgDel.getVisibility() != View.VISIBLE) {
                    holder.imgDel.setVisibility(View.VISIBLE);
                }
                holder.imgDel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dataGrid.remove(position);
                        callbackAddimg.notifyDataSetChanged();
                    }
                });
                convertView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        toPictureBrowser(position);
                    }
                });
            }
//        }



        x.image().bind(holder.img, dataGrid.get(position).get("suo"), MyUtil.imageOptions);



        //隐藏“+”图片
        if ( position>=numPhoto) {
            if (convertView.getVisibility() != View.GONE) {
                convertView.setVisibility(View.GONE);
            }
        } else {
            if (convertView.getVisibility() != View.VISIBLE) {
                convertView.setVisibility(View.VISIBLE);
            }

        }

//        //一张照片改变高
//        if(1==numPhoto)
//            convertView.setMinimumHeight(convertView.getWidth());
        //Log.i("GridAddimgAdapter", "return convertView");
        return convertView;

    }



    static class ViewHolder{
        ImageView img;
        ImageView imgDel;
    }

   private void toPictureBrowser(int currentItem) {
        Intent intent = new Intent(context, ImageBrowserActivity.class);
        intent.putExtra("imglist",(Serializable)dataGrid);
        intent.putExtra("currentitem",currentItem);
        context.startActivity(intent);
    }
}