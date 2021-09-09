package _m_j;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.motion.widget.MotionLayout;
import com.google.android.exoplayer2.C;
import com.xiaomi.smarthome.R;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;

public class oO000Oo0 extends oO0000o0 {
    public String O0000O0o = null;
    public int O0000OOo = f2264O000000o;
    public String O0000Oo = null;
    public String O0000Oo0 = null;
    public int O0000OoO = f2264O000000o;
    public int O0000Ooo = f2264O000000o;
    boolean O0000o = true;
    float O0000o0 = 0.1f;
    View O0000o00 = null;
    boolean O0000o0O = true;
    boolean O0000o0o = true;
    Method O0000oO;
    public float O0000oO0 = Float.NaN;
    Method O0000oOO;
    Method O0000oOo;
    public boolean O0000oo = false;
    float O0000oo0;
    RectF O0000ooO = new RectF();
    RectF O0000ooo = new RectF();
    private int O00oOooO = -1;

    public final void O000000o(HashMap<String, oO0O0OoO> hashMap) {
    }

    public final void O000000o(HashSet<String> hashSet) {
    }

    public oO000Oo0() {
        this.O00000oO = 5;
        this.O00000oo = new HashMap();
    }

    public final void O000000o(Context context, AttributeSet attributeSet) {
        O000000o.O000000o(this, context.obtainStyledAttributes(attributeSet, new int[]{R.attr.framePosition, R.attr.motionTarget, R.attr.motion_postLayoutCollision, R.attr.motion_triggerOnCollision, R.attr.onCross, R.attr.onNegativeCross, R.attr.onPositiveCross, R.attr.triggerId, R.attr.triggerReceiver, R.attr.triggerSlack}));
    }

    static void O000000o(RectF rectF, View view, boolean z) {
        rectF.top = (float) view.getTop();
        rectF.bottom = (float) view.getBottom();
        rectF.left = (float) view.getLeft();
        rectF.right = (float) view.getRight();
        if (z) {
            view.getMatrix().mapRect(rectF);
        }
    }

    static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        private static SparseIntArray f2267O000000o;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f2267O000000o = sparseIntArray;
            sparseIntArray.append(0, 8);
            f2267O000000o.append(4, 4);
            f2267O000000o.append(5, 1);
            f2267O000000o.append(6, 2);
            f2267O000000o.append(1, 7);
            f2267O000000o.append(7, 6);
            f2267O000000o.append(9, 5);
            f2267O000000o.append(3, 9);
            f2267O000000o.append(2, 10);
            f2267O000000o.append(8, 11);
        }

        public static void O000000o(oO000Oo0 oo000oo0, TypedArray typedArray) {
            int indexCount = typedArray.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = typedArray.getIndex(i);
                switch (f2267O000000o.get(index)) {
                    case 1:
                        oo000oo0.O0000Oo0 = typedArray.getString(index);
                        continue;
                    case 2:
                        oo000oo0.O0000Oo = typedArray.getString(index);
                        continue;
                    case 4:
                        oo000oo0.O0000O0o = typedArray.getString(index);
                        continue;
                    case 5:
                        oo000oo0.O0000o0 = typedArray.getFloat(index, oo000oo0.O0000o0);
                        continue;
                    case 6:
                        oo000oo0.O0000OoO = typedArray.getResourceId(index, oo000oo0.O0000OoO);
                        continue;
                    case 7:
                        if (MotionLayout.f2778O000000o) {
                            oo000oo0.O00000o0 = typedArray.getResourceId(index, oo000oo0.O00000o0);
                            if (oo000oo0.O00000o0 == -1) {
                                oo000oo0.O00000o = typedArray.getString(index);
                            } else {
                                continue;
                            }
                        } else if (typedArray.peekValue(index).type == 3) {
                            oo000oo0.O00000o = typedArray.getString(index);
                        } else {
                            oo000oo0.O00000o0 = typedArray.getResourceId(index, oo000oo0.O00000o0);
                        }
                    case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER /*8*/:
                        oo000oo0.O00000Oo = typedArray.getInteger(index, oo000oo0.O00000Oo);
                        oo000oo0.O0000oO0 = (((float) oo000oo0.O00000Oo) + 0.5f) / 100.0f;
                        continue;
                    case 9:
                        oo000oo0.O0000Ooo = typedArray.getResourceId(index, oo000oo0.O0000Ooo);
                        continue;
                    case 10:
                        oo000oo0.O0000oo = typedArray.getBoolean(index, oo000oo0.O0000oo);
                        continue;
                    case 11:
                        oo000oo0.O0000OOo = typedArray.getResourceId(index, oo000oo0.O0000OOo);
                        break;
                }
                Log.e("KeyTrigger", "unused attribute 0x" + Integer.toHexString(index) + "   " + f2267O000000o.get(index));
            }
        }
    }
}
