package com.google.android.gms.gcm;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Color;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.google.android.gms.common.util.PlatformVersion;
import com.xiaomi.smarthome.R;
import java.util.MissingFormatArgumentException;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;

final class zzd {
    static zzd zzj;
    private final Context zzk;
    private String zzl;
    private final AtomicInteger zzm = new AtomicInteger((int) SystemClock.elapsedRealtime());

    private zzd(Context context) {
        this.zzk = context.getApplicationContext();
    }

    static synchronized zzd zzd(Context context) {
        zzd zzd;
        synchronized (zzd.class) {
            if (zzj == null) {
                zzj = new zzd(context);
            }
            zzd = zzj;
        }
        return zzd;
    }

    static String zzd(Bundle bundle, String str) {
        String string = bundle.getString(str);
        return string == null ? bundle.getString(str.replace("gcm.n.", "gcm.notification.")) : string;
    }

    private final Bundle zze() {
        ApplicationInfo applicationInfo;
        try {
            applicationInfo = this.zzk.getPackageManager().getApplicationInfo(this.zzk.getPackageName(), NotificationCompat.FLAG_HIGH_PRIORITY);
        } catch (PackageManager.NameNotFoundException unused) {
            applicationInfo = null;
        }
        return (applicationInfo == null || applicationInfo.metaData == null) ? Bundle.EMPTY : applicationInfo.metaData;
    }

