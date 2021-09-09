package com.tencent.wxop.stat;

import _m_j.dkc;
import _m_j.dkd;
import _m_j.dke;
import _m_j.dkf;
import _m_j.dkl;
import _m_j.dkv;
import _m_j.dlm;
import android.content.Context;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;

public final class ap implements Runnable {

    /* renamed from: O000000o  reason: collision with root package name */
    private Context f5887O000000o = null;
    private Map<String, Integer> O00000Oo = null;
    private dkf O00000o0 = null;

    public ap(Context context) {
        this.f5887O000000o = context;
        this.O00000o0 = null;
    }

    private static Map<String, Integer> O000000o() {
        String str;
        HashMap hashMap = new HashMap();
        String O000000o2 = dkd.O000000o("__MTA_TEST_SPEED__");
        if (!(O000000o2 == null || O000000o2.trim().length() == 0)) {
            for (String split : O000000o2.split(";")) {
                String[] split2 = split.split(",");
                if (!(split2 == null || split2.length != 2 || (str = split2[0]) == null || str.trim().length() == 0)) {
                    try {
                        hashMap.put(str, Integer.valueOf(Integer.valueOf(split2[1]).intValue()));
                    } catch (NumberFormatException e) {
                        dke.O0000o.O00000Oo((Throwable) e);
                    }
                }
            }
        }
        return hashMap;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.dke.O000000o(android.content.Context, boolean, _m_j.dkf):int
     arg types: [android.content.Context, int, _m_j.dkf]
     candidates:
      _m_j.dke.O000000o(android.content.Context, java.lang.String, _m_j.dkf):void
      _m_j.dke.O000000o(android.content.Context, java.lang.String, java.util.Properties):void
      _m_j.dke.O000000o(android.content.Context, java.lang.String, java.lang.String):boolean
      _m_j.dke.O000000o(android.content.Context, boolean, _m_j.dkf):int */
    public final void run() {
        dlm O00000oO;
        String str;
        try {
            if (this.O00000Oo == null) {
                this.O00000Oo = O000000o();
            }
            if (this.O00000Oo != null) {
                if (this.O00000Oo.size() != 0) {
                    JSONArray jSONArray = new JSONArray();
                    for (Map.Entry next : this.O00000Oo.entrySet()) {
                        String str2 = (String) next.getKey();
                        if (str2 != null) {
                            if (str2.length() != 0) {
                                if (((Integer) next.getValue()) == null) {
                                    O00000oO = dke.O0000o;
                                    str = "port is null for ".concat(String.valueOf(str2));
                                    O00000oO.O00000o0(str);
                                } else {
                                    jSONArray.put(O000000o((String) next.getKey(), ((Integer) next.getValue()).intValue()).O000000o());
                                }
                            }
                        }
                        O00000oO = dke.O0000o;
                        str = "empty domain name.";
                        O00000oO.O00000o0(str);
                    }
                    if (jSONArray.length() != 0) {
                        dkl dkl = new dkl(this.f5887O000000o, dke.O000000o(this.f5887O000000o, false, this.O00000o0), this.O00000o0);
                        dkl.f14744O000000o = jSONArray.toString();
                        new dkv(dkl).O000000o();
                        return;
                    }
                    return;
                }
            }
            dke.O0000o.O000000o("empty domain list.");
        } catch (Throwable th) {
            dke.O0000o.O00000Oo(th);
        }
    }

    private static dkc O000000o(String str, int i) {
        int i2;
        dkc dkc = new dkc();
        Socket socket = new Socket();
        try {
            dkc.O00000o0 = str;
            dkc.O00000o = i;
            long currentTimeMillis = System.currentTimeMillis();
            InetSocketAddress inetSocketAddress = new InetSocketAddress(str, i);
            socket.connect(inetSocketAddress, 30000);
            dkc.f14736O000000o = System.currentTimeMillis() - currentTimeMillis;
            dkc.O00000oO = inetSocketAddress.getAddress().getHostAddress();
            socket.close();
            try {
                socket.close();
            } catch (Throwable th) {
                dke.O0000o.O00000Oo(th);
            }
            i2 = 0;
        } catch (IOException e) {
            try {
                dke.O0000o.O00000Oo((Throwable) e);
                socket.close();
            } catch (Throwable th2) {
                dke.O0000o.O00000Oo(th2);
            }
        } catch (Throwable th3) {
            dke.O0000o.O00000Oo(th3);
        }
        dkc.O00000Oo = i2;
        return dkc;
        throw th;
        i2 = -1;
        dkc.O00000Oo = i2;
        return dkc;
    }
}
