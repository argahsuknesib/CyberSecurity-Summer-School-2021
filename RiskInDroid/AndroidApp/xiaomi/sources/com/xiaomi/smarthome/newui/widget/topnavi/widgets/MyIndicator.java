package com.xiaomi.smarthome.newui.widget.topnavi.widgets;

import _m_j.gty;
import _m_j.gzq;
import _m_j.hhr;
import _m_j.hid;
import _m_j.hxi;
import _m_j.hxk;
import _m_j.iuo;
import _m_j.ixc;
import _m_j.ixe;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import com.google.android.material.appbar.AppBarLayout;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.newui.MainRoomMenuPopupWindow;
import com.xiaomi.smarthome.newui.widget.ImageFilterViewCopy;
import com.xiaomi.smarthome.newui.widget.topnavi.PageBean;
import com.xiaomi.smarthome.newui.widget.topnavi.indicator.buildins.ObservableHorizontalScrollView;
import com.xiaomi.smarthome.newui.widget.topnavi.indicator.buildins.commonnavigator.CommonNavigator;
import com.xiaomi.smarthome.newui.widget.topnavi.widgets.DeviceRoomRenderState;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B%\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u000e\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eJ\u0006\u0010\u001f\u001a\u00020\u001cJ\b\u0010 \u001a\u00020\u001cH\u0002J\u0012\u0010!\u001a\u00020\u001c2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0014J\u0010\u0010$\u001a\u00020\u000f2\u0006\u0010%\u001a\u00020&H\u0016J\u0018\u0010'\u001a\u00020\u001c2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\bH\u0016J\u000e\u0010+\u001a\u00020\u001c2\u0006\u0010,\u001a\u00020-R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019X\u000e¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lcom/xiaomi/smarthome/newui/widget/topnavi/widgets/MyIndicator;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/google/android/material/appbar/AppBarLayout$OnOffsetChangedListener;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "disposables", "Lio/reactivex/disposables/CompositeDisposable;", "edgeTransparentView", "Lcom/xiaomi/smarthome/newui/widget/topnavi/widgets/FadingEdgeLayout;", "inEditModeAny", "", "interpolator", "Landroid/view/animation/Interpolator;", "lastPercent", "", "menuIcon", "Lcom/xiaomi/smarthome/newui/widget/ImageFilterViewCopy;", "pageIndicator", "Lcom/xiaomi/smarthome/newui/widget/topnavi/widgets/PageIndicator;", "pages", "", "Lcom/xiaomi/smarthome/newui/widget/topnavi/PageBean;", "attachViewPager", "", "viewPager", "Landroidx/viewpager/widget/ViewPager;", "dispose", "flex", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onInterceptTouchEvent", "ev", "Landroid/view/MotionEvent;", "onOffsetChanged", "appbar", "Lcom/google/android/material/appbar/AppBarLayout;", "offset", "render", "state", "Lcom/xiaomi/smarthome/newui/widget/topnavi/widgets/DeviceRoomRenderState;", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class MyIndicator extends ConstraintLayout implements AppBarLayout.OnOffsetChangedListener {

    /* renamed from: O000000o  reason: collision with root package name */
    public final PageIndicator f10370O000000o;
    public final CompositeDisposable O00000Oo;
    private final ImageFilterViewCopy O00000o;
    private final FadingEdgeLayout O00000o0;
    private List<PageBean> O00000oO;
    private boolean O00000oo;
    private float O0000O0o;
    private final Interpolator O0000OOo;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public MyIndicator(Context context) {
        this(context, null, 0, 6, null);
        ixe.O00000o(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public MyIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        ixe.O00000o(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MyIndicator(Context context, AttributeSet attributeSet, int i, int i2, ixc ixc) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MyIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        ixe.O00000o(context, "context");
        this.O00000Oo = new CompositeDisposable();
        View.inflate(context, R.layout.top_navi_layout, this);
        View findViewById = findViewById(R.id.page_indicator);
        ixe.O00000Oo(findViewById, "findViewById(R.id.page_indicator)");
        this.f10370O000000o = (PageIndicator) findViewById;
        View findViewById2 = findViewById(R.id.edge_transparent_view);
        ixe.O00000Oo(findViewById2, "findViewById(R.id.edge_transparent_view)");
        this.O00000o0 = (FadingEdgeLayout) findViewById2;
        View findViewById3 = findViewById(R.id.arrow_down_img);
        ixe.O00000Oo(findViewById3, "findViewById(R.id.arrow_down_img)");
        this.O00000o = (ImageFilterViewCopy) findViewById3;
        this.O00000o.setContentDescription(context.getString(R.string.navi_open_accessibility_desc));
        this.O00000o.setOnClickListener(new View.OnClickListener(context) {
            /* class com.xiaomi.smarthome.newui.widget.topnavi.widgets.$$Lambda$MyIndicator$Cc5MsbJGLhNVWiphGwaLgQUxk */
            private final /* synthetic */ Context f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                MyIndicator.O000000o(MyIndicator.this, this.f$1, view);
            }
        });
        hhr navigator = this.f10370O000000o.getNavigator();
        if (navigator != null) {
            this.O00000o0.setFadeEdges$1d54120b(false);
            ((CommonNavigator) navigator).setScrollViewListener(new ObservableHorizontalScrollView.O000000o() {
                /* class com.xiaomi.smarthome.newui.widget.topnavi.widgets.$$Lambda$MyIndicator$C38_vHwm9cdtPnp6JwAXUrkkU9k */

                public final void onScrollChanged(ObservableHorizontalScrollView observableHorizontalScrollView, int i, int i2, int i3, int i4) {
                    MyIndicator.O000000o(MyIndicator.this, observableHorizontalScrollView, i, i2, i3, i4);
                }
            });
            CompositeDisposable compositeDisposable = this.O00000Oo;
            gzq.O000000o o000000o = gzq.f18638O000000o;
            gzq.O000000o o000000o2 = gzq.f18638O000000o;
            compositeDisposable.addAll(Observable.merge(gzq.O00000o.map($$Lambda$MyIndicator$oiUrgCpiYITnAAajhCilqkk_74U.INSTANCE), gzq.O00000oO.map($$Lambda$MyIndicator$zkiGyv6iHYnNskxe8PQgulZptXo.INSTANCE)).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer() {
                /* class com.xiaomi.smarthome.newui.widget.topnavi.widgets.$$Lambda$MyIndicator$bsda7RPT1CwT3yqkUEdkxzkwM */

                public final void accept(Object obj) {
                    MyIndicator.O000000o(MyIndicator.this, (Boolean) obj);
                }
            }));
            O000000o();
            this.O0000O0o = -1.0f;
            this.O0000OOo = new AccelerateInterpolator(2.0f);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.xiaomi.smarthome.newui.widget.topnavi.indicator.buildins.commonnavigator.CommonNavigator");
    }

    /* access modifiers changed from: private */
    public static final void O000000o(MyIndicator myIndicator, Context context, View view) {
        ixe.O00000o(myIndicator, "this$0");
        ixe.O00000o(context, "$context");
        if (!myIndicator.O00000oo) {
            if (!CoreApi.O000000o().O0000Ooo()) {
                gty.O000000o().startLogin(context, 1, null);
                return;
            }
            List<PageBean> list = myIndicator.O00000oO;
            if (list != null) {
                new MainRoomMenuPopupWindow((FragmentActivity) context, myIndicator.O00000o).e_();
                hxk hxk = hxi.O00000o;
                long currentTimeMillis = System.currentTimeMillis();
                String O0000o0 = CoreApi.O000000o().O0000o0();
                int size = list.size();
                hxk.f952O000000o.O000000o("home.tab.all.clk", "time", Long.valueOf(currentTimeMillis), "uid", O0000o0, "total number", Integer.valueOf(size));
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void O000000o(MyIndicator myIndicator, ObservableHorizontalScrollView observableHorizontalScrollView, int i, int i2, int i3, int i4) {
        ixe.O00000o(myIndicator, "this$0");
        if (observableHorizontalScrollView.getScrollX() > 0) {
            myIndicator.O00000o0.setFadeEdges$1d54120b(true);
        } else {
            myIndicator.O00000o0.setFadeEdges$1d54120b(false);
        }
    }

    /* access modifiers changed from: private */
    public static final Boolean O000000o(Intent intent) {
        ixe.O00000o(intent, "it");
        return Boolean.valueOf(intent.getBooleanExtra("main_extra_card_edit_mode_is_edit_mode", false));
    }

    /* access modifiers changed from: private */
    public static final Boolean O00000Oo(Intent intent) {
        ixe.O00000o(intent, "it");
        return Boolean.valueOf(intent.getBooleanExtra("main_extra_scene_edit_mode_is_edit_mode", false));
    }

    /* access modifiers changed from: private */
    public static final void O000000o(MyIndicator myIndicator, Boolean bool) {
        ixe.O00000o(myIndicator, "this$0");
        ixe.O00000Oo(bool, "it");
        myIndicator.O00000oo = bool.booleanValue();
    }

    public final void O000000o(DeviceRoomRenderState deviceRoomRenderState) {
        List list;
        ixe.O00000o(deviceRoomRenderState, "state");
        if (deviceRoomRenderState instanceof DeviceRoomRenderState.DeviceRoomState) {
            Iterable<hid> iterable = ((DeviceRoomRenderState.DeviceRoomState) deviceRoomRenderState).O00000Oo;
            Collection arrayList = new ArrayList(iuo.O000000o(iterable, 10));
            for (hid hid : iterable) {
                arrayList.add(hid.f18959O000000o);
            }
            List<PageBean> list2 = (List) arrayList;
            List<PageBean> list3 = this.O00000oO;
            if (list3 == null) {
                list = null;
            } else {
                Iterable<PageBean> iterable2 = list3;
                Collection arrayList2 = new ArrayList(iuo.O000000o(iterable2, 10));
                for (PageBean pageBean : iterable2) {
                    arrayList2.add(pageBean.f10340O000000o);
                }
                list = (List) arrayList2;
            }
            Iterable<PageBean> iterable3 = list2;
            Collection arrayList3 = new ArrayList(iuo.O000000o(iterable3, 10));
            for (PageBean pageBean2 : iterable3) {
                arrayList3.add(pageBean2.f10340O000000o);
            }
            if (!ixe.O000000o(list, (List) arrayList3)) {
                this.O00000oO = list2;
                this.f10370O000000o.O000000o(list2);
            }
            this.O00000o.setVisibility(0);
            return;
        }
        PageBean.O000000o o000000o = PageBean.CREATOR;
        this.O00000oO = iuo.O000000o(PageBean.O000000o.O000000o());
        this.f10370O000000o.O000000o(this.O00000oO);
        this.O00000o.setVisibility(4);
    }

    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        ixe.O00000o(motionEvent, "ev");
        return this.O00000oo || super.onInterceptTouchEvent(motionEvent);
    }

    public final void onOffsetChanged(AppBarLayout appBarLayout, int i) {
        ixe.O00000o(appBarLayout, "appbar");
        float abs = Math.abs(((float) i) / ((float) appBarLayout.getTotalScrollRange()));
        if (!(abs == this.O0000O0o)) {
            this.O0000O0o = abs;
            this.O00000o.setCrossfade(this.O0000OOo.getInterpolation(abs));
        }
    }

    /* access modifiers changed from: protected */
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        O000000o();
    }

    private final void O000000o() {
        int dimension = (int) getResources().getDimension(R.dimen.main_page_flex_padding);
        setPadding(dimension, 0, dimension, 0);
    }
}
