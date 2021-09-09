package com.xiaomi.smarthome.library.common.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import com.xiaomi.smarthome.R;

public class IRHintBgView extends View {

    /* renamed from: O000000o  reason: collision with root package name */
    Paint f9198O000000o = new Paint();
    Bitmap O00000Oo = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
    RectF O00000o = new RectF();
    Rect O00000o0 = new Rect();
    Bitmap O00000oO;
    Rect O00000oo = new Rect();
    RectF O0000O0o = new RectF();
    PorterDuffXfermode O0000OOo = new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);

    public IRHintBgView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Canvas canvas = new Canvas(this.O00000Oo);
        this.f9198O000000o.setColor(-536870912);
        canvas.drawPaint(this.f9198O000000o);
    }

    public void setTranspantRect(Rect rect) {
        try {
            this.O00000oO = Bitmap.createBitmap(rect.width(), rect.height(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(this.O00000oO);
            Drawable drawable = getResources().getDrawable(R.drawable.main_grid_card_bg_normal);
            drawable.setBounds(new Rect(0, 0, rect.width(), rect.height()));
            drawable.draw(canvas);
            this.O0000O0o.set(rect);
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.O00000Oo != null && this.O00000oO != null) {
            canvas.drawColor(16777215);
            int saveLayer = canvas.saveLayer(0.0f, 0.0f, (float) getWidth(), (float) getHeight(), this.f9198O000000o, 31);
            this.O00000o0.set(0, 0, this.O00000Oo.getWidth(), this.O00000Oo.getHeight());
            this.O00000o.set(0.0f, 0.0f, (float) getWidth(), (float) getHeight());
            canvas.drawBitmap(this.O00000Oo, this.O00000o0, this.O00000o, this.f9198O000000o);
            this.f9198O000000o.setXfermode(this.O0000OOo);
            this.O00000oo.set(0, 0, this.O00000oO.getWidth(), this.O00000oO.getHeight());
            canvas.drawBitmap(this.O00000oO, this.O00000oo, this.O0000O0o, this.f9198O000000o);
            this.f9198O000000o.setXfermode(null);
            canvas.restoreToCount(saveLayer);
        }
    }
}
