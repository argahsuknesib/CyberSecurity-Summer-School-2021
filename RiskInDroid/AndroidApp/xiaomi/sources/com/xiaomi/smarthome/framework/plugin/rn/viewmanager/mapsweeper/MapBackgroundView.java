package com.xiaomi.smarthome.framework.plugin.rn.viewmanager.mapsweeper;

import _m_j.gcs;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapBackgroundView extends View {

    /* renamed from: O000000o  reason: collision with root package name */
    List<gcs> f8598O000000o;
    HashMap<String, gcs> O00000Oo;
    private Context O00000o;
    HashMap<String, gcs> O00000o0;
    private Paint O00000oO;
    private int O00000oo;
    private Paint O0000O0o;
    private int O0000OOo;
    private float O0000Oo0;

    public MapBackgroundView(Context context) {
        this(context, null);
    }

    public MapBackgroundView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MapBackgroundView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.O00000oo = Color.parseColor("#468ad6");
        this.O0000OOo = Color.parseColor("#333333");
        this.O0000Oo0 = 4.0f;
        this.O00000Oo = new HashMap<>();
        this.O00000o0 = new HashMap<>();
        this.O00000o = context;
        this.f8598O000000o = new ArrayList();
        this.O00000oO = new Paint();
        this.O00000oO.setColor(this.O00000oo);
        this.O00000oO.setStrokeWidth(this.O0000Oo0);
        this.O00000oO.setStyle(Paint.Style.STROKE);
        this.O0000O0o = new Paint();
        this.O0000O0o.setColor(this.O0000OOo);
        this.O0000O0o.setStrokeWidth(this.O0000Oo0);
        this.O0000O0o.setStrokeCap(Paint.Cap.SQUARE);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        float size = ((float) View.MeasureSpec.getSize(i)) / 256.0f;
        if (size > 4.0f) {
            this.O0000Oo0 = size;
        }
        this.O0000O0o.setStrokeWidth(this.O0000Oo0);
        this.O00000oO.setStrokeWidth(this.O0000Oo0 + 1.0f);
        super.onMeasure(i, i2);
    }

    public void setSquareColor(int i) {
        this.O0000OOo = i;
        Paint paint = this.O0000O0o;
        if (paint != null) {
            paint.setColor(this.O0000OOo);
        }
    }

    public void setFloorColor(int i) {
        this.O00000oo = i;
        this.O00000oO.setColor(this.O00000oo);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        HashMap<String, gcs> hashMap = this.O00000Oo;
        int i = 0;
        if (!(hashMap == null || hashMap.size() == 0)) {
            int size = this.O00000Oo.size() * 2;
            float[] fArr = new float[size];
            int i2 = 0;
            for (Map.Entry next : this.O00000Oo.entrySet()) {
                fArr[i2] = (float) ((gcs) next.getValue()).f17542O000000o;
                fArr[i2 + 1] = (float) ((gcs) next.getValue()).O00000Oo;
                i2 += 2;
                if (i2 >= size) {
                    break;
                }
            }
            canvas.drawPoints(fArr, this.O0000O0o);
        }
        HashMap<String, gcs> hashMap2 = this.O00000o0;
        if (hashMap2 != null && hashMap2.size() != 0) {
            int size2 = this.O00000o0.size() * 2;
            float[] fArr2 = new float[size2];
            for (Map.Entry next2 : this.O00000o0.entrySet()) {
                fArr2[i] = (float) ((gcs) next2.getValue()).f17542O000000o;
                fArr2[i + 1] = (float) ((gcs) next2.getValue()).O00000Oo;
                i += 2;
                if (i >= size2) {
                    break;
                }
            }
            canvas.drawPoints(fArr2, this.O00000oO);
        }
    }
}
