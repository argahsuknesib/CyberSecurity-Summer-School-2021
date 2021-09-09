package com.mi.global.shop.activity;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.mi.global.shop.widget.CustomTextView;
import com.mi.global.shop.widget.PopSpinnerView;
import com.xiaomi.smarthome.R;

public class DeliveryActivity_ViewBinding implements Unbinder {

    /* renamed from: O000000o  reason: collision with root package name */
    private DeliveryActivity f4624O000000o;

    public DeliveryActivity_ViewBinding(DeliveryActivity deliveryActivity, View view) {
        this.f4624O000000o = deliveryActivity;
        deliveryActivity.deliveryCheckBox = (CheckBox) Utils.findRequiredViewAsType(view, R.id.four_hour_delivery_ck, "field 'deliveryCheckBox'", CheckBox.class);
        deliveryActivity.deliveryNoticeView = Utils.findRequiredView(view, R.id.delivery_notice, "field 'deliveryNoticeView'");
        deliveryActivity.deliveryHome = (CustomTextView) Utils.findRequiredViewAsType(view, R.id.delivery_home, "field 'deliveryHome'", CustomTextView.class);
        deliveryActivity.deliverySmartBox = (CustomTextView) Utils.findRequiredViewAsType(view, R.id.delivery_smart, "field 'deliverySmartBox'", CustomTextView.class);
        deliveryActivity.fourHourDelivery = Utils.findRequiredView(view, R.id.rl_four_delivery, "field 'fourHourDelivery'");
        deliveryActivity.smartBox = Utils.findRequiredView(view, R.id.rl_smart_box, "field 'smartBox'");
        deliveryActivity.smartBoxConditions = (CustomTextView) Utils.findRequiredViewAsType(view, R.id.tv_smart_box_conditions, "field 'smartBoxConditions'", CustomTextView.class);
        deliveryActivity.btnConfirm = Utils.findRequiredView(view, R.id.btn_confirm, "field 'btnConfirm'");
        deliveryActivity.popSpinnerView = (PopSpinnerView) Utils.findRequiredViewAsType(view, R.id.psv_smart, "field 'popSpinnerView'", PopSpinnerView.class);
        deliveryActivity.fourHourPrice = (CustomTextView) Utils.findRequiredViewAsType(view, R.id.four_hour_price, "field 'fourHourPrice'", CustomTextView.class);
        deliveryActivity.deliveryView = (ImageView) Utils.findRequiredViewAsType(view, R.id.four_hour_delivery_v, "field 'deliveryView'", ImageView.class);
        deliveryActivity.smartExplain = (CustomTextView) Utils.findRequiredViewAsType(view, R.id.tv_smart_explain, "field 'smartExplain'", CustomTextView.class);
        deliveryActivity.deliveryFouHour = (CustomTextView) Utils.findRequiredViewAsType(view, R.id.delivery_four_hour, "field 'deliveryFouHour'", CustomTextView.class);
    }

    public void unbind() {
        DeliveryActivity deliveryActivity = this.f4624O000000o;
        if (deliveryActivity != null) {
            this.f4624O000000o = null;
            deliveryActivity.deliveryCheckBox = null;
            deliveryActivity.deliveryNoticeView = null;
            deliveryActivity.deliveryHome = null;
            deliveryActivity.deliverySmartBox = null;
            deliveryActivity.fourHourDelivery = null;
            deliveryActivity.smartBox = null;
            deliveryActivity.smartBoxConditions = null;
            deliveryActivity.btnConfirm = null;
            deliveryActivity.popSpinnerView = null;
            deliveryActivity.fourHourPrice = null;
            deliveryActivity.deliveryView = null;
            deliveryActivity.smartExplain = null;
            deliveryActivity.deliveryFouHour = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
