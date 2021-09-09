package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

public final class zzck {
    public static final Status zzmm = new Status(8, "The connection to Google Play services was lost");
    private static final BasePendingResult<?>[] zzmn = new BasePendingResult[0];
    private final Map<Api.AnyClientKey<?>, Api.Client> zzil;
    @VisibleForTesting
    final Set<BasePendingResult<?>> zzmo = Collections.synchronizedSet(Collections.newSetFromMap(new WeakHashMap()));
    private final zzcn zzmp = new zzcl(this);

    public zzck(Map<Api.AnyClientKey<?>, Api.Client> map) {
        this.zzil = map;
    }

    /* JADX WARN: Type inference failed for: r5v0, types: [com.google.android.gms.common.api.ResultCallback, com.google.android.gms.common.api.internal.zzcn, com.google.android.gms.common.api.zzc, com.google.android.gms.common.api.internal.zzcl] */
    /*  JADX ERROR: JadxRuntimeException in pass: MethodInvokeVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not class type: ?
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
    public final void release() {
        /*
            r8 = this;
            java.util.Set<com.google.android.gms.common.api.internal.BasePendingResult<?>> r0 = r8.zzmo
            com.google.android.gms.common.api.internal.BasePendingResult<?>[] r1 = com.google.android.gms.common.api.internal.zzck.zzmn
            java.lang.Object[] r0 = r0.toArray(r1)
            com.google.android.gms.common.api.internal.BasePendingResult[] r0 = (com.google.android.gms.common.api.internal.BasePendingResult[]) r0
            int r1 = r0.length
            r2 = 0
            r3 = 0
        L_0x000d:
            if (r3 >= r1) goto L_0x0075
            r4 = r0[r3]
            r5 = 0
            r4.zza(r5)
            java.lang.Integer r6 = r4.zzo()
            if (r6 != 0) goto L_0x0027
            boolean r5 = r4.zzw()
            if (r5 == 0) goto L_0x0072
        L_0x0021:
            java.util.Set<com.google.android.gms.common.api.internal.BasePendingResult<?>> r5 = r8.zzmo
            r5.remove(r4)
            goto L_0x0072
        L_0x0027:
            r4.setResultCallback(r5)
            java.util.Map<com.google.android.gms.common.api.Api$AnyClientKey<?>, com.google.android.gms.common.api.Api$Client> r6 = r8.zzil
            r7 = r4
            com.google.android.gms.common.api.internal.BaseImplementation$ApiMethodImpl r7 = (com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl) r7
            com.google.android.gms.common.api.Api$AnyClientKey r7 = r7.getClientKey()
            java.lang.Object r6 = r6.get(r7)
            com.google.android.gms.common.api.Api$Client r6 = (com.google.android.gms.common.api.Api.Client) r6
            android.os.IBinder r6 = r6.getServiceBrokerBinder()
            boolean r7 = r4.isReady()
            if (r7 == 0) goto L_0x004c
            com.google.android.gms.common.api.internal.zzcm r7 = new com.google.android.gms.common.api.internal.zzcm
            r7.<init>(r4, r5, r6, r5)
            r4.zza(r7)
            goto L_0x0021
        L_0x004c:
            if (r6 == 0) goto L_0x0060
            boolean r7 = r6.isBinderAlive()
            if (r7 == 0) goto L_0x0060
            com.google.android.gms.common.api.internal.zzcm r7 = new com.google.android.gms.common.api.internal.zzcm
            r7.<init>(r4, r5, r6, r5)
            r4.zza(r7)
            r6.linkToDeath(r7, r2)     // Catch:{ RemoteException -> 0x0063 }
            goto L_0x0021
        L_0x0060:
            r4.zza(r5)
        L_0x0063:
            r4.cancel()
            java.lang.Integer r6 = r4.zzo()
            int r6 = r6.intValue()
            r5.remove(r6)
            goto L_0x0021
        L_0x0072:
            int r3 = r3 + 1
            goto L_0x000d
        L_0x0075:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.zzck.release():void");
    }

    /* access modifiers changed from: package-private */
    public final void zzb(BasePendingResult<? extends Result> basePendingResult) {
        this.zzmo.add(basePendingResult);
        basePendingResult.zza(this.zzmp);
    }

    public final void zzce() {
        for (BasePendingResult zzb : (BasePendingResult[]) this.zzmo.toArray(zzmn)) {
            zzb.zzb(zzmm);
        }
    }
}
