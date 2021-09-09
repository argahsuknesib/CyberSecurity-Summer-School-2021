package com.xiaomi.smarthome.scene.widget;

import _m_j.hrn;
import _m_j.hro;
import _m_j.hrp;
import _m_j.hrq;
import _m_j.hrr;
import _m_j.hrs;
import _m_j.hrt;
import android.content.Context;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.scene.widget.ObservableHorizontalScrollView;
import java.util.ArrayList;
import java.util.List;

public class CommonNavigator extends FrameLayout implements hrq, hrs.O000000o {

    /* renamed from: O000000o  reason: collision with root package name */
    public hrn f11324O000000o;
    public hrs O00000Oo = new hrs();
    public ObservableHorizontalScrollView.O000000o O00000o = null;
    public boolean O00000o0 = true;
    private ObservableHorizontalScrollView O00000oO;
    private CutOffLinearLayout O00000oo;
    private LinearLayout O0000O0o;
    private hrp O0000OOo;
    private boolean O0000Oo;
    private boolean O0000Oo0;
    private boolean O0000OoO;
    private float O0000Ooo = 0.5f;
    private boolean O0000o;
    private boolean O0000o0 = true;
    private boolean O0000o00 = true;
    private int O0000o0O;
    private int O0000o0o;
    private boolean O0000oO = true;
    private boolean O0000oO0;
    private List<hrt> O0000oOO = new ArrayList();
    private DataSetObserver O0000oOo = new DataSetObserver() {
        /* class com.xiaomi.smarthome.scene.widget.CommonNavigator.AnonymousClass1 */

        public final void onInvalidated() {
        }

        public final void onChanged() {
            CommonNavigator commonNavigator = CommonNavigator.this;
            commonNavigator.O00000o0 = true;
            commonNavigator.O00000Oo.O00000Oo(CommonNavigator.this.f11324O000000o.O000000o());
            CommonNavigator.this.O00000Oo();
        }
    };
    private int O0000oo0 = 0;

    public int getCurrentSelected() {
        return this.O0000oo0;
    }

    public CommonNavigator(Context context) {
        super(context);
        this.O00000Oo.O00000oO = this;
    }

    public void setAdjustMode(boolean z) {
        this.O0000Oo0 = z;
    }

    public final boolean O000000o() {
        return this.O0000Oo;
    }

    public void setCompactMode(boolean z) {
        this.O0000Oo = z;
    }

    public hrn getAdapter() {
        return this.f11324O000000o;
    }

    public void setAdapter(hrn hrn) {
        hrn hrn2 = this.f11324O000000o;
        if (hrn2 != hrn) {
            if (hrn2 != null) {
                hrn2.f569O000000o.unregisterObserver(this.O0000oOo);
            }
            this.f11324O000000o = hrn;
            hrn hrn3 = this.f11324O000000o;
            if (hrn3 != null) {
                hrn3.f569O000000o.registerObserver(this.O0000oOo);
                this.O00000Oo.O00000Oo(this.f11324O000000o.O000000o());
                if (this.O00000oo != null) {
                    this.f11324O000000o.f569O000000o.notifyChanged();
                    return;
                }
                return;
            }
            this.O00000Oo.O00000Oo(0);
            O00000Oo();
        }
    }

    public final void O00000Oo() {
        removeAllViews();
        View inflate = LayoutInflater.from(getContext()).inflate((int) R.layout.scene_navigator_layout, this);
        this.O00000oO = (ObservableHorizontalScrollView) inflate.findViewById(R.id.scroll_view);
        this.O00000oo = (CutOffLinearLayout) inflate.findViewById(R.id.title_container);
        this.O00000oo.setPadding(this.O0000o0o, 0, this.O0000o0O, 0);
        this.O0000O0o = (LinearLayout) inflate.findViewById(R.id.indicator_container);
        if (this.O0000o) {
            this.O0000O0o.getParent().bringChildToFront(this.O0000O0o);
        }
        this.O00000oO.setScrollViewListener(new ObservableHorizontalScrollView.O000000o() {
            /* class com.xiaomi.smarthome.scene.widget.CommonNavigator.AnonymousClass2 */
        });
        O00000o();
    }

