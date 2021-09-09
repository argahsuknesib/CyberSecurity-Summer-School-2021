package com.loc;

import _m_j.bty;
import _m_j.bua;
import _m_j.pg;
import android.content.Context;
import java.lang.reflect.Method;

public final class co implements pg.O000000o {

    /* renamed from: O000000o  reason: collision with root package name */
    Context f4521O000000o = null;
    Object O00000Oo = null;

    public co(Context context) {
        this.f4521O000000o = context;
    }

    private double[] O00000Oo(double[] dArr) {
        try {
            if (this.O00000Oo == null) {
                this.O00000Oo = Class.forName("com.amap.api.location.CoordinateConverter").getConstructor(Context.class).newInstance(this.f4521O000000o);
            }
            if (bua.O000000o(dArr[0], dArr[1])) {
                Object[] objArr = {"GPS"};
                Object newInstance = Class.forName("com.amap.api.location.DPoint").getConstructor(Double.TYPE, Double.TYPE).newInstance(Double.valueOf(dArr[0]), Double.valueOf(dArr[1]));
                Method declaredMethod = Class.forName("com.amap.api.location.CoordinateConverter$CoordType").getDeclaredMethod("valueOf", String.class);
                if (!declaredMethod.isAccessible()) {
                    declaredMethod.setAccessible(true);
                }
                Object invoke = declaredMethod.invoke(null, objArr);
                bty.O000000o(this.O00000Oo, "coord", newInstance);
                bty.O000000o(this.O00000Oo, "from", invoke);
                Object O000000o2 = bty.O000000o(this.O00000Oo, "convert", new Object[0]);
                dArr[0] = ((Double) bty.O000000o(O000000o2, "getLatitude", new Object[0])).doubleValue();
                dArr[1] = ((Double) bty.O000000o(O000000o2, "getLongitude", new Object[0])).doubleValue();
            }
        } catch (Throwable th) {
            bua.O000000o(th, "OfflineCoordinateConverter", "wgsToGcj");
        }
        return dArr;
    }

    public final double[] O000000o(double[] dArr) {
        if (this.f4521O000000o == null) {
            return null;
        }
        return O00000Oo(dArr);
    }
}
