package com.google.firebase.messaging;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.app.KeyguardManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.AdaptiveIconDrawable;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import android.os.SystemClock;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.firebase.iid.zzan;
import com.xiaomi.smarthome.R;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.MissingFormatArgumentException;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;

final class zza {
    private static zza zzcz;
    private Bundle zzda;
    private Method zzdb;
    private Method zzdc;
    private final AtomicInteger zzdd = new AtomicInteger((int) SystemClock.elapsedRealtime());
    private final Context zzz;

    private zza(Context context) {
        this.zzz = context.getApplicationContext();
    }

    @TargetApi(26)
    private final Notification zza(CharSequence charSequence, String str, int i, Integer num, Uri uri, PendingIntent pendingIntent, PendingIntent pendingIntent2, String str2) {
        Notification.Builder smallIcon = new Notification.Builder(this.zzz).setAutoCancel(true).setSmallIcon(i);
        if (!TextUtils.isEmpty(charSequence)) {
            smallIcon.setContentTitle(charSequence);
        }
        if (!TextUtils.isEmpty(str)) {
            smallIcon.setContentText(str);
            smallIcon.setStyle(new Notification.BigTextStyle().bigText(str));
        }
        if (num != null) {
            smallIcon.setColor(num.intValue());
        }
        if (uri != null) {
            smallIcon.setSound(uri);
        }
        if (pendingIntent != null) {
            smallIcon.setContentIntent(pendingIntent);
        }
        if (pendingIntent2 != null) {
            smallIcon.setDeleteIntent(pendingIntent2);
        }
        if (str2 != null) {
            if (this.zzdb == null) {
                this.zzdb = zzl("setChannelId");
            }
            if (this.zzdb == null) {
                this.zzdb = zzl("setChannel");
            }
            Method method = this.zzdb;
            if (method == null) {
                Log.e("FirebaseMessaging", "Error while setting the notification channel");
            } else {
                try {
                    method.invoke(smallIcon, str2);
                } catch (IllegalAccessException | IllegalArgumentException | SecurityException | InvocationTargetException e) {
                    Log.e("FirebaseMessaging", "Error while setting the notification channel", e);
                }
            }
        }
        return smallIcon.build();
    }

    static String zza(Bundle bundle, String str) {
        String string = bundle.getString(str);
        return string == null ? bundle.getString(str.replace("gcm.n.", "gcm.notification.")) : string;
    }

    private static void zza(Intent intent, Bundle bundle) {
        for (String next : bundle.keySet()) {
            if (next.startsWith("google.c.a.") || next.equals("from")) {
                intent.putExtra(next, bundle.getString(next));
            }
        }
    }

    private final Bundle zzal() {
        Bundle bundle = this.zzda;
        if (bundle != null) {
            return bundle;
        }
        ApplicationInfo applicationInfo = null;
        try {
            applicationInfo = this.zzz.getPackageManager().getApplicationInfo(this.zzz.getPackageName(), NotificationCompat.FLAG_HIGH_PRIORITY);
        } catch (PackageManager.NameNotFoundException unused) {
        }
        if (applicationInfo == null || applicationInfo.metaData == null) {
            return Bundle.EMPTY;
        }
        this.zzda = applicationInfo.metaData;
        return this.zzda;
    }

    static String zzb(Bundle bundle, String str) {
        String valueOf = String.valueOf(str);
        return zza(bundle, "_loc_key".length() != 0 ? valueOf.concat("_loc_key") : new String(valueOf));
    }

    @TargetApi(26)
    private final boolean zzb(int i) {
        if (Build.VERSION.SDK_INT != 26) {
            return true;
        }
        try {
            if (!(this.zzz.getResources().getDrawable(i, null) instanceof AdaptiveIconDrawable)) {
                return true;
            }
            StringBuilder sb = new StringBuilder(77);
            sb.append("Adaptive icons cannot be used in notifications. Ignoring icon id: ");
            sb.append(i);
            Log.e("FirebaseMessaging", sb.toString());
            return false;
        } catch (Resources.NotFoundException unused) {
            return false;
        }
    }

