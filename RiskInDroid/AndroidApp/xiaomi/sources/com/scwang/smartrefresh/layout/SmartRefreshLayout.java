package com.scwang.smartrefresh.layout;

import _m_j.br;
import _m_j.bs;
import _m_j.bv;
import _m_j.czo;
import _m_j.czp;
import _m_j.czq;
import _m_j.czs;
import _m_j.czt;
import _m_j.czu;
import _m_j.czv;
import _m_j.czw;
import _m_j.czx;
import _m_j.czy;
import _m_j.czz;
import _m_j.daa;
import _m_j.dab;
import _m_j.dai;
import _m_j.daj;
import _m_j.dak;
import _m_j.dan;
import _m_j.dao;
import _m_j.dar;
import _m_j.das;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.webkit.WebView;
import android.widget.AbsListView;
import android.widget.ScrollView;
import android.widget.Scroller;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.exoplayer2.C;
import com.google.android.gms.common.internal.GmsLogger;
import com.scwang.smartrefresh.layout.constant.DimensionStatus;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.footer.BallPulseFooter;
import com.scwang.smartrefresh.layout.header.BezierRadarHeader;
import com.xiaomi.smarthome.R;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import no.nordicsemi.android.dfu.DfuSettingsConstants;

@SuppressLint({"RestrictedApi"})
public class SmartRefreshLayout extends ViewGroup implements bs, czx {
    protected static czo O000oo0 = new czo() {
        /* class com.scwang.smartrefresh.layout.SmartRefreshLayout.AnonymousClass1 */

        public final czt O000000o(Context context) {
            return new BallPulseFooter(context);
        }
    };
    protected static czp O000oo0O = new czp() {
        /* class com.scwang.smartrefresh.layout.SmartRefreshLayout.AnonymousClass3 */

        public final czu O000000o(Context context) {
            return new BezierRadarHeader(context);
        }
    };
    protected static czq O000oo0o;

    /* renamed from: O000000o  reason: collision with root package name */
    protected int f5558O000000o;
    protected int O00000Oo;
    protected int O00000o;
    protected int O00000o0;
    protected int O00000oO;
    protected int O00000oo;
    protected int O0000O0o;
    protected float O0000OOo;
    protected float O0000Oo;
    protected float O0000Oo0;
    protected float O0000OoO;
    protected float O0000Ooo;
    protected int O0000o;
    protected boolean O0000o0;
    protected char O0000o00;
    protected boolean O0000o0O;
    protected int O0000o0o;
    protected int O0000oO;
    protected int O0000oO0;
    protected int O0000oOO;
    protected int O0000oOo;
    protected Scroller O0000oo;
    protected int O0000oo0;
    protected VelocityTracker O0000ooO;
    protected Interpolator O0000ooo;
    protected boolean O000O00o;
    protected boolean O000O0OO;
    protected boolean O000O0Oo;
    protected boolean O000O0o;
    protected boolean O000O0o0;
    protected boolean O000O0oO;
    protected boolean O000O0oo;
    protected boolean O000OO;
    protected boolean O000OO00;
    protected boolean O000OO0o;
    protected boolean O000OOOo;
    protected boolean O000OOo;
    protected boolean O000OOo0;
    protected boolean O000OOoO;
    protected boolean O000OOoo;
    protected boolean O000Oo0;
    protected boolean O000Oo00;
    protected boolean O000Oo0O;
    protected boolean O000Oo0o;
    protected dai O000OoO;
    protected boolean O000OoO0;
    protected daj O000OoOO;
    protected czy O000OoOo;
    protected boolean O000Ooo;
    protected int O000Ooo0;
    protected int[] O000OooO;
    protected br O000Oooo;
    protected czv O000o;
    protected DimensionStatus O000o0;
    protected int O000o00;
    protected bv O000o000;
    protected DimensionStatus O000o00O;
    protected int O000o00o;
    protected int O000o0O;
    protected int O000o0O0;
    protected float O000o0OO;
    protected float O000o0Oo;
    protected float O000o0o;
    protected float O000o0o0;
    protected czv O000o0oo;
    protected List<dan> O000oO;
    protected Paint O000oO0;
    protected czs O000oO00;
    protected Handler O000oO0O;
    protected czw O000oO0o;
    protected RefreshState O000oOO;
    protected RefreshState O000oOO0;
    protected long O000oOOO;
    protected int O000oOOo;
    protected boolean O000oOo;
    protected int O000oOo0;
    protected boolean O000oOoO;
    protected boolean O000oOoo;
    protected boolean O000oo;
    protected Runnable O000ooO;
    protected MotionEvent O000ooO0;
    protected ValueAnimator O000ooOO;
    protected dak O00O0Oo;
    protected boolean O00oOoOo;
    protected int[] O00oOooO;
    protected boolean O00oOooo;

    public SmartRefreshLayout getLayout() {
        return this;
    }

    public final /* synthetic */ czx O0000OOo() {
        return O000000o(0);
    }

    public SmartRefreshLayout(Context context) {
        this(context, null);
    }

