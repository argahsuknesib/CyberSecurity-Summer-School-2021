package com.scwang.smartrefresh.header;

import _m_j.czw;
import _m_j.dao;
import _m_j.q;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.AttributeSet;
import com.scwang.smartrefresh.header.fungame.FunGameView;
import com.xiaomi.smarthome.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FunGameHitBlockHeader extends FunGameView {

    /* renamed from: O000000o  reason: collision with root package name */
    protected float f5526O000000o;
    protected float O00000Oo;
    protected Paint O00000o;
    protected float O00000o0;
    protected float O00000oO;
    protected float O00000oo;
    protected float O0000O0o;
    protected float O0000OOo;
    protected boolean O0000Oo;
    protected List<Point> O0000Oo0;
    protected int O0000OoO;
    protected int O0000Ooo;
    protected int O0000o00;

    public FunGameHitBlockHeader(Context context) {
        this(context, null);
    }

    public FunGameHitBlockHeader(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FunGameHitBlockHeader(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.fghBallSpeed, R.attr.fghBlockHorizontalNum});
        this.O0000o00 = obtainStyledAttributes.getInt(0, dao.O000000o(3.0f));
        this.O0000Ooo = obtainStyledAttributes.getInt(1, 3);
        obtainStyledAttributes.recycle();
        this.O00000o = new Paint(1);
        this.O00000o.setStyle(Paint.Style.FILL);
        this.O00000o0 = (float) dao.O000000o(4.0f);
    }

    public final void O000000o(czw czw, int i, int i2) {
        int measuredWidth = getMeasuredWidth();
        this.f5526O000000o = ((float) (i / 5)) - 1.0f;
        float f = (float) measuredWidth;
        this.O00000Oo = 0.01806f * f;
        this.O00000oO = 0.08f * f;
        this.O00000oo = f * 0.8f;
        this.O000Oo00 = (int) (this.f5526O000000o * 1.6f);
        super.O000000o(czw, i, i2);
    }

    public final void O000000o() {
        this.O0000O0o = this.O00000oo - (this.O00000o0 * 3.0f);
        this.O0000OOo = (float) ((int) (((float) this.O0000oO) * 0.5f));
        this.O000OOoo = 1.0f;
        this.O0000OoO = 30;
        this.O0000Oo = true;
        List<Point> list = this.O0000Oo0;
        if (list == null) {
            this.O0000Oo0 = new ArrayList();
        } else {
            list.clear();
        }
    }

    public final void O000000o(Canvas canvas, int i) {
        boolean z;
        boolean z2 = false;
        int i2 = 0;
        while (true) {
            int i3 = this.O0000Ooo;
            boolean z3 = true;
            if (i2 >= i3 * 5) {
                break;
            }
            int i4 = i2 / i3;
            int i5 = i2 % i3;
            Iterator<Point> it = this.O0000Oo0.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (it.next().equals(i5, i4)) {
                        break;
                    }
                } else {
                    z3 = false;
                    break;
                }
            }
            if (!z3) {
                this.O00000o.setColor(q.O00000Oo(this.O000Oo0O, 255 / (i5 + 1)));
                float f = this.O00000oO;
                float f2 = this.O00000Oo;
                float f3 = f + (((float) i5) * (f2 + 1.0f));
                float f4 = (float) i4;
                float f5 = this.f5526O000000o;
                float f6 = (f4 * (f5 + 1.0f)) + 1.0f;
                canvas.drawRect(f3, f6, f3 + f2, f6 + f5, this.O00000o);
            }
            i2++;
        }
        this.O000OOo.setColor(this.O000Oo0o);
        canvas.drawRect(this.O00000oo, this.O000OOoo, this.O00000oo + this.O00000Oo, this.O000OOoo + ((float) this.O000Oo00), this.O000OOo);
        if (this.O000Oo0 == 1 || this.O000Oo0 == 3 || this.O000Oo0 == 4 || isInEditMode()) {
            this.O000OOo.setColor(this.O000OoO0);
            float f7 = this.O0000O0o;
            float f8 = this.O00000oO;
            int i6 = this.O0000Ooo;
            float f9 = this.O00000Oo;
            float f10 = (((float) i6) * f9) + f8 + (((float) (i6 - 1)) * 1.0f);
            float f11 = this.O00000o0;
            if (f7 <= f10 + f11) {
                float f12 = this.O0000OOo;
                int i7 = (int) ((((f7 - f8) - f11) - ((float) this.O0000o00)) / f9);
                if (i7 == i6) {
                    i7--;
                }
                int i8 = (int) (f12 / this.f5526O000000o);
                if (i8 == 5) {
                    i8--;
                }
                Point point = new Point();
                point.set(i7, i8);
                Iterator<Point> it2 = this.O0000Oo0.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        if (it2.next().equals(point.x, point.y)) {
                            z = true;
                            break;
                        }
                    } else {
                        z = false;
                        break;
                    }
                }
                if (!z) {
                    this.O0000Oo0.add(point);
                }
                if (!z) {
                    this.O0000Oo = false;
                }
            }
            if (this.O0000O0o <= this.O00000oO + this.O00000o0) {
                this.O0000Oo = false;
            }
            float f13 = this.O0000O0o;
            float f14 = this.O00000o0;
            float f15 = this.O00000oo;
            if (f13 + f14 >= f15 && f13 - f14 < f15 + this.O00000Oo) {
                float f16 = this.O0000OOo - this.O000OOoo;
                if (f16 >= 0.0f && f16 <= ((float) this.O000Oo00)) {
                    z2 = true;
                }
                if (z2) {
                    if (this.O0000Oo0.size() == this.O0000Ooo * 5) {
                        this.O000Oo0 = 2;
                        return;
                    }
                    this.O0000Oo = true;
                }
            } else if (this.O0000O0o > ((float) i)) {
                this.O000Oo0 = 2;
            }
            float f17 = this.O0000OOo;
            if (f17 <= this.O00000o0 + 1.0f) {
                this.O0000OoO = 150;
            } else if (f17 >= (((float) this.O0000oO) - this.O00000o0) - 1.0f) {
                this.O0000OoO = 210;
            }
            if (this.O0000Oo) {
                this.O0000O0o -= (float) this.O0000o00;
            } else {
                this.O0000O0o += (float) this.O0000o00;
            }
            this.O0000OOo -= ((float) Math.tan(Math.toRadians((double) this.O0000OoO))) * ((float) this.O0000o00);
            canvas.drawCircle(this.O0000O0o, this.O0000OOo, this.O00000o0, this.O000OOo);
            invalidate();
        }
    }
}
