package com.xiaomi.smarthome.smartconfig.step;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.xiaomi.smarthome.R;

public class QRScanFindFailedStep_ViewBinding implements Unbinder {

    /* renamed from: O000000o  reason: collision with root package name */
    private QRScanFindFailedStep f11804O000000o;

    public QRScanFindFailedStep_ViewBinding(QRScanFindFailedStep qRScanFindFailedStep, View view) {
        this.f11804O000000o = qRScanFindFailedStep;
        qRScanFindFailedStep.mIcon = (ImageView) Utils.findRequiredViewAsType(view, R.id.smart_config_common_icon, "field 'mIcon'", ImageView.class);
        qRScanFindFailedStep.mMainTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.smart_config_common_main_title, "field 'mMainTitle'", TextView.class);
        qRScanFindFailedStep.mSubMainTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.smart_config_common_main_sub_title, "field 'mSubMainTitle'", TextView.class);
        qRScanFindFailedStep.mLeftBtn = (TextView) Utils.findRequiredViewAsType(view, R.id.left_btn, "field 'mLeftBtn'", TextView.class);
        qRScanFindFailedStep.mRightBtn = (TextView) Utils.findRequiredViewAsType(view, R.id.right_btn, "field 'mRightBtn'", TextView.class);
        qRScanFindFailedStep.mHelpTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.help_title, "field 'mHelpTitle'", TextView.class);
    }

    public void unbind() {
        QRScanFindFailedStep qRScanFindFailedStep = this.f11804O000000o;
        if (qRScanFindFailedStep != null) {
            this.f11804O000000o = null;
            qRScanFindFailedStep.mIcon = null;
            qRScanFindFailedStep.mMainTitle = null;
            qRScanFindFailedStep.mSubMainTitle = null;
            qRScanFindFailedStep.mLeftBtn = null;
            qRScanFindFailedStep.mRightBtn = null;
            qRScanFindFailedStep.mHelpTitle = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
