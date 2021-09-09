package _m_j;

import _m_j.amb;
import com.fasterxml.jackson.core.JsonParser;

public final class amc {

    /* renamed from: O000000o  reason: collision with root package name */
    protected final JsonParser f12451O000000o;
    protected final ajt O00000Oo;
    public amb O00000o;
    protected final Object[] O00000o0;
    private int O00000oO;

    public amc(JsonParser jsonParser, ajt ajt, int i) {
        this.f12451O000000o = jsonParser;
        this.O00000Oo = ajt;
        this.O00000oO = i;
        this.O00000o0 = new Object[i];
    }

    public final void O000000o(alm[] almArr) {
        int length = almArr.length;
        for (int i = 0; i < length; i++) {
            alm alm = almArr[i];
            if (alm != null) {
                this.O00000o0[i] = this.O00000Oo.O000000o(alm.O00000o0());
            }
        }
    }

    /* access modifiers changed from: protected */
    public final Object[] O000000o(Object[] objArr) {
        Object obj;
        if (objArr != null) {
            int length = this.O00000o0.length;
            for (int i = 0; i < length; i++) {
                Object[] objArr2 = this.O00000o0;
                if (objArr2[i] == null && (obj = objArr[i]) != null) {
                    objArr2[i] = obj;
                }
            }
        }
        return this.O00000o0;
    }

    public final boolean O000000o(int i, Object obj) {
        this.O00000o0[i] = obj;
        int i2 = this.O00000oO - 1;
        this.O00000oO = i2;
        return i2 <= 0;
    }

    public final void O000000o(alm alm, Object obj) {
        this.O00000o = new amb.O00000o0(this.O00000o, obj, alm);
    }

    public final void O000000o(all all, String str, Object obj) {
        this.O00000o = new amb.O000000o(this.O00000o, obj, all, str);
    }
}
