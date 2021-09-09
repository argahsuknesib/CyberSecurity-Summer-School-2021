package _m_j;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.ximalaya.ting.android.opensdk.util.dh.DhKeyPair;
import java.util.HashMap;

public class ijg {
    private static ijg O00000Oo;

    /* renamed from: O000000o  reason: collision with root package name */
    public String f1360O000000o;
    private boolean O00000o = false;
    private Context O00000o0;

    public static ijg O000000o() {
        if (O00000Oo == null) {
            synchronized (ijg.class) {
                if (O00000Oo == null) {
                    O00000Oo = new ijg();
                }
            }
        }
        return O00000Oo;
    }

    public final void O000000o(Context context) {
        if (!this.O00000o) {
            this.O00000o = true;
            this.O00000o0 = context.getApplicationContext();
            this.f1360O000000o = ilp.O000000o(this.O00000o0).O00000o0("secret_public_key");
            if (!O00000Oo()) {
                O00000o();
            }
        }
    }

    public final boolean O00000Oo() {
        long O00000Oo2 = ilp.O000000o(this.O00000o0).O00000Oo("secret_request_time");
        int O00000o2 = ilp.O000000o(this.O00000o0).O00000o("secret_expired_time");
        if (!TextUtils.isEmpty(this.f1360O000000o) && (System.currentTimeMillis() - O00000Oo2) / 1000 <= ((long) O00000o2)) {
            return true;
        }
        this.f1360O000000o = null;
        O00000o0();
        return false;
    }

    public final void O00000o0() {
        ilp.O000000o(this.O00000o0).O00000oo("secret_request_time");
        ilp.O000000o(this.O00000o0).O00000oo("secret_expired_time");
        ilp.O000000o(this.O00000o0).O00000oo("secret_public_key");
        ilh.O000000o(this.O00000o0);
    }

    private void O00000o() {
        DhKeyPair O000000o2 = ilh.O000000o();
        if (O000000o2 != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("c_pub_key", O000000o2.publicKey.toString());
            iit.O0000Oo(hashMap, new iiw<ijm>() {
                /* class _m_j.ijg.AnonymousClass1 */

                public final /* bridge */ /* synthetic */ void O000000o(Object obj) {
                    ijg.this.O000000o((ijm) obj);
                }

                public final void O000000o(int i, String str) {
                    ijg.this.O00000o0();
                }
            });
        }
    }

    public static String O000000o(String str) {
        if (str.length() < 16) {
            StringBuilder sb = new StringBuilder(str);
            while (sb.length() < 16) {
                sb.append("0");
            }
            str = sb.toString();
        }
        return str.substring(0, 16);
    }

    public static byte[] O00000Oo(String str) {
        try {
            return Base64.decode(str, 0);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public final void O000000o(ijm ijm) {
        if (ijm != null) {
            this.f1360O000000o = ijm.f1369O000000o;
            ilp.O000000o(this.O00000o0).O000000o("secret_public_key", this.f1360O000000o);
            ilp.O000000o(this.O00000o0).O000000o("secret_request_time", System.currentTimeMillis());
            ilp.O000000o(this.O00000o0).O000000o("secret_expired_time", ijm.O00000Oo);
            return;
        }
        O00000o0();
    }
}
