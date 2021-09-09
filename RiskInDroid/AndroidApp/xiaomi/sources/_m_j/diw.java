package _m_j;

import android.os.SystemClock;

public final class diw {

    /* renamed from: O000000o  reason: collision with root package name */
    protected static diw f14702O000000o;

    protected diw() {
    }

    public static synchronized diw O000000o() {
        diw diw;
        synchronized (diw.class) {
            if (f14702O000000o == null) {
                f14702O000000o = new diw();
            }
            diw = f14702O000000o;
        }
        return diw;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.diy.O000000o(android.os.Bundle, java.lang.String, boolean):void
     arg types: [android.os.Bundle, java.lang.String, int]
     candidates:
      _m_j.diy.O000000o(java.lang.String, java.lang.String, android.os.Bundle):void
      _m_j.diy.O000000o(android.os.Bundle, java.lang.String, boolean):void */
    public static void O000000o(String str, String str2, String str3, String str4, String str5, String str6) {
        diy.O000000o().O000000o(djp.O000000o(str, str3, str4, str5, str2, str6), str2, true);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.diy.O000000o(android.os.Bundle, java.lang.String, boolean):void
     arg types: [android.os.Bundle, java.lang.String, int]
     candidates:
      _m_j.diy.O000000o(java.lang.String, java.lang.String, android.os.Bundle):void
      _m_j.diy.O000000o(android.os.Bundle, java.lang.String, boolean):void */
    public static void O000000o(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        diy.O000000o().O000000o(djp.O000000o(str, str4, str5, str3, str2, str6, "", str7, str8, "", "", ""), str2, false);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.diy.O000000o(android.os.Bundle, java.lang.String, boolean):void
     arg types: [android.os.Bundle, java.lang.String, int]
     candidates:
      _m_j.diy.O000000o(java.lang.String, java.lang.String, android.os.Bundle):void
      _m_j.diy.O000000o(android.os.Bundle, java.lang.String, boolean):void */
    public static void O000000o(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
        diy.O000000o().O000000o(djp.O000000o(str, str4, str5, str3, str2, str6, str7, "", "", str8, str9, str10), str2, false);
    }

    public static void O000000o(int i, String str, String str2, String str3, String str4, Long l, String str5) {
        long elapsedRealtime = SystemClock.elapsedRealtime() - l.longValue();
        if (l.longValue() == 0 || elapsedRealtime < 0) {
            elapsedRealtime = 0;
        }
        StringBuffer stringBuffer = new StringBuffer("https://huatuocode.huatuo.qq.com");
        stringBuffer.append("?domain=mobile.opensdk.com&cgi=opensdk&type=");
        stringBuffer.append(i);
        stringBuffer.append("&code=0&time=");
        stringBuffer.append(elapsedRealtime);
        stringBuffer.append("&rate=1&uin=");
        stringBuffer.append(str2);
        stringBuffer.append("&data=");
        diy.O000000o().O000000o(stringBuffer.toString(), "GET", djp.O000000o(String.valueOf(i), "0", String.valueOf(elapsedRealtime), "1", str, str2, str3, str4, str5));
    }
}
