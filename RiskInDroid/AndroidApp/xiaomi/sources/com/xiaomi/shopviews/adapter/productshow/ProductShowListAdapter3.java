package com.xiaomi.shopviews.adapter.productshow;

import _m_j.duh;
import _m_j.ewn;
import _m_j.ewt;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.xiaomi.shopviews.widget.customfont.CustomTextView;
import com.xiaomi.smarthome.R;
import java.util.ArrayList;

public class ProductShowListAdapter3 extends RecyclerView.O000000o<O000000o> {

    /* renamed from: O000000o  reason: collision with root package name */
    public ArrayList<ewn.O000000o> f3926O000000o = new ArrayList<>();
    private Context O00000Oo;

    public /* synthetic */ void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, int i) {
        O000000o o000000o = (O000000o) o000OOo0;
        ewn.O000000o o000000o2 = this.f3926O000000o.get(i);
        if (!TextUtils.isEmpty(o000000o2.O00000Oo)) {
            duh.O000000o().O000000o(ewt.O000000o(o000000o2.O00000Oo), o000000o.f3927O000000o);
        }
        o000000o.O00000Oo.setText(o000000o2.f15894O000000o);
        o000000o.O00000o0.setText(o000000o2.O00000o0);
        if (!TextUtils.isEmpty(o000000o2.O00000o) && !o000000o2.O00000o0.equals(o000000o2.O00000o)) {
            o000000o.O00000o.setText(o000000o2.O00000o);
            o000000o.O00000o.getPaint().setAntiAlias(true);
            o000000o.O00000o.getPaint().setFlags(16);
        }
    }

    public ProductShowListAdapter3(Context context) {
        this.O00000Oo = context;
    }

    public int getItemCount() {
        return this.f3926O000000o.size();
    }

    static class O000000o extends RecyclerView.O000OOo0 {

        /* renamed from: O000000o  reason: collision with root package name */
        ImageView f3927O000000o;
        CustomTextView O00000Oo;
        CustomTextView O00000o;
        CustomTextView O00000o0;

        O000000o(View view) {
            super(view);
            this.f3927O000000o = (ImageView) view.findViewById(R.id.item_image);
            this.O00000Oo = (CustomTextView) view.findViewById(R.id.item_title);
            this.O00000o0 = (CustomTextView) view.findViewById(R.id.item_price);
            this.O00000o = (CustomTextView) view.findViewById(R.id.item_price_origin);
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public /* synthetic */ RecyclerView.O000OOo0 onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new O000000o(LayoutInflater.from(this.O00000Oo).inflate((int) R.layout.product_show_view_adapter_item_3, viewGroup, false));
    }
}
