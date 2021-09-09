package com.mi.global.shop.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.mi.global.shop.widget.CustomTextView;
import com.mi.global.shop.widget.NoScrollListView;
import com.xiaomi.smarthome.R;

public class TrackAcitvity_ViewBinding implements Unbinder {

    /* renamed from: O000000o  reason: collision with root package name */
    private TrackAcitvity f4716O000000o;

    public TrackAcitvity_ViewBinding(TrackAcitvity trackAcitvity, View view) {
        this.f4716O000000o = trackAcitvity;
        trackAcitvity.ivShipping = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_shipping, "field 'ivShipping'", ImageView.class);
        trackAcitvity.expressName = (CustomTextView) Utils.findRequiredViewAsType(view, R.id.express_name, "field 'expressName'", CustomTextView.class);
        trackAcitvity.expressSn = (CustomTextView) Utils.findRequiredViewAsType(view, R.id.express_sn, "field 'expressSn'", CustomTextView.class);
        trackAcitvity.trackItemList = (NoScrollListView) Utils.findRequiredViewAsType(view, R.id.trackItemList, "field 'trackItemList'", NoScrollListView.class);
        trackAcitvity.loading = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.loading, "field 'loading'", LinearLayout.class);
        trackAcitvity.tvExpressHint = (CustomTextView) Utils.findRequiredViewAsType(view, R.id.tv_express_hint, "field 'tvExpressHint'", CustomTextView.class);
    }

    public void unbind() {
        TrackAcitvity trackAcitvity = this.f4716O000000o;
        if (trackAcitvity != null) {
            this.f4716O000000o = null;
            trackAcitvity.ivShipping = null;
            trackAcitvity.expressName = null;
            trackAcitvity.expressSn = null;
            trackAcitvity.trackItemList = null;
            trackAcitvity.loading = null;
            trackAcitvity.tvExpressHint = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
