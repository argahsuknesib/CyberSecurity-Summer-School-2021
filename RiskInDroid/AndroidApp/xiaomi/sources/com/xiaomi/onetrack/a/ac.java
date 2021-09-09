package com.xiaomi.onetrack.a;

import com.xiaomi.onetrack.OneTrack;
import com.xiaomi.onetrack.h.q;
import com.xiaomi.onetrack.h.s;
import com.xiaomi.onetrack.h.z;
import java.util.Map;
import org.json.JSONObject;

class ac implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f6091a;
    final /* synthetic */ OneTrack.UserIdType b;
    final /* synthetic */ boolean c;
    final /* synthetic */ Map d;
    final /* synthetic */ f e;

    ac(f fVar, String str, OneTrack.UserIdType userIdType, boolean z, Map map) {
        this.e = fVar;
        this.f6091a = str;
        this.b = userIdType;
        this.c = z;
        this.d = map;
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
            z.g(this.f6091a);
            z.h(this.b.getUserIdType());
            if (!this.c) {
                JSONObject a2 = s.a((Map<String, Object>) this.d, false);
                a2.put("uid", this.f6091a);
                a2.put("uid_type", this.b.getUserIdType());
                this.e.b.a("ot_login", c.c(a2, this.e.f, this.e.h, this.e.d("ot_login")));
            }
        } catch (Exception e2) {
            q.b("OneTrackImp", "login error:" + e2.toString());
        }
    }
}
