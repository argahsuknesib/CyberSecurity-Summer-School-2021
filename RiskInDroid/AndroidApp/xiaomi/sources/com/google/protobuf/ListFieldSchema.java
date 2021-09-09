package com.google.protobuf;

import com.google.protobuf.Internal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

abstract class ListFieldSchema {
    private static final ListFieldSchema FULL_INSTANCE = new ListFieldSchemaFull();
    private static final ListFieldSchema LITE_INSTANCE = new ListFieldSchemaLite();

    /* access modifiers changed from: package-private */
    public abstract void makeImmutableListAt(Object obj, long j);

    /* access modifiers changed from: package-private */
    public abstract <L> void mergeListsAt(Object obj, Object obj2, long j);

    /* access modifiers changed from: package-private */
    public abstract <L> List<L> mutableListAt(Object obj, long j);

    private ListFieldSchema() {
    }

    static ListFieldSchema full() {
        return FULL_INSTANCE;
    }

    static ListFieldSchema lite() {
        return LITE_INSTANCE;
    }

    static final class ListFieldSchemaFull extends ListFieldSchema {
        private static final Class<?> UNMODIFIABLE_LIST_CLASS = Collections.unmodifiableList(Collections.emptyList()).getClass();

        private ListFieldSchemaFull() {
            super();
        }

        /* access modifiers changed from: package-private */
        public final <L> List<L> mutableListAt(Object obj, long j) {
            return mutableListAt(obj, j, 10);
        }

        /* access modifiers changed from: package-private */
        public final void makeImmutableListAt(Object obj, long j) {
            Object obj2;
            List list = (List) UnsafeUtil.getObject(obj, j);
            if (list instanceof LazyStringList) {
                obj2 = ((LazyStringList) list).getUnmodifiableView();
            } else if (!UNMODIFIABLE_LIST_CLASS.isAssignableFrom(list.getClass())) {
                if (!(list instanceof PrimitiveNonBoxingCollection) || !(list instanceof Internal.ProtobufList)) {
                    obj2 = Collections.unmodifiableList(list);
                } else {
                    Internal.ProtobufList protobufList = (Internal.ProtobufList) list;
                    if (protobufList.isModifiable()) {
                        protobufList.makeImmutable();
                        return;
                    }
                    return;
                }
            } else {
                return;
            }
            UnsafeUtil.putObject(obj, j, obj2);
        }

        /* JADX INFO: additional move instructions added (1) to help type inference */
        private static <L> List<L> mutableListAt(Object obj, long j, int i) {
            List list;
            List<L> list2;
            List<L> list3 = getList(obj, j);
            if (list3.isEmpty()) {
                if (list3 instanceof LazyStringList) {
                    list2 = new LazyStringArrayList(i);
                } else if (!(list3 instanceof PrimitiveNonBoxingCollection) || !(list3 instanceof Internal.ProtobufList)) {
                    list2 = new ArrayList<>(i);
                } else {
                    list2 = ((Internal.ProtobufList) list3).mutableCopyWithCapacity(i);
                }
                UnsafeUtil.putObject(obj, j, list2);
                return list2;
            }
            if (UNMODIFIABLE_LIST_CLASS.isAssignableFrom(list3.getClass())) {
                List arrayList = new ArrayList(list3.size() + i);
                arrayList.addAll(list3);
                UnsafeUtil.putObject(obj, j, arrayList);
                list = arrayList;
            } else if (list3 instanceof UnmodifiableLazyStringList) {
                LazyStringArrayList lazyStringArrayList = new LazyStringArrayList(list3.size() + i);
                lazyStringArrayList.addAll((UnmodifiableLazyStringList) list3);
                UnsafeUtil.putObject(obj, j, lazyStringArrayList);
                list = lazyStringArrayList;
            } else if (!(list3 instanceof PrimitiveNonBoxingCollection) || !(list3 instanceof Internal.ProtobufList)) {
                return list3;
            } else {
                Internal.ProtobufList protobufList = (Internal.ProtobufList) list3;
                if (protobufList.isModifiable()) {
                    return list3;
                }
                Internal.ProtobufList mutableCopyWithCapacity = protobufList.mutableCopyWithCapacity(list3.size() + i);
                UnsafeUtil.putObject(obj, j, mutableCopyWithCapacity);
                return mutableCopyWithCapacity;
            }
            return list;
        }

        /* access modifiers changed from: package-private */
        public final <E> void mergeListsAt(Object obj, Object obj2, long j) {
            List list = getList(obj2, j);
            List mutableListAt = mutableListAt(obj, j, list.size());
            int size = mutableListAt.size();
            int size2 = list.size();
            if (size > 0 && size2 > 0) {
                mutableListAt.addAll(list);
            }
            if (size > 0) {
                list = mutableListAt;
            }
            UnsafeUtil.putObject(obj, j, list);
        }

        static <E> List<E> getList(Object obj, long j) {
            return (List) UnsafeUtil.getObject(obj, j);
        }
    }

    static final class ListFieldSchemaLite extends ListFieldSchema {
        private ListFieldSchemaLite() {
            super();
        }

        /* access modifiers changed from: package-private */
        public final <L> List<L> mutableListAt(Object obj, long j) {
            Internal.ProtobufList protobufList = getProtobufList(obj, j);
            if (protobufList.isModifiable()) {
                return protobufList;
            }
            int size = protobufList.size();
            Internal.ProtobufList mutableCopyWithCapacity = protobufList.mutableCopyWithCapacity(size == 0 ? 10 : size * 2);
            UnsafeUtil.putObject(obj, j, mutableCopyWithCapacity);
            return mutableCopyWithCapacity;
        }

        /* access modifiers changed from: package-private */
        public final void makeImmutableListAt(Object obj, long j) {
            getProtobufList(obj, j).makeImmutable();
        }

        /* access modifiers changed from: package-private */
        public final <E> void mergeListsAt(Object obj, Object obj2, long j) {
            Internal.ProtobufList protobufList = getProtobufList(obj, j);
            Internal.ProtobufList protobufList2 = getProtobufList(obj2, j);
            int size = protobufList.size();
            int size2 = protobufList2.size();
            if (size > 0 && size2 > 0) {
                if (!protobufList.isModifiable()) {
                    protobufList = protobufList.mutableCopyWithCapacity(size2 + size);
                }
                protobufList.addAll(protobufList2);
            }
            if (size > 0) {
                protobufList2 = protobufList;
            }
            UnsafeUtil.putObject(obj, j, protobufList2);
        }

        static <E> Internal.ProtobufList<E> getProtobufList(Object obj, long j) {
            return (Internal.ProtobufList) UnsafeUtil.getObject(obj, j);
        }
    }
}
