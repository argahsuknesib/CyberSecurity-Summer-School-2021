package in.cashify.otex.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.xiaomi.smarthome.R;
import java.util.ArrayList;
import java.util.Iterator;

public class CalibrationView extends View {

    /* renamed from: O000000o  reason: collision with root package name */
    public Bitmap f12270O000000o;
    public Bitmap O00000Oo;
    public Bitmap O00000o;
    public Bitmap O00000o0;
    public final ArrayList<O00000o0> O00000oO = new ArrayList<>();
    public final ArrayList<O00000o> O00000oo = new ArrayList<>();
    public O00000Oo O0000O0o;
    public O0000O0o O0000OOo;
    public int O0000Oo;
    public boolean O0000Oo0;
    public int O0000OoO;
    public float O0000Ooo = -1.0f;
    public Matrix O0000o;
    public boolean O0000o0;
    public float O0000o00 = -1.0f;
    public Matrix O0000o0O;
    public Matrix O0000o0o;
    public O00000o0 O0000oO;
    public Matrix O0000oO0;
    public int O0000oOO = 20;
    public int O0000oOo = 20;
    public int O0000oo = 20;
    public int O0000oo0 = 20;
    public boolean O0000ooO = true;

    public static /* synthetic */ class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public static final /* synthetic */ int[] f12271O000000o = new int[b.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(10:0|1|2|3|4|5|6|7|8|10) */
        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        static {
            f12271O000000o[b.HORIZONTAL.ordinal()] = 1;
            f12271O000000o[b.VERTICAL.ordinal()] = 2;
            f12271O000000o[b.DIAGONAL_LEFT_TOP.ordinal()] = 3;
            try {
                f12271O000000o[b.DIAGONAL_RIGHT_TOP.ordinal()] = 4;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public interface O00000Oo {
        void b();

        void c();
    }

    public class O00000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public final float f12272O000000o;
        public final float O00000Oo;

        public O00000o(float f, float f2) {
            this.f12272O000000o = f;
            this.O00000Oo = f2;
        }
    }

    public class O00000o0 {

        /* renamed from: O000000o  reason: collision with root package name */
        public final b f12273O000000o;
        public final RectF O00000Oo;
        public final float O00000o;
        public final RectF O00000o0;
        public final float O00000oO;
        public boolean O00000oo;

        public O00000o0(float f, float f2, float f3, float f4, b bVar) {
            this.O00000o = (f3 / 2.0f) + f;
            this.O00000oO = (f4 / 2.0f) + f2;
            float f5 = f3 + f;
            float f6 = f4 + f2;
            this.O00000Oo = new RectF(f, f2, f5, f6);
            this.O00000o0 = new RectF(f - 7.0f, f2 - 7.0f, f5 + 14.0f, f6 + 14.0f);
            this.f12273O000000o = bVar;
        }
    }

    public interface O0000O0o {
        void a(boolean z);
    }

    public enum b {
        HORIZONTAL,
        VERTICAL,
        CENTER_CELL,
        DIAGONAL_LEFT_TOP,
        DIAGONAL_RIGHT_TOP
    }

    public CalibrationView(Context context) {
        super(context);
        O000000o(context);
    }

    public CalibrationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        O000000o(context);
    }

    public CalibrationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        O000000o(context);
    }

    private void O000000o(float f, float f2) {
        this.O00000oo.add(new O00000o(f, f2));
    }

    private void O000000o(int i) {
        float f = this.O0000Ooo;
        float f2 = this.O0000o00;
        float f3 = (((float) this.O0000OoO) - f2) - ((float) this.O0000oo);
        float f4 = f;
        int i2 = i;
        for (int i3 = 0; i3 < i2; i3++) {
            this.O00000oO.add(new O00000o0(f4, f2, (float) this.O0000oo0, (float) this.O0000oo, b.HORIZONTAL));
            this.O00000oO.add(new O00000o0(f4, f3, (float) this.O0000oo0, (float) this.O0000oo, b.HORIZONTAL));
            f4 += (float) this.O0000oo0;
        }
    }

    private void O000000o(Context context) {
        this.f12270O000000o = BitmapFactory.decodeResource(getResources(), R.drawable.vertical_pattern);
        this.O00000Oo = BitmapFactory.decodeResource(getResources(), R.drawable.vertical_pattern_remove);
        this.O00000o0 = BitmapFactory.decodeResource(getResources(), R.drawable.horizontal_pattern);
        this.O00000o = BitmapFactory.decodeResource(getResources(), R.drawable.horizontal_pattern_remove);
        this.O0000oOO = this.f12270O000000o.getWidth();
        this.O0000oOo = this.f12270O000000o.getHeight();
        this.O0000oo0 = this.O00000o0.getWidth();
        this.O0000oo = this.O00000o0.getHeight();
        if (context instanceof O0000O0o) {
            this.O0000OOo = (O0000O0o) context;
        }
    }

