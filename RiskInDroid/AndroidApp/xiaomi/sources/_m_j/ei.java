package _m_j;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

public abstract class ei {
    public ArrayList<O000000o> O00000o = new ArrayList<>();
    public int O00000oO;
    public int O00000oo;
    public int O0000O0o;
    public int O0000OOo;
    public int O0000Oo;
    public int O0000Oo0;
    public boolean O0000OoO;
    public boolean O0000Ooo = true;
    public CharSequence O0000o;
    public int O0000o0;
    public String O0000o00;
    public CharSequence O0000o0O;
    public int O0000o0o;
    public ArrayList<String> O0000oO;
    public ArrayList<String> O0000oO0;
    public boolean O0000oOO = false;
    ArrayList<Runnable> O0000oOo;

    public abstract int O00000Oo();

    public abstract void O00000o();

    public abstract int O00000o0();

    public abstract void O00000oO();

    public static final class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public int f15307O000000o;
        public Fragment O00000Oo;
        public int O00000o;
        public int O00000o0;
        public int O00000oO;
        public int O00000oo;
        public Lifecycle.State O0000O0o;
        public Lifecycle.State O0000OOo;

        public O000000o() {
        }

        O000000o(int i, Fragment fragment) {
            this.f15307O000000o = i;
            this.O00000Oo = fragment;
            this.O0000O0o = Lifecycle.State.RESUMED;
            this.O0000OOo = Lifecycle.State.RESUMED;
        }

        O000000o(Fragment fragment, Lifecycle.State state) {
            this.f15307O000000o = 10;
            this.O00000Oo = fragment;
            this.O0000O0o = fragment.mMaxState;
            this.O0000OOo = state;
        }
    }

    public final void O00000Oo(O000000o o000000o) {
        this.O00000o.add(o000000o);
        o000000o.O00000o0 = this.O00000oO;
        o000000o.O00000o = this.O00000oo;
        o000000o.O00000oO = this.O0000O0o;
        o000000o.O00000oo = this.O0000OOo;
    }

    public final ei O000000o(Fragment fragment, String str) {
        O000000o(0, fragment, str, 1);
        return this;
    }

    public final ei O000000o(int i, Fragment fragment) {
        O000000o(i, fragment, (String) null, 1);
        return this;
    }

    public final ei O000000o(int i, Fragment fragment, String str) {
        O000000o(i, fragment, str, 1);
        return this;
    }

    /* access modifiers changed from: package-private */
    public void O000000o(int i, Fragment fragment, String str, int i2) {
        Class<?> cls = fragment.getClass();
        int modifiers = cls.getModifiers();
        if (cls.isAnonymousClass() || !Modifier.isPublic(modifiers) || (cls.isMemberClass() && !Modifier.isStatic(modifiers))) {
            throw new IllegalStateException("Fragment " + cls.getCanonicalName() + " must be a public static class to be  properly recreated from instance state.");
        }
        if (str != null) {
            if (fragment.mTag == null || str.equals(fragment.mTag)) {
                fragment.mTag = str;
            } else {
                throw new IllegalStateException("Can't change tag of fragment " + fragment + ": was " + fragment.mTag + " now " + str);
            }
        }
        if (i != 0) {
            if (i == -1) {
                throw new IllegalArgumentException("Can't add fragment " + fragment + " with tag " + str + " to container view with no id");
            } else if (fragment.mFragmentId == 0 || fragment.mFragmentId == i) {
                fragment.mFragmentId = i;
                fragment.mContainerId = i;
            } else {
                throw new IllegalStateException("Can't change container ID of fragment " + fragment + ": was " + fragment.mFragmentId + " now " + i);
            }
        }
        O00000Oo(new O000000o(i2, fragment));
    }

    public final ei O00000Oo(int i, Fragment fragment) {
        return O00000Oo(i, fragment, null);
    }

    public final ei O00000Oo(int i, Fragment fragment, String str) {
        if (i != 0) {
            O000000o(i, fragment, str, 2);
            return this;
        }
        throw new IllegalArgumentException("Must use non-zero containerViewId");
    }

    public ei O000000o(Fragment fragment) {
        O00000Oo(new O000000o(3, fragment));
        return this;
    }

    public ei O00000Oo(Fragment fragment) {
        O00000Oo(new O000000o(4, fragment));
        return this;
    }

    public ei O00000o0(Fragment fragment) {
        O00000Oo(new O000000o(5, fragment));
        return this;
    }

    public ei O00000o(Fragment fragment) {
        O00000Oo(new O000000o(6, fragment));
        return this;
    }

    public final ei O00000oo(Fragment fragment) {
        O00000Oo(new O000000o(7, fragment));
        return this;
    }

    public ei O00000oO(Fragment fragment) {
        O00000Oo(new O000000o(8, fragment));
        return this;
    }

    public ei O000000o(Fragment fragment, Lifecycle.State state) {
        O00000Oo(new O000000o(fragment, state));
        return this;
    }

    public boolean O0000O0o() {
        return this.O00000o.isEmpty();
    }

    public final ei O000000o(int i, int i2) {
        return O000000o(i, i2, 0, 0);
    }

    public final ei O000000o(int i, int i2, int i3, int i4) {
        this.O00000oO = i;
        this.O00000oo = i2;
        this.O0000O0o = i3;
        this.O0000OOo = i4;
        return this;
    }

    public final ei O000000o(String str) {
        if (this.O0000Ooo) {
            this.O0000OoO = true;
            this.O0000o00 = str;
            return this;
        }
        throw new IllegalStateException("This FragmentTransaction is not allowed to be added to the back stack.");
    }

    public final ei O0000OOo() {
        if (!this.O0000OoO) {
            this.O0000Ooo = false;
            return this;
        }
        throw new IllegalStateException("This transaction is already being added to the back stack");
    }

    public final ei O000000o(Runnable runnable) {
        O0000OOo();
        if (this.O0000oOo == null) {
            this.O0000oOo = new ArrayList<>();
        }
        this.O0000oOo.add(runnable);
        return this;
    }
}
