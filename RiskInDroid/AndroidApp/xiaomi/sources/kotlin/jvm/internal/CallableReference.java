package kotlin.jvm.internal;

import _m_j.ixs;
import _m_j.ixu;
import java.io.ObjectStreamException;
import java.io.Serializable;
import kotlin.jvm.KotlinReflectionNotSupportedError;

public abstract class CallableReference implements ixs, Serializable {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final Object f15381O000000o = NoReceiver.f15382O000000o;
    private transient ixs O00000Oo;
    protected final Object receiver;

    /* access modifiers changed from: protected */
    public abstract ixs O000000o();

    static class NoReceiver implements Serializable {

        /* renamed from: O000000o  reason: collision with root package name */
        public static final NoReceiver f15382O000000o = new NoReceiver();

        private NoReceiver() {
        }

        private Object readResolve() throws ObjectStreamException {
            return f15382O000000o;
        }
    }

    public CallableReference() {
        this(f15381O000000o);
    }

    private CallableReference(Object obj) {
        this.receiver = obj;
    }

    public final Object O00000Oo() {
        return this.receiver;
    }

    public final ixs O00000o0() {
        ixs ixs = this.O00000Oo;
        if (ixs != null) {
            return ixs;
        }
        ixs O000000o2 = O000000o();
        this.O00000Oo = O000000o2;
        return O000000o2;
    }

    /* access modifiers changed from: protected */
    public ixs O00000o() {
        ixs O00000o0 = O00000o0();
        if (O00000o0 != this) {
            return O00000o0;
        }
        throw new KotlinReflectionNotSupportedError();
    }

    public ixu O00000oO() {
        throw new AbstractMethodError();
    }

    public String O00000oo() {
        throw new AbstractMethodError();
    }

    public String O0000O0o() {
        throw new AbstractMethodError();
    }

    public final Object O000000o(Object... objArr) {
        return O00000o().O000000o(objArr);
    }
}
