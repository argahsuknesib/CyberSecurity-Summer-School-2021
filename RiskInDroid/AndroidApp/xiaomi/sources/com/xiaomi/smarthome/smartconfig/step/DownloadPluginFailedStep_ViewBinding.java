package com.xiaomi.smarthome.smartconfig.step;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.xiaomi.smarthome.R;

public class DownloadPluginFailedStep_ViewBinding implements Unbinder {

    /* renamed from: O000000o  reason: collision with root package name */
    private DownloadPluginFailedStep f11757O000000o;

    public DownloadPluginFailedStep_ViewBinding(DownloadPluginFailedStep downloadPluginFailedStep, View view) {
        this.f11757O000000o = downloadPluginFailedStep;
        downloadPluginFailedStep.mIcon = (ImageView) Utils.findRequiredViewAsType(view, R.id.smart_config_common_icon, "field 'mIcon'", ImageView.class);
        downloadPluginFailedStep.mMainTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.smart_config_common_main_title, "field 'mMainTitle'", TextView.class);
        downloadPluginFailedStep.mSubMainTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.smart_config_common_main_sub_title, "field 'mSubMainTitle'", TextView.class);
        downloadPluginFailedStep.mLeftBtn = (TextView) Utils.findRequiredViewAsType(view, R.id.left_btn, "field 'mLeftBtn'", TextView.class);
        downloadPluginFailedStep.mRightBtn = (TextView) Utils.findRequiredViewAsType(view, R.id.right_btn, "field 'mRightBtn'", TextView.class);
    }

    public void unbind() {
        DownloadPluginFailedStep downloadPluginFailedStep = this.f11757O000000o;
        if (downloadPluginFailedStep != null) {
            this.f11757O000000o = null;
            downloadPluginFailedStep.mIcon = null;
            downloadPluginFailedStep.mMainTitle = null;
            downloadPluginFailedStep.mSubMainTitle = null;
            downloadPluginFailedStep.mLeftBtn = null;
            downloadPluginFailedStep.mRightBtn = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
