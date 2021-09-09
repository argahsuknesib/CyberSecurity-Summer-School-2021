package _m_j;

import android.content.Context;
import com.polidea.rxandroidble.RxBleAdapterStateObservable;
import java.lang.invoke.LambdaForm;
import rx.Observable;
import rx.Subscriber;

public final /* synthetic */ class cqt implements Observable.OnSubscribe {

    /* renamed from: O000000o  reason: collision with root package name */
    private final Context f14259O000000o;

    private cqt(Context context) {
        this.f14259O000000o = context;
    }

    public static Observable.OnSubscribe O000000o(Context context) {
        return new cqt(context);
    }

    @LambdaForm.Hidden
    public final void call(Object obj) {
        RxBleAdapterStateObservable.O000000o(this.f14259O000000o, (Subscriber) obj);
    }
}
