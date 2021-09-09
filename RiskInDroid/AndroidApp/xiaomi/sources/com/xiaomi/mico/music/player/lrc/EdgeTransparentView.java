package com.xiaomi.mico.music.player.lrc;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.xiaomi.mico.common.util.DisplayUtils;
import com.xiaomi.smarthome.R;

public class EdgeTransparentView extends FrameLayout {
    private float drawSize;
    private int[] mGradientColors;
    private float[] mGradientPosition;
    private int mHeight;
    private Paint mPaint;
    private int mWidth;

    public EdgeTransparentView(Context context) {
        this(context, null);
    }

    public EdgeTransparentView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public EdgeTransparentView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mGradientColors = new int[]{getResources().getColor(R.color.mj_color_white_100_transparent), getResources().getColor(R.color.mj_color_white_100_transparent), getResources().getColor(R.color.mj_color_white_00_transparent)};
        this.mGradientPosition = new float[]{0.0f, 0.42f, 1.0f};
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        this.mPaint = new Paint(1);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.drawSize = (float) DisplayUtils.dip2px(getContext(), 150.0f);
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        initShader();
        this.mWidth = getWidth();
        this.mHeight = getHeight();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.graphics.LinearGradient.<init>(float, float, float, float, int[], float[], android.graphics.Shader$TileMode):void}
     arg types: [int, int, int, float, int[], float[], android.graphics.Shader$TileMode]
     candidates:
      ClspMth{android.graphics.LinearGradient.<init>(float, float, float, float, long, long, android.graphics.Shader$TileMode):void}
      ClspMth{android.graphics.LinearGradient.<init>(float, float, float, float, long[], float[], android.graphics.Shader$TileMode):void}
      ClspMth{android.graphics.LinearGradient.<init>(float, float, float, float, int, int, android.graphics.Shader$TileMode):void}
      ClspMth{android.graphics.LinearGradient.<init>(float, float, float, float, int[], float[], android.graphics.Shader$TileMode):void} */
    private void initShader() {
        this.mPaint.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, this.drawSize, this.mGradientColors, this.mGradientPosition, Shader.TileMode.CLAMP));
    }

    /* access modifiers changed from: protected */
    public boolean drawChild(Canvas canvas, View view, long j) {
        Canvas canvas2 = canvas;
        int saveLayer = canvas2.saveLayer(0.0f, 0.0f, (float) getWidth(), (float) getHeight(), null, 31);
        boolean drawChild = super.drawChild(canvas, view, j);
        canvas2.drawRect(0.0f, 0.0f, (float) this.mWidth, this.drawSize, this.mPaint);
        int save = canvas.save();
        canvas.rotate(180.0f, (float) (this.mWidth / 2), (float) (this.mHeight / 2));
        canvas.drawRect(0.0f, 0.0f, (float) this.mWidth, this.drawSize, this.mPaint);
        canvas.restoreToCount(save);
        canvas.restoreToCount(saveLayer);
        return drawChild;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }
}
