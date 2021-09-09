package _m_j;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u00032\b\u0012\u0004\u0012\u00020\u00050\u0004B\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0016\u001a\u00020\u0017H\u0002J\t\u0010\u0018\u001a\u00020\u0019H\u0002J\u000e\u0010\u001a\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u001bJ\r\u0010\u001c\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u001bJ\u001e\u0010\u001d\u001a\u00020\u00052\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00050\u001fH\u0016ø\u0001\u0000¢\u0006\u0002\u0010 J\u0019\u0010!\u001a\u00020\u00052\u0006\u0010\"\u001a\u00028\u0000H@ø\u0001\u0000¢\u0006\u0002\u0010#J\u001f\u0010$\u001a\u00020\u00052\f\u0010%\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H@ø\u0001\u0000¢\u0006\u0002\u0010&R\u0014\u0010\u0007\u001a\u00020\b8VX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0016\u0010\u000b\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000R\"\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0012\u0010\u0011\u001a\u0004\u0018\u00018\u0000X\u000e¢\u0006\u0004\n\u0002\u0010\u0012R\u0012\u0010\u0013\u001a\u00060\u0014j\u0002`\u0015X\u000e¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006'"}, d2 = {"Lkotlin/sequences/SequenceBuilderIterator;", "T", "Lkotlin/sequences/SequenceScope;", "", "Lkotlin/coroutines/Continuation;", "", "()V", "context", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "nextIterator", "nextStep", "getNextStep", "()Lkotlin/coroutines/Continuation;", "setNextStep", "(Lkotlin/coroutines/Continuation;)V", "nextValue", "Ljava/lang/Object;", "state", "", "Lkotlin/sequences/State;", "exceptionalState", "", "hasNext", "", "next", "()Ljava/lang/Object;", "nextNotReady", "resumeWith", "result", "Lkotlin/Result;", "(Ljava/lang/Object;)V", "yield", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "yieldAll", "iterator", "(Ljava/util/Iterator;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlin-stdlib"}, k = 1, mv = {1, 1, 13})
final class iyc<T> extends iyd<T> implements ivo<iuh>, ixj, Iterator<T> {

    /* renamed from: O000000o  reason: collision with root package name */
    ivo<? super iuh> f1650O000000o;
    private int O00000Oo;
    private Iterator<? extends T> O00000o;
    private T O00000o0;

    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final boolean hasNext() {
        while (true) {
            int i = this.O00000Oo;
            if (i != 0) {
                if (i == 1) {
                    Iterator<? extends T> it = this.O00000o;
                    if (it == null) {
                        ixe.O000000o();
                    }
                    if (it.hasNext()) {
                        this.O00000Oo = 2;
                        return true;
                    }
                    this.O00000o = null;
                } else if (i == 2 || i == 3) {
                    return true;
                } else {
                    if (i == 4) {
                        return false;
                    }
                    throw O00000Oo();
                }
            }
            this.O00000Oo = 5;
            ivo<? super iuh> ivo = this.f1650O000000o;
            if (ivo == null) {
                ixe.O000000o();
            }
            this.f1650O000000o = null;
            iuh iuh = iuh.f1631O000000o;
            Result.O000000o o000000o = Result.f15374O000000o;
            ivo.O00000Oo(Result.O00000o0(iuh));
        }
    }

    public final T next() {
        do {
            int i = this.O00000Oo;
            if (i != 0 && i != 1) {
                if (i == 2) {
                    this.O00000Oo = 1;
                    Iterator<? extends T> it = this.O00000o;
                    if (it == null) {
                        ixe.O000000o();
                    }
                    return it.next();
                } else if (i == 3) {
                    this.O00000Oo = 0;
                    T t = this.O00000o0;
                    this.O00000o0 = null;
                    return t;
                } else {
                    throw O00000Oo();
                }
            }
        } while (hasNext());
        throw new NoSuchElementException();
    }

    private final Throwable O00000Oo() {
        int i = this.O00000Oo;
        if (i == 4) {
            return new NoSuchElementException();
        }
        if (i == 5) {
            return new IllegalStateException("Iterator has failed.");
        }
        return new IllegalStateException("Unexpected state of the iterator: " + this.O00000Oo);
    }

    public final Object O000000o(T t, ivo<? super iuh> ivo) {
        this.O00000o0 = t;
        this.O00000Oo = 3;
        this.f1650O000000o = ivo;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (coroutineSingletons == CoroutineSingletons.COROUTINE_SUSPENDED) {
            ixe.O00000o0(ivo, "frame");
        }
        return coroutineSingletons;
    }

    public final void O00000Oo(Object obj) {
        this.O00000Oo = 4;
    }

    public final ivq O000000o() {
        return EmptyCoroutineContext.f15379O000000o;
    }
}
