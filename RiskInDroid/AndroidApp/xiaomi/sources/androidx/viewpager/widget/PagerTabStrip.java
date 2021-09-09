package androidx.viewpager.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.core.content.ContextCompat;

public class PagerTabStrip extends PagerTitleStrip {
    private int O0000O0o;
    private int O0000OOo;
    private int O0000Oo;
    private int O0000Oo0;
    private int O0000OoO;
    private int O0000Ooo;
    private boolean O0000o;
    private final Rect O0000o0;
    private final Paint O0000o00;
    private int O0000o0O;
    private boolean O0000o0o;
    private boolean O0000oO;
    private int O0000oO0;
    private float O0000oOO;
    private float O0000oOo;
    private int O0000oo0;

    public PagerTabStrip(Context context) {
        this(context, null);
    }

    public PagerTabStrip(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.O0000o00 = new Paint();
        this.O0000o0 = new Rect();
        this.O0000o0O = 255;
        this.O0000o0o = false;
        this.O0000o = false;
        this.O0000O0o = this.O00000oo;
        this.O0000o00.setColor(this.O0000O0o);
        float f = context.getResources().getDisplayMetrics().density;
        this.O0000OOo = (int) ((3.0f * f) + 0.5f);
        this.O0000Oo0 = (int) ((6.0f * f) + 0.5f);
        this.O0000Oo = (int) (64.0f * f);
        this.O0000Ooo = (int) ((16.0f * f) + 0.5f);
        this.O0000oO0 = (int) ((1.0f * f) + 0.5f);
        this.O0000OoO = (int) ((f * 32.0f) + 0.5f);
        this.O0000oo0 = ViewConfiguration.get(context).getScaledTouchSlop();
        setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom());
        setTextSpacing(getTextSpacing());
        setWillNotDraw(false);
        this.O00000Oo.setFocusable(true);
        this.O00000Oo.setOnClickListener(new View.OnClickListener() {
            /* class androidx.viewpager.widget.PagerTabStrip.AnonymousClass1 */

            public final void onClick(View view) {
                PagerTabStrip.this.f3029O000000o.setCurrentItem(PagerTabStrip.this.f3029O000000o.getCurrentItem() - 1);
            }
        });
        this.O00000o.setFocusable(true);
        this.O00000o.setOnClickListener(new View.OnClickListener() {
            /* class androidx.viewpager.widget.PagerTabStrip.AnonymousClass2 */

            public final void onClick(View view) {
                PagerTabStrip.this.f3029O000000o.setCurrentItem(PagerTabStrip.this.f3029O000000o.getCurrentItem() + 1);
            }
        });
        if (getBackground() == null) {
            this.O0000o0o = true;
        }
    }

    public void setTabIndicatorColor(int i) {
        this.O0000O0o = i;
        this.O0000o00.setColor(this.O0000O0o);
        invalidate();
    }

    public void setTabIndicatorColorResource(int i) {
        setTabIndicatorColor(ContextCompat.O00000o0(getContext(), i));
    }

    public int getTabIndicatorColor() {
        return this.O0000O0o;
    }

    public void setPadding(int i, int i2, int i3, int i4) {
        int i5 = this.O0000Oo0;
        if (i4 < i5) {
            i4 = i5;
        }
        super.setPadding(i, i2, i3, i4);
    }

    public void setTextSpacing(int i) {
        int i2 = this.O0000Oo;
        if (i < i2) {
            i = i2;
        }
        super.setTextSpacing(i);
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (!this.O0000o) {
            this.O0000o0o = drawable == null;
        }
    }

    public void setBackgroundColor(int i) {
        super.setBackgroundColor(i);
        if (!this.O0000o) {
            this.O0000o0o = (i & -16777216) == 0;
        }
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (!this.O0000o) {
            this.O0000o0o = i == 0;
        }
    }

    public void setDrawFullUnderline(boolean z) {
        this.O0000o0o = z;
        this.O0000o = true;
        invalidate();
    }

    public boolean getDrawFullUnderline() {
        return this.O0000o0o;
    }

    /* access modifiers changed from: package-private */
    public int getMinHeight() {
        return Math.max(super.getMinHeight(), this.O0000OoO);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0 && this.O0000oO) {
            return false;
        }
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        if (action == 0) {
            this.O0000oOO = x;
            this.O0000oOo = y;
            this.O0000oO = false;
        } else if (action != 1) {
            if (action == 2 && (Math.abs(x - this.O0000oOO) > ((float) this.O0000oo0) || Math.abs(y - this.O0000oOo) > ((float) this.O0000oo0))) {
                this.O0000oO = true;
            }
        } else if (x < ((float) (this.O00000o0.getLeft() - this.O0000Ooo))) {
            this.f3029O000000o.setCurrentItem(this.f3029O000000o.getCurrentItem() - 1);
        } else if (x > ((float) (this.O00000o0.getRight() + this.O0000Ooo))) {
            this.f3029O000000o.setCurrentItem(this.f3029O000000o.getCurrentItem() + 1);
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int height = getHeight();
        int left = this.O00000o0.getLeft() - this.O0000Ooo;
        int right = this.O00000o0.getRight() + this.O0000Ooo;
        this.O0000o00.setColor((this.O0000o0O << 24) | (this.O0000O0o & 16777215));
        float f = (float) height;
        canvas.drawRect((float) left, (float) (height - this.O0000OOo), (float) right, f, this.O0000o00);
        if (this.O0000o0o) {
            this.O0000o00.setColor(-16777216 | (this.O0000O0o & 16777215));
            canvas.drawRect((float) getPaddingLeft(), (float) (height - this.O0000oO0), (float) (getWidth() - getPaddingRight()), f, this.O0000o00);
        }
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(int i, float f, boolean z) {
        Rect rect = this.O0000o0;
        int height = getHeight();
        int left = this.O00000o0.getLeft() - this.O0000Ooo;
        int right = this.O00000o0.getRight() + this.O0000Ooo;
        int i2 = height - this.O0000OOo;
        rect.set(left, i2, right, height);
        super.O000000o(i, f, z);
        this.O0000o0O = (int) (Math.abs(f - 0.5f) * 2.0f * 255.0f);
        rect.union(this.O00000o0.getLeft() - this.O0000Ooo, i2, this.O00000o0.getRight() + this.O0000Ooo, height);
        invalidate(rect);
    }
}
