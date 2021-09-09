package com.xiaomi.smarthome;

import _m_j.ft;
import android.content.Intent;
import com.xiaomi.smarthome.application.CommonApplication;

/* renamed from: com.xiaomi.smarthome.-$$Lambda$SmartHomeMainActivity$1$hz7xUVfasoil3165qBqGzVhIEFo  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$SmartHomeMainActivity$1$hz7xUVfasoil3165qBqGzVhIEFo implements Runnable {
    public static final /* synthetic */ $$Lambda$SmartHomeMainActivity$1$hz7xUVfasoil3165qBqGzVhIEFo INSTANCE = new $$Lambda$SmartHomeMainActivity$1$hz7xUVfasoil3165qBqGzVhIEFo();

    private /* synthetic */ $$Lambda$SmartHomeMainActivity$1$hz7xUVfasoil3165qBqGzVhIEFo() {
    }

    public final void run() {
        ft.O000000o(CommonApplication.getAppContext()).O000000o(new Intent("com.smarthome.refresh_list_view"));
    }
}
