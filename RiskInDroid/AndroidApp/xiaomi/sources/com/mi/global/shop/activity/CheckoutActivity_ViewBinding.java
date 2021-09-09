package com.mi.global.shop.activity;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.mi.global.shop.widget.CustomButtonView;
import com.mi.global.shop.widget.CustomTextView;
import com.xiaomi.smarthome.R;

public class CheckoutActivity_ViewBinding implements Unbinder {

    /* renamed from: O000000o  reason: collision with root package name */
    private CheckoutActivity f4612O000000o;

    public CheckoutActivity_ViewBinding(CheckoutActivity checkoutActivity, View view) {
        this.f4612O000000o = checkoutActivity;
        checkoutActivity.addressView = Utils.findRequiredView(view, R.id.address_layout, "field 'addressView'");
        checkoutActivity.addressContent = Utils.findRequiredView(view, R.id.address_content, "field 'addressContent'");
        checkoutActivity.consigneeTextView = (CustomTextView) Utils.findRequiredViewAsType(view, R.id.consignee, "field 'consigneeTextView'", CustomTextView.class);
        checkoutActivity.phoneTextView = (CustomTextView) Utils.findRequiredViewAsType(view, R.id.phone, "field 'phoneTextView'", CustomTextView.class);
        checkoutActivity.addressTextView = (CustomTextView) Utils.findRequiredViewAsType(view, R.id.address, "field 'addressTextView'", CustomTextView.class);
        checkoutActivity.addressMarkView = Utils.findRequiredView(view, R.id.address_mask, "field 'addressMarkView'");
        checkoutActivity.addAddressView = Utils.findRequiredView(view, R.id.add_address, "field 'addAddressView'");
        checkoutActivity.addressTipLayout = Utils.findRequiredView(view, R.id.address_tip_layout, "field 'addressTipLayout'");
        checkoutActivity.codNotAvailableTextView = (CustomTextView) Utils.findRequiredViewAsType(view, R.id.COD_not_available, "field 'codNotAvailableTextView'", CustomTextView.class);
        checkoutActivity.addressErrorTextView = (CustomTextView) Utils.findRequiredViewAsType(view, R.id.address_error, "field 'addressErrorTextView'", CustomTextView.class);
        checkoutActivity.selectCouponView = Utils.findRequiredView(view, R.id.select_coupon_container, "field 'selectCouponView'");
        checkoutActivity.selectCouponTextView = (CustomTextView) Utils.findRequiredViewAsType(view, R.id.coupon, "field 'selectCouponTextView'", CustomTextView.class);
        checkoutActivity.selectExchangeCouponView = Utils.findRequiredView(view, R.id.select_exchange_coupon_container, "field 'selectExchangeCouponView'");
        checkoutActivity.selectExchangeCouponTextView = (CustomTextView) Utils.findRequiredViewAsType(view, R.id.select_exchange_coupon, "field 'selectExchangeCouponTextView'", CustomTextView.class);
        checkoutActivity.selectExchangeCouponTitleView = (CustomTextView) Utils.findRequiredViewAsType(view, R.id.select_exchange_coupon_title, "field 'selectExchangeCouponTitleView'", CustomTextView.class);
        checkoutActivity.subtotalTextView = (CustomTextView) Utils.findRequiredViewAsType(view, R.id.checkout_subtotal, "field 'subtotalTextView'", CustomTextView.class);
        checkoutActivity.shipTextView = (CustomTextView) Utils.findRequiredViewAsType(view, R.id.checkout_shipping, "field 'shipTextView'", CustomTextView.class);
        checkoutActivity.totalTextView = (CustomTextView) Utils.findRequiredViewAsType(view, R.id.checkout_total, "field 'totalTextView'", CustomTextView.class);
        checkoutActivity.promoteView = Utils.findRequiredView(view, R.id.promote_container, "field 'promoteView'");
        checkoutActivity.promoteTextView = (CustomTextView) Utils.findRequiredViewAsType(view, R.id.checkout_promote, "field 'promoteTextView'", CustomTextView.class);
        checkoutActivity.couponView = Utils.findRequiredView(view, R.id.coupon_container, "field 'couponView'");
        checkoutActivity.couponTextView = (CustomTextView) Utils.findRequiredViewAsType(view, R.id.checkout_coupon, "field 'couponTextView'", CustomTextView.class);
        checkoutActivity.exchangeCouponView = Utils.findRequiredView(view, R.id.exchange_coupon_container, "field 'exchangeCouponView'");
        checkoutActivity.exchangeCouponTextView = (CustomTextView) Utils.findRequiredViewAsType(view, R.id.checkout_exchange_coupon, "field 'exchangeCouponTextView'", CustomTextView.class);
        checkoutActivity.bottomTotalTextView = (CustomTextView) Utils.findRequiredViewAsType(view, R.id.bottom_total, "field 'bottomTotalTextView'", CustomTextView.class);
        checkoutActivity.placeOrderButton = (CustomButtonView) Utils.findRequiredViewAsType(view, R.id.place_order, "field 'placeOrderButton'", CustomButtonView.class);
        checkoutActivity.loadingView = Utils.findRequiredView(view, R.id.loading, "field 'loadingView'");
        checkoutActivity.fourDeliveryRelativeLayout = Utils.findRequiredView(view, R.id.select_four_hour_delivery, "field 'fourDeliveryRelativeLayout'");
        checkoutActivity.deliveryNameTextView = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_delivery, "field 'deliveryNameTextView'", TextView.class);
        checkoutActivity.gstRelativeLayout = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rl_gst, "field 'gstRelativeLayout'", RelativeLayout.class);
        checkoutActivity.gstTextView = (CustomTextView) Utils.findRequiredViewAsType(view, R.id.ctv_gst, "field 'gstTextView'", CustomTextView.class);
        checkoutActivity.noticeContainer = Utils.findRequiredView(view, R.id.notice_container, "field 'noticeContainer'");
        checkoutActivity.deliveryNotice = (CustomTextView) Utils.findRequiredViewAsType(view, R.id.delivery_notice, "field 'deliveryNotice'", CustomTextView.class);
        checkoutActivity.dividerView = Utils.findRequiredView(view, R.id.view_divider, "field 'dividerView'");
    }

    public void unbind() {
        CheckoutActivity checkoutActivity = this.f4612O000000o;
        if (checkoutActivity != null) {
            this.f4612O000000o = null;
            checkoutActivity.addressView = null;
            checkoutActivity.addressContent = null;
            checkoutActivity.consigneeTextView = null;
            checkoutActivity.phoneTextView = null;
            checkoutActivity.addressTextView = null;
            checkoutActivity.addressMarkView = null;
            checkoutActivity.addAddressView = null;
            checkoutActivity.addressTipLayout = null;
            checkoutActivity.codNotAvailableTextView = null;
            checkoutActivity.addressErrorTextView = null;
            checkoutActivity.selectCouponView = null;
            checkoutActivity.selectCouponTextView = null;
            checkoutActivity.selectExchangeCouponView = null;
            checkoutActivity.selectExchangeCouponTextView = null;
            checkoutActivity.selectExchangeCouponTitleView = null;
            checkoutActivity.subtotalTextView = null;
            checkoutActivity.shipTextView = null;
            checkoutActivity.totalTextView = null;
            checkoutActivity.promoteView = null;
            checkoutActivity.promoteTextView = null;
            checkoutActivity.couponView = null;
            checkoutActivity.couponTextView = null;
            checkoutActivity.exchangeCouponView = null;
            checkoutActivity.exchangeCouponTextView = null;
            checkoutActivity.bottomTotalTextView = null;
            checkoutActivity.placeOrderButton = null;
            checkoutActivity.loadingView = null;
            checkoutActivity.fourDeliveryRelativeLayout = null;
            checkoutActivity.deliveryNameTextView = null;
            checkoutActivity.gstRelativeLayout = null;
            checkoutActivity.gstTextView = null;
            checkoutActivity.noticeContainer = null;
            checkoutActivity.deliveryNotice = null;
            checkoutActivity.dividerView = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
