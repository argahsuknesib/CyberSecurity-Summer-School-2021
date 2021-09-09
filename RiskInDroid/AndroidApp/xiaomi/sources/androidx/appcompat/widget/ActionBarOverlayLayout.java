package androidx.appcompat.widget;

import _m_j.OO0o000;
import _m_j.OOOOO00;
import _m_j.OOOOO0o;
import _m_j.bs;
import _m_j.bt;
import _m_j.bu;
import _m_j.bv;
import _m_j.cb;
import _m_j.ci;
import _m_j.o00;
import _m_j.r;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.view.WindowInsets;
import android.widget.OverScroller;
import com.xiaomi.smarthome.R;

@SuppressLint({"UnknownNullness"})
public class ActionBarOverlayLayout extends ViewGroup implements OOOOO00, bs, bt, bu {
    static final int[] O00000oo = {R.attr.actionBarSize, 16842841};

    /* renamed from: O000000o  reason: collision with root package name */
    ActionBarContainer f2684O000000o;
    public boolean O00000Oo;
    ViewPropertyAnimator O00000o;
    boolean O00000o0;
    final AnimatorListenerAdapter O00000oO;
    private int O0000O0o;
    private int O0000OOo;
    private OOOOO0o O0000Oo;
    private ContentFrameLayout O0000Oo0;
    private Drawable O0000OoO;
    private boolean O0000Ooo;
    private final Rect O0000o;
    private boolean O0000o0;
    private boolean O0000o00;
    private int O0000o0O;
    private int O0000o0o;
    private final Rect O0000oO;
    private final Rect O0000oO0;
    private final Rect O0000oOO;
    private final Rect O0000oOo;
    private final Rect O0000oo;
    private final Rect O0000oo0;
    private ci O0000ooO;
    private ci O0000ooo;
    private O000000o O000O00o;
    private OverScroller O000O0OO;
    private final Runnable O000O0Oo;
    private final bv O000O0o0;
    private final Runnable O00oOoOo;
    private ci O00oOooO;
    private ci O00oOooo;

    public interface O000000o {
        void O00000Oo(int i);

        void O00000oO(boolean z);

        void O0000Ooo();

        void O0000o0();

        void O0000o00();
    }

