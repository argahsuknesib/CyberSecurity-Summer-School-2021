package com.xiaomi.smarthome.scene.activity;

import android.content.DialogInterface;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.device.api.DeviceApi;

/* renamed from: com.xiaomi.smarthome.scene.activity.-$$Lambda$SmartHomeSceneCreateEditActivity$brJKcxvLsMwGQjZMBRRTZu219bs  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$SmartHomeSceneCreateEditActivity$brJKcxvLsMwGQjZMBRRTZu219bs implements DialogInterface.OnClickListener {
    public static final /* synthetic */ $$Lambda$SmartHomeSceneCreateEditActivity$brJKcxvLsMwGQjZMBRRTZu219bs INSTANCE = new $$Lambda$SmartHomeSceneCreateEditActivity$brJKcxvLsMwGQjZMBRRTZu219bs();

    private /* synthetic */ $$Lambda$SmartHomeSceneCreateEditActivity$brJKcxvLsMwGQjZMBRRTZu219bs() {
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        DeviceApi.getInstance().setUserLicenseConfig(ServiceApplication.getAppContext(), "scene_privacy_did", "remove", null);
    }
}
