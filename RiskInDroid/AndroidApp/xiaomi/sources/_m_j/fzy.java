package _m_j;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import java.io.File;
import java.util.List;

public final class fzy {
    public static int O00000oO = 5;

    /* renamed from: O000000o  reason: collision with root package name */
    public boolean f17451O000000o = true;
    public String O00000Oo;
    public gaa O00000o;
    public List<md> O00000o0;
    public Bitmap O00000oo;
    public gab O0000O0o;
    public int O0000OOo = 10;
    private int O0000Oo = 27398;
    private String O0000Oo0;
    private int O0000OoO = 20500;
    private int O0000Ooo = 2047;
    private Paint O0000o;
    private Bitmap O0000o0;
    private float O0000o00 = 0.03f;
    private Canvas O0000o0O;
    private int O0000o0o;
    private int O0000oO;
    private Path O0000oO0;
    private float O0000oOO;
    private int O0000oOo;

    public static String O000000o(int i) {
        switch (i) {
            case 10001:
                return "points data is empty";
            case 10002:
                return "file already exists";
            case 10003:
                return "file creation failed";
            case 10004:
                return "file save failed";
            case 10005:
                return "file path is empty";
            default:
                return "unknown error";
        }
    }

    public fzy(List<md> list, String str, fzo fzo) {
        this.O00000o0 = list;
        this.O00000Oo = str + File.separator;
        this.O0000Oo0 = str + File.separator + "temp" + File.separator;
        this.O0000oO = fzo.f17447O000000o;
        this.O0000oOO = fzo.O00000o0;
        this.O0000oOo = fzo.O00000Oo;
        this.O0000Oo = fzo.O00000oO;
        this.O0000OoO = fzo.O00000oo;
        this.O0000Ooo = fzo.O0000O0o;
        this.O0000o00 = fzo.O00000o * gaf.O000000o();
        this.O0000o0o = fzo.O0000OOo;
        this.O0000OOo = fzo.O0000Oo0;
        this.O0000o = new Paint();
        this.O0000oO0 = new Path();
        this.O0000O0o = new gab();
        this.O0000o.setStrokeWidth(this.O0000oOO);
        this.O0000o.setColor(this.O0000oOo);
        this.O0000o.setStyle(Paint.Style.STROKE);
        this.O0000o.setAntiAlias(true);
        this.O0000o.setStrokeCap(Paint.Cap.ROUND);
    }

    public fzy(String str) {
        this.O00000Oo = str + File.separator;
        this.O0000Oo0 = str + File.separator + "temp" + File.separator;
    }

    public final void O000000o() {
        float f = this.O0000o00;
        this.O0000o0 = Bitmap.createBitmap((int) (((float) this.O0000Oo) * f), (int) (f * ((float) this.O0000OoO)), Bitmap.Config.ARGB_4444);
        this.O00000oo = gac.O000000o(this.O0000oO, this.O0000o0);
        this.O0000o0O = new Canvas(this.O00000oo);
    }

    public final void O000000o(List<md> list) {
        int i;
        Path path;
        Path path2;
        List<md> list2 = list;
        if (list2 == null || list.size() <= 0) {
            gaa gaa = this.O00000o;
            if (gaa != null) {
                gaa.O000000o(10001);
                return;
            }
            return;
        }
        char c = 0;
        int i2 = 0;
        int i3 = 0;
        while (i2 < list.size() - 1) {
            md mdVar = list2.get(i2);
            i2++;
            md mdVar2 = list2.get(i2);
            if (!(mdVar == null || mdVar2 == null)) {
                if (mdVar.O00000o <= 0 && mdVar2.O00000o > 0 && (path2 = this.O0000oO0) != null) {
                    path2.moveTo(mdVar.f2180O000000o * this.O0000o00, mdVar.O00000Oo * this.O0000o00);
                }
                if (mdVar.O00000o > 0 && mdVar2.O00000o > 0) {
                    if (this.O0000o != null) {
                        this.O0000o.setStrokeWidth(this.O0000oOO * (mdVar.O00000o0 / ((float) this.O0000Ooo)));
                        this.O0000o.setColor(this.O0000oOo);
                    }
                    Path path3 = this.O0000oO0;
                    if (path3 != null) {
                        path3.quadTo(mdVar.f2180O000000o * this.O0000o00, mdVar.O00000Oo * this.O0000o00, mdVar2.f2180O000000o * this.O0000o00, mdVar2.O00000Oo * this.O0000o00);
                    }
                    float[] fArr = new float[4];
                    fArr[c] = mdVar.f2180O000000o * this.O0000o00;
                    fArr[1] = mdVar.O00000Oo * this.O0000o00;
                    fArr[2] = mdVar2.f2180O000000o * this.O0000o00;
                    fArr[3] = mdVar2.O00000Oo * this.O0000o00;
                    Canvas canvas = this.O0000o0O;
                    Paint paint = this.O0000o;
                    float f = fArr[2] - fArr[c];
                    float f2 = fArr[3] - fArr[1];
                    int max = (int) (Math.max(Math.abs(f), Math.abs(f2)) + 2.0f);
                    float f3 = (float) max;
                    float f4 = f / f3;
                    float f5 = f2 / f3;
                    int i4 = 0;
                    while (i4 < max) {
                        float f6 = fArr[c];
                        float f7 = (float) i4;
                        float f8 = f6 + (f7 * f4);
                        float f9 = fArr[1] + (f7 * f5);
                        if (!(canvas == null || paint == null)) {
                            canvas.drawPoint(f8, f9, paint);
                        }
                        i4++;
                        c = 0;
                    }
                    if (!this.f17451O000000o) {
                        i = i3 + 1;
                        if (i >= this.O0000o0o) {
                            this.O0000O0o.O000000o(this.O00000oo.copy(Bitmap.Config.ARGB_4444, true));
                            i = 0;
                        }
                        if (mdVar.O00000o <= 0 && mdVar2.O00000o <= 0 && (path = this.O0000oO0) != null) {
                            path.reset();
                        }
                        i3 = i;
                    }
                }
                i = i3;
                path.reset();
                i3 = i;
            }
            c = 0;
        }
        if (!this.f17451O000000o && i3 > 0) {
            this.O0000O0o.O000000o(this.O00000oo.copy(Bitmap.Config.ARGB_4444, true));
        }
    }
}
