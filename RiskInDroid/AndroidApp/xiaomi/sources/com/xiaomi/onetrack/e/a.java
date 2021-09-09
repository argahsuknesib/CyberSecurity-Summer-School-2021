package com.xiaomi.onetrack.e;

import com.xiaomi.onetrack.b.f;
import com.xiaomi.onetrack.f.b;
import com.xiaomi.onetrack.h.q;
import org.json.JSONObject;

public class a extends b {
    public a(String str, String str2, String str3, String str4) {
        try {
            a(str);
            c(str3);
            b(str2);
            b(System.currentTimeMillis());
            a(new JSONObject(str4));
            a(f.a().a(str, str3, "level", 1));
        } catch (Exception e) {
            q.b("CustomEvent", "CustomEvent error:" + e.toString());
        }
    }
}
