package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.Serializable;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.LongBinaryOperator;
import java.util.function.LongUnaryOperator;

@GwtCompatible
public final class AtomicLongMap<K> implements Serializable {
    private transient Map<K, Long> asMap;
    private final ConcurrentHashMap<K, Long> map;

    static /* synthetic */ long lambda$put$4(long j, long j2) {
        return j;
    }

    private AtomicLongMap(ConcurrentHashMap<K, Long> concurrentHashMap) {
        this.map = (ConcurrentHashMap) Preconditions.checkNotNull(concurrentHashMap);
    }

    public static <K> AtomicLongMap<K> create() {
        return new AtomicLongMap<>(new ConcurrentHashMap());
    }

    public static <K> AtomicLongMap<K> create(Map<? extends K, ? extends Long> map2) {
        AtomicLongMap<K> create = create();
        create.putAll(map2);
        return create;
    }

    public final long get(K k) {
        return this.map.getOrDefault(k, 0L).longValue();
    }

    @CanIgnoreReturnValue
    public final long incrementAndGet(K k) {
        return addAndGet(k, 1);
    }

    @CanIgnoreReturnValue
    public final long decrementAndGet(K k) {
        return addAndGet(k, -1);
    }

    @CanIgnoreReturnValue
    public final long addAndGet(K k, long j) {
        return accumulateAndGet(k, j, $$Lambda$dplkPhACWDPIy18ogwdupEQaN40.INSTANCE);
    }

    @CanIgnoreReturnValue
    public final long getAndIncrement(K k) {
        return getAndAdd(k, 1);
    }

    @CanIgnoreReturnValue
    public final long getAndDecrement(K k) {
        return getAndAdd(k, -1);
    }

    @CanIgnoreReturnValue
    public final long getAndAdd(K k, long j) {
        return getAndAccumulate(k, j, $$Lambda$dplkPhACWDPIy18ogwdupEQaN40.INSTANCE);
    }

    @CanIgnoreReturnValue
    public final long updateAndGet(K k, LongUnaryOperator longUnaryOperator) {
        Preconditions.checkNotNull(longUnaryOperator);
        return this.map.compute(k, new BiFunction(longUnaryOperator) {
            /* class com.google.common.util.concurrent.$$Lambda$AtomicLongMap$TraBMzXCthGZEQVANO5QmnxWno */
            private final /* synthetic */ LongUnaryOperator f$0;

            {
                this.f$0 = r1;
            }

            public final Object apply(Object obj, Object obj2) {
                return AtomicLongMap.lambda$updateAndGet$0(this.f$0, obj, (Long) obj2);
            }
        }).longValue();
    }

    static /* synthetic */ Long lambda$updateAndGet$0(LongUnaryOperator longUnaryOperator, Object obj, Long l) {
        return Long.valueOf(longUnaryOperator.applyAsLong(l == null ? 0 : l.longValue()));
    }

    @CanIgnoreReturnValue
    public final long getAndUpdate(K k, LongUnaryOperator longUnaryOperator) {
        Preconditions.checkNotNull(longUnaryOperator);
        AtomicLong atomicLong = new AtomicLong();
        this.map.compute(k, new BiFunction(atomicLong, longUnaryOperator) {
            /* class com.google.common.util.concurrent.$$Lambda$AtomicLongMap$_mRNwAvglyKc5Yx82XZ6MQIcNOc */
            private final /* synthetic */ AtomicLong f$0;
            private final /* synthetic */ LongUnaryOperator f$1;

            {
                this.f$0 = r1;
                this.f$1 = r2;
            }

            public final Object apply(Object obj, Object obj2) {
                return AtomicLongMap.lambda$getAndUpdate$1(this.f$0, this.f$1, obj, (Long) obj2);
            }
        });
        return atomicLong.get();
    }

    static /* synthetic */ Long lambda$getAndUpdate$1(AtomicLong atomicLong, LongUnaryOperator longUnaryOperator, Object obj, Long l) {
        long longValue = l == null ? 0 : l.longValue();
        atomicLong.set(longValue);
        return Long.valueOf(longUnaryOperator.applyAsLong(longValue));
    }

    @CanIgnoreReturnValue
    public final long accumulateAndGet(K k, long j, LongBinaryOperator longBinaryOperator) {
        Preconditions.checkNotNull(longBinaryOperator);
        return updateAndGet(k, new LongUnaryOperator(longBinaryOperator, j) {
            /* class com.google.common.util.concurrent.$$Lambda$AtomicLongMap$4CvOIpS6KzWJFfXmm4Bsao0FRtY */
            private final /* synthetic */ LongBinaryOperator f$0;
            private final /* synthetic */ long f$1;

            {
                this.f$0 = r1;
                this.f$1 = r2;
            }

            public final long applyAsLong(long j) {
                return this.f$0.applyAsLong(j, this.f$1);
            }
        });
    }

