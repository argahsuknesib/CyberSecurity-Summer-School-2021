package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicates;
import com.google.common.collect.Collections2;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;
import com.google.common.math.IntMath;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.Serializable;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.NavigableSet;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Stream;

@GwtCompatible(emulated = true)
public final class Sets {
    private Sets() {
    }

    static abstract class ImprovedAbstractSet<E> extends AbstractSet<E> {
        ImprovedAbstractSet() {
        }

        public boolean removeAll(Collection<?> collection) {
            return Sets.removeAllImpl(this, collection);
        }

        public boolean retainAll(Collection<?> collection) {
            return super.retainAll((Collection) Preconditions.checkNotNull(collection));
        }
    }

    @GwtCompatible(serializable = true)
    public static <E extends Enum<E>> ImmutableSet<E> immutableEnumSet(E e, E... eArr) {
        return ImmutableEnumSet.asImmutable(EnumSet.of(e, eArr));
    }

    @GwtCompatible(serializable = true)
    public static <E extends Enum<E>> ImmutableSet<E> immutableEnumSet(Iterable<E> iterable) {
        if (iterable instanceof ImmutableEnumSet) {
            return (ImmutableEnumSet) iterable;
        }
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            if (collection.isEmpty()) {
                return ImmutableSet.of();
            }
            return ImmutableEnumSet.asImmutable(EnumSet.copyOf(collection));
        }
        Iterator<E> it = iterable.iterator();
        if (!it.hasNext()) {
            return ImmutableSet.of();
        }
        EnumSet of = EnumSet.of((Enum) it.next());
        Iterators.addAll(of, it);
        return ImmutableEnumSet.asImmutable(of);
    }

    static final class Accumulator<E extends Enum<E>> {
        static final Collector<Enum<?>, ?, ImmutableSet<? extends Enum<?>>> TO_IMMUTABLE_ENUM_SET = Collector.of($$Lambda$Sets$Accumulator$S40KW5mTd8a2Tg458loRQsXPtY.INSTANCE, $$Lambda$_swt8Zk1tNFsHoMh5XS2Yp6uvM.INSTANCE, $$Lambda$jlZmUqXRMJaxewOq0E8639s5Bs0.INSTANCE, $$Lambda$sIeyAkSPar31xXK7wYDuaKbDR34.INSTANCE, Collector.Characteristics.UNORDERED);
        private EnumSet<E> set;

        /* renamed from: lambda$-S40KW5mTd8a2Tg458loRQsXPtY  reason: not valid java name */
        public static /* synthetic */ Accumulator m65lambda$S40KW5mTd8a2Tg458loRQsXPtY() {
            return new Accumulator();
        }

        private Accumulator() {
        }

        /* access modifiers changed from: package-private */
        public final void add(E e) {
            EnumSet<E> enumSet = this.set;
            if (enumSet == null) {
                this.set = EnumSet.of(e);
            } else {
                enumSet.add(e);
            }
        }

        /* access modifiers changed from: package-private */
        public final Accumulator<E> combine(Accumulator<E> accumulator) {
            EnumSet<E> enumSet = this.set;
            if (enumSet == null) {
                return accumulator;
            }
            EnumSet<E> enumSet2 = accumulator.set;
            if (enumSet2 == null) {
                return this;
            }
            enumSet.addAll(enumSet2);
            return this;
        }

        /* access modifiers changed from: package-private */
        public final ImmutableSet<E> toImmutableSet() {
            EnumSet<E> enumSet = this.set;
            return enumSet == null ? ImmutableSet.of() : ImmutableEnumSet.asImmutable(enumSet);
        }
    }

    @Beta
    public static <E extends Enum<E>> Collector<E, ?, ImmutableSet<E>> toImmutableEnumSet() {
        return Accumulator.TO_IMMUTABLE_ENUM_SET;
    }

    public static <E extends Enum<E>> EnumSet<E> newEnumSet(Iterable<E> iterable, Class<E> cls) {
        EnumSet<E> noneOf = EnumSet.noneOf(cls);
        Iterables.addAll(noneOf, iterable);
        return noneOf;
    }

    public static <E> HashSet<E> newHashSet() {
        return new HashSet<>();
    }

    public static <E> HashSet<E> newHashSet(E... eArr) {
        HashSet<E> newHashSetWithExpectedSize = newHashSetWithExpectedSize(eArr.length);
        Collections.addAll(newHashSetWithExpectedSize, eArr);
        return newHashSetWithExpectedSize;
    }

    public static <E> HashSet<E> newHashSet(Iterable<? extends E> iterable) {
        if (iterable instanceof Collection) {
            return new HashSet<>(Collections2.cast(iterable));
        }
        return newHashSet(iterable.iterator());
    }

    public static <E> HashSet<E> newHashSet(Iterator<? extends E> it) {
        HashSet<E> newHashSet = newHashSet();
        Iterators.addAll(newHashSet, it);
        return newHashSet;
    }

    public static <E> HashSet<E> newHashSetWithExpectedSize(int i) {
        return new HashSet<>(Maps.capacity(i));
    }

    public static <E> Set<E> newConcurrentHashSet() {
        return Collections.newSetFromMap(new ConcurrentHashMap());
    }

    public static <E> Set<E> newConcurrentHashSet(Iterable<? extends E> iterable) {
        Set<E> newConcurrentHashSet = newConcurrentHashSet();
        Iterables.addAll(newConcurrentHashSet, iterable);
        return newConcurrentHashSet;
    }

    public static <E> LinkedHashSet<E> newLinkedHashSet() {
        return new LinkedHashSet<>();
    }

    public static <E> LinkedHashSet<E> newLinkedHashSet(Iterable<? extends E> iterable) {
        if (iterable instanceof Collection) {
            return new LinkedHashSet<>(Collections2.cast(iterable));
        }
        LinkedHashSet<E> newLinkedHashSet = newLinkedHashSet();
        Iterables.addAll(newLinkedHashSet, iterable);
        return newLinkedHashSet;
    }

    public static <E> LinkedHashSet<E> newLinkedHashSetWithExpectedSize(int i) {
        return new LinkedHashSet<>(Maps.capacity(i));
    }

    public static <E extends Comparable> TreeSet<E> newTreeSet() {
        return new TreeSet<>();
    }

    public static <E extends Comparable> TreeSet<E> newTreeSet(Iterable<? extends E> iterable) {
        TreeSet<E> newTreeSet = newTreeSet();
        Iterables.addAll(newTreeSet, iterable);
        return newTreeSet;
    }

    public static <E> TreeSet<E> newTreeSet(Comparator<? super E> comparator) {
        return new TreeSet<>((Comparator) Preconditions.checkNotNull(comparator));
    }

    public static <E> Set<E> newIdentityHashSet() {
        return Collections.newSetFromMap(Maps.newIdentityHashMap());
    }

    @GwtIncompatible
    public static <E> CopyOnWriteArraySet<E> newCopyOnWriteArraySet() {
        return new CopyOnWriteArraySet<>();
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Iterable<? extends E>, java.lang.Iterable] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @GwtIncompatible
    public static <E> CopyOnWriteArraySet<E> newCopyOnWriteArraySet(Iterable<? extends E> r1) {
        Object obj;
        if (r1 instanceof Collection) {
            obj = Collections2.cast(r1);
        } else {
            obj = Lists.newArrayList((Iterable) r1);
        }
        return new CopyOnWriteArraySet<>(obj);
    }

    public static <E extends Enum<E>> EnumSet<E> complementOf(Collection<E> collection) {
        if (collection instanceof EnumSet) {
            return EnumSet.complementOf((EnumSet) collection);
        }
        Preconditions.checkArgument(!collection.isEmpty(), "collection is empty; use the other version of this method");
        return makeComplementByHand(collection, ((Enum) collection.iterator().next()).getDeclaringClass());
    }

    public static <E extends Enum<E>> EnumSet<E> complementOf(Collection<E> collection, Class<E> cls) {
        Preconditions.checkNotNull(collection);
        if (collection instanceof EnumSet) {
            return EnumSet.complementOf((EnumSet) collection);
        }
        return makeComplementByHand(collection, cls);
    }

    private static <E extends Enum<E>> EnumSet<E> makeComplementByHand(Collection<E> collection, Class<E> cls) {
        EnumSet<E> allOf = EnumSet.allOf(cls);
        allOf.removeAll(collection);
        return allOf;
    }

    @Deprecated
    public static <E> Set<E> newSetFromMap(Map<E, Boolean> map) {
        return Collections.newSetFromMap(map);
    }

    public static abstract class SetView<E> extends AbstractSet<E> {
        public abstract UnmodifiableIterator<E> iterator();

        private SetView() {
        }

        public ImmutableSet<E> immutableCopy() {
            return ImmutableSet.copyOf((Collection) this);
        }

        /*  JADX ERROR: JadxRuntimeException in pass: MethodInvokeVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Not class type: S
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
        @com.google.errorprone.annotations.CanIgnoreReturnValue
        public <S extends java.util.Set<E>> S copyInto(S r1) {
            /*
                r0 = this;
                r1.addAll(r0)
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.Sets.SetView.copyInto(java.util.Set):java.util.Set");
        }

        @CanIgnoreReturnValue
        @Deprecated
        public final boolean add(E e) {
            throw new UnsupportedOperationException();
        }

        @CanIgnoreReturnValue
        @Deprecated
        public final boolean remove(Object obj) {
            throw new UnsupportedOperationException();
        }

        @CanIgnoreReturnValue
        @Deprecated
        public final boolean addAll(Collection<? extends E> collection) {
            throw new UnsupportedOperationException();
        }

        @CanIgnoreReturnValue
        @Deprecated
        public final boolean removeAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        @CanIgnoreReturnValue
        @Deprecated
        public final boolean removeIf(Predicate<? super E> predicate) {
            throw new UnsupportedOperationException();
        }

        @CanIgnoreReturnValue
        @Deprecated
        public final boolean retainAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        @Deprecated
        public final void clear() {
            throw new UnsupportedOperationException();
        }
    }

    public static <E> SetView<E> union(final Set<? extends E> set, final Set<? extends E> set2) {
        Preconditions.checkNotNull(set, "set1");
        Preconditions.checkNotNull(set2, "set2");
        return new SetView<E>() {
            /* class com.google.common.collect.Sets.AnonymousClass1 */

            public final int size() {
                int size = set.size();
                for (Object contains : set2) {
                    if (!set.contains(contains)) {
                        size++;
                    }
                }
                return size;
            }

            public final boolean isEmpty() {
                return set.isEmpty() && set2.isEmpty();
            }

            public final UnmodifiableIterator<E> iterator() {
                return new AbstractIterator<E>() {
                    /* class com.google.common.collect.Sets.AnonymousClass1.AnonymousClass1 */
                    final Iterator<? extends E> itr1 = set.iterator();
                    final Iterator<? extends E> itr2 = set2.iterator();

                    /* access modifiers changed from: protected */
                    public E computeNext() {
                        if (this.itr1.hasNext()) {
                            return this.itr1.next();
                        }
                        while (this.itr2.hasNext()) {
                            E next = this.itr2.next();
                            if (!set.contains(next)) {
                                return next;
                            }
                        }
                        return endOfData();
                    }
                };
            }

            static /* synthetic */ boolean lambda$stream$0(Set set, Object obj) {
                return !set.contains(obj);
            }

            public final Stream<E> stream() {
                return Stream.concat(set.stream(), set2.stream().filter(new Predicate(set) {
                    /* class com.google.common.collect.$$Lambda$Sets$1$SgG8Qe8hxyMq4JICRRsW2TYosLE */
                    private final /* synthetic */ Set f$0;

                    {
                        this.f$0 = r1;
                    }

                    public final boolean test(Object obj) {
                        return Sets.AnonymousClass1.lambda$stream$0(this.f$0, obj);
                    }
                }));
            }

            public final Stream<E> parallelStream() {
                return (Stream) stream().parallel();
            }

            public final boolean contains(Object obj) {
                return set.contains(obj) || set2.contains(obj);
            }

            /*  JADX ERROR: JadxRuntimeException in pass: MethodInvokeVisitor
                jadx.core.utils.exceptions.JadxRuntimeException: Not class type: S
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
            public final <S extends java.util.Set<E>> S copyInto(S r2) {
                /*
                    r1 = this;
                    java.util.Set r0 = r1
                    r2.addAll(r0)
                    java.util.Set r0 = r2
                    r2.addAll(r0)
                    return r2
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.Sets.AnonymousClass1.copyInto(java.util.Set):java.util.Set");
            }

            public final ImmutableSet<E> immutableCopy() {
                return new ImmutableSet.Builder().addAll((Iterable) set).addAll((Iterable) set2).build();
            }
        };
    }

    public static <E> SetView<E> intersection(final Set<E> set, final Set<?> set2) {
        Preconditions.checkNotNull(set, "set1");
        Preconditions.checkNotNull(set2, "set2");
        return new SetView<E>() {
            /* class com.google.common.collect.Sets.AnonymousClass2 */

            public final UnmodifiableIterator<E> iterator() {
                return new AbstractIterator<E>() {
                    /* class com.google.common.collect.Sets.AnonymousClass2.AnonymousClass1 */
                    final Iterator<E> itr = set.iterator();

                    /* access modifiers changed from: protected */
                    public E computeNext() {
                        while (this.itr.hasNext()) {
                            E next = this.itr.next();
                            if (set2.contains(next)) {
                                return next;
                            }
                        }
                        return endOfData();
                    }
                };
            }

            public final Stream<E> stream() {
                Stream stream = set.stream();
                Set set = set2;
                set.getClass();
                return stream.filter(new Predicate(set) {
                    /* class com.google.common.collect.$$Lambda$0SUabifbs_laOWE0P2DjMk48G4 */
                    private final /* synthetic */ Set f$0;

                    {
                        this.f$0 = r1;
                    }

                    public final boolean test(Object obj) {
                        return this.f$0.contains(obj);
                    }
                });
            }

            public final Stream<E> parallelStream() {
                Stream parallelStream = set.parallelStream();
                Set set = set2;
                set.getClass();
                return parallelStream.filter(new Predicate(set) {
                    /* class com.google.common.collect.$$Lambda$0SUabifbs_laOWE0P2DjMk48G4 */
                    private final /* synthetic */ Set f$0;

                    {
                        this.f$0 = r1;
                    }

                    public final boolean test(Object obj) {
                        return this.f$0.contains(obj);
                    }
                });
            }

            public final int size() {
                int i = 0;
                for (Object contains : set) {
                    if (set2.contains(contains)) {
                        i++;
                    }
                }
                return i;
            }

            public final boolean isEmpty() {
                return Collections.disjoint(set, set2);
            }

            public final boolean contains(Object obj) {
                return set.contains(obj) && set2.contains(obj);
            }

            public final boolean containsAll(Collection<?> collection) {
                return set.containsAll(collection) && set2.containsAll(collection);
            }
        };
    }

    public static <E> SetView<E> difference(final Set<E> set, final Set<?> set2) {
        Preconditions.checkNotNull(set, "set1");
        Preconditions.checkNotNull(set2, "set2");
        return new SetView<E>() {
            /* class com.google.common.collect.Sets.AnonymousClass3 */

            public final UnmodifiableIterator<E> iterator() {
                return new AbstractIterator<E>() {
                    /* class com.google.common.collect.Sets.AnonymousClass3.AnonymousClass1 */
                    final Iterator<E> itr = set.iterator();

                    /* access modifiers changed from: protected */
                    public E computeNext() {
                        while (this.itr.hasNext()) {
                            E next = this.itr.next();
                            if (!set2.contains(next)) {
                                return next;
                            }
                        }
                        return endOfData();
                    }
                };
            }

            static /* synthetic */ boolean lambda$stream$0(Set set, Object obj) {
                return !set.contains(obj);
            }

            public final Stream<E> stream() {
                return set.stream().filter(new Predicate(set2) {
                    /* class com.google.common.collect.$$Lambda$Sets$3$HD_wTuijgQrcuiKowwjeSA8YVM */
                    private final /* synthetic */ Set f$0;

                    {
                        this.f$0 = r1;
                    }

                    public final boolean test(Object obj) {
                        return Sets.AnonymousClass3.lambda$stream$0(this.f$0, obj);
                    }
                });
            }

            static /* synthetic */ boolean lambda$parallelStream$1(Set set, Object obj) {
                return !set.contains(obj);
            }

            public final Stream<E> parallelStream() {
                return set.parallelStream().filter(new Predicate(set2) {
                    /* class com.google.common.collect.$$Lambda$Sets$3$x17hQtUOQyO7joqWg4OEyVd0N4 */
                    private final /* synthetic */ Set f$0;

                    {
                        this.f$0 = r1;
                    }

                    public final boolean test(Object obj) {
                        return Sets.AnonymousClass3.lambda$parallelStream$1(this.f$0, obj);
                    }
                });
            }

            public final int size() {
                int i = 0;
                for (Object contains : set) {
                    if (!set2.contains(contains)) {
                        i++;
                    }
                }
                return i;
            }

            public final boolean isEmpty() {
                return set2.containsAll(set);
            }

            public final boolean contains(Object obj) {
                return set.contains(obj) && !set2.contains(obj);
            }
        };
    }

    public static <E> SetView<E> symmetricDifference(final Set<? extends E> set, final Set<? extends E> set2) {
        Preconditions.checkNotNull(set, "set1");
        Preconditions.checkNotNull(set2, "set2");
        return new SetView<E>() {
            /* class com.google.common.collect.Sets.AnonymousClass4 */

            public final UnmodifiableIterator<E> iterator() {
                final Iterator it = set.iterator();
                final Iterator it2 = set2.iterator();
                return new AbstractIterator<E>() {
                    /* class com.google.common.collect.Sets.AnonymousClass4.AnonymousClass1 */

                    public E computeNext() {
                        while (it.hasNext()) {
                            E next = it.next();
                            if (!set2.contains(next)) {
                                return next;
                            }
                        }
                        while (it2.hasNext()) {
                            E next2 = it2.next();
                            if (!set.contains(next2)) {
                                return next2;
                            }
                        }
                        return endOfData();
                    }
                };
            }

            public final int size() {
                int i = 0;
                for (Object contains : set) {
                    if (!set2.contains(contains)) {
                        i++;
                    }
                }
                for (Object contains2 : set2) {
                    if (!set.contains(contains2)) {
                        i++;
                    }
                }
                return i;
            }

            public final boolean isEmpty() {
                return set.equals(set2);
            }

            public final boolean contains(Object obj) {
                return set2.contains(obj) ^ set.contains(obj);
            }
        };
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.common.collect.Sets.filter(java.util.SortedSet, com.google.common.base.Predicate):java.util.SortedSet<E>
     arg types: [java.util.SortedSet, com.google.common.base.Predicate<? super E>]
     candidates:
      com.google.common.collect.Sets.filter(java.util.NavigableSet, com.google.common.base.Predicate):java.util.NavigableSet<E>
      com.google.common.collect.Sets.filter(java.util.Set, com.google.common.base.Predicate):java.util.Set<E>
      com.google.common.collect.Sets.filter(java.util.SortedSet, com.google.common.base.Predicate):java.util.SortedSet<E> */
    public static <E> Set<E> filter(Set<E> set, com.google.common.base.Predicate<? super E> predicate) {
        if (set instanceof SortedSet) {
            return filter((SortedSet) set, (com.google.common.base.Predicate) predicate);
        }
        if (!(set instanceof FilteredSet)) {
            return new FilteredSet((Set) Preconditions.checkNotNull(set), (com.google.common.base.Predicate) Preconditions.checkNotNull(predicate));
        }
        FilteredSet filteredSet = (FilteredSet) set;
        return new FilteredSet((Set) filteredSet.unfiltered, Predicates.and(filteredSet.predicate, predicate));
    }

    public static <E> SortedSet<E> filter(SortedSet<E> sortedSet, com.google.common.base.Predicate<? super E> predicate) {
        if (!(sortedSet instanceof FilteredSet)) {
            return new FilteredSortedSet((SortedSet) Preconditions.checkNotNull(sortedSet), (com.google.common.base.Predicate) Preconditions.checkNotNull(predicate));
        }
        FilteredSet filteredSet = (FilteredSet) sortedSet;
        return new FilteredSortedSet((SortedSet) filteredSet.unfiltered, Predicates.and(filteredSet.predicate, predicate));
    }

    @GwtIncompatible
    public static <E> NavigableSet<E> filter(NavigableSet<E> navigableSet, com.google.common.base.Predicate<? super E> predicate) {
        if (!(navigableSet instanceof FilteredSet)) {
            return new FilteredNavigableSet((NavigableSet) Preconditions.checkNotNull(navigableSet), (com.google.common.base.Predicate) Preconditions.checkNotNull(predicate));
        }
        FilteredSet filteredSet = (FilteredSet) navigableSet;
        return new FilteredNavigableSet((NavigableSet) filteredSet.unfiltered, Predicates.and(filteredSet.predicate, predicate));
    }

    static class FilteredSet<E> extends Collections2.FilteredCollection<E> implements Set<E> {
        FilteredSet(Set<E> set, com.google.common.base.Predicate<? super E> predicate) {
            super(set, predicate);
        }

        public boolean equals(Object obj) {
            return Sets.equalsImpl(this, obj);
        }

        public int hashCode() {
            return Sets.hashCodeImpl(this);
        }
    }

    static class FilteredSortedSet<E> extends FilteredSet<E> implements SortedSet<E> {
        FilteredSortedSet(SortedSet<E> sortedSet, com.google.common.base.Predicate<? super E> predicate) {
            super(sortedSet, predicate);
        }

        public Comparator<? super E> comparator() {
            return ((SortedSet) this.unfiltered).comparator();
        }

        public SortedSet<E> subSet(E e, E e2) {
            return new FilteredSortedSet(((SortedSet) this.unfiltered).subSet(e, e2), this.predicate);
        }

        public SortedSet<E> headSet(E e) {
            return new FilteredSortedSet(((SortedSet) this.unfiltered).headSet(e), this.predicate);
        }

        public SortedSet<E> tailSet(E e) {
            return new FilteredSortedSet(((SortedSet) this.unfiltered).tailSet(e), this.predicate);
        }

        public E first() {
            return Iterators.find(this.unfiltered.iterator(), this.predicate);
        }

        public E last() {
            SortedSet sortedSet = (SortedSet) this.unfiltered;
            while (true) {
                E last = sortedSet.last();
                if (this.predicate.apply(last)) {
                    return last;
                }
                sortedSet = sortedSet.headSet(last);
            }
        }
    }

    @GwtIncompatible
    static class FilteredNavigableSet<E> extends FilteredSortedSet<E> implements NavigableSet<E> {
        FilteredNavigableSet(NavigableSet<E> navigableSet, com.google.common.base.Predicate<? super E> predicate) {
            super(navigableSet, predicate);
        }

        /* access modifiers changed from: package-private */
        public NavigableSet<E> unfiltered() {
            return (NavigableSet) this.unfiltered;
        }

        public E lower(E e) {
            return Iterators.find(unfiltered().headSet(e, false).descendingIterator(), this.predicate, null);
        }

        public E floor(E e) {
            return Iterators.find(unfiltered().headSet(e, true).descendingIterator(), this.predicate, null);
        }

        public E ceiling(E e) {
            return Iterables.find(unfiltered().tailSet(e, true), this.predicate, null);
        }

        public E higher(E e) {
            return Iterables.find(unfiltered().tailSet(e, false), this.predicate, null);
        }

        public E pollFirst() {
            return Iterables.removeFirstMatching(unfiltered(), this.predicate);
        }

        public E pollLast() {
            return Iterables.removeFirstMatching(unfiltered().descendingSet(), this.predicate);
        }

        public NavigableSet<E> descendingSet() {
            return Sets.filter(unfiltered().descendingSet(), this.predicate);
        }

        public Iterator<E> descendingIterator() {
            return Iterators.filter(unfiltered().descendingIterator(), this.predicate);
        }

        public E last() {
            return Iterators.find(unfiltered().descendingIterator(), this.predicate);
        }

        public NavigableSet<E> subSet(E e, boolean z, E e2, boolean z2) {
            return Sets.filter(unfiltered().subSet(e, z, e2, z2), this.predicate);
        }

        public NavigableSet<E> headSet(E e, boolean z) {
            return Sets.filter(unfiltered().headSet(e, z), this.predicate);
        }

        public NavigableSet<E> tailSet(E e, boolean z) {
            return Sets.filter(unfiltered().tailSet(e, z), this.predicate);
        }
    }

    public static <B> Set<List<B>> cartesianProduct(List<? extends Set<? extends B>> list) {
        return CartesianSet.create(list);
    }

    @SafeVarargs
    public static <B> Set<List<B>> cartesianProduct(Set<? extends B>... setArr) {
        return cartesianProduct(Arrays.asList(setArr));
    }

    static final class CartesianSet<E> extends ForwardingCollection<List<E>> implements Set<List<E>> {
        private final transient ImmutableList<ImmutableSet<E>> axes;
        private final transient CartesianList<E> delegate;

        static <E> Set<List<E>> create(List<? extends Set<? extends E>> list) {
            ImmutableList.Builder builder = new ImmutableList.Builder(list.size());
            for (Set set : list) {
                ImmutableSet copyOf = ImmutableSet.copyOf((Collection) set);
                if (copyOf.isEmpty()) {
                    return ImmutableSet.of();
                }
                builder.add((Object) copyOf);
            }
            final ImmutableList build = builder.build();
            return new CartesianSet(build, new CartesianList(new ImmutableList<List<E>>() {
                /* class com.google.common.collect.Sets.CartesianSet.AnonymousClass1 */

                /* access modifiers changed from: package-private */
                public final boolean isPartialView() {
                    return true;
                }

                public final int size() {
                    return build.size();
                }

                public final List<E> get(int i) {
                    return ((ImmutableSet) build.get(i)).asList();
                }
            }));
        }

        private CartesianSet(ImmutableList<ImmutableSet<E>> immutableList, CartesianList<E> cartesianList) {
            this.axes = immutableList;
            this.delegate = cartesianList;
        }

        /* access modifiers changed from: protected */
        public final Collection<List<E>> delegate() {
            return this.delegate;
        }

        public final boolean equals(Object obj) {
            if (obj instanceof CartesianSet) {
                return this.axes.equals(((CartesianSet) obj).axes);
            }
            return super.equals(obj);
        }

        public final int hashCode() {
            int i = 1;
            int size = size() - 1;
            for (int i2 = 0; i2 < this.axes.size(); i2++) {
                size = ((size * 31) ^ -1) ^ -1;
            }
            UnmodifiableIterator<ImmutableSet<E>> it = this.axes.iterator();
            while (it.hasNext()) {
                Set next = it.next();
                i = (((i * 31) + ((size() / next.size()) * next.hashCode())) ^ -1) ^ -1;
            }
            return ((i + size) ^ -1) ^ -1;
        }
    }

    @GwtCompatible(serializable = false)
    public static <E> Set<Set<E>> powerSet(Set<E> set) {
        return new PowerSet(set);
    }

    static final class SubSet<E> extends AbstractSet<E> {
        public final ImmutableMap<E, Integer> inputSet;
        public final int mask;

        SubSet(ImmutableMap<E, Integer> immutableMap, int i) {
            this.inputSet = immutableMap;
            this.mask = i;
        }

        public final Iterator<E> iterator() {
            return new UnmodifiableIterator<E>() {
                /* class com.google.common.collect.Sets.SubSet.AnonymousClass1 */
                final ImmutableList<E> elements = SubSet.this.inputSet.keySet().asList();
                int remainingSetBits = SubSet.this.mask;

                public boolean hasNext() {
                    return this.remainingSetBits != 0;
                }

                public E next() {
                    int numberOfTrailingZeros = Integer.numberOfTrailingZeros(this.remainingSetBits);
                    if (numberOfTrailingZeros != 32) {
                        this.remainingSetBits &= (1 << numberOfTrailingZeros) ^ -1;
                        return this.elements.get(numberOfTrailingZeros);
                    }
                    throw new NoSuchElementException();
                }
            };
        }

        public final int size() {
            return Integer.bitCount(this.mask);
        }

        public final boolean contains(Object obj) {
            Integer num = this.inputSet.get(obj);
            if (num == null) {
                return false;
            }
            return ((1 << num.intValue()) & this.mask) != 0;
        }
    }

    static final class PowerSet<E> extends AbstractSet<Set<E>> {
        final ImmutableMap<E, Integer> inputSet;

        public final boolean isEmpty() {
            return false;
        }

        PowerSet(Set<E> set) {
            Preconditions.checkArgument(set.size() <= 30, "Too many elements to create power set: %s > 30", set.size());
            this.inputSet = Maps.indexMap(set);
        }

        public final int size() {
            return 1 << this.inputSet.size();
        }

        public final Iterator<Set<E>> iterator() {
            return new AbstractIndexedListIterator<Set<E>>(size()) {
                /* class com.google.common.collect.Sets.PowerSet.AnonymousClass1 */

                /* access modifiers changed from: protected */
                public Set<E> get(int i) {
                    return new SubSet(PowerSet.this.inputSet, i);
                }
            };
        }

        public final boolean contains(Object obj) {
            if (!(obj instanceof Set)) {
                return false;
            }
            return this.inputSet.keySet().containsAll((Set) obj);
        }

        public final boolean equals(Object obj) {
            if (obj instanceof PowerSet) {
                return this.inputSet.equals(((PowerSet) obj).inputSet);
            }
            return super.equals(obj);
        }

        public final int hashCode() {
            return this.inputSet.keySet().hashCode() << (this.inputSet.size() - 1);
        }

        public final String toString() {
            return "powerSet(" + this.inputSet + ")";
        }
    }

    @Beta
    public static <E> Set<Set<E>> combinations(Set<E> set, final int i) {
        final ImmutableMap<E, Integer> indexMap = Maps.indexMap(set);
        CollectPreconditions.checkNonnegative(i, "size");
        Preconditions.checkArgument(i <= indexMap.size(), "size (%s) must be <= set.size() (%s)", i, indexMap.size());
        if (i == 0) {
            return ImmutableSet.of(ImmutableSet.of());
        }
        if (i == indexMap.size()) {
            return ImmutableSet.of(indexMap.keySet());
        }
        return new AbstractSet<Set<E>>() {
            /* class com.google.common.collect.Sets.AnonymousClass5 */

            public final boolean contains(Object obj) {
                if (obj instanceof Set) {
                    Set set = (Set) obj;
                    if (set.size() != i || !indexMap.keySet().containsAll(set)) {
                        return false;
                    }
                    return true;
                }
                return false;
            }

            public final Iterator<Set<E>> iterator() {
                return new AbstractIterator<Set<E>>() {
                    /* class com.google.common.collect.Sets.AnonymousClass5.AnonymousClass1 */
                    final BitSet bits = new BitSet(indexMap.size());

                    /* access modifiers changed from: protected */
                    public Set<E> computeNext() {
                        if (this.bits.isEmpty()) {
                            this.bits.set(0, i);
                        } else {
                            int nextSetBit = this.bits.nextSetBit(0);
                            int nextClearBit = this.bits.nextClearBit(nextSetBit);
                            if (nextClearBit == indexMap.size()) {
                                return (Set) endOfData();
                            }
                            int i = (nextClearBit - nextSetBit) - 1;
                            this.bits.set(0, i);
                            this.bits.clear(i, nextClearBit);
                            this.bits.set(nextClearBit);
                        }
                        final BitSet bitSet = (BitSet) this.bits.clone();
                        return new AbstractSet<E>() {
                            /* class com.google.common.collect.Sets.AnonymousClass5.AnonymousClass1.AnonymousClass1 */

                            public boolean contains(Object obj) {
                                Integer num = (Integer) indexMap.get(obj);
                                return num != null && bitSet.get(num.intValue());
                            }

                            public Iterator<E> iterator() {
                                return new AbstractIterator<E>() {
                                    /* class com.google.common.collect.Sets.AnonymousClass5.AnonymousClass1.AnonymousClass1.AnonymousClass1 */
                                    int i = -1;

                                    /* access modifiers changed from: protected */
                                    public E computeNext() {
                                        this.i = bitSet.nextSetBit(this.i + 1);
                                        if (this.i == -1) {
                                            return endOfData();
                                        }
                                        return indexMap.keySet().asList().get(this.i);
                                    }
                                };
                            }

                            public int size() {
                                return i;
                            }
                        };
                    }
                };
            }

            public final int size() {
                return IntMath.binomial(indexMap.size(), i);
            }

            public final String toString() {
                return "Sets.combinations(" + indexMap.keySet() + ", " + i + ")";
            }
        };
    }

    static int hashCodeImpl(Set<?> set) {
        Iterator<?> it = set.iterator();
        int i = 0;
        while (it.hasNext()) {
            Object next = it.next();
            i = ((i + (next != null ? next.hashCode() : 0)) ^ -1) ^ -1;
        }
        return i;
    }

    static boolean equalsImpl(Set<?> set, Object obj) {
        if (set == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set2 = (Set) obj;
            try {
                return set.size() == set2.size() && set.containsAll(set2);
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
    }

    public static <E> NavigableSet<E> unmodifiableNavigableSet(NavigableSet<E> navigableSet) {
        return ((navigableSet instanceof ImmutableCollection) || (navigableSet instanceof UnmodifiableNavigableSet)) ? navigableSet : new UnmodifiableNavigableSet(navigableSet);
    }

    static final class UnmodifiableNavigableSet<E> extends ForwardingSortedSet<E> implements Serializable, NavigableSet<E> {
        private static final long serialVersionUID = 0;
        private final NavigableSet<E> delegate;
        private transient UnmodifiableNavigableSet<E> descendingSet;
        private final SortedSet<E> unmodifiableDelegate;

        /* JADX WARN: Type inference failed for: r2v0, types: [java.util.SortedSet, java.lang.Object, java.util.NavigableSet<E>] */
        /* JADX WARNING: Unknown variable types count: 1 */
        UnmodifiableNavigableSet(NavigableSet<E> r2) {
            this.delegate = (NavigableSet) Preconditions.checkNotNull(r2);
            this.unmodifiableDelegate = Collections.unmodifiableSortedSet(r2);
        }

        /* access modifiers changed from: protected */
        public final SortedSet<E> delegate() {
            return this.unmodifiableDelegate;
        }

        public final boolean removeIf(Predicate<? super E> predicate) {
            throw new UnsupportedOperationException();
        }

        public final Stream<E> stream() {
            return this.delegate.stream();
        }

        public final Stream<E> parallelStream() {
            return this.delegate.parallelStream();
        }

        public final void forEach(Consumer<? super E> consumer) {
            this.delegate.forEach(consumer);
        }

        public final E lower(E e) {
            return this.delegate.lower(e);
        }

        public final E floor(E e) {
            return this.delegate.floor(e);
        }

        public final E ceiling(E e) {
            return this.delegate.ceiling(e);
        }

        public final E higher(E e) {
            return this.delegate.higher(e);
        }

        public final E pollFirst() {
            throw new UnsupportedOperationException();
        }

        public final E pollLast() {
            throw new UnsupportedOperationException();
        }

        public final NavigableSet<E> descendingSet() {
            UnmodifiableNavigableSet<E> unmodifiableNavigableSet = this.descendingSet;
            if (unmodifiableNavigableSet != null) {
                return unmodifiableNavigableSet;
            }
            UnmodifiableNavigableSet<E> unmodifiableNavigableSet2 = new UnmodifiableNavigableSet<>(this.delegate.descendingSet());
            this.descendingSet = unmodifiableNavigableSet2;
            unmodifiableNavigableSet2.descendingSet = this;
            return unmodifiableNavigableSet2;
        }

        public final Iterator<E> descendingIterator() {
            return Iterators.unmodifiableIterator(this.delegate.descendingIterator());
        }

        public final NavigableSet<E> subSet(E e, boolean z, E e2, boolean z2) {
            return Sets.unmodifiableNavigableSet(this.delegate.subSet(e, z, e2, z2));
        }

        public final NavigableSet<E> headSet(E e, boolean z) {
            return Sets.unmodifiableNavigableSet(this.delegate.headSet(e, z));
        }

        public final NavigableSet<E> tailSet(E e, boolean z) {
            return Sets.unmodifiableNavigableSet(this.delegate.tailSet(e, z));
        }
    }

    @GwtIncompatible
    public static <E> NavigableSet<E> synchronizedNavigableSet(NavigableSet<E> navigableSet) {
        return Synchronized.navigableSet(navigableSet);
    }

    static boolean removeAllImpl(Set<?> set, Iterator<?> it) {
        boolean z = false;
        while (it.hasNext()) {
            z |= set.remove(it.next());
        }
        return z;
    }

    static boolean removeAllImpl(Set<?> set, Collection<?> collection) {
        Preconditions.checkNotNull(collection);
        if (collection instanceof Multiset) {
            collection = ((Multiset) collection).elementSet();
        }
        if (!(collection instanceof Set) || collection.size() <= set.size()) {
            return removeAllImpl(set, collection.iterator());
        }
        return Iterators.removeAll(set.iterator(), collection);
    }

    @GwtIncompatible
    static class DescendingSet<E> extends ForwardingNavigableSet<E> {
        private final NavigableSet<E> forward;

        DescendingSet(NavigableSet<E> navigableSet) {
            this.forward = navigableSet;
        }

        /* access modifiers changed from: protected */
        public NavigableSet<E> delegate() {
            return this.forward;
        }

        public E lower(E e) {
            return this.forward.higher(e);
        }

        public E floor(E e) {
            return this.forward.ceiling(e);
        }

        public E ceiling(E e) {
            return this.forward.floor(e);
        }

        public E higher(E e) {
            return this.forward.lower(e);
        }

        public E pollFirst() {
            return this.forward.pollLast();
        }

        public E pollLast() {
            return this.forward.pollFirst();
        }

        public NavigableSet<E> descendingSet() {
            return this.forward;
        }

        public Iterator<E> descendingIterator() {
            return this.forward.iterator();
        }

        public NavigableSet<E> subSet(E e, boolean z, E e2, boolean z2) {
            return this.forward.subSet(e2, z2, e, z).descendingSet();
        }

        public SortedSet<E> subSet(E e, E e2) {
            return standardSubSet(e, e2);
        }

        public NavigableSet<E> headSet(E e, boolean z) {
            return this.forward.tailSet(e, z).descendingSet();
        }

        public SortedSet<E> headSet(E e) {
            return standardHeadSet(e);
        }

        public NavigableSet<E> tailSet(E e, boolean z) {
            return this.forward.headSet(e, z).descendingSet();
        }

        public SortedSet<E> tailSet(E e) {
            return standardTailSet(e);
        }

        public Comparator<? super E> comparator() {
            Comparator<? super E> comparator = this.forward.comparator();
            if (comparator == null) {
                return Ordering.natural().reverse();
            }
            return reverse(comparator);
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [java.util.Comparator<T>, java.util.Comparator] */
        /* JADX WARNING: Unknown variable types count: 1 */
        private static <T> Ordering<T> reverse(Comparator<T> r0) {
            return Ordering.from((Comparator) r0).reverse();
        }

        public E first() {
            return this.forward.last();
        }

        public E last() {
            return this.forward.first();
        }

        public Iterator<E> iterator() {
            return this.forward.descendingIterator();
        }

        public Object[] toArray() {
            return standardToArray();
        }

        public <T> T[] toArray(T[] tArr) {
            return standardToArray(tArr);
        }

        public String toString() {
            return standardToString();
        }
    }

    @GwtIncompatible
    @Beta
    public static <K extends Comparable<? super K>> NavigableSet<K> subSet(NavigableSet<K> navigableSet, Range<K> range) {
        boolean z = true;
        if (navigableSet.comparator() != null && navigableSet.comparator() != Ordering.natural() && range.hasLowerBound() && range.hasUpperBound()) {
            Preconditions.checkArgument(navigableSet.comparator().compare(range.lowerEndpoint(), range.upperEndpoint()) <= 0, "set is using a custom comparator which is inconsistent with the natural ordering.");
        }
        if (range.hasLowerBound() && range.hasUpperBound()) {
            K lowerEndpoint = range.lowerEndpoint();
            boolean z2 = range.lowerBoundType() == BoundType.CLOSED;
            K upperEndpoint = range.upperEndpoint();
            if (range.upperBoundType() != BoundType.CLOSED) {
                z = false;
            }
            return navigableSet.subSet(lowerEndpoint, z2, upperEndpoint, z);
        } else if (range.hasLowerBound()) {
            K lowerEndpoint2 = range.lowerEndpoint();
            if (range.lowerBoundType() != BoundType.CLOSED) {
                z = false;
            }
            return navigableSet.tailSet(lowerEndpoint2, z);
        } else if (!range.hasUpperBound()) {
            return (NavigableSet) Preconditions.checkNotNull(navigableSet);
        } else {
            K upperEndpoint2 = range.upperEndpoint();
            if (range.upperBoundType() != BoundType.CLOSED) {
                z = false;
            }
            return navigableSet.headSet(upperEndpoint2, z);
        }
    }
}
