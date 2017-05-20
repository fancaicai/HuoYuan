package com.huotongtianxia.huoyuan.ui.WDCD.zxcc;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.huotongtianxia.huoyuan.R;
import com.huotongtianxia.huoyuan.bean.ZXCCBBean;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/1/17 0017.
 */

public class ZXCCBAdapter extends BaseAdapter {
    private List<ZXCCBBean.DataBean> list;
    private Context context;
    private LayoutInflater inflater;

    public ZXCCBAdapter(Context context, List<ZXCCBBean.DataBean> list) {
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
            view = inflater.inflate(R.layout.item_zxcc_w, null);
            holder = new ViewHolder(view);
            view.setTag(holder);
        }else {
            holder = (ViewHolder) view.getTag();
        }
        List<ZXCCBBean.DataBean.PreferenceWayBean> preference_way=list.get(i).getPreference_way();
        if(preference_way.size()==2){

            holder.zxccWText2.setText(preference_way.get(1).getStart_city()+"、"+preference_way.get(1).getEnd_city()+";"+preference_way.get(0).getStart_city()+"、"+preference_way.get(0).getEnd_city());

        }else if(preference_way.size()==1){
            holder.zxccWText2.setText(preference_way.get(0).getStart_city()+"、"+preference_way.get(0).getEnd_city());
        }
        holder.zxccWText4.setText(list.get(i).getRegister_place());
        holder.zxccWText8.setText(list.get(i).getName());
        holder.zxccWText5.setText(list.get(i).getLength());
        holder.zxccWText6.setText(list.get(i).getWeight());
        holder.zxccWText7.setText(list.get(i).getType());
        holder.zxccWText10.setText(list.get(i).getPlate_number());
        holder.zxccwimg1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                call("03512340094");
            }
        });
        return view;
    }

    public void reload(List _list) {
        list.addAll(_list);
        notifyDataSetChanged();
    }

    static class ViewHolder {
        @Bind(R.id.zxcc_w_text2)
        TextView zxccWText2;
        @Bind(R.id.zxcc_w_text4)
        TextView zxccWText4;
        @Bind(R.id.zxcc_w_text5)
        TextView zxccWText5;
        @Bind(R.id.zxcc_w_text6)
        TextView zxccWText6;
        @Bind(R.id.zxcc_w_text7)
        TextView zxccWText7;
        @Bind(R.id.zxcc_w_text8)
        TextView zxccWText8;
        @Bind(R.id.zxcc_w_text10)
        TextView zxccWText10;
        private ImageView zxccwimg1;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
            zxccwimg1= (ImageView) view.findViewById(R.id.zxcc_w_img1);
        }
    }
    private void call(String phone) {
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+phone));
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }
}
