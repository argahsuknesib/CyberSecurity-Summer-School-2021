package _m_j;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import androidx.constraintlayout.motion.widget.MotionLayout;
import com.google.android.exoplayer2.C;
import com.xiaomi.smarthome.R;
import java.util.HashMap;
import no.nordicsemi.android.dfu.DfuSettingsConstants;

public class oO000OOO extends ooOOOOoo {
    String O0000O0o = null;
    int O0000OOo = f2264O000000o;
    float O0000Oo = Float.NaN;
    int O0000Oo0 = 0;
    float O0000OoO = Float.NaN;
    float O0000Ooo = Float.NaN;
    float O0000o0 = Float.NaN;
    float O0000o00 = Float.NaN;
    float O0000o0O = Float.NaN;
    int O0000o0o = 0;
    private float O0000oO = Float.NaN;
    private float O0000oO0 = Float.NaN;

    public final void O000000o(HashMap<String, oO0O0OoO> hashMap) {
    }

    public oO000OOO() {
        this.O00000oO = 2;
    }

    public final void O000000o(Context context, AttributeSet attributeSet) {
        O000000o.O000000o(this, context.obtainStyledAttributes(attributeSet, new int[]{R.attr.curveFit, R.attr.drawPath, R.attr.framePosition, R.attr.keyPositionType, R.attr.motionTarget, R.attr.pathMotionArc, R.attr.percentHeight, R.attr.percentWidth, R.attr.percentX, R.attr.percentY, R.attr.sizePercent, R.attr.transitionEasing}));
    }

    static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        private static SparseIntArray f2266O000000o;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f2266O000000o = sparseIntArray;
            sparseIntArray.append(4, 1);
            f2266O000000o.append(2, 2);
            f2266O000000o.append(11, 3);
            f2266O000000o.append(0, 4);
            f2266O000000o.append(1, 5);
            f2266O000000o.append(8, 6);
            f2266O000000o.append(9, 7);
            f2266O000000o.append(3, 9);
            f2266O000000o.append(10, 8);
            f2266O000000o.append(7, 11);
            f2266O000000o.append(6, 12);
            f2266O000000o.append(5, 10);
        }

        public static void O000000o(oO000OOO oo000ooo, TypedArray typedArray) {
            int indexCount = typedArray.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = typedArray.getIndex(i);
                switch (f2266O000000o.get(index)) {
                    case 1:
                        if (!MotionLayout.f2778O000000o) {
                            if (typedArray.peekValue(index).type != 3) {
                                oo000ooo.O00000o0 = typedArray.getResourceId(index, oo000ooo.O00000o0);
                                break;
                            } else {
                                oo000ooo.O00000o = typedArray.getString(index);
                                break;
                            }
                        } else {
                            oo000ooo.O00000o0 = typedArray.getResourceId(index, oo000ooo.O00000o0);
                            if (oo000ooo.O00000o0 != -1) {
                                break;
                            } else {
                                oo000ooo.O00000o = typedArray.getString(index);
                                break;
                            }
                        }
                    case 2:
                        oo000ooo.O00000Oo = typedArray.getInt(index, oo000ooo.O00000Oo);
                        break;
                    case 3:
                        if (typedArray.peekValue(index).type != 3) {
                            oo000ooo.O0000O0o = o0OO0o00.O00000o0[typedArray.getInteger(index, 0)];
                            break;
                        } else {
                            oo000ooo.O0000O0o = typedArray.getString(index);
                            break;
                        }
                    case 4:
                        oo000ooo.O0000o = typedArray.getInteger(index, oo000ooo.O0000o);
                        break;
                    case 5:
                        oo000ooo.O0000Oo0 = typedArray.getInt(index, oo000ooo.O0000Oo0);
                        break;
                    case 6:
                        oo000ooo.O0000Ooo = typedArray.getFloat(index, oo000ooo.O0000Ooo);
                        break;
                    case 7:
                        oo000ooo.O0000o00 = typedArray.getFloat(index, oo000ooo.O0000o00);
                        break;
                    case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER /*8*/:
                        float f = typedArray.getFloat(index, oo000ooo.O0000OoO);
                        oo000ooo.O0000Oo = f;
                        oo000ooo.O0000OoO = f;
                        break;
                    case 9:
                        oo000ooo.O0000o0o = typedArray.getInt(index, oo000ooo.O0000o0o);
                        break;
                    case 10:
                        oo000ooo.O0000OOo = typedArray.getInt(index, oo000ooo.O0000OOo);
                        break;
                    case 11:
                        oo000ooo.O0000Oo = typedArray.getFloat(index, oo000ooo.O0000Oo);
                        break;
                    case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                        oo000ooo.O0000OoO = typedArray.getFloat(index, oo000ooo.O0000OoO);
                        break;
                    default:
                        Log.e("KeyPosition", "unused attribute 0x" + Integer.toHexString(index) + "   " + f2266O000000o.get(index));
                        break;
                }
            }
            if (oo000ooo.O00000Oo == -1) {
                Log.e("KeyPosition", "no frame position");
            }
        }
    }
}
