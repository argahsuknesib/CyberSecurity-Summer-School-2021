package androidx.core.app;

import _m_j.b;
import _m_j.oOOOOO0O;
import _m_j.oOOo0000;
import _m_j.oo000000;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Icon;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.SparseArray;
import android.widget.RemoteViews;
import androidx.core.graphics.drawable.IconCompat;
import com.xiaomi.smarthome.R;
import java.text.NumberFormat;
import java.util.ArrayList;

public final class NotificationCompat {

    public static final class O00000o0 {

        /* renamed from: O000000o  reason: collision with root package name */
        public PendingIntent f2825O000000o;
        public PendingIntent O00000Oo;
        public int O00000o;
        public IconCompat O00000o0;
        public int O00000oO;
        public int O00000oo;
    }

    public static class Builder {

        /* renamed from: O000000o  reason: collision with root package name */
        public Context f2822O000000o;
        public ArrayList<O000000o> O00000Oo;
        public CharSequence O00000o;
        public ArrayList<O000000o> O00000o0;
        public CharSequence O00000oO;
        public PendingIntent O00000oo;
        public PendingIntent O0000O0o;
        public RemoteViews O0000OOo;
        public CharSequence O0000Oo;
        public Bitmap O0000Oo0;
        public int O0000OoO;
        public int O0000Ooo;
        public CharSequence O0000o;
        public boolean O0000o0;
        public boolean O0000o00;
        boolean O0000o0O;
        O00000o O0000o0o;
        public int O0000oO;
        public CharSequence[] O0000oO0;
        public int O0000oOO;
        public boolean O0000oOo;
        public boolean O0000oo;
        public String O0000oo0;
        public String O0000ooO;
        public boolean O0000ooo;
        public String O000O00o;
        public Bundle O000O0OO;
        public int O000O0Oo;
        public RemoteViews O000O0o;
        public Notification O000O0o0;
        public RemoteViews O000O0oO;
        public RemoteViews O000O0oo;
        public String O000OO;
        public String O000OO00;
        public int O000OO0o;
        public long O000OOOo;
        public boolean O000OOo;
        public int O000OOo0;
        public O00000o0 O000OOoO;
        public Notification O000OOoo;
        @Deprecated
        public ArrayList<String> O000Oo0;
        public boolean O000Oo00;
        public int O00oOoOo;
        public boolean O00oOooO;
        public boolean O00oOooo;

        public Builder(Context context, String str) {
            this.O00000Oo = new ArrayList<>();
            this.O00000o0 = new ArrayList<>();
            this.O0000o00 = true;
            this.O0000ooo = false;
            this.O000O0Oo = 0;
            this.O00oOoOo = 0;
            this.O000OO0o = 0;
            this.O000OOo0 = 0;
            this.O000OOoo = new Notification();
            this.f2822O000000o = context;
            this.O000OO00 = str;
            this.O000OOoo.when = System.currentTimeMillis();
            this.O000OOoo.audioStreamType = -1;
            this.O0000Ooo = 0;
            this.O000Oo0 = new ArrayList<>();
            this.O000OOo = true;
        }

        @Deprecated
        public Builder(Context context) {
            this(context, null);
        }

        public final Builder O000000o(long j) {
            this.O000OOoo.when = j;
            return this;
        }

        public final Builder O000000o(int i) {
            this.O000OOoo.icon = i;
            return this;
        }

        public final Builder O000000o(CharSequence charSequence) {
            this.O00000o = O00000oO(charSequence);
            return this;
        }

        public final Builder O00000Oo(CharSequence charSequence) {
            this.O00000oO = O00000oO(charSequence);
            return this;
        }

        public final Builder O00000o0(CharSequence charSequence) {
            this.O0000o = O00000oO(charSequence);
            return this;
        }

        public final Builder O000000o(int i, int i2, boolean z) {
            this.O0000oO = i;
            this.O0000oOO = i2;
            this.O0000oOo = z;
            return this;
        }

        public final Builder O000000o(PendingIntent pendingIntent) {
            this.O000OOoo.deleteIntent = pendingIntent;
            return this;
        }

        public final Builder O00000o(CharSequence charSequence) {
            this.O000OOoo.tickerText = O00000oO(charSequence);
            return this;
        }

        public final Builder O000000o(Uri uri) {
            Notification notification = this.O000OOoo;
            notification.sound = uri;
            notification.audioStreamType = -1;
            if (Build.VERSION.SDK_INT >= 21) {
                this.O000OOoo.audioAttributes = new AudioAttributes.Builder().setContentType(4).setUsage(5).build();
            }
            return this;
        }

