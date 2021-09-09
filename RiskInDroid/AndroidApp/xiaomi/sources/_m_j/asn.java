package _m_j;

public final class asn extends aso {
    protected final ajv[] O00000oO;
    protected final String[] O00000oo;

    public final boolean O0000OoO() {
        return false;
    }

    protected asn(Class<?> cls) {
        this(cls, null, null, null, null);
    }

    protected asn(Class<?> cls, String[] strArr, ajv[] ajvArr, Object obj, Object obj2) {
        super(cls, 0, obj, obj2);
        if (strArr == null || strArr.length == 0) {
            this.O00000oo = null;
            this.O00000oO = null;
            return;
        }
        this.O00000oo = strArr;
        this.O00000oO = ajvArr;
    }

    public static asn O0000O0o(Class<?> cls) {
        return new asn(cls, null, null, null, null);
    }

    public final ajv O00000o(Class<?> cls) {
        return new asn(cls, this.O00000oo, this.O00000oO, this.O00000o0, this.O00000o);
    }

    public final ajv O00000oO(Class<?> cls) {
        throw new IllegalArgumentException("Internal error: SimpleType.narrowContentsBy() should never be called");
    }

    public final ajv O00000oo(Class<?> cls) {
        throw new IllegalArgumentException("Internal error: SimpleType.widenContentsBy() should never be called");
    }

    public final ajv O00000Oo(Object obj) {
        throw new IllegalArgumentException("Simple types have no content types; can not call withContenTypeHandler()");
    }

    /* access modifiers changed from: protected */
    public final String O0000oOO() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f12412O000000o.getName());
        ajv[] ajvArr = this.O00000oO;
        if (ajvArr != null && ajvArr.length > 0) {
            sb.append('<');
            boolean z = true;
            for (ajv ajv : this.O00000oO) {
                if (z) {
                    z = false;
                } else {
                    sb.append(',');
                }
                sb.append(ajv.O000000o());
            }
            sb.append('>');
        }
        return sb.toString();
    }

    public final int O0000o() {
        ajv[] ajvArr = this.O00000oO;
        if (ajvArr == null) {
            return 0;
        }
        return ajvArr.length;
    }

    public final ajv O000000o(int i) {
        ajv[] ajvArr;
        if (i < 0 || (ajvArr = this.O00000oO) == null || i >= ajvArr.length) {
            return null;
        }
        return ajvArr[i];
    }

    public final String O00000Oo(int i) {
        String[] strArr;
        if (i < 0 || (strArr = this.O00000oo) == null || i >= strArr.length) {
            return null;
        }
        return strArr[i];
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(40);
        sb.append("[simple type, class ");
        sb.append(O0000oOO());
        sb.append(']');
        return sb.toString();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        asn asn = (asn) obj;
        if (asn.f12412O000000o != this.f12412O000000o) {
            return false;
        }
        ajv[] ajvArr = this.O00000oO;
        ajv[] ajvArr2 = asn.O00000oO;
        if (ajvArr == null) {
            return ajvArr2 == null || ajvArr2.length == 0;
        }
        if (ajvArr2 == null || ajvArr.length != ajvArr2.length) {
            return false;
        }
        int length = ajvArr.length;
        for (int i = 0; i < length; i++) {
            if (!ajvArr[i].equals(ajvArr2[i])) {
                return false;
            }
        }
        return true;
    }

    public final /* synthetic */ ajv O00000o(Object obj) {
        throw new IllegalArgumentException("Simple types have no content types; can not call withContenValueHandler()");
    }

    public final /* synthetic */ ajv O00000o0(Object obj) {
        if (obj == this.O00000o0) {
            return this;
        }
        return new asn(this.f12412O000000o, this.O00000oo, this.O00000oO, obj, this.O00000o);
    }

    public final /* synthetic */ ajv O000000o(Object obj) {
        return new asn(this.f12412O000000o, this.O00000oo, this.O00000oO, this.O00000o0, obj);
    }
}
