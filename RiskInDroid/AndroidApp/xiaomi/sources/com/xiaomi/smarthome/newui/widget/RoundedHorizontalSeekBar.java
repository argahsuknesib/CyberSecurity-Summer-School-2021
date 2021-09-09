package com.xiaomi.smarthome.newui.widget;

import _m_j.gsy;
import _m_j.hhj;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import com.xiaomi.smarthome.R;

public class RoundedHorizontalSeekBar extends BaseSeekBar {

    /* renamed from: O000000o  reason: collision with root package name */
    private hhj f10326O000000o;
    private Bitmap O00000Oo;
    private float O00000o;
    private CharSequence O00000o0;
    private Paint O00000oO;
    private PorterDuffXfermode O00000oo;
    private boolean O0000O0o;
    private int O0000OOo;
    private int O0000Oo;
    private int O0000Oo0;
    private int O0000OoO;
    private int O0000Ooo;
    private int O0000o0;
    private int O0000o00;

    public RoundedHorizontalSeekBar(Context context) {
        this(context, null);
    }

    public RoundedHorizontalSeekBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundedHorizontalSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.O00000o = -1.0f;
        this.O00000oo = new PorterDuffXfermode(PorterDuff.Mode.SRC_IN);
        this.O0000O0o = true;
        setProgressDrawable(null);
        this.f10326O000000o = new hhj();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.bg_color_my, R.attr.icon_padding_left_my, R.attr.img_icon_my, R.attr.progress_color_my, R.attr.seek_enable, R.attr.text_color_my, R.attr.text_color_select, R.attr.text_my, R.attr.text_padding_left_my, R.attr.text_size_my}, i, 0);
        int color = obtainStyledAttributes.getColor(3, getResources().getColor(R.color.mj_color_text_blue_bg));
        int color2 = obtainStyledAttributes.getColor(0, getResources().getColor(R.color.mj_color_gray_lightest));
        this.O0000OOo = color2;
        this.O0000Oo0 = color;
        this.O0000Ooo = obtainStyledAttributes.getColor(6, -526345);
        this.O0000Oo = getResources().getColor(R.color.mj_color_gray_lightest);
        this.O0000OoO = getResources().getColor(R.color.mj_color_gray_lighter);
        this.O0000o00 = this.O0000Oo;
        this.O0000o0 = this.O0000OoO;
        this.f10326O000000o.O00000Oo(color);
        this.f10326O000000o.O000000o(color2);
        setCanSeek(obtainStyledAttributes.getBoolean(4, true));
        if (obtainStyledAttributes.hasValue(2)) {
            int resourceId = obtainStyledAttributes.getResourceId(2, -1);
            if (resourceId > 0) {
                setImageIcon(resourceId);
            }
            this.O00000o = obtainStyledAttributes.getDimension(1, -1.0f);
        } else {
            String text = obtainStyledAttributes.getText(7);
            text = text == null ? "" : text;
            this.O00000o = obtainStyledAttributes.getDimension(8, -1.0f);
            float dimension = obtainStyledAttributes.getDimension(9, 0.0f);
            int color3 = obtainStyledAttributes.getColor(5, getResources().getColor(17170443));
            setTextInfo(text);
            this.O00000oO = new Paint(1);
            this.O00000oO.setTextSize(dimension);
            this.O00000oO.setTextAlign(Paint.Align.LEFT);
            this.O00000oO.setColor(color3);
        }
        this.f10326O000000o.O000000o(0, getMax());
        obtainStyledAttributes.recycle();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        this.f10326O000000o.f18948O000000o = getProgress();
        this.f10326O000000o.draw(canvas);
        int width = getWidth();
        int height = getHeight();
        if (width > 0 && height > 0) {
            if (this.O00000o < 0.0f) {
                this.O00000o = (float) this.f10326O000000o.O00000Oo;
            }
            if (this.O00000oO.getTextSize() == 0.0f) {
                this.O00000oO.setTextSize(((float) this.f10326O000000o.O00000Oo) * 0.7f);
            }
            if (this.O00000Oo != null) {
                float height2 = (float) this.f10326O000000o.getBounds().height();
                Rect rect = new Rect(0, 0, this.O00000Oo.getWidth(), this.O00000Oo.getHeight());
                Bitmap bitmap = this.O00000Oo;
                float f = this.O00000o;
                canvas.drawBitmap(bitmap, rect, new RectF(f, 0.0f, ((((float) rect.width()) * height2) / ((float) rect.height())) + f, height2), (Paint) null);
            } else if (this.O00000o0 != null) {
                Paint.FontMetricsInt fontMetricsInt = this.O00000oO.getFontMetricsInt();
                int i = fontMetricsInt.bottom - fontMetricsInt.top;
                int i2 = (height - i) / 2;
                Rect rect2 = new Rect((int) this.O00000o, i2, (int) this.O00000oO.measureText(this.O00000o0.toString()), i + i2);
                Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
                Canvas canvas2 = new Canvas(createBitmap);
                this.O00000oO.setColor(getTextColor());
                canvas2.drawText(this.O00000o0.toString(), this.O00000o, (float) ((((rect2.bottom + rect2.top) - fontMetricsInt.bottom) - fontMetricsInt.top) / 2), this.O00000oO);
                this.O00000oO.setXfermode(this.O00000oo);
                this.O00000oO.setColor(getTextProcessedColor());
                canvas2.drawRect(new RectF(0.0f, 0.0f, (float) this.f10326O000000o.O000000o(), (float) height), this.O00000oO);
                canvas.drawBitmap(createBitmap, 0.0f, 0.0f, (Paint) null);
                this.O00000oO.setXfermode(null);
                if (!createBitmap.isRecycled()) {
                    createBitmap.recycle();
                }
            }
        }
        super.onDraw(canvas);
    }

    public void setContentPaddingLeft(float f) {
        this.O00000o = f;
    }

    private int getTextColor() {
        if (this.O0000O0o) {
            return this.O0000Oo0;
        }
        return this.O0000o0;
    }

    private int getTextProcessedColor() {
        if (this.O0000O0o) {
            return this.O0000Ooo;
        }
        return this.O0000o00;
    }

    public void setImageIcon(Bitmap bitmap) {
        this.O00000Oo = bitmap;
        this.O00000o0 = null;
    }

    public void setTextInfo(CharSequence charSequence) {
        this.O00000o0 = charSequence;
        this.O00000Oo = null;
    }

    public final void O000000o(boolean z) {
        this.O0000O0o = z;
        setCanSeek(z);
        if (z) {
            this.f10326O000000o.O00000Oo(this.O0000Oo0);
            this.f10326O000000o.O000000o(this.O0000OOo);
        } else {
            this.f10326O000000o.O00000Oo(this.O0000OoO);
            this.f10326O000000o.O000000o(this.O0000Oo);
        }
        invalidate();
    }

    public synchronized void setMax(int i) {
        super.setMax(i);
        if (this.f10326O000000o != null) {
            this.f10326O000000o.O000000o(Build.VERSION.SDK_INT >= 26 ? getMin() : 0, getMax());
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f10326O000000o.setBounds(new Rect(0, 0, i, i2));
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        Bitmap bitmap = this.O00000Oo;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.O00000Oo.recycle();
        }
        super.onDetachedFromWindow();
    }

    public void setForegroundColor(int i) {
        if (this.O0000O0o) {
            hhj hhj = this.f10326O000000o;
            this.O0000Oo0 = i;
            hhj.O00000Oo(i);
        }
    }

    public void setImageIcon(int i) {
        Bitmap decodeResource = BitmapFactory.decodeResource(getResources(), i);
        if (decodeResource == null) {
            gsy.O000000o(6, "Seekbar", "icon==null");
        } else {
            decodeResource = Bitmap.createScaledBitmap(decodeResource, decodeResource.getWidth(), decodeResource.getHeight(), true);
        }
        this.O00000Oo = decodeResource;
        this.O00000o0 = null;
    }
}
