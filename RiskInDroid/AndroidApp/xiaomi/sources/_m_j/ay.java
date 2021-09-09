package _m_j;

import com.google.android.gms.common.internal.GmsLogger;
import java.util.Locale;

public final class ay {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final ax f12694O000000o = new O0000O0o(null, false);
    public static final ax O00000Oo = new O0000O0o(null, true);
    public static final ax O00000o = new O0000O0o(O00000Oo.f12696O000000o, true);
    public static final ax O00000o0 = new O0000O0o(O00000Oo.f12696O000000o, false);
    public static final ax O00000oO = new O0000O0o(O000000o.f12695O000000o, false);
    public static final ax O00000oo = O0000OOo.f12699O000000o;

    interface O00000o0 {
        int O000000o(CharSequence charSequence, int i, int i2);
    }

    static int O000000o(int i) {
        if (i != 0) {
            return (i == 1 || i == 2) ? 0 : 2;
        }
        return 1;
    }

    static int O00000Oo(int i) {
        if (i != 0) {
            if (i == 1 || i == 2) {
                return 0;
            }
            switch (i) {
                case 14:
                case GmsLogger.MAX_PII_TAG_LENGTH:
                    break;
                case 16:
                case 17:
                    return 0;
                default:
                    return 2;
            }
        }
        return 1;
    }

    static abstract class O00000o implements ax {

        /* renamed from: O000000o  reason: collision with root package name */
        private final O00000o0 f12697O000000o;

        /* access modifiers changed from: protected */
        public abstract boolean O000000o();

        O00000o(O00000o0 o00000o0) {
            this.f12697O000000o = o00000o0;
        }

        public final boolean O000000o(CharSequence charSequence, int i) {
            if (charSequence == null || i < 0 || charSequence.length() - i < 0) {
                throw new IllegalArgumentException();
            }
            O00000o0 o00000o0 = this.f12697O000000o;
            if (o00000o0 == null) {
                return O000000o();
            }
            int O000000o2 = o00000o0.O000000o(charSequence, 0, i);
            if (O000000o2 == 0) {
                return true;
            }
            if (O000000o2 != 1) {
                return O000000o();
            }
            return false;
        }
    }

    static class O0000O0o extends O00000o {

        /* renamed from: O000000o  reason: collision with root package name */
        private final boolean f12698O000000o;

        O0000O0o(O00000o0 o00000o0, boolean z) {
            super(o00000o0);
            this.f12698O000000o = z;
        }

        /* access modifiers changed from: protected */
        public final boolean O000000o() {
            return this.f12698O000000o;
        }
    }

    static class O00000Oo implements O00000o0 {

        /* renamed from: O000000o  reason: collision with root package name */
        static final O00000Oo f12696O000000o = new O00000Oo();

        public final int O000000o(CharSequence charSequence, int i, int i2) {
            int i3 = i2 + 0;
            int i4 = 2;
            for (int i5 = 0; i5 < i3 && i4 == 2; i5++) {
                i4 = ay.O00000Oo(Character.getDirectionality(charSequence.charAt(i5)));
            }
            return i4;
        }

        private O00000Oo() {
        }
    }

    static class O000000o implements O00000o0 {

        /* renamed from: O000000o  reason: collision with root package name */
        static final O000000o f12695O000000o = new O000000o();
        private final boolean O00000Oo = true;

        public final int O000000o(CharSequence charSequence, int i, int i2) {
            int i3 = i2 + 0;
            boolean z = false;
            for (int i4 = 0; i4 < i3; i4++) {
                int O000000o2 = ay.O000000o(Character.getDirectionality(charSequence.charAt(i4)));
                if (O000000o2 != 0) {
                    if (O000000o2 != 1) {
                        continue;
                    } else if (!this.O00000Oo) {
                        return 1;
                    }
                } else if (this.O00000Oo) {
                    return 0;
                }
                z = true;
            }
            if (z) {
                return this.O00000Oo ? 1 : 0;
            }
            return 2;
        }

        private O000000o() {
        }
    }

    static class O0000OOo extends O00000o {

        /* renamed from: O000000o  reason: collision with root package name */
        static final O0000OOo f12699O000000o = new O0000OOo();

        O0000OOo() {
            super(null);
        }

        /* access modifiers changed from: protected */
        public final boolean O000000o() {
            return az.O000000o(Locale.getDefault()) == 1;
        }
    }
}
