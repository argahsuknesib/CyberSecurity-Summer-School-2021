package com.xiaomi.push.service;

import _m_j.duv;
import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.util.Pair;
import com.xiaomi.push.gg;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class r {

    /* renamed from: a  reason: collision with root package name */
    private static ArrayList<Pair<String, byte[]>> f6573a = new ArrayList<>();

    /* renamed from: a  reason: collision with other field name */
    private static final Map<String, byte[]> f347a = new HashMap();

    public static void a(Context context, int i, String str) {
        synchronized (f347a) {
            for (String next : f347a.keySet()) {
                a(context, next, f347a.get(next), i, str);
            }
            f347a.clear();
        }
    }

    public static void a(Context context, String str, byte[] bArr, int i, String str2) {
        Intent intent = new Intent("com.xiaomi.mipush.ERROR");
        intent.setPackage(str);
        intent.putExtra("mipush_payload", bArr);
        intent.putExtra("mipush_error_code", i);
        intent.putExtra("mipush_error_msg", str2);
        context.sendBroadcast(intent, ab.a(str));
    }

    public static void a(XMPushService xMPushService) {
        try {
            synchronized (f347a) {
                for (String next : f347a.keySet()) {
                    ab.a(xMPushService, next, f347a.get(next));
                }
                f347a.clear();
            }
        } catch (gg e) {
            duv.O00000o("fail to deal with pending register request. ".concat(String.valueOf(e)));
            xMPushService.a(10, e);
        }
    }

    public static void a(String str, byte[] bArr) {
        synchronized (f347a) {
            f347a.put(str, bArr);
        }
    }

    public static void b(XMPushService xMPushService) {
        ArrayList<Pair<String, byte[]>> arrayList;
        try {
            synchronized (f6573a) {
                arrayList = f6573a;
                f6573a = new ArrayList<>();
            }
            boolean z = Thread.currentThread() == Looper.getMainLooper().getThread();
            Iterator<Pair<String, byte[]>> it = arrayList.iterator();
            while (it.hasNext()) {
                Pair next = it.next();
                ab.a(xMPushService, (String) next.first, (byte[]) next.second);
                if (!z) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException unused) {
                    }
                }
            }
        } catch (gg e) {
            duv.O00000o("meet error when process pending message. ".concat(String.valueOf(e)));
            xMPushService.a(10, e);
        }
    }

    public static void b(String str, byte[] bArr) {
        synchronized (f6573a) {
            f6573a.add(new Pair(str, bArr));
            if (f6573a.size() > 50) {
                f6573a.remove(0);
            }
        }
    }
}
