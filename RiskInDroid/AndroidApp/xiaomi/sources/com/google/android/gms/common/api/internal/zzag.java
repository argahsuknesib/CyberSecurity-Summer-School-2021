package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.internal.BaseImplementation;

public final class zzag implements zzbc {
    /* access modifiers changed from: private */
    public final zzbd zzhf;
    private boolean zzhg = false;

    public zzag(zzbd zzbd) {
        this.zzhf = zzbd;
    }

    public final void begin() {
    }

    public final void connect() {
        if (this.zzhg) {
            this.zzhg = false;
            this.zzhf.zza(new zzai(this, this));
        }
    }

    public final boolean disconnect() {
        if (this.zzhg) {
            return false;
        }
        if (this.zzhf.zzfq.zzba()) {
            this.zzhg = true;
            for (zzch zzcc : this.zzhf.zzfq.zziq) {
                zzcc.zzcc();
            }
            return false;
        }
        this.zzhf.zzf(null);
        return true;
    }

    public final <A extends Api.AnyClient, R extends Result, T extends BaseImplementation.ApiMethodImpl<R, A>> T enqueue(T t) {
        return execute(t);
    }

    /* JADX INFO: additional move instructions added (1) to help type inference */
    /*  JADX ERROR: JadxRuntimeException in pass: MethodInvokeVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not class type: T
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
    public final <A extends com.google.android.gms.common.api.Api.AnyClient, T extends com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl<? extends com.google.android.gms.common.api.Result, A>> T execute(T r4) {
        /*
            r3 = this;
            com.google.android.gms.common.api.internal.zzbd r0 = r3.zzhf     // Catch:{ DeadObjectException -> 0x004b }
            com.google.android.gms.common.api.internal.zzav r0 = r0.zzfq     // Catch:{ DeadObjectException -> 0x004b }
            com.google.android.gms.common.api.internal.zzck r0 = r0.zzir     // Catch:{ DeadObjectException -> 0x004b }
            r0.zzb(r4)     // Catch:{ DeadObjectException -> 0x004b }
            com.google.android.gms.common.api.internal.zzbd r0 = r3.zzhf     // Catch:{ DeadObjectException -> 0x004b }
            com.google.android.gms.common.api.internal.zzav r0 = r0.zzfq     // Catch:{ DeadObjectException -> 0x004b }
            com.google.android.gms.common.api.Api$AnyClientKey r1 = r4.getClientKey()     // Catch:{ DeadObjectException -> 0x004b }
            java.util.Map<com.google.android.gms.common.api.Api$AnyClientKey<?>, com.google.android.gms.common.api.Api$Client> r0 = r0.zzil     // Catch:{ DeadObjectException -> 0x004b }
            java.lang.Object r0 = r0.get(r1)     // Catch:{ DeadObjectException -> 0x004b }
            com.google.android.gms.common.api.Api$Client r0 = (com.google.android.gms.common.api.Api.Client) r0     // Catch:{ DeadObjectException -> 0x004b }
            java.lang.String r1 = "Appropriate Api was not requested."
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r0, r1)     // Catch:{ DeadObjectException -> 0x004b }
            boolean r1 = r0.isConnected()     // Catch:{ DeadObjectException -> 0x004b }
            if (r1 != 0) goto L_0x003d
            com.google.android.gms.common.api.internal.zzbd r1 = r3.zzhf     // Catch:{ DeadObjectException -> 0x004b }
            java.util.Map<com.google.android.gms.common.api.Api$AnyClientKey<?>, com.google.android.gms.common.ConnectionResult> r1 = r1.zzjb     // Catch:{ DeadObjectException -> 0x004b }
            com.google.android.gms.common.api.Api$AnyClientKey r2 = r4.getClientKey()     // Catch:{ DeadObjectException -> 0x004b }
            boolean r1 = r1.containsKey(r2)     // Catch:{ DeadObjectException -> 0x004b }
            if (r1 == 0) goto L_0x003d
            com.google.android.gms.common.api.Status r0 = new com.google.android.gms.common.api.Status     // Catch:{ DeadObjectException -> 0x004b }
            r1 = 17
            r0.<init>(r1)     // Catch:{ DeadObjectException -> 0x004b }
            r4.setFailedResult(r0)     // Catch:{ DeadObjectException -> 0x004b }
            goto L_0x0055
        L_0x003d:
            boolean r1 = r0 instanceof com.google.android.gms.common.internal.SimpleClientAdapter     // Catch:{ DeadObjectException -> 0x004b }
            if (r1 == 0) goto L_0x0047
            com.google.android.gms.common.internal.SimpleClientAdapter r0 = (com.google.android.gms.common.internal.SimpleClientAdapter) r0     // Catch:{ DeadObjectException -> 0x004b }
            com.google.android.gms.common.api.Api$SimpleClient r0 = r0.getClient()     // Catch:{ DeadObjectException -> 0x004b }
        L_0x0047:
            r4.run(r0)     // Catch:{ DeadObjectException -> 0x004b }
            goto L_0x0055
        L_0x004b:
            com.google.android.gms.common.api.internal.zzbd r0 = r3.zzhf
            com.google.android.gms.common.api.internal.zzah r1 = new com.google.android.gms.common.api.internal.zzah
            r1.<init>(r3, r3)
            r0.zza(r1)
        L_0x0055:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.zzag.execute(com.google.android.gms.common.api.internal.BaseImplementation$ApiMethodImpl):com.google.android.gms.common.api.internal.BaseImplementation$ApiMethodImpl");
    }

    public final void onConnected(Bundle bundle) {
    }

    public final void onConnectionSuspended(int i) {
        this.zzhf.zzf(null);
        this.zzhf.zzjf.zzb(i, this.zzhg);
    }

    public final void zza(ConnectionResult connectionResult, Api<?> api, boolean z) {
    }

    /* access modifiers changed from: package-private */
    public final void zzap() {
        if (this.zzhg) {
            this.zzhg = false;
            this.zzhf.zzfq.zzir.release();
            disconnect();
        }
    }
}
