package androidx.appcompat.widget;

import _m_j.OO00O0o;
import _m_j.OOO00o;
import _m_j.Oo;
import _m_j.cb;
import _m_j.ce;
import _m_j.o00;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.view.menu.MenuBuilder;
import com.xiaomi.smarthome.R;

public class ActionBarContextView extends OOO00o {
    public boolean O0000O0o;
    private CharSequence O0000OOo;
    private View O0000Oo;
    private CharSequence O0000Oo0;
    private View O0000OoO;
    private LinearLayout O0000Ooo;
    private int O0000o;
    private TextView O0000o0;
    private TextView O0000o00;
    private int O0000o0O;
    private int O0000o0o;

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public final /* bridge */ /* synthetic */ ce O000000o(int i, long j) {
        return super.O000000o(i, j);
    }

    public /* bridge */ /* synthetic */ int getAnimatedVisibility() {
        return super.getAnimatedVisibility();
    }

    public /* bridge */ /* synthetic */ int getContentHeight() {
        return super.getContentHeight();
    }

    public /* bridge */ /* synthetic */ boolean onHoverEvent(MotionEvent motionEvent) {
        return super.onHoverEvent(motionEvent);
    }

    public /* bridge */ /* synthetic */ boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public /* bridge */ /* synthetic */ void setVisibility(int i) {
        super.setVisibility(i);
    }

