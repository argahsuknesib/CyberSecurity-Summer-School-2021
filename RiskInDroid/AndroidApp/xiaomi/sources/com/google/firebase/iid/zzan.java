package com.google.firebase.iid;

import _m_j.o0OO00OO;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.util.Log;
import androidx.legacy.content.WakefulBroadcastReceiver;
import java.util.ArrayDeque;
import java.util.Queue;

public final class zzan {
    private static zzan zzcl;
    private final o0OO00OO<String, String> zzcm = new o0OO00OO<>();
    private Boolean zzcn = null;
    final Queue<Intent> zzco = new ArrayDeque();
    private final Queue<Intent> zzcp = new ArrayDeque();

    private zzan() {
    }

    public static PendingIntent zza(Context context, int i, Intent intent, int i2) {
        Intent intent2 = new Intent(context, FirebaseInstanceIdReceiver.class);
        intent2.setAction("com.google.firebase.MESSAGING_EVENT");
        intent2.putExtra("wrapped_intent", intent);
        return PendingIntent.getBroadcast(context, i, intent2, 1073741824);
    }

    public static synchronized zzan zzad() {
        zzan zzan;
        synchronized (zzan.class) {
            if (zzcl == null) {
                zzcl = new zzan();
            }
            zzan = zzcl;
        }
        return zzan;
    }

    /* JADX WARNING: Removed duplicated region for block: B:43:0x00db A[Catch:{ SecurityException -> 0x0138, IllegalStateException -> 0x0110 }] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00f2 A[Catch:{ SecurityException -> 0x0138, IllegalStateException -> 0x0110 }] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00f7 A[Catch:{ SecurityException -> 0x0138, IllegalStateException -> 0x0110 }] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0104 A[Catch:{ SecurityException -> 0x0138, IllegalStateException -> 0x0110 }] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x010e A[RETURN] */
    private final int zzb(Context context, Intent intent) {
        String str;
        ComponentName componentName;
        synchronized (this.zzcm) {
            str = this.zzcm.get(intent.getAction());
        }
        boolean z = false;
        if (str == null) {
            ResolveInfo resolveService = context.getPackageManager().resolveService(intent, 0);
            if (resolveService == null || resolveService.serviceInfo == null) {
                Log.e("FirebaseInstanceId", "Failed to resolve target intent service, skipping classname enforcement");
                if (this.zzcn == null) {
                    if (context.checkCallingOrSelfPermission("android.permission.WAKE_LOCK") == 0) {
                        z = true;
                    }
                    this.zzcn = Boolean.valueOf(z);
                }
                if (this.zzcn.booleanValue()) {
                    componentName = WakefulBroadcastReceiver.startWakefulService(context, intent);
                } else {
                    componentName = context.startService(intent);
                    Log.d("FirebaseInstanceId", "Missing wake lock permission, service start may be delayed");
                }
                if (componentName != null) {
                    return -1;
                }
                Log.e("FirebaseInstanceId", "Error while delivering the message: ServiceIntent not found.");
                return 404;
            }
            ServiceInfo serviceInfo = resolveService.serviceInfo;
            if (!context.getPackageName().equals(serviceInfo.packageName) || serviceInfo.name == null) {
                String str2 = serviceInfo.packageName;
                String str3 = serviceInfo.name;
                StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 94 + String.valueOf(str3).length());
                sb.append("Error resolving target intent service, skipping classname enforcement. Resolved service was: ");
                sb.append(str2);
                sb.append("/");
                sb.append(str3);
                Log.e("FirebaseInstanceId", sb.toString());
                if (this.zzcn == null) {
                }
                if (this.zzcn.booleanValue()) {
                }
                if (componentName != null) {
                }
            } else {
                str = serviceInfo.name;
                if (str.startsWith(".")) {
                    String valueOf = String.valueOf(context.getPackageName());
                    String valueOf2 = String.valueOf(str);
                    str = valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
                }
                synchronized (this.zzcm) {
                    this.zzcm.put(intent.getAction(), str);
                }
            }
        }
        if (Log.isLoggable("FirebaseInstanceId", 3)) {
            String valueOf3 = String.valueOf(str);
            Log.d("FirebaseInstanceId", valueOf3.length() != 0 ? "Restricting intent to a specific service: ".concat(valueOf3) : new String("Restricting intent to a specific service: "));
        }
        intent.setClassName(context.getPackageName(), str);
        try {
            if (this.zzcn == null) {
            }
            if (this.zzcn.booleanValue()) {
            }
            if (componentName != null) {
            }
        } catch (SecurityException e) {
            Log.e("FirebaseInstanceId", "Error while delivering the message to the serviceIntent", e);
            return 401;
        } catch (IllegalStateException e2) {
            String valueOf4 = String.valueOf(e2);
            StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf4).length() + 45);
            sb2.append("Failed to start service while in background: ");
            sb2.append(valueOf4);
            Log.e("FirebaseInstanceId", sb2.toString());
            return 402;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0027  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x004b  */
    public final int zza(Context context, String str, Intent intent) {
        char c;
        Queue<Intent> queue;
        int hashCode = str.hashCode();
        if (hashCode != -842411455) {
            if (hashCode == 41532704 && str.equals("com.google.firebase.MESSAGING_EVENT")) {
                c = 1;
                if (c == 0) {
                    queue = this.zzco;
                } else if (c != 1) {
                    String valueOf = String.valueOf(str);
                    Log.w("FirebaseInstanceId", valueOf.length() != 0 ? "Unknown service action: ".concat(valueOf) : new String("Unknown service action: "));
                    return 500;
                } else {
                    queue = this.zzcp;
                }
                queue.offer(intent);
                Intent intent2 = new Intent(str);
                intent2.setPackage(context.getPackageName());
                return zzb(context, intent2);
            }
        } else if (str.equals("com.google.firebase.INSTANCE_ID_EVENT")) {
            c = 0;
            if (c == 0) {
            }
            queue.offer(intent);
            Intent intent22 = new Intent(str);
            intent22.setPackage(context.getPackageName());
            return zzb(context, intent22);
        }
        c = 65535;
        if (c == 0) {
        }
        queue.offer(intent);
        Intent intent222 = new Intent(str);
        intent222.setPackage(context.getPackageName());
        return zzb(context, intent222);
    }

    public final Intent zzae() {
        return this.zzcp.poll();
    }
}
