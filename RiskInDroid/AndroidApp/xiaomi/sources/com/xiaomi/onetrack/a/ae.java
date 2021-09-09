package com.xiaomi.onetrack.a;

import android.content.Context;
import com.xiaomi.onetrack.Configuration;
import com.xiaomi.onetrack.OneTrack;
import com.xiaomi.onetrack.b.a;
import com.xiaomi.onetrack.c.g;
import com.xiaomi.onetrack.f.d;
import com.xiaomi.onetrack.f.f;
import com.xiaomi.onetrack.h.j;
import com.xiaomi.onetrack.h.q;

public class ae implements d {
    private Configuration d;

    public ae(Context context, Configuration configuration) {
        f.a(context);
        this.d = configuration;
    }

    public void a(String str, String str2) {
        if (b(str, str2)) {
            if (!g.b()) {
                g.a(str, str2);
                return;
            }
            g.a(this);
            if (q.f6178a && !str.equalsIgnoreCase("onetrack_bug_report")) {
                q.a("OneTrackLocalImp", "track data:".concat(String.valueOf(str2)));
            }
            a.a(this.d.getAppId());
            if (!a(str)) {
                d.a(this.d.getAppId(), com.xiaomi.onetrack.f.a.d(), str, str2);
            }
        }
    }

    public void a(int i) {
        if (g.b() && i == 2) {
            j.a(new af(this));
        }
    }

    public boolean b(String str, String str2) {
        if (OneTrack.isDisable() || OneTrack.isUseSystemNetTrafficOnly()) {
            return false;
        }
        if ((str != null && str.equals("onetrack_bug_report")) || str2 == null || str2.length() * 2 <= 102400) {
            return true;
        }
        q.a("OneTrackLocalImp", "Event size exceed limitation!");
        return false;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.onetrack.b.f.a(java.lang.String, java.lang.String, java.lang.String, boolean):boolean
     arg types: [java.lang.String, java.lang.String, java.lang.String, int]
     candidates:
      com.xiaomi.onetrack.b.f.a(java.lang.String, java.lang.String, java.lang.String, double):double
      com.xiaomi.onetrack.b.f.a(java.lang.String, java.lang.String, java.lang.String, int):int
      com.xiaomi.onetrack.b.f.a(java.lang.String, java.lang.String, java.lang.String, long):long
      com.xiaomi.onetrack.b.f.a(java.lang.String, java.lang.String, java.lang.String, java.lang.String):java.lang.String
      com.xiaomi.onetrack.b.f.a(java.lang.String, java.lang.String, java.lang.String, boolean):boolean */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x003e A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:12:? A[ADDED_TO_REGION, ORIG_RETURN, RETURN, SYNTHETIC] */
    public boolean a(String str) {
        boolean z;
        boolean z2;
        try {
            z2 = com.xiaomi.onetrack.b.f.a().a(this.d.getAppId(), "disable_log");
            try {
                z = com.xiaomi.onetrack.b.f.a().a(this.d.getAppId(), str, "disable_log", false);
            } catch (Exception e) {
                e = e;
                q.a("OneTrackLocalImp", "isDisableTrack: " + e.toString());
                z = false;
                if (!z2) {
                }
            }
        } catch (Exception e2) {
            e = e2;
            z2 = false;
            q.a("OneTrackLocalImp", "isDisableTrack: " + e.toString());
            z = false;
            return !z2 ? true : true;
        }
        if (!z2 && !z) {
            return false;
        }
    }
}