    static Object[] zzc(Bundle bundle, String str) {
        String valueOf = String.valueOf(str);
        String zza = zza(bundle, "_loc_args".length() != 0 ? valueOf.concat("_loc_args") : new String(valueOf));
        if (TextUtils.isEmpty(zza)) {
            return null;
        }
        try {
            JSONArray jSONArray = new JSONArray(zza);
            Object[] objArr = new String[jSONArray.length()];
            for (int i = 0; i < objArr.length; i++) {
                objArr[i] = jSONArray.opt(i);
            }
            return objArr;
        } catch (JSONException unused) {
            String valueOf2 = String.valueOf(str);
            String substring = ("_loc_args".length() != 0 ? valueOf2.concat("_loc_args") : new String(valueOf2)).substring(6);
            StringBuilder sb = new StringBuilder(String.valueOf(substring).length() + 41 + String.valueOf(zza).length());
            sb.append("Malformed ");
            sb.append(substring);
            sb.append(": ");
            sb.append(zza);
            sb.append("  Default value will be used.");
            Log.w("FirebaseMessaging", sb.toString());
            return null;
        }
    }

    static synchronized zza zzd(Context context) {
        zza zza;
        synchronized (zza.class) {
            if (zzcz == null) {
                zzcz = new zza(context);
            }
            zza = zzcz;
        }
        return zza;
    }

    private final String zzd(Bundle bundle, String str) {
        String zza = zza(bundle, str);
        if (!TextUtils.isEmpty(zza)) {
            return zza;
        }
        String zzb = zzb(bundle, str);
        if (TextUtils.isEmpty(zzb)) {
            return null;
        }
        Resources resources = this.zzz.getResources();
        int identifier = resources.getIdentifier(zzb, "string", this.zzz.getPackageName());
        if (identifier == 0) {
            String valueOf = String.valueOf(str);
            String substring = ("_loc_key".length() != 0 ? valueOf.concat("_loc_key") : new String(valueOf)).substring(6);
            StringBuilder sb = new StringBuilder(String.valueOf(substring).length() + 49 + String.valueOf(zzb).length());
            sb.append(substring);
            sb.append(" resource not found: ");
            sb.append(zzb);
            sb.append(" Default value will be used.");
            Log.w("FirebaseMessaging", sb.toString());
            return null;
        }
        Object[] zzc = zzc(bundle, str);
        if (zzc == null) {
            return resources.getString(identifier);
        }
        try {
            return resources.getString(identifier, zzc);
        } catch (MissingFormatArgumentException e) {
            String arrays = Arrays.toString(zzc);
            StringBuilder sb2 = new StringBuilder(String.valueOf(zzb).length() + 58 + String.valueOf(arrays).length());
            sb2.append("Missing format argument for ");
            sb2.append(zzb);
            sb2.append(": ");
            sb2.append(arrays);
            sb2.append(" Default value will be used.");
            Log.w("FirebaseMessaging", sb2.toString(), e);
            return null;
        }
    }

    static boolean zzf(Bundle bundle) {
        return "1".equals(zza(bundle, "gcm.n.e")) || zza(bundle, "gcm.n.icon") != null;
    }

    static Uri zzg(Bundle bundle) {
        String zza = zza(bundle, "gcm.n.link_android");
        if (TextUtils.isEmpty(zza)) {
            zza = zza(bundle, "gcm.n.link");
        }
        if (!TextUtils.isEmpty(zza)) {
            return Uri.parse(zza);
        }
        return null;
    }

    static String zzi(Bundle bundle) {
        String zza = zza(bundle, "gcm.n.sound2");
        return TextUtils.isEmpty(zza) ? zza(bundle, "gcm.n.sound") : zza;
    }

