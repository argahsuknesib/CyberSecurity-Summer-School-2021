package com.google.firebase.components;

import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@KeepForSdk
public final class Component<T> {
    private final Set<Class<? super T>> zzab;
    private final Set<Dependency> zzac;
    private final int zzad;
    private final ComponentFactory<T> zzae;

    @KeepForSdk
    public static class Builder<T> {
        private final Set<Class<? super T>> zzab;
        private final Set<Dependency> zzac;
        private int zzad;
        private ComponentFactory<T> zzae;

        private Builder(Class<T> cls, Class<? super T>... clsArr) {
            this.zzab = new HashSet();
            this.zzac = new HashSet();
            this.zzad = 0;
            zzk.zza(cls, "Null interface");
            this.zzab.add(cls);
            for (Class<? super T> zza : clsArr) {
                zzk.zza(zza, "Null interface");
            }
            Collections.addAll(this.zzab, clsArr);
        }

        private final Builder<T> zza(int i) {
            zzk.checkState(this.zzad == 0, "Instantiation type has already been set.");
            this.zzad = i;
            return this;
        }

        @KeepForSdk
        public Builder<T> add(Dependency dependency) {
            zzk.zza(dependency, "Null dependency");
            if (!this.zzab.contains(dependency.zzn())) {
                this.zzac.add(dependency);
                return this;
            }
            throw new IllegalArgumentException("Components are not allowed to depend on interfaces they themselves provide.");
        }

        @KeepForSdk
        public Builder<T> alwaysEager() {
            return zza(1);
        }

        @KeepForSdk
        public Component<T> build() {
            zzk.checkState(this.zzae != null, "Missing required property: factory.");
            return new Component(new HashSet(this.zzab), new HashSet(this.zzac), this.zzad, this.zzae);
        }

        @KeepForSdk
        public Builder<T> eagerInDefaultApp() {
            return zza(2);
        }

        @KeepForSdk
        public Builder<T> factory(ComponentFactory<T> componentFactory) {
            this.zzae = (ComponentFactory) zzk.zza(componentFactory, "Null factory");
            return this;
        }
    }

    private Component(Set<Class<? super T>> set, Set<Dependency> set2, int i, ComponentFactory<T> componentFactory) {
        this.zzab = Collections.unmodifiableSet(set);
        this.zzac = Collections.unmodifiableSet(set2);
        this.zzad = i;
        this.zzae = componentFactory;
    }

    @KeepForSdk
    public static <T> Builder<T> builder(Class<T> cls) {
        return new Builder<>(cls, new Class[0]);
    }

    @KeepForSdk
    public static <T> Builder<T> builder(Class<T> cls, Class<? super T>... clsArr) {
        return new Builder<>(cls, clsArr);
    }

    @KeepForSdk
    public static <T> Component<T> of(Class<T> cls, T t) {
        return builder(cls).factory(new zza(t)).build();
    }

    public final String toString() {
        return "Component<" + Arrays.toString(this.zzab.toArray()) + ">{" + this.zzad + ", deps=" + Arrays.toString(this.zzac.toArray()) + "}";
    }

    public final Set<Class<? super T>> zze() {
        return this.zzab;
    }

    public final Set<Dependency> zzf() {
        return this.zzac;
    }

    public final ComponentFactory<T> zzg() {
        return this.zzae;
    }

    public final boolean zzh() {
        return this.zzad == 1;
    }

    public final boolean zzi() {
        return this.zzad == 2;
    }
}
