package com.xiaomi.smarthome.infrared.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

public class SideBar extends View {

    /* renamed from: O000000o  reason: collision with root package name */
    public static String[] f9045O000000o = {"A", "B", "C", "F", "G", "H", "J", "L", "N", "Q", "S", "T", "X", "Y", "Z"};
    private O000000o O00000Oo;
    private Paint O00000o = new Paint();
    private int O00000o0 = -1;
    private TextView O00000oO;

    public interface O000000o {
        void O000000o(String str);
    }

    public void setTextView(TextView textView) {
        this.O00000oO = textView;
    }

    public SideBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public SideBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SideBar(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int height = getHeight();
        int width = getWidth();
        int length = height / f9045O000000o.length;
        for (int i = 0; i < f9045O000000o.length; i++) {
            this.O00000o.setTypeface(Typeface.DEFAULT_BOLD);
            this.O00000o.setAntiAlias(true);
            this.O00000o.setTextSize(26.0f);
            this.O00000o.setColor(-7500403);
            canvas.drawText(f9045O000000o[i], ((float) (width / 2)) - (this.O00000o.measureText(f9045O000000o[i]) / 2.0f), ((float) ((length * i) + (length / 2))) + 10.0f, this.O00000o);
            this.O00000o.reset();
        }
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        float y = motionEvent.getY();
        int i = this.O00000o0;
        O000000o o000000o = this.O00000Oo;
        float height = y / ((float) getHeight());
        String[] strArr = f9045O000000o;
        int length = (int) (height * ((float) strArr.length));
        if (action == 1) {
            setBackgroundDrawable(new ColorDrawable(0));
            this.O00000o0 = -1;
            invalidate();
            TextView textView = this.O00000oO;
            if (textView != null) {
                textView.setVisibility(4);
            }
        } else if (i != length && length >= 0 && length < strArr.length) {
            if (o000000o != null) {
                o000000o.O000000o(strArr[length]);
            }
            TextView textView2 = this.O00000oO;
            if (textView2 != null) {
                textView2.setText(f9045O000000o[length]);
                this.O00000oO.setVisibility(0);
            }
            this.O00000o0 = length;
            invalidate();
        }
        return true;
    }

    public void setOnTouchingLetterChangedListener(O000000o o000000o) {
        this.O00000Oo = o000000o;
    }
}