    @TargetApi(26)
    private static Method zzl(String str) {
        try {
            return Notification.Builder.class.getMethod(str, String.class);
        } catch (NoSuchMethodException | SecurityException unused) {
            return null;
        }
    }

    private final Integer zzm(String str) {
        if (Build.VERSION.SDK_INT < 21) {
            return null;
        }
        if (!TextUtils.isEmpty(str)) {
            try {
                return Integer.valueOf(Color.parseColor(str));
            } catch (IllegalArgumentException unused) {
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 54);
                sb.append("Color ");
                sb.append(str);
                sb.append(" not valid. Notification will use default color.");
                Log.w("FirebaseMessaging", sb.toString());
            }
        }
        int i = zzal().getInt("com.google.firebase.messaging.default_notification_color", 0);
        if (i != 0) {
            try {
                return Integer.valueOf(ContextCompat.O00000o0(this.zzz, i));
            } catch (Resources.NotFoundException unused2) {
                Log.w("FirebaseMessaging", "Cannot find the color resource referenced in AndroidManifest.");
            }
        }
        return null;
    }

    @TargetApi(26)
    private final String zzn(String str) {
        String str2;
        if (!PlatformVersion.isAtLeastO()) {
            return null;
        }
        NotificationManager notificationManager = (NotificationManager) this.zzz.getSystemService(NotificationManager.class);
        try {
            if (this.zzdc == null) {
                this.zzdc = notificationManager.getClass().getMethod("getNotificationChannel", String.class);
            }
            if (!TextUtils.isEmpty(str)) {
                if (this.zzdc.invoke(notificationManager, str) != null) {
                    return str;
                }
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 122);
                sb.append("Notification Channel requested (");
                sb.append(str);
                sb.append(") has not been created by the app. Manifest configuration, or default, value will be used.");
                Log.w("FirebaseMessaging", sb.toString());
            }
            String string = zzal().getString("com.google.firebase.messaging.default_notification_channel_id");
            if (!TextUtils.isEmpty(string)) {
                if (this.zzdc.invoke(notificationManager, string) != null) {
                    return string;
                }
                str2 = "Notification Channel set in AndroidManifest.xml has not been created by the app. Default value will be used.";
            } else {
                str2 = "Missing Default Notification Channel metadata in AndroidManifest. Default value will be used.";
            }
            Log.w("FirebaseMessaging", str2);
            if (this.zzdc.invoke(notificationManager, "fcm_fallback_notification_channel") == null) {
                Class<?> cls = Class.forName("android.app.NotificationChannel");
                Object newInstance = cls.getConstructor(String.class, CharSequence.class, Integer.TYPE).newInstance("fcm_fallback_notification_channel", this.zzz.getString(R.string.fcm_fallback_notification_channel_label), 3);
                notificationManager.getClass().getMethod("createNotificationChannel", cls).invoke(notificationManager, newInstance);
            }
            return "fcm_fallback_notification_channel";
        } catch (ClassNotFoundException | IllegalAccessException | IllegalArgumentException | InstantiationException | LinkageError | NoSuchMethodException | SecurityException | InvocationTargetException e) {
            Log.e("FirebaseMessaging", "Error while setting the notification channel", e);
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x02c7  */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x02dc  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0120  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0122  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0186  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x019a  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x01cf  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x01d1  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x021b  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x024f  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0288  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0291  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x02a2  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x02aa  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x02af  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x02b3  */
    public final boolean zzh(Bundle bundle) {
        boolean z;
        int i;
        Integer zzm;
        String zzi;
        Uri uri;
        String zza;
        Intent intent;
        PendingIntent pendingIntent;
        PendingIntent pendingIntent2;
        Notification notification;
        String zza2;
        if ("1".equals(zza(bundle, "gcm.n.noui"))) {
            return true;
        }
        if (!((KeyguardManager) this.zzz.getSystemService("keyguard")).inKeyguardRestrictedInputMode()) {
            if (!PlatformVersion.isAtLeastLollipop()) {
                SystemClock.sleep(10);
            }
            int myPid = Process.myPid();
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) this.zzz.getSystemService("activity")).getRunningAppProcesses();
            if (runningAppProcesses != null) {
                Iterator<ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    ActivityManager.RunningAppProcessInfo next = it.next();
                    if (next.pid == myPid) {
                        if (next.importance == 100) {
                            z = true;
                        }
                    }
                }
            }
        }
        z = false;
        if (z) {
            return false;
        }
        CharSequence zzd = zzd(bundle, "gcm.n.title");
        if (TextUtils.isEmpty(zzd)) {
            zzd = this.zzz.getApplicationInfo().loadLabel(this.zzz.getPackageManager());
        }
        CharSequence charSequence = zzd;
        String zzd2 = zzd(bundle, "gcm.n.body");
        String zza3 = zza(bundle, "gcm.n.icon");
        if (!TextUtils.isEmpty(zza3)) {
            Resources resources = this.zzz.getResources();
            i = resources.getIdentifier(zza3, "drawable", this.zzz.getPackageName());
            if (i == 0 || !zzb(i)) {
                int identifier = resources.getIdentifier(zza3, "mipmap", this.zzz.getPackageName());
                if (identifier == 0 || !zzb(identifier)) {
                    StringBuilder sb = new StringBuilder(String.valueOf(zza3).length() + 61);
                    sb.append("Icon resource ");
                    sb.append(zza3);
                    sb.append(" not found. Notification will use default icon.");
                    Log.w("FirebaseMessaging", sb.toString());
                } else {
                    i = identifier;
                }
            }
            zzm = zzm(zza(bundle, "gcm.n.color"));
            zzi = zzi(bundle);
            if (!TextUtils.isEmpty(zzi)) {
                uri = null;
            } else if ("default".equals(zzi) || this.zzz.getResources().getIdentifier(zzi, "raw", this.zzz.getPackageName()) == 0) {
                uri = RingtoneManager.getDefaultUri(2);
            } else {
                String packageName = this.zzz.getPackageName();
                StringBuilder sb2 = new StringBuilder(String.valueOf(packageName).length() + 24 + String.valueOf(zzi).length());
                sb2.append("android.resource://");
                sb2.append(packageName);
                sb2.append("/raw/");
                sb2.append(zzi);
                uri = Uri.parse(sb2.toString());
            }
            zza = zza(bundle, "gcm.n.click_action");
            if (TextUtils.isEmpty(zza)) {
                intent = new Intent(zza);
                intent.setPackage(this.zzz.getPackageName());
                intent.setFlags(268435456);
            } else {
                Uri zzg = zzg(bundle);
                if (zzg != null) {
                    intent = new Intent("android.intent.action.VIEW");
                    intent.setPackage(this.zzz.getPackageName());
                    intent.setData(zzg);
                } else {
                    intent = this.zzz.getPackageManager().getLaunchIntentForPackage(this.zzz.getPackageName());
                    if (intent == null) {
                        Log.w("FirebaseMessaging", "No activity found to launch app");
                    }
                }
            }
            if (intent != null) {
                pendingIntent = null;
            } else {
                intent.addFlags(67108864);
                Bundle bundle2 = new Bundle(bundle);
                FirebaseMessagingService.zzj(bundle2);
                intent.putExtras(bundle2);
                for (String next2 : bundle2.keySet()) {
                    if (next2.startsWith("gcm.n.") || next2.startsWith("gcm.notification.")) {
                        intent.removeExtra(next2);
                    }
                }
                pendingIntent = PendingIntent.getActivity(this.zzz, this.zzdd.incrementAndGet(), intent, 1073741824);
            }
            if (!FirebaseMessagingService.zzk(bundle)) {
                Intent intent2 = new Intent("com.google.firebase.messaging.NOTIFICATION_OPEN");
                zza(intent2, bundle);
                intent2.putExtra("pending_intent", pendingIntent);
                PendingIntent zza4 = zzan.zza(this.zzz, this.zzdd.incrementAndGet(), intent2, 1073741824);
                Intent intent3 = new Intent("com.google.firebase.messaging.NOTIFICATION_DISMISS");
                zza(intent3, bundle);
                pendingIntent2 = zzan.zza(this.zzz, this.zzdd.incrementAndGet(), intent3, 1073741824);
                pendingIntent = zza4;
            } else {
                pendingIntent2 = null;
            }
            if (PlatformVersion.isAtLeastO() || this.zzz.getApplicationInfo().targetSdkVersion <= 25) {
                NotificationCompat.Builder O000000o2 = new NotificationCompat.Builder(this.zzz).O00000Oo().O000000o(i);
                if (!TextUtils.isEmpty(charSequence)) {
                    O000000o2.O000000o(charSequence);
                }
                if (!TextUtils.isEmpty(zzd2)) {
                    O000000o2.O00000Oo(zzd2);
                    O000000o2.O000000o(new NotificationCompat.O00000Oo().O000000o(zzd2));
                }
                if (zzm != null) {
                    O000000o2.O000O0Oo = zzm.intValue();
                }
                if (uri != null) {
                    O000000o2.O000000o(uri);
                }
                if (pendingIntent != null) {
                    O000000o2.O00000oo = pendingIntent;
                }
                if (pendingIntent2 != null) {
                    O000000o2.O000000o(pendingIntent2);
                }
                notification = O000000o2.O00000o();
            } else {
                notification = zza(charSequence, zzd2, i, zzm, uri, pendingIntent, pendingIntent2, zzn(zza(bundle, "gcm.n.android_channel_id")));
            }
            zza2 = zza(bundle, "gcm.n.tag");
            if (Log.isLoggable("FirebaseMessaging", 3)) {
                Log.d("FirebaseMessaging", "Showing notification");
            }
            NotificationManager notificationManager = (NotificationManager) this.zzz.getSystemService("notification");
            if (TextUtils.isEmpty(zza2)) {
                long uptimeMillis = SystemClock.uptimeMillis();
                StringBuilder sb3 = new StringBuilder(37);
                sb3.append("FCM-Notification:");
                sb3.append(uptimeMillis);
                zza2 = sb3.toString();
            }
            notificationManager.notify(zza2, 0, notification);
            return true;
        }
        int i2 = zzal().getInt("com.google.firebase.messaging.default_notification_icon", 0);
        if (i2 == 0 || !zzb(i2)) {
            i2 = this.zzz.getApplicationInfo().icon;
        }
        if (i2 == 0 || !zzb(i2)) {
            i2 = 17301651;
        }
        i = i2;
        zzm = zzm(zza(bundle, "gcm.n.color"));
        zzi = zzi(bundle);
        if (!TextUtils.isEmpty(zzi)) {
        }
        zza = zza(bundle, "gcm.n.click_action");
        if (TextUtils.isEmpty(zza)) {
        }
        if (intent != null) {
        }
        if (!FirebaseMessagingService.zzk(bundle)) {
        }
        if (PlatformVersion.isAtLeastO()) {
        }
        NotificationCompat.Builder O000000o22 = new NotificationCompat.Builder(this.zzz).O00000Oo().O000000o(i);
        if (!TextUtils.isEmpty(charSequence)) {
        }
        if (!TextUtils.isEmpty(zzd2)) {
        }
        if (zzm != null) {
        }
        if (uri != null) {
        }
        if (pendingIntent != null) {
        }
        if (pendingIntent2 != null) {
        }
        notification = O000000o22.O00000o();
        zza2 = zza(bundle, "gcm.n.tag");
        if (Log.isLoggable("FirebaseMessaging", 3)) {
        }
        NotificationManager notificationManager2 = (NotificationManager) this.zzz.getSystemService("notification");
        if (TextUtils.isEmpty(zza2)) {
        }
        notificationManager2.notify(zza2, 0, notification);
        return true;
    }
}
