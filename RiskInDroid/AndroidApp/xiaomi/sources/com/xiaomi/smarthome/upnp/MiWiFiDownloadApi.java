package com.xiaomi.smarthome.upnp;

import android.database.Cursor;
import android.net.Uri;

public abstract class MiWiFiDownloadApi {
    public static volatile MiWiFiDownloadApi _instance;

    public abstract void notifyLocalWifiConnect(boolean z);

    public abstract void pauseDownload(long... jArr);

    public abstract Cursor queryDownload(boolean z, long... jArr);

    public abstract void removeDownload(long... jArr);

    public abstract void restartDownload(long... jArr);

    public abstract void resumeDownload(long... jArr);

    public abstract long startDownload(Uri uri, String str, String str2, String str3);

    public static MiWiFiDownloadApi instance() {
        return _instance;
    }
}
