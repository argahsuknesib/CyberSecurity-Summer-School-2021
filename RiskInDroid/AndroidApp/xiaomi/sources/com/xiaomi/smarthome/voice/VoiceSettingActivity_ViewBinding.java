package com.xiaomi.smarthome.voice;

import android.view.View;
import android.widget.ImageView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.xiaomi.smarthome.R;

public class VoiceSettingActivity_ViewBinding implements Unbinder {

    /* renamed from: O000000o  reason: collision with root package name */
    private VoiceSettingActivity f11914O000000o;

    public VoiceSettingActivity_ViewBinding(VoiceSettingActivity voiceSettingActivity, View view) {
        this.f11914O000000o = voiceSettingActivity;
        voiceSettingActivity.mAnoterNameDot = (ImageView) Utils.findRequiredViewAsType(view, R.id.img_anohter_name_dot, "field 'mAnoterNameDot'", ImageView.class);
        voiceSettingActivity.mXiaoaiRoomSetting = Utils.findRequiredView(view, R.id.xiaoai_room_setting, "field 'mXiaoaiRoomSetting'");
        voiceSettingActivity.mXiaoaiRoomDot = (ImageView) Utils.findRequiredViewAsType(view, R.id.img_xiaoai_dot, "field 'mXiaoaiRoomDot'", ImageView.class);
        voiceSettingActivity.mDeviceAuth = Utils.findRequiredView(view, R.id.device_auth, "field 'mDeviceAuth'");
        voiceSettingActivity.mdeviceauthdot = (ImageView) Utils.findRequiredViewAsType(view, R.id.img_device_auth_dot, "field 'mdeviceauthdot'", ImageView.class);
        voiceSettingActivity.mAnotherNameSetting = Utils.findRequiredView(view, R.id.voice_another_name_setting, "field 'mAnotherNameSetting'");
    }

    public void unbind() {
        VoiceSettingActivity voiceSettingActivity = this.f11914O000000o;
        if (voiceSettingActivity != null) {
            this.f11914O000000o = null;
            voiceSettingActivity.mAnoterNameDot = null;
            voiceSettingActivity.mXiaoaiRoomSetting = null;
            voiceSettingActivity.mXiaoaiRoomDot = null;
            voiceSettingActivity.mDeviceAuth = null;
            voiceSettingActivity.mdeviceauthdot = null;
            voiceSettingActivity.mAnotherNameSetting = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
