package com.scwang.smartrefresh.layout.footer;

import _m_j.czt;
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

public class FalsifyFooter extends dae implements czt {

    /* renamed from: O000000o  reason: collision with root package name */
    private czw f5578O000000o;

    public final boolean O000000o(boolean z) {
        return false;
    }

    public FalsifyFooter(Context context) {
        this(context, null);
    }

    public FalsifyFooter(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FalsifyFooter(Context context, AttributeSet attributeSet, int i) {
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

    public final void O000000o(czw czw, int i, int i2) {
        this.f5578O000000o = czw;
        czw.O000000o().O0000Oo();
    }

    public final void O000000o(czx czx, int i, int i2) {
        czw czw = this.f5578O000000o;
        if (czw != null) {
            czw.O000000o(RefreshState.None);
            this.f5578O000000o.O000000o(RefreshState.LoadFinish);
        }
    }
}
