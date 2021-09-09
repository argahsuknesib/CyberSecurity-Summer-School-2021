package android.support.v4.app;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.NotificationCompatBase;
import android.support.v4.app.RemoteInputCompatBase;
import android.util.SparseArray;
import android.widget.RemoteViews;
import java.util.ArrayList;
import java.util.List;

@TargetApi(19)
@RequiresApi(19)
class NotificationCompatKitKat {
    NotificationCompatKitKat() {
    }

    public static class Builder implements NotificationBuilderWithActions, NotificationBuilderWithBuilderAccessor {
        private Notification.Builder b;
        private List<Bundle> mActionExtrasList = new ArrayList();
        private RemoteViews mBigContentView;
        private RemoteViews mContentView;
        private Bundle mExtras;

        public Builder(Context context, Notification notification, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, RemoteViews remoteViews, int i, PendingIntent pendingIntent, PendingIntent pendingIntent2, Bitmap bitmap, int i2, int i3, boolean z, boolean z2, boolean z3, int i4, CharSequence charSequence4, boolean z4, ArrayList<String> arrayList, Bundle bundle, String str, boolean z5, String str2, RemoteViews remoteViews2, RemoteViews remoteViews3) {
            PendingIntent pendingIntent3;
            Notification notification2 = notification;
            ArrayList<String> arrayList2 = arrayList;
            Bundle bundle2 = bundle;
            String str3 = str;
            String str4 = str2;
            boolean z6 = false;
            Notification.Builder deleteIntent = new Notification.Builder(context).setWhen(notification2.when).setShowWhen(z2).setSmallIcon(notification2.icon, notification2.iconLevel).setContent(notification2.contentView).setTicker(notification2.tickerText, remoteViews).setSound(notification2.sound, notification2.audioStreamType).setVibrate(notification2.vibrate).setLights(notification2.ledARGB, notification2.ledOnMS, notification2.ledOffMS).setOngoing((notification2.flags & 2) != 0).setOnlyAlertOnce((notification2.flags & 8) != 0).setAutoCancel((notification2.flags & 16) != 0).setDefaults(notification2.defaults).setContentTitle(charSequence).setContentText(charSequence2).setSubText(charSequence4).setContentInfo(charSequence3).setContentIntent(pendingIntent).setDeleteIntent(notification2.deleteIntent);
            if ((notification2.flags & NotificationCompat.FLAG_HIGH_PRIORITY) != 0) {
                pendingIntent3 = pendingIntent2;
                z6 = true;
            } else {
                pendingIntent3 = pendingIntent2;
            }
            this.b = deleteIntent.setFullScreenIntent(pendingIntent3, z6).setLargeIcon(bitmap).setNumber(i).setUsesChronometer(z3).setPriority(i4).setProgress(i2, i3, z);
            this.mExtras = new Bundle();
            if (bundle2 != null) {
                this.mExtras.putAll(bundle2);
            }
            if (arrayList2 != null && !arrayList.isEmpty()) {
                this.mExtras.putStringArray("android.people", (String[]) arrayList2.toArray(new String[arrayList.size()]));
            }
            if (z4) {
                this.mExtras.putBoolean("android.support.localOnly", true);
            }
            if (str3 != null) {
                this.mExtras.putString("android.support.groupKey", str3);
                if (z5) {
                    this.mExtras.putBoolean("android.support.isGroupSummary", true);
                } else {
                    this.mExtras.putBoolean("android.support.useSideChannel", true);
                }
            }
            if (str4 != null) {
                this.mExtras.putString("android.support.sortKey", str4);
            }
            this.mContentView = remoteViews2;
            this.mBigContentView = remoteViews3;
        }

        public void addAction(NotificationCompatBase.Action action) {
            this.mActionExtrasList.add(NotificationCompatJellybean.writeActionAndGetExtras(this.b, action));
        }

        public Notification.Builder getBuilder() {
            return this.b;
        }

        public Notification build() {
            SparseArray<Bundle> buildActionExtrasMap = NotificationCompatJellybean.buildActionExtrasMap(this.mActionExtrasList);
            if (buildActionExtrasMap != null) {
                this.mExtras.putSparseParcelableArray("android.support.actionExtras", buildActionExtrasMap);
            }
            this.b.setExtras(this.mExtras);
            Notification build = this.b.build();
            RemoteViews remoteViews = this.mContentView;
            if (remoteViews != null) {
                build.contentView = remoteViews;
            }
            RemoteViews remoteViews2 = this.mBigContentView;
            if (remoteViews2 != null) {
                build.bigContentView = remoteViews2;
            }
            return build;
        }
    }

    public static Bundle getExtras(Notification notification) {
        return notification.extras;
    }

    public static int getActionCount(Notification notification) {
        if (notification.actions != null) {
            return notification.actions.length;
        }
        return 0;
    }

    public static NotificationCompatBase.Action getAction(Notification notification, int i, NotificationCompatBase.Action.Factory factory, RemoteInputCompatBase.RemoteInput.Factory factory2) {
        Notification.Action action = notification.actions[i];
        SparseArray sparseParcelableArray = notification.extras.getSparseParcelableArray("android.support.actionExtras");
        return NotificationCompatJellybean.readAction(factory, factory2, action.icon, action.title, action.actionIntent, sparseParcelableArray != null ? (Bundle) sparseParcelableArray.get(i) : null);
    }

    public static boolean getLocalOnly(Notification notification) {
        return notification.extras.getBoolean("android.support.localOnly");
    }

    public static String getGroup(Notification notification) {
        return notification.extras.getString("android.support.groupKey");
    }

    public static boolean isGroupSummary(Notification notification) {
        return notification.extras.getBoolean("android.support.isGroupSummary");
    }

    public static String getSortKey(Notification notification) {
        return notification.extras.getString("android.support.sortKey");
    }
}