    public boolean onNestedPreFling(View view, float f, float f2) {
        return false;
    }

    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
    }

    public void setShowingForActionMode(boolean z) {
    }

    public void setUiOptions(int i) {
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public ActionBarOverlayLayout(Context context) {
        this(context, null);
    }

    public ActionBarOverlayLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.O0000OOo = 0;
        this.O0000o = new Rect();
        this.O0000oO0 = new Rect();
        this.O0000oO = new Rect();
        this.O0000oOO = new Rect();
        this.O0000oOo = new Rect();
        this.O0000oo0 = new Rect();
        this.O0000oo = new Rect();
        this.O0000ooO = ci.f13874O000000o;
        this.O0000ooo = ci.f13874O000000o;
        this.O00oOooO = ci.f13874O000000o;
        this.O00oOooo = ci.f13874O000000o;
        this.O00000oO = new AnimatorListenerAdapter() {
            /* class androidx.appcompat.widget.ActionBarOverlayLayout.AnonymousClass1 */

            public final void onAnimationEnd(Animator animator) {
                ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
                actionBarOverlayLayout.O00000o = null;
                actionBarOverlayLayout.O00000o0 = false;
            }

            public final void onAnimationCancel(Animator animator) {
                ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
                actionBarOverlayLayout.O00000o = null;
                actionBarOverlayLayout.O00000o0 = false;
            }
        };
        this.O000O0Oo = new Runnable() {
            /* class androidx.appcompat.widget.ActionBarOverlayLayout.AnonymousClass2 */

            public final void run() {
                ActionBarOverlayLayout.this.O000000o();
                ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
                actionBarOverlayLayout.O00000o = actionBarOverlayLayout.f2684O000000o.animate().translationY(0.0f).setListener(ActionBarOverlayLayout.this.O00000oO);
            }
        };
        this.O00oOoOo = new Runnable() {
            /* class androidx.appcompat.widget.ActionBarOverlayLayout.AnonymousClass3 */

            public final void run() {
                ActionBarOverlayLayout.this.O000000o();
                ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
                actionBarOverlayLayout.O00000o = actionBarOverlayLayout.f2684O000000o.animate().translationY((float) (-ActionBarOverlayLayout.this.f2684O000000o.getHeight())).setListener(ActionBarOverlayLayout.this.O00000oO);
            }
        };
        O000000o(context);
        this.O000O0o0 = new bv();
    }

    private void O000000o(Context context) {
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(O00000oo);
        boolean z = false;
        this.O0000O0o = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.O0000OoO = obtainStyledAttributes.getDrawable(1);
        setWillNotDraw(this.O0000OoO == null);
        obtainStyledAttributes.recycle();
        if (context.getApplicationInfo().targetSdkVersion < 19) {
            z = true;
        }
        this.O0000Ooo = z;
        this.O000O0OO = new OverScroller(context);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        O000000o();
    }

    public void setActionBarVisibilityCallback(O000000o o000000o) {
        this.O000O00o = o000000o;
        if (getWindowToken() != null) {
            this.O000O00o.O00000Oo(this.O0000OOo);
            int i = this.O0000o0o;
            if (i != 0) {
                onWindowSystemUiVisibilityChanged(i);
                cb.O0000ooO(this);
            }
        }
    }

    public void setOverlayMode(boolean z) {
        this.O00000Oo = z;
        this.O0000Ooo = z && getContext().getApplicationInfo().targetSdkVersion < 19;
    }

    public void setHasNonEmbeddedTabs(boolean z) {
        this.O0000o00 = z;
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        O000000o(getContext());
        cb.O0000ooO(this);
    }

    public void onWindowSystemUiVisibilityChanged(int i) {
        if (Build.VERSION.SDK_INT >= 16) {
            super.onWindowSystemUiVisibilityChanged(i);
        }
        O0000Oo0();
        int i2 = this.O0000o0o ^ i;
        this.O0000o0o = i;
        boolean z = false;
        boolean z2 = (i & 4) == 0;
        if ((i & 256) != 0) {
            z = true;
        }
        O000000o o000000o = this.O000O00o;
        if (o000000o != null) {
            o000000o.O00000oO(!z);
            if (z2 || !z) {
                this.O000O00o.O0000Ooo();
            } else {
                this.O000O00o.O0000o00();
            }
        }
        if ((i2 & 256) != 0 && this.O000O00o != null) {
            cb.O0000ooO(this);
        }
    }

    /* access modifiers changed from: protected */
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        this.O0000OOo = i;
        O000000o o000000o = this.O000O00o;
        if (o000000o != null) {
            o000000o.O00000Oo(i);
        }
    }

    private static boolean O000000o(View view, Rect rect, boolean z) {
        boolean z2;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (layoutParams.leftMargin != rect.left) {
            layoutParams.leftMargin = rect.left;
            z2 = true;
        } else {
            z2 = false;
        }
        if (layoutParams.topMargin != rect.top) {
            layoutParams.topMargin = rect.top;
            z2 = true;
        }
        if (layoutParams.rightMargin != rect.right) {
            layoutParams.rightMargin = rect.right;
            z2 = true;
        }
        if (!z || layoutParams.bottomMargin == rect.bottom) {
            return z2;
        }
        layoutParams.bottomMargin = rect.bottom;
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean fitSystemWindows(Rect rect) {
        if (Build.VERSION.SDK_INT >= 21) {
            return super.fitSystemWindows(rect);
        }
        O0000Oo0();
        boolean O000000o2 = O000000o(this.f2684O000000o, rect, false);
        this.O0000oOO.set(rect);
        o00.O000000o(this, this.O0000oOO, this.O0000o);
        if (!this.O0000oOo.equals(this.O0000oOO)) {
            this.O0000oOo.set(this.O0000oOO);
            O000000o2 = true;
        }
        if (!this.O0000oO0.equals(this.O0000o)) {
            this.O0000oO0.set(this.O0000o);
            O000000o2 = true;
        }
        if (O000000o2) {
            requestLayout();
        }
        return true;
    }

    public WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        O0000Oo0();
        ci O000000o2 = ci.O000000o(windowInsets);
        boolean O000000o3 = O000000o(this.f2684O000000o, new Rect(O000000o2.O00000Oo.O0000O0o().O00000Oo, O000000o2.O00000Oo.O0000O0o().O00000o0, O000000o2.O00000Oo.O0000O0o().O00000o, O000000o2.O00000Oo.O0000O0o().O00000oO), false);
        cb.O000000o(this, O000000o2, this.O0000o);
        this.O0000ooO = O000000o2.O00000Oo(this.O0000o.left, this.O0000o.top, this.O0000o.right, this.O0000o.bottom);
        if (!this.O0000ooo.equals(this.O0000ooO)) {
            this.O0000ooo = this.O0000ooO;
            O000000o3 = true;
        }
        if (!this.O0000oO0.equals(this.O0000o)) {
            this.O0000oO0.set(this.O0000o);
            O000000o3 = true;
        }
        if (O000000o3) {
            requestLayout();
        }
        return O000000o2.O00000Oo.O00000oo().O00000Oo.O00000o0().O00000Oo.O00000o().O00000oO();
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int i3;
        O0000Oo0();
        measureChildWithMargins(this.f2684O000000o, i, 0, i2, 0);
        LayoutParams layoutParams = (LayoutParams) this.f2684O000000o.getLayoutParams();
        int max = Math.max(0, this.f2684O000000o.getMeasuredWidth() + layoutParams.leftMargin + layoutParams.rightMargin);
        int max2 = Math.max(0, this.f2684O000000o.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin);
        int combineMeasuredStates = View.combineMeasuredStates(0, this.f2684O000000o.getMeasuredState());
        boolean z = (cb.O0000oo(this) & 256) != 0;
        if (z) {
            i3 = this.O0000O0o;
            if (this.O0000o00 && this.f2684O000000o.getTabContainer() != null) {
                i3 += this.O0000O0o;
            }
        } else {
            i3 = this.f2684O000000o.getVisibility() != 8 ? this.f2684O000000o.getMeasuredHeight() : 0;
        }
        this.O0000oO.set(this.O0000o);
        if (Build.VERSION.SDK_INT >= 21) {
            this.O00oOooO = this.O0000ooO;
        } else {
            this.O0000oo0.set(this.O0000oOO);
        }
        if (!this.O00000Oo && !z) {
            this.O0000oO.top += i3;
            this.O0000oO.bottom += 0;
            if (Build.VERSION.SDK_INT >= 21) {
                this.O00oOooO = this.O00oOooO.O00000Oo(0, i3, 0, 0);
            }
        } else if (Build.VERSION.SDK_INT >= 21) {
            this.O00oOooO = new ci.O000000o(this.O00oOooO).O000000o(r.O000000o(this.O00oOooO.O00000Oo.O0000O0o().O00000Oo, this.O00oOooO.O00000Oo.O0000O0o().O00000o0 + i3, this.O00oOooO.O00000Oo.O0000O0o().O00000o, this.O00oOooO.O00000Oo.O0000O0o().O00000oO + 0)).f13875O000000o.O000000o();
        } else {
            this.O0000oo0.top += i3;
            this.O0000oo0.bottom += 0;
        }
        O000000o(this.O0000Oo0, this.O0000oO, true);
        if (Build.VERSION.SDK_INT >= 21 && !this.O00oOooo.equals(this.O00oOooO)) {
            ci ciVar = this.O00oOooO;
            this.O00oOooo = ciVar;
            cb.O00000Oo(this.O0000Oo0, ciVar);
        } else if (Build.VERSION.SDK_INT < 21 && !this.O0000oo.equals(this.O0000oo0)) {
            this.O0000oo.set(this.O0000oo0);
            this.O0000Oo0.O000000o(this.O0000oo0);
        }
        measureChildWithMargins(this.O0000Oo0, i, 0, i2, 0);
        LayoutParams layoutParams2 = (LayoutParams) this.O0000Oo0.getLayoutParams();
        int max3 = Math.max(max, this.O0000Oo0.getMeasuredWidth() + layoutParams2.leftMargin + layoutParams2.rightMargin);
        int max4 = Math.max(max2, this.O0000Oo0.getMeasuredHeight() + layoutParams2.topMargin + layoutParams2.bottomMargin);
        int combineMeasuredStates2 = View.combineMeasuredStates(combineMeasuredStates, this.O0000Oo0.getMeasuredState());
        setMeasuredDimension(View.resolveSizeAndState(Math.max(max3 + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), i, combineMeasuredStates2), View.resolveSizeAndState(Math.max(max4 + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight()), i2, combineMeasuredStates2 << 16));
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                int i6 = layoutParams.leftMargin + paddingLeft;
                int i7 = layoutParams.topMargin + paddingTop;
                childAt.layout(i6, i7, measuredWidth + i6, measuredHeight + i7);
            }
        }
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.O0000OoO != null && !this.O0000Ooo) {
            int bottom = this.f2684O000000o.getVisibility() == 0 ? (int) (((float) this.f2684O000000o.getBottom()) + this.f2684O000000o.getTranslationY() + 0.5f) : 0;
            this.O0000OoO.setBounds(0, bottom, getWidth(), this.O0000OoO.getIntrinsicHeight() + bottom);
            this.O0000OoO.draw(canvas);
        }
    }

    public void onNestedScroll(View view, int i, int i2, int i3, int i4, int i5, int[] iArr) {
        onNestedScroll(view, i, i2, i3, i4, i5);
    }

    public boolean onStartNestedScroll(View view, View view2, int i, int i2) {
        return i2 == 0 && onStartNestedScroll(view, view2, i);
    }

    public void onNestedScrollAccepted(View view, View view2, int i, int i2) {
        if (i2 == 0) {
            onNestedScrollAccepted(view, view2, i);
        }
    }

    public void onStopNestedScroll(View view, int i) {
        if (i == 0) {
            onStopNestedScroll(view);
        }
    }

    public void onNestedScroll(View view, int i, int i2, int i3, int i4, int i5) {
        if (i5 == 0) {
            onNestedScroll(view, i, i2, i3, i4);
        }
    }

    public void onNestedPreScroll(View view, int i, int i2, int[] iArr, int i3) {
        if (i3 == 0) {
            onNestedPreScroll(view, i, i2, iArr);
        }
    }

    public boolean onStartNestedScroll(View view, View view2, int i) {
        if ((i & 2) == 0 || this.f2684O000000o.getVisibility() != 0) {
            return false;
        }
        return this.O0000o0;
    }

    public void onNestedScrollAccepted(View view, View view2, int i) {
        this.O000O0o0.O000000o(i, 0);
        this.O0000o0O = getActionBarHideOffset();
        O000000o();
        O000000o o000000o = this.O000O00o;
        if (o000000o != null) {
            o000000o.O0000o0();
        }
    }

    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        this.O0000o0O += i2;
        setActionBarHideOffset(this.O0000o0O);
    }

    public void onStopNestedScroll(View view) {
        if (this.O0000o0 && !this.O00000o0) {
            if (this.O0000o0O <= this.f2684O000000o.getHeight()) {
                O000000o();
                postDelayed(this.O000O0Oo, 600);
                return;
            }
            O000000o();
            postDelayed(this.O00oOoOo, 600);
        }
    }

    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        boolean z2 = false;
        if (!this.O0000o0 || !z) {
            return false;
        }
        this.O000O0OO.fling(0, 0, 0, (int) f2, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        if (this.O000O0OO.getFinalY() > this.f2684O000000o.getHeight()) {
            z2 = true;
        }
        if (z2) {
            O000000o();
            this.O00oOoOo.run();
        } else {
            O000000o();
            this.O000O0Oo.run();
        }
        this.O00000o0 = true;
        return true;
    }

    public int getNestedScrollAxes() {
        return this.O000O0o0.O000000o();
    }

    private void O0000Oo0() {
        if (this.O0000Oo0 == null) {
            this.O0000Oo0 = (ContentFrameLayout) findViewById(R.id.action_bar_activity_content);
            this.f2684O000000o = (ActionBarContainer) findViewById(R.id.action_bar_container);
            this.O0000Oo = O000000o(findViewById(R.id.action_bar));
        }
    }

    private static OOOOO0o O000000o(View view) {
        if (view instanceof OOOOO0o) {
            return (OOOOO0o) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        throw new IllegalStateException("Can't make a decor toolbar out of " + view.getClass().getSimpleName());
    }

    public void setHideOnContentScrollEnabled(boolean z) {
        if (z != this.O0000o0) {
            this.O0000o0 = z;
            if (!z) {
                O000000o();
                setActionBarHideOffset(0);
            }
        }
    }

    public int getActionBarHideOffset() {
        ActionBarContainer actionBarContainer = this.f2684O000000o;
        if (actionBarContainer != null) {
            return -((int) actionBarContainer.getTranslationY());
        }
        return 0;
    }

    public void setActionBarHideOffset(int i) {
        O000000o();
        this.f2684O000000o.setTranslationY((float) (-Math.max(0, Math.min(i, this.f2684O000000o.getHeight()))));
    }

    /* access modifiers changed from: package-private */
    public final void O000000o() {
        removeCallbacks(this.O000O0Oo);
        removeCallbacks(this.O00oOoOo);
        ViewPropertyAnimator viewPropertyAnimator = this.O00000o;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
        }
    }

    public void setWindowCallback(Window.Callback callback) {
        O0000Oo0();
        this.O0000Oo.O000000o(callback);
    }

    public void setWindowTitle(CharSequence charSequence) {
        O0000Oo0();
        this.O0000Oo.O000000o(charSequence);
    }

    public CharSequence getTitle() {
        O0000Oo0();
        return this.O0000Oo.O00000oO();
    }

    public final void O000000o(int i) {
        O0000Oo0();
        if (i == 2) {
            this.O0000Oo.O00000oo();
        } else if (i == 5) {
            this.O0000Oo.O0000O0o();
        } else if (i == 109) {
            setOverlayMode(true);
        }
    }

    public void setIcon(int i) {
        O0000Oo0();
        this.O0000Oo.O000000o(i);
    }

    public void setIcon(Drawable drawable) {
        O0000Oo0();
        this.O0000Oo.O000000o(drawable);
    }

    public void setLogo(int i) {
        O0000Oo0();
        this.O0000Oo.O00000Oo(i);
    }

    public final boolean O00000Oo() {
        O0000Oo0();
        return this.O0000Oo.O0000OOo();
    }

    public final boolean O00000o0() {
        O0000Oo0();
        return this.O0000Oo.O0000Oo0();
    }

    public final boolean O00000o() {
        O0000Oo0();
        return this.O0000Oo.O0000Oo();
    }

    public final boolean O00000oO() {
        O0000Oo0();
        return this.O0000Oo.O0000OoO();
    }

    public final boolean O00000oo() {
        O0000Oo0();
        return this.O0000Oo.O0000Ooo();
    }

    public final void O0000O0o() {
        O0000Oo0();
        this.O0000Oo.O0000o00();
    }

    public final void O000000o(Menu menu, OO0o000.O000000o o000000o) {
        O0000Oo0();
        this.O0000Oo.O000000o(menu, o000000o);
    }

    public final void O0000OOo() {
        O0000Oo0();
        this.O0000Oo.O0000o0();
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams() {
            super(-1, -1);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    /* access modifiers changed from: protected */
    public /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    public /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }
}
