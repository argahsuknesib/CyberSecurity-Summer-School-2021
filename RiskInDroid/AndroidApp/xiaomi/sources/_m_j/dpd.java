package _m_j;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import com.tmall.wireless.vaf.framework.VafContext;
import java.util.ArrayList;
import java.util.List;

public abstract class dpd extends dpf {

    /* renamed from: O000000o  reason: collision with root package name */
    protected List<dpf> f14825O000000o = new ArrayList();

    public dpd(VafContext vafContext, dpg dpg) {
        super(vafContext, dpg);
    }

    public O000000o O000000o() {
        return new O000000o();
    }

    public final List<dpf> O00000Oo() {
        return this.f14825O000000o;
    }

    public final void O00000o0() {
        super.O00000o0();
        int size = this.f14825O000000o.size();
        for (int i = 0; i < size; i++) {
            this.f14825O000000o.get(i).O00000o0();
        }
    }

    public final dpf O000000o(String str) {
        dpf O000000o2 = super.O000000o(str);
        if (O000000o2 == null) {
            int size = this.f14825O000000o.size();
            for (int i = 0; i < size; i++) {
                O000000o2 = this.f14825O000000o.get(i).O000000o(str);
                if (O000000o2 != null) {
                    break;
                }
            }
        }
        return O000000o2;
    }

    public final boolean O000000o(int i, int i2) {
        boolean z;
        int size = this.f14825O000000o.size() - 1;
        while (true) {
            if (size < 0) {
                z = false;
                break;
            }
            dpf dpf = this.f14825O000000o.get(size);
            int O00oOooo = dpf.O00oOooo();
            int O000O00o = dpf.O000O00o();
            int comMeasuredWidth = dpf.getComMeasuredWidth();
            int comMeasuredHeight = dpf.getComMeasuredHeight();
            if (i >= O00oOooo && i < O00oOooo + comMeasuredWidth && i2 >= O000O00o && i2 <= O000O00o + comMeasuredHeight) {
                z = dpf.O000000o(i, i2);
                break;
            }
            size--;
        }
        return !z ? super.O000000o(i, i2) : z;
    }

    public final boolean O000000o(int i, int i2, boolean z) {
        boolean z2;
        int size = this.f14825O000000o.size() - 1;
        while (true) {
            if (size < 0) {
                z2 = false;
                break;
            }
            dpf dpf = this.f14825O000000o.get(size);
            int O00oOooo = dpf.O00oOooo();
            int O000O00o = dpf.O000O00o();
            int comMeasuredWidth = dpf.getComMeasuredWidth();
            int comMeasuredHeight = dpf.getComMeasuredHeight();
            if (i >= O00oOooo && i < O00oOooo + comMeasuredWidth && i2 >= O000O00o && i2 <= O000O00o + comMeasuredHeight) {
                z2 = dpf.O000000o(i, i2, z);
                break;
            }
            size--;
        }
        return !z2 ? super.O000000o(i, i2, z) : z2;
    }

    public final void O00000o() {
        super.O00000o();
        int size = this.f14825O000000o.size();
        for (int i = 0; i < size; i++) {
            this.f14825O000000o.get(i).O00000o();
        }
    }

