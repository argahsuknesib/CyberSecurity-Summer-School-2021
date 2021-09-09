package com.xiaomi.smarthome.newui.widget;

import _m_j.hhi;
import _m_j.hhk;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import androidx.core.content.ContextCompat;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.device.Device;

public class DownloadProgressBar extends ProgressBar implements hhk {

    /* renamed from: O000000o  reason: collision with root package name */
    private Context f10298O000000o;
    private Paint O00000Oo;
    private int O00000o;
    private PorterDuffXfermode O00000o0;

    public final void O000000o(Device device) {
    }

    public float getPercent() {
        return 0.0f;
    }

    public void setCallback(hhi hhi) {
    }

    public void setVisible(boolean z) {
    }

    public DownloadProgressBar(Context context) {
        super(context, null, 16842872);
        this.f10298O000000o = context;
        O00000oO();
    }

    public DownloadProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f10298O000000o = context;
        O00000oO();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        switch (this.O00000o) {
            case 101:
                O000000o(canvas, 101);
                return;
            case 102:
                O000000o(canvas, 102);
                return;
            case 103:
                O000000o(canvas, 103);
                return;
            case 104:
                O000000o(canvas, 104);
                return;
            default:
                O000000o(canvas, 101);
                return;
        }
    }

    private void O00000oO() {
        setIndeterminate(false);
        setIndeterminateDrawable(ContextCompat.O000000o(this.f10298O000000o, 17301613));
        setProgressDrawable(ContextCompat.O000000o(this.f10298O000000o, (int) R.drawable.pb_shape_green));
        setMax(100);
        this.O00000Oo = new Paint();
        this.O00000Oo.setDither(true);
        this.O00000Oo.setAntiAlias(true);
        this.O00000Oo.setStyle(Paint.Style.FILL_AND_STROKE);
        this.O00000Oo.setTextAlign(Paint.Align.LEFT);
        this.O00000Oo.setTextSize((float) getResources().getDimensionPixelSize(R.dimen.font_size_13sp));
        this.O00000Oo.setTypeface(Typeface.MONOSPACE);
        this.O00000o0 = new PorterDuffXfermode(PorterDuff.Mode.SRC_IN);
    }

    private void O000000o(int i) {
        switch (i) {
            case 101:
                setProgress(0);
                this.O00000Oo.setColor(ContextCompat.O00000o0(this.f10298O000000o, R.color.mj_color_gray_lightest));
                return;
            case 102:
                this.O00000Oo.setColor(ContextCompat.O00000o0(this.f10298O000000o, R.color.mj_color_green_normal));
                return;
            case 103:
                this.O00000Oo.setColor(ContextCompat.O00000o0(this.f10298O000000o, R.color.mj_color_green_normal));
                return;
            case 104:
                setProgress(0);
                this.O00000Oo.setColor(ContextCompat.O00000o0(this.f10298O000000o, R.color.mj_color_gray_lightest));
                return;
            default:
                setProgress(0);
                this.O00000Oo.setColor(ContextCompat.O00000o0(this.f10298O000000o, R.color.mj_color_gray_lightest));
                return;
        }
    }

    private void O000000o(Canvas canvas, int i) {
        O000000o(i);
        String O00000Oo2 = O00000Oo(i);
        int textColor$134621 = getTextColor$134621();
        Rect rect = new Rect();
        this.O00000Oo.getTextBounds(O00000Oo2, 0, O00000Oo2.length(), rect);
        float width = (float) ((getWidth() / 2) - rect.centerX());
        float height = (float) ((getHeight() / 2) - rect.centerY());
        int color = this.O00000Oo.getColor();
        if (i == 101) {
            this.O00000Oo.setColor(textColor$134621);
            canvas.drawText(O00000Oo2, width, height, this.O00000Oo);
            this.O00000Oo.setColor(color);
            return;
        }
        Bitmap createBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas2 = new Canvas(createBitmap);
        this.O00000Oo.setColor(textColor$134621);
        canvas2.drawText(O00000Oo2, width, height, this.O00000Oo);
        this.O00000Oo.setColor(color);
        this.O00000Oo.setXfermode(this.O00000o0);
        this.O00000Oo.setColor(-1);
        canvas2.drawRect(new RectF(0.0f, 0.0f, (float) ((getWidth() * getProgress()) / 100), (float) getHeight()), this.O00000Oo);
        canvas.drawBitmap(createBitmap, 0.0f, 0.0f, (Paint) null);
        this.O00000Oo.setXfermode(null);
        if (!createBitmap.isRecycled()) {
            createBitmap.recycle();
        }
    }

    private int getTextColor$134621() {
        return ContextCompat.O00000o0(this.f10298O000000o, R.color.mj_color_black_80_transparent);
    }

    private String O00000Oo(int i) {
        switch (i) {
            case 101:
                return getResources().getString(R.string.card_more_operation);
            case 102:
                return getResources().getString(R.string.device_loading);
            case 103:
                return getResources().getString(R.string.download_device_fail);
            case 104:
                return getResources().getString(R.string.card_more_operation);
            default:
                return getResources().getString(R.string.download_device);
        }
    }

    public final void O000000o() {
        this.O00000o = 102;
        invalidate();
    }

    public final void O00000Oo() {
        this.O00000o = 104;
        invalidate();
    }

    public final void O00000o0() {
        this.O00000o = 103;
        invalidate();
    }

    public final void O00000o() {
        this.O00000o = 101;
        invalidate();
    }

    public void setPercent(float f) {
        setProgress((int) f);
    }
}
