package _m_j;

import _m_j.OO000o0;
import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.StateSet;

@SuppressLint({"RestrictedAPI"})
class OO00OO extends OO000o0 {
    private boolean O00000o;
    private O000000o O00000o0;

    public boolean isStateful() {
        return true;
    }

    OO00OO() {
        this(null, null);
    }

    /* access modifiers changed from: protected */
    public boolean onStateChange(int[] iArr) {
        boolean onStateChange = super.onStateChange(iArr);
        int O00000Oo = this.O00000o0.O00000Oo(iArr);
        if (O00000Oo < 0) {
            O00000Oo = this.O00000o0.O00000Oo(StateSet.WILD_CARD);
        }
        return O000000o(O00000Oo) || onStateChange;
    }

    public Drawable mutate() {
        if (!this.O00000o && super.mutate() == this) {
            this.O00000o0.O000000o();
            this.O00000o = true;
        }
        return this;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: O000000o */
    public O000000o O00000Oo() {
        return new O000000o(this.O00000o0, this, null);
    }

    static class O000000o extends OO000o0.O00000Oo {
        int[][] O000OO;

        O000000o(O000000o o000000o, OO00OO oo00oo, Resources resources) {
            super(o000000o, oo00oo, resources);
            if (o000000o != null) {
                this.O000OO = o000000o.O000OO;
            } else {
                this.O000OO = new int[this.O0000Oo0.length][];
            }
        }

        /* access modifiers changed from: package-private */
        public void O000000o() {
            int[][] iArr = this.O000OO;
            int[][] iArr2 = new int[iArr.length][];
            for (int length = iArr.length - 1; length >= 0; length--) {
                int[][] iArr3 = this.O000OO;
                iArr2[length] = iArr3[length] != null ? (int[]) iArr3[length].clone() : null;
            }
            this.O000OO = iArr2;
        }

        /* access modifiers changed from: package-private */
        public final int O00000Oo(int[] iArr) {
            int[][] iArr2 = this.O000OO;
            int i = this.O0000Oo;
            for (int i2 = 0; i2 < i; i2++) {
                if (StateSet.stateSetMatches(iArr2[i2], iArr)) {
                    return i2;
                }
            }
            return -1;
        }

        public Drawable newDrawable() {
            return new OO00OO(this, null);
        }

        public Drawable newDrawable(Resources resources) {
            return new OO00OO(this, resources);
        }

        public final void O00000Oo(int i, int i2) {
            super.O00000Oo(i, i2);
            int[][] iArr = new int[i2][];
            System.arraycopy(this.O000OO, 0, iArr, 0, i);
            this.O000OO = iArr;
        }
    }

    public void applyTheme(Resources.Theme theme) {
        super.applyTheme(theme);
        onStateChange(getState());
    }

    /* access modifiers changed from: package-private */
    public void O000000o(OO000o0.O00000Oo o00000Oo) {
        super.O000000o(o00000Oo);
        if (o00000Oo instanceof O000000o) {
            this.O00000o0 = (O000000o) o00000Oo;
        }
    }

    OO00OO(O000000o o000000o, Resources resources) {
        O000000o(new O000000o(o000000o, this, resources));
        onStateChange(getState());
    }

    OO00OO(byte b) {
    }
}
