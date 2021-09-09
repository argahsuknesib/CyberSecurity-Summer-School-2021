package com.xiaomi.shopviews.adapter.productshow;

import _m_j.duh;
import _m_j.ewm;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.xiaomi.shopviews.widget.customfont.CustomTextView;
import com.xiaomi.smarthome.R;
import java.util.ArrayList;
import java.util.List;

public class HomeHotAccessoriesListAdapter extends RecyclerView.O000000o<O000000o> {

    /* renamed from: O000000o  reason: collision with root package name */
    public List<ewm.O000000o> f3920O000000o = new ArrayList();
    private Context O00000Oo;

    public /* synthetic */ void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, int i) {
        O000000o o000000o = (O000000o) o000OOo0;
        ewm.O000000o o000000o2 = this.f3920O000000o.get(i);
        if (i <= 2 || i != this.f3920O000000o.size() - 1) {
            o000000o.O00000oO.setVisibility(8);
        } else {
            o000000o.O00000oO.setVisibility(0);
        }
        o000000o.f3922O000000o.setText(o000000o2.f15892O000000o);
        o000000o.itemView.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.shopviews.adapter.productshow.HomeHotAccessoriesListAdapter.AnonymousClass1 */

            public final void onClick(View view) {
            }
        });
        o000000o.O00000o0.setText(o000000o2.O00000o);
        o000000o.O00000o.setText(o000000o2.O00000o);
        o000000o.O00000o.getPaint().setAntiAlias(true);
        o000000o.O00000o.getPaint().setFlags(16);
        duh.O000000o().O000000o(o000000o2.O00000o0, o000000o.O00000Oo);
    }

    public HomeHotAccessoriesListAdapter(Context context) {
        this.O00000Oo = context;
    }

    public int getItemCount() {
        return this.f3920O000000o.size();
    }

    static class O000000o extends RecyclerView.O000OOo0 {

        /* renamed from: O000000o  reason: collision with root package name */
        CustomTextView f3922O000000o;
        ImageView O00000Oo;
        CustomTextView O00000o;
        CustomTextView O00000o0;
        CustomTextView O00000oO;

        O000000o(View view) {
            super(view);
            this.f3922O000000o = (CustomTextView) view.findViewById(R.id.product_name);
            this.O00000Oo = (ImageView) view.findViewById(R.id.product_image);
            this.O00000o0 = (CustomTextView) view.findViewById(R.id.tv_price_new);
            this.O00000o = (CustomTextView) view.findViewById(R.id.tv_price_origin);
            this.O00000oO = (CustomTextView) view.findViewById(R.id.tv_more);
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public /* synthetic */ RecyclerView.O000OOo0 onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new O000000o(LayoutInflater.from(this.O00000Oo).inflate((int) R.layout.hot_accessories_adapter_list_item, viewGroup, false));
    }
}
