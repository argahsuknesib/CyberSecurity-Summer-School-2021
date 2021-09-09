package com.xiaomi.shopviews.widget.homehorizontaltab;

import _m_j.exj;
import _m_j.o0OO00o0;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import androidx.viewpager.widget.ViewPager;
import com.xiaomi.shopviews.widget.smarttab.SmartTabLayout;
import com.xiaomi.smarthome.R;
import java.util.LinkedHashMap;

public class HorizontalViewPagerSlideTab extends RelativeLayout {

    /* renamed from: O000000o  reason: collision with root package name */
    public O000000o f3951O000000o;
    public SmartTabLayout O00000Oo;
    public LinkedHashMap<String, Integer> O00000o = new LinkedHashMap<>();
    public O00000Oo O00000o0 = new O00000Oo();
    private o0OO00o0<String> O00000oO = new o0OO00o0<>();

    public interface O000000o {
        void O000000o(int i);
    }

    public HorizontalViewPagerSlideTab(Context context) {
        super(context);
        LayoutInflater.from(getContext()).inflate((int) R.layout.listitem_category_slidetab, this);
        SmartTabLayout smartTabLayout = (SmartTabLayout) findViewById(R.id.listitem_category_slidetab_smarttablayout);
        this.O00000Oo = smartTabLayout;
        smartTabLayout.setSelectedIndicatorColors(getResources().getColor(R.color.transparent));
    }

    public O00000Oo getSmartTabMediator() {
        return this.O00000o0;
    }

    public void setDoAnim(boolean z) {
        this.O00000Oo.setDoStartAnim(z);
    }

    public void setOnSlideTabItemSelecteListener(O000000o o000000o) {
        this.f3951O000000o = o000000o;
    }

    public void setSelectedItemByTitle(String str) {
        if (!TextUtils.isEmpty(str)) {
            for (int i = 0; i < this.O00000oO.O00000Oo(); i++) {
                int O00000Oo2 = this.O00000oO.O00000Oo(i);
                if (str.equals(this.O00000oO.O000000o(O00000Oo2, null))) {
                    O00000Oo o00000Oo = this.O00000o0;
                    o00000Oo.f3952O000000o = O00000Oo2;
                    if (o00000Oo.O00000Oo != null) {
                        o00000Oo.O00000Oo.onPageSelected(O00000Oo2);
                        return;
                    }
                    return;
                }
            }
        }
    }

    public class O00000Oo implements exj {

        /* renamed from: O000000o  reason: collision with root package name */
        int f3952O000000o;
        ViewPager.O0000O0o O00000Oo;
        public o0OO00o0<String> O00000o0;

        public O00000Oo() {
        }

        public final void O000000o(ViewPager.O0000O0o o0000O0o) {
            this.O00000Oo = o0000O0o;
        }

        public final int O000000o() {
            return this.O00000o0.O00000Oo();
        }

        public final int O00000Oo() {
            return this.f3952O000000o;
        }

        public final CharSequence O000000o(int i) {
            return this.O00000o0.O000000o(i, null);
        }

        public final boolean O00000o0() {
            o0OO00o0<String> o0oo00o0 = this.O00000o0;
            return o0oo00o0 == null && o0oo00o0.O00000Oo() <= 0;
        }

        public final void O00000Oo(int i) {
            this.f3952O000000o = i;
            if (HorizontalViewPagerSlideTab.this.f3951O000000o != null) {
                HorizontalViewPagerSlideTab.this.f3951O000000o.O000000o(HorizontalViewPagerSlideTab.this.O00000o.get(this.O00000o0.O000000o(i, null)).intValue());
            }
            ViewPager.O0000O0o o0000O0o = this.O00000Oo;
            if (o0000O0o != null) {
                o0000O0o.onPageSelected(i);
            }
        }
    }
}
