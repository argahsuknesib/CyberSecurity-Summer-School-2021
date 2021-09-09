package com.scwang.smartrefresh.header;

import _m_j.czw;
import _m_j.dao;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.SparseArray;
import com.scwang.smartrefresh.header.fungame.FunGameView;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class FunGameBattleCityHeader extends FunGameView {

    /* renamed from: O000000o  reason: collision with root package name */
    protected static int f5525O000000o = 3;
    protected SparseArray<Queue<RectF>> O00000Oo;
    protected Point O00000o;
    protected Queue<Point> O00000o0;
    protected Random O00000oO;
    protected float O00000oo;
    protected int O0000O0o;
    protected int O0000OOo;
    protected int O0000Oo;
    protected int O0000Oo0;
    protected int O0000OoO;
    protected int O0000Ooo;
    protected boolean O0000o;
    protected int O0000o0;
    protected int O0000o00;
    protected int O0000o0O;
    protected int O0000o0o;

    public FunGameBattleCityHeader(Context context) {
        this(context, null);
    }

    public FunGameBattleCityHeader(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FunGameBattleCityHeader(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.O0000Oo = 1;
        this.O0000OoO = 4;
        this.O0000o = true;
        this.O00000oO = new Random();
    }

    public final void O000000o(czw czw, int i, int i2) {
        this.O000Oo00 = i / f5525O000000o;
        this.O0000Oo0 = (int) Math.floor((double) ((((float) this.O000Oo00) * 0.33333334f) + 0.5f));
        this.O00000oo = (((float) this.O0000Oo0) - (this.O000O0OO * 2.0f)) * 0.5f;
        super.O000000o(czw, i, i2);
    }

    public final void O000000o() {
        this.O000Oo0 = 0;
        this.O000OOoo = this.O000O0OO;
        this.O0000Oo = dao.O000000o(1.0f);
        this.O0000OoO = dao.O000000o(4.0f);
        this.O0000o0O = 8;
        this.O0000o0o = 0;
        this.O0000o = true;
        this.O0000O0o = this.O000Oo00 + this.O0000Oo0 + 60;
        this.O0000OOo = 360;
        this.O00000Oo = new SparseArray<>();
        for (int i = 0; i < f5525O000000o; i++) {
            this.O00000Oo.put(i, new LinkedList());
        }
        this.O00000o0 = new LinkedList();
    }

    private int O00000o0(int i) {
        int i2 = this.O0000oO;
        int i3 = f5525O000000o;
        int i4 = i / (i2 / i3);
        if (i4 >= i3) {
            i4 = i3 - 1;
        }
        if (i4 < 0) {
            return 0;
        }
        return i4;
    }

    private boolean O000000o(int i, float f, float f2) {
        RectF rectF = (RectF) this.O00000Oo.get(i).peek();
        return rectF != null && rectF.contains(f, f2);
    }

    private void O00000Oo(Canvas canvas, int i) {
        boolean z;
        this.O000OOo.setColor(this.O000OoO0);
        this.O0000o00 += this.O0000OoO;
        if (this.O0000o00 / this.O0000OOo == 1) {
            this.O0000o00 = 0;
        }
        if (this.O0000o00 == 0) {
            Point point = new Point();
            point.x = (i - this.O000Oo00) - this.O0000Oo0;
            point.y = (int) (this.O000OOoo + (((float) this.O000Oo00) * 0.5f));
            this.O00000o0.offer(point);
        }
        boolean z2 = false;
        for (Point next : this.O00000o0) {
            int O00000o02 = O00000o0(next.y);
            RectF rectF = (RectF) this.O00000Oo.get(O00000o02).peek();
            if (rectF == null || !rectF.contains((float) next.x, (float) next.y)) {
                z = false;
            } else {
                int i2 = this.O0000o0o + 1;
                this.O0000o0o = i2;
                int i3 = this.O0000o0O;
                if (i2 == i3) {
                    this.O0000o0O = i3 + 8;
                    this.O0000Oo += dao.O000000o(1.0f);
                    this.O0000OoO += dao.O000000o(1.0f);
                    this.O0000o0o = 0;
                    int i4 = this.O0000O0o;
                    if (i4 > 12) {
                        this.O0000O0o = i4 - 12;
                    }
                    int i5 = this.O0000OOo;
                    if (i5 > 30) {
                        this.O0000OOo = i5 - 30;
                    }
                }
                this.O00000Oo.get(O00000o02).poll();
                z = true;
            }
            if (z) {
                this.O00000o = next;
            } else {
                if (((float) next.x) + this.O00000oo <= 0.0f) {
                    z2 = true;
                }
                next.x -= this.O0000OoO;
                canvas.drawCircle((float) next.x, (float) next.y, this.O00000oo, this.O000OOo);
            }
        }
        if (z2) {
            this.O00000o0.poll();
        }
        this.O00000o0.remove(this.O00000o);
        this.O00000o = null;
    }

    private void O000000o(Canvas canvas, RectF rectF) {
        rectF.set(rectF.left + ((float) this.O0000Oo), rectF.top, rectF.right + ((float) this.O0000Oo), rectF.bottom);
        canvas.drawRect(rectF, this.O000OOo);
        float f = rectF.top + (((float) (this.O000Oo00 - this.O0000Oo0)) * 0.5f);
        float f2 = rectF.right;
        float f3 = rectF.right;
        int i = this.O0000Oo0;
        canvas.drawRect(f2, f, f3 + ((float) i), f + ((float) i), this.O000OOo);
    }

    public final void O000000o(Canvas canvas, int i) {
        boolean z;
        Canvas canvas2 = canvas;
        int i2 = i;
        this.O000OOo.setColor(this.O000Oo0o);
        boolean O000000o2 = O000000o(O00000o0((int) this.O000OOoo), (float) (i2 - this.O000Oo00), this.O000OOoo);
        boolean O000000o3 = O000000o(O00000o0((int) (this.O000OOoo + ((float) this.O000Oo00))), (float) (i2 - this.O000Oo00), this.O000OOoo + ((float) this.O000Oo00));
        if (O000000o2 || O000000o3) {
            this.O000Oo0 = 2;
        }
        float f = (float) i2;
        canvas.drawRect((float) (i2 - this.O000Oo00), this.O000O0OO + this.O000OOoo, f, this.O000OOoo + ((float) this.O000Oo00) + this.O000O0OO, this.O000OOo);
        float f2 = (float) ((i2 - this.O000Oo00) - this.O0000Oo0);
        float f3 = (((float) (this.O000Oo00 - this.O0000Oo0)) * 0.5f) + this.O000OOoo;
        float f4 = (float) (i2 - this.O000Oo00);
        float f5 = this.O000OOoo;
        int i3 = this.O000Oo00;
        int i4 = this.O0000Oo0;
        canvas.drawRect(f2, f3, f4, f5 + (((float) (i3 - i4)) * 0.5f) + ((float) i4), this.O000OOo);
        if (this.O000Oo0 == 1 || this.O000Oo0 == 3 || this.O000Oo0 == 4) {
            this.O000OOo.setColor(this.O000Oo0O);
            this.O0000Ooo += this.O0000Oo;
            if (this.O0000Ooo / this.O0000O0o == 1 || this.O0000o) {
                this.O0000Ooo = 0;
                this.O0000o = false;
            }
            int nextInt = this.O00000oO.nextInt(f5525O000000o);
            boolean z2 = false;
            for (int i5 = 0; i5 < f5525O000000o; i5++) {
                Queue queue = this.O00000Oo.get(i5);
                if (this.O0000Ooo == 0 && i5 == nextInt) {
                    float f6 = (float) (-(this.O000Oo00 + this.O0000Oo0));
                    float f7 = ((float) (this.O000Oo00 * i5)) + this.O000O0OO;
                    queue.offer(new RectF(f6, f7, (((float) this.O0000Oo0) * 2.5f) + f6, ((float) this.O000Oo00) + f7));
                }
                Iterator it = queue.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = z2;
                        break;
                    }
                    RectF rectF = (RectF) it.next();
                    if (rectF.left >= f) {
                        int i6 = this.O0000o0 + 1;
                        this.O0000o0 = i6;
                        if (i6 >= 8) {
                            this.O000Oo0 = 2;
                            z = true;
                            break;
                        }
                        z2 = true;
                    } else {
                        O000000o(canvas2, rectF);
                    }
                }
                if (this.O000Oo0 == 2) {
                    break;
                }
                if (z) {
                    queue.poll();
                    z2 = false;
                } else {
                    z2 = z;
                }
            }
            invalidate();
            O00000Oo(canvas, i);
        }
        if (isInEditMode()) {
            O000000o(canvas2, new RectF((float) this.O000Oo00, 0.0f, (float) (this.O000Oo00 * 2), (float) this.O000Oo00));
            O000000o(canvas2, new RectF(0.0f, (float) this.O000Oo00, (float) this.O000Oo00, (float) (this.O000Oo00 * 2)));
            O000000o(canvas2, new RectF((float) (this.O000Oo00 * 3), (float) (this.O000Oo00 * 2), (float) (this.O000Oo00 * 4), (float) (this.O000Oo00 * 3)));
        }
    }
}
