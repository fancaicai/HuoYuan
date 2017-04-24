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

import com.huotongtianxia.huoyuan.R;
import com.huotongtianxia.huoyuan.bean.WDCD1Bean;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/2/16 0016.
 */

public class WDCD1Adapter extends BaseAdapter {
    private Context context;
    private List<WDCD1Bean.DataBean> list = null;
    private LayoutInflater inflater;

    public WDCD1Adapter(Context context, List<WDCD1Bean.DataBean> list) {
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
        final int driver_id = Integer.parseInt(list.get(i).getDriver_id());
        holder.wdcdItemText1.setText(list.get(i).getName());
        holder.wdcdItemText2.setText(list.get(i).getTel());
        holder.wdcdItemText3.setText(list.get(i).getPlate_number());
        String length = String.valueOf(list.get(i).getLength());
        holder.wdcdItemText4.setText(length);
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
