package _m_j;

import _m_j.ds;
import _m_j.dt;
import android.os.Looper;
import android.util.AndroidRuntimeException;
import android.view.View;
import java.util.ArrayList;

public abstract class dt<T extends dt<T>> implements ds.O00000Oo {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final O00000Oo f14910O000000o = new O00000Oo("translationX") {
        /* class _m_j.dt.AnonymousClass1 */

        public final /* synthetic */ float getValue(Object obj) {
            return ((View) obj).getTranslationX();
        }

        public final /* synthetic */ void setValue(Object obj, float f) {
            ((View) obj).setTranslationX(f);
        }
    };
    public static final O00000Oo O00000Oo = new O00000Oo("translationY") {
        /* class _m_j.dt.AnonymousClass7 */

        public final /* synthetic */ float getValue(Object obj) {
            return ((View) obj).getTranslationY();
        }

        public final /* synthetic */ void setValue(Object obj, float f) {
            ((View) obj).setTranslationY(f);
        }
    };
    public static final O00000Oo O00000o = new O00000Oo("scaleX") {
        /* class _m_j.dt.AnonymousClass9 */

        public final /* synthetic */ float getValue(Object obj) {
            return ((View) obj).getScaleX();
        }

        public final /* synthetic */ void setValue(Object obj, float f) {
            ((View) obj).setScaleX(f);
        }
    };
    public static final O00000Oo O00000o0 = new O00000Oo("translationZ") {
        /* class _m_j.dt.AnonymousClass8 */

        public final /* synthetic */ float getValue(Object obj) {
            return cb.O0000oOo((View) obj);
        }

        public final /* synthetic */ void setValue(Object obj, float f) {
            cb.O0000OoO((View) obj, f);
        }
    };
    public static final O00000Oo O00000oO = new O00000Oo("scaleY") {
        /* class _m_j.dt.AnonymousClass10 */

        public final /* synthetic */ float getValue(Object obj) {
            return ((View) obj).getScaleY();
        }

        public final /* synthetic */ void setValue(Object obj, float f) {
            ((View) obj).setScaleY(f);
        }
    };
    public static final O00000Oo O00000oo = new O00000Oo("rotation") {
        /* class _m_j.dt.AnonymousClass11 */

        public final /* synthetic */ float getValue(Object obj) {
            return ((View) obj).getRotation();
        }

        public final /* synthetic */ void setValue(Object obj, float f) {
            ((View) obj).setRotation(f);
        }
    };
    public static final O00000Oo O0000O0o = new O00000Oo("rotationX") {
        /* class _m_j.dt.AnonymousClass12 */

        public final /* synthetic */ float getValue(Object obj) {
            return ((View) obj).getRotationX();
        }

        public final /* synthetic */ void setValue(Object obj, float f) {
            ((View) obj).setRotationX(f);
        }
    };
    public static final O00000Oo O0000OOo = new O00000Oo("rotationY") {
        /* class _m_j.dt.AnonymousClass13 */

        public final /* synthetic */ float getValue(Object obj) {
            return ((View) obj).getRotationY();
        }

        public final /* synthetic */ void setValue(Object obj, float f) {
            ((View) obj).setRotationY(f);
        }
    };
    public static final O00000Oo O0000Oo = new O00000Oo("y") {
        /* class _m_j.dt.AnonymousClass2 */

        public final /* synthetic */ float getValue(Object obj) {
            return ((View) obj).getY();
        }

        public final /* synthetic */ void setValue(Object obj, float f) {
            ((View) obj).setY(f);
        }
    };
    public static final O00000Oo O0000Oo0 = new O00000Oo("x") {
        /* class _m_j.dt.AnonymousClass14 */

        public final /* synthetic */ float getValue(Object obj) {
            return ((View) obj).getX();
        }

        public final /* synthetic */ void setValue(Object obj, float f) {
            ((View) obj).setX(f);
        }
    };
    public static final O00000Oo O0000OoO = new O00000Oo("z") {
        /* class _m_j.dt.AnonymousClass3 */

        public final /* synthetic */ float getValue(Object obj) {
            return cb.O000O0oo((View) obj);
        }

        public final /* synthetic */ void setValue(Object obj, float f) {
            cb.O0000Ooo((View) obj, f);
        }
    };
    public static final O00000Oo O0000Ooo = new O00000Oo("alpha") {
        /* class _m_j.dt.AnonymousClass4 */

        public final /* synthetic */ float getValue(Object obj) {
            return ((View) obj).getAlpha();
        }

        public final /* synthetic */ void setValue(Object obj, float f) {
            ((View) obj).setAlpha(f);
        }
    };
    public static final O00000Oo O0000o0 = new O00000Oo("scrollY") {
        /* class _m_j.dt.AnonymousClass6 */

        public final /* synthetic */ float getValue(Object obj) {
            return (float) ((View) obj).getScrollY();
        }

        public final /* synthetic */ void setValue(Object obj, float f) {
            ((View) obj).setScrollY((int) f);
        }
    };
    public static final O00000Oo O0000o00 = new O00000Oo("scrollX") {
        /* class _m_j.dt.AnonymousClass5 */

        public final /* synthetic */ float getValue(Object obj) {
            return (float) ((View) obj).getScrollX();
        }

        public final /* synthetic */ void setValue(Object obj, float f) {
            ((View) obj).setScrollX((int) f);
        }
    };
    public boolean O0000o = false;
    float O0000o0O = 0.0f;
    public float O0000o0o = Float.MAX_VALUE;
    final du O0000oO;
    final Object O0000oO0;
    boolean O0000oOO = false;
    float O0000oOo = Float.MAX_VALUE;
    float O0000oo;
    float O0000oo0 = (-this.O0000oOo);
    private long O0000ooO = 0;
    private final ArrayList<Object> O0000ooo = new ArrayList<>();
    private final ArrayList<Object> O00oOooO = new ArrayList<>();