    public void O000000o(Canvas canvas) {
        super.O000000o(canvas);
        int size = this.f14825O000000o.size();
        for (int i = 0; i < size; i++) {
            dpf dpf = this.f14825O000000o.get(i);
            if (dpf.O000O0Oo()) {
                dpf.O000000o(canvas);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void O00000Oo(Canvas canvas) {
        super.O00000Oo(canvas);
        O00000o0(canvas);
    }

    public final void O00000oO() {
        super.O00000oO();
        if (this.O0000Oo0 == null) {
            this.O0000Oo0 = new Paint();
            this.O0000Oo0.setStyle(Paint.Style.FILL);
            this.O0000Oo0.setAntiAlias(true);
        }
    }

    /* access modifiers changed from: protected */
    public final boolean O00000oo() {
        boolean O00000oo = super.O00000oo();
        int size = this.f14825O000000o.size();
        for (int i = 0; i < size; i++) {
            this.f14825O000000o.get(i).O00000oo();
        }
        return O00000oo;
    }

    public final void O000000o(dpf dpf) {
        this.f14825O000000o.add(dpf);
        dpf.O00O0Oo = this;
        dpf.O00000oo();
    }

    /* access modifiers changed from: protected */
    public final void O000000o(dpf dpf, int i, int i2) {
        O000000o O000O0oo = dpf.O000O0oo();
        dpf.measureComponent(O000000o(i, this.O000O0oo + this.O000OO00 + (this.O0000o0 << 1) + O000O0oo.O00000o + O000O0oo.O00000oo, O000O0oo.f14826O000000o), O000000o(i2, this.O000OO0o + this.O000OO + (this.O0000o0 << 1) + O000O0oo.O0000OOo + O000O0oo.O0000Oo, O000O0oo.O00000Oo));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0036, code lost:
        if (r7 == -2) goto L_0x0033;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0021, code lost:
        if (r7 == -2) goto L_0x0033;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x002a, code lost:
        if (r7 == -2) goto L_0x003a;
     */
    public static int O000000o(int i, int i2, int i3) {
        int mode = View.MeasureSpec.getMode(i);
        int max = Math.max(0, View.MeasureSpec.getSize(i) - i2);
        int i4 = 1073741824;
        if (mode != Integer.MIN_VALUE) {
            if (mode != 0) {
                if (mode == 1073741824) {
                    if (i3 < 0) {
                        if (i3 != -1) {
                        }
                        return View.MeasureSpec.makeMeasureSpec(max, i4);
                    }
                }
                max = 0;
                i4 = 0;
                return View.MeasureSpec.makeMeasureSpec(max, i4);
            } else if (i3 < 0) {
                if (i3 != -1) {
                }
                i4 = 0;
                return View.MeasureSpec.makeMeasureSpec(max, i4);
            }
        } else if (i3 < 0) {
            if (i3 != -1) {
            }
            i4 = Integer.MIN_VALUE;
            return View.MeasureSpec.makeMeasureSpec(max, i4);
        }
        max = i3;
        return View.MeasureSpec.makeMeasureSpec(max, i4);
    }

    /* access modifiers changed from: protected */
    public boolean O000000o(int i, float f) {
        boolean O000000o2 = super.O000000o(i, f);
        if (!O000000o2) {
            return false;
        }
        return O000000o2;
    }

    /* access modifiers changed from: protected */
    public boolean O00000Oo(int i, float f) {
        boolean O00000Oo = super.O00000Oo(i, f);
        if (!O00000Oo) {
            return false;
        }
        return O00000Oo;
    }

    /* access modifiers changed from: protected */
    public boolean O00000Oo(int i, int i2) {
        boolean O00000Oo = super.O00000Oo(i, i2);
        if (!O00000Oo) {
            return false;
        }
        return O00000Oo;
    }

    /* access modifiers changed from: protected */
    public boolean O00000o0(int i, int i2) {
        boolean O00000o0 = super.O00000o0(i, i2);
        if (!O00000o0) {
            return false;
        }
        return O00000o0;
    }

    /* access modifiers changed from: protected */
    public boolean O000000o(int i, String str) {
        boolean O000000o2 = super.O000000o(i, str);
        if (!O000000o2) {
            return false;
        }
        return O000000o2;
    }

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public int f14826O000000o = 0;
        public int O00000Oo = 0;
        public int O00000o = 0;
        public int O00000o0;
        protected boolean O00000oO;
        public int O00000oo = 0;
        protected boolean O0000O0o;
        public int O0000OOo = 0;
        public int O0000Oo = 0;
        protected boolean O0000Oo0;
        protected boolean O0000OoO;

        public final boolean O000000o(int i, float f) {
            switch (i) {
                case -2037919555:
                    this.O0000OOo = bns.O000000o((double) f);
                    this.O0000Oo0 = true;
                    return true;
                case 62363524:
                    this.O00000oo = bns.O000000o((double) f);
                    this.O0000O0o = true;
                    return true;
                case 1248755103:
                    this.O00000o = bns.O000000o((double) f);
                    this.O00000oO = true;
                    return true;
                case 1481142723:
                    this.O0000Oo = bns.O000000o((double) f);
                    this.O0000OoO = true;
                    return true;
                case 1557524721:
                    this.O00000Oo = bns.O000000o((double) f);
                    return true;
                case 1697244536:
                    this.O00000o0 = bns.O000000o((double) f);
                    if (!this.O00000oO) {
                        this.O00000o = this.O00000o0;
                    }
                    if (!this.O0000O0o) {
                        this.O00000oo = this.O00000o0;
                    }
                    if (!this.O0000Oo0) {
                        this.O0000OOo = this.O00000o0;
                    }
                    if (this.O0000OoO) {
                        return true;
                    }
                    this.O0000Oo = this.O00000o0;
                    return true;
                case 2003872956:
                    this.f14826O000000o = bns.O000000o((double) f);
                    return true;
                default:
                    return false;
            }
        }

        public boolean O00000Oo(int i, float f) {
            switch (i) {
                case -2037919555:
                    this.O0000OOo = bns.O00000Oo((double) f);
                    this.O0000Oo0 = true;
                    return true;
                case 62363524:
                    this.O00000oo = bns.O00000Oo((double) f);
                    this.O0000O0o = true;
                    return true;
                case 1248755103:
                    this.O00000o = bns.O00000Oo((double) f);
                    this.O00000oO = true;
                    return true;
                case 1481142723:
                    this.O0000Oo = bns.O00000Oo((double) f);
                    this.O0000OoO = true;
                    return true;
                case 1557524721:
                    if (f > 0.0f) {
                        this.O00000Oo = bns.O00000Oo((double) f);
                        return true;
                    }
                    this.O00000Oo = (int) f;
                    return true;
                case 1697244536:
                    this.O00000o0 = bns.O00000Oo((double) f);
                    if (!this.O00000oO) {
                        this.O00000o = this.O00000o0;
                    }
                    if (!this.O0000O0o) {
                        this.O00000oo = this.O00000o0;
                    }
                    if (!this.O0000Oo0) {
                        this.O0000OOo = this.O00000o0;
                    }
                    if (this.O0000OoO) {
                        return true;
                    }
                    this.O0000Oo = this.O00000o0;
                    return true;
                case 2003872956:
                    if (f > 0.0f) {
                        this.f14826O000000o = bns.O00000Oo((double) f);
                        return true;
                    }
                    this.f14826O000000o = (int) f;
                    return true;
                default:
                    return false;
            }
        }

        public final boolean O000000o(int i, int i2) {
            switch (i) {
                case -2037919555:
                    this.O0000OOo = bns.O000000o((double) i2);
                    this.O0000Oo0 = true;
                    return true;
                case 62363524:
                    this.O00000oo = bns.O000000o((double) i2);
                    this.O0000O0o = true;
                    return true;
                case 1248755103:
                    this.O00000o = bns.O000000o((double) i2);
                    this.O00000oO = true;
                    return true;
                case 1481142723:
                    this.O0000Oo = bns.O000000o((double) i2);
                    this.O0000OoO = true;
                    return true;
                case 1557524721:
                    this.O00000Oo = bns.O000000o((double) i2);
                    return true;
                case 1697244536:
                    this.O00000o0 = bns.O000000o((double) i2);
                    if (!this.O00000oO) {
                        this.O00000o = this.O00000o0;
                    }
                    if (!this.O0000O0o) {
                        this.O00000oo = this.O00000o0;
                    }
                    if (!this.O0000Oo0) {
                        this.O0000OOo = this.O00000o0;
                    }
                    if (this.O0000OoO) {
                        return true;
                    }
                    this.O0000Oo = this.O00000o0;
                    return true;
                case 2003872956:
                    this.f14826O000000o = bns.O000000o((double) i2);
                    return true;
                default:
                    return false;
            }
        }

        public boolean O00000Oo(int i, int i2) {
            switch (i) {
                case -2037919555:
                    this.O0000OOo = bns.O00000Oo((double) i2);
                    this.O0000Oo0 = true;
                    return true;
                case 62363524:
                    this.O00000oo = bns.O00000Oo((double) i2);
                    this.O0000O0o = true;
                    return true;
                case 1248755103:
                    this.O00000o = bns.O00000Oo((double) i2);
                    this.O00000oO = true;
                    return true;
                case 1481142723:
                    this.O0000Oo = bns.O00000Oo((double) i2);
                    this.O0000OoO = true;
                    return true;
                case 1557524721:
                    if (i2 > 0) {
                        this.O00000Oo = bns.O00000Oo((double) i2);
                        return true;
                    }
                    this.O00000Oo = i2;
                    return true;
                case 1697244536:
                    this.O00000o0 = bns.O00000Oo((double) i2);
                    if (!this.O00000oO) {
                        this.O00000o = this.O00000o0;
                    }
                    if (!this.O0000O0o) {
                        this.O00000oo = this.O00000o0;
                    }
                    if (!this.O0000Oo0) {
                        this.O0000OOo = this.O00000o0;
                    }
                    if (this.O0000OoO) {
                        return true;
                    }
                    this.O0000Oo = this.O00000o0;
                    return true;
                case 2003872956:
                    if (i2 > 0) {
                        this.f14826O000000o = bns.O00000Oo((double) i2);
                        return true;
                    }
                    this.f14826O000000o = i2;
                    return true;
                default:
                    return false;
            }
        }
    }
}
