package com.xiaomi.smarthome.camera.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.TextView;
import com.xiaomi.smarthome.R;

public class RectTextView extends TextView {
    public RectTextView(Context context) {
        super(context);
    }

    public RectTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public RectTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        RectF rectF = new RectF();
        Paint paint = new Paint();
        paint.setColor(-1);
        paint.setAntiAlias(true);
        paint.setStrokeWidth(getResources().getDimension(R.dimen.general_player_speed_stroke_width));
        paint.setStyle(Paint.Style.STROKE);
        rectF.left = (float) getPaddingLeft();
        rectF.right = (float) (getMeasuredWidth() - getPaddingRight());
        rectF.top = (float) getPaddingTop();
        rectF.bottom = (float) (getMeasuredHeight() - getPaddingBottom());
        float dimension = (float) ((int) getResources().getDimension(R.dimen.general_player_speed_stroke_round));
        canvas.drawRoundRect(rectF, dimension, dimension, paint);
    }
}
