package com.xiaomi.smarthome.library.common.widget;

import _m_j.gwg;
import android.animation.ArgbEvaluator;
import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.tabs.TabLayout;
import com.xiaomi.smarthome.R;

public class CoordinatorTabLayout extends CoordinatorLayout {

    /* renamed from: O000000o  reason: collision with root package name */
    public AppBarLayout f9158O000000o;
    public ArgbEvaluator O00000Oo = new ArgbEvaluator();
    public int O00000o = 0;
    public int O00000o0 = 0;
    public AppBarLayout.OnOffsetChangedListener O00000oO;
    public float O00000oo = 0.0f;
    public TabLayout.OnTabSelectedListener O0000O0o;
    private Context O0000OOo;
    private TabLayout O0000Oo;
    private Toolbar O0000Oo0;
    private FrameLayout O0000OoO;
    private CollapsingToolbarLayout O0000Ooo;

    public CoordinatorTabLayout(Context context) {
        super(context);
        this.O0000OOo = context;
    }

    public CoordinatorTabLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.O0000OOo = context;
        if (Build.VERSION.SDK_INT >= 3 && !isInEditMode()) {
            O000000o(context);
            O000000o(context, attributeSet);
        }
    }

    public CoordinatorTabLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.O0000OOo = context;
        if (Build.VERSION.SDK_INT >= 3 && !isInEditMode()) {
            O000000o(context);
            O000000o(context, attributeSet);
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, com.xiaomi.smarthome.library.common.widget.CoordinatorTabLayout, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    private void O000000o(Context context) {
        LayoutInflater.from(context).inflate((int) R.layout.view_coordinatortablayout, (ViewGroup) this, true);
        O000000o();
        this.O0000Ooo = (CollapsingToolbarLayout) findViewById(R.id.collapsingtoolbarlayout);
        this.O0000Oo = (TabLayout) findViewById(R.id.tabLayout);
        this.O0000OoO = (FrameLayout) findViewById(R.id.top_content_container);
        this.f9158O000000o = (AppBarLayout) findViewById(R.id.app_bar_layout);
        this.O00000o0 = getResources().getColor(R.color.mj_color_gray_normal);
        this.O00000o = getResources().getColor(R.color.mj_color_white);
        this.f9158O000000o.addOnOffsetChangedListener((AppBarLayout.OnOffsetChangedListener) new AppBarLayout.OnOffsetChangedListener() {
            /* class com.xiaomi.smarthome.library.common.widget.CoordinatorTabLayout.AnonymousClass1 */
            private int O00000Oo = 0;
            private boolean O00000o0 = true;

            public final void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                if (this.O00000Oo == 0) {
                    this.O00000Oo = appBarLayout.getTotalScrollRange();
                }
                if (this.O00000Oo != 0) {
                    if (CoordinatorTabLayout.this.O00000oO != null) {
                        CoordinatorTabLayout.this.O00000oO.onOffsetChanged(appBarLayout, i);
                    }
                    CoordinatorTabLayout.this.O00000oo = ((float) Math.abs(i)) / ((float) this.O00000Oo);
                    CoordinatorTabLayout.this.f9158O000000o.setBackgroundColor(((Integer) CoordinatorTabLayout.this.O00000Oo.evaluate(CoordinatorTabLayout.this.O00000oo, Integer.valueOf(CoordinatorTabLayout.this.O00000o0), Integer.valueOf(CoordinatorTabLayout.this.O00000o))).intValue());
                    if (CoordinatorTabLayout.this.O00000oo >= 1.0f) {
                        if (!this.O00000o0) {
                            this.O00000o0 = true;
                            gwg.O00000Oo(((Activity) CoordinatorTabLayout.this.getContext()).getWindow());
                        }
                    } else if (this.O00000o0) {
                        this.O00000o0 = false;
                        gwg.O00000o0((Activity) CoordinatorTabLayout.this.getContext());
                    }
                }
            }
        });
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() == 1) {
            if (((double) this.O00000oo) > 0.5d) {
                this.f9158O000000o.setExpanded(false, true);
            } else {
                this.f9158O000000o.setExpanded(true, true);
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    private void O000000o(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.contentScrim, R.attr.tabIndicatorColor, R.attr.tabTextColor});
        this.O0000Oo.setSelectedTabIndicatorColor(obtainStyledAttributes.getColor(1, getResources().getColor(R.color.mj_color_green_normal)));
        this.O0000Oo.setSelectedTabIndicatorHeight(0);
        this.O0000Oo.setTabTextColors(getResources().getColor(R.color.mj_color_gray_lighter), getResources().getColor(R.color.mj_color_green_normal));
        obtainStyledAttributes.recycle();
    }

    private void O000000o() {
        this.O0000Oo0 = (Toolbar) findViewById(R.id.title_bar);
    }

    public void setOnTabSelectedListener(TabLayout.OnTabSelectedListener onTabSelectedListener) {
        this.O0000O0o = onTabSelectedListener;
    }

    public TabLayout getTabLayout() {
        return this.O0000Oo;
    }

    public FrameLayout getTopContent() {
        return this.O0000OoO;
    }

    public void setTopContentView(View view) {
        this.O0000OoO.removeAllViews();
        this.O0000OoO.addView(view);
    }

    public void setHeaderView(View view) {
        this.O0000Oo0.removeAllViews();
        this.O0000Oo0.addView(view);
    }

    public void setOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener onOffsetChangedListener) {
        this.O00000oO = onOffsetChangedListener;
    }
}
