package com.xiaomi.smarthome.smartconfig.initdevice;

import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.xiaomi.smarthome.R;

public class InitShareAndMibrainActivity_ViewBinding implements Unbinder {

    /* renamed from: O000000o  reason: collision with root package name */
    private InitShareAndMibrainActivity f11531O000000o;

    public InitShareAndMibrainActivity_ViewBinding(InitShareAndMibrainActivity initShareAndMibrainActivity, View view) {
        this.f11531O000000o = initShareAndMibrainActivity;
        initShareAndMibrainActivity.vsShareFamily = (ViewStub) Utils.findRequiredViewAsType(view, R.id.stub_share_family, "field 'vsShareFamily'", ViewStub.class);
        initShareAndMibrainActivity.vsShareDevice = (ViewStub) Utils.findRequiredViewAsType(view, R.id.stub_share_device, "field 'vsShareDevice'", ViewStub.class);
        initShareAndMibrainActivity.vsVoiceControl = (ViewStub) Utils.findRequiredViewAsType(view, R.id.stub_voice_contrl, "field 'vsVoiceControl'", ViewStub.class);
        initShareAndMibrainActivity.vsMiSoundGatewaySwitcher = (ViewStub) Utils.findRequiredViewAsType(view, R.id.stub_misound_switcher, "field 'vsMiSoundGatewaySwitcher'", ViewStub.class);
        initShareAndMibrainActivity.mImgDevice = (SimpleDraweeView) Utils.findRequiredViewAsType(view, R.id.device_img, "field 'mImgDevice'", SimpleDraweeView.class);
        initShareAndMibrainActivity.mTxtDeviceName = (TextView) Utils.findRequiredViewAsType(view, R.id.device_name, "field 'mTxtDeviceName'", TextView.class);
        initShareAndMibrainActivity.mTxtNext = (TextView) Utils.findRequiredViewAsType(view, R.id.go_next, "field 'mTxtNext'", TextView.class);
        initShareAndMibrainActivity.mTvStep = (TextView) Utils.findRequiredViewAsType(view, R.id.step, "field 'mTvStep'", TextView.class);
        initShareAndMibrainActivity.mDivider = Utils.findRequiredView(view, R.id.divider, "field 'mDivider'");
    }

    public void unbind() {
        InitShareAndMibrainActivity initShareAndMibrainActivity = this.f11531O000000o;
        if (initShareAndMibrainActivity != null) {
            this.f11531O000000o = null;
            initShareAndMibrainActivity.vsShareFamily = null;
            initShareAndMibrainActivity.vsShareDevice = null;
            initShareAndMibrainActivity.vsVoiceControl = null;
            initShareAndMibrainActivity.vsMiSoundGatewaySwitcher = null;
            initShareAndMibrainActivity.mImgDevice = null;
            initShareAndMibrainActivity.mTxtDeviceName = null;
            initShareAndMibrainActivity.mTxtNext = null;
            initShareAndMibrainActivity.mTvStep = null;
            initShareAndMibrainActivity.mDivider = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
