package androidx.appcompat.widget;

import _m_j.OOO0O0O;
import _m_j.cb;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.xiaomi.smarthome.R;

public class ActionBarContainer extends FrameLayout {

    /* renamed from: O000000o  reason: collision with root package name */
    public Drawable f2682O000000o;
    public Drawable O00000Oo;
    public boolean O00000o;
    public Drawable O00000o0;
    public boolean O00000oO;
    private boolean O00000oo;
    private View O0000O0o;
    private View O0000OOo;
    private int O0000Oo;
    private View O0000Oo0;

    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback) {
        return null;
    }

    public ActionBarContainer(Context context) {
        this(context, null);
    }

    public ActionBarContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        cb.O000000o(this, new OOO0O0O(this));
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.background, R.attr.backgroundSplit, R.attr.backgroundStacked, R.attr.contentInsetEnd, R.attr.contentInsetEndWithActions, R.attr.contentInsetLeft, R.attr.contentInsetRight, R.attr.contentInsetStart, R.attr.contentInsetStartWithNavigation, R.attr.customNavigationLayout, R.attr.displayOptions, R.attr.divider, R.attr.elevation, R.attr.height, R.attr.hideOnContentScroll, R.attr.homeAsUpIndicator, R.attr.homeLayout, R.attr.icon, R.attr.indeterminateProgressStyle, R.attr.itemPadding, R.attr.logo, R.attr.navigationMode, R.attr.popupTheme, R.attr.progressBarPadding, R.attr.progressBarStyle, R.attr.subtitle, R.attr.subtitleTextStyle, R.attr.title, R.attr.titleTextStyle});
        boolean z = false;
        this.f2682O000000o = obtainStyledAttributes.getDrawable(0);
        this.O00000Oo = obtainStyledAttributes.getDrawable(2);
        this.O0000Oo = obtainStyledAttributes.getDimensionPixelSize(13, -1);
        if (getId() == R.id.split_action_bar) {
            this.O00000o = true;
            this.O00000o0 = obtainStyledAttributes.getDrawable(1);
        }
        obtainStyledAttributes.recycle();
        if (!this.O00000o ? this.f2682O000000o == null && this.O00000Oo == null : this.O00000o0 == null) {
            z = true;
        }
        setWillNotDraw(z);
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        this.O0000OOo = findViewById(R.id.action_bar);
        this.O0000Oo0 = findViewById(R.id.action_context_bar);
    }

    public void setPrimaryBackground(Drawable drawable) {
        Drawable drawable2 = this.f2682O000000o;
        if (drawable2 != null) {
            drawable2.setCallback(null);
            unscheduleDrawable(this.f2682O000000o);
        }
        this.f2682O000000o = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            View view = this.O0000OOo;
            if (view != null) {
                this.f2682O000000o.setBounds(view.getLeft(), this.O0000OOo.getTop(), this.O0000OOo.getRight(), this.O0000OOo.getBottom());
            }
        }
        boolean z = true;
        if (!this.O00000o ? !(this.f2682O000000o == null && this.O00000Oo == null) : this.O00000o0 != null) {
            z = false;
        }
        setWillNotDraw(z);
        invalidate();
        if (Build.VERSION.SDK_INT >= 21) {
            invalidateOutline();
        }
    }

    public void setStackedBackground(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.O00000Oo;
        if (drawable3 != null) {
            drawable3.setCallback(null);
            unscheduleDrawable(this.O00000Oo);
        }
        this.O00000Oo = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.O00000oO && (drawable2 = this.O00000Oo) != null) {
                drawable2.setBounds(this.O0000O0o.getLeft(), this.O0000O0o.getTop(), this.O0000O0o.getRight(), this.O0000O0o.getBottom());
            }
        }
        boolean z = true;
        if (!this.O00000o ? !(this.f2682O000000o == null && this.O00000Oo == null) : this.O00000o0 != null) {
            z = false;
        }
        setWillNotDraw(z);
        invalidate();
        if (Build.VERSION.SDK_INT >= 21) {
            invalidateOutline();
        }
    }

    public void setSplitBackground(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.O00000o0;
        if (drawable3 != null) {
            drawable3.setCallback(null);
            unscheduleDrawable(this.O00000o0);
        }
        this.O00000o0 = drawable;
        boolean z = false;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.O00000o && (drawable2 = this.O00000o0) != null) {
                drawable2.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            }
        }
        if (!this.O00000o ? this.f2682O000000o == null && this.O00000Oo == null : this.O00000o0 == null) {
            z = true;
        }
        setWillNotDraw(z);
        invalidate();
        if (Build.VERSION.SDK_INT >= 21) {
            invalidateOutline();
        }
    }

    public void setVisibility(int i) {
        super.setVisibility(i);
        boolean z = i == 0;
        Drawable drawable = this.f2682O000000o;
        if (drawable != null) {
            drawable.setVisible(z, false);
        }
        Drawable drawable2 = this.O00000Oo;
        if (drawable2 != null) {
            drawable2.setVisible(z, false);
        }
        Drawable drawable3 = this.O00000o0;
        if (drawable3 != null) {
            drawable3.setVisible(z, false);
        }
    }

    /* access modifiers changed from: protected */
    public boolean verifyDrawable(Drawable drawable) {
        if (drawable == this.f2682O000000o && !this.O00000o) {
            return true;
        }
        if (drawable != this.O00000Oo || !this.O00000oO) {
            return (drawable == this.O00000o0 && this.O00000o) || super.verifyDrawable(drawable);
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f2682O000000o;
        if (drawable != null && drawable.isStateful()) {
            this.f2682O000000o.setState(getDrawableState());
        }
        Drawable drawable2 = this.O00000Oo;
        if (drawable2 != null && drawable2.isStateful()) {
            this.O00000Oo.setState(getDrawableState());
        }
        Drawable drawable3 = this.O00000o0;
        if (drawable3 != null && drawable3.isStateful()) {
            this.O00000o0.setState(getDrawableState());
        }
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f2682O000000o;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.O00000Oo;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        Drawable drawable3 = this.O00000o0;
        if (drawable3 != null) {
            drawable3.jumpToCurrentState();
        }
    }

    public void setTransitioning(boolean z) {
        this.O00000oo = z;
        setDescendantFocusability(z ? 393216 : 262144);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.O00000oo || super.onInterceptTouchEvent(motionEvent);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        super.onHoverEvent(motionEvent);
        return true;
    }

    public void setTabContainer(ScrollingTabContainerView scrollingTabContainerView) {
        View view = this.O0000O0o;
        if (view != null) {
            removeView(view);
        }
        this.O0000O0o = scrollingTabContainerView;
        if (scrollingTabContainerView != null) {
            addView(scrollingTabContainerView);
            ViewGroup.LayoutParams layoutParams = scrollingTabContainerView.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -2;
            scrollingTabContainerView.setAllowCollapse(false);
        }
    }

    public View getTabContainer() {
        return this.O0000O0o;
    }

    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback, int i) {
        if (i != 0) {
            return super.startActionModeForChild(view, callback, i);
        }
        return null;
    }

    private static boolean O000000o(View view) {
        return view == null || view.getVisibility() == 8 || view.getMeasuredHeight() == 0;
    }

    private static int O00000Oo(View view) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        return view.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
    }

    public void onMeasure(int i, int i2) {
        int i3;
        int i4;
        if (this.O0000OOo == null && View.MeasureSpec.getMode(i2) == Integer.MIN_VALUE && (i4 = this.O0000Oo) >= 0) {
            i2 = View.MeasureSpec.makeMeasureSpec(Math.min(i4, View.MeasureSpec.getSize(i2)), Integer.MIN_VALUE);
        }
        super.onMeasure(i, i2);
        if (this.O0000OOo != null) {
            int mode = View.MeasureSpec.getMode(i2);
            View view = this.O0000O0o;
            if (view != null && view.getVisibility() != 8 && mode != 1073741824) {
                if (!O000000o(this.O0000OOo)) {
                    i3 = O00000Oo(this.O0000OOo);
                } else {
                    i3 = !O000000o(this.O0000Oo0) ? O00000Oo(this.O0000Oo0) : 0;
                }
                setMeasuredDimension(getMeasuredWidth(), Math.min(i3 + O00000Oo(this.O0000O0o), mode == Integer.MIN_VALUE ? View.MeasureSpec.getSize(i2) : Integer.MAX_VALUE));
            }
        }
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Drawable drawable;
        super.onLayout(z, i, i2, i3, i4);
        View view = this.O0000O0o;
        boolean z2 = true;
        boolean z3 = false;
        boolean z4 = (view == null || view.getVisibility() == 8) ? false : true;
        if (!(view == null || view.getVisibility() == 8)) {
            int measuredHeight = getMeasuredHeight();
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
            view.layout(i, (measuredHeight - view.getMeasuredHeight()) - layoutParams.bottomMargin, i3, measuredHeight - layoutParams.bottomMargin);
        }
        if (this.O00000o) {
            Drawable drawable2 = this.O00000o0;
            if (drawable2 != null) {
                drawable2.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            } else {
                z2 = false;
            }
        } else {
            if (this.f2682O000000o != null) {
                if (this.O0000OOo.getVisibility() == 0) {
                    this.f2682O000000o.setBounds(this.O0000OOo.getLeft(), this.O0000OOo.getTop(), this.O0000OOo.getRight(), this.O0000OOo.getBottom());
                } else {
                    View view2 = this.O0000Oo0;
                    if (view2 == null || view2.getVisibility() != 0) {
                        this.f2682O000000o.setBounds(0, 0, 0, 0);
                    } else {
                        this.f2682O000000o.setBounds(this.O0000Oo0.getLeft(), this.O0000Oo0.getTop(), this.O0000Oo0.getRight(), this.O0000Oo0.getBottom());
                    }
                }
                z3 = true;
            }
            this.O00000oO = z4;
            if (!z4 || (drawable = this.O00000Oo) == null) {
                z2 = z3;
            } else {
                drawable.setBounds(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            }
        }
        if (z2) {
            invalidate();
        }
    }
}
