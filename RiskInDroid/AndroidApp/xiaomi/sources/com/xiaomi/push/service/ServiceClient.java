package com.xiaomi.push.service;

import _m_j.duv;
import _m_j.elh;
import _m_j.emf;
import _m_j.epo;
import _m_j.eqo;
import _m_j.eqp;
import _m_j.eqq;
import _m_j.erb;
import _m_j.esl;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.text.TextUtils;
import com.xiaomi.push.go;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.http.NameValuePair;

public class ServiceClient {

    /* renamed from: a  reason: collision with root package name */
    private static long f6461a = 0;

    /* renamed from: a  reason: collision with other field name */
    private static ServiceClient f182a;

    /* renamed from: a  reason: collision with other field name */
    private static String f183a;
    private static String b = (erb.O000000o() + "-");

    /* renamed from: a  reason: collision with other field name */
    private Context f184a;

    /* renamed from: a  reason: collision with other field name */
    private Messenger f185a = null;

    /* renamed from: a  reason: collision with other field name */
    private List<Message> f186a = new ArrayList();

    /* renamed from: a  reason: collision with other field name */
    private boolean f187a = false;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with other field name */
    public Messenger f188b;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with other field name */
    public boolean f189b = false;

    private ServiceClient(Context context) {
        this.f184a = context.getApplicationContext();
        if (m111a()) {
            duv.O00000o0("use miui push service");
            this.f187a = true;
        }
    }

    private Intent a() {
        if (isMiuiPushServiceEnabled()) {
            Intent intent = new Intent();
            intent.setPackage("com.xiaomi.xmsf");
            intent.setClassName("com.xiaomi.xmsf", m108a());
            intent.putExtra(bd.A, this.f184a.getPackageName());
            m109a();
            return intent;
        }
        Intent intent2 = new Intent(this.f184a, XMPushService.class);
        intent2.putExtra(bd.A, this.f184a.getPackageName());
        b();
        return intent2;
    }

    private Message a(Intent intent) {
        Message obtain = Message.obtain();
        obtain.what = 17;
        obtain.obj = intent;
        return obtain;
    }

