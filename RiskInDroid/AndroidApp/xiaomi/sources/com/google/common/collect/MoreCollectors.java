package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collector;

@GwtCompatible
@Beta
public final class MoreCollectors {
    private static final Object NULL_PLACEHOLDER = new Object();
    private static final Collector<Object, ?, Object> ONLY_ELEMENT = Collector.of($$Lambda$AW8d5rjde7n52sHHlfKGLys6o4.INSTANCE, $$Lambda$MoreCollectors$oN3vFXc6_LKZJQOgj9PeBSrbA4g.INSTANCE, $$Lambda$T3Z3qL6s2UgnlIibFIHZE8hnQd8.INSTANCE, $$Lambda$MoreCollectors$A6KiO1a0N4DLe0rKqSWOUITsXo.INSTANCE, Collector.Characteristics.UNORDERED);
    private static final Collector<Object, ?, Optional<Object>> TO_OPTIONAL = Collector.of($$Lambda$AW8d5rjde7n52sHHlfKGLys6o4.INSTANCE, $$Lambda$OugZ7uzX1ge93a2UFbU199Ga9uI.INSTANCE, $$Lambda$T3Z3qL6s2UgnlIibFIHZE8hnQd8.INSTANCE, $$Lambda$qKNWqC3OxvkO7x9RxwopFUoEg4.INSTANCE, Collector.Characteristics.UNORDERED);

    public static <T> Collector<T, ?, Optional<T>> toOptional() {
        return TO_OPTIONAL;
    }

    static /* synthetic */ void lambda$static$0(ToOptionalState toOptionalState, Object obj) {
        if (obj == null) {
            obj = NULL_PLACEHOLDER;
        }
        toOptionalState.add(obj);
    }

    static /* synthetic */ Object lambda$static$1(ToOptionalState toOptionalState) {
        Object element = toOptionalState.getElement();
        if (element == NULL_PLACEHOLDER) {
            return null;
        }
        return element;
    }

    public static <T> Collector<T, ?, T> onlyElement() {
        return ONLY_ELEMENT;
    }

    static final class ToOptionalState {
        Object element = null;
        List<Object> extras = null;

        ToOptionalState() {
        }

        /* access modifiers changed from: package-private */
        public final IllegalArgumentException multiples(boolean z) {
            StringBuilder sb = new StringBuilder("expected one element but was: <");
            sb.append(this.element);
            for (Object next : this.extras) {
                sb.append(", ");
                sb.append(next);
            }
            if (z) {
                sb.append(", ...");
            }
            sb.append('>');
            throw new IllegalArgumentException(sb.toString());
        }

        /* access modifiers changed from: package-private */
        public final void add(Object obj) {
            Preconditions.checkNotNull(obj);
            if (this.element == null) {
                this.element = obj;
                return;
            }
            List<Object> list = this.extras;
            if (list == null) {
                this.extras = new ArrayList(4);
                this.extras.add(obj);
            } else if (list.size() < 4) {
                this.extras.add(obj);
            } else {
                throw multiples(true);
            }
        }

        /* access modifiers changed from: package-private */
        public final ToOptionalState combine(ToOptionalState toOptionalState) {
            if (this.element == null) {
                return toOptionalState;
            }
            if (toOptionalState.element == null) {
                return this;
            }
            if (this.extras == null) {
                this.extras = new ArrayList();
            }
            this.extras.add(toOptionalState.element);
            List<Object> list = toOptionalState.extras;
            if (list != null) {
                this.extras.addAll(list);
            }
            if (this.extras.size() <= 4) {
                return this;
            }
            List<Object> list2 = this.extras;
            list2.subList(4, list2.size()).clear();
            throw multiples(true);
        }

        /* access modifiers changed from: package-private */
        public final Optional<Object> getOptional() {
            if (this.extras == null) {
                return Optional.ofNullable(this.element);
            }
            throw multiples(false);
        }

        /* access modifiers changed from: package-private */
        public final Object getElement() {
            Object obj = this.element;
            if (obj == null) {
                throw new NoSuchElementException();
            } else if (this.extras == null) {
                return obj;
            } else {
                throw multiples(false);
            }
        }
    }

    private MoreCollectors() {
    }
}
