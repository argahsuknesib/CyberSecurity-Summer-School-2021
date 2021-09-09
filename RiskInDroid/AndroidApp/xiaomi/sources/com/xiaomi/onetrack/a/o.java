package com.xiaomi.onetrack.a;

import android.text.TextUtils;
import com.xiaomi.onetrack.h.l;
import com.xiaomi.onetrack.h.q;
import com.xiaomi.onetrack.h.s;
import java.util.Map;
import org.json.JSONObject;

class o implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Map f6107a;
    final /* synthetic */ f b;

    o(f fVar, Map map) {
        this.b = fVar;
        this.f6107a = map;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.onetrack.h.s.a(java.util.Map<java.lang.String, java.lang.Object>, boolean):org.json.JSONObject
     arg types: [java.util.Map, int]
     candidates:
      com.xiaomi.onetrack.h.s.a(java.util.Map<java.lang.String, java.lang.Object>, com.xiaomi.onetrack.h.s$a):org.json.JSONObject
      com.xiaomi.onetrack.h.s.a(org.json.JSONObject, org.json.JSONObject):org.json.JSONObject
      com.xiaomi.onetrack.h.s.a(java.lang.String, java.lang.String):void
      com.xiaomi.onetrack.h.s.a(java.util.Map<java.lang.String, java.lang.Object>, boolean):org.json.JSONObject */
    public void run() {
        try {
            JSONObject a2 = s.a((Map<String, Object>) this.f6107a, false);
            String a3 = l.a(this.b.i());
            JSONObject jSONObject = null;
            if (!TextUtils.isEmpty(a3)) {
                jSONObject = new JSONObject(a3);
            }
            l.a(this.b.i(), s.a(a2, jSONObject).toString());
        } catch (Exception e) {
            q.b("OneTrackImp", " " + e.toString());
        }
    }
}
