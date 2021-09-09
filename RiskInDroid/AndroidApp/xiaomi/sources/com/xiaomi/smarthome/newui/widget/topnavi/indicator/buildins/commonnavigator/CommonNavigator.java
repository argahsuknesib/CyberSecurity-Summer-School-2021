package com.xiaomi.smarthome.newui.widget.topnavi.indicator.buildins.commonnavigator;

import _m_j.hhp;
import _m_j.hhr;
import _m_j.hhu;
import _m_j.hhv;
import _m_j.hhw;
import _m_j.hhx;
import _m_j.hhy;
import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.newui.widget.topnavi.indicator.buildins.ObservableHorizontalScrollView;
import com.xiaomi.smarthome.newui.widget.topnavi.widgets.CutOffLinearLayout;
import java.util.ArrayList;
import java.util.List;

public class CommonNavigator extends FrameLayout implements hhp.O000000o, hhr {

    /* renamed from: O000000o  reason: collision with root package name */
    public CutOffLinearLayout f10345O000000o;
    public hhu O00000Oo;
    public List<hhy> O00000o = new ArrayList();
    public hhp O00000o0 = new hhp();
    public boolean O00000oO = true;
    public ObservableHorizontalScrollView.O000000o O00000oo = null;
    private ObservableHorizontalScrollView O0000O0o;
    private LinearLayout O0000OOo;
    private boolean O0000Oo;
    private hhw O0000Oo0;
    private boolean O0000OoO;
    private boolean O0000Ooo;
    private int O0000o;
    private boolean O0000o0 = true;
    private float O0000o00 = 0.5f;
    private boolean O0000o0O = true;
    private int O0000o0o;
    private boolean O0000oO;
    private boolean O0000oO0;
    private boolean O0000oOO = true;
    private DataSetObserver O0000oOo = new DataSetObserver() {
        /* class com.xiaomi.smarthome.newui.widget.topnavi.indicator.buildins.commonnavigator.CommonNavigator.AnonymousClass1 */

        public final void onInvalidated() {
        }

        public final void onChanged() {
            CommonNavigator commonNavigator = CommonNavigator.this;
            commonNavigator.O00000oO = true;
            commonNavigator.O00000o0.O00000Oo(CommonNavigator.this.O00000Oo.O000000o());
            CommonNavigator.this.O00000o0();
        }
    };
    private int O0000oo0 = 0;

    public int getCurrentSelected() {
        return this.O0000oo0;
    }

    public CommonNavigator(Context context) {
        super(context);
        this.O00000o0.O00000oO = this;
    }

    public void setAdjustMode(boolean z) {
        this.O0000Oo = z;
    }

    public final boolean O00000Oo() {
        return this.O0000OoO;
    }

    public void setCompactMode(boolean z) {
        this.O0000OoO = z;
    }

    public hhu getAdapter() {
        return this.O00000Oo;
    }

    public void setAdapter(hhu hhu) {
        hhu hhu2 = this.O00000Oo;
        if (hhu2 != hhu) {
            if (hhu2 != null) {
                hhu2.f18954O000000o.unregisterObserver(this.O0000oOo);
            }
            this.O00000Oo = hhu;
            hhu hhu3 = this.O00000Oo;
            if (hhu3 != null) {
                hhu3.f18954O000000o.registerObserver(this.O0000oOo);
                this.O00000o0.O00000Oo(this.O00000Oo.O000000o());
                if (this.f10345O000000o != null) {
                    this.O00000Oo.f18954O000000o.notifyChanged();
                    return;
                }
                return;
            }
            this.O00000o0.O00000Oo(0);
            O00000o0();
        }
    }

    public final void O00000o0() {
        View view;
        removeAllViews();
        if (this.O0000OoO) {
            view = LayoutInflater.from(getContext()).inflate((int) R.layout.pager_navigator_layout_compact, this);
        } else if (this.O0000Oo) {
            view = LayoutInflater.from(getContext()).inflate((int) R.layout.pager_navigator_layout_no_scroll, this);
        } else {
            view = LayoutInflater.from(getContext()).inflate((int) R.layout.pager_navigator_layout, this);
        }
        this.O0000O0o = (ObservableHorizontalScrollView) view.findViewById(R.id.scroll_view);
        this.f10345O000000o = (CutOffLinearLayout) view.findViewById(R.id.title_container);
        this.f10345O000000o.setPadding(this.O0000o, 0, this.O0000o0o, 0);
        this.O0000OOo = (LinearLayout) view.findViewById(R.id.indicator_container);
        if (this.O0000oO0) {
            this.O0000OOo.getParent().bringChildToFront(this.O0000OOo);
        }
        this.O0000O0o.setScrollViewListener(new ObservableHorizontalScrollView.O000000o() {
            /* class com.xiaomi.smarthome.newui.widget.topnavi.indicator.buildins.commonnavigator.CommonNavigator.AnonymousClass2 */

            public final void onScrollChanged(ObservableHorizontalScrollView observableHorizontalScrollView, int i, int i2, int i3, int i4) {
                if (CommonNavigator.this.O00000oo != null) {
                    CommonNavigator.this.O00000oo.onScrollChanged(observableHorizontalScrollView, i, i2, i3, i4);
                }
            }
        });
        O00000o();
    }

