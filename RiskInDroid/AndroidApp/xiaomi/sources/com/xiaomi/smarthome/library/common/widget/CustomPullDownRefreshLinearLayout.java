package com.xiaomi.smarthome.library.common.widget;

import _m_j.gpo;
import _m_j.gsy;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import com.airbnb.lottie.LottieAnimationView;
import com.hb.views.PinnedSectionListView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.library.common.widget.viewflow.ViewFlow;
import java.lang.ref.WeakReference;

public class CustomPullDownRefreshLinearLayout extends LinearLayout {

    /* renamed from: O000000o  reason: collision with root package name */
    float f9164O000000o;
    int O00000Oo;
    public boolean O00000o = false;
    int O00000o0 = 0;
    O000000o O00000oO = new O000000o(this);
    View O00000oo = null;
    int O0000O0o = 0;
    int O0000OOo;
    PinnedSectionListView O0000Oo;
    ScrollView O0000Oo0;
    WebView O0000OoO;
    ViewFlow O0000Ooo;
    private LottieAnimationView O0000o;
    private final float O0000o0 = 1.5f;
    private final int O0000o00 = 16;
    private boolean O0000o0O = false;
    private float O0000o0o = 0.0f;
    private O00000o0 O0000oO;
    private boolean O0000oO0 = false;
    private O00000Oo O0000oOO;
    private View O0000oOo = null;
    private boolean O0000oo = true;
    private int O0000oo0 = Integer.MAX_VALUE;
    private boolean O0000ooO = true;
    private boolean O0000ooo = true;
    private CharSequence O000O00o;
    private boolean O00oOooO = false;
    private CharSequence O00oOooo;

    public interface O00000Oo {
        boolean O000000o();
    }

    public interface O00000o0 {
        void O000000o();
    }

