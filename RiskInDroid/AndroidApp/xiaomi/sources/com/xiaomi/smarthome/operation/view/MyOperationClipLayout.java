package com.xiaomi.smarthome.operation.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.util.AttributeSet;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.xiaomi.smarthome.R;

public class MyOperationClipLayout extends ConstraintLayout {

    /* renamed from: O000000o  reason: collision with root package name */
    private Paint f10537O000000o;
    private Bitmap O00000Oo;
    private Rect O00000o;
    private PorterDuffXfermode O00000o0;
    private Rect O00000oO;
    private boolean O00000oo;
    private boolean O0000O0o;
    private Bitmap O0000OOo;

    public MyOperationClipLayout(Context context) {
        this(context, null);
    }

    public MyOperationClipLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MyOperationClipLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.O00000oo = true;
        this.O0000O0o = false;
        setLayerType(2, null);
        this.f10537O000000o = new Paint();
        this.f10537O000000o.setAntiAlias(true);
        this.O00000o0 = new PorterDuffXfermode(PorterDuff.Mode.DST_ATOP);
    }

    public void setClipBannerOnly(boolean z) {
        if (this.O0000O0o != z) {
            this.O0000O0o = z;
            invalidate();
        }
    }

    private Bitmap getClipBg() {
        if (this.O0000O0o) {
            if (this.O0000OOo == null) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inScaled = true;
                options.inPreferredConfig = Bitmap.Config.ALPHA_8;
                this.O0000OOo = BitmapFactory.decodeResource(getResources(), R.drawable.my_operation_duffmode_banner, options);
                this.O00000o = new Rect(0, 0, this.O0000OOo.getWidth(), this.O0000OOo.getHeight());
            }
            return this.O0000OOo;
        }
        if (this.O00000Oo == null) {
            BitmapFactory.Options options2 = new BitmapFactory.Options();
            options2.inScaled = true;
            options2.inPreferredConfig = Bitmap.Config.ALPHA_8;
            this.O00000Oo = BitmapFactory.decodeResource(getResources(), R.drawable.my_operation_duffmode_top, options2);
            this.O00000o = new Rect(0, 0, this.O00000Oo.getWidth(), this.O00000Oo.getHeight());
        }
        return this.O00000Oo;
    }

    public void dispatchDraw(Canvas canvas) {
        if (this.O00000oo) {
            canvas.save();
            super.dispatchDraw(canvas);
            this.f10537O000000o.setXfermode(this.O00000o0);
            canvas.drawBitmap(getClipBg(), this.O00000o, this.O00000oO, this.f10537O000000o);
            this.f10537O000000o.setXfermode(null);
            canvas.restore();
            return;
        }
        super.dispatchDraw(canvas);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.O00000oO = new Rect(0, 0, i, i2);
    }

    public void setClipBounds(boolean z) {
        if (z != this.O00000oo) {
            this.O00000oo = z;
            invalidate();
        }
    }
}