    public ActionBarContextView(Context context) {
        this(context, null);
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.actionModeStyle);
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Oo O000000o2 = Oo.O000000o(context, attributeSet, new int[]{R.attr.background, R.attr.backgroundSplit, R.attr.closeItemLayout, R.attr.height, R.attr.subtitleTextStyle, R.attr.titleTextStyle}, i, 0);
        cb.O000000o(this, O000000o2.O000000o(0));
        this.O0000o0O = O000000o2.O0000O0o(5, 0);
        this.O0000o0o = O000000o2.O0000O0o(4, 0);
        this.O00000oO = O000000o2.O00000oo(3, 0);
        this.O0000o = O000000o2.O0000O0o(2, R.layout.abc_action_mode_close_item_material);
        O000000o2.f12340O000000o.recycle();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.O00000o != null) {
            this.O00000o.O00000o();
            this.O00000o.O00000oo();
        }
    }

    public void setContentHeight(int i) {
        this.O00000oO = i;
    }

    public void setCustomView(View view) {
        LinearLayout linearLayout;
        View view2 = this.O0000OoO;
        if (view2 != null) {
            removeView(view2);
        }
        this.O0000OoO = view;
        if (!(view == null || (linearLayout = this.O0000Ooo) == null)) {
            removeView(linearLayout);
            this.O0000Ooo = null;
        }
        if (view != null) {
            addView(view);
        }
        requestLayout();
    }

    public void setTitle(CharSequence charSequence) {
        this.O0000OOo = charSequence;
        O00000o();
    }

    public void setSubtitle(CharSequence charSequence) {
        this.O0000Oo0 = charSequence;
        O00000o();
    }

    public CharSequence getTitle() {
        return this.O0000OOo;
    }

    public CharSequence getSubtitle() {
        return this.O0000Oo0;
    }

    private void O00000o() {
        if (this.O0000Ooo == null) {
            LayoutInflater.from(getContext()).inflate((int) R.layout.abc_action_bar_title_item, this);
            this.O0000Ooo = (LinearLayout) getChildAt(getChildCount() - 1);
            this.O0000o00 = (TextView) this.O0000Ooo.findViewById(R.id.action_bar_title);
            this.O0000o0 = (TextView) this.O0000Ooo.findViewById(R.id.action_bar_subtitle);
            if (this.O0000o0O != 0) {
                this.O0000o00.setTextAppearance(getContext(), this.O0000o0O);
            }
            if (this.O0000o0o != 0) {
                this.O0000o0.setTextAppearance(getContext(), this.O0000o0o);
            }
        }
        this.O0000o00.setText(this.O0000OOo);
        this.O0000o0.setText(this.O0000Oo0);
        boolean z = !TextUtils.isEmpty(this.O0000OOo);
        boolean z2 = !TextUtils.isEmpty(this.O0000Oo0);
        int i = 0;
        this.O0000o0.setVisibility(z2 ? 0 : 8);
        LinearLayout linearLayout = this.O0000Ooo;
        if (!z && !z2) {
            i = 8;
        }
        linearLayout.setVisibility(i);
        if (this.O0000Ooo.getParent() == null) {
            addView(this.O0000Ooo);
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [int, androidx.appcompat.widget.ActionBarContextView, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public final void O000000o(final OO00O0o oO00O0o) {
        View view = this.O0000Oo;
        if (view == null) {
            this.O0000Oo = LayoutInflater.from(getContext()).inflate(this.O0000o, (ViewGroup) this, false);
            addView(this.O0000Oo);
        } else if (view.getParent() == null) {
            addView(this.O0000Oo);
        }
        this.O0000Oo.findViewById(R.id.action_mode_close_button).setOnClickListener(new View.OnClickListener() {
            /* class androidx.appcompat.widget.ActionBarContextView.AnonymousClass1 */

            public final void onClick(View view) {
                oO00O0o.O00000o0();
            }
        });
        MenuBuilder menuBuilder = (MenuBuilder) oO00O0o.O00000Oo();
        if (this.O00000o != null) {
            this.O00000o.O00000oO();
        }
        this.O00000o = new ActionMenuPresenter(getContext());
        this.O00000o.O00000Oo();
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-2, -1);
        menuBuilder.addMenuPresenter(this.O00000o, this.O00000Oo);
        this.O00000o0 = (ActionMenuView) this.O00000o.O000000o(this);
        cb.O000000o(this.O00000o0, (Drawable) null);
        addView(this.O00000o0, layoutParams);
    }

    public final void O00000Oo() {
        if (this.O0000Oo == null) {
            O00000o0();
        }
    }

    public final void O00000o0() {
        removeAllViews();
        this.O0000OoO = null;
        this.O00000o0 = null;
    }

    public final boolean O000000o() {
        if (this.O00000o != null) {
            return this.O00000o.O00000o0();
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-1, -2);
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int i3 = 1073741824;
        if (View.MeasureSpec.getMode(i) != 1073741824) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with android:layout_width=\"match_parent\" (or fill_parent)");
        } else if (View.MeasureSpec.getMode(i2) != 0) {
            int size = View.MeasureSpec.getSize(i);
            int size2 = this.O00000oO > 0 ? this.O00000oO : View.MeasureSpec.getSize(i2);
            int paddingTop = getPaddingTop() + getPaddingBottom();
            int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
            int i4 = size2 - paddingTop;
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i4, Integer.MIN_VALUE);
            View view = this.O0000Oo;
            if (view != null) {
                int O000000o2 = O000000o(view, paddingLeft, makeMeasureSpec);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.O0000Oo.getLayoutParams();
                paddingLeft = O000000o2 - (marginLayoutParams.leftMargin + marginLayoutParams.rightMargin);
            }
            if (this.O00000o0 != null && this.O00000o0.getParent() == this) {
                paddingLeft = O000000o(this.O00000o0, paddingLeft, makeMeasureSpec);
            }
            LinearLayout linearLayout = this.O0000Ooo;
            if (linearLayout != null && this.O0000OoO == null) {
                if (this.O0000O0o) {
                    this.O0000Ooo.measure(View.MeasureSpec.makeMeasureSpec(0, 0), makeMeasureSpec);
                    int measuredWidth = this.O0000Ooo.getMeasuredWidth();
                    boolean z = measuredWidth <= paddingLeft;
                    if (z) {
                        paddingLeft -= measuredWidth;
                    }
                    this.O0000Ooo.setVisibility(z ? 0 : 8);
                } else {
                    paddingLeft = O000000o(linearLayout, paddingLeft, makeMeasureSpec);
                }
            }
            View view2 = this.O0000OoO;
            if (view2 != null) {
                ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                int i5 = layoutParams.width != -2 ? 1073741824 : Integer.MIN_VALUE;
                if (layoutParams.width >= 0) {
                    paddingLeft = Math.min(layoutParams.width, paddingLeft);
                }
                if (layoutParams.height == -2) {
                    i3 = Integer.MIN_VALUE;
                }
                if (layoutParams.height >= 0) {
                    i4 = Math.min(layoutParams.height, i4);
                }
                this.O0000OoO.measure(View.MeasureSpec.makeMeasureSpec(paddingLeft, i5), View.MeasureSpec.makeMeasureSpec(i4, i3));
            }
            if (this.O00000oO <= 0) {
                int childCount = getChildCount();
                int i6 = 0;
                for (int i7 = 0; i7 < childCount; i7++) {
                    int measuredHeight = getChildAt(i7).getMeasuredHeight() + paddingTop;
                    if (measuredHeight > i6) {
                        i6 = measuredHeight;
                    }
                }
                setMeasuredDimension(size, i6);
                return;
            }
            setMeasuredDimension(size, size2);
        } else {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with android:layout_height=\"wrap_content\"");
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        boolean O000000o2 = o00.O000000o(this);
        int paddingRight = O000000o2 ? (i3 - i) - getPaddingRight() : getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingTop2 = ((i4 - i2) - getPaddingTop()) - getPaddingBottom();
        View view = this.O0000Oo;
        if (!(view == null || view.getVisibility() == 8)) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.O0000Oo.getLayoutParams();
            int i5 = O000000o2 ? marginLayoutParams.rightMargin : marginLayoutParams.leftMargin;
            int i6 = O000000o2 ? marginLayoutParams.leftMargin : marginLayoutParams.rightMargin;
            int O000000o3 = O000000o(paddingRight, i5, O000000o2);
            paddingRight = O000000o(O000000o3 + O000000o(this.O0000Oo, O000000o3, paddingTop, paddingTop2, O000000o2), i6, O000000o2);
        }
        LinearLayout linearLayout = this.O0000Ooo;
        if (!(linearLayout == null || this.O0000OoO != null || linearLayout.getVisibility() == 8)) {
            paddingRight += O000000o(this.O0000Ooo, paddingRight, paddingTop, paddingTop2, O000000o2);
        }
        View view2 = this.O0000OoO;
        if (view2 != null) {
            O000000o(view2, paddingRight, paddingTop, paddingTop2, O000000o2);
        }
        int paddingLeft = O000000o2 ? getPaddingLeft() : (i3 - i) - getPaddingRight();
        if (this.O00000o0 != null) {
            O000000o(this.O00000o0, paddingLeft, paddingTop, paddingTop2, !O000000o2);
        }
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (accessibilityEvent.getEventType() == 32) {
            accessibilityEvent.setSource(this);
            accessibilityEvent.setClassName(getClass().getName());
            accessibilityEvent.setPackageName(getContext().getPackageName());
            accessibilityEvent.setContentDescription(this.O0000OOo);
            return;
        }
        super.onInitializeAccessibilityEvent(accessibilityEvent);
    }

    public void setTitleOptional(boolean z) {
        if (z != this.O0000O0o) {
            requestLayout();
        }
        this.O0000O0o = z;
    }
}
