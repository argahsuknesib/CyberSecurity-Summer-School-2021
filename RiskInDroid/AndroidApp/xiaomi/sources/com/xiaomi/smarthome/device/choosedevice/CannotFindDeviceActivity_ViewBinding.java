package com.xiaomi.smarthome.device.choosedevice;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.xiaomi.smarthome.R;

public class CannotFindDeviceActivity_ViewBinding implements Unbinder {

    /* renamed from: O000000o  reason: collision with root package name */
    private CannotFindDeviceActivity f7211O000000o;

    public CannotFindDeviceActivity_ViewBinding(CannotFindDeviceActivity cannotFindDeviceActivity, View view) {
        this.f7211O000000o = cannotFindDeviceActivity;
        cannotFindDeviceActivity.mBtnSure = (Button) Utils.findRequiredViewAsType(view, R.id.btn_sure, "field 'mBtnSure'", Button.class);
        cannotFindDeviceActivity.mTxtTopTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.txt_title, "field 'mTxtTopTitle'", TextView.class);
        cannotFindDeviceActivity.mLayoutCompanyGroup = Utils.findRequiredView(view, R.id.layout_company_group, "field 'mLayoutCompanyGroup'");
        cannotFindDeviceActivity.mLayoutCompanyParent = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.layout_company_parent, "field 'mLayoutCompanyParent'", LinearLayout.class);
        cannotFindDeviceActivity.mLayoutModelGroup = Utils.findRequiredView(view, R.id.layout_model_group, "field 'mLayoutModelGroup'");
        cannotFindDeviceActivity.mLayoutModelParent = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.layout_model_parent, "field 'mLayoutModelParent'", LinearLayout.class);
        cannotFindDeviceActivity.mLayoutBottomGuide = Utils.findRequiredView(view, R.id.layout_bottom_guide, "field 'mLayoutBottomGuide'");
        cannotFindDeviceActivity.mImgGuide = (ImageView) Utils.findRequiredViewAsType(view, R.id.img_guide, "field 'mImgGuide'", ImageView.class);
    }

    public void unbind() {
        CannotFindDeviceActivity cannotFindDeviceActivity = this.f7211O000000o;
        if (cannotFindDeviceActivity != null) {
            this.f7211O000000o = null;
            cannotFindDeviceActivity.mBtnSure = null;
            cannotFindDeviceActivity.mTxtTopTitle = null;
            cannotFindDeviceActivity.mLayoutCompanyGroup = null;
            cannotFindDeviceActivity.mLayoutCompanyParent = null;
            cannotFindDeviceActivity.mLayoutModelGroup = null;
            cannotFindDeviceActivity.mLayoutModelParent = null;
            cannotFindDeviceActivity.mLayoutBottomGuide = null;
            cannotFindDeviceActivity.mImgGuide = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
