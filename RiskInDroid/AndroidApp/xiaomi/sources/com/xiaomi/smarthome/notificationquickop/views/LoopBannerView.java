package com.xiaomi.smarthome.notificationquickop.views;

import _m_j.gsy;
import _m_j.jz;
import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewpager.widget.ViewPager;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.smarthome.shop.view.LoopViewPager;
import java.util.List;

public class LoopBannerView extends FrameLayout {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final String f10495O000000o = "LoopBannerView";
    public LayoutInflater O00000Oo;
    private int O00000o = 0;
    private int O00000o0 = 0;
    private LoopViewPager O00000oO;
    private O000000o O00000oo;

    public LoopBannerView(Context context) {
        super(context);
        O000000o(context);
    }

    public LoopBannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        O000000o(context);
    }

    public LoopBannerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        O000000o(context);
    }

    private void O000000o(Context context) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.O00000o0 = (int) TypedValue.applyDimension(1, 6.0f, displayMetrics);
        this.O00000o = (int) TypedValue.applyDimension(1, 3.0f, displayMetrics);
        this.O00000Oo = LayoutInflater.from(context);
        this.O00000Oo.inflate((int) R.layout.notification_quick_op_vp, this);
        this.O00000oO = (LoopViewPager) findViewById(R.id.view_pager);
        this.O00000oo = new O000000o(this, (byte) 0);
        this.O00000oO.setAdapter(this.O00000oo);
        this.O00000oO.setOnPageChangeListener(new ViewPager.O0000O0o() {
            /* class com.xiaomi.smarthome.notificationquickop.views.LoopBannerView.AnonymousClass1 */

            public final void onPageScrollStateChanged(int i) {
            }

            public final void onPageScrolled(int i, float f, int i2) {
            }

            public final void onPageSelected(int i) {
            }
        });
        this.O00000oo.notifyDataSetChanged();
    }

    public void setViewPagerHeight(int i) {
        ViewGroup.LayoutParams layoutParams = this.O00000oO.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.height = i;
            this.O00000oO.setLayoutParams(layoutParams);
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.O00000oO.O000000o();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.O00000oO.O00000Oo();
    }

    class O000000o extends jz {

        /* renamed from: O000000o  reason: collision with root package name */
        List<Object> f10497O000000o;

        public final int getItemPosition(Object obj) {
            return -2;
        }

        public final boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        private O000000o() {
        }

        /* synthetic */ O000000o(LoopBannerView loopBannerView, byte b) {
            this();
        }

        public final int getCount() {
            List<Object> list = this.f10497O000000o;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        public final void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView((View) obj);
        }

        public final Object instantiateItem(ViewGroup viewGroup, int i) {
            gsy.O000000o(LogType.GENERAL, LoopBannerView.f10495O000000o, "instantiateItem pos: ".concat(String.valueOf(i)));
            View inflate = LoopBannerView.this.O00000Oo.inflate((int) R.layout.notification_quick_op_item_view, (ViewGroup) null);
            this.f10497O000000o.get(i);
            inflate.findViewById(R.id.title);
            inflate.findViewById(R.id.sub_title);
            inflate.setTag(Integer.valueOf(i));
            viewGroup.addView(inflate, 0);
            return inflate;
        }
    }
}
