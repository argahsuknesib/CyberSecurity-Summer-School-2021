package com.xiaomi.smarthome.library.common.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.xiaomi.smarthome.R;
import java.util.ArrayList;
import java.util.List;

public class SceneImageView extends View {

    /* renamed from: O000000o  reason: collision with root package name */
    private List<Bitmap> f9247O000000o = new ArrayList();
    private List<Bitmap> O00000Oo = new ArrayList();
    private float O00000o;
    private Paint O00000o0 = new Paint(5);
    private float O00000oO;
    private Paint O00000oo;

    public SceneImageView(Context context) {
        super(context);
        O000000o();
    }

    public SceneImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        O000000o();
    }

    public SceneImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        O000000o();
    }

    private void O000000o() {
        this.O00000o = getResources().getDimension(R.dimen.scene_small_margin);
        this.O00000oO = getResources().getDimension(R.dimen.scene_line);
        this.O00000oo = new Paint();
        this.O00000oo.setARGB(255, 229, 229, 229);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        for (Bitmap next : this.f9247O000000o) {
            canvas.drawBitmap(next, new Rect(0, 0, next.getWidth(), next.getHeight()), new RectF(0.0f, 0.0f, (float) getHeight(), (float) getHeight()), this.O00000o0);
            canvas.translate(((float) getHeight()) + this.O00000o, 0.0f);
        }
        canvas.drawRect(new Rect(0, (int) ((((float) getHeight()) - this.O00000oO) / 2.0f), 1, (int) ((((float) getHeight()) + this.O00000oO) / 2.0f)), this.O00000oo);
        canvas.translate(this.O00000o, 0.0f);
        for (Bitmap next2 : this.O00000Oo) {
            canvas.drawBitmap(next2, new Rect(0, 0, next2.getWidth(), next2.getHeight()), new RectF(0.0f, 0.0f, (float) getHeight(), (float) getHeight()), this.O00000o0);
            canvas.translate(((float) getHeight()) + this.O00000o, 0.0f);
        }
        canvas.restore();
    }
}
