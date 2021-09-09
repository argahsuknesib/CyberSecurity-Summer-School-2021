package com.hannto.print.widget;

import _m_j.O00o00;
import _m_j.ayy;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Region;
import android.util.AttributeSet;
import android.view.View;
import com.xiaomi.smarthome.R;

public class IdCardMaskView extends View {

    /* renamed from: O000000o  reason: collision with root package name */
    public Context f4365O000000o;
    public int O00000Oo;
    public int O00000o;
    public int O00000o0;
    public int O00000oO;
    public Bitmap O00000oo;
    public Bitmap O0000O0o;
    public Rect O0000OOo;
    public int O0000Oo;
    public int O0000Oo0;

    public IdCardMaskView(Context context) {
        this(context, null, 0);
    }

    public IdCardMaskView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        canvas.clipRect(this.O0000OOo, Region.Op.DIFFERENCE);
        canvas.drawColor(getResources().getColor(R.color.ht_black_40_transparent));
        canvas.restore();
        canvas.drawBitmap(this.O0000O0o, (float) this.O0000Oo0, (float) this.O0000Oo, new Paint());
    }

    @SuppressLint({"DrawAllocation"})
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.O00000Oo = getWidth() - (this.O00000oO * 2);
        this.O00000o0 = getHeight() - (this.O00000oO * 2);
        if (this.O00000oo.getHeight() * this.O00000Oo < this.O00000oo.getWidth() * this.O00000o0) {
            this.O00000o0 = (this.O00000oo.getHeight() * this.O00000Oo) / this.O00000oo.getWidth();
        } else {
            this.O00000Oo = (this.O00000oo.getWidth() * this.O00000o0) / this.O00000oo.getHeight();
        }
        this.O0000Oo0 = (getWidth() - this.O00000Oo) / 2;
        this.O0000Oo = (getHeight() - this.O00000o0) / 2;
        this.O0000OOo = new Rect(this.O0000Oo0, this.O0000Oo, getWidth() - this.O0000Oo0, getHeight() - this.O0000Oo);
        this.O0000O0o = ayy.O000000o(this.O00000oo, this.O00000Oo, this.O00000o0);
    }

    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    public IdCardMaskView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.O00000o = 40;
        this.f4365O000000o = context;
        this.O00000oo = BitmapFactory.decodeResource(this.f4365O000000o.getResources(), R.mipmap.ht_idcard_camera);
        this.O00000oO = O00o00.O000000o(this.f4365O000000o, (float) this.O00000o);
    }
}
