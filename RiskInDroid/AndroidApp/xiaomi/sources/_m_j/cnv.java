package _m_j;

import android.graphics.Bitmap;
import com.nostra13.universalimageloader.core.assist.LoadedFrom;

public final class cnv implements Runnable {

    /* renamed from: O000000o  reason: collision with root package name */
    private final Bitmap f14155O000000o;
    private final String O00000Oo;
    private final String O00000o;
    private final cok O00000o0;
    private final coi O00000oO;
    private final coo O00000oo;
    private final cny O0000O0o;
    private final LoadedFrom O0000OOo;

    public cnv(Bitmap bitmap, cnz cnz, cny cny, LoadedFrom loadedFrom) {
        this.f14155O000000o = bitmap;
        this.O00000Oo = cnz.f14161O000000o;
        this.O00000o0 = cnz.O00000o0;
        this.O00000o = cnz.O00000Oo;
        this.O00000oO = cnz.O00000oO.O0000o;
        this.O00000oo = cnz.O00000oo;
        this.O0000O0o = cny;
        this.O0000OOo = loadedFrom;
    }

    public final void run() {
        if (this.O00000o0.O00000oO()) {
            cou.O000000o("ImageAware was collected by GC. Task is cancelled. [%s]", this.O00000o);
            this.O00000oo.onLoadingCancelled(this.O00000Oo, this.O00000o0.O00000o());
            return;
        }
        if (!this.O00000o.equals(this.O0000O0o.O000000o(this.O00000o0))) {
            cou.O000000o("ImageAware is reused for another image. Task is cancelled. [%s]", this.O00000o);
            this.O00000oo.onLoadingCancelled(this.O00000Oo, this.O00000o0.O00000o());
            return;
        }
        cou.O000000o("Display image in ImageAware (loaded from %1$s) [%2$s]", this.O0000OOo, this.O00000o);
        this.O00000oO.O000000o(this.f14155O000000o, this.O00000o0);
        this.O0000O0o.O00000Oo(this.O00000o0);
        this.O00000oo.onLoadingComplete(this.O00000Oo, this.O00000o0.O00000o(), this.f14155O000000o);
    }
}
