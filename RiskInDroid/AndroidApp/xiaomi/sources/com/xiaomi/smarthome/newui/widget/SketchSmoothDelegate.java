package com.xiaomi.smarthome.newui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import com.xiaomi.smarthome.R;

public class SketchSmoothDelegate {

    /* renamed from: O000000o  reason: collision with root package name */
    private final Paint f10334O000000o;
    private Path O00000Oo;
    private float O00000o = 0.0f;
    private float O00000o0 = 0.0f;
    private float O00000oO = 0.0f;
    private float O00000oo = 0.0f;
    private float O0000O0o = 0.0f;
    private int O0000OOo = -1;
    private boolean O0000Oo = true;
    private boolean O0000Oo0 = true;
    private boolean O0000OoO = true;
    private boolean O0000Ooo = true;

    public SketchSmoothDelegate(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.bl, R.attr.br, R.attr.gradient_angle, R.attr.gradient_end_color, R.attr.gradient_start_color, R.attr.max_radius, R.attr.prefer_sketch_style_radius, R.attr.radius_bg, R.attr.tl, R.attr.tr});
            this.O00000oO = obtainStyledAttributes.getDimension(5, 0.0f);
            this.O0000Oo0 = obtainStyledAttributes.getBoolean(8, true);
            this.O0000Oo = obtainStyledAttributes.getBoolean(9, true);
            this.O0000OoO = obtainStyledAttributes.getBoolean(0, true);
            this.O0000Ooo = obtainStyledAttributes.getBoolean(1, true);
            this.O0000OOo = obtainStyledAttributes.getColor(7, -1);
            obtainStyledAttributes.recycle();
        }
        this.f10334O000000o = new Paint();
        this.f10334O000000o.setAntiAlias(true);
        this.f10334O000000o.setColor(this.O0000OOo);
        this.O00000Oo = new Path();
    }
}
