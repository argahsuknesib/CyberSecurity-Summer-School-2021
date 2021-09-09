package com.google.common.graph;

import com.google.common.annotations.Beta;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import com.google.common.collect.Ordering;
import com.google.errorprone.annotations.Immutable;
import java.util.Comparator;
import java.util.Map;

@Immutable
@Beta
public final class ElementOrder<T> {
    private final Comparator<T> comparator;
    private final Type type;

    public enum Type {
        UNORDERED,
        INSERTION,
        SORTED
    }

    /* access modifiers changed from: package-private */
    public final <T1 extends T> ElementOrder<T1> cast() {
        return this;
    }

    private ElementOrder(Type type2, Comparator<T> comparator2) {
        this.type = (Type) Preconditions.checkNotNull(type2);
        this.comparator = comparator2;
        Preconditions.checkState((type2 == Type.SORTED) != (comparator2 != null) ? false : true);
    }

    public static <S> ElementOrder<S> unordered() {
        return new ElementOrder<>(Type.UNORDERED, null);
    }

    public static <S> ElementOrder<S> insertion() {
        return new ElementOrder<>(Type.INSERTION, null);
    }

    public static <S extends Comparable<? super S>> ElementOrder<S> natural() {
        return new ElementOrder<>(Type.SORTED, Ordering.natural());
    }

    public static <S> ElementOrder<S> sorted(Comparator<S> comparator2) {
        return new ElementOrder<>(Type.SORTED, comparator2);
    }

    public final Type type() {
        return this.type;
    }

    public final Comparator<T> comparator() {
        Comparator<T> comparator2 = this.comparator;
        if (comparator2 != null) {
            return comparator2;
        }
        throw new UnsupportedOperationException("This ordering does not define a comparator.");
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ElementOrder)) {
            return false;
        }
        ElementOrder elementOrder = (ElementOrder) obj;
        return this.type == elementOrder.type && Objects.equal(this.comparator, elementOrder.comparator);
    }

    public final int hashCode() {
        return Objects.hashCode(this.type, this.comparator);
    }

    public final String toString() {
        MoreObjects.ToStringHelper add = MoreObjects.toStringHelper(this).add("type", this.type);
        Comparator<T> comparator2 = this.comparator;
        if (comparator2 != null) {
            add.add("comparator", comparator2);
        }
        return add.toString();
    }

    /* renamed from: com.google.common.graph.ElementOrder$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$common$graph$ElementOrder$Type = new int[Type.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|8) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        static {
            $SwitchMap$com$google$common$graph$ElementOrder$Type[Type.UNORDERED.ordinal()] = 1;
            $SwitchMap$com$google$common$graph$ElementOrder$Type[Type.INSERTION.ordinal()] = 2;
            try {
                $SwitchMap$com$google$common$graph$ElementOrder$Type[Type.SORTED.ordinal()] = 3;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final <K extends T, V> Map<K, V> createMap(int i) {
        int i2 = AnonymousClass1.$SwitchMap$com$google$common$graph$ElementOrder$Type[this.type.ordinal()];
        if (i2 == 1) {
            return Maps.newHashMapWithExpectedSize(i);
        }
        if (i2 == 2) {
            return Maps.newLinkedHashMapWithExpectedSize(i);
        }
        if (i2 == 3) {
            return Maps.newTreeMap(comparator());
        }
        throw new AssertionError();
    }
}
