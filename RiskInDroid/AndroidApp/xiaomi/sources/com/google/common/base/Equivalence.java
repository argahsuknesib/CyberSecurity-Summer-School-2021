package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Predicate;
import com.google.errorprone.annotations.ForOverride;
import java.io.Serializable;
import java.util.function.BiPredicate;

@GwtCompatible
public abstract class Equivalence<T> implements BiPredicate<T, T> {
    /* access modifiers changed from: protected */
    @ForOverride
    public abstract boolean doEquivalent(Object obj, Object obj2);

    /* access modifiers changed from: protected */
    @ForOverride
    public abstract int doHash(Object obj);

    protected Equivalence() {
    }

    public final boolean equivalent(T t, T t2) {
        if (t == t2) {
            return true;
        }
        if (t == null || t2 == null) {
            return false;
        }
        return doEquivalent(t, t2);
    }

    @Deprecated
    public final boolean test(T t, T t2) {
        return equivalent(t, t2);
    }

    public final int hash(T t) {
        if (t == null) {
            return 0;
        }
        return doHash(t);
    }

    public final <F> Equivalence<F> onResultOf(Function<F, ? extends T> function) {
        return new FunctionalEquivalence(function, this);
    }

    public final <S extends T> Wrapper<S> wrap(S s) {
        return new Wrapper<>(s);
    }

    public static final class Wrapper<T> implements Serializable {
        private static final long serialVersionUID = 0;
        private final Equivalence<? super T> equivalence;
        private final T reference;

        private Wrapper(Equivalence<? super T> equivalence2, T t) {
            this.equivalence = (Equivalence) Preconditions.checkNotNull(equivalence2);
            this.reference = t;
        }

        public final T get() {
            return this.reference;
        }

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Wrapper)) {
                return false;
            }
            Wrapper wrapper = (Wrapper) obj;
            if (this.equivalence.equals(wrapper.equivalence)) {
                return this.equivalence.equivalent(this.reference, wrapper.reference);
            }
            return false;
        }

        public final int hashCode() {
            return this.equivalence.hash(this.reference);
        }

        public final String toString() {
            return this.equivalence + ".wrap(" + ((Object) this.reference) + ")";
        }
    }

    @GwtCompatible(serializable = true)
    public final <S extends T> Equivalence<Iterable<S>> pairwise() {
        return new PairwiseEquivalence(this);
    }

    public final Predicate<T> equivalentTo(T t) {
        return new EquivalentToPredicate(this, t);
    }

    static final class EquivalentToPredicate<T> implements Predicate<T>, Serializable {
        private static final long serialVersionUID = 0;
        private final Equivalence<T> equivalence;
        private final T target;

        public /* synthetic */ boolean test(T t) {
            return Predicate.CC.$default$test(this, t);
        }

        EquivalentToPredicate(Equivalence<T> equivalence2, T t) {
            this.equivalence = (Equivalence) Preconditions.checkNotNull(equivalence2);
            this.target = t;
        }

        public final boolean apply(T t) {
            return this.equivalence.equivalent(t, this.target);
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof EquivalentToPredicate) {
                EquivalentToPredicate equivalentToPredicate = (EquivalentToPredicate) obj;
                return this.equivalence.equals(equivalentToPredicate.equivalence) && Objects.equal(this.target, equivalentToPredicate.target);
            }
        }

        public final int hashCode() {
            return Objects.hashCode(this.equivalence, this.target);
        }

        public final String toString() {
            return this.equivalence + ".equivalentTo(" + ((Object) this.target) + ")";
        }
    }

    public static Equivalence<Object> equals() {
        return Equals.INSTANCE;
    }

    public static Equivalence<Object> identity() {
        return Identity.INSTANCE;
    }

    static final class Equals extends Equivalence<Object> implements Serializable {
        static final Equals INSTANCE = new Equals();
        private static final long serialVersionUID = 1;

        Equals() {
        }

        /* access modifiers changed from: protected */
        public final boolean doEquivalent(Object obj, Object obj2) {
            return obj.equals(obj2);
        }

        /* access modifiers changed from: protected */
        public final int doHash(Object obj) {
            return obj.hashCode();
        }

        private Object readResolve() {
            return INSTANCE;
        }
    }

    static final class Identity extends Equivalence<Object> implements Serializable {
        static final Identity INSTANCE = new Identity();
        private static final long serialVersionUID = 1;

        /* access modifiers changed from: protected */
        public final boolean doEquivalent(Object obj, Object obj2) {
            return false;
        }

        Identity() {
        }

        /* access modifiers changed from: protected */
        public final int doHash(Object obj) {
            return System.identityHashCode(obj);
        }

        private Object readResolve() {
            return INSTANCE;
        }
    }
}
