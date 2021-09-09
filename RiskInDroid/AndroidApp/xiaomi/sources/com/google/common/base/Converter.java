package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.ForOverride;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.io.Serializable;
import java.util.Iterator;

@GwtCompatible
public abstract class Converter<A, B> implements Function<A, B> {
    private final boolean handleNullAutomatically;
    @LazyInit
    private transient Converter<B, A> reverse;

    /* access modifiers changed from: protected */
    @ForOverride
    public abstract A doBackward(Object obj);

    /* access modifiers changed from: protected */
    @ForOverride
    public abstract B doForward(Object obj);

    protected Converter() {
        this(true);
    }

    Converter(boolean z) {
        this.handleNullAutomatically = z;
    }

    @CanIgnoreReturnValue
    public final B convert(A a2) {
        return correctedDoForward(a2);
    }

    /* access modifiers changed from: package-private */
    public B correctedDoForward(A a2) {
        if (!this.handleNullAutomatically) {
            return doForward(a2);
        }
        if (a2 == null) {
            return null;
        }
        return Preconditions.checkNotNull(doForward(a2));
    }

    /* access modifiers changed from: package-private */
    public A correctedDoBackward(B b) {
        if (!this.handleNullAutomatically) {
            return doBackward(b);
        }
        if (b == null) {
            return null;
        }
        return Preconditions.checkNotNull(doBackward(b));
    }

    @CanIgnoreReturnValue
    public Iterable<B> convertAll(final Iterable<? extends A> iterable) {
        Preconditions.checkNotNull(iterable, "fromIterable");
        return new Iterable<B>() {
            /* class com.google.common.base.Converter.AnonymousClass1 */

            public Iterator<B> iterator() {
                return new Iterator<B>() {
                    /* class com.google.common.base.Converter.AnonymousClass1.AnonymousClass1 */
                    private final Iterator<? extends A> fromIterator = iterable.iterator();

                    public boolean hasNext() {
                        return this.fromIterator.hasNext();
                    }

                    public B next() {
                        return Converter.this.convert(this.fromIterator.next());
                    }

                    public void remove() {
                        this.fromIterator.remove();
                    }
                };
            }
        };
    }

    @CanIgnoreReturnValue
    public Converter<B, A> reverse() {
        Converter<B, A> converter = this.reverse;
        if (converter != null) {
            return converter;
        }
        ReverseConverter reverseConverter = new ReverseConverter(this);
        this.reverse = reverseConverter;
        return reverseConverter;
    }

    static final class ReverseConverter<A, B> extends Converter<B, A> implements Serializable {
        private static final long serialVersionUID = 0;
        final Converter<A, B> original;

        ReverseConverter(Converter<A, B> converter) {
            this.original = converter;
        }

        /* access modifiers changed from: protected */
        public final A doForward(B b) {
            throw new AssertionError();
        }

        /* access modifiers changed from: protected */
        public final B doBackward(A a2) {
            throw new AssertionError();
        }

        /* access modifiers changed from: package-private */
        public final A correctedDoForward(B b) {
            return this.original.correctedDoBackward(b);
        }

        /* access modifiers changed from: package-private */
        public final B correctedDoBackward(A a2) {
            return this.original.correctedDoForward(a2);
        }

        public final Converter<A, B> reverse() {
            return this.original;
        }

        public final boolean equals(Object obj) {
            if (obj instanceof ReverseConverter) {
                return this.original.equals(((ReverseConverter) obj).original);
            }
            return false;
        }

        public final int hashCode() {
            return this.original.hashCode() ^ -1;
        }

        public final String toString() {
            return this.original + ".reverse()";
        }
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [com.google.common.base.Converter<B, C>, com.google.common.base.Converter] */
    /* JADX WARNING: Unknown variable types count: 1 */
    public final <C> Converter<A, C> andThen(Converter<B, C> r1) {
        return doAndThen(r1);
    }

    /* access modifiers changed from: package-private */
    public <C> Converter<A, C> doAndThen(Converter<B, C> converter) {
        return new ConverterComposition(this, (Converter) Preconditions.checkNotNull(converter));
    }

