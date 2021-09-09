package com.mibigkoo.convenientbanner.view;

import _m_j.chk;
import _m_j.cho;
import _m_j.hyy;
import _m_j.jz;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.viewpager.widget.ViewPager;

public class CBLoopViewPager extends ViewPager {

    /* renamed from: O000000o  reason: collision with root package name */
    ViewPager.O0000O0o f5184O000000o;
    public chk O00000Oo;
    private boolean O00000o = true;
    private cho O00000o0;
    private boolean O00000oO = true;
    private float O00000oo = 0.0f;
    private float O0000O0o = 0.0f;
    private ViewPager.O0000O0o O0000OOo = new ViewPager.O0000O0o() {
        /* class com.mibigkoo.convenientbanner.view.CBLoopViewPager.AnonymousClass1 */
        private float O00000Oo = -1.0f;

        public final void onPageSelected(int i) {
            int O000000o2 = CBLoopViewPager.this.O00000Oo.O000000o(i);
            float f = (float) O000000o2;
            if (this.O00000Oo != f) {
                this.O00000Oo = f;
                if (CBLoopViewPager.this.f5184O000000o != null) {
                    CBLoopViewPager.this.f5184O000000o.onPageSelected(O000000o2);
                }
            }
        }

        public final void onPageScrolled(int i, float f, int i2) {
            if (CBLoopViewPager.this.f5184O000000o != null) {
                CBLoopViewPager.this.f5184O000000o.onPageScrolled(i, f, i2);
            }
        }

        public final void onPageScrollStateChanged(int i) {
            if (CBLoopViewPager.this.f5184O000000o != null) {
                CBLoopViewPager.this.f5184O000000o.onPageScrollStateChanged(i);
            }
        }
    };

    public final void O000000o(jz jzVar, boolean z) {
        this.O00000Oo = (chk) jzVar;
        chk chk = this.O00000Oo;
        chk.O00000o0 = z;
        chk.O00000o = this;
        super.setAdapter(chk);
        setCurrentItem(getFristItem(), false);
    }

    public int getFristItem() {
        if (this.O00000oO) {
            return this.O00000Oo.O000000o();
        }
        return 0;
    }

    public int getLastItem() {
        return this.O00000Oo.O000000o() - 1;
    }

    public void setCanScroll(boolean z) {
        this.O00000o = z;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (getChildCount() == 0) {
            return false;
        }
        if (this.O00000o0 != null) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.O00000oo = motionEvent.getX();
            } else if (action == 1) {
                this.O0000O0o = motionEvent.getX();
                if (Math.abs(this.O00000oo - this.O0000O0o) < 5.0f) {
                    int realItem = getRealItem();
                    if (hyy.O000000o() && this.O00000Oo.O00000oO && this.O0000O0o > ((float) getWidth()) / 2.0f) {
                        realItem = (realItem + 1) % this.O00000Oo.O000000o();
                    }
                    this.O00000o0.onItemClick(realItem);
                }
                this.O00000oo = 0.0f;
                this.O0000O0o = 0.0f;
            } else if (action == 2 && !this.O00000o) {
                return false;
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.O00000o) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return false;
    }

    public chk getAdapter() {
        return this.O00000Oo;
    }

    public int getRealItem() {
        chk chk = this.O00000Oo;
        if (chk != null) {
            return chk.O000000o(super.getCurrentItem());
        }
        return 0;
    }

    public void setOnPageChangeListener(ViewPager.O0000O0o o0000O0o) {
        this.f5184O000000o = o0000O0o;
    }

    public CBLoopViewPager(Context context) {
        super(context);
        O000000o();
    }

    public CBLoopViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        O000000o();
    }

    private void O000000o() {
        super.setOnPageChangeListener(this.O0000OOo);
    }

    public void setCanLoop(boolean z) {
        this.O00000oO = z;
        if (!z) {
            setCurrentItem(getRealItem(), false);
        }
        chk chk = this.O00000Oo;
        if (chk != null) {
            chk.O00000o0 = z;
            chk.notifyDataSetChanged();
        }
    }

    public void setOnItemClickListener(cho cho) {
        this.O00000o0 = cho;
    }

    public cho getOnItemClickListener() {
        return this.O00000o0;
    }
}
