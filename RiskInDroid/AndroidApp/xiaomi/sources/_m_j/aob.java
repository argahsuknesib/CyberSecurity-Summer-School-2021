package _m_j;

import com.fasterxml.jackson.databind.AnnotationIntrospector;

public final class aob extends anu implements Comparable<aob> {

    /* renamed from: O000000o  reason: collision with root package name */
    protected final boolean f12495O000000o;
    protected final AnnotationIntrospector O00000Oo;
    protected final String O00000o;
    protected final String O00000o0;
    protected O000000o<anl> O00000oO;
    protected O000000o<anp> O00000oo;
    protected O000000o<ann> O0000O0o;
    protected O000000o<ann> O0000OOo;

    interface O00000Oo<T> {
        T O000000o(anm anm);
    }

    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        aob aob = (aob) obj;
        if (this.O00000oo != null) {
            if (aob.O00000oo == null) {
                return -1;
            }
        } else if (aob.O00000oo != null) {
            return 1;
        }
        return this.O00000o0.compareTo(aob.O00000o0);
    }

    public aob(String str, AnnotationIntrospector annotationIntrospector, boolean z) {
        this.O00000o = str;
        this.O00000o0 = str;
        this.O00000Oo = annotationIntrospector;
        this.f12495O000000o = z;
    }

    private aob(aob aob, String str) {
        this.O00000o = aob.O00000o;
        this.O00000o0 = str;
        this.O00000Oo = aob.O00000Oo;
        this.O00000oO = aob.O00000oO;
        this.O00000oo = aob.O00000oo;
        this.O0000O0o = aob.O0000O0o;
        this.O0000OOo = aob.O0000OOo;
        this.f12495O000000o = aob.f12495O000000o;
    }

    public final aob O000000o(String str) {
        return new aob(this, str);
    }

    public final String O000000o() {
        return this.O00000o0;
    }

    public final String O0000o0o() {
        return this.O00000o;
    }

    public final boolean O00000Oo() {
        return O00000o(this.O00000oO) || O00000o(this.O0000O0o) || O00000o(this.O0000OOo) || O00000o(this.O00000oo);
    }

    public final boolean O00000o() {
        return this.O0000O0o != null;
    }

    public final boolean O00000oO() {
        return this.O0000OOo != null;
    }

    public final boolean O00000oo() {
        return this.O00000oO != null;
    }

    public final boolean O0000O0o() {
        return this.O00000oo != null;
    }

    public final ann O0000OOo() {
        O000000o<ann> o000000o = this.O0000O0o;
        if (o000000o == null) {
            return null;
        }
        ann ann = (ann) o000000o.f12499O000000o;
        O000000o<T> o000000o2 = this.O0000O0o.O00000Oo;
        while (o000000o2 != null) {
            ann ann2 = (ann) o000000o2.f12499O000000o;
            Class<?> O0000Oo = ann.O0000Oo();
            Class<?> O0000Oo2 = ann2.O0000Oo();
            if (O0000Oo != O0000Oo2) {
                if (O0000Oo.isAssignableFrom(O0000Oo2)) {
                    ann = ann2;
                } else if (O0000Oo2.isAssignableFrom(O0000Oo)) {
                }
                o000000o2 = o000000o2.O00000Oo;
            }
            throw new IllegalArgumentException("Conflicting getter definitions for property \"" + this.O00000o0 + "\": " + ann.O0000Ooo() + " vs " + ann2.O0000Ooo());
        }
        return ann;
    }

    public final ann O0000Oo0() {
        O000000o<ann> o000000o = this.O0000OOo;
        if (o000000o == null) {
            return null;
        }
        ann ann = (ann) o000000o.f12499O000000o;
        O000000o<T> o000000o2 = this.O0000OOo.O00000Oo;
        while (o000000o2 != null) {
            ann ann2 = (ann) o000000o2.f12499O000000o;
            Class<?> O0000Oo = ann.O0000Oo();
            Class<?> O0000Oo2 = ann2.O0000Oo();
            if (O0000Oo != O0000Oo2) {
                if (O0000Oo.isAssignableFrom(O0000Oo2)) {
                    ann = ann2;
                } else if (O0000Oo2.isAssignableFrom(O0000Oo)) {
                }
                o000000o2 = o000000o2.O00000Oo;
            }
            throw new IllegalArgumentException("Conflicting setter definitions for property \"" + this.O00000o0 + "\": " + ann.O0000Ooo() + " vs " + ann2.O0000Ooo());
        }
        return ann;
    }

    public final anl O0000Oo() {
        O000000o<anl> o000000o = this.O00000oO;
        if (o000000o == null) {
            return null;
        }
        anl anl = (anl) o000000o.f12499O000000o;
        O000000o<T> o000000o2 = this.O00000oO.O00000Oo;
        while (o000000o2 != null) {
            anl anl2 = (anl) o000000o2.f12499O000000o;
            Class<?> O0000Oo = anl.O0000Oo();
            Class<?> O0000Oo2 = anl2.O0000Oo();
            if (O0000Oo != O0000Oo2) {
                if (O0000Oo.isAssignableFrom(O0000Oo2)) {
                    anl = anl2;
                } else if (O0000Oo2.isAssignableFrom(O0000Oo)) {
                }
                o000000o2 = o000000o2.O00000Oo;
            }
            throw new IllegalArgumentException("Multiple fields representing property \"" + this.O00000o0 + "\": " + anl.O0000O0o() + " vs " + anl2.O0000O0o());
        }
        return anl;
    }

    public final anm O0000OoO() {
        ann O0000OOo2 = O0000OOo();
        return O0000OOo2 == null ? O0000Oo() : O0000OOo2;
    }

    public final Class<?>[] O0000o00() {
        return (Class[]) O000000o(new O00000Oo<Class<?>[]>() {
            /* class _m_j.aob.AnonymousClass1 */

            public final /* synthetic */ Object O000000o(anm anm) {
                return aob.this.O00000Oo.O00000o((ani) anm);
            }
        });
    }

    public final AnnotationIntrospector.ReferenceProperty O0000o0() {
        return (AnnotationIntrospector.ReferenceProperty) O000000o(new O00000Oo<AnnotationIntrospector.ReferenceProperty>() {
            /* class _m_j.aob.AnonymousClass2 */

            public final /* bridge */ /* synthetic */ Object O000000o(anm anm) {
                return aob.this.O00000Oo.O000000o(anm);
            }
        });
    }

    public final boolean O0000o0O() {
        Boolean bool = (Boolean) O000000o(new O00000Oo<Boolean>() {
            /* class _m_j.aob.AnonymousClass3 */

            public final /* synthetic */ Object O000000o(anm anm) {
                return aob.this.O00000Oo.O00000oo(anm);
            }
        });
        return bool != null && bool.booleanValue();
    }

    public final void O000000o(anl anl, String str, boolean z, boolean z2) {
        this.O00000oO = new O000000o(anl, this.O00000oO, str, z, z2);
    }

    public final void O000000o(anp anp, String str) {
        this.O00000oo = new O000000o(anp, this.O00000oo, str, true, false);
    }

    public final void O000000o(ann ann, String str, boolean z, boolean z2) {
        this.O0000O0o = new O000000o(ann, this.O0000O0o, str, z, z2);
    }

    public final void O00000Oo(ann ann, String str, boolean z, boolean z2) {
        this.O0000OOo = new O000000o(ann, this.O0000OOo, str, z, z2);
    }

    public final void O000000o(aob aob) {
        this.O00000oO = O000000o(this.O00000oO, aob.O00000oO);
        this.O00000oo = O000000o(this.O00000oo, aob.O00000oo);
        this.O0000O0o = O000000o(this.O0000O0o, aob.O0000O0o);
        this.O0000OOo = O000000o(this.O0000OOo, aob.O0000OOo);
    }

    private static <T> O000000o<T> O000000o(O000000o o000000o, O000000o o000000o2) {
        if (o000000o == null) {
            return o000000o2;
        }
        return o000000o2 == null ? o000000o : o000000o.O000000o(o000000o2);
    }

    public final void O0000o() {
        this.O00000oO = O000000o(this.O00000oO);
        this.O0000O0o = O000000o(this.O0000O0o);
        this.O0000OOo = O000000o(this.O0000OOo);
        this.O00000oo = O000000o(this.O00000oo);
    }

    public final void O0000oO0() {
        this.O0000O0o = O00000Oo(this.O0000O0o);
        this.O00000oo = O00000Oo(this.O00000oo);
        if (this.O0000O0o == null) {
            this.O00000oO = O00000Oo(this.O00000oO);
            this.O0000OOo = O00000Oo(this.O0000OOo);
        }
    }

    public final void O0000oO() {
        this.O00000oO = O00000o0(this.O00000oO);
        this.O0000O0o = O00000o0(this.O0000O0o);
        this.O0000OOo = O00000o0(this.O0000OOo);
        this.O00000oo = O00000o0(this.O00000oo);
    }

    public final void O000000o(boolean z) {
        if (z) {
            O000000o<ann> o000000o = this.O0000O0o;
            if (o000000o != null) {
                anr O000000o2 = O000000o(0, o000000o, this.O00000oO, this.O00000oo, this.O0000OOo);
                O000000o<ann> o000000o2 = this.O0000O0o;
                this.O0000O0o = o000000o2.O000000o(((ann) o000000o2.f12499O000000o).O000000o(O000000o2));
                return;
            }
            O000000o<anl> o000000o3 = this.O00000oO;
            if (o000000o3 != null) {
                anr O000000o3 = O000000o(0, o000000o3, this.O00000oo, this.O0000OOo);
                O000000o<anl> o000000o4 = this.O00000oO;
                this.O00000oO = o000000o4.O000000o(((anl) o000000o4.f12499O000000o).O000000o(O000000o3));
                return;
            }
            return;
        }
        O000000o<anp> o000000o5 = this.O00000oo;
        if (o000000o5 != null) {
            anr O000000o4 = O000000o(0, o000000o5, this.O0000OOo, this.O00000oO, this.O0000O0o);
            O000000o<anp> o000000o6 = this.O00000oo;
            this.O00000oo = o000000o6.O000000o(((anp) o000000o6.f12499O000000o).O000000o(O000000o4));
            return;
        }
        O000000o<ann> o000000o7 = this.O0000OOo;
        if (o000000o7 != null) {
            anr O000000o5 = O000000o(0, o000000o7, this.O00000oO, this.O0000O0o);
            O000000o<ann> o000000o8 = this.O0000OOo;
            this.O0000OOo = o000000o8.O000000o(((ann) o000000o8.f12499O000000o).O000000o(O000000o5));
            return;
        }
        O000000o<anl> o000000o9 = this.O00000oO;
        if (o000000o9 != null) {
            anr O000000o6 = O000000o(0, o000000o9, this.O0000O0o);
            O000000o<anl> o000000o10 = this.O00000oO;
            this.O00000oO = o000000o10.O000000o(((anl) o000000o10.f12499O000000o).O000000o(O000000o6));
        }
    }

    private anr O000000o(int i, O000000o<? extends anm>... o000000oArr) {
        anr O00000oO2 = ((anm) o000000oArr[i].f12499O000000o).O00000oO();
        do {
            i++;
            if (i >= o000000oArr.length) {
                return O00000oO2;
            }
        } while (o000000oArr[i] == null);
        return anr.O000000o(O00000oO2, O000000o(i, o000000oArr));
    }

    private static <T> O000000o<T> O000000o(O000000o o000000o) {
        return o000000o == null ? o000000o : o000000o.O000000o();
    }

    private static <T> O000000o<T> O00000Oo(O000000o<T> o000000o) {
        return o000000o == null ? o000000o : o000000o.O00000Oo();
    }

    private static <T> O000000o<T> O00000o0(O000000o<T> o000000o) {
        return o000000o == null ? o000000o : o000000o.O00000o0();
    }

    private static <T> boolean O00000o(O000000o<T> o000000o) {
        while (o000000o != null) {
            if (o000000o.O00000o0 != null && o000000o.O00000o0.length() > 0) {
                return true;
            }
            o000000o = o000000o.O00000Oo;
        }
        return false;
    }

    public final boolean O0000oOO() {
        return O00000oO(this.O00000oO) || O00000oO(this.O0000O0o) || O00000oO(this.O0000OOo) || O00000oO(this.O00000oo);
    }

    private static <T> boolean O00000oO(O000000o<T> o000000o) {
        while (o000000o != null) {
            if (o000000o.O00000o) {
                return true;
            }
            o000000o = o000000o.O00000Oo;
        }
        return false;
    }

    public final boolean O0000oOo() {
        return O00000oo(this.O00000oO) || O00000oo(this.O0000O0o) || O00000oo(this.O0000OOo) || O00000oo(this.O00000oo);
    }

    private static <T> boolean O00000oo(O000000o<T> o000000o) {
        while (o000000o != null) {
            if (o000000o.O00000oO) {
                return true;
            }
            o000000o = o000000o.O00000Oo;
        }
        return false;
    }

    public final String O0000oo0() {
        O000000o<? extends anm> O00000Oo2 = O00000Oo(this.O00000oo, O00000Oo(this.O0000OOo, O00000Oo(this.O0000O0o, O00000Oo(this.O00000oO, null))));
        if (O00000Oo2 == null) {
            return null;
        }
        return O00000Oo2.O00000o0;
    }

    private O000000o<? extends anm> O00000Oo(O000000o<? extends anm> o000000o, O000000o<? extends anm> o000000o2) {
        while (o000000o != null) {
            String str = o000000o.O00000o0;
            if (str != null && !str.equals(this.O00000o0)) {
                if (o000000o2 == null) {
                    o000000o2 = o000000o;
                } else if (!str.equals(o000000o2.O00000o0)) {
                    throw new IllegalStateException("Conflicting property name definitions: '" + o000000o2.O00000o0 + "' (for " + ((Object) o000000o2.f12499O000000o) + ") vs '" + o000000o.O00000o0 + "' (for " + ((Object) o000000o.f12499O000000o) + ")");
                }
            }
            o000000o = o000000o.O00000Oo;
        }
        return o000000o2;
    }

    public final String toString() {
        return "[Property '" + this.O00000o0 + "'; ctors: " + this.O00000oo + ", field(s): " + this.O00000oO + ", getter(s): " + this.O0000O0o + ", setter(s): " + this.O0000OOo + "]";
    }

    private <T> T O000000o(O00000Oo o00000Oo) {
        O000000o<anl> o000000o;
        O000000o<ann> o000000o2;
        T t = null;
        if (this.O00000Oo == null) {
            return null;
        }
        if (this.f12495O000000o) {
            O000000o<ann> o000000o3 = this.O0000O0o;
            if (o000000o3 != null) {
                t = o00000Oo.O000000o((anm) o000000o3.f12499O000000o);
            }
        } else {
            O000000o<anp> o000000o4 = this.O00000oo;
            if (o000000o4 != null) {
                t = o00000Oo.O000000o((anm) o000000o4.f12499O000000o);
            }
            if (t == null && (o000000o2 = this.O0000OOo) != null) {
                t = o00000Oo.O000000o((anm) o000000o2.f12499O000000o);
            }
        }
        return (t != null || (o000000o = this.O00000oO) == null) ? t : o00000Oo.O000000o((anm) o000000o.f12499O000000o);
    }

    static final class O000000o<T> {

        /* renamed from: O000000o  reason: collision with root package name */
        public final T f12499O000000o;
        public final O000000o<T> O00000Oo;
        public final boolean O00000o;
        public final String O00000o0;
        public final boolean O00000oO;

        public O000000o(T t, O000000o<T> o000000o, String str, boolean z, boolean z2) {
            this.f12499O000000o = t;
            this.O00000Oo = o000000o;
            String str2 = null;
            if (!(str == null || str.length() == 0)) {
                str2 = str;
            }
            this.O00000o0 = str2;
            this.O00000o = z;
            this.O00000oO = z2;
        }

        public final O000000o<T> O000000o(T t) {
            if (t == this.f12499O000000o) {
                return this;
            }
            return new O000000o(t, this.O00000Oo, this.O00000o0, this.O00000o, this.O00000oO);
        }

        private O000000o<T> O00000Oo(O000000o<T> o000000o) {
            if (o000000o == this.O00000Oo) {
                return this;
            }
            return new O000000o(this.f12499O000000o, o000000o, this.O00000o0, this.O00000o, this.O00000oO);
        }

        public final O000000o<T> O000000o() {
            O000000o<T> O000000o2;
            O000000o o000000o = this;
            while (o000000o.O00000oO) {
                o000000o = o000000o.O00000Oo;
                if (o000000o == null) {
                    return null;
                }
            }
            O000000o<T> o000000o2 = o000000o.O00000Oo;
            return (o000000o2 == null || (O000000o2 = o000000o2.O000000o()) == o000000o.O00000Oo) ? o000000o : o000000o.O00000Oo(O000000o2);
        }

        public final O000000o<T> O00000Oo() {
            O000000o<T> o000000o = this.O00000Oo;
            O000000o<T> O00000Oo2 = o000000o == null ? null : o000000o.O00000Oo();
            return this.O00000o ? O00000Oo(O00000Oo2) : O00000Oo2;
        }

        public final O000000o<T> O000000o(O000000o<T> o000000o) {
            O000000o<T> o000000o2 = this.O00000Oo;
            if (o000000o2 == null) {
                return O00000Oo(o000000o);
            }
            return O00000Oo(o000000o2.O000000o((O000000o) o000000o));
        }

        public final O000000o<T> O00000o0() {
            O000000o<T> o000000o = this.O00000Oo;
            if (o000000o == null) {
                return this;
            }
            O000000o<T> O00000o02 = o000000o.O00000o0();
            if (this.O00000o0 != null) {
                if (O00000o02.O00000o0 == null) {
                    return O00000Oo(null);
                }
                return O00000Oo(O00000o02);
            } else if (O00000o02.O00000o0 != null) {
                return O00000o02;
            } else {
                boolean z = this.O00000o;
                if (z == O00000o02.O00000o) {
                    return O00000Oo(O00000o02);
                }
                return z ? O00000Oo(null) : O00000o02;
            }
        }

        public final String toString() {
            String str = this.f12499O000000o.toString() + "[visible=" + this.O00000o + "]";
            if (this.O00000Oo == null) {
                return str;
            }
            return str + ", " + this.O00000Oo.toString();
        }
    }

    public final anm O0000Ooo() {
        anp anp;
        O000000o<T> o000000o = this.O00000oo;
        if (o000000o != null) {
            while (true) {
                if (!(((anp) o000000o.f12499O000000o).O0000O0o() instanceof ank)) {
                    o000000o = o000000o.O00000Oo;
                    if (o000000o == null) {
                        anp = (anp) this.O00000oo.f12499O000000o;
                        break;
                    }
                } else {
                    anp = (anp) o000000o.f12499O000000o;
                    break;
                }
            }
        } else {
            anp = null;
        }
        if (anp != null) {
            return anp;
        }
        ann O0000Oo0 = O0000Oo0();
        return O0000Oo0 == null ? O0000Oo() : O0000Oo0;
    }
}
