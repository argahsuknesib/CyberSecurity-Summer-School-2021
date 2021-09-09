package _m_j;

public final class evc {

    /* renamed from: O000000o  reason: collision with root package name */
    public O00000Oo f15841O000000o;

    /* synthetic */ evc(O00000Oo o00000Oo, byte b) {
        this(o00000Oo);
    }

    private evc(O00000Oo o00000Oo) {
        this.f15841O000000o = o00000Oo;
    }

    public final Boolean O000000o() {
        return Boolean.valueOf(this.f15841O000000o.O0000o00);
    }

    public static class O00000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        public Float f15843O000000o;
        public Integer O00000Oo;
        public Float O00000o;
        public Boolean O00000o0;
        public Integer O00000oO;
        public Integer O00000oo;
        public Boolean O0000O0o;
        public Boolean O0000OOo;
        public Boolean O0000Oo;
        public Boolean O0000Oo0;
        public Boolean O0000OoO;
        public Boolean O0000Ooo;
        public String O0000o;
        public O000000o O0000o0;
        public boolean O0000o00;
        public String O0000o0O;
        public String O0000o0o;
        public String O0000oO;
        public String O0000oO0;
        public String O0000oOO;
        public Float O0000oOo;
        public Float O0000oo;
        public Float O0000oo0;
        public Float O0000ooO;
        public Float O0000ooo;
        public Float O000O00o;
        public Float O000O0OO;
        public Float O000O0Oo;
        public Float O00oOooO;
        public Float O00oOooo;

        private void O00000Oo() {
            Float f = this.f15843O000000o;
            if (f != null && f.floatValue() <= 0.0f) {
                this.f15843O000000o = null;
            }
            Float f2 = this.O00000o;
            if (f2 != null && f2.floatValue() <= 0.0f) {
                this.O00000o = null;
            }
            O000000o o000000o = this.O0000o0;
            if (o000000o != null && !o000000o.f15842O000000o) {
                this.O0000o0 = null;
            }
            O000000o o000000o2 = this.O0000o0;
            if (o000000o2 != null) {
                Boolean bool = o000000o2.O00000oO;
                if (bool == null || !bool.booleanValue()) {
                    O000000o o000000o3 = this.O0000o0;
                    o000000o3.f15842O000000o = true;
                    o000000o3.O00000oo = null;
                    o000000o3.O00000Oo((Float) null);
                }
                Boolean bool2 = this.O0000o0.O0000OOo;
                if (bool2 == null || !bool2.booleanValue()) {
                    this.O0000o0.O00000Oo((Integer) null);
                    this.O0000o0.O00000o(null);
                    this.O0000o0.O00000o0(null);
                }
                if (this.O0000o0.O00000o0 != null && this.O0000o0.O00000o0.floatValue() <= 0.0f) {
                    this.O0000o0.O000000o((Float) null);
                }
            }
            Integer num = this.O00000oo;
            if (num == null) {
                return;
            }
            if (num.intValue() < 0 || this.O00000oo.intValue() > 2) {
                this.O00000oo = null;
            }
        }

        public final evc O000000o() {
            O00000Oo();
            return new evc(this, (byte) 0);
        }
    }

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public boolean f15842O000000o = false;
        public Integer O00000Oo;
        public Float O00000o;
        public Float O00000o0;
        public Boolean O00000oO;
        public Integer O00000oo;
        public Float O0000O0o;
        public Boolean O0000OOo;
        public Float O0000Oo;
        public Integer O0000Oo0;
        public Float O0000OoO;

        public final O000000o O000000o(Integer num) {
            this.f15842O000000o = true;
            this.O00000Oo = num;
            return this;
        }

        public final O000000o O000000o(Float f) {
            this.f15842O000000o = true;
            this.O00000o0 = f;
            return this;
        }

        public final O000000o O00000Oo(Float f) {
            this.f15842O000000o = true;
            this.O0000O0o = f;
            return this;
        }

        public final O000000o O00000o0(Float f) {
            this.f15842O000000o = true;
            this.O0000OoO = f;
            return this;
        }

        public final O000000o O00000Oo(Integer num) {
            this.f15842O000000o = true;
            this.O0000Oo0 = num;
            return this;
        }

        public final O000000o O00000o(Float f) {
            this.f15842O000000o = true;
            this.O0000Oo = f;
            return this;
        }
    }
}
