package com.xiaomi.smarthome.camera.view;

import _m_j.cki;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.appcompat.widget.AppCompatImageView;
import java.util.Map;
import java.util.TreeMap;

public class BabySleepAreaView extends AppCompatImageView {
    public static final String TAG = "BabySleepAreaView";
    private final int LINE_WIDTH;
    private final TreeMap<Float, Integer> distances;
    private float downX;
    private float downY;
    private int height;
    private int itemH;
    private int itemW;
    private int needMove;
    public boolean needSetValue;
    Paint paint32;
    Paint paintSTROKE;
    Paint paintSTROKE2;
    private int[] positions;
    private Rect rect;
    private Rect rect2;
    private float touchB;
    private float touchL;
    private float touchR;
    private float touchT;
    private int width;

    public BabySleepAreaView(Context context) {
        this(context, null);
    }

    public BabySleepAreaView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BabySleepAreaView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.needSetValue = false;
        this.positions = new int[]{30, 30, 65, 65};
        this.touchL = 100.0f;
        this.touchT = 100.0f;
        this.touchR = 280.0f;
        this.touchB = 280.0f;
        this.paint32 = new Paint();
        this.paintSTROKE = new Paint();
        this.paintSTROKE2 = new Paint();
        this.LINE_WIDTH = 6;
        this.needMove = 0;
        this.distances = new TreeMap<>();
        this.rect = new Rect();
        this.rect2 = new Rect();
        init();
    }

    public void setPositions(int i, int i2, int i3, int i4) {
        int[] iArr = this.positions;
        iArr[0] = i;
        iArr[1] = i2;
        iArr[2] = i3;
        iArr[3] = i4;
        String str = TAG;
        cki.O00000o(str, "setPositions height=" + this.height);
        int i5 = this.height;
        if (i5 > 0) {
            int i6 = this.width;
            this.touchL = ((float) i6) * (((float) i) / 100.0f);
            this.touchT = ((float) i5) * (((float) i2) / 100.0f);
            this.touchR = ((float) i6) * (((float) i3) / 100.0f);
            this.touchB = ((float) i5) * (((float) i4) / 100.0f);
            invalidate();
        }
    }

    public int[] getPositions() {
        float f = this.touchL;
        int i = this.width;
        float f2 = this.touchT;
        int i2 = this.height;
        return new int[]{(int) ((f / ((float) i)) * 100.0f), (int) ((f2 / ((float) i2)) * 100.0f), (int) ((this.touchR / ((float) i)) * 100.0f), (int) ((this.touchB / ((float) i2)) * 100.0f)};
    }

    private void init() {
        setClickable(true);
        this.width = getWidth();
        this.height = getHeight();
        String str = TAG;
        cki.O000000o(str, "init:" + this.width + "-" + this.height);
        this.paint32.setStyle(Paint.Style.FILL);
        this.paint32.setColor(Color.parseColor("#5532BAC0"));
        this.paintSTROKE.setStyle(Paint.Style.STROKE);
        this.paintSTROKE.setStrokeWidth(3.0f);
        this.paintSTROKE.setColor(Color.parseColor("#32BAC0"));
        this.paintSTROKE2.setStyle(Paint.Style.STROKE);
        this.paintSTROKE2.setStrokeWidth(6.0f);
        this.paintSTROKE2.setColor(Color.parseColor("#32BAC0"));
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isEnabled()) {
            return super.onTouchEvent(motionEvent);
        }
        this.needSetValue = true;
        int action = motionEvent.getAction();
        if (action == 0) {
            float f = this.touchL;
            float f2 = this.touchR;
            if (f > f2) {
                this.touchL = f2;
                this.touchR = f;
            }
            float f3 = this.touchT;
            float f4 = this.touchB;
            if (f3 > f4) {
                this.touchT = f4;
                this.touchB = f3;
            }
            this.downX = motionEvent.getX();
            this.downY = motionEvent.getY();
            this.distances.clear();
            this.distances.put(Float.valueOf(Math.abs(this.downX - this.touchL)), 0);
            this.distances.put(Float.valueOf(Math.abs(this.downY - this.touchT)), 1);
            this.distances.put(Float.valueOf(Math.abs(this.downX - this.touchR)), 2);
            this.distances.put(Float.valueOf(Math.abs(this.downY - this.touchB)), 3);
            int i = -1;
            for (Map.Entry next : this.distances.entrySet()) {
                float floatValue = ((Float) next.getKey()).floatValue();
                int intValue = ((Integer) next.getValue()).intValue();
                if (i == -1 || i % 2 != intValue % 2) {
                    if (intValue != 0) {
                        if (intValue != 1) {
                            if (intValue != 2) {
                                if (intValue == 3 && floatValue < 100.0f) {
                                    float f5 = this.downX;
                                    if (f5 >= this.touchL - 100.0f && f5 <= this.touchR + 100.0f) {
                                        this.needMove |= 8;
                                    }
                                }
                            } else if (floatValue < 100.0f) {
                                float f6 = this.downY;
                                if (f6 >= this.touchT - 100.0f && f6 <= this.touchB + 100.0f) {
                                    this.needMove |= 4;
                                }
                            }
                        } else if (floatValue < 100.0f) {
                            float f7 = this.downX;
                            if (f7 >= this.touchL - 100.0f && f7 <= this.touchR + 100.0f) {
                                this.needMove |= 2;
                            }
                        }
                    } else if (floatValue < 100.0f) {
                        float f8 = this.downY;
                        if (f8 >= this.touchT - 100.0f && f8 <= this.touchB + 100.0f) {
                            this.needMove |= 1;
                        }
                    }
                    if (i != -1) {
                        break;
                    }
                    i = intValue;
                }
            }
        } else if (action != 2) {
            this.needMove = 0;
        } else {
            int i2 = this.needMove;
            if (!(i2 == 0 || i2 == 8 || i2 == 4 || i2 == 2 || i2 == 1)) {
                this.downX = motionEvent.getX();
                this.downY = motionEvent.getY();
                if (this.downX < 0.0f) {
                    this.downX = 0.0f;
                }
                float f9 = this.downX;
                int i3 = this.width;
                if (f9 > ((float) i3)) {
                    this.downX = (float) i3;
                }
                if (this.downY < 0.0f) {
                    this.downY = 0.0f;
                }
                float f10 = this.downY;
                int i4 = this.height;
                if (f10 > ((float) i4)) {
                    this.downY = (float) i4;
                }
                int i5 = this.itemH;
                if ((1 & this.needMove) > 0) {
                    float f11 = this.downX;
                    float f12 = this.touchR;
                    if (f11 < f12 && ((float) i5) < Math.abs(f11 - f12)) {
                        this.touchL = this.downX;
                    }
                }
                if ((this.needMove & 2) > 0) {
                    float f13 = this.downY;
                    float f14 = this.touchB;
                    if (f13 < f14 && ((float) i5) < Math.abs(f13 - f14)) {
                        this.touchT = this.downY;
                    }
                }
                if ((this.needMove & 4) > 0) {
                    float f15 = this.downX;
                    float f16 = this.touchL;
                    if (f15 > f16 && ((float) i5) < Math.abs(f15 - f16)) {
                        this.touchR = this.downX;
                    }
                }
                if ((this.needMove & 8) > 0) {
                    float f17 = this.downY;
                    float f18 = this.touchT;
                    if (f17 > f18 && ((float) i5) < Math.abs(f17 - f18)) {
                        this.touchB = this.downY;
                    }
                }
                invalidate();
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.width = getWidth();
        this.height = getHeight();
        String str = TAG;
        cki.O000000o(str, "onSizeChanged:" + this.width + "-" + this.height);
        int i5 = this.width;
        this.itemW = i5 / 8;
        int i6 = this.height;
        this.itemH = i6 / 4;
        int[] iArr = this.positions;
        this.touchL = ((float) i5) * (((float) iArr[0]) / 100.0f);
        this.touchT = ((float) i6) * (((float) iArr[1]) / 100.0f);
        this.touchR = ((float) i5) * (((float) iArr[2]) / 100.0f);
        this.touchB = ((float) i6) * (((float) iArr[3]) / 100.0f);
        String str2 = TAG;
        cki.O000000o(str2, "onSizeChanged positions=" + this.positions[0] + "," + this.positions[1] + "," + this.positions[2] + "," + this.positions[3]);
        invalidate();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        Canvas canvas2 = canvas;
        super.onDraw(canvas);
        if (isEnabled() && this.height > 0) {
            float min = Math.min(this.touchL, this.touchR);
            float max = Math.max(this.touchL, this.touchR);
            float min2 = Math.min(this.touchT, this.touchB);
            float max2 = Math.max(this.touchT, this.touchB);
            int i = this.itemW;
            int i2 = (int) (min / ((float) i));
            int i3 = ((int) (max / ((float) i))) + 1;
            int i4 = this.itemH;
            int i5 = ((int) (max2 / ((float) i4))) + 1;
            for (int i6 = (int) (min2 / ((float) i4)); i6 < i5; i6++) {
                for (int i7 = i2; i7 < i3; i7++) {
                    Rect rect3 = this.rect;
                    rect3.left = this.itemW * i7;
                    rect3.top = this.itemH * i6;
                    rect3.right = rect3.left + this.itemW;
                    Rect rect4 = this.rect;
                    rect4.bottom = rect4.top + this.itemH;
                    canvas2.drawRect(this.rect, this.paint32);
                }
            }
            Rect rect5 = this.rect2;
            rect5.left = (int) this.touchL;
            rect5.right = (int) this.touchR;
            rect5.top = (int) this.touchT;
            rect5.bottom = (int) this.touchB;
            canvas2.drawRect(rect5, this.paintSTROKE);
            float f = min - 6.0f;
            float f2 = min2 - 3.0f;
            float f3 = f + 20.0f;
            Canvas canvas3 = canvas;
            canvas3.drawLine(f, f2, f3, f2, this.paintSTROKE2);
            float f4 = min - 3.0f;
            float f5 = min2 - 6.0f;
            float f6 = f5 + 20.0f;
            canvas3.drawLine(f4, f5, f4, f6, this.paintSTROKE2);
            float f7 = max + 6.0f;
            float f8 = f7 - 20.0f;
            canvas3.drawLine(f8, f2, f7, f2, this.paintSTROKE2);
            float f9 = max + 3.0f;
            canvas3.drawLine(f9, f5, f9, f6, this.paintSTROKE2);
            float f10 = max2 + 3.0f;
            canvas3.drawLine(f8, f10, f7, f10, this.paintSTROKE2);
            float f11 = max2 + 6.0f;
            float f12 = f11 - 20.0f;
            canvas3.drawLine(f9, f12, f9, f11, this.paintSTROKE2);
            canvas3.drawLine(f, f10, f3, f10, this.paintSTROKE2);
            canvas3.drawLine(f4, f12, f4, f11, this.paintSTROKE2);
        }
    }
}