    private void O000000o(boolean z) {
        O0000O0o o0000O0o = this.O0000OOo;
        if (o0000O0o != null) {
            o0000O0o.a(z);
        }
    }

    private void O00000Oo(int i) {
        float f = this.O0000Ooo;
        int i2 = (int) f;
        int i3 = (int) ((((float) this.O0000Oo) - f) - ((float) this.O0000oOO));
        int i4 = (int) this.O0000o00;
        int i5 = i;
        for (int i6 = 0; i6 < i5; i6++) {
            float f2 = (float) i4;
            this.O00000oO.add(new O00000o0((float) i2, f2, (float) this.O0000oOO, (float) this.O0000oOo, b.VERTICAL));
            this.O00000oO.add(new O00000o0((float) i3, f2, (float) this.O0000oOO, (float) this.O0000oOo, b.VERTICAL));
            i4 += this.O0000oOo;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000a, code lost:
        if (r0 == 2) goto L_0x002a;
     */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 1) {
                this.O0000Oo0 = true;
                invalidate();
                O000000o(true);
            }
            return true;
        }
        O000000o(false);
        if (!this.O0000o0) {
            O00000Oo o00000Oo = this.O0000O0o;
            if (o00000Oo != null) {
                o00000Oo.b();
            }
            this.O0000o0 = true;
            return true;
        }
        this.O0000Oo0 = false;
        O000000o(motionEvent.getX(), motionEvent.getY());
        invalidate();
        return true;
    }

    public void setOnCalibrationDoneListener(O00000Oo o00000Oo) {
        this.O0000O0o = o00000Oo;
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        int i5 = i3 - i;
        int i6 = i4 - i2;
        if (this.O0000ooO) {
            this.O0000Oo = i5;
            this.O0000OoO = i6;
            float f = this.O0000Ooo + ((float) this.O0000oOO);
            float f2 = this.O0000o00 + ((float) this.O0000oo);
            this.O0000oO = new O00000o0(f, f2, (((float) this.O0000Oo) - f) - f, (((float) this.O0000OoO) - f2) - f2, b.CENTER_CELL);
            double d = (double) (this.O0000oO.O00000Oo.left + ((float) (this.O0000oOO / 2)));
            double d2 = (double) this.O0000oO.O00000Oo.top;
            double d3 = (double) (this.O0000oO.O00000Oo.right - ((float) (this.O0000oOO / 2)));
            double d4 = (double) this.O0000oO.O00000Oo.top;
            double d5 = (double) (this.O0000oO.O00000Oo.right - ((float) (this.O0000oOO / 2)));
            double d6 = (double) this.O0000oO.O00000Oo.bottom;
            Double.isNaN(d2);
            Double.isNaN(d6);
            Double.isNaN(d);
            Double.isNaN(d5);
            double atan2 = Math.atan2(d2 - d6, d - d5);
            Double.isNaN(d4);
            Double.isNaN(d6);
            Double.isNaN(d3);
            Double.isNaN(d5);
            float degrees = (float) Math.toDegrees(atan2 - Math.atan2(d4 - d6, d3 - d5));
            this.O0000o0o = new Matrix();
            this.O0000o0O = new Matrix();
            this.O0000o0o.preRotate(degrees, this.O0000oO.O00000o, this.O0000oO.O00000oO);
            this.O0000o0o.invert(this.O0000o0O);
            this.O0000o = new Matrix();
            this.O0000oO0 = new Matrix();
            this.O0000o.preRotate(-degrees, this.O0000oO.O00000o, this.O0000oO.O00000oO);
            this.O0000o.invert(this.O0000oO0);
            O000000o((int) ((((float) this.O0000Oo) - (this.O0000Ooo * 2.0f)) / ((float) this.O0000oo0)));
            O00000Oo((int) ((((float) this.O0000OoO) - (this.O0000o00 * 2.0f)) / ((float) this.O0000oOo)));
            O000000o();
            this.O0000ooO = false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x00c5 A[LOOP:2: B:18:0x0089->B:30:0x00c5, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00c2 A[SYNTHETIC] */
    public void onDraw(Canvas canvas) {
        O00000Oo o00000Oo;
        Matrix matrix;
        Canvas canvas2 = canvas;
        super.onDraw(canvas);
        Iterator<O00000o0> it = this.O00000oO.iterator();
        while (it.hasNext()) {
            O00000o0 next = it.next();
            int i = O000000o.f12271O000000o[next.f12273O000000o.ordinal()];
            if (i == 1) {
                canvas2.drawBitmap(this.O00000o0, (Rect) null, next.O00000Oo, (Paint) null);
            } else if (i == 2) {
                canvas2.drawBitmap(this.f12270O000000o, (Rect) null, next.O00000Oo, (Paint) null);
            } else if (i == 3) {
                canvas.save();
                canvas2.setMatrix(this.O0000o0o);
                canvas2.drawBitmap(this.f12270O000000o, (Rect) null, next.O00000Oo, (Paint) null);
                canvas.restore();
            } else if (i == 4) {
                canvas.save();
                canvas2.setMatrix(this.O0000o);
                canvas2.drawBitmap(this.f12270O000000o, (Rect) null, next.O00000Oo, (Paint) null);
                canvas.restore();
            }
        }
        Iterator<O00000o0> it2 = this.O00000oO.iterator();
        char c = 0;
        boolean z = true;
        while (it2.hasNext()) {
            O00000o0 next2 = it2.next();
            if (!next2.O00000oo) {
                float[] fArr = new float[2];
                float[] fArr2 = new float[2];
                Iterator<O00000o> it3 = this.O00000oo.iterator();
                while (true) {
                    if (!it3.hasNext()) {
                        break;
                    }
                    O00000o next3 = it3.next();
                    float f = next3.f12272O000000o;
                    fArr2[c] = f;
                    fArr[c] = f;
                    float f2 = next3.O00000Oo;
                    fArr2[1] = f2;
                    fArr[1] = f2;
                    if (next2.f12273O000000o == b.DIAGONAL_LEFT_TOP) {
                        matrix = this.O0000o0O;
                    } else {
                        if (next2.f12273O000000o == b.DIAGONAL_RIGHT_TOP) {
                            matrix = this.O0000oO0;
                        }
                        if (!next2.O00000Oo.contains(fArr[c], fArr[1])) {
                            next2.O00000oo = true;
                            break;
                        }
                        c = 0;
                    }
                    matrix.mapPoints(fArr, fArr2);
                    if (!next2.O00000Oo.contains(fArr[c], fArr[1])) {
                    }
                }
            }
            if (next2.O00000oo) {
                int i2 = O000000o.f12271O000000o[next2.f12273O000000o.ordinal()];
                if (i2 == 1) {
                    canvas2.drawBitmap(this.O00000o, (Rect) null, next2.O00000o0, (Paint) null);
                } else if (i2 == 2) {
                    canvas2.drawBitmap(this.O00000Oo, (Rect) null, next2.O00000o0, (Paint) null);
                } else if (i2 == 3) {
                    canvas.save();
                    canvas2.setMatrix(this.O0000o0o);
                    canvas2.drawBitmap(this.O00000Oo, (Rect) null, next2.O00000o0, (Paint) null);
                    canvas.restore();
                } else if (i2 == 4) {
                    canvas.save();
                    canvas2.setMatrix(this.O0000o);
                    canvas2.drawBitmap(this.O00000Oo, (Rect) null, next2.O00000o0, (Paint) null);
                    canvas.restore();
                }
            }
            if (!z || next2.O00000oo) {
                c = 0;
            } else {
                c = 0;
                z = false;
            }
        }
        this.O00000oo.clear();
        if (z && (o00000Oo = this.O0000O0o) != null && this.O0000Oo0) {
            o00000Oo.c();
            this.O0000Oo0 = false;
        }
    }

    public int getCompletionPercent() {
        ArrayList<O00000o0> arrayList = this.O00000oO;
        int i = 0;
        if (arrayList == null || arrayList.isEmpty()) {
            return 0;
        }
        Iterator<O00000o0> it = this.O00000oO.iterator();
        while (it.hasNext()) {
            if (it.next().O00000oo) {
                i++;
            }
        }
        return (i * 100) / this.O00000oO.size();
    }

    private void O000000o() {
        float f = (float) this.O0000oOO;
        float f2 = (float) this.O0000oOo;
        int height = (int) (this.O0000oO.O00000Oo.height() / f2);
        float f3 = this.O0000oO.O00000o - (f / 2.0f);
        float height2 = (this.O0000oO.O00000Oo.top + ((this.O0000oO.O00000Oo.height() % f2) / 2.0f)) - f2;
        for (int i = 0; i < height + 1; i++) {
            float f4 = f3;
            float f5 = height2;
            float f6 = f;
            float f7 = f2;
            this.O00000oO.add(new O00000o0(f4, f5, f6, f7, b.DIAGONAL_LEFT_TOP));
            this.O00000oO.add(new O00000o0(f4, f5, f6, f7, b.DIAGONAL_RIGHT_TOP));
            height2 += f2;
        }
    }
}
