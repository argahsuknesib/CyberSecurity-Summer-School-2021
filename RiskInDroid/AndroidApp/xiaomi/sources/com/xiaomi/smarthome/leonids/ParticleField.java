package com.xiaomi.smarthome.leonids;

import _m_j.gkp;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import java.util.ArrayList;

class ParticleField extends View {

    /* renamed from: O000000o  reason: collision with root package name */
    ArrayList<gkp> f9069O000000o;

    public ParticleField(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public ParticleField(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ParticleField(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        synchronized (this.f9069O000000o) {
            for (int i = 0; i < this.f9069O000000o.size(); i++) {
                gkp gkp = this.f9069O000000o.get(i);
                if (gkp != null) {
                    gkp.O000000o(canvas);
                }
            }
        }
    }
}
