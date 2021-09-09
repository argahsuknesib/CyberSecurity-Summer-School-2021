package com.mi.global.shop.activity;

import android.view.View;
import android.widget.LinearLayout;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.mi.global.shop.widget.CustomTextView;
import com.xiaomi.smarthome.R;

public class OrderViewActivity_ViewBinding implements Unbinder {

    /* renamed from: O000000o  reason: collision with root package name */
    private OrderViewActivity f4655O000000o;

    public OrderViewActivity_ViewBinding(OrderViewActivity orderViewActivity, View view) {
        this.f4655O000000o = orderViewActivity;
        orderViewActivity.showTips = (CustomTextView) Utils.findRequiredViewAsType(view, R.id.show_tips, "field 'showTips'", CustomTextView.class);
        orderViewActivity.llNotice = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_notice, "field 'llNotice'", LinearLayout.class);
        orderViewActivity.showTag = (CustomTextView) Utils.findRequiredViewAsType(view, R.id.show_tag, "field 'showTag'", CustomTextView.class);
        orderViewActivity.tipsShadow = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.tips_shadow, "field 'tipsShadow'", LinearLayout.class);
        orderViewActivity.exchangeCouponGroup = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.orderview_exchange_couponLL, "field 'exchangeCouponGroup'", LinearLayout.class);
        orderViewActivity.exchangeCouponView = (CustomTextView) Utils.findRequiredViewAsType(view, R.id.orderview_exchange_coupon, "field 'exchangeCouponView'", CustomTextView.class);
    }

    public void unbind() {
        OrderViewActivity orderViewActivity = this.f4655O000000o;
        if (orderViewActivity != null) {
            this.f4655O000000o = null;
            orderViewActivity.showTips = null;
            orderViewActivity.llNotice = null;
            orderViewActivity.showTag = null;
            orderViewActivity.tipsShadow = null;
            orderViewActivity.exchangeCouponGroup = null;
            orderViewActivity.exchangeCouponView = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
