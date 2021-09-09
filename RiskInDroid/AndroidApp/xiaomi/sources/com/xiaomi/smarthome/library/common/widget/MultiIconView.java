package com.xiaomi.smarthome.library.common.widget;

import _m_j.gfr;
import _m_j.gri;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.view.DraweeHolder;
import com.facebook.drawee.view.MultiDraweeHolder;
import com.xiaomi.smarthome.R;

public class MultiIconView extends ImageView {
    private MultiDraweeHolder<GenericDraweeHierarchy> mMultiDraweeHolder;

    public MultiIconView(Context context) {
        super(context);
        init();
    }

    public MultiIconView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public MultiIconView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        this.mMultiDraweeHolder = new MultiDraweeHolder<>();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mMultiDraweeHolder.onDetach();
    }

    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        this.mMultiDraweeHolder.onDetach();
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mMultiDraweeHolder.onAttach();
    }

    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        this.mMultiDraweeHolder.onAttach();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.mMultiDraweeHolder.onTouchEvent(motionEvent) || super.onTouchEvent(motionEvent);
    }

    public void addUrl(String str) {
        DraweeHolder create = DraweeHolder.create(new GenericDraweeHierarchyBuilder(getResources()).setFadeDuration(200).setPlaceholderImage(getResources().getDrawable(R.drawable.device_list_phone_no)).setActualImageScaleType(ScalingUtils.ScaleType.CENTER_INSIDE).setPlaceholderImageScaleType(ScalingUtils.ScaleType.CENTER_INSIDE).build(), getContext());
        create.setController(Fresco.newDraweeControllerBuilder().setUri(Uri.parse(str)).build());
        this.mMultiDraweeHolder.add(create);
        create.getTopLevelDrawable().setCallback(this);
    }

    public void addResource(int i) {
        DraweeHolder create = DraweeHolder.create(new GenericDraweeHierarchyBuilder(getResources()).setFadeDuration(200).setPlaceholderImage(getResources().getDrawable(R.drawable.device_list_phone_no)).setActualImageScaleType(ScalingUtils.ScaleType.CENTER_INSIDE).setPlaceholderImageScaleType(ScalingUtils.ScaleType.CENTER_INSIDE).build(), getContext());
        PipelineDraweeControllerBuilder newDraweeControllerBuilder = Fresco.newDraweeControllerBuilder();
        create.setController(newDraweeControllerBuilder.setUri(Uri.parse("res://" + gfr.O0000O0o + "/" + i)).build());
        create.getTopLevelDrawable().setCallback(this);
        this.mMultiDraweeHolder.add(create);
    }

    /* access modifiers changed from: protected */
    public boolean verifyDrawable(Drawable drawable) {
        for (int i = 0; i < this.mMultiDraweeHolder.size(); i++) {
            if (drawable == this.mMultiDraweeHolder.get(i).getHierarchy().getTopLevelDrawable()) {
                return true;
            }
        }
        return super.verifyDrawable(drawable);
    }

    public void clear() {
        for (int i = 0; i < this.mMultiDraweeHolder.size(); i++) {
            this.mMultiDraweeHolder.get(i).onDetach();
            this.mMultiDraweeHolder.get(i).getTopLevelDrawable().setCallback(null);
        }
        this.mMultiDraweeHolder.clear();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        int i;
        super.onDraw(canvas);
        if (this.mMultiDraweeHolder.size() != 0) {
            int O000000o2 = (gri.O000000o(47.0f) - 15) / 2;
            int O000000o3 = (gri.O000000o(47.0f) - 15) / 2;
            int O000000o4 = (gri.O000000o(47.0f) - O000000o3) / 2;
            int i2 = 4;
            if (this.mMultiDraweeHolder.size() <= 4) {
                i2 = this.mMultiDraweeHolder.size();
            }
            Paint paint = new Paint();
            paint.setARGB(0, 255, 255, 255);
            canvas.drawRect(new Rect(0, 0, gri.O000000o(47.0f), gri.O000000o(47.0f)), paint);
            for (int i3 = 0; i3 < i2; i3++) {
                Drawable topLevelDrawable = this.mMultiDraweeHolder.get(i3).getTopLevelDrawable();
                if (i2 == 1) {
                    topLevelDrawable.setBounds(new Rect(0, 0, gri.O000000o(47.0f), gri.O000000o(47.0f)));
                    topLevelDrawable.draw(canvas);
                } else if (i2 == 3 && i3 == 2) {
                    topLevelDrawable.setBounds(new Rect(O000000o4, O000000o3 + 10, O000000o4 + O000000o2, (O000000o3 + 5) * 2));
                    topLevelDrawable.draw(canvas);
                } else {
                    if (i2 > 2) {
                        i = 5;
                    } else {
                        i = (gri.O000000o(47.0f) - O000000o3) / 2;
                    }
                    int i4 = ((O000000o2 + 5) * (i3 % 2)) + 5;
                    int i5 = ((i + O000000o3) * (i3 / 2)) + i;
                    topLevelDrawable.setBounds(new Rect(i4, i5, i4 + O000000o2, i5 + O000000o3));
                    topLevelDrawable.draw(canvas);
                }
            }
        }
    }
}
