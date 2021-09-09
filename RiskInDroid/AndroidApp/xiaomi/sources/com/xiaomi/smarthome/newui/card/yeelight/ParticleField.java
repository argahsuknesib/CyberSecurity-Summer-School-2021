package com.xiaomi.smarthome.newui.card.yeelight;

import _m_j.hfi;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import java.util.ArrayList;

public class ParticleField extends View {

    /* renamed from: O000000o  reason: collision with root package name */
    public ArrayList<hfi> f10242O000000o;

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
        int i = 0;
        while (i < this.f10242O000000o.size()) {
            try {
                this.f10242O000000o.get(i).O000000o(canvas);
                i++;
            } catch (Exception unused) {
                return;
            }
        }
    }
}
