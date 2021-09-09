package _m_j;

import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.DisplayCutout;
import android.view.WindowInsets;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.Objects;

public final class ci {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final ci f13874O000000o = new O000000o().f13875O000000o.O000000o().O00000Oo.O00000oo().O00000Oo.O00000o().O00000Oo.O00000o0();
    public final O0000O0o O00000Oo;

    private ci(WindowInsets windowInsets) {
        if (Build.VERSION.SDK_INT >= 29) {
            this.O00000Oo = new O0000o00(this, windowInsets);
        } else if (Build.VERSION.SDK_INT >= 28) {
            this.O00000Oo = new O0000Oo(this, windowInsets);
        } else if (Build.VERSION.SDK_INT >= 21) {
            this.O00000Oo = new O0000Oo0(this, windowInsets);
        } else if (Build.VERSION.SDK_INT >= 20) {
            this.O00000Oo = new O0000OOo(this, windowInsets);
        } else {
            this.O00000Oo = new O0000O0o(this);
        }
    }

    public ci() {
        this.O00000Oo = new O0000O0o(this);
    }

    public static ci O000000o(WindowInsets windowInsets) {
        return new ci((WindowInsets) bf.O000000o(windowInsets));
    }

    @Deprecated
    public final ci O000000o(int i, int i2, int i3, int i4) {
        return new O000000o(this).O000000o(r.O000000o(i, i2, i3, i4)).f13875O000000o.O000000o();
    }

