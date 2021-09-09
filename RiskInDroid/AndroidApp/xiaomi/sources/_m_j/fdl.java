package _m_j;

import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public class fdl {
    private static volatile fdl O00000o0;

    /* renamed from: O000000o  reason: collision with root package name */
    public volatile boolean f16104O000000o = true;
    public AtomicBoolean O00000Oo = new AtomicBoolean(false);

    private fdl() {
    }

    public static fdl O000000o() {
        if (O00000o0 == null) {
            synchronized (fdl.class) {
                if (O00000o0 == null) {
                    O00000o0 = new fdl();
                }
            }
        }
        return O00000o0;
    }

    public static void O000000o(JSONObject jSONObject) {
        fdk O000000o2 = fdk.O000000o();
        if (jSONObject != null) {
            int optInt = jSONObject.optInt("debug_users", 0);
            O000000o2.O00000Oo = (long) (((jSONObject.optInt("gray_users", 0) << 1) & 2) | (optInt & 1));
            gsy.O00000Oo("UserDegree", "mUserDegree:" + O000000o2.O00000Oo);
        }
    }
}
