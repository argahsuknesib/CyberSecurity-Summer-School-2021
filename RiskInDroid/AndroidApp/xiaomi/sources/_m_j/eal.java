package _m_j;

import android.content.Context;
import android.content.Intent;
import com.xiaomi.mipush.sdk.PushMessageHandler;

public final class eal implements Runnable {

    /* renamed from: O000000o  reason: collision with root package name */
    final /* synthetic */ Context f15124O000000o;
    final /* synthetic */ Intent O00000Oo;

    public eal(Context context, Intent intent) {
        this.f15124O000000o = context;
        this.O00000Oo = intent;
    }

    public final void run() {
        PushMessageHandler.O000000o(this.f15124O000000o, this.O00000Oo);
    }
}
