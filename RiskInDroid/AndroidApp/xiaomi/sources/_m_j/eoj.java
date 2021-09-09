package _m_j;

import android.util.Log;
import android.util.Pair;
import java.util.Date;
import java.util.List;

final class eoj implements Runnable {

    /* renamed from: O000000o  reason: collision with root package name */
    final /* synthetic */ String f15676O000000o;
    final /* synthetic */ Throwable O00000Oo;
    final /* synthetic */ eoi O00000o0;

    eoj(eoi eoi, String str, Throwable th) {
        this.O00000o0 = eoi;
        this.f15676O000000o = str;
        this.O00000Oo = th;
    }

    public final void run() {
        eoi.O00000oo.add(new Pair(String.format("%1$s %2$s %3$s ", eoi.O00000Oo.format(new Date()), this.O00000o0.O00000o0, this.f15676O000000o), this.O00000Oo));
        if (eoi.O00000oo.size() > 20000) {
            int size = (eoi.O00000oo.size() - 20000) + 50;
            for (int i = 0; i < size; i++) {
                try {
                    if (eoi.O00000oo.size() > 0) {
                        eoi.O00000oo.remove(0);
                    }
                } catch (IndexOutOfBoundsException unused) {
                }
            }
            List O00000Oo2 = eoi.O00000oo;
            O00000Oo2.add(new Pair(String.format("%1$s %2$s %3$s ", eoi.O00000Oo.format(new Date()), this.O00000o0.O00000o0, "flush " + size + " lines logs."), null));
        }
        try {
            if (!elg.O00000o0()) {
                gsy.O000000o(5, this.O00000o0.O00000o0, "SDCard is unavailable.");
            } else {
                eoi.O00000Oo(this.O00000o0);
            }
        } catch (Exception e) {
            Log.e(this.O00000o0.O00000o0, "", e);
        }
    }
}
