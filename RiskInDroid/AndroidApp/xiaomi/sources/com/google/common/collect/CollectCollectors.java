package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableBiMap;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableRangeMap;
import com.google.common.collect.ImmutableSortedMap;
import com.google.common.collect.ImmutableSortedSet;
import java.util.Comparator;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

@GwtCompatible
final class CollectCollectors {
    private static final Collector<Object, ?, ImmutableList<Object>> TO_IMMUTABLE_LIST = Collector.of($$Lambda$DfydzOF3bxBxHq3iqs49ZgMLUs.INSTANCE, $$Lambda$QvyaiL_hYayIQFE2St24To5wZE.INSTANCE, $$Lambda$Qx83BY6lz6Jpv1dd6polKavxmK8.INSTANCE, $$Lambda$B6qMqDjsj2i6zaZiqfU9Ziu4KU.INSTANCE, new Collector.Characteristics[0]);
    @GwtIncompatible
    private static final Collector<Range<Comparable>, ?, ImmutableRangeSet<Comparable>> TO_IMMUTABLE_RANGE_SET = Collector.of($$Lambda$qYrmkTOaUrLYeL7EApXANHaSYdI.INSTANCE, $$Lambda$lowwVYyQOaWraSEhFKduT64LPV0.INSTANCE, $$Lambda$7Mxhy81NAiwcDk9tE05wrS15B5g.INSTANCE, $$Lambda$3snfJOhsHXrS4Qvlzt9iufmIkY8.INSTANCE, new Collector.Characteristics[0]);
    private static final Collector<Object, ?, ImmutableSet<Object>> TO_IMMUTABLE_SET = Collector.of($$Lambda$D2fWAlgZqZKOlZH1XayB5NNFYg.INSTANCE, $$Lambda$IdVJip9QnNnOjsjbknfdGci9RiE.INSTANCE, $$Lambda$wUAReslCQiBwCn6kktgOARAFWY.INSTANCE, $$Lambda$T_uso8JlwUHIict0GBhQKPJhLA.INSTANCE, new Collector.Characteristics[0]);

    CollectCollectors() {
    }

    static <T, K, V> Collector<T, ?, ImmutableBiMap<K, V>> toImmutableBiMap(Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2) {
        Preconditions.checkNotNull(function);
        Preconditions.checkNotNull(function2);
        return Collector.of($$Lambda$_m_t76O2vKrvy2DwB7sQvYoUFCw.INSTANCE, new BiConsumer(function, function2) {
            /* class com.google.common.collect.$$Lambda$CollectCollectors$HMw9mDrSvkUs_smMpKcOhX6haxs */
            private final /* synthetic */ Function f$0;
            private final /* synthetic */ Function f$1;

            {
                this.f$0 = r1;
                this.f$1 = r2;
            }

            public final void accept(Object obj, Object obj2) {
                ((ImmutableBiMap.Builder) obj).put(this.f$0.apply(obj2), this.f$1.apply(obj2));
            }
        }, $$Lambda$QPuM9iKoW1PCf2mQzuKDfsTjICw.INSTANCE, $$Lambda$XhUs_LRHe4OdfH7q5ERshr3mO8.INSTANCE, new Collector.Characteristics[0]);
    }

    static <E> Collector<E, ?, ImmutableList<E>> toImmutableList() {
        return TO_IMMUTABLE_LIST;
    }

    static <T, K, V> Collector<T, ?, ImmutableMap<K, V>> toImmutableMap(Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2) {
        Preconditions.checkNotNull(function);
        Preconditions.checkNotNull(function2);
        return Collector.of($$Lambda$2DoWASnF6dZ7iLd1Bp9mMxtgx34.INSTANCE, new BiConsumer(function, function2) {
            /* class com.google.common.collect.$$Lambda$CollectCollectors$QEt2k0TxRNpKjocJNjSlM4nzwzg */
            private final /* synthetic */ Function f$0;
            private final /* synthetic */ Function f$1;

            {
                this.f$0 = r1;
                this.f$1 = r2;
            }

            public final void accept(Object obj, Object obj2) {
                ((ImmutableMap.Builder) obj).put(this.f$0.apply(obj2), this.f$1.apply(obj2));
            }
        }, $$Lambda$iMl639MbEQfK2Uwz4dSjiDOdD0Y.INSTANCE, $$Lambda$JNR12gyt_ZEeeKFrcwlQXfJuBo.INSTANCE, new Collector.Characteristics[0]);
    }

