package com.xiaomi.smarthome.framework.page.rndebug;

import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.xiaomi.smarthome.R;

public class RnDebugClassifyActivity_ViewBinding implements Unbinder {

    /* renamed from: O000000o  reason: collision with root package name */
    private RnDebugClassifyActivity f7909O000000o;

    public RnDebugClassifyActivity_ViewBinding(RnDebugClassifyActivity rnDebugClassifyActivity, View view) {
        this.f7909O000000o = rnDebugClassifyActivity;
        rnDebugClassifyActivity.viewHeadLeft = Utils.findRequiredView(view, R.id.module_a_3_return_btn, "field 'viewHeadLeft'");
        rnDebugClassifyActivity.tvHeadTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.module_a_3_return_title, "field 'tvHeadTitle'", TextView.class);
        rnDebugClassifyActivity.mViewRnDebug = Utils.findRequiredView(view, R.id.layout_rn_debug, "field 'mViewRnDebug'");
        rnDebugClassifyActivity.mViewRnPluginDemo = Utils.findRequiredView(view, R.id.layout_rn_plugin_demo, "field 'mViewRnPluginDemo'");
        rnDebugClassifyActivity.mViewRnFeedback = Utils.findRequiredView(view, R.id.layout_rn_plugin_feedback, "field 'mViewRnFeedback'");
    }

    public void unbind() {
        RnDebugClassifyActivity rnDebugClassifyActivity = this.f7909O000000o;
        if (rnDebugClassifyActivity != null) {
            this.f7909O000000o = null;
            rnDebugClassifyActivity.viewHeadLeft = null;
            rnDebugClassifyActivity.tvHeadTitle = null;
            rnDebugClassifyActivity.mViewRnDebug = null;
            rnDebugClassifyActivity.mViewRnPluginDemo = null;
            rnDebugClassifyActivity.mViewRnFeedback = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
