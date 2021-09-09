package com.xiaomi.smarthome.device.renderer;

import com.xiaomi.smarthome.frame.plugin.SendMessageHandle;

public final class PluginDownloadingRecord {

    /* renamed from: O000000o  reason: collision with root package name */
    public String f7296O000000o;
    public Status O00000Oo;
    public SendMessageHandle O00000o;
    public float O00000o0;
    public long O00000oO;

    public enum Status {
        PENDING,
        DOWNLOADING,
        DOWNLOADING_SUCCESS,
        DOWNLOADING_FAILURE
    }
}
