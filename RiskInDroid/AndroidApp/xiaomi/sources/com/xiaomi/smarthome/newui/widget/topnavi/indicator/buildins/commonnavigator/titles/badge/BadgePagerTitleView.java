package com.xiaomi.smarthome.newui.widget.topnavi.indicator.buildins.commonnavigator.titles.badge;

import _m_j.hhv;
import _m_j.hhx;
import _m_j.hhz;
import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;

public class BadgePagerTitleView extends FrameLayout implements hhv {

    /* renamed from: O000000o  reason: collision with root package name */
    private hhx f10354O000000o;
    private View O00000Oo;
    private hhz O00000o;
    private boolean O00000o0 = true;
    private hhz O00000oO;

    public BadgePagerTitleView(Context context) {
        super(context);
    }

    public void onSelected(int i, int i2) {
        hhx hhx = this.f10354O000000o;
        if (hhx != null) {
            hhx.onSelected(i, i2);
        }
        if (this.O00000o0) {
            setBadgeView(null);
        }
    }

    public void onDeselected(int i, int i2) {
        hhx hhx = this.f10354O000000o;
        if (hhx != null) {
            hhx.onDeselected(i, i2);
        }
    }

    public void onLeave(int i, int i2, float f, boolean z) {
        hhx hhx = this.f10354O000000o;
        if (hhx != null) {
            hhx.onLeave(i, i2, f, z);
        }
    }

    public void onEnter(int i, int i2, float f, boolean z) {
        hhx hhx = this.f10354O000000o;
        if (hhx != null) {
            hhx.onEnter(i, i2, f, z);
        }
    }

    public hhx getInnerPagerTitleView() {
        return this.f10354O000000o;
    }

    public void setInnerPagerTitleView(hhx hhx) {
        if (this.f10354O000000o != hhx) {
            this.f10354O000000o = hhx;
            removeAllViews();
            if (this.f10354O000000o instanceof View) {
                addView((View) this.f10354O000000o, new FrameLayout.LayoutParams(-1, -1));
            }
            if (this.O00000Oo != null) {
                addView(this.O00000Oo, new FrameLayout.LayoutParams(-2, -2));
            }
        }
    }

    public View getBadgeView() {
        return this.O00000Oo;
    }

    public void setBadgeView(View view) {
        if (this.O00000Oo != view) {
            this.O00000Oo = view;
            removeAllViews();
            if (this.f10354O000000o instanceof View) {
                addView((View) this.f10354O000000o, new FrameLayout.LayoutParams(-1, -1));
            }
            if (this.O00000Oo != null) {
                addView(this.O00000Oo, new FrameLayout.LayoutParams(-2, -2));
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        hhx hhx = this.f10354O000000o;
        if ((hhx instanceof View) && this.O00000Oo != null) {
            int[] iArr = new int[14];
            View view = (View) hhx;
            iArr[0] = view.getLeft();
            iArr[1] = view.getTop();
            iArr[2] = view.getRight();
            iArr[3] = view.getBottom();
            hhx hhx2 = this.f10354O000000o;
            if (hhx2 instanceof hhv) {
                hhv hhv = (hhv) hhx2;
                iArr[4] = hhv.getContentLeft();
                iArr[5] = hhv.getContentTop();
                iArr[6] = hhv.getContentRight();
                iArr[7] = hhv.getContentBottom();
            } else {
                for (int i5 = 4; i5 < 8; i5++) {
                    iArr[i5] = iArr[i5 - 4];
                }
            }
            iArr[8] = view.getWidth() / 2;
            iArr[9] = view.getHeight() / 2;
            iArr[10] = iArr[4] / 2;
            iArr[11] = iArr[5] / 2;
            iArr[12] = iArr[6] + ((iArr[2] - iArr[6]) / 2);
            iArr[13] = iArr[7] + ((iArr[3] - iArr[7]) / 2);
            hhz hhz = this.O00000o;
            if (hhz != null) {
                int i6 = iArr[hhz.f18956O000000o.ordinal()] + this.O00000o.O00000Oo;
                View view2 = this.O00000Oo;
                view2.offsetLeftAndRight(i6 - view2.getLeft());
            }
            hhz hhz2 = this.O00000oO;
            if (hhz2 != null) {
                int i7 = iArr[hhz2.f18956O000000o.ordinal()] + this.O00000oO.O00000Oo;
                View view3 = this.O00000Oo;
                view3.offsetTopAndBottom(i7 - view3.getTop());
            }
        }
    }

    public int getContentLeft() {
        if (this.f10354O000000o instanceof hhv) {
            return getLeft() + ((hhv) this.f10354O000000o).getContentLeft();
        }
        return getLeft();
    }

    public int getContentTop() {
        hhx hhx = this.f10354O000000o;
        if (hhx instanceof hhv) {
            return ((hhv) hhx).getContentTop();
        }
        return getTop();
    }

    public int getContentRight() {
        if (this.f10354O000000o instanceof hhv) {
            return getLeft() + ((hhv) this.f10354O000000o).getContentRight();
        }
        return getRight();
    }

    public int getContentBottom() {
        hhx hhx = this.f10354O000000o;
        if (hhx instanceof hhv) {
            return ((hhv) hhx).getContentBottom();
        }
        return getBottom();
    }

    public hhz getXBadgeRule() {
        return this.O00000o;
    }

    public hhz getYBadgeRule() {
        return this.O00000oO;
    }

    public void setAutoCancelBadge(boolean z) {
        this.O00000o0 = z;
    }

    public void setXBadgeRule(hhz hhz) {
        BadgeAnchor badgeAnchor;
        if (hhz == null || (badgeAnchor = hhz.f18956O000000o) == BadgeAnchor.LEFT || badgeAnchor == BadgeAnchor.RIGHT || badgeAnchor == BadgeAnchor.CONTENT_LEFT || badgeAnchor == BadgeAnchor.CONTENT_RIGHT || badgeAnchor == BadgeAnchor.CENTER_X || badgeAnchor == BadgeAnchor.LEFT_EDGE_CENTER_X || badgeAnchor == BadgeAnchor.RIGHT_EDGE_CENTER_X) {
            this.O00000o = hhz;
            return;
        }
        throw new IllegalArgumentException("x badge rule is wrong.");
    }

    public void setYBadgeRule(hhz hhz) {
        BadgeAnchor badgeAnchor;
        if (hhz == null || (badgeAnchor = hhz.f18956O000000o) == BadgeAnchor.TOP || badgeAnchor == BadgeAnchor.BOTTOM || badgeAnchor == BadgeAnchor.CONTENT_TOP || badgeAnchor == BadgeAnchor.CONTENT_BOTTOM || badgeAnchor == BadgeAnchor.CENTER_Y || badgeAnchor == BadgeAnchor.TOP_EDGE_CENTER_Y || badgeAnchor == BadgeAnchor.BOTTOM_EDGE_CENTER_Y) {
            this.O00000oO = hhz;
            return;
        }
        throw new IllegalArgumentException("y badge rule is wrong.");
    }
}