        public final Builder O000000o() {
            O000000o(8, true);
            return this;
        }

        public final Builder O00000Oo() {
            O000000o(16, true);
            return this;
        }

        public final Builder O00000Oo(int i) {
            Notification notification = this.O000OOoo;
            notification.defaults = i;
            if ((i & 4) != 0) {
                notification.flags |= 1;
            }
            return this;
        }

        public final void O000000o(int i, boolean z) {
            if (z) {
                Notification notification = this.O000OOoo;
                notification.flags = i | notification.flags;
                return;
            }
            Notification notification2 = this.O000OOoo;
            notification2.flags = (i ^ -1) & notification2.flags;
        }

        public final Bundle O00000o0() {
            if (this.O000O0OO == null) {
                this.O000O0OO = new Bundle();
            }
            return this.O000O0OO;
        }

        public final Builder O000000o(O00000o o00000o) {
            if (this.O0000o0o != o00000o) {
                this.O0000o0o = o00000o;
                O00000o o00000o2 = this.O0000o0o;
                if (o00000o2 != null) {
                    o00000o2.O000000o(this);
                }
            }
            return this;
        }

        public final Notification O00000o() {
            RemoteViews remoteViews;
            Notification notification;
            RemoteViews O00000Oo2;
            oOOo0000 oooo0000 = new oOOo0000(this);
            O00000o o00000o = oooo0000.O00000Oo.O0000o0o;
            if (o00000o != null) {
                o00000o.O000000o(oooo0000);
            }
            if (o00000o != null) {
                remoteViews = o00000o.O000000o();
            } else {
                remoteViews = null;
            }
            if (Build.VERSION.SDK_INT >= 26) {
                notification = oooo0000.f2322O000000o.build();
            } else if (Build.VERSION.SDK_INT >= 24) {
                notification = oooo0000.f2322O000000o.build();
                if (oooo0000.O0000O0o != 0) {
                    if (!(notification.getGroup() == null || (notification.flags & 512) == 0 || oooo0000.O0000O0o != 2)) {
                        oOOo0000.O000000o(notification);
                    }
                    if (notification.getGroup() != null && (notification.flags & 512) == 0 && oooo0000.O0000O0o == 1) {
                        oOOo0000.O000000o(notification);
                    }
                }
            } else if (Build.VERSION.SDK_INT >= 21) {
                oooo0000.f2322O000000o.setExtras(oooo0000.O00000oo);
                notification = oooo0000.f2322O000000o.build();
                if (oooo0000.O00000o0 != null) {
                    notification.contentView = oooo0000.O00000o0;
                }
                if (oooo0000.O00000o != null) {
                    notification.bigContentView = oooo0000.O00000o;
                }
                if (oooo0000.O0000OOo != null) {
                    notification.headsUpContentView = oooo0000.O0000OOo;
                }
                if (oooo0000.O0000O0o != 0) {
                    if (!(notification.getGroup() == null || (notification.flags & 512) == 0 || oooo0000.O0000O0o != 2)) {
                        oOOo0000.O000000o(notification);
                    }
                    if (notification.getGroup() != null && (notification.flags & 512) == 0 && oooo0000.O0000O0o == 1) {
                        oOOo0000.O000000o(notification);
                    }
                }
            } else if (Build.VERSION.SDK_INT >= 20) {
                oooo0000.f2322O000000o.setExtras(oooo0000.O00000oo);
                notification = oooo0000.f2322O000000o.build();
                if (oooo0000.O00000o0 != null) {
                    notification.contentView = oooo0000.O00000o0;
                }
                if (oooo0000.O00000o != null) {
                    notification.bigContentView = oooo0000.O00000o;
                }
                if (oooo0000.O0000O0o != 0) {
                    if (!(notification.getGroup() == null || (notification.flags & 512) == 0 || oooo0000.O0000O0o != 2)) {
                        oOOo0000.O000000o(notification);
                    }
                    if (notification.getGroup() != null && (notification.flags & 512) == 0 && oooo0000.O0000O0o == 1) {
                        oOOo0000.O000000o(notification);
                    }
                }
            } else if (Build.VERSION.SDK_INT >= 19) {
                SparseArray<Bundle> O000000o2 = oo000000.O000000o(oooo0000.O00000oO);
                if (O000000o2 != null) {
                    oooo0000.O00000oo.putSparseParcelableArray("android.support.actionExtras", O000000o2);
                }
                oooo0000.f2322O000000o.setExtras(oooo0000.O00000oo);
                notification = oooo0000.f2322O000000o.build();
                if (oooo0000.O00000o0 != null) {
                    notification.contentView = oooo0000.O00000o0;
                }
                if (oooo0000.O00000o != null) {
                    notification.bigContentView = oooo0000.O00000o;
                }
            } else if (Build.VERSION.SDK_INT >= 16) {
                notification = oooo0000.f2322O000000o.build();
                Bundle O000000o3 = NotificationCompat.O000000o(notification);
                Bundle bundle = new Bundle(oooo0000.O00000oo);
                for (String next : oooo0000.O00000oo.keySet()) {
                    if (O000000o3.containsKey(next)) {
                        bundle.remove(next);
                    }
                }
                O000000o3.putAll(bundle);
                SparseArray<Bundle> O000000o4 = oo000000.O000000o(oooo0000.O00000oO);
                if (O000000o4 != null) {
                    NotificationCompat.O000000o(notification).putSparseParcelableArray("android.support.actionExtras", O000000o4);
                }
                if (oooo0000.O00000o0 != null) {
                    notification.contentView = oooo0000.O00000o0;
                }
                if (oooo0000.O00000o != null) {
                    notification.bigContentView = oooo0000.O00000o;
                }
            } else {
                notification = oooo0000.f2322O000000o.getNotification();
            }
            if (remoteViews != null) {
                notification.contentView = remoteViews;
            } else if (oooo0000.O00000Oo.O000O0o != null) {
                notification.contentView = oooo0000.O00000Oo.O000O0o;
            }
            if (!(Build.VERSION.SDK_INT < 16 || o00000o == null || (O00000Oo2 = o00000o.O00000Oo()) == null)) {
                notification.bigContentView = O00000Oo2;
            }
            int i = Build.VERSION.SDK_INT;
            if (Build.VERSION.SDK_INT >= 16 && o00000o != null) {
                NotificationCompat.O000000o(notification);
            }
            return notification;
        }

