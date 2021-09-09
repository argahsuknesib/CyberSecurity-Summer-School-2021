package com.xiaomi.qrcode2;

import _m_j.idg;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v4.app.NotificationCompat;
import android.util.AttributeSet;
import android.view.View;
import com.xiaomi.qrcode2.camera.CameraManager;
import com.xiaomi.smarthome.R;
import java.util.ArrayList;
import java.util.List;

public final class ViewfinderView extends View {
    private static final int[] O00000o0 = {0, 64, NotificationCompat.FLAG_HIGH_PRIORITY, 192, 255, 192, NotificationCompat.FLAG_HIGH_PRIORITY, 64};

    /* renamed from: O000000o  reason: collision with root package name */
    Bitmap f6609O000000o;
    public List<idg> O00000Oo;
    private CameraManager O00000o;
    private final Paint O00000oO = new Paint(1);
    private Bitmap O00000oo;
    private final int O0000O0o;
    private final int O0000OOo;
    private final int O0000Oo;
    private final int O0000Oo0;
    private final int O0000OoO;
    private int O0000Ooo;
    private int O0000o0;
    private int O0000o00;
    private List<idg> O0000o0O;
    private float O0000o0o = -1.0f;

    public ViewfinderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Resources resources = getResources();
        this.O0000O0o = resources.getColor(R.color.viewfinder_mask);
        this.O0000OOo = resources.getColor(R.color.result_view);
        this.O0000Oo0 = resources.getColor(R.color.viewfinder_laser);
        this.O0000Oo = resources.getColor(R.color.possible_result_points);
        this.O0000OoO = resources.getColor(R.color.scan_border_color);
        this.O0000Ooo = resources.getDimensionPixelSize(R.dimen.scan_border_width);
        this.O0000o00 = resources.getDimensionPixelSize(R.dimen.scan_border_height);
        this.O0000o0 = 0;
        this.O00000Oo = new ArrayList(5);
        this.O0000o0O = null;
    }

    public final void setCameraManager(CameraManager cameraManager) {
        this.O00000o = cameraManager;
        this.O00000oo = BitmapFactory.decodeResource(getResources(), R.drawable.scan_bar);
    }

    @SuppressLint({"DrawAllocation"})
    public final void onDraw(Canvas canvas) {
        CameraManager cameraManager = this.O00000o;
        if (cameraManager != null) {
            Rect O00000oO2 = cameraManager.O00000oO();
            Rect O00000oo2 = this.O00000o.O00000oo();
            if (O00000oO2 != null && O00000oo2 != null) {
                int width = canvas.getWidth();
                int height = canvas.getHeight();
                this.O00000oO.setColor(this.O0000O0o);
                float f = (float) width;
                canvas.drawRect(0.0f, 0.0f, f, (float) O00000oO2.top, this.O00000oO);
                canvas.drawRect(0.0f, (float) O00000oO2.top, (float) O00000oO2.left, (float) (O00000oO2.bottom + 1), this.O00000oO);
                Canvas canvas2 = canvas;
                float f2 = f;
                canvas2.drawRect((float) (O00000oO2.right + 1), (float) O00000oO2.top, f2, (float) (O00000oO2.bottom + 1), this.O00000oO);
                canvas2.drawRect(0.0f, (float) (O00000oO2.bottom + 1), f2, (float) height, this.O00000oO);
                if (this.O0000o0o == -1.0f) {
                    this.O0000o0o = (float) O00000oO2.top;
                }
                this.O0000o0o += (((float) (((long) O00000oO2.height()) * 15)) * 1.0f) / 2500.0f;
                if (this.O0000o0o >= ((float) (O00000oO2.top + O00000oO2.height()))) {
                    this.O0000o0o = (float) O00000oO2.top;
                }
                canvas.drawBitmap(this.O00000oo, (float) O00000oO2.left, this.O0000o0o, this.O00000oO);
                this.O00000oO.setColor(this.O0000OoO);
                this.O00000oO.setStyle(Paint.Style.FILL);
                int i = O00000oO2.left;
                int i2 = O00000oO2.top;
                int width2 = O00000oO2.width();
                int height2 = O00000oO2.height();
                float f3 = (float) i2;
                float f4 = (float) i;
                float f5 = f3;
                canvas.drawRect(f4, f5, (float) (this.O0000o00 + i), (float) (this.O0000Ooo + i2), this.O00000oO);
                canvas.drawRect(f4, f5, (float) (this.O0000Ooo + i), (float) (this.O0000o00 + i2), this.O00000oO);
                int i3 = height2 + i2;
                float f6 = (float) (i3 + 1);
                float f7 = f6;
                canvas.drawRect(f4, (float) ((i3 - this.O0000o00) + 1), (float) (this.O0000Ooo + i), f7, this.O00000oO);
                Canvas canvas3 = canvas;
                canvas3.drawRect(f4, (float) ((i3 - this.O0000Ooo) + 1), (float) (this.O0000o00 + i), f7, this.O00000oO);
                int i4 = i + width2;
                float f8 = f3;
                float f9 = (float) (i4 + 1);
                canvas3.drawRect((float) ((i4 - this.O0000o00) + 1), f8, f9, (float) (this.O0000Ooo + i2), this.O00000oO);
                canvas3.drawRect((float) ((i4 - this.O0000Ooo) + 1), f8, f9, (float) (i2 + this.O0000o00), this.O00000oO);
                float f10 = f6;
                canvas3.drawRect((float) ((i4 - this.O0000Ooo) + 1), (float) ((i3 - this.O0000o00) + 1), f9, f10, this.O00000oO);
                canvas3.drawRect((float) ((i4 - this.O0000o00) + 1), (float) ((i3 - this.O0000Ooo) + 1), f9, f10, this.O00000oO);
                if (this.f6609O000000o == null) {
                    postInvalidateDelayed(15, O00000oO2.left - 6, O00000oO2.top - 6, O00000oO2.right + 6, O00000oO2.bottom + 6);
                }
            }
        }
    }
}
