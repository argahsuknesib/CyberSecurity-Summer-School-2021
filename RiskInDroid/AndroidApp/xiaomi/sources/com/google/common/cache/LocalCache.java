package com.google.common.cache;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Equivalence;
import com.google.common.base.Preconditions;
import com.google.common.base.Stopwatch;
import com.google.common.base.Ticker;
import com.google.common.cache.AbstractCache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.collect.AbstractSequentialIterator;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterators;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.common.primitives.Ints;
import com.google.common.util.concurrent.ExecutionError;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.SettableFuture;
import com.google.common.util.concurrent.UncheckedExecutionException;
import com.google.common.util.concurrent.Uninterruptibles;
import com.google.errorprone.annotations.concurrent.GuardedBy;
import com.google.j2objc.annotations.Weak;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractQueue;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;

@GwtCompatible(emulated = true)
class LocalCache<K, V> extends AbstractMap<K, V> implements ConcurrentMap<K, V> {
    static final Queue<?> DISCARDING_QUEUE = new AbstractQueue<Object>() {
        /* class com.google.common.cache.LocalCache.AnonymousClass2 */

        public final boolean offer(Object obj) {
            return true;
        }

        public final Object peek() {
            return null;
        }

        public final Object poll() {
            return null;
        }

        public final int size() {
            return 0;
        }

        public final Iterator<Object> iterator() {
            return ImmutableSet.of().iterator();
        }
    };
    static final ValueReference<Object, Object> UNSET = new ValueReference<Object, Object>() {
        /* class com.google.common.cache.LocalCache.AnonymousClass1 */

        public final ValueReference<Object, Object> copyFor(ReferenceQueue<Object> referenceQueue, Object obj, ReferenceEntry<Object, Object> referenceEntry) {
            return this;
        }

        public final Object get() {
            return null;
        }

        public final ReferenceEntry<Object, Object> getEntry() {
            return null;
        }

        public final int getWeight() {
            return 0;
        }

        public final boolean isActive() {
            return false;
        }

        public final boolean isLoading() {
            return false;
        }

        public final void notifyNewValue(Object obj) {
        }

        public final Object waitForValue() {
            return null;
        }
    };
    static final Logger logger = Logger.getLogger(LocalCache.class.getName());
    final int concurrencyLevel;
    final CacheLoader<? super K, V> defaultLoader;
    final EntryFactory entryFactory;
    Set<Map.Entry<K, V>> entrySet;
    final long expireAfterAccessNanos;
    final long expireAfterWriteNanos;
    final AbstractCache.StatsCounter globalStatsCounter;
    final Equivalence<Object> keyEquivalence;
    Set<K> keySet;
    final Strength keyStrength;
    final long maxWeight;
    final long refreshNanos;
    final RemovalListener<K, V> removalListener;
    final Queue<RemovalNotification<K, V>> removalNotificationQueue;
    final int segmentMask;
    final int segmentShift;
    final Segment<K, V>[] segments;
    final Ticker ticker;
    final Equivalence<Object> valueEquivalence;
    final Strength valueStrength;
    Collection<V> values;
    final Weigher<K, V> weigher;

    enum NullEntry implements ReferenceEntry<Object, Object> {
        INSTANCE;

        public final long getAccessTime() {
            return 0;
        }

        public final int getHash() {
            return 0;
        }

        public final Object getKey() {
            return null;
        }

        public final ReferenceEntry<Object, Object> getNext() {
            return null;
        }

        public final ReferenceEntry<Object, Object> getNextInAccessQueue() {
            return this;
        }

        public final ReferenceEntry<Object, Object> getNextInWriteQueue() {
            return this;
        }

        public final ReferenceEntry<Object, Object> getPreviousInAccessQueue() {
            return this;
        }

        public final ReferenceEntry<Object, Object> getPreviousInWriteQueue() {
            return this;
        }

        public final ValueReference<Object, Object> getValueReference() {
            return null;
        }

        public final long getWriteTime() {
            return 0;
        }

        public final void setAccessTime(long j) {
        }

        public final void setNextInAccessQueue(ReferenceEntry<Object, Object> referenceEntry) {
        }

        public final void setNextInWriteQueue(ReferenceEntry<Object, Object> referenceEntry) {
        }

        public final void setPreviousInAccessQueue(ReferenceEntry<Object, Object> referenceEntry) {
        }

        public final void setPreviousInWriteQueue(ReferenceEntry<Object, Object> referenceEntry) {
        }

        public final void setValueReference(ValueReference<Object, Object> valueReference) {
        }

        public final void setWriteTime(long j) {
        }
    }

    enum Strength {
        STRONG {
            /* access modifiers changed from: package-private */
            public final <K, V> ValueReference<K, V> referenceValue(Segment<K, V> segment, ReferenceEntry<K, V> referenceEntry, V v, int i) {
                return i == 1 ? new StrongValueReference(v) : new WeightedStrongValueReference(v, i);
            }

            /* access modifiers changed from: package-private */
            public final Equivalence<Object> defaultEquivalence() {
                return Equivalence.equals();
            }
        },
        SOFT {
            /* access modifiers changed from: package-private */
            public final <K, V> ValueReference<K, V> referenceValue(Segment<K, V> segment, ReferenceEntry<K, V> referenceEntry, V v, int i) {
                return i == 1 ? new SoftValueReference(segment.valueReferenceQueue, v, referenceEntry) : new WeightedSoftValueReference(segment.valueReferenceQueue, v, referenceEntry, i);
            }

            /* access modifiers changed from: package-private */
            public final Equivalence<Object> defaultEquivalence() {
                return Equivalence.identity();
            }
        },
        WEAK {
            /* access modifiers changed from: package-private */
            public final <K, V> ValueReference<K, V> referenceValue(Segment<K, V> segment, ReferenceEntry<K, V> referenceEntry, V v, int i) {
                return i == 1 ? new WeakValueReference(segment.valueReferenceQueue, v, referenceEntry) : new WeightedWeakValueReference(segment.valueReferenceQueue, v, referenceEntry, i);
            }

            /* access modifiers changed from: package-private */
            public final Equivalence<Object> defaultEquivalence() {
                return Equivalence.identity();
            }
        };

        /* access modifiers changed from: package-private */
        public abstract Equivalence<Object> defaultEquivalence();

        /* access modifiers changed from: package-private */
        public abstract <K, V> ValueReference<K, V> referenceValue(Segment<K, V> segment, ReferenceEntry<K, V> referenceEntry, V v, int i);
    }

    interface ValueReference<K, V> {
        ValueReference<K, V> copyFor(ReferenceQueue<V> referenceQueue, V v, ReferenceEntry<K, V> referenceEntry);

        V get();

        ReferenceEntry<K, V> getEntry();

        int getWeight();

        boolean isActive();

        boolean isLoading();

        void notifyNewValue(V v);

        V waitForValue() throws ExecutionException;
    }

    static int rehash(int i) {
        int i2 = i + ((i << 15) ^ -12931);
        int i3 = i2 ^ (i2 >>> 10);
        int i4 = i3 + (i3 << 3);
        int i5 = i4 ^ (i4 >>> 6);
        int i6 = i5 + (i5 << 2) + (i5 << 14);
        return i6 ^ (i6 >>> 16);
    }

