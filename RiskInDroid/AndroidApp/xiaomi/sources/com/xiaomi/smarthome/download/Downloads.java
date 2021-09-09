package com.xiaomi.smarthome.download;

import android.net.Uri;
import android.provider.BaseColumns;

public final class Downloads implements BaseColumns {
    public static final Uri ALL_DOWNLOADS_CONTENT_URI = Uri.parse("content://com.xiaomi.smarthome.downloads/all_downloads");
    public static final Uri CONTENT_URI = Uri.parse("content://com.xiaomi.smarthome.downloads/my_downloads");

    public static boolean isStatusClientError(int i) {
        return i >= 400 && i < 500;
    }

    public static boolean isStatusCompleted(int i) {
        if (i < 200 || i >= 300) {
            return i >= 400 && i < 600;
        }
        return true;
    }

    public static boolean isStatusError(int i) {
        return i >= 400 && i < 600;
    }

    public static boolean isStatusInformational(int i) {
        return i >= 100 && i < 200;
    }

    public static boolean isStatusServerError(int i) {
        return i >= 500 && i < 600;
    }

    public static boolean isStatusSuccess(int i) {
        return i >= 200 && i < 300;
    }

    private Downloads() {
    }
}
