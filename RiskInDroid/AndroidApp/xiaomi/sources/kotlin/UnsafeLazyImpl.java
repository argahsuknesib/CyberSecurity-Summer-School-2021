package kotlin;

import _m_j.itz;
import _m_j.iug;
import _m_j.iwb;
import _m_j.ixe;
import java.io.Serializable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0000\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00060\u0003j\u0002`\u0004B\u0013\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\tH\u0002R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00028\u00008VX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u0012"}, d2 = {"Lkotlin/UnsafeLazyImpl;", "T", "Lkotlin/Lazy;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "initializer", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)V", "_value", "", "value", "getValue", "()Ljava/lang/Object;", "isInitialized", "", "toString", "", "writeReplace", "kotlin-stdlib"}, k = 1, mv = {1, 1, 13})
public final class UnsafeLazyImpl<T> implements itz<T>, Serializable {
    private Object _value = iug.f1630O000000o;
    private iwb<? extends T> initializer;

    public UnsafeLazyImpl(iwb<? extends T> iwb) {
        ixe.O00000o0(iwb, "initializer");
        this.initializer = iwb;
    }

    public final T O000000o() {
        if (this._value == iug.f1630O000000o) {
            iwb<? extends T> iwb = this.initializer;
            if (iwb == null) {
                ixe.O000000o();
            }
            this._value = iwb.invoke();
            this.initializer = null;
        }
        return this._value;
    }

    private final Object writeReplace() {
        return new InitializedLazyImpl(O000000o());
    }

    public final String toString() {
        return this._value != iug.f1630O000000o ? String.valueOf(O000000o()) : "Lazy value not initialized yet.";
    }
}
