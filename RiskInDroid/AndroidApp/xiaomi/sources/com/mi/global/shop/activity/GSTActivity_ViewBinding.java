package com.mi.global.shop.activity;

import android.view.View;
import android.widget.Button;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.mi.global.shop.widget.CustomEditTextView;
import com.mi.global.shop.widget.XEditText;
import com.xiaomi.smarthome.R;

public class GSTActivity_ViewBinding implements Unbinder {

    /* renamed from: O000000o  reason: collision with root package name */
    private GSTActivity f4629O000000o;

    public GSTActivity_ViewBinding(GSTActivity gSTActivity, View view) {
        this.f4629O000000o = gSTActivity;
        gSTActivity.ed_gst = (XEditText) Utils.findRequiredViewAsType(view, R.id.ed_gst, "field 'ed_gst'", XEditText.class);
        gSTActivity.bg_gst = (CustomEditTextView) Utils.findRequiredViewAsType(view, R.id.bg_gst, "field 'bg_gst'", CustomEditTextView.class);
        gSTActivity.bt_gst = (Button) Utils.findRequiredViewAsType(view, R.id.bt_gst, "field 'bt_gst'", Button.class);
        gSTActivity.bt_gst_cancel = (Button) Utils.findRequiredViewAsType(view, R.id.bt_gst_cancel, "field 'bt_gst_cancel'", Button.class);
    }

    public void unbind() {
        GSTActivity gSTActivity = this.f4629O000000o;
        if (gSTActivity != null) {
            this.f4629O000000o = null;
            gSTActivity.ed_gst = null;
            gSTActivity.bg_gst = null;
            gSTActivity.bt_gst = null;
            gSTActivity.bt_gst_cancel = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
