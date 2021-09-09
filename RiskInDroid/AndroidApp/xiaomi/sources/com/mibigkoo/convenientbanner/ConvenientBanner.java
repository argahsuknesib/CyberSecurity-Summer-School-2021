package com.mibigkoo.convenientbanner;

import _m_j.chk;
import _m_j.chl;
import _m_j.chn;
import _m_j.cho;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.viewpager.widget.ViewPager;
import com.mibigkoo.convenientbanner.view.CBLoopViewPager;
import com.xiaomi.smarthome.R;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class ConvenientBanner<T> extends LinearLayout {

    /* renamed from: O000000o  reason: collision with root package name */
    public CBLoopViewPager f5179O000000o;
    public long O00000Oo;
    public O000000o O00000o;
    public boolean O00000o0;
    private List<T> O00000oO;
    private int[] O00000oo;
    private ArrayList<ImageView> O0000O0o = new ArrayList<>();
    private chn O0000OOo;
    private chk O0000Oo;
    private ViewPager.O0000O0o O0000Oo0;
    private ViewPagerScroller O0000OoO;
    private ViewGroup O0000Ooo;
    private boolean O0000o0 = true;
    private boolean O0000o00 = false;
    private boolean O0000o0O = true;

    public enum PageIndicatorAlign {
        ALIGN_PARENT_LEFT,
        ALIGN_PARENT_RIGHT,
        CENTER_HORIZONTAL
    }

    public ConvenientBanner(Context context) {
        super(context);
        O000000o(context);
    }

    public ConvenientBanner(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.canLoop});
        this.O0000o0O = obtainStyledAttributes.getBoolean(0, true);
        obtainStyledAttributes.recycle();
        O000000o(context);
    }

    @TargetApi(11)
    public ConvenientBanner(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.canLoop});
        this.O0000o0O = obtainStyledAttributes.getBoolean(0, true);
        obtainStyledAttributes.recycle();
        O000000o(context);
    }

    @TargetApi(21)
    public ConvenientBanner(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.canLoop});
        this.O0000o0O = obtainStyledAttributes.getBoolean(0, true);
        obtainStyledAttributes.recycle();
        O000000o(context);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, com.mibigkoo.convenientbanner.ConvenientBanner, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    private void O000000o(Context context) {
        View inflate = LayoutInflater.from(context).inflate((int) R.layout.include_viewpager, (ViewGroup) this, true);
        this.f5179O000000o = (CBLoopViewPager) inflate.findViewById(R.id.cbLoopViewPager);
        this.O0000Ooo = (ViewGroup) inflate.findViewById(R.id.loPageTurningPoint);
        O00000o0();
        this.O00000o = new O000000o(this);
    }

    static class O000000o implements Runnable {

        /* renamed from: O000000o  reason: collision with root package name */
        private final WeakReference<ConvenientBanner> f5180O000000o;

        O000000o(ConvenientBanner convenientBanner) {
            this.f5180O000000o = new WeakReference<>(convenientBanner);
        }

        public final void run() {
            ConvenientBanner convenientBanner = this.f5180O000000o.get();
            if (convenientBanner != null && convenientBanner.f5179O000000o != null && convenientBanner.O00000o0) {
                convenientBanner.f5179O000000o.setCurrentItem(convenientBanner.f5179O000000o.getCurrentItem() + 1);
                convenientBanner.postDelayed(convenientBanner.O00000o, convenientBanner.O00000Oo);
            }
        }
    }

    public final ConvenientBanner O000000o(chl chl, List<T> list) {
        this.O00000oO = list;
        this.O0000Oo = new chk(chl, this.O00000oO);
        this.f5179O000000o.O000000o(this.O0000Oo, this.O0000o0O);
        int[] iArr = this.O00000oo;
        if (iArr != null) {
            O000000o(iArr);
        }
        return this;
    }

    public final ConvenientBanner O000000o(boolean z) {
        chk chk = this.O0000Oo;
        if (chk != null) {
            chk.O00000oO = z;
        }
        return this;
    }

    public final void O000000o() {
        this.f5179O000000o.getAdapter().notifyDataSetChanged();
        int[] iArr = this.O00000oo;
        if (iArr != null) {
            O000000o(iArr);
        }
    }

    public void setPointViewTopMargin(int i) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.O0000Ooo.getLayoutParams();
        layoutParams.topMargin = i;
        this.O0000Ooo.setLayoutParams(layoutParams);
    }

    public void setPointViewBottomMargin(int i) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.O0000Ooo.getLayoutParams();
        layoutParams.bottomMargin = i;
        this.O0000Ooo.setLayoutParams(layoutParams);
    }

    public void setPointViewLeftMargin(int i) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.O0000Ooo.getLayoutParams();
        layoutParams.leftMargin = i;
        this.O0000Ooo.setLayoutParams(layoutParams);
    }

    public final ConvenientBanner O000000o(int[] iArr) {
        this.O0000Ooo.removeAllViews();
        this.O0000O0o.clear();
        this.O00000oo = iArr;
        if (this.O00000oO == null) {
            return this;
        }
        for (int i = 0; i < this.O00000oO.size(); i++) {
            ImageView imageView = new ImageView(getContext());
            imageView.setPadding(5, 0, 5, 0);
            if (this.O0000O0o.isEmpty()) {
                imageView.setImageResource(iArr[1]);
            } else {
                imageView.setImageResource(iArr[0]);
            }
            this.O0000O0o.add(imageView);
            this.O0000Ooo.addView(imageView);
        }
        this.O0000OOo = new chn(this.O0000O0o, iArr);
        this.f5179O000000o.setOnPageChangeListener(this.O0000OOo);
        this.O0000OOo.onPageSelected(this.f5179O000000o.getRealItem());
        ViewPager.O0000O0o o0000O0o = this.O0000Oo0;
        if (o0000O0o != null) {
            this.O0000OOo.f13826O000000o = o0000O0o;
        }
        return this;
    }

    public final ConvenientBanner O000000o(PageIndicatorAlign pageIndicatorAlign) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.O0000Ooo.getLayoutParams();
        int i = -1;
        layoutParams.addRule(9, pageIndicatorAlign == PageIndicatorAlign.ALIGN_PARENT_LEFT ? -1 : 0);
        layoutParams.addRule(11, pageIndicatorAlign == PageIndicatorAlign.ALIGN_PARENT_RIGHT ? -1 : 0);
        if (pageIndicatorAlign != PageIndicatorAlign.CENTER_HORIZONTAL) {
            i = 0;
        }
        layoutParams.addRule(14, i);
        this.O0000Ooo.setLayoutParams(layoutParams);
        return this;
    }

    public final ConvenientBanner O000000o(long j) {
        if (this.O00000o0) {
            O00000Oo();
        }
        this.O0000o00 = true;
        this.O00000Oo = j;
        this.O00000o0 = true;
        postDelayed(this.O00000o, j);
        return this;
    }

    private void O00000Oo() {
        this.O00000o0 = false;
        removeCallbacks(this.O00000o);
    }

    private void O00000o0() {
        try {
            Field declaredField = ViewPager.class.getDeclaredField("mScroller");
            declaredField.setAccessible(true);
            this.O0000OoO = new ViewPagerScroller(this.f5179O000000o.getContext());
            declaredField.set(this.f5179O000000o, this.O0000OoO);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e2) {
            e2.printStackTrace();
        } catch (IllegalAccessException e3) {
            e3.printStackTrace();
        }
    }

    public void setManualPageable(boolean z) {
        this.f5179O000000o.setCanScroll(z);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 1 || action == 3 || action == 4) {
            if (this.O0000o00) {
                O000000o(this.O00000Oo);
            }
        } else if (action == 0 && this.O0000o00) {
            O00000Oo();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public int getCurrentItem() {
        CBLoopViewPager cBLoopViewPager = this.f5179O000000o;
        if (cBLoopViewPager != null) {
            return cBLoopViewPager.getRealItem();
        }
        return -1;
    }

    public void setcurrentitem(int i) {
        CBLoopViewPager cBLoopViewPager = this.f5179O000000o;
        if (cBLoopViewPager != null) {
            cBLoopViewPager.setCurrentItem(i);
        }
    }

    public ViewPager.O0000O0o getOnPageChangeListener() {
        return this.O0000Oo0;
    }

    public final ConvenientBanner O000000o(ViewPager.O0000O0o o0000O0o) {
        this.O0000Oo0 = o0000O0o;
        chn chn = this.O0000OOo;
        if (chn != null) {
            chn.f13826O000000o = o0000O0o;
        } else {
            this.f5179O000000o.setOnPageChangeListener(o0000O0o);
        }
        return this;
    }

    public final ConvenientBanner O000000o(cho cho) {
        if (cho == null) {
            this.f5179O000000o.setOnItemClickListener(null);
            return this;
        }
        this.f5179O000000o.setOnItemClickListener(cho);
        return this;
    }

    public void setScrollDuration(int i) {
        this.O0000OoO.f5183O000000o = i;
    }

    public int getScrollDuration() {
        return this.O0000OoO.f5183O000000o;
    }

    public CBLoopViewPager getViewPager() {
        return this.f5179O000000o;
    }

    public void setCanLoop(boolean z) {
        this.O0000o0O = z;
        this.f5179O000000o.setCanLoop(z);
    }
}
