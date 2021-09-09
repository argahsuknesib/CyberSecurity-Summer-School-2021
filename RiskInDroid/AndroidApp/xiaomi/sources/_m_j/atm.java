package _m_j;

import _m_j.auh;
import _m_j.dbj;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.RectF;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import com.github.barteksc.pdfviewer.PDFView;
import com.shockwave.pdfium.PdfiumCore;
import java.util.Iterator;

public final class atm implements GestureDetector.OnDoubleTapListener, GestureDetector.OnGestureListener, ScaleGestureDetector.OnScaleGestureListener, View.OnTouchListener {

    /* renamed from: O000000o  reason: collision with root package name */
    public boolean f12601O000000o = false;
    private PDFView O00000Oo;
    private GestureDetector O00000o;
    private atj O00000o0;
    private ScaleGestureDetector O00000oO;
    private boolean O00000oo = false;
    private boolean O0000O0o = false;

    public final boolean onDoubleTapEvent(MotionEvent motionEvent) {
        return false;
    }

    public final void onLongPress(MotionEvent motionEvent) {
    }

    public final void onShowPress(MotionEvent motionEvent) {
    }

    public final boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    public atm(PDFView pDFView, atj atj) {
        this.O00000Oo = pDFView;
        this.O00000o0 = atj;
        this.O00000o = new GestureDetector(pDFView.getContext(), this);
        this.O00000oO = new ScaleGestureDetector(pDFView.getContext(), this);
        pDFView.setOnTouchListener(this);
    }

