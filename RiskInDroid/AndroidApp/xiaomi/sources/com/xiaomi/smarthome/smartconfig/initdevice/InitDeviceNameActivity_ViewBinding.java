package com.xiaomi.smarthome.smartconfig.initdevice;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.library.common.widget.CommonFlowGroup;

public class InitDeviceNameActivity_ViewBinding implements Unbinder {

    /* renamed from: O000000o  reason: collision with root package name */
    private InitDeviceNameActivity f11497O000000o;

    public InitDeviceNameActivity_ViewBinding(InitDeviceNameActivity initDeviceNameActivity, View view) {
        this.f11497O000000o = initDeviceNameActivity;
        initDeviceNameActivity.mDeviceImg = (SimpleDraweeView) Utils.findRequiredViewAsType(view, R.id.device_img, "field 'mDeviceImg'", SimpleDraweeView.class);
        initDeviceNameActivity.mGoNextBtn = (Button) Utils.findRequiredViewAsType(view, R.id.go_next, "field 'mGoNextBtn'", Button.class);
        initDeviceNameActivity.mDeviceNameEt = (EditText) Utils.findRequiredViewAsType(view, R.id.device_name, "field 'mDeviceNameEt'", EditText.class);
        initDeviceNameActivity.mInputClearBtn = Utils.findRequiredView(view, R.id.input_clear, "field 'mInputClearBtn'");
        initDeviceNameActivity.mDeviceNameTips = (TextView) Utils.findRequiredViewAsType(view, R.id.device_name_tips, "field 'mDeviceNameTips'", TextView.class);
        initDeviceNameActivity.mRecommendTagFlow = (CommonFlowGroup) Utils.findRequiredViewAsType(view, R.id.recommend_name_tag, "field 'mRecommendTagFlow'", CommonFlowGroup.class);
        initDeviceNameActivity.mDivider = Utils.findRequiredView(view, R.id.divider, "field 'mDivider'");
    }

    public void unbind() {
        InitDeviceNameActivity initDeviceNameActivity = this.f11497O000000o;
        if (initDeviceNameActivity != null) {
            this.f11497O000000o = null;
            initDeviceNameActivity.mDeviceImg = null;
            initDeviceNameActivity.mGoNextBtn = null;
            initDeviceNameActivity.mDeviceNameEt = null;
            initDeviceNameActivity.mInputClearBtn = null;
            initDeviceNameActivity.mDeviceNameTips = null;
            initDeviceNameActivity.mRecommendTagFlow = null;
            initDeviceNameActivity.mDivider = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