    public void setScrollViewListener(ObservableHorizontalScrollView.O000000o o000000o) {
        this.O00000o = o000000o;
    }

    private void O00000o() {
        LinearLayout.LayoutParams layoutParams;
        int i = this.O00000Oo.f570O000000o;
        for (int i2 = 0; i2 < i; i2++) {
            View view = (View) this.f11324O000000o.O000000o(getContext(), i2);
            if (this.O0000Oo) {
                layoutParams = new LinearLayout.LayoutParams(-2, -2);
            } else if (this.O0000Oo0) {
                layoutParams = new LinearLayout.LayoutParams(0, -1);
                getContext();
                layoutParams.weight = 1.0f;
            } else {
                layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
                if (layoutParams == null) {
                    layoutParams = new LinearLayout.LayoutParams(-2, -1);
                }
            }
            this.O00000oo.addView(view, layoutParams);
        }
        if (this.f11324O000000o != null) {
            getContext();
            this.O0000OOo = null;
            if (this.O0000OOo instanceof View) {
                this.O0000O0o.addView((View) this.O0000OOo, new FrameLayout.LayoutParams(-1, -1));
            }
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.scene.widget.CommonNavigator.O000000o(int, float):void
     arg types: [int, int]
     candidates:
      com.xiaomi.smarthome.scene.widget.CommonNavigator.O000000o(int, int):void
      _m_j.hrs.O000000o.O000000o(int, int):void
      com.xiaomi.smarthome.scene.widget.CommonNavigator.O000000o(int, float):void */
    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.f11324O000000o != null && this.O00000o0) {
            this.O00000o0 = false;
            this.O0000oOO.clear();
            int i5 = this.O00000Oo.f570O000000o;
            for (int i6 = 0; i6 < i5; i6++) {
                hrt hrt = new hrt();
                View childAt = this.O00000oo.getChildAt(i6);
                if (childAt != null) {
                    hrt.f571O000000o = childAt.getLeft();
                    hrt.O00000Oo = childAt.getTop();
                    hrt.O00000o0 = childAt.getRight();
                    hrt.O00000o = childAt.getBottom();
                    if (childAt instanceof hro) {
                        hro hro = (hro) childAt;
                        hrt.O00000oO = hro.getContentLeft();
                        hrt.O00000oo = hro.getContentTop();
                        hrt.O0000O0o = hro.getContentRight();
                        hrt.O0000OOo = hro.getContentBottom();
                    } else {
                        hrt.O00000oO = hrt.f571O000000o;
                        hrt.O00000oo = hrt.O00000Oo;
                        hrt.O0000O0o = hrt.O00000o0;
                        hrt.O0000OOo = hrt.O00000o;
                    }
                }
                this.O0000oOO.add(hrt);
            }
            if (this.O0000oO && this.O00000Oo.O00000o0 == 0) {
                O000000o(this.O00000Oo.O00000Oo);
                O000000o(this.O00000Oo.O00000Oo, 0.0f);
            }
        }
    }

    public final void O000000o(int i, float f) {
        if (this.f11324O000000o != null) {
            this.O00000Oo.O000000o(i, f);
            if (this.O00000oO != null && this.O0000oOO.size() > 0 && i >= 0 && i < this.O0000oOO.size() && this.O0000o0) {
                int min = Math.min(this.O0000oOO.size() - 1, i);
                int min2 = Math.min(this.O0000oOO.size() - 1, i + 1);
                float O000000o2 = ((float) this.O0000oOO.get(min).O000000o()) - (((float) this.O00000oO.getWidth()) * this.O0000Ooo);
                this.O00000oO.scrollTo((int) (O000000o2 + (((((float) this.O0000oOO.get(min2).O000000o()) - (((float) this.O00000oO.getWidth()) * this.O0000Ooo)) - O000000o2) * f)), 0);
            }
        }
    }

    public float getScrollPivotX() {
        return this.O0000Ooo;
    }

    public void setScrollPivotX(float f) {
        this.O0000Ooo = f;
    }

    public final void O000000o(int i) {
        if (this.f11324O000000o != null) {
            this.O00000Oo.O000000o(i);
        }
    }

