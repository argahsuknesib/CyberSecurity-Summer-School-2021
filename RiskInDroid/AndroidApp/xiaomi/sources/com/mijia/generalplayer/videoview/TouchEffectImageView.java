package com.mijia.generalplayer.videoview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;

public class TouchEffectImageView extends ImageView {
    public TouchEffectImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        Drawable drawable;
        int action = motionEvent.getAction();
        if (action == 0) {
            Drawable drawable2 = getDrawable();
            if (drawable2 != null) {
                drawable2.mutate().setAlpha(102);
            }
        } else if ((action == 1 || (action != 2 && action == 3)) && (drawable = getDrawable()) != null) {
            drawable.mutate().setAlpha(255);
        }
        return super.onTouchEvent(motionEvent);
    }
}
