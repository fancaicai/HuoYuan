package com.huotongtianxia.huoyuan.ui.WDCD.sscl;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.huotongtianxia.huoyuan.R;
import com.huotongtianxia.huoyuan.bean.WDCDSCBean;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/4/18 0018.
 */

public class WDCDSSAdapter extends BaseAdapter {
    private Context context;
    private List<WDCDSCBean.DataBean> list = null;
    private LayoutInflater inflater;

    public WDCDSSAdapter(Context context, List<WDCDSCBean.DataBean> list) {
        this.context = context;
        this.list = list;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = null;
        if (view == null) {
            view = inflater.inflate(R.layout.item_wdcd, null);
            holder = new ViewHolder(view);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        Glide.with(context).load(list.get(i).getHeadimgurl()).into(holder.wdcdItemImg);
        holder.wdcdItemText1.setText(list.get(i).getName());
        holder.wdcdItemText2.setText(list.get(i).getTel());
        holder.wdcdItemText3.setText(list.get(i).getPlate_number());
        int length = list.get(i).getLength();
//        holder.wdcdItemText4.setText(length);
        holder.wdcdItemText5.setText(list.get(i).getType());
        return view;
    }

    public void reload(List _list) {
        list.addAll(_list);
        notifyDataSetChanged();
    }

    static class ViewHolder {
        @Bind(R.id.wdcd_item_img)
        ImageView wdcdItemImg;
        @Bind(R.id.wdcd_item_text1)
        TextView wdcdItemText1;
        @Bind(R.id.wdcd_item_text2)
        TextView wdcdItemText2;
        @Bind(R.id.wdcd_item_text3)
        TextView wdcdItemText3;
        @Bind(R.id.wdcd_item_text4)
        TextView wdcdItemText4;
        @Bind(R.id.wdcd_item_text5)
        TextView wdcdItemText5;
        @Bind(R.id.wdcd_item_text6)
        TextView wdcdItemText6;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}