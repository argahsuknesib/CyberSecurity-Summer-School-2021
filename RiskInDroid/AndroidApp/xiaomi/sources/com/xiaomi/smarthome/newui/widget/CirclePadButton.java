package com.xiaomi.smarthome.newui.widget;

import _m_j.gpc;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.xiaomi.smarthome.R;

public class CirclePadButton extends View {
    private static Bitmap O00000o;
    private static Bitmap O00000o0;
    private static Bitmap O00000oO;
    private static Bitmap O00000oo;
    private static Bitmap O0000O0o;
    private static Bitmap O0000OOo;

    /* renamed from: O000000o  reason: collision with root package name */
    private MODE f10275O000000o;
    private O000000o O00000Oo;
    private Paint O0000Oo;
    private Paint O0000Oo0;
    private float O0000OoO;
    private long O0000Ooo;
    private boolean O0000o00;

    public enum MODE {
        Normal,
        Switch,
        Plus,
        Minus
    }

    public interface O000000o {
        void O000000o(MODE mode);
    }

    public void setListener(O000000o o000000o) {
        this.O00000Oo = o000000o;
    }

    public CirclePadButton(Context context) {
        this(context, null);
    }

    public CirclePadButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void setTouchable(boolean z) {
        this.O0000o00 = z;
    }

