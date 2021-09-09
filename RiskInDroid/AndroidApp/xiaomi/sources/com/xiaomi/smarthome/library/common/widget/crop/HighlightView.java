package com.xiaomi.smarthome.library.common.widget.crop;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.support.v4.app.NotificationCompat;
import android.view.View;
import com.xiaomi.smarthome.R;

public final class HighlightView {

    /* renamed from: O000000o  reason: collision with root package name */
    View f9308O000000o;
    boolean O00000Oo;
    int O00000o;
    boolean O00000o0;
    Rect O00000oO;
    RectF O00000oo;
    RectF O0000O0o;
    Matrix O0000OOo;
    float O0000Oo;
    boolean O0000Oo0 = false;
    boolean O0000OoO = false;
    final Paint O0000Ooo = new Paint();
    private Drawable O0000o;
    final Paint O0000o0 = new Paint();
    final Paint O0000o00 = new Paint();
    private ModifyMode O0000o0O = ModifyMode.None;
    private Drawable O0000o0o;
    private Drawable O0000oO;
    private Drawable O0000oO0;
    private Drawable O0000oOO;
    private Drawable O0000oOo;
    private Drawable O0000oo0;

    enum ModifyMode {
        None,
        Move,
        Grow
    }

    public HighlightView(View view) {
        this.f9308O000000o = view;
    }

