package com.polidea.rxandroidble.internal.connection;

import _m_j.be;
import android.bluetooth.BluetoothGattCharacteristic;
import java.lang.invoke.LambdaForm;
import rx.Observable;
import rx.functions.Func0;

final /* synthetic */ class RxBleGattCallback$$Lambda$4 implements Func0 {
    private final BluetoothGattCharacteristic arg$1;
    private final byte[] arg$2;

    private RxBleGattCallback$$Lambda$4(BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr) {
        this.arg$1 = bluetoothGattCharacteristic;
        this.arg$2 = bArr;
    }

    private static Func0 get$Lambda(BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr) {
        return new RxBleGattCallback$$Lambda$4(bluetoothGattCharacteristic, bArr);
    }

    public static Func0 lambdaFactory$(BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr) {
        return new RxBleGattCallback$$Lambda$4(bluetoothGattCharacteristic, bArr);
    }

    @LambdaForm.Hidden
    public final Object call() {
        return Observable.just(be.O000000o(this.arg$1, this.arg$2));
    }
}
