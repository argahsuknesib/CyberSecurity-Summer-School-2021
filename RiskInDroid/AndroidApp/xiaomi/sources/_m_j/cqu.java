package _m_j;

import android.content.BroadcastReceiver;
import android.content.Context;
import java.lang.invoke.LambdaForm;
import rx.functions.Action0;

public final /* synthetic */ class cqu implements Action0 {

    /* renamed from: O000000o  reason: collision with root package name */
    private final Context f14260O000000o;
    private final BroadcastReceiver O00000Oo;

    private cqu(Context context, BroadcastReceiver broadcastReceiver) {
        this.f14260O000000o = context;
        this.O00000Oo = broadcastReceiver;
    }

    public static Action0 O000000o(Context context, BroadcastReceiver broadcastReceiver) {
        return new cqu(context, broadcastReceiver);
    }

    @LambdaForm.Hidden
    public final void call() {
        this.f14260O000000o.unregisterReceiver(this.O00000Oo);
    }
}
