package android.support.v4.app;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.PendingIntent;
import android.app.RemoteInput;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.NotificationCompatBase;
import android.support.v4.app.RemoteInputCompatBase;
import android.widget.RemoteViews;
import java.util.ArrayList;
import java.util.Iterator;

@TargetApi(21)
@RequiresApi(21)
class NotificationCompatApi21 {
    NotificationCompatApi21() {
    }

    public static class Builder implements NotificationBuilderWithActions, NotificationBuilderWithBuilderAccessor {
        private Notification.Builder b;
        private RemoteViews mBigContentView;
        private RemoteViews mContentView;
        private Bundle mExtras;
        private RemoteViews mHeadsUpContentView;

        public Builder(Context context, Notification notification, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, RemoteViews remoteViews, int i, PendingIntent pendingIntent, PendingIntent pendingIntent2, Bitmap bitmap, int i2, int i3, boolean z, boolean z2, boolean z3, int i4, CharSequence charSequence4, boolean z4, String str, ArrayList<String> arrayList, Bundle bundle, int i5, int i6, Notification notification2, String str2, boolean z5, String str3, RemoteViews remoteViews2, RemoteViews remoteViews3, RemoteViews remoteViews4) {
            PendingIntent pendingIntent3;
            Notification notification3 = notification;
            Bundle bundle2 = bundle;
            boolean z6 = true;
            Notification.Builder deleteIntent = new Notification.Builder(context).setWhen(notification3.when).setShowWhen(z2).setSmallIcon(notification3.icon, notification3.iconLevel).setContent(notification3.contentView).setTicker(notification3.tickerText, remoteViews).setSound(notification3.sound, notification3.audioStreamType).setVibrate(notification3.vibrate).setLights(notification3.ledARGB, notification3.ledOnMS, notification3.ledOffMS).setOngoing((notification3.flags & 2) != 0).setOnlyAlertOnce((notification3.flags & 8) != 0).setAutoCancel((notification3.flags & 16) != 0).setDefaults(notification3.defaults).setContentTitle(charSequence).setContentText(charSequence2).setSubText(charSequence4).setContentInfo(charSequence3).setContentIntent(pendingIntent).setDeleteIntent(notification3.deleteIntent);
            if ((notification3.flags & NotificationCompat.FLAG_HIGH_PRIORITY) != 0) {
                pendingIntent3 = pendingIntent2;
            } else {
                pendingIntent3 = pendingIntent2;
                z6 = false;
            }
            this.b = deleteIntent.setFullScreenIntent(pendingIntent3, z6).setLargeIcon(bitmap).setNumber(i).setUsesChronometer(z3).setPriority(i4).setProgress(i2, i3, z).setLocalOnly(z4).setGroup(str2).setGroupSummary(z5).setSortKey(str3).setCategory(str).setColor(i5).setVisibility(i6).setPublicVersion(notification2);
            this.mExtras = new Bundle();
            if (bundle2 != null) {
                this.mExtras.putAll(bundle2);
            }
            Iterator<String> it = arrayList.iterator();
            while (it.hasNext()) {
                this.b.addPerson(it.next());
            }
            this.mContentView = remoteViews2;
            this.mBigContentView = remoteViews3;
            this.mHeadsUpContentView = remoteViews4;
        }

        public void addAction(NotificationCompatBase.Action action) {
            NotificationCompatApi20.addAction(this.b, action);
        }

        public Notification.Builder getBuilder() {
            return this.b;
        }

        public Notification build() {
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
            RemoteViews remoteViews3 = this.mHeadsUpContentView;
            if (remoteViews3 != null) {
                build.headsUpContentView = remoteViews3;
            }
            return build;
        }
    }

    public static String getCategory(Notification notification) {
        return notification.category;
    }

    static Bundle getBundleForUnreadConversation(NotificationCompatBase.UnreadConversation unreadConversation) {
        String str = null;
        if (unreadConversation == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        if (unreadConversation.getParticipants() != null && unreadConversation.getParticipants().length > 1) {
            str = unreadConversation.getParticipants()[0];
        }
        Parcelable[] parcelableArr = new Parcelable[unreadConversation.getMessages().length];
        for (int i = 0; i < parcelableArr.length; i++) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("text", unreadConversation.getMessages()[i]);
            bundle2.putString("author", str);
            parcelableArr[i] = bundle2;
        }
        bundle.putParcelableArray("messages", parcelableArr);
        RemoteInputCompatBase.RemoteInput remoteInput = unreadConversation.getRemoteInput();
        if (remoteInput != null) {
            bundle.putParcelable("remote_input", fromCompatRemoteInput(remoteInput));
        }
        bundle.putParcelable("on_reply", unreadConversation.getReplyPendingIntent());
        bundle.putParcelable("on_read", unreadConversation.getReadPendingIntent());
        bundle.putStringArray("participants", unreadConversation.getParticipants());
        bundle.putLong("timestamp", unreadConversation.getLatestTimestamp());
        return bundle;
    }

    static NotificationCompatBase.UnreadConversation getUnreadConversationFromBundle(Bundle bundle, NotificationCompatBase.UnreadConversation.Factory factory, RemoteInputCompatBase.RemoteInput.Factory factory2) {
        String[] strArr;
        RemoteInputCompatBase.RemoteInput remoteInput = null;
        if (bundle == null) {
            return null;
        }
        Parcelable[] parcelableArray = bundle.getParcelableArray("messages");
        if (parcelableArray != null) {
            String[] strArr2 = new String[parcelableArray.length];
            boolean z = false;
            int i = 0;
            while (true) {
                if (i >= strArr2.length) {
                    z = true;
                    break;
                } else if (!(parcelableArray[i] instanceof Bundle)) {
                    break;
                } else {
                    strArr2[i] = ((Bundle) parcelableArray[i]).getString("text");
                    if (strArr2[i] == null) {
                        break;
                    }
                    i++;
                }
            }
            if (!z) {
                return null;
            }
            strArr = strArr2;
        } else {
            strArr = null;
        }
        PendingIntent pendingIntent = (PendingIntent) bundle.getParcelable("on_read");
        PendingIntent pendingIntent2 = (PendingIntent) bundle.getParcelable("on_reply");
        RemoteInput remoteInput2 = (RemoteInput) bundle.getParcelable("remote_input");
        String[] stringArray = bundle.getStringArray("participants");
        if (stringArray == null || stringArray.length != 1) {
            return null;
        }
        if (remoteInput2 != null) {
            remoteInput = toCompatRemoteInput(remoteInput2, factory2);
        }
        return factory.build(strArr, remoteInput, pendingIntent2, pendingIntent, stringArray, bundle.getLong("timestamp"));
    }

    private static RemoteInput fromCompatRemoteInput(RemoteInputCompatBase.RemoteInput remoteInput) {
        return new RemoteInput.Builder(remoteInput.getResultKey()).setLabel(remoteInput.getLabel()).setChoices(remoteInput.getChoices()).setAllowFreeFormInput(remoteInput.getAllowFreeFormInput()).addExtras(remoteInput.getExtras()).build();
    }

    private static RemoteInputCompatBase.RemoteInput toCompatRemoteInput(RemoteInput remoteInput, RemoteInputCompatBase.RemoteInput.Factory factory) {
        return factory.build(remoteInput.getResultKey(), remoteInput.getLabel(), remoteInput.getChoices(), remoteInput.getAllowFreeFormInput(), remoteInput.getExtras());
    }
}
