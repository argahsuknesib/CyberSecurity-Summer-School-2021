package com.xiaomi.shopviews.widget.homehorizontaltab;

import _m_j.dul;
import _m_j.exe;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.viewpager.widget.ViewPager;
import com.xiaomi.shopviews.model.HomeSectionItem;
import com.xiaomi.shopviews.widget.homehorizontaltab.HorizontalViewPagerSlideTab;
import com.xiaomi.smarthome.R;

public class HomeHorizontalTabViewPager extends LinearLayout {

    /* renamed from: O000000o  reason: collision with root package name */
    public exe f3948O000000o;
    public HorizontalViewPagerSlideTab O00000Oo;
    private boolean O00000o = false;
    public CustViewPager O00000o0;
    private RelativeLayout O00000oO;

    public HomeHorizontalTabViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        inflate(context, R.layout.listitem_home_horizontal_viewpager, this);
        this.O00000oO = (RelativeLayout) findViewById(R.id.tab_container);
        CustViewPager custViewPager = (CustViewPager) findViewById(R.id.horizontal_viewpager);
        this.O00000o0 = custViewPager;
        custViewPager.setOffscreenPageLimit(0);
        this.O00000o0.setPageMargin(dul.O000000o(context, 2.0f));
        HorizontalViewPagerSlideTab horizontalViewPagerSlideTab = new HorizontalViewPagerSlideTab(context);
        this.O00000Oo = horizontalViewPagerSlideTab;
        horizontalViewPagerSlideTab.setOnSlideTabItemSelecteListener(new HorizontalViewPagerSlideTab.O000000o() {
            /* class com.xiaomi.shopviews.widget.homehorizontaltab.HomeHorizontalTabViewPager.AnonymousClass1 */

            public final void O000000o(int i) {
                CustViewPager custViewPager = HomeHorizontalTabViewPager.this.O00000o0;
                exe exe = HomeHorizontalTabViewPager.this.f3948O000000o;
                custViewPager.setCurrentItem(i + (250 - (250 % (exe.f3589O000000o != null ? exe.f3589O000000o.size() : 0))));
            }
        });
        this.O00000oO.addView(this.O00000Oo, new RelativeLayout.LayoutParams(-1, dul.O000000o(context, 40.0f)));
        this.f3948O000000o = new exe(context, this.O00000o);
        this.O00000o0.addOnPageChangeListener(new ViewPager.O0000O0o() {
            /* class com.xiaomi.shopviews.widget.homehorizontaltab.HomeHorizontalTabViewPager.AnonymousClass2 */
            private int O00000Oo = 0;

            public final void onPageScrollStateChanged(int i) {
            }

            public final void onPageScrolled(int i, float f, int i2) {
            }

            public final void onPageSelected(int i) {
                HomeSectionItem O00000Oo2 = HomeHorizontalTabViewPager.this.f3948O000000o.O000000o(i);
                int O00000o0 = HomeHorizontalTabViewPager.this.f3948O000000o.O00000o0(i);
                if (O00000o0 == 0 || O00000o0 == HomeHorizontalTabViewPager.this.f3948O000000o.f3589O000000o.size() - 1 || O00000o0 % 4 == 0) {
                    HomeHorizontalTabViewPager.this.O00000Oo.setDoAnim(true);
                } else if (this.O00000Oo > i) {
                    HomeHorizontalTabViewPager.this.O00000Oo.setDoAnim(true);
                } else {
                    HomeHorizontalTabViewPager.this.O00000Oo.setDoAnim(false);
                }
                HomeHorizontalTabViewPager.this.O00000Oo.setSelectedItemByTitle(O00000Oo2.mTitle);
                this.O00000Oo = i;
            }
        });
    }

    private void O000000o() {
        CustViewPager custViewPager = this.O00000o0;
        if (custViewPager != null) {
            custViewPager.setAdapter(null);
            this.O00000o0.removeAllViews();
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        O000000o();
    }

    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        O000000o();
    }
}
