package com.alipay.apmobilesecuritysdk.e;

import android.content.Context;
import com.alipay.apmobilesecuritysdk.f.a;
import org.json.JSONObject;

public final class e {
    public static f a(Context context) {
        if (context == null) {
            return null;
        }
        String a2 = a.a(context, "device_feature_prefs_name", "device_feature_prefs_key");
        if (com.alipay.security.mobile.module.a.a.a(a2)) {
            a2 = a.a("device_feature_file_name", "device_feature_file_key");
        }
        if (com.alipay.security.mobile.module.a.a.a(a2)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(a2);
            f fVar = new f();
            fVar.a(jSONObject.getString("imei"));
            fVar.b(jSONObject.getString("imsi"));
            fVar.c(jSONObject.getString("mac"));
            fVar.d(jSONObject.getString("bluetoothmac"));
            fVar.e(jSONObject.getString("gsi"));
            return fVar;
        } catch (Exception e) {
            com.alipay.apmobilesecuritysdk.c.a.a(e);
            return null;
        }
    }
}