    /* JADX WARN: Type inference failed for: r12v0, types: [com.google.common.cache.CacheBuilder, com.google.common.cache.CacheBuilder<? super K, ? super V>] */
    /*  JADX ERROR: JadxRuntimeException in pass: MethodInvokeVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not class type: ?
        	at jadx.core.dex.info.ClassInfo.checkClassType(ClassInfo.java:60)
        	at jadx.core.dex.info.ClassInfo.fromType(ClassInfo.java:31)
        	at jadx.core.dex.nodes.DexNode.resolveClass(DexNode.java:143)
        	at jadx.core.dex.nodes.RootNode.resolveClass(RootNode.java:183)
        	at jadx.core.dex.nodes.utils.MethodUtils.processMethodArgsOverloaded(MethodUtils.java:75)
        	at jadx.core.dex.nodes.utils.MethodUtils.collectOverloadedMethods(MethodUtils.java:54)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processOverloaded(MethodInvokeVisitor.java:108)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInvoke(MethodInvokeVisitor.java:101)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:72)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:77)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.visit(MethodInvokeVisitor.java:65)
        */
    LocalCache(com.google.common.cache.CacheBuilder<? super K, ? super V> r12, com.google.common.cache.CacheLoader<? super K, V> r13) {
        /*
            r11 = this;
            r11.<init>()
            int r0 = r12.getConcurrencyLevel()
            r1 = 65536(0x10000, float:9.18355E-41)
            int r0 = java.lang.Math.min(r0, r1)
            r11.concurrencyLevel = r0
            com.google.common.cache.LocalCache$Strength r0 = r12.getKeyStrength()
            r11.keyStrength = r0
            com.google.common.cache.LocalCache$Strength r0 = r12.getValueStrength()
            r11.valueStrength = r0
            com.google.common.base.Equivalence r0 = r12.getKeyEquivalence()
            r11.keyEquivalence = r0
            com.google.common.base.Equivalence r0 = r12.getValueEquivalence()
            r11.valueEquivalence = r0
            long r0 = r12.getMaximumWeight()
            r11.maxWeight = r0
            com.google.common.cache.Weigher r0 = r12.getWeigher()
            r11.weigher = r0
            long r0 = r12.getExpireAfterAccessNanos()
            r11.expireAfterAccessNanos = r0
            long r0 = r12.getExpireAfterWriteNanos()
            r11.expireAfterWriteNanos = r0
            long r0 = r12.getRefreshNanos()
            r11.refreshNanos = r0
            com.google.common.cache.RemovalListener r0 = r12.getRemovalListener()
            r11.removalListener = r0
            com.google.common.cache.RemovalListener<K, V> r0 = r11.removalListener
            com.google.common.cache.CacheBuilder$NullListener r1 = com.google.common.cache.CacheBuilder.NullListener.INSTANCE
            if (r0 != r1) goto L_0x0056
            java.util.Queue r0 = discardingQueue()
            goto L_0x005b
        L_0x0056:
            java.util.concurrent.ConcurrentLinkedQueue r0 = new java.util.concurrent.ConcurrentLinkedQueue
            r0.<init>()
        L_0x005b:
            r11.removalNotificationQueue = r0
            boolean r0 = r11.recordsTime()
            com.google.common.base.Ticker r0 = r12.getTicker(r0)
            r11.ticker = r0
            com.google.common.cache.LocalCache$Strength r0 = r11.keyStrength
            boolean r1 = r11.usesAccessEntries()
            boolean r2 = r11.usesWriteEntries()
            com.google.common.cache.LocalCache$EntryFactory r0 = com.google.common.cache.LocalCache.EntryFactory.getFactory(r0, r1, r2)
            r11.entryFactory = r0
            com.google.common.base.Supplier r0 = r12.getStatsCounterSupplier()
            java.lang.Object r0 = r0.get()
            com.google.common.cache.AbstractCache$StatsCounter r0 = (com.google.common.cache.AbstractCache.StatsCounter) r0
            r11.globalStatsCounter = r0
            r11.defaultLoader = r13
            int r13 = r12.getInitialCapacity()
            r0 = 1073741824(0x40000000, float:2.0)
            int r13 = java.lang.Math.min(r13, r0)
            boolean r0 = r11.evictsBySize()
            if (r0 == 0) goto L_0x00a3
            boolean r0 = r11.customWeigher()
            if (r0 != 0) goto L_0x00a3
            long r0 = (long) r13
            long r2 = r11.maxWeight
            long r0 = java.lang.Math.min(r0, r2)
            int r13 = (int) r0
        L_0x00a3:
            r0 = 0
            r1 = 1
            r2 = 1
            r3 = 0
        L_0x00a7:
            int r4 = r11.concurrencyLevel
            if (r2 >= r4) goto L_0x00bf
            boolean r4 = r11.evictsBySize()
            if (r4 == 0) goto L_0x00ba
            int r4 = r2 * 20
            long r4 = (long) r4
            long r6 = r11.maxWeight
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 > 0) goto L_0x00bf
        L_0x00ba:
            int r3 = r3 + 1
            int r2 = r2 << 1
            goto L_0x00a7
        L_0x00bf:
            int r3 = 32 - r3
            r11.segmentShift = r3
            int r3 = r2 + -1
            r11.segmentMask = r3
            com.google.common.cache.LocalCache$Segment[] r3 = r11.newSegmentArray(r2)
            r11.segments = r3
            int r3 = r13 / r2
            int r4 = r3 * r2
            if (r4 >= r13) goto L_0x00d5
            int r3 = r3 + 1
        L_0x00d5:
            if (r1 >= r3) goto L_0x00da
            int r1 = r1 << 1
            goto L_0x00d5
        L_0x00da:
            boolean r13 = r11.evictsBySize()
            if (r13 == 0) goto L_0x010a
            long r3 = r11.maxWeight
            long r5 = (long) r2
            long r7 = r3 / r5
            r9 = 1
            long r7 = r7 + r9
            long r3 = r3 % r5
        L_0x00e9:
            com.google.common.cache.LocalCache$Segment<K, V>[] r13 = r11.segments
            int r13 = r13.length
            if (r0 >= r13) goto L_0x0109
            long r5 = (long) r0
            int r13 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r13 != 0) goto L_0x00f4
            long r7 = r7 - r9
        L_0x00f4:
            com.google.common.cache.LocalCache$Segment<K, V>[] r13 = r11.segments
            com.google.common.base.Supplier r2 = r12.getStatsCounterSupplier()
            java.lang.Object r2 = r2.get()
            com.google.common.cache.AbstractCache$StatsCounter r2 = (com.google.common.cache.AbstractCache.StatsCounter) r2
            com.google.common.cache.LocalCache$Segment r2 = r11.createSegment(r1, r7, r2)
            r13[r0] = r2
            int r0 = r0 + 1
            goto L_0x00e9
        L_0x0109:
            return
        L_0x010a:
            com.google.common.cache.LocalCache$Segment<K, V>[] r13 = r11.segments
            int r2 = r13.length
            if (r0 >= r2) goto L_0x0124
            r2 = -1
            com.google.common.base.Supplier r4 = r12.getStatsCounterSupplier()
            java.lang.Object r4 = r4.get()
            com.google.common.cache.AbstractCache$StatsCounter r4 = (com.google.common.cache.AbstractCache.StatsCounter) r4
            com.google.common.cache.LocalCache$Segment r2 = r11.createSegment(r1, r2, r4)
            r13[r0] = r2
            int r0 = r0 + 1
            goto L_0x010a
        L_0x0124:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.cache.LocalCache.<init>(com.google.common.cache.CacheBuilder, com.google.common.cache.CacheLoader):void");
    }

    /* access modifiers changed from: package-private */
    public boolean evictsBySize() {
        return this.maxWeight >= 0;
    }

    /* access modifiers changed from: package-private */
    public boolean customWeigher() {
        return this.weigher != CacheBuilder.OneWeigher.INSTANCE;
    }

    /* access modifiers changed from: package-private */
    public boolean expires() {
        return expiresAfterWrite() || expiresAfterAccess();
    }

    /* access modifiers changed from: package-private */
    public boolean expiresAfterWrite() {
        return this.expireAfterWriteNanos > 0;
    }

    /* access modifiers changed from: package-private */
    public boolean expiresAfterAccess() {
        return this.expireAfterAccessNanos > 0;
    }

    /* access modifiers changed from: package-private */
    public boolean refreshes() {
        return this.refreshNanos > 0;
    }

    /* access modifiers changed from: package-private */
    public boolean usesAccessQueue() {
        return expiresAfterAccess() || evictsBySize();
    }

    /* access modifiers changed from: package-private */
    public boolean usesWriteQueue() {
        return expiresAfterWrite();
    }

    /* access modifiers changed from: package-private */
    public boolean recordsWrite() {
        return expiresAfterWrite() || refreshes();
    }

    /* access modifiers changed from: package-private */
    public boolean recordsAccess() {
        return expiresAfterAccess();
    }

    /* access modifiers changed from: package-private */
    public boolean recordsTime() {
        return recordsWrite() || recordsAccess();
    }

    /* access modifiers changed from: package-private */
    public boolean usesWriteEntries() {
        return usesWriteQueue() || recordsWrite();
    }

    /* access modifiers changed from: package-private */
    public boolean usesAccessEntries() {
        return usesAccessQueue() || recordsAccess();
    }

    /* access modifiers changed from: package-private */
    public boolean usesKeyReferences() {
        return this.keyStrength != Strength.STRONG;
    }

    /* access modifiers changed from: package-private */
    public boolean usesValueReferences() {
        return this.valueStrength != Strength.STRONG;
    }

    /* JADX INFO: Failed to restore enum class, 'enum' modifier removed */
    static abstract class EntryFactory extends Enum<EntryFactory> {
        private static final /* synthetic */ EntryFactory[] $VALUES;
        public static final EntryFactory STRONG = new EntryFactory("STRONG", 0) {
            /* class com.google.common.cache.LocalCache.EntryFactory.AnonymousClass1 */

            /* access modifiers changed from: package-private */
            public final <K, V> ReferenceEntry<K, V> newEntry(Segment<K, V> segment, K k, int i, ReferenceEntry<K, V> referenceEntry) {
                return new StrongEntry(k, i, referenceEntry);
            }
        };
        public static final EntryFactory STRONG_ACCESS = new EntryFactory("STRONG_ACCESS", 1) {
            /* class com.google.common.cache.LocalCache.EntryFactory.AnonymousClass2 */

            /* access modifiers changed from: package-private */
            public final <K, V> ReferenceEntry<K, V> newEntry(Segment<K, V> segment, K k, int i, ReferenceEntry<K, V> referenceEntry) {
                return new StrongAccessEntry(k, i, referenceEntry);
            }

            /* access modifiers changed from: package-private */
            public final <K, V> ReferenceEntry<K, V> copyEntry(Segment<K, V> segment, ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
                ReferenceEntry<K, V> copyEntry = super.copyEntry(segment, referenceEntry, referenceEntry2);
                copyAccessEntry(referenceEntry, copyEntry);
                return copyEntry;
            }
        };
        public static final EntryFactory STRONG_ACCESS_WRITE = new EntryFactory("STRONG_ACCESS_WRITE", 3) {
            /* class com.google.common.cache.LocalCache.EntryFactory.AnonymousClass4 */

            /* access modifiers changed from: package-private */
            public final <K, V> ReferenceEntry<K, V> newEntry(Segment<K, V> segment, K k, int i, ReferenceEntry<K, V> referenceEntry) {
                return new StrongAccessWriteEntry(k, i, referenceEntry);
            }

            /* access modifiers changed from: package-private */
            public final <K, V> ReferenceEntry<K, V> copyEntry(Segment<K, V> segment, ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
                ReferenceEntry<K, V> copyEntry = super.copyEntry(segment, referenceEntry, referenceEntry2);
                copyAccessEntry(referenceEntry, copyEntry);
                copyWriteEntry(referenceEntry, copyEntry);
                return copyEntry;
            }
        };
        public static final EntryFactory STRONG_WRITE = new EntryFactory("STRONG_WRITE", 2) {
            /* class com.google.common.cache.LocalCache.EntryFactory.AnonymousClass3 */

            /* access modifiers changed from: package-private */
            public final <K, V> ReferenceEntry<K, V> newEntry(Segment<K, V> segment, K k, int i, ReferenceEntry<K, V> referenceEntry) {
                return new StrongWriteEntry(k, i, referenceEntry);
            }

            /* access modifiers changed from: package-private */
            public final <K, V> ReferenceEntry<K, V> copyEntry(Segment<K, V> segment, ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
                ReferenceEntry<K, V> copyEntry = super.copyEntry(segment, referenceEntry, referenceEntry2);
                copyWriteEntry(referenceEntry, copyEntry);
                return copyEntry;
            }
        };
        public static final EntryFactory WEAK = new EntryFactory("WEAK", 4) {
            /* class com.google.common.cache.LocalCache.EntryFactory.AnonymousClass5 */

            /* access modifiers changed from: package-private */
            public final <K, V> ReferenceEntry<K, V> newEntry(Segment<K, V> segment, K k, int i, ReferenceEntry<K, V> referenceEntry) {
                return new WeakEntry(segment.keyReferenceQueue, k, i, referenceEntry);
            }
        };
        public static final EntryFactory WEAK_ACCESS = new EntryFactory("WEAK_ACCESS", 5) {
            /* class com.google.common.cache.LocalCache.EntryFactory.AnonymousClass6 */

            /* access modifiers changed from: package-private */
            public final <K, V> ReferenceEntry<K, V> newEntry(Segment<K, V> segment, K k, int i, ReferenceEntry<K, V> referenceEntry) {
                return new WeakAccessEntry(segment.keyReferenceQueue, k, i, referenceEntry);
            }

            /* access modifiers changed from: package-private */
            public final <K, V> ReferenceEntry<K, V> copyEntry(Segment<K, V> segment, ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
                ReferenceEntry<K, V> copyEntry = super.copyEntry(segment, referenceEntry, referenceEntry2);
                copyAccessEntry(referenceEntry, copyEntry);
                return copyEntry;
            }
        };
        public static final EntryFactory WEAK_ACCESS_WRITE = new EntryFactory("WEAK_ACCESS_WRITE", 7) {
            /* class com.google.common.cache.LocalCache.EntryFactory.AnonymousClass8 */

            /* access modifiers changed from: package-private */
            public final <K, V> ReferenceEntry<K, V> newEntry(Segment<K, V> segment, K k, int i, ReferenceEntry<K, V> referenceEntry) {
                return new WeakAccessWriteEntry(segment.keyReferenceQueue, k, i, referenceEntry);
            }

            /* access modifiers changed from: package-private */
            public final <K, V> ReferenceEntry<K, V> copyEntry(Segment<K, V> segment, ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
                ReferenceEntry<K, V> copyEntry = super.copyEntry(segment, referenceEntry, referenceEntry2);
                copyAccessEntry(referenceEntry, copyEntry);
                copyWriteEntry(referenceEntry, copyEntry);
                return copyEntry;
            }
        };
        public static final EntryFactory WEAK_WRITE = new EntryFactory("WEAK_WRITE", 6) {
            /* class com.google.common.cache.LocalCache.EntryFactory.AnonymousClass7 */

            /* access modifiers changed from: package-private */
            public final <K, V> ReferenceEntry<K, V> newEntry(Segment<K, V> segment, K k, int i, ReferenceEntry<K, V> referenceEntry) {
                return new WeakWriteEntry(segment.keyReferenceQueue, k, i, referenceEntry);
            }

            /* access modifiers changed from: package-private */
            public final <K, V> ReferenceEntry<K, V> copyEntry(Segment<K, V> segment, ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
                ReferenceEntry<K, V> copyEntry = super.copyEntry(segment, referenceEntry, referenceEntry2);
                copyWriteEntry(referenceEntry, copyEntry);
                return copyEntry;
            }
        };
        static final EntryFactory[] factories;

        /* access modifiers changed from: package-private */
        public abstract <K, V> ReferenceEntry<K, V> newEntry(Segment<K, V> segment, K k, int i, ReferenceEntry<K, V> referenceEntry);

        private EntryFactory(String str, int i) {
        }

        public static EntryFactory valueOf(String str) {
            return (EntryFactory) Enum.valueOf(EntryFactory.class, str);
        }

        public static EntryFactory[] values() {
            return (EntryFactory[]) $VALUES.clone();
        }

        static {
            EntryFactory entryFactory = STRONG;
            EntryFactory entryFactory2 = STRONG_ACCESS;
            EntryFactory entryFactory3 = STRONG_WRITE;
            EntryFactory entryFactory4 = STRONG_ACCESS_WRITE;
            EntryFactory entryFactory5 = WEAK;
            EntryFactory entryFactory6 = WEAK_ACCESS;
            EntryFactory entryFactory7 = WEAK_WRITE;
            EntryFactory entryFactory8 = WEAK_ACCESS_WRITE;
            $VALUES = new EntryFactory[]{entryFactory, entryFactory2, entryFactory3, entryFactory4, entryFactory5, entryFactory6, entryFactory7, entryFactory8};
            factories = new EntryFactory[]{entryFactory, entryFactory2, entryFactory3, entryFactory4, entryFactory5, entryFactory6, entryFactory7, entryFactory8};
        }

        static EntryFactory getFactory(Strength strength, boolean z, boolean z2) {
            char c = 0;
            boolean z3 = (strength == Strength.WEAK ? (char) 4 : 0) | z;
            if (z2) {
                c = 2;
            }
            return factories[z3 | c];
        }

        /* access modifiers changed from: package-private */
        public <K, V> ReferenceEntry<K, V> copyEntry(Segment<K, V> segment, ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
            return newEntry(segment, referenceEntry.getKey(), referenceEntry.getHash(), referenceEntry2);
        }

        /* access modifiers changed from: package-private */
        public <K, V> void copyAccessEntry(ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
            referenceEntry2.setAccessTime(referenceEntry.getAccessTime());
            LocalCache.connectAccessOrder(referenceEntry.getPreviousInAccessQueue(), referenceEntry2);
            LocalCache.connectAccessOrder(referenceEntry2, referenceEntry.getNextInAccessQueue());
            LocalCache.nullifyAccessOrder(referenceEntry);
        }

        /* access modifiers changed from: package-private */
        public <K, V> void copyWriteEntry(ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
            referenceEntry2.setWriteTime(referenceEntry.getWriteTime());
            LocalCache.connectWriteOrder(referenceEntry.getPreviousInWriteQueue(), referenceEntry2);
            LocalCache.connectWriteOrder(referenceEntry2, referenceEntry.getNextInWriteQueue());
            LocalCache.nullifyWriteOrder(referenceEntry);
        }
    }

    static <K, V> ValueReference<K, V> unset() {
        return UNSET;
    }

    static abstract class AbstractReferenceEntry<K, V> implements ReferenceEntry<K, V> {
        AbstractReferenceEntry() {
        }

        public ValueReference<K, V> getValueReference() {
            throw new UnsupportedOperationException();
        }

        public void setValueReference(ValueReference<K, V> valueReference) {
            throw new UnsupportedOperationException();
        }

        public ReferenceEntry<K, V> getNext() {
            throw new UnsupportedOperationException();
        }

        public int getHash() {
            throw new UnsupportedOperationException();
        }

        public K getKey() {
            throw new UnsupportedOperationException();
        }

        public long getAccessTime() {
            throw new UnsupportedOperationException();
        }

        public void setAccessTime(long j) {
            throw new UnsupportedOperationException();
        }

        public ReferenceEntry<K, V> getNextInAccessQueue() {
            throw new UnsupportedOperationException();
        }

        public void setNextInAccessQueue(ReferenceEntry<K, V> referenceEntry) {
            throw new UnsupportedOperationException();
        }

        public ReferenceEntry<K, V> getPreviousInAccessQueue() {
            throw new UnsupportedOperationException();
        }

        public void setPreviousInAccessQueue(ReferenceEntry<K, V> referenceEntry) {
            throw new UnsupportedOperationException();
        }

        public long getWriteTime() {
            throw new UnsupportedOperationException();
        }

        public void setWriteTime(long j) {
            throw new UnsupportedOperationException();
        }

        public ReferenceEntry<K, V> getNextInWriteQueue() {
            throw new UnsupportedOperationException();
        }

        public void setNextInWriteQueue(ReferenceEntry<K, V> referenceEntry) {
            throw new UnsupportedOperationException();
        }

        public ReferenceEntry<K, V> getPreviousInWriteQueue() {
            throw new UnsupportedOperationException();
        }

        public void setPreviousInWriteQueue(ReferenceEntry<K, V> referenceEntry) {
            throw new UnsupportedOperationException();
        }
    }

    static <K, V> ReferenceEntry<K, V> nullEntry() {
        return NullEntry.INSTANCE;
    }

    static <E> Queue<E> discardingQueue() {
        return DISCARDING_QUEUE;
    }

    static class StrongEntry<K, V> extends AbstractReferenceEntry<K, V> {
        final int hash;
        final K key;
        final ReferenceEntry<K, V> next;
        volatile ValueReference<K, V> valueReference = LocalCache.unset();

        StrongEntry(K k, int i, ReferenceEntry<K, V> referenceEntry) {
            this.key = k;
            this.hash = i;
            this.next = referenceEntry;
        }

        public K getKey() {
            return this.key;
        }

        public ValueReference<K, V> getValueReference() {
            return this.valueReference;
        }

        public void setValueReference(ValueReference<K, V> valueReference2) {
            this.valueReference = valueReference2;
        }

        public int getHash() {
            return this.hash;
        }

        public ReferenceEntry<K, V> getNext() {
            return this.next;
        }
    }

    static final class StrongAccessEntry<K, V> extends StrongEntry<K, V> {
        volatile long accessTime = Long.MAX_VALUE;
        ReferenceEntry<K, V> nextAccess = LocalCache.nullEntry();
        ReferenceEntry<K, V> previousAccess = LocalCache.nullEntry();

        StrongAccessEntry(K k, int i, ReferenceEntry<K, V> referenceEntry) {
            super(k, i, referenceEntry);
        }

        public final long getAccessTime() {
            return this.accessTime;
        }

        public final void setAccessTime(long j) {
            this.accessTime = j;
        }

        public final ReferenceEntry<K, V> getNextInAccessQueue() {
            return this.nextAccess;
        }

        public final void setNextInAccessQueue(ReferenceEntry<K, V> referenceEntry) {
            this.nextAccess = referenceEntry;
        }

        public final ReferenceEntry<K, V> getPreviousInAccessQueue() {
            return this.previousAccess;
        }

        public final void setPreviousInAccessQueue(ReferenceEntry<K, V> referenceEntry) {
            this.previousAccess = referenceEntry;
        }
    }

    static final class StrongWriteEntry<K, V> extends StrongEntry<K, V> {
        ReferenceEntry<K, V> nextWrite = LocalCache.nullEntry();
        ReferenceEntry<K, V> previousWrite = LocalCache.nullEntry();
        volatile long writeTime = Long.MAX_VALUE;

        StrongWriteEntry(K k, int i, ReferenceEntry<K, V> referenceEntry) {
            super(k, i, referenceEntry);
        }

        public final long getWriteTime() {
            return this.writeTime;
        }

        public final void setWriteTime(long j) {
            this.writeTime = j;
        }

        public final ReferenceEntry<K, V> getNextInWriteQueue() {
            return this.nextWrite;
        }

        public final void setNextInWriteQueue(ReferenceEntry<K, V> referenceEntry) {
            this.nextWrite = referenceEntry;
        }

        public final ReferenceEntry<K, V> getPreviousInWriteQueue() {
            return this.previousWrite;
        }

        public final void setPreviousInWriteQueue(ReferenceEntry<K, V> referenceEntry) {
            this.previousWrite = referenceEntry;
        }
    }

    static final class StrongAccessWriteEntry<K, V> extends StrongEntry<K, V> {
        volatile long accessTime = Long.MAX_VALUE;
        ReferenceEntry<K, V> nextAccess = LocalCache.nullEntry();
        ReferenceEntry<K, V> nextWrite = LocalCache.nullEntry();
        ReferenceEntry<K, V> previousAccess = LocalCache.nullEntry();
        ReferenceEntry<K, V> previousWrite = LocalCache.nullEntry();
        volatile long writeTime = Long.MAX_VALUE;

        StrongAccessWriteEntry(K k, int i, ReferenceEntry<K, V> referenceEntry) {
            super(k, i, referenceEntry);
        }

        public final long getAccessTime() {
            return this.accessTime;
        }

        public final void setAccessTime(long j) {
            this.accessTime = j;
        }

        public final ReferenceEntry<K, V> getNextInAccessQueue() {
            return this.nextAccess;
        }

        public final void setNextInAccessQueue(ReferenceEntry<K, V> referenceEntry) {
            this.nextAccess = referenceEntry;
        }

        public final ReferenceEntry<K, V> getPreviousInAccessQueue() {
            return this.previousAccess;
        }

        public final void setPreviousInAccessQueue(ReferenceEntry<K, V> referenceEntry) {
            this.previousAccess = referenceEntry;
        }

        public final long getWriteTime() {
            return this.writeTime;
        }

        public final void setWriteTime(long j) {
            this.writeTime = j;
        }

        public final ReferenceEntry<K, V> getNextInWriteQueue() {
            return this.nextWrite;
        }

        public final void setNextInWriteQueue(ReferenceEntry<K, V> referenceEntry) {
            this.nextWrite = referenceEntry;
        }

        public final ReferenceEntry<K, V> getPreviousInWriteQueue() {
            return this.previousWrite;
        }

        public final void setPreviousInWriteQueue(ReferenceEntry<K, V> referenceEntry) {
            this.previousWrite = referenceEntry;
        }
    }

    static class WeakEntry<K, V> extends WeakReference<K> implements ReferenceEntry<K, V> {
        final int hash;
        final ReferenceEntry<K, V> next;
        volatile ValueReference<K, V> valueReference = LocalCache.unset();

        WeakEntry(ReferenceQueue<K> referenceQueue, K k, int i, ReferenceEntry<K, V> referenceEntry) {
            super(k, referenceQueue);
            this.hash = i;
            this.next = referenceEntry;
        }

        public K getKey() {
            return get();
        }

        public long getAccessTime() {
            throw new UnsupportedOperationException();
        }

        public void setAccessTime(long j) {
            throw new UnsupportedOperationException();
        }

        public ReferenceEntry<K, V> getNextInAccessQueue() {
            throw new UnsupportedOperationException();
        }

        public void setNextInAccessQueue(ReferenceEntry<K, V> referenceEntry) {
            throw new UnsupportedOperationException();
        }

        public ReferenceEntry<K, V> getPreviousInAccessQueue() {
            throw new UnsupportedOperationException();
        }

        public void setPreviousInAccessQueue(ReferenceEntry<K, V> referenceEntry) {
            throw new UnsupportedOperationException();
        }

        public long getWriteTime() {
            throw new UnsupportedOperationException();
        }

        public void setWriteTime(long j) {
            throw new UnsupportedOperationException();
        }

        public ReferenceEntry<K, V> getNextInWriteQueue() {
            throw new UnsupportedOperationException();
        }

        public void setNextInWriteQueue(ReferenceEntry<K, V> referenceEntry) {
            throw new UnsupportedOperationException();
        }

        public ReferenceEntry<K, V> getPreviousInWriteQueue() {
            throw new UnsupportedOperationException();
        }

        public void setPreviousInWriteQueue(ReferenceEntry<K, V> referenceEntry) {
            throw new UnsupportedOperationException();
        }

        public ValueReference<K, V> getValueReference() {
            return this.valueReference;
        }

        public void setValueReference(ValueReference<K, V> valueReference2) {
            this.valueReference = valueReference2;
        }

        public int getHash() {
            return this.hash;
        }

        public ReferenceEntry<K, V> getNext() {
            return this.next;
        }
    }

    static final class WeakAccessEntry<K, V> extends WeakEntry<K, V> {
        volatile long accessTime = Long.MAX_VALUE;
        ReferenceEntry<K, V> nextAccess = LocalCache.nullEntry();
        ReferenceEntry<K, V> previousAccess = LocalCache.nullEntry();

        WeakAccessEntry(ReferenceQueue<K> referenceQueue, K k, int i, ReferenceEntry<K, V> referenceEntry) {
            super(referenceQueue, k, i, referenceEntry);
        }

        public final long getAccessTime() {
            return this.accessTime;
        }

        public final void setAccessTime(long j) {
            this.accessTime = j;
        }

        public final ReferenceEntry<K, V> getNextInAccessQueue() {
            return this.nextAccess;
        }

        public final void setNextInAccessQueue(ReferenceEntry<K, V> referenceEntry) {
            this.nextAccess = referenceEntry;
        }

        public final ReferenceEntry<K, V> getPreviousInAccessQueue() {
            return this.previousAccess;
        }

        public final void setPreviousInAccessQueue(ReferenceEntry<K, V> referenceEntry) {
            this.previousAccess = referenceEntry;
        }
    }

    static final class WeakWriteEntry<K, V> extends WeakEntry<K, V> {
        ReferenceEntry<K, V> nextWrite = LocalCache.nullEntry();
        ReferenceEntry<K, V> previousWrite = LocalCache.nullEntry();
        volatile long writeTime = Long.MAX_VALUE;

        WeakWriteEntry(ReferenceQueue<K> referenceQueue, K k, int i, ReferenceEntry<K, V> referenceEntry) {
            super(referenceQueue, k, i, referenceEntry);
        }

        public final long getWriteTime() {
            return this.writeTime;
        }

        public final void setWriteTime(long j) {
            this.writeTime = j;
        }

        public final ReferenceEntry<K, V> getNextInWriteQueue() {
            return this.nextWrite;
        }

        public final void setNextInWriteQueue(ReferenceEntry<K, V> referenceEntry) {
            this.nextWrite = referenceEntry;
        }

        public final ReferenceEntry<K, V> getPreviousInWriteQueue() {
            return this.previousWrite;
        }

        public final void setPreviousInWriteQueue(ReferenceEntry<K, V> referenceEntry) {
            this.previousWrite = referenceEntry;
        }
    }

    static final class WeakAccessWriteEntry<K, V> extends WeakEntry<K, V> {
        volatile long accessTime = Long.MAX_VALUE;
        ReferenceEntry<K, V> nextAccess = LocalCache.nullEntry();
        ReferenceEntry<K, V> nextWrite = LocalCache.nullEntry();
        ReferenceEntry<K, V> previousAccess = LocalCache.nullEntry();
        ReferenceEntry<K, V> previousWrite = LocalCache.nullEntry();
        volatile long writeTime = Long.MAX_VALUE;

        WeakAccessWriteEntry(ReferenceQueue<K> referenceQueue, K k, int i, ReferenceEntry<K, V> referenceEntry) {
            super(referenceQueue, k, i, referenceEntry);
        }

        public final long getAccessTime() {
            return this.accessTime;
        }

        public final void setAccessTime(long j) {
            this.accessTime = j;
        }

        public final ReferenceEntry<K, V> getNextInAccessQueue() {
            return this.nextAccess;
        }

        public final void setNextInAccessQueue(ReferenceEntry<K, V> referenceEntry) {
            this.nextAccess = referenceEntry;
        }

        public final ReferenceEntry<K, V> getPreviousInAccessQueue() {
            return this.previousAccess;
        }

        public final void setPreviousInAccessQueue(ReferenceEntry<K, V> referenceEntry) {
            this.previousAccess = referenceEntry;
        }

        public final long getWriteTime() {
            return this.writeTime;
        }

        public final void setWriteTime(long j) {
            this.writeTime = j;
        }

        public final ReferenceEntry<K, V> getNextInWriteQueue() {
            return this.nextWrite;
        }

        public final void setNextInWriteQueue(ReferenceEntry<K, V> referenceEntry) {
            this.nextWrite = referenceEntry;
        }

        public final ReferenceEntry<K, V> getPreviousInWriteQueue() {
            return this.previousWrite;
        }

        public final void setPreviousInWriteQueue(ReferenceEntry<K, V> referenceEntry) {
            this.previousWrite = referenceEntry;
        }
    }

    static class WeakValueReference<K, V> extends WeakReference<V> implements ValueReference<K, V> {
        final ReferenceEntry<K, V> entry;

        public int getWeight() {
            return 1;
        }

        public boolean isActive() {
            return true;
        }

        public boolean isLoading() {
            return false;
        }

        public void notifyNewValue(V v) {
        }

        WeakValueReference(ReferenceQueue<V> referenceQueue, V v, ReferenceEntry<K, V> referenceEntry) {
            super(v, referenceQueue);
            this.entry = referenceEntry;
        }

        public ReferenceEntry<K, V> getEntry() {
            return this.entry;
        }

        public ValueReference<K, V> copyFor(ReferenceQueue<V> referenceQueue, V v, ReferenceEntry<K, V> referenceEntry) {
            return new WeakValueReference(referenceQueue, v, referenceEntry);
        }

        public V waitForValue() {
            return get();
        }
    }

    static class SoftValueReference<K, V> extends SoftReference<V> implements ValueReference<K, V> {
        final ReferenceEntry<K, V> entry;

        public int getWeight() {
            return 1;
        }

        public boolean isActive() {
            return true;
        }

        public boolean isLoading() {
            return false;
        }

        public void notifyNewValue(V v) {
        }

        SoftValueReference(ReferenceQueue<V> referenceQueue, V v, ReferenceEntry<K, V> referenceEntry) {
            super(v, referenceQueue);
            this.entry = referenceEntry;
        }

        public ReferenceEntry<K, V> getEntry() {
            return this.entry;
        }

        public ValueReference<K, V> copyFor(ReferenceQueue<V> referenceQueue, V v, ReferenceEntry<K, V> referenceEntry) {
            return new SoftValueReference(referenceQueue, v, referenceEntry);
        }

        public V waitForValue() {
            return get();
        }
    }

    static class StrongValueReference<K, V> implements ValueReference<K, V> {
        final V referent;

        public ValueReference<K, V> copyFor(ReferenceQueue<V> referenceQueue, V v, ReferenceEntry<K, V> referenceEntry) {
            return this;
        }

        public ReferenceEntry<K, V> getEntry() {
            return null;
        }

        public int getWeight() {
            return 1;
        }

        public boolean isActive() {
            return true;
        }

        public boolean isLoading() {
            return false;
        }

        public void notifyNewValue(V v) {
        }

        StrongValueReference(V v) {
            this.referent = v;
        }

        public V get() {
            return this.referent;
        }

        public V waitForValue() {
            return get();
        }
    }

    static final class WeightedWeakValueReference<K, V> extends WeakValueReference<K, V> {
        final int weight;

        WeightedWeakValueReference(ReferenceQueue<V> referenceQueue, V v, ReferenceEntry<K, V> referenceEntry, int i) {
            super(referenceQueue, v, referenceEntry);
            this.weight = i;
        }

        public final int getWeight() {
            return this.weight;
        }

        public final ValueReference<K, V> copyFor(ReferenceQueue<V> referenceQueue, V v, ReferenceEntry<K, V> referenceEntry) {
            return new WeightedWeakValueReference(referenceQueue, v, referenceEntry, this.weight);
        }
    }

    static final class WeightedSoftValueReference<K, V> extends SoftValueReference<K, V> {
        final int weight;

        WeightedSoftValueReference(ReferenceQueue<V> referenceQueue, V v, ReferenceEntry<K, V> referenceEntry, int i) {
            super(referenceQueue, v, referenceEntry);
            this.weight = i;
        }

        public final int getWeight() {
            return this.weight;
        }

        public final ValueReference<K, V> copyFor(ReferenceQueue<V> referenceQueue, V v, ReferenceEntry<K, V> referenceEntry) {
            return new WeightedSoftValueReference(referenceQueue, v, referenceEntry, this.weight);
        }
    }

    static final class WeightedStrongValueReference<K, V> extends StrongValueReference<K, V> {
        final int weight;

        WeightedStrongValueReference(V v, int i) {
            super(v);
            this.weight = i;
        }

        public final int getWeight() {
            return this.weight;
        }
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public ReferenceEntry<K, V> newEntry(K k, int i, ReferenceEntry<K, V> referenceEntry) {
        Segment segmentFor = segmentFor(i);
        segmentFor.lock();
        try {
            return segmentFor.newEntry(k, i, referenceEntry);
        } finally {
            segmentFor.unlock();
        }
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public ReferenceEntry<K, V> copyEntry(ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
        return segmentFor(referenceEntry.getHash()).copyEntry(referenceEntry, referenceEntry2);
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public ValueReference<K, V> newValueReference(ReferenceEntry<K, V> referenceEntry, V v, int i) {
        return this.valueStrength.referenceValue(segmentFor(referenceEntry.getHash()), referenceEntry, Preconditions.checkNotNull(v), i);
    }

    /* access modifiers changed from: package-private */
    public int hash(Object obj) {
        return rehash(this.keyEquivalence.hash(obj));
    }

    /* access modifiers changed from: package-private */
    public void reclaimValue(ValueReference<K, V> valueReference) {
        ReferenceEntry<K, V> entry = valueReference.getEntry();
        int hash = entry.getHash();
        segmentFor(hash).reclaimValue(entry.getKey(), hash, valueReference);
    }

    /* access modifiers changed from: package-private */
    public void reclaimKey(ReferenceEntry<K, V> referenceEntry) {
        int hash = referenceEntry.getHash();
        segmentFor(hash).reclaimKey(referenceEntry, hash);
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public boolean isLive(ReferenceEntry<K, V> referenceEntry, long j) {
        return segmentFor(referenceEntry.getHash()).getLiveValue(referenceEntry, j) != null;
    }

    /* access modifiers changed from: package-private */
    public Segment<K, V> segmentFor(int i) {
        return this.segments[(i >>> this.segmentShift) & this.segmentMask];
    }

    /* access modifiers changed from: package-private */
    public Segment<K, V> createSegment(int i, long j, AbstractCache.StatsCounter statsCounter) {
        return new Segment(this, i, j, statsCounter);
    }

    /* access modifiers changed from: package-private */
    public V getLiveValue(ReferenceEntry<K, V> referenceEntry, long j) {
        V v;
        if (referenceEntry.getKey() == null || (v = referenceEntry.getValueReference().get()) == null || isExpired(referenceEntry, j)) {
            return null;
        }
        return v;
    }

    /* access modifiers changed from: package-private */
    public boolean isExpired(ReferenceEntry<K, V> referenceEntry, long j) {
        Preconditions.checkNotNull(referenceEntry);
        if (expiresAfterAccess() && j - referenceEntry.getAccessTime() >= this.expireAfterAccessNanos) {
            return true;
        }
        if (!expiresAfterWrite() || j - referenceEntry.getWriteTime() < this.expireAfterWriteNanos) {
            return false;
        }
        return true;
    }

    static <K, V> void connectAccessOrder(ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
        referenceEntry.setNextInAccessQueue(referenceEntry2);
        referenceEntry2.setPreviousInAccessQueue(referenceEntry);
    }

    static <K, V> void nullifyAccessOrder(ReferenceEntry<K, V> referenceEntry) {
        ReferenceEntry nullEntry = nullEntry();
        referenceEntry.setNextInAccessQueue(nullEntry);
        referenceEntry.setPreviousInAccessQueue(nullEntry);
    }

    static <K, V> void connectWriteOrder(ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
        referenceEntry.setNextInWriteQueue(referenceEntry2);
        referenceEntry2.setPreviousInWriteQueue(referenceEntry);
    }

    static <K, V> void nullifyWriteOrder(ReferenceEntry<K, V> referenceEntry) {
        ReferenceEntry nullEntry = nullEntry();
        referenceEntry.setNextInWriteQueue(nullEntry);
        referenceEntry.setPreviousInWriteQueue(nullEntry);
    }

    /* access modifiers changed from: package-private */
    public void processPendingNotifications() {
        while (true) {
            RemovalNotification poll = this.removalNotificationQueue.poll();
            if (poll != null) {
                try {
                    this.removalListener.onRemoval(poll);
                } catch (Throwable th) {
                    logger.log(Level.WARNING, "Exception thrown by removal listener", th);
                }
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final Segment<K, V>[] newSegmentArray(int i) {
        return new Segment[i];
    }

    static class Segment<K, V> extends ReentrantLock {
        @GuardedBy("this")
        final Queue<ReferenceEntry<K, V>> accessQueue;
        volatile int count;
        final ReferenceQueue<K> keyReferenceQueue;
        @Weak
        final LocalCache<K, V> map;
        final long maxSegmentWeight;
        int modCount;
        final AtomicInteger readCount = new AtomicInteger();
        final Queue<ReferenceEntry<K, V>> recencyQueue;
        final AbstractCache.StatsCounter statsCounter;
        volatile AtomicReferenceArray<ReferenceEntry<K, V>> table;
        int threshold;
        @GuardedBy("this")
        long totalWeight;
        final ReferenceQueue<V> valueReferenceQueue;
        @GuardedBy("this")
        final Queue<ReferenceEntry<K, V>> writeQueue;

        Segment(LocalCache<K, V> localCache, int i, long j, AbstractCache.StatsCounter statsCounter2) {
            Queue<ReferenceEntry<K, V>> queue;
            Queue<ReferenceEntry<K, V>> queue2;
            Queue<ReferenceEntry<K, V>> queue3;
            this.map = localCache;
            this.maxSegmentWeight = j;
            this.statsCounter = (AbstractCache.StatsCounter) Preconditions.checkNotNull(statsCounter2);
            initTable(newEntryArray(i));
            ReferenceQueue<V> referenceQueue = null;
            this.keyReferenceQueue = localCache.usesKeyReferences() ? new ReferenceQueue<>() : null;
            this.valueReferenceQueue = localCache.usesValueReferences() ? new ReferenceQueue<>() : referenceQueue;
            if (localCache.usesAccessQueue()) {
                queue = new ConcurrentLinkedQueue<>();
            } else {
                queue = LocalCache.discardingQueue();
            }
            this.recencyQueue = queue;
            if (localCache.usesWriteQueue()) {
                queue2 = new WriteQueue<>();
            } else {
                queue2 = LocalCache.discardingQueue();
            }
            this.writeQueue = queue2;
            if (localCache.usesAccessQueue()) {
                queue3 = new AccessQueue<>();
            } else {
                queue3 = LocalCache.discardingQueue();
            }
            this.accessQueue = queue3;
        }

        /* access modifiers changed from: package-private */
        public AtomicReferenceArray<ReferenceEntry<K, V>> newEntryArray(int i) {
            return new AtomicReferenceArray<>(i);
        }

        /* access modifiers changed from: package-private */
        public void initTable(AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray) {
            this.threshold = (atomicReferenceArray.length() * 3) / 4;
            if (!this.map.customWeigher()) {
                int i = this.threshold;
                if (((long) i) == this.maxSegmentWeight) {
                    this.threshold = i + 1;
                }
            }
            this.table = atomicReferenceArray;
        }

        /* access modifiers changed from: package-private */
        @GuardedBy("this")
        public ReferenceEntry<K, V> newEntry(K k, int i, ReferenceEntry<K, V> referenceEntry) {
            return this.map.entryFactory.newEntry(this, Preconditions.checkNotNull(k), i, referenceEntry);
        }

        /* access modifiers changed from: package-private */
        @GuardedBy("this")
        public ReferenceEntry<K, V> copyEntry(ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
            if (referenceEntry.getKey() == null) {
                return null;
            }
            ValueReference<K, V> valueReference = referenceEntry.getValueReference();
            V v = valueReference.get();
            if (v == null && valueReference.isActive()) {
                return null;
            }
            ReferenceEntry<K, V> copyEntry = this.map.entryFactory.copyEntry(this, referenceEntry, referenceEntry2);
            copyEntry.setValueReference(valueReference.copyFor(this.valueReferenceQueue, v, copyEntry));
            return copyEntry;
        }

        /* access modifiers changed from: package-private */
        @GuardedBy("this")
        public void setValue(ReferenceEntry<K, V> referenceEntry, K k, V v, long j) {
            ValueReference<K, V> valueReference = referenceEntry.getValueReference();
            int weigh = this.map.weigher.weigh(k, v);
            Preconditions.checkState(weigh >= 0, "Weights must be non-negative");
            referenceEntry.setValueReference(this.map.valueStrength.referenceValue(this, referenceEntry, v, weigh));
            recordWrite(referenceEntry, weigh, j);
            valueReference.notifyNewValue(v);
        }

        /* access modifiers changed from: package-private */
        public V get(K k, int i, CacheLoader<? super K, V> cacheLoader) throws ExecutionException {
            ReferenceEntry entry;
            Preconditions.checkNotNull(k);
            Preconditions.checkNotNull(cacheLoader);
            try {
                if (!(this.count == 0 || (entry = getEntry(k, i)) == null)) {
                    long read = this.map.ticker.read();
                    Object liveValue = getLiveValue(entry, read);
                    if (liveValue != null) {
                        recordRead(entry, read);
                        this.statsCounter.recordHits(1);
                        V scheduleRefresh = scheduleRefresh(entry, k, i, liveValue, read, cacheLoader);
                        postReadCleanup();
                        return scheduleRefresh;
                    }
                    ValueReference valueReference = entry.getValueReference();
                    if (valueReference.isLoading()) {
                        V waitForLoadingValue = waitForLoadingValue(entry, k, valueReference);
                        postReadCleanup();
                        return waitForLoadingValue;
                    }
                }
                V lockedGetOrLoad = lockedGetOrLoad(k, i, cacheLoader);
                postReadCleanup();
                return lockedGetOrLoad;
            } catch (ExecutionException e) {
                Throwable cause = e.getCause();
                if (cause instanceof Error) {
                    throw new ExecutionError((Error) cause);
                } else if (cause instanceof RuntimeException) {
                    throw new UncheckedExecutionException(cause);
                } else {
                    throw e;
                }
            } catch (Throwable th) {
                postReadCleanup();
                throw th;
            }
        }

        /* access modifiers changed from: package-private */
        public V get(Object obj, int i) {
            try {
                if (this.count != 0) {
                    long read = this.map.ticker.read();
                    ReferenceEntry liveEntry = getLiveEntry(obj, i, read);
                    if (liveEntry == null) {
                        return null;
                    }
                    Object obj2 = liveEntry.getValueReference().get();
                    if (obj2 != null) {
                        recordRead(liveEntry, read);
                        V scheduleRefresh = scheduleRefresh(liveEntry, liveEntry.getKey(), i, obj2, read, this.map.defaultLoader);
                        postReadCleanup();
                        return scheduleRefresh;
                    }
                    tryDrainReferenceQueues();
                }
                postReadCleanup();
                return null;
            } finally {
                postReadCleanup();
            }
        }

        /* access modifiers changed from: package-private */
        public V lockedGetOrLoad(K k, int i, CacheLoader<? super K, V> cacheLoader) throws ExecutionException {
            LoadingValueReference loadingValueReference;
            ValueReference valueReference;
            boolean z;
            V loadSync;
            K k2 = k;
            int i2 = i;
            lock();
            try {
                long read = this.map.ticker.read();
                preWriteCleanup(read);
                int i3 = this.count - 1;
                AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.table;
                int length = i2 & (atomicReferenceArray.length() - 1);
                ReferenceEntry referenceEntry = atomicReferenceArray.get(length);
                ReferenceEntry referenceEntry2 = referenceEntry;
                while (true) {
                    loadingValueReference = null;
                    if (referenceEntry2 == null) {
                        valueReference = null;
                        break;
                    }
                    Object key = referenceEntry2.getKey();
                    if (referenceEntry2.getHash() != i2 || key == null || !this.map.keyEquivalence.equivalent(k2, key)) {
                        referenceEntry2 = referenceEntry2.getNext();
                    } else {
                        ValueReference valueReference2 = referenceEntry2.getValueReference();
                        if (valueReference2.isLoading()) {
                            z = false;
                            valueReference = valueReference2;
                        } else {
                            V v = valueReference2.get();
                            if (v == null) {
                                enqueueNotification(key, i, v, valueReference2.getWeight(), RemovalCause.COLLECTED);
                            } else if (this.map.isExpired(referenceEntry2, read)) {
                                enqueueNotification(key, i, v, valueReference2.getWeight(), RemovalCause.EXPIRED);
                            } else {
                                recordLockedRead(referenceEntry2, read);
                                this.statsCounter.recordHits(1);
                                unlock();
                                postWriteCleanup();
                                return v;
                            }
                            this.writeQueue.remove(referenceEntry2);
                            this.accessQueue.remove(referenceEntry2);
                            this.count = i3;
                            valueReference = valueReference2;
                        }
                    }
                }
                z = true;
                if (z) {
                    loadingValueReference = new LoadingValueReference();
                    if (referenceEntry2 == null) {
                        referenceEntry2 = newEntry(k2, i2, referenceEntry);
                        referenceEntry2.setValueReference(loadingValueReference);
                        atomicReferenceArray.set(length, referenceEntry2);
                    } else {
                        referenceEntry2.setValueReference(loadingValueReference);
                    }
                }
                if (!z) {
                    return waitForLoadingValue(referenceEntry2, k2, valueReference);
                }
                try {
                    synchronized (referenceEntry2) {
                        loadSync = loadSync(k2, i2, loadingValueReference, cacheLoader);
                    }
                    this.statsCounter.recordMisses(1);
                    return loadSync;
                } catch (Throwable th) {
                    this.statsCounter.recordMisses(1);
                    throw th;
                }
            } finally {
                unlock();
                postWriteCleanup();
            }
        }

        /* access modifiers changed from: package-private */
        public V waitForLoadingValue(ReferenceEntry<K, V> referenceEntry, K k, ValueReference<K, V> valueReference) throws ExecutionException {
            if (valueReference.isLoading()) {
                Preconditions.checkState(!Thread.holdsLock(referenceEntry), "Recursive load of: %s", k);
                try {
                    V waitForValue = valueReference.waitForValue();
                    if (waitForValue != null) {
                        recordRead(referenceEntry, this.map.ticker.read());
                        return waitForValue;
                    }
                    throw new CacheLoader.InvalidCacheLoadException("CacheLoader returned null for key " + ((Object) k) + ".");
                } finally {
                    this.statsCounter.recordMisses(1);
                }
            } else {
                throw new AssertionError();
            }
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Can't wrap try/catch for region: R(3:33|34|35) */
        /* JADX WARNING: Code restructure failed: missing block: B:35:0x00cc, code lost:
            throw new java.lang.AssertionError("impossible; Futures.immediateFuture can't throw");
         */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x00c5 */
        public V compute(K k, int i, BiFunction<? super K, ? super V, ? extends V> biFunction) {
            boolean z;
            ValueReference valueReference;
            boolean z2;
            boolean z3;
            BiFunction<? super K, ? super V, ? extends V> biFunction2;
            K k2 = k;
            int i2 = i;
            lock();
            try {
                long read = this.map.ticker.read();
                preWriteCleanup(read);
                AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.table;
                int length = i2 & (atomicReferenceArray.length() - 1);
                ReferenceEntry referenceEntry = atomicReferenceArray.get(length);
                ReferenceEntry referenceEntry2 = referenceEntry;
                while (true) {
                    if (referenceEntry2 == null) {
                        z = false;
                        valueReference = null;
                        z2 = true;
                        break;
                    }
                    Object key = referenceEntry2.getKey();
                    if (referenceEntry2.getHash() != i2 || key == null || !this.map.keyEquivalence.equivalent(k2, key)) {
                        referenceEntry2 = referenceEntry2.getNext();
                    } else {
                        ValueReference valueReference2 = referenceEntry2.getValueReference();
                        if (this.map.isExpired(referenceEntry2, read)) {
                            z = false;
                            enqueueNotification(key, i, valueReference2.get(), valueReference2.getWeight(), RemovalCause.EXPIRED);
                        } else {
                            z = false;
                        }
                        this.writeQueue.remove(referenceEntry2);
                        this.accessQueue.remove(referenceEntry2);
                        valueReference = valueReference2;
                        z2 = false;
                    }
                }
                LoadingValueReference loadingValueReference = new LoadingValueReference(valueReference);
                if (referenceEntry2 == null) {
                    referenceEntry2 = newEntry(k2, i2, referenceEntry);
                    referenceEntry2.setValueReference(loadingValueReference);
                    atomicReferenceArray.set(length, referenceEntry2);
                    biFunction2 = biFunction;
                    z3 = true;
                } else {
                    referenceEntry2.setValueReference(loadingValueReference);
                    z3 = z2;
                    biFunction2 = biFunction;
                }
                V compute = loadingValueReference.compute(k2, biFunction2);
                if (compute == null) {
                    if (z3) {
                        removeLoadingValue(k2, i2, loadingValueReference);
                    } else {
                        removeEntry(referenceEntry2, i2, RemovalCause.EXPLICIT);
                    }
                    unlock();
                    postWriteCleanup();
                    return null;
                } else if (valueReference == null || compute != valueReference.get()) {
                    V andRecordStats = getAndRecordStats(k2, i2, loadingValueReference, Futures.immediateFuture(compute));
                    unlock();
                    postWriteCleanup();
                    return andRecordStats;
                } else {
                    loadingValueReference.set(compute);
                    referenceEntry2.setValueReference(valueReference);
                    recordWrite(referenceEntry2, z, read);
                    return compute;
                }
            } finally {
                unlock();
                postWriteCleanup();
            }
        }

        /* access modifiers changed from: package-private */
        public V loadSync(K k, int i, LoadingValueReference<K, V> loadingValueReference, CacheLoader<? super K, V> cacheLoader) throws ExecutionException {
            return getAndRecordStats(k, i, loadingValueReference, loadingValueReference.loadFuture(k, cacheLoader));
        }

        /* access modifiers changed from: package-private */
        public ListenableFuture<V> loadAsync(K k, int i, LoadingValueReference<K, V> loadingValueReference, CacheLoader<? super K, V> cacheLoader) {
            ListenableFuture<V> loadFuture = loadingValueReference.loadFuture(k, cacheLoader);
            final K k2 = k;
            final int i2 = i;
            final LoadingValueReference<K, V> loadingValueReference2 = loadingValueReference;
            final ListenableFuture<V> listenableFuture = loadFuture;
            loadFuture.addListener(new Runnable() {
                /* class com.google.common.cache.LocalCache.Segment.AnonymousClass1 */

                public void run() {
                    try {
                        Segment.this.getAndRecordStats(k2, i2, loadingValueReference2, listenableFuture);
                    } catch (Throwable th) {
                        LocalCache.logger.log(Level.WARNING, "Exception thrown during refresh", th);
                        loadingValueReference2.setException(th);
                    }
                }
            }, MoreExecutors.directExecutor());
            return loadFuture;
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Removed duplicated region for block: B:15:0x0040  */
        public V getAndRecordStats(K k, int i, LoadingValueReference<K, V> loadingValueReference, ListenableFuture<V> listenableFuture) throws ExecutionException {
            V v;
            try {
                v = Uninterruptibles.getUninterruptibly(listenableFuture);
                if (v != null) {
                    try {
                        this.statsCounter.recordLoadSuccess(loadingValueReference.elapsedNanos());
                        storeLoadedValue(k, i, loadingValueReference, v);
                        if (v == null) {
                            this.statsCounter.recordLoadException(loadingValueReference.elapsedNanos());
                            removeLoadingValue(k, i, loadingValueReference);
                        }
                        return v;
                    } catch (Throwable th) {
                        th = th;
                        if (v == null) {
                            this.statsCounter.recordLoadException(loadingValueReference.elapsedNanos());
                            removeLoadingValue(k, i, loadingValueReference);
                        }
                        throw th;
                    }
                } else {
                    throw new CacheLoader.InvalidCacheLoadException("CacheLoader returned null for key " + ((Object) k) + ".");
                }
            } catch (Throwable th2) {
                th = th2;
                v = null;
                if (v == null) {
                }
                throw th;
            }
        }

        /* access modifiers changed from: package-private */
        public V scheduleRefresh(ReferenceEntry<K, V> referenceEntry, K k, int i, V v, long j, CacheLoader<? super K, V> cacheLoader) {
            V refresh;
            return (!this.map.refreshes() || j - referenceEntry.getWriteTime() <= this.map.refreshNanos || referenceEntry.getValueReference().isLoading() || (refresh = refresh(k, i, cacheLoader, true)) == null) ? v : refresh;
        }

        /* access modifiers changed from: package-private */
        public V refresh(K k, int i, CacheLoader<? super K, V> cacheLoader, boolean z) {
            LoadingValueReference insertLoadingValueReference = insertLoadingValueReference(k, i, z);
            if (insertLoadingValueReference == null) {
                return null;
            }
            ListenableFuture<V> loadAsync = loadAsync(k, i, insertLoadingValueReference, cacheLoader);
            if (loadAsync.isDone()) {
                try {
                    return Uninterruptibles.getUninterruptibly(loadAsync);
                } catch (Throwable unused) {
                }
            }
            return null;
        }

        /* JADX INFO: finally extract failed */
        /* access modifiers changed from: package-private */
        public LoadingValueReference<K, V> insertLoadingValueReference(K k, int i, boolean z) {
            lock();
            try {
                long read = this.map.ticker.read();
                preWriteCleanup(read);
                AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i;
                ReferenceEntry referenceEntry = atomicReferenceArray.get(length);
                ReferenceEntry referenceEntry2 = referenceEntry;
                while (referenceEntry2 != null) {
                    Object key = referenceEntry2.getKey();
                    if (referenceEntry2.getHash() != i || key == null || !this.map.keyEquivalence.equivalent(k, key)) {
                        referenceEntry2 = referenceEntry2.getNext();
                    } else {
                        ValueReference valueReference = referenceEntry2.getValueReference();
                        if (!valueReference.isLoading()) {
                            if (!z || read - referenceEntry2.getWriteTime() >= this.map.refreshNanos) {
                                this.modCount++;
                                LoadingValueReference<K, V> loadingValueReference = new LoadingValueReference<>(valueReference);
                                referenceEntry2.setValueReference(loadingValueReference);
                                unlock();
                                postWriteCleanup();
                                return loadingValueReference;
                            }
                        }
                        unlock();
                        postWriteCleanup();
                        return null;
                    }
                }
                this.modCount++;
                LoadingValueReference<K, V> loadingValueReference2 = new LoadingValueReference<>();
                ReferenceEntry newEntry = newEntry(k, i, referenceEntry);
                newEntry.setValueReference(loadingValueReference2);
                atomicReferenceArray.set(length, newEntry);
                unlock();
                postWriteCleanup();
                return loadingValueReference2;
            } catch (Throwable th) {
                unlock();
                postWriteCleanup();
                throw th;
            }
        }

        /* access modifiers changed from: package-private */
        public void tryDrainReferenceQueues() {
            if (tryLock()) {
                try {
                    drainReferenceQueues();
                } finally {
                    unlock();
                }
            }
        }

        /* access modifiers changed from: package-private */
        @GuardedBy("this")
        public void drainReferenceQueues() {
            if (this.map.usesKeyReferences()) {
                drainKeyReferenceQueue();
            }
            if (this.map.usesValueReferences()) {
                drainValueReferenceQueue();
            }
        }

        /* access modifiers changed from: package-private */
        @GuardedBy("this")
        public void drainKeyReferenceQueue() {
            int i = 0;
            do {
                Reference<? extends K> poll = this.keyReferenceQueue.poll();
                if (poll != null) {
                    this.map.reclaimKey((ReferenceEntry) poll);
                    i++;
                } else {
                    return;
                }
            } while (i != 16);
        }

        /* access modifiers changed from: package-private */
        @GuardedBy("this")
        public void drainValueReferenceQueue() {
            int i = 0;
            do {
                Reference<? extends V> poll = this.valueReferenceQueue.poll();
                if (poll != null) {
                    this.map.reclaimValue((ValueReference) poll);
                    i++;
                } else {
                    return;
                }
            } while (i != 16);
        }

        /* access modifiers changed from: package-private */
        public void clearReferenceQueues() {
            if (this.map.usesKeyReferences()) {
                clearKeyReferenceQueue();
            }
            if (this.map.usesValueReferences()) {
                clearValueReferenceQueue();
            }
        }

        /* access modifiers changed from: package-private */
        public void clearKeyReferenceQueue() {
            do {
            } while (this.keyReferenceQueue.poll() != null);
        }

        /* access modifiers changed from: package-private */
        public void clearValueReferenceQueue() {
            do {
            } while (this.valueReferenceQueue.poll() != null);
        }

        /* access modifiers changed from: package-private */
        public void recordRead(ReferenceEntry<K, V> referenceEntry, long j) {
            if (this.map.recordsAccess()) {
                referenceEntry.setAccessTime(j);
            }
            this.recencyQueue.add(referenceEntry);
        }

        /* access modifiers changed from: package-private */
        @GuardedBy("this")
        public void recordLockedRead(ReferenceEntry<K, V> referenceEntry, long j) {
            if (this.map.recordsAccess()) {
                referenceEntry.setAccessTime(j);
            }
            this.accessQueue.add(referenceEntry);
        }

        /* access modifiers changed from: package-private */
        @GuardedBy("this")
        public void recordWrite(ReferenceEntry<K, V> referenceEntry, int i, long j) {
            drainRecencyQueue();
            this.totalWeight += (long) i;
            if (this.map.recordsAccess()) {
                referenceEntry.setAccessTime(j);
            }
            if (this.map.recordsWrite()) {
                referenceEntry.setWriteTime(j);
            }
            this.accessQueue.add(referenceEntry);
            this.writeQueue.add(referenceEntry);
        }

        /* access modifiers changed from: package-private */
        @GuardedBy("this")
        public void drainRecencyQueue() {
            while (true) {
                ReferenceEntry poll = this.recencyQueue.poll();
                if (poll == null) {
                    return;
                }
                if (this.accessQueue.contains(poll)) {
                    this.accessQueue.add(poll);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void tryExpireEntries(long j) {
            if (tryLock()) {
                try {
                    expireEntries(j);
                } finally {
                    unlock();
                }
            }
        }

        /* access modifiers changed from: package-private */
        @GuardedBy("this")
        public void expireEntries(long j) {
            ReferenceEntry peek;
            ReferenceEntry peek2;
            drainRecencyQueue();
            do {
                peek = this.writeQueue.peek();
                if (peek == null || !this.map.isExpired(peek, j)) {
                    do {
                        peek2 = this.accessQueue.peek();
                        if (peek2 == null || !this.map.isExpired(peek2, j)) {
                            return;
                        }
                    } while (removeEntry(peek2, peek2.getHash(), RemovalCause.EXPIRED));
                    throw new AssertionError();
                }
            } while (removeEntry(peek, peek.getHash(), RemovalCause.EXPIRED));
            throw new AssertionError();
        }

        /* access modifiers changed from: package-private */
        @GuardedBy("this")
        public void enqueueNotification(K k, int i, V v, int i2, RemovalCause removalCause) {
            this.totalWeight -= (long) i2;
            if (removalCause.wasEvicted()) {
                this.statsCounter.recordEviction();
            }
            if (this.map.removalNotificationQueue != LocalCache.DISCARDING_QUEUE) {
                this.map.removalNotificationQueue.offer(RemovalNotification.create(k, v, removalCause));
            }
        }

        /* access modifiers changed from: package-private */
        @GuardedBy("this")
        public void evictEntries(ReferenceEntry<K, V> referenceEntry) {
            if (this.map.evictsBySize()) {
                drainRecencyQueue();
                if (((long) referenceEntry.getValueReference().getWeight()) <= this.maxSegmentWeight || removeEntry(referenceEntry, referenceEntry.getHash(), RemovalCause.SIZE)) {
                    while (this.totalWeight > this.maxSegmentWeight) {
                        ReferenceEntry nextEvictable = getNextEvictable();
                        if (!removeEntry(nextEvictable, nextEvictable.getHash(), RemovalCause.SIZE)) {
                            throw new AssertionError();
                        }
                    }
                    return;
                }
                throw new AssertionError();
            }
        }

        /* access modifiers changed from: package-private */
        @GuardedBy("this")
        public ReferenceEntry<K, V> getNextEvictable() {
            for (ReferenceEntry<K, V> next : this.accessQueue) {
                if (next.getValueReference().getWeight() > 0) {
                    return next;
                }
            }
            throw new AssertionError();
        }

        /* access modifiers changed from: package-private */
        public ReferenceEntry<K, V> getFirst(int i) {
            AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.table;
            return atomicReferenceArray.get(i & (atomicReferenceArray.length() - 1));
        }

        /* access modifiers changed from: package-private */
        public ReferenceEntry<K, V> getEntry(Object obj, int i) {
            for (ReferenceEntry<K, V> first = getFirst(i); first != null; first = first.getNext()) {
                if (first.getHash() == i) {
                    K key = first.getKey();
                    if (key == null) {
                        tryDrainReferenceQueues();
                    } else if (this.map.keyEquivalence.equivalent(obj, key)) {
                        return first;
                    }
                }
            }
            return null;
        }

        /* access modifiers changed from: package-private */
        public ReferenceEntry<K, V> getLiveEntry(Object obj, int i, long j) {
            ReferenceEntry<K, V> entry = getEntry(obj, i);
            if (entry == null) {
                return null;
            }
            if (!this.map.isExpired(entry, j)) {
                return entry;
            }
            tryExpireEntries(j);
            return null;
        }

        /* access modifiers changed from: package-private */
        public V getLiveValue(ReferenceEntry<K, V> referenceEntry, long j) {
            if (referenceEntry.getKey() == null) {
                tryDrainReferenceQueues();
                return null;
            }
            V v = referenceEntry.getValueReference().get();
            if (v == null) {
                tryDrainReferenceQueues();
                return null;
            } else if (!this.map.isExpired(referenceEntry, j)) {
                return v;
            } else {
                tryExpireEntries(j);
                return null;
            }
        }

        /* access modifiers changed from: package-private */
        public boolean containsKey(Object obj, int i) {
            try {
                boolean z = false;
                if (this.count != 0) {
                    ReferenceEntry liveEntry = getLiveEntry(obj, i, this.map.ticker.read());
                    if (liveEntry == null) {
                        return false;
                    }
                    if (liveEntry.getValueReference().get() != null) {
                        z = true;
                    }
                    postReadCleanup();
                    return z;
                }
                postReadCleanup();
                return false;
            } finally {
                postReadCleanup();
            }
        }

        /* JADX INFO: finally extract failed */
        /* access modifiers changed from: package-private */
        @VisibleForTesting
        public boolean containsValue(Object obj) {
            try {
                if (this.count != 0) {
                    long read = this.map.ticker.read();
                    AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.table;
                    int length = atomicReferenceArray.length();
                    for (int i = 0; i < length; i++) {
                        ReferenceEntry referenceEntry = atomicReferenceArray.get(i);
                        while (referenceEntry != null) {
                            Object liveValue = getLiveValue(referenceEntry, read);
                            if (liveValue == null || !this.map.valueEquivalence.equivalent(obj, liveValue)) {
                                referenceEntry = referenceEntry.getNext();
                            } else {
                                postReadCleanup();
                                return true;
                            }
                        }
                    }
                }
                postReadCleanup();
                return false;
            } catch (Throwable th) {
                postReadCleanup();
                throw th;
            }
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0049, code lost:
            r1 = r12.getValueReference();
            r10 = r1.get();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0051, code lost:
            if (r10 != null) goto L_0x0092;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0053, code lost:
            r7.modCount++;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x005d, code lost:
            if (r1.isActive() == false) goto L_0x0079;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x005f, code lost:
            enqueueNotification(r15, r16, r10, r1.getWeight(), com.google.common.cache.RemovalCause.COLLECTED);
            setValue(r12, r15, r17, r8);
            r0 = r7.count;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0079, code lost:
            setValue(r12, r15, r17, r8);
            r0 = r7.count + 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0086, code lost:
            r7.count = r0;
            evictEntries(r12);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0092, code lost:
            if (r18 == false) goto L_0x009e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
            recordLockedRead(r12, r8);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x0097, code lost:
            unlock();
            postWriteCleanup();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x009d, code lost:
            return r10;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
            r7.modCount++;
            enqueueNotification(r15, r16, r10, r1.getWeight(), com.google.common.cache.RemovalCause.REPLACED);
            setValue(r12, r15, r17, r8);
            evictEntries(r12);
         */
        public V put(K k, int i, V v, boolean z) {
            int i2 = i;
            lock();
            try {
                long read = this.map.ticker.read();
                preWriteCleanup(read);
                if (this.count + 1 > this.threshold) {
                    expand();
                    int i3 = this.count;
                }
                AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.table;
                int length = i2 & (atomicReferenceArray.length() - 1);
                ReferenceEntry referenceEntry = atomicReferenceArray.get(length);
                ReferenceEntry referenceEntry2 = referenceEntry;
                while (true) {
                    if (referenceEntry2 == null) {
                        this.modCount++;
                        ReferenceEntry newEntry = newEntry(k, i2, referenceEntry);
                        setValue(newEntry, k, v, read);
                        atomicReferenceArray.set(length, newEntry);
                        this.count++;
                        evictEntries(newEntry);
                        break;
                    }
                    Object key = referenceEntry2.getKey();
                    if (referenceEntry2.getHash() == i2 && key != null && this.map.keyEquivalence.equivalent(k, key)) {
                        break;
                    }
                    referenceEntry2 = referenceEntry2.getNext();
                }
                return null;
            } finally {
                unlock();
                postWriteCleanup();
            }
        }

        /* access modifiers changed from: package-private */
        @GuardedBy("this")
        public void expand() {
            AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.table;
            int length = atomicReferenceArray.length();
            if (length < 1073741824) {
                int i = this.count;
                AtomicReferenceArray<ReferenceEntry<K, V>> newEntryArray = newEntryArray(length << 1);
                this.threshold = (newEntryArray.length() * 3) / 4;
                int length2 = newEntryArray.length() - 1;
                for (int i2 = 0; i2 < length; i2++) {
                    ReferenceEntry referenceEntry = atomicReferenceArray.get(i2);
                    if (referenceEntry != null) {
                        ReferenceEntry next = referenceEntry.getNext();
                        int hash = referenceEntry.getHash() & length2;
                        if (next == null) {
                            newEntryArray.set(hash, referenceEntry);
                        } else {
                            ReferenceEntry referenceEntry2 = referenceEntry;
                            while (next != null) {
                                int hash2 = next.getHash() & length2;
                                if (hash2 != hash) {
                                    referenceEntry2 = next;
                                    hash = hash2;
                                }
                                next = next.getNext();
                            }
                            newEntryArray.set(hash, referenceEntry2);
                            while (referenceEntry != referenceEntry2) {
                                int hash3 = referenceEntry.getHash() & length2;
                                ReferenceEntry copyEntry = copyEntry(referenceEntry, newEntryArray.get(hash3));
                                if (copyEntry != null) {
                                    newEntryArray.set(hash3, copyEntry);
                                } else {
                                    removeCollectedEntry(referenceEntry);
                                    i--;
                                }
                                referenceEntry = referenceEntry.getNext();
                            }
                        }
                    }
                }
                this.table = newEntryArray;
                this.count = i;
            }
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:10:0x003f, code lost:
            r16 = r13.getValueReference();
            r6 = r16.get();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0047, code lost:
            if (r6 != null) goto L_0x0072;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x004d, code lost:
            if (r16.isActive() == false) goto L_0x006b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x004f, code lost:
            r1 = r9.count;
            r9.modCount++;
            r10.set(r12, removeValueFromChain(r2, r13, r4, r19, r6, r16, com.google.common.cache.RemovalCause.COLLECTED));
            r9.count--;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x007c, code lost:
            if (r9.map.valueEquivalence.equivalent(r20, r6) == false) goto L_0x00a9;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x007e, code lost:
            r9.modCount++;
            enqueueNotification(r18, r19, r6, r16.getWeight(), com.google.common.cache.RemovalCause.REPLACED);
            setValue(r13, r18, r21, r7);
            evictEntries(r13);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x00a2, code lost:
            unlock();
            postWriteCleanup();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x00a8, code lost:
            return true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
            recordLockedRead(r13, r7);
         */
        public boolean replace(K k, int i, V v, V v2) {
            int i2 = i;
            lock();
            try {
                long read = this.map.ticker.read();
                preWriteCleanup(read);
                AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.table;
                int length = i2 & (atomicReferenceArray.length() - 1);
                ReferenceEntry referenceEntry = atomicReferenceArray.get(length);
                ReferenceEntry referenceEntry2 = referenceEntry;
                while (true) {
                    if (referenceEntry2 == null) {
                        break;
                    }
                    Object key = referenceEntry2.getKey();
                    if (referenceEntry2.getHash() != i2 || key == null) {
                        K k2 = k;
                    } else if (this.map.keyEquivalence.equivalent(k, key)) {
                        break;
                    }
                    V v3 = v;
                    referenceEntry2 = referenceEntry2.getNext();
                }
                return false;
            } finally {
                unlock();
                postWriteCleanup();
            }
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:10:0x003f, code lost:
            r15 = r12.getValueReference();
            r16 = r15.get();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0047, code lost:
            if (r16 != null) goto L_0x0075;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x004d, code lost:
            if (r15.isActive() == false) goto L_0x006e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x004f, code lost:
            r1 = r9.count;
            r9.modCount++;
            r10.set(r11, removeValueFromChain(r2, r12, r4, r19, r16, r15, com.google.common.cache.RemovalCause.COLLECTED));
            r9.count--;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
            r9.modCount++;
            enqueueNotification(r18, r19, r16, r15.getWeight(), com.google.common.cache.RemovalCause.REPLACED);
            setValue(r12, r18, r20, r7);
            evictEntries(r12);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x009a, code lost:
            unlock();
            postWriteCleanup();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x00a0, code lost:
            return r16;
         */
        public V replace(K k, int i, V v) {
            int i2 = i;
            lock();
            try {
                long read = this.map.ticker.read();
                preWriteCleanup(read);
                AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.table;
                int length = i2 & (atomicReferenceArray.length() - 1);
                ReferenceEntry referenceEntry = atomicReferenceArray.get(length);
                ReferenceEntry referenceEntry2 = referenceEntry;
                while (true) {
                    if (referenceEntry2 == null) {
                        break;
                    }
                    Object key = referenceEntry2.getKey();
                    if (referenceEntry2.getHash() == i2 && key != null) {
                        if (this.map.keyEquivalence.equivalent(k, key)) {
                            break;
                        }
                    }
                    referenceEntry2 = referenceEntry2.getNext();
                }
                return null;
            } finally {
                unlock();
                postWriteCleanup();
            }
        }

        /* access modifiers changed from: package-private */
        public V remove(Object obj, int i) {
            RemovalCause removalCause;
            lock();
            try {
                preWriteCleanup(this.map.ticker.read());
                int i2 = this.count;
                AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i;
                ReferenceEntry referenceEntry = atomicReferenceArray.get(length);
                ReferenceEntry referenceEntry2 = referenceEntry;
                while (true) {
                    if (referenceEntry2 == null) {
                        break;
                    }
                    Object key = referenceEntry2.getKey();
                    if (referenceEntry2.getHash() != i || key == null || !this.map.keyEquivalence.equivalent(obj, key)) {
                        referenceEntry2 = referenceEntry2.getNext();
                    } else {
                        ValueReference valueReference = referenceEntry2.getValueReference();
                        V v = valueReference.get();
                        if (v != null) {
                            removalCause = RemovalCause.EXPLICIT;
                        } else if (valueReference.isActive()) {
                            removalCause = RemovalCause.COLLECTED;
                        }
                        RemovalCause removalCause2 = removalCause;
                        this.modCount++;
                        atomicReferenceArray.set(length, removeValueFromChain(referenceEntry, referenceEntry2, key, i, v, valueReference, removalCause2));
                        this.count--;
                        return v;
                    }
                }
                unlock();
                postWriteCleanup();
                return null;
            } finally {
                unlock();
                postWriteCleanup();
            }
        }

        /* access modifiers changed from: package-private */
        public boolean remove(Object obj, int i, Object obj2) {
            RemovalCause removalCause;
            lock();
            try {
                preWriteCleanup(this.map.ticker.read());
                int i2 = this.count;
                AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.table;
                boolean z = true;
                int length = (atomicReferenceArray.length() - 1) & i;
                ReferenceEntry referenceEntry = atomicReferenceArray.get(length);
                ReferenceEntry referenceEntry2 = referenceEntry;
                while (true) {
                    if (referenceEntry2 == null) {
                        break;
                    }
                    Object key = referenceEntry2.getKey();
                    if (referenceEntry2.getHash() != i || key == null || !this.map.keyEquivalence.equivalent(obj, key)) {
                        referenceEntry2 = referenceEntry2.getNext();
                    } else {
                        ValueReference valueReference = referenceEntry2.getValueReference();
                        Object obj3 = valueReference.get();
                        if (this.map.valueEquivalence.equivalent(obj2, obj3)) {
                            removalCause = RemovalCause.EXPLICIT;
                        } else if (obj3 == null && valueReference.isActive()) {
                            removalCause = RemovalCause.COLLECTED;
                        }
                        this.modCount++;
                        atomicReferenceArray.set(length, removeValueFromChain(referenceEntry, referenceEntry2, key, i, obj3, valueReference, removalCause));
                        this.count--;
                        if (removalCause != RemovalCause.EXPLICIT) {
                            z = false;
                        }
                        return z;
                    }
                }
                unlock();
                postWriteCleanup();
                return false;
            } finally {
                unlock();
                postWriteCleanup();
            }
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x004a, code lost:
            r1 = r14.getValueReference();
            r4 = r1.get();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0054, code lost:
            if (r18 == r1) goto L_0x0072;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0056, code lost:
            if (r4 != null) goto L_0x005d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x005a, code lost:
            if (r1 == com.google.common.cache.LocalCache.UNSET) goto L_0x005d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x005d, code lost:
            enqueueNotification(r16, r17, r19, 0, com.google.common.cache.RemovalCause.REPLACED);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x006a, code lost:
            unlock();
            postWriteCleanup();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0071, code lost:
            return false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
            r7.modCount++;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x007b, code lost:
            if (r18.isActive() == false) goto L_0x0093;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x007d, code lost:
            if (r4 != null) goto L_0x0082;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x007f, code lost:
            r1 = com.google.common.cache.RemovalCause.COLLECTED;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x0082, code lost:
            r1 = com.google.common.cache.RemovalCause.REPLACED;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x0084, code lost:
            enqueueNotification(r16, r17, r4, r18.getWeight(), r1);
            r11 = r11 - 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x0093, code lost:
            setValue(r14, r16, r19, r8);
            r7.count = r11;
            evictEntries(r14);
         */
        public boolean storeLoadedValue(K k, int i, LoadingValueReference<K, V> loadingValueReference, V v) {
            K k2 = k;
            int i2 = i;
            lock();
            try {
                long read = this.map.ticker.read();
                preWriteCleanup(read);
                int i3 = this.count + 1;
                if (i3 > this.threshold) {
                    expand();
                    i3 = this.count + 1;
                }
                int i4 = i3;
                AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.table;
                int length = i2 & (atomicReferenceArray.length() - 1);
                ReferenceEntry referenceEntry = atomicReferenceArray.get(length);
                ReferenceEntry referenceEntry2 = referenceEntry;
                while (true) {
                    if (referenceEntry2 == null) {
                        this.modCount++;
                        ReferenceEntry newEntry = newEntry(k2, i2, referenceEntry);
                        setValue(newEntry, k, v, read);
                        atomicReferenceArray.set(length, newEntry);
                        this.count = i4;
                        evictEntries(newEntry);
                        break;
                    }
                    Object key = referenceEntry2.getKey();
                    if (referenceEntry2.getHash() == i2 && key != null && this.map.keyEquivalence.equivalent(k2, key)) {
                        break;
                    }
                    referenceEntry2 = referenceEntry2.getNext();
                }
                return true;
            } finally {
                unlock();
                postWriteCleanup();
            }
        }

        /* access modifiers changed from: package-private */
        public void clear() {
            RemovalCause removalCause;
            if (this.count != 0) {
                lock();
                try {
                    preWriteCleanup(this.map.ticker.read());
                    AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.table;
                    for (int i = 0; i < atomicReferenceArray.length(); i++) {
                        for (ReferenceEntry referenceEntry = atomicReferenceArray.get(i); referenceEntry != null; referenceEntry = referenceEntry.getNext()) {
                            if (referenceEntry.getValueReference().isActive()) {
                                Object key = referenceEntry.getKey();
                                Object obj = referenceEntry.getValueReference().get();
                                if (key != null) {
                                    if (obj != null) {
                                        removalCause = RemovalCause.EXPLICIT;
                                        enqueueNotification(key, referenceEntry.getHash(), obj, referenceEntry.getValueReference().getWeight(), removalCause);
                                    }
                                }
                                removalCause = RemovalCause.COLLECTED;
                                enqueueNotification(key, referenceEntry.getHash(), obj, referenceEntry.getValueReference().getWeight(), removalCause);
                            }
                        }
                    }
                    for (int i2 = 0; i2 < atomicReferenceArray.length(); i2++) {
                        atomicReferenceArray.set(i2, null);
                    }
                    clearReferenceQueues();
                    this.writeQueue.clear();
                    this.accessQueue.clear();
                    this.readCount.set(0);
                    this.modCount++;
                    this.count = 0;
                } finally {
                    unlock();
                    postWriteCleanup();
                }
            }
        }

        /* access modifiers changed from: package-private */
        @GuardedBy("this")
        public ReferenceEntry<K, V> removeValueFromChain(ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2, K k, int i, V v, ValueReference<K, V> valueReference, RemovalCause removalCause) {
            enqueueNotification(k, i, v, valueReference.getWeight(), removalCause);
            this.writeQueue.remove(referenceEntry2);
            this.accessQueue.remove(referenceEntry2);
            if (!valueReference.isLoading()) {
                return removeEntryFromChain(referenceEntry, referenceEntry2);
            }
            valueReference.notifyNewValue(null);
            return referenceEntry;
        }

        /* access modifiers changed from: package-private */
        @GuardedBy("this")
        public ReferenceEntry<K, V> removeEntryFromChain(ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
            int i = this.count;
            ReferenceEntry<K, V> next = referenceEntry2.getNext();
            while (referenceEntry != referenceEntry2) {
                ReferenceEntry<K, V> copyEntry = copyEntry(referenceEntry, next);
                if (copyEntry != null) {
                    next = copyEntry;
                } else {
                    removeCollectedEntry(referenceEntry);
                    i--;
                }
                referenceEntry = referenceEntry.getNext();
            }
            this.count = i;
            return next;
        }

        /* access modifiers changed from: package-private */
        @GuardedBy("this")
        public void removeCollectedEntry(ReferenceEntry<K, V> referenceEntry) {
            enqueueNotification(referenceEntry.getKey(), referenceEntry.getHash(), referenceEntry.getValueReference().get(), referenceEntry.getValueReference().getWeight(), RemovalCause.COLLECTED);
            this.writeQueue.remove(referenceEntry);
            this.accessQueue.remove(referenceEntry);
        }

        /* access modifiers changed from: package-private */
        public boolean reclaimKey(ReferenceEntry<K, V> referenceEntry, int i) {
            lock();
            try {
                int i2 = this.count;
                AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i;
                ReferenceEntry<K, V> referenceEntry2 = atomicReferenceArray.get(length);
                for (ReferenceEntry<K, V> referenceEntry3 = referenceEntry2; referenceEntry3 != null; referenceEntry3 = referenceEntry3.getNext()) {
                    if (referenceEntry3 == referenceEntry) {
                        this.modCount++;
                        atomicReferenceArray.set(length, removeValueFromChain(referenceEntry2, referenceEntry3, referenceEntry3.getKey(), i, referenceEntry3.getValueReference().get(), referenceEntry3.getValueReference(), RemovalCause.COLLECTED));
                        this.count--;
                        return true;
                    }
                }
                unlock();
                postWriteCleanup();
                return false;
            } finally {
                unlock();
                postWriteCleanup();
            }
        }

        /* access modifiers changed from: package-private */
        public boolean reclaimValue(K k, int i, ValueReference<K, V> valueReference) {
            lock();
            try {
                int i2 = this.count;
                AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i;
                ReferenceEntry referenceEntry = atomicReferenceArray.get(length);
                ReferenceEntry referenceEntry2 = referenceEntry;
                while (referenceEntry2 != null) {
                    Object key = referenceEntry2.getKey();
                    if (referenceEntry2.getHash() != i || key == null || !this.map.keyEquivalence.equivalent(k, key)) {
                        referenceEntry2 = referenceEntry2.getNext();
                    } else if (referenceEntry2.getValueReference() == valueReference) {
                        this.modCount++;
                        atomicReferenceArray.set(length, removeValueFromChain(referenceEntry, referenceEntry2, key, i, valueReference.get(), valueReference, RemovalCause.COLLECTED));
                        this.count--;
                        return true;
                    } else {
                        unlock();
                        if (!isHeldByCurrentThread()) {
                            postWriteCleanup();
                        }
                        return false;
                    }
                }
                unlock();
                if (!isHeldByCurrentThread()) {
                    postWriteCleanup();
                }
                return false;
            } finally {
                unlock();
                if (!isHeldByCurrentThread()) {
                    postWriteCleanup();
                }
            }
        }

        /* access modifiers changed from: package-private */
        public boolean removeLoadingValue(K k, int i, LoadingValueReference<K, V> loadingValueReference) {
            lock();
            try {
                AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i;
                ReferenceEntry referenceEntry = atomicReferenceArray.get(length);
                ReferenceEntry referenceEntry2 = referenceEntry;
                while (true) {
                    if (referenceEntry2 == null) {
                        break;
                    }
                    Object key = referenceEntry2.getKey();
                    if (referenceEntry2.getHash() != i || key == null || !this.map.keyEquivalence.equivalent(k, key)) {
                        referenceEntry2 = referenceEntry2.getNext();
                    } else if (referenceEntry2.getValueReference() == loadingValueReference) {
                        if (loadingValueReference.isActive()) {
                            referenceEntry2.setValueReference(loadingValueReference.getOldValue());
                        } else {
                            atomicReferenceArray.set(length, removeEntryFromChain(referenceEntry, referenceEntry2));
                        }
                        return true;
                    }
                }
                unlock();
                postWriteCleanup();
                return false;
            } finally {
                unlock();
                postWriteCleanup();
            }
        }

        /* access modifiers changed from: package-private */
        @VisibleForTesting
        @GuardedBy("this")
        public boolean removeEntry(ReferenceEntry<K, V> referenceEntry, int i, RemovalCause removalCause) {
            int i2 = this.count;
            AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.table;
            int length = (atomicReferenceArray.length() - 1) & i;
            ReferenceEntry<K, V> referenceEntry2 = atomicReferenceArray.get(length);
            for (ReferenceEntry<K, V> referenceEntry3 = referenceEntry2; referenceEntry3 != null; referenceEntry3 = referenceEntry3.getNext()) {
                if (referenceEntry3 == referenceEntry) {
                    this.modCount++;
                    atomicReferenceArray.set(length, removeValueFromChain(referenceEntry2, referenceEntry3, referenceEntry3.getKey(), i, referenceEntry3.getValueReference().get(), referenceEntry3.getValueReference(), removalCause));
                    this.count--;
                    return true;
                }
            }
            return false;
        }

        /* access modifiers changed from: package-private */
        public void postReadCleanup() {
            if ((this.readCount.incrementAndGet() & 63) == 0) {
                cleanUp();
            }
        }

        /* access modifiers changed from: package-private */
        @GuardedBy("this")
        public void preWriteCleanup(long j) {
            runLockedCleanup(j);
        }

        /* access modifiers changed from: package-private */
        public void postWriteCleanup() {
            runUnlockedCleanup();
        }

        /* access modifiers changed from: package-private */
        public void cleanUp() {
            runLockedCleanup(this.map.ticker.read());
            runUnlockedCleanup();
        }

        /* access modifiers changed from: package-private */
        public void runLockedCleanup(long j) {
            if (tryLock()) {
                try {
                    drainReferenceQueues();
                    expireEntries(j);
                    this.readCount.set(0);
                } finally {
                    unlock();
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void runUnlockedCleanup() {
            if (!isHeldByCurrentThread()) {
                this.map.processPendingNotifications();
            }
        }
    }

    static class LoadingValueReference<K, V> implements ValueReference<K, V> {
        final SettableFuture<V> futureValue;
        volatile ValueReference<K, V> oldValue;
        final Stopwatch stopwatch;

        public ValueReference<K, V> copyFor(ReferenceQueue<V> referenceQueue, V v, ReferenceEntry<K, V> referenceEntry) {
            return this;
        }

        public ReferenceEntry<K, V> getEntry() {
            return null;
        }

        public boolean isLoading() {
            return true;
        }

        public LoadingValueReference() {
            this(null);
        }

        public LoadingValueReference(ValueReference<K, V> valueReference) {
            this.futureValue = SettableFuture.create();
            this.stopwatch = Stopwatch.createUnstarted();
            this.oldValue = valueReference == null ? LocalCache.unset() : valueReference;
        }

        public boolean isActive() {
            return this.oldValue.isActive();
        }

        public int getWeight() {
            return this.oldValue.getWeight();
        }

        public boolean set(V v) {
            return this.futureValue.set(v);
        }

        public boolean setException(Throwable th) {
            return this.futureValue.setException(th);
        }

        private ListenableFuture<V> fullyFailedFuture(Throwable th) {
            return Futures.immediateFailedFuture(th);
        }

        public void notifyNewValue(V v) {
            if (v != null) {
                set(v);
            } else {
                this.oldValue = LocalCache.unset();
            }
        }

        /* JADX WARN: Type inference failed for: r3v0, types: [com.google.common.cache.CacheLoader, com.google.common.cache.CacheLoader<? super K, V>] */
        /*  JADX ERROR: JadxRuntimeException in pass: MethodInvokeVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Not class type: ?
            	at jadx.core.dex.info.ClassInfo.checkClassType(ClassInfo.java:60)
            	at jadx.core.dex.info.ClassInfo.fromType(ClassInfo.java:31)
            	at jadx.core.dex.nodes.DexNode.resolveClass(DexNode.java:143)
            	at jadx.core.dex.nodes.RootNode.resolveClass(RootNode.java:183)
            	at jadx.core.dex.nodes.utils.MethodUtils.processMethodArgsOverloaded(MethodUtils.java:75)
            	at jadx.core.dex.nodes.utils.MethodUtils.collectOverloadedMethods(MethodUtils.java:54)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.processOverloaded(MethodInvokeVisitor.java:108)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.processInvoke(MethodInvokeVisitor.java:101)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:72)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.visit(MethodInvokeVisitor.java:65)
            */
        public com.google.common.util.concurrent.ListenableFuture<V> loadFuture(K r2, com.google.common.cache.CacheLoader<? super K, V> r3) {
            /*
                r1 = this;
                com.google.common.base.Stopwatch r0 = r1.stopwatch     // Catch:{ Throwable -> 0x0039 }
                r0.start()     // Catch:{ Throwable -> 0x0039 }
                com.google.common.cache.LocalCache$ValueReference<K, V> r0 = r1.oldValue     // Catch:{ Throwable -> 0x0039 }
                java.lang.Object r0 = r0.get()     // Catch:{ Throwable -> 0x0039 }
                if (r0 != 0) goto L_0x001f
                java.lang.Object r2 = r3.load(r2)     // Catch:{ Throwable -> 0x0039 }
                boolean r3 = r1.set(r2)     // Catch:{ Throwable -> 0x0039 }
                if (r3 == 0) goto L_0x001a
                com.google.common.util.concurrent.SettableFuture<V> r2 = r1.futureValue     // Catch:{ Throwable -> 0x0039 }
                return r2
            L_0x001a:
                com.google.common.util.concurrent.ListenableFuture r2 = com.google.common.util.concurrent.Futures.immediateFuture(r2)     // Catch:{ Throwable -> 0x0039 }
                return r2
            L_0x001f:
                com.google.common.util.concurrent.ListenableFuture r2 = r3.reload(r2, r0)     // Catch:{ Throwable -> 0x0039 }
                if (r2 != 0) goto L_0x002b
                r2 = 0
                com.google.common.util.concurrent.ListenableFuture r2 = com.google.common.util.concurrent.Futures.immediateFuture(r2)     // Catch:{ Throwable -> 0x0039 }
                return r2
            L_0x002b:
                com.google.common.cache.LocalCache$LoadingValueReference$1 r3 = new com.google.common.cache.LocalCache$LoadingValueReference$1     // Catch:{ Throwable -> 0x0039 }
                r3.<init>()     // Catch:{ Throwable -> 0x0039 }
                java.util.concurrent.Executor r0 = com.google.common.util.concurrent.MoreExecutors.directExecutor()     // Catch:{ Throwable -> 0x0039 }
                com.google.common.util.concurrent.ListenableFuture r2 = com.google.common.util.concurrent.Futures.transform(r2, r3, r0)     // Catch:{ Throwable -> 0x0039 }
                return r2
            L_0x0039:
                r2 = move-exception
                boolean r3 = r1.setException(r2)
                if (r3 == 0) goto L_0x0043
                com.google.common.util.concurrent.SettableFuture<V> r3 = r1.futureValue
                goto L_0x0047
            L_0x0043:
                com.google.common.util.concurrent.ListenableFuture r3 = r1.fullyFailedFuture(r2)
            L_0x0047:
                boolean r2 = r2 instanceof java.lang.InterruptedException
                if (r2 == 0) goto L_0x0052
                java.lang.Thread r2 = java.lang.Thread.currentThread()
                r2.interrupt()
            L_0x0052:
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.cache.LocalCache.LoadingValueReference.loadFuture(java.lang.Object, com.google.common.cache.CacheLoader):com.google.common.util.concurrent.ListenableFuture");
        }

        public V compute(K k, BiFunction<? super K, ? super V, ? extends V> biFunction) {
            V v;
            this.stopwatch.start();
            try {
                v = this.oldValue.waitForValue();
            } catch (ExecutionException unused) {
                v = null;
            }
            try {
                V apply = biFunction.apply(k, v);
                set(apply);
                return apply;
            } catch (Throwable th) {
                setException(th);
                throw th;
            }
        }

        public long elapsedNanos() {
            return this.stopwatch.elapsed(TimeUnit.NANOSECONDS);
        }

        public V waitForValue() throws ExecutionException {
            return Uninterruptibles.getUninterruptibly(this.futureValue);
        }

        public V get() {
            return this.oldValue.get();
        }

        public ValueReference<K, V> getOldValue() {
            return this.oldValue;
        }
    }

    static final class WriteQueue<K, V> extends AbstractQueue<ReferenceEntry<K, V>> {
        final ReferenceEntry<K, V> head = new AbstractReferenceEntry<K, V>() {
            /* class com.google.common.cache.LocalCache.WriteQueue.AnonymousClass1 */
            ReferenceEntry<K, V> nextWrite = this;
            ReferenceEntry<K, V> previousWrite = this;

            public long getWriteTime() {
                return Long.MAX_VALUE;
            }

            public void setWriteTime(long j) {
            }

            public ReferenceEntry<K, V> getNextInWriteQueue() {
                return this.nextWrite;
            }

            public void setNextInWriteQueue(ReferenceEntry<K, V> referenceEntry) {
                this.nextWrite = referenceEntry;
            }

            public ReferenceEntry<K, V> getPreviousInWriteQueue() {
                return this.previousWrite;
            }

            public void setPreviousInWriteQueue(ReferenceEntry<K, V> referenceEntry) {
                this.previousWrite = referenceEntry;
            }
        };

        WriteQueue() {
        }

        public final boolean offer(ReferenceEntry<K, V> referenceEntry) {
            LocalCache.connectWriteOrder(referenceEntry.getPreviousInWriteQueue(), referenceEntry.getNextInWriteQueue());
            LocalCache.connectWriteOrder(this.head.getPreviousInWriteQueue(), referenceEntry);
            LocalCache.connectWriteOrder(referenceEntry, this.head);
            return true;
        }

        public final ReferenceEntry<K, V> peek() {
            ReferenceEntry<K, V> nextInWriteQueue = this.head.getNextInWriteQueue();
            if (nextInWriteQueue == this.head) {
                return null;
            }
            return nextInWriteQueue;
        }

        public final ReferenceEntry<K, V> poll() {
            ReferenceEntry<K, V> nextInWriteQueue = this.head.getNextInWriteQueue();
            if (nextInWriteQueue == this.head) {
                return null;
            }
            remove(nextInWriteQueue);
            return nextInWriteQueue;
        }

        public final boolean remove(Object obj) {
            ReferenceEntry referenceEntry = (ReferenceEntry) obj;
            ReferenceEntry previousInWriteQueue = referenceEntry.getPreviousInWriteQueue();
            ReferenceEntry nextInWriteQueue = referenceEntry.getNextInWriteQueue();
            LocalCache.connectWriteOrder(previousInWriteQueue, nextInWriteQueue);
            LocalCache.nullifyWriteOrder(referenceEntry);
            return nextInWriteQueue != NullEntry.INSTANCE;
        }

        public final boolean contains(Object obj) {
            return ((ReferenceEntry) obj).getNextInWriteQueue() != NullEntry.INSTANCE;
        }

        public final boolean isEmpty() {
            return this.head.getNextInWriteQueue() == this.head;
        }

        public final int size() {
            int i = 0;
            for (ReferenceEntry<K, V> nextInWriteQueue = this.head.getNextInWriteQueue(); nextInWriteQueue != this.head; nextInWriteQueue = nextInWriteQueue.getNextInWriteQueue()) {
                i++;
            }
            return i;
        }

        public final void clear() {
            ReferenceEntry<K, V> nextInWriteQueue = this.head.getNextInWriteQueue();
            while (true) {
                ReferenceEntry<K, V> referenceEntry = this.head;
                if (nextInWriteQueue != referenceEntry) {
                    ReferenceEntry<K, V> nextInWriteQueue2 = nextInWriteQueue.getNextInWriteQueue();
                    LocalCache.nullifyWriteOrder(nextInWriteQueue);
                    nextInWriteQueue = nextInWriteQueue2;
                } else {
                    referenceEntry.setNextInWriteQueue(referenceEntry);
                    ReferenceEntry<K, V> referenceEntry2 = this.head;
                    referenceEntry2.setPreviousInWriteQueue(referenceEntry2);
                    return;
                }
            }
        }

        public final Iterator<ReferenceEntry<K, V>> iterator() {
            return new AbstractSequentialIterator<ReferenceEntry<K, V>>(peek()) {
                /* class com.google.common.cache.LocalCache.WriteQueue.AnonymousClass2 */

                /* access modifiers changed from: protected */
                public ReferenceEntry<K, V> computeNext(ReferenceEntry<K, V> referenceEntry) {
                    ReferenceEntry<K, V> nextInWriteQueue = referenceEntry.getNextInWriteQueue();
                    if (nextInWriteQueue == WriteQueue.this.head) {
                        return null;
                    }
                    return nextInWriteQueue;
                }
            };
        }
    }

    static final class AccessQueue<K, V> extends AbstractQueue<ReferenceEntry<K, V>> {
        final ReferenceEntry<K, V> head = new AbstractReferenceEntry<K, V>() {
            /* class com.google.common.cache.LocalCache.AccessQueue.AnonymousClass1 */
            ReferenceEntry<K, V> nextAccess = this;
            ReferenceEntry<K, V> previousAccess = this;

            public long getAccessTime() {
                return Long.MAX_VALUE;
            }

            public void setAccessTime(long j) {
            }

            public ReferenceEntry<K, V> getNextInAccessQueue() {
                return this.nextAccess;
            }

            public void setNextInAccessQueue(ReferenceEntry<K, V> referenceEntry) {
                this.nextAccess = referenceEntry;
            }

            public ReferenceEntry<K, V> getPreviousInAccessQueue() {
                return this.previousAccess;
            }

            public void setPreviousInAccessQueue(ReferenceEntry<K, V> referenceEntry) {
                this.previousAccess = referenceEntry;
            }
        };

        AccessQueue() {
        }

        public final boolean offer(ReferenceEntry<K, V> referenceEntry) {
            LocalCache.connectAccessOrder(referenceEntry.getPreviousInAccessQueue(), referenceEntry.getNextInAccessQueue());
            LocalCache.connectAccessOrder(this.head.getPreviousInAccessQueue(), referenceEntry);
            LocalCache.connectAccessOrder(referenceEntry, this.head);
            return true;
        }

        public final ReferenceEntry<K, V> peek() {
            ReferenceEntry<K, V> nextInAccessQueue = this.head.getNextInAccessQueue();
            if (nextInAccessQueue == this.head) {
                return null;
            }
            return nextInAccessQueue;
        }

        public final ReferenceEntry<K, V> poll() {
            ReferenceEntry<K, V> nextInAccessQueue = this.head.getNextInAccessQueue();
            if (nextInAccessQueue == this.head) {
                return null;
            }
            remove(nextInAccessQueue);
            return nextInAccessQueue;
        }

        public final boolean remove(Object obj) {
            ReferenceEntry referenceEntry = (ReferenceEntry) obj;
            ReferenceEntry previousInAccessQueue = referenceEntry.getPreviousInAccessQueue();
            ReferenceEntry nextInAccessQueue = referenceEntry.getNextInAccessQueue();
            LocalCache.connectAccessOrder(previousInAccessQueue, nextInAccessQueue);
            LocalCache.nullifyAccessOrder(referenceEntry);
            return nextInAccessQueue != NullEntry.INSTANCE;
        }

        public final boolean contains(Object obj) {
            return ((ReferenceEntry) obj).getNextInAccessQueue() != NullEntry.INSTANCE;
        }

        public final boolean isEmpty() {
            return this.head.getNextInAccessQueue() == this.head;
        }

        public final int size() {
            int i = 0;
            for (ReferenceEntry<K, V> nextInAccessQueue = this.head.getNextInAccessQueue(); nextInAccessQueue != this.head; nextInAccessQueue = nextInAccessQueue.getNextInAccessQueue()) {
                i++;
            }
            return i;
        }

        public final void clear() {
            ReferenceEntry<K, V> nextInAccessQueue = this.head.getNextInAccessQueue();
            while (true) {
                ReferenceEntry<K, V> referenceEntry = this.head;
                if (nextInAccessQueue != referenceEntry) {
                    ReferenceEntry<K, V> nextInAccessQueue2 = nextInAccessQueue.getNextInAccessQueue();
                    LocalCache.nullifyAccessOrder(nextInAccessQueue);
                    nextInAccessQueue = nextInAccessQueue2;
                } else {
                    referenceEntry.setNextInAccessQueue(referenceEntry);
                    ReferenceEntry<K, V> referenceEntry2 = this.head;
                    referenceEntry2.setPreviousInAccessQueue(referenceEntry2);
                    return;
                }
            }
        }

        public final Iterator<ReferenceEntry<K, V>> iterator() {
            return new AbstractSequentialIterator<ReferenceEntry<K, V>>(peek()) {
                /* class com.google.common.cache.LocalCache.AccessQueue.AnonymousClass2 */

                /* access modifiers changed from: protected */
                public ReferenceEntry<K, V> computeNext(ReferenceEntry<K, V> referenceEntry) {
                    ReferenceEntry<K, V> nextInAccessQueue = referenceEntry.getNextInAccessQueue();
                    if (nextInAccessQueue == AccessQueue.this.head) {
                        return null;
                    }
                    return nextInAccessQueue;
                }
            };
        }
    }

    public void cleanUp() {
        for (Segment<K, V> cleanUp : this.segments) {
            cleanUp.cleanUp();
        }
    }

    public boolean isEmpty() {
        Segment<K, V>[] segmentArr = this.segments;
        long j = 0;
        for (int i = 0; i < segmentArr.length; i++) {
            if (segmentArr[i].count != 0) {
                return false;
            }
            j += (long) segmentArr[i].modCount;
        }
        if (j == 0) {
            return true;
        }
        for (int i2 = 0; i2 < segmentArr.length; i2++) {
            if (segmentArr[i2].count != 0) {
                return false;
            }
            j -= (long) segmentArr[i2].modCount;
        }
        if (j != 0) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public long longSize() {
        Segment<K, V>[] segmentArr = this.segments;
        long j = 0;
        for (Segment<K, V> segment : segmentArr) {
            j += (long) Math.max(0, segment.count);
        }
        return j;
    }

    public int size() {
        return Ints.saturatedCast(longSize());
    }

    public V get(Object obj) {
        if (obj == null) {
            return null;
        }
        int hash = hash(obj);
        return segmentFor(hash).get(obj, hash);
    }

    /* access modifiers changed from: package-private */
    public V get(K k, CacheLoader<? super K, V> cacheLoader) throws ExecutionException {
        int hash = hash(Preconditions.checkNotNull(k));
        return segmentFor(hash).get(k, hash, cacheLoader);
    }

    public V getIfPresent(Object obj) {
        int hash = hash(Preconditions.checkNotNull(obj));
        V v = segmentFor(hash).get(obj, hash);
        if (v == null) {
            this.globalStatsCounter.recordMisses(1);
        } else {
            this.globalStatsCounter.recordHits(1);
        }
        return v;
    }

    public V getOrDefault(Object obj, V v) {
        V v2 = get(obj);
        return v2 != null ? v2 : v;
    }

    /* access modifiers changed from: package-private */
    public V getOrLoad(K k) throws ExecutionException {
        return get(k, this.defaultLoader);
    }

    /* access modifiers changed from: package-private */
    public ImmutableMap<K, V> getAllPresent(Iterable<?> iterable) {
        LinkedHashMap newLinkedHashMap = Maps.newLinkedHashMap();
        int i = 0;
        int i2 = 0;
        for (Object next : iterable) {
            Object obj = get(next);
            if (obj == null) {
                i2++;
            } else {
                newLinkedHashMap.put(next, obj);
                i++;
            }
        }
        this.globalStatsCounter.recordHits(i);
        this.globalStatsCounter.recordMisses(i2);
        return ImmutableMap.copyOf(newLinkedHashMap);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Can't wrap try/catch for region: R(4:21|22|(2:25|23)|38) */
    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        r8 = r1.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x006c, code lost:
        if (r8.hasNext() != false) goto L_0x006e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x006e, code lost:
        r1 = r8.next();
        r3 = r3 - 1;
        r0.put(r1, get(r1, r7.defaultLoader));
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0064 */
    public ImmutableMap<K, V> getAll(Iterable<? extends K> iterable) throws ExecutionException {
        LinkedHashMap newLinkedHashMap = Maps.newLinkedHashMap();
        LinkedHashSet newLinkedHashSet = Sets.newLinkedHashSet();
        int i = 0;
        int i2 = 0;
        for (Object next : iterable) {
            Object obj = get(next);
            if (!newLinkedHashMap.containsKey(next)) {
                newLinkedHashMap.put(next, obj);
                if (obj == null) {
                    i2++;
                    newLinkedHashSet.add(next);
                } else {
                    i++;
                }
            }
        }
        try {
            if (!newLinkedHashSet.isEmpty()) {
                Map<? super K, V> loadAll = loadAll(newLinkedHashSet, this.defaultLoader);
                for (Object next2 : newLinkedHashSet) {
                    V v = loadAll.get(next2);
                    if (v != null) {
                        newLinkedHashMap.put(next2, v);
                    } else {
                        throw new CacheLoader.InvalidCacheLoadException("loadAll failed to return a value for ".concat(String.valueOf(next2)));
                    }
                }
            }
            return ImmutableMap.copyOf(newLinkedHashMap);
        } finally {
            this.globalStatsCounter.recordHits(i);
            this.globalStatsCounter.recordMisses(i2);
        }
    }

    /* JADX WARN: Type inference failed for: r8v0, types: [com.google.common.cache.CacheLoader, com.google.common.cache.CacheLoader<? super K, V>, java.lang.Object] */
    /*  JADX ERROR: JadxRuntimeException in pass: MethodInvokeVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not class type: ?
        	at jadx.core.dex.info.ClassInfo.checkClassType(ClassInfo.java:60)
        	at jadx.core.dex.info.ClassInfo.fromType(ClassInfo.java:31)
        	at jadx.core.dex.nodes.DexNode.resolveClass(DexNode.java:143)
        	at jadx.core.dex.nodes.RootNode.resolveClass(RootNode.java:183)
        	at jadx.core.dex.nodes.utils.MethodUtils.processMethodArgsOverloaded(MethodUtils.java:75)
        	at jadx.core.dex.nodes.utils.MethodUtils.collectOverloadedMethods(MethodUtils.java:54)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processOverloaded(MethodInvokeVisitor.java:108)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInvoke(MethodInvokeVisitor.java:101)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:72)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.visit(MethodInvokeVisitor.java:65)
        */
    java.util.Map<K, V> loadAll(java.util.Set<? extends K> r7, com.google.common.cache.CacheLoader<? super K, V> r8) throws java.util.concurrent.ExecutionException {
        /*
            r6 = this;
            com.google.common.base.Preconditions.checkNotNull(r8)
            com.google.common.base.Preconditions.checkNotNull(r7)
            com.google.common.base.Stopwatch r0 = com.google.common.base.Stopwatch.createStarted()
            r1 = 1
            r2 = 0
            java.util.Map r7 = r8.loadAll(r7)     // Catch:{ UnsupportedLoadingOperationException -> 0x00b3, InterruptedException -> 0x00a5, RuntimeException -> 0x009e, Exception -> 0x0097, Error -> 0x0090 }
            if (r7 == 0) goto L_0x006c
            r0.stop()
            java.util.Set r3 = r7.entrySet()
            java.util.Iterator r3 = r3.iterator()
        L_0x001d:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x003c
            java.lang.Object r4 = r3.next()
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4
            java.lang.Object r5 = r4.getKey()
            java.lang.Object r4 = r4.getValue()
            if (r5 == 0) goto L_0x003a
            if (r4 != 0) goto L_0x0036
            goto L_0x003a
        L_0x0036:
            r6.put(r5, r4)
            goto L_0x001d
        L_0x003a:
            r2 = 1
            goto L_0x001d
        L_0x003c:
            if (r2 != 0) goto L_0x004a
            com.google.common.cache.AbstractCache$StatsCounter r8 = r6.globalStatsCounter
            java.util.concurrent.TimeUnit r1 = java.util.concurrent.TimeUnit.NANOSECONDS
            long r0 = r0.elapsed(r1)
            r8.recordLoadSuccess(r0)
            return r7
        L_0x004a:
            com.google.common.cache.AbstractCache$StatsCounter r7 = r6.globalStatsCounter
            java.util.concurrent.TimeUnit r1 = java.util.concurrent.TimeUnit.NANOSECONDS
            long r0 = r0.elapsed(r1)
            r7.recordLoadException(r0)
            com.google.common.cache.CacheLoader$InvalidCacheLoadException r7 = new com.google.common.cache.CacheLoader$InvalidCacheLoadException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r8)
            java.lang.String r8 = " returned null keys or values from loadAll"
            r0.append(r8)
            java.lang.String r8 = r0.toString()
            r7.<init>(r8)
            throw r7
        L_0x006c:
            com.google.common.cache.AbstractCache$StatsCounter r7 = r6.globalStatsCounter
            java.util.concurrent.TimeUnit r1 = java.util.concurrent.TimeUnit.NANOSECONDS
            long r0 = r0.elapsed(r1)
            r7.recordLoadException(r0)
            com.google.common.cache.CacheLoader$InvalidCacheLoadException r7 = new com.google.common.cache.CacheLoader$InvalidCacheLoadException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r8)
            java.lang.String r8 = " returned null map from loadAll"
            r0.append(r8)
            java.lang.String r8 = r0.toString()
            r7.<init>(r8)
            throw r7
        L_0x008e:
            r7 = move-exception
            goto L_0x00b7
        L_0x0090:
            r7 = move-exception
            com.google.common.util.concurrent.ExecutionError r8 = new com.google.common.util.concurrent.ExecutionError     // Catch:{ all -> 0x008e }
            r8.<init>(r7)     // Catch:{ all -> 0x008e }
            throw r8     // Catch:{ all -> 0x008e }
        L_0x0097:
            r7 = move-exception
            java.util.concurrent.ExecutionException r8 = new java.util.concurrent.ExecutionException     // Catch:{ all -> 0x008e }
            r8.<init>(r7)     // Catch:{ all -> 0x008e }
            throw r8     // Catch:{ all -> 0x008e }
        L_0x009e:
            r7 = move-exception
            com.google.common.util.concurrent.UncheckedExecutionException r8 = new com.google.common.util.concurrent.UncheckedExecutionException     // Catch:{ all -> 0x008e }
            r8.<init>(r7)     // Catch:{ all -> 0x008e }
            throw r8     // Catch:{ all -> 0x008e }
        L_0x00a5:
            r7 = move-exception
            java.lang.Thread r8 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x008e }
            r8.interrupt()     // Catch:{ all -> 0x008e }
            java.util.concurrent.ExecutionException r8 = new java.util.concurrent.ExecutionException     // Catch:{ all -> 0x008e }
            r8.<init>(r7)     // Catch:{ all -> 0x008e }
            throw r8     // Catch:{ all -> 0x008e }
        L_0x00b3:
            r7 = move-exception
            throw r7     // Catch:{ all -> 0x00b5 }
        L_0x00b5:
            r7 = move-exception
            r2 = 1
        L_0x00b7:
            if (r2 != 0) goto L_0x00c4
            com.google.common.cache.AbstractCache$StatsCounter r8 = r6.globalStatsCounter
            java.util.concurrent.TimeUnit r1 = java.util.concurrent.TimeUnit.NANOSECONDS
            long r0 = r0.elapsed(r1)
            r8.recordLoadException(r0)
        L_0x00c4:
            goto L_0x00c6
        L_0x00c5:
            throw r7
        L_0x00c6:
            goto L_0x00c5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.cache.LocalCache.loadAll(java.util.Set, com.google.common.cache.CacheLoader):java.util.Map");
    }

    /* access modifiers changed from: package-private */
    public ReferenceEntry<K, V> getEntry(Object obj) {
        if (obj == null) {
            return null;
        }
        int hash = hash(obj);
        return segmentFor(hash).getEntry(obj, hash);
    }

    /* access modifiers changed from: package-private */
    public void refresh(K k) {
        int hash = hash(Preconditions.checkNotNull(k));
        segmentFor(hash).refresh(k, hash, this.defaultLoader, false);
    }

    public boolean containsKey(Object obj) {
        if (obj == null) {
            return false;
        }
        int hash = hash(obj);
        return segmentFor(hash).containsKey(obj, hash);
    }

    public boolean containsValue(Object obj) {
        long j;
        Object obj2 = obj;
        if (obj2 == null) {
            return false;
        }
        long read = this.ticker.read();
        Segment<K, V>[] segmentArr = this.segments;
        long j2 = -1;
        int i = 0;
        while (i < 3) {
            int length = segmentArr.length;
            long j3 = 0;
            int i2 = 0;
            while (i2 < length) {
                Segment<K, V> segment = segmentArr[i2];
                int i3 = segment.count;
                AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = segment.table;
                for (int i4 = 0; i4 < atomicReferenceArray.length(); i4++) {
                    ReferenceEntry referenceEntry = atomicReferenceArray.get(i4);
                    while (referenceEntry != null) {
                        Segment<K, V>[] segmentArr2 = segmentArr;
                        V liveValue = segment.getLiveValue(referenceEntry, read);
                        if (liveValue != null) {
                            j = read;
                            if (this.valueEquivalence.equivalent(obj2, liveValue)) {
                                return true;
                            }
                        } else {
                            j = read;
                        }
                        referenceEntry = referenceEntry.getNext();
                        segmentArr = segmentArr2;
                        read = j;
                    }
                }
                j3 += (long) segment.modCount;
                i2++;
                read = read;
            }
            long j4 = read;
            Segment<K, V>[] segmentArr3 = segmentArr;
            if (j3 == j2) {
                return false;
            }
            i++;
            j2 = j3;
            segmentArr = segmentArr3;
            read = j4;
        }
        return false;
    }

    public V put(K k, V v) {
        Preconditions.checkNotNull(k);
        Preconditions.checkNotNull(v);
        int hash = hash(k);
        return segmentFor(hash).put(k, hash, v, false);
    }

    public V putIfAbsent(K k, V v) {
        Preconditions.checkNotNull(k);
        Preconditions.checkNotNull(v);
        int hash = hash(k);
        return segmentFor(hash).put(k, hash, v, true);
    }

    public V compute(K k, BiFunction<? super K, ? super V, ? extends V> biFunction) {
        Preconditions.checkNotNull(k);
        Preconditions.checkNotNull(biFunction);
        int hash = hash(k);
        return segmentFor(hash).compute(k, hash, biFunction);
    }

    public V computeIfAbsent(K k, Function<? super K, ? extends V> function) {
        Preconditions.checkNotNull(k);
        Preconditions.checkNotNull(function);
        return compute(k, new BiFunction(function, k) {
            /* class com.google.common.cache.$$Lambda$LocalCache$5vp99pKXUK9ge6_GCg4e2j56npU */
            private final /* synthetic */ Function f$0;
            private final /* synthetic */ Object f$1;

            {
                this.f$0 = r1;
                this.f$1 = r2;
            }

            public final Object apply(Object obj, Object obj2) {
                return LocalCache.lambda$computeIfAbsent$0(this.f$0, this.f$1, obj, obj2);
            }
        });
    }

    static /* synthetic */ Object lambda$computeIfAbsent$0(Function function, Object obj, Object obj2, Object obj3) {
        return obj3 == null ? function.apply(obj) : obj3;
    }

    public V computeIfPresent(K k, BiFunction<? super K, ? super V, ? extends V> biFunction) {
        Preconditions.checkNotNull(k);
        Preconditions.checkNotNull(biFunction);
        return compute(k, new BiFunction(biFunction) {
            /* class com.google.common.cache.$$Lambda$LocalCache$CRLOAuFbS7B6z4BkOLfl1bVCq7Y */
            private final /* synthetic */ BiFunction f$0;

            {
                this.f$0 = r1;
            }

            public final Object apply(Object obj, Object obj2) {
                return LocalCache.lambda$computeIfPresent$1(this.f$0, obj, obj2);
            }
        });
    }

    static /* synthetic */ Object lambda$computeIfPresent$1(BiFunction biFunction, Object obj, Object obj2) {
        if (obj2 == null) {
            return null;
        }
        return biFunction.apply(obj, obj2);
    }

    public V merge(K k, V v, BiFunction<? super V, ? super V, ? extends V> biFunction) {
        Preconditions.checkNotNull(k);
        Preconditions.checkNotNull(v);
        Preconditions.checkNotNull(biFunction);
        return compute(k, new BiFunction(v, biFunction) {
            /* class com.google.common.cache.$$Lambda$LocalCache$TeTK5ukvbJK2GsSI48_gdeK0a7U */
            private final /* synthetic */ Object f$0;
            private final /* synthetic */ BiFunction f$1;

            {
                this.f$0 = r1;
                this.f$1 = r2;
            }

            public final Object apply(Object obj, Object obj2) {
                return LocalCache.lambda$merge$2(this.f$0, this.f$1, obj, obj2);
            }
        });
    }

    static /* synthetic */ Object lambda$merge$2(Object obj, BiFunction biFunction, Object obj2, Object obj3) {
        return obj3 == null ? obj : biFunction.apply(obj3, obj);
    }

    public void putAll(Map<? extends K, ? extends V> map) {
        for (Map.Entry next : map.entrySet()) {
            put(next.getKey(), next.getValue());
        }
    }

    public V remove(Object obj) {
        if (obj == null) {
            return null;
        }
        int hash = hash(obj);
        return segmentFor(hash).remove(obj, hash);
    }

    public boolean remove(Object obj, Object obj2) {
        if (obj == null || obj2 == null) {
            return false;
        }
        int hash = hash(obj);
        return segmentFor(hash).remove(obj, hash, obj2);
    }

    public boolean replace(K k, V v, V v2) {
        Preconditions.checkNotNull(k);
        Preconditions.checkNotNull(v2);
        if (v == null) {
            return false;
        }
        int hash = hash(k);
        return segmentFor(hash).replace(k, hash, v, v2);
    }

    public V replace(K k, V v) {
        Preconditions.checkNotNull(k);
        Preconditions.checkNotNull(v);
        int hash = hash(k);
        return segmentFor(hash).replace(k, hash, v);
    }

    public void clear() {
        for (Segment<K, V> clear : this.segments) {
            clear.clear();
        }
    }

    /* access modifiers changed from: package-private */
    public void invalidateAll(Iterable<?> iterable) {
        for (Object remove : iterable) {
            remove(remove);
        }
    }

    public Set<K> keySet() {
        Set<K> set = this.keySet;
        if (set != null) {
            return set;
        }
        KeySet keySet2 = new KeySet(this);
        this.keySet = keySet2;
        return keySet2;
    }

    public Collection<V> values() {
        Collection<V> collection = this.values;
        if (collection != null) {
            return collection;
        }
        Values values2 = new Values(this);
        this.values = values2;
        return values2;
    }

    @GwtIncompatible
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = this.entrySet;
        if (set != null) {
            return set;
        }
        EntrySet entrySet2 = new EntrySet(this);
        this.entrySet = entrySet2;
        return entrySet2;
    }

    abstract class HashIterator<T> implements Iterator<T> {
        Segment<K, V> currentSegment;
        AtomicReferenceArray<ReferenceEntry<K, V>> currentTable;
        LocalCache<K, V>.WriteThroughEntry lastReturned;
        ReferenceEntry<K, V> nextEntry;
        LocalCache<K, V>.WriteThroughEntry nextExternal;
        int nextSegmentIndex;
        int nextTableIndex = -1;

        public abstract T next();

        HashIterator() {
            this.nextSegmentIndex = LocalCache.this.segments.length - 1;
            advance();
        }

        /* access modifiers changed from: package-private */
        public final void advance() {
            this.nextExternal = null;
            if (!nextInChain() && !nextInTable()) {
                while (this.nextSegmentIndex >= 0) {
                    Segment<K, V>[] segmentArr = LocalCache.this.segments;
                    int i = this.nextSegmentIndex;
                    this.nextSegmentIndex = i - 1;
                    this.currentSegment = segmentArr[i];
                    if (this.currentSegment.count != 0) {
                        this.currentTable = this.currentSegment.table;
                        this.nextTableIndex = this.currentTable.length() - 1;
                        if (nextInTable()) {
                            return;
                        }
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        public boolean nextInChain() {
            ReferenceEntry<K, V> referenceEntry = this.nextEntry;
            if (referenceEntry == null) {
                return false;
            }
            while (true) {
                this.nextEntry = referenceEntry.getNext();
                ReferenceEntry<K, V> referenceEntry2 = this.nextEntry;
                if (referenceEntry2 == null) {
                    return false;
                }
                if (advanceTo(referenceEntry2)) {
                    return true;
                }
                referenceEntry = this.nextEntry;
            }
        }

        /* access modifiers changed from: package-private */
        public boolean nextInTable() {
            while (true) {
                int i = this.nextTableIndex;
                if (i < 0) {
                    return false;
                }
                AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.currentTable;
                this.nextTableIndex = i - 1;
                ReferenceEntry<K, V> referenceEntry = atomicReferenceArray.get(i);
                this.nextEntry = referenceEntry;
                if (referenceEntry != null && (advanceTo(this.nextEntry) || nextInChain())) {
                    return true;
                }
            }
        }

        /* JADX INFO: finally extract failed */
        /* access modifiers changed from: package-private */
        public boolean advanceTo(ReferenceEntry<K, V> referenceEntry) {
            try {
                long read = LocalCache.this.ticker.read();
                K key = referenceEntry.getKey();
                V liveValue = LocalCache.this.getLiveValue(referenceEntry, read);
                if (liveValue != null) {
                    this.nextExternal = new WriteThroughEntry(key, liveValue);
                    this.currentSegment.postReadCleanup();
                    return true;
                }
                this.currentSegment.postReadCleanup();
                return false;
            } catch (Throwable th) {
                this.currentSegment.postReadCleanup();
                throw th;
            }
        }

        public boolean hasNext() {
            return this.nextExternal != null;
        }

        /* access modifiers changed from: package-private */
        public LocalCache<K, V>.WriteThroughEntry nextEntry() {
            LocalCache<K, V>.WriteThroughEntry writeThroughEntry = this.nextExternal;
            if (writeThroughEntry != null) {
                this.lastReturned = writeThroughEntry;
                advance();
                return this.lastReturned;
            }
            throw new NoSuchElementException();
        }

        public void remove() {
            Preconditions.checkState(this.lastReturned != null);
            LocalCache.this.remove(this.lastReturned.getKey());
            this.lastReturned = null;
        }
    }

    final class KeyIterator extends LocalCache<K, V>.HashIterator<K> {
        KeyIterator() {
            super();
        }

        public final K next() {
            return nextEntry().getKey();
        }
    }

    final class ValueIterator extends LocalCache<K, V>.HashIterator<V> {
        ValueIterator() {
            super();
        }

        public final V next() {
            return nextEntry().getValue();
        }
    }

    final class WriteThroughEntry implements Map.Entry<K, V> {
        final K key;
        V value;

        WriteThroughEntry(K k, V v) {
            this.key = k;
            this.value = v;
        }

        public final K getKey() {
            return this.key;
        }

        public final V getValue() {
            return this.value;
        }

        /*  JADX ERROR: JadxRuntimeException in pass: MethodInvokeVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Not class type: K
            	at jadx.core.dex.info.ClassInfo.checkClassType(ClassInfo.java:60)
            	at jadx.core.dex.info.ClassInfo.fromType(ClassInfo.java:31)
            	at jadx.core.dex.nodes.DexNode.resolveClass(DexNode.java:143)
            	at jadx.core.dex.nodes.RootNode.resolveClass(RootNode.java:183)
            	at jadx.core.dex.nodes.utils.MethodUtils.processMethodArgsOverloaded(MethodUtils.java:75)
            	at jadx.core.dex.nodes.utils.MethodUtils.collectOverloadedMethods(MethodUtils.java:54)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.processOverloaded(MethodInvokeVisitor.java:108)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.processInvoke(MethodInvokeVisitor.java:101)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:72)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:77)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.visit(MethodInvokeVisitor.java:65)
            */
        public final boolean equals(java.lang.Object r4) {
            /*
                r3 = this;
                boolean r0 = r4 instanceof java.util.Map.Entry
                r1 = 0
                if (r0 == 0) goto L_0x0021
                java.util.Map$Entry r4 = (java.util.Map.Entry) r4
                K r0 = r3.key
                java.lang.Object r2 = r4.getKey()
                boolean r0 = r0.equals(r2)
                if (r0 == 0) goto L_0x0021
                V r0 = r3.value
                java.lang.Object r4 = r4.getValue()
                boolean r4 = r0.equals(r4)
                if (r4 == 0) goto L_0x0021
                r4 = 1
                return r4
            L_0x0021:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.cache.LocalCache.WriteThroughEntry.equals(java.lang.Object):boolean");
        }

        public final int hashCode() {
            return this.key.hashCode() ^ this.value.hashCode();
        }

        public final V setValue(V v) {
            V put = LocalCache.this.put(this.key, v);
            this.value = v;
            return put;
        }

        public final String toString() {
            return getKey() + "=" + getValue();
        }
    }

    final class EntryIterator extends LocalCache<K, V>.HashIterator<Map.Entry<K, V>> {
        EntryIterator() {
            super();
        }

        public final Map.Entry<K, V> next() {
            return nextEntry();
        }
    }

    abstract class AbstractCacheSet<T> extends AbstractSet<T> {
        @Weak
        final ConcurrentMap<?, ?> map;

        AbstractCacheSet(ConcurrentMap<?, ?> concurrentMap) {
            this.map = concurrentMap;
        }

        public int size() {
            return this.map.size();
        }

        public boolean isEmpty() {
            return this.map.isEmpty();
        }

        public void clear() {
            this.map.clear();
        }

        public Object[] toArray() {
            return LocalCache.toArrayList(this).toArray();
        }

        public <E> E[] toArray(E[] eArr) {
            return LocalCache.toArrayList(this).toArray(eArr);
        }
    }

    public static <E> ArrayList<E> toArrayList(Collection<E> collection) {
        ArrayList<E> arrayList = new ArrayList<>(collection.size());
        Iterators.addAll(arrayList, collection.iterator());
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public boolean removeIf(BiPredicate<? super K, ? super V> biPredicate) {
        Preconditions.checkNotNull(biPredicate);
        boolean z = false;
        for (Object next : keySet()) {
            while (true) {
                Object obj = get(next);
                if (obj != null && biPredicate.test(next, obj)) {
                    if (remove(next, obj)) {
                        z = true;
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        return z;
    }

    final class KeySet extends LocalCache<K, V>.AbstractCacheSet<K> {
        KeySet(ConcurrentMap<?, ?> concurrentMap) {
            super(concurrentMap);
        }

        public final Iterator<K> iterator() {
            return new KeyIterator();
        }

        public final boolean contains(Object obj) {
            return this.map.containsKey(obj);
        }

        public final boolean remove(Object obj) {
            return this.map.remove(obj) != null;
        }
    }

    final class Values extends AbstractCollection<V> {
        private final ConcurrentMap<?, ?> map;

        Values(ConcurrentMap<?, ?> concurrentMap) {
            this.map = concurrentMap;
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

        public final Iterator<V> iterator() {
            return new ValueIterator();
        }

        public final boolean removeIf(Predicate<? super V> predicate) {
            Preconditions.checkNotNull(predicate);
            return LocalCache.this.removeIf(new BiPredicate(predicate) {
                /* class com.google.common.cache.$$Lambda$LocalCache$Values$okp7iNiz5QxmoxFBOtX4KAC8Ktk */
                private final /* synthetic */ Predicate f$0;

                {
                    this.f$0 = r1;
                }

                public final boolean test(Object obj, Object obj2) {
                    return this.f$0.test(obj2);
                }
            });
        }

        public final boolean contains(Object obj) {
            return this.map.containsValue(obj);
        }

        public final Object[] toArray() {
            return LocalCache.toArrayList(this).toArray();
        }

        public final <E> E[] toArray(E[] eArr) {
            return LocalCache.toArrayList(this).toArray(eArr);
        }
    }

    final class EntrySet extends LocalCache<K, V>.AbstractCacheSet<Map.Entry<K, V>> {
        EntrySet(ConcurrentMap<?, ?> concurrentMap) {
            super(concurrentMap);
        }

        public final Iterator<Map.Entry<K, V>> iterator() {
            return new EntryIterator();
        }

        public final boolean removeIf(Predicate<? super Map.Entry<K, V>> predicate) {
            Preconditions.checkNotNull(predicate);
            return LocalCache.this.removeIf(new BiPredicate(predicate) {
                /* class com.google.common.cache.$$Lambda$LocalCache$EntrySet$dxOfzfb8G2LoOjBNlP6Nev0Uc34 */
                private final /* synthetic */ Predicate f$0;

                {
                    this.f$0 = r1;
                }

                public final boolean test(Object obj, Object obj2) {
                    return this.f$0.test(Maps.immutableEntry(obj, obj2));
                }
            });
        }

        public final boolean contains(Object obj) {
            Map.Entry entry;
            Object key;
            Object obj2;
            if ((obj instanceof Map.Entry) && (key = (entry = (Map.Entry) obj).getKey()) != null && (obj2 = LocalCache.this.get(key)) != null && LocalCache.this.valueEquivalence.equivalent(entry.getValue(), obj2)) {
                return true;
            }
            return false;
        }

        public final boolean remove(Object obj) {
            Map.Entry entry;
            Object key;
            if ((obj instanceof Map.Entry) && (key = (entry = (Map.Entry) obj).getKey()) != null && LocalCache.this.remove(key, entry.getValue())) {
                return true;
            }
            return false;
        }
    }

    static class ManualSerializationProxy<K, V> extends ForwardingCache<K, V> implements Serializable {
        private static final long serialVersionUID = 1;
        final int concurrencyLevel;
        transient Cache<K, V> delegate;
        final long expireAfterAccessNanos;
        final long expireAfterWriteNanos;
        final Equivalence<Object> keyEquivalence;
        final Strength keyStrength;
        final CacheLoader<? super K, V> loader;
        final long maxWeight;
        final RemovalListener<? super K, ? super V> removalListener;
        final Ticker ticker;
        final Equivalence<Object> valueEquivalence;
        final Strength valueStrength;
        final Weigher<K, V> weigher;

        /* JADX WARNING: Illegal instructions before constructor call */
        ManualSerializationProxy(LocalCache<K, V> localCache) {
            this(r0.keyStrength, r0.valueStrength, r0.keyEquivalence, r0.valueEquivalence, r0.expireAfterWriteNanos, r0.expireAfterAccessNanos, r0.maxWeight, r0.weigher, r0.concurrencyLevel, r0.removalListener, r0.ticker, r0.defaultLoader);
            LocalCache<K, V> localCache2 = localCache;
        }

        private ManualSerializationProxy(Strength strength, Strength strength2, Equivalence<Object> equivalence, Equivalence<Object> equivalence2, long j, long j2, long j3, Weigher<K, V> weigher2, int i, RemovalListener<? super K, ? super V> removalListener2, Ticker ticker2, CacheLoader<? super K, V> cacheLoader) {
            this.keyStrength = strength;
            this.valueStrength = strength2;
            this.keyEquivalence = equivalence;
            this.valueEquivalence = equivalence2;
            this.expireAfterWriteNanos = j;
            this.expireAfterAccessNanos = j2;
            this.maxWeight = j3;
            this.weigher = weigher2;
            this.concurrencyLevel = i;
            this.removalListener = removalListener2;
            this.ticker = (ticker2 == Ticker.systemTicker() || ticker2 == CacheBuilder.NULL_TICKER) ? null : ticker2;
            this.loader = cacheLoader;
        }

        /* access modifiers changed from: package-private */
        public CacheBuilder<K, V> recreateCacheBuilder() {
            CacheBuilder removalListener2 = CacheBuilder.newBuilder().setKeyStrength(this.keyStrength).setValueStrength(this.valueStrength).keyEquivalence(this.keyEquivalence).valueEquivalence(this.valueEquivalence).concurrencyLevel(this.concurrencyLevel).removalListener(this.removalListener);
            removalListener2.strictParsing = false;
            long j = this.expireAfterWriteNanos;
            if (j > 0) {
                removalListener2.expireAfterWrite(j, TimeUnit.NANOSECONDS);
            }
            long j2 = this.expireAfterAccessNanos;
            if (j2 > 0) {
                removalListener2.expireAfterAccess(j2, TimeUnit.NANOSECONDS);
            }
            if (this.weigher != CacheBuilder.OneWeigher.INSTANCE) {
                removalListener2.weigher(this.weigher);
                long j3 = this.maxWeight;
                if (j3 != -1) {
                    removalListener2.maximumWeight(j3);
                }
            } else {
                long j4 = this.maxWeight;
                if (j4 != -1) {
                    removalListener2.maximumSize(j4);
                }
            }
            Ticker ticker2 = this.ticker;
            if (ticker2 != null) {
                removalListener2.ticker(ticker2);
            }
            return removalListener2;
        }

        private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            objectInputStream.defaultReadObject();
            this.delegate = recreateCacheBuilder().build();
        }

        private Object readResolve() {
            return this.delegate;
        }

        /* access modifiers changed from: protected */
        public Cache<K, V> delegate() {
            return this.delegate;
        }
    }

    static final class LoadingSerializationProxy<K, V> extends ManualSerializationProxy<K, V> implements LoadingCache<K, V>, Serializable {
        private static final long serialVersionUID = 1;
        transient LoadingCache<K, V> autoDelegate;

        LoadingSerializationProxy(LocalCache<K, V> localCache) {
            super(localCache);
        }

        private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            objectInputStream.defaultReadObject();
            this.autoDelegate = recreateCacheBuilder().build(this.loader);
        }

        public final V get(K k) throws ExecutionException {
            return this.autoDelegate.get(k);
        }

        public final V getUnchecked(K k) {
            return this.autoDelegate.getUnchecked(k);
        }

        public final ImmutableMap<K, V> getAll(Iterable<? extends K> iterable) throws ExecutionException {
            return this.autoDelegate.getAll(iterable);
        }

        public final V apply(K k) {
            return this.autoDelegate.apply(k);
        }

        public final void refresh(K k) {
            this.autoDelegate.refresh(k);
        }

        private Object readResolve() {
            return this.autoDelegate;
        }
    }

    static class LocalManualCache<K, V> implements Cache<K, V>, Serializable {
        private static final long serialVersionUID = 1;
        final LocalCache<K, V> localCache;

        LocalManualCache(CacheBuilder cacheBuilder) {
            this(new LocalCache(cacheBuilder, null));
        }

        private LocalManualCache(LocalCache localCache2) {
            this.localCache = localCache2;
        }

        public V getIfPresent(Object obj) {
            return this.localCache.getIfPresent(obj);
        }

        public V get(K k, final Callable<? extends V> callable) throws ExecutionException {
            Preconditions.checkNotNull(callable);
            return this.localCache.get(k, new CacheLoader<Object, V>() {
                /* class com.google.common.cache.LocalCache.LocalManualCache.AnonymousClass1 */

                public V load(Object obj) throws Exception {
                    return callable.call();
                }
            });
        }

        public ImmutableMap<K, V> getAllPresent(Iterable<?> iterable) {
            return this.localCache.getAllPresent(iterable);
        }

        public void put(K k, V v) {
            this.localCache.put(k, v);
        }

        public void putAll(Map<? extends K, ? extends V> map) {
            this.localCache.putAll(map);
        }

        public void invalidate(Object obj) {
            Preconditions.checkNotNull(obj);
            this.localCache.remove(obj);
        }

        public void invalidateAll(Iterable<?> iterable) {
            this.localCache.invalidateAll(iterable);
        }

        public void invalidateAll() {
            this.localCache.clear();
        }

        public long size() {
            return this.localCache.longSize();
        }

        public ConcurrentMap<K, V> asMap() {
            return this.localCache;
        }

        public CacheStats stats() {
            AbstractCache.SimpleStatsCounter simpleStatsCounter = new AbstractCache.SimpleStatsCounter();
            simpleStatsCounter.incrementBy(this.localCache.globalStatsCounter);
            for (Segment<K, V> segment : this.localCache.segments) {
                simpleStatsCounter.incrementBy(segment.statsCounter);
            }
            return simpleStatsCounter.snapshot();
        }

        public void cleanUp() {
            this.localCache.cleanUp();
        }

        /* access modifiers changed from: package-private */
        public Object writeReplace() {
            return new ManualSerializationProxy(this.localCache);
        }
    }

    static class LocalLoadingCache<K, V> extends LocalManualCache<K, V> implements LoadingCache<K, V> {
        private static final long serialVersionUID = 1;

        LocalLoadingCache(CacheBuilder<? super K, ? super V> cacheBuilder, CacheLoader<? super K, V> cacheLoader) {
            super();
        }

        public V get(K k) throws ExecutionException {
            return this.localCache.getOrLoad(k);
        }

        public V getUnchecked(K k) {
            try {
                return get(k);
            } catch (ExecutionException e) {
                throw new UncheckedExecutionException(e.getCause());
            }
        }

        public ImmutableMap<K, V> getAll(Iterable<? extends K> iterable) throws ExecutionException {
            return this.localCache.getAll(iterable);
        }

        public void refresh(K k) {
            this.localCache.refresh(k);
        }

        public final V apply(K k) {
            return getUnchecked(k);
        }

        /* access modifiers changed from: package-private */
        public Object writeReplace() {
            return new LoadingSerializationProxy(this.localCache);
        }
    }
}