    static <E> Collector<E, ?, ImmutableSet<E>> toImmutableSet() {
        return TO_IMMUTABLE_SET;
    }

    static <T, K, V> Collector<T, ?, ImmutableSortedMap<K, V>> toImmutableSortedMap(Comparator<? super K> comparator, Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2) {
        Preconditions.checkNotNull(comparator);
        Preconditions.checkNotNull(function);
        Preconditions.checkNotNull(function2);
        return Collector.of(new Supplier(comparator) {
            /* class com.google.common.collect.$$Lambda$CollectCollectors$JbNzTVqa2YS9FTms4CBu4SjH7ak */
            private final /* synthetic */ Comparator f$0;

            {
                this.f$0 = r1;
            }

            public final Object get() {
                return CollectCollectors.lambda$toImmutableSortedMap$2(this.f$0);
            }
        }, new BiConsumer(function, function2) {
            /* class com.google.common.collect.$$Lambda$CollectCollectors$LRJvFLvkG13RJZ8bFXav4HMCTMQ */
            private final /* synthetic */ Function f$0;
            private final /* synthetic */ Function f$1;

            {
                this.f$0 = r1;
                this.f$1 = r2;
            }

            public final void accept(Object obj, Object obj2) {
                ((ImmutableSortedMap.Builder) obj).put(this.f$0.apply(obj2), this.f$1.apply(obj2));
            }
        }, $$Lambda$xRTACJ_W0N2wW_qcPf4oUEy47wM.INSTANCE, $$Lambda$siK1rvzVZhWHDX4C7n3RSZYbQfs.INSTANCE, Collector.Characteristics.UNORDERED);
    }

    static /* synthetic */ ImmutableSortedMap.Builder lambda$toImmutableSortedMap$2(Comparator comparator) {
        return new ImmutableSortedMap.Builder(comparator);
    }

    static <E> Collector<E, ?, ImmutableSortedSet<E>> toImmutableSortedSet(Comparator<? super E> comparator) {
        Preconditions.checkNotNull(comparator);
        return Collector.of(new Supplier(comparator) {
            /* class com.google.common.collect.$$Lambda$CollectCollectors$hEyPbqEvvnuK__OqWC8HpCfj_fE */
            private final /* synthetic */ Comparator f$0;

            {
                this.f$0 = r1;
            }

            public final Object get() {
                return CollectCollectors.lambda$toImmutableSortedSet$4(this.f$0);
            }
        }, $$Lambda$FLuZpkQmNg7JOBdGkuDvpE1c7wY.INSTANCE, $$Lambda$Gb0cLXsnGYbZK6C3LsaZrtl7k8.INSTANCE, $$Lambda$HYy5QkqepjzFGDSicdDzvjxFZSk.INSTANCE, new Collector.Characteristics[0]);
    }

    static /* synthetic */ ImmutableSortedSet.Builder lambda$toImmutableSortedSet$4(Comparator comparator) {
        return new ImmutableSortedSet.Builder(comparator);
    }

    @GwtIncompatible
    static <E extends Comparable<? super E>> Collector<Range<E>, ?, ImmutableRangeSet<E>> toImmutableRangeSet() {
        return TO_IMMUTABLE_RANGE_SET;
    }

    @GwtIncompatible
    static <T, K extends Comparable<? super K>, V> Collector<T, ?, ImmutableRangeMap<K, V>> toImmutableRangeMap(Function<? super T, Range<K>> function, Function<? super T, ? extends V> function2) {
        Preconditions.checkNotNull(function);
        Preconditions.checkNotNull(function2);
        return Collector.of($$Lambda$gysTBkYkLoQ6CU7u_E1e7mz2Fg.INSTANCE, new BiConsumer(function, function2) {
            /* class com.google.common.collect.$$Lambda$CollectCollectors$65HCb4TFteqa_fnqC20JyjqXnWQ */
            private final /* synthetic */ Function f$0;
            private final /* synthetic */ Function f$1;

            {
                this.f$0 = r1;
                this.f$1 = r2;
            }

            public final void accept(Object obj, Object obj2) {
                ((ImmutableRangeMap.Builder) obj).put((Range) this.f$0.apply(obj2), this.f$1.apply(obj2));
            }
        }, $$Lambda$zFfqyVq5T798wGUZivKwgD4lls.INSTANCE, $$Lambda$k2Nywlv8zwjiSiBaJUxSurcGA.INSTANCE, new Collector.Characteristics[0]);
    }
}
