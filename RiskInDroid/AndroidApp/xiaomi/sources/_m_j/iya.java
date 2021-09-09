package _m_j;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010(\n\u0000\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B1\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\u0007¢\u0006\u0002\u0010\bJ\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\nH\u0002R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lkotlin/sequences/FilteringSequence;", "T", "Lkotlin/sequences/Sequence;", "sequence", "sendWhen", "", "predicate", "Lkotlin/Function1;", "(Lkotlin/sequences/Sequence;ZLkotlin/jvm/functions/Function1;)V", "iterator", "", "kotlin-stdlib"}, k = 1, mv = {1, 1, 13})
public final class iya<T> implements iyb<T> {

    /* renamed from: O000000o  reason: collision with root package name */
    public final iyb<T> f1648O000000o;
    public final boolean O00000Oo = true;
    public final iwc<T, Boolean> O00000o0;

    public iya(iyb<? extends T> iyb, iwc<? super T, Boolean> iwc) {
        ixe.O00000o0(iyb, "sequence");
        ixe.O00000o0(iwc, "predicate");
        this.f1648O000000o = iyb;
        this.O00000o0 = iwc;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000#\n\u0000\n\u0002\u0010(\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\b\u0010\u0011\u001a\u00020\u0012H\u0002J\t\u0010\u0013\u001a\u00020\u0014H\u0002J\u000e\u0010\u0015\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u0007R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004R\u001e\u0010\u0005\u001a\u0004\u0018\u00018\u0000X\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0016"}, d2 = {"kotlin/sequences/FilteringSequence$iterator$1", "", "iterator", "getIterator", "()Ljava/util/Iterator;", "nextItem", "getNextItem", "()Ljava/lang/Object;", "setNextItem", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "nextState", "", "getNextState", "()I", "setNextState", "(I)V", "calcNext", "", "hasNext", "", "next", "kotlin-stdlib"}, k = 1, mv = {1, 1, 13})
    public static final class O000000o implements ixj, Iterator<T> {

        /* renamed from: O000000o  reason: collision with root package name */
        final /* synthetic */ iya f1649O000000o;
        private final Iterator<T> O00000Oo;
        private T O00000o;
        private int O00000o0 = -1;

        public final void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        O000000o(iya iya) {
            this.f1649O000000o = iya;
            this.O00000Oo = iya.f1648O000000o.O000000o();
        }

        private final void O000000o() {
            while (this.O00000Oo.hasNext()) {
                T next = this.O00000Oo.next();
                if (this.f1649O000000o.O00000o0.invoke(next).booleanValue() == this.f1649O000000o.O00000Oo) {
                    this.O00000o = next;
                    this.O00000o0 = 1;
                    return;
                }
            }
            this.O00000o0 = 0;
        }

        public final T next() {
            if (this.O00000o0 == -1) {
                O000000o();
            }
            if (this.O00000o0 != 0) {
                T t = this.O00000o;
                this.O00000o = null;
                this.O00000o0 = -1;
                return t;
            }
            throw new NoSuchElementException();
        }

        public final boolean hasNext() {
            if (this.O00000o0 == -1) {
                O000000o();
            }
            return this.O00000o0 == 1;
        }
    }

    public final Iterator<T> O000000o() {
        return new O000000o(this);
    }
}
