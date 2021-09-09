package com.mi.global.shop.user;

import android.content.Context;
import android.content.Intent;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import com.mi.global.shop.activity.TrackAcitvity;
import com.mi.global.shop.adapter.util.ArrayAdapter;
import com.mi.global.shop.newmodel.order.NewDeliversData;
import com.mi.global.shop.newmodel.order.NewOrderStatusInfo;
import com.mi.global.shop.widget.CustomButtonView;
import com.mi.global.shop.widget.CustomTextView;
import com.mi.global.shop.widget.NoScrollListView;
import com.xiaomi.smarthome.R;
import java.util.ArrayList;

public class OrderViewSuborderListViewAdapter extends ArrayAdapter<NewDeliversData> {

    /* renamed from: O000000o  reason: collision with root package name */
    private Context f4932O000000o;

    public int getItemViewType(int i) {
        return 1;
    }

    public int getViewTypeCount() {
        return 1;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, ?[OBJECT, ARRAY], int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public final /* synthetic */ View O000000o(Context context, int i, Object obj, ViewGroup viewGroup) {
        if (((NewDeliversData) obj) == null) {
            return null;
        }
        View inflate = LayoutInflater.from(this.f4932O000000o).inflate((int) R.layout.shop_orderview_suborder_item, (ViewGroup) null, false);
        O00000Oo o00000Oo = new O00000Oo();
        o00000Oo.f4934O000000o = inflate;
        o00000Oo.O00000Oo = (CustomTextView) inflate.findViewById(R.id.suborder_id);
        o00000Oo.O00000o0 = (CustomTextView) inflate.findViewById(R.id.suborder_status);
        o00000Oo.O00000oo = (CustomButtonView) inflate.findViewById(R.id.btn_track);
        o00000Oo.O00000o = (NoScrollListView) inflate.findViewById(R.id.suborder_items);
        inflate.setTag(o00000Oo);
        return inflate;
    }

    public final /* synthetic */ void O000000o(View view, int i, Object obj) {
        O00000Oo o00000Oo;
        NewDeliversData newDeliversData = (NewDeliversData) obj;
        if (newDeliversData != null && (o00000Oo = (O00000Oo) view.getTag()) != null) {
            String str = newDeliversData.deliver_id;
            O000000o o000000o = new O000000o(str, this.f4932O000000o, newDeliversData.order_status_info);
            CustomTextView customTextView = o00000Oo.O00000Oo;
            customTextView.setText(this.f4932O000000o.getString(R.string.orderview_suborderid) + " " + str);
            CustomTextView customTextView2 = o00000Oo.O00000o0;
            customTextView2.setText(Html.fromHtml(this.f4932O000000o.getString(R.string.orderview_order_status) + " <font color='#FF6700'>" + newDeliversData.order_status_info.info + "</font>"));
            if (TextUtils.isEmpty(newDeliversData.express_sn) || newDeliversData.express_sn.equals("0")) {
                o00000Oo.O00000oo.setVisibility(8);
            } else {
                o00000Oo.O00000oo.setVisibility(0);
                o00000Oo.O00000oo.setOnClickListener(o000000o);
            }
            o00000Oo.O00000oO = new OrderViewItemListViewAdapter(this.f4932O000000o);
            o00000Oo.O00000oO.O00000o0();
            o00000Oo.O00000oO.O000000o((ArrayList) newDeliversData.product);
            o00000Oo.O00000o.setAdapter((ListAdapter) o00000Oo.O00000oO);
        }
    }

    public OrderViewSuborderListViewAdapter(Context context) {
        super(context);
        this.f4932O000000o = context;
    }

    static class O00000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        View f4934O000000o;
        CustomTextView O00000Oo;
        NoScrollListView O00000o;
        CustomTextView O00000o0;
        OrderViewItemListViewAdapter O00000oO;
        CustomButtonView O00000oo;

        O00000Oo() {
        }
    }

    class O000000o implements View.OnClickListener {

        /* renamed from: O000000o  reason: collision with root package name */
        String f4933O000000o;
        NewOrderStatusInfo O00000Oo;
        Context O00000o0;

        public O000000o(String str, Context context, NewOrderStatusInfo newOrderStatusInfo) {
            this.f4933O000000o = str;
            this.O00000o0 = context;
            this.O00000Oo = newOrderStatusInfo;
        }

        public final void onClick(View view) {
            Intent intent = new Intent(this.O00000o0, TrackAcitvity.class);
            intent.putExtra("expresssn", this.f4933O000000o);
            if (this.O00000Oo.trace != null && this.O00000Oo.trace.size() > 0) {
                intent.putExtra("order_placed", this.O00000Oo.trace.get(0).time);
                intent.putExtra("order_paid", this.O00000Oo.trace.get(1).time);
            }
            this.O00000o0.startActivity(intent);
        }
    }
}
