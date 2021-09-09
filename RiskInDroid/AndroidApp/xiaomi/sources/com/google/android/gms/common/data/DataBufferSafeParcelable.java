package com.google.android.gms.common.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class DataBufferSafeParcelable<T extends SafeParcelable> extends AbstractDataBuffer<T> {
    private static final String[] zznk = {"data"};
    private final Parcelable.Creator<T> zznl;

    public DataBufferSafeParcelable(DataHolder dataHolder, Parcelable.Creator<T> creator) {
        super(dataHolder);
        this.zznl = creator;
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
    public static <T extends com.google.android.gms.common.internal.safeparcel.SafeParcelable> void addValue(com.google.android.gms.common.data.DataHolder.Builder r3, T r4) {
        /*
            android.os.Parcel r0 = android.os.Parcel.obtain()
            r1 = 0
            r4.writeToParcel(r0, r1)
            android.content.ContentValues r4 = new android.content.ContentValues
            r4.<init>()
            byte[] r1 = r0.marshall()
            java.lang.String r2 = "data"
            r4.put(r2, r1)
            r3.withRow(r4)
            r0.recycle()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.data.DataBufferSafeParcelable.addValue(com.google.android.gms.common.data.DataHolder$Builder, com.google.android.gms.common.internal.safeparcel.SafeParcelable):void");
    }

    public static DataHolder.Builder buildDataHolder() {
        return DataHolder.builder(zznk);
    }

    public T get(int i) {
        byte[] byteArray = this.mDataHolder.getByteArray("data", i, this.mDataHolder.getWindowIndex(i));
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(byteArray, 0, byteArray.length);
        obtain.setDataPosition(0);
        T t = (SafeParcelable) this.zznl.createFromParcel(obtain);
        obtain.recycle();
        return t;
    }
}
