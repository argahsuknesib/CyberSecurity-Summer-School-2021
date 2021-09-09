package com.amap.api.services.a;

import android.content.Context;
import com.amap.api.services.core.ServiceSettings;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public abstract class k<T, V> extends j<T, V> {
    public Map<String, String> d() {
        return null;
    }

    /* access modifiers changed from: protected */
    public V f() {
        return null;
    }

    /* access modifiers changed from: protected */
    public abstract String g();

    public k(Context context, T t) {
        super(context, t);
    }

    public byte[] h() {
        try {
            StringBuffer stringBuffer = new StringBuffer(g());
            stringBuffer.append("&language=");
            stringBuffer.append(ServiceSettings.getInstance().getLanguage());
            String stringBuffer2 = stringBuffer.toString();
            String b = b(stringBuffer2);
            StringBuffer stringBuffer3 = new StringBuffer();
            stringBuffer3.append(stringBuffer2);
            String a2 = bs.a();
            stringBuffer3.append("&ts=".concat(String.valueOf(a2)));
            stringBuffer3.append("&scode=" + bs.a(this.d, a2, b));
            return stringBuffer3.toString().getBytes("utf-8");
        } catch (Throwable th) {
            s.a(th, "ProtocalHandler", "getEntity");
            return null;
        }
    }

    public Map<String, String> e() {
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/x-www-form-urlencoded");
        hashMap.put("Accept-Encoding", "gzip");
        hashMap.put("User-Agent", "AMAP SDK Android Search 6.9.3");
        hashMap.put("X-INFO", bs.a(this.d));
        hashMap.put("platinfo", String.format("platform=Android&sdkversion=%s&product=%s", "6.9.3", "sea"));
        hashMap.put("logversion", "2.1");
        return hashMap;
    }

    public String b(String str) {
        String[] split = str.split("&");
        Arrays.sort(split);
        StringBuffer stringBuffer = new StringBuffer();
        for (String d : split) {
            stringBuffer.append(d(d));
            stringBuffer.append("&");
        }
        String stringBuffer2 = stringBuffer.toString();
        return stringBuffer2.length() > 1 ? (String) stringBuffer2.subSequence(0, stringBuffer2.length() - 1) : str;
    }

    /* access modifiers changed from: protected */
    public String c(String str) {
        if (str == null) {
            return str;
        }
        try {
            return URLEncoder.encode(str, "utf-8");
        } catch (UnsupportedEncodingException e) {
            s.a(e, "ProtocalHandler", "strEncoderUnsupportedEncodingException");
            return "";
        } catch (Exception e2) {
            s.a(e2, "ProtocalHandler", "strEncoderException");
            return "";
        }
    }

    /* access modifiers changed from: protected */
    public String d(String str) {
        if (str == null) {
            return str;
        }
        try {
            return URLDecoder.decode(str, "utf-8");
        } catch (UnsupportedEncodingException e) {
            s.a(e, "ProtocalHandler", "strReEncoder");
            return "";
        } catch (Exception e2) {
            s.a(e2, "ProtocalHandler", "strReEncoderException");
            return "";
        }
    }
}
