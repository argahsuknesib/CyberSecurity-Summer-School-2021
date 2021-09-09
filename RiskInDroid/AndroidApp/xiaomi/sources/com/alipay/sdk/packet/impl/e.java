package com.alipay.sdk.packet.impl;

import android.content.Context;
import com.alipay.sdk.net.a;
import com.alipay.sdk.packet.b;
import com.alipay.sdk.sys.a;
import com.alipay.sdk.util.c;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class e extends com.alipay.sdk.packet.e {
    public String a(a aVar, String str, JSONObject jSONObject) {
        return str;
    }

    public JSONObject a() {
        return null;
    }

    public Map<String, String> a(boolean z, String str) {
        return new HashMap();
    }

    public b a(a aVar, Context context, String str) throws Throwable {
        c.b("mspl", "mdap post");
        byte[] a2 = com.alipay.sdk.encrypt.b.a(str.getBytes(Charset.forName("UTF-8")));
        HashMap hashMap = new HashMap();
        hashMap.put("utdId", com.alipay.sdk.sys.b.a().e());
        hashMap.put("logHeader", "RAW");
        hashMap.put("bizCode", "alipaysdk");
        hashMap.put("productId", "alipaysdk_android");
        hashMap.put("Content-Encoding", "Gzip");
        hashMap.put("productVersion", "15.8.00");
        a.b a3 = com.alipay.sdk.net.a.a(context, new a.C0018a("https://loggw-exsdk.alipay.com/loggw/logUpload.do", hashMap, a2));
        c.b("mspl", "mdap got ".concat(String.valueOf(a3)));
        if (a3 != null) {
            boolean a4 = a(a3);
            try {
                byte[] bArr = a3.c;
                if (a4) {
                    bArr = com.alipay.sdk.encrypt.b.b(bArr);
                }
                return new b("", new String(bArr, Charset.forName("UTF-8")));
            } catch (Exception e) {
                c.a(e);
                return null;
            }
        } else {
            throw new RuntimeException("Response is null");
        }
    }
}
