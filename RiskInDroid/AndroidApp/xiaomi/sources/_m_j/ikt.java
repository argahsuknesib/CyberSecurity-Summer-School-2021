package _m_j;

import _m_j.ilj;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Build;
import android.text.TextUtils;
import android.widget.RemoteViews;
import com.ximalaya.ting.android.opensdk.model.PlayableModel;
import com.ximalaya.ting.android.opensdk.model.track.Track;
import com.ximalaya.ting.android.opensdk.player.receive.PlayerReceiver;
import com.ximalaya.ting.android.opensdk.player.service.XmPlayListControl;

public class ikt {
    public static String O00000oo;
    private static ikt O0000o00;

    /* renamed from: O000000o  reason: collision with root package name */
    public RemoteViews f1422O000000o;
    public RemoteViews O00000Oo;
    public RemoteViews O00000o;
    public RemoteViews O00000o0;
    public Context O00000oO;
    public O000000o O0000O0o = new O000000o(this, (byte) 0);
    private PendingIntent O0000OOo;
    private PendingIntent O0000Oo;
    private PendingIntent O0000Oo0;
    private PendingIntent O0000OoO;
    private Resources O0000Ooo;
    private int O0000o0 = Build.VERSION.SDK_INT;
    private String O0000o0O = "";

    private ikt(Context context) {
        this.O00000oO = context;
        this.O0000Ooo = context.getResources();
        this.O0000o0O = this.O00000oO.getPackageName();
    }

    public static ikt O000000o(Context context) {
        if (O0000o00 == null) {
            synchronized (ikt.class) {
                if (O0000o00 == null) {
                    O0000o00 = new ikt(context.getApplicationContext());
                }
            }
        }
        return O0000o00;
    }

    public final void O000000o() {
        Intent intent = new Intent(this.O0000o0O.equals("com.ximalaya.ting.android") ? "com.ximalaya.ting.android.ACTION_CONTROL_START_PAUSE_MAIN" : "com.ximalaya.ting.android.ACTION_CONTROL_START_PAUSE");
        intent.setClass(this.O00000oO, PlayerReceiver.class);
        this.O0000OOo = PendingIntent.getBroadcast(this.O00000oO, 0, intent, 0);
    }

    public final void O00000Oo() {
        Intent intent = new Intent(this.O0000o0O.equals("com.ximalaya.ting.android") ? "com.ximalaya.ting.android.ACTION_CONTROL_PLAY_NEXT_MAIN" : "com.ximalaya.ting.android.ACTION_CONTROL_PLAY_NEXT");
        intent.setClass(this.O00000oO, PlayerReceiver.class);
        this.O0000Oo0 = PendingIntent.getBroadcast(this.O00000oO, 0, intent, 0);
    }

    public final void O00000o0() {
        Intent intent = new Intent(this.O0000o0O.equals("com.ximalaya.ting.android") ? "com.ximalaya.ting.android.ACTION_CONTROL_PLAY_PRE_MAIN" : "com.ximalaya.ting.android.ACTION_CONTROL_PLAY_PRE");
        intent.setClass(this.O00000oO, PlayerReceiver.class);
        this.O0000Oo = PendingIntent.getBroadcast(this.O00000oO, 0, intent, 0);
    }

    public final void O00000o() {
        Intent intent = new Intent(this.O0000o0O.equals("com.ximalaya.ting.android") ? "com.ximalaya.ting.android.ACTION_CLOSE_MAIN" : "com.ximalaya.ting.android.ACTION_CLOSE");
        intent.setClass(this.O00000oO, PlayerReceiver.class);
        this.O0000OoO = PendingIntent.getBroadcast(this.O00000oO, 0, intent, 0);
    }

    private boolean O00000oo() {
        return this.O0000o0 >= 16;
    }

