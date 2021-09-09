package com.google.firebase.components;

import java.util.HashSet;
import java.util.Set;

final class zzh {
    private final Component<?> zzaj;
    private final Set<zzh> zzak = new HashSet();
    private final Set<zzh> zzal = new HashSet();

    zzh(Component<?> component) {
        this.zzaj = component;
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzh zzh) {
        this.zzak.add(zzh);
    }

    /* access modifiers changed from: package-private */
    public final void zzb(zzh zzh) {
        this.zzal.add(zzh);
    }

    /* access modifiers changed from: package-private */
    public final void zzc(zzh zzh) {
        this.zzal.remove(zzh);
    }

    /* access modifiers changed from: package-private */
    public final Set<zzh> zzf() {
        return this.zzak;
    }

    /* access modifiers changed from: package-private */
    public final Component<?> zzk() {
        return this.zzaj;
    }

    /* access modifiers changed from: package-private */
    public final boolean zzl() {
        return this.zzal.isEmpty();
    }

    /* access modifiers changed from: package-private */
    public final boolean zzm() {
        return this.zzak.isEmpty();
    }
}
