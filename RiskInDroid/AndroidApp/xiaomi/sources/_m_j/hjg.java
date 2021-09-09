package _m_j;

import _m_j.hjf;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import android.widget.RemoteViews;
import androidx.core.app.NotificationCompat;
import com.xiaomi.smarthome.R;
import java.util.List;

public final class hjg {
    public static void O000000o(Service service, List<hjf.O000000o> list) {
        Notification notification;
        if (list == null || list.size() == 0) {
            Intent intent = new Intent("com.xiaomi.smarthome.notification.auth_expired");
            intent.setPackage(service.getPackageName());
            O000000o(service, 999, service.getResources().getString(R.string.app_name), service.getResources().getString(R.string.app_name), intent);
            O000000o(service);
            gsy.O00000Oo("NotificationController", "createShortcutNotification cancelShortcutNotifications");
            return;
        }
        try {
            RemoteViews O000000o2 = hjh.O000000o(service, list);
            if (Build.VERSION.SDK_INT >= 26) {
                NotificationManager notificationManager = (NotificationManager) service.getSystemService("notification");
                NotificationChannel notificationChannel = new NotificationChannel("Shortcut", service.getResources().getString(R.string.notification_quick_op_title), 2);
                if (Build.VERSION.SDK_INT >= 28) {
                    if (notificationManager.getNotificationChannelGroup("other") == null) {
                        notificationManager.createNotificationChannelGroup(new NotificationChannelGroup("other", fke.O000000o(service)));
                    }
                    if (TextUtils.isEmpty(notificationChannel.getGroup())) {
                        notificationChannel.setGroup("other");
                    }
                }
                notificationChannel.enableLights(false);
                notificationChannel.enableVibration(false);
                notificationManager.createNotificationChannel(notificationChannel);
                Notification.Builder builder = new Notification.Builder(service, "Shortcut");
                builder.setSmallIcon((int) R.drawable.mj_notify_icon).setCustomContentView(O000000o2).setOngoing(true);
                notification = builder.build();
            } else {
                NotificationCompat.Builder builder2 = new NotificationCompat.Builder(service);
                NotificationCompat.Builder O000000o3 = builder2.O000000o((int) R.drawable.mj_notify_icon);
                O000000o3.O000O0o = O000000o2;
                O000000o3.O000O0oO = O000000o2;
                O000000o3.O000000o(2, true);
                O000000o3.O0000Ooo = 2;
                notification = builder2.O00000o();
            }
            notification.flags |= 16;
            NotificationManager notificationManager2 = (NotificationManager) service.getSystemService("notification");
            if (Build.VERSION.SDK_INT < 24) {
                notificationManager2.notify(999, notification);
            } else {
                service.startForeground(999, notification);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void O000000o(Service service) {
        NotificationManager notificationManager = (NotificationManager) service.getSystemService("notification");
        if (Build.VERSION.SDK_INT < 24) {
            notificationManager.cancel(999);
        } else {
            service.stopForeground(true);
        }
    }

    public static void O000000o(Service service, int i, String str, String str2, Intent intent) {
        O000000o(service, i, str, str2, PendingIntent.getBroadcast(service, (int) System.currentTimeMillis(), intent, 1073741824));
    }

    public static void O000000o(Service service, int i, String str, String str2, PendingIntent pendingIntent) {
        Notification.Builder builder;
        NotificationManager notificationManager = (NotificationManager) service.getSystemService("notification");
        if (Build.VERSION.SDK_INT >= 26) {
            NotificationChannel notificationChannel = new NotificationChannel("Shortcut", service.getResources().getString(R.string.notification_quick_op_title), 2);
            if (Build.VERSION.SDK_INT >= 28) {
                if (notificationManager.getNotificationChannelGroup("other") == null) {
                    notificationManager.createNotificationChannelGroup(new NotificationChannelGroup("other", fke.O000000o(service)));
                }
                if (TextUtils.isEmpty(notificationChannel.getGroup())) {
                    notificationChannel.setGroup("other");
                }
            }
            notificationChannel.enableLights(false);
            notificationChannel.enableVibration(false);
            notificationManager.createNotificationChannel(notificationChannel);
            builder = new Notification.Builder(service, "Shortcut");
        } else {
            builder = new Notification.Builder(service);
        }
        builder.setSmallIcon((int) R.drawable.mj_notify_icon).setContentTitle(str).setContentText(str2).setContentIntent(pendingIntent);
        Notification build = builder.build();
        build.flags |= 16;
        if (Build.VERSION.SDK_INT < 24) {
            notificationManager.notify(i, build);
        } else {
            service.startForeground(i, build);
        }
    }
}