    private final String zze(Bundle bundle, String str) {
        String zzd = zzd(bundle, str);
        if (!TextUtils.isEmpty(zzd)) {
            return zzd;
        }
        String valueOf = String.valueOf(str);
        String zzd2 = zzd(bundle, "_loc_key".length() != 0 ? valueOf.concat("_loc_key") : new String(valueOf));
        if (TextUtils.isEmpty(zzd2)) {
            return null;
        }
        Resources resources = this.zzk.getResources();
        int identifier = resources.getIdentifier(zzd2, "string", this.zzk.getPackageName());
        if (identifier == 0) {
            String valueOf2 = String.valueOf(str);
            String substring = ("_loc_key".length() != 0 ? valueOf2.concat("_loc_key") : new String(valueOf2)).substring(6);
            StringBuilder sb = new StringBuilder(String.valueOf(substring).length() + 49 + String.valueOf(zzd2).length());
            sb.append(substring);
            sb.append(" resource not found: ");
            sb.append(zzd2);
            sb.append(" Default value will be used.");
            Log.w("GcmNotification", sb.toString());
            return null;
        }
        String valueOf3 = String.valueOf(str);
        String zzd3 = zzd(bundle, "_loc_args".length() != 0 ? valueOf3.concat("_loc_args") : new String(valueOf3));
        if (TextUtils.isEmpty(zzd3)) {
            return resources.getString(identifier);
        }
        try {
            JSONArray jSONArray = new JSONArray(zzd3);
            Object[] objArr = new String[jSONArray.length()];
            for (int i = 0; i < objArr.length; i++) {
                objArr[i] = jSONArray.opt(i);
            }
            return resources.getString(identifier, objArr);
        } catch (JSONException unused) {
            String valueOf4 = String.valueOf(str);
            String substring2 = ("_loc_args".length() != 0 ? valueOf4.concat("_loc_args") : new String(valueOf4)).substring(6);
            StringBuilder sb2 = new StringBuilder(String.valueOf(substring2).length() + 41 + String.valueOf(zzd3).length());
            sb2.append("Malformed ");
            sb2.append(substring2);
            sb2.append(": ");
            sb2.append(zzd3);
            sb2.append("  Default value will be used.");
            Log.w("GcmNotification", sb2.toString());
            return null;
        } catch (MissingFormatArgumentException e) {
            StringBuilder sb3 = new StringBuilder(String.valueOf(zzd2).length() + 58 + String.valueOf(zzd3).length());
            sb3.append("Missing format argument for ");
            sb3.append(zzd2);
            sb3.append(": ");
            sb3.append(zzd3);
            sb3.append(" Default value will be used.");
            Log.w("GcmNotification", sb3.toString(), e);
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x009c  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0102  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0116  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0148  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0178  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0201  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0278  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x0281  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x028a  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0292  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0297  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x02a9  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x02be  */
    public final boolean zze(Bundle bundle) {
        int i;
        String zzd;
        String zzd2;
        Uri uri;
        String zzd3;
        PendingIntent pendingIntent;
        Notification notification;
        String zzd4;
        String str;
        Intent intent;
        CharSequence zze = zze(bundle, "gcm.n.title");
        if (TextUtils.isEmpty(zze)) {
            zze = this.zzk.getApplicationInfo().loadLabel(this.zzk.getPackageManager());
        }
        String zze2 = zze(bundle, "gcm.n.body");
        String zzd5 = zzd(bundle, "gcm.n.icon");
        if (!TextUtils.isEmpty(zzd5)) {
            Resources resources = this.zzk.getResources();
            i = resources.getIdentifier(zzd5, "drawable", this.zzk.getPackageName());
            if (i == 0 && (i = resources.getIdentifier(zzd5, "mipmap", this.zzk.getPackageName())) == 0) {
                StringBuilder sb = new StringBuilder(String.valueOf(zzd5).length() + 57);
                sb.append("Icon resource ");
                sb.append(zzd5);
                sb.append(" not found. Notification will use app icon.");
                Log.w("GcmNotification", sb.toString());
            }
            zzd = zzd(bundle, "gcm.n.color");
            zzd2 = zzd(bundle, "gcm.n.sound2");
            String str2 = null;
            if (!TextUtils.isEmpty(zzd2)) {
                uri = null;
            } else if ("default".equals(zzd2) || this.zzk.getResources().getIdentifier(zzd2, "raw", this.zzk.getPackageName()) == 0) {
                uri = RingtoneManager.getDefaultUri(2);
            } else {
                String packageName = this.zzk.getPackageName();
                StringBuilder sb2 = new StringBuilder(String.valueOf(packageName).length() + 24 + String.valueOf(zzd2).length());
                sb2.append("android.resource://");
                sb2.append(packageName);
                sb2.append("/raw/");
                sb2.append(zzd2);
                uri = Uri.parse(sb2.toString());
            }
            zzd3 = zzd(bundle, "gcm.n.click_action");
            if (TextUtils.isEmpty(zzd3)) {
                intent = new Intent(zzd3);
                intent.setPackage(this.zzk.getPackageName());
                intent.setFlags(268435456);
            } else {
                intent = this.zzk.getPackageManager().getLaunchIntentForPackage(this.zzk.getPackageName());
                if (intent == null) {
                    Log.w("GcmNotification", "No activity found to launch app");
                    pendingIntent = null;
                    if (PlatformVersion.isAtLeastO() || this.zzk.getApplicationInfo().targetSdkVersion < 26) {
                        NotificationCompat.Builder O000000o2 = new NotificationCompat.Builder(this.zzk).O00000Oo().O000000o(i);
                        if (!TextUtils.isEmpty(zze)) {
                            O000000o2.O000000o(zze);
                        }
                        if (!TextUtils.isEmpty(zze2)) {
                            O000000o2.O00000Oo(zze2);
                        }
                        if (!TextUtils.isEmpty(zzd)) {
                            O000000o2.O000O0Oo = Color.parseColor(zzd);
                        }
                        if (uri != null) {
                            O000000o2.O000000o(uri);
                        }
                        if (pendingIntent != null) {
                            O000000o2.O00000oo = pendingIntent;
                        }
                        notification = O000000o2.O00000o();
                    } else {
                        String zzd6 = zzd(bundle, "gcm.n.android_channel_id");
                        if (PlatformVersion.isAtLeastO()) {
                            NotificationManager notificationManager = (NotificationManager) this.zzk.getSystemService(NotificationManager.class);
                            if (!TextUtils.isEmpty(zzd6)) {
                                if (notificationManager.getNotificationChannel(zzd6) == null) {
                                    StringBuilder sb3 = new StringBuilder(String.valueOf(zzd6).length() + 122);
                                    sb3.append("Notification Channel requested (");
                                    sb3.append(zzd6);
                                    sb3.append(") has not been created by the app. Manifest configuration, or default, value will be used.");
                                    Log.w("GcmNotification", sb3.toString());
                                }
                                str2 = zzd6;
                            }
                            zzd6 = this.zzl;
                            if (zzd6 == null) {
                                this.zzl = zze().getString("com.google.android.gms.gcm.default_notification_channel_id");
                                if (TextUtils.isEmpty(this.zzl)) {
                                    str = "Missing Default Notification Channel metadata in AndroidManifest. Default value will be used.";
                                    Log.w("GcmNotification", str);
                                    if (notificationManager.getNotificationChannel("fcm_fallback_notification_channel") == null) {
                                    }
                                    this.zzl = "fcm_fallback_notification_channel";
                                } else if (notificationManager.getNotificationChannel(this.zzl) == null) {
                                    str = "Notification Channel set in AndroidManifest.xml has not been created by the app. Default value will be used.";
                                    Log.w("GcmNotification", str);
                                    if (notificationManager.getNotificationChannel("fcm_fallback_notification_channel") == null) {
                                        notificationManager.createNotificationChannel(new NotificationChannel("fcm_fallback_notification_channel", this.zzk.getString(R.string.gcm_fallback_notification_channel_label), 3));
                                    }
                                    this.zzl = "fcm_fallback_notification_channel";
                                }
                                str2 = this.zzl;
                            }
                            str2 = zzd6;
                        }
                        Notification.Builder smallIcon = new Notification.Builder(this.zzk).setAutoCancel(true).setSmallIcon(i);
                        if (!TextUtils.isEmpty(zze)) {
                            smallIcon.setContentTitle(zze);
                        }
                        if (!TextUtils.isEmpty(zze2)) {
                            smallIcon.setContentText(zze2);
                            smallIcon.setStyle(new Notification.BigTextStyle().bigText(zze2));
                        }
                        if (!TextUtils.isEmpty(zzd)) {
                            smallIcon.setColor(Color.parseColor(zzd));
                        }
                        if (uri != null) {
                            smallIcon.setSound(uri);
                        }
                        if (pendingIntent != null) {
                            smallIcon.setContentIntent(pendingIntent);
                        }
                        if (str2 != null) {
                            smallIcon.setChannelId(str2);
                        }
                        notification = smallIcon.build();
                    }
                    zzd4 = zzd(bundle, "gcm.n.tag");
                    if (Log.isLoggable("GcmNotification", 3)) {
                        Log.d("GcmNotification", "Showing notification");
                    }
                    NotificationManager notificationManager2 = (NotificationManager) this.zzk.getSystemService("notification");
                    if (TextUtils.isEmpty(zzd4)) {
                        long uptimeMillis = SystemClock.uptimeMillis();
                        StringBuilder sb4 = new StringBuilder(37);
                        sb4.append("GCM-Notification:");
                        sb4.append(uptimeMillis);
                        zzd4 = sb4.toString();
                    }
                    notificationManager2.notify(zzd4, 0, notification);
                    return true;
                }
            }
            Bundle bundle2 = new Bundle(bundle);
            GcmListenerService.zzd(bundle2);
            intent.putExtras(bundle2);
            for (String next : bundle2.keySet()) {
                if (next.startsWith("gcm.n.") || next.startsWith("gcm.notification.")) {
                    intent.removeExtra(next);
                }
            }
            pendingIntent = PendingIntent.getActivity(this.zzk, this.zzm.getAndIncrement(), intent, 1073741824);
            if (PlatformVersion.isAtLeastO()) {
            }
            NotificationCompat.Builder O000000o22 = new NotificationCompat.Builder(this.zzk).O00000Oo().O000000o(i);
            if (!TextUtils.isEmpty(zze)) {
            }
            if (!TextUtils.isEmpty(zze2)) {
            }
            if (!TextUtils.isEmpty(zzd)) {
            }
            if (uri != null) {
            }
            if (pendingIntent != null) {
            }
            notification = O000000o22.O00000o();
            zzd4 = zzd(bundle, "gcm.n.tag");
            if (Log.isLoggable("GcmNotification", 3)) {
            }
            NotificationManager notificationManager22 = (NotificationManager) this.zzk.getSystemService("notification");
            if (TextUtils.isEmpty(zzd4)) {
            }
            notificationManager22.notify(zzd4, 0, notification);
            return true;
        }
        int i2 = this.zzk.getApplicationInfo().icon;
        i = i2 == 0 ? 17301651 : i2;
        zzd = zzd(bundle, "gcm.n.color");
        zzd2 = zzd(bundle, "gcm.n.sound2");
        String str22 = null;
        if (!TextUtils.isEmpty(zzd2)) {
        }
        zzd3 = zzd(bundle, "gcm.n.click_action");
        if (TextUtils.isEmpty(zzd3)) {
        }
        Bundle bundle22 = new Bundle(bundle);
        GcmListenerService.zzd(bundle22);
        intent.putExtras(bundle22);
        while (r6.hasNext()) {
        }
        pendingIntent = PendingIntent.getActivity(this.zzk, this.zzm.getAndIncrement(), intent, 1073741824);
        if (PlatformVersion.isAtLeastO()) {
        }
        NotificationCompat.Builder O000000o222 = new NotificationCompat.Builder(this.zzk).O00000Oo().O000000o(i);
        if (!TextUtils.isEmpty(zze)) {
        }
        if (!TextUtils.isEmpty(zze2)) {
        }
        if (!TextUtils.isEmpty(zzd)) {
        }
        if (uri != null) {
        }
        if (pendingIntent != null) {
        }
        notification = O000000o222.O00000o();
        zzd4 = zzd(bundle, "gcm.n.tag");
        if (Log.isLoggable("GcmNotification", 3)) {
        }
        NotificationManager notificationManager222 = (NotificationManager) this.zzk.getSystemService("notification");
        if (TextUtils.isEmpty(zzd4)) {
        }
        notificationManager222.notify(zzd4, 0, notification);
        return true;
    }
}