        protected static CharSequence O00000oO(CharSequence charSequence) {
            return (charSequence != null && charSequence.length() > 5120) ? charSequence.subSequence(0, 5120) : charSequence;
        }

        public final long O00000oO() {
            if (this.O0000o00) {
                return this.O000OOoo.when;
            }
            return 0;
        }

        public final Builder O000000o(Bitmap bitmap) {
            if (bitmap != null && Build.VERSION.SDK_INT < 27) {
                Resources resources = this.f2822O000000o.getResources();
                int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.compat_notification_large_icon_max_width);
                int dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.compat_notification_large_icon_max_height);
                if (bitmap.getWidth() > dimensionPixelSize || bitmap.getHeight() > dimensionPixelSize2) {
                    double d = (double) dimensionPixelSize;
                    double max = (double) Math.max(1, bitmap.getWidth());
                    Double.isNaN(d);
                    Double.isNaN(max);
                    double d2 = d / max;
                    double d3 = (double) dimensionPixelSize2;
                    double max2 = (double) Math.max(1, bitmap.getHeight());
                    Double.isNaN(d3);
                    Double.isNaN(max2);
                    double min = Math.min(d2, d3 / max2);
                    double width = (double) bitmap.getWidth();
                    Double.isNaN(width);
                    double height = (double) bitmap.getHeight();
                    Double.isNaN(height);
                    bitmap = Bitmap.createScaledBitmap(bitmap, (int) Math.ceil(width * min), (int) Math.ceil(height * min), true);
                }
            }
            this.O0000Oo0 = bitmap;
            return this;
        }
    }

    public static abstract class O00000o {

        /* renamed from: O000000o  reason: collision with root package name */
        protected Builder f2824O000000o;
        CharSequence O00000Oo;
        boolean O00000o = false;
        CharSequence O00000o0;

        public RemoteViews O000000o() {
            return null;
        }

        public void O000000o(oOOOOO0O oooooo0o) {
        }

        public RemoteViews O00000Oo() {
            return null;
        }

        public final void O000000o(Builder builder) {
            if (this.f2824O000000o != builder) {
                this.f2824O000000o = builder;
                Builder builder2 = this.f2824O000000o;
                if (builder2 != null) {
                    builder2.O000000o(this);
                }
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:49:0x0100  */
        /* JADX WARNING: Removed duplicated region for block: B:50:0x010c  */
        /* JADX WARNING: Removed duplicated region for block: B:56:0x0118  */
        /* JADX WARNING: Removed duplicated region for block: B:60:0x013a  */
        /* JADX WARNING: Removed duplicated region for block: B:70:0x018a  */
        /* JADX WARNING: Removed duplicated region for block: B:73:0x0190  */
        /* JADX WARNING: Removed duplicated region for block: B:74:0x0192  */
        /* JADX WARNING: Removed duplicated region for block: B:77:0x019d  */
        public final RemoteViews O000000o(int i, boolean z) {
            boolean z2;
            boolean z3;
            boolean z4;
            Resources resources = this.f2824O000000o.f2822O000000o.getResources();
            RemoteViews remoteViews = new RemoteViews(this.f2824O000000o.f2822O000000o.getPackageName(), i);
            boolean z5 = true;
            int i2 = 0;
            boolean z6 = this.f2824O000000o.O0000Ooo < -1;
            if (Build.VERSION.SDK_INT >= 16 && Build.VERSION.SDK_INT < 21) {
                if (z6) {
                    remoteViews.setInt(R.id.notification_background, "setBackgroundResource", R.drawable.notification_bg_low);
                    remoteViews.setInt(R.id.icon, "setBackgroundResource", R.drawable.notification_template_icon_low_bg);
                } else {
                    remoteViews.setInt(R.id.notification_background, "setBackgroundResource", R.drawable.notification_bg);
                    remoteViews.setInt(R.id.icon, "setBackgroundResource", R.drawable.notification_template_icon_bg);
                }
            }
            if (this.f2824O000000o.O0000Oo0 != null) {
                if (Build.VERSION.SDK_INT >= 16) {
                    remoteViews.setViewVisibility(R.id.icon, 0);
                    remoteViews.setImageViewBitmap(R.id.icon, this.f2824O000000o.O0000Oo0);
                } else {
                    remoteViews.setViewVisibility(R.id.icon, 8);
                }
            }
            if (this.f2824O000000o.O00000o != null) {
                remoteViews.setTextViewText(R.id.title, this.f2824O000000o.O00000o);
            }
            if (this.f2824O000000o.O00000oO != null) {
                remoteViews.setTextViewText(R.id.text, this.f2824O000000o.O00000oO);
                z2 = true;
            } else {
                z2 = false;
            }
            boolean z7 = Build.VERSION.SDK_INT < 21 && this.f2824O000000o.O0000Oo0 != null;
            if (this.f2824O000000o.O0000Oo != null) {
                remoteViews.setTextViewText(R.id.info, this.f2824O000000o.O0000Oo);
                remoteViews.setViewVisibility(R.id.info, 0);
            } else if (this.f2824O000000o.O0000OoO > 0) {
                if (this.f2824O000000o.O0000OoO > resources.getInteger(R.integer.status_bar_notification_info_maxnum)) {
                    remoteViews.setTextViewText(R.id.info, resources.getString(R.string.status_bar_notification_info_overflow));
                } else {
                    remoteViews.setTextViewText(R.id.info, NumberFormat.getIntegerInstance().format((long) this.f2824O000000o.O0000OoO));
                }
                remoteViews.setViewVisibility(R.id.info, 0);
            } else {
                remoteViews.setViewVisibility(R.id.info, 8);
                z3 = z7;
                if (this.f2824O000000o.O0000o != null && Build.VERSION.SDK_INT >= 16) {
                    remoteViews.setTextViewText(R.id.text, this.f2824O000000o.O0000o);
                    if (this.f2824O000000o.O00000oO == null) {
                        remoteViews.setTextViewText(R.id.text2, this.f2824O000000o.O00000oO);
                        remoteViews.setViewVisibility(R.id.text2, 0);
                        z4 = true;
                        if (z4 && Build.VERSION.SDK_INT >= 16) {
                            if (z) {
                                remoteViews.setTextViewTextSize(R.id.text, 0, (float) resources.getDimensionPixelSize(R.dimen.notification_subtext_size));
                            }
                            remoteViews.setViewPadding(R.id.line1, 0, 0, 0, 0);
                        }
                        if (this.f2824O000000o.O00000oO() != 0) {
                            z5 = z3;
                        } else if (!this.f2824O000000o.O0000o0 || Build.VERSION.SDK_INT < 16) {
                            remoteViews.setViewVisibility(R.id.time, 0);
                            remoteViews.setLong(R.id.time, "setTime", this.f2824O000000o.O00000oO());
                        } else {
                            remoteViews.setViewVisibility(R.id.chronometer, 0);
                            remoteViews.setLong(R.id.chronometer, "setBase", this.f2824O000000o.O00000oO() + (SystemClock.elapsedRealtime() - System.currentTimeMillis()));
                            remoteViews.setBoolean(R.id.chronometer, "setStarted", true);
                            if (this.f2824O000000o.O0000o0O && Build.VERSION.SDK_INT >= 24) {
                                remoteViews.setChronometerCountDown(R.id.chronometer, this.f2824O000000o.O0000o0O);
                            }
                        }
                        remoteViews.setViewVisibility(R.id.right_side, !z5 ? 0 : 8);
                        if (!z2) {
                            i2 = 8;
                        }
                        remoteViews.setViewVisibility(R.id.line3, i2);
                        return remoteViews;
                    }
                    remoteViews.setViewVisibility(R.id.text2, 8);
                }
                z4 = false;
                if (z) {
                }
                remoteViews.setViewPadding(R.id.line1, 0, 0, 0, 0);
                if (this.f2824O000000o.O00000oO() != 0) {
                }
                remoteViews.setViewVisibility(R.id.right_side, !z5 ? 0 : 8);
                if (!z2) {
                }
                remoteViews.setViewVisibility(R.id.line3, i2);
                return remoteViews;
            }
            z2 = true;
            z3 = true;
            remoteViews.setTextViewText(R.id.text, this.f2824O000000o.O0000o);
            if (this.f2824O000000o.O00000oO == null) {
            }
        }
    }

    public static class O00000Oo extends O00000o {
        private CharSequence O00000oO;

        public final O00000Oo O000000o(CharSequence charSequence) {
            this.O00000oO = Builder.O00000oO(charSequence);
            return this;
        }

        public final void O000000o(oOOOOO0O oooooo0o) {
            if (Build.VERSION.SDK_INT >= 16) {
                Notification.BigTextStyle bigText = new Notification.BigTextStyle(oooooo0o.O000000o()).setBigContentTitle(this.O00000Oo).bigText(this.O00000oO);
                if (this.O00000o) {
                    bigText.setSummaryText(this.O00000o0);
                }
            }
        }
    }

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public final Bundle f2823O000000o;
        public final b[] O00000Oo;
        public boolean O00000o;
        public final b[] O00000o0;
        public boolean O00000oO;
        public final int O00000oo;
        public final boolean O0000O0o;
        @Deprecated
        public int O0000OOo;
        public PendingIntent O0000Oo;
        public CharSequence O0000Oo0;
        private IconCompat O0000OoO;

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public O000000o(int i, CharSequence charSequence, PendingIntent pendingIntent) {
            this(i != 0 ? IconCompat.O000000o(null, "", i) : null, charSequence, pendingIntent);
        }

        private O000000o(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent) {
            this(iconCompat, charSequence, pendingIntent, new Bundle());
        }

        private O000000o(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle) {
            int i;
            this.O00000oO = true;
            this.O0000OoO = iconCompat;
            if (iconCompat != null) {
                if (iconCompat.f2830O000000o != -1 || Build.VERSION.SDK_INT < 23) {
                    i = iconCompat.f2830O000000o;
                } else {
                    i = IconCompat.O000000o((Icon) iconCompat.O00000Oo);
                }
                if (i == 2) {
                    this.O0000OOo = iconCompat.O000000o();
                }
            }
            this.O0000Oo0 = Builder.O00000oO(charSequence);
            this.O0000Oo = pendingIntent;
            this.f2823O000000o = bundle;
            this.O00000Oo = null;
            this.O00000o0 = null;
            this.O00000o = true;
            this.O00000oo = 0;
            this.O00000oO = true;
            this.O0000O0o = false;
        }

        public final IconCompat O000000o() {
            int i;
            if (this.O0000OoO == null && (i = this.O0000OOo) != 0) {
                this.O0000OoO = IconCompat.O000000o(null, "", i);
            }
            return this.O0000OoO;
        }
    }

    public static Bundle O000000o(Notification notification) {
        if (Build.VERSION.SDK_INT >= 19) {
            return notification.extras;
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return oo000000.O000000o(notification);
        }
        return null;
    }
}