    /* access modifiers changed from: package-private */
    public abstract boolean O00000Oo(long j);

    public static abstract class O00000Oo extends du<View> {
        /* synthetic */ O00000Oo(String str, byte b) {
            this(str);
        }

        private O00000Oo(String str) {
            super(str);
        }
    }

    static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        float f14911O000000o;
        float O00000Oo;

        O000000o() {
        }
    }

    <K> dt(K k, du<K> duVar) {
        this.O0000oO0 = k;
        this.O0000oO = duVar;
        du duVar2 = this.O0000oO;
        if (duVar2 == O00000oo || duVar2 == O0000O0o || duVar2 == O0000OOo) {
            this.O0000oo = 0.1f;
        } else if (duVar2 == O0000Ooo) {
            this.O0000oo = 0.00390625f;
        } else if (duVar2 == O00000o || duVar2 == O00000oO) {
            this.O0000oo = 0.00390625f;
        } else {
            this.O0000oo = 1.0f;
        }
    }

    private static <T> void O000000o(ArrayList arrayList) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (arrayList.get(size) == null) {
                arrayList.remove(size);
            }
        }
    }

    public void O000000o() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            boolean z = this.O0000oOO;
            if (!z && !z) {
                this.O0000oOO = true;
                if (!this.O0000o) {
                    this.O0000o0o = this.O0000oO.getValue(this.O0000oO0);
                }
                float f = this.O0000o0o;
                if (f > this.O0000oOo || f < this.O0000oo0) {
                    throw new IllegalArgumentException("Starting value need to be in between min value and max value");
                }
                ds O000000o2 = ds.O000000o();
                if (O000000o2.O00000o0.size() == 0) {
                    O000000o2.O00000Oo().O000000o();
                }
                if (!O000000o2.O00000o0.contains(this)) {
                    O000000o2.O00000o0.add(this);
                    return;
                }
                return;
            }
            return;
        }
        throw new AndroidRuntimeException("Animations may only be started on the main thread");
    }

    public final void O00000Oo() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new AndroidRuntimeException("Animations may only be canceled on the main thread");
        } else if (this.O0000oOO) {
            O00000o0();
        }
    }

    public final boolean O000000o(long j) {
        long j2 = this.O0000ooO;
        if (j2 == 0) {
            this.O0000ooO = j;
            O000000o(this.O0000o0o);
            return false;
        }
        this.O0000ooO = j;
        boolean O00000Oo2 = O00000Oo(j - j2);
        this.O0000o0o = Math.min(this.O0000o0o, this.O0000oOo);
        this.O0000o0o = Math.max(this.O0000o0o, this.O0000oo0);
        O000000o(this.O0000o0o);
        if (O00000Oo2) {
            O00000o0();
        }
        return O00000Oo2;
    }

    private void O00000o0() {
        this.O0000oOO = false;
        ds.O000000o().O000000o(this);
        this.O0000ooO = 0;
        this.O0000o = false;
        for (int i = 0; i < this.O0000ooo.size(); i++) {
            if (this.O0000ooo.get(i) != null) {
                this.O0000ooo.get(i);
            }
        }
        O000000o(this.O0000ooo);
    }

    private void O000000o(float f) {
        this.O0000oO.setValue(this.O0000oO0, f);
        for (int i = 0; i < this.O00oOooO.size(); i++) {
            if (this.O00oOooO.get(i) != null) {
                this.O00oOooO.get(i);
            }
        }
        O000000o(this.O00oOooO);
    }
}
