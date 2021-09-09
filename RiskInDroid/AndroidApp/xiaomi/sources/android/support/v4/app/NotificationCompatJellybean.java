package android.support.v4.app;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.NotificationCompatBase;
import android.support.v4.app.RemoteInputCompatBase;
import android.util.Log;
import android.util.SparseArray;
import android.widget.RemoteViews;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@TargetApi(16)
@RequiresApi(16)
class NotificationCompatJellybean {
    private static Class<?> sActionClass;
    private static Field sActionIconField;
    private static Field sActionIntentField;
    private static Field sActionTitleField;
    private static boolean sActionsAccessFailed;
    private static Field sActionsField;
    private static final Object sActionsLock = new Object();
    private static Field sExtrasField;
    private static boolean sExtrasFieldAccessFailed;
    private static final Object sExtrasLock = new Object();

    NotificationCompatJellybean() {
    }

    public static class Builder implements NotificationBuilderWithActions, NotificationBuilderWithBuilderAccessor {
        private Notification.Builder b;
        private List<Bundle> mActionExtrasList = new ArrayList();
        private RemoteViews mBigContentView;
        private RemoteViews mContentView;
        private final Bundle mExtras;

        public Builder(Context context, Notification notification, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, RemoteViews remoteViews, int i, PendingIntent pendingIntent, PendingIntent pendingIntent2, Bitmap bitmap, int i2, int i3, boolean z, boolean z2, int i4, CharSequence charSequence4, boolean z3, Bundle bundle, String str, boolean z4, String str2, RemoteViews remoteViews2, RemoteViews remoteViews3) {
            PendingIntent pendingIntent3;
            Notification notification2 = notification;
            Bundle bundle2 = bundle;
            String str3 = str;
            String str4 = str2;
            boolean z5 = false;
            Notification.Builder deleteIntent = new Notification.Builder(context).setWhen(notification2.when).setSmallIcon(notification2.icon, notification2.iconLevel).setContent(notification2.contentView).setTicker(notification2.tickerText, remoteViews).setSound(notification2.sound, notification2.audioStreamType).setVibrate(notification2.vibrate).setLights(notification2.ledARGB, notification2.ledOnMS, notification2.ledOffMS).setOngoing((notification2.flags & 2) != 0).setOnlyAlertOnce((notification2.flags & 8) != 0).setAutoCancel((notification2.flags & 16) != 0).setDefaults(notification2.defaults).setContentTitle(charSequence).setContentText(charSequence2).setSubText(charSequence4).setContentInfo(charSequence3).setContentIntent(pendingIntent).setDeleteIntent(notification2.deleteIntent);
            if ((notification2.flags & NotificationCompat.FLAG_HIGH_PRIORITY) != 0) {
                pendingIntent3 = pendingIntent2;
                z5 = true;
            } else {
                pendingIntent3 = pendingIntent2;
            }
            this.b = deleteIntent.setFullScreenIntent(pendingIntent3, z5).setLargeIcon(bitmap).setNumber(i).setUsesChronometer(z2).setPriority(i4).setProgress(i2, i3, z);
            this.mExtras = new Bundle();
            if (bundle2 != null) {
                this.mExtras.putAll(bundle2);
            }
            if (z3) {
                this.mExtras.putBoolean("android.support.localOnly", true);
            }
            if (str3 != null) {
                this.mExtras.putString("android.support.groupKey", str3);
                if (z4) {
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
            Notification build = this.b.build();
            Bundle extras = NotificationCompatJellybean.getExtras(build);
            Bundle bundle = new Bundle(this.mExtras);
            for (String next : this.mExtras.keySet()) {
                if (extras.containsKey(next)) {
                    bundle.remove(next);
                }
            }
            extras.putAll(bundle);
            SparseArray<Bundle> buildActionExtrasMap = NotificationCompatJellybean.buildActionExtrasMap(this.mActionExtrasList);
            if (buildActionExtrasMap != null) {
                NotificationCompatJellybean.getExtras(build).putSparseParcelableArray("android.support.actionExtras", buildActionExtrasMap);
            }
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

    public static void addBigTextStyle(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor, CharSequence charSequence, boolean z, CharSequence charSequence2, CharSequence charSequence3) {
        Notification.BigTextStyle bigText = new Notification.BigTextStyle(notificationBuilderWithBuilderAccessor.getBuilder()).setBigContentTitle(charSequence).bigText(charSequence3);
        if (z) {
            bigText.setSummaryText(charSequence2);
        }
    }

    public static void addBigPictureStyle(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor, CharSequence charSequence, boolean z, CharSequence charSequence2, Bitmap bitmap, Bitmap bitmap2, boolean z2) {
        Notification.BigPictureStyle bigPicture = new Notification.BigPictureStyle(notificationBuilderWithBuilderAccessor.getBuilder()).setBigContentTitle(charSequence).bigPicture(bitmap);
        if (z2) {
            bigPicture.bigLargeIcon(bitmap2);
        }
        if (z) {
            bigPicture.setSummaryText(charSequence2);
        }
    }

    public static void addInboxStyle(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor, CharSequence charSequence, boolean z, CharSequence charSequence2, ArrayList<CharSequence> arrayList) {
        Notification.InboxStyle bigContentTitle = new Notification.InboxStyle(notificationBuilderWithBuilderAccessor.getBuilder()).setBigContentTitle(charSequence);
        if (z) {
            bigContentTitle.setSummaryText(charSequence2);
        }
        Iterator<CharSequence> it = arrayList.iterator();
        while (it.hasNext()) {
            bigContentTitle.addLine(it.next());
        }
    }

    public static SparseArray<Bundle> buildActionExtrasMap(List<Bundle> list) {
        int size = list.size();
        SparseArray<Bundle> sparseArray = null;
        for (int i = 0; i < size; i++) {
            Bundle bundle = list.get(i);
            if (bundle != null) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray<>();
                }
                sparseArray.put(i, bundle);
            }
        }
        return sparseArray;
    }

    public static Bundle getExtras(Notification notification) {
        synchronized (sExtrasLock) {
            if (sExtrasFieldAccessFailed) {
                return null;
            }
            try {
                if (sExtrasField == null) {
                    Field declaredField = Notification.class.getDeclaredField("extras");
                    if (!Bundle.class.isAssignableFrom(declaredField.getType())) {
                        Log.e("NotificationCompat", "Notification.extras field is not of type Bundle");
                        sExtrasFieldAccessFailed = true;
                        return null;
                    }
                    declaredField.setAccessible(true);
                    sExtrasField = declaredField;
                }
                Bundle bundle = (Bundle) sExtrasField.get(notification);
                if (bundle == null) {
                    bundle = new Bundle();
                    sExtrasField.set(notification, bundle);
                }
                return bundle;
            } catch (IllegalAccessException e) {
                Log.e("NotificationCompat", "Unable to access notification extras", e);
                sExtrasFieldAccessFailed = true;
                return null;
            } catch (NoSuchFieldException e2) {
                Log.e("NotificationCompat", "Unable to access notification extras", e2);
                sExtrasFieldAccessFailed = true;
                return null;
            }
        }
    }

    public static NotificationCompatBase.Action readAction(NotificationCompatBase.Action.Factory factory, RemoteInputCompatBase.RemoteInput.Factory factory2, int i, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle) {
        boolean z;
        RemoteInputCompatBase.RemoteInput[] remoteInputArr;
        if (bundle != null) {
            remoteInputArr = RemoteInputCompatJellybean.fromBundleArray(BundleUtil.getBundleArrayFromBundle(bundle, "android.support.remoteInputs"), factory2);
            z = bundle.getBoolean("android.support.allowGeneratedReplies");
        } else {
            remoteInputArr = null;
            z = false;
        }
        return factory.build(i, charSequence, pendingIntent, bundle, remoteInputArr, z);
    }

    public static Bundle writeActionAndGetExtras(Notification.Builder builder, NotificationCompatBase.Action action) {
        builder.addAction(action.getIcon(), action.getTitle(), action.getActionIntent());
        Bundle bundle = new Bundle(action.getExtras());
        if (action.getRemoteInputs() != null) {
            bundle.putParcelableArray("android.support.remoteInputs", RemoteInputCompatJellybean.toBundleArray(action.getRemoteInputs()));
        }
        bundle.putBoolean("android.support.allowGeneratedReplies", action.getAllowGeneratedReplies());
        return bundle;
    }

    public static int getActionCount(Notification notification) {
        int length;
        synchronized (sActionsLock) {
            Object[] actionObjectsLocked = getActionObjectsLocked(notification);
            length = actionObjectsLocked != null ? actionObjectsLocked.length : 0;
        }
        return length;
    }

    public static NotificationCompatBase.Action getAction(Notification notification, int i, NotificationCompatBase.Action.Factory factory, RemoteInputCompatBase.RemoteInput.Factory factory2) {
        SparseArray sparseParcelableArray;
        synchronized (sActionsLock) {
            try {
                Object[] actionObjectsLocked = getActionObjectsLocked(notification);
                if (actionObjectsLocked != null) {
                    Object obj = actionObjectsLocked[i];
                    Bundle extras = getExtras(notification);
                    NotificationCompatBase.Action readAction = readAction(factory, factory2, sActionIconField.getInt(obj), (CharSequence) sActionTitleField.get(obj), (PendingIntent) sActionIntentField.get(obj), (extras == null || (sparseParcelableArray = extras.getSparseParcelableArray("android.support.actionExtras")) == null) ? null : (Bundle) sparseParcelableArray.get(i));
                    return readAction;
                }
            } catch (IllegalAccessException e) {
                Log.e("NotificationCompat", "Unable to access notification actions", e);
                sActionsAccessFailed = true;
            } catch (Throwable th) {
                throw th;
            }
        }
        return null;
    }

    private static Object[] getActionObjectsLocked(Notification notification) {
        synchronized (sActionsLock) {
            if (!ensureActionReflectionReadyLocked()) {
                return null;
            }
            try {
                Object[] objArr = (Object[]) sActionsField.get(notification);
                return objArr;
            } catch (IllegalAccessException e) {
                Log.e("NotificationCompat", "Unable to access notification actions", e);
                sActionsAccessFailed = true;
                return null;
            }
        }
    }

    private static boolean ensureActionReflectionReadyLocked() {
        if (sActionsAccessFailed) {
            return false;
        }
        try {
            if (sActionsField == null) {
                Class<?> cls = Class.forName("android.app.Notification$Action");
                sActionClass = cls;
                sActionIconField = cls.getDeclaredField("icon");
                sActionTitleField = sActionClass.getDeclaredField("title");
                sActionIntentField = sActionClass.getDeclaredField("actionIntent");
                Field declaredField = Notification.class.getDeclaredField("actions");
                sActionsField = declaredField;
                declaredField.setAccessible(true);
            }
        } catch (ClassNotFoundException e) {
            Log.e("NotificationCompat", "Unable to access notification actions", e);
            sActionsAccessFailed = true;
        } catch (NoSuchFieldException e2) {
            Log.e("NotificationCompat", "Unable to access notification actions", e2);
            sActionsAccessFailed = true;
        }
        return !sActionsAccessFailed;
    }

    public static NotificationCompatBase.Action[] getActionsFromParcelableArrayList(ArrayList<Parcelable> arrayList, NotificationCompatBase.Action.Factory factory, RemoteInputCompatBase.RemoteInput.Factory factory2) {
        if (arrayList == null) {
            return null;
        }
        NotificationCompatBase.Action[] newArray = factory.newArray(arrayList.size());
        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = getActionFromBundle((Bundle) arrayList.get(i), factory, factory2);
        }
        return newArray;
    }

