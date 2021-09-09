package com.xiaomi.onetrack.a;

import com.xiaomi.onetrack.h.q;
import java.util.Map;

class ah implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ag f6094a;

    ah(ag agVar) {
        this.f6094a = agVar;
    }

    public void run() {
        try {
            synchronized (this.f6094a.d) {
                if (this.f6094a.d.size() > 0) {
                    for (Map.Entry entry : this.f6094a.d.entrySet()) {
                        String str = (String) entry.getKey();
                        String str2 = (String) entry.getValue();
                        this.f6094a.f.b(str2, str, this.f6094a.e);
                        if (q.f6178a) {
                            q.a("OneTrackSystemImp", "name:" + str2 + "data :" + str);
                        }
                    }
                    this.f6094a.d.clear();
                }
            }
        } catch (Exception e) {
            q.a("OneTrackSystemImp", "trackCachedEvents: " + e.toString());
        }
    }
}
