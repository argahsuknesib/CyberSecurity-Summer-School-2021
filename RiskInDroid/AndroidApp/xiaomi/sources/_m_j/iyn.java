package _m_j;

import _m_j.ixr;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TypeCastException;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010(\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BY\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012:\u0010\b\u001a6\u0012\u0004\u0012\u00020\u0004\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\r0\t¢\u0006\u0002\b\u000e¢\u0006\u0002\u0010\u000fJ\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\u0011H\u0002RB\u0010\b\u001a6\u0012\u0004\u0012\u00020\u0004\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\r0\t¢\u0006\u0002\b\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lkotlin/text/DelimitedRangesSequence;", "Lkotlin/sequences/Sequence;", "Lkotlin/ranges/IntRange;", "input", "", "startIndex", "", "limit", "getNextMatch", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "currentIndex", "Lkotlin/Pair;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/CharSequence;IILkotlin/jvm/functions/Function2;)V", "iterator", "", "kotlin-stdlib"}, k = 1, mv = {1, 1, 13})
public final class iyn implements iyb<ixr> {

    /* renamed from: O000000o  reason: collision with root package name */
    public final CharSequence f1653O000000o;
    public final int O00000Oo = 0;
    public final iwn<CharSequence, Integer, Pair<Integer, Integer>> O00000o;
    public final int O00000o0 = 0;

    /* JADX WARN: Type inference failed for: r4v0, types: [_m_j.iwn<java.lang.CharSequence, java.lang.Integer, kotlin.Pair<java.lang.Integer, java.lang.Integer>>, _m_j.iwn<? super java.lang.CharSequence, ? super java.lang.Integer, kotlin.Pair<java.lang.Integer, java.lang.Integer>>, java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    public iyn(CharSequence charSequence, int i, int i2, iwn<? super CharSequence, ? super Integer, Pair<Integer, Integer>> r4) {
        ixe.O00000o0(charSequence, "input");
        ixe.O00000o0(r4, "getNextMatch");
        this.f1653O000000o = charSequence;
        this.O00000o = r4;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000%\n\u0000\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0017\u001a\u00020\u0018H\u0002J\t\u0010\u0019\u001a\u00020\u001aH\u0002J\t\u0010\u001b\u001a\u00020\u0002H\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0002X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0006\"\u0004\b\u0013\u0010\bR\u001a\u0010\u0014\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0006\"\u0004\b\u0016\u0010\b¨\u0006\u001c"}, d2 = {"kotlin/text/DelimitedRangesSequence$iterator$1", "", "Lkotlin/ranges/IntRange;", "counter", "", "getCounter", "()I", "setCounter", "(I)V", "currentStartIndex", "getCurrentStartIndex", "setCurrentStartIndex", "nextItem", "getNextItem", "()Lkotlin/ranges/IntRange;", "setNextItem", "(Lkotlin/ranges/IntRange;)V", "nextSearchIndex", "getNextSearchIndex", "setNextSearchIndex", "nextState", "getNextState", "setNextState", "calcNext", "", "hasNext", "", "next", "kotlin-stdlib"}, k = 1, mv = {1, 1, 13})
    public static final class O000000o implements ixj, Iterator<ixr> {

        /* renamed from: O000000o  reason: collision with root package name */
        final /* synthetic */ iyn f1654O000000o;
        private int O00000Oo = -1;
        private int O00000o;
        private int O00000o0;
        private ixr O00000oO;
        private int O00000oo;

        public final void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        O000000o(iyn iyn) {
            this.f1654O000000o = iyn;
            int i = iyn.O00000Oo;
            int length = iyn.f1653O000000o.length();
            if (length >= 0) {
                if (i < 0) {
                    i = 0;
                } else if (i > length) {
                    i = length;
                }
                this.O00000o0 = i;
                this.O00000o = this.O00000o0;
                return;
            }
            throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + length + " is less than minimum 0.");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:7:0x001e, code lost:
            if (r7.O00000oo < r7.f1654O000000o.O00000o0) goto L_0x0020;
         */
        private final void O000000o() {
            ixr ixr;
            int i = 0;
            if (this.O00000o < 0) {
                this.O00000Oo = 0;
                this.O00000oO = null;
                return;
            }
            if (this.f1654O000000o.O00000o0 > 0) {
                this.O00000oo++;
            }
            if (this.O00000o <= this.f1654O000000o.f1653O000000o.length()) {
                Pair invoke = this.f1654O000000o.O00000o.invoke(this.f1654O000000o.f1653O000000o, Integer.valueOf(this.O00000o));
                if (invoke == null) {
                    this.O00000oO = new ixr(this.O00000o0, iyo.O00000o(this.f1654O000000o.f1653O000000o));
                    this.O00000o = -1;
                } else {
                    int intValue = ((Number) invoke.first).intValue();
                    int intValue2 = ((Number) invoke.second).intValue();
                    int i2 = this.O00000o0;
                    if (intValue <= Integer.MIN_VALUE) {
                        ixr.O000000o o000000o = ixr.O00000oo;
                        ixr = ixr.O00000oO;
                    } else {
                        ixr = new ixr(i2, intValue - 1);
                    }
                    this.O00000oO = ixr;
                    this.O00000o0 = intValue + intValue2;
                    int i3 = this.O00000o0;
                    if (intValue2 == 0) {
                        i = 1;
                    }
                    this.O00000o = i3 + i;
                }
                this.O00000Oo = 1;
            }
            this.O00000oO = new ixr(this.O00000o0, iyo.O00000o(this.f1654O000000o.f1653O000000o));
            this.O00000o = -1;
            this.O00000Oo = 1;
        }

        public final boolean hasNext() {
            if (this.O00000Oo == -1) {
                O000000o();
            }
            return this.O00000Oo == 1;
        }

        public final /* synthetic */ Object next() {
            if (this.O00000Oo == -1) {
                O000000o();
            }
            if (this.O00000Oo != 0) {
                ixr ixr = this.O00000oO;
                if (ixr != null) {
                    this.O00000oO = null;
                    this.O00000Oo = -1;
                    return ixr;
                }
                throw new TypeCastException("null cannot be cast to non-null type kotlin.ranges.IntRange");
            }
            throw new NoSuchElementException();
        }
    }

    public final Iterator<ixr> O000000o() {
        return new O000000o(this);
    }
}
