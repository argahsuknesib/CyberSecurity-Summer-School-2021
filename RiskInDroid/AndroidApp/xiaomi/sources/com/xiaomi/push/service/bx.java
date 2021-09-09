package com.xiaomi.push.service;

import _m_j.duv;
import _m_j.elo;
import _m_j.esv;
import android.content.Context;
import android.util.Log;
import com.xiaomi.push.hz;
import com.xiaomi.push.io;
import com.xiaomi.push.service.XMPushService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class bx implements XMPushService.n {

    /* renamed from: a  reason: collision with root package name */
    private static Context f6539a;

    /* renamed from: a  reason: collision with other field name */
    private static final Map<Integer, Map<String, List<String>>> f307a = new HashMap();

    /* renamed from: a  reason: collision with other field name */
    private static final boolean f308a = Log.isLoggable("UNDatas", 3);

    public bx(Context context) {
        f6539a = context;
    }

    private static void b() {
        HashMap hashMap = new HashMap();
        hashMap.putAll(f307a);
        if (hashMap.size() > 0) {
            for (Integer num : hashMap.keySet()) {
                Map map = (Map) hashMap.get(num);
                if (map != null && map.size() > 0) {
                    StringBuilder sb = new StringBuilder();
                    for (String str : map.keySet()) {
                        sb.append(str);
                        sb.append(":");
                        List list = (List) map.get(str);
                        if (!esv.O000000o(list)) {
                            for (int i = 0; i < list.size(); i++) {
                                if (i != 0) {
                                    sb.append(",");
                                }
                                sb.append((String) list.get(i));
                            }
                        }
                        sb.append(";");
                    }
                    io a2 = a(null, aw.a(), hz.Y.f70a, null);
                    a2.O000000o("removed_reason", String.valueOf(num));
                    a2.O000000o("all_delete_msgId_appId", sb.toString());
                    duv.O00000Oo("UNDatas upload all removed messages reason: " + num + " allIds: " + sb.toString());
                    a(f6539a, a2);
                }
                f307a.remove(num);
            }
        }
    }

    public void a() {
        if (f307a.size() > 0) {
            synchronized (f307a) {
                b();
            }
        }
    }

    private static void a(Context context, io ioVar) {
        if (f308a) {
            duv.O00000Oo("UNDatas upload message notification:".concat(String.valueOf(ioVar)));
        }
        elo.O000000o(context).O000000o(new by(ioVar), 0);
    }

    private static io a(String str, String str2, String str3, String str4) {
        io ioVar = new io();
        if (str3 != null) {
            ioVar.d = str3;
        }
        if (str != null) {
            ioVar.c = str;
        }
        if (str2 != null) {
            ioVar.b = str2;
        }
        if (str4 != null) {
            ioVar.f = str4;
        }
        ioVar.O000000o(false);
        return ioVar;
    }
}
