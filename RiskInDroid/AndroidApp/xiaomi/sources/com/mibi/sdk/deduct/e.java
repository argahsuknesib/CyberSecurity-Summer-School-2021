package com.mibi.sdk.deduct;

import _m_j.cfk;
import _m_j.cgf;
import _m_j.cgh;
import android.content.Context;
import com.mibi.sdk.component.recharge.Recharge;
import java.util.HashMap;

public final class e {
    private static final e O00000Oo = new e();

    /* renamed from: O000000o  reason: collision with root package name */
    public HashMap<String, Recharge> f5141O000000o = new HashMap<>();

    public enum a {
        ALIPAY(cfk.class),
        MIPAY(cgf.class),
        WXPAY(cgh.class);
        
        private Recharge d = null;

        private a(Class<? extends Recharge> cls) {
            try {
                this.d = (Recharge) cls.newInstance();
            } catch (InstantiationException e2) {
                throw new IllegalStateException(e2);
            } catch (IllegalAccessException e3) {
                throw new IllegalStateException(e3);
            }
        }

        public final Recharge a() {
            return this.d;
        }

        public final String b() {
            return this.d.getChannel();
        }
    }

    private e() {
        for (a aVar : a.values()) {
            this.f5141O000000o.put(aVar.b(), aVar.a());
        }
    }

    public static e O000000o() {
        return O00000Oo;
    }

    public static String O000000o(Context context) {
        StringBuilder sb = new StringBuilder();
        for (a aVar : a.values()) {
            if (aVar.a().available(context)) {
                if (sb.length() != 0) {
                    sb.append(",");
                }
                sb.append(aVar.b());
            }
        }
        return sb.toString();
    }
}
