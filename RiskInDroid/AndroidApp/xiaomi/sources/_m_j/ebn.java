package _m_j;

import android.content.Context;
import android.content.Intent;

public final class ebn implements Runnable {

    /* renamed from: O000000o  reason: collision with root package name */
    final /* synthetic */ Context f15151O000000o;
    final /* synthetic */ Intent O00000Oo;

    public ebn(Context context, Intent intent) {
        this.f15151O000000o = context;
        this.O00000Oo = intent;
    }

    public final void run() {
        try {
            this.f15151O000000o.startService(this.O00000Oo);
        } catch (Exception e) {
            duv.O000000o(e.getMessage());
        }
    }
}