    public final void O00000Oo(int i) {
        if (this.f11324O000000o != null) {
            this.O00000Oo.O00000o0 = i;
        }
    }

    public final void O00000o0() {
        O00000Oo();
    }

    public hrp getPagerIndicator() {
        return this.O0000OOo;
    }

    public void setEnablePivotScroll(boolean z) {
        this.O0000OoO = z;
    }

    public final void O000000o(int i, int i2, float f, boolean z) {
        CutOffLinearLayout cutOffLinearLayout = this.O00000oo;
        if (cutOffLinearLayout != null) {
            View childAt = cutOffLinearLayout.getChildAt(i);
            if (childAt instanceof hrr) {
                ((hrr) childAt).onEnter(i, i2, f, z);
            }
        }
    }

    public final void O00000Oo(int i, int i2, float f, boolean z) {
        CutOffLinearLayout cutOffLinearLayout = this.O00000oo;
        if (cutOffLinearLayout != null) {
            View childAt = cutOffLinearLayout.getChildAt(i);
            if (childAt instanceof hrr) {
                ((hrr) childAt).onLeave(i, i2, f, z);
            }
        }
    }

    public void setSmoothScroll(boolean z) {
        this.O0000o00 = z;
    }

    public void setFollowTouch(boolean z) {
        this.O0000o0 = z;
    }

    public void setSkimOver(boolean z) {
        this.O0000oO0 = z;
        this.O00000Oo.O00000o = z;
    }

    public final void O000000o(int i, int i2) {
        this.O0000oo0 = i;
        CutOffLinearLayout cutOffLinearLayout = this.O00000oo;
        if (cutOffLinearLayout != null) {
            View childAt = cutOffLinearLayout.getChildAt(i);
            if (childAt instanceof hrr) {
                ((hrr) childAt).onSelected(i, i2);
                childAt.performAccessibilityAction(64, new Bundle());
            }
            if (!this.O0000Oo0 && !this.O0000o0 && this.O00000oO != null && this.O0000oOO.size() > 0) {
                hrt hrt = this.O0000oOO.get(Math.min(this.O0000oOO.size() - 1, i));
                if (this.O0000OoO) {
                    float O000000o2 = ((float) hrt.O000000o()) - (((float) this.O00000oO.getWidth()) * this.O0000Ooo);
                    if (this.O0000o00) {
                        this.O00000oO.smoothScrollTo((int) O000000o2, 0);
                    } else {
                        this.O00000oO.scrollTo((int) O000000o2, 0);
                    }
                } else if (this.O00000oO.getScrollX() > hrt.f571O000000o) {
                    if (this.O0000o00) {
                        this.O00000oO.smoothScrollTo(hrt.f571O000000o, 0);
                    } else {
                        this.O00000oO.scrollTo(hrt.f571O000000o, 0);
                    }
                } else if (this.O00000oO.getScrollX() + getWidth() >= hrt.O00000o0) {
                } else {
                    if (this.O0000o00) {
                        this.O00000oO.smoothScrollTo(hrt.O00000o0 - getWidth(), 0);
                    } else {
                        this.O00000oO.scrollTo(hrt.O00000o0 - getWidth(), 0);
                    }
                }
            }
        }
    }

    public final void O00000Oo(int i, int i2) {
        CutOffLinearLayout cutOffLinearLayout = this.O00000oo;
        if (cutOffLinearLayout != null) {
            View childAt = cutOffLinearLayout.getChildAt(i);
            if (childAt instanceof hrr) {
                ((hrr) childAt).onDeselected(i, i2);
            }
        }
    }

    public LinearLayout getTitleContainer() {
        return this.O00000oo;
    }

    public int getRightPadding() {
        return this.O0000o0O;
    }

    public void setRightPadding(int i) {
        this.O0000o0O = i;
    }

    public int getLeftPadding() {
        return this.O0000o0o;
    }

    public void setLeftPadding(int i) {
        this.O0000o0o = i;
    }

    public void setIndicatorOnTop(boolean z) {
        this.O0000o = z;
    }

    public void setReselectWhenLayout(boolean z) {
        this.O0000oO = z;
    }
}