    /* renamed from: a  reason: collision with other method in class */
    private String m108a() {
        try {
            return this.f184a.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4).versionCode >= 106 ? "com.xiaomi.push.service.XMPushService" : "com.xiaomi.xmsf.push.service.XMPushService";
        } catch (Exception unused) {
            return "com.xiaomi.xmsf.push.service.XMPushService";
        }
    }

    private String a(Map<String, String> map) {
        StringBuilder sb = new StringBuilder();
        int i = 1;
        for (Map.Entry next : map.entrySet()) {
            sb.append((String) next.getKey());
            sb.append(":");
            sb.append((String) next.getValue());
            if (i < map.size()) {
                sb.append(",");
            }
            i++;
        }
        return sb.toString();
    }

    private Map<String, String> a(List<NameValuePair> list) {
        HashMap hashMap = new HashMap();
        if (list != null && list.size() > 0) {
            for (NameValuePair next : list) {
                if (next != null) {
                    hashMap.put(next.getName(), next.getValue());
                }
            }
        }
        return hashMap;
    }

    /* renamed from: a  reason: collision with other method in class */
    private void m109a() {
        this.f184a.getPackageManager().setComponentEnabledSetting(new ComponentName(this.f184a, XMPushService.class), 2, 1);
    }

    /* renamed from: a  reason: collision with other method in class */
    private synchronized void m110a(Intent intent) {
        if (this.f189b) {
            Message a2 = a(intent);
            if (this.f186a.size() >= 50) {
                this.f186a.remove(0);
            }
            this.f186a.add(a2);
        } else if (this.f188b == null) {
            this.f184a.bindService(intent, new bn(this), 1);
            this.f189b = true;
            this.f186a.clear();
            this.f186a.add(a(intent));
        } else {
            try {
                this.f188b.send(a(intent));
            } catch (RemoteException unused) {
                this.f188b = null;
                this.f189b = false;
            }
        }
    }

    private void a(Intent intent, String str, String str2, String str3, String str4, String str5, boolean z, Map<String, String> map, Map<String, String> map2) {
        intent.putExtra(bd.p, str);
        intent.putExtra(bd.s, str2);
        intent.putExtra(bd.u, str3);
        intent.putExtra(bd.w, str5);
        intent.putExtra(bd.v, str4);
        intent.putExtra(bd.x, z);
        intent.putExtra(bd.E, f183a);
        intent.putExtra(bd.I, this.f185a);
        if (map != null && map.size() > 0) {
            String a2 = a(map);
            if (!TextUtils.isEmpty(a2)) {
                intent.putExtra(bd.y, a2);
            }
        }
        if (map2 != null && map2.size() > 0) {
            String a3 = a(map2);
            if (!TextUtils.isEmpty(a3)) {
                intent.putExtra(bd.z, a3);
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    private boolean m111a() {
        if (elh.O00000oo) {
            return false;
        }
        try {
            PackageInfo packageInfo = this.f184a.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4);
            return packageInfo != null && packageInfo.versionCode >= 104;
        } catch (Exception unused) {
            return false;
        }
    }

    private void b() {
        this.f184a.getPackageManager().setComponentEnabledSetting(new ComponentName(this.f184a, XMPushService.class), 1, 1);
    }

    public static ServiceClient getInstance(Context context) {
        if (f182a == null) {
            f182a = new ServiceClient(context);
        }
        return f182a;
    }

    public static String getSession() {
        return f183a;
    }

    public static void setSession(String str) {
        f183a = str;
    }

    public boolean batchSendMessage(eqq[] eqqArr, boolean z) {
        if (!emf.O000000o(this.f184a)) {
            return false;
        }
        Intent a2 = a();
        Bundle[] bundleArr = new Bundle[eqqArr.length];
        for (int i = 0; i < eqqArr.length; i++) {
            String O000000o2 = epo.O000000o();
            if (!TextUtils.isEmpty(O000000o2)) {
                eqo eqo = new eqo("pf");
                eqo eqo2 = new eqo("sent");
                eqo2.O00000Oo(O000000o2);
                eqo.O000000o(eqo2);
                eqqArr[i].O000000o(eqo);
            }
            duv.O00000o0("SEND:" + eqqArr[i].O00000Oo());
            bundleArr[i] = eqqArr[i].O000000o();
        }
        if (bundleArr.length <= 0) {
            return false;
        }
        a2.setAction(bd.g);
        a2.putExtra(bd.E, f183a);
        a2.putExtra("ext_packets", bundleArr);
        a2.putExtra("ext_encrypt", z);
        return startServiceSafely(a2);
    }

    public void checkAlive() {
        Intent a2 = a();
        a2.setAction("com.xiaomi.push.check_alive");
        startServiceSafely(a2);
    }

    public boolean closeChannel() {
        Intent a2 = a();
        a2.setAction(bd.i);
        return startServiceSafely(a2);
    }

    public boolean closeChannel(String str) {
        Intent a2 = a();
        a2.setAction(bd.i);
        a2.putExtra(bd.s, str);
        return startServiceSafely(a2);
    }

    public boolean closeChannel(String str, String str2) {
        Intent a2 = a();
        a2.setAction(bd.i);
        a2.putExtra(bd.s, str);
        a2.putExtra(bd.p, str2);
        return startServiceSafely(a2);
    }

    @Deprecated
    public boolean forceReconnection(String str, String str2, String str3, String str4, String str5, boolean z, List<NameValuePair> list, List<NameValuePair> list2) {
        return forceReconnection(str, str2, str3, str4, str5, z, a(list), a(list2));
    }

    public boolean forceReconnection(String str, String str2, String str3, String str4, String str5, boolean z, Map<String, String> map, Map<String, String> map2) {
        Intent a2 = a();
        a2.setAction(bd.j);
        a(a2, str, str2, str3, str4, str5, z, map, map2);
        return startServiceSafely(a2);
    }

    public boolean isMiuiPushServiceEnabled() {
        return this.f187a;
    }

    public int openChannel(String str, String str2, String str3, String str4, String str5, Map<String, String> map, Map<String, String> map2, boolean z) {
        Intent a2 = a();
        a2.setAction(bd.d);
        a(a2, str, str2, str3, str4, str5, z, map, map2);
        startServiceSafely(a2);
        return 0;
    }

    @Deprecated
    public int openChannel(String str, String str2, String str3, String str4, String str5, boolean z, List<NameValuePair> list, List<NameValuePair> list2) {
        return openChannel(str, str2, str3, str4, str5, a(list), a(list2), z);
    }

    @Deprecated
    public void resetConnection(String str, String str2, String str3, String str4, String str5, boolean z, List<NameValuePair> list, List<NameValuePair> list2) {
        resetConnection(str, str2, str3, str4, str5, z, a(list), a(list2));
    }

    public void resetConnection(String str, String str2, String str3, String str4, String str5, boolean z, Map<String, String> map, Map<String, String> map2) {
        Intent a2 = a();
        a2.setAction(bd.k);
        a(a2, str, str2, str3, str4, str5, z, map, map2);
        startServiceSafely(a2);
    }

    public boolean sendIQ(eqp eqp) {
        if (!emf.O000000o(this.f184a)) {
            return false;
        }
        Intent a2 = a();
        Bundle O000000o2 = eqp.O000000o();
        if (O000000o2 == null) {
            return false;
        }
        duv.O00000o0("SEND:" + eqp.O00000Oo());
        a2.setAction(bd.f);
        a2.putExtra(bd.E, f183a);
        a2.putExtra("ext_packet", O000000o2);
        return startServiceSafely(a2);
    }

    public boolean sendMessage(eqq eqq, boolean z) {
        if (!emf.O000000o(this.f184a)) {
            return false;
        }
        Intent a2 = a();
        String O000000o2 = epo.O000000o();
        if (!TextUtils.isEmpty(O000000o2)) {
            eqo eqo = new eqo("pf");
            eqo eqo2 = new eqo("sent");
            eqo2.O00000Oo(O000000o2);
            eqo.O000000o(eqo2);
            eqq.O000000o(eqo);
        }
        Bundle O000000o3 = eqq.O000000o();
        if (O000000o3 == null) {
            return false;
        }
        duv.O00000o0("SEND:" + eqq.O00000Oo());
        a2.setAction(bd.e);
        a2.putExtra(bd.E, f183a);
        a2.putExtra("ext_packet", O000000o3);
        a2.putExtra("ext_encrypt", z);
        return startServiceSafely(a2);
    }

    public boolean sendMessage(byte[] bArr, String str, String str2) {
        String str3;
        if (!emf.O000000o(this.f184a) || bArr == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            duv.O000000o("Failed to send message: message|userId|chid may be empty, or the network is unavailable.");
            return false;
        }
        Intent a2 = a();
        if (bArr == null) {
            return false;
        }
        a2.setAction(bd.e);
        a2.putExtra(bd.E, f183a);
        a2.putExtra("ext_raw_packet", bArr);
        int indexOf = str.indexOf("@");
        String str4 = null;
        String substring = indexOf != -1 ? str.substring(0, indexOf) : null;
        int lastIndexOf = str.lastIndexOf("/");
        if (lastIndexOf != -1) {
            str4 = str.substring(indexOf + 1, lastIndexOf);
            str3 = str.substring(lastIndexOf + 1);
        } else {
            str3 = null;
        }
        a2.putExtra(bd.p, substring);
        a2.putExtra(bd.q, str4);
        a2.putExtra(bd.r, str3);
        StringBuilder sb = new StringBuilder();
        sb.append(b);
        long j = f6461a;
        f6461a = 1 + j;
        sb.append(j);
        String sb2 = sb.toString();
        a2.putExtra("ext_pkt_id", sb2);
        a2.putExtra("ext_chid", str2);
        duv.O00000oo("SEND: chid=" + str2 + ", packetId=" + sb2);
        return startServiceSafely(a2);
    }

    public boolean sendPresence(go goVar) {
        if (!emf.O000000o(this.f184a)) {
            return false;
        }
        Intent a2 = a();
        Bundle O000000o2 = goVar.O000000o();
        if (O000000o2 == null) {
            return false;
        }
        duv.O00000o0("SEND:" + goVar.O00000Oo());
        a2.setAction(bd.h);
        a2.putExtra(bd.E, f183a);
        a2.putExtra("ext_packet", O000000o2);
        return startServiceSafely(a2);
    }

    public void setMessenger(Messenger messenger) {
        this.f185a = messenger;
    }

    public boolean startServiceSafely(Intent intent) {
        try {
            if (esl.O000000o() || Build.VERSION.SDK_INT < 26) {
                this.f184a.startService(intent);
                return true;
            }
            m110a(intent);
            return true;
        } catch (Exception e) {
            duv.O000000o(e);
            return false;
        }
    }

    @Deprecated
    public void updateChannelInfo(String str, List<NameValuePair> list, List<NameValuePair> list2) {
        updateChannelInfo(str, a(list), a(list2));
    }

    public void updateChannelInfo(String str, Map<String, String> map, Map<String, String> map2) {
        Intent a2 = a();
        a2.setAction(bd.l);
        if (map != null) {
            String a3 = a(map);
            if (!TextUtils.isEmpty(a3)) {
                a2.putExtra(bd.y, a3);
            }
        }
        if (map2 != null) {
            String a4 = a(map2);
            if (!TextUtils.isEmpty(a4)) {
                a2.putExtra(bd.z, a4);
            }
        }
        a2.putExtra(bd.s, str);
        startServiceSafely(a2);
    }
}
