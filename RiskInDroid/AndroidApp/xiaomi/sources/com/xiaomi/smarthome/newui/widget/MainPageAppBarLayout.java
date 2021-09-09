package com.xiaomi.smarthome.newui.widget;

import _m_j.gzs;
import _m_j.hxi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.AppBarLayoutSpringBehavior;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.newui.widget.SimplePushToRefreshHeader;
import com.xiaomi.smarthome.newui.widget.banner.CustomBannerHeaderView;
import java.lang.ref.WeakReference;

public class MainPageAppBarLayout extends AppBarLayout {

    /* renamed from: O000000o  reason: collision with root package name */
    public CustomBannerHeaderView f10315O000000o;
    public SimplePushToRefreshHeader O00000Oo;
    public View O00000o;
    public MainConstraintLayout O00000o0;
    public AppBarLayoutSpringBehavior O00000oO;
    public boolean O00000oo = true;
    public int O0000O0o = 0;
    boolean O0000OOo = false;
    boolean O0000Oo = false;
    public boolean O0000Oo0 = false;
    boolean O0000OoO = true;
    public boolean O0000Ooo = true;
    private final long O0000o = ((long) ViewConfiguration.getTapTimeout());
    private SimplePushToRefreshHeader.O000000o O0000o0;
    private View O0000o00;
    private AppBarLayout.OnOffsetChangedListener O0000o0O = new AppBarLayout.OnOffsetChangedListener() {
        /* class com.xiaomi.smarthome.newui.widget.MainPageAppBarLayout.AnonymousClass2 */
        private int O00000Oo = Integer.MAX_VALUE;

        public final void onOffsetChanged(AppBarLayout appBarLayout, int i) {
            int i2 = this.O00000Oo;
            if (i2 == Integer.MAX_VALUE) {
                this.O00000Oo = i;
            } else if (i2 == i) {
                return;
            }
            this.O00000Oo = i;
            float totalScrollRange = (float) appBarLayout.getTotalScrollRange();
            float abs = ((float) Math.abs(i)) / totalScrollRange;
            MainPageAppBarLayout mainPageAppBarLayout = MainPageAppBarLayout.this;
            if (abs >= 0.3f) {
                if (mainPageAppBarLayout.O0000OoO) {
                    mainPageAppBarLayout.O0000OoO = false;
                }
            } else if (!mainPageAppBarLayout.O0000OoO) {
                mainPageAppBarLayout.O0000OoO = true;
            }
            MainPageAppBarLayout mainPageAppBarLayout2 = MainPageAppBarLayout.this;
            if (abs >= 0.9f) {
                if (!mainPageAppBarLayout2.O0000Oo) {
                    mainPageAppBarLayout2.O0000Oo = true;
                }
            } else if (mainPageAppBarLayout2.O0000Oo) {
                mainPageAppBarLayout2.O0000Oo = false;
            }
            float abs2 = ((float) Math.abs(Math.abs(i))) / totalScrollRange;
            if (MainPageAppBarLayout.this.f10315O000000o != null) {
                MainPageAppBarLayout.this.f10315O000000o.setAlpha(1.0f - abs2);
            }
            if (((double) abs2) > 0.8d) {
                float f = 1.0f - ((abs2 - 0.8f) * 5.0f);
                MainPageAppBarLayout.this.findViewById(R.id.home_name_tv).setAlpha(f);
                MainPageAppBarLayout.this.findViewById(R.id.add_device_btn).setAlpha(f);
                MainPageAppBarLayout.this.findViewById(R.id.message_center_icon).setAlpha(f);
            } else {
                MainPageAppBarLayout.this.findViewById(R.id.home_name_tv).setAlpha(1.0f);
                MainPageAppBarLayout.this.findViewById(R.id.add_device_btn).setAlpha(1.0f);
                MainPageAppBarLayout.this.findViewById(R.id.message_center_icon).setAlpha(1.0f);
            }
            if (MainPageAppBarLayout.this.O00000o == null) {
                MainPageAppBarLayout mainPageAppBarLayout3 = MainPageAppBarLayout.this;
                mainPageAppBarLayout3.O00000o = mainPageAppBarLayout3.findViewById(R.id.title_bar_content);
            }
            if (abs2 >= 1.0f) {
                MainPageAppBarLayout mainPageAppBarLayout4 = MainPageAppBarLayout.this;
                mainPageAppBarLayout4.O0000Oo0 = true;
                if (mainPageAppBarLayout4.O00000o != null) {
                    MainPageAppBarLayout.this.O00000o.setBackgroundColor(0);
                    MainPageAppBarLayout.this.O00000o.setAlpha(1.0f);
                    ((TextView) MainPageAppBarLayout.this.O00000o.findViewById(R.id.home_name_tv)).setVisibility(8);
                }
                MainPageAppBarLayout.this.O000000o();
                if (!MainPageAppBarLayout.this.O00000oo) {
                    MainPageAppBarLayout.this.O00000oo = true;
                    return;
                }
                return;
            }
            MainPageAppBarLayout mainPageAppBarLayout5 = MainPageAppBarLayout.this;
            mainPageAppBarLayout5.O0000Oo0 = false;
            if (mainPageAppBarLayout5.O00000oo) {
                MainPageAppBarLayout mainPageAppBarLayout6 = MainPageAppBarLayout.this;
                mainPageAppBarLayout6.O00000oo = false;
                mainPageAppBarLayout6.O000000o();
                if (MainPageAppBarLayout.this.O00000o != null) {
                    MainPageAppBarLayout.this.O00000o.setBackgroundColor(0);
                    MainPageAppBarLayout.this.O00000o.setAlpha(1.0f);
                    ((TextView) MainPageAppBarLayout.this.O00000o.findViewById(R.id.home_name_tv)).setVisibility(0);
                }
            }
        }
    };
    private WeakReference<gzs> O0000o0o;
    private long O0000oO = -1;
    private final float O0000oO0 = ((float) ViewConfiguration.get(getContext()).getScaledTouchSlop());
    private float O0000oOO = -1.0f;
    private float O0000oOo = -1.0f;