    public void setScrollViewListener(ObservableHorizontalScrollView.O000000o o000000o) {
        this.O00000oo = o000000o;
    }

    private void O00000o() {
        LinearLayout.LayoutParams layoutParams;
        int i = this.O00000o0.f18952O000000o;
        for (int i2 = 0; i2 < i; i2++) {
            View view = (View) this.O00000Oo.O000000o(getContext(), i2);
            if (this.O0000OoO) {
                layoutParams = new LinearLayout.LayoutParams(-2, -2);
            } else if (this.O0000Oo) {
                layoutParams = new LinearLayout.LayoutParams(0, -1);
                getContext();
                layoutParams.weight = 1.0f;
            } else {
                layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
                if (layoutParams == null) {
                    layoutParams = new LinearLayout.LayoutParams(-2, -1);
                }
            }
            this.f10345O000000o.addView(view, layoutParams);
        }
        if (this.O00000Oo != null) {
            getContext();
            this.O0000Oo0 = null;
            if (this.O0000Oo0 instanceof View) {
                this.O0000OOo.addView((View) this.O0000Oo0, new FrameLayout.LayoutParams(-1, -1));
            }
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.newui.widget.topnavi.indicator.buildins.commonnavigator.CommonNavigator.O000000o(int, float):void
     arg types: [int, int]
     candidates:
      com.xiaomi.smarthome.newui.widget.topnavi.indicator.buildins.commonnavigator.CommonNavigator.O000000o(int, int):void
      _m_j.hhp.O000000o.O000000o(int, int):void
      com.xiaomi.smarthome.newui.widget.topnavi.indicator.buildins.commonnavigator.CommonNavigator.O000000o(int, float):void */
    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.O00000Oo != null && this.O00000oO) {
            this.O00000oO = false;
            this.O00000o.clear();
            int i5 = this.O00000o0.f18952O000000o;
            for (int i6 = 0; i6 < i5; i6++) {
                hhy hhy = new hhy();
                View childAt = this.f10345O000000o.getChildAt(i6);
                if (childAt != null) {
                    hhy.f18955O000000o = childAt.getLeft();
                    hhy.O00000Oo = childAt.getTop();
                    hhy.O00000o0 = childAt.getRight();
                    hhy.O00000o = childAt.getBottom();
                    if (childAt instanceof hhv) {
                        hhv hhv = (hhv) childAt;
                        hhy.O00000oO = hhv.getContentLeft();
                        hhy.O00000oo = hhv.getContentTop();
                        hhy.O0000O0o = hhv.getContentRight();
                        hhy.O0000OOo = hhv.getContentBottom();
                    } else {
                        hhy.O00000oO = hhy.f18955O000000o;
                        hhy.O00000oo = hhy.O00000Oo;
                        hhy.O0000O0o = hhy.O00000o0;
                        hhy.O0000OOo = hhy.O00000o;
                    }
                }
                this.O00000o.add(hhy);
            }
            hhw hhw = this.O0000Oo0;
            if (hhw != null) {
                hhw.O000000o(this.O00000o);
            }
            if (this.O0000oOO && this.O00000o0.O00000o0 == 0) {
                O000000o(this.O00000o0.O00000Oo);
                O000000o(this.O00000o0.O00000Oo, 0.0f);
            }
        }
    }

    public final void O000000o(int i, float f) {
        if (this.O00000Oo != null) {
            this.O00000o0.O000000o(i, f);
            hhw hhw = this.O0000Oo0;
            if (hhw != null) {
                hhw.O000000o(i, f);
            }
            if (this.O0000O0o != null && this.O00000o.size() > 0 && i >= 0 && i < this.O00000o.size() && this.O0000o0O) {
                int min = Math.min(this.O00000o.size() - 1, i);
                int min2 = Math.min(this.O00000o.size() - 1, i + 1);
                float O00000Oo2 = ((float) this.O00000o.get(min).O00000Oo()) - (((float) this.O0000O0o.getWidth()) * this.O0000o00);
                this.O0000O0o.scrollTo((int) (O00000Oo2 + (((((float) this.O00000o.get(min2).O00000Oo()) - (((float) this.O0000O0o.getWidth()) * this.O0000o00)) - O00000Oo2) * f)), 0);
            }
        }
    }

