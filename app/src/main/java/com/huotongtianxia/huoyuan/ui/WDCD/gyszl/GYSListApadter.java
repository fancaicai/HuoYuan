package com.huotongtianxia.huoyuan.ui.WDCD.gyszl;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.huotongtianxia.huoyuan.R;
import com.huotongtianxia.huoyuan.bean.FHRBean;
import com.huotongtianxia.huoyuan.bean.GYSBean;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/1/17 0017.
 */

public class GYSListApadter extends BaseAdapter {
    private Context context;
    private List<FHRBean.DataBean> list = null;
    private LayoutInflater inflater;

    public GYSListApadter(Context context, List<FHRBean.DataBean> list) {
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
            view = inflater.inflate(R.layout.item_gys, null);
            holder = new ViewHolder(view);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        holder.khzlText2.setText(list.get(i).getName());
        holder.khzlText3.setText(list.get(i).getTel());
        holder.khzlText5.setText(list.get(i).getProvince()+"-"+list.get(i).getCity()+"-"+list.get(i).getArea()+","+list.get(i).getAddress());
        /**
         * id : 57
         * name : 1
         * tel : 2
         * province : 3
         * city : 4
         * area : 5
         * address : 6
         */
        return view;
    }

    public void reload(List _list) {
        list.addAll(_list);
        notifyDataSetChanged();
    }

    static class ViewHolder {
        @Bind(R.id.khzl_text2)
        TextView khzlText2;
        @Bind(R.id.khzl_text3)
        TextView khzlText3;
        @Bind(R.id.khzl_text5)
        TextView khzlText5;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
