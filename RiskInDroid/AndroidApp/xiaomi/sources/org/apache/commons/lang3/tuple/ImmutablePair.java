package org.apache.commons.lang3.tuple;

public final class ImmutablePair<L, R> extends Pair<L, R> {
    private static final long serialVersionUID = 4954918890077093841L;
    public final L left;
    public final R right;

    public ImmutablePair(L l, R r) {
        this.left = l;
        this.right = r;
    }

    public final L O000000o() {
        return this.left;
    }

    public final R O00000Oo() {
        return this.right;
    }

    public final R setValue(R r) {
        throw new UnsupportedOperationException();
    }
}
