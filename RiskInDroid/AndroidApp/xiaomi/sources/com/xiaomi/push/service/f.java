package com.xiaomi.push.service;

import _m_j.duv;
import _m_j.epq;
import _m_j.eqp;
import _m_j.eqq;
import _m_j.eqr;
import _m_j.esl;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Message;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import com.xiaomi.push.go;
import com.xiaomi.push.service.az;
import java.util.Collection;
import java.util.Iterator;

public class f {

    /* renamed from: a  reason: collision with root package name */
    private s f6559a = new s();

    public static String a(az.b bVar) {
        StringBuilder sb;
        String str;
        if (!"9".equals(bVar.g)) {
            sb = new StringBuilder();
            sb.append(bVar.f274a);
            str = ".permission.MIPUSH_RECEIVE";
        } else {
            sb = new StringBuilder();
            sb.append(bVar.f274a);
            str = ".permission.MIMC_RECEIVE";
        }
        sb.append(str);
        return sb.toString();
    }

    private static void a(Context context, Intent intent, az.b bVar) {
        if ("com.xiaomi.xmsf".equals(context.getPackageName())) {
            context.sendBroadcast(intent);
        } else {
            context.sendBroadcast(intent, a(bVar));
        }
    }

    @SuppressLint({"WrongConstant"})
    public void a(Context context) {
        Intent intent = new Intent();
        intent.setAction("com.xiaomi.push.service_started");
        if (esl.O00000o()) {
            intent.addFlags(16777216);
        }
        duv.O000000o("[Bcst] send ***.push.service_started broadcast to inform push service has started.");
        context.sendBroadcast(intent);
    }

    @SuppressLint({"DefaultLocale"})
    public void a(Context context, az.b bVar, int i) {
        if (!"5".equalsIgnoreCase(bVar.g)) {
            Intent intent = new Intent();
            intent.setAction("com.xiaomi.push.channel_closed");
            intent.setPackage(bVar.f274a);
            intent.putExtra(bd.s, bVar.g);
            intent.putExtra("ext_reason", i);
            intent.putExtra(bd.p, bVar.f277b);
            intent.putExtra(bd.E, bVar.i);
            if (bVar.f268a == null || !"9".equals(bVar.g)) {
                duv.O000000o(String.format("[Bcst] notify channel closed. %s,%s,%d", bVar.g, bVar.f274a, Integer.valueOf(i)));
                a(context, intent, bVar);
                return;
            }
            try {
                bVar.f268a.send(Message.obtain(null, 17, intent));
            } catch (RemoteException unused) {
                bVar.f268a = null;
                duv.O000000o("peer may died: " + bVar.f277b.substring(bVar.f277b.lastIndexOf(64)));
            }
        }
    }

    public void a(Context context, az.b bVar, String str, String str2) {
        if (bVar == null) {
            duv.O00000o("error while notify kick by server!");
        } else if ("5".equalsIgnoreCase(bVar.g)) {
            duv.O00000o("mipush kicked by server");
        } else {
            Intent intent = new Intent();
            intent.setAction("com.xiaomi.push.kicked");
            intent.setPackage(bVar.f274a);
            intent.putExtra("ext_kick_type", str);
            intent.putExtra("ext_kick_reason", str2);
            intent.putExtra("ext_chid", bVar.g);
            intent.putExtra(bd.p, bVar.f277b);
            intent.putExtra(bd.E, bVar.i);
            duv.O000000o(String.format("[Bcst] notify packet(blob) arrival. %s,%s,%s", bVar.g, bVar.f274a, str2));
            a(context, intent, bVar);
        }
    }

    @SuppressLint({"DefaultLocale"})
    public void a(Context context, az.b bVar, boolean z, int i, String str) {
        if ("5".equalsIgnoreCase(bVar.g)) {
            this.f6559a.a(context, bVar, z, i, str);
            return;
        }
        Intent intent = new Intent();
        intent.setAction("com.xiaomi.push.channel_opened");
        intent.setPackage(bVar.f274a);
        intent.putExtra("ext_succeeded", z);
        if (!z) {
            intent.putExtra("ext_reason", i);
        }
        if (!TextUtils.isEmpty(str)) {
            intent.putExtra("ext_reason_msg", str);
        }
        intent.putExtra("ext_chid", bVar.g);
        intent.putExtra(bd.p, bVar.f277b);
        intent.putExtra(bd.E, bVar.i);
        duv.O000000o(String.format("[Bcst] notify channel open result. %s,%s,%b,%d", bVar.g, bVar.f274a, Boolean.valueOf(z), Integer.valueOf(i)));
        a(context, intent, bVar);
    }