    public final RemoteViews O000000o(Context context, boolean z) {
        RemoteViews remoteViews;
        if (!O00000oo()) {
            return null;
        }
        if ("and-d8".equals(O00000oo)) {
            if (z) {
                remoteViews = new RemoteViews(context.getPackageName(), O000000o("reflect_view_notify_dark_play_big_for_oppo", "layout"));
            } else {
                remoteViews = new RemoteViews(context.getPackageName(), O000000o("reflect_view_notify_play_big_for_oppo", "layout"));
            }
        } else if (z) {
            remoteViews = new RemoteViews(context.getPackageName(), O000000o("view_notify_dark_play_big", "layout"));
        } else {
            remoteViews = new RemoteViews(context.getPackageName(), O000000o("view_notify_play_big", "layout"));
        }
        if (this.O0000Oo == null) {
            O00000o0();
        }
        if (this.O0000Oo != null) {
            remoteViews.setOnClickPendingIntent(O000000o("img_notifyPre", "id"), this.O0000Oo);
        }
        if (this.O0000OoO == null) {
            O00000o();
        }
        if (this.O0000OoO != null) {
            remoteViews.setOnClickPendingIntent(O000000o("img_notifyClose", "id"), this.O0000OoO);
        }
        if (this.O0000OOo == null) {
            O000000o();
        }
        if (this.O0000OOo != null) {
            remoteViews.setOnClickPendingIntent(O000000o("img_notifyPlayOrPause", "id"), this.O0000OOo);
        }
        if (this.O0000Oo0 == null) {
            O00000Oo();
        }
        if (this.O0000Oo0 != null) {
            remoteViews.setOnClickPendingIntent(O000000o("img_notifyNext", "id"), this.O0000Oo0);
        }
        return remoteViews;
    }

    public final RemoteViews O00000Oo(Context context, boolean z) {
        RemoteViews remoteViews;
        if ("and-d8".equals(O00000oo)) {
            if (z) {
                remoteViews = new RemoteViews(context.getPackageName(), O000000o("reflect_view_notify_dark_play_for_oppo", "layout"));
            } else {
                remoteViews = new RemoteViews(context.getPackageName(), O000000o("reflect_view_notify_play_for_oppo", "layout"));
            }
        } else if (z) {
            remoteViews = new RemoteViews(context.getPackageName(), O000000o("view_notify_dark_play", "layout"));
        } else {
            remoteViews = new RemoteViews(context.getPackageName(), O000000o("view_notify_play", "layout"));
        }
        if (this.O0000OOo == null) {
            O000000o();
        }
        if (this.O0000OOo != null) {
            remoteViews.setOnClickPendingIntent(O000000o("img_notifyPlayOrPause", "id"), this.O0000OOo);
        }
        if (this.O0000Oo0 == null) {
            O00000Oo();
        }
        if (this.O0000Oo0 != null) {
            remoteViews.setOnClickPendingIntent(O000000o("img_notifyNext", "id"), this.O0000Oo0);
        }
        if (this.O0000OoO == null) {
            O00000o();
        }
        if (this.O0000OoO != null) {
            remoteViews.setOnClickPendingIntent(O000000o("img_notifyClose", "id"), this.O0000OoO);
        }
        return remoteViews;
    }

    public final int O000000o(String str, String str2) {
        return this.O0000Ooo.getIdentifier(str, str2, this.O00000oO.getPackageName());
    }

