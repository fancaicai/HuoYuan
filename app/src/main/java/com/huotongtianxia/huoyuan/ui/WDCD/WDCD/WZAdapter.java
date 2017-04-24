package com.huotongtianxia.huoyuan.ui.WDCD.WDCD;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.huotongtianxia.huoyuan.R;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/4/1 0001.
 */

public class WZAdapter extends BaseAdapter {
    private Context context;
    private LayoutInflater inflater;
    private List<String> list1 = null;

    public WZAdapter(Context context,List<String> list1) {
        this.context = context;
        this.list1 = list1;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list1.size();
    }

    @Override
    public Object getItem(int i) {
        return list1.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = null;
        if (view == null) {
            view = inflater.inflate(R.layout.item_wz, null);
            holder = new ViewHolder(view);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        holder.itemWzText2.setText(list1.get(i));
        return view;
    }

    static class ViewHolder {
        @Bind(R.id.item_wz_text2)
        TextView itemWzText2;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
