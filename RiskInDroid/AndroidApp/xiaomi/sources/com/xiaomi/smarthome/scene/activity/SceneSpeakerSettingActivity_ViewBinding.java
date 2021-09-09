package com.xiaomi.smarthome.scene.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.xiaomi.smarthome.R;

public class SceneSpeakerSettingActivity_ViewBinding implements Unbinder {

    /* renamed from: O000000o  reason: collision with root package name */
    private SceneSpeakerSettingActivity f10878O000000o;

    public SceneSpeakerSettingActivity_ViewBinding(SceneSpeakerSettingActivity sceneSpeakerSettingActivity, View view) {
        this.f10878O000000o = sceneSpeakerSettingActivity;
        sceneSpeakerSettingActivity.mDeviceList = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.device_list, "field 'mDeviceList'", RecyclerView.class);
        sceneSpeakerSettingActivity.mModuleA4ReturnBtn = Utils.findRequiredView(view, R.id.module_a_3_return_btn, "field 'mModuleA4ReturnBtn'");
        sceneSpeakerSettingActivity.emptyView = Utils.findRequiredView(view, R.id.common_white_empty_view, "field 'emptyView'");
        sceneSpeakerSettingActivity.imgEmpty = (ImageView) Utils.findRequiredViewAsType(view, R.id.empty_icon, "field 'imgEmpty'", ImageView.class);
        sceneSpeakerSettingActivity.txtEmpty = (TextView) Utils.findRequiredViewAsType(view, R.id.common_white_empty_text, "field 'txtEmpty'", TextView.class);
    }

    public void unbind() {
        SceneSpeakerSettingActivity sceneSpeakerSettingActivity = this.f10878O000000o;
        if (sceneSpeakerSettingActivity != null) {
            this.f10878O000000o = null;
            sceneSpeakerSettingActivity.mDeviceList = null;
            sceneSpeakerSettingActivity.mModuleA4ReturnBtn = null;
            sceneSpeakerSettingActivity.emptyView = null;
            sceneSpeakerSettingActivity.imgEmpty = null;
            sceneSpeakerSettingActivity.txtEmpty = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
