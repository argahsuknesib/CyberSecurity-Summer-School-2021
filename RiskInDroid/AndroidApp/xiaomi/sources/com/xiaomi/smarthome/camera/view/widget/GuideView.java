package com.xiaomi.smarthome.camera.view.widget;

import _m_j.gsy;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.RelativeLayout;
import com.xiaomi.smarthome.R;

public class GuideView extends RelativeLayout implements ViewTreeObserver.OnGlobalLayoutListener {
    private final String TAG = getClass().getSimpleName();
    private Bitmap bitmap;
    private int[] center;
    private ViewGroup containerView;
    private View customGuideView;
    private boolean first = true;
    private boolean isMeasured;
    private Context mContent;
    private Canvas temp;

    private void init() {
    }

    public void restoreState() {
        gsy.O000000o(2, this.TAG, "restoreState");
        this.isMeasured = false;
        this.center = null;
        this.bitmap = null;
        this.temp = null;
    }

    public GuideView(Context context) {
        super(context);
        this.mContent = context;
        init();
    }

    public void setCustomGuideView(View view) {
        this.customGuideView = view;
        if (!this.first) {
            restoreState();
        }
    }

    public void setContainerView(ViewGroup viewGroup) {
        this.containerView = viewGroup;
    }

    public int[] getCenter() {
        return this.center;
    }

    public void setCenter(int[] iArr) {
        this.center = iArr;
    }

    public void hide() {
        gsy.O000000o(2, this.TAG, "hide");
        if (this.customGuideView != null) {
            if (Build.VERSION.SDK_INT >= 16) {
                this.containerView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            } else {
                this.containerView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            }
            removeAllViews();
            ((ViewGroup) getParent()).removeView(this);
            restoreState();
        }
    }

    public void show() {
        gsy.O000000o(2, this.TAG, "show");
        ViewGroup viewGroup = this.containerView;
        if (viewGroup != null) {
            viewGroup.getViewTreeObserver().addOnGlobalLayoutListener(this);
        }
        setBackgroundResource(R.color.mj_color_black_00_transparent);
        this.containerView.addView(this);
        this.first = false;
    }

    private void createGuideView() {
        gsy.O000000o(2, this.TAG, "createGuideView");
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        addView(this.customGuideView, layoutParams);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        gsy.O000000o(2, this.TAG, "onDraw");
        if (this.isMeasured && this.containerView != null) {
            drawBackground(canvas);
        }
    }

    private void drawBackground(Canvas canvas) {
        gsy.O000000o(2, this.TAG, "drawBackground");
        this.bitmap = Bitmap.createBitmap(canvas.getWidth(), canvas.getHeight(), Bitmap.Config.ARGB_8888);
        this.temp = new Canvas(this.bitmap);
        Paint paint = new Paint();
        paint.setColor(getResources().getColor(R.color.mj_color_overlayer_black));
        Canvas canvas2 = this.temp;
        canvas2.drawRect(0.0f, 0.0f, (float) canvas2.getWidth(), (float) this.temp.getHeight(), paint);
        canvas.drawBitmap(this.bitmap, 0.0f, 0.0f, paint);
        this.bitmap.recycle();
    }

    public void setClickInfo() {
        setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.view.widget.GuideView.AnonymousClass1 */

            public void onClick(View view) {
                GuideView.this.hide();
            }
        });
    }

    public void onGlobalLayout() {
        if (!this.isMeasured) {
            if (this.containerView.getHeight() > 0 && this.containerView.getWidth() > 0) {
                this.isMeasured = true;
            }
            createGuideView();
        }
    }

    public static class Builder {
        static GuideView guiderView;
        static Builder instance = new Builder();
        Context mContext;

        private Builder() {
        }

        public Builder(Context context) {
            this.mContext = context;
        }

        public static Builder newInstance(Context context) {
            guiderView = new GuideView(context);
            return instance;
        }

        public Builder setContainerView(ViewGroup viewGroup) {
            guiderView.setContainerView(viewGroup);
            return instance;
        }

        public Builder setCustomGuideView(View view) {
            guiderView.setCustomGuideView(view);
            return instance;
        }

        public GuideView build() {
            guiderView.setClickInfo();
            return guiderView;
        }
    }
}
