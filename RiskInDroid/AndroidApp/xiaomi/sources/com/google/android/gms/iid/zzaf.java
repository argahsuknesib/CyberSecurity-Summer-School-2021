package com.google.android.gms.iid;

import _m_j.o0O0OOO0;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.ConditionVariable;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcelable;
import android.os.Process;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.exoplayer2.source.dash.DashMediaSource;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.tasks.Tasks;
import java.io.IOException;
import java.security.KeyPair;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class zzaf {
    private static int zzck = 0;
    private static final zzaj<Boolean> zzco = zzai.zzw().zzd("gcm_iid_use_messenger_ipc", true);
    private static String zzcp = null;
    private static boolean zzcq = false;
    private static int zzcr = 0;
    private static int zzcs = 0;
    private static BroadcastReceiver zzct = null;
    private PendingIntent zzad;
    private Messenger zzah;
    private Map<String, Object> zzcu = new o0O0OOO0();
    private Messenger zzcv;
    private MessengerCompat zzcw;
    private Context zzk;

    public zzaf(Context context) {
        this.zzk = context;
    }

    private static void zzd(Object obj, Object obj2) {
        if (obj instanceof ConditionVariable) {
            ((ConditionVariable) obj).open();
        }
        if (obj instanceof Messenger) {
            Messenger messenger = (Messenger) obj;
            Message obtain = Message.obtain();
            obtain.obj = obj2;
            try {
                messenger.send(obtain);
            } catch (RemoteException e) {
                String valueOf = String.valueOf(e);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 24);
                sb.append("Failed to send response ");
                sb.append(valueOf);
                Log.w("InstanceID", sb.toString());
            }
        }
    }

    private final void zzd(String str, Object obj) {
        synchronized (getClass()) {
            Object obj2 = this.zzcu.get(str);
            this.zzcu.put(str, obj);
            zzd(obj2, obj);
        }
    }

    private static boolean zzd(PackageManager packageManager, String str) {
        try {
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(str, 0);
            zzcp = applicationInfo.packageName;
            zzcs = applicationInfo.uid;
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    private static boolean zzd(PackageManager packageManager, String str, String str2) {
        if (packageManager.checkPermission("com.google.android.c2dm.permission.SEND", str) == 0) {
            return zzd(packageManager, str);
        }
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 56 + String.valueOf(str2).length());
        sb.append("Possible malicious package ");
        sb.append(str);
        sb.append(" declares ");
        sb.append(str2);
        sb.append(" without permission");
        Log.w("InstanceID", sb.toString());
        return false;
    }

    private final synchronized void zzg(Intent intent) {
        if (this.zzad == null) {
            Intent intent2 = new Intent();
            intent2.setPackage("com.google.example.invalidpackage");
            this.zzad = PendingIntent.getBroadcast(this.zzk, 0, intent2, 0);
        }
        intent.putExtra("app", this.zzad);
    }

    static String zzi(Bundle bundle) throws IOException {
        if (bundle != null) {
            String string = bundle.getString("registration_id");
            if (string == null) {
                string = bundle.getString("unregistered");
            }
            if (string != null) {
                return string;
            }
            String string2 = bundle.getString("error");
            if (string2 != null) {
                throw new IOException(string2);
            }
            String valueOf = String.valueOf(bundle);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 29);
            sb.append("Unexpected response from GCM ");
            sb.append(valueOf);
            Log.w("InstanceID", sb.toString(), new Throwable());
            throw new IOException("SERVICE_NOT_AVAILABLE");
        }
        throw new IOException("SERVICE_NOT_AVAILABLE");
    }

    private final Bundle zzj(Bundle bundle) throws IOException {
        Bundle zzk2 = zzk(bundle);
        if (zzk2 == null || !zzk2.containsKey("google.messenger")) {
            return zzk2;
        }
        Bundle zzk3 = zzk(bundle);
        if (zzk3 == null || !zzk3.containsKey("google.messenger")) {
            return zzk3;
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:58:0x0184 A[SYNTHETIC] */
    private final Bundle zzk(Bundle bundle) throws IOException {
        Bundle bundle2;
        ConditionVariable conditionVariable = new ConditionVariable();
        String zzv = zzv();
        synchronized (getClass()) {
            this.zzcu.put(zzv, conditionVariable);
        }
        if (this.zzah == null) {
            zzl(this.zzk);
            this.zzah = new Messenger(new zzag(this, Looper.getMainLooper()));
        }
        if (zzcp != null) {
            Intent intent = new Intent(zzcq ? "com.google.iid.TOKEN_REQUEST" : "com.google.android.c2dm.intent.REGISTER");
            intent.setPackage(zzcp);
            intent.putExtras(bundle);
            zzg(intent);
            StringBuilder sb = new StringBuilder(String.valueOf(zzv).length() + 5);
            sb.append("|ID|");
            sb.append(zzv);
            sb.append("|");
            intent.putExtra("kid", sb.toString());
            StringBuilder sb2 = new StringBuilder(String.valueOf(zzv).length() + 5);
            sb2.append("|ID|");
            sb2.append(zzv);
            sb2.append("|");
            intent.putExtra("X-kid", sb2.toString());
            boolean equals = "com.google.android.gsf".equals(zzcp);
            String stringExtra = intent.getStringExtra("useGsf");
            if (stringExtra != null) {
                equals = "1".equals(stringExtra);
            }
            if (Log.isLoggable("InstanceID", 3)) {
                String valueOf = String.valueOf(intent.getExtras());
                StringBuilder sb3 = new StringBuilder(String.valueOf(valueOf).length() + 8);
                sb3.append("Sending ");
                sb3.append(valueOf);
                Log.d("InstanceID", sb3.toString());
            }
            if (this.zzcv != null) {
                intent.putExtra("google.messenger", this.zzah);
                Message obtain = Message.obtain();
                obtain.obj = intent;
                try {
                    this.zzcv.send(obtain);
                } catch (RemoteException unused) {
                    if (Log.isLoggable("InstanceID", 3)) {
                        Log.d("InstanceID", "Messenger failed, fallback to startService");
                    }
                }
                conditionVariable.block(DashMediaSource.DEFAULT_LIVE_PRESENTATION_DELAY_FIXED_MS);
                synchronized (getClass()) {
                    Object remove = this.zzcu.remove(zzv);
                    if (remove instanceof Bundle) {
                        bundle2 = (Bundle) remove;
                    } else if (remove instanceof String) {
                        throw new IOException((String) remove);
                    } else {
                        String valueOf2 = String.valueOf(remove);
                        StringBuilder sb4 = new StringBuilder(String.valueOf(valueOf2).length() + 12);
                        sb4.append("No response ");
                        sb4.append(valueOf2);
                        Log.w("InstanceID", sb4.toString());
                        throw new IOException("TIMEOUT");
                    }
                }
                return bundle2;
            }
            if (equals) {
                synchronized (this) {
                    if (zzct == null) {
                        zzct = new zzah(this);
                        if (Log.isLoggable("InstanceID", 3)) {
                            Log.d("InstanceID", "Registered GSF callback receiver");
                        }
                        IntentFilter intentFilter = new IntentFilter("com.google.android.c2dm.intent.REGISTRATION");
                        intentFilter.addCategory(this.zzk.getPackageName());
                        this.zzk.registerReceiver(zzct, intentFilter, "com.google.android.c2dm.permission.SEND", null);
                    }
                }
            } else {
                intent.putExtra("google.messenger", this.zzah);
                intent.putExtra("messenger2", "1");
                if (this.zzcw != null) {
                    Message obtain2 = Message.obtain();
                    obtain2.obj = intent;
                    try {
                        this.zzcw.send(obtain2);
                    } catch (RemoteException unused2) {
                        if (Log.isLoggable("InstanceID", 3)) {
                            Log.d("InstanceID", "Messenger failed, fallback to startService");
                        }
                    }
                    conditionVariable.block(DashMediaSource.DEFAULT_LIVE_PRESENTATION_DELAY_FIXED_MS);
                    synchronized (getClass()) {
                    }
                }
                if (!zzcq) {
                    this.zzk.startService(intent);
                    conditionVariable.block(DashMediaSource.DEFAULT_LIVE_PRESENTATION_DELAY_FIXED_MS);
                    synchronized (getClass()) {
                    }
                }
            }
            this.zzk.sendBroadcast(intent);
            conditionVariable.block(DashMediaSource.DEFAULT_LIVE_PRESENTATION_DELAY_FIXED_MS);
            synchronized (getClass()) {
            }
        } else {
            throw new IOException("MISSING_INSTANCEID_SERVICE");
        }
    }

    public static boolean zzk(Context context) {
        if (zzcp != null) {
            zzl(context);
        }
        return zzcq;
    }

    public static String zzl(Context context) {
        boolean z;
        String str = zzcp;
        if (str != null) {
            return str;
        }
        zzcr = Process.myUid();
        PackageManager packageManager = context.getPackageManager();
        boolean z2 = true;
        if (!PlatformVersion.isAtLeastO()) {
            Iterator<ResolveInfo> it = packageManager.queryIntentServices(new Intent("com.google.android.c2dm.intent.REGISTER"), 0).iterator();
            while (true) {
                if (it.hasNext()) {
                    if (zzd(packageManager, it.next().serviceInfo.packageName, "com.google.android.c2dm.intent.REGISTER")) {
                        zzcq = false;
                        z = true;
                        break;
                    }
                } else {
                    z = false;
                    break;
                }
            }
            if (z) {
                return zzcp;
            }
        }
        Iterator<ResolveInfo> it2 = packageManager.queryBroadcastReceivers(new Intent("com.google.iid.TOKEN_REQUEST"), 0).iterator();
        while (true) {
            if (it2.hasNext()) {
                if (zzd(packageManager, it2.next().activityInfo.packageName, "com.google.iid.TOKEN_REQUEST")) {
                    zzcq = true;
                    break;
                }
            } else {
                z2 = false;
                break;
            }
        }
        if (z2) {
            return zzcp;
        }
        Log.w("InstanceID", "Failed to resolve IID implementation package, falling back");
        if (zzd(packageManager, "com.google.android.gms")) {
            zzcq = PlatformVersion.isAtLeastO();
            return zzcp;
        } else if (PlatformVersion.isAtLeastLollipop() || !zzd(packageManager, "com.google.android.gsf")) {
            Log.w("InstanceID", "Google Play services is missing, unable to get tokens");
            return null;
        } else {
            zzcq = false;
            return zzcp;
        }
    }

    private static int zzm(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(zzl(context), 0).versionCode;
        } catch (PackageManager.NameNotFoundException unused) {
            return -1;
        }
    }

    private static synchronized String zzv() {
        String num;
        synchronized (zzaf.class) {
            int i = zzck;
            zzck = i + 1;
            num = Integer.toString(i);
        }
        return num;
    }

    /* access modifiers changed from: package-private */
    public final Bundle zzd(Bundle bundle, KeyPair keyPair) throws IOException {
        int zzm = zzm(this.zzk);
        bundle.putString("gmsv", Integer.toString(zzm));
        bundle.putString("osv", Integer.toString(Build.VERSION.SDK_INT));
        bundle.putString("app_ver", Integer.toString(InstanceID.zzg(this.zzk)));
        bundle.putString("app_ver_name", InstanceID.zzh(this.zzk));
        bundle.putString("cliv", "iid-12451000");
        bundle.putString("appid", InstanceID.zzd(keyPair));
        if (zzm < 12000000 || !zzco.get().booleanValue()) {
            return zzj(bundle);
        }
        try {
            return (Bundle) Tasks.await(new zzr(this.zzk).zzd(1, bundle));
        } catch (InterruptedException | ExecutionException e) {
            if (Log.isLoggable("InstanceID", 3)) {
                String valueOf = String.valueOf(e);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 22);
                sb.append("Error making request: ");
                sb.append(valueOf);
                Log.d("InstanceID", sb.toString());
            }
            if (!(e.getCause() instanceof zzaa) || ((zzaa) e.getCause()).getErrorCode() != 4) {
                return null;
            }
            return zzj(bundle);
        }
    }

    public final void zze(Message message) {
        if (message != null) {
            if (message.obj instanceof Intent) {
                Intent intent = (Intent) message.obj;
                intent.setExtrasClassLoader(MessengerCompat.class.getClassLoader());
                if (intent.hasExtra("google.messenger")) {
                    Parcelable parcelableExtra = intent.getParcelableExtra("google.messenger");
                    if (parcelableExtra instanceof MessengerCompat) {
                        this.zzcw = (MessengerCompat) parcelableExtra;
                    }
                    if (parcelableExtra instanceof Messenger) {
                        this.zzcv = (Messenger) parcelableExtra;
                    }
                }
                zzh((Intent) message.obj);
                return;
            }
            Log.w("InstanceID", "Dropping invalid message");
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.iid.zzaf.zzd(java.lang.String, java.lang.Object):void
     arg types: [java.lang.String, java.lang.String]
     candidates:
      com.google.android.gms.iid.zzaf.zzd(java.lang.Object, java.lang.Object):void
      com.google.android.gms.iid.zzaf.zzd(android.content.pm.PackageManager, java.lang.String):boolean
      com.google.android.gms.iid.zzaf.zzd(android.os.Bundle, java.security.KeyPair):android.os.Bundle
      com.google.android.gms.iid.zzaf.zzd(java.lang.String, java.lang.Object):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.iid.zzaf.zzd(java.lang.String, java.lang.Object):void
     arg types: [java.lang.String, android.os.Bundle]
     candidates:
      com.google.android.gms.iid.zzaf.zzd(java.lang.Object, java.lang.Object):void
      com.google.android.gms.iid.zzaf.zzd(android.content.pm.PackageManager, java.lang.String):boolean
      com.google.android.gms.iid.zzaf.zzd(android.os.Bundle, java.security.KeyPair):android.os.Bundle
      com.google.android.gms.iid.zzaf.zzd(java.lang.String, java.lang.Object):void */
    public final void zzh(Intent intent) {
        String str;
        if (intent != null) {
            String action = intent.getAction();
            if ("com.google.android.c2dm.intent.REGISTRATION".equals(action) || "com.google.android.gms.iid.InstanceID".equals(action)) {
                String stringExtra = intent.getStringExtra("registration_id");
                if (stringExtra == null) {
                    stringExtra = intent.getStringExtra("unregistered");
                }
                if (stringExtra == null) {
                    String stringExtra2 = intent.getStringExtra("error");
                    if (stringExtra2 == null) {
                        String valueOf = String.valueOf(intent.getExtras());
                        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 49);
                        sb.append("Unexpected response, no error or registration id ");
                        sb.append(valueOf);
                        Log.w("InstanceID", sb.toString());
                        return;
                    }
                    if (Log.isLoggable("InstanceID", 3)) {
                        String valueOf2 = String.valueOf(stringExtra2);
                        Log.d("InstanceID", valueOf2.length() != 0 ? "Received InstanceID error ".concat(valueOf2) : new String("Received InstanceID error "));
                    }
                    String str2 = null;
                    if (stringExtra2.startsWith("|")) {
                        String[] split = stringExtra2.split("\\|");
                        if (!"ID".equals(split[1])) {
                            String valueOf3 = String.valueOf(stringExtra2);
                            Log.w("InstanceID", valueOf3.length() != 0 ? "Unexpected structured response ".concat(valueOf3) : new String("Unexpected structured response "));
                        }
                        if (split.length > 2) {
                            String str3 = split[2];
                            str = split[3];
                            if (str.startsWith(":")) {
                                str = str.substring(1);
                            }
                            str2 = str3;
                        } else {
                            str = "UNKNOWN";
                        }
                        stringExtra2 = str;
                        intent.putExtra("error", stringExtra2);
                    }
                    if (str2 == null) {
                        synchronized (getClass()) {
                            for (String next : this.zzcu.keySet()) {
                                Object obj = this.zzcu.get(next);
                                this.zzcu.put(next, stringExtra2);
                                zzd(obj, stringExtra2);
                            }
                        }
                        return;
                    }
                    zzd(str2, (Object) stringExtra2);
                    return;
                }
                Matcher matcher = Pattern.compile("\\|ID\\|([^|]+)\\|:?+(.*)").matcher(stringExtra);
                if (matcher.matches()) {
                    String group = matcher.group(1);
                    String group2 = matcher.group(2);
                    Bundle extras = intent.getExtras();
                    extras.putString("registration_id", group2);
                    zzd(group, (Object) extras);
                } else if (Log.isLoggable("InstanceID", 3)) {
                    String valueOf4 = String.valueOf(stringExtra);
                    Log.d("InstanceID", valueOf4.length() != 0 ? "Unexpected response string: ".concat(valueOf4) : new String("Unexpected response string: "));
                }
            } else if (Log.isLoggable("InstanceID", 3)) {
                String valueOf5 = String.valueOf(intent.getAction());
                Log.d("InstanceID", valueOf5.length() != 0 ? "Unexpected response ".concat(valueOf5) : new String("Unexpected response "));
            }
        } else if (Log.isLoggable("InstanceID", 3)) {
            Log.d("InstanceID", "Unexpected response: null");
        }
    }
}
