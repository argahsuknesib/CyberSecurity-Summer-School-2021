package _m_j;

import java.util.NoSuchElementException;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\b\u001a\u00020\tH\u0002J\b\u0010\r\u001a\u00020\u0003H\u0016R\u000e\u0010\u0007\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u000e"}, d2 = {"Lkotlin/ranges/IntProgressionIterator;", "Lkotlin/collections/IntIterator;", "first", "", "last", "step", "(III)V", "finalElement", "hasNext", "", "next", "getStep", "()I", "nextInt", "kotlin-stdlib"}, k = 1, mv = {1, 1, 13})
public final class ixq extends iva {

    /* renamed from: O000000o  reason: collision with root package name */
    private final int f1646O000000o;
    private boolean O00000Oo;
    private final int O00000o;
    private int O00000o0;

    public ixq(int i, int i2, int i3) {
        this.O00000o = i3;
        this.f1646O000000o = i2;
        boolean z = true;
        if (this.O00000o <= 0 ? i < i2 : i > i2) {
            z = false;
        }
        this.O00000Oo = z;
        this.O00000o0 = !this.O00000Oo ? this.f1646O000000o : i;
    }

    public final boolean hasNext() {
        return this.O00000Oo;
    }

    public final int O000000o() {
        int i = this.O00000o0;
        if (i != this.f1646O000000o) {
            this.O00000o0 = this.O00000o + i;
        } else if (this.O00000Oo) {
            this.O00000Oo = false;
        } else {
            throw new NoSuchElementException();
        }
        return i;
    }
}
