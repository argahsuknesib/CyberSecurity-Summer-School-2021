package com.mibigkoo.convenientbanner;

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

public class ConvenientBannerUnReusable<T> extends LinearLayout {

    /* renamed from: O000000o  reason: collision with root package name */
    public CBLoopViewPager f5181O000000o;
    public long O00000Oo;
    public O000000o O00000o;
    public boolean O00000o0;
    private ArrayList<ImageView> O00000oO = new ArrayList<>();
    private ViewPager.O0000O0o O00000oo;
    private ViewPagerScroller O0000O0o;
    private ViewGroup O0000OOo;
    private boolean O0000Oo = true;
    private boolean O0000Oo0 = false;
    private boolean O0000OoO = true;

    public ConvenientBannerUnReusable(Context context) {
        super(context);
        O000000o(context);
    }

    public ConvenientBannerUnReusable(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.canLoop});
        this.O0000OoO = obtainStyledAttributes.getBoolean(0, true);
        obtainStyledAttributes.recycle();
        O000000o(context);
    }

    @TargetApi(11)
    public ConvenientBannerUnReusable(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.canLoop});
        this.O0000OoO = obtainStyledAttributes.getBoolean(0, true);
        obtainStyledAttributes.recycle();
        O000000o(context);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, com.mibigkoo.convenientbanner.ConvenientBannerUnReusable, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    private void O000000o(Context context) {
        View inflate = LayoutInflater.from(context).inflate((int) R.layout.include_viewpager, (ViewGroup) this, true);
        this.f5181O000000o = (CBLoopViewPager) inflate.findViewById(R.id.cbLoopViewPager);
        this.O0000OOo = (ViewGroup) inflate.findViewById(R.id.loPageTurningPoint);
        O00000Oo();
        this.O00000o = new O000000o(this);
    }

    static class O000000o implements Runnable {

        /* renamed from: O000000o  reason: collision with root package name */
        private final WeakReference<ConvenientBannerUnReusable> f5182O000000o;

        O000000o(ConvenientBannerUnReusable convenientBannerUnReusable) {
            this.f5182O000000o = new WeakReference<>(convenientBannerUnReusable);
        }

        public final void run() {
            ConvenientBannerUnReusable convenientBannerUnReusable = this.f5182O000000o.get();
            if (convenientBannerUnReusable != null && convenientBannerUnReusable.f5181O000000o != null && convenientBannerUnReusable.O00000o0) {
                convenientBannerUnReusable.f5181O000000o.setCurrentItem(convenientBannerUnReusable.f5181O000000o.getCurrentItem() + 1);
                convenientBannerUnReusable.postDelayed(convenientBannerUnReusable.O00000o, convenientBannerUnReusable.O00000Oo);
            }
        }
    }

    public void setPointViewTopMargin(int i) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.O0000OOo.getLayoutParams();
        layoutParams.topMargin = i;
        this.O0000OOo.setLayoutParams(layoutParams);
    }

    private void O000000o() {
        this.O00000o0 = false;
        removeCallbacks(this.O00000o);
    }

    private void O00000Oo() {
        try {
            Field declaredField = ViewPager.class.getDeclaredField("mScroller");
            declaredField.setAccessible(true);
            this.O0000O0o = new ViewPagerScroller(this.f5181O000000o.getContext());
            declaredField.set(this.f5181O000000o, this.O0000O0o);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e2) {
            e2.printStackTrace();
        } catch (IllegalAccessException e3) {
            e3.printStackTrace();
        }
    }

    public void setManualPageable(boolean z) {
        this.f5181O000000o.setCanScroll(z);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 1 || action == 3 || action == 4) {
            if (this.O0000Oo0) {
                long j = this.O00000Oo;
                if (this.O00000o0) {
                    O000000o();
                }
                this.O0000Oo0 = true;
                this.O00000Oo = j;
                this.O00000o0 = true;
                postDelayed(this.O00000o, j);
            }
        } else if (action == 0 && this.O0000Oo0) {
            O000000o();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public int getCurrentItem() {
        CBLoopViewPager cBLoopViewPager = this.f5181O000000o;
        if (cBLoopViewPager != null) {
            return cBLoopViewPager.getRealItem();
        }
        return -1;
    }

    public void setcurrentitem(int i) {
        CBLoopViewPager cBLoopViewPager = this.f5181O000000o;
        if (cBLoopViewPager != null) {
            cBLoopViewPager.setCurrentItem(i);
        }
    }

    public ViewPager.O0000O0o getOnPageChangeListener() {
        return this.O00000oo;
    }

    public void setScrollDuration(int i) {
        this.O0000O0o.f5183O000000o = i;
    }

    public int getScrollDuration() {
        return this.O0000O0o.f5183O000000o;
    }

    public CBLoopViewPager getViewPager() {
        return this.f5181O000000o;
    }

    public void setCanLoop(boolean z) {
        this.O0000OoO = z;
        this.f5181O000000o.setCanLoop(z);
    }
}
