package com.polidea.rxandroidble.internal;

import _m_j.cqx;
import _m_j.cqy;
import _m_j.cqz;
import _m_j.cra;
import android.content.Context;
import com.polidea.rxandroidble.exceptions.BleAlreadyConnectedException;
import java.lang.invoke.LambdaForm;
import rx.Observable;
import rx.functions.Func0;

final /* synthetic */ class RxBleDeviceImpl$$Lambda$1 implements Func0 {
    private final cqx arg$1;
    private final Context arg$2;
    private final boolean arg$3;

    private RxBleDeviceImpl$$Lambda$1(cqx cqx, Context context, boolean z) {
        this.arg$1 = cqx;
        this.arg$2 = context;
        this.arg$3 = z;
    }

    private static Func0 get$Lambda(cqx cqx, Context context, boolean z) {
        return new RxBleDeviceImpl$$Lambda$1(cqx, context, z);
    }

    public static Func0 lambdaFactory$(cqx cqx, Context context, boolean z) {
        return new RxBleDeviceImpl$$Lambda$1(cqx, context, z);
    }

    @LambdaForm.Hidden
    public final Object call() {
        cqx cqx = this.arg$1;
        Context context = this.arg$2;
        boolean z = this.arg$3;
        if (cqx.O00000o.compareAndSet(false, true)) {
            return cqx.O00000Oo.O000000o(context, z).doOnSubscribe(cqy.O000000o(cqx)).doOnNext(cqz.O000000o(cqx)).doOnUnsubscribe(cra.O000000o(cqx));
        }
        return Observable.error(new BleAlreadyConnectedException(cqx.f14263O000000o.getAddress()));
    }
}
