package com.google.firebase.components;

import com.google.firebase.inject.Provider;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class zzg implements ComponentContainer {
    private final List<Component<?>> zzah;
    private final Map<Class<?>, zzi<?>> zzai = new HashMap();

    public zzg(Iterable<ComponentRegistrar> iterable, Component<?>... componentArr) {
        zzh zzh;
        ArrayList<Component> arrayList = new ArrayList<>();
        for (ComponentRegistrar components : iterable) {
            arrayList.addAll(components.getComponents());
        }
        Collections.addAll(arrayList, componentArr);
        HashMap hashMap = new HashMap(arrayList.size());
        for (Component component : arrayList) {
            zzh zzh2 = new zzh(component);
            Iterator it = component.zze().iterator();
            while (true) {
                if (it.hasNext()) {
                    Class cls = (Class) it.next();
                    if (hashMap.put(cls, zzh2) != null) {
                        throw new IllegalArgumentException(String.format("Multiple components provide %s.", cls));
                    }
                }
            }
        }
        for (zzh zzh3 : hashMap.values()) {
            for (Dependency next : zzh3.zzk().zzf()) {
                if (next.zzp() && (zzh = (zzh) hashMap.get(next.zzn())) != null) {
                    zzh3.zza(zzh);
                    zzh.zzb(zzh3);
                }
            }
        }
        HashSet<zzh> hashSet = new HashSet<>(hashMap.values());
        HashSet hashSet2 = new HashSet();
        for (zzh zzh4 : hashSet) {
            if (zzh4.zzl()) {
                hashSet2.add(zzh4);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        while (!hashSet2.isEmpty()) {
            zzh zzh5 = (zzh) hashSet2.iterator().next();
            hashSet2.remove(zzh5);
            arrayList2.add(zzh5.zzk());
            for (zzh next2 : zzh5.zzf()) {
                next2.zzc(zzh5);
                if (next2.zzl()) {
                    hashSet2.add(next2);
                }
            }
        }
        if (arrayList2.size() == arrayList.size()) {
            Collections.reverse(arrayList2);
            this.zzah = Collections.unmodifiableList(arrayList2);
            for (Component next3 : this.zzah) {
                zzi zzi = new zzi(next3.zzg(), new zzl(next3.zzf(), this));
                for (Class put : next3.zze()) {
                    this.zzai.put(put, zzi);
                }
            }
            for (Component next4 : this.zzah) {
                Iterator<Dependency> it2 = next4.zzf().iterator();
                while (true) {
                    if (it2.hasNext()) {
                        Dependency next5 = it2.next();
                        if (next5.zzo() && !this.zzai.containsKey(next5.zzn())) {
                            throw new MissingDependencyException(String.format("Unsatisfied dependency for component %s: %s", next4, next5.zzn()));
                        }
                    }
                }
            }
            return;
        }
        ArrayList arrayList3 = new ArrayList();
        for (zzh zzh6 : hashSet) {
            if (!zzh6.zzl() && !zzh6.zzm()) {
                arrayList3.add(zzh6.zzk());
            }
        }
        throw new DependencyCycleException(arrayList3);
    }

    public final Object get(Class cls) {
        return ComponentContainer$$CC.get(this, cls);
    }

    public final <T> Provider<T> getProvider(Class<T> cls) {
        zzk.zza(cls, "Null interface requested.");
        return this.zzai.get(cls);
    }

    public final void zzb(boolean z) {
        for (Component next : this.zzah) {
            if (next.zzh() || (next.zzi() && z)) {
                get((Class) next.zze().iterator().next());
            }
        }
    }
}
