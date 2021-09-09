package _m_j;

import android.os.Handler;
import android.os.HandlerThread;
import java.util.HashMap;

public class ilb implements ila {
    private static ilb O00000Oo;

    /* renamed from: O000000o  reason: collision with root package name */
    public Handler f1430O000000o;
    private HandlerThread O00000o0 = new HandlerThread("statistics-manager");

    public static ilb O000000o() {
        if (O00000Oo == null) {
            synchronized (ilb.class) {
                if (O00000Oo == null) {
                    O00000Oo = new ilb();
                }
            }
        }
        return O00000Oo;
    }

    private ilb() {
        this.O00000o0.start();
        this.f1430O000000o = new Handler(this.O00000o0.getLooper());
    }

    public final void O000000o(ijr ijr) {
        HashMap hashMap = new HashMap();
        if (ijr.O00000o) {
            StringBuilder sb = new StringBuilder();
            sb.append(ijr.O0000OOo);
            hashMap.put("track_id", sb.toString());
            ilk.O00000Oo("StatisticsManager", "uploadtrack");
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(ijr.O0000OOo);
            hashMap.put("radio_id", sb2.toString());
            ilk.O00000Oo("StatisticsManager", "uploadradio");
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append(ijr.O0000OoO);
        hashMap.put("played_secs", sb3.toString());
        StringBuilder sb4 = new StringBuilder();
        sb4.append(ijr.O0000Oo);
        hashMap.put("duration", sb4.toString());
        StringBuilder sb5 = new StringBuilder();
        sb5.append(ijr.O0000o00);
        hashMap.put("started_at", sb5.toString());
        hashMap.put("play_type", "0");
        if (ijr.O00000o) {
            iit.O0000o00(hashMap, new iiw<ijl>() {
                /* class _m_j.ilb.AnonymousClass1 */

                public final /* bridge */ /* synthetic */ void O000000o(Object obj) {
                    ijl ijl = (ijl) obj;
                    if (ijl != null && ijl.f1368O000000o == 0) {
                        ilk.O000000o((Object) "postTrackSingleRecord onSuccess");
                    }
                }

                public final void O000000o(int i, String str) {
                    ilk.O000000o((Object) "postTrackSingleRecord onError  ".concat(String.valueOf(str)));
                }
            });
        } else {
            iit.O0000Ooo(hashMap, new iiw<ijl>() {
                /* class _m_j.ilb.AnonymousClass2 */

                public final /* bridge */ /* synthetic */ void O000000o(Object obj) {
                    ijl ijl = (ijl) obj;
                    if (ijl != null && ijl.f1368O000000o == 0) {
                        ilk.O000000o((Object) "postLiveSingleRecord onSuccess");
                    }
                }

                public final void O000000o(int i, String str) {
                    ilk.O000000o((Object) "postLiveSingleRecord onError  ".concat(String.valueOf(str)));
                }
            });
        }
    }
}
