package com.mi.global.shop.activity;

import android.view.View;
import android.widget.LinearLayout;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.mi.global.shop.widget.CommonButton;
import com.mi.global.shop.widget.CustomButtonView;
import com.mi.global.shop.widget.CustomTextView;
import com.mi.global.shop.widget.NoScrollListView;
import com.xiaomi.smarthome.R;

public class ShoppingCartActivity_ViewBinding implements Unbinder {

    /* renamed from: O000000o  reason: collision with root package name */
    private ShoppingCartActivity f4696O000000o;

    public ShoppingCartActivity_ViewBinding(ShoppingCartActivity shoppingCartActivity, View view) {
        this.f4696O000000o = shoppingCartActivity;
        shoppingCartActivity.mHomeView = Utils.findRequiredView(view, R.id.title_bar_home, "field 'mHomeView'");
        shoppingCartActivity.loadingLL = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.cart_loadingLL, "field 'loadingLL'", LinearLayout.class);
        shoppingCartActivity.emptyLL = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.cart_emptyLL, "field 'emptyLL'", LinearLayout.class);
        shoppingCartActivity.bargainLL = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.cart_bargain, "field 'bargainLL'", LinearLayout.class);
        shoppingCartActivity.subtotalLayout = Utils.findRequiredView(view, R.id.subtotal_container, "field 'subtotalLayout'");
        shoppingCartActivity.promoteLayout = Utils.findRequiredView(view, R.id.promote_container, "field 'promoteLayout'");
        shoppingCartActivity.totalLayout = Utils.findRequiredView(view, R.id.total_container, "field 'totalLayout'");
        shoppingCartActivity.subtotalTV = (CustomTextView) Utils.findRequiredViewAsType(view, R.id.cart_subtotal, "field 'subtotalTV'", CustomTextView.class);
        shoppingCartActivity.promotionTV = (CustomTextView) Utils.findRequiredViewAsType(view, R.id.cart_promote, "field 'promotionTV'", CustomTextView.class);
        shoppingCartActivity.cartTotal = (CustomTextView) Utils.findRequiredViewAsType(view, R.id.cart_total, "field 'cartTotal'", CustomTextView.class);
        shoppingCartActivity.shippingTV = (CustomTextView) Utils.findRequiredViewAsType(view, R.id.cart_shipping, "field 'shippingTV'", CustomTextView.class);
        shoppingCartActivity.giftDivider = Utils.findRequiredView(view, R.id.cart_gift_divider, "field 'giftDivider'");
        shoppingCartActivity.offerDivider = Utils.findRequiredView(view, R.id.cart_offer_divider, "field 'offerDivider'");
        shoppingCartActivity.itemLV = (NoScrollListView) Utils.findRequiredViewAsType(view, R.id.cart_itemlist, "field 'itemLV'", NoScrollListView.class);
        shoppingCartActivity.giftLV = (NoScrollListView) Utils.findRequiredViewAsType(view, R.id.cart_giftlist, "field 'giftLV'", NoScrollListView.class);
        shoppingCartActivity.offerLV = (NoScrollListView) Utils.findRequiredViewAsType(view, R.id.cart_offerlist, "field 'offerLV'", NoScrollListView.class);
        shoppingCartActivity.bargainLV = (NoScrollListView) Utils.findRequiredViewAsType(view, R.id.cart_bargainlist, "field 'bargainLV'", NoScrollListView.class);
        shoppingCartActivity.mainFrame = Utils.findRequiredView(view, R.id.cart_main_frame, "field 'mainFrame'");
        shoppingCartActivity.viewBtn = (CommonButton) Utils.findRequiredViewAsType(view, R.id.cart_viewbtn, "field 'viewBtn'", CommonButton.class);
        shoppingCartActivity.checkoutBtn = (CustomButtonView) Utils.findRequiredViewAsType(view, R.id.cart_checkout, "field 'checkoutBtn'", CustomButtonView.class);
        shoppingCartActivity.cartBottomView = Utils.findRequiredView(view, R.id.cart_bottom_layout, "field 'cartBottomView'");
        shoppingCartActivity.cartBottomTotal = (CustomTextView) Utils.findRequiredViewAsType(view, R.id.cart_bottom_total, "field 'cartBottomTotal'", CustomTextView.class);
    }

    public void unbind() {
        ShoppingCartActivity shoppingCartActivity = this.f4696O000000o;
        if (shoppingCartActivity != null) {
            this.f4696O000000o = null;
            shoppingCartActivity.mHomeView = null;
            shoppingCartActivity.loadingLL = null;
            shoppingCartActivity.emptyLL = null;
            shoppingCartActivity.bargainLL = null;
            shoppingCartActivity.subtotalLayout = null;
            shoppingCartActivity.promoteLayout = null;
            shoppingCartActivity.totalLayout = null;
            shoppingCartActivity.subtotalTV = null;
            shoppingCartActivity.promotionTV = null;
            shoppingCartActivity.cartTotal = null;
            shoppingCartActivity.shippingTV = null;
            shoppingCartActivity.giftDivider = null;
            shoppingCartActivity.offerDivider = null;
            shoppingCartActivity.itemLV = null;
            shoppingCartActivity.giftLV = null;
            shoppingCartActivity.offerLV = null;
            shoppingCartActivity.bargainLV = null;
            shoppingCartActivity.mainFrame = null;
            shoppingCartActivity.viewBtn = null;
            shoppingCartActivity.checkoutBtn = null;
            shoppingCartActivity.cartBottomView = null;
            shoppingCartActivity.cartBottomTotal = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
