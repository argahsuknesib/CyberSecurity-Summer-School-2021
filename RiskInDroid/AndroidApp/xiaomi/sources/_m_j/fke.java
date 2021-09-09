package _m_j;

import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.xiaomi.smarthome.R;

public final class fke {
    public static String O000000o(NotificationManager notificationManager, Context context) {
        return O000000o(context, notificationManager, null, "SmartHome", context.getString(R.string.app_name2));
    }

    public static String O000000o(Context context) {
        return context.getString(R.string.notification_channel_other);
    }

    public static String O000000o(Context context, NotificationManager notificationManager, String str, String str2, String str3) {
        if (TextUtils.isEmpty(null)) {
            str = "other";
        }
        O00000Oo(context, notificationManager, str, str2, str3);
        return str2;
    }

    private static NotificationManager O00000Oo(Context context, NotificationManager notificationManager, String str, String str2, String str3) {
        if (notificationManager == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT >= 26 && notificationManager.getNotificationChannel(str2) == null) {
            NotificationChannel notificationChannel = new NotificationChannel(str2, str3, 4);
            try {
                if (Build.VERSION.SDK_INT >= 28) {
                    NotificationChannelGroup notificationChannelGroup = notificationManager.getNotificationChannelGroup(str);
                    if (notificationChannelGroup == null) {
                        notificationChannelGroup = new NotificationChannelGroup(str, context.getString(R.string.notification_channel_other));
                        notificationManager.createNotificationChannelGroup(notificationChannelGroup);
                    }
                    notificationChannel.setGroup(notificationChannelGroup.getId());
                }
            } catch (Exception e) {
                gsy.O000000o(6, "NotificationChannelCreator", e.toString());
            }
            notificationManager.createNotificationChannel(notificationChannel);
        }
        return notificationManager;
    }
}
