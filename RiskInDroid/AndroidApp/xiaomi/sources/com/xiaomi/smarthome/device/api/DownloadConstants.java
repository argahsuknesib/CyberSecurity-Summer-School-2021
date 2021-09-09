package com.xiaomi.smarthome.device.api;

import android.net.Uri;

public class DownloadConstants {
    public static final Uri ALL_DOWNLOADS_CONTENT_URI = Uri.parse("content://com.xiaomi.smarthome.downloads/all_downloads");
    public static final Uri CONTENT_URI = Uri.parse("content://com.xiaomi.smarthome.downloads/my_downloads");
}
