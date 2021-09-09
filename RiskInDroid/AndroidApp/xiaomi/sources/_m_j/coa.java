package _m_j;

import android.graphics.Bitmap;
import android.os.Handler;
import com.nostra13.universalimageloader.core.LoadAndDisplayImageTask;
import com.nostra13.universalimageloader.core.assist.LoadedFrom;

final class coa implements Runnable {

    /* renamed from: O000000o  reason: collision with root package name */
    private final cny f14163O000000o;
    private final Bitmap O00000Oo;
    private final Handler O00000o;
    private final cnz O00000o0;

    public coa(cny cny, Bitmap bitmap, cnz cnz, Handler handler) {
        this.f14163O000000o = cny;
        this.O00000Oo = bitmap;
        this.O00000o0 = cnz;
        this.O00000o = handler;
    }

    public final void run() {
        cou.O000000o("PostProcess image before displaying [%s]", this.O00000o0.O00000Oo);
        LoadAndDisplayImageTask.O000000o(new cnv(this.O00000o0.O00000oO.O0000o0o.O000000o(), this.O00000o0, this.f14163O000000o, LoadedFrom.MEMORY_CACHE), this.O00000o0.O00000oO.O0000oO, this.O00000o, this.f14163O000000o);
    }
}
