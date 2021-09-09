package com.xiaomi.smarthome.library.common.widget.slidinglayer;

import _m_j.gri;
import _m_j.grn;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.xiaomi.smarthome.R;

public class SceneRecommendSlidingLayer extends RelativeLayout {

    /* renamed from: O000000o  reason: collision with root package name */
    public SlidingLayer f9328O000000o;

    public SceneRecommendSlidingLayer(Context context) {
        super(context);
        O000000o();
    }

    public SceneRecommendSlidingLayer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        O000000o();
    }

    public SceneRecommendSlidingLayer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        O000000o();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, com.xiaomi.smarthome.library.common.widget.slidinglayer.SceneRecommendSlidingLayer, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.library.common.widget.slidinglayer.SlidingLayer.O000000o(int, boolean, boolean):void
     arg types: [int, int, int]
     candidates:
      com.xiaomi.smarthome.library.common.widget.slidinglayer.SlidingLayer.O000000o(int, int, int):void
      com.xiaomi.smarthome.library.common.widget.slidinglayer.SlidingLayer.O000000o(float, float, boolean):boolean
      com.xiaomi.smarthome.library.common.widget.slidinglayer.SlidingLayer.O000000o(int, boolean, boolean):void */
    private void O000000o() {
        View inflate = LayoutInflater.from(getContext().getApplicationContext()).inflate((int) R.layout.sm_widget_scene_recommend_sliding_layer_layout, (ViewGroup) this, false);
        addView(inflate);
        this.f9328O000000o = (SlidingLayer) inflate.findViewById(R.id.sliding_layer);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f9328O000000o.getLayoutParams();
        layoutParams.addRule(15);
        this.f9328O000000o.setLayoutParams(layoutParams);
        this.f9328O000000o.setStickTo(-1);
        this.f9328O000000o.setLayerTransformer(new grn());
        this.f9328O000000o.setOffsetDistance(gri.O000000o(50.0f));
        this.f9328O000000o.O000000o(0, false, false);
        this.f9328O000000o.setChangeStateOnTap(false);
        this.f9328O000000o.findViewById(R.id.tv1).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.library.common.widget.slidinglayer.SceneRecommendSlidingLayer.AnonymousClass1 */

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: com.xiaomi.smarthome.library.common.widget.slidinglayer.SlidingLayer.O000000o(int, boolean, boolean):void
             arg types: [int, int, int]
             candidates:
              com.xiaomi.smarthome.library.common.widget.slidinglayer.SlidingLayer.O000000o(int, int, int):void
              com.xiaomi.smarthome.library.common.widget.slidinglayer.SlidingLayer.O000000o(float, float, boolean):boolean
              com.xiaomi.smarthome.library.common.widget.slidinglayer.SlidingLayer.O000000o(int, boolean, boolean):void */
            public final void onClick(View view) {
                if (SceneRecommendSlidingLayer.this.f9328O000000o.O000000o()) {
                    SceneRecommendSlidingLayer.this.f9328O000000o.O000000o(0, true, false);
                    SceneRecommendSlidingLayer.this.setClickable(false);
                    return;
                }
                SceneRecommendSlidingLayer.this.f9328O000000o.O000000o(2, true, false);
                SceneRecommendSlidingLayer.this.setClickable(true);
            }
        });
        setClickable(false);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.library.common.widget.slidinglayer.SlidingLayer.O000000o(int, boolean, boolean):void
     arg types: [int, int, int]
     candidates:
      com.xiaomi.smarthome.library.common.widget.slidinglayer.SlidingLayer.O000000o(int, int, int):void
      com.xiaomi.smarthome.library.common.widget.slidinglayer.SlidingLayer.O000000o(float, float, boolean):boolean
      com.xiaomi.smarthome.library.common.widget.slidinglayer.SlidingLayer.O000000o(int, boolean, boolean):void */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if ((motionEvent.getAction() & 255) == 1 && this.f9328O000000o.O000000o()) {
            this.f9328O000000o.O000000o(0, true, false);
            setClickable(false);
        }
        return this.f9328O000000o.O000000o();
    }
}
