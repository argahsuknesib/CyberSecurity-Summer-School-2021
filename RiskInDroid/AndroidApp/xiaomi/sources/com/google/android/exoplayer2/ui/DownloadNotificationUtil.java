package com.google.android.exoplayer2.ui;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import com.google.android.exoplayer2.offline.Download;
import java.util.List;

@Deprecated
public final class DownloadNotificationUtil {
    private DownloadNotificationUtil() {
    }

    public static Notification buildProgressNotification(Context context, int i, String str, PendingIntent pendingIntent, String str2, List<Download> list) {
        return new DownloadNotificationHelper(context, str).buildProgressNotification(i, pendingIntent, str2, list);
    }

    public static Notification buildDownloadCompletedNotification(Context context, int i, String str, PendingIntent pendingIntent, String str2) {
        return new DownloadNotificationHelper(context, str).buildDownloadCompletedNotification(i, pendingIntent, str2);
    }

    public static Notification buildDownloadFailedNotification(Context context, int i, String str, PendingIntent pendingIntent, String str2) {
        return new DownloadNotificationHelper(context, str).buildDownloadFailedNotification(i, pendingIntent, str2);
    }
}
