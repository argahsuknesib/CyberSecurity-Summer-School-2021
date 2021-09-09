package com.xiaomi.shopviews.adapter.productshow;

import _m_j.duh;
import _m_j.dui;
import _m_j.eum;
import _m_j.ewr;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.xiaomi.base.imageloader.Option;
import com.xiaomi.shopviews.widget.customfont.CustomTextView;
import com.xiaomi.smarthome.R;
import java.util.ArrayList;
import java.util.List;

public class ProductShowListAdapter1 extends RecyclerView.O000000o<O000000o> {

    /* renamed from: O000000o  reason: collision with root package name */
    public List<ewr.O000000o> f3923O000000o;
    eum O00000Oo;
    private Context O00000o;
    public ewr O00000o0;

    public /* synthetic */ void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, final int i) {
        O000000o o000000o = (O000000o) o000OOo0;
        if (i == 0) {
            o000000o.f3925O000000o.setVisibility(0);
        } else {
            o000000o.f3925O000000o.setVisibility(8);
        }
        final ewr.O000000o o000000o2 = this.f3923O000000o.get(i);
        o000000o.O00000o.setVisibility(8);
        o000000o.O00000Oo.setText(o000000o2.O00000o);
        o000000o.itemView.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.shopviews.adapter.productshow.ProductShowListAdapter1.AnonymousClass1 */

            public final void onClick(View view) {
                ProductShowListAdapter1 productShowListAdapter1 = ProductShowListAdapter1.this;
                String str = productShowListAdapter1.O00000o0.O00000Oo;
                ewr.O000000o o000000o = o000000o2;
                if (productShowListAdapter1.O00000Oo != null) {
                    productShowListAdapter1.O00000Oo.O000000o(str, o000000o, "");
                }
                ProductShowListAdapter1 productShowListAdapter12 = ProductShowListAdapter1.this;
                String format = String.format("place%s_click", Integer.valueOf(i + 1));
                if (productShowListAdapter12.O00000Oo != null) {
                    productShowListAdapter12.O00000Oo.O000000o(format, "reconmend_bar");
                }
            }
        });
        dui O000000o2 = duh.O000000o();
        String str = o000000o2.O00000Oo;
        ImageView imageView = o000000o.O00000o0;
        Option option = new Option();
        option.O00000Oo = R.drawable.default_pic_small_inverse;
        O000000o2.O000000o(str, imageView, option);
        String str2 = this.O00000o0.O00000Oo;
        eum eum = this.O00000Oo;
        if (eum != null) {
            eum.O000000o(str2, o000000o2);
        }
    }

    public ProductShowListAdapter1(Context context, ewr ewr, eum eum) {
        this(context);
        this.O00000o0 = ewr;
        this.O00000Oo = eum;
    }

    public ProductShowListAdapter1(Context context) {
        this.f3923O000000o = new ArrayList();
        this.O00000o = context;
    }

    public int getItemCount() {
        return this.f3923O000000o.size();
    }

    static class O000000o extends RecyclerView.O000OOo0 {

        /* renamed from: O000000o  reason: collision with root package name */
        View f3925O000000o;
        CustomTextView O00000Oo;
        CustomTextView O00000o;
        ImageView O00000o0;

        O000000o(View view) {
            super(view);
            this.f3925O000000o = view.findViewById(R.id.left_view);
            this.O00000Oo = (CustomTextView) view.findViewById(R.id.product_name);
            this.O00000o0 = (ImageView) view.findViewById(R.id.product_image);
            this.O00000o = (CustomTextView) view.findViewById(R.id.tv_more);
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public /* synthetic */ RecyclerView.O000OOo0 onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new O000000o(LayoutInflater.from(this.O00000o).inflate((int) R.layout.product_show_adapter_list_item_1, viewGroup, false));
    }
}
