package _m_j;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import com.xiaomi.smarthome.leonids.ParticleSystem;
import java.util.List;
import java.util.Random;

public class gkp {

    /* renamed from: O000000o  reason: collision with root package name */
    protected Bitmap f17945O000000o;
    public float O00000Oo;
    public float O00000o;
    public float O00000o0;
    public int O00000oO;
    public float O00000oo;
    public float O0000O0o;
    public float O0000OOo;
    public float O0000Oo;
    public float O0000Oo0;
    public float O0000OoO;
    protected long O0000Ooo;
    private float O0000o;
    private Matrix O0000o0;
    public float O0000o00;
    private Paint O0000o0O;
    private float O0000o0o;
    private long O0000oO;
    private float O0000oO0;
    private int O0000oOO;
    private int O0000oOo;
    private int O0000oo;
    private List<Object> O0000oo0;
    private ParticleSystem.ParticleSystemType O0000ooO;
    private Random O0000ooo;
    private long O00oOooO;

    protected gkp() {
        this.O00000o = 1.0f;
        this.O00000oO = 255;
        this.O00000oo = 0.0f;
        this.O0000O0o = 0.0f;
        this.O0000OOo = 0.0f;
        this.O0000Oo0 = 0.0f;
        this.O0000ooO = ParticleSystem.ParticleSystemType.Normal;
        this.O0000ooo = new Random();
        this.O0000o00 = 1.0f;
        this.O0000o0 = new Matrix();
        this.O0000o0O = new Paint();
    }

    public gkp(Bitmap bitmap) {
        this();
        this.f17945O000000o = bitmap;
    }

    public final void O000000o() {
        this.O00000o = 1.0f;
        this.O00000oO = 255;
    }

    public final void O000000o(long j, float f, float f2) {
        this.O0000oOO = this.f17945O000000o.getWidth() / 2;
        this.O0000oOo = this.f17945O000000o.getHeight() / 2;
        this.O0000o0o = f - ((float) this.O0000oOO);
        this.O0000o = f2 - ((float) this.O0000oOo);
        this.O00000Oo = this.O0000o0o;
        this.O00000o0 = this.O0000o;
        this.O0000oO = j;
    }

    public final void O000000o(long j, float f, float f2, int i, ParticleSystem.ParticleSystemType particleSystemType) {
        this.O0000oOO = this.f17945O000000o.getWidth() / 2;
        this.O0000oOo = this.f17945O000000o.getHeight() / 2;
        this.O0000o0o = f - ((float) this.O0000oOO);
        this.O0000o = f2 - ((float) this.O0000oOo);
        this.O00000Oo = this.O0000o0o;
        this.O00000o0 = this.O0000o;
        this.O0000oO = j;
        this.O0000oo = i;
        this.O0000ooO = particleSystemType;
        if (this.O0000ooO == ParticleSystem.ParticleSystemType.AirPurifier) {
            this.O00000oO = this.O0000ooo.nextInt(50) + 50;
        }
    }

    public boolean O000000o(long j) {
        long j2 = j - this.O0000Ooo;
        if (j2 > this.O0000oO) {
            return false;
        }
        if (this.O0000ooO == ParticleSystem.ParticleSystemType.Sweeper) {
            float f = (float) j2;
            float f2 = (this.O0000OOo * f) + (this.O0000Oo * f * f);
            double d = (double) this.O0000oo;
            Double.isNaN(d);
            float f3 = (float) ((d * 3.141592653589793d) / 180.0d);
            double d2 = (double) this.O0000o0o;
            double d3 = (double) f2;
            double d4 = (double) f3;
            double sin = Math.sin(d4);
            Double.isNaN(d3);
            Double.isNaN(d2);
            this.O00000Oo = (float) (d2 - (sin * d3));
            double d5 = (double) this.O0000o;
            double cos = Math.cos(d4);
            Double.isNaN(d3);
            Double.isNaN(d5);
            this.O00000o0 = (float) (d5 + (d3 * cos));
        } else if (this.O0000ooO == ParticleSystem.ParticleSystemType.AirPurifier) {
            float f4 = this.O00000Oo;
            float f5 = this.O0000OOo;
            float f6 = this.O0000o00;
            long j3 = this.O00oOooO;
            float f7 = (float) j2;
            this.O00000Oo = f4 + (f5 * f6 * ((float) (j - j3))) + (this.O0000Oo * f7 * f7);
            this.O00000o0 += (this.O0000Oo0 * f6 * ((float) (j - j3))) + (this.O0000OoO * f7 * f7);
        } else {
            float f8 = (float) j2;
            this.O00000Oo = this.O0000o0o + (this.O0000OOo * f8) + (this.O0000Oo * f8 * f8);
            this.O00000o0 = this.O0000o + (this.O0000Oo0 * f8) + (this.O0000OoO * f8 * f8);
        }
        this.O0000oO0 = this.O00000oo + ((this.O0000O0o * ((float) j2)) / 1000.0f);
        for (int i = 0; i < this.O0000oo0.size(); i++) {
            this.O0000oo0.get(i);
        }
        this.O00oOooO = j;
        return true;
    }

    public final void O000000o(Canvas canvas) {
        this.O0000o0.reset();
        this.O0000o0.postRotate(this.O0000oO0, (float) this.O0000oOO, (float) this.O0000oOo);
        Matrix matrix = this.O0000o0;
        float f = this.O00000o;
        matrix.postScale(f, f, (float) this.O0000oOO, (float) this.O0000oOo);
        this.O0000o0.postTranslate(this.O00000Oo, this.O00000o0);
        this.O0000o0O.setAlpha(this.O00000oO);
        canvas.drawBitmap(this.f17945O000000o, this.O0000o0, this.O0000o0O);
    }

    public final gkp O000000o(long j, List<Object> list) {
        this.O0000Ooo = j;
        this.O0000oo0 = list;
        this.O00oOooO = j;
        return this;
    }

    public final Bitmap O00000Oo() {
        return this.f17945O000000o;
    }

    public final void O000000o(Bitmap bitmap) {
        this.f17945O000000o = bitmap;
    }
}
