package kotlin;

import _m_j.itz;
import _m_j.iug;
import _m_j.iwb;
import _m_j.ixe;
import java.io.Serializable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0002\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00060\u0003j\u0002`\u0004B\u001f\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\bH\u0002R\u0010\u0010\n\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00028\u00008VX\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u0013"}, d2 = {"Lkotlin/SynchronizedLazyImpl;", "T", "Lkotlin/Lazy;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "initializer", "Lkotlin/Function0;", "lock", "", "(Lkotlin/jvm/functions/Function0;Ljava/lang/Object;)V", "_value", "value", "getValue", "()Ljava/lang/Object;", "isInitialized", "", "toString", "", "writeReplace", "kotlin-stdlib"}, k = 1, mv = {1, 1, 13})
public final class SynchronizedLazyImpl<T> implements itz<T>, Serializable {
    private volatile Object _value;
    private iwb<? extends T> initializer;
    private final Object lock;

    public /* synthetic */ SynchronizedLazyImpl(iwb iwb) {
        this(iwb, null);
    }

    public SynchronizedLazyImpl(iwb<? extends T> iwb, Object obj) {
        ixe.O00000o0(iwb, "initializer");
        this.initializer = iwb;
        this._value = iug.f1630O000000o;
        this.lock = obj == null ? this : obj;
    }

    public final T O000000o() {
        T t;
        T t2 = this._value;
        if (t2 != iug.f1630O000000o) {
            return t2;
        }
        synchronized (this.lock) {
            t = this._value;
            if (t == iug.f1630O000000o) {
                iwb iwb = this.initializer;
                if (iwb == null) {
                    ixe.O000000o();
                }
                t = iwb.invoke();
                this._value = t;
                this.initializer = null;
            }
        }
        return t;
    }

    private final Object writeReplace() {
        return new InitializedLazyImpl(O000000o());
    }

    public final String toString() {
        return this._value != iug.f1630O000000o ? String.valueOf(O000000o()) : "Lazy value not initialized yet.";
    }
}