    private static NotificationCompatBase.Action getActionFromBundle(Bundle bundle, NotificationCompatBase.Action.Factory factory, RemoteInputCompatBase.RemoteInput.Factory factory2) {
        Bundle bundle2 = bundle.getBundle("extras");
        return factory.build(bundle.getInt("icon"), bundle.getCharSequence("title"), (PendingIntent) bundle.getParcelable("actionIntent"), bundle.getBundle("extras"), RemoteInputCompatJellybean.fromBundleArray(BundleUtil.getBundleArrayFromBundle(bundle, "remoteInputs"), factory2), bundle2 != null ? bundle2.getBoolean("android.support.allowGeneratedReplies", false) : false);
    }

    public static ArrayList<Parcelable> getParcelableArrayListForActions(NotificationCompatBase.Action[] actionArr) {
        if (actionArr == null) {
            return null;
        }
        ArrayList<Parcelable> arrayList = new ArrayList<>(actionArr.length);
        for (NotificationCompatBase.Action bundleForAction : actionArr) {
            arrayList.add(getBundleForAction(bundleForAction));
        }
        return arrayList;
    }

    private static Bundle getBundleForAction(NotificationCompatBase.Action action) {
        Bundle bundle;
        Bundle bundle2 = new Bundle();
        bundle2.putInt("icon", action.getIcon());
        bundle2.putCharSequence("title", action.getTitle());
        bundle2.putParcelable("actionIntent", action.getActionIntent());
        if (action.getExtras() != null) {
            bundle = new Bundle(action.getExtras());
        } else {
            bundle = new Bundle();
        }
        bundle.putBoolean("android.support.allowGeneratedReplies", action.getAllowGeneratedReplies());
        bundle2.putBundle("extras", bundle);
        bundle2.putParcelableArray("remoteInputs", RemoteInputCompatJellybean.toBundleArray(action.getRemoteInputs()));
        return bundle2;
    }

    public static boolean getLocalOnly(Notification notification) {
        return getExtras(notification).getBoolean("android.support.localOnly");
    }

    public static String getGroup(Notification notification) {
        return getExtras(notification).getString("android.support.groupKey");
    }

    public static boolean isGroupSummary(Notification notification) {
        return getExtras(notification).getBoolean("android.support.isGroupSummary");
    }

    public static String getSortKey(Notification notification) {
        return getExtras(notification).getString("android.support.sortKey");
    }
}
