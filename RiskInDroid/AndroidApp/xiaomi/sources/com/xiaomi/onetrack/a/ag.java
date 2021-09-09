package com.xiaomi.onetrack.a;

import android.content.Context;
import android.os.Process;
import com.xiaomi.onetrack.Configuration;
import com.xiaomi.onetrack.OneTrack;
import com.xiaomi.onetrack.a.ai;
import com.xiaomi.onetrack.c.g;
import com.xiaomi.onetrack.h.j;
import com.xiaomi.onetrack.h.q;
import java.util.concurrent.ConcurrentHashMap;

public class ag implements ai.b, d {
    /* access modifiers changed from: private */
    public final ConcurrentHashMap<String, String> d = new ConcurrentHashMap<>();
    /* access modifiers changed from: private */
    public Configuration e;
    /* access modifiers changed from: private */
    public ai f;

    public ag(Context context, Configuration configuration) {
        this.e = configuration;
        this.f = ai.a();
        this.f.a(this);
    }

    public void a(String str, String str2) {
        if (b(str, str2)) {
            if (g.b()) {
                g.a(this);
            } else if (!"onetrack_cta_status".equalsIgnoreCase(str)) {
                g.a(str, str2);
                return;
            }
            if (q.f6178a) {
                q.a("OneTrackSystemImp", "track name:" + str + " data :" + str2 + " tid" + Process.myTid());
            }
            synchronized (this.d) {
                if (!this.f.a(str, str2, this.e)) {
                    this.d.put(str2, str);
                    if (q.f6178a) {
                        q.a("OneTrackSystemImp", "track mIOneTrackService is null!" + this.d.size() + "  " + str2);
                    }
                }
            }
        }
    }

    private boolean b(String str, String str2) {
        if (OneTrack.isDisable()) {
            return false;
        }
        if ((str != null && str.equals("onetrack_bug_report")) || str2 == null || str2.length() * 2 <= 102400) {
            return true;
        }
        q.a("OneTrackSystemImp", "Event size exceed limitation!");
        return false;
    }

    public void a(int i) {
        this.f.a(i);
    }

    public void a() {
        if (g.b()) {
            b();
        }
    }

    private void b() {
        j.a(new ah(this));
    }
}
