package com.xiaomi.qrcode.camera;

import _m_j.gsy;
import android.content.Context;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.view.TextureView;

public class CameraTextureView extends TextureView {

    /* renamed from: O000000o  reason: collision with root package name */
    private int f6598O000000o;
    private int O00000Oo;
    private int O00000o0;

    public CameraTextureView(Context context) {
        this(context, null);
    }

    public CameraTextureView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CameraTextureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        gsy.O000000o(3, "CameraTextureView", getClass().getName() + ".setImageFrameMatrix()");
        O000000o(this.f6598O000000o, this.O00000Oo, this.O00000o0);
    }

    public final void O000000o(int i, int i2, int i3) {
        gsy.O000000o(3, "CameraTextureView", getClass().getName() + ".setImageFrameMatrix() frameWH = " + i + "x" + i2 + " , frameDegree = " + i3);
        if (i > 0 && i2 > 0) {
            this.f6598O000000o = i;
            this.O00000Oo = i2;
            this.O00000o0 = i3;
            int width = getWidth();
            int height = getHeight();
            if (width > 0 && height > 0) {
                Matrix matrix = new Matrix();
                matrix.setRotate((float) i3, ((float) getWidth()) * 0.5f, ((float) getHeight()) * 0.5f);
                if (i3 % 180 == 0) {
                    int i4 = width * i2;
                    int i5 = i * height;
                    if (i4 < i5) {
                        float f = ((((float) i) * 1.0f) * ((float) height)) / ((float) i4);
                        gsy.O000000o(3, "CameraTextureView", getClass().getName() + ".setImageFrameMatrix()A XY = " + f + " : 1");
                        matrix.postScale(f, 1.0f, 0.0f, 0.0f);
                    } else {
                        float f2 = ((((float) width) * 1.0f) * ((float) i2)) / ((float) i5);
                        gsy.O000000o(3, "CameraTextureView", getClass().getName() + ".setImageFrameMatrix()B XY = 1 : " + f2);
                        matrix.postScale(1.0f, f2, 0.0f, 0.0f);
                    }
                } else if (width * i < i2 * height) {
                    float f3 = (((float) i2) * 1.0f) / ((float) i);
                    float f4 = (float) height;
                    float f5 = (float) width;
                    matrix.postScale(f3, (1.0f * f4) / f5, f5 * 0.5f, f4 * 0.5f);
                    matrix.postTranslate(((f3 * f4) - f5) * 0.5f, 0.0f);
                } else {
                    float f6 = (float) width;
                    float f7 = (float) height;
                    float f8 = (((float) i) * 1.0f) / ((float) i2);
                    matrix.postScale((f6 * 1.0f) / f7, f8, f6 * 0.5f, f7 * 0.5f);
                    matrix.postTranslate(0.0f, ((f8 * f6) - f7) * 0.5f);
                }
                setTransform(matrix);
            }
        }
    }
}
