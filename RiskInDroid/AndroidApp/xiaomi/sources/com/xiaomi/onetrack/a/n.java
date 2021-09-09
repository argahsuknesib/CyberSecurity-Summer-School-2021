package com.xiaomi.onetrack.a;

import android.text.TextUtils;
import com.xiaomi.onetrack.h.q;
import com.xiaomi.onetrack.h.z;
import org.json.JSONObject;

class n implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ boolean f6106a;
    final /* synthetic */ f b;

    n(f fVar, boolean z) {
        this.b = fVar;
        this.f6106a = z;
    }

    public void run() {
        try {
            String z = z.z();
            if (!TextUtils.isEmpty(z)) {
                JSONObject jSONObject = new JSONObject(z);
                this.b.b.a("onetrack_pa", jSONObject.put("B", jSONObject.optJSONObject("B").put("app_end", this.f6106a)).toString());
                if (q.f6178a) {
                    q.a("OneTrackImp", "trackPageEndAuto");
                }
                z.i("");
            }
        } catch (Exception e) {
            q.b("OneTrackImp", "trackPageEndAuto error:" + e.toString());
        }
    }
}
