package com.xiaomi.smarthome.miio.activity;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.library.common.widget.ViewPager;

public class BleGatewayGuideActivity_ViewBinding implements Unbinder {

    /* renamed from: O000000o  reason: collision with root package name */
    private BleGatewayGuideActivity f9627O000000o;

    public BleGatewayGuideActivity_ViewBinding(BleGatewayGuideActivity bleGatewayGuideActivity, View view) {
        this.f9627O000000o = bleGatewayGuideActivity;
        bleGatewayGuideActivity.mViewPager = (ViewPager) Utils.findRequiredViewAsType(view, R.id.view_pager, "field 'mViewPager'", ViewPager.class);
        bleGatewayGuideActivity.mFirstIndicator = Utils.findRequiredView(view, R.id.first_indicator, "field 'mFirstIndicator'");
        bleGatewayGuideActivity.mSecondIndicator = Utils.findRequiredView(view, R.id.second_indicator, "field 'mSecondIndicator'");
    }

    public void unbind() {
        BleGatewayGuideActivity bleGatewayGuideActivity = this.f9627O000000o;
        if (bleGatewayGuideActivity != null) {
            this.f9627O000000o = null;
            bleGatewayGuideActivity.mViewPager = null;
            bleGatewayGuideActivity.mFirstIndicator = null;
            bleGatewayGuideActivity.mSecondIndicator = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
