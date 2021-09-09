package com.github.barteksc.pdfviewer;

import _m_j.atj;
import _m_j.atk;
import _m_j.atl;
import _m_j.atm;
import _m_j.atn;
import _m_j.ato;
import _m_j.atp;
import _m_j.atq;
import _m_j.atr;
import _m_j.ats;
import _m_j.att;
import _m_j.atu;
import _m_j.atv;
import _m_j.atw;
import _m_j.atx;
import _m_j.aty;
import _m_j.atz;
import _m_j.aua;
import _m_j.aub;
import _m_j.aud;
import _m_j.aue;
import _m_j.auf;
import _m_j.aug;
import _m_j.auh;
import _m_j.auk;
import _m_j.dbj;
import _m_j.dbk;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.HandlerThread;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.github.barteksc.pdfviewer.util.FitPolicy;
import com.github.barteksc.pdfviewer.util.SnapEdge;
import com.shockwave.pdfium.PdfiumCore;
import com.shockwave.pdfium.util.Size;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class PDFView extends RelativeLayout {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final String f3602O000000o = "PDFView";
    public float O00000Oo = 1.0f;
    public atj O00000o;
    public atk O00000o0;
    public atm O00000oO;
    public ato O00000oo;
    public int O0000O0o;
    public float O0000OOo = 0.0f;
    public float O0000Oo = 1.0f;
    public float O0000Oo0 = 0.0f;
    protected boolean O0000OoO = true;
    public State O0000Ooo = State.DEFAULT;
    public boolean O0000o = true;
    public atp O0000o0;
    public final HandlerThread O0000o00 = new HandlerThread("PDF renderer");
    public ats O0000o0O = new ats();
    public int O0000o0o = 0;
    public boolean O0000oO = true;
    public boolean O0000oO0 = true;
    public aue O0000oOO;
    public boolean O0000oOo = false;
    public boolean O0000oo = false;
    public boolean O0000oo0 = false;
    public boolean O0000ooO = false;
    boolean O0000ooo = true;
    public boolean O000O00o = false;
    public O000000o O000O0OO;
    private float O000O0Oo = 1.75f;
    private atl O000O0o;
    private ScrollDir O000O0o0 = ScrollDir.NONE;
    private atn O000O0oO;
    private Paint O000O0oo;
    private boolean O000OO = false;
    private Paint O000OO00;
    private FitPolicy O000OO0o = FitPolicy.WIDTH;
    private boolean O000OOOo = true;
    private PaintFlagsDrawFilter O000OOo = new PaintFlagsDrawFilter(0, 3);
    private PdfiumCore O000OOo0;
    private int O000OOoO = 0;
    private List<Integer> O000OOoo = new ArrayList(10);
    private float O00oOoOo = 3.0f;
    public boolean O00oOooO = false;
    public boolean O00oOooo = true;

    enum ScrollDir {
        NONE,
        START,
        END
    }

    public enum State {
        DEFAULT,
        LOADED,
        SHOWN,
        ERROR
    }

    public aue getScrollHandle() {
        return this.O0000oOO;
    }

    public PDFView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        if (!isInEditMode()) {
            this.O00000o0 = new atk();
            this.O00000o = new atj(this);
            this.O00000oO = new atm(this, this.O00000o);
            this.O000O0oO = new atn(this);
            this.O000O0oo = new Paint();
            this.O000OO00 = new Paint();
            this.O000OO00.setStyle(Paint.Style.STROKE);
            this.O000OOo0 = new PdfiumCore(context);
            setWillNotDraw(false);
        }
    }

    public final void O000000o(auf auf, String str, int[] iArr) {
        if (this.O0000OoO) {
            this.O0000OoO = false;
            this.O000O0o = new atl(auf, str, iArr, this, this.O000OOo0);
            this.O000O0o.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            return;
        }
        throw new IllegalStateException("Don't call load on a PDF View without recycling it first.");
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.github.barteksc.pdfviewer.PDFView.O000000o(float, float, boolean):void
     arg types: [float, float, int]
     candidates:
      com.github.barteksc.pdfviewer.PDFView.O000000o(android.graphics.Canvas, int, _m_j.att):void
      com.github.barteksc.pdfviewer.PDFView.O000000o(float, float, float):void
      com.github.barteksc.pdfviewer.PDFView.O000000o(_m_j.auf, java.lang.String, int[]):void
      com.github.barteksc.pdfviewer.PDFView.O000000o(float, float, boolean):void */
    public final void O000000o(int i) {
        float f;
        ato ato = this.O00000oo;
        if (ato != null) {
            int O00000o02 = ato.O00000o0(i);
            if (O00000o02 == 0) {
                f = 0.0f;
            } else {
                f = -this.O00000oo.O00000o0(O00000o02, this.O0000Oo);
            }
            if (this.O0000o) {
                O000000o(this.O0000OOo, f, true);
            } else {
                O000000o(f, this.O0000Oo0, true);
            }
            O00000o0(O00000o02);
        }
    }

    private void O00000o0(int i) {
        if (!this.O0000OoO) {
            this.O0000O0o = this.O00000oo.O00000o0(i);
            O00000Oo();
            if (this.O0000oOO != null && !O00000oO()) {
                this.O0000oOO.setPageNum(this.O0000O0o + 1);
            }
            this.O0000o0O.O000000o(this.O0000O0o, this.O00000oo.O00000o0);
        }
    }

    public float getPositionOffset() {
        int i;
        float f;
        float f2;
        if (this.O0000o) {
            f2 = -this.O0000Oo0;
            ato ato = this.O00000oo;
            f = ato.O00000oO * this.O0000Oo;
            i = getHeight();
        } else {
            f2 = -this.O0000OOo;
            ato ato2 = this.O00000oo;
            f = ato2.O00000oO * this.O0000Oo;
            i = getWidth();
        }
        float f3 = f2 / (f - ((float) i));
        if (f3 <= 0.0f) {
            return 0.0f;
        }
        if (f3 >= 1.0f) {
            return 1.0f;
        }
        return f3;
    }

    public final void O000000o(float f, boolean z) {
        if (this.O0000o) {
            float f2 = this.O0000OOo;
            ato ato = this.O00000oo;
            O000000o(f2, ((-(ato.O00000oO * this.O0000Oo)) + ((float) getHeight())) * f, z);
        } else {
            ato ato2 = this.O00000oo;
            O000000o(((-(ato2.O00000oO * this.O0000Oo)) + ((float) getWidth())) * f, this.O0000Oo0, z);
        }
        O00000o0();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.github.barteksc.pdfviewer.PDFView.O000000o(float, boolean):void
     arg types: [float, int]
     candidates:
      com.github.barteksc.pdfviewer.PDFView.O000000o(android.graphics.Canvas, _m_j.aud):void
      com.github.barteksc.pdfviewer.PDFView.O000000o(com.github.barteksc.pdfviewer.PDFView, int):void
      com.github.barteksc.pdfviewer.PDFView.O000000o(int, com.github.barteksc.pdfviewer.util.SnapEdge):float
      com.github.barteksc.pdfviewer.PDFView.O000000o(float, float):int
      com.github.barteksc.pdfviewer.PDFView.O000000o(float, android.graphics.PointF):void
      com.github.barteksc.pdfviewer.PDFView.O000000o(float, boolean):void */
    public void setPositionOffset(float f) {
        O000000o(f, true);
    }

    public int getPageCount() {
        ato ato = this.O00000oo;
        if (ato == null) {
            return 0;
        }
        return ato.O00000o0;
    }

    public void setSwipeEnabled(boolean z) {
        this.O0000oO0 = z;
    }

    public void setNightMode(boolean z) {
        this.O000OO = z;
        if (z) {
            this.O000O0oo.setColorFilter(new ColorMatrixColorFilter(new ColorMatrix(new float[]{-1.0f, 0.0f, 0.0f, 0.0f, 255.0f, 0.0f, -1.0f, 0.0f, 0.0f, 255.0f, 0.0f, 0.0f, -1.0f, 0.0f, 255.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f})));
            return;
        }
        this.O000O0oo.setColorFilter(null);
    }

    public final void i_() {
        this.O000O0OO = null;
        this.O00000o.O000000o();
        this.O00000oO.f12601O000000o = false;
        atp atp = this.O0000o0;
        if (atp != null) {
            atp.O00000Oo = false;
            atp.removeMessages(1);
        }
        atl atl = this.O000O0o;
        if (atl != null) {
            atl.cancel(true);
        }
        atk atk = this.O00000o0;
        synchronized (atk.O00000o) {
            Iterator<aud> it = atk.f12598O000000o.iterator();
            while (it.hasNext()) {
                it.next().O00000Oo.recycle();
            }
            atk.f12598O000000o.clear();
            Iterator<aud> it2 = atk.O00000Oo.iterator();
            while (it2.hasNext()) {
                it2.next().O00000Oo.recycle();
            }
            atk.O00000Oo.clear();
        }
        synchronized (atk.O00000o0) {
            for (aud aud : atk.O00000o0) {
                aud.O00000Oo.recycle();
            }
            atk.O00000o0.clear();
        }
        aue aue = this.O0000oOO;
        if (aue != null && this.O0000oOo) {
            aue.O000000o();
        }
        ato ato = this.O00000oo;
        if (ato != null) {
            if (!(ato.O00000Oo == null || ato.f12605O000000o == null)) {
                ato.O00000Oo.O00000Oo(ato.f12605O000000o);
            }
            ato.f12605O000000o = null;
            ato.O00000oo = null;
            this.O00000oo = null;
        }
        this.O0000o0 = null;
        this.O0000oOO = null;
        this.O0000oOo = false;
        this.O0000Oo0 = 0.0f;
        this.O0000OOo = 0.0f;
        this.O0000Oo = 1.0f;
        this.O0000OoO = true;
        this.O0000o0O = new ats();
        this.O0000Ooo = State.DEFAULT;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.github.barteksc.pdfviewer.PDFView.O000000o(float, float, boolean):void
     arg types: [float, float, int]
     candidates:
      com.github.barteksc.pdfviewer.PDFView.O000000o(android.graphics.Canvas, int, _m_j.att):void
      com.github.barteksc.pdfviewer.PDFView.O000000o(float, float, float):void
      com.github.barteksc.pdfviewer.PDFView.O000000o(_m_j.auf, java.lang.String, int[]):void
      com.github.barteksc.pdfviewer.PDFView.O000000o(float, float, boolean):void */
    public void computeScroll() {
        super.computeScroll();
        if (!isInEditMode()) {
            atj atj = this.O00000o;
            if (atj.O00000Oo.computeScrollOffset()) {
                atj.f12594O000000o.O000000o((float) atj.O00000Oo.getCurrX(), (float) atj.O00000Oo.getCurrY(), true);
                atj.f12594O000000o.O00000o0();
            } else if (atj.O00000o0) {
                atj.O00000o0 = false;
                atj.f12594O000000o.O00000Oo();
                atj.O00000o0();
                atj.f12594O000000o.O00000o();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        i_();
        super.onDetachedFromWindow();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.github.barteksc.pdfviewer.PDFView.O000000o(float, float, boolean):void
     arg types: [float, float, int]
     candidates:
      com.github.barteksc.pdfviewer.PDFView.O000000o(android.graphics.Canvas, int, _m_j.att):void
      com.github.barteksc.pdfviewer.PDFView.O000000o(float, float, float):void
      com.github.barteksc.pdfviewer.PDFView.O000000o(_m_j.auf, java.lang.String, int[]):void
      com.github.barteksc.pdfviewer.PDFView.O000000o(float, float, boolean):void */
    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        this.O000O00o = true;
        O000000o o000000o = this.O000O0OO;
        if (o000000o != null) {
            o000000o.O000000o();
        }
        if (!isInEditMode() && this.O0000Ooo == State.SHOWN) {
            this.O00000o.O000000o();
            this.O00000oo.O000000o(new Size(i, i2));
            if (this.O0000o) {
                O000000o(this.O0000OOo, -this.O00000oo.O00000o0(this.O0000O0o, this.O0000Oo), true);
            } else {
                O000000o(-this.O00000oo.O00000o0(this.O0000O0o, this.O0000Oo), this.O0000Oo0, true);
            }
            O00000o0();
        }
    }

    public boolean canScrollHorizontally(int i) {
        if (this.O00000oo == null) {
            return true;
        }
        if (this.O0000o) {
            if (i < 0 && this.O0000OOo < 0.0f) {
                return true;
            }
            if (i <= 0 || this.O0000OOo + (this.O00000oo.O000000o().f14452O000000o * this.O0000Oo) <= ((float) getWidth())) {
                return false;
            }
            return true;
        } else if (i < 0 && this.O0000OOo < 0.0f) {
            return true;
        } else {
            if (i <= 0) {
                return false;
            }
            float f = this.O0000OOo;
            ato ato = this.O00000oo;
            if (f + (ato.O00000oO * this.O0000Oo) > ((float) getWidth())) {
                return true;
            }
            return false;
        }
    }

    public boolean canScrollVertically(int i) {
        if (this.O00000oo == null) {
            return true;
        }
        if (this.O0000o) {
            if (i < 0 && this.O0000Oo0 < 0.0f) {
                return true;
            }
            if (i <= 0) {
                return false;
            }
            float f = this.O0000Oo0;
            ato ato = this.O00000oo;
            if (f + (ato.O00000oO * this.O0000Oo) > ((float) getHeight())) {
                return true;
            }
            return false;
        } else if (i < 0 && this.O0000Oo0 < 0.0f) {
            return true;
        } else {
            if (i <= 0 || this.O0000Oo0 + (this.O00000oo.O000000o().O00000Oo * this.O0000Oo) <= ((float) getHeight())) {
                return false;
            }
            return true;
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        if (!isInEditMode()) {
            if (this.O0000ooo) {
                canvas.setDrawFilter(this.O000OOo);
            }
            Drawable background = getBackground();
            if (background == null) {
                canvas.drawColor(this.O000OO ? -16777216 : -1);
            } else {
                background.draw(canvas);
            }
            if (!this.O0000OoO && this.O0000Ooo == State.SHOWN) {
                float f = this.O0000OOo;
                float f2 = this.O0000Oo0;
                canvas.translate(f, f2);
                for (aud O000000o2 : this.O00000o0.O00000o0()) {
                    O000000o(canvas, O000000o2);
                }
                for (aud next : this.O00000o0.O00000Oo()) {
                    O000000o(canvas, next);
                    if (this.O0000o0O.O0000OOo != null && !this.O000OOoo.contains(Integer.valueOf(next.f12618O000000o))) {
                        this.O000OOoo.add(Integer.valueOf(next.f12618O000000o));
                    }
                }
                for (Integer intValue : this.O000OOoo) {
                    O000000o(canvas, intValue.intValue(), this.O0000o0O.O0000OOo);
                }
                this.O000OOoo.clear();
                O000000o(canvas, this.O0000O0o, this.O0000o0O.O0000O0o);
                canvas.translate(-f, -f2);
            }
        }
    }

    private void O000000o(Canvas canvas, int i, att att) {
        float f;
        if (att != null) {
            float f2 = 0.0f;
            if (this.O0000o) {
                f2 = this.O00000oo.O00000o0(i, this.O0000Oo);
                f = 0.0f;
            } else {
                f = this.O00000oo.O00000o0(i, this.O0000Oo);
            }
            canvas.translate(f, f2);
            dbk O000000o2 = this.O00000oo.O000000o(i);
            att.a_(O000000o2.f14452O000000o * this.O0000Oo, O000000o2.O00000Oo * this.O0000Oo);
            canvas.translate(-f, -f2);
        }
    }

    public final void O00000Oo() {
        atp atp;
        if (this.O00000oo != null && (atp = this.O0000o0) != null) {
            atp.removeMessages(1);
            this.O00000o0.O000000o();
            this.O000O0oO.O000000o();
            invalidate();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x007a  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00d1  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00d9  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00f7  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00fc  */
    public final void O000000o(float f, float f2, boolean z) {
        float f3;
        float f4;
        float height;
        float f5;
        float f6;
        float width;
        if (this.O0000o) {
            float f7 = this.O00000oo.O000000o().f14452O000000o * this.O0000Oo;
            if (f7 < ((float) getWidth())) {
                width = (float) (getWidth() / 2);
                f7 /= 2.0f;
            } else {
                if (f > 0.0f) {
                    f = 0.0f;
                } else if (f + f7 < ((float) getWidth())) {
                    width = (float) getWidth();
                }
                ato ato = this.O00000oo;
                f5 = ato.O00000oO * this.O0000Oo;
                if (f5 >= ((float) getHeight())) {
                    f2 = (((float) getHeight()) - f5) / 2.0f;
                } else if (f2 > 0.0f) {
                    f2 = 0.0f;
                } else if (f2 + f5 < ((float) getHeight())) {
                    f2 = (-f5) + ((float) getHeight());
                }
                f6 = this.O0000Oo0;
                if (f2 >= f6) {
                    this.O000O0o0 = ScrollDir.END;
                } else if (f2 > f6) {
                    this.O000O0o0 = ScrollDir.START;
                } else {
                    this.O000O0o0 = ScrollDir.NONE;
                }
            }
            f = width - f7;
            ato ato2 = this.O00000oo;
            f5 = ato2.O00000oO * this.O0000Oo;
            if (f5 >= ((float) getHeight())) {
            }
            f6 = this.O0000Oo0;
            if (f2 >= f6) {
            }
        } else {
            float f8 = this.O00000oo.O000000o().O00000Oo * this.O0000Oo;
            if (f8 < ((float) getHeight())) {
                height = (float) (getHeight() / 2);
                f8 /= 2.0f;
            } else {
                if (f2 > 0.0f) {
                    f2 = 0.0f;
                } else if (f2 + f8 < ((float) getHeight())) {
                    height = (float) getHeight();
                }
                ato ato3 = this.O00000oo;
                f3 = ato3.O00000oO * this.O0000Oo;
                if (f3 >= ((float) getWidth())) {
                    f = (((float) getWidth()) - f3) / 2.0f;
                } else if (f > 0.0f) {
                    f = 0.0f;
                } else if (f + f3 < ((float) getWidth())) {
                    f = (-f3) + ((float) getWidth());
                }
                f4 = this.O0000OOo;
                if (f >= f4) {
                    this.O000O0o0 = ScrollDir.END;
                } else if (f > f4) {
                    this.O000O0o0 = ScrollDir.START;
                } else {
                    this.O000O0o0 = ScrollDir.NONE;
                }
            }
            f2 = height - f8;
            ato ato32 = this.O00000oo;
            f3 = ato32.O00000oO * this.O0000Oo;
            if (f3 >= ((float) getWidth())) {
            }
            f4 = this.O0000OOo;
            if (f >= f4) {
            }
        }
        this.O0000OOo = f;
        this.O0000Oo0 = f2;
        float positionOffset = getPositionOffset();
        if (z && this.O0000oOO != null && !O00000oO()) {
            this.O0000oOO.setScroll(positionOffset);
        }
        ats ats = this.O0000o0O;
        getCurrentPage();
        ats.O000000o();
        invalidate();
    }

    public final void O00000o0() {
        int i;
        float f;
        if (this.O00000oo.O00000o0 != 0) {
            if (this.O0000o) {
                f = this.O0000Oo0;
                i = getHeight();
            } else {
                f = this.O0000OOo;
                i = getWidth();
            }
            int O000000o2 = this.O00000oo.O000000o(-(f - (((float) i) / 2.0f)), this.O0000Oo);
            if (O000000o2 < 0 || O000000o2 > this.O00000oo.O00000o0 - 1 || O000000o2 == getCurrentPage()) {
                O00000Oo();
            } else {
                O00000o0(O000000o2);
            }
        }
    }

    public final void O00000o() {
        ato ato;
        int O000000o2;
        SnapEdge O00000Oo2;
        if (this.O000OOOo && (ato = this.O00000oo) != null && ato.O00000o0 != 0 && (O00000Oo2 = O00000Oo((O000000o2 = O000000o(this.O0000OOo, this.O0000Oo0)))) != SnapEdge.NONE) {
            float O000000o3 = O000000o(O000000o2, O00000Oo2);
            if (this.O0000o) {
                this.O00000o.O00000Oo(this.O0000Oo0, -O000000o3);
            } else {
                this.O00000o.O000000o(this.O0000OOo, -O000000o3);
            }
        }
    }

    public final SnapEdge O00000Oo(int i) {
        if (!this.O000OOOo || i < 0) {
            return SnapEdge.NONE;
        }
        float f = this.O0000o ? this.O0000Oo0 : this.O0000OOo;
        float f2 = -this.O00000oo.O00000o0(i, this.O0000Oo);
        int height = this.O0000o ? getHeight() : getWidth();
        float O00000Oo2 = this.O00000oo.O00000Oo(i, this.O0000Oo);
        float f3 = (float) height;
        if (f3 >= O00000Oo2) {
            return SnapEdge.CENTER;
        }
        if (f >= f2) {
            return SnapEdge.START;
        }
        if (f2 - O00000Oo2 > f - f3) {
            return SnapEdge.END;
        }
        return SnapEdge.NONE;
    }

    public final float O000000o(int i, SnapEdge snapEdge) {
        float f;
        float O00000o02 = this.O00000oo.O00000o0(i, this.O0000Oo);
        float height = (float) (this.O0000o ? getHeight() : getWidth());
        float O00000Oo2 = this.O00000oo.O00000Oo(i, this.O0000Oo);
        if (snapEdge == SnapEdge.CENTER) {
            f = O00000o02 - (height / 2.0f);
            O00000Oo2 /= 2.0f;
        } else if (snapEdge != SnapEdge.END) {
            return O00000o02;
        } else {
            f = O00000o02 - height;
        }
        return f + O00000Oo2;
    }

    public final int O000000o(float f, float f2) {
        if (this.O0000o) {
            f = f2;
        }
        float height = (float) (this.O0000o ? getHeight() : getWidth());
        if (f > -1.0f) {
            return 0;
        }
        if (f < (-(this.O00000oo.O00000oO * this.O0000Oo)) + height + 1.0f) {
            return this.O00000oo.O00000o0 - 1;
        }
        return this.O00000oo.O000000o(-(f - (height / 2.0f)), this.O0000Oo);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.github.barteksc.pdfviewer.PDFView.O000000o(float, float, boolean):void
     arg types: [float, float, int]
     candidates:
      com.github.barteksc.pdfviewer.PDFView.O000000o(android.graphics.Canvas, int, _m_j.att):void
      com.github.barteksc.pdfviewer.PDFView.O000000o(float, float, float):void
      com.github.barteksc.pdfviewer.PDFView.O000000o(_m_j.auf, java.lang.String, int[]):void
      com.github.barteksc.pdfviewer.PDFView.O000000o(float, float, boolean):void */
    public final void O000000o(float f, PointF pointF) {
        float f2 = f / this.O0000Oo;
        this.O0000Oo = f;
        O000000o((this.O0000OOo * f2) + (pointF.x - (pointF.x * f2)), (this.O0000Oo0 * f2) + (pointF.y - (pointF.y * f2)), true);
    }

    public final boolean O00000oO() {
        float f = this.O00000oo.O00000oO * 1.0f;
        return this.O0000o ? f < ((float) getHeight()) : f < ((float) getWidth());
    }

    public int getCurrentPage() {
        return this.O0000O0o;
    }

    public float getCurrentXOffset() {
        return this.O0000OOo;
    }

    public float getCurrentYOffset() {
        return this.O0000Oo0;
    }

    public float getZoom() {
        return this.O0000Oo;
    }

    public void setDefaultPage(int i) {
        this.O0000o0o = i;
    }

    public final void O000000o(float f, float f2, float f3) {
        this.O00000o.O000000o(f, f2, this.O0000Oo, f3);
    }

    public void setScrollHandle(aue aue) {
        this.O0000oOO = aue;
    }

    public float getMinZoom() {
        return this.O00000Oo;
    }

    public void setMinZoom(float f) {
        this.O00000Oo = f;
    }

    public float getMidZoom() {
        return this.O000O0Oo;
    }

    public void setMidZoom(float f) {
        this.O000O0Oo = f;
    }

    public float getMaxZoom() {
        return this.O00oOoOo;
    }

    public void setMaxZoom(float f) {
        this.O00oOoOo = f;
    }

    public void setSwipeVertical(boolean z) {
        this.O0000o = z;
    }

    public int getSpacingPx() {
        return this.O000OOoO;
    }

    public void setPageFling(boolean z) {
        this.O00oOooo = z;
    }

    /* access modifiers changed from: private */
    public void setSpacing(int i) {
        this.O000OOoO = auk.O000000o(getContext(), i);
    }

    public void setAutoSpacing(boolean z) {
        this.O00oOooO = z;
    }

    public void setPageFitPolicy(FitPolicy fitPolicy) {
        this.O000OO0o = fitPolicy;
    }

    public FitPolicy getPageFitPolicy() {
        return this.O000OO0o;
    }

    public void setPageSnap(boolean z) {
        this.O000OOOo = z;
    }

    public dbj.O00000o0 getDocumentMeta() {
        ato ato = this.O00000oo;
        if (ato == null || ato.f12605O000000o == null) {
            return null;
        }
        return ato.O00000Oo.O00000o0(ato.f12605O000000o);
    }

    public List<dbj.O000000o> getTableOfContents() {
        ato ato = this.O00000oo;
        if (ato == null) {
            return Collections.emptyList();
        }
        if (ato.f12605O000000o == null) {
            return new ArrayList();
        }
        return ato.O00000Oo.O00000o(ato.f12605O000000o);
    }

    public final O000000o O000000o(Uri uri) {
        return new O000000o(this, new aug(uri), (byte) 0);
    }

    public class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public att f3603O000000o;
        public atv O00000Oo;
        public atx O00000o;
        public atu O00000o0;
        public atz O00000oO;
        public aub O00000oo;
        public atr O0000O0o;
        public int O0000OOo;
        public boolean O0000Oo;
        public boolean O0000Oo0;
        public String O0000OoO;
        public boolean O0000Ooo;
        public boolean O0000o;
        public boolean O0000o0;
        public int O0000o00;
        public FitPolicy O0000o0O;
        public boolean O0000o0o;
        private final auf O0000oO;
        private int[] O0000oOO;
        private boolean O0000oOo;
        private att O0000oo;
        private boolean O0000oo0;
        private aua O0000ooO;
        private atw O0000ooo;
        private boolean O000O00o;
        private aty O00oOooO;
        private aue O00oOooo;

        /* synthetic */ O000000o(PDFView pDFView, auf auf, byte b) {
            this(auf);
        }

        private O000000o(auf auf) {
            this.O0000oOO = null;
            this.O0000oOo = true;
            this.O0000oo0 = true;
            this.O0000O0o = new atq(PDFView.this);
            this.O0000OOo = 0;
            this.O0000Oo0 = false;
            this.O0000Oo = false;
            this.O0000OoO = null;
            this.O00oOooo = null;
            this.O0000Ooo = true;
            this.O0000o00 = 0;
            this.O0000o0 = false;
            this.O0000o0O = FitPolicy.WIDTH;
            this.O0000o0o = false;
            this.O0000o = false;
            this.O000O00o = false;
            this.O0000oO = auf;
        }

        public final void O000000o() {
            if (!PDFView.this.O000O00o) {
                PDFView.this.O000O0OO = this;
                return;
            }
            PDFView.this.i_();
            PDFView.this.O0000o0O.f12611O000000o = this.O00000Oo;
            PDFView.this.O0000o0O.O00000Oo = this.O00000o0;
            PDFView.this.O0000o0O.O0000O0o = this.f3603O000000o;
            PDFView.this.O0000o0O.O0000OOo = this.O0000oo;
            PDFView.this.O0000o0O.O00000oO = this.O00000o;
            PDFView.this.O0000o0O.O00000oo = this.O00000oO;
            PDFView.this.O0000o0O.O00000o = this.O0000ooO;
            PDFView.this.O0000o0O.O0000Oo0 = this.O00000oo;
            PDFView.this.O0000o0O.O0000Oo = this.O0000ooo;
            PDFView.this.O0000o0O.O00000o0 = this.O00oOooO;
            PDFView.this.O0000o0O.O0000OoO = this.O0000O0o;
            PDFView.this.setSwipeEnabled(this.O0000oOo);
            PDFView.this.setNightMode(this.O000O00o);
            PDFView pDFView = PDFView.this;
            pDFView.O0000oO = this.O0000oo0;
            pDFView.setDefaultPage(this.O0000OOo);
            PDFView.this.setSwipeVertical(!this.O0000Oo0);
            PDFView pDFView2 = PDFView.this;
            pDFView2.O0000oo = this.O0000Oo;
            pDFView2.setScrollHandle(this.O00oOooo);
            PDFView pDFView3 = PDFView.this;
            pDFView3.O0000ooo = this.O0000Ooo;
            pDFView3.setSpacing(this.O0000o00);
            PDFView.this.setAutoSpacing(this.O0000o0);
            PDFView.this.setPageFitPolicy(this.O0000o0O);
            PDFView.this.setPageSnap(this.O0000o);
            PDFView.this.setPageFling(this.O0000o0o);
            int[] iArr = this.O0000oOO;
            if (iArr != null) {
                PDFView.this.O000000o(this.O0000oO, this.O0000OoO, iArr);
            } else {
                PDFView.this.O000000o(this.O0000oO, this.O0000OoO, (int[]) null);
            }
        }
    }

    private void O000000o(Canvas canvas, aud aud) {
        float f;
        float f2;
        RectF rectF = aud.O00000o0;
        Bitmap bitmap = aud.O00000Oo;
        if (!bitmap.isRecycled()) {
            dbk O000000o2 = this.O00000oo.O000000o(aud.f12618O000000o);
            if (this.O0000o) {
                f2 = this.O00000oo.O00000o0(aud.f12618O000000o, this.O0000Oo);
                f = ((this.O00000oo.O000000o().f14452O000000o - O000000o2.f14452O000000o) * this.O0000Oo) / 2.0f;
            } else {
                f = this.O00000oo.O00000o0(aud.f12618O000000o, this.O0000Oo);
                f2 = ((this.O00000oo.O000000o().O00000Oo - O000000o2.O00000Oo) * this.O0000Oo) / 2.0f;
            }
            canvas.translate(f, f2);
            Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
            float f3 = rectF.left * O000000o2.f14452O000000o * this.O0000Oo;
            float f4 = rectF.top * O000000o2.O00000Oo * this.O0000Oo;
            RectF rectF2 = new RectF((float) ((int) f3), (float) ((int) f4), (float) ((int) (f3 + (rectF.width() * O000000o2.f14452O000000o * this.O0000Oo))), (float) ((int) (f4 + (rectF.height() * O000000o2.O00000Oo * this.O0000Oo))));
            float f5 = this.O0000OOo + f;
            float f6 = this.O0000Oo0 + f2;
            if (rectF2.left + f5 >= ((float) getWidth()) || f5 + rectF2.right <= 0.0f || rectF2.top + f6 >= ((float) getHeight()) || f6 + rectF2.bottom <= 0.0f) {
                canvas.translate(-f, -f2);
                return;
            }
            canvas.drawBitmap(bitmap, rect, rectF2, this.O000O0oo);
            if (auh.f12620O000000o) {
                this.O000OO00.setColor(aud.f12618O000000o % 2 == 0 ? -65536 : -16776961);
                canvas.drawRect(rectF2, this.O000OO00);
            }
            canvas.translate(-f, -f2);
        }
    }
}
