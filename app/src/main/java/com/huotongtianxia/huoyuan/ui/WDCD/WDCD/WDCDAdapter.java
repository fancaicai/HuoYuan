package com.huotongtianxia.huoyuan.ui.WDCD.WDCD;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.huotongtianxia.huoyuan.R;
import com.huotongtianxia.huoyuan.bean.WDCDBean;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/1/18 0018.
 */

public class WDCDAdapter extends BaseAdapter {
    private Context context;
    private List<WDCDBean.DataBean> list = null;
    private LayoutInflater inflater;

    public WDCDAdapter(Context context, List<WDCDBean.DataBean> list) {
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
        }else {
            holder = (ViewHolder) view.getTag();
        }
        final int driver_id = list.get(i).getDriver_id();
        Glide.with(context).load(list.get(i).getHeadimgurl()).into(holder.wdcdItemImg);
        holder.wdcdItemText1.setText(list.get(i).getName());
        holder.wdcdItemText2.setText(list.get(i).getTel());
        holder.wdcdItemText3.setText(list.get(i).getPlate_number());
        holder.wdcdItemText4.setText(list.get(i).getLength());
        holder.wdcdItemText5.setText(list.get(i).getType());
        holder.wdcdItemText6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, WZActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("driver_id",driver_id);
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });
        return view;
    }

    public void reload(List _list) {
        list.addAll(_list);
        notifyDataSetChanged();
    }

    static class ViewHolder {
        private TextView wdcdItemText6,wdcdItemText5,wdcdItemText4,wdcdItemText3,wdcdItemText2,wdcdItemText1;
        private ImageView wdcdItemImg;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
            wdcdItemText6 = (TextView) view.findViewById(R.id.wdcd_item_text6);
            wdcdItemText5 = (TextView) view.findViewById(R.id.wdcd_item_text5);
            wdcdItemText4 = (TextView) view.findViewById(R.id.wdcd_item_text4);
            wdcdItemText3 = (TextView) view.findViewById(R.id.wdcd_item_text3);
            wdcdItemText2 = (TextView) view.findViewById(R.id.wdcd_item_text2);
            wdcdItemText1 = (TextView) view.findViewById(R.id.wdcd_item_text1);
            wdcdItemImg = (ImageView) view.findViewById(R.id.wdcd_item_img);


        }
    }
}
