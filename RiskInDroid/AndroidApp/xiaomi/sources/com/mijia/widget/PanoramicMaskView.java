package com.mijia.widget;

import _m_j.cht;
import _m_j.gpc;
import _m_j.gsy;
import _m_j.mh;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.appcompat.widget.AppCompatImageView;

public class PanoramicMaskView extends AppCompatImageView {
    public static final String TAG = "PanoramicMaskView";
    private cht cameraGetPanorama;
    private short hdDistance;
    float height;
    float itemX;
    float itemY;
    private short[] leftTop;
    O000000o onUpListener;
    Paint paint;
    RectF rectF;
    private short[] rightBottom;
    private short vdDistance;
    float width;
    private float x;
    private float y;

    public interface O000000o {
        void onUpEvent(short s, short s2);
    }

    public PanoramicMaskView(Context context) {
        this(context, null);
    }

    public PanoramicMaskView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PanoramicMaskView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.paint = new Paint();
        this.rightBottom = new short[2];
        this.leftTop = new short[2];
        this.x = 250.0f;
        this.y = 150.0f;
        this.rectF = new RectF();
        this.paint.setColor(-1);
        this.paint.setStrokeWidth(3.0f);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setAntiAlias(true);
    }

    public void setCameraGetPanorama(cht cht) {
        this.cameraGetPanorama = cht;
    }

    public void initialAngle(Context context, String str) {
        try {
            if (this.cameraGetPanorama.O0000O0o > 5) {
                this.rightBottom = this.cameraGetPanorama.O00000oo.get((this.cameraGetPanorama.O0000O0o / 2) + 1);
                this.leftTop = this.cameraGetPanorama.O00000oo.get(1);
            } else {
                this.leftTop = this.cameraGetPanorama.O00000oo.get(1);
                this.rightBottom = this.cameraGetPanorama.O00000oo.get(2);
            }
            mh.O000000o(context, str).O000000o("panoramAngleLeft", this.leftTop[0]);
            mh.O000000o(context, str).O000000o("panoramAngleTop", this.leftTop[1]);
            mh.O000000o(context, str).O000000o("panoramAngleRight", this.rightBottom[0]);
            mh.O000000o(context, str).O000000o("panoramAngleBottom", this.rightBottom[1]);
            mh.O000000o(context, str).O000000o("panoramCount", this.cameraGetPanorama.O0000O0o);
        } catch (Exception unused) {
            this.rightBottom = new short[2];
            this.rightBottom[0] = (short) mh.O000000o(context, str).O000000o("panoramAngleRight");
            this.rightBottom[1] = (short) mh.O000000o(context, str).O000000o("panoramAngleBottom");
            this.leftTop = new short[2];
            this.leftTop[0] = (short) mh.O000000o(context, str).O000000o("panoramAngleLeft");
            this.leftTop[1] = (short) mh.O000000o(context, str).O000000o("panoramAngleTop");
        }
        this.itemX = this.width / ((float) (this.cameraGetPanorama.O0000O0o * 2));
        if (this.cameraGetPanorama.O0000O0o > 5) {
            this.itemY = this.height / 4.0f;
        } else {
            this.itemY = this.height / 2.0f;
        }
        short[] sArr = this.leftTop;
        short s = sArr[0];
        short[] sArr2 = this.rightBottom;
        this.hdDistance = (short) (s - sArr2[0]);
        this.vdDistance = (short) (sArr2[1] - sArr[1]);
        invalidate();
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        this.width = (float) i;
        this.height = (float) i2;
        String str = TAG;
        gsy.O00000Oo(str, "onSizeChanged w=" + i + " h=" + i2);
        if (this.cameraGetPanorama.O0000O0o > 0) {
            this.itemX = this.width / ((float) (this.cameraGetPanorama.O0000O0o * 2));
        }
        if (this.cameraGetPanorama.O0000O0o > 5) {
            this.itemY = this.height / 4.0f;
        } else {
            this.itemY = this.height / 2.0f;
        }
        correction();
        invalidate();
        super.onSizeChanged(i, i2, i3, i4);
    }

    public void initialPosition(short[] sArr) {
        String str = TAG;
        gsy.O00000Oo(str, "hd=" + ((int) sArr[0]) + "  vd=" + ((int) sArr[1]));
        String str2 = TAG;
        gsy.O00000Oo(str2, "hdDistance=" + ((int) this.hdDistance) + "  vdDistance=" + ((int) this.vdDistance));
        short s = sArr[0];
        short[] sArr2 = this.rightBottom;
        float f = ((float) (s - sArr2[0])) / ((float) this.hdDistance);
        float f2 = ((float) (sArr2[1] - sArr[1])) / ((float) this.vdDistance);
        String str3 = TAG;
        gsy.O00000Oo(str3, "rightBottom[0]=" + ((int) this.rightBottom[0]) + "  rightBottom[1]=" + ((int) this.rightBottom[1]));
        String str4 = TAG;
        gsy.O00000Oo(str4, "leftTop[0]=" + ((int) this.leftTop[0]) + "  leftTop[1]=" + ((int) this.leftTop[1]));
        String str5 = TAG;
        gsy.O00000Oo(str5, "sc0aleh=" + f + "  scalev=" + f2);
        float f3 = this.width;
        float f4 = this.itemX;
        this.x = (f3 - f4) - ((f3 - (2.0f * f4)) * f);
        this.y = this.itemY;
        String str6 = TAG;
        gsy.O00000Oo(str6, "x=" + this.x + "  y=" + this.y);
        correction();
        String str7 = TAG;
        gsy.O00000Oo(str7, "correction  x=" + this.x + "  y=" + this.y);
        invalidate();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() != 1) {
            this.x = motionEvent.getX();
            this.y = motionEvent.getY();
            correction();
            invalidate();
        } else {
            float f = this.width;
            float f2 = this.itemX;
            float f3 = f - (f2 * 2.0f);
            float f4 = this.height;
            float f5 = this.itemY;
            float f6 = f4 - (2.0f * f5);
            float f7 = (f - this.x) - f2;
            float f8 = (f4 - this.y) - f5;
            float f9 = 0.0f;
            float f10 = f3 != 0.0f ? f7 / f3 : 0.0f;
            if (f6 != 0.0f) {
                f9 = f8 / f6;
            }
            String str = TAG;
            gsy.O00000Oo(str, "ACTION_UP:" + f7 + "--" + f8);
            String str2 = TAG;
            gsy.O00000Oo(str2, "ACTION_UP:" + f10 + "--" + f9);
            String str3 = TAG;
            gsy.O00000Oo(str3, "ACTION_UP rightBottom:" + ((int) this.rightBottom[0]) + "--" + ((int) this.rightBottom[1]));
            short[] sArr = this.rightBottom;
            short s = (short) ((int) (((float) sArr[0]) + (f10 * ((float) this.hdDistance))));
            short s2 = (short) ((int) (((float) sArr[1]) - (f9 * ((float) this.vdDistance))));
            String str4 = TAG;
            gsy.O00000Oo(str4, "ACTION_UP hd=" + ((int) s) + "--vd" + ((int) s2));
            onUp(s, s2);
        }
        return true;
    }

    private void correction() {
        float f = this.x;
        float f2 = this.itemX;
        if (f < f2) {
            this.x = f2;
        }
        float f3 = this.x;
        float f4 = this.width;
        float f5 = this.itemX;
        if (f3 > f4 - f5) {
            this.x = f4 - f5;
        }
        float f6 = this.y;
        float f7 = this.itemY;
        if (f6 < f7) {
            this.y = f7;
        }
        float f8 = this.y;
        float f9 = this.height;
        float f10 = this.itemY;
        if (f8 > f9 - f10) {
            this.y = f9 - f10;
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        this.rectF.left = (this.x - this.itemX) + ((float) gpc.O00000o0(getContext(), 1.0f));
        this.rectF.top = (this.y - this.itemY) + ((float) gpc.O00000o0(getContext(), 1.0f));
        this.rectF.right = (this.x + this.itemX) - ((float) gpc.O00000o0(getContext(), 1.0f));
        this.rectF.bottom = (this.y + this.itemY) - ((float) gpc.O00000o0(getContext(), 1.0f));
        float O00000o0 = (float) gpc.O00000o0(getContext(), 10.0f);
        canvas.drawRoundRect(this.rectF, O00000o0, O00000o0, this.paint);
    }

    private void onUp(short s, short s2) {
        O000000o o000000o = this.onUpListener;
        if (o000000o != null) {
            o000000o.onUpEvent(s, s2);
        }
    }

    public void setOnUpListener(O000000o o000000o) {
        this.onUpListener = o000000o;
    }
}
