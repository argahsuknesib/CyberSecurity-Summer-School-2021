package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Ascii;
import com.google.common.base.Equivalence;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.collect.MapMakerInternalMap;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@GwtCompatible(emulated = true)
public final class MapMaker {
    int concurrencyLevel = -1;
    int initialCapacity = -1;
    Equivalence<Object> keyEquivalence;
    MapMakerInternalMap.Strength keyStrength;
    boolean useCustomMap;
    MapMakerInternalMap.Strength valueStrength;

    enum Dummy {
        VALUE
    }

    /* access modifiers changed from: package-private */
    @GwtIncompatible
    @CanIgnoreReturnValue
    public final MapMaker keyEquivalence(Equivalence<Object> equivalence) {
        Preconditions.checkState(this.keyEquivalence == null, "key equivalence was already set to %s", this.keyEquivalence);
        this.keyEquivalence = (Equivalence) Preconditions.checkNotNull(equivalence);
        this.useCustomMap = true;
        return this;
    }

    /* access modifiers changed from: package-private */
    public final Equivalence<Object> getKeyEquivalence() {
        return (Equivalence) MoreObjects.firstNonNull(this.keyEquivalence, getKeyStrength().defaultEquivalence());
    }

    @CanIgnoreReturnValue
    public final MapMaker initialCapacity(int i) {
        boolean z = true;
        Preconditions.checkState(this.initialCapacity == -1, "initial capacity was already set to %s", this.initialCapacity);
        if (i < 0) {
            z = false;
        }
        Preconditions.checkArgument(z);
        this.initialCapacity = i;
        return this;
    }

    /* access modifiers changed from: package-private */
    public final int getInitialCapacity() {
        int i = this.initialCapacity;
        if (i == -1) {
            return 16;
        }
        return i;
    }

    @CanIgnoreReturnValue
    public final MapMaker concurrencyLevel(int i) {
        boolean z = true;
        Preconditions.checkState(this.concurrencyLevel == -1, "concurrency level was already set to %s", this.concurrencyLevel);
        if (i <= 0) {
            z = false;
        }
        Preconditions.checkArgument(z);
        this.concurrencyLevel = i;
        return this;
    }

    /* access modifiers changed from: package-private */
    public final int getConcurrencyLevel() {
        int i = this.concurrencyLevel;
        if (i == -1) {
            return 4;
        }
        return i;
    }

    @GwtIncompatible
    @CanIgnoreReturnValue
    public final MapMaker weakKeys() {
        return setKeyStrength(MapMakerInternalMap.Strength.WEAK);
    }

    /* access modifiers changed from: package-private */
    public final MapMaker setKeyStrength(MapMakerInternalMap.Strength strength) {
        Preconditions.checkState(this.keyStrength == null, "Key strength was already set to %s", this.keyStrength);
        this.keyStrength = (MapMakerInternalMap.Strength) Preconditions.checkNotNull(strength);
        if (strength != MapMakerInternalMap.Strength.STRONG) {
            this.useCustomMap = true;
        }
        return this;
    }

    /* access modifiers changed from: package-private */
    public final MapMakerInternalMap.Strength getKeyStrength() {
        return (MapMakerInternalMap.Strength) MoreObjects.firstNonNull(this.keyStrength, MapMakerInternalMap.Strength.STRONG);
    }

    @GwtIncompatible
    @CanIgnoreReturnValue
    public final MapMaker weakValues() {
        return setValueStrength(MapMakerInternalMap.Strength.WEAK);
    }

    /* access modifiers changed from: package-private */
    public final MapMaker setValueStrength(MapMakerInternalMap.Strength strength) {
        Preconditions.checkState(this.valueStrength == null, "Value strength was already set to %s", this.valueStrength);
        this.valueStrength = (MapMakerInternalMap.Strength) Preconditions.checkNotNull(strength);
        if (strength != MapMakerInternalMap.Strength.STRONG) {
            this.useCustomMap = true;
        }
        return this;
    }

    /* access modifiers changed from: package-private */
    public final MapMakerInternalMap.Strength getValueStrength() {
        return (MapMakerInternalMap.Strength) MoreObjects.firstNonNull(this.valueStrength, MapMakerInternalMap.Strength.STRONG);
    }

    public final <K, V> ConcurrentMap<K, V> makeMap() {
        if (!this.useCustomMap) {
            return new ConcurrentHashMap(getInitialCapacity(), 0.75f, getConcurrencyLevel());
        }
        return MapMakerInternalMap.create(this);
    }

    public final String toString() {
        MoreObjects.ToStringHelper stringHelper = MoreObjects.toStringHelper(this);
        int i = this.initialCapacity;
        if (i != -1) {
            stringHelper.add("initialCapacity", i);
        }
        int i2 = this.concurrencyLevel;
        if (i2 != -1) {
            stringHelper.add("concurrencyLevel", i2);
        }
        MapMakerInternalMap.Strength strength = this.keyStrength;
        if (strength != null) {
            stringHelper.add("keyStrength", Ascii.toLowerCase(strength.toString()));
        }
        MapMakerInternalMap.Strength strength2 = this.valueStrength;
        if (strength2 != null) {
            stringHelper.add("valueStrength", Ascii.toLowerCase(strength2.toString()));
        }
        if (this.keyEquivalence != null) {
            stringHelper.addValue("keyEquivalence");
        }
        return stringHelper.toString();
    }
}
