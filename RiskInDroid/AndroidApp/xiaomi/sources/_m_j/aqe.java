package _m_j;

import java.util.HashMap;

public final class aqe {

    /* renamed from: O000000o  reason: collision with root package name */
    public HashMap<O000000o, ajz<Object>> f12521O000000o = new HashMap<>(64);
    public aqq O00000Oo = null;

    public final aqq O000000o() {
        aqq aqq;
        synchronized (this) {
            aqq = this.O00000Oo;
            if (aqq == null) {
                aqq aqq2 = new aqq(new aqm(this.f12521O000000o));
                this.O00000Oo = aqq2;
                aqq = aqq2;
            }
        }
        return aqq.O000000o();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.aqe.O000000o.<init>(java.lang.Class<?>, boolean):void
     arg types: [java.lang.Class<?>, int]
     candidates:
      _m_j.aqe.O000000o.<init>(_m_j.ajv, boolean):void
      _m_j.aqe.O000000o.<init>(java.lang.Class<?>, boolean):void */
    public final ajz<Object> O000000o(Class<?> cls) {
        ajz<Object> ajz;
        synchronized (this) {
            ajz = this.f12521O000000o.get(new O000000o(cls, false));
        }
        return ajz;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.aqe.O000000o.<init>(_m_j.ajv, boolean):void
     arg types: [_m_j.ajv, int]
     candidates:
      _m_j.aqe.O000000o.<init>(java.lang.Class<?>, boolean):void
      _m_j.aqe.O000000o.<init>(_m_j.ajv, boolean):void */
    public final ajz<Object> O000000o(ajv ajv) {
        ajz<Object> ajz;
        synchronized (this) {
            ajz = this.f12521O000000o.get(new O000000o(ajv, false));
        }
        return ajz;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.aqe.O000000o.<init>(_m_j.ajv, boolean):void
     arg types: [_m_j.ajv, int]
     candidates:
      _m_j.aqe.O000000o.<init>(java.lang.Class<?>, boolean):void
      _m_j.aqe.O000000o.<init>(_m_j.ajv, boolean):void */
    public final ajz<Object> O00000Oo(ajv ajv) {
        ajz<Object> ajz;
        synchronized (this) {
            ajz = this.f12521O000000o.get(new O000000o(ajv, true));
        }
        return ajz;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.aqe.O000000o.<init>(java.lang.Class<?>, boolean):void
     arg types: [java.lang.Class<?>, int]
     candidates:
      _m_j.aqe.O000000o.<init>(_m_j.ajv, boolean):void
      _m_j.aqe.O000000o.<init>(java.lang.Class<?>, boolean):void */
    public final ajz<Object> O00000Oo(Class<?> cls) {
        ajz<Object> ajz;
        synchronized (this) {
            ajz = this.f12521O000000o.get(new O000000o(cls, true));
        }
        return ajz;
    }

    public static final class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        protected int f12522O000000o;
        protected Class<?> O00000Oo;
        protected boolean O00000o;
        protected ajv O00000o0;

        public O000000o(Class<?> cls, boolean z) {
            this.O00000Oo = cls;
            this.O00000o0 = null;
            this.O00000o = z;
            this.f12522O000000o = O000000o(cls, z);
        }

        public O000000o(ajv ajv, boolean z) {
            this.O00000o0 = ajv;
            this.O00000Oo = null;
            this.O00000o = z;
            this.f12522O000000o = O000000o(ajv, z);
        }

        private static final int O000000o(Class<?> cls, boolean z) {
            int hashCode = cls.getName().hashCode();
            return z ? hashCode + 1 : hashCode;
        }

        private static final int O000000o(ajv ajv, boolean z) {
            int hashCode = ajv.hashCode() - 1;
            return z ? hashCode - 1 : hashCode;
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: _m_j.aqe.O000000o.O000000o(java.lang.Class<?>, boolean):int
         arg types: [java.lang.Class<?>, int]
         candidates:
          _m_j.aqe.O000000o.O000000o(_m_j.ajv, boolean):int
          _m_j.aqe.O000000o.O000000o(java.lang.Class<?>, boolean):int */
        public final void O000000o(Class<?> cls) {
            this.O00000o0 = null;
            this.O00000Oo = cls;
            this.O00000o = true;
            this.f12522O000000o = O000000o(cls, true);
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: _m_j.aqe.O000000o.O000000o(java.lang.Class<?>, boolean):int
         arg types: [java.lang.Class<?>, int]
         candidates:
          _m_j.aqe.O000000o.O000000o(_m_j.ajv, boolean):int
          _m_j.aqe.O000000o.O000000o(java.lang.Class<?>, boolean):int */
        public final void O00000Oo(Class<?> cls) {
            this.O00000o0 = null;
            this.O00000Oo = cls;
            this.O00000o = false;
            this.f12522O000000o = O000000o(cls, false);
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: _m_j.aqe.O000000o.O000000o(_m_j.ajv, boolean):int
         arg types: [_m_j.ajv, int]
         candidates:
          _m_j.aqe.O000000o.O000000o(java.lang.Class<?>, boolean):int
          _m_j.aqe.O000000o.O000000o(_m_j.ajv, boolean):int */
        public final void O000000o(ajv ajv) {
            this.O00000o0 = ajv;
            this.O00000Oo = null;
            this.O00000o = true;
            this.f12522O000000o = O000000o(ajv, true);
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: _m_j.aqe.O000000o.O000000o(_m_j.ajv, boolean):int
         arg types: [_m_j.ajv, int]
         candidates:
          _m_j.aqe.O000000o.O000000o(java.lang.Class<?>, boolean):int
          _m_j.aqe.O000000o.O000000o(_m_j.ajv, boolean):int */
        public final void O00000Oo(ajv ajv) {
            this.O00000o0 = ajv;
            this.O00000Oo = null;
            this.O00000o = false;
            this.f12522O000000o = O000000o(ajv, false);
        }

        public final int hashCode() {
            return this.f12522O000000o;
        }

        public final String toString() {
            if (this.O00000Oo != null) {
                return "{class: " + this.O00000Oo.getName() + ", typed? " + this.O00000o + "}";
            }
            return "{type: " + this.O00000o0 + ", typed? " + this.O00000o + "}";
        }

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            O000000o o000000o = (O000000o) obj;
            if (o000000o.O00000o != this.O00000o) {
                return false;
            }
            Class<?> cls = this.O00000Oo;
            if (cls == null) {
                return this.O00000o0.equals(o000000o.O00000o0);
            }
            if (o000000o.O00000Oo == cls) {
                return true;
            }
            return false;
        }
    }
}
