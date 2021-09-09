package com.xiaomi.smarthome.scene.activity;

import android.content.DialogInterface;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.device.api.DeviceApi;

/* renamed from: com.xiaomi.smarthome.scene.activity.-$$Lambda$SmarthomeCreateAutoSceneActivity$Pi9Y2NSE2dKoY1vmqMZ09iGc3hU  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$SmarthomeCreateAutoSceneActivity$Pi9Y2NSE2dKoY1vmqMZ09iGc3hU implements DialogInterface.OnClickListener {
    public static final /* synthetic */ $$Lambda$SmarthomeCreateAutoSceneActivity$Pi9Y2NSE2dKoY1vmqMZ09iGc3hU INSTANCE = new $$Lambda$SmarthomeCreateAutoSceneActivity$Pi9Y2NSE2dKoY1vmqMZ09iGc3hU();

    private /* synthetic */ $$Lambda$SmarthomeCreateAutoSceneActivity$Pi9Y2NSE2dKoY1vmqMZ09iGc3hU() {
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        DeviceApi.getInstance().setUserLicenseConfig(ServiceApplication.getAppContext(), "scene_privacy_did", "remove", null);
    }
}
