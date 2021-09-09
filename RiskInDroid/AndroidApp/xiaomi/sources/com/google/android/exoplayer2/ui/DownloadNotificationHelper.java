package com.google.android.exoplayer2.ui;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import androidx.core.app.NotificationCompat;
import com.google.android.exoplayer2.offline.Download;
import com.xiaomi.smarthome.R;
import java.util.List;

public final class DownloadNotificationHelper {
    private final Context context;
    private final NotificationCompat.Builder notificationBuilder;

    public DownloadNotificationHelper(Context context2, String str) {
        Context applicationContext = context2.getApplicationContext();
        this.context = applicationContext;
        this.notificationBuilder = new NotificationCompat.Builder(applicationContext, str);
    }

    public final Notification buildProgressNotification(int i, PendingIntent pendingIntent, String str, List<Download> list) {
        boolean z;
        int i2;
        boolean z2 = true;
        boolean z3 = false;
        boolean z4 = false;
        float f = 0.0f;
        int i3 = 0;
        boolean z5 = true;
        boolean z6 = false;
        for (int i4 = 0; i4 < list.size(); i4++) {
            Download download = list.get(i4);
            if (download.state == 5) {
                z4 = true;
            } else if (download.state == 7 || download.state == 2) {
                float percentDownloaded = download.getPercentDownloaded();
                if (percentDownloaded != -1.0f) {
                    f += percentDownloaded;
                    z5 = false;
                }
                i3++;
                z6 = (download.getBytesDownloaded() > 0) | z6;
                z3 = true;
            }
        }
        int i5 = z3 ? R.string.exo_download_downloading : z4 ? R.string.exo_download_removing : 0;
        if (z3) {
            int i6 = (int) (f / ((float) i3));
            if (!z5 || !z6) {
                z2 = false;
            }
            z = z2;
            i2 = i6;
        } else {
            i2 = 0;
            z = true;
        }
        return buildNotification(i, pendingIntent, str, i5, 100, i2, z, true, false);
    }

    public final Notification buildDownloadCompletedNotification(int i, PendingIntent pendingIntent, String str) {
        return buildEndStateNotification(i, pendingIntent, str, R.string.exo_download_completed);
    }

    public final Notification buildDownloadFailedNotification(int i, PendingIntent pendingIntent, String str) {
        return buildEndStateNotification(i, pendingIntent, str, R.string.exo_download_failed);
    }

    private Notification buildEndStateNotification(int i, PendingIntent pendingIntent, String str, int i2) {
        return buildNotification(i, pendingIntent, str, i2, 0, 0, false, false, true);
    }

    private Notification buildNotification(int i, PendingIntent pendingIntent, String str, int i2, int i3, int i4, boolean z, boolean z2, boolean z3) {
        String str2;
        this.notificationBuilder.O000000o(i);
        NotificationCompat.Builder builder = this.notificationBuilder;
        NotificationCompat.O00000Oo o00000Oo = null;
        if (i2 == 0) {
            str2 = null;
        } else {
            str2 = this.context.getResources().getString(i2);
        }
        builder.O000000o(str2);
        NotificationCompat.Builder builder2 = this.notificationBuilder;
        builder2.O00000oo = pendingIntent;
        if (str != null) {
            o00000Oo = new NotificationCompat.O00000Oo().O000000o(str);
        }
        builder2.O000000o(o00000Oo);
        this.notificationBuilder.O000000o(i3, i4, z);
        this.notificationBuilder.O000000o(2, z2);
        NotificationCompat.Builder builder3 = this.notificationBuilder;
        builder3.O0000o00 = z3;
        return builder3.O00000o();
    }
}
