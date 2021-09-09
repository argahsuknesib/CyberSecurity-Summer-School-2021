package _m_j;

import com.github.barteksc.pdfviewer.util.FitPolicy;
import com.shockwave.pdfium.util.Size;

public final class auj {

    /* renamed from: O000000o  reason: collision with root package name */
    public dbk f12623O000000o;
    public dbk O00000Oo;
    private final Size O00000o;
    private FitPolicy O00000o0;
    private final Size O00000oO;
    private final Size O00000oo;
    private float O0000O0o;
    private float O0000OOo;

    public auj(FitPolicy fitPolicy, Size size, Size size2, Size size3) {
        this.O00000o0 = fitPolicy;
        this.O00000o = size;
        this.O00000oO = size2;
        this.O00000oo = size3;
        int i = AnonymousClass1.f12624O000000o[this.O00000o0.ordinal()];
        if (i == 1) {
            this.O00000Oo = O00000Oo(this.O00000oO, (float) this.O00000oo.O00000Oo);
            this.O0000OOo = this.O00000Oo.O00000Oo / ((float) this.O00000oO.O00000Oo);
            Size size4 = this.O00000o;
            this.f12623O000000o = O00000Oo(size4, ((float) size4.O00000Oo) * this.O0000OOo);
        } else if (i != 2) {
            this.f12623O000000o = O000000o(this.O00000o, (float) this.O00000oo.f5609O000000o);
            this.O0000O0o = this.f12623O000000o.f14452O000000o / ((float) this.O00000o.f5609O000000o);
            Size size5 = this.O00000oO;
            this.O00000Oo = O000000o(size5, ((float) size5.f5609O000000o) * this.O0000O0o);
        } else {
            float f = O000000o(this.O00000o, (float) this.O00000oo.f5609O000000o, (float) this.O00000oo.O00000Oo).f14452O000000o / ((float) this.O00000o.f5609O000000o);
            Size size6 = this.O00000oO;
            this.O00000Oo = O000000o(size6, ((float) size6.f5609O000000o) * f, (float) this.O00000oo.O00000Oo);
            this.O0000OOo = this.O00000Oo.O00000Oo / ((float) this.O00000oO.O00000Oo);
            this.f12623O000000o = O000000o(this.O00000o, (float) this.O00000oo.f5609O000000o, ((float) this.O00000o.O00000Oo) * this.O0000OOo);
            this.O0000O0o = this.f12623O000000o.f14452O000000o / ((float) this.O00000o.f5609O000000o);
        }
    }

    /* renamed from: _m_j.auj$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: O000000o  reason: collision with root package name */
        static final /* synthetic */ int[] f12624O000000o = new int[FitPolicy.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        static {
            f12624O000000o[FitPolicy.HEIGHT.ordinal()] = 1;
            f12624O000000o[FitPolicy.BOTH.ordinal()] = 2;
        }
    }

    public final dbk O000000o(Size size) {
        if (size.f5609O000000o <= 0 || size.O00000Oo <= 0) {
            return new dbk(0.0f, 0.0f);
        }
        int i = AnonymousClass1.f12624O000000o[this.O00000o0.ordinal()];
        if (i == 1) {
            return O00000Oo(size, ((float) size.O00000Oo) * this.O0000OOo);
        }
        if (i != 2) {
            return O000000o(size, ((float) size.f5609O000000o) * this.O0000O0o);
        }
        return O000000o(size, ((float) size.f5609O000000o) * this.O0000O0o, ((float) size.O00000Oo) * this.O0000OOo);
    }

    private static dbk O000000o(Size size, float f) {
        return new dbk(f, (float) Math.floor((double) (f / (((float) size.f5609O000000o) / ((float) size.O00000Oo)))));
    }

    private static dbk O00000Oo(Size size, float f) {
        return new dbk((float) Math.floor((double) (f / (((float) size.O00000Oo) / ((float) size.f5609O000000o)))), f);
    }

    private static dbk O000000o(Size size, float f, float f2) {
        float f3 = ((float) size.f5609O000000o) / ((float) size.O00000Oo);
        float floor = (float) Math.floor((double) (f / f3));
        if (floor > f2) {
            f = (float) Math.floor((double) (f3 * f2));
            floor = f2;
        }
        return new dbk(f, floor);
    }
}
