package _m_j;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import java.util.Collection;

public final class aou implements aoh<aou> {

    /* renamed from: O000000o  reason: collision with root package name */
    protected JsonTypeInfo.Id f12507O000000o;
    protected JsonTypeInfo.As O00000Oo;
    protected boolean O00000o = false;
    protected String O00000o0;
    protected Class<?> O00000oO;
    protected aog O00000oo;

    public static aou O00000Oo() {
        return new aou().O000000o(JsonTypeInfo.Id.NONE, null);
    }

    /* access modifiers changed from: private */
    /* renamed from: O00000Oo */
    public aou O000000o(JsonTypeInfo.Id id, aog aog) {
        if (id != null) {
            this.f12507O000000o = id;
            this.O00000oo = aog;
            this.O00000o0 = id.getDefaultPropertyName();
            return this;
        }
        throw new IllegalArgumentException("idType can not be null");
    }

    public final aoi O000000o(ake ake, ajv ajv, Collection<aod> collection) {
        if (this.f12507O000000o == JsonTypeInfo.Id.NONE) {
            return null;
        }
        aog O000000o2 = O000000o(ake, ajv, collection, true, false);
        int i = AnonymousClass1.f12508O000000o[this.O00000Oo.ordinal()];
        if (i == 1) {
            return new aok(O000000o2, null);
        }
        if (i == 2) {
            return new aoo(O000000o2, null, this.O00000o0);
        }
        if (i == 3) {
            return new aoq(O000000o2, null);
        }
        if (i == 4) {
            return new aom(O000000o2, null, this.O00000o0);
        }
        throw new IllegalStateException("Do not know how to construct standard type serializer for inclusion type: " + this.O00000Oo);
    }

    public final aof O000000o(ajs ajs, ajv ajv, Collection<aod> collection) {
        if (this.f12507O000000o == JsonTypeInfo.Id.NONE) {
            return null;
        }
        aog O000000o2 = O000000o(ajs, ajv, collection, false, true);
        int i = AnonymousClass1.f12508O000000o[this.O00000Oo.ordinal()];
        if (i == 1) {
            return new aoj(ajv, O000000o2, this.O00000o0, this.O00000o, this.O00000oO);
        } else if (i == 2) {
            return new aon(ajv, O000000o2, this.O00000o0, this.O00000o, this.O00000oO);
        } else if (i == 3) {
            return new aop(ajv, O000000o2, this.O00000o0, this.O00000o);
        } else {
            if (i == 4) {
                return new aol(ajv, O000000o2, this.O00000o0, this.O00000o, this.O00000oO);
            }
            throw new IllegalStateException("Do not know how to construct standard type serializer for inclusion type: " + this.O00000Oo);
        }
    }

    public final Class<?> O000000o() {
        return this.O00000oO;
    }

    private aog O000000o(akr<?> akr, ajv ajv, Collection<aod> collection, boolean z, boolean z2) {
        aog aog = this.O00000oo;
        if (aog != null) {
            return aog;
        }
        if (this.f12507O000000o != null) {
            int i = AnonymousClass1.O00000Oo[this.f12507O000000o.ordinal()];
            if (i == 1) {
                return new aor(ajv, akr.O0000o0());
            }
            if (i == 2) {
                return new aos(ajv, akr.O0000o0());
            }
            if (i == 3) {
                return aox.O000000o(akr, ajv, collection, z, z2);
            }
            if (i == 4) {
                return null;
            }
            throw new IllegalStateException("Do not know how to construct standard type id resolver for idType: " + this.f12507O000000o);
        }
        throw new IllegalStateException("Can not build, 'init()' not yet called");
    }

    /* renamed from: _m_j.aou$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: O000000o  reason: collision with root package name */
        static final /* synthetic */ int[] f12508O000000o = new int[JsonTypeInfo.As.values().length];
        static final /* synthetic */ int[] O00000Oo = new int[JsonTypeInfo.Id.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(21:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|13|14|15|16|17|19|20|21|22|23|24|25|26|28) */
        /* JADX WARNING: Can't wrap try/catch for region: R(22:0|1|2|3|(2:5|6)|7|(2:9|10)|11|13|14|15|16|17|19|20|21|22|23|24|25|26|28) */
        /* JADX WARNING: Can't wrap try/catch for region: R(23:0|1|2|3|5|6|7|(2:9|10)|11|13|14|15|16|17|19|20|21|22|23|24|25|26|28) */
        /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0035 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0053 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x005d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0067 */
        static {
            try {
                O00000Oo[JsonTypeInfo.Id.CLASS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                O00000Oo[JsonTypeInfo.Id.MINIMAL_CLASS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                O00000Oo[JsonTypeInfo.Id.NAME.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            O00000Oo[JsonTypeInfo.Id.NONE.ordinal()] = 4;
            O00000Oo[JsonTypeInfo.Id.CUSTOM.ordinal()] = 5;
            f12508O000000o[JsonTypeInfo.As.WRAPPER_ARRAY.ordinal()] = 1;
            f12508O000000o[JsonTypeInfo.As.PROPERTY.ordinal()] = 2;
            f12508O000000o[JsonTypeInfo.As.WRAPPER_OBJECT.ordinal()] = 3;
            f12508O000000o[JsonTypeInfo.As.EXTERNAL_PROPERTY.ordinal()] = 4;
        }
    }

    public final /* bridge */ /* synthetic */ aoh O000000o(boolean z) {
        this.O00000o = z;
        return this;
    }

    public final /* bridge */ /* synthetic */ aoh O000000o(Class cls) {
        this.O00000oO = cls;
        return this;
    }

    public final /* synthetic */ aoh O000000o(String str) {
        if (str == null || str.length() == 0) {
            str = this.f12507O000000o.getDefaultPropertyName();
        }
        this.O00000o0 = str;
        return this;
    }

    public final /* synthetic */ aoh O000000o(JsonTypeInfo.As as) {
        if (as != null) {
            this.O00000Oo = as;
            return this;
        }
        throw new IllegalArgumentException("includeAs can not be null");
    }
}
