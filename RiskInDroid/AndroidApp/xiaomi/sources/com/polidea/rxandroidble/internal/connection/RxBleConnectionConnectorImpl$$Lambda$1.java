package com.polidea.rxandroidble.internal.connection;

import _m_j.cre;
import _m_j.crh;
import _m_j.cri;
import _m_j.crj;
import _m_j.crk;
import _m_j.crl;
import _m_j.crn;
import _m_j.cro;
import _m_j.cry;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import com.polidea.rxandroidble.internal.util.BleConnectionCompat;
import java.lang.invoke.LambdaForm;
import java.util.concurrent.atomic.AtomicReference;
import rx.functions.Func0;
import rx.subjects.BehaviorSubject;

public final /* synthetic */ class RxBleConnectionConnectorImpl$$Lambda$1 implements Func0 {
    private final cre arg$1;
    private final Context arg$2;
    private final boolean arg$3;

    private RxBleConnectionConnectorImpl$$Lambda$1(cre cre, Context context, boolean z) {
        this.arg$1 = cre;
        this.arg$2 = context;
        this.arg$3 = z;
    }

    private static Func0 get$Lambda(cre cre, Context context, boolean z) {
        return new RxBleConnectionConnectorImpl$$Lambda$1(cre, context, z);
    }

    public static Func0 lambdaFactory$(cre cre, Context context, boolean z) {
        return new RxBleConnectionConnectorImpl$$Lambda$1(cre, context, z);
    }

    @LambdaForm.Hidden
    public final Object call() {
        cre cre = this.arg$1;
        Context context = this.arg$2;
        boolean z = this.arg$3;
        crn O000000o2 = cre.O00000Oo.O000000o();
        BluetoothDevice bluetoothDevice = cre.f14273O000000o;
        BleConnectionCompat bleConnectionCompat = cre.O00000o;
        AtomicReference atomicReference = new AtomicReference();
        cro cro = new cro(bluetoothDevice, O000000o2, bleConnectionCompat, z);
        cry cry = new cry(O000000o2, atomicReference, (BluetoothManager) context.getSystemService("bluetooth"));
        BehaviorSubject<BluetoothGatt> behaviorSubject = cro.O00000o0;
        atomicReference.getClass();
        behaviorSubject.subscribe(crk.O000000o(atomicReference), crl.O000000o());
        return cre.O00000o0.O000000o().flatMap(crh.O000000o(cre, O000000o2)).mergeWith(O000000o2.O00000o0).doOnUnsubscribe(cri.O000000o(cre, new crj.O000000o(cro, cry)));
    }
}
