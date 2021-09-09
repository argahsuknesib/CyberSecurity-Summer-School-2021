package com.xiaomi.onetrack.c;

import com.xiaomi.onetrack.a.d;
import com.xiaomi.onetrack.h.q;
import java.util.List;
import org.json.JSONObject;

final class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ d f6130a;

    i(d dVar) {
        this.f6130a = dVar;
    }

    public final void run() {
        try {
            List<JSONObject> c = g.c();
            if (c != null && c.size() > 0) {
                for (JSONObject next : c) {
                    this.f6130a.a(next.optString("eventName"), next.optString("data"));
                }
            }
            g.c(true);
        } catch (Exception e) {
            q.b("NetworkAccessManager", "cta event error: " + e.toString());
        }
        boolean unused = g.l = false;
    }
}
