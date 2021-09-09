package com.xiaomi.onetrack.h.a.a;

import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import com.xiaomi.onetrack.h.q;

public class k {
    public String a(Context context) {
        Bundle bundle;
        Uri parse = Uri.parse("content://cn.nubia.identity/identity");
        try {
            if (Build.VERSION.SDK_INT > 17) {
                ContentProviderClient acquireContentProviderClient = context.getContentResolver().acquireContentProviderClient(parse);
                bundle = acquireContentProviderClient.call("getOAID", null, null);
                if (acquireContentProviderClient != null) {
                    if (Build.VERSION.SDK_INT >= 24) {
                        acquireContentProviderClient.close();
                    } else {
                        acquireContentProviderClient.release();
                    }
                }
            } else {
                bundle = context.getContentResolver().call(parse, "getOAID", (String) null, (Bundle) null);
            }
            if (bundle.getInt("code", -1) == 0) {
                return bundle.getString("id");
            }
            return "";
        } catch (Exception e) {
            q.a("NubiaDeviceIDHelper", e.getMessage());
            return "";
        }
    }
}
