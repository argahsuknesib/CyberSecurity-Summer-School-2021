package com.xiaomi.shopviews.adapter.countdown;

import _m_j.duh;
import _m_j.ewj;
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

public class CrowdfundingMultipleAdapter extends RecyclerView.O000000o<O000000o> {

    /* renamed from: O000000o  reason: collision with root package name */
    public List<ewj.O000000o> f3910O000000o = new ArrayList();
    private Context O00000Oo;

    public /* synthetic */ void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, int i) {
        O000000o o000000o = (O000000o) o000OOo0;
        ewj.O000000o o000000o2 = this.f3910O000000o.get(i);
        o000000o.f3912O000000o.setText(o000000o2.O00000o0);
        o000000o.itemView.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.shopviews.adapter.countdown.CrowdfundingMultipleAdapter.AnonymousClass1 */

            public final void onClick(View view) {
            }
        });
        duh.O000000o().O000000o(o000000o2.f15887O000000o, o000000o.O00000Oo);
    }

    public CrowdfundingMultipleAdapter(Context context) {
        this.O00000Oo = context;
    }

    public int getItemCount() {
        return this.f3910O000000o.size();
    }

    static class O000000o extends RecyclerView.O000OOo0 {

        /* renamed from: O000000o  reason: collision with root package name */
        CustomTextView f3912O000000o;
        ImageView O00000Oo;

        O000000o(View view) {
            super(view);
            this.f3912O000000o = (CustomTextView) view.findViewById(R.id.product_name);
            this.O00000Oo = (ImageView) view.findViewById(R.id.product_img);
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public /* synthetic */ RecyclerView.O000OOo0 onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new O000000o(LayoutInflater.from(this.O00000Oo).inflate((int) R.layout.crowdfunding_multiple_adapter_list_item, viewGroup, false));
    }
}