    public final boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        boolean z;
        int i;
        int i2;
        boolean z2;
        boolean z3;
        aue scrollHandle;
        ats ats = this.O00000Oo.O0000o0O;
        if (ats.O0000Oo0 != null) {
            ats.O0000Oo0.O000000o(motionEvent);
            z = true;
        } else {
            z = false;
        }
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        ato ato = this.O00000Oo.O00000oo;
        float f = (-this.O00000Oo.getCurrentXOffset()) + x;
        float f2 = (-this.O00000Oo.getCurrentYOffset()) + y;
        int O000000o2 = ato.O000000o(this.O00000Oo.O0000o ? f2 : f, this.O00000Oo.getZoom());
        dbk O000000o3 = ato.O000000o(O000000o2, this.O00000Oo.getZoom());
        if (this.O00000Oo.O0000o) {
            i2 = (int) ato.O00000o(O000000o2, this.O00000Oo.getZoom());
            i = (int) ato.O00000o0(O000000o2, this.O00000Oo.getZoom());
        } else {
            i = (int) ato.O00000o(O000000o2, this.O00000Oo.getZoom());
            i2 = (int) ato.O00000o0(O000000o2, this.O00000Oo.getZoom());
        }
        Iterator<dbj.O00000Oo> it = ato.O00000Oo.O00000o0(ato.f12605O000000o, ato.O00000o(O000000o2)).iterator();
        while (true) {
            if (!it.hasNext()) {
                z2 = z;
                z3 = false;
                break;
            }
            dbj.O00000Oo next = it.next();
            int i3 = (int) O000000o3.f14452O000000o;
            RectF rectF = next.f14450O000000o;
            int O00000o2 = ato.O00000o(O000000o2);
            PdfiumCore pdfiumCore = ato.O00000Oo;
            int i4 = O000000o2;
            dbj dbj = ato.f12605O000000o;
            ato ato2 = ato;
            z2 = z;
            dbk dbk = O000000o3;
            float f3 = x;
            float f4 = y;
            double d = (double) rectF.top;
            PdfiumCore pdfiumCore2 = pdfiumCore;
            int i5 = i3;
            dbj dbj2 = dbj;
            dbj.O00000Oo o00000Oo = next;
            int i6 = O00000o2;
            int i7 = i2;
            int i8 = i;
            int i9 = i5;
            int i10 = (int) O000000o3.O00000Oo;
            Point O000000o4 = pdfiumCore2.O000000o(dbj2, i6, i7, i8, i9, i10, 0, (double) rectF.left, d);
            Point O000000o5 = pdfiumCore2.O000000o(dbj2, i6, i7, i8, i9, i10, 0, (double) rectF.right, (double) rectF.bottom);
            RectF rectF2 = new RectF((float) O000000o4.x, (float) O000000o4.y, (float) O000000o5.x, (float) O000000o5.y);
            rectF2.sort();
            if (rectF2.contains(f, f2)) {
                ats ats2 = this.O00000Oo.O0000o0O;
                auc auc = new auc(f3, f4, f, f2, rectF2, o00000Oo);
                if (ats2.O0000OoO != null) {
                    ats2.O0000OoO.O000000o(auc);
                }
                z3 = true;
            } else {
                O000000o2 = i4;
                ato = ato2;
                z = z2;
                O000000o3 = dbk;
                x = f3;
                y = f4;
            }
        }
        if (!z2 && !z3 && (scrollHandle = this.O00000Oo.getScrollHandle()) != null && !this.O00000Oo.O00000oO()) {
            if (!scrollHandle.O00000o0()) {
                scrollHandle.O00000o();
            } else {
                scrollHandle.O00000oO();
            }
        }
        this.O00000Oo.performClick();
        return true;
    }

    public final boolean onDoubleTap(MotionEvent motionEvent) {
        if (!this.O00000Oo.O0000oO) {
            return false;
        }
        if (this.O00000Oo.getZoom() < this.O00000Oo.getMidZoom()) {
            this.O00000Oo.O000000o(motionEvent.getX(), motionEvent.getY(), this.O00000Oo.getMidZoom());
            return true;
        } else if (this.O00000Oo.getZoom() < this.O00000Oo.getMaxZoom()) {
            this.O00000Oo.O000000o(motionEvent.getX(), motionEvent.getY(), this.O00000Oo.getMaxZoom());
            return true;
        } else {
            PDFView pDFView = this.O00000Oo;
            pDFView.O00000o.O000000o((float) (pDFView.getWidth() / 2), (float) (pDFView.getHeight() / 2), pDFView.O0000Oo, pDFView.O00000Oo);
            return true;
        }
    }

    public final boolean onDown(MotionEvent motionEvent) {
        this.O00000o0.O00000Oo();
        return true;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.github.barteksc.pdfviewer.PDFView.O000000o(float, float, boolean):void
     arg types: [float, float, int]
     candidates:
      com.github.barteksc.pdfviewer.PDFView.O000000o(android.graphics.Canvas, int, _m_j.att):void
      com.github.barteksc.pdfviewer.PDFView.O000000o(float, float, float):void
      com.github.barteksc.pdfviewer.PDFView.O000000o(_m_j.auf, java.lang.String, int[]):void
      com.github.barteksc.pdfviewer.PDFView.O000000o(float, float, boolean):void */
    public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        this.O00000oo = true;
        PDFView pDFView = this.O00000Oo;
        if ((pDFView.O0000Oo != pDFView.O00000Oo) || this.O00000Oo.O0000oO0) {
            PDFView pDFView2 = this.O00000Oo;
            pDFView2.O000000o(pDFView2.O0000OOo + (-f), pDFView2.O0000Oo0 + (-f2), true);
        }
        if (!this.O0000O0o || this.O00000Oo.O0000ooO) {
            this.O00000Oo.O00000o0();
        }
        return true;
    }

    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        int i;
        float f3;
        float f4;
        float f5;
        float f6;
        float f7;
        float f8;
        float f9 = f;
        float f10 = f2;
        if (!this.O00000Oo.O0000oO0) {
            return false;
        }
        if (this.O00000Oo.O00oOooo) {
            PDFView pDFView = this.O00000Oo;
            float f11 = -pDFView.O00000oo.O00000o0(pDFView.O0000O0o, pDFView.O0000Oo);
            float O00000Oo2 = f11 - pDFView.O00000oo.O00000Oo(pDFView.O0000O0o, pDFView.O0000Oo);
            boolean z = !pDFView.O0000o ? !(f11 <= pDFView.O0000OOo || O00000Oo2 >= pDFView.O0000OOo - ((float) pDFView.getWidth())) : !(f11 <= pDFView.O0000Oo0 || O00000Oo2 >= pDFView.O0000Oo0 - ((float) pDFView.getHeight()));
            float f12 = 0.0f;
            if (z) {
                int currentXOffset = (int) this.O00000Oo.getCurrentXOffset();
                int currentYOffset = (int) this.O00000Oo.getCurrentYOffset();
                ato ato = this.O00000Oo.O00000oo;
                float f13 = -ato.O00000o0(this.O00000Oo.getCurrentPage(), this.O00000Oo.getZoom());
                float O00000Oo3 = f13 - ato.O00000Oo(this.O00000Oo.getCurrentPage(), this.O00000Oo.getZoom());
                if (this.O00000Oo.O0000o) {
                    f8 = -((ato.O000000o().f14452O000000o * this.O00000Oo.O0000Oo) - ((float) this.O00000Oo.getWidth()));
                    f7 = O00000Oo3 + ((float) this.O00000Oo.getHeight());
                    f12 = f13;
                    f13 = 0.0f;
                } else {
                    float width = O00000Oo3 + ((float) this.O00000Oo.getWidth());
                    f7 = -((ato.O000000o().O00000Oo * this.O00000Oo.O0000Oo) - ((float) this.O00000Oo.getHeight()));
                    f8 = width;
                }
                this.O00000o0.O000000o(currentXOffset, currentYOffset, (int) f9, (int) f10, (int) f8, (int) f13, (int) f7, (int) f12);
            } else {
                float abs = Math.abs(f);
                float abs2 = Math.abs(f2);
                if (!this.O00000Oo.O0000o ? abs > abs2 : abs2 > abs) {
                    int i2 = -1;
                    if (!this.O00000Oo.O0000o ? f9 <= 0.0f : f10 <= 0.0f) {
                        i2 = 1;
                    }
                    if (this.O00000Oo.O0000o) {
                        f6 = motionEvent2.getY();
                        f5 = motionEvent.getY();
                    } else {
                        f6 = motionEvent2.getX();
                        f5 = motionEvent.getX();
                    }
                    float f14 = f6 - f5;
                    int max = Math.max(0, Math.min(this.O00000Oo.getPageCount() - 1, this.O00000Oo.O000000o(this.O00000Oo.getCurrentXOffset() - (this.O00000Oo.getZoom() * f14), this.O00000Oo.getCurrentYOffset() - (f14 * this.O00000Oo.getZoom())) + i2));
                    float O000000o2 = this.O00000Oo.O000000o(max, this.O00000Oo.O00000Oo(max));
                    atj atj = this.O00000o0;
                    float f15 = -O000000o2;
                    if (atj.f12594O000000o.O0000o) {
                        atj.O00000Oo(atj.f12594O000000o.getCurrentYOffset(), f15);
                    } else {
                        atj.O000000o(atj.f12594O000000o.getCurrentXOffset(), f15);
                    }
                    atj.O00000o = true;
                }
            }
            return true;
        }
        int currentXOffset2 = (int) this.O00000Oo.getCurrentXOffset();
        int currentYOffset2 = (int) this.O00000Oo.getCurrentYOffset();
        ato ato2 = this.O00000Oo.O00000oo;
        if (this.O00000Oo.O0000o) {
            f3 = -((ato2.O000000o().f14452O000000o * this.O00000Oo.O0000Oo) - ((float) this.O00000Oo.getWidth()));
            f4 = ato2.O00000oO * this.O00000Oo.getZoom();
            i = this.O00000Oo.getHeight();
        } else {
            f3 = -((ato2.O00000oO * this.O00000Oo.getZoom()) - ((float) this.O00000Oo.getWidth()));
            f4 = ato2.O000000o().O00000Oo * this.O00000Oo.O0000Oo;
            i = this.O00000Oo.getHeight();
        }
        this.O00000o0.O000000o(currentXOffset2, currentYOffset2, (int) f9, (int) f10, (int) f3, 0, (int) (-(f4 - ((float) i))), 0);
        return true;
    }

    public final boolean onScale(ScaleGestureDetector scaleGestureDetector) {
        float f;
        float zoom;
        float scaleFactor = scaleGestureDetector.getScaleFactor();
        float zoom2 = this.O00000Oo.getZoom() * scaleFactor;
        if (zoom2 < auh.O00000Oo.O00000Oo) {
            f = auh.O00000Oo.O00000Oo;
            zoom = this.O00000Oo.getZoom();
        } else {
            if (zoom2 > auh.O00000Oo.f12622O000000o) {
                f = auh.O00000Oo.f12622O000000o;
                zoom = this.O00000Oo.getZoom();
            }
            PDFView pDFView = this.O00000Oo;
            pDFView.O000000o(pDFView.O0000Oo * scaleFactor, new PointF(scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY()));
            return true;
        }
        scaleFactor = f / zoom;
        PDFView pDFView2 = this.O00000Oo;
        pDFView2.O000000o(pDFView2.O0000Oo * scaleFactor, new PointF(scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY()));
        return true;
    }

    public final boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
        this.O0000O0o = true;
        return true;
    }

    public final void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
        this.O00000Oo.O00000Oo();
        O000000o();
        this.O0000O0o = false;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z = false;
        if (!this.f12601O000000o) {
            return false;
        }
        boolean z2 = this.O00000o.onTouchEvent(motionEvent) || this.O00000oO.onTouchEvent(motionEvent);
        if (motionEvent.getAction() == 1 && this.O00000oo) {
            this.O00000oo = false;
            this.O00000Oo.O00000Oo();
            O000000o();
            atj atj = this.O00000o0;
            if (atj.O00000o0 || atj.O00000o) {
                z = true;
            }
            if (!z) {
                this.O00000Oo.O00000o();
            }
        }
        return z2;
    }

    private void O000000o() {
        aue scrollHandle = this.O00000Oo.getScrollHandle();
        if (scrollHandle != null && scrollHandle.O00000o0()) {
            scrollHandle.O00000Oo();
        }
    }
}
