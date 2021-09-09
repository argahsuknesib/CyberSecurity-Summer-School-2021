package com.polidea.rxandroidble.internal.cache;

import java.lang.invoke.LambdaForm;
import java.util.HashSet;
import rx.functions.Func0;

final /* synthetic */ class RxBleDeviceCache$$Lambda$4 implements Func0 {
    private static final RxBleDeviceCache$$Lambda$4 instance = new RxBleDeviceCache$$Lambda$4();

    private RxBleDeviceCache$$Lambda$4() {
    }

    public static Func0 lambdaFactory$() {
        return instance;
    }

    @LambdaForm.Hidden
    public final Object call() {
        return new HashSet();
    }
}
