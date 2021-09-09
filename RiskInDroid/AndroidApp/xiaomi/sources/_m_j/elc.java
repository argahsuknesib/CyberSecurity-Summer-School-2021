package _m_j;

import android.content.Context;
import java.io.File;

final class elc extends esx {

    /* renamed from: O000000o  reason: collision with root package name */
    final /* synthetic */ Runnable f15604O000000o;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    elc(Context context, File file, Runnable runnable) {
        super(context, file, (byte) 0);
        this.f15604O000000o = runnable;
    }

    /* access modifiers changed from: protected */
    public final void O000000o() {
        Runnable runnable = this.f15604O000000o;
        if (runnable != null) {
            runnable.run();
        }
    }
}
