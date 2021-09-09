package com.xiaomi.smarthome.operation.view;

import _m_j.gku;
import _m_j.ixe;
import android.content.Context;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.SimpleDraweeView;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001)B\u001b\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006B\u0011\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007B\u001b\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nB#\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rB+\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\u000e\u001a\u00020\f\u0012\u0006\u0010\u000f\u001a\u00020\f¢\u0006\u0002\u0010\u0010J\b\u0010\u001e\u001a\u00020\u001fH\u0002J\u0010\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\"\u001a\u00020#J\b\u0010$\u001a\u00020\u0016H\u0002J\b\u0010%\u001a\u00020\u001fH\u0014J\b\u0010&\u001a\u00020\u001fH\u0014J\u000e\u0010'\u001a\u00020\u001f2\u0006\u0010(\u001a\u00020\u001aR\u000e\u0010\u0011\u001a\u00020\u0012XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/xiaomi/smarthome/operation/view/OperationImageView;", "Lcom/facebook/drawee/view/SimpleDraweeView;", "context", "Landroid/content/Context;", "hierarchy", "Lcom/facebook/drawee/generic/GenericDraweeHierarchy;", "(Landroid/content/Context;Lcom/facebook/drawee/generic/GenericDraweeHierarchy;)V", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleAttr", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "TAG", "", "globalLayoutListener", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "isDetachFromWindow", "", "isRegister", "lastVisibleState", "onVisibleListener", "Lcom/xiaomi/smarthome/operation/view/OperationImageView$IOnVisible;", "windowFocusChangeListener", "Landroid/view/ViewTreeObserver$OnWindowFocusChangeListener;", "windowReFocus", "dispatch", "", "getColorMatrixColorFilter", "Landroid/graphics/ColorMatrixColorFilter;", "darkPct", "", "isVisible", "onAttachedToWindow", "onDetachedFromWindow", "registerOnVisibleToUser", "listener", "IOnVisible", "smarthome-operation_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class OperationImageView extends SimpleDraweeView {
    private final String TAG = "OperationImageView";
    private final ViewTreeObserver.OnGlobalLayoutListener globalLayoutListener;
    private boolean isDetachFromWindow;
    private boolean isRegister;
    private boolean lastVisibleState;
    private O000000o onVisibleListener;
    private final ViewTreeObserver.OnWindowFocusChangeListener windowFocusChangeListener;
    private boolean windowReFocus;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/xiaomi/smarthome/operation/view/OperationImageView$IOnVisible;", "", "onVisible", "", "view", "Landroid/view/View;", "smarthome-operation_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public interface O000000o {
        void onVisible(View view);
    }

    public final void _$_clearFindViewByIdCache() {
    }

    public OperationImageView(Context context, GenericDraweeHierarchy genericDraweeHierarchy) {
        super(context, genericDraweeHierarchy);
        this.lastVisibleState = getVisibility() == 0;
        this.globalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() {
            /* class com.xiaomi.smarthome.operation.view.$$Lambda$OperationImageView$HvxowodHvGEKsA60nw8_VPpVnXM */

            public final void onGlobalLayout() {
                OperationImageView.m423globalLayoutListener$lambda0(OperationImageView.this);
            }
        };
        this.windowFocusChangeListener = new ViewTreeObserver.OnWindowFocusChangeListener() {
            /* class com.xiaomi.smarthome.operation.view.$$Lambda$OperationImageView$eKru70i5sqCa4t5Fe3Bd9_xzbnQ */

            public final void onWindowFocusChanged(boolean z) {
                OperationImageView.m424windowFocusChangeListener$lambda1(OperationImageView.this, z);
            }
        };
        GenericDraweeHierarchy genericDraweeHierarchy2 = (GenericDraweeHierarchy) getHierarchy();
        if (genericDraweeHierarchy2 != null) {
            genericDraweeHierarchy2.setActualImageScaleType(ScalingUtils.ScaleType.FIT_XY);
        }
        if (gku.O000000o(getContext())) {
            setColorFilter(getColorMatrixColorFilter(0.8f));
        }
    }

    public OperationImageView(Context context) {
        super(context);
        this.lastVisibleState = getVisibility() == 0;
        this.globalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() {
            /* class com.xiaomi.smarthome.operation.view.$$Lambda$OperationImageView$HvxowodHvGEKsA60nw8_VPpVnXM */

            public final void onGlobalLayout() {
                OperationImageView.m423globalLayoutListener$lambda0(OperationImageView.this);
            }
        };
        this.windowFocusChangeListener = new ViewTreeObserver.OnWindowFocusChangeListener() {
            /* class com.xiaomi.smarthome.operation.view.$$Lambda$OperationImageView$eKru70i5sqCa4t5Fe3Bd9_xzbnQ */

            public final void onWindowFocusChanged(boolean z) {
                OperationImageView.m424windowFocusChangeListener$lambda1(OperationImageView.this, z);
            }
        };
        GenericDraweeHierarchy genericDraweeHierarchy = (GenericDraweeHierarchy) getHierarchy();
        if (genericDraweeHierarchy != null) {
            genericDraweeHierarchy.setActualImageScaleType(ScalingUtils.ScaleType.FIT_XY);
        }
        if (gku.O000000o(getContext())) {
            setColorFilter(getColorMatrixColorFilter(0.8f));
        }
    }

    public OperationImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.lastVisibleState = getVisibility() == 0;
        this.globalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() {
            /* class com.xiaomi.smarthome.operation.view.$$Lambda$OperationImageView$HvxowodHvGEKsA60nw8_VPpVnXM */

            public final void onGlobalLayout() {
                OperationImageView.m423globalLayoutListener$lambda0(OperationImageView.this);
            }
        };
        this.windowFocusChangeListener = new ViewTreeObserver.OnWindowFocusChangeListener() {
            /* class com.xiaomi.smarthome.operation.view.$$Lambda$OperationImageView$eKru70i5sqCa4t5Fe3Bd9_xzbnQ */

            public final void onWindowFocusChanged(boolean z) {
                OperationImageView.m424windowFocusChangeListener$lambda1(OperationImageView.this, z);
            }
        };
        GenericDraweeHierarchy genericDraweeHierarchy = (GenericDraweeHierarchy) getHierarchy();
        if (genericDraweeHierarchy != null) {
            genericDraweeHierarchy.setActualImageScaleType(ScalingUtils.ScaleType.FIT_XY);
        }
        if (gku.O000000o(getContext())) {
            setColorFilter(getColorMatrixColorFilter(0.8f));
        }
    }

    public OperationImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.lastVisibleState = getVisibility() == 0;
        this.globalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() {
            /* class com.xiaomi.smarthome.operation.view.$$Lambda$OperationImageView$HvxowodHvGEKsA60nw8_VPpVnXM */

            public final void onGlobalLayout() {
                OperationImageView.m423globalLayoutListener$lambda0(OperationImageView.this);
            }
        };
        this.windowFocusChangeListener = new ViewTreeObserver.OnWindowFocusChangeListener() {
            /* class com.xiaomi.smarthome.operation.view.$$Lambda$OperationImageView$eKru70i5sqCa4t5Fe3Bd9_xzbnQ */

            public final void onWindowFocusChanged(boolean z) {
                OperationImageView.m424windowFocusChangeListener$lambda1(OperationImageView.this, z);
            }
        };
        GenericDraweeHierarchy genericDraweeHierarchy = (GenericDraweeHierarchy) getHierarchy();
        if (genericDraweeHierarchy != null) {
            genericDraweeHierarchy.setActualImageScaleType(ScalingUtils.ScaleType.FIT_XY);
        }
        if (gku.O000000o(getContext())) {
            setColorFilter(getColorMatrixColorFilter(0.8f));
        }
    }

    public OperationImageView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.lastVisibleState = getVisibility() == 0;
        this.globalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() {
            /* class com.xiaomi.smarthome.operation.view.$$Lambda$OperationImageView$HvxowodHvGEKsA60nw8_VPpVnXM */

            public final void onGlobalLayout() {
                OperationImageView.m423globalLayoutListener$lambda0(OperationImageView.this);
            }
        };
        this.windowFocusChangeListener = new ViewTreeObserver.OnWindowFocusChangeListener() {
            /* class com.xiaomi.smarthome.operation.view.$$Lambda$OperationImageView$eKru70i5sqCa4t5Fe3Bd9_xzbnQ */

            public final void onWindowFocusChanged(boolean z) {
                OperationImageView.m424windowFocusChangeListener$lambda1(OperationImageView.this, z);
            }
        };
        GenericDraweeHierarchy genericDraweeHierarchy = (GenericDraweeHierarchy) getHierarchy();
        if (genericDraweeHierarchy != null) {
            genericDraweeHierarchy.setActualImageScaleType(ScalingUtils.ScaleType.FIT_XY);
        }
        if (gku.O000000o(getContext())) {
            setColorFilter(getColorMatrixColorFilter(0.8f));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: globalLayoutListener$lambda-0  reason: not valid java name */
    public static final void m423globalLayoutListener$lambda0(OperationImageView operationImageView) {
        ixe.O00000o(operationImageView, "this$0");
        operationImageView.dispatch();
    }

    /* access modifiers changed from: private */
    /* renamed from: windowFocusChangeListener$lambda-1  reason: not valid java name */
    public static final void m424windowFocusChangeListener$lambda1(OperationImageView operationImageView, boolean z) {
        ixe.O00000o(operationImageView, "this$0");
        if (z) {
            operationImageView.windowReFocus = true;
        }
        operationImageView.dispatch();
        operationImageView.windowReFocus = false;
    }

    public final ColorMatrixColorFilter getColorMatrixColorFilter(float f) {
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setScale(f, f, f, 1.0f);
        return new ColorMatrixColorFilter(colorMatrix);
    }

    private final void dispatch() {
        O000000o o000000o;
        O000000o o000000o2;
        boolean isVisible = isVisible();
        if (this.windowReFocus) {
            if (isVisible && (o000000o2 = this.onVisibleListener) != null) {
                o000000o2.onVisible(this);
            }
            this.lastVisibleState = isVisible;
            return;
        }
        boolean z = this.lastVisibleState;
        if (isVisible != z) {
            if (!z && isVisible && (o000000o = this.onVisibleListener) != null) {
                o000000o.onVisible(this);
            }
            this.lastVisibleState = isVisible;
        }
    }

    public final void registerOnVisibleToUser(O000000o o000000o) {
        ixe.O00000o(o000000o, "listener");
        if (!this.isDetachFromWindow) {
            if (!this.isRegister) {
                this.isRegister = true;
                getViewTreeObserver().addOnGlobalLayoutListener(this.globalLayoutListener);
                getViewTreeObserver().addOnWindowFocusChangeListener(this.windowFocusChangeListener);
            }
            if (this.lastVisibleState) {
                o000000o.onVisible(this);
            }
            this.onVisibleListener = o000000o;
        }
    }

    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.isDetachFromWindow = true;
        getViewTreeObserver().removeOnGlobalLayoutListener(this.globalLayoutListener);
        getViewTreeObserver().removeOnWindowFocusChangeListener(this.windowFocusChangeListener);
    }

    private final boolean isVisible() {
        return getLocalVisibleRect(new Rect()) && isShown();
    }
}
