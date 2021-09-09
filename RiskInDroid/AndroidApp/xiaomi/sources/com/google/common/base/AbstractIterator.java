package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Iterator;
import java.util.NoSuchElementException;

@GwtCompatible
abstract class AbstractIterator<T> implements Iterator<T> {
    private T next;
    private State state = State.NOT_READY;

    enum State {
        READY,
        NOT_READY,
        DONE,
        FAILED
    }

    /* access modifiers changed from: protected */
    public abstract T computeNext();

    protected AbstractIterator() {
    }

    /* access modifiers changed from: protected */
    @CanIgnoreReturnValue
    public final T endOfData() {
        this.state = State.DONE;
        return null;
    }

    /* renamed from: com.google.common.base.AbstractIterator$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$common$base$AbstractIterator$State = new int[State.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        static {
            $SwitchMap$com$google$common$base$AbstractIterator$State[State.READY.ordinal()] = 1;
            $SwitchMap$com$google$common$base$AbstractIterator$State[State.DONE.ordinal()] = 2;
        }
    }

    public final boolean hasNext() {
        Preconditions.checkState(this.state != State.FAILED);
        int i = AnonymousClass1.$SwitchMap$com$google$common$base$AbstractIterator$State[this.state.ordinal()];
        if (i == 1) {
            return true;
        }
        if (i != 2) {
            return tryToComputeNext();
        }
        return false;
    }

    private boolean tryToComputeNext() {
        this.state = State.FAILED;
        this.next = computeNext();
        if (this.state == State.DONE) {
            return false;
        }
        this.state = State.READY;
        return true;
    }

    public final T next() {
        if (hasNext()) {
            this.state = State.NOT_READY;
            T t = this.next;
            this.next = null;
            return t;
        }
        throw new NoSuchElementException();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
