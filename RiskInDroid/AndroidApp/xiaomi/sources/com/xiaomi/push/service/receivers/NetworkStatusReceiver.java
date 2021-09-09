package com.xiaomi.push.service.receivers;

import _m_j.duv;
import _m_j.dzm;
import _m_j.dzp;
import _m_j.dzq;
import _m_j.dzs;
import _m_j.eah;
import _m_j.eao;
import _m_j.emf;
import _m_j.erf;
import _m_j.eso;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.xiaomi.mipush.sdk.au;
import com.xiaomi.mipush.sdk.b;
import com.xiaomi.push.service.ServiceClient;

public class NetworkStatusReceiver extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f6574a = false;
    private boolean b;

    public NetworkStatusReceiver() {
        this.b = false;
        this.b = true;
    }

    public NetworkStatusReceiver(Object obj) {
        this.b = false;
        f6574a = true;
    }

    public static boolean a() {
        return f6574a;
    }

    public void onReceive(Context context, Intent intent) {
        if (!this.b) {
            eso.O000000o().post(new a(this, context));
        }
    }

    /* access modifiers changed from: private */
    public void a(Context context) {
        if (!eao.O000000o(context).O00000o0() && b.O000000o(context).O00000Oo.O000000o() && !b.O000000o(context).O00000Oo()) {
            try {
                Intent intent = new Intent();
                intent.setComponent(new ComponentName(context, "com.xiaomi.push.service.XMPushService"));
                intent.setAction("com.xiaomi.push.network_status_changed");
                ServiceClient.getInstance(context).startServiceSafely(intent);
            } catch (Exception e) {
                duv.O000000o(e);
            }
        }
        erf.O000000o(context);
        if (emf.O000000o(context) && eao.O000000o(context).O00000oo()) {
            eao.O000000o(context).O00000o();
        }
        if (emf.O000000o(context)) {
            if ("syncing".equals(eah.O000000o(context).O000000o(au.f6052a))) {
                dzs.O0000OOo(context);
            }
            if ("syncing".equals(eah.O000000o(context).O000000o(au.b))) {
                dzs.O0000Oo0(context);
            }
            if ("syncing".equals(eah.O000000o(context).O000000o(au.c))) {
                dzs.O0000Oo(context);
            }
            if ("syncing".equals(eah.O000000o(context).O000000o(au.d))) {
                dzs.O0000OoO(context);
            }
            if ("syncing".equals(eah.O000000o(context).O000000o(au.e))) {
                dzs.O0000Ooo(context);
            }
            if ("syncing".equals(eah.O000000o(context).O000000o(au.f))) {
                dzs.O0000o00(context);
            }
            if (dzq.O000000o() && dzq.O00000Oo(context)) {
                dzq.O000000o(context);
                dzq.O00000o0(context);
            }
            dzm.O00000Oo(context);
            dzp.O000000o(context);
        }
    }
}
