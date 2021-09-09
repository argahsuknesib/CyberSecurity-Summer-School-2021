package com.xiaomi.smarthome.library.common.widget.crop;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.library.common.widget.crop.HighlightView;
import java.util.ArrayList;
import java.util.Iterator;

public class CropImageView extends ImageViewTouchBase {
    private Context mContext;
    ArrayList<HighlightView> mHighlightViews = new ArrayList<>();
    float mLastX;
    float mLastY;
    int mMotionEdge;
    HighlightView mMotionHighlightView = null;

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2 - 96, i3, i4 - 96);
        if (this.mBitmapDisplayed.f18174O000000o != null) {
            Iterator<HighlightView> it = this.mHighlightViews.iterator();
            while (it.hasNext()) {
                HighlightView next = it.next();
                next.O0000OOo.set(getImageMatrix());
                next.O00000o0();
                if (next.O00000Oo) {
                    centerBasedOnHighlightView(next);
                }
            }
        }
    }

    @SuppressLint({"WrongCall"})
    public void setTopMargine(int i) {
        onLayout(false, this.mLeft, this.mTop - i, this.mRight, this.mTop - i);
    }

    public CropImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
    }

    /* access modifiers changed from: protected */
    public void zoomTo(float f, float f2, float f3) {
        super.zoomTo(f, f2, f3);
        Iterator<HighlightView> it = this.mHighlightViews.iterator();
        while (it.hasNext()) {
            HighlightView next = it.next();
            next.O0000OOo.set(getImageMatrix());
            next.O00000o0();
        }
    }

    /* access modifiers changed from: protected */
    public void zoomIn() {
        super.zoomIn();
        Iterator<HighlightView> it = this.mHighlightViews.iterator();
        while (it.hasNext()) {
            HighlightView next = it.next();
            next.O0000OOo.set(getImageMatrix());
            next.O00000o0();
        }
    }

    /* access modifiers changed from: protected */
    public void zoomOut() {
        super.zoomOut();
        Iterator<HighlightView> it = this.mHighlightViews.iterator();
        while (it.hasNext()) {
            HighlightView next = it.next();
            next.O0000OOo.set(getImageMatrix());
            next.O00000o0();
        }
    }

    /* access modifiers changed from: protected */
    public void postTranslate(float f, float f2) {
        super.postTranslate(f, f2);
        for (int i = 0; i < this.mHighlightViews.size(); i++) {
            HighlightView highlightView = this.mHighlightViews.get(i);
            highlightView.O0000OOo.postTranslate(f, f2);
            highlightView.O00000o0();
        }
    }

    private void recomputeFocus(MotionEvent motionEvent) {
        int i = 0;
        for (int i2 = 0; i2 < this.mHighlightViews.size(); i2++) {
            HighlightView highlightView = this.mHighlightViews.get(i2);
            highlightView.O00000Oo = false;
            highlightView.O00000o0();
        }
        while (true) {
            if (i >= this.mHighlightViews.size()) {
                break;
            }
            HighlightView highlightView2 = this.mHighlightViews.get(i);
            int O000000o2 = highlightView2.O000000o(motionEvent.getX(), motionEvent.getY());
            highlightView2.O00000o = O000000o2;
            if (O000000o2 == 1) {
                i++;
            } else if (!highlightView2.O00000Oo) {
                highlightView2.O00000Oo = true;
                highlightView2.O00000o0();
            }
        }
        invalidate();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.Math.min(float, float):float}
     arg types: [int, float]
     candidates:
      ClspMth{java.lang.Math.min(double, double):double}
      ClspMth{java.lang.Math.min(long, long):long}
      ClspMth{java.lang.Math.min(int, int):int}
      ClspMth{java.lang.Math.min(float, float):float} */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.Math.max(float, float):float}
     arg types: [int, float]
     candidates:
      ClspMth{java.lang.Math.max(double, double):double}
      ClspMth{java.lang.Math.max(int, int):int}
      ClspMth{java.lang.Math.max(long, long):long}
      ClspMth{java.lang.Math.max(float, float):float} */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x0251  */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x025a  */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x0263  */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x026c  */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        float f;
        float f2;
        CropImageActivity cropImageActivity = (CropImageActivity) this.mContext;
        int i = 0;
        if (cropImageActivity.O00000o) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 1) {
                if (cropImageActivity.O00000o0) {
                    for (int i2 = 0; i2 < this.mHighlightViews.size(); i2++) {
                        HighlightView highlightView = this.mHighlightViews.get(i2);
                        if (highlightView.O00000Oo) {
                            cropImageActivity.O00000oO = highlightView;
                            for (int i3 = 0; i3 < this.mHighlightViews.size(); i3++) {
                                if (i3 != i2) {
                                    this.mHighlightViews.get(i3).O00000o0 = true;
                                }
                            }
                            centerBasedOnHighlightView(highlightView);
                            ((CropImageActivity) this.mContext).O00000o0 = false;
                            return true;
                        }
                    }
                } else {
                    HighlightView highlightView2 = this.mMotionHighlightView;
                    if (highlightView2 != null) {
                        centerBasedOnHighlightView(highlightView2);
                        this.mMotionHighlightView.O000000o(HighlightView.ModifyMode.None);
                    }
                }
                this.mMotionHighlightView = null;
            } else if (action == 2) {
                if (cropImageActivity.O00000o0) {
                    recomputeFocus(motionEvent);
                } else {
                    HighlightView highlightView3 = this.mMotionHighlightView;
                    if (highlightView3 != null) {
                        int i4 = this.mMotionEdge;
                        float x = motionEvent.getX() - this.mLastX;
                        float y = motionEvent.getY() - this.mLastY;
                        Rect O00000Oo = highlightView3.O00000Oo();
                        if (i4 != 1) {
                            if (i4 == 32) {
                                float width = x * (highlightView3.O0000O0o.width() / ((float) O00000Oo.width()));
                                float height = y * (highlightView3.O0000O0o.height() / ((float) O00000Oo.height()));
                                Rect rect = new Rect(highlightView3.O00000oO);
                                if (highlightView3.O0000O0o.left + width < highlightView3.O00000oo.left) {
                                    width = highlightView3.O00000oo.left - highlightView3.O0000O0o.left;
                                }
                                if (highlightView3.O0000O0o.right + width > highlightView3.O00000oo.right) {
                                    width = highlightView3.O00000oo.right - highlightView3.O0000O0o.right;
                                }
                                if (highlightView3.O0000O0o.top + height < highlightView3.O00000oo.top) {
                                    height = highlightView3.O00000oo.top - highlightView3.O0000O0o.top;
                                }
                                if (highlightView3.O0000O0o.bottom + height > highlightView3.O00000oo.bottom) {
                                    height = highlightView3.O00000oo.bottom - highlightView3.O0000O0o.bottom;
                                }
                                highlightView3.O0000O0o.offset(width, height);
                                highlightView3.O00000oO = highlightView3.O00000Oo();
                                rect.union(highlightView3.O00000oO);
                                rect.inset(-10, -10);
                                highlightView3.f9308O000000o.invalidate(rect);
                            } else {
                                float width2 = x * (highlightView3.O0000O0o.width() / ((float) O00000Oo.width()));
                                float height2 = y * (highlightView3.O0000O0o.height() / ((float) O00000Oo.height()));
                                int i5 = -1;
                                float f3 = ((float) ((i4 & 64) != 0 ? -1 : 1)) * width2;
                                if ((i4 & 256) == 0) {
                                    i5 = 1;
                                }
                                float f4 = ((float) i5) * height2;
                                if (highlightView3.O0000Oo0) {
                                    if ((i4 & 192) != 0) {
                                        f4 = f3 / highlightView3.O0000Oo;
                                    } else if ((i4 & 768) != 0) {
                                        f3 = highlightView3.O0000Oo * f4;
                                    }
                                }
                                RectF rectF = new RectF(highlightView3.O0000O0o);
                                if (f3 <= 0.0f || f4 <= 0.0f) {
                                    if (f3 < 0.0f && f4 < 0.0f) {
                                        float f5 = -1.0E12f;
                                        if ((i4 & 4) != 0 && rectF.right + f3 < rectF.left + 15.0f) {
                                            f5 = Math.max(-1.0E12f, (rectF.left - rectF.right) + 15.0f);
                                        }
                                        if ((i4 & 2) != 0 && rectF.left - f3 > rectF.right - 15.0f) {
                                            f5 = Math.max(f5, (rectF.left - rectF.right) + 15.0f);
                                        }
                                        if ((i4 & 8) != 0 && rectF.top - f4 > rectF.bottom - 15.0f) {
                                            f5 = Math.max(f5, (rectF.top - rectF.bottom) + 15.0f);
                                        }
                                        if ((i4 & 16) != 0 && rectF.bottom + f4 < rectF.top + 15.0f) {
                                            f5 = Math.max(f5, (rectF.top - rectF.bottom) + 15.0f);
                                        }
                                        if ((i4 & 192) != 0) {
                                            f3 = Math.max(f3, f5);
                                            if (highlightView3.O0000Oo0) {
                                                f2 = highlightView3.O0000Oo;
                                            }
                                        } else if ((i4 & 768) != 0) {
                                            f4 = Math.max(f4, f5);
                                            if (highlightView3.O0000Oo0) {
                                                f = highlightView3.O0000Oo;
                                                f3 = f * f4;
                                            }
                                        }
                                    }
                                    if ((i4 & 4) != 0) {
                                        rectF.right += f3;
                                    }
                                    if ((i4 & 2) != 0) {
                                        rectF.left -= f3;
                                    }
                                    if ((i4 & 8) != 0) {
                                        rectF.top -= f4;
                                    }
                                    if ((i4 & 16) != 0) {
                                        rectF.bottom += f4;
                                    }
                                    highlightView3.O0000O0o.set(rectF);
                                    highlightView3.O00000oO = highlightView3.O00000Oo();
                                    highlightView3.f9308O000000o.invalidate();
                                } else {
                                    float f6 = Float.MAX_VALUE;
                                    if ((i4 & 4) != 0 && rectF.right + f3 > highlightView3.O00000oo.right) {
                                        f6 = Math.min(Float.MAX_VALUE, highlightView3.O00000oo.right - rectF.right);
                                    }
                                    if ((i4 & 2) != 0 && rectF.left - f3 < highlightView3.O00000oo.left) {
                                        f6 = Math.min(f6, highlightView3.O00000oo.left - highlightView3.O00000oo.left);
                                    }
                                    if ((i4 & 8) != 0 && rectF.top - f4 < highlightView3.O00000oo.top) {
                                        f6 = Math.min(f6, highlightView3.O00000oo.top - highlightView3.O00000oo.top);
                                    }
                                    if ((i4 & 16) != 0 && rectF.bottom + f4 > highlightView3.O00000oo.bottom) {
                                        f6 = Math.min(f6, highlightView3.O00000oo.bottom - rectF.bottom);
                                    }
                                    if ((i4 & 192) != 0) {
                                        f3 = Math.min(f3, f6);
                                        if (highlightView3.O0000Oo0) {
                                            f2 = highlightView3.O0000Oo;
                                        }
                                    } else if ((i4 & 768) != 0) {
                                        f4 = Math.min(f4, f6);
                                        if (highlightView3.O0000Oo0) {
                                            f = highlightView3.O0000Oo;
                                            f3 = f * f4;
                                        }
                                    }
                                    if ((i4 & 4) != 0) {
                                    }
                                    if ((i4 & 2) != 0) {
                                    }
                                    if ((i4 & 8) != 0) {
                                    }
                                    if ((i4 & 16) != 0) {
                                    }
                                    highlightView3.O0000O0o.set(rectF);
                                    highlightView3.O00000oO = highlightView3.O00000Oo();
                                    highlightView3.f9308O000000o.invalidate();
                                }
                                f4 = f3 / f2;
                                if ((i4 & 4) != 0) {
                                }
                                if ((i4 & 2) != 0) {
                                }
                                if ((i4 & 8) != 0) {
                                }
                                if ((i4 & 16) != 0) {
                                }
                                highlightView3.O0000O0o.set(rectF);
                                highlightView3.O00000oO = highlightView3.O00000Oo();
                                highlightView3.f9308O000000o.invalidate();
                            }
                        }
                        this.mLastX = motionEvent.getX();
                        this.mLastY = motionEvent.getY();
                        cropImageActivity.O00000Oo.invalidate();
                    }
                }
            }
        } else if (cropImageActivity.O00000o0) {
            recomputeFocus(motionEvent);
        } else {
            while (true) {
                if (i >= this.mHighlightViews.size()) {
                    break;
                }
                HighlightView highlightView4 = this.mHighlightViews.get(i);
                int O000000o2 = highlightView4.O000000o(motionEvent.getX(), motionEvent.getY());
                if (O000000o2 != 1) {
                    this.mMotionEdge = O000000o2;
                    this.mMotionHighlightView = highlightView4;
                    this.mLastX = motionEvent.getX();
                    this.mLastY = motionEvent.getY();
                    this.mMotionHighlightView.O000000o(O000000o2 == 32 ? HighlightView.ModifyMode.Move : HighlightView.ModifyMode.Grow);
                    this.mMotionHighlightView.O00000o = O000000o2;
                } else {
                    i++;
                }
            }
        }
        int action2 = motionEvent.getAction();
        if (action2 == 1) {
            center(true, true);
        } else if (action2 == 2 && getScale() == 1.0f) {
            center(true, true);
        }
        return true;
    }

    private void ensureVisible(HighlightView highlightView) {
        Rect rect = highlightView.O00000oO;
        int max = Math.max(0, this.mLeft - rect.left);
        int min = Math.min(0, this.mRight - rect.right);
        int max2 = Math.max(0, this.mTop - rect.top);
        int min2 = Math.min(0, this.mBottom - rect.bottom);
        if (max == 0) {
            max = min;
        }
        if (max2 != 0) {
            min2 = max2;
        }
        if (max != 0 || min2 != 0) {
            panBy((float) max, (float) min2);
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.Math.max(float, float):float}
     arg types: [int, float]
     candidates:
      ClspMth{java.lang.Math.max(double, double):double}
      ClspMth{java.lang.Math.max(int, int):int}
      ClspMth{java.lang.Math.max(long, long):long}
      ClspMth{java.lang.Math.max(float, float):float} */
    private void centerBasedOnHighlightView(HighlightView highlightView) {
        Rect rect = highlightView.O00000oO;
        float max = Math.max(1.0f, Math.min((((float) getWidth()) / ((float) rect.width())) * 0.6f, (((float) getHeight()) / ((float) rect.height())) * 0.6f) * getScale());
        if (((double) (Math.abs(max - getScale()) / max)) > 0.1d) {
            float[] fArr = {highlightView.O0000O0o.centerX(), highlightView.O0000O0o.centerY()};
            getImageMatrix().mapPoints(fArr);
            zoomTo(max, fArr[0], fArr[1], 300.0f);
        }
        ensureVisible(highlightView);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (int i = 0; i < this.mHighlightViews.size(); i++) {
            HighlightView highlightView = this.mHighlightViews.get(i);
            if (!highlightView.O00000o0) {
                Path path = new Path();
                if (!highlightView.O00000Oo) {
                    highlightView.O0000o0.setColor(highlightView.f9308O000000o.getResources().getColor(R.color.mj_color_white_100_transparent));
                    canvas.drawRect(highlightView.O00000oO, highlightView.O0000o0);
                    highlightView.O000000o(canvas);
                } else {
                    Rect rect = new Rect();
                    highlightView.f9308O000000o.getDrawingRect(rect);
                    if (highlightView.O0000OoO) {
                        canvas.save();
                        float width = ((float) highlightView.O00000oO.width()) / 2.0f;
                        path.addCircle(((float) highlightView.O00000oO.left) + width, ((float) highlightView.O00000oO.top) + (((float) highlightView.O00000oO.height()) / 2.0f), width, Path.Direction.CW);
                        highlightView.O0000o0.setColor(highlightView.f9308O000000o.getResources().getColor(R.color.mj_color_white_100_transparent));
                        canvas.clipPath(path, Region.Op.DIFFERENCE);
                        canvas.drawRect(rect, highlightView.O00000Oo ? highlightView.O0000Ooo : highlightView.O0000o00);
                        canvas.restore();
                    } else {
                        Rect rect2 = new Rect(rect.left, rect.top, rect.right, highlightView.O00000oO.top);
                        if (rect2.width() > 0 && rect2.height() > 0) {
                            canvas.drawRect(rect2, highlightView.O00000Oo ? highlightView.O0000Ooo : highlightView.O0000o00);
                        }
                        Rect rect3 = new Rect(rect.left, highlightView.O00000oO.bottom, rect.right, rect.bottom);
                        if (rect3.width() > 0 && rect3.height() > 0) {
                            canvas.drawRect(rect3, highlightView.O00000Oo ? highlightView.O0000Ooo : highlightView.O0000o00);
                        }
                        Rect rect4 = new Rect(rect.left, rect2.bottom, highlightView.O00000oO.left, rect3.top);
                        if (rect4.width() > 0 && rect4.height() > 0) {
                            canvas.drawRect(rect4, highlightView.O00000Oo ? highlightView.O0000Ooo : highlightView.O0000o00);
                        }
                        Rect rect5 = new Rect(highlightView.O00000oO.right, rect2.bottom, rect.right, rect3.top);
                        if (rect5.width() > 0 && rect5.height() > 0) {
                            canvas.drawRect(rect5, highlightView.O00000Oo ? highlightView.O0000Ooo : highlightView.O0000o00);
                        }
                        path.addRect(new RectF(highlightView.O00000oO), Path.Direction.CW);
                        highlightView.O0000o0.setColor(highlightView.f9308O000000o.getResources().getColor(R.color.mj_color_white_100_transparent));
                    }
                    canvas.drawPath(path, highlightView.O0000o0);
                    highlightView.O000000o(canvas);
                }
            }
        }
    }

    public void add(HighlightView highlightView) {
        this.mHighlightViews.add(highlightView);
        invalidate();
    }
}