    public void a(XMPushService xMPushService, String str, epq epq) {
        az.b a2 = a(epq);
        if (a2 == null) {
            duv.O00000o("error while notify channel closed! channel " + str + " not registered");
        } else if ("5".equalsIgnoreCase(str)) {
            this.f6559a.a(xMPushService, epq, a2);
        } else {
            String str2 = a2.f274a;
            Intent intent = new Intent();
            intent.setAction("com.xiaomi.push.new_msg");
            intent.setPackage(str2);
            intent.putExtra("ext_rcv_timestamp", SystemClock.elapsedRealtime());
            intent.putExtra("ext_chid", str);
            intent.putExtra("ext_raw_packet", epq.O00000o0(a2.h));
            intent.putExtra(bd.E, a2.i);
            intent.putExtra(bd.w, a2.h);
            if (a2.f268a != null) {
                try {
                    a2.f268a.send(Message.obtain(null, 17, intent));
                    duv.O000000o("message was sent by messenger for chid=".concat(String.valueOf(str)));
                    return;
                } catch (RemoteException unused) {
                    a2.f268a = null;
                    duv.O000000o("peer may died: " + a2.f277b.substring(a2.f277b.lastIndexOf(64)));
                }
            }
            if (!"com.xiaomi.xmsf".equals(str2)) {
                duv.O000000o(String.format("[Bcst] notify packet(blob) arrival. %s,%s,%s", a2.g, a2.f274a, epq.O000000o()));
                a(xMPushService, intent, a2);
            }
        }
    }

    public void a(XMPushService xMPushService, String str, eqr eqr) {
        String str2;
        az.b a2 = a(eqr);
        if (a2 == null) {
            duv.O00000o("error while notify channel closed! channel " + str + " not registered");
        } else if ("5".equalsIgnoreCase(str)) {
            this.f6559a.a(xMPushService, eqr, a2);
        } else {
            String str3 = a2.f274a;
            if (eqr instanceof eqq) {
                str2 = "com.xiaomi.push.new_msg";
            } else if (eqr instanceof eqp) {
                str2 = "com.xiaomi.push.new_iq";
            } else if (eqr instanceof go) {
                str2 = "com.xiaomi.push.new_pres";
            } else {
                duv.O00000o("unknown packet type, drop it");
                return;
            }
            Intent intent = new Intent();
            intent.setAction(str2);
            intent.setPackage(str3);
            intent.putExtra("ext_chid", str);
            intent.putExtra("ext_packet", eqr.O000000o());
            intent.putExtra(bd.E, a2.i);
            intent.putExtra(bd.w, a2.h);
            duv.O000000o(String.format("[Bcst] notify packet arrival. %s,%s,%s", a2.g, a2.f274a, eqr.O00000o()));
            a(xMPushService, intent, a2);
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x002e  */
    public az.b a(eqr eqr) {
        Collection<az.b> a2 = az.a().m177a(eqr.O0000oOO);
        if (a2.isEmpty()) {
            return null;
        }
        Iterator<az.b> it = a2.iterator();
        if (a2.size() == 1) {
            return it.next();
        }
        String str = eqr.O0000oO;
        String str2 = eqr.O0000oO0;
        while (it.hasNext()) {
            az.b next = it.next();
            if (TextUtils.equals(str, next.f277b) || TextUtils.equals(str2, next.f277b)) {
                return next;
            }
            while (it.hasNext()) {
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public az.b a(epq epq) {
        Collection<az.b> a2 = az.a().m177a(Integer.toString(epq.f15708O000000o.f15684O000000o));
        if (a2.isEmpty()) {
            return null;
        }
        Iterator<az.b> it = a2.iterator();
        if (a2.size() == 1) {
            return it.next();
        }
        String O00000Oo = epq.O00000Oo();
        while (it.hasNext()) {
            az.b next = it.next();
            if (TextUtils.equals(O00000Oo, next.f277b)) {
                return next;
            }
        }
        return null;
    }
}
