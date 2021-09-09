package _m_j;

import android.app.Notification;
import android.app.RemoteInput;
import android.content.Context;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.RemoteViews;
import androidx.core.app.NotificationCompat;
import androidx.core.graphics.drawable.IconCompat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class oOOo0000 implements oOOOOO0O {

    /* renamed from: O000000o  reason: collision with root package name */
    public final Notification.Builder f2322O000000o;
    public final NotificationCompat.Builder O00000Oo;
    public RemoteViews O00000o;
    public RemoteViews O00000o0;
    public final List<Bundle> O00000oO = new ArrayList();
    public final Bundle O00000oo = new Bundle();
    public int O0000O0o;
    public RemoteViews O0000OOo;

    public oOOo0000(NotificationCompat.Builder builder) {
        Notification.BubbleMetadata bubbleMetadata;
        this.O00000Oo = builder;
        if (Build.VERSION.SDK_INT >= 26) {
            this.f2322O000000o = new Notification.Builder(builder.f2822O000000o, builder.O000OO00);
        } else {
            this.f2322O000000o = new Notification.Builder(builder.f2822O000000o);
        }
        Notification notification = builder.O000OOoo;
        boolean z = false;
        this.f2322O000000o.setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, builder.O0000OOo).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(builder.O00000o).setContentText(builder.O00000oO).setContentInfo(builder.O0000Oo).setContentIntent(builder.O00000oo).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(builder.O0000O0o, (notification.flags & android.support.v4.app.NotificationCompat.FLAG_HIGH_PRIORITY) != 0).setLargeIcon(builder.O0000Oo0).setNumber(builder.O0000OoO).setProgress(builder.O0000oO, builder.O0000oOO, builder.O0000oOo);
        if (Build.VERSION.SDK_INT < 21) {
            this.f2322O000000o.setSound(notification.sound, notification.audioStreamType);
        }
        if (Build.VERSION.SDK_INT >= 16) {
            this.f2322O000000o.setSubText(builder.O0000o).setUsesChronometer(builder.O0000o0).setPriority(builder.O0000Ooo);
            Iterator<NotificationCompat.O000000o> it = builder.O00000Oo.iterator();
            while (it.hasNext()) {
                O000000o(it.next());
            }
            if (builder.O000O0OO != null) {
                this.O00000oo.putAll(builder.O000O0OO);
            }
            if (Build.VERSION.SDK_INT < 20) {
                if (builder.O0000ooo) {
                    this.O00000oo.putBoolean("android.support.localOnly", true);
                }
                if (builder.O0000oo0 != null) {
                    this.O00000oo.putString("android.support.groupKey", builder.O0000oo0);
                    if (builder.O0000oo) {
                        this.O00000oo.putBoolean("android.support.isGroupSummary", true);
                    } else {
                        this.O00000oo.putBoolean("android.support.useSideChannel", true);
                    }
                }
                if (builder.O0000ooO != null) {
                    this.O00000oo.putString("android.support.sortKey", builder.O0000ooO);
                }
            }
            this.O00000o0 = builder.O000O0o;
            this.O00000o = builder.O000O0oO;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            this.f2322O000000o.setShowWhen(builder.O0000o00);
            if (Build.VERSION.SDK_INT < 21 && builder.O000Oo0 != null && !builder.O000Oo0.isEmpty()) {
                this.O00000oo.putStringArray("android.people", (String[]) builder.O000Oo0.toArray(new String[builder.O000Oo0.size()]));
            }
        }
        if (Build.VERSION.SDK_INT >= 20) {
            this.f2322O000000o.setLocalOnly(builder.O0000ooo).setGroup(builder.O0000oo0).setGroupSummary(builder.O0000oo).setSortKey(builder.O0000ooO);
            this.O0000O0o = builder.O000OOo0;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            this.f2322O000000o.setCategory(builder.O000O00o).setColor(builder.O000O0Oo).setVisibility(builder.O00oOoOo).setPublicVersion(builder.O000O0o0).setSound(notification.sound, notification.audioAttributes);
            Iterator<String> it2 = builder.O000Oo0.iterator();
            while (it2.hasNext()) {
                this.f2322O000000o.addPerson(it2.next());
            }
            this.O0000OOo = builder.O000O0oo;
            if (builder.O00000o0.size() > 0) {
                Bundle bundle = builder.O00000o0().getBundle("android.car.EXTENSIONS");
                bundle = bundle == null ? new Bundle() : bundle;
                Bundle bundle2 = new Bundle();
                for (int i = 0; i < builder.O00000o0.size(); i++) {
                    bundle2.putBundle(Integer.toString(i), oo000000.O000000o(builder.O00000o0.get(i)));
                }
                bundle.putBundle("invisible_actions", bundle2);
                builder.O00000o0().putBundle("android.car.EXTENSIONS", bundle);
                this.O00000oo.putBundle("android.car.EXTENSIONS", bundle);
            }
        }
        if (Build.VERSION.SDK_INT >= 24) {
            this.f2322O000000o.setExtras(builder.O000O0OO).setRemoteInputHistory(builder.O0000oO0);
            if (builder.O000O0o != null) {
                this.f2322O000000o.setCustomContentView(builder.O000O0o);
            }
            if (builder.O000O0oO != null) {
                this.f2322O000000o.setCustomBigContentView(builder.O000O0oO);
            }
            if (builder.O000O0oo != null) {
                this.f2322O000000o.setCustomHeadsUpContentView(builder.O000O0oo);
            }
        }
        if (Build.VERSION.SDK_INT >= 26) {
            this.f2322O000000o.setBadgeIconType(builder.O000OO0o).setShortcutId(builder.O000OO).setTimeoutAfter(builder.O000OOOo).setGroupAlertBehavior(builder.O000OOo0);
            if (builder.O00oOooo) {
                this.f2322O000000o.setColorized(builder.O00oOooO);
            }
            if (!TextUtils.isEmpty(builder.O000OO00)) {
                this.f2322O000000o.setSound(null).setDefaults(0).setLights(0, 0, 0).setVibrate(null);
            }
        }
        if (Build.VERSION.SDK_INT >= 29) {
            this.f2322O000000o.setAllowSystemGeneratedContextualActions(builder.O000OOo);
            Notification.Builder builder2 = this.f2322O000000o;
            NotificationCompat.O00000o0 o00000o0 = builder.O000OOoO;
            if (o00000o0 == null) {
                bubbleMetadata = null;
            } else {
                Notification.BubbleMetadata.Builder suppressNotification = new Notification.BubbleMetadata.Builder().setAutoExpandBubble((o00000o0.O00000oo & 1) != 0).setDeleteIntent(o00000o0.O00000Oo).setIcon(o00000o0.O00000o0.O000000o((Context) null)).setIntent(o00000o0.f2825O000000o).setSuppressNotification((o00000o0.O00000oo & 2) != 0 ? true : z);
                if (o00000o0.O00000o != 0) {
                    suppressNotification.setDesiredHeight(o00000o0.O00000o);
                }
                if (o00000o0.O00000oO != 0) {
                    suppressNotification.setDesiredHeightResId(o00000o0.O00000oO);
                }
                bubbleMetadata = suppressNotification.build();
            }
            builder2.setBubbleMetadata(bubbleMetadata);
        }
        if (builder.O000Oo00) {
            if (this.O00000Oo.O0000oo) {
                this.O0000O0o = 2;
            } else {
                this.O0000O0o = 1;
            }
            this.f2322O000000o.setVibrate(null);
            this.f2322O000000o.setSound(null);
            notification.defaults &= -2;
            notification.defaults &= -3;
            this.f2322O000000o.setDefaults(notification.defaults);
            if (Build.VERSION.SDK_INT >= 26) {
                if (TextUtils.isEmpty(this.O00000Oo.O0000oo0)) {
                    this.f2322O000000o.setGroup("silent");
                }
                this.f2322O000000o.setGroupAlertBehavior(this.O0000O0o);
            }
        }
    }

    public final Notification.Builder O000000o() {
        return this.f2322O000000o;
    }

    private void O000000o(NotificationCompat.O000000o o000000o) {
        Notification.Action.Builder builder;
        Bundle bundle;
        int i;
        if (Build.VERSION.SDK_INT >= 20) {
            IconCompat O000000o2 = o000000o.O000000o();
            if (Build.VERSION.SDK_INT >= 23) {
                Icon icon = null;
                if (O000000o2 != null) {
                    icon = O000000o2.O000000o((Context) null);
                }
                builder = new Notification.Action.Builder(icon, o000000o.O0000Oo0, o000000o.O0000Oo);
            } else {
                if (O000000o2 != null) {
                    i = O000000o2.O000000o();
                } else {
                    i = 0;
                }
                builder = new Notification.Action.Builder(i, o000000o.O0000Oo0, o000000o.O0000Oo);
            }
            if (o000000o.O00000Oo != null) {
                for (RemoteInput addRemoteInput : b.O000000o(o000000o.O00000Oo)) {
                    builder.addRemoteInput(addRemoteInput);
                }
            }
            if (o000000o.f2823O000000o != null) {
                bundle = new Bundle(o000000o.f2823O000000o);
            } else {
                bundle = new Bundle();
            }
            bundle.putBoolean("android.support.allowGeneratedReplies", o000000o.O00000o);
            if (Build.VERSION.SDK_INT >= 24) {
                builder.setAllowGeneratedReplies(o000000o.O00000o);
            }
            bundle.putInt("android.support.action.semanticAction", o000000o.O00000oo);
            if (Build.VERSION.SDK_INT >= 28) {
                builder.setSemanticAction(o000000o.O00000oo);
            }
            if (Build.VERSION.SDK_INT >= 29) {
                builder.setContextual(o000000o.O0000O0o);
            }
            bundle.putBoolean("android.support.action.showsUserInterface", o000000o.O00000oO);
            builder.addExtras(bundle);
            this.f2322O000000o.addAction(builder.build());
        } else if (Build.VERSION.SDK_INT >= 16) {
            this.O00000oO.add(oo000000.O000000o(this.f2322O000000o, o000000o));
        }
    }

    public static void O000000o(Notification notification) {
        notification.sound = null;
        notification.vibrate = null;
        notification.defaults &= -2;
        notification.defaults &= -3;
    }
}