    public MainPageAppBarLayout(Context context) {
        super(context);
    }

    public MainPageAppBarLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f10315O000000o = (CustomBannerHeaderView) findViewById(R.id.custom_header_view);
        this.O00000Oo = (SimplePushToRefreshHeader) findViewById(R.id.pull_to_refresh_indicator);
        this.O00000o0 = (MainConstraintLayout) findViewById(R.id.title_bar_content);
        SimplePushToRefreshHeader.O000000o o000000o = this.O0000o0;
        if (o000000o != null) {
            this.O00000Oo.setOnRefreshListener(o000000o);
        }
        this.O0000o00 = findViewById(R.id.loading_container);
        post(new Runnable() {
            /* class com.xiaomi.smarthome.newui.widget.MainPageAppBarLayout.AnonymousClass1 */

            public final void run() {
                MainPageAppBarLayout mainPageAppBarLayout = MainPageAppBarLayout.this;
                mainPageAppBarLayout.O00000oO = (AppBarLayoutSpringBehavior) ((CoordinatorLayout.O00000o) mainPageAppBarLayout.getLayoutParams()).f2811O000000o;
                MainPageAppBarLayout.this.O00000oO.addSpringOffsetCallback(new AppBarLayoutSpringBehavior.SpringOffsetCallback() {
                    /* class com.xiaomi.smarthome.newui.widget.MainPageAppBarLayout.AnonymousClass1.AnonymousClass1 */

                    public final void springCallback(int i) {
                        if (MainPageAppBarLayout.this.f10315O000000o != null) {
                            CustomBannerHeaderView customBannerHeaderView = MainPageAppBarLayout.this.f10315O000000o;
                            if (customBannerHeaderView.O00000oO == 0) {
                                customBannerHeaderView.O00000oO = customBannerHeaderView.getHeight();
                            }
                        }
                    }
                });
                MainPageAppBarLayout.this.O00000oO.addPullToRefreshCallback(MainPageAppBarLayout.this.O00000Oo);
                MainPageAppBarLayout.this.O00000oO.addPullToRefreshCallback(MainPageAppBarLayout.this.O00000o0);
                MainPageAppBarLayout.this.O00000oO.addPullToRefreshCallback(MainPageAppBarLayout.this.f10315O000000o);
                MainPageAppBarLayout.this.O00000oO.setContentHeight(MainPageAppBarLayout.this.O0000O0o);
                MainPageAppBarLayout.this.O00000oO.setNormalScrollEnable(MainPageAppBarLayout.this.O0000Ooo, (CoordinatorLayout) MainPageAppBarLayout.this.getParent(), MainPageAppBarLayout.this);
            }
        });
    }

    public int getContentHeight() {
        return this.O0000O0o;
    }

    public void setContentHeight(int i) {
        this.O0000O0o = i;
        getLayoutParams().height = i;
        AppBarLayoutSpringBehavior appBarLayoutSpringBehavior = this.O00000oO;
        if (appBarLayoutSpringBehavior != null) {
            appBarLayoutSpringBehavior.setContentHeight(i);
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        View view = this.O0000o00;
        if (view != null && !this.O0000OOo) {
            this.O0000OOo = true;
            view.getLayoutParams();
            getResources().getDimensionPixelSize(R.dimen.mainpage_titlebar_height);
        }
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        addOnOffsetChangedListener(this.O0000o0O);
    }

    public final void O000000o() {
        gzs gzs;
        WeakReference<gzs> weakReference = this.O0000o0o;
        if (weakReference != null && (gzs = weakReference.get()) != null) {
            gzs.refreshTitleBar();
        }
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeOnOffsetChangedListener(this.O0000o0O);
    }

    public void setOnRefreshListener(SimplePushToRefreshHeader.O000000o o000000o) {
        SimplePushToRefreshHeader simplePushToRefreshHeader = this.O00000Oo;
        if (simplePushToRefreshHeader != null) {
            simplePushToRefreshHeader.setOnRefreshListener(o000000o);
        } else {
            this.O0000o0 = o000000o;
        }
    }

    public void setDeviceMainPage(gzs gzs) {
        this.O0000o0o = new WeakReference<>(gzs);
    }

    public final void O000000o(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
        AppBarLayoutSpringBehavior appBarLayoutSpringBehavior = this.O00000oO;
        if (appBarLayoutSpringBehavior != null) {
            appBarLayoutSpringBehavior.collapse(coordinatorLayout, appBarLayout);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.O0000oO = System.currentTimeMillis();
            this.O0000oOO = motionEvent.getX();
            this.O0000oOo = motionEvent.getY();
        } else if (action == 1) {
            if (System.currentTimeMillis() - this.O0000oO <= this.O0000o && Math.abs(motionEvent.getX() - this.O0000oOO) <= this.O0000oO0 && Math.abs(motionEvent.getY() - this.O0000oOo) <= this.O0000oO0) {
                hxi.O00000o.f952O000000o.O000000o("background_empty", "clk", 1);
            }
        }
        return true;
    }
}
