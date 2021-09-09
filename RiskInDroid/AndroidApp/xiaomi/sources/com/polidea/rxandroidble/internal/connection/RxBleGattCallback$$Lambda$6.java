package com.polidea.rxandroidble.internal.connection;

import _m_j.be;
import android.bluetooth.BluetoothGattDescriptor;
import java.lang.invoke.LambdaForm;
import rx.Observable;
import rx.functions.Func0;

final /* synthetic */ class RxBleGattCallback$$Lambda$6 implements Func0 {
    private final BluetoothGattDescriptor arg$1;
    private final byte[] arg$2;

    private RxBleGattCallback$$Lambda$6(BluetoothGattDescriptor bluetoothGattDescriptor, byte[] bArr) {
        this.arg$1 = bluetoothGattDescriptor;
        this.arg$2 = bArr;
    }

    private static Func0 get$Lambda(BluetoothGattDescriptor bluetoothGattDescriptor, byte[] bArr) {
        return new RxBleGattCallback$$Lambda$6(bluetoothGattDescriptor, bArr);
    }

    public static Func0 lambdaFactory$(BluetoothGattDescriptor bluetoothGattDescriptor, byte[] bArr) {
        return new RxBleGattCallback$$Lambda$6(bluetoothGattDescriptor, bArr);
    }

    @LambdaForm.Hidden
    public final Object call() {
        return Observable.just(be.O000000o(this.arg$1, this.arg$2));
    }
}
