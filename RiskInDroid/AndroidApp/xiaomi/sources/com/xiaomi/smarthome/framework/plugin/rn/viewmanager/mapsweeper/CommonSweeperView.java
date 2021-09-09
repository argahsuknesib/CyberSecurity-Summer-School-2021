package com.xiaomi.smarthome.framework.plugin.rn.viewmanager.mapsweeper;

import _m_j.gbu;
import _m_j.gcs;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import android.widget.Scroller;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.views.image.ImageResizeMode;
import com.facebook.react.views.image.ReactImageView;
import com.xiaomi.smarthome.R;

public class CommonSweeperView extends RelativeLayout {

    /* renamed from: O000000o  reason: collision with root package name */
    Context f8596O000000o;
    public ReactImageView O00000Oo;
    int O00000o;
    public ReactImageView O00000o0;
    int O00000oO;
    Handler O00000oo;
    private AbstractDraweeControllerBuilder O0000O0o;
    private Animation O0000OOo;
    private Scroller O0000Oo;
    private boolean O0000Oo0;
    private gcs O0000OoO;
    private float O0000Ooo;

    public CommonSweeperView(Context context) {
        this(context, null);
    }

    public CommonSweeperView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CommonSweeperView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.O0000OoO = new gcs();
        this.O0000Ooo = 1.0f;
        this.O00000oo = new Handler() {
            /* class com.xiaomi.smarthome.framework.plugin.rn.viewmanager.mapsweeper.CommonSweeperView.AnonymousClass1 */

            public final void handleMessage(Message message) {
                int i = message.what;
                if (i == 1) {
                    CommonSweeperView.this.O000000o();
                } else if (i != 2) {
                    if (i == 3 && CommonSweeperView.this.O00000Oo != null) {
                        CommonSweeperView.this.O00000Oo.setVisibility(0);
                    }
                } else if (CommonSweeperView.this.O00000o0 != null) {
                    CommonSweeperView.this.O00000o0.setVisibility(0);
                }
            }
        };
        this.f8596O000000o = context;
        this.O0000OOo = AnimationUtils.loadAnimation(context, R.anim.anim_sweeper_circular_scale);
        this.O0000Oo = new Scroller(context);
    }

    public final void O000000o(int i, int i2) {
        gcs gcs = this.O0000OoO;
        gcs.f17542O000000o = i;
        gcs.O00000Oo = i2;
    }

    public gcs getCurrentPosition() {
        return this.O0000OoO;
    }

    /* access modifiers changed from: package-private */
    public final ReactImageView O000000o(ReadableArray readableArray, int i) {
        ReactImageView reactImageView = new ReactImageView(this.f8596O000000o, getDraweeControllerBuilder(), null, this.f8596O000000o);
        reactImageView.setScaleType(ImageResizeMode.toScaleType("stretch"));
        reactImageView.setSource(readableArray);
        reactImageView.setRotation((float) (i + 180));
        reactImageView.setTag(Boolean.FALSE);
        return reactImageView;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    public AbstractDraweeControllerBuilder getDraweeControllerBuilder() {
        if (this.O0000O0o == null) {
            this.O0000O0o = Fresco.newDraweeControllerBuilder();
        }
        return this.O0000O0o;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.O00000oo.sendEmptyMessageDelayed(1, 200);
    }

    public final void O000000o() {
        gbu.O000000o("CommonSweeperView startSweeperCircularAnimatorDelayed...mIsAnimating=" + this.O0000Oo0);
        ReactImageView reactImageView = this.O00000Oo;
        if (reactImageView != null && !this.O0000Oo0) {
            reactImageView.startAnimation(this.O0000OOo);
        }
        this.O0000Oo0 = true;
    }

    public final void O00000Oo() {
        gbu.O000000o("CommonSweeperView stopSweeperCircularAnimator...mIsAnimating=" + this.O0000Oo0);
        ReactImageView reactImageView = this.O00000Oo;
        if (reactImageView != null && this.O0000Oo0) {
            reactImageView.clearAnimation();
        }
        this.O0000Oo0 = false;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        O00000Oo();
        Handler handler = this.O00000oo;
        if (handler != null) {
            handler.removeMessages(1);
            this.O00000oo.removeMessages(2);
            this.O00000oo.removeMessages(3);
        }
        super.onDetachedFromWindow();
    }

    public final void O00000Oo(int i, int i2) {
        int finalX = i - this.O0000Oo.getFinalX();
        int finalY = i2 - this.O0000Oo.getFinalY();
        Scroller scroller = this.O0000Oo;
        scroller.startScroll(scroller.getFinalX(), this.O0000Oo.getFinalY(), finalX, finalY);
        invalidate();
    }

    public void computeScroll() {
        if (this.O0000Oo.computeScrollOffset()) {
            scrollTo(this.O0000Oo.getCurrX(), this.O0000Oo.getCurrY());
            postInvalidate();
        }
        super.computeScroll();
    }

    public void setZoom(float f) {
        float f2 = this.O0000Ooo;
        if (f2 != f) {
            if (f - f2 > 1.5f) {
                ReactImageView reactImageView = this.O00000o0;
                if (reactImageView != null) {
                    reactImageView.setVisibility(4);
                }
                ReactImageView reactImageView2 = this.O00000Oo;
                if (reactImageView2 != null) {
                    reactImageView2.setVisibility(4);
                }
            }
            this.O0000Ooo = f;
            O00000Oo();
            float f3 = this.O0000Ooo;
            float f4 = (((float) this.O00000o) / f3) + (f3 / 10.0f);
            float f5 = (((float) this.O00000oO) / f3) + (f3 / 10.0f);
            ReactImageView reactImageView3 = this.O00000o0;
            int i = 1;
            if (reactImageView3 != null) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) reactImageView3.getLayoutParams();
                layoutParams.width = f4 < 1.0f ? 1 : (int) f4;
                layoutParams.height = f5 < 1.0f ? 1 : (int) f5;
                this.O00000o0.setLayoutParams(layoutParams);
                gbu.O000000o("CommonSweeperView Sweeper  updateSweeperViewByZoom-->params.width=" + layoutParams.width + "  params.height=" + layoutParams.height + "  mZoom=" + this.O0000Ooo + "  mOriginSweeperWidth=" + this.O00000o + "  mOriginSweeperHeight=" + this.O00000oO);
            }
            ReactImageView reactImageView4 = this.O00000Oo;
            if (reactImageView4 != null) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) reactImageView4.getLayoutParams();
                layoutParams2.width = f4 < 1.0f ? 1 : (int) f4;
                if (f5 >= 1.0f) {
                    i = (int) f5;
                }
                layoutParams2.height = i;
                layoutParams2.width = layoutParams2.width < 3 ? layoutParams2.width : layoutParams2.width - 2;
                layoutParams2.height = layoutParams2.height < 3 ? layoutParams2.height : layoutParams2.height - 2;
                this.O00000Oo.setLayoutParams(layoutParams2);
            }
        }
        this.O00000oo.sendEmptyMessageDelayed(2, 500);
        this.O00000oo.sendEmptyMessageDelayed(3, 500);
    }
}