    public SmartRefreshLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SmartRefreshLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.O00000oO = 250;
        this.O00000oo = 250;
        this.O0000Ooo = 0.5f;
        this.O0000o00 = 'n';
        this.O0000o0o = -1;
        this.O0000o = -1;
        this.O0000oO0 = -1;
        this.O0000oO = -1;
        this.O00oOooo = true;
        this.O000O00o = false;
        this.O000O0OO = true;
        this.O000O0Oo = true;
        this.O00oOoOo = true;
        this.O000O0o0 = true;
        this.O000O0o = false;
        this.O000O0oO = true;
        this.O000O0oo = true;
        this.O000OO00 = false;
        this.O000OO0o = true;
        this.O000OO = false;
        this.O000OOOo = true;
        this.O000OOo0 = true;
        this.O000OOo = true;
        this.O000OOoO = false;
        this.O000OOoo = false;
        this.O000Oo00 = false;
        this.O000Oo0 = false;
        this.O000Oo0O = false;
        this.O000Oo0o = false;
        this.O000OoO0 = false;
        this.O000OooO = new int[2];
        this.O000Oooo = new br(this);
        this.O000o000 = new bv();
        this.O000o00O = DimensionStatus.DefaultUnNotify;
        this.O000o0 = DimensionStatus.DefaultUnNotify;
        this.O000o0OO = 2.5f;
        this.O000o0Oo = 2.5f;
        this.O000o0o0 = 1.0f;
        this.O000o0o = 1.0f;
        this.O000oO0o = new O00000o0();
        this.O000oOO0 = RefreshState.None;
        this.O000oOO = RefreshState.None;
        this.O000oOOO = 0;
        this.O000oOOo = 0;
        this.O000oOo0 = 0;
        this.O000oOoo = false;
        this.O000oo = false;
        this.O000ooO0 = null;
        super.setClipToPadding(false);
        dao dao = new dao();
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.O0000oo = new Scroller(context);
        this.O0000ooO = VelocityTracker.obtain();
        this.O0000O0o = context.getResources().getDisplayMetrics().heightPixels;
        this.O0000ooo = new das();
        this.f5558O000000o = viewConfiguration.getScaledTouchSlop();
        this.O0000oOO = viewConfiguration.getScaledMinimumFlingVelocity();
        this.O0000oOo = viewConfiguration.getScaledMaximumFlingVelocity();
        this.O000o00o = dao.O00000Oo(60.0f);
        this.O000o00 = dao.O00000Oo(100.0f);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.srlAccentColor, R.attr.srlDisableContentWhenLoading, R.attr.srlDisableContentWhenRefresh, R.attr.srlDragRate, R.attr.srlEnableAutoLoadMore, R.attr.srlEnableClipFooterWhenFixedBehind, R.attr.srlEnableClipHeaderWhenFixedBehind, R.attr.srlEnableFooterFollowWhenLoadFinished, R.attr.srlEnableFooterTranslationContent, R.attr.srlEnableHeaderTranslationContent, R.attr.srlEnableLoadMore, R.attr.srlEnableLoadMoreWhenContentNotFull, R.attr.srlEnableNestedScrolling, R.attr.srlEnableOverScrollBounce, R.attr.srlEnableOverScrollDrag, R.attr.srlEnablePreviewInEditMode, R.attr.srlEnablePureScrollMode, R.attr.srlEnableRefresh, R.attr.srlEnableScrollContentWhenLoaded, R.attr.srlEnableScrollContentWhenRefreshed, R.attr.srlFixedFooterViewId, R.attr.srlFixedHeaderViewId, R.attr.srlFooterHeight, R.attr.srlFooterInsetStart, R.attr.srlFooterMaxDragRate, R.attr.srlFooterTranslationViewId, R.attr.srlFooterTriggerRate, R.attr.srlHeaderHeight, R.attr.srlHeaderInsetStart, R.attr.srlHeaderMaxDragRate, R.attr.srlHeaderTranslationViewId, R.attr.srlHeaderTriggerRate, R.attr.srlPrimaryColor, R.attr.srlReboundDuration});
        br brVar = this.O000Oooo;
        brVar.O000000o(obtainStyledAttributes.getBoolean(12, brVar.f13211O000000o));
        this.O0000Ooo = obtainStyledAttributes.getFloat(3, this.O0000Ooo);
        this.O000o0OO = obtainStyledAttributes.getFloat(29, this.O000o0OO);
        this.O000o0Oo = obtainStyledAttributes.getFloat(24, this.O000o0Oo);
        this.O000o0o0 = obtainStyledAttributes.getFloat(31, this.O000o0o0);
        this.O000o0o = obtainStyledAttributes.getFloat(26, this.O000o0o);
        this.O00oOooo = obtainStyledAttributes.getBoolean(17, this.O00oOooo);
        this.O00000oo = obtainStyledAttributes.getInt(33, this.O00000oo);
        this.O000O00o = obtainStyledAttributes.getBoolean(10, this.O000O00o);
        this.O000o00 = obtainStyledAttributes.getDimensionPixelOffset(27, this.O000o00);
        this.O000o00o = obtainStyledAttributes.getDimensionPixelOffset(22, this.O000o00o);
        this.O000o0O0 = obtainStyledAttributes.getDimensionPixelOffset(28, this.O000o0O0);
        this.O000o0O = obtainStyledAttributes.getDimensionPixelOffset(23, this.O000o0O);
        this.O000OOoO = obtainStyledAttributes.getBoolean(2, this.O000OOoO);
        this.O000OOoo = obtainStyledAttributes.getBoolean(1, this.O000OOoo);
        this.O00oOoOo = obtainStyledAttributes.getBoolean(9, this.O00oOoOo);
        this.O000O0o0 = obtainStyledAttributes.getBoolean(8, this.O000O0o0);
        this.O000O0oO = obtainStyledAttributes.getBoolean(15, this.O000O0oO);
        this.O000OO0o = obtainStyledAttributes.getBoolean(4, this.O000OO0o);
        this.O000O0oo = obtainStyledAttributes.getBoolean(13, this.O000O0oo);
        this.O000OO = obtainStyledAttributes.getBoolean(16, this.O000OO);
        this.O000OOOo = obtainStyledAttributes.getBoolean(18, this.O000OOOo);
        this.O000OOo0 = obtainStyledAttributes.getBoolean(19, this.O000OOo0);
        this.O000OOo = obtainStyledAttributes.getBoolean(11, this.O000OOo);
        this.O000O0o = obtainStyledAttributes.getBoolean(7, this.O000O0o);
        this.O000O0OO = obtainStyledAttributes.getBoolean(6, this.O000O0OO);
        this.O000O0Oo = obtainStyledAttributes.getBoolean(5, this.O000O0Oo);
        this.O000OO00 = obtainStyledAttributes.getBoolean(14, this.O000OO00);
        this.O0000o0o = obtainStyledAttributes.getResourceId(21, this.O0000o0o);
        this.O0000o = obtainStyledAttributes.getResourceId(20, this.O0000o);
        this.O0000oO0 = obtainStyledAttributes.getResourceId(30, this.O0000oO0);
        this.O0000oO = obtainStyledAttributes.getResourceId(25, this.O0000oO);
        if (this.O000OO && !obtainStyledAttributes.hasValue(14)) {
            this.O000OO00 = true;
        }
        this.O000Oo0 = obtainStyledAttributes.hasValue(10);
        this.O000Oo0o = obtainStyledAttributes.hasValue(9);
        this.O000OoO0 = obtainStyledAttributes.hasValue(8);
        this.O000Oo0O = this.O000Oo0O || obtainStyledAttributes.hasValue(12);
        this.O000o00O = obtainStyledAttributes.hasValue(27) ? DimensionStatus.XmlLayoutUnNotify : this.O000o00O;
        this.O000o0 = obtainStyledAttributes.hasValue(22) ? DimensionStatus.XmlLayoutUnNotify : this.O000o0;
        int color = obtainStyledAttributes.getColor(0, 0);
        int color2 = obtainStyledAttributes.getColor(32, 0);
        if (color2 != 0) {
            if (color != 0) {
                this.O00oOooO = new int[]{color2, color};
            } else {
                this.O00oOooO = new int[]{color2};
            }
        } else if (color != 0) {
            this.O00oOooO = new int[]{0, color};
        }
        obtainStyledAttributes.recycle();
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0051  */
    public void onFinishInflate() {
        int i;
        int i2;
        int i3;
        super.onFinishInflate();
        int childCount = super.getChildCount();
        if (childCount <= 3) {
            int i4 = 0;
            int i5 = -1;
            int i6 = 0;
            while (true) {
                i = 2;
                if (i4 >= childCount) {
                    break;
                }
                View childAt = super.getChildAt(i4);
                if (!dar.O00000o0(childAt) || (i6 >= 2 && i4 != 1)) {
                    if (!(childAt instanceof czv) && i6 <= 0) {
                        i = i4 > 0 ? 1 : 0;
                    }
                    i4++;
                }
                i5 = i4;
                i6 = i;
                i4++;
            }
            if (i5 >= 0) {
                this.O000oO00 = new czz(super.getChildAt(i5));
                if (i5 == 1) {
                    if (childCount == 3) {
                        i2 = 0;
                    } else {
                        i2 = 0;
                        i = -1;
                    }
                } else if (childCount == 2) {
                    i2 = -1;
                    i = 1;
                }
                for (i3 = 0; i3 < childCount; i3++) {
                    View childAt2 = super.getChildAt(i3);
                    if (i3 == i2 || (i3 != i && i2 == -1 && this.O000o0oo == null && (childAt2 instanceof czu))) {
                        this.O000o0oo = childAt2 instanceof czu ? (czu) childAt2 : new dab(childAt2);
                    } else if (i3 == i || (i == -1 && (childAt2 instanceof czt))) {
                        this.O000O00o = this.O000O00o || !this.O000Oo0;
                        this.O000o = childAt2 instanceof czt ? (czt) childAt2 : new daa(childAt2);
                    }
                }
                return;
            }
            i2 = -1;
            i = -1;
            while (i3 < childCount) {
            }
            return;
        }
        throw new RuntimeException("最多只支持3个子View，Most only support three sub view");
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        czv czv;
        super.onAttachedToWindow();
        if (!isInEditMode()) {
            if (this.O000oO0O == null) {
                this.O000oO0O = new Handler();
            }
            List<dan> list = this.O000oO;
            View view = null;
            if (list != null) {
                for (dan next : list) {
                    this.O000oO0O.postDelayed(next, next.f14417O000000o);
                }
                this.O000oO.clear();
                this.O000oO = null;
            }
            if (this.O000o0oo == null) {
                czu O000000o2 = O000oo0O.O000000o(getContext());
                czv czv2 = this.O000o0oo;
                if (czv2 != null) {
                    super.removeView(czv2.getView());
                }
                this.O000o0oo = O000000o2;
                this.O000oOOo = 0;
                this.O000oOo = false;
                this.O000o00O = this.O000o00O.unNotify();
                if (O000000o2.getSpinnerStyle() == SpinnerStyle.FixedBehind) {
                    super.addView(this.O000o0oo.getView(), 0, new LayoutParams(-1, -2));
                } else {
                    super.addView(this.O000o0oo.getView(), -1, -2);
                }
            }
            boolean z = true;
            if (this.O000o == null) {
                czt O000000o3 = O000oo0.O000000o(getContext());
                czv czv3 = this.O000o;
                if (czv3 != null) {
                    super.removeView(czv3.getView());
                }
                this.O000o = O000000o3;
                this.O000oOo0 = 0;
                this.O000oOoO = false;
                this.O000o0 = this.O000o0.unNotify();
                if (this.O000Oo0 && !this.O000O00o) {
                    z = false;
                }
                this.O000O00o = z;
                if (this.O000o.getSpinnerStyle() == SpinnerStyle.FixedBehind) {
                    super.addView(this.O000o.getView(), 0, new LayoutParams(-1, -2));
                } else {
                    super.addView(this.O000o.getView(), -1, -2);
                }
            } else {
                if (!this.O000O00o && this.O000Oo0) {
                    z = false;
                }
                this.O000O00o = z;
            }
            if (this.O000oO00 == null) {
                int childCount = getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = getChildAt(i);
                    czv czv4 = this.O000o0oo;
                    if ((czv4 == null || childAt != czv4.getView()) && ((czv = this.O000o) == null || childAt != czv.getView())) {
                        this.O000oO00 = new czz(childAt);
                    }
                }
            }
            if (this.O000oO00 == null) {
                int O000000o4 = dao.O000000o(20.0f);
                TextView textView = new TextView(getContext());
                textView.setTextColor(-39424);
                textView.setGravity(17);
                textView.setTextSize(20.0f);
                textView.setText((int) R.string.srl_content_empty);
                super.addView(textView, -1, -1);
                this.O000oO00 = new czz(textView);
                this.O000oO00.O000000o().setPadding(O000000o4, O000000o4, O000000o4, O000000o4);
            }
            int i2 = this.O0000o0o;
            View findViewById = i2 > 0 ? findViewById(i2) : null;
            int i3 = this.O0000o;
            if (i3 > 0) {
                view = findViewById(i3);
            }
            this.O000oO00.O000000o(this.O000OoOo);
            this.O000oO00.O000000o(this.O000OOo);
            this.O000oO00.O000000o(this.O000oO0o, findViewById, view);
            if (this.O00000Oo != 0) {
                O000000o(RefreshState.None);
                czs czs = this.O000oO00;
                this.O00000Oo = 0;
                czs.O000000o(0, this.O0000oO0, this.O0000oO);
            }
            if (!this.O000Oo0O && !isNestedScrollingEnabled()) {
                post(new Runnable() {
                    /* class com.scwang.smartrefresh.layout.SmartRefreshLayout.AnonymousClass4 */

                    public final void run() {
                        ViewParent parent = SmartRefreshLayout.this.getParent();
                        while (parent != null) {
                            if (parent instanceof bs) {
                                SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                                if (((bs) parent).onStartNestedScroll(smartRefreshLayout, smartRefreshLayout, 2)) {
                                    SmartRefreshLayout.this.setNestedScrollingEnabled(true);
                                    SmartRefreshLayout.this.O000Oo0O = false;
                                    return;
                                }
                            }
                            if (parent instanceof View) {
                                parent = ((View) parent).getParent();
                            } else {
                                return;
                            }
                        }
                    }
                });
            }
        }
        int[] iArr = this.O00oOooO;
        if (iArr != null) {
            czv czv5 = this.O000o0oo;
            if (czv5 != null) {
                czv5.setPrimaryColors(iArr);
            }
            czv czv6 = this.O000o;
            if (czv6 != null) {
                czv6.setPrimaryColors(this.O00oOooO);
            }
        }
        czs czs2 = this.O000oO00;
        if (czs2 != null) {
            super.bringChildToFront(czs2.O000000o());
        }
        czv czv7 = this.O000o0oo;
        if (!(czv7 == null || czv7.getSpinnerStyle() == SpinnerStyle.FixedBehind)) {
            super.bringChildToFront(this.O000o0oo.getView());
        }
        czv czv8 = this.O000o;
        if (czv8 != null && czv8.getSpinnerStyle() != SpinnerStyle.FixedBehind) {
            super.bringChildToFront(this.O000o.getView());
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00ce  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00d3  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00f2  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x010b  */
    public void onMeasure(int i, int i2) {
        int i3;
        int i4 = i;
        int i5 = i2;
        boolean z = isInEditMode() && this.O000O0oO;
        int childCount = super.getChildCount();
        int i6 = 0;
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = super.getChildAt(i7);
            czv czv = this.O000o0oo;
            if (czv != null && czv.getView() == childAt) {
                View view = this.O000o0oo.getView();
                LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                int childMeasureSpec = ViewGroup.getChildMeasureSpec(i4, layoutParams.leftMargin + layoutParams.rightMargin, layoutParams.width);
                int i8 = this.O000o00;
                if (this.O000o00O.ordinal() < DimensionStatus.XmlLayoutUnNotify.ordinal()) {
                    if (layoutParams.height > 0) {
                        i3 = layoutParams.height + layoutParams.bottomMargin + layoutParams.topMargin;
                        if (this.O000o00O.canReplaceWith(DimensionStatus.XmlExactUnNotify)) {
                            this.O000o00 = layoutParams.height + layoutParams.bottomMargin + layoutParams.topMargin;
                            this.O000o00O = DimensionStatus.XmlExactUnNotify;
                        }
                    } else if (layoutParams.height == -2 && (this.O000o0oo.getSpinnerStyle() != SpinnerStyle.MatchLayout || !this.O000o00O.notified)) {
                        int max = Math.max((View.MeasureSpec.getSize(i2) - layoutParams.bottomMargin) - layoutParams.topMargin, 0);
                        view.measure(childMeasureSpec, View.MeasureSpec.makeMeasureSpec(max, Integer.MIN_VALUE));
                        int measuredHeight = view.getMeasuredHeight();
                        if (measuredHeight > 0) {
                            if (measuredHeight != max && this.O000o00O.canReplaceWith(DimensionStatus.XmlWrapUnNotify)) {
                                this.O000o00 = measuredHeight + layoutParams.bottomMargin + layoutParams.topMargin;
                                this.O000o00O = DimensionStatus.XmlWrapUnNotify;
                            }
                            i3 = -1;
                        }
                    }
                    if (this.O000o0oo.getSpinnerStyle() != SpinnerStyle.MatchLayout) {
                        i3 = View.MeasureSpec.getSize(i2);
                    } else if (this.O000o0oo.getSpinnerStyle() == SpinnerStyle.Scale && !z) {
                        i3 = Math.max(0, O000000o(this.O00oOooo) ? this.O00000Oo : 0);
                    }
                    if (i3 != -1) {
                        view.measure(childMeasureSpec, View.MeasureSpec.makeMeasureSpec(Math.max((i3 - layoutParams.bottomMargin) - layoutParams.topMargin, 0), 1073741824));
                    }
                    if (!this.O000o00O.notified) {
                        this.O000o00O = this.O000o00O.notified();
                        czv czv2 = this.O000o0oo;
                        czw czw = this.O000oO0o;
                        int i9 = this.O000o00;
                        czv2.O000000o(czw, i9, (int) (this.O000o0OO * ((float) i9)));
                    }
                    if (z && O000000o(this.O00oOooo)) {
                        i6 += view.getMeasuredHeight();
                    }
                }
                i3 = i8;
                if (this.O000o0oo.getSpinnerStyle() != SpinnerStyle.MatchLayout) {
                }
                if (i3 != -1) {
                }
                if (!this.O000o00O.notified) {
                }
                i6 += view.getMeasuredHeight();
            }
            czv czv3 = this.O000o;
            if (czv3 != null && czv3.getView() == childAt) {
                View view2 = this.O000o.getView();
                LayoutParams layoutParams2 = (LayoutParams) view2.getLayoutParams();
                int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i4, layoutParams2.leftMargin + layoutParams2.rightMargin, layoutParams2.width);
                int i10 = this.O000o00o;
                if (this.O000o0.ordinal() < DimensionStatus.XmlLayoutUnNotify.ordinal()) {
                    if (layoutParams2.height > 0) {
                        i10 = layoutParams2.height + layoutParams2.topMargin + layoutParams2.bottomMargin;
                        if (this.O000o0.canReplaceWith(DimensionStatus.XmlExactUnNotify)) {
                            this.O000o00o = layoutParams2.height + layoutParams2.topMargin + layoutParams2.bottomMargin;
                            this.O000o0 = DimensionStatus.XmlExactUnNotify;
                        }
                    } else if (layoutParams2.height == -2 && (this.O000o.getSpinnerStyle() != SpinnerStyle.MatchLayout || !this.O000o0.notified)) {
                        int max2 = Math.max((View.MeasureSpec.getSize(i2) - layoutParams2.bottomMargin) - layoutParams2.topMargin, 0);
                        view2.measure(childMeasureSpec2, View.MeasureSpec.makeMeasureSpec(max2, Integer.MIN_VALUE));
                        int measuredHeight2 = view2.getMeasuredHeight();
                        if (measuredHeight2 > 0) {
                            if (measuredHeight2 != max2 && this.O000o0.canReplaceWith(DimensionStatus.XmlWrapUnNotify)) {
                                this.O000o00o = measuredHeight2 + layoutParams2.topMargin + layoutParams2.bottomMargin;
                                this.O000o0 = DimensionStatus.XmlWrapUnNotify;
                            }
                            i10 = -1;
                        }
                    }
                }
                if (this.O000o.getSpinnerStyle() == SpinnerStyle.MatchLayout) {
                    i10 = View.MeasureSpec.getSize(i2);
                } else if (this.O000o.getSpinnerStyle() == SpinnerStyle.Scale && !z) {
                    i10 = Math.max(0, O000000o(this.O000O00o) ? -this.O00000Oo : 0);
                }
                if (i10 != -1) {
                    view2.measure(childMeasureSpec2, View.MeasureSpec.makeMeasureSpec(Math.max((i10 - layoutParams2.bottomMargin) - layoutParams2.topMargin, 0), 1073741824));
                }
                if (!this.O000o0.notified) {
                    this.O000o0 = this.O000o0.notified();
                    czv czv4 = this.O000o;
                    czw czw2 = this.O000oO0o;
                    int i11 = this.O000o00o;
                    czv4.O000000o(czw2, i11, (int) (this.O000o0Oo * ((float) i11)));
                }
                if (z && O000000o(this.O000O00o)) {
                    i6 += view2.getMeasuredHeight();
                }
            }
            czs czs = this.O000oO00;
            if (czs != null && czs.O000000o() == childAt) {
                View O000000o2 = this.O000oO00.O000000o();
                LayoutParams layoutParams3 = (LayoutParams) O000000o2.getLayoutParams();
                O000000o2.measure(ViewGroup.getChildMeasureSpec(i4, getPaddingLeft() + getPaddingRight() + layoutParams3.leftMargin + layoutParams3.rightMargin, layoutParams3.width), ViewGroup.getChildMeasureSpec(i5, getPaddingTop() + getPaddingBottom() + layoutParams3.topMargin + layoutParams3.bottomMargin + ((!z || !(this.O000o0oo != null && O000000o(this.O00oOooo) && O000000o(this.O00oOoOo, this.O000o0oo))) ? 0 : this.O000o00) + ((!z || !(this.O000o != null && O000000o(this.O000O00o) && O000000o(this.O000O0o0, this.O000o))) ? 0 : this.O000o00o), layoutParams3.height));
                i6 += O000000o2.getMeasuredHeight();
            }
        }
        super.setMeasuredDimension(View.resolveSize(super.getSuggestedMinimumWidth(), i4), View.resolveSize(i6, i5));
        this.O0000Oo = (float) (getMeasuredWidth() / 2);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        getPaddingBottom();
        int childCount = super.getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = super.getChildAt(i6);
            czs czs = this.O000oO00;
            boolean z2 = true;
            if (czs != null && czs.O000000o() == childAt) {
                boolean z3 = isInEditMode() && this.O000O0oO && O000000o(this.O00oOooo) && this.O000o0oo != null;
                View O000000o2 = this.O000oO00.O000000o();
                LayoutParams layoutParams = (LayoutParams) O000000o2.getLayoutParams();
                int i7 = layoutParams.leftMargin + paddingLeft;
                int i8 = layoutParams.topMargin + paddingTop;
                int measuredWidth = O000000o2.getMeasuredWidth() + i7;
                int measuredHeight = O000000o2.getMeasuredHeight() + i8;
                if (z3 && O000000o(this.O00oOoOo, this.O000o0oo)) {
                    int i9 = this.O000o00;
                    i8 += i9;
                    measuredHeight += i9;
                }
                O000000o2.layout(i7, i8, measuredWidth, measuredHeight);
            }
            czv czv = this.O000o0oo;
            if (czv != null && czv.getView() == childAt) {
                boolean z4 = isInEditMode() && this.O000O0oO && O000000o(this.O00oOooo);
                View view = this.O000o0oo.getView();
                LayoutParams layoutParams2 = (LayoutParams) view.getLayoutParams();
                int i10 = layoutParams2.leftMargin;
                int i11 = layoutParams2.topMargin + this.O000o0O0;
                int measuredWidth2 = view.getMeasuredWidth() + i10;
                int measuredHeight2 = view.getMeasuredHeight() + i11;
                if (!z4 && this.O000o0oo.getSpinnerStyle() == SpinnerStyle.Translate) {
                    int i12 = this.O000o00;
                    i11 -= i12;
                    measuredHeight2 -= i12;
                }
                view.layout(i10, i11, measuredWidth2, measuredHeight2);
            }
            czv czv2 = this.O000o;
            if (czv2 != null && czv2.getView() == childAt) {
                if (!isInEditMode() || !this.O000O0oO || !O000000o(this.O000O00o)) {
                    z2 = false;
                }
                View view2 = this.O000o.getView();
                LayoutParams layoutParams3 = (LayoutParams) view2.getLayoutParams();
                SpinnerStyle spinnerStyle = this.O000o.getSpinnerStyle();
                int i13 = layoutParams3.leftMargin;
                int measuredHeight3 = (layoutParams3.topMargin + getMeasuredHeight()) - this.O000o0O;
                if (spinnerStyle == SpinnerStyle.MatchLayout) {
                    measuredHeight3 = layoutParams3.topMargin - this.O000o0O;
                } else {
                    if (z2 || spinnerStyle == SpinnerStyle.FixedFront || spinnerStyle == SpinnerStyle.FixedBehind) {
                        i5 = this.O000o00o;
                    } else if (spinnerStyle == SpinnerStyle.Scale && this.O00000Oo < 0) {
                        i5 = Math.max(O000000o(this.O000O00o) ? -this.O00000Oo : 0, 0);
                    }
                    measuredHeight3 -= i5;
                }
                view2.layout(i13, measuredHeight3, view2.getMeasuredWidth() + i13, view2.getMeasuredHeight() + measuredHeight3);
            }
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.czw.O000000o(int, boolean):_m_j.czw
     arg types: [int, int]
     candidates:
      _m_j.czw.O000000o(_m_j.czv, int):_m_j.czw
      _m_j.czw.O000000o(_m_j.czv, boolean):_m_j.czw
      _m_j.czw.O000000o(int, boolean):_m_j.czw */
    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.O000oO0o.O000000o(0, true);
        O000000o(RefreshState.None);
        Handler handler = this.O000oO0O;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.O000oO0O = null;
        }
        List<dan> list = this.O000oO;
        if (list != null) {
            list.clear();
            this.O000oO = null;
        }
        this.O000Oo0 = true;
        this.O000Oo0O = true;
        this.O000ooO = null;
        ValueAnimator valueAnimator = this.O000ooOO;
        if (valueAnimator != null) {
            valueAnimator.removeAllListeners();
            this.O000ooOO.removeAllUpdateListeners();
            this.O000ooOO.cancel();
            this.O000ooOO = null;
        }
    }

    /* access modifiers changed from: protected */
    public boolean drawChild(Canvas canvas, View view, long j) {
        Paint paint;
        Paint paint2;
        czs czs = this.O000oO00;
        View O000000o2 = czs != null ? czs.O000000o() : null;
        czv czv = this.O000o0oo;
        if (czv != null && czv.getView() == view) {
            if (!O000000o(this.O00oOooo) || (!this.O000O0oO && isInEditMode())) {
                return true;
            }
            if (O000000o2 != null) {
                int max = Math.max(O000000o2.getTop() + O000000o2.getPaddingTop() + this.O00000Oo, view.getTop());
                int i = this.O000oOOo;
                if (!(i == 0 || (paint2 = this.O000oO0) == null)) {
                    paint2.setColor(i);
                    if (this.O000o0oo.getSpinnerStyle() == SpinnerStyle.Scale) {
                        max = view.getBottom();
                    } else if (this.O000o0oo.getSpinnerStyle() == SpinnerStyle.Translate) {
                        max = view.getBottom() + this.O00000Oo;
                    }
                    canvas.drawRect((float) view.getLeft(), (float) view.getTop(), (float) view.getRight(), (float) max, this.O000oO0);
                }
                if (this.O000O0OO && this.O000o0oo.getSpinnerStyle() == SpinnerStyle.FixedBehind) {
                    canvas.save();
                    canvas.clipRect(view.getLeft(), view.getTop(), view.getRight(), max);
                    boolean drawChild = super.drawChild(canvas, view, j);
                    canvas.restore();
                    return drawChild;
                }
            }
        }
        czv czv2 = this.O000o;
        if (czv2 != null && czv2.getView() == view) {
            if (!O000000o(this.O000O00o) || (!this.O000O0oO && isInEditMode())) {
                return true;
            }
            if (O000000o2 != null) {
                int min = Math.min((O000000o2.getBottom() - O000000o2.getPaddingBottom()) + this.O00000Oo, view.getBottom());
                int i2 = this.O000oOo0;
                if (!(i2 == 0 || (paint = this.O000oO0) == null)) {
                    paint.setColor(i2);
                    if (this.O000o.getSpinnerStyle() == SpinnerStyle.Scale) {
                        min = view.getTop();
                    } else if (this.O000o.getSpinnerStyle() == SpinnerStyle.Translate) {
                        min = view.getTop() + this.O00000Oo;
                    }
                    canvas.drawRect((float) view.getLeft(), (float) min, (float) view.getRight(), (float) view.getBottom(), this.O000oO0);
                }
                if (this.O000O0Oo && this.O000o.getSpinnerStyle() == SpinnerStyle.FixedBehind) {
                    canvas.save();
                    canvas.clipRect(view.getLeft(), min, view.getRight(), view.getBottom());
                    boolean drawChild2 = super.drawChild(canvas, view, j);
                    canvas.restore();
                    return drawChild2;
                }
            }
        }
        return super.drawChild(canvas, view, j);
    }

    public void computeScroll() {
        float f;
        this.O0000oo.getCurrY();
        if (this.O0000oo.computeScrollOffset()) {
            int finalY = this.O0000oo.getFinalY();
            if ((finalY >= 0 || ((!this.O000OO00 && !O000000o(this.O00oOooo)) || !this.O000oO00.O00000o0())) && (finalY <= 0 || ((!this.O000OO00 && !O000000o(this.O000O00o)) || !this.O000oO00.O00000o()))) {
                this.O000oo = true;
                invalidate();
                return;
            }
            if (this.O000oo) {
                if (Build.VERSION.SDK_INT >= 14) {
                    f = finalY > 0 ? -this.O0000oo.getCurrVelocity() : this.O0000oo.getCurrVelocity();
                } else {
                    f = (((float) (this.O0000oo.getCurrY() - finalY)) * 1.0f) / ((float) Math.max(this.O0000oo.getDuration() - this.O0000oo.timePassed(), 1));
                }
                if (this.O000ooOO == null) {
                    if (f > 0.0f && (this.O000oOO0 == RefreshState.Refreshing || this.O000oOO0 == RefreshState.TwoLevel)) {
                        this.O000ooO = new O000000o(f, this.O000o00);
                    } else if (f < 0.0f && (this.O000oOO0 == RefreshState.Loading || ((this.O000O0o && this.O000Oo00 && O000000o(this.O000O00o)) || (this.O000OO0o && !this.O000Oo00 && O000000o(this.O000O00o) && this.O000oOO0 != RefreshState.Refreshing)))) {
                        this.O000ooO = new O000000o(f, -this.O000o00o);
                    } else if (this.O00000Oo == 0 && this.O000O0oo) {
                        this.O000ooO = new O000000o(f, 0);
                    }
                }
            }
            this.O0000oo.forceFinished(true);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:108:0x0155, code lost:
        if (r6 != 3) goto L_0x0375;
     */
    /* JADX WARNING: Removed duplicated region for block: B:220:0x030a  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x0130  */
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z;
        char c;
        czv czv;
        czv czv2;
        MotionEvent motionEvent2 = motionEvent;
        int actionMasked = motionEvent.getActionMasked();
        int i = 1;
        boolean z2 = actionMasked == 6;
        int actionIndex = z2 ? motionEvent.getActionIndex() : -1;
        int pointerCount = motionEvent.getPointerCount();
        float f = 0.0f;
        float f2 = 0.0f;
        for (int i2 = 0; i2 < pointerCount; i2++) {
            if (actionIndex != i2) {
                f += motionEvent2.getX(i2);
                f2 += motionEvent2.getY(i2);
            }
        }
        if (z2) {
            pointerCount--;
        }
        float f3 = (float) pointerCount;
        float f4 = f / f3;
        float f5 = f2 / f3;
        if ((actionMasked == 6 || actionMasked == 5) && this.O0000o0) {
            this.O0000Oo0 += f5 - this.O0000OoO;
        }
        this.O0000Oo = f4;
        this.O0000OoO = f5;
        if (this.O000Ooo) {
            int i3 = this.O000Ooo0;
            boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
            if (actionMasked == 2 && i3 == this.O000Ooo0) {
                int i4 = (int) this.O0000Oo;
                int width = getWidth();
                float f6 = this.O0000Oo;
                if (width != 0) {
                    i = width;
                }
                float f7 = f6 / ((float) i);
                if (O000000o(this.O00oOooo) && this.O00000Oo > 0 && (czv2 = this.O000o0oo) != null && czv2.O00000Oo()) {
                    this.O000o0oo.O000000o(f7, i4, width);
                } else if (O000000o(this.O000O00o) && this.O00000Oo < 0 && (czv = this.O000o) != null && czv.O00000Oo()) {
                    this.O000o.O000000o(f7, i4, width);
                }
            }
            return dispatchTouchEvent;
        } else if (!isEnabled() || ((!O000000o(this.O00oOooo) && !O000000o(this.O000O00o) && !this.O000OO00) || ((this.O000oOo && ((this.O000oOO0.isOpening || this.O000oOO0.isFinishing) && this.O000oOO0.isHeader)) || (this.O000oOoO && ((this.O000oOO0.isOpening || this.O000oOO0.isFinishing) && this.O000oOO0.isFooter))))) {
            return super.dispatchTouchEvent(motionEvent);
        } else {
            if (actionMasked == 0) {
                if (this.O000ooOO != null) {
                    if (!this.O000oOO0.isFinishing && this.O000oOO0 != RefreshState.TwoLevelReleased) {
                        if (this.O000oOO0 == RefreshState.PullDownCanceled) {
                            this.O000oO0o.O000000o(RefreshState.PullDownToRefresh);
                        } else if (this.O000oOO0 == RefreshState.PullUpCanceled) {
                            this.O000oO0o.O000000o(RefreshState.PullUpToLoad);
                        }
                        this.O000ooOO.cancel();
                        this.O000ooOO = null;
                    }
                    z = true;
                    if (!z || this.O000oOO0.isFinishing || ((this.O000oOO0 == RefreshState.Loading && this.O000OOoo) || (this.O000oOO0 == RefreshState.Refreshing && this.O000OOoO))) {
                        return false;
                    }
                    if (actionMasked != 0) {
                        if (actionMasked != 1) {
                            if (actionMasked == 2) {
                                float f8 = f4 - this.O0000OOo;
                                float f9 = f5 - this.O0000Oo0;
                                this.O0000ooO.addMovement(motionEvent2);
                                if (!(this.O0000o0 || (c = this.O0000o00) == 'h' || this.O000oO00 == null)) {
                                    if (c == 'v' || (Math.abs(f9) >= ((float) this.f5558O000000o) && Math.abs(f8) < Math.abs(f9))) {
                                        this.O0000o00 = 'v';
                                        if (f9 > 0.0f && (this.O00000Oo < 0 || ((this.O000OO00 || O000000o(this.O00oOooo)) && this.O000oO00.O00000o0()))) {
                                            this.O0000o0 = true;
                                            this.O0000Oo0 = f5 - ((float) this.f5558O000000o);
                                        } else if (f9 < 0.0f && (this.O00000Oo > 0 || ((this.O000OO00 || O000000o(this.O000O00o)) && ((this.O000oOO0 == RefreshState.Loading && this.O000oOoo) || this.O000oO00.O00000o())))) {
                                            this.O0000o0 = true;
                                            this.O0000Oo0 = ((float) this.f5558O000000o) + f5;
                                        }
                                        if (this.O0000o0) {
                                            f9 = f5 - this.O0000Oo0;
                                            if (this.O0000o0O) {
                                                motionEvent2.setAction(3);
                                                super.dispatchTouchEvent(motionEvent);
                                            }
                                            int i5 = this.O00000Oo;
                                            if (i5 > 0 || (i5 == 0 && f9 > 0.0f)) {
                                                this.O000oO0o.O000000o(RefreshState.PullDownToRefresh);
                                            } else {
                                                this.O000oO0o.O000000o(RefreshState.PullUpToLoad);
                                            }
                                            ViewParent parent = getParent();
                                            if (parent != null) {
                                                parent.requestDisallowInterceptTouchEvent(true);
                                            }
                                        }
                                    } else if (Math.abs(f8) >= ((float) this.f5558O000000o) && Math.abs(f8) > Math.abs(f9) && this.O0000o00 != 'v') {
                                        this.O0000o00 = 'h';
                                    }
                                }
                                if (this.O0000o0) {
                                    int i6 = ((int) f9) + this.O00000o;
                                    if ((this.O000oOO.isHeader && (i6 < 0 || this.O00000o0 < 0)) || (this.O000oOO.isFooter && (i6 > 0 || this.O00000o0 > 0))) {
                                        this.O00000o0 = i6;
                                        long eventTime = motionEvent.getEventTime();
                                        if (this.O000ooO0 == null) {
                                            this.O000ooO0 = MotionEvent.obtain(eventTime, eventTime, 0, this.O0000OOo + f8, this.O0000Oo0, 0);
                                            super.dispatchTouchEvent(this.O000ooO0);
                                        }
                                        MotionEvent obtain = MotionEvent.obtain(eventTime, eventTime, 2, this.O0000OOo + f8, this.O0000Oo0 + ((float) i6), 0);
                                        super.dispatchTouchEvent(obtain);
                                        if (this.O000oOoo && f9 > ((float) this.f5558O000000o) && this.O00000Oo < 0) {
                                            this.O000oOoo = false;
                                        }
                                        if (i6 <= 0 || ((!this.O000OO00 && !O000000o(this.O00oOooo)) || !this.O000oO00.O00000o0())) {
                                            if (i6 < 0 && ((this.O000OO00 || O000000o(this.O000O00o)) && this.O000oO00.O00000o())) {
                                                this.O0000OoO = f5;
                                                this.O0000Oo0 = f5;
                                                this.O00000o = 0;
                                                this.O000oO0o.O000000o(RefreshState.PullUpToLoad);
                                            }
                                            if ((this.O000oOO.isHeader || i6 >= 0) && (!this.O000oOO.isFooter || i6 <= 0)) {
                                                if (this.O000ooO0 != null) {
                                                    this.O000ooO0 = null;
                                                    obtain.setAction(3);
                                                    super.dispatchTouchEvent(obtain);
                                                }
                                                obtain.recycle();
                                            } else {
                                                if (this.O00000Oo != 0) {
                                                    O000000o(0.0f);
                                                }
                                                return true;
                                            }
                                        } else {
                                            this.O0000OoO = f5;
                                            this.O0000Oo0 = f5;
                                            this.O00000o = 0;
                                            this.O000oO0o.O000000o(RefreshState.PullDownToRefresh);
                                        }
                                        i6 = 0;
                                        if (this.O000oOO.isHeader) {
                                        }
                                        if (this.O000ooO0 != null) {
                                        }
                                        obtain.recycle();
                                    }
                                    O000000o((float) i6);
                                    return true;
                                } else if (this.O000oOoo && f9 > ((float) this.f5558O000000o) && this.O00000Oo < 0) {
                                    this.O000oOoo = false;
                                }
                            }
                            return super.dispatchTouchEvent(motionEvent);
                        }
                        this.O0000ooO.addMovement(motionEvent2);
                        this.O0000ooO.computeCurrentVelocity(1000, (float) this.O0000oOo);
                        this.O0000oo0 = (int) this.O0000ooO.getYVelocity();
                        O000000o((Float) null);
                        this.O0000ooO.clear();
                        this.O0000o00 = 'n';
                        MotionEvent motionEvent3 = this.O000ooO0;
                        if (motionEvent3 != null) {
                            motionEvent3.recycle();
                            this.O000ooO0 = null;
                            long eventTime2 = motionEvent.getEventTime();
                            MotionEvent obtain2 = MotionEvent.obtain(eventTime2, eventTime2, actionMasked, this.O0000OOo, f5, 0);
                            super.dispatchTouchEvent(obtain2);
                            obtain2.recycle();
                        }
                        O0000OoO();
                        if (this.O0000o0) {
                            this.O0000o0 = false;
                            return true;
                        }
                        return super.dispatchTouchEvent(motionEvent);
                    }
                    this.O0000oo0 = 0;
                    this.O0000ooO.addMovement(motionEvent2);
                    this.O0000oo.forceFinished(true);
                    this.O0000OOo = f4;
                    this.O0000Oo0 = f5;
                    this.O00000o0 = 0;
                    this.O00000o = this.O00000Oo;
                    this.O0000o0 = false;
                    this.O0000o0O = super.dispatchTouchEvent(motionEvent);
                    if (this.O000oOO0 != RefreshState.TwoLevel || this.O0000Oo0 >= ((float) ((getMeasuredHeight() * 5) / 6))) {
                        czs czs = this.O000oO00;
                        if (czs != null) {
                            czs.O000000o(motionEvent2);
                        }
                        return true;
                    }
                    this.O0000o00 = 'h';
                    return this.O0000o0O;
                }
                this.O000ooO = null;
            }
            if (this.O000ooOO == null) {
                z = false;
                if (!z) {
                }
                return false;
            }
            z = true;
            if (!z) {
            }
            return false;
        }
    }

    private boolean O000000o(Float f) {
        float floatValue = f == null ? (float) this.O0000oo0 : f.floatValue();
        if (Math.abs(floatValue) > ((float) this.O0000oOO)) {
            if (((float) this.O00000Oo) * floatValue < 0.0f) {
                if (!this.O000oOO0.isOpening) {
                    int i = this.O00000Oo;
                    if (((float) i) > ((float) this.O000o00) * this.O000o0o0 || ((float) (-i)) > ((float) this.O000o00o) * this.O000o0o) {
                        return true;
                    }
                } else if (!(this.O000oOO0 == RefreshState.TwoLevel || this.O000oOO0 == this.O000oOO)) {
                    this.O000ooO = new O00000Oo(floatValue).O000000o();
                    return true;
                }
            }
            if ((floatValue < 0.0f && ((this.O000O0oo && (this.O000OO00 || O000000o(this.O000O00o))) || ((this.O000oOO0 == RefreshState.Loading && this.O00000Oo >= 0) || (this.O000OO0o && O000000o(this.O000O00o))))) || (floatValue > 0.0f && ((this.O000O0oo && (this.O000OO00 || O000000o(this.O00oOooo))) || (this.O000oOO0 == RefreshState.Refreshing && this.O00000Oo <= 0)))) {
                this.O000oo = false;
                this.O0000oo.fling(0, 0, 0, (int) (-floatValue), 0, 0, -2147483647, Integer.MAX_VALUE);
                this.O0000oo.computeScrollOffset();
                invalidate();
            }
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public final void O000000o(RefreshState refreshState) {
        RefreshState refreshState2 = this.O000oOO0;
        if (refreshState2 != refreshState) {
            this.O000oOO0 = refreshState;
            this.O000oOO = refreshState;
            czv czv = this.O000o0oo;
            czv czv2 = this.O000o;
            daj daj = this.O000OoOO;
            if (czv != null) {
                czv.O000000o(this, refreshState2, refreshState);
            }
            if (czv2 != null) {
                czv2.O000000o(this, refreshState2, refreshState);
            }
            if (daj != null) {
                daj.O000000o(this, refreshState2, refreshState);
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void O000000o() {
        if (this.O000oOO0 != RefreshState.Loading) {
            this.O000oOOO = System.currentTimeMillis();
            this.O000oOoo = true;
            O000000o(RefreshState.Loading);
            dai dai = this.O000OoO;
            if (dai != null) {
                dai.onLoadMore(this);
            } else if (this.O000OoOO == null) {
                O00000Oo(2000);
            }
            czv czv = this.O000o;
            if (czv != null) {
                int i = this.O000o00o;
                czv.O00000Oo(this, i, (int) (this.O000o0Oo * ((float) i)));
            }
            daj daj = this.O000OoOO;
            if (daj != null && (this.O000o instanceof czt)) {
                daj.onLoadMore(this);
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void O00000Oo() {
        AnonymousClass5 r0 = new AnimatorListenerAdapter() {
            /* class com.scwang.smartrefresh.layout.SmartRefreshLayout.AnonymousClass5 */

            public final void onAnimationEnd(Animator animator) {
                SmartRefreshLayout.this.O000000o();
            }
        };
        O000000o(RefreshState.LoadReleased);
        ValueAnimator O000000o2 = this.O000oO0o.O000000o(-this.O000o00o);
        if (O000000o2 != null) {
            O000000o2.addListener(r0);
        }
        czv czv = this.O000o;
        if (czv != null) {
            int i = this.O000o00o;
            czv.O000000o(this, i, (int) (this.O000o0Oo * ((float) i)));
        }
        if (O000000o2 == null) {
            r0.onAnimationEnd(null);
        }
    }

    /* access modifiers changed from: protected */
    public final void O00000o0() {
        AnonymousClass6 r0 = new AnimatorListenerAdapter() {
            /* class com.scwang.smartrefresh.layout.SmartRefreshLayout.AnonymousClass6 */

            public final void onAnimationEnd(Animator animator) {
                SmartRefreshLayout.this.O000oOOO = System.currentTimeMillis();
                SmartRefreshLayout.this.O000000o(RefreshState.Refreshing);
                if (SmartRefreshLayout.this.O00O0Oo == null && SmartRefreshLayout.this.O000OoOO == null) {
                    SmartRefreshLayout.this.O000000o(3000);
                }
                if (SmartRefreshLayout.this.O000o0oo != null) {
                    czv czv = SmartRefreshLayout.this.O000o0oo;
                    SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                    czv.O00000Oo(smartRefreshLayout, smartRefreshLayout.O000o00, (int) (SmartRefreshLayout.this.O000o0OO * ((float) SmartRefreshLayout.this.O000o00)));
                }
            }
        };
        O000000o(RefreshState.RefreshReleased);
        ValueAnimator O000000o2 = this.O000oO0o.O000000o(this.O000o00);
        if (O000000o2 != null) {
            O000000o2.addListener(r0);
        }
        czv czv = this.O000o0oo;
        if (czv != null) {
            int i = this.O000o00;
            czv.O000000o(this, i, (int) (this.O000o0OO * ((float) i)));
        }
        if (O000000o2 == null) {
            r0.onAnimationEnd(null);
        }
    }

    /* access modifiers changed from: protected */
    public final void O00000o() {
        if (this.O000oOO0 != RefreshState.None && this.O00000Oo == 0) {
            O000000o(RefreshState.None);
        }
        if (this.O00000Oo != 0) {
            this.O000oO0o.O000000o(0);
        }
    }

    /* access modifiers changed from: protected */
    public void setViceState(RefreshState refreshState) {
        if (this.O000oOO0.isDragging && this.O000oOO0.isHeader != refreshState.isHeader) {
            O000000o(RefreshState.None);
        }
        if (this.O000oOO != refreshState) {
            this.O000oOO = refreshState;
        }
    }

    /* access modifiers changed from: protected */
    public final boolean O000000o(boolean z, czv czv) {
        return z || this.O000OO || czv == null || czv.getSpinnerStyle() == SpinnerStyle.FixedBehind;
    }

    /* access modifiers changed from: protected */
    public final boolean O000000o(boolean z) {
        return z && !this.O000OO;
    }

    public class O00000Oo implements Runnable {

        /* renamed from: O000000o  reason: collision with root package name */
        int f5571O000000o;
        int O00000Oo = 0;
        float O00000o;
        int O00000o0 = 10;
        float O00000oO = 0.98f;
        long O00000oo = 0;
        long O0000O0o = AnimationUtils.currentAnimationTimeMillis();

        O00000Oo(float f) {
            this.O00000o = f;
            this.f5571O000000o = SmartRefreshLayout.this.O00000Oo;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:12:0x002c, code lost:
            if (r0.O000000o(r0.O000O00o) != false) goto L_0x002e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x004a, code lost:
            if (r0.O000000o(r0.O000O00o) != false) goto L_0x004c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0055, code lost:
            if (r10.O0000OOo.O00000Oo >= (-r10.O0000OOo.O000o00o)) goto L_0x0057;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x0067, code lost:
            if (r10.O0000OOo.O00000Oo > r10.O0000OOo.O000o00) goto L_0x0069;
         */
        public final Runnable O000000o() {
            if (SmartRefreshLayout.this.O000oOO0.isFinishing) {
                return null;
            }
            if (SmartRefreshLayout.this.O00000Oo != 0) {
                if (!SmartRefreshLayout.this.O000oOO0.isOpening) {
                    if (SmartRefreshLayout.this.O000Oo00 && SmartRefreshLayout.this.O000O0o) {
                        SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                    }
                    int i = 0;
                    int i2 = SmartRefreshLayout.this.O00000Oo;
                    int i3 = SmartRefreshLayout.this.O00000Oo;
                    float f = this.O00000o;
                    while (true) {
                        if (i3 * i2 <= 0) {
                            break;
                        }
                        double d = (double) f;
                        i++;
                        double pow = Math.pow((double) this.O00000oO, (double) ((this.O00000o0 * i) / 10));
                        Double.isNaN(d);
                        f = (float) (d * pow);
                        float f2 = ((((float) this.O00000o0) * 1.0f) / 1000.0f) * f;
                        if (Math.abs(f2) >= 1.0f) {
                            i2 = (int) (((float) i2) + f2);
                        } else if (!SmartRefreshLayout.this.O000oOO0.isOpening || ((SmartRefreshLayout.this.O000oOO0 == RefreshState.Refreshing && i2 > SmartRefreshLayout.this.O000o00) || (SmartRefreshLayout.this.O000oOO0 != RefreshState.Refreshing && i2 < (-SmartRefreshLayout.this.O000o00o)))) {
                            return null;
                        }
                    }
                }
                if (SmartRefreshLayout.this.O000oOO0 != RefreshState.Loading) {
                    if (SmartRefreshLayout.this.O000Oo00 && SmartRefreshLayout.this.O000O0o) {
                        SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
                    }
                    if (SmartRefreshLayout.this.O000oOO0 == RefreshState.Refreshing) {
                    }
                }
            }
            this.O00000oo = AnimationUtils.currentAnimationTimeMillis();
            SmartRefreshLayout.this.postDelayed(this, (long) this.O00000o0);
            return this;
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: _m_j.czw.O000000o(int, boolean):_m_j.czw
         arg types: [int, int]
         candidates:
          _m_j.czw.O000000o(_m_j.czv, int):_m_j.czw
          _m_j.czw.O000000o(_m_j.czv, boolean):_m_j.czw
          _m_j.czw.O000000o(int, boolean):_m_j.czw */
        public final void run() {
            if (SmartRefreshLayout.this.O000ooO == this && !SmartRefreshLayout.this.O000oOO0.isFinishing) {
                long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
                double d = (double) this.O00000o;
                double pow = Math.pow((double) this.O00000oO, (double) ((currentAnimationTimeMillis - this.O00000oo) / ((long) (1000 / this.O00000o0))));
                Double.isNaN(d);
                this.O00000o = (float) (d * pow);
                float f = this.O00000o * ((((float) (currentAnimationTimeMillis - this.O0000O0o)) * 1.0f) / 1000.0f);
                if (Math.abs(f) > 1.0f) {
                    this.O0000O0o = currentAnimationTimeMillis;
                    this.f5571O000000o = (int) (((float) this.f5571O000000o) + f);
                    if (SmartRefreshLayout.this.O00000Oo * this.f5571O000000o > 0) {
                        SmartRefreshLayout.this.O000oO0o.O000000o(this.f5571O000000o, true);
                        SmartRefreshLayout.this.postDelayed(this, (long) this.O00000o0);
                        return;
                    }
                    SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                    smartRefreshLayout.O000ooO = null;
                    smartRefreshLayout.O000oO0o.O000000o(0, true);
                    View O00000Oo2 = SmartRefreshLayout.this.O000oO00.O00000Oo();
                    int i = (int) (-this.O00000o);
                    if (O00000Oo2 instanceof ScrollView) {
                        ((ScrollView) O00000Oo2).fling(i);
                    } else if (O00000Oo2 instanceof AbsListView) {
                        if (Build.VERSION.SDK_INT >= 21) {
                            ((AbsListView) O00000Oo2).fling(i);
                        }
                    } else if (O00000Oo2 instanceof WebView) {
                        ((WebView) O00000Oo2).flingScroll(0, i);
                    } else if (O00000Oo2 instanceof NestedScrollView) {
                        ((NestedScrollView) O00000Oo2).O00000Oo(i);
                    } else if (O00000Oo2 instanceof RecyclerView) {
                        ((RecyclerView) O00000Oo2).fling(0, i);
                    }
                    if (SmartRefreshLayout.this.O000oOoo && f > 0.0f) {
                        SmartRefreshLayout.this.O000oOoo = false;
                        return;
                    }
                    return;
                }
                SmartRefreshLayout.this.O000ooO = null;
            }
        }
    }

    public class O000000o implements Runnable {

        /* renamed from: O000000o  reason: collision with root package name */
        int f5570O000000o = 0;
        int O00000Oo = 10;
        long O00000o;
        int O00000o0;
        float O00000oO = 0.0f;
        float O00000oo;

        O000000o(float f, int i) {
            this.O00000oo = f;
            this.O00000o0 = i;
            this.O00000o = AnimationUtils.currentAnimationTimeMillis();
            SmartRefreshLayout.this.postDelayed(this, (long) this.O00000Oo);
        }

        public final void run() {
            if (SmartRefreshLayout.this.O000ooO == this && !SmartRefreshLayout.this.O000oOO0.isFinishing) {
                if (Math.abs(SmartRefreshLayout.this.O00000Oo) < Math.abs(this.O00000o0)) {
                    double d = (double) this.O00000oo;
                    int i = this.f5570O000000o + 1;
                    this.f5570O000000o = i;
                    double pow = Math.pow(0.949999988079071d, (double) (i * 2));
                    Double.isNaN(d);
                    this.O00000oo = (float) (d * pow);
                } else if (this.O00000o0 != 0) {
                    double d2 = (double) this.O00000oo;
                    int i2 = this.f5570O000000o + 1;
                    this.f5570O000000o = i2;
                    double pow2 = Math.pow(0.44999998807907104d, (double) (i2 * 2));
                    Double.isNaN(d2);
                    this.O00000oo = (float) (d2 * pow2);
                } else {
                    double d3 = (double) this.O00000oo;
                    int i3 = this.f5570O000000o + 1;
                    this.f5570O000000o = i3;
                    double pow3 = Math.pow(0.8500000238418579d, (double) (i3 * 2));
                    Double.isNaN(d3);
                    this.O00000oo = (float) (d3 * pow3);
                }
                long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
                float f = this.O00000oo * ((((float) (currentAnimationTimeMillis - this.O00000o)) * 1.0f) / 1000.0f);
                if (Math.abs(f) >= 1.0f) {
                    this.O00000o = currentAnimationTimeMillis;
                    this.O00000oO += f;
                    SmartRefreshLayout.this.O000000o(this.O00000oO);
                    SmartRefreshLayout.this.postDelayed(this, (long) this.O00000Oo);
                    return;
                }
                SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                smartRefreshLayout.O000ooO = null;
                if (Math.abs(smartRefreshLayout.O00000Oo) >= Math.abs(this.O00000o0)) {
                    SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
                    smartRefreshLayout2.O000000o(this.O00000o0, 0, smartRefreshLayout2.O0000ooo, Math.min(Math.max((int) dao.O000000o(Math.abs(SmartRefreshLayout.this.O00000Oo - this.O00000o0)), 30), 100) * 10);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public final ValueAnimator O000000o(int i, int i2, Interpolator interpolator, int i3) {
        if (this.O00000Oo == i) {
            return null;
        }
        ValueAnimator valueAnimator = this.O000ooOO;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        this.O000ooO = null;
        this.O000ooOO = ValueAnimator.ofInt(this.O00000Oo, i);
        this.O000ooOO.setDuration((long) i3);
        this.O000ooOO.setInterpolator(interpolator);
        this.O000ooOO.addListener(new AnimatorListenerAdapter() {
            /* class com.scwang.smartrefresh.layout.SmartRefreshLayout.AnonymousClass7 */

            public final void onAnimationCancel(Animator animator) {
                super.onAnimationEnd(animator);
            }

            public final void onAnimationEnd(Animator animator) {
                SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                smartRefreshLayout.O000ooOO = null;
                if (smartRefreshLayout.O00000Oo == 0) {
                    if (SmartRefreshLayout.this.O000oOO0 != RefreshState.None && !SmartRefreshLayout.this.O000oOO0.isOpening) {
                        SmartRefreshLayout.this.O000000o(RefreshState.None);
                    }
                } else if (SmartRefreshLayout.this.O000oOO0 != SmartRefreshLayout.this.O000oOO) {
                    SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
                    smartRefreshLayout2.setViceState(smartRefreshLayout2.O000oOO0);
                }
            }
        });
        this.O000ooOO.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            /* class com.scwang.smartrefresh.layout.SmartRefreshLayout.AnonymousClass8 */

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: _m_j.czw.O000000o(int, boolean):_m_j.czw
             arg types: [int, int]
             candidates:
              _m_j.czw.O000000o(_m_j.czv, int):_m_j.czw
              _m_j.czw.O000000o(_m_j.czv, boolean):_m_j.czw
              _m_j.czw.O000000o(int, boolean):_m_j.czw */
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                SmartRefreshLayout.this.O000oO0o.O000000o(((Integer) valueAnimator.getAnimatedValue()).intValue(), false);
            }
        });
        this.O000ooOO.setStartDelay((long) i2);
        this.O000ooOO.start();
        return this.O000ooOO;
    }

    private void O0000OoO() {
        if (this.O000oOO0 == RefreshState.TwoLevel) {
            if (this.O0000oo0 > -1000 && this.O00000Oo > getMeasuredHeight() / 2) {
                ValueAnimator O000000o2 = this.O000oO0o.O000000o(getMeasuredHeight());
                if (O000000o2 != null) {
                    O000000o2.setDuration((long) this.O00000oO);
                }
            } else if (this.O0000o0) {
                this.O000oO0o.O00000o0();
            }
        } else if (this.O000oOO0 == RefreshState.Loading || (this.O000O0o && this.O000Oo00 && this.O00000Oo < 0 && O000000o(this.O000O00o))) {
            int i = this.O00000Oo;
            int i2 = this.O000o00o;
            if (i < (-i2)) {
                this.O000oO0o.O000000o(-i2);
            } else if (i > 0) {
                this.O000oO0o.O000000o(0);
            }
        } else if (this.O000oOO0 == RefreshState.Refreshing) {
            int i3 = this.O00000Oo;
            int i4 = this.O000o00;
            if (i3 > i4) {
                this.O000oO0o.O000000o(i4);
            } else if (i3 < 0) {
                this.O000oO0o.O000000o(0);
            }
        } else if (this.O000oOO0 == RefreshState.PullDownToRefresh) {
            this.O000oO0o.O000000o(RefreshState.PullDownCanceled);
        } else if (this.O000oOO0 == RefreshState.PullUpToLoad) {
            this.O000oO0o.O000000o(RefreshState.PullUpCanceled);
        } else if (this.O000oOO0 == RefreshState.ReleaseToRefresh) {
            this.O000oO0o.O000000o(RefreshState.Refreshing);
        } else if (this.O000oOO0 == RefreshState.ReleaseToLoad) {
            this.O000oO0o.O000000o(RefreshState.Loading);
        } else if (this.O000oOO0 == RefreshState.ReleaseToTwoLevel) {
            this.O000oO0o.O000000o(RefreshState.TwoLevelReleased);
        } else if (this.O000oOO0 == RefreshState.RefreshReleased) {
            if (this.O000ooOO == null) {
                this.O000oO0o.O000000o(this.O000o00);
            }
        } else if (this.O000oOO0 == RefreshState.LoadReleased) {
            if (this.O000ooOO == null) {
                this.O000oO0o.O000000o(-this.O000o00o);
            }
        } else if (this.O00000Oo != 0) {
            this.O000oO0o.O000000o(0);
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.czw.O000000o(int, boolean):_m_j.czw
     arg types: [int, int]
     candidates:
      _m_j.czw.O000000o(_m_j.czv, int):_m_j.czw
      _m_j.czw.O000000o(_m_j.czv, boolean):_m_j.czw
      _m_j.czw.O000000o(int, boolean):_m_j.czw */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.Math.max(float, float):float}
     arg types: [int, float]
     candidates:
      ClspMth{java.lang.Math.max(double, double):double}
      ClspMth{java.lang.Math.max(int, int):int}
      ClspMth{java.lang.Math.max(long, long):long}
      ClspMth{java.lang.Math.max(float, float):float} */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.Math.min(float, float):float}
     arg types: [int, float]
     candidates:
      ClspMth{java.lang.Math.min(double, double):double}
      ClspMth{java.lang.Math.min(long, long):long}
      ClspMth{java.lang.Math.min(int, int):int}
      ClspMth{java.lang.Math.min(float, float):float} */
    /* access modifiers changed from: protected */
    public final void O000000o(float f) {
        float f2 = f;
        if (this.O000oOO0 == RefreshState.TwoLevel && f2 > 0.0f) {
            this.O000oO0o.O000000o(Math.min((int) f2, getMeasuredHeight()), true);
        } else if (this.O000oOO0 == RefreshState.Refreshing && f2 >= 0.0f) {
            int i = this.O000o00;
            if (f2 < ((float) i)) {
                this.O000oO0o.O000000o((int) f2, true);
            } else {
                double d = (double) ((this.O000o0OO - 1.0f) * ((float) i));
                int max = Math.max((this.O0000O0o * 4) / 3, getHeight());
                int i2 = this.O000o00;
                double d2 = (double) (max - i2);
                double max2 = (double) Math.max(0.0f, (f2 - ((float) i2)) * this.O0000Ooo);
                Double.isNaN(max2);
                double d3 = -max2;
                if (d2 == 0.0d) {
                    d2 = 1.0d;
                }
                Double.isNaN(d);
                this.O000oO0o.O000000o(((int) Math.min(d * (1.0d - Math.pow(100.0d, d3 / d2)), max2)) + this.O000o00, true);
            }
        } else if (f2 < 0.0f && (this.O000oOO0 == RefreshState.Loading || ((this.O000O0o && this.O000Oo00 && O000000o(this.O000O00o)) || (this.O000OO0o && !this.O000Oo00 && O000000o(this.O000O00o))))) {
            int i3 = this.O000o00o;
            if (f2 > ((float) (-i3))) {
                this.O000oO0o.O000000o((int) f2, true);
            } else {
                double d4 = (double) ((this.O000o0Oo - 1.0f) * ((float) i3));
                int max3 = Math.max((this.O0000O0o * 4) / 3, getHeight());
                int i4 = this.O000o00o;
                double d5 = (double) (max3 - i4);
                double d6 = (double) (-Math.min(0.0f, (((float) i4) + f2) * this.O0000Ooo));
                Double.isNaN(d6);
                double d7 = -d6;
                if (d5 == 0.0d) {
                    d5 = 1.0d;
                }
                Double.isNaN(d4);
                this.O000oO0o.O000000o(((int) (-Math.min(d4 * (1.0d - Math.pow(100.0d, d7 / d5)), d6))) - this.O000o00o, true);
            }
        } else if (f2 >= 0.0f) {
            double d8 = (double) (this.O000o0OO * ((float) this.O000o00));
            double max4 = (double) Math.max(this.O0000O0o / 2, getHeight());
            double max5 = (double) Math.max(0.0f, this.O0000Ooo * f2);
            Double.isNaN(max5);
            double d9 = -max5;
            if (max4 == 0.0d) {
                max4 = 1.0d;
            }
            Double.isNaN(d8);
            this.O000oO0o.O000000o((int) Math.min(d8 * (1.0d - Math.pow(100.0d, d9 / max4)), max5), true);
        } else {
            double d10 = (double) (this.O000o0Oo * ((float) this.O000o00o));
            double max6 = (double) Math.max(this.O0000O0o / 2, getHeight());
            double d11 = (double) (-Math.min(0.0f, this.O0000Ooo * f2));
            Double.isNaN(d11);
            double d12 = -d11;
            if (max6 == 0.0d) {
                max6 = 1.0d;
            }
            Double.isNaN(d10);
            this.O000oO0o.O000000o((int) (-Math.min(d10 * (1.0d - Math.pow(100.0d, d12 / max6)), d11)), true);
        }
        if (this.O000OO0o && !this.O000Oo00 && O000000o(this.O000O00o) && f2 < 0.0f && this.O000oOO0 != RefreshState.Refreshing && this.O000oOO0 != RefreshState.Loading && this.O000oOO0 != RefreshState.LoadFinish) {
            O000000o();
            if (this.O000OOoo) {
                this.O000ooO = null;
                this.O000oO0o.O000000o(-this.O000o00o);
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {

        /* renamed from: O000000o  reason: collision with root package name */
        public int f5569O000000o = 0;
        public SpinnerStyle O00000Oo = null;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.layout_srlBackgroundColor, R.attr.layout_srlSpinnerStyle});
            this.f5569O000000o = obtainStyledAttributes.getColor(0, this.f5569O000000o);
            if (obtainStyledAttributes.hasValue(1)) {
                this.O00000Oo = SpinnerStyle.values()[obtainStyledAttributes.getInt(1, SpinnerStyle.Translate.ordinal())];
            }
            obtainStyledAttributes.recycle();
        }

        public LayoutParams(int i, int i2) {
            super(-1, i2);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public int getNestedScrollAxes() {
        return this.O000o000.O000000o();
    }

    public boolean onStartNestedScroll(View view, View view2, int i) {
        return (isEnabled() && isNestedScrollingEnabled() && (i & 2) != 0) && (this.O000OO00 || O000000o(this.O00oOooo) || O000000o(this.O000O00o));
    }

    public void onNestedScrollAccepted(View view, View view2, int i) {
        this.O000o000.O000000o(i, 0);
        this.O000Oooo.O000000o(i & 2, 0);
        this.O000Ooo0 = this.O00000Oo;
        this.O000Ooo = true;
    }

    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        int i3;
        int i4 = this.O000Ooo0;
        if (i2 * i4 > 0) {
            if (Math.abs(i2) > Math.abs(this.O000Ooo0)) {
                i3 = this.O000Ooo0;
                this.O000Ooo0 = 0;
            } else {
                this.O000Ooo0 -= i2;
                i3 = i2;
            }
            O000000o((float) this.O000Ooo0);
            if (this.O000oOO.isOpening || this.O000oOO == RefreshState.None) {
                if (this.O00000Oo > 0) {
                    this.O000oO0o.O000000o(RefreshState.PullDownToRefresh);
                } else {
                    this.O000oO0o.O000000o(RefreshState.PullUpToLoad);
                }
            }
        } else if (i2 <= 0 || !this.O000oOoo) {
            i3 = 0;
        } else {
            this.O000Ooo0 = i4 - i2;
            O000000o((float) this.O000Ooo0);
            i3 = i2;
        }
        this.O000Oooo.O000000o(i, i2 - i3, iArr, null);
        iArr[1] = iArr[1] + i3;
    }

    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        this.O000Oooo.O000000o(i, i2, i3, i4, this.O000OooO);
        int i5 = i4 + this.O000OooO[1];
        if (i5 == 0) {
            return;
        }
        if (this.O000OO00 || ((i5 < 0 && O000000o(this.O00oOooo)) || (i5 > 0 && O000000o(this.O000O00o)))) {
            if (this.O000oOO == RefreshState.None) {
                this.O000oO0o.O000000o(i5 > 0 ? RefreshState.PullUpToLoad : RefreshState.PullDownToRefresh);
            }
            int i6 = this.O000Ooo0 - i5;
            this.O000Ooo0 = i6;
            O000000o((float) i6);
        }
    }

    public boolean onNestedPreFling(View view, float f, float f2) {
        return (this.O000oOoo && f2 > 0.0f) || O000000o(Float.valueOf(-f2)) || this.O000Oooo.O000000o(f, f2);
    }

    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        return this.O000Oooo.O000000o(f, f2, z);
    }

    public void onStopNestedScroll(View view) {
        this.O000o000.O000000o(0);
        this.O000Ooo = false;
        this.O000Ooo0 = 0;
        O0000OoO();
        this.O000Oooo.O00000Oo(0);
    }

    public void setNestedScrollingEnabled(boolean z) {
        this.O000Oo0O = true;
        this.O000Oooo.O000000o(z);
    }

    public boolean isNestedScrollingEnabled() {
        return this.O000Oooo.f13211O000000o;
    }

    /* renamed from: O00000Oo */
    public final SmartRefreshLayout O0000O0o(boolean z) {
        this.O000Oo0 = true;
        this.O000O00o = z;
        return this;
    }

    public final SmartRefreshLayout O00000o0(boolean z) {
        this.O00oOooo = false;
        return this;
    }

    public final SmartRefreshLayout O00000o(boolean z) {
        this.O000OO0o = z;
        return this;
    }

    public final czx O00000oO() {
        setNestedScrollingEnabled(false);
        return this;
    }

    public czt getRefreshFooter() {
        czv czv = this.O000o;
        if (czv instanceof czt) {
            return (czt) czv;
        }
        return null;
    }

    public czu getRefreshHeader() {
        czv czv = this.O000o0oo;
        if (czv instanceof czu) {
            return (czu) czv;
        }
        return null;
    }

    public RefreshState getState() {
        return this.O000oOO0;
    }

    public final SmartRefreshLayout O000000o(dai dai) {
        this.O000OoO = dai;
        this.O000O00o = this.O000O00o || (!this.O000Oo0 && dai != null);
        return this;
    }

    public final SmartRefreshLayout O00000oO(boolean z) {
        this.O000Oo00 = z;
        czv czv = this.O000o;
        if ((czv instanceof czt) && !((czt) czv).O000000o(z)) {
            PrintStream printStream = System.out;
            printStream.println("Footer:" + this.O000o + " NoMoreData is not supported.(不支持NoMoreData)");
        }
        return this;
    }

    /* renamed from: O00000oo */
    public final SmartRefreshLayout O0000O0o() {
        return O00000Oo(Math.min(Math.max(0, 300 - ((int) (System.currentTimeMillis() - this.O000oOOO))), 300));
    }

    public final SmartRefreshLayout O00000Oo(int i) {
        postDelayed(new Runnable(true, false) {
            /* class com.scwang.smartrefresh.layout.SmartRefreshLayout.AnonymousClass10 */

            /* renamed from: O000000o  reason: collision with root package name */
            final /* synthetic */ boolean f5559O000000o = true;
            final /* synthetic */ boolean O00000Oo = false;

            public final void run() {
                boolean z = true;
                if (SmartRefreshLayout.this.O000oOO0 == RefreshState.Loading && SmartRefreshLayout.this.O000o != null && SmartRefreshLayout.this.O000oO00 != null) {
                    SmartRefreshLayout.this.O000000o(RefreshState.LoadFinish);
                    int O000000o2 = SmartRefreshLayout.this.O000o.O000000o(SmartRefreshLayout.this, this.f5559O000000o);
                    if (O000000o2 < Integer.MAX_VALUE) {
                        if (!this.O00000Oo || !SmartRefreshLayout.this.O000O0o || SmartRefreshLayout.this.O00000Oo >= 0 || !SmartRefreshLayout.this.O000oO00.O00000o()) {
                            z = false;
                        }
                        final int max = SmartRefreshLayout.this.O00000Oo - (z ? Math.max(SmartRefreshLayout.this.O00000Oo, -SmartRefreshLayout.this.O000o00o) : 0);
                        if (SmartRefreshLayout.this.O0000o0 || SmartRefreshLayout.this.O000Ooo) {
                            if (SmartRefreshLayout.this.O0000o0) {
                                SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                                smartRefreshLayout.O0000Oo0 = smartRefreshLayout.O0000OoO;
                                SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
                                smartRefreshLayout2.O0000o0 = false;
                                smartRefreshLayout2.O00000o = smartRefreshLayout2.O00000Oo - max;
                            }
                            long currentTimeMillis = System.currentTimeMillis();
                            SmartRefreshLayout smartRefreshLayout3 = SmartRefreshLayout.this;
                            float f = (float) max;
                            long j = currentTimeMillis;
                            long j2 = currentTimeMillis;
                            boolean unused = SmartRefreshLayout.super.dispatchTouchEvent(MotionEvent.obtain(j, j2, 0, smartRefreshLayout3.O0000Oo, SmartRefreshLayout.this.O0000OoO + f + ((float) (SmartRefreshLayout.this.f5558O000000o * 2)), 0));
                            SmartRefreshLayout smartRefreshLayout4 = SmartRefreshLayout.this;
                            boolean unused2 = SmartRefreshLayout.super.dispatchTouchEvent(MotionEvent.obtain(j, j2, 2, smartRefreshLayout4.O0000Oo, SmartRefreshLayout.this.O0000OoO + f, 0));
                            if (SmartRefreshLayout.this.O000Ooo) {
                                SmartRefreshLayout.this.O000Ooo0 = 0;
                            }
                        }
                        SmartRefreshLayout.this.postDelayed(new Runnable() {
                            /* class com.scwang.smartrefresh.layout.SmartRefreshLayout.AnonymousClass10.AnonymousClass1 */

                            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                             method: _m_j.czw.O000000o(int, boolean):_m_j.czw
                             arg types: [int, int]
                             candidates:
                              _m_j.czw.O000000o(_m_j.czv, int):_m_j.czw
                              _m_j.czw.O000000o(_m_j.czv, boolean):_m_j.czw
                              _m_j.czw.O000000o(int, boolean):_m_j.czw */
                            /* JADX WARNING: Removed duplicated region for block: B:28:0x00b5  */
                            /* JADX WARNING: Removed duplicated region for block: B:30:0x00b9  */
                            public final void run() {
                                ValueAnimator valueAnimator;
                                ValueAnimator.AnimatorUpdateListener O000000o2 = (!SmartRefreshLayout.this.O000OOOo || max >= 0) ? null : SmartRefreshLayout.this.O000oO00.O000000o(SmartRefreshLayout.this.O00000Oo);
                                if (O000000o2 != null) {
                                    O000000o2.onAnimationUpdate(ValueAnimator.ofInt(0, 0));
                                }
                                AnonymousClass1 r2 = new AnimatorListenerAdapter() {
                                    /* class com.scwang.smartrefresh.layout.SmartRefreshLayout.AnonymousClass10.AnonymousClass1.AnonymousClass1 */

                                    public final void onAnimationCancel(Animator animator) {
                                        super.onAnimationEnd(animator);
                                    }

                                    public final void onAnimationEnd(Animator animator) {
                                        SmartRefreshLayout.this.O000oOoo = false;
                                        if (AnonymousClass10.this.O00000Oo) {
                                            SmartRefreshLayout.this.O00000oO(true);
                                        }
                                        if (SmartRefreshLayout.this.O000oOO0 == RefreshState.LoadFinish) {
                                            SmartRefreshLayout.this.O000000o(RefreshState.None);
                                        }
                                    }
                                };
                                if (SmartRefreshLayout.this.O00000Oo <= 0) {
                                    if (O000000o2 != null || SmartRefreshLayout.this.O00000Oo == 0) {
                                        if (SmartRefreshLayout.this.O000ooOO != null) {
                                            SmartRefreshLayout.this.O000ooOO.cancel();
                                            SmartRefreshLayout.this.O000ooOO = null;
                                        }
                                        SmartRefreshLayout.this.O000oO0o.O000000o(0, false);
                                        SmartRefreshLayout.this.O00000o();
                                    } else if (AnonymousClass10.this.O00000Oo && SmartRefreshLayout.this.O000O0o) {
                                        if (SmartRefreshLayout.this.O00000Oo >= (-SmartRefreshLayout.this.O000o00o)) {
                                            SmartRefreshLayout.this.O000000o(RefreshState.None);
                                        } else {
                                            valueAnimator = SmartRefreshLayout.this.O000oO0o.O000000o(-SmartRefreshLayout.this.O000o00o);
                                            if (valueAnimator != null) {
                                                valueAnimator.addListener(r2);
                                                return;
                                            } else {
                                                r2.onAnimationEnd(null);
                                                return;
                                            }
                                        }
                                    }
                                    valueAnimator = null;
                                    if (valueAnimator != null) {
                                    }
                                }
                                valueAnimator = SmartRefreshLayout.this.O000oO0o.O000000o(0);
                                if (valueAnimator != null) {
                                }
                            }
                        }, SmartRefreshLayout.this.O00000Oo < 0 ? (long) O000000o2 : 0);
                    }
                } else if (this.O00000Oo) {
                    SmartRefreshLayout.this.O00000oO(true);
                }
            }
        }, i <= 0 ? 1 : (long) i);
        return this;
    }

    public static void setDefaultRefreshHeaderCreator(czp czp) {
        O000oo0O = czp;
    }

    public static void setDefaultRefreshFooterCreator(czo czo) {
        O000oo0 = czo;
    }

    public static void setDefaultRefreshInitializer(czq czq) {
        O000oo0o = czq;
    }

    public class O00000o0 implements czw {
        public O00000o0() {
        }

        public final czx O000000o() {
            return SmartRefreshLayout.this;
        }

        public final czs O00000Oo() {
            return SmartRefreshLayout.this.O000oO00;
        }

        public final czw O000000o(RefreshState refreshState) {
            switch (AnonymousClass2.f5562O000000o[refreshState.ordinal()]) {
                case 1:
                    SmartRefreshLayout.this.O00000o();
                    return null;
                case 2:
                    if (!SmartRefreshLayout.this.O000oOO0.isOpening) {
                        SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                        if (smartRefreshLayout.O000000o(smartRefreshLayout.O00oOooo)) {
                            SmartRefreshLayout.this.O000000o(RefreshState.PullDownToRefresh);
                            return null;
                        }
                    }
                    SmartRefreshLayout.this.setViceState(RefreshState.PullDownToRefresh);
                    return null;
                case 3:
                    SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
                    if (!smartRefreshLayout2.O000000o(smartRefreshLayout2.O000O00o) || SmartRefreshLayout.this.O000oOO0.isOpening || SmartRefreshLayout.this.O000oOO0.isFinishing || (SmartRefreshLayout.this.O000Oo00 && SmartRefreshLayout.this.O000O0o)) {
                        SmartRefreshLayout.this.setViceState(RefreshState.PullUpToLoad);
                        return null;
                    }
                    SmartRefreshLayout.this.O000000o(RefreshState.PullUpToLoad);
                    return null;
                case 4:
                    if (!SmartRefreshLayout.this.O000oOO0.isOpening) {
                        SmartRefreshLayout smartRefreshLayout3 = SmartRefreshLayout.this;
                        if (smartRefreshLayout3.O000000o(smartRefreshLayout3.O00oOooo)) {
                            SmartRefreshLayout.this.O000000o(RefreshState.PullDownCanceled);
                            SmartRefreshLayout.this.O00000o();
                            return null;
                        }
                    }
                    SmartRefreshLayout.this.setViceState(RefreshState.PullDownCanceled);
                    return null;
                case 5:
                    SmartRefreshLayout smartRefreshLayout4 = SmartRefreshLayout.this;
                    if (!smartRefreshLayout4.O000000o(smartRefreshLayout4.O000O00o) || SmartRefreshLayout.this.O000oOO0.isOpening || (SmartRefreshLayout.this.O000Oo00 && SmartRefreshLayout.this.O000O0o)) {
                        SmartRefreshLayout.this.setViceState(RefreshState.PullUpCanceled);
                        return null;
                    }
                    SmartRefreshLayout.this.O000000o(RefreshState.PullUpCanceled);
                    SmartRefreshLayout.this.O00000o();
                    return null;
                case 6:
                    if (!SmartRefreshLayout.this.O000oOO0.isOpening) {
                        SmartRefreshLayout smartRefreshLayout5 = SmartRefreshLayout.this;
                        if (smartRefreshLayout5.O000000o(smartRefreshLayout5.O00oOooo)) {
                            SmartRefreshLayout.this.O000000o(RefreshState.ReleaseToRefresh);
                            return null;
                        }
                    }
                    SmartRefreshLayout.this.setViceState(RefreshState.ReleaseToRefresh);
                    return null;
                case 7:
                    SmartRefreshLayout smartRefreshLayout6 = SmartRefreshLayout.this;
                    if (!smartRefreshLayout6.O000000o(smartRefreshLayout6.O000O00o) || SmartRefreshLayout.this.O000oOO0.isOpening || SmartRefreshLayout.this.O000oOO0.isFinishing || (SmartRefreshLayout.this.O000Oo00 && SmartRefreshLayout.this.O000O0o)) {
                        SmartRefreshLayout.this.setViceState(RefreshState.ReleaseToLoad);
                        return null;
                    }
                    SmartRefreshLayout.this.O000000o(RefreshState.ReleaseToLoad);
                    return null;
                case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                    if (!SmartRefreshLayout.this.O000oOO0.isOpening) {
                        SmartRefreshLayout smartRefreshLayout7 = SmartRefreshLayout.this;
                        if (smartRefreshLayout7.O000000o(smartRefreshLayout7.O00oOooo)) {
                            SmartRefreshLayout.this.O000000o(RefreshState.ReleaseToTwoLevel);
                            return null;
                        }
                    }
                    SmartRefreshLayout.this.setViceState(RefreshState.ReleaseToTwoLevel);
                    return null;
                case 9:
                    if (!SmartRefreshLayout.this.O000oOO0.isOpening) {
                        SmartRefreshLayout smartRefreshLayout8 = SmartRefreshLayout.this;
                        if (smartRefreshLayout8.O000000o(smartRefreshLayout8.O00oOooo)) {
                            SmartRefreshLayout.this.O000000o(RefreshState.RefreshReleased);
                            return null;
                        }
                    }
                    SmartRefreshLayout.this.setViceState(RefreshState.RefreshReleased);
                    return null;
                case 10:
                    if (!SmartRefreshLayout.this.O000oOO0.isOpening) {
                        SmartRefreshLayout smartRefreshLayout9 = SmartRefreshLayout.this;
                        if (smartRefreshLayout9.O000000o(smartRefreshLayout9.O000O00o)) {
                            SmartRefreshLayout.this.O000000o(RefreshState.LoadReleased);
                            return null;
                        }
                    }
                    SmartRefreshLayout.this.setViceState(RefreshState.LoadReleased);
                    return null;
                case 11:
                    SmartRefreshLayout.this.O00000o0();
                    return null;
                case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                    SmartRefreshLayout.this.O00000Oo();
                    return null;
                case 13:
                    if (SmartRefreshLayout.this.O000oOO0 != RefreshState.Refreshing) {
                        return null;
                    }
                    SmartRefreshLayout.this.O000000o(RefreshState.RefreshFinish);
                    return null;
                case 14:
                    if (SmartRefreshLayout.this.O000oOO0 != RefreshState.Loading) {
                        return null;
                    }
                    SmartRefreshLayout.this.O000000o(RefreshState.LoadFinish);
                    return null;
                case GmsLogger.MAX_PII_TAG_LENGTH:
                    SmartRefreshLayout.this.O000000o(RefreshState.TwoLevelReleased);
                    return null;
                case 16:
                    SmartRefreshLayout.this.O000000o(RefreshState.TwoLevelFinish);
                    return null;
                case 17:
                    SmartRefreshLayout.this.O000000o(RefreshState.TwoLevel);
                    return null;
                default:
                    return null;
            }
        }

        public final czw O000000o(boolean z) {
            if (z) {
                AnonymousClass1 r4 = new AnimatorListenerAdapter() {
                    /* class com.scwang.smartrefresh.layout.SmartRefreshLayout.O00000o0.AnonymousClass1 */

                    public final void onAnimationEnd(Animator animator) {
                        SmartRefreshLayout.this.O000oO0o.O000000o(RefreshState.TwoLevel);
                    }
                };
                ValueAnimator O000000o2 = O000000o(SmartRefreshLayout.this.getMeasuredHeight());
                if (O000000o2 == null || O000000o2 != SmartRefreshLayout.this.O000ooOO) {
                    r4.onAnimationEnd(null);
                } else {
                    O000000o2.setDuration((long) SmartRefreshLayout.this.O00000oO);
                    O000000o2.addListener(r4);
                }
            } else if (O000000o(0) == null) {
                SmartRefreshLayout.this.O000000o(RefreshState.None);
            }
            return this;
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: com.scwang.smartrefresh.layout.SmartRefreshLayout.O00000o0.O000000o(int, boolean):_m_j.czw
         arg types: [int, int]
         candidates:
          com.scwang.smartrefresh.layout.SmartRefreshLayout.O00000o0.O000000o(_m_j.czv, int):_m_j.czw
          com.scwang.smartrefresh.layout.SmartRefreshLayout.O00000o0.O000000o(_m_j.czv, boolean):_m_j.czw
          _m_j.czw.O000000o(_m_j.czv, int):_m_j.czw
          _m_j.czw.O000000o(_m_j.czv, boolean):_m_j.czw
          com.scwang.smartrefresh.layout.SmartRefreshLayout.O00000o0.O000000o(int, boolean):_m_j.czw */
        public final czw O00000o0() {
            if (SmartRefreshLayout.this.O000oOO0 == RefreshState.TwoLevel) {
                SmartRefreshLayout.this.O000oO0o.O000000o(RefreshState.TwoLevelFinish);
                if (SmartRefreshLayout.this.O00000Oo == 0) {
                    O000000o(0, false);
                    SmartRefreshLayout.this.O000000o(RefreshState.None);
                } else {
                    O000000o(0).setDuration((long) SmartRefreshLayout.this.O00000oO);
                }
            }
            return this;
        }

        public final czw O000000o(int i, boolean z) {
            if (SmartRefreshLayout.this.O00000Oo == i && ((SmartRefreshLayout.this.O000o0oo == null || !SmartRefreshLayout.this.O000o0oo.O00000Oo()) && (SmartRefreshLayout.this.O000o == null || !SmartRefreshLayout.this.O000o.O00000Oo()))) {
                return this;
            }
            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
            int i2 = smartRefreshLayout.O00000Oo;
            SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
            smartRefreshLayout2.O00000Oo = i;
            if (z && smartRefreshLayout2.O000oOO.isDragging) {
                if (((float) SmartRefreshLayout.this.O00000Oo) > ((float) SmartRefreshLayout.this.O000o00) * SmartRefreshLayout.this.O000o0o0) {
                    if (SmartRefreshLayout.this.O000oOO0 != RefreshState.ReleaseToTwoLevel) {
                        SmartRefreshLayout.this.O000oO0o.O000000o(RefreshState.ReleaseToRefresh);
                    }
                } else if (((float) (-SmartRefreshLayout.this.O00000Oo)) > ((float) SmartRefreshLayout.this.O000o00o) * SmartRefreshLayout.this.O000o0o && !SmartRefreshLayout.this.O000Oo00) {
                    SmartRefreshLayout.this.O000oO0o.O000000o(RefreshState.ReleaseToLoad);
                } else if (SmartRefreshLayout.this.O00000Oo < 0 && !SmartRefreshLayout.this.O000Oo00) {
                    SmartRefreshLayout.this.O000oO0o.O000000o(RefreshState.PullUpToLoad);
                } else if (SmartRefreshLayout.this.O00000Oo > 0) {
                    SmartRefreshLayout.this.O000oO0o.O000000o(RefreshState.PullDownToRefresh);
                }
            }
            int i3 = 1;
            if (SmartRefreshLayout.this.O000oO00 != null) {
                Integer num = null;
                if (i >= 0 && SmartRefreshLayout.this.O000o0oo != null) {
                    SmartRefreshLayout smartRefreshLayout3 = SmartRefreshLayout.this;
                    if (smartRefreshLayout3.O000000o(smartRefreshLayout3.O00oOoOo, SmartRefreshLayout.this.O000o0oo)) {
                        num = Integer.valueOf(i);
                    } else if (i2 < 0) {
                        num = 0;
                    }
                }
                if (i <= 0 && SmartRefreshLayout.this.O000o != null) {
                    SmartRefreshLayout smartRefreshLayout4 = SmartRefreshLayout.this;
                    if (smartRefreshLayout4.O000000o(smartRefreshLayout4.O000O0o0, SmartRefreshLayout.this.O000o)) {
                        num = Integer.valueOf(i);
                    } else if (i2 > 0) {
                        num = 0;
                    }
                }
                if (num != null) {
                    SmartRefreshLayout.this.O000oO00.O000000o(num.intValue(), SmartRefreshLayout.this.O0000oO0, SmartRefreshLayout.this.O0000oO);
                    boolean z2 = (SmartRefreshLayout.this.O000O0OO && SmartRefreshLayout.this.O000o0oo != null && SmartRefreshLayout.this.O000o0oo.getSpinnerStyle() == SpinnerStyle.FixedBehind) || SmartRefreshLayout.this.O000oOOo != 0;
                    boolean z3 = (SmartRefreshLayout.this.O000O0Oo && SmartRefreshLayout.this.O000o != null && SmartRefreshLayout.this.O000o.getSpinnerStyle() == SpinnerStyle.FixedBehind) || SmartRefreshLayout.this.O000oOo0 != 0;
                    if ((z2 && (num.intValue() >= 0 || i2 > 0)) || (z3 && (num.intValue() <= 0 || i2 < 0))) {
                        smartRefreshLayout.invalidate();
                    }
                }
            }
            if ((i >= 0 || i2 > 0) && SmartRefreshLayout.this.O000o0oo != null) {
                int max = Math.max(i, 0);
                int i4 = SmartRefreshLayout.this.O000o00;
                int i5 = (int) (((float) SmartRefreshLayout.this.O000o00) * SmartRefreshLayout.this.O000o0OO);
                float f = (((float) max) * 1.0f) / ((float) (SmartRefreshLayout.this.O000o00 == 0 ? 1 : SmartRefreshLayout.this.O000o00));
                SmartRefreshLayout smartRefreshLayout5 = SmartRefreshLayout.this;
                if (smartRefreshLayout5.O000000o(smartRefreshLayout5.O00oOooo) || (SmartRefreshLayout.this.O000oOO0 == RefreshState.RefreshFinish && !z)) {
                    if (i2 != SmartRefreshLayout.this.O00000Oo) {
                        if (SmartRefreshLayout.this.O000o0oo.getSpinnerStyle() == SpinnerStyle.Translate) {
                            SmartRefreshLayout.this.O000o0oo.getView().setTranslationY((float) SmartRefreshLayout.this.O00000Oo);
                            if (!(SmartRefreshLayout.this.O000oOOo == 0 || SmartRefreshLayout.this.O000oO0 == null)) {
                                SmartRefreshLayout smartRefreshLayout6 = SmartRefreshLayout.this;
                                if (!smartRefreshLayout6.O000000o(smartRefreshLayout6.O00oOoOo, SmartRefreshLayout.this.O000o0oo)) {
                                    smartRefreshLayout.invalidate();
                                }
                            }
                        } else if (SmartRefreshLayout.this.O000o0oo.getSpinnerStyle() == SpinnerStyle.Scale) {
                            SmartRefreshLayout.this.O000o0oo.getView().requestLayout();
                        }
                        SmartRefreshLayout.this.O000o0oo.O000000o(z, f, max, i4, i5);
                    }
                    if (z && SmartRefreshLayout.this.O000o0oo.O00000Oo()) {
                        int i6 = (int) SmartRefreshLayout.this.O0000Oo;
                        int width = smartRefreshLayout.getWidth();
                        SmartRefreshLayout.this.O000o0oo.O000000o(SmartRefreshLayout.this.O0000Oo / ((float) (width == 0 ? 1 : width)), i6, width);
                    }
                }
            }
            if ((i <= 0 || i2 < 0) && SmartRefreshLayout.this.O000o != null) {
                int i7 = -Math.min(i, 0);
                int i8 = SmartRefreshLayout.this.O000o00o;
                int i9 = (int) (((float) SmartRefreshLayout.this.O000o00o) * SmartRefreshLayout.this.O000o0Oo);
                float f2 = (((float) i7) * 1.0f) / ((float) (SmartRefreshLayout.this.O000o00o == 0 ? 1 : SmartRefreshLayout.this.O000o00o));
                SmartRefreshLayout smartRefreshLayout7 = SmartRefreshLayout.this;
                if (smartRefreshLayout7.O000000o(smartRefreshLayout7.O000O00o) || (SmartRefreshLayout.this.O000oOO0 == RefreshState.LoadFinish && !z)) {
                    if (i2 != SmartRefreshLayout.this.O00000Oo) {
                        if (SmartRefreshLayout.this.O000o.getSpinnerStyle() == SpinnerStyle.Translate) {
                            SmartRefreshLayout.this.O000o.getView().setTranslationY((float) SmartRefreshLayout.this.O00000Oo);
                            if (!(SmartRefreshLayout.this.O000oOo0 == 0 || SmartRefreshLayout.this.O000oO0 == null)) {
                                SmartRefreshLayout smartRefreshLayout8 = SmartRefreshLayout.this;
                                if (!smartRefreshLayout8.O000000o(smartRefreshLayout8.O000O0o0, SmartRefreshLayout.this.O000o)) {
                                    smartRefreshLayout.invalidate();
                                }
                            }
                        } else if (SmartRefreshLayout.this.O000o.getSpinnerStyle() == SpinnerStyle.Scale) {
                            SmartRefreshLayout.this.O000o.getView().requestLayout();
                        }
                        SmartRefreshLayout.this.O000o.O000000o(z, f2, i7, i8, i9);
                    }
                    if (z && SmartRefreshLayout.this.O000o.O00000Oo()) {
                        int i10 = (int) SmartRefreshLayout.this.O0000Oo;
                        int width2 = smartRefreshLayout.getWidth();
                        float f3 = SmartRefreshLayout.this.O0000Oo;
                        if (width2 != 0) {
                            i3 = width2;
                        }
                        SmartRefreshLayout.this.O000o.O000000o(f3 / ((float) i3), i10, width2);
                    }
                }
            }
            return this;
        }

        public final ValueAnimator O000000o(int i) {
            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
            return smartRefreshLayout.O000000o(i, 0, smartRefreshLayout.O0000ooo, SmartRefreshLayout.this.O00000oo);
        }

        public final czw O000000o(czv czv, int i) {
            if (SmartRefreshLayout.this.O000oO0 == null && i != 0) {
                SmartRefreshLayout.this.O000oO0 = new Paint();
            }
            if (czv.equals(SmartRefreshLayout.this.O000o0oo)) {
                SmartRefreshLayout.this.O000oOOo = i;
            } else if (czv.equals(SmartRefreshLayout.this.O000o)) {
                SmartRefreshLayout.this.O000oOo0 = i;
            }
            return this;
        }

        public final czw O000000o(czv czv, boolean z) {
            if (czv.equals(SmartRefreshLayout.this.O000o0oo)) {
                SmartRefreshLayout.this.O000oOo = z;
            } else if (czv.equals(SmartRefreshLayout.this.O000o)) {
                SmartRefreshLayout.this.O000oOoO = z;
            }
            return this;
        }

        public final czw O000000o(czv czv) {
            if (czv.equals(SmartRefreshLayout.this.O000o0oo)) {
                if (!SmartRefreshLayout.this.O000Oo0o) {
                    SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                    smartRefreshLayout.O000Oo0o = true;
                    smartRefreshLayout.O00oOoOo = false;
                }
            } else if (czv.equals(SmartRefreshLayout.this.O000o) && !SmartRefreshLayout.this.O000OoO0) {
                SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
                smartRefreshLayout2.O000OoO0 = true;
                smartRefreshLayout2.O000O0o0 = false;
            }
            return this;
        }

        public final czw O00000Oo(int i) {
            SmartRefreshLayout.this.O00000oO = i;
            return this;
        }
    }

    /* renamed from: com.scwang.smartrefresh.layout.SmartRefreshLayout$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {

        /* renamed from: O000000o  reason: collision with root package name */
        static final /* synthetic */ int[] f5562O000000o = new int[RefreshState.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(36:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|36) */
        /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0040 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x004b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0056 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0062 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x007a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0086 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0092 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x009e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x00aa */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x00b6 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x00c2 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0035 */
        static {
            f5562O000000o[RefreshState.None.ordinal()] = 1;
            f5562O000000o[RefreshState.PullDownToRefresh.ordinal()] = 2;
            f5562O000000o[RefreshState.PullUpToLoad.ordinal()] = 3;
            f5562O000000o[RefreshState.PullDownCanceled.ordinal()] = 4;
            f5562O000000o[RefreshState.PullUpCanceled.ordinal()] = 5;
            f5562O000000o[RefreshState.ReleaseToRefresh.ordinal()] = 6;
            f5562O000000o[RefreshState.ReleaseToLoad.ordinal()] = 7;
            f5562O000000o[RefreshState.ReleaseToTwoLevel.ordinal()] = 8;
            f5562O000000o[RefreshState.RefreshReleased.ordinal()] = 9;
            f5562O000000o[RefreshState.LoadReleased.ordinal()] = 10;
            f5562O000000o[RefreshState.Refreshing.ordinal()] = 11;
            f5562O000000o[RefreshState.Loading.ordinal()] = 12;
            f5562O000000o[RefreshState.RefreshFinish.ordinal()] = 13;
            f5562O000000o[RefreshState.LoadFinish.ordinal()] = 14;
            f5562O000000o[RefreshState.TwoLevelReleased.ordinal()] = 15;
            f5562O000000o[RefreshState.TwoLevelFinish.ordinal()] = 16;
            f5562O000000o[RefreshState.TwoLevel.ordinal()] = 17;
        }
    }

    public boolean post(Runnable runnable) {
        Handler handler = this.O000oO0O;
        if (handler != null) {
            return handler.post(new dan(runnable, 0));
        }
        List<dan> list = this.O000oO;
        if (list == null) {
            list = new ArrayList<>();
        }
        this.O000oO = list;
        this.O000oO.add(new dan(runnable, 0));
        return false;
    }

    public boolean postDelayed(Runnable runnable, long j) {
        if (j == 0) {
            new dan(runnable, 0).run();
            return true;
        }
        Handler handler = this.O000oO0O;
        if (handler != null) {
            return handler.postDelayed(new dan(runnable, 0), j);
        }
        List<dan> list = this.O000oO;
        if (list == null) {
            list = new ArrayList<>();
        }
        this.O000oO = list;
        this.O000oO.add(new dan(runnable, j));
        return false;
    }

    public final SmartRefreshLayout O000000o(int i) {
        postDelayed(new Runnable(true) {
            /* class com.scwang.smartrefresh.layout.SmartRefreshLayout.AnonymousClass9 */

            /* renamed from: O000000o  reason: collision with root package name */
            final /* synthetic */ boolean f5568O000000o = true;

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: _m_j.czw.O000000o(int, boolean):_m_j.czw
             arg types: [int, int]
             candidates:
              _m_j.czw.O000000o(_m_j.czv, int):_m_j.czw
              _m_j.czw.O000000o(_m_j.czv, boolean):_m_j.czw
              _m_j.czw.O000000o(int, boolean):_m_j.czw */
            public final void run() {
                if (SmartRefreshLayout.this.O000oOO0 == RefreshState.Refreshing && SmartRefreshLayout.this.O000o0oo != null && SmartRefreshLayout.this.O000oO00 != null) {
                    if (this.f5568O000000o) {
                        SmartRefreshLayout.this.O00000oO(false);
                    }
                    SmartRefreshLayout.this.O000000o(RefreshState.RefreshFinish);
                    int O000000o2 = SmartRefreshLayout.this.O000o0oo.O000000o(SmartRefreshLayout.this, this.f5568O000000o);
                    if (O000000o2 < Integer.MAX_VALUE) {
                        if (SmartRefreshLayout.this.O0000o0 || SmartRefreshLayout.this.O000Ooo) {
                            if (SmartRefreshLayout.this.O0000o0) {
                                SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                                smartRefreshLayout.O0000Oo0 = smartRefreshLayout.O0000OoO;
                                SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
                                smartRefreshLayout2.O00000o = 0;
                                smartRefreshLayout2.O0000o0 = false;
                            }
                            long currentTimeMillis = System.currentTimeMillis();
                            SmartRefreshLayout smartRefreshLayout3 = SmartRefreshLayout.this;
                            long j = currentTimeMillis;
                            boolean unused = SmartRefreshLayout.super.dispatchTouchEvent(MotionEvent.obtain(currentTimeMillis, j, 0, smartRefreshLayout3.O0000Oo, (SmartRefreshLayout.this.O0000OoO + ((float) SmartRefreshLayout.this.O00000Oo)) - ((float) (SmartRefreshLayout.this.f5558O000000o * 2)), 0));
                            SmartRefreshLayout smartRefreshLayout4 = SmartRefreshLayout.this;
                            boolean unused2 = SmartRefreshLayout.super.dispatchTouchEvent(MotionEvent.obtain(currentTimeMillis, j, 2, smartRefreshLayout4.O0000Oo, SmartRefreshLayout.this.O0000OoO + ((float) SmartRefreshLayout.this.O00000Oo), 0));
                            if (SmartRefreshLayout.this.O000Ooo) {
                                SmartRefreshLayout.this.O000Ooo0 = 0;
                            }
                        }
                        if (SmartRefreshLayout.this.O00000Oo > 0) {
                            ValueAnimator.AnimatorUpdateListener animatorUpdateListener = null;
                            SmartRefreshLayout smartRefreshLayout5 = SmartRefreshLayout.this;
                            ValueAnimator O000000o3 = smartRefreshLayout5.O000000o(0, O000000o2, smartRefreshLayout5.O0000ooo, SmartRefreshLayout.this.O00000oo);
                            if (SmartRefreshLayout.this.O000OOo0) {
                                animatorUpdateListener = SmartRefreshLayout.this.O000oO00.O000000o(SmartRefreshLayout.this.O00000Oo);
                            }
                            if (O000000o3 != null && animatorUpdateListener != null) {
                                O000000o3.addUpdateListener(animatorUpdateListener);
                            }
                        } else if (SmartRefreshLayout.this.O00000Oo < 0) {
                            SmartRefreshLayout smartRefreshLayout6 = SmartRefreshLayout.this;
                            smartRefreshLayout6.O000000o(0, O000000o2, smartRefreshLayout6.O0000ooo, SmartRefreshLayout.this.O00000oo);
                        } else {
                            SmartRefreshLayout.this.O000oO0o.O000000o(0, false);
                            SmartRefreshLayout.this.O00000o();
                        }
                    }
                }
            }
        }, i <= 0 ? 1 : (long) i);
        return this;
    }

    /* access modifiers changed from: protected */
    public /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    /* access modifiers changed from: protected */
    public /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    public /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public final /* bridge */ /* synthetic */ czx O0000Oo0() {
        this.O000OO00 = false;
        return this;
    }

    public final /* bridge */ /* synthetic */ czx O0000Oo() {
        this.O000OO0o = false;
        return this;
    }

    public final /* bridge */ /* synthetic */ czx O00000oo(boolean z) {
        this.O00oOooo = z;
        return this;
    }

    public final /* synthetic */ czx O00000Oo(float f) {
        this.O000o0OO = f;
        czv czv = this.O000o0oo;
        if (czv == null || this.O000oO0O == null) {
            this.O000o00O = this.O000o00O.unNotify();
        } else {
            czw czw = this.O000oO0o;
            int i = this.O000o00;
            czv.O000000o(czw, i, (int) (this.O000o0OO * ((float) i)));
        }
        return this;
    }
}
