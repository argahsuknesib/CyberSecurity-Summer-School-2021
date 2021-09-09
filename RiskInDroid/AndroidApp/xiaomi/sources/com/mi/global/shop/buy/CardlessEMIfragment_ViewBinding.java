package com.mi.global.shop.buy;

import android.view.View;
import android.widget.RelativeLayout;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.mi.global.shop.widget.CustomButtonView;
import com.mi.global.shop.widget.CustomTextView;
import com.mi.global.shop.widget.NoScrollListView;
import com.xiaomi.smarthome.R;

public class CardlessEMIfragment_ViewBinding implements Unbinder {

    /* renamed from: O000000o  reason: collision with root package name */
    private CardlessEMIfragment f4845O000000o;
    private View O00000Oo;

    public CardlessEMIfragment_ViewBinding(final CardlessEMIfragment cardlessEMIfragment, View view) {
        this.f4845O000000o = cardlessEMIfragment;
        cardlessEMIfragment.mContentGroup = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.ll_content_group, "field 'mContentGroup'", RelativeLayout.class);
        cardlessEMIfragment.mPlanTips = (CustomTextView) Utils.findRequiredViewAsType(view, R.id.tv_plan_tips, "field 'mPlanTips'", CustomTextView.class);
        cardlessEMIfragment.mPlanListView = (NoScrollListView) Utils.findRequiredViewAsType(view, R.id.lv_plan_list, "field 'mPlanListView'", NoScrollListView.class);
        View findRequiredView = Utils.findRequiredView(view, R.id.bt_cardless_pay_now, "field 'mPayNowBtn' and method 'cardlessPayNow'");
        cardlessEMIfragment.mPayNowBtn = (CustomButtonView) Utils.castView(findRequiredView, R.id.bt_cardless_pay_now, "field 'mPayNowBtn'", CustomButtonView.class);
        this.O00000Oo = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() {
            /* class com.mi.global.shop.buy.CardlessEMIfragment_ViewBinding.AnonymousClass1 */

            public final void doClick(View view) {
                cardlessEMIfragment.cardlessPayNow(view);
            }
        });
        cardlessEMIfragment.mEMIErrorTip = (CustomTextView) Utils.findRequiredViewAsType(view, R.id.emi_less_error_tip, "field 'mEMIErrorTip'", CustomTextView.class);
    }

    public void unbind() {
        CardlessEMIfragment cardlessEMIfragment = this.f4845O000000o;
        if (cardlessEMIfragment != null) {
            this.f4845O000000o = null;
            cardlessEMIfragment.mContentGroup = null;
            cardlessEMIfragment.mPlanTips = null;
            cardlessEMIfragment.mPlanListView = null;
            cardlessEMIfragment.mPayNowBtn = null;
            cardlessEMIfragment.mEMIErrorTip = null;
            this.O00000Oo.setOnClickListener(null);
            this.O00000Oo = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
