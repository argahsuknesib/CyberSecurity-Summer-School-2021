package com.github.barteksc.pdfviewer.scroll;

import _m_j.aue;
import _m_j.auk;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.github.barteksc.pdfviewer.PDFView;
import com.xiaomi.smarthome.R;

public class DefaultScrollHandle extends RelativeLayout implements aue {

    /* renamed from: O000000o  reason: collision with root package name */
    protected TextView f3604O000000o;
    protected Context O00000Oo;
    private boolean O00000o;
    private float O00000o0;
    private PDFView O00000oO;
    private float O00000oo;
    private Handler O0000O0o;
    private Runnable O0000OOo;

    public DefaultScrollHandle(Context context) {
        this(context, (byte) 0);
    }

    private DefaultScrollHandle(Context context, byte b) {
        super(context);
        this.O00000o0 = 0.0f;
        this.O0000O0o = new Handler();
        this.O0000OOo = new Runnable() {
            /* class com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle.AnonymousClass1 */

            public final void run() {
                DefaultScrollHandle.this.setVisibility(4);
            }
        };
        this.O00000Oo = context;
        this.O00000o = false;
        this.f3604O000000o = new TextView(context);
        setVisibility(4);
        setTextColor(-16777216);
        setTextSize(16);
    }

    public final void O000000o() {
        this.O00000oO.removeView(this);
    }

    public void setScroll(float f) {
        if (!O00000o0()) {
            setVisibility(0);
        } else {
            this.O0000O0o.removeCallbacks(this.O0000OOo);
        }
        setPosition(((float) (this.O00000oO.O0000o ? this.O00000oO.getHeight() : this.O00000oO.getWidth())) * f);
    }

    private void setPosition(float f) {
        int i;
        float f2;
        int i2;
        float f3;
        if (!Float.isInfinite(f) && !Float.isNaN(f)) {
            if (this.O00000oO.O0000o) {
                i = this.O00000oO.getHeight();
            } else {
                i = this.O00000oO.getWidth();
            }
            float f4 = (float) i;
            float f5 = f - this.O00000o0;
            if (f5 < 0.0f) {
                f5 = 0.0f;
            } else if (f5 > f4 - ((float) auk.O000000o(this.O00000Oo, 40))) {
                f5 = f4 - ((float) auk.O000000o(this.O00000Oo, 40));
            }
            if (this.O00000oO.O0000o) {
                setY(f5);
            } else {
                setX(f5);
            }
            if (this.O00000oO.O0000o) {
                f2 = getY();
                f3 = (float) getHeight();
                i2 = this.O00000oO.getHeight();
            } else {
                f2 = getX();
                f3 = (float) getWidth();
                i2 = this.O00000oO.getWidth();
            }
            this.O00000o0 = ((f2 + this.O00000o0) / ((float) i2)) * f3;
            invalidate();
        }
    }

    public final void O00000Oo() {
        this.O0000O0o.postDelayed(this.O0000OOo, 1000);
    }

    public void setPageNum(int i) {
        String valueOf = String.valueOf(i);
        if (!this.f3604O000000o.getText().equals(valueOf)) {
            this.f3604O000000o.setText(valueOf);
        }
    }

    public final boolean O00000o0() {
        return getVisibility() == 0;
    }

    public final void O00000o() {
        setVisibility(0);
    }

    public final void O00000oO() {
        setVisibility(4);
    }

    public void setTextColor(int i) {
        this.f3604O000000o.setTextColor(i);
    }

    public void setTextSize(int i) {
        this.f3604O000000o.setTextSize(1, (float) i);
    }

    public void setupLayout(PDFView pDFView) {
        Drawable drawable;
        int i;
        int i2 = 65;
        int i3 = 40;
        if (!pDFView.O0000o) {
            if (this.O00000o) {
                i = 10;
                drawable = ContextCompat.O000000o(this.O00000Oo, (int) R.drawable.default_scroll_handle_top);
            } else {
                i = 12;
                drawable = ContextCompat.O000000o(this.O00000Oo, (int) R.drawable.default_scroll_handle_bottom);
            }
            i2 = 40;
            i3 = 65;
        } else if (this.O00000o) {
            i = 9;
            drawable = ContextCompat.O000000o(this.O00000Oo, (int) R.drawable.default_scroll_handle_left);
        } else {
            i = 11;
            drawable = ContextCompat.O000000o(this.O00000Oo, (int) R.drawable.default_scroll_handle_right);
        }
        if (Build.VERSION.SDK_INT < 16) {
            setBackgroundDrawable(drawable);
        } else {
            setBackground(drawable);
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(auk.O000000o(this.O00000Oo, i2), auk.O000000o(this.O00000Oo, i3));
        layoutParams.setMargins(0, 0, 0, 0);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13, -1);
        addView(this.f3604O000000o, layoutParams2);
        layoutParams.addRule(i);
        pDFView.addView(this, layoutParams);
        this.O00000oO = pDFView;
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
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x008c  */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        PDFView pDFView = this.O00000oO;
        if (!(pDFView != null && pDFView.getPageCount() > 0 && !this.O00000oO.O00000oO())) {
            return super.onTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action != 2) {
                    if (action != 3) {
                        if (action != 5) {
                            if (action != 6) {
                                return super.onTouchEvent(motionEvent);
                            }
                        }
                    }
                }
                if (!this.O00000oO.O0000o) {
                    setPosition((motionEvent.getRawY() - this.O00000oo) + this.O00000o0);
                    this.O00000oO.O000000o(this.O00000o0 / ((float) getHeight()), false);
                } else {
                    setPosition((motionEvent.getRawX() - this.O00000oo) + this.O00000o0);
                    this.O00000oO.O000000o(this.O00000o0 / ((float) getWidth()), false);
                }
                return true;
            }
            O00000Oo();
            this.O00000oO.O00000o();
            return true;
        }
        this.O00000oO.O00000o.O00000Oo();
        this.O0000O0o.removeCallbacks(this.O0000OOo);
        if (this.O00000oO.O0000o) {
            this.O00000oo = motionEvent.getRawY() - getY();
        } else {
            this.O00000oo = motionEvent.getRawX() - getX();
        }
        if (!this.O00000oO.O0000o) {
        }
        return true;
    }
}
