package com.mi.global.shop.adapter.user;

import _m_j.cad;
import android.content.Context;
import android.text.TextUtils;
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
import com.mi.global.shop.newmodel.user.coupon.NewCouponItem;
import com.xiaomi.smarthome.R;

public final class CouponListAdapter extends ArrayAdapter<NewCouponItem> {

    /* renamed from: O000000o  reason: collision with root package name */
    private String f4824O000000o;

    public class ViewHolder_ViewBinding implements Unbinder {

        /* renamed from: O000000o  reason: collision with root package name */
        private ViewHolder f4825O000000o;

        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            this.f4825O000000o = viewHolder;
            viewHolder.value = (TextView) Utils.findRequiredViewAsType(view, R.id.coupon_value, "field 'value'", TextView.class);
            viewHolder.name = (TextView) Utils.findRequiredViewAsType(view, R.id.coupon_name, "field 'name'", TextView.class);
            viewHolder.range = (TextView) Utils.findRequiredViewAsType(view, R.id.coupon_range, "field 'range'", TextView.class);
            viewHolder.time = (TextView) Utils.findRequiredViewAsType(view, R.id.coupon_time, "field 'time'", TextView.class);
            viewHolder.state = (ImageView) Utils.findRequiredViewAsType(view, R.id.coupon_state, "field 'state'", ImageView.class);
        }

        public void unbind() {
            ViewHolder viewHolder = this.f4825O000000o;
            if (viewHolder != null) {
                this.f4825O000000o = null;
                viewHolder.value = null;
                viewHolder.name = null;
                viewHolder.range = null;
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
        if (((NewCouponItem) obj) == null) {
            return null;
        }
        View inflate = LayoutInflater.from(context).inflate((int) R.layout.shop_coupon_item, viewGroup, false);
        inflate.setTag(new ViewHolder(inflate));
        return inflate;
    }

    public final /* synthetic */ void O000000o(View view, int i, Object obj) {
        NewCouponItem newCouponItem = (NewCouponItem) obj;
        if (newCouponItem != null) {
            ViewHolder viewHolder = (ViewHolder) view.getTag();
            viewHolder.value.setText(newCouponItem.valueDesc);
            viewHolder.name.setText(newCouponItem.couponNameDesc);
            if (TextUtils.isEmpty(newCouponItem.couponNameDesc)) {
                viewHolder.name.setVisibility(8);
            } else {
                viewHolder.name.setVisibility(0);
            }
            viewHolder.range.setText(newCouponItem.usableRange);
            String O000000o2 = O000000o(newCouponItem.beginTime);
            String O000000o3 = O000000o(newCouponItem.endTime);
            viewHolder.time.setText(O000000o2 + " - " + O000000o3);
            if ("coupon_choose".equalsIgnoreCase(this.f4824O000000o)) {
                if ("unused".equalsIgnoreCase(newCouponItem.stat)) {
                    if ("true".equalsIgnoreCase(newCouponItem.check_res)) {
                        viewHolder.state.setVisibility(8);
                        viewHolder.O000000o(true);
                        return;
                    }
                    viewHolder.state.setVisibility(0);
                    viewHolder.state.setImageResource(R.drawable.shop_disabled);
                    viewHolder.O000000o(false);
                } else if ("used".equalsIgnoreCase(newCouponItem.stat)) {
                    viewHolder.state.setVisibility(0);
                    viewHolder.state.setImageResource(R.drawable.shop_used);
                    viewHolder.O000000o(false);
                } else {
                    viewHolder.state.setVisibility(0);
                    viewHolder.state.setImageResource(R.drawable.shop_expired);
                    viewHolder.O000000o(false);
                }
            } else if ("unused".equalsIgnoreCase(newCouponItem.stat)) {
                viewHolder.state.setVisibility(8);
                viewHolder.O000000o(true);
            } else if ("used".equalsIgnoreCase(newCouponItem.stat)) {
                viewHolder.state.setVisibility(0);
                viewHolder.state.setImageResource(R.drawable.shop_used);
                viewHolder.O000000o(false);
            } else {
                viewHolder.state.setVisibility(0);
                viewHolder.state.setImageResource(R.drawable.shop_expired);
                viewHolder.O000000o(false);
            }
        }
    }

    public CouponListAdapter(Context context, String str) {
        super(context);
        this.f4824O000000o = str;
    }

    private static String O000000o(int i) {
        return cad.O000000o(Long.valueOf(((long) i) * 1000));
    }

    static class ViewHolder {
        @BindView(2131493218)
        TextView name;
        @BindView(2131493219)
        TextView range;
        @BindView(2131493220)
        ImageView state;
        @BindView(2131493221)
        TextView time;
        @BindView(2131493223)
        TextView value;

        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }

        public final void O000000o(boolean z) {
            this.value.setEnabled(z);
            this.name.setEnabled(z);
            this.range.setEnabled(z);
            this.time.setEnabled(z);
        }
    }
}