    public CirclePadButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f10275O000000o = MODE.Normal;
        this.O0000o00 = true;
        this.O0000Oo0 = new Paint();
        this.O0000Oo = new Paint();
        this.O0000Oo.setColor(getResources().getColor(R.color.mj_color_separator));
        this.O0000Oo.setStyle(Paint.Style.FILL);
        O00000o = BitmapFactory.decodeResource(getResources(), R.drawable.popup_bg_tvadd_pre);
        O00000oO = BitmapFactory.decodeResource(getResources(), R.drawable.popup_bg_tvreduce_nor);
        O00000oo = BitmapFactory.decodeResource(getResources(), R.drawable.popup_icon_tvswitch_nor);
        O0000O0o = BitmapFactory.decodeResource(getResources(), R.drawable.popup_icon_tvadd_nor);
        O0000OOo = BitmapFactory.decodeResource(getResources(), R.drawable.popup_icon_tvreduce_nor);
        this.O0000OoO = (float) gpc.O000000o(getContext(), 200.0f);
        O00000o0 = BitmapFactory.decodeResource(getResources(), R.drawable.popup_icon_bg_nor);
        this.O0000Ooo = (long) gpc.O000000o(getContext(), 36.0f);
    }

    public void setMode(MODE mode) {
        this.f10275O000000o = mode;
    }

    /* renamed from: com.xiaomi.smarthome.newui.widget.CirclePadButton$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: O000000o  reason: collision with root package name */
        static final /* synthetic */ int[] f10276O000000o = new int[MODE.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(10:0|1|2|3|4|5|6|7|8|10) */
        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        static {
            f10276O000000o[MODE.Normal.ordinal()] = 1;
            f10276O000000o[MODE.Plus.ordinal()] = 2;
            f10276O000000o[MODE.Minus.ordinal()] = 3;
            try {
                f10276O000000o[MODE.Switch.ordinal()] = 4;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int i = AnonymousClass1.f10276O000000o[this.f10275O000000o.ordinal()];
        if (i == 1) {
            canvas.drawBitmap(O00000o0, 0.0f, 0.0f, this.O0000Oo0);
            this.O0000Oo.setColor(-1);
            float f = this.O0000OoO;
            canvas.drawCircle(f / 2.0f, f / 2.0f, (float) this.O0000Ooo, this.O0000Oo);
        } else if (i == 2) {
            canvas.drawBitmap(O00000o, 0.0f, 0.0f, this.O0000Oo0);
        } else if (i == 3) {
            canvas.drawBitmap(O00000oO, 0.0f, 0.0f, this.O0000Oo0);
        } else if (i == 4) {
            canvas.drawBitmap(O00000o0, 0.0f, 0.0f, this.O0000Oo0);
            this.O0000Oo.setColor(getResources().getColor(R.color.mj_color_separator));
            float f2 = this.O0000OoO;
            canvas.drawCircle(f2 / 2.0f, f2 / 2.0f, (float) this.O0000Ooo, this.O0000Oo);
        }
        Bitmap bitmap = O0000O0o;
        canvas.drawBitmap(bitmap, (this.O0000OoO / 2.0f) - (((float) bitmap.getWidth()) / 2.0f), (((this.O0000OoO / 2.0f) - ((float) this.O0000Ooo)) / 2.0f) - (((float) O0000O0o.getWidth()) / 2.0f), this.O0000Oo0);
        Bitmap bitmap2 = O0000OOo;
        float width = (this.O0000OoO / 2.0f) - (((float) bitmap2.getWidth()) / 2.0f);
        float f3 = this.O0000OoO;
        canvas.drawBitmap(bitmap2, width, (f3 - (((f3 / 2.0f) - ((float) this.O0000Ooo)) / 2.0f)) - (((float) O0000OOo.getWidth()) / 2.0f), this.O0000Oo0);
        Bitmap bitmap3 = O00000oo;
        canvas.drawBitmap(bitmap3, (this.O0000OoO / 2.0f) - (((float) bitmap3.getWidth()) / 2.0f), (this.O0000OoO / 2.0f) - ((float) (O00000oo.getHeight() / 2)), this.O0000Oo0);
    }

    public final void O000000o(boolean z) {
        if (z) {
            O00000oo = BitmapFactory.decodeResource(getResources(), R.drawable.popup_icon_tvswitch_nor);
            O0000O0o = BitmapFactory.decodeResource(getResources(), R.drawable.popup_icon_tvadd_nor);
            O0000OOo = BitmapFactory.decodeResource(getResources(), R.drawable.popup_icon_tvreduce_nor);
        } else {
            O0000O0o = BitmapFactory.decodeResource(getResources(), R.drawable.popup_icon_tvadd_disable);
            O0000OOo = BitmapFactory.decodeResource(getResources(), R.drawable.popup_icon_minus_disable);
            O00000oo = BitmapFactory.decodeResource(getResources(), R.drawable.popup_icon_tvswitch_disable);
        }
        invalidate();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.O0000o00) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            O000000o(motionEvent);
        } else if (action == 1) {
            getParent().requestDisallowInterceptTouchEvent(true);
            O000000o o000000o = this.O00000Oo;
            if (o000000o != null) {
                o000000o.O000000o(this.f10275O000000o);
            }
            this.f10275O000000o = MODE.Normal;
            invalidate();
        } else if (action == 2) {
            getParent().requestDisallowInterceptTouchEvent(true);
            O000000o(motionEvent);
        }
        return true;
    }

    private void O000000o(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        float f = this.O0000OoO;
        float f2 = x > f / 2.0f ? x - (f / 2.0f) : (f / 2.0f) - x;
        float f3 = this.O0000OoO;
        float f4 = y > f3 / 2.0f ? y - (f3 / 2.0f) : (f3 / 2.0f) - y;
        float f5 = (f2 * f2) + (f4 * f4);
        long j = this.O0000Ooo;
        if (f5 <= ((float) (j * j))) {
            this.f10275O000000o = MODE.Switch;
            invalidate();
            return;
        }
        float f6 = this.O0000OoO;
        if (f5 > (f6 / 2.0f) * f6 * 2.0f || x < 0.0f || x > f6) {
            this.f10275O000000o = MODE.Normal;
            invalidate();
        } else if (((double) (f4 / f2)) < Math.tan(22.5d)) {
            this.f10275O000000o = MODE.Normal;
            invalidate();
        } else if (y < this.O0000OoO / 2.0f) {
            this.f10275O000000o = MODE.Plus;
            invalidate();
        } else {
            this.f10275O000000o = MODE.Minus;
            invalidate();
        }
    }
}