    static final class ConverterComposition<A, B, C> extends Converter<A, C> implements Serializable {
        private static final long serialVersionUID = 0;
        final Converter<A, B> first;
        final Converter<B, C> second;

        ConverterComposition(Converter<A, B> converter, Converter<B, C> converter2) {
            this.first = converter;
            this.second = converter2;
        }

        /* access modifiers changed from: protected */
        public final C doForward(A a2) {
            throw new AssertionError();
        }

        /* access modifiers changed from: protected */
        public final A doBackward(C c) {
            throw new AssertionError();
        }

        /* access modifiers changed from: package-private */
        public final C correctedDoForward(A a2) {
            return this.second.correctedDoForward(this.first.correctedDoForward(a2));
        }

        /* access modifiers changed from: package-private */
        public final A correctedDoBackward(C c) {
            return this.first.correctedDoBackward(this.second.correctedDoBackward(c));
        }

        public final boolean equals(Object obj) {
            if (obj instanceof ConverterComposition) {
                ConverterComposition converterComposition = (ConverterComposition) obj;
                if (!this.first.equals(converterComposition.first) || !this.second.equals(converterComposition.second)) {
                    return false;
                }
                return true;
            }
            return false;
        }

        public final int hashCode() {
            return (this.first.hashCode() * 31) + this.second.hashCode();
        }

        public final String toString() {
            return this.first + ".andThen(" + this.second + ")";
        }
    }

    @CanIgnoreReturnValue
    @Deprecated
    public final B apply(A a2) {
        return convert(a2);
    }

    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public static <A, B> Converter<A, B> from(Function<? super A, ? extends B> function, Function<? super B, ? extends A> function2) {
        return new FunctionBasedConverter(function, function2);
    }

    static final class FunctionBasedConverter<A, B> extends Converter<A, B> implements Serializable {
        private final Function<? super B, ? extends A> backwardFunction;
        private final Function<? super A, ? extends B> forwardFunction;

        private FunctionBasedConverter(Function<? super A, ? extends B> function, Function<? super B, ? extends A> function2) {
            this.forwardFunction = (Function) Preconditions.checkNotNull(function);
            this.backwardFunction = (Function) Preconditions.checkNotNull(function2);
        }

        /* access modifiers changed from: protected */
        public final B doForward(A a2) {
            return this.forwardFunction.apply(a2);
        }

        /* access modifiers changed from: protected */
        public final A doBackward(B b) {
            return this.backwardFunction.apply(b);
        }

        public final boolean equals(Object obj) {
            if (obj instanceof FunctionBasedConverter) {
                FunctionBasedConverter functionBasedConverter = (FunctionBasedConverter) obj;
                if (!this.forwardFunction.equals(functionBasedConverter.forwardFunction) || !this.backwardFunction.equals(functionBasedConverter.backwardFunction)) {
                    return false;
                }
                return true;
            }
            return false;
        }

        public final int hashCode() {
            return (this.forwardFunction.hashCode() * 31) + this.backwardFunction.hashCode();
        }

        public final String toString() {
            return "Converter.from(" + this.forwardFunction + ", " + this.backwardFunction + ")";
        }
    }

    public static <T> Converter<T, T> identity() {
        return IdentityConverter.INSTANCE;
    }

    static final class IdentityConverter<T> extends Converter<T, T> implements Serializable {
        static final IdentityConverter INSTANCE = new IdentityConverter();
        private static final long serialVersionUID = 0;

        /* access modifiers changed from: protected */
        public final T doBackward(T t) {
            return t;
        }

        /* access modifiers changed from: protected */
        public final T doForward(T t) {
            return t;
        }

        public final IdentityConverter<T> reverse() {
            return this;
        }

        public final String toString() {
            return "Converter.identity()";
        }

        private IdentityConverter() {
        }

        /* access modifiers changed from: package-private */
        public final <S> Converter<T, S> doAndThen(Converter<T, S> converter) {
            return (Converter) Preconditions.checkNotNull(converter, "otherConverter");
        }

        private Object readResolve() {
            return INSTANCE;
        }
    }
}
