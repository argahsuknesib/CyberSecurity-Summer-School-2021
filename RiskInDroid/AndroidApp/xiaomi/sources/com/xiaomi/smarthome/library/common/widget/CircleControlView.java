package com.xiaomi.smarthome.library.common.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import com.xiaomi.smarthome.R;

public class CircleControlView extends RelativeLayout {

    /* renamed from: O000000o  reason: collision with root package name */
    private View f9148O000000o;
    private View O00000Oo;
    private View O00000o;
    private View O00000o0;
    private View O00000oO;
    private int O00000oo;
    private int O0000O0o;
    private int O0000OOo;
    private int O0000Oo;
    private int O0000Oo0;
    private int O0000OoO;

    private static boolean O000000o(int i, int i2, int i3) {
        return (i * i) + (i2 * i2) <= i3 * i3;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public CircleControlView(Context context) {
        super(context);
        setContentView(context);
    }

    public CircleControlView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setContentView(context);
    }

    public CircleControlView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setContentView(context);
    }

    private void setContentView(Context context) {
        LayoutInflater.from(context).inflate((int) R.layout.sm_widget_miio_widget_circle_control, this);
        this.f9148O000000o = findViewById(R.id.up_btn);
        this.f9148O000000o.setSelected(false);
        this.O00000Oo = findViewById(R.id.down_btn);
        this.O00000Oo.setSelected(false);
        this.O00000o0 = findViewById(R.id.left_btn);
        this.O00000o0.setSelected(false);
        this.O00000o = findViewById(R.id.right_btn);
        this.O00000o.setSelected(false);
        this.O00000oO = findViewById(R.id.ok_btn);
        this.O00000oO.setSelected(false);
    }

    public View getUpBtn() {
        return this.f9148O000000o;
    }

    public View getDownBtn() {
        return this.O00000Oo;
    }

    public View getLeftBtn() {
        return this.O00000o0;
    }

    public View getRightBtn() {
        return this.O00000o;
    }

    public View getOkBtn() {
        return this.O00000oO;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.O0000O0o = this.O00000oO.getMeasuredWidth() / 2;
        int action = motionEvent.getAction();
        if (action == 0) {
            this.O0000OOo = (int) motionEvent.getX();
            this.O0000Oo0 = (int) motionEvent.getY();
            this.O00000oo = getMeasuredWidth() / 2;
            int i = this.O0000OOo;
            int i2 = this.O00000oo;
            int i3 = i - i2;
            int i4 = i2 - this.O0000Oo0;
            if (O000000o(i3, i4, i2)) {
                int i5 = (i3 * i3) + (i4 * i4);
                int i6 = this.O0000O0o;
                if (i5 <= i6 * i6) {
                    this.O00000oO.setPressed(true);
                } else if (i3 < i4 && (-i3) < i4) {
                    this.f9148O000000o.setPressed(true);
                } else if (i3 < i4 && (-i3) > i4) {
                    this.O00000o0.setPressed(true);
                } else if (i3 > i4 && (-i3) < i4) {
                    this.O00000o.setPressed(true);
                } else if (i3 > i4 && (-i3) > i4) {
                    this.O00000Oo.setPressed(true);
                }
            }
        } else if (action == 1) {
            this.O0000Oo = (int) motionEvent.getX();
            this.O0000OoO = (int) motionEvent.getY();
            int i7 = this.O0000Oo;
            int i8 = this.O00000oo;
            int i9 = i7 - i8;
            int i10 = this.O0000OoO;
            int i11 = i8 - i10;
            int i12 = this.O0000OOo;
            int i13 = this.O0000Oo0;
            int i14 = (int) ((getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
            int i15 = i7 - i12;
            int i16 = i10 - i13;
            if (((i15 * i15) + (i16 * i16) <= i14 * i14) && O000000o(i9, i11, this.O00000oo)) {
                int i17 = (i9 * i9) + (i11 * i11);
                int i18 = this.O0000O0o;
                if (i17 <= i18 * i18) {
                    this.O00000oO.performClick();
                } else if (i9 < i11 && (-i9) < i11) {
                    this.f9148O000000o.performClick();
                } else if (i9 < i11 && (-i9) > i11) {
                    this.O00000o0.performClick();
                } else if (i9 > i11 && (-i9) < i11) {
                    this.O00000o.performClick();
                } else if (i9 > i11 && (-i9) > i11) {
                    this.O00000Oo.performClick();
                }
            }
            this.O00000oO.setPressed(false);
            this.f9148O000000o.setPressed(false);
            this.O00000o0.setPressed(false);
            this.O00000o.setPressed(false);
            this.O00000Oo.setPressed(false);
        }
        return true;
    }
}