    public float getScrollPivotX() {
        return this.O0000o00;
    }

    public void setScrollPivotX(float f) {
        this.O0000o00 = f;
    }

    public final void O000000o(int i) {
        if (this.O00000Oo != null) {
            this.O00000o0.O000000o(i);
        }
    }

    public final void O00000Oo(int i) {
        if (this.O00000Oo != null) {
            this.O00000o0.O00000o0 = i;
        }
    }

    public final void O000000o() {
        O00000o0();
    }

    public hhw getPagerIndicator() {
        return this.O0000Oo0;
    }

    public void setEnablePivotScroll(boolean z) {
        this.O0000Ooo = z;
    }

    public final void O000000o(int i, int i2, float f, boolean z) {
        CutOffLinearLayout cutOffLinearLayout = this.f10345O000000o;
        if (cutOffLinearLayout != null) {
            View childAt = cutOffLinearLayout.getChildAt(i);
            if (childAt instanceof hhx) {
                ((hhx) childAt).onEnter(i, i2, f, z);
            }
        }
    }

    public final void O00000Oo(int i, int i2, float f, boolean z) {
        CutOffLinearLayout cutOffLinearLayout = this.f10345O000000o;
        if (cutOffLinearLayout != null) {
            View childAt = cutOffLinearLayout.getChildAt(i);
            if (childAt instanceof hhx) {
                ((hhx) childAt).onLeave(i, i2, f, z);
            }
        }
    }

    public void setSmoothScroll(boolean z) {
        this.O0000o0 = z;
    }

    public void setFollowTouch(boolean z) {
        this.O0000o0O = z;
    }

    public void setSkimOver(boolean z) {
        this.O0000oO = z;
        this.O00000o0.O00000o = z;
    }

    public final void O000000o(int i, int i2) {
        this.O0000oo0 = i;
        CutOffLinearLayout cutOffLinearLayout = this.f10345O000000o;
        if (cutOffLinearLayout != null) {
            View childAt = cutOffLinearLayout.getChildAt(i);
            if (childAt instanceof hhx) {
                ((hhx) childAt).onSelected(i, i2);
                childAt.sendAccessibilityEvent(4);
            }
            if (!this.O0000Oo && !this.O0000o0O && this.O0000O0o != null && this.O00000o.size() > 0) {
                hhy hhy = this.O00000o.get(Math.min(this.O00000o.size() - 1, i));
                if (this.O0000Ooo) {
                    float O00000Oo2 = ((float) hhy.O00000Oo()) - (((float) this.O0000O0o.getWidth()) * this.O0000o00);
                    if (this.O0000o0) {
                        this.O0000O0o.smoothScrollTo((int) O00000Oo2, 0);
                    } else {
                        this.O0000O0o.scrollTo((int) O00000Oo2, 0);
                    }
                } else if (this.O0000O0o.getScrollX() > hhy.f18955O000000o) {
                    if (this.O0000o0) {
                        this.O0000O0o.smoothScrollTo(hhy.f18955O000000o, 0);
                    } else {
                        this.O0000O0o.scrollTo(hhy.f18955O000000o, 0);
                    }
                } else if (this.O0000O0o.getScrollX() + getWidth() >= hhy.O00000o0) {
                } else {
                    if (this.O0000o0) {
                        this.O0000O0o.smoothScrollTo(hhy.O00000o0 - getWidth(), 0);
                    } else {
                        this.O0000O0o.scrollTo(hhy.O00000o0 - getWidth(), 0);
                    }
                }
            }
        }
    }

    public final void O00000Oo(int i, int i2) {
        CutOffLinearLayout cutOffLinearLayout = this.f10345O000000o;
        if (cutOffLinearLayout != null) {
            View childAt = cutOffLinearLayout.getChildAt(i);
            if (childAt instanceof hhx) {
                ((hhx) childAt).onDeselected(i, i2);
            }
        }
    }

    public LinearLayout getTitleContainer() {
        return this.f10345O000000o;
    }

    public int getRightPadding() {
        return this.O0000o0o;
    }

    public void setRightPadding(int i) {
        this.O0000o0o = i;
    }

    public int getLeftPadding() {
        return this.O0000o;
    }

    public void setLeftPadding(int i) {
        this.O0000o = i;
    }

    public void setIndicatorOnTop(boolean z) {
        this.O0000oO0 = z;
    }

    public void setReselectWhenLayout(boolean z) {
        this.O0000oOO = z;
    }
}
