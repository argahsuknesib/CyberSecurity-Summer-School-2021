package _m_j;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.Log;
import android.util.Xml;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.core.widget.NestedScrollView;
import com.xiaomi.smarthome.R;
import org.xmlpull.v1.XmlPullParser;

public final class oOo00OO0 {
    private static final float[][] O0000oo = {new float[]{0.0f, -1.0f}, new float[]{0.0f, 1.0f}, new float[]{-1.0f, 0.0f}, new float[]{1.0f, 0.0f}, new float[]{-1.0f, 0.0f}, new float[]{1.0f, 0.0f}};
    private static final float[][] O0000oo0 = {new float[]{0.5f, 0.0f}, new float[]{0.0f, 0.5f}, new float[]{1.0f, 0.5f}, new float[]{0.5f, 1.0f}, new float[]{0.5f, 0.5f}, new float[]{0.0f, 0.5f}, new float[]{1.0f, 0.5f}};

    /* renamed from: O000000o  reason: collision with root package name */
    public int f2329O000000o = 0;
    public int O00000Oo = -1;
    int O00000o = -1;
    public int O00000o0 = -1;
    public float O00000oO = 0.5f;
    public float O00000oo = 0.5f;
    public float O0000O0o = 0.0f;
    public float O0000OOo = 1.0f;
    public float[] O0000Oo = new float[2];
    public boolean O0000Oo0 = false;
    float O0000OoO;
    float O0000Ooo;
    float O0000o = 1.0f;
    float O0000o0 = 4.0f;
    public final MotionLayout O0000o00;
    float O0000o0O = 1.2f;
    public boolean O0000o0o = true;
    float O0000oO = 10.0f;
    public int O0000oO0 = 0;
    private int O0000oOO = 0;
    private int O0000oOo = 0;

    oOo00OO0(Context context, MotionLayout motionLayout, XmlPullParser xmlPullParser) {
        this.O0000o00 = motionLayout;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), new int[]{R.attr.dragDirection, R.attr.dragScale, R.attr.dragThreshold, R.attr.limitBoundsTo, R.attr.maxAcceleration, R.attr.maxVelocity, R.attr.moveWhenScrollAtTop, R.attr.nestedScrollFlags, R.attr.onTouchUp, R.attr.touchAnchorId, R.attr.touchAnchorSide, R.attr.touchRegionId});
        O000000o(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
    }

    public final void O000000o(boolean z) {
        if (z) {
            float[][] fArr = O0000oo;
            fArr[4] = fArr[3];
            fArr[5] = fArr[2];
            float[][] fArr2 = O0000oo0;
            fArr2[5] = fArr2[2];
            fArr2[6] = fArr2[1];
        } else {
            float[][] fArr3 = O0000oo;
            fArr3[4] = fArr3[2];
            fArr3[5] = fArr3[3];
            float[][] fArr4 = O0000oo0;
            fArr4[5] = fArr4[1];
            fArr4[6] = fArr4[2];
        }
        float[][] fArr5 = O0000oo0;
        int i = this.O0000oOO;
        this.O00000oo = fArr5[i][0];
        this.O00000oO = fArr5[i][1];
        float[][] fArr6 = O0000oo;
        int i2 = this.O0000oOo;
        this.O0000O0o = fArr6[i2][0];
        this.O0000OOo = fArr6[i2][1];
    }

    private void O000000o(TypedArray typedArray) {
        int indexCount = typedArray.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = typedArray.getIndex(i);
            if (index == 9) {
                this.O00000Oo = typedArray.getResourceId(index, this.O00000Oo);
            } else if (index == 10) {
                this.O0000oOO = typedArray.getInt(index, this.O0000oOO);
                float[][] fArr = O0000oo0;
                int i2 = this.O0000oOO;
                this.O00000oo = fArr[i2][0];
                this.O00000oO = fArr[i2][1];
            } else if (index == 0) {
                this.O0000oOo = typedArray.getInt(index, this.O0000oOo);
                float[][] fArr2 = O0000oo;
                int i3 = this.O0000oOo;
                this.O0000O0o = fArr2[i3][0];
                this.O0000OOo = fArr2[i3][1];
            } else if (index == 5) {
                this.O0000o0 = typedArray.getFloat(index, this.O0000o0);
            } else if (index == 4) {
                this.O0000o0O = typedArray.getFloat(index, this.O0000o0O);
            } else if (index == 6) {
                this.O0000o0o = typedArray.getBoolean(index, this.O0000o0o);
            } else if (index == 1) {
                this.O0000o = typedArray.getFloat(index, this.O0000o);
            } else if (index == 2) {
                this.O0000oO = typedArray.getFloat(index, this.O0000oO);
            } else if (index == 11) {
                this.O00000o0 = typedArray.getResourceId(index, this.O00000o0);
            } else if (index == 8) {
                this.f2329O000000o = typedArray.getInt(index, this.f2329O000000o);
            } else if (index == 7) {
                this.O0000oO0 = typedArray.getInteger(index, 0);
            } else if (index == 3) {
                this.O00000o = typedArray.getResourceId(index, 0);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void O000000o() {
        View view;
        int i = this.O00000Oo;
        if (i != -1) {
            view = this.O0000o00.findViewById(i);
            if (view == null) {
                Log.e("TouchResponse", "cannot find TouchAnchorId @id/" + oO00000o.O000000o(this.O0000o00.getContext(), this.O00000Oo));
            }
        } else {
            view = null;
        }
        if (view instanceof NestedScrollView) {
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            nestedScrollView.setOnTouchListener(new View.OnTouchListener() {
                /* class _m_j.oOo00OO0.AnonymousClass1 */

                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    return false;
                }
            });
            nestedScrollView.setOnScrollChangeListener(new NestedScrollView.O00000Oo() {
                /* class _m_j.oOo00OO0.AnonymousClass2 */

                public final void O000000o(NestedScrollView nestedScrollView) {
                }
            });
        }
    }

    public final RectF O000000o(ViewGroup viewGroup, RectF rectF) {
        View findViewById;
        int i = this.O00000o0;
        if (i == -1 || (findViewById = viewGroup.findViewById(i)) == null) {
            return null;
        }
        rectF.set((float) findViewById.getLeft(), (float) findViewById.getTop(), (float) findViewById.getRight(), (float) findViewById.getBottom());
        return rectF;
    }

    public final String toString() {
        return this.O0000O0o + " , " + this.O0000OOo;
    }
}