    public CustomPullDownRefreshLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.scroll_bar_id});
        this.O0000OOo = obtainStyledAttributes.getResourceId(0, 0);
        obtainStyledAttributes.recycle();
        O00000o0();
    }

    public CustomPullDownRefreshLinearLayout(Context context) {
        super(context);
        O00000o0();
    }

    public void setScrollView(ScrollView scrollView) {
        this.O0000Oo0 = scrollView;
    }

    public void setListView(PinnedSectionListView pinnedSectionListView) {
        this.O0000Oo = pinnedSectionListView;
    }

    public void setWebView(WebView webView) {
        this.O0000OoO = webView;
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        if (this.O0000Oo0 == null) {
            this.O0000Oo0 = (ScrollView) findViewById(this.O0000OOo);
        }
    }

    public void setRefreshListener(O00000o0 o00000o0) {
        this.O0000oO = o00000o0;
    }

    public void setInterceptListener(O00000Oo o00000Oo) {
        this.O0000oOO = o00000Oo;
    }

    public void setShowRefreshProgress(boolean z) {
        this.O0000ooo = z;
    }

    public final void O000000o() {
        if (this.O00000o || this.O0000oO == null) {
            gpo.O00000Oo(this.O0000o);
            return;
        }
        this.O00000o = true;
        ViewGroup.LayoutParams layoutParams = this.O00000oo.getLayoutParams();
        if (this.O00000o0 == 0) {
            this.O00000o0 = getContext().getResources().getDimensionPixelSize(R.dimen.pull_down_header_height);
        }
        layoutParams.height = this.O00000o0 + this.O0000O0o;
        this.O00000oo.setLayoutParams(layoutParams);
        gpo.O000000o(this.O0000o);
        this.O0000oO.O000000o();
    }

    public final void O00000Oo() {
        this.O00000o = false;
        ViewGroup.LayoutParams layoutParams = this.O00000oo.getLayoutParams();
        layoutParams.height = this.O0000O0o + this.O00000o0;
        this.O00000oo.setLayoutParams(layoutParams);
        this.O00000oO.sendEmptyMessageDelayed(0, 16);
        gpo.O00000Oo(this.O0000o);
    }

    public void setPullDownEnabled(boolean z) {
        this.O0000oo = z;
    }

    @SuppressLint({"NewApi"})
    private void O00000o0() {
        if (Build.VERSION.SDK_INT >= 14) {
            setOverScrollMode(2);
        }
        if (!isInEditMode()) {
            this.f9164O000000o = (getResources().getDisplayMetrics().density * 1.5f) + 0.5f;
            this.O00oOooo = getContext().getString(R.string.pull_down_refresh);
            this.O000O00o = getContext().getString(R.string.release_to_refresh);
            this.O00000Oo = getResources().getDimensionPixelSize(R.dimen.pull_down_refresh_threshold);
            this.O0000oOo = LayoutInflater.from(getContext()).inflate((int) R.layout.sm_widget_pull_header, (ViewGroup) null);
            this.O00000oo = this.O0000oOo.findViewById(R.id.pull_header);
            this.O0000o = (LottieAnimationView) this.O0000oOo.findViewById(R.id.pull_animation);
            addView(this.O0000oOo, 0);
        }
    }

    public void setCanPullDown(boolean z) {
        this.O0000ooO = z;
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        WebView webView;
        ScrollView scrollView;
        PinnedSectionListView pinnedSectionListView;
        WebView webView2;
        ScrollView scrollView2;
        PinnedSectionListView pinnedSectionListView2;
        if (!this.O0000ooO) {
            return super.dispatchTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.O00oOooO = false;
            if (this.O0000oo) {
                this.O0000oO0 = false;
                if (!this.O00000o && (((webView = this.O0000OoO) != null && webView.getScrollY() <= 0) || (((scrollView = this.O0000Oo0) != null && scrollView.getScrollY() <= 0) || ((pinnedSectionListView = this.O0000Oo) != null && pinnedSectionListView.O00000oO)))) {
                    this.O0000o0O = true;
                    this.O0000o0o = motionEvent.getY();
                }
                gpo.O000000o(this.O0000o);
            }
        } else if (action == 1) {
            if (this.O0000o0O) {
                O00000Oo o00000Oo = this.O0000oOO;
                if (o00000Oo == null || !o00000Oo.O000000o()) {
                    this.O00000oO.sendEmptyMessage(0);
                    if (this.O0000oO0) {
                        O000000o();
                    }
                } else if (!this.O0000oO0) {
                    this.O00000oO.sendEmptyMessage(0);
                }
                this.O0000o0O = false;
            }
            this.O00oOooO = false;
        } else if (action == 2) {
            ViewFlow viewFlow = this.O0000Ooo;
            if (viewFlow != null) {
                if (viewFlow.O00000o0 == 1) {
                    return super.dispatchTouchEvent(motionEvent);
                }
            }
            boolean z = this.O0000o0O;
            if (z) {
                float y = motionEvent.getY();
                if (y - this.O0000o0o > 10.0f) {
                    ViewGroup.LayoutParams layoutParams = this.O00000oo.getLayoutParams();
                    this.O00000o0 = (int) ((y - this.O0000o0o) / 2.0f);
                    int i = this.O00000o0;
                    int i2 = this.O0000O0o;
                    int i3 = i + i2;
                    int i4 = this.O0000oo0;
                    if (i3 < i4) {
                        layoutParams.height = i + i2;
                        this.O00000oo.setLayoutParams(layoutParams);
                        if (this.O00000o0 >= this.O00000Oo) {
                            if (!this.O0000oO0) {
                                this.O0000oO0 = true;
                            }
                        } else if (this.O0000oO0) {
                            this.O0000oO0 = false;
                        }
                    } else {
                        this.O00000o0 = Math.max(0, i4 - i2);
                    }
                    gsy.O000000o(6, "CustomPullDownLinearLayout", motionEvent.toString());
                    motionEvent.setAction(3);
                    super.dispatchTouchEvent(motionEvent);
                    this.O00oOooO = true;
                    return true;
                }
            } else if (this.O0000oo && !z && !this.O00000o && ((((webView2 = this.O0000OoO) != null && webView2.getScrollY() <= 0) || (((scrollView2 = this.O0000Oo0) != null && scrollView2.getScrollY() <= 0) || ((pinnedSectionListView2 = this.O0000Oo) != null && pinnedSectionListView2.O00000oO))) && this.O0000oOo.getTop() >= 0)) {
                this.O0000o0O = true;
                this.O0000o0o = motionEvent.getY();
                this.O0000oO0 = false;
                gpo.O000000o(this.O0000o);
            }
        } else if (action == 3) {
            if (this.O0000o0O) {
                this.O00000oO.sendEmptyMessage(0);
            }
            this.O0000o0O = false;
            this.O00oOooO = false;
        }
        try {
            return super.dispatchTouchEvent(motionEvent);
        } catch (Exception unused) {
            return true;
        }
    }

    static final class O000000o extends Handler {

        /* renamed from: O000000o  reason: collision with root package name */
        private WeakReference<CustomPullDownRefreshLinearLayout> f9165O000000o;

        public O000000o(CustomPullDownRefreshLinearLayout customPullDownRefreshLinearLayout) {
            this.f9165O000000o = new WeakReference<>(customPullDownRefreshLinearLayout);
        }

        public final void handleMessage(Message message) {
            CustomPullDownRefreshLinearLayout customPullDownRefreshLinearLayout = this.f9165O000000o.get();
            if (customPullDownRefreshLinearLayout != null) {
                if (message.what == 0) {
                    ViewGroup.LayoutParams layoutParams = customPullDownRefreshLinearLayout.O00000oo.getLayoutParams();
                    if (customPullDownRefreshLinearLayout.O00000o0 >= 0) {
                        customPullDownRefreshLinearLayout.O00000o0 = (int) (((float) customPullDownRefreshLinearLayout.O00000o0) - ((customPullDownRefreshLinearLayout.O00000o ? customPullDownRefreshLinearLayout.f9164O000000o : customPullDownRefreshLinearLayout.f9164O000000o / 2.0f) * 16.0f));
                        if (customPullDownRefreshLinearLayout.O00000o && customPullDownRefreshLinearLayout.O00000o0 <= customPullDownRefreshLinearLayout.O00000Oo) {
                            customPullDownRefreshLinearLayout.O00000o0 = customPullDownRefreshLinearLayout.O00000Oo;
                            layoutParams.height = customPullDownRefreshLinearLayout.O00000o0 + customPullDownRefreshLinearLayout.O0000O0o;
                            customPullDownRefreshLinearLayout.O00000oo.setLayoutParams(layoutParams);
                            customPullDownRefreshLinearLayout.O00000oO.removeMessages(0);
                        } else if (customPullDownRefreshLinearLayout.O00000o0 <= 0) {
                            customPullDownRefreshLinearLayout.O00000o0 = 0;
                            layoutParams.height = customPullDownRefreshLinearLayout.O00000o0 + customPullDownRefreshLinearLayout.O0000O0o;
                            customPullDownRefreshLinearLayout.O00000oo.setLayoutParams(layoutParams);
                            customPullDownRefreshLinearLayout.O00000oO.removeMessages(0);
                        } else {
                            layoutParams.height = customPullDownRefreshLinearLayout.O00000o0 + customPullDownRefreshLinearLayout.O0000O0o;
                            customPullDownRefreshLinearLayout.O00000oo.setLayoutParams(layoutParams);
                        }
                    }
                    customPullDownRefreshLinearLayout.O00000oO.sendEmptyMessageDelayed(0, 16);
                }
                super.handleMessage(message);
            }
        }
    }
}
