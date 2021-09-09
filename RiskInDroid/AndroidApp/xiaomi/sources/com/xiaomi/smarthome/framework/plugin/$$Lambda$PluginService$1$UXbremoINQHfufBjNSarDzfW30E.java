package com.xiaomi.smarthome.framework.plugin;

import com.xiaomi.smarthome.camera.api.CameraRouterFactory;

/* renamed from: com.xiaomi.smarthome.framework.plugin.-$$Lambda$PluginService$1$UXbremoINQHfufBjNSarDzfW30E  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$PluginService$1$UXbremoINQHfufBjNSarDzfW30E implements Runnable {
    public static final /* synthetic */ $$Lambda$PluginService$1$UXbremoINQHfufBjNSarDzfW30E INSTANCE = new $$Lambda$PluginService$1$UXbremoINQHfufBjNSarDzfW30E();

    private /* synthetic */ $$Lambda$PluginService$1$UXbremoINQHfufBjNSarDzfW30E() {
    }

    public final void run() {
        CameraRouterFactory.getCameraManagerApi().removeFloatWindow(false);
    }
}
