package com.google.common.reflect;

import com.google.common.annotations.Beta;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.ForwardingMap;
import com.google.common.collect.ForwardingMapEntry;
import com.google.common.collect.ForwardingSet;
import com.google.common.collect.Iterators;
import com.google.common.collect.Maps;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@Beta
public final class MutableTypeToInstanceMap<B> extends ForwardingMap<TypeToken<? extends B>, B> implements TypeToInstanceMap<B> {
    private final Map<TypeToken<? extends B>, B> backingMap = Maps.newHashMap();

    public final <T extends B> T getInstance(Class<T> cls) {
        return trustedGet(TypeToken.of((Class) cls));
    }

    public final <T extends B> T getInstance(TypeToken<T> typeToken) {
        return trustedGet(typeToken.rejectTypeVariables());
    }

    @CanIgnoreReturnValue
    public final <T extends B> T putInstance(Class<T> cls, T t) {
        return trustedPut(TypeToken.of((Class) cls), t);
    }

    @CanIgnoreReturnValue
    public final <T extends B> T putInstance(TypeToken<T> typeToken, T t) {
        return trustedPut(typeToken.rejectTypeVariables(), t);
    }

    @CanIgnoreReturnValue
    @Deprecated
    public final B put(TypeToken<? extends B> typeToken, B b) {
        throw new UnsupportedOperationException("Please use putInstance() instead.");
    }

    @Deprecated
    public final void putAll(Map<? extends TypeToken<? extends B>, ? extends B> map) {
        throw new UnsupportedOperationException("Please use putInstance() instead.");
    }

    public final Set<Map.Entry<TypeToken<? extends B>, B>> entrySet() {
        return UnmodifiableEntry.transformEntries(super.entrySet());
    }

    public final Map<TypeToken<? extends B>, B> delegate() {
        return this.backingMap;
    }

    private <T extends B> T trustedPut(TypeToken<T> typeToken, T t) {
        return this.backingMap.put(typeToken, t);
    }

    private <T extends B> T trustedGet(TypeToken<T> typeToken) {
        return this.backingMap.get(typeToken);
    }

    static final class UnmodifiableEntry<K, V> extends ForwardingMapEntry<K, V> {
        private final Map.Entry<K, V> delegate;

        static <K, V> Set<Map.Entry<K, V>> transformEntries(final Set<Map.Entry<K, V>> set) {
            return new ForwardingSet<Map.Entry<K, V>>() {
                /* class com.google.common.reflect.MutableTypeToInstanceMap.UnmodifiableEntry.AnonymousClass1 */

                public final Set<Map.Entry<K, V>> delegate() {
                    return set;
                }

                public final Iterator<Map.Entry<K, V>> iterator() {
                    return UnmodifiableEntry.transformEntries(super.iterator());
                }

                public final Object[] toArray() {
                    return standardToArray();
                }

                public final <T> T[] toArray(T[] tArr) {
                    return standardToArray(tArr);
                }
            };
        }

        public static <K, V> Iterator<Map.Entry<K, V>> transformEntries(Iterator<Map.Entry<K, V>> it) {
            return Iterators.transform(it, new Function<Map.Entry<K, V>, Map.Entry<K, V>>() {
                /* class com.google.common.reflect.MutableTypeToInstanceMap.UnmodifiableEntry.AnonymousClass2 */

                public final Map.Entry<K, V> apply(Map.Entry<K, V> entry) {
                    return new UnmodifiableEntry(entry);
                }
            });
        }

        private UnmodifiableEntry(Map.Entry<K, V> entry) {
            this.delegate = (Map.Entry) Preconditions.checkNotNull(entry);
        }

        public final Map.Entry<K, V> delegate() {
            return this.delegate;
        }

        public final V setValue(V v) {
            throw new UnsupportedOperationException();
        }
    }
}
