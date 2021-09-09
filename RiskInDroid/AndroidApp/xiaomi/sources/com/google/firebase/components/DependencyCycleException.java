package com.google.firebase.components;

import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.Arrays;
import java.util.List;

@KeepForSdk
public class DependencyCycleException extends DependencyException {
    private final List<Component<?>> zzap;

    /* JADX WARNING: Illegal instructions before constructor call */
    @KeepForSdk
    public DependencyCycleException(List<Component<?>> list) {
        super(r0.length() != 0 ? "Dependency cycle detected: ".concat(r0) : new String("Dependency cycle detected: "));
        String valueOf = String.valueOf(Arrays.toString(list.toArray()));
        this.zzap = list;
    }

    @KeepForSdk
    public List<Component<?>> getComponentsInCycle() {
        return this.zzap;
    }
}
