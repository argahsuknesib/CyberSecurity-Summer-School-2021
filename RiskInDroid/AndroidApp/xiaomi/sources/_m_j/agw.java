package _m_j;

import com.drew.lang.Rational;
import java.util.Stack;

public abstract class agw implements xa {

    /* renamed from: O000000o  reason: collision with root package name */
    private final Stack<xr> f12383O000000o = new Stack<>();
    protected xr O00000Oo;
    private xr O00000o;
    protected final xu O00000o0;

    protected agw(xu xuVar, xr xrVar) {
        this.O00000o0 = xuVar;
        this.O00000o = xrVar;
    }

    public final void O00000Oo() {
        this.O00000Oo = this.f12383O000000o.empty() ? null : this.f12383O000000o.pop();
    }

    /* access modifiers changed from: protected */
    public final void O000000o(Class<? extends xr> cls) {
        try {
            xr xrVar = (xr) cls.newInstance();
            xr xrVar2 = this.O00000Oo;
            if (xrVar2 == null) {
                xr xrVar3 = this.O00000o;
                if (xrVar3 != null) {
                    xrVar.O00000oO = xrVar3;
                    this.O00000o = null;
                }
            } else {
                this.f12383O000000o.push(xrVar2);
                xrVar.O00000oO = this.O00000Oo;
            }
            this.O00000Oo = xrVar;
            this.O00000o0.O000000o(this.O00000Oo);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e2) {
            throw new RuntimeException(e2);
        }
    }

    public final void O000000o(String str) {
        O00000o0().O000000o(str);
    }

    public final void O00000Oo(String str) {
        O00000o0().O000000o(str);
    }

    private xr O00000o0() {
        xr xrVar = this.O00000Oo;
        if (xrVar != null) {
            return xrVar;
        }
        xs xsVar = (xs) this.O00000o0.O000000o(xs.class);
        if (xsVar != null) {
            return xsVar;
        }
        O000000o(xs.class);
        return this.O00000Oo;
    }

    public final void O000000o(int i, byte[] bArr) {
        this.O00000Oo.O000000o(i, bArr);
    }

    public final void O000000o(int i, xv xvVar) {
        this.O00000Oo.O000000o(i, xvVar);
    }

    public final void O000000o(int i, Rational rational) {
        this.O00000Oo.O000000o(i, rational);
    }

    public final void O000000o(int i, Rational[] rationalArr) {
        this.O00000Oo.O00000Oo(i, rationalArr);
    }

    public final void O000000o(int i, float f) {
        this.O00000Oo.O000000o(i, f);
    }

    public final void O000000o(int i, float[] fArr) {
        this.O00000Oo.O00000Oo(i, fArr);
    }

    public final void O000000o(int i, double d) {
        this.O00000Oo.O000000o(i, d);
    }

    public final void O000000o(int i, double[] dArr) {
        this.O00000Oo.O00000Oo(i, dArr);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.xr.O000000o(int, int):void
     arg types: [int, byte]
     candidates:
      _m_j.xr.O000000o(int, double):void
      _m_j.xr.O000000o(int, float):void
      _m_j.xr.O000000o(int, long):void
      _m_j.xr.O000000o(int, _m_j.xv):void
      _m_j.xr.O000000o(int, java.lang.Object):void
      _m_j.xr.O000000o(int, java.lang.String):void
      _m_j.xr.O000000o(int, boolean):void
      _m_j.xr.O000000o(int, byte[]):void
      _m_j.xr.O000000o(int, int):void */
    public final void O000000o(int i, byte b) {
        this.O00000Oo.O000000o(i, (int) b);
    }

    public final void O00000Oo(int i, byte[] bArr) {
        this.O00000Oo.O000000o(i, bArr);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.xr.O000000o(int, int):void
     arg types: [int, short]
     candidates:
      _m_j.xr.O000000o(int, double):void
      _m_j.xr.O000000o(int, float):void
      _m_j.xr.O000000o(int, long):void
      _m_j.xr.O000000o(int, _m_j.xv):void
      _m_j.xr.O000000o(int, java.lang.Object):void
      _m_j.xr.O000000o(int, java.lang.String):void
      _m_j.xr.O000000o(int, boolean):void
      _m_j.xr.O000000o(int, byte[]):void
      _m_j.xr.O000000o(int, int):void */
    public final void O000000o(int i, short s) {
        this.O00000Oo.O000000o(i, (int) s);
    }

    public final void O000000o(int i, short[] sArr) {
        this.O00000Oo.O00000Oo(i, sArr);
    }

    public final void O000000o(int i, int i2) {
        this.O00000Oo.O000000o(i, i2);
    }

    public final void O00000Oo(int i, short[] sArr) {
        this.O00000Oo.O00000Oo(i, sArr);
    }

    public final void O00000Oo(int i, int i2) {
        this.O00000Oo.O000000o(i, i2);
    }

    public final void O000000o(int i, int[] iArr) {
        this.O00000Oo.O00000Oo(i, iArr);
    }

    public final void O00000o0(int i, int i2) {
        this.O00000Oo.O000000o(i, i2);
    }

    public final void O00000Oo(int i, int[] iArr) {
        this.O00000Oo.O00000Oo(i, iArr);
    }

    public final void O00000Oo(int i, long j) {
        this.O00000Oo.O000000o(i, j);
    }

    public final void O000000o(int i, long[] jArr) {
        this.O00000Oo.O00000Oo(i, jArr);
    }
}
