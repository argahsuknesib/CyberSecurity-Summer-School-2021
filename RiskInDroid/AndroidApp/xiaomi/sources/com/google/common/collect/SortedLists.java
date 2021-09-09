package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import java.util.Comparator;
import java.util.List;
import java.util.RandomAccess;

@GwtCompatible
@Beta
final class SortedLists {

    enum KeyAbsentBehavior {
        NEXT_LOWER {
            /* access modifiers changed from: package-private */
            public final int resultIndex(int i) {
                return i - 1;
            }
        },
        NEXT_HIGHER {
            public final int resultIndex(int i) {
                return i;
            }
        },
        INVERTED_INSERTION_INDEX {
            public final int resultIndex(int i) {
                return i ^ -1;
            }
        };

        /* access modifiers changed from: package-private */
        public abstract int resultIndex(int i);
    }

    enum KeyPresentBehavior {
        ANY_PRESENT {
            /* access modifiers changed from: package-private */
            public final <E> int resultIndex(Comparator<? super E> comparator, E e, List<? extends E> list, int i) {
                return i;
            }
        },
        LAST_PRESENT {
            /* access modifiers changed from: package-private */
            public final <E> int resultIndex(Comparator<? super E> comparator, E e, List<? extends E> list, int i) {
                int size = list.size() - 1;
                while (i < size) {
                    int i2 = ((i + size) + 1) >>> 1;
                    if (comparator.compare(list.get(i2), e) > 0) {
                        size = i2 - 1;
                    } else {
                        i = i2;
                    }
                }
                return i;
            }
        },
        FIRST_PRESENT {
            /* access modifiers changed from: package-private */
            public final <E> int resultIndex(Comparator<? super E> comparator, E e, List<? extends E> list, int i) {
                int i2 = 0;
                while (i2 < i) {
                    int i3 = (i2 + i) >>> 1;
                    if (comparator.compare(list.get(i3), e) < 0) {
                        i2 = i3 + 1;
                    } else {
                        i = i3;
                    }
                }
                return i2;
            }
        },
        FIRST_AFTER {
            public final <E> int resultIndex(Comparator<? super E> comparator, E e, List<? extends E> list, int i) {
                return LAST_PRESENT.resultIndex(comparator, e, list, i) + 1;
            }
        },
        LAST_BEFORE {
            public final <E> int resultIndex(Comparator<? super E> comparator, E e, List<? extends E> list, int i) {
                return FIRST_PRESENT.resultIndex(comparator, e, list, i) - 1;
            }
        };

        /* access modifiers changed from: package-private */
        public abstract <E> int resultIndex(Comparator<? super E> comparator, E e, List<? extends E> list, int i);
    }

    private SortedLists() {
    }

    public static <E extends Comparable> int binarySearch(List<? extends E> list, E e, KeyPresentBehavior keyPresentBehavior, KeyAbsentBehavior keyAbsentBehavior) {
        Preconditions.checkNotNull(e);
        return binarySearch(list, e, Ordering.natural(), keyPresentBehavior, keyAbsentBehavior);
    }

    public static <E, K extends Comparable> int binarySearch(List list, Function function, Comparable comparable, KeyPresentBehavior keyPresentBehavior, KeyAbsentBehavior keyAbsentBehavior) {
        return binarySearch(list, function, comparable, Ordering.natural(), keyPresentBehavior, keyAbsentBehavior);
    }

    public static <E, K> int binarySearch(List<E> list, Function<? super E, K> function, K k, Comparator<? super K> comparator, KeyPresentBehavior keyPresentBehavior, KeyAbsentBehavior keyAbsentBehavior) {
        return binarySearch(Lists.transform(list, function), k, comparator, keyPresentBehavior, keyAbsentBehavior);
    }

    public static <E> int binarySearch(List list, Object obj, Comparator comparator, KeyPresentBehavior keyPresentBehavior, KeyAbsentBehavior keyAbsentBehavior) {
        Preconditions.checkNotNull(comparator);
        Preconditions.checkNotNull(list);
        Preconditions.checkNotNull(keyPresentBehavior);
        Preconditions.checkNotNull(keyAbsentBehavior);
        if (!(list instanceof RandomAccess)) {
            list = Lists.newArrayList(list);
        }
        int i = 0;
        int size = list.size() - 1;
        while (i <= size) {
            int i2 = (i + size) >>> 1;
            int compare = comparator.compare(obj, list.get(i2));
            if (compare < 0) {
                size = i2 - 1;
            } else if (compare <= 0) {
                return i + keyPresentBehavior.resultIndex(comparator, obj, list.subList(i, size + 1), i2 - i);
            } else {
                i = i2 + 1;
            }
        }
        return keyAbsentBehavior.resultIndex(i);
    }
}
