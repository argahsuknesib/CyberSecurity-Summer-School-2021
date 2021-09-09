package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl;

public final class zzd<A extends BaseImplementation.ApiMethodImpl<? extends Result, Api.AnyClient>> extends zzb {
    private final A zzdv;

    public zzd(int i, A a2) {
        super(i);
        this.zzdv = a2;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: MethodInvokeVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not class type: A
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
    public final void zza(com.google.android.gms.common.api.Status r2) {
        /*
            r1 = this;
            A r0 = r1.zzdv
            r0.setFailedResult(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.zzd.zza(com.google.android.gms.common.api.Status):void");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: MethodInvokeVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not class type: A
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
    public final void zza(com.google.android.gms.common.api.internal.GoogleApiManager.zza<?> r2) throws android.os.DeadObjectException {
        /*
            r1 = this;
            A r0 = r1.zzdv     // Catch:{ RuntimeException -> 0x000a }
            com.google.android.gms.common.api.Api$Client r2 = r2.zzae()     // Catch:{ RuntimeException -> 0x000a }
            r0.run(r2)     // Catch:{ RuntimeException -> 0x000a }
            return
        L_0x000a:
            r2 = move-exception
            r1.zza(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.zzd.zza(com.google.android.gms.common.api.internal.GoogleApiManager$zza):void");
    }

    public final void zza(zzaa zzaa, boolean z) {
        zzaa.zza((BasePendingResult<? extends Result>) this.zzdv, z);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: MethodInvokeVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not class type: A
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
    public final void zza(java.lang.RuntimeException r5) {
        /*
            r4 = this;
            com.google.android.gms.common.api.Status r0 = new com.google.android.gms.common.api.Status
            java.lang.Class r1 = r5.getClass()
            java.lang.String r1 = r1.getSimpleName()
            java.lang.String r5 = r5.getLocalizedMessage()
            java.lang.String r2 = java.lang.String.valueOf(r1)
            int r2 = r2.length()
            int r2 = r2 + 2
            java.lang.String r3 = java.lang.String.valueOf(r5)
            int r3 = r3.length()
            int r2 = r2 + r3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r2)
            r3.append(r1)
            java.lang.String r1 = ": "
            r3.append(r1)
            r3.append(r5)
            java.lang.String r5 = r3.toString()
            r1 = 10
            r0.<init>(r1, r5)
            A r5 = r4.zzdv
            r5.setFailedResult(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.zzd.zza(java.lang.RuntimeException):void");
    }
}
