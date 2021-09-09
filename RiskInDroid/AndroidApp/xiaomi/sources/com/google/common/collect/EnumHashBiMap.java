package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.Enum;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.BiFunction;

@GwtCompatible(emulated = true)
public final class EnumHashBiMap<K extends Enum<K>, V> extends AbstractBiMap<K, V> {
    @GwtIncompatible
    private static final long serialVersionUID = 0;
    private transient Class<K> keyType;

    public final /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    public final /* bridge */ /* synthetic */ boolean containsValue(Object obj) {
        return super.containsValue(obj);
    }

    public final /* bridge */ /* synthetic */ Set entrySet() {
        return super.entrySet();
    }

    public final /* bridge */ /* synthetic */ BiMap inverse() {
        return super.inverse();
    }

    public final /* bridge */ /* synthetic */ Set keySet() {
        return super.keySet();
    }

    public final /* bridge */ /* synthetic */ void putAll(Map map) {
        super.putAll(map);
    }

    @CanIgnoreReturnValue
    public final /* bridge */ /* synthetic */ Object remove(Object obj) {
        return super.remove(obj);
    }

    public final /* bridge */ /* synthetic */ void replaceAll(BiFunction biFunction) {
        super.replaceAll(biFunction);
    }

    public final /* bridge */ /* synthetic */ Set values() {
        return super.values();
    }

    public static <K extends Enum<K>, V> EnumHashBiMap<K, V> create(Class<K> cls) {
        return new EnumHashBiMap<>(cls);
    }

    public static <K extends Enum<K>, V> EnumHashBiMap<K, V> create(Map<K, ? extends V> map) {
        EnumHashBiMap<K, V> create = create(EnumBiMap.inferKeyType(map));
        create.putAll(map);
        return create;
    }

    private EnumHashBiMap(Class<K> cls) {
        super(WellBehavedMap.wrap(new EnumMap(cls)), Maps.newHashMapWithExpectedSize(((Enum[]) cls.getEnumConstants()).length));
        this.keyType = cls;
    }

    /* access modifiers changed from: package-private */
    public final K checkKey(K k) {
        return (Enum) Preconditions.checkNotNull(k);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.common.collect.AbstractBiMap.put(java.lang.Object, java.lang.Object):V
     arg types: [K, V]
     candidates:
      com.google.common.collect.EnumHashBiMap.put(java.lang.Enum, java.lang.Object):V
      com.google.common.collect.AbstractBiMap.put(java.lang.Object, java.lang.Object):V */
    @CanIgnoreReturnValue
    public final V put(K k, V v) {
        return super.put((Object) k, (Object) v);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.common.collect.AbstractBiMap.forcePut(java.lang.Object, java.lang.Object):V
     arg types: [K, V]
     candidates:
      com.google.common.collect.EnumHashBiMap.forcePut(java.lang.Enum, java.lang.Object):V
      com.google.common.collect.AbstractBiMap.forcePut(java.lang.Object, java.lang.Object):V */
    @CanIgnoreReturnValue
    public final V forcePut(K k, V v) {
        return super.forcePut((Object) k, (Object) v);
    }

    public final Class<K> keyType() {
        return this.keyType;
    }

    @GwtIncompatible
    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.keyType);
        Serialization.writeMap(this, objectOutputStream);
    }

    @GwtIncompatible
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.keyType = (Class) objectInputStream.readObject();
        setDelegates(WellBehavedMap.wrap(new EnumMap(this.keyType)), new HashMap((((Enum[]) this.keyType.getEnumConstants()).length * 3) / 2));
        Serialization.populateMap(this, objectInputStream);
    }
}
