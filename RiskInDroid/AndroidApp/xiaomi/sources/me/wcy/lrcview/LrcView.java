package me.wcy.lrcview;

import _m_j.izc;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.Scroller;
import com.xiaomi.smarthome.R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class LrcView extends View {

    /* renamed from: O000000o  reason: collision with root package name */
    public List<izc> f15385O000000o;
    public Drawable O00000Oo;
    public String O00000o;
    long O00000o0;
    public O000000o O00000oO;
    public Scroller O00000oo;
    public float O0000O0o;
    public int O0000OOo;
    public boolean O0000Oo;
    public boolean O0000Oo0;
    public boolean O0000OoO;
    public Runnable O0000Ooo;
    private int O0000o;
    private TextPaint O0000o0;
    private TextPaint O0000o00;
    private Paint.FontMetrics O0000o0O;
    private float O0000o0o;
    private int O0000oO;
    private int O0000oO0;
    private int O0000oOO;
    private int O0000oOo;
    private int O0000oo;
    private int O0000oo0;
    private float O0000ooO;
    private ValueAnimator O0000ooo;
    private GestureDetector.SimpleOnGestureListener O000O00o;
    private GestureDetector O00oOooO;
    private Object O00oOooo;

    public interface O000000o {
        boolean onPlayClick(long j);
    }

    public LrcView(Context context) {
        this(context, null);
    }

    public LrcView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LrcView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f15385O000000o = new ArrayList();
        this.O0000o00 = new TextPaint();
        this.O0000o0 = new TextPaint();
        this.O000O00o = new GestureDetector.SimpleOnGestureListener() {
            /* class me.wcy.lrcview.LrcView.AnonymousClass2 */

            public final boolean onDown(MotionEvent motionEvent) {
                if (!LrcView.this.O000000o() || LrcView.this.O00000oO == null) {
                    return super.onDown(motionEvent);
                }
                LrcView.this.O00000oo.forceFinished(true);
                LrcView lrcView = LrcView.this;
                lrcView.removeCallbacks(lrcView.O0000Ooo);
                LrcView lrcView2 = LrcView.this;
                lrcView2.O0000Oo = true;
                lrcView2.O0000Oo0 = true;
                lrcView2.invalidate();
                return true;
            }

            public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (!LrcView.this.O000000o()) {
                    return super.onScroll(motionEvent, motionEvent2, f, f2);
                }
                LrcView.this.O0000O0o += -f2;
                LrcView lrcView = LrcView.this;
                lrcView.O0000O0o = Math.min(lrcView.O0000O0o, LrcView.this.O000000o(0));
                LrcView lrcView2 = LrcView.this;
                float f3 = lrcView2.O0000O0o;
                LrcView lrcView3 = LrcView.this;
                lrcView2.O0000O0o = Math.max(f3, lrcView3.O000000o(lrcView3.f15385O000000o.size() - 1));
                LrcView.this.invalidate();
                return true;
            }

            public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (!LrcView.this.O000000o()) {
                    return super.onFling(motionEvent, motionEvent2, f, f2);
                }
                LrcView lrcView = LrcView.this;
                LrcView.this.O00000oo.fling(0, (int) LrcView.this.O0000O0o, 0, (int) f2, 0, 0, (int) lrcView.O000000o(lrcView.f15385O000000o.size() - 1), (int) LrcView.this.O000000o(0));
                LrcView.this.O0000OoO = true;
                return true;
            }

            public final boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                if (LrcView.this.O000000o() && LrcView.this.O0000Oo0 && LrcView.this.O00000Oo.getBounds().contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                    int centerLine = LrcView.this.getCenterLine();
                    long j = LrcView.this.f15385O000000o.get(centerLine).f1660O000000o;
                    if (LrcView.this.O00000oO != null && LrcView.this.O00000oO.onPlayClick(j)) {
                        LrcView lrcView = LrcView.this;
                        lrcView.O0000Oo0 = false;
                        lrcView.removeCallbacks(lrcView.O0000Ooo);
                        LrcView lrcView2 = LrcView.this;
                        lrcView2.O0000OOo = centerLine;
                        lrcView2.invalidate();
                        return true;
                    }
                }
                return super.onSingleTapConfirmed(motionEvent);
            }
        };
        this.O0000Ooo = new Runnable() {
            /* class me.wcy.lrcview.LrcView.AnonymousClass3 */

            public final void run() {
                if (LrcView.this.O000000o() && LrcView.this.O0000Oo0) {
                    LrcView lrcView = LrcView.this;
                    lrcView.O0000Oo0 = false;
                    lrcView.O000000o(lrcView.O0000OOo, lrcView.O00000o0);
                }
            }
        };
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, new int[]{R.attr.lrcAnimationDuration, R.attr.lrcCurrentTextColor, R.attr.lrcDividerHeight, R.attr.lrcLabel, R.attr.lrcNormalTextColor, R.attr.lrcPadding, R.attr.lrcPlayDrawable, R.attr.lrcTextSize, R.attr.lrcTimeTextColor, R.attr.lrcTimeTextSize, R.attr.lrcTimelineColor, R.attr.lrcTimelineHeight, R.attr.lrcTimelineTextColor});
        float dimension = obtainStyledAttributes.getDimension(7, getResources().getDimension(R.dimen.lrc_text_size));
        this.O0000o0o = obtainStyledAttributes.getDimension(2, getResources().getDimension(R.dimen.lrc_divider_height));
        int integer = getResources().getInteger(R.integer.lrc_animation_duration);
        this.O00000o0 = (long) obtainStyledAttributes.getInt(0, integer);
        long j = this.O00000o0;
        this.O00000o0 = j < 0 ? (long) integer : j;
        this.O0000o = obtainStyledAttributes.getColor(4, getResources().getColor(R.color.lrc_normal_text_color));
        this.O0000oO0 = obtainStyledAttributes.getColor(1, getResources().getColor(R.color.lrc_current_text_color));
        this.O0000oO = obtainStyledAttributes.getColor(12, getResources().getColor(R.color.lrc_timeline_text_color));
        this.O00000o = obtainStyledAttributes.getString(3);
        this.O00000o = TextUtils.isEmpty(this.O00000o) ? getContext().getString(R.string.lrc_label) : this.O00000o;
        this.O0000ooO = obtainStyledAttributes.getDimension(5, 0.0f);
        this.O0000oOO = obtainStyledAttributes.getColor(10, getResources().getColor(R.color.lrc_timeline_color));
        float dimension2 = obtainStyledAttributes.getDimension(11, getResources().getDimension(R.dimen.lrc_timeline_height));
        this.O00000Oo = obtainStyledAttributes.getDrawable(6);
        Drawable drawable = this.O00000Oo;
        this.O00000Oo = drawable == null ? getResources().getDrawable(R.drawable.lrc_play) : drawable;
        this.O0000oOo = obtainStyledAttributes.getColor(8, getResources().getColor(R.color.lrc_time_text_color));
        float dimension3 = obtainStyledAttributes.getDimension(9, getResources().getDimension(R.dimen.lrc_time_text_size));
        obtainStyledAttributes.recycle();
        this.O0000oo0 = (int) getResources().getDimension(R.dimen.lrc_drawable_width);
        this.O0000oo = (int) getResources().getDimension(R.dimen.lrc_time_width);
        this.O0000o00.setAntiAlias(true);
        this.O0000o00.setTextSize(dimension);
        this.O0000o00.setTextAlign(Paint.Align.LEFT);
        this.O0000o0.setAntiAlias(true);
        this.O0000o0.setTextSize(dimension3);
        this.O0000o0.setTextAlign(Paint.Align.CENTER);
        this.O0000o0.setStrokeWidth(dimension2);
        this.O0000o0.setStrokeCap(Paint.Cap.ROUND);
        this.O0000o0O = this.O0000o0.getFontMetrics();
        this.O00oOooO = new GestureDetector(getContext(), this.O000O00o);
        this.O00oOooO.setIsLongpressEnabled(false);
        this.O00000oo = new Scroller(getContext());
    }

    public void setNormalColor(int i) {
        this.O0000o = i;
        postInvalidate();
    }

    public void setCurrentColor(int i) {
        this.O0000oO0 = i;
        postInvalidate();
    }

    public void setTimelineTextColor(int i) {
        this.O0000oO = i;
        postInvalidate();
    }

    public void setTimelineColor(int i) {
        this.O0000oOO = i;
        postInvalidate();
    }

    public void setTimeTextColor(int i) {
        this.O0000oOo = i;
        postInvalidate();
    }

    public void setOnPlayClickListener(O000000o o000000o) {
        this.O00000oO = o000000o;
    }

    public void setLabel(final String str) {
        AnonymousClass1 r0 = new Runnable() {
            /* class me.wcy.lrcview.LrcView.AnonymousClass1 */

            public final void run() {
                LrcView lrcView = LrcView.this;
                lrcView.O00000o = str;
                lrcView.invalidate();
            }
        };
        if (Looper.myLooper() == Looper.getMainLooper()) {
            r0.run();
        } else {
            post(r0);
        }
    }

    public final boolean O000000o() {
        return !this.f15385O000000o.isEmpty();
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            if (O000000o() && getWidth() != 0) {
                Collections.sort(this.f15385O000000o);
                for (izc next : this.f15385O000000o) {
                    next.O00000o0 = new StaticLayout(next.O00000Oo, this.O0000o00, (int) getLrcWidth(), Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, false);
                }
                this.O0000O0o = (float) (getHeight() / 2);
            }
            int i5 = (this.O0000oo - this.O0000oo0) / 2;
            int i6 = this.O0000oo0;
            int height = (getHeight() / 2) - (i6 / 2);
            this.O00000Oo.setBounds(i5, height, i5 + i6, i6 + height);
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int height = getHeight() / 2;
        if (!O000000o()) {
            this.O0000o00.setColor(this.O0000oO0);
            O000000o(canvas, new StaticLayout(this.O00000o, this.O0000o00, (int) getLrcWidth(), Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, false), (float) height);
            return;
        }
        int centerLine = getCenterLine();
        if (this.O0000Oo0) {
            this.O00000Oo.draw(canvas);
            this.O0000o0.setColor(this.O0000oOO);
            float f = (float) height;
            canvas.drawLine((float) this.O0000oo, f, (float) (getWidth() - this.O0000oo), f, this.O0000o0);
            this.O0000o0.setColor(this.O0000oOo);
            long j = this.f15385O000000o.get(centerLine).f1660O000000o;
            int i = (int) ((j / 1000) % 60);
            String format = String.format(Locale.getDefault(), "%02d", Integer.valueOf((int) (j / 60000)));
            String format2 = String.format(Locale.getDefault(), "%02d", Integer.valueOf(i));
            canvas.drawText(format + ":" + format2, (float) (getWidth() - (this.O0000oo / 2)), f - ((this.O0000o0O.descent + this.O0000o0O.ascent) / 2.0f), this.O0000o0);
        }
        float f2 = 0.0f;
        canvas.translate(0.0f, this.O0000O0o);
        for (int i2 = 0; i2 < this.f15385O000000o.size(); i2++) {
            if (i2 > 0) {
                f2 += ((float) ((this.f15385O000000o.get(i2 - 1).O000000o() + this.f15385O000000o.get(i2).O000000o()) / 2)) + this.O0000o0o;
            }
            if (i2 == this.O0000OOo) {
                this.O0000o00.setColor(this.O0000oO0);
            } else if (!this.O0000Oo0 || i2 != centerLine) {
                this.O0000o00.setColor(this.O0000o);
            } else {
                this.O0000o00.setColor(this.O0000oO);
            }
            O000000o(canvas, this.f15385O000000o.get(i2).O00000o0, f2);
        }
    }

    private void O000000o(Canvas canvas, StaticLayout staticLayout, float f) {
        canvas.save();
        canvas.translate(this.O0000ooO, f - ((float) (staticLayout.getHeight() / 2)));
        staticLayout.draw(canvas);
        canvas.restore();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
            this.O0000Oo = false;
            if (O000000o() && !this.O0000OoO) {
                O00000Oo();
                postDelayed(this.O0000Ooo, 4000);
            }
        }
        return this.O00oOooO.onTouchEvent(motionEvent);
    }

    public void computeScroll() {
        if (this.O00000oo.computeScrollOffset()) {
            this.O0000O0o = (float) this.O00000oo.getCurrY();
            invalidate();
        }
        if (this.O0000OoO && this.O00000oo.isFinished()) {
            this.O0000OoO = false;
            if (O000000o() && !this.O0000Oo) {
                O00000Oo();
                postDelayed(this.O0000Ooo, 4000);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        removeCallbacks(this.O0000Ooo);
        super.onDetachedFromWindow();
    }

    private void O00000Oo() {
        O000000o(getCenterLine(), 100);
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(int i, long j) {
        float O000000o2 = O000000o(i);
        O00000o0();
        this.O0000ooo = ValueAnimator.ofFloat(this.O0000O0o, O000000o2);
        this.O0000ooo.setDuration(j);
        this.O0000ooo.setInterpolator(new LinearInterpolator());
        this.O0000ooo.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            /* class me.wcy.lrcview.LrcView.AnonymousClass4 */

            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                LrcView.this.O0000O0o = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                LrcView.this.invalidate();
            }
        });
        this.O0000ooo.start();
    }

    private void O00000o0() {
        ValueAnimator valueAnimator = this.O0000ooo;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.O0000ooo.end();
        }
    }

    public int getCenterLine() {
        int i = 0;
        float f = Float.MAX_VALUE;
        for (int i2 = 0; i2 < this.f15385O000000o.size(); i2++) {
            if (Math.abs(this.O0000O0o - O000000o(i2)) < f) {
                f = Math.abs(this.O0000O0o - O000000o(i2));
                i = i2;
            }
        }
        return i;
    }

    public final float O000000o(int i) {
        if (this.f15385O000000o.get(i).O00000o == Float.MIN_VALUE) {
            float height = (float) (getHeight() / 2);
            for (int i2 = 1; i2 <= i; i2++) {
                height -= ((float) ((this.f15385O000000o.get(i2 - 1).O000000o() + this.f15385O000000o.get(i2).O000000o()) / 2)) + this.O0000o0o;
            }
            this.f15385O000000o.get(i).O00000o = height;
        }
        return this.f15385O000000o.get(i).O00000o;
    }

    private float getLrcWidth() {
        return ((float) getWidth()) - (this.O0000ooO * 2.0f);
    }

    public Object getFlag() {
        return this.O00oOooo;
    }

    public void setFlag(Object obj) {
        this.O00oOooo = obj;
    }
}
