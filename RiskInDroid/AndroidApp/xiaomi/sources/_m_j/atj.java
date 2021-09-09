package _m_j;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.PointF;
import android.view.animation.DecelerateInterpolator;
import android.widget.OverScroller;
import com.github.barteksc.pdfviewer.PDFView;

public final class atj {

    /* renamed from: O000000o  reason: collision with root package name */
    public PDFView f12594O000000o;
    public OverScroller O00000Oo;
    public boolean O00000o = false;
    public boolean O00000o0 = false;
    private ValueAnimator O00000oO;

    public atj(PDFView pDFView) {
        this.f12594O000000o = pDFView;
        this.O00000Oo = new OverScroller(pDFView.getContext());
    }

    public final void O000000o(float f, float f2) {
        O000000o();
        this.O00000oO = ValueAnimator.ofFloat(f, f2);
        O000000o o000000o = new O000000o();
        this.O00000oO.setInterpolator(new DecelerateInterpolator());
        this.O00000oO.addUpdateListener(o000000o);
        this.O00000oO.addListener(o000000o);
        this.O00000oO.setDuration(400L);
        this.O00000oO.start();
    }

    public final void O00000Oo(float f, float f2) {
        O000000o();
        this.O00000oO = ValueAnimator.ofFloat(f, f2);
        O00000Oo o00000Oo = new O00000Oo();
        this.O00000oO.setInterpolator(new DecelerateInterpolator());
        this.O00000oO.addUpdateListener(o00000Oo);
        this.O00000oO.addListener(o00000Oo);
        this.O00000oO.setDuration(400L);
        this.O00000oO.start();
    }

    public final void O000000o(float f, float f2, float f3, float f4) {
        O000000o();
        this.O00000oO = ValueAnimator.ofFloat(f3, f4);
        this.O00000oO.setInterpolator(new DecelerateInterpolator());
        O00000o0 o00000o0 = new O00000o0(f, f2);
        this.O00000oO.addUpdateListener(o00000o0);
        this.O00000oO.addListener(o00000o0);
        this.O00000oO.setDuration(400L);
        this.O00000oO.start();
    }

    public final void O000000o(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        O000000o();
        this.O00000o0 = true;
        this.O00000Oo.fling(i, i2, i3, i4, i5, i6, i7, i8);
    }

    public final void O000000o() {
        ValueAnimator valueAnimator = this.O00000oO;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.O00000oO = null;
        }
        O00000Oo();
    }

    public final void O00000Oo() {
        this.O00000o0 = false;
        this.O00000Oo.forceFinished(true);
    }

    class O000000o extends AnimatorListenerAdapter implements ValueAnimator.AnimatorUpdateListener {
        O000000o() {
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: com.github.barteksc.pdfviewer.PDFView.O000000o(float, float, boolean):void
         arg types: [float, float, int]
         candidates:
          com.github.barteksc.pdfviewer.PDFView.O000000o(android.graphics.Canvas, int, _m_j.att):void
          com.github.barteksc.pdfviewer.PDFView.O000000o(float, float, float):void
          com.github.barteksc.pdfviewer.PDFView.O000000o(_m_j.auf, java.lang.String, int[]):void
          com.github.barteksc.pdfviewer.PDFView.O000000o(float, float, boolean):void */
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            atj.this.f12594O000000o.O000000o(((Float) valueAnimator.getAnimatedValue()).floatValue(), atj.this.f12594O000000o.getCurrentYOffset(), true);
            atj.this.f12594O000000o.O00000o0();
        }

        public final void onAnimationCancel(Animator animator) {
            atj.this.f12594O000000o.O00000Oo();
            atj.this.O00000o = false;
        }

        public final void onAnimationEnd(Animator animator) {
            atj.this.f12594O000000o.O00000Oo();
            atj.this.O00000o = false;
        }
    }

    class O00000Oo extends AnimatorListenerAdapter implements ValueAnimator.AnimatorUpdateListener {
        O00000Oo() {
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: com.github.barteksc.pdfviewer.PDFView.O000000o(float, float, boolean):void
         arg types: [float, float, int]
         candidates:
          com.github.barteksc.pdfviewer.PDFView.O000000o(android.graphics.Canvas, int, _m_j.att):void
          com.github.barteksc.pdfviewer.PDFView.O000000o(float, float, float):void
          com.github.barteksc.pdfviewer.PDFView.O000000o(_m_j.auf, java.lang.String, int[]):void
          com.github.barteksc.pdfviewer.PDFView.O000000o(float, float, boolean):void */
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            atj.this.f12594O000000o.O000000o(atj.this.f12594O000000o.getCurrentXOffset(), ((Float) valueAnimator.getAnimatedValue()).floatValue(), true);
            atj.this.f12594O000000o.O00000o0();
        }

        public final void onAnimationCancel(Animator animator) {
            atj.this.f12594O000000o.O00000Oo();
            atj.this.O00000o = false;
        }

        public final void onAnimationEnd(Animator animator) {
            atj.this.f12594O000000o.O00000Oo();
            atj.this.O00000o = false;
        }
    }

    class O00000o0 implements Animator.AnimatorListener, ValueAnimator.AnimatorUpdateListener {
        private final float O00000Oo;
        private final float O00000o0;

        public final void onAnimationCancel(Animator animator) {
        }

        public final void onAnimationRepeat(Animator animator) {
        }

        public final void onAnimationStart(Animator animator) {
        }

        public O00000o0(float f, float f2) {
            this.O00000Oo = f;
            this.O00000o0 = f2;
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            atj.this.f12594O000000o.O000000o(((Float) valueAnimator.getAnimatedValue()).floatValue(), new PointF(this.O00000Oo, this.O00000o0));
        }

        public final void onAnimationEnd(Animator animator) {
            atj.this.f12594O000000o.O00000Oo();
            atj.this.O00000o0();
            atj.this.f12594O000000o.O00000o();
        }
    }

    public final void O00000o0() {
        if (this.f12594O000000o.getScrollHandle() != null) {
            this.f12594O000000o.getScrollHandle().O00000Oo();
        }
    }
}
