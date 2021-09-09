package _m_j;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.ActionMenuPresenter;
import androidx.appcompat.widget.ActionMenuView;
import com.xiaomi.smarthome.R;

public abstract class OOO00o extends ViewGroup {

    /* renamed from: O000000o  reason: collision with root package name */
    protected final O000000o f12313O000000o;
    protected final Context O00000Oo;
    protected ActionMenuPresenter O00000o;
    protected ActionMenuView O00000o0;
    protected int O00000oO;
    protected ce O00000oo;
    private boolean O0000O0o;
    private boolean O0000OOo;

    protected static int O000000o(int i, int i2, boolean z) {
        return z ? i - i2 : i + i2;
    }

    OOO00o(Context context) {
        this(context, null);
    }

    OOO00o(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    protected OOO00o(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f12313O000000o = new O000000o();
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(R.attr.actionBarPopupTheme, typedValue, true) || typedValue.resourceId == 0) {
            this.O00000Oo = context;
        } else {
            this.O00000Oo = new ContextThemeWrapper(context, typedValue.resourceId);
        }
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(null, new int[]{R.attr.background, R.attr.backgroundSplit, R.attr.backgroundStacked, R.attr.contentInsetEnd, R.attr.contentInsetEndWithActions, R.attr.contentInsetLeft, R.attr.contentInsetRight, R.attr.contentInsetStart, R.attr.contentInsetStartWithNavigation, R.attr.customNavigationLayout, R.attr.displayOptions, R.attr.divider, R.attr.elevation, R.attr.height, R.attr.hideOnContentScroll, R.attr.homeAsUpIndicator, R.attr.homeLayout, R.attr.icon, R.attr.indeterminateProgressStyle, R.attr.itemPadding, R.attr.logo, R.attr.navigationMode, R.attr.popupTheme, R.attr.progressBarPadding, R.attr.progressBarStyle, R.attr.subtitle, R.attr.subtitleTextStyle, R.attr.title, R.attr.titleTextStyle}, R.attr.actionBarStyle, 0);
        setContentHeight(obtainStyledAttributes.getLayoutDimension(13, 0));
        obtainStyledAttributes.recycle();
        ActionMenuPresenter actionMenuPresenter = this.O00000o;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.O000000o();
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.O0000O0o = false;
        }
        if (!this.O0000O0o) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !onTouchEvent) {
                this.O0000O0o = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.O0000O0o = false;
        }
        return true;
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.O0000OOo = false;
        }
        if (!this.O0000OOo) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !onHoverEvent) {
                this.O0000OOo = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.O0000OOo = false;
        }
        return true;
    }

    public void setContentHeight(int i) {
        this.O00000oO = i;
        requestLayout();
    }

    public int getContentHeight() {
        return this.O00000oO;
    }

    public int getAnimatedVisibility() {
        if (this.O00000oo != null) {
            return this.f12313O000000o.f12314O000000o;
        }
        return getVisibility();
    }

    public ce O000000o(int i, long j) {
        ce ceVar = this.O00000oo;
        if (ceVar != null) {
            ceVar.O00000Oo();
        }
        if (i == 0) {
            if (getVisibility() != 0) {
                setAlpha(0.0f);
            }
            ce O000000o2 = cb.O0000o(this).O000000o(1.0f);
            O000000o2.O000000o(j);
            O000000o2.O000000o(this.f12313O000000o.O000000o(O000000o2, i));
            return O000000o2;
        }
        ce O000000o3 = cb.O0000o(this).O000000o(0.0f);
        O000000o3.O000000o(j);
        O000000o3.O000000o(this.f12313O000000o.O000000o(O000000o3, i));
        return O000000o3;
    }

    public void setVisibility(int i) {
        if (i != getVisibility()) {
            ce ceVar = this.O00000oo;
            if (ceVar != null) {
                ceVar.O00000Oo();
            }
            super.setVisibility(i);
        }
    }

    public boolean O000000o() {
        ActionMenuPresenter actionMenuPresenter = this.O00000o;
        if (actionMenuPresenter != null) {
            return actionMenuPresenter.O00000o0();
        }
        return false;
    }

    protected static int O000000o(View view, int i, int i2) {
        view.measure(View.MeasureSpec.makeMeasureSpec(i, Integer.MIN_VALUE), i2);
        return Math.max(0, (i - view.getMeasuredWidth()) - 0);
    }

    protected static int O000000o(View view, int i, int i2, int i3, boolean z) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i4 = i2 + ((i3 - measuredHeight) / 2);
        if (z) {
            view.layout(i - measuredWidth, i4, i, measuredHeight + i4);
        } else {
            view.layout(i, i4, i + measuredWidth, measuredHeight + i4);
        }
        return z ? -measuredWidth : measuredWidth;
    }

    public class O000000o implements cf {

        /* renamed from: O000000o  reason: collision with root package name */
        int f12314O000000o;
        private boolean O00000o0 = false;

        protected O000000o() {
        }

        public final O000000o O000000o(ce ceVar, int i) {
            OOO00o.this.O00000oo = ceVar;
            this.f12314O000000o = i;
            return this;
        }

        public final void O000000o(View view) {
            OOO00o.super.setVisibility(0);
            this.O00000o0 = false;
        }

        public final void O00000Oo(View view) {
            if (!this.O00000o0) {
                OOO00o oOO00o = OOO00o.this;
                oOO00o.O00000oo = null;
                OOO00o.super.setVisibility(this.f12314O000000o);
            }
        }

        public final void O00000o0(View view) {
            this.O00000o0 = true;
        }
    }
}
