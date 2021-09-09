package com.xiaomi.smarthome.library.common.widget;

import _m_j.gri;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Checkable;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.xiaomi.smarthome.R;

public class SingleWaveView extends View {

    /* renamed from: O000000o  reason: collision with root package name */
    int f9251O000000o = 0;
    int O00000Oo = 0;
    boolean O00000o = true;
    boolean O00000o0 = false;
    int O00000oO = 0;
    int O00000oo = 0;
    int O0000O0o = 0;
    long O0000OOo = 300;
    long O0000Oo = 16;
    long O0000Oo0 = 1200;
    long O0000OoO = 0;
    long O0000Ooo = 0;
    Paint O0000o0 = new Paint();
    long O0000o00 = 0;
    Handler O0000o0O = new Handler() {
        /* class com.xiaomi.smarthome.library.common.widget.SingleWaveView.AnonymousClass1 */

        public final void handleMessage(Message message) {
            int i = message.what;
            if (i == 1) {
                SingleWaveView.this.O0000o0O.sendEmptyMessage(2);
            } else if (i == 2) {
                SingleWaveView.this.invalidate();
                SingleWaveView.this.O0000o0O.sendEmptyMessageDelayed(2, SingleWaveView.this.O0000Oo);
            } else if (i == 3) {
                SingleWaveView singleWaveView = SingleWaveView.this;
                singleWaveView.O00000o = true;
                singleWaveView.O0000Ooo = System.currentTimeMillis();
                SingleWaveView.this.O0000o0O.sendEmptyMessageDelayed(4, SingleWaveView.this.O0000Oo0 - ((SingleWaveView.this.O0000Ooo - SingleWaveView.this.O0000OoO) % SingleWaveView.this.O0000OOo));
                SingleWaveView.this.invalidate();
            } else if (i == 4) {
                SingleWaveView singleWaveView2 = SingleWaveView.this;
                singleWaveView2.O00000o0 = false;
                singleWaveView2.O0000o0O.removeMessages(2);
                SingleWaveView.this.invalidate();
            }
        }
    };

    public SingleWaveView(Context context) {
        super(context);
        O000000o();
    }

    public SingleWaveView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        O000000o();
    }

    public SingleWaveView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        O000000o();
    }

    private void O000000o() {
        this.O0000o0.setAntiAlias(true);
        this.O0000o0.setStrokeWidth((float) gri.O000000o(1.0f));
        this.O0000o0.setStyle(Paint.Style.STROKE);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.O00000o0) {
            if (this.f9251O000000o == 0) {
                this.f9251O000000o = getMeasuredWidth();
            }
            if (this.O00000Oo == 0) {
                this.O00000Oo = getMeasuredHeight();
            }
            this.O0000o00 = System.currentTimeMillis();
            float sqrt = (float) Math.sqrt((double) (((float) (this.O0000o00 - this.O0000OoO)) / ((float) this.O0000Oo0)));
            if (sqrt >= 1.0f) {
                this.O0000OoO = System.currentTimeMillis();
                return;
            }
            int i = this.O00000oo;
            int i2 = this.O00000oO;
            float f = 1.0f - sqrt;
            this.O0000o0.setColor(((((int) (255.0f * f)) & 255) << 24) | this.O0000O0o);
            this.O0000o0.setAlpha((int) (f * 100.0f));
            canvas.drawCircle(((float) this.f9251O000000o) / 2.0f, ((float) this.O00000Oo) / 2.0f, (float) ((int) ((((float) (i - i2)) * sqrt) + ((float) i2))), this.O0000o0);
        }
    }

    public static class DeletableTextView extends TextView implements Checkable {
        private static final int[] CHECK_STATE = {16842912};
        private boolean isChecked;
        private boolean isDeletable = true;
        private Rect mBounds;
        private Context mContext;
        private Drawable mDrawableRight;
        private O000000o mOnTextClearListener;

        public interface O000000o {
        }

        public DeletableTextView(Context context) {
            super(context);
            initialize(context);
        }

        public DeletableTextView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            initialize(context);
        }

        private void initialize(Context context) {
            this.mContext = context;
            this.mDrawableRight = this.mContext.getResources().getDrawable(R.drawable.mijia_icon_delete_selector);
            Drawable drawable = this.mDrawableRight;
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), this.mDrawableRight.getMinimumWidth());
            setCompoundDrawables(null, null, this.mDrawableRight, null);
            setClickable(true);
            setMinWidth(gri.O000000o(70.0f));
            setMinHeight(gri.O000000o(30.0f));
            setGravity(17);
            setPadding(8, 8, 8, 8);
            setCompoundDrawablePadding(8);
            setBackgroundResource(R.drawable.mijia_button_bg_sec);
            setTextColor(getResources().getColor(R.color.mj_color_white));
            setTextSize(13.0f);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(gri.O000000o(4.0f), 0, 0, gri.O000000o(11.0f));
            setLayoutParams(layoutParams);
        }

        public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
            if (drawable3 != null) {
                this.mDrawableRight = drawable3;
            }
            super.setCompoundDrawables(drawable, drawable2, this.mDrawableRight, drawable4);
        }

        public void setDeletable(boolean z) {
            this.isDeletable = z;
            if (z) {
                setBackgroundResource(R.drawable.mijia_button_bg_add);
                setCompoundDrawables(null, null, this.mDrawableRight, null);
                return;
            }
            setBackgroundResource(R.drawable.mijia_button_bg_sec);
            super.setCompoundDrawables(null, null, null, null);
        }

        public boolean onTouchEvent(MotionEvent motionEvent) {
            Drawable drawable;
            if (motionEvent.getAction() == 0) {
                this.mBounds = this.mDrawableRight.getBounds();
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                if (x < (getWidth() - this.mBounds.width()) - getPaddingLeft() || x > getWidth() - getPaddingRight() || y < getPaddingTop() || y > getHeight() - getPaddingBottom()) {
                    return false;
                }
            }
            if (motionEvent.getAction() == 1 && (drawable = this.mDrawableRight) != null) {
                this.mBounds = drawable.getBounds();
                int x2 = (int) motionEvent.getX();
                int y2 = (int) motionEvent.getY();
                if (x2 >= (getWidth() - this.mBounds.width()) - getPaddingLeft() && x2 <= getWidth() - getPaddingRight() && y2 >= getPaddingTop() && y2 <= getHeight() - getPaddingBottom()) {
                    clear();
                    motionEvent.setAction(3);
                }
            }
            return super.onTouchEvent(motionEvent);
        }

        private void clear() {
            super.setCompoundDrawables(null, null, null, null);
        }

        public void setOnTextClearListener(O000000o o000000o) {
            this.mOnTextClearListener = o000000o;
        }

        /* access modifiers changed from: protected */
        public void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            this.mContext = null;
        }

        /* access modifiers changed from: protected */
        public void onAttachedToWindow() {
            super.onAttachedToWindow();
            this.mContext = getContext();
        }

        public void finalize() throws Throwable {
            this.mDrawableRight = null;
            this.mBounds = null;
            super.finalize();
        }

        public void setChecked(boolean z) {
            if (this.isChecked != z) {
                this.isChecked = z;
                refreshDrawableState();
            }
        }

        public boolean isChecked() {
            return this.isChecked;
        }

        public void toggle() {
            setChecked(!this.isChecked);
        }
    }
}
