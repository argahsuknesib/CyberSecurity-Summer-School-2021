package _m_j;

import android.bluetooth.BluetoothGatt;
import java.lang.invoke.LambdaForm;
import java.util.concurrent.atomic.AtomicReference;
import rx.functions.Action1;

public final /* synthetic */ class crk implements Action1 {

    /* renamed from: O000000o  reason: collision with root package name */
    private final AtomicReference f14279O000000o;

    private crk(AtomicReference atomicReference) {
        this.f14279O000000o = atomicReference;
    }

    public static Action1 O000000o(AtomicReference atomicReference) {
        return new crk(atomicReference);
    }

    @LambdaForm.Hidden
    public final void call(Object obj) {
        this.f14279O000000o.set((BluetoothGatt) obj);
    }
}
