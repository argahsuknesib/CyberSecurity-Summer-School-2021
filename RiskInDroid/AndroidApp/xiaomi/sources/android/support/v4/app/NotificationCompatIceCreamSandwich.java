package android.support.v4.app;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.RequiresApi;
import android.widget.RemoteViews;

@TargetApi(14)
@RequiresApi(14)
class NotificationCompatIceCreamSandwich {
    NotificationCompatIceCreamSandwich() {
    }

    public static class Builder implements NotificationBuilderWithBuilderAccessor {
        private Notification.Builder b;

        public Builder(Context context, Notification notification, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, RemoteViews remoteViews, int i, PendingIntent pendingIntent, PendingIntent pendingIntent2, Bitmap bitmap, int i2, int i3, boolean z) {
            Notification notification2 = notification;
            boolean z2 = true;
            Notification.Builder deleteIntent = new Notification.Builder(context).setWhen(notification2.when).setSmallIcon(notification2.icon, notification2.iconLevel).setContent(notification2.contentView).setTicker(notification2.tickerText, remoteViews).setSound(notification2.sound, notification2.audioStreamType).setVibrate(notification2.vibrate).setLights(notification2.ledARGB, notification2.ledOnMS, notification2.ledOffMS).setOngoing((notification2.flags & 2) != 0).setOnlyAlertOnce((notification2.flags & 8) != 0).setAutoCancel((notification2.flags & 16) != 0).setDefaults(notification2.defaults).setContentTitle(charSequence).setContentText(charSequence2).setContentInfo(charSequence3).setContentIntent(pendingIntent).setDeleteIntent(notification2.deleteIntent);
            if ((notification2.flags & NotificationCompat.FLAG_HIGH_PRIORITY) == 0) {
                z2 = false;
            }
            this.b = deleteIntent.setFullScreenIntent(pendingIntent2, z2).setLargeIcon(bitmap).setNumber(i).setProgress(i2, i3, z);
        }

        public Notification.Builder getBuilder() {
            return this.b;
        }

        public Notification build() {
            return this.b.getNotification();
        }
    }
}
