package com.miui.tsmclient.model;

import android.content.Context;
import android.os.Bundle;
import com.miui.tsmclient.common.mvp.IModel;
import com.miui.tsmclient.common.mvp.OnModelChangedListener;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BaseModel implements IModel {
    private Context mContext;
    private ExecutorService mExecutor = Executors.newCachedThreadPool();
    private OnModelChangedListener mListener;

    /* access modifiers changed from: protected */
    public void onInit() {
    }

    /* access modifiers changed from: protected */
    public void onRelease() {
    }

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
    public static <T extends com.miui.tsmclient.model.BaseModel> T create(android.content.Context r1, java.lang.Class<T> r2) {
        /*
            java.lang.Object r2 = r2.newInstance()     // Catch:{ Exception -> 0x000b }
            com.miui.tsmclient.model.BaseModel r2 = (com.miui.tsmclient.model.BaseModel) r2     // Catch:{ Exception -> 0x000b }
            r0 = 0
            r2.init(r1, r0)     // Catch:{ Exception -> 0x000b }
            return r2
        L_0x000b:
            r1 = move-exception
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.String r1 = r1.getMessage()
            r2.<init>(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.miui.tsmclient.model.BaseModel.create(android.content.Context, java.lang.Class):com.miui.tsmclient.model.BaseModel");
    }

    public void init(Context context, OnModelChangedListener onModelChangedListener) {
        this.mContext = context;
        this.mListener = onModelChangedListener;
        onInit();
    }

    public void release() {
        onRelease();
        this.mExecutor.shutdownNow();
    }

    public Context getContext() {
        return this.mContext;
    }

    /* access modifiers changed from: protected */
    public void runOnBackground(Runnable runnable) {
        this.mExecutor.submit(runnable);
    }

    /* access modifiers changed from: protected */
    public final void notifyChanged(int i) {
        notifyChanged(i, null);
    }

    /* access modifiers changed from: protected */
    public final void notifyChanged(int i, Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        OnModelChangedListener onModelChangedListener = this.mListener;
        if (onModelChangedListener != null) {
            onModelChangedListener.onModelChanged(i, bundle);
        }
    }
}