    private void O00000o() {
        Resources resources = this.f9308O000000o.getResources();
        this.O0000o0o = resources.getDrawable(R.drawable.camera_crop_width);
        this.O0000o = resources.getDrawable(R.drawable.camera_crop_height);
        this.O0000oO0 = resources.getDrawable(R.drawable.indicator_autocrop);
        this.O0000oO = resources.getDrawable(R.drawable.crop_left);
        this.O0000oOO = resources.getDrawable(R.drawable.crop_right);
        this.O0000oOo = resources.getDrawable(R.drawable.crop_up);
        this.O0000oo0 = resources.getDrawable(R.drawable.crop_down);
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(Canvas canvas) {
        int i;
        Canvas canvas2 = canvas;
        int i2 = this.O00000oO.left + 1;
        int i3 = this.O00000oO.right + 1;
        int i4 = this.O00000oO.top + 4;
        int intrinsicWidth = this.O0000oO.getIntrinsicWidth() / 2;
        int intrinsicHeight = this.O0000oO.getIntrinsicHeight() / 2;
        int intrinsicWidth2 = this.O0000oOO.getIntrinsicWidth() / 2;
        int intrinsicHeight2 = this.O0000oOO.getIntrinsicHeight() / 2;
        int intrinsicWidth3 = this.O0000oOo.getIntrinsicWidth() / 2;
        int intrinsicHeight3 = this.O0000oOo.getIntrinsicHeight() / 2;
        int intrinsicWidth4 = this.O0000oo0.getIntrinsicWidth() / 2;
        int i5 = this.O00000oO.bottom + 3;
        int i6 = this.O00000oO.left + ((this.O00000oO.right - this.O00000oO.left) / 2);
        int intrinsicHeight4 = this.O0000oo0.getIntrinsicHeight() / 2;
        int i7 = this.O00000oO.top + ((this.O00000oO.bottom - this.O00000oO.top) / 2);
        if (this.O0000o0O != ModifyMode.Move) {
            if (this.O0000o0O != ModifyMode.Grow) {
                int i8 = intrinsicWidth4;
                this.O0000oO.setBounds(i2 - intrinsicWidth, i7 - intrinsicHeight, i2 + intrinsicWidth, intrinsicHeight + i7);
                this.O0000oO.draw(canvas2);
                this.O0000oOO.setBounds(i3 - intrinsicWidth2, i7 - intrinsicHeight2, i3 + intrinsicWidth2, i7 + intrinsicHeight2);
                this.O0000oOO.draw(canvas2);
                this.O0000oOo.setBounds(i6 - intrinsicWidth3, i4 - intrinsicHeight3, intrinsicWidth3 + i6, i4 + intrinsicHeight3);
                this.O0000oOo.draw(canvas2);
                this.O0000oo0.setBounds(i6 - i8, i5 - intrinsicHeight4, i6 + i8, i5 + intrinsicHeight4);
                this.O0000oo0.draw(canvas2);
            } else if (this.O0000OoO) {
                int intrinsicWidth5 = this.O0000oO0.getIntrinsicWidth();
                int intrinsicHeight5 = this.O0000oO0.getIntrinsicHeight();
                double cos = Math.cos(0.7853981633974483d);
                double width = (double) this.O00000oO.width();
                Double.isNaN(width);
                int round = (int) Math.round(cos * (width / 2.0d));
                int width2 = ((this.O00000oO.left + (this.O00000oO.width() / 2)) + round) - (intrinsicWidth5 / 2);
                int height = ((this.O00000oO.top + (this.O00000oO.height() / 2)) - round) - (intrinsicHeight5 / 2);
                Drawable drawable = this.O0000oO0;
                drawable.setBounds(width2, height, drawable.getIntrinsicWidth() + width2, this.O0000oO0.getIntrinsicHeight() + height);
                this.O0000oO0.draw(canvas2);
            } else {
                if ((this.O00000o & 2) != 0) {
                    i = intrinsicWidth4;
                    this.O0000oO.setBounds(i2 - intrinsicWidth, i7 - intrinsicHeight, i2 + intrinsicWidth, intrinsicHeight + i7);
                    this.O0000oO.draw(canvas2);
                } else {
                    i = intrinsicWidth4;
                }
                if ((this.O00000o & 4) != 0) {
                    this.O0000oOO.setBounds(i3 - intrinsicWidth2, i7 - intrinsicHeight2, i3 + intrinsicWidth2, i7 + intrinsicHeight2);
                    this.O0000oOO.draw(canvas2);
                }
                if ((this.O00000o & 8) != 0) {
                    this.O0000oOo.setBounds(i6 - intrinsicWidth3, i4 - intrinsicHeight3, intrinsicWidth3 + i6, i4 + intrinsicHeight3);
                    this.O0000oOo.draw(canvas2);
                }
                if ((this.O00000o & 16) != 0) {
                    this.O0000oo0.setBounds(i6 - i, i5 - intrinsicHeight4, i6 + i, i5 + intrinsicHeight4);
                    this.O0000oo0.draw(canvas2);
                }
            }
        }
    }

    public final void O000000o(ModifyMode modifyMode) {
        if (modifyMode != this.O0000o0O) {
            this.O0000o0O = modifyMode;
            this.f9308O000000o.invalidate();
        }
    }

    public final int O000000o(float f, float f2) {
        int i;
        Rect O00000Oo2 = O00000Oo();
        int i2 = 8;
        int i3 = 4;
        if (this.O0000OoO) {
            float centerX = f - ((float) O00000Oo2.centerX());
            float centerY = f2 - ((float) O00000Oo2.centerY());
            int sqrt = (int) Math.sqrt((double) ((centerX * centerX) + (centerY * centerY)));
            int width = this.O00000oO.width() / 2;
            if (((float) Math.abs(sqrt - width)) <= 20.0f) {
                return Math.abs(centerY) > Math.abs(centerX) ? centerY < 0.0f ? 8 : 16 : centerX < 0.0f ? 2 : 4;
            }
            if (sqrt < width) {
                return 32;
            }
        } else if (f >= ((float) O00000Oo2.left) - 20.0f && f <= ((float) O00000Oo2.right) + 20.0f && f2 >= ((float) O00000Oo2.top) - 20.0f && f2 <= ((float) O00000Oo2.bottom) + 20.0f) {
            if (f > ((float) O00000Oo2.left) + 20.0f && f < ((float) O00000Oo2.right) - 20.0f && f2 > ((float) O00000Oo2.top) + 20.0f && f2 < ((float) O00000Oo2.bottom) - 20.0f) {
                return 32;
            }
            boolean z = f2 >= ((float) O00000Oo2.top) - 20.0f && f2 < ((float) O00000Oo2.bottom) + 20.0f;
            boolean z2 = f >= ((float) O00000Oo2.left) - 20.0f && f < ((float) O00000Oo2.right) + 20.0f;
            if (z) {
                boolean z3 = Math.abs(f - ((float) O00000Oo2.left)) <= 20.0f;
                boolean z4 = Math.abs(f - ((float) O00000Oo2.right)) <= 20.0f;
                if (z3 && z4) {
                    z3 = Math.abs(f - ((float) O00000Oo2.left)) < Math.abs(f - ((float) O00000Oo2.right));
                    z4 = !z3;
                }
                int i4 = z3 ? 67 : 1;
                if (z4) {
                    i4 = i4 | 4 | NotificationCompat.FLAG_HIGH_PRIORITY;
                }
                if (f2 > ((float) ((O00000Oo2.top + O00000Oo2.bottom) / 2))) {
                    i2 = 16;
                }
                i = i4 | i2;
            } else {
                i = 1;
            }
            if (!z2) {
                return i;
            }
            boolean z5 = Math.abs(f2 - ((float) O00000Oo2.top)) <= 20.0f;
            boolean z6 = Math.abs(f2 - ((float) O00000Oo2.bottom)) <= 20.0f;
            if (z5 && z6) {
                z5 = Math.abs(f2 - ((float) O00000Oo2.top)) < Math.abs(f2 - ((float) O00000Oo2.bottom));
                z6 = !z5;
            }
            if (z5) {
                i = i | 8 | 256;
            }
            if (z6) {
                i = i | 16 | 512;
            }
            if (f <= ((float) ((O00000Oo2.left + O00000Oo2.right) / 2))) {
                i3 = 2;
            }
            return i | i3;
        }
        return 1;
    }

    public final Rect O000000o() {
        return new Rect((int) this.O0000O0o.left, (int) this.O0000O0o.top, (int) this.O0000O0o.right, (int) this.O0000O0o.bottom);
    }

    /* access modifiers changed from: package-private */
    public final Rect O00000Oo() {
        RectF rectF = new RectF(this.O0000O0o.left, this.O0000O0o.top, this.O0000O0o.right, this.O0000O0o.bottom);
        this.O0000OOo.mapRect(rectF);
        return new Rect(Math.round(rectF.left), Math.round(rectF.top), Math.round(rectF.right), Math.round(rectF.bottom));
    }

    public final void O00000o0() {
        this.O00000oO = O00000Oo();
    }

    public final void O000000o(Matrix matrix, Rect rect, RectF rectF, boolean z, boolean z2) {
        if (z) {
            z2 = true;
        }
        this.O0000OOo = new Matrix(matrix);
        this.O0000O0o = rectF;
        this.O00000oo = new RectF(rect);
        this.O0000Oo0 = z2;
        this.O0000OoO = z;
        this.O0000Oo = this.O0000O0o.width() / this.O0000O0o.height();
        this.O00000oO = O00000Oo();
        this.O0000Ooo.setARGB(125, 50, 50, 50);
        this.O0000o00.setARGB(125, 50, 50, 50);
        this.O0000o0.setStrokeWidth(3.0f);
        this.O0000o0.setStyle(Paint.Style.STROKE);
        this.O0000o0.setAntiAlias(true);
        this.O0000o0O = ModifyMode.None;
        O00000o();
    }
}