    public final void O000000o(NotificationManager notificationManager, Notification notification, int i, boolean z) {
        if (notification != null) {
            this.O00000o = O000000o(this.O00000oO, z);
            if (Build.VERSION.SDK_INT >= 16) {
                notification.bigContentView = this.O00000o;
            }
            this.O00000o0 = O00000Oo(this.O00000oO, z);
            notification.contentView = this.O00000o0;
            O000000o o000000o = this.O0000O0o;
            o000000o.O00000o = z;
            o000000o.O0000O0o = true;
            try {
                O000000o(o000000o, notificationManager, notification, i);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void O000000o(boolean z, boolean z2) {
        int i;
        int i2;
        if (O00000oo() && this.O00000o0 != null) {
            if (z) {
                if (z2) {
                    i2 = O000000o("notify_btn_next_pressed", "drawable");
                } else {
                    i2 = O000000o("notify_btn_next_pressed", "drawable");
                }
            } else if (z2) {
                i2 = O000000o("notify_btn_light_next_normal_xml", "drawable");
            } else {
                i2 = O000000o("notify_btn_dark_next_normal_xml", "drawable");
            }
            try {
                this.O00000o0.setImageViewResource(O000000o("img_notifyNext", "id"), i2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (O00000oo() && this.O00000o != null) {
            if (z) {
                if (z2) {
                    i = O000000o("notify_btn_next_pressed", "drawable");
                } else {
                    i = O000000o("notify_btn_next_pressed", "drawable");
                }
            } else if (z2) {
                i = O000000o("notify_btn_light_next_normal_xml", "drawable");
            } else {
                i = O000000o("notify_btn_dark_next_normal_xml", "drawable");
            }
            this.O00000o.setImageViewResource(O000000o("img_notifyNext", "id"), i);
        }
    }

    private void O00000Oo(boolean z, boolean z2) {
        int i;
        if (O00000oo() && this.O00000o != null) {
            if (z) {
                if (z2) {
                    i = O000000o("notify_btn_prev_pressed", "drawable");
                } else {
                    i = O000000o("notify_btn_prev_pressed", "drawable");
                }
            } else if (z2) {
                i = O000000o("notify_btn_light_prev_normal_xml", "drawable");
            } else {
                i = O000000o("notify_btn_dark_prev_normal_xml", "drawable");
            }
            try {
                this.O00000o.setImageViewResource(O000000o("img_notifyPre", "id"), i);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00ee  */
    public final void O000000o(XmPlayListControl xmPlayListControl, final NotificationManager notificationManager, final Notification notification, final int i, boolean z) {
        String str;
        if (notification != null) {
            this.O00000o = O000000o(this.O00000oO, z);
            if (O00000oo() && Build.VERSION.SDK_INT >= 16) {
                notification.bigContentView = this.O00000o;
            }
            this.O00000o0 = O00000Oo(this.O00000oO, z);
            notification.contentView = this.O00000o0;
            PlayableModel playableModel = xmPlayListControl.O00000o;
            if (playableModel == null || this.O00000o0 == null || notificationManager == null) {
                O000000o o000000o = this.O0000O0o;
                o000000o.O00000Oo = "随时随地 听我想听";
                o000000o.f1424O000000o = "喜马拉雅";
                o000000o.O00000o = z;
                o000000o.O0000O0o = false;
                o000000o.O00000o0 = null;
                o000000o.O00000oo = true;
                o000000o.O00000oO = true;
                O000000o(o000000o, notificationManager, notification, i);
                return;
            }
            Track track = (Track) playableModel;
            String str2 = track.O0000Oo0;
            if (TextUtils.isEmpty(str2)) {
                str2 = "";
            }
            if (!"track".equals(playableModel.O00000Oo) && !"live_flv".equals(playableModel.O00000Oo)) {
                if ("radio".equals(playableModel.O00000Oo)) {
                    str = track.O0000Oo;
                } else if ("schedule".equals(playableModel.O00000Oo) && track.O000000o() != null) {
                    str = track.O000000o().O00000Oo;
                }
                if (TextUtils.isEmpty(str)) {
                }
                O000000o o000000o2 = this.O0000O0o;
                o000000o2.O00000Oo = str2;
                o000000o2.f1424O000000o = str;
                o000000o2.O00000o = z;
                o000000o2.O0000O0o = false;
                o000000o2.O00000o0 = null;
                int i2 = xmPlayListControl.O0000Oo;
                int size = xmPlayListControl.O00000o0.size();
                if (playableModel instanceof Track) {
                }
                O000000o(this.O0000O0o, notificationManager, notification, i);
                int O000000o2 = O000000o(this.O00000oO, 64.0f);
                if (O00000oo()) {
                }
                ilj.O000000o(this.O00000oO, track, O000000o2, O000000o2, new ilj.O00000Oo() {
                    /* class _m_j.ikt.AnonymousClass1 */

                    public final void O000000o(Bitmap bitmap) {
                        ikt.this.O0000O0o.O00000o0 = bitmap;
                        ikt ikt = ikt.this;
                        ikt.O000000o(ikt.O0000O0o, notificationManager, notification, i);
                    }
                });
            } else if (track.O000000o() != null) {
                str = track.O000000o().O00000Oo;
                if (TextUtils.isEmpty(str)) {
                    str = "";
                }
                O000000o o000000o22 = this.O0000O0o;
                o000000o22.O00000Oo = str2;
                o000000o22.f1424O000000o = str;
                o000000o22.O00000o = z;
                o000000o22.O0000O0o = false;
                o000000o22.O00000o0 = null;
                if (!(xmPlayListControl == null || xmPlayListControl.O00000o0 == null || xmPlayListControl.O00000o0.size() <= 0)) {
                    int i22 = xmPlayListControl.O0000Oo;
                    int size2 = xmPlayListControl.O00000o0.size();
                    if (playableModel instanceof Track) {
                        if (i22 == 0) {
                            O000000o o000000o3 = this.O0000O0o;
                            o000000o3.O00000oO = true;
                            if (size2 == 1) {
                                o000000o3.O00000oo = true;
                            } else {
                                o000000o3.O00000oo = false;
                            }
                        } else if (i22 == size2 - 1) {
                            O000000o o000000o4 = this.O0000O0o;
                            o000000o4.O00000oo = true;
                            if (size2 >= 2) {
                                o000000o4.O00000oO = false;
                            } else {
                                o000000o4.O00000oO = true;
                            }
                        } else {
                            O000000o o000000o5 = this.O0000O0o;
                            o000000o5.O00000oO = false;
                            o000000o5.O00000oo = false;
                        }
                    }
                }
                O000000o(this.O0000O0o, notificationManager, notification, i);
                int O000000o22 = O000000o(this.O00000oO, 64.0f);
                if (O00000oo()) {
                    O000000o22 = O000000o(this.O00000oO, 110.0f);
                }
                ilj.O000000o(this.O00000oO, track, O000000o22, O000000o22, new ilj.O00000Oo() {
                    /* class _m_j.ikt.AnonymousClass1 */

                    public final void O000000o(Bitmap bitmap) {
                        ikt.this.O0000O0o.O00000o0 = bitmap;
                        ikt ikt = ikt.this;
                        ikt.O000000o(ikt.O0000O0o, notificationManager, notification, i);
                    }
                });
            }
            str = null;
            if (TextUtils.isEmpty(str)) {
            }
            O000000o o000000o222 = this.O0000O0o;
            o000000o222.O00000Oo = str2;
            o000000o222.f1424O000000o = str;
            o000000o222.O00000o = z;
            o000000o222.O0000O0o = false;
            o000000o222.O00000o0 = null;
            int i222 = xmPlayListControl.O0000Oo;
            int size22 = xmPlayListControl.O00000o0.size();
            if (playableModel instanceof Track) {
            }
            O000000o(this.O0000O0o, notificationManager, notification, i);
            int O000000o222 = O000000o(this.O00000oO, 64.0f);
            if (O00000oo()) {
            }
            ilj.O000000o(this.O00000oO, track, O000000o222, O000000o222, new ilj.O00000Oo() {
                /* class _m_j.ikt.AnonymousClass1 */

                public final void O000000o(Bitmap bitmap) {
                    ikt.this.O0000O0o.O00000o0 = bitmap;
                    ikt ikt = ikt.this;
                    ikt.O000000o(ikt.O0000O0o, notificationManager, notification, i);
                }
            });
        }
    }

    public class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        String f1424O000000o;
        String O00000Oo;
        public boolean O00000o;
        Bitmap O00000o0;
        boolean O00000oO;
        boolean O00000oo;
        public boolean O0000O0o;

        private O000000o() {
        }

        /* synthetic */ O000000o(ikt ikt, byte b) {
            this();
        }
    }

    public final void O000000o(O000000o o000000o, NotificationManager notificationManager, Notification notification, int i) {
        RemoteViews remoteViews;
        RemoteViews remoteViews2;
        RemoteViews remoteViews3;
        if (notificationManager != null && notification != null) {
            if (TextUtils.isEmpty(o000000o.f1424O000000o)) {
                o000000o.f1424O000000o = "喜马拉雅";
            }
            if (TextUtils.isEmpty(o000000o.O00000Oo)) {
                o000000o.O00000Oo = "随时随地 听我想听";
            }
            O000000o(this.O00000o, this.O00000o0);
            if (O00000oo() && (remoteViews3 = this.O00000o) != null) {
                remoteViews3.setTextViewText(O000000o("txt_notifyMusicName", "id"), o000000o.O00000Oo);
                this.O00000o.setTextViewText(O000000o("txt_notifyNickName", "id"), o000000o.f1424O000000o);
                if (o000000o.O00000o) {
                    if (o000000o.O0000O0o) {
                        this.O00000o.setImageViewResource(O000000o("img_notifyPlayOrPause", "id"), O000000o("notify_btn_light_play_normal_xml", "drawable"));
                    } else {
                        this.O00000o.setImageViewResource(O000000o("img_notifyPlayOrPause", "id"), O000000o("notify_btn_light_pause_normal_xml", "drawable"));
                    }
                } else if (o000000o.O0000O0o) {
                    this.O00000o.setImageViewResource(O000000o("img_notifyPlayOrPause", "id"), O000000o("notify_btn_dark_play_normal_xml", "drawable"));
                } else {
                    this.O00000o.setImageViewResource(O000000o("img_notifyPlayOrPause", "id"), O000000o("notify_btn_dark_pause_normal_xml", "drawable"));
                }
            }
            this.O00000o0.setTextViewText(O000000o("txt_notifyMusicName", "id"), o000000o.O00000Oo);
            this.O00000o0.setTextViewText(O000000o("txt_notifyNickName", "id"), o000000o.f1424O000000o);
            if (o000000o.O00000o) {
                if (o000000o.O0000O0o) {
                    this.O00000o0.setImageViewResource(O000000o("img_notifyPlayOrPause", "id"), O000000o("notify_btn_light_play2_normal_xml", "drawable"));
                } else {
                    this.O00000o0.setImageViewResource(O000000o("img_notifyPlayOrPause", "id"), O000000o("notify_btn_light_pause2_normal_xml", "drawable"));
                }
            } else if (o000000o.O0000O0o) {
                this.O00000o0.setImageViewResource(O000000o("img_notifyPlayOrPause", "id"), O000000o("notify_btn_dark_play2_normal_xml", "drawable"));
            } else {
                this.O00000o0.setImageViewResource(O000000o("img_notifyPlayOrPause", "id"), O000000o("notify_btn_dark_pause2_normal_xml", "drawable"));
            }
            O000000o(o000000o.O00000oo, o000000o.O00000o);
            O00000Oo(o000000o.O00000oO, o000000o.O00000o);
            if (o000000o.O00000o0 == null || o000000o.O00000o0.isRecycled()) {
                RemoteViews remoteViews4 = this.O00000o0;
                if (remoteViews4 != null) {
                    try {
                        remoteViews4.setInt(O000000o("img_notifyIcon", "id"), "setImageResource", O000000o("notification_default", "drawable"));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                if (O00000oo() && (remoteViews = this.O00000o) != null) {
                    try {
                        remoteViews.setInt(O000000o("img_notifyIcon", "id"), "setImageResource", O000000o("notification_default", "drawable"));
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            } else {
                RemoteViews remoteViews5 = this.O00000o0;
                if (remoteViews5 != null) {
                    remoteViews5.setImageViewBitmap(O000000o("img_notifyIcon", "id"), o000000o.O00000o0);
                }
                if (O00000oo() && (remoteViews2 = this.O00000o) != null) {
                    remoteViews2.setImageViewBitmap(O000000o("img_notifyIcon", "id"), o000000o.O00000o0);
                }
            }
            try {
                notificationManager.notify(i, notification);
            } catch (Throwable unused) {
            }
        }
    }

    private static int O000000o(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static void O00000oO() {
        ikt ikt = O0000o00;
        if (ikt != null) {
            ikt.f1422O000000o = null;
            ikt.O00000Oo = null;
            ikt.O00000o0 = null;
            ikt.O00000o = null;
            O0000o00 = null;
        }
    }

    public final void O000000o(RemoteViews remoteViews, RemoteViews remoteViews2) {
        if (remoteViews != null) {
            iks.O000000o(this.O00000oO, remoteViews, O000000o("txt_notifyMusicName", "id"));
            iks.O00000Oo(this.O00000oO, remoteViews, O000000o("txt_notifyNickName", "id"));
        }
        iks.O000000o(this.O00000oO, remoteViews2, O000000o("txt_notifyMusicName", "id"));
        iks.O00000Oo(this.O00000oO, remoteViews2, O000000o("txt_notifyNickName", "id"));
    }
}
