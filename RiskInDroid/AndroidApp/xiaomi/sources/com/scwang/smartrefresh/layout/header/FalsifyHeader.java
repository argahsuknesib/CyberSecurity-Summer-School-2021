package com.scwang.smartrefresh.layout.header;

import _m_j.czu;
import _m_j.czw;
import _m_j.czx;
import _m_j.dae;
import _m_j.dao;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.xiaomi.smarthome.R;

public class FalsifyHeader extends dae implements czu {
    protected czw O0000Oo0;

    public FalsifyHeader(Context context) {
        this(context, null);
    }

    public FalsifyHeader(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FalsifyHeader(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (isInEditMode()) {
            int O000000o2 = dao.O000000o(5.0f);
            Paint paint = new Paint();
            paint.setStyle(Paint.Style.STROKE);
            paint.setColor(-858993460);
            paint.setStrokeWidth((float) dao.O000000o(1.0f));
            float f = (float) O000000o2;
            paint.setPathEffect(new DashPathEffect(new float[]{f, f, f, f}, 1.0f));
            canvas.drawRect(f, f, (float) (getWidth() - O000000o2), (float) (getBottom() - O000000o2), paint);
            TextView textView = new TextView(getContext());
            textView.setText(getResources().getString(R.string.srl_component_falsify, getClass().getSimpleName(), Float.valueOf(dao.O000000o(getHeight()))));
            textView.setTextColor(-858993460);
            textView.setGravity(17);
            textView.measure(View.MeasureSpec.makeMeasureSpec(getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getHeight(), 1073741824));
            textView.layout(0, 0, getWidth(), getHeight());
            textView.draw(canvas);
        }
    }

    public void O000000o(czw czw, int i, int i2) {
        this.O0000Oo0 = czw;
    }

    public void O000000o(czx czx, int i, int i2) {
        czw czw = this.O0000Oo0;
        if (czw != null) {
            czw.O000000o(RefreshState.None);
            this.O0000Oo0.O000000o(RefreshState.RefreshFinish);
        }
    }
}
