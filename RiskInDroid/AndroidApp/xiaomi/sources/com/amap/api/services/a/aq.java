package com.amap.api.services.a;

import android.content.Context;
import com.amap.api.services.core.AMapException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class aq extends j<String, String> {
    private String i;

    public aq(Context context, String str) {
        super(context, str);
        this.i = str;
    }

    public Map<String, String> d() {
        byte[] bArr;
        StringBuilder sb = new StringBuilder();
        sb.append("channel=open_api&flag=1");
        sb.append("&address=" + URLEncoder.encode(this.i));
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("open_api1");
        stringBuffer.append(this.i);
        stringBuffer.append("@8UbJH6N2szojnTHONAWzB6K7N1kaj7Y0iUMarxac");
        String a2 = bw.a(stringBuffer.toString());
        sb.append("&sign=");
        sb.append(a2.toUpperCase(Locale.US));
        sb.append("&output=json");
        try {
            bArr = ay.a(sb.toString().getBytes("utf-8"), "Yaynpa84IKOfasFx".substring(0, 16).getBytes("utf-8"));
        } catch (UnsupportedEncodingException e) {
            s.a(e, "ShareUrlSearchHandler", "getParams");
            bArr = null;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("ent", "2");
        hashMap.put("in", bu.b(bArr));
        hashMap.put("keyt", "openapi");
        return hashMap;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public String a(String str) throws AMapException {
        try {
            JSONObject jSONObject = new JSONObject(str);
            String a2 = z.a(jSONObject, "code");
            String a3 = z.a(jSONObject, "message");
            if ("1".equals(a2)) {
                return z.a(jSONObject, "transfer_url");
            }
            if ("0".equals(a2)) {
                throw new AMapException("其他未知错误", 0, a3);
            } else if ("2".equals(a2)) {
                throw new AMapException("短串请求失败", 0, a3);
            } else if ("3".equals(a2)) {
                throw new AMapException("请求参数非法", 0, a3);
            } else if ("4".equals(a2)) {
                throw new AMapException("用户签名未通过", 0, a3);
            } else if (!"5".equals(a2)) {
                return null;
            } else {
                throw new AMapException("短串分享认证失败", 0, a3);
            }
        } catch (JSONException e) {
            s.a(e, "ShareUrlSearchHandler", "paseJSON");
            return null;
        }
    }

    public String i() {
        return r.d();
    }

    /* access modifiers changed from: protected */
    public byte[] a(int i2, de deVar, df dfVar) throws bo {
        if (i2 == 1) {
            return deVar.d(dfVar);
        }
        if (i2 == 2) {
            return deVar.e(dfVar);
        }
        return null;
    }
}
