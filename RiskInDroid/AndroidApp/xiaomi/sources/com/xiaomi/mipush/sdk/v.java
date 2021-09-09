package com.xiaomi.mipush.sdk;

import _m_j.duv;
import _m_j.dzs;
import _m_j.esu;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.text.TextUtils;
import com.xiaomi.push.service.bd;
import java.util.HashMap;

public final class v {

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public String f6057O000000o;
        public boolean O00000Oo = true;
        public String O00000o;
        public boolean O00000o0;

        public O000000o(String str, boolean z, String str2) {
            this.f6057O000000o = str;
            this.O00000o0 = z;
            this.O00000o = str2;
        }
    }

    public static class a extends RuntimeException {
        public a(String str) {
            super(str);
        }
    }

    private static ActivityInfo O000000o(PackageManager packageManager, Intent intent, Class<?> cls) {
        for (ResolveInfo resolveInfo : packageManager.queryBroadcastReceivers(intent, 16384)) {
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            if (activityInfo != null && cls.getCanonicalName().equals(activityInfo.name)) {
                return activityInfo;
            }
        }
        return null;
    }

    private static void O000000o(Context context, String str, String str2) {
        PackageManager packageManager = context.getPackageManager();
        String packageName = context.getPackageName();
        Intent intent = new Intent(str);
        intent.setPackage(packageName);
        boolean z = false;
        for (ResolveInfo resolveInfo : packageManager.queryBroadcastReceivers(intent, 16384)) {
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            if (activityInfo == null || TextUtils.isEmpty(activityInfo.name) || !activityInfo.name.equals(str2)) {
                z = false;
                continue;
            } else {
                z = true;
                continue;
            }
            if (z) {
                break;
            }
        }
        if (!z) {
            throw new a(String.format("<receiver android:name=\"%1$s\" .../> is missing or disabled in AndroidManifest.", str2));
        }
    }

    private static void O000000o(ActivityInfo activityInfo, Boolean[] boolArr) {
        if (boolArr[0].booleanValue() != activityInfo.enabled) {
            throw new a(String.format("<receiver android:name=\"%1$s\" .../> in AndroidManifest had the wrong enabled attribute, which should be android:enabled=%2$b.", activityInfo.name, boolArr[0]));
        } else if (boolArr[1].booleanValue() != activityInfo.exported) {
            throw new a(String.format("<receiver android:name=\"%1$s\" .../> in AndroidManifest had the wrong exported attribute, which should be android:exported=%2$b.", activityInfo.name, boolArr[1]));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0023 A[LOOP:0: B:1:0x0005->B:14:0x0023, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0022 A[SYNTHETIC] */
    private static boolean O000000o(PackageInfo packageInfo, String[] strArr) {
        boolean z;
        ServiceInfo[] serviceInfoArr = packageInfo.services;
        int length = serviceInfoArr.length;
        int i = 0;
        while (i < length) {
            String str = serviceInfoArr[i].name;
            if (str != null) {
                int i2 = 0;
                while (true) {
                    if (i2 >= 2) {
                        break;
                    } else if (TextUtils.equals(strArr[i2], str)) {
                        z = true;
                        break;
                    } else {
                        i2++;
                    }
                }
                if (!z) {
                    return true;
                }
                i++;
            }
            z = false;
            if (!z) {
            }
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x00a2 A[EDGE_INSN: B:39:0x00a2->B:29:0x00a2 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x006e A[SYNTHETIC] */
    public static /* synthetic */ void O000000o(Context context) {
        PackageManager packageManager = context.getPackageManager();
        String packageName = context.getPackageName();
        Intent intent = new Intent(bd.o);
        intent.setPackage(packageName);
        try {
            ActivityInfo O000000o2 = O000000o(packageManager, intent, esu.O000000o(context, "com.xiaomi.push.service.receivers.PingReceiver"));
            if (!dzs.O000000o(context)) {
                if (O000000o2 != null) {
                    O000000o(O000000o2, new Boolean[]{Boolean.TRUE, Boolean.FALSE});
                } else {
                    throw new a(String.format("<receiver android:name=\"%1$s\" .../> is missing or disabled in AndroidManifest.", "com.xiaomi.push.service.receivers.PingReceiver"));
                }
            } else if (O000000o2 != null) {
                O000000o(O000000o2, new Boolean[]{Boolean.TRUE, Boolean.FALSE});
            }
        } catch (ClassNotFoundException e) {
            duv.O000000o(e);
        }
        Intent intent2 = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
        intent2.setPackage(packageName);
        boolean z = false;
        for (ResolveInfo resolveInfo : packageManager.queryBroadcastReceivers(intent2, 16384)) {
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            if (activityInfo != null) {
                try {
                    if (!TextUtils.isEmpty(activityInfo.name) && PushMessageReceiver.class.isAssignableFrom(esu.O000000o(context, activityInfo.name)) && activityInfo.enabled) {
                        z = true;
                        if (!z) {
                            break;
                        }
                    }
                } catch (ClassNotFoundException e2) {
                    duv.O000000o(e2);
                }
            }
            z = false;
            if (!z) {
            }
        }
        if (z) {
            if (dzs.O0000o(context)) {
                O000000o(context, "com.huawei.android.push.intent.RECEIVE", "com.xiaomi.assemble.control.HmsPushReceiver");
                O000000o(context, "com.huawei.intent.action.PUSH", "com.huawei.hms.support.api.push.PushEventReceiver");
            }
            if (dzs.O0000oOO(context)) {
                O000000o(context, "com.vivo.pushclient.action.RECEIVE", "com.xiaomi.assemble.control.FTOSPushMessageReceiver");
                return;
            }
            return;
        }
        throw new a("Receiver: none of the subclasses of PushMessageReceiver is enabled or defined.");
    }

    public static /* synthetic */ void O000000o(Context context, PackageInfo packageInfo) {
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        hashMap2.put(PushMessageHandler.class.getCanonicalName(), new O000000o(PushMessageHandler.class.getCanonicalName(), true, ""));
        hashMap2.put(MessageHandleService.class.getCanonicalName(), new O000000o(MessageHandleService.class.getCanonicalName(), false, ""));
        if (!dzs.O000000o(context) || O000000o(packageInfo, new String[]{"com.xiaomi.push.service.XMJobService", "com.xiaomi.push.service.XMPushService"})) {
            hashMap2.put("com.xiaomi.push.service.XMJobService", new O000000o("com.xiaomi.push.service.XMJobService", false, "android.permission.BIND_JOB_SERVICE"));
            hashMap2.put("com.xiaomi.push.service.XMPushService", new O000000o("com.xiaomi.push.service.XMPushService", false, ""));
        }
        if (dzs.O0000oO0(context)) {
            hashMap2.put("com.xiaomi.assemble.control.MiFireBaseInstanceIdService", new O000000o("com.xiaomi.assemble.control.MiFireBaseInstanceIdService", false, ""));
            hashMap2.put("com.xiaomi.assemble.control.MiFirebaseMessagingService", new O000000o("com.xiaomi.assemble.control.MiFirebaseMessagingService", false, ""));
        }
        if (dzs.O0000oO(context)) {
            hashMap2.put("com.xiaomi.assemble.control.COSPushMessageService", new O000000o("com.xiaomi.assemble.control.COSPushMessageService", true, "com.coloros.mcs.permission.SEND_MCS_MESSAGE"));
        }
        if (packageInfo.services != null) {
            for (ServiceInfo serviceInfo : packageInfo.services) {
                if (!TextUtils.isEmpty(serviceInfo.name) && hashMap2.containsKey(serviceInfo.name)) {
                    O000000o o000000o = (O000000o) hashMap2.remove(serviceInfo.name);
                    boolean z = o000000o.O00000Oo;
                    boolean z2 = o000000o.O00000o0;
                    String str = o000000o.O00000o;
                    if (z != serviceInfo.enabled) {
                        throw new a(String.format("<service android:name=\"%1$s\" .../> in AndroidManifest had the wrong enabled attribute, which should be android:enabled=%2$b.", serviceInfo.name, Boolean.valueOf(z)));
                    } else if (z2 != serviceInfo.exported) {
                        throw new a(String.format("<service android:name=\"%1$s\" .../> in AndroidManifest had the wrong exported attribute, which should be android:exported=%2$b.", serviceInfo.name, Boolean.valueOf(z2)));
                    } else if (TextUtils.isEmpty(str) || TextUtils.equals(str, serviceInfo.permission)) {
                        hashMap.put(serviceInfo.name, serviceInfo.processName);
                        if (hashMap2.isEmpty()) {
                            break;
                        }
                    } else {
                        throw new a(String.format("<service android:name=\"%1$s\" .../> in AndroidManifest had the wrong permission attribute, which should be android:permission=\"%2$s\".", serviceInfo.name, str));
                    }
                }
            }
        }
        if (!hashMap2.isEmpty()) {
            throw new a(String.format("<service android:name=\"%1$s\" .../> is missing or disabled in AndroidManifest.", hashMap2.keySet().iterator().next()));
        } else if (!TextUtils.equals((CharSequence) hashMap.get(PushMessageHandler.class.getCanonicalName()), (CharSequence) hashMap.get(MessageHandleService.class.getCanonicalName()))) {
            throw new a(String.format("\"%1$s\" and \"%2$s\" must be running in the same process.", PushMessageHandler.class.getCanonicalName(), MessageHandleService.class.getCanonicalName()));
        } else if (hashMap.containsKey("com.xiaomi.push.service.XMJobService") && hashMap.containsKey("com.xiaomi.push.service.XMPushService") && !TextUtils.equals((CharSequence) hashMap.get("com.xiaomi.push.service.XMJobService"), (CharSequence) hashMap.get("com.xiaomi.push.service.XMPushService"))) {
            throw new a(String.format("\"%1$s\" and \"%2$s\" must be running in the same process.", "com.xiaomi.push.service.XMJobService", "com.xiaomi.push.service.XMPushService"));
        }
    }
}
