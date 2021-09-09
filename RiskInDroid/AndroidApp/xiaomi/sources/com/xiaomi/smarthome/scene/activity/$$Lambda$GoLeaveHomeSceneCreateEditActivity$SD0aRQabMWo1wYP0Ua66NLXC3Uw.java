package com.xiaomi.smarthome.scene.activity;

import android.content.DialogInterface;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.device.api.DeviceApi;

/* renamed from: com.xiaomi.smarthome.scene.activity.-$$Lambda$GoLeaveHomeSceneCreateEditActivity$SD0aRQabMWo1wYP0Ua66NLXC3Uw  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$GoLeaveHomeSceneCreateEditActivity$SD0aRQabMWo1wYP0Ua66NLXC3Uw implements DialogInterface.OnClickListener {
    public static final /* synthetic */ $$Lambda$GoLeaveHomeSceneCreateEditActivity$SD0aRQabMWo1wYP0Ua66NLXC3Uw INSTANCE = new $$Lambda$GoLeaveHomeSceneCreateEditActivity$SD0aRQabMWo1wYP0Ua66NLXC3Uw();

    private /* synthetic */ $$Lambda$GoLeaveHomeSceneCreateEditActivity$SD0aRQabMWo1wYP0Ua66NLXC3Uw() {
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        DeviceApi.getInstance().setUserLicenseConfig(ServiceApplication.getAppContext(), "scene_privacy_did", "remove", null);
    }
}