    @CanIgnoreReturnValue
    public final long getAndAccumulate(K k, long j, LongBinaryOperator longBinaryOperator) {
        Preconditions.checkNotNull(longBinaryOperator);
        return getAndUpdate(k, new LongUnaryOperator(longBinaryOperator, j) {
            /* class com.google.common.util.concurrent.$$Lambda$AtomicLongMap$xkVI1iDZ2IluvsquadnktIkVUWI */
            private final /* synthetic */ LongBinaryOperator f$0;
            private final /* synthetic */ long f$1;

            {
                this.f$0 = r1;
                this.f$1 = r2;
            }

            public final long applyAsLong(long j) {
                return this.f$0.applyAsLong(j, this.f$1);
            }
        });
    }

    @CanIgnoreReturnValue
    public final long put(K k, long j) {
        return getAndUpdate(k, new LongUnaryOperator(j) {
            /* class com.google.common.util.concurrent.$$Lambda$AtomicLongMap$DcLTlF3s5DHwdNSgEWTYCqVol1g */
            private final /* synthetic */ long f$0;

            {
                this.f$0 = r1;
            }

            public final long applyAsLong(long j) {
                return AtomicLongMap.lambda$put$4(this.f$0, j);
            }
        });
    }

    public final void putAll(Map<? extends K, ? extends Long> map2) {
        map2.forEach(new BiConsumer() {
            /* class com.google.common.util.concurrent.$$Lambda$NpQImCSB1VBAuWg5oY26Tq15j3U */

            public final void accept(Object obj, Object obj2) {
                AtomicLongMap.this.put(obj, ((Long) obj2).longValue());
            }
        });
    }

    @CanIgnoreReturnValue
    public final long remove(K k) {
        Long remove = this.map.remove(k);
        if (remove == null) {
            return 0;
        }
        return remove.longValue();
    }

    /* access modifiers changed from: package-private */
    public final boolean remove(K k, long j) {
        return this.map.remove(k, Long.valueOf(j));
    }

    @CanIgnoreReturnValue
    @Beta
    public final boolean removeIfZero(K k) {
        return remove(k, 0);
    }

    static /* synthetic */ boolean lambda$removeAllZeros$5(Long l) {
        return l.longValue() == 0;
    }

    public final void removeAllZeros() {
        this.map.values().removeIf($$Lambda$AtomicLongMap$49jqsgGfolS7k5Y0w5CKFvjzFZk.INSTANCE);
    }

    public final long sum() {
        return this.map.values().stream().mapToLong($$Lambda$ELHKvd8JMVRD8rbALqYPKbDX2mM.INSTANCE).sum();
    }

    public final Map<K, Long> asMap() {
        Map<K, Long> map2 = this.asMap;
        if (map2 != null) {
            return map2;
        }
        Map<K, Long> createAsMap = createAsMap();
        this.asMap = createAsMap;
        return createAsMap;
    }

    private Map<K, Long> createAsMap() {
        return Collections.unmodifiableMap(this.map);
    }

    public final boolean containsKey(Object obj) {
        return this.map.containsKey(obj);
    }

    public final int size() {
        return this.map.size();
    }

    public final boolean isEmpty() {
        return this.map.isEmpty();
    }

    public final void clear() {
        this.map.clear();
    }

    public final String toString() {
        return this.map.toString();
    }

    /* access modifiers changed from: package-private */
    public final long putIfAbsent(K k, long j) {
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        Long compute = this.map.compute(k, new BiFunction(atomicBoolean, j) {
            /* class com.google.common.util.concurrent.$$Lambda$AtomicLongMap$ssE2wSalMHj2RQJgrvz9l7Rh5mI */
            private final /* synthetic */ AtomicBoolean f$0;
            private final /* synthetic */ long f$1;

            {
                this.f$0 = r1;
                this.f$1 = r2;
            }

            public final Object apply(Object obj, Object obj2) {
                return AtomicLongMap.lambda$putIfAbsent$6(this.f$0, this.f$1, obj, (Long) obj2);
            }
        });
        if (atomicBoolean.get()) {
            return 0;
        }
        return compute.longValue();
    }

    static /* synthetic */ Long lambda$putIfAbsent$6(AtomicBoolean atomicBoolean, long j, Object obj, Long l) {
        if (l != null && l.longValue() != 0) {
            return l;
        }
        atomicBoolean.set(true);
        return Long.valueOf(j);
    }

    /* access modifiers changed from: package-private */
    public final boolean replace(K k, long j, long j2) {
        if (j == 0) {
            return putIfAbsent(k, j2) == 0;
        }
        return this.map.replace(k, Long.valueOf(j), Long.valueOf(j2));
    }
}
