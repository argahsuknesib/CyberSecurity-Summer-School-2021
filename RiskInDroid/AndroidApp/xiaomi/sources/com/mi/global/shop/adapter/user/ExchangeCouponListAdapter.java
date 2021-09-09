package com.mi.global.shop.adapter.user;

import _m_j.cad;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.mi.global.shop.adapter.util.ArrayAdapter;
import com.mi.global.shop.newmodel.user.exchangecoupon.coupon.NewExchangeCouponItem;
import com.xiaomi.smarthome.R;

public final class ExchangeCouponListAdapter extends ArrayAdapter<NewExchangeCouponItem> {

    /* renamed from: O000000o  reason: collision with root package name */
    private String f4826O000000o;
    private Context O00000Oo;

    public class ViewHolder_ViewBinding implements Unbinder {

        /* renamed from: O000000o  reason: collision with root package name */
        private ViewHolder f4827O000000o;

        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            this.f4827O000000o = viewHolder;
            viewHolder.value = (TextView) Utils.findRequiredViewAsType(view, R.id.coupon_value, "field 'value'", TextView.class);
            viewHolder.time = (TextView) Utils.findRequiredViewAsType(view, R.id.coupon_time, "field 'time'", TextView.class);
            viewHolder.state = (ImageView) Utils.findRequiredViewAsType(view, R.id.coupon_state, "field 'state'", ImageView.class);
        }

        public void unbind() {
            ViewHolder viewHolder = this.f4827O000000o;
            if (viewHolder != null) {
                this.f4827O000000o = null;
                viewHolder.value = null;
                viewHolder.time = null;
                viewHolder.state = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public final /* synthetic */ View O000000o(Context context, int i, Object obj, ViewGroup viewGroup) {
        if (((NewExchangeCouponItem) obj) == null) {
            return null;
        }
        View inflate = LayoutInflater.from(context).inflate((int) R.layout.shop_exchange_coupon_item, viewGroup, false);
        inflate.setTag(new ViewHolder(inflate));
        return inflate;
    }

    public final /* synthetic */ void O000000o(View view, int i, Object obj) {
        NewExchangeCouponItem newExchangeCouponItem = (NewExchangeCouponItem) obj;
        if (newExchangeCouponItem != null) {
            ViewHolder viewHolder = (ViewHolder) view.getTag();
            TextView textView = viewHolder.value;
            textView.setText(cad.O00000o0() + newExchangeCouponItem.amount);
            String O000000o2 = O000000o(newExchangeCouponItem.start_time);
            String O000000o3 = O000000o(newExchangeCouponItem.end_time);
            viewHolder.time.setText(O000000o2 + " - " + O000000o3);
        }
    }

    public ExchangeCouponListAdapter(Context context, String str) {
        super(context);
        this.f4826O000000o = str;
        this.O00000Oo = context;
    }

    private static String O000000o(int i) {
        return cad.O000000o(Long.valueOf(((long) i) * 1000));
    }

    static class ViewHolder {
        @BindView(2131493220)
        ImageView state;
        @BindView(2131493221)
        TextView time;
        @BindView(2131493223)
        TextView value;

        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