    public final ci O00000Oo(int i, int i2, int i3, int i4) {
        return this.O00000Oo.O000000o(i, i2, i3, i4);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ci)) {
            return false;
        }
        return bd.O000000o(this.O00000Oo, ((ci) obj).O00000Oo);
    }

    public final int hashCode() {
        O0000O0o o0000O0o = this.O00000Oo;
        if (o0000O0o == null) {
            return 0;
        }
        return o0000O0o.hashCode();
    }

    public final WindowInsets O00000oO() {
        O0000O0o o0000O0o = this.O00000Oo;
        if (o0000O0o instanceof O0000OOo) {
            return ((O0000OOo) o0000O0o).O00000Oo;
        }
        return null;
    }

    public static class O0000O0o {

        /* renamed from: O000000o  reason: collision with root package name */
        final ci f13879O000000o;

        /* access modifiers changed from: package-private */
        public boolean O000000o() {
            return false;
        }

        public boolean O00000Oo() {
            return false;
        }

        /* access modifiers changed from: package-private */
        public bi O00000oO() {
            return null;
        }

        O0000O0o(ci ciVar) {
            this.f13879O000000o = ciVar;
        }

        public ci O00000o0() {
            return this.f13879O000000o;
        }

        public ci O00000o() {
            return this.f13879O000000o;
        }

        public ci O00000oo() {
            return this.f13879O000000o;
        }

        public r O0000O0o() {
            return r.f2418O000000o;
        }

        /* access modifiers changed from: package-private */
        public r O0000OOo() {
            return r.f2418O000000o;
        }

        public r O0000Oo0() {
            return O0000O0o();
        }

        /* access modifiers changed from: package-private */
        public ci O000000o(int i, int i2, int i3, int i4) {
            return ci.f13874O000000o;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof O0000O0o)) {
                return false;
            }
            O0000O0o o0000O0o = (O0000O0o) obj;
            return O000000o() == o0000O0o.O000000o() && O00000Oo() == o0000O0o.O00000Oo() && bd.O000000o(O0000O0o(), o0000O0o.O0000O0o()) && bd.O000000o(O0000OOo(), o0000O0o.O0000OOo()) && bd.O000000o(O00000oO(), o0000O0o.O00000oO());
        }

        public int hashCode() {
            return bd.O000000o(Boolean.valueOf(O000000o()), Boolean.valueOf(O00000Oo()), O0000O0o(), O0000OOo(), O00000oO());
        }
    }

    static class O0000OOo extends O0000O0o {
        final WindowInsets O00000Oo;
        private r O00000o0 = null;

        O0000OOo(ci ciVar, WindowInsets windowInsets) {
            super(ciVar);
            this.O00000Oo = windowInsets;
        }

        /* access modifiers changed from: package-private */
        public boolean O000000o() {
            return this.O00000Oo.isRound();
        }

        /* access modifiers changed from: package-private */
        public final r O0000O0o() {
            if (this.O00000o0 == null) {
                this.O00000o0 = r.O000000o(this.O00000Oo.getSystemWindowInsetLeft(), this.O00000Oo.getSystemWindowInsetTop(), this.O00000Oo.getSystemWindowInsetRight(), this.O00000Oo.getSystemWindowInsetBottom());
            }
            return this.O00000o0;
        }

        /* access modifiers changed from: package-private */
        public ci O000000o(int i, int i2, int i3, int i4) {
            O000000o o000000o = new O000000o(ci.O000000o(this.O00000Oo));
            o000000o.O000000o(ci.O000000o(O0000O0o(), i, i2, i3, i4));
            o000000o.f13875O000000o.O00000Oo(ci.O000000o(O0000OOo(), i, i2, i3, i4));
            return o000000o.f13875O000000o.O000000o();
        }
    }

    static class O0000Oo0 extends O0000OOo {
        private r O00000o0 = null;

        O0000Oo0(ci ciVar, WindowInsets windowInsets) {
            super(ciVar, windowInsets);
        }

        /* access modifiers changed from: package-private */
        public boolean O00000Oo() {
            return this.O00000Oo.isConsumed();
        }

        /* access modifiers changed from: package-private */
        public ci O00000o() {
            return ci.O000000o(this.O00000Oo.consumeStableInsets());
        }

        /* access modifiers changed from: package-private */
        public ci O00000o0() {
            return ci.O000000o(this.O00000Oo.consumeSystemWindowInsets());
        }

        /* access modifiers changed from: package-private */
        public final r O0000OOo() {
            if (this.O00000o0 == null) {
                this.O00000o0 = r.O000000o(this.O00000Oo.getStableInsetLeft(), this.O00000Oo.getStableInsetTop(), this.O00000Oo.getStableInsetRight(), this.O00000Oo.getStableInsetBottom());
            }
            return this.O00000o0;
        }
    }

    static class O0000Oo extends O0000Oo0 {
        O0000Oo(ci ciVar, WindowInsets windowInsets) {
            super(ciVar, windowInsets);
        }

        /* access modifiers changed from: package-private */
        public bi O00000oO() {
            DisplayCutout displayCutout = this.O00000Oo.getDisplayCutout();
            if (displayCutout == null) {
                return null;
            }
            return new bi(displayCutout);
        }

        /* access modifiers changed from: package-private */
        public ci O00000oo() {
            return ci.O000000o(this.O00000Oo.consumeDisplayCutout());
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof O0000Oo)) {
                return false;
            }
            return Objects.equals(this.O00000Oo, ((O0000Oo) obj).O00000Oo);
        }

        public int hashCode() {
            return this.O00000Oo.hashCode();
        }
    }

    static class O0000o00 extends O0000Oo {
        private r O00000o = null;
        private r O00000o0 = null;
        private r O00000oO = null;

        O0000o00(ci ciVar, WindowInsets windowInsets) {
            super(ciVar, windowInsets);
        }

        /* access modifiers changed from: package-private */
        public final r O0000Oo0() {
            if (this.O00000o == null) {
                this.O00000o = r.O000000o(this.O00000Oo.getMandatorySystemGestureInsets());
            }
            return this.O00000o;
        }

        /* access modifiers changed from: package-private */
        public final ci O000000o(int i, int i2, int i3, int i4) {
            return ci.O000000o(this.O00000Oo.inset(i, i2, i3, i4));
        }
    }

    static r O000000o(r rVar, int i, int i2, int i3, int i4) {
        int max = Math.max(0, rVar.O00000Oo - i);
        int max2 = Math.max(0, rVar.O00000o0 - i2);
        int max3 = Math.max(0, rVar.O00000o - i3);
        int max4 = Math.max(0, rVar.O00000oO - i4);
        if (max == i && max2 == i2 && max3 == i3 && max4 == i4) {
            return rVar;
        }
        return r.O000000o(max, max2, max3, max4);
    }

    public static final class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public final O00000Oo f13875O000000o;

        public O000000o() {
            if (Build.VERSION.SDK_INT >= 29) {
                this.f13875O000000o = new O00000o();
            } else if (Build.VERSION.SDK_INT >= 20) {
                this.f13875O000000o = new O00000o0();
            } else {
                this.f13875O000000o = new O00000Oo();
            }
        }

        public O000000o(ci ciVar) {
            if (Build.VERSION.SDK_INT >= 29) {
                this.f13875O000000o = new O00000o(ciVar);
            } else if (Build.VERSION.SDK_INT >= 20) {
                this.f13875O000000o = new O00000o0(ciVar);
            } else {
                this.f13875O000000o = new O00000Oo(ciVar);
            }
        }

        public final O000000o O000000o(r rVar) {
            this.f13875O000000o.O000000o(rVar);
            return this;
        }
    }

    public static class O00000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        private final ci f13876O000000o;

        /* access modifiers changed from: package-private */
        public void O000000o(r rVar) {
        }

        /* access modifiers changed from: package-private */
        public void O00000Oo(r rVar) {
        }

        O00000Oo() {
            this(new ci());
        }

        O00000Oo(ci ciVar) {
            this.f13876O000000o = ciVar;
        }

        public ci O000000o() {
            return this.f13876O000000o;
        }
    }

    static class O00000o0 extends O00000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        private static Field f13878O000000o = null;
        private static boolean O00000Oo = false;
        private static boolean O00000o = false;
        private static Constructor<WindowInsets> O00000o0;
        private WindowInsets O00000oO;

        O00000o0() {
            this.O00000oO = O00000Oo();
        }

        O00000o0(ci ciVar) {
            this.O00000oO = ciVar.O00000oO();
        }

        /* access modifiers changed from: package-private */
        public final void O000000o(r rVar) {
            WindowInsets windowInsets = this.O00000oO;
            if (windowInsets != null) {
                this.O00000oO = windowInsets.replaceSystemWindowInsets(rVar.O00000Oo, rVar.O00000o0, rVar.O00000o, rVar.O00000oO);
            }
        }

        /* access modifiers changed from: package-private */
        public final ci O000000o() {
            return ci.O000000o(this.O00000oO);
        }

        private static WindowInsets O00000Oo() {
            if (!O00000Oo) {
                try {
                    f13878O000000o = WindowInsets.class.getDeclaredField("CONSUMED");
                } catch (ReflectiveOperationException e) {
                    Log.i("WindowInsetsCompat", "Could not retrieve WindowInsets.CONSUMED field", e);
                }
                O00000Oo = true;
            }
            Field field = f13878O000000o;
            if (field != null) {
                try {
                    WindowInsets windowInsets = (WindowInsets) field.get(null);
                    if (windowInsets != null) {
                        return new WindowInsets(windowInsets);
                    }
                } catch (ReflectiveOperationException e2) {
                    Log.i("WindowInsetsCompat", "Could not get value from WindowInsets.CONSUMED field", e2);
                }
            }
            if (!O00000o) {
                try {
                    O00000o0 = WindowInsets.class.getConstructor(Rect.class);
                } catch (ReflectiveOperationException e3) {
                    Log.i("WindowInsetsCompat", "Could not retrieve WindowInsets(Rect) constructor", e3);
                }
                O00000o = true;
            }
            Constructor<WindowInsets> constructor = O00000o0;
            if (constructor != null) {
                try {
                    return constructor.newInstance(new Rect());
                } catch (ReflectiveOperationException e4) {
                    Log.i("WindowInsetsCompat", "Could not invoke WindowInsets(Rect) constructor", e4);
                }
            }
            return null;
        }
    }

    static class O00000o extends O00000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        final WindowInsets.Builder f13877O000000o;

        O00000o() {
            this.f13877O000000o = new WindowInsets.Builder();
        }

        O00000o(ci ciVar) {
            WindowInsets.Builder builder;
            WindowInsets O00000oO = ciVar.O00000oO();
            if (O00000oO != null) {
                builder = new WindowInsets.Builder(O00000oO);
            } else {
                builder = new WindowInsets.Builder();
            }
            this.f13877O000000o = builder;
        }

        /* access modifiers changed from: package-private */
        public final void O000000o(r rVar) {
            this.f13877O000000o.setSystemWindowInsets(rVar.O000000o());
        }

        /* access modifiers changed from: package-private */
        public final void O00000Oo(r rVar) {
            this.f13877O000000o.setStableInsets(rVar.O000000o());
        }

        /* access modifiers changed from: package-private */
        public final ci O000000o() {
            return ci.O000000o(this.f13877O000000o.build());
        }
    }

    public final int O000000o() {
        return this.O00000Oo.O0000O0o().O00000Oo;
    }

    public final int O00000Oo() {
        return this.O00000Oo.O0000O0o().O00000o0;
    }

    public final int O00000o0() {
        return this.O00000Oo.O0000O0o().O00000o;
    }

    public final int O00000o() {
        return this.O00000Oo.O0000O0o().O00000oO;
    }
}
