package com.mi.global.shop.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.mi.global.shop.newmodel.user.address.SmartDetailItemData;
import com.mi.global.shop.widget.CustomTextView;
import com.xiaomi.smarthome.R;
import java.util.ArrayList;

public class DeliveryPopAdapter extends BaseAdapter {

    /* renamed from: O000000o  reason: collision with root package name */
    public ArrayList<SmartDetailItemData> f4736O000000o;
    public String O00000Oo;
    private Context O00000o0;

    public long getItemId(int i) {
        return (long) i;
    }

    public DeliveryPopAdapter(Context context) {
        this.O00000o0 = context;
    }

    public DeliveryPopAdapter(Context context, ArrayList<SmartDetailItemData> arrayList, String str) {
        this.O00000o0 = context;
        this.f4736O000000o = arrayList;
        this.O00000Oo = str;
    }

    public int getCount() {
        return this.f4736O000000o.size();
    }

    public Object getItem(int i) {
        return this.f4736O000000o.get(i);
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        O000000o o000000o;
        if (view == null) {
            o000000o = new O000000o();
            view2 = LayoutInflater.from(this.O00000o0).inflate((int) R.layout.shop_item_lv_pop_category, (ViewGroup) null);
            o000000o.f4737O000000o = (CustomTextView) view2.findViewById(R.id.tv_name);
            o000000o.O00000Oo = (CustomTextView) view2.findViewById(R.id.tv_detail);
            o000000o.O00000o0 = (ImageView) view2.findViewById(R.id.iv_select);
            view2.setTag(o000000o);
        } else {
            view2 = view;
            o000000o = (O000000o) view.getTag();
        }
        o000000o.O00000Oo.setText(this.f4736O000000o.get(i).address);
        o000000o.f4737O000000o.setText(this.f4736O000000o.get(i).shortName);
        if (!this.f4736O000000o.get(i).isServiceable) {
            o000000o.O00000o0.setImageResource(R.drawable.shop_cannotselected);
            o000000o.O00000Oo.setTextColor(this.O00000o0.getResources().getColor(R.color.delivery_tv_gray));
            o000000o.f4737O000000o.setTextColor(this.O00000o0.getResources().getColor(R.color.delivery_tv_gray));
        } else {
            o000000o.O00000Oo.setTextColor(this.O00000o0.getResources().getColor(R.color.delivery_tv_detail));
            o000000o.f4737O000000o.setTextColor(this.O00000o0.getResources().getColor(R.color.delivery_tv_name));
            if (this.f4736O000000o.get(i).id.equals(this.O00000Oo)) {
                o000000o.O00000o0.setImageResource(R.drawable.shop_selecetd);
            } else {
                o000000o.O00000o0.setImageResource(R.drawable.shop_unselecetd);
            }
        }
        return view2;
    }

    class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        TextView f4737O000000o;
        TextView O00000Oo;
        ImageView O00000o0;

        O000000o() {
        }
    }
}
