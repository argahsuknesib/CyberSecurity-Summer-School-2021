package _m_j;

import android.content.Context;
import com.xiaomi.mipush.sdk.MessageHandleService;

public final class ebo implements Runnable {

    /* renamed from: O000000o  reason: collision with root package name */
    final /* synthetic */ Context f15152O000000o;

    public ebo(Context context) {
        this.f15152O000000o = context;
    }

    public final void run() {
        MessageHandleService.O00000Oo(this.f15152O000000o);
    }
}
