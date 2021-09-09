package _m_j;

import java.util.Iterator;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0016\u0018\u0000 \u00172\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0017B\u001f\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0002\u0010\u0006J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002J\b\u0010\u0011\u001a\u00020\u0002H\u0016J\b\u0010\u0012\u001a\u00020\u000eH\u0016J\t\u0010\u0013\u001a\u00020\u0014H\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0016R\u0011\u0010\u0007\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0018"}, d2 = {"Lkotlin/ranges/IntProgression;", "", "", "start", "endInclusive", "step", "(III)V", "first", "getFirst", "()I", "last", "getLast", "getStep", "equals", "", "other", "", "hashCode", "isEmpty", "iterator", "Lkotlin/collections/IntIterator;", "toString", "", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 1, 13})
public class ixp implements ixj, Iterable<Integer> {
    public static final O000000o O00000o = new O000000o((byte) 0);

    /* renamed from: O000000o  reason: collision with root package name */
    public final int f1645O000000o;
    public final int O00000Oo;
    public final int O00000o0;

    public ixp(int i, int i2, int i3) {
        if (i3 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        } else if (i3 != Integer.MIN_VALUE) {
            this.f1645O000000o = i;
            if (i3 > 0) {
                if (i < i2) {
                    i2 -= ivx.O000000o(i2, i, i3);
                }
            } else if (i3 >= 0) {
                throw new IllegalArgumentException("Step is zero.");
            } else if (i > i2) {
                i2 += ivx.O000000o(i, i2, -i3);
            }
            this.O00000Oo = i2;
            this.O00000o0 = i3;
        } else {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
    }

    public boolean O000000o() {
        return this.O00000o0 > 0 ? this.f1645O000000o > this.O00000Oo : this.f1645O000000o < this.O00000Oo;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ixp)) {
            return false;
        }
        if (O000000o() && ((ixp) obj).O000000o()) {
            return true;
        }
        ixp ixp = (ixp) obj;
        return this.f1645O000000o == ixp.f1645O000000o && this.O00000Oo == ixp.O00000Oo && this.O00000o0 == ixp.O00000o0;
    }

    public int hashCode() {
        if (O000000o()) {
            return -1;
        }
        return (((this.f1645O000000o * 31) + this.O00000Oo) * 31) + this.O00000o0;
    }

    public String toString() {
        StringBuilder sb;
        int i;
        if (this.O00000o0 > 0) {
            sb = new StringBuilder();
            sb.append(this.f1645O000000o);
            sb.append("..");
            sb.append(this.O00000Oo);
            sb.append(" step ");
            i = this.O00000o0;
        } else {
            sb = new StringBuilder();
            sb.append(this.f1645O000000o);
            sb.append(" downTo ");
            sb.append(this.O00000Oo);
            sb.append(" step ");
            i = -this.O00000o0;
        }
        sb.append(i);
        return sb.toString();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006¨\u0006\t"}, d2 = {"Lkotlin/ranges/IntProgression$Companion;", "", "()V", "fromClosedRange", "Lkotlin/ranges/IntProgression;", "rangeStart", "", "rangeEnd", "step", "kotlin-stdlib"}, k = 1, mv = {1, 1, 13})
    public static final class O000000o {
        private O000000o() {
        }

        public /* synthetic */ O000000o(byte b) {
            this();
        }
    }

    public /* synthetic */ Iterator iterator() {
        return new ixq(this.f1645O000000o, this.O00000Oo, this.O00000o0);
    }
}
