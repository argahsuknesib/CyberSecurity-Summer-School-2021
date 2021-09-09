package _m_j;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import androidx.core.app.NotificationCompat;
import com.xiaomi.smarthome.R;

public final class gps {

    /* renamed from: O000000o  reason: collision with root package name */
    private static long f18129O000000o;

    public static void O000000o(Context context, CharSequence charSequence, CharSequence charSequence2) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context.getApplicationContext());
        builder.O000000o((int) R.drawable.mj_notify_icon);
        builder.O000000o(charSequence);
        builder.O00000Oo(charSequence2);
        builder.O00000oo = null;
        builder.O00000Oo();
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - f18129O000000o > 5000) {
            f18129O000000o = currentTimeMillis;
        }
        NotificationManager notificationManager = (NotificationManager) context.getApplicationContext().getSystemService("notification");
        if (notificationManager == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 26) {
            notificationManager.notify(997, new Notification.Builder(context.getApplicationContext(), fke.O000000o(notificationManager, context)).setTicker(charSequence).setContentTitle(charSequence).setContentText(charSequence2).setAutoCancel(true).setSmallIcon((int) R.drawable.mj_notify_icon).setContentIntent(null).build());
            return;
        }
        NotificationCompat.Builder builder2 = new NotificationCompat.Builder(context);
        builder2.O00000o(charSequence);
        builder2.O000000o(charSequence);
        builder2.O00000Oo(charSequence2);
        builder2.O00000Oo();
        builder2.O000000o((int) R.drawable.mj_notify_icon);
        builder2.O00000oo = null;
        notificationManager.notify(997, builder2.O00000o());
    }
}
