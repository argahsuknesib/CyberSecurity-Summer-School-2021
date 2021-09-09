package _m_j;

import _m_j.oO0O0OoO;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.ConstraintAttribute;
import com.google.android.exoplayer2.C;
import com.google.android.gms.common.internal.GmsLogger;
import com.xiaomi.smarthome.R;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import no.nordicsemi.android.dfu.DfuSettingsConstants;

public class oO000O0O extends oO0000o0 {
    public String O0000O0o;
    public int O0000OOo = -1;
    public float O0000Oo = Float.NaN;
    public float O0000Oo0 = Float.NaN;
    public float O0000OoO = Float.NaN;
    public float O0000Ooo = Float.NaN;
    public float O0000o = Float.NaN;
    public float O0000o0 = Float.NaN;
    public float O0000o00 = Float.NaN;
    public float O0000o0O = Float.NaN;
    public float O0000o0o = Float.NaN;
    public float O0000oO = Float.NaN;
    public float O0000oO0 = Float.NaN;
    public float O0000oOO = Float.NaN;
    public float O0000oOo = Float.NaN;
    private boolean O0000oo = false;
    public float O0000oo0 = Float.NaN;

    public oO000O0O() {
        this.O00000oO = 1;
        this.O00000oo = new HashMap();
    }

    public final void O000000o(Context context, AttributeSet attributeSet) {
        O000000o.O000000o(this, context.obtainStyledAttributes(attributeSet, new int[]{16843551, 16843552, 16843553, 16843554, 16843555, 16843556, 16843557, 16843558, 16843559, 16843560, 16843770, 16843840, R.attr.curveFit, R.attr.framePosition, R.attr.motionProgress, R.attr.motionTarget, R.attr.transitionEasing, R.attr.transitionPathRotate}));
    }

    public final void O000000o(HashSet<String> hashSet) {
        if (!Float.isNaN(this.O0000Oo0)) {
            hashSet.add("alpha");
        }
        if (!Float.isNaN(this.O0000Oo)) {
            hashSet.add("elevation");
        }
        if (!Float.isNaN(this.O0000OoO)) {
            hashSet.add("rotation");
        }
        if (!Float.isNaN(this.O0000Ooo)) {
            hashSet.add("rotationX");
        }
        if (!Float.isNaN(this.O0000o00)) {
            hashSet.add("rotationY");
        }
        if (!Float.isNaN(this.O0000o0)) {
            hashSet.add("transformPivotX");
        }
        if (!Float.isNaN(this.O0000o0O)) {
            hashSet.add("transformPivotY");
        }
        if (!Float.isNaN(this.O0000oO)) {
            hashSet.add("translationX");
        }
        if (!Float.isNaN(this.O0000oOO)) {
            hashSet.add("translationY");
        }
        if (!Float.isNaN(this.O0000oOo)) {
            hashSet.add("translationZ");
        }
        if (!Float.isNaN(this.O0000o0o)) {
            hashSet.add("transitionPathRotate");
        }
        if (!Float.isNaN(this.O0000o)) {
            hashSet.add("scaleX");
        }
        if (!Float.isNaN(this.O0000o)) {
            hashSet.add("scaleY");
        }
        if (!Float.isNaN(this.O0000oo0)) {
            hashSet.add("progress");
        }
        if (this.O00000oo.size() > 0) {
            for (String valueOf : this.O00000oo.keySet()) {
                hashSet.add("CUSTOM,".concat(String.valueOf(valueOf)));
            }
        }
    }

    public final void O00000Oo(HashMap<String, Integer> hashMap) {
        if (this.O0000OOo != -1) {
            if (!Float.isNaN(this.O0000Oo0)) {
                hashMap.put("alpha", Integer.valueOf(this.O0000OOo));
            }
            if (!Float.isNaN(this.O0000Oo)) {
                hashMap.put("elevation", Integer.valueOf(this.O0000OOo));
            }
            if (!Float.isNaN(this.O0000OoO)) {
                hashMap.put("rotation", Integer.valueOf(this.O0000OOo));
            }
            if (!Float.isNaN(this.O0000Ooo)) {
                hashMap.put("rotationX", Integer.valueOf(this.O0000OOo));
            }
            if (!Float.isNaN(this.O0000o00)) {
                hashMap.put("rotationY", Integer.valueOf(this.O0000OOo));
            }
            if (!Float.isNaN(this.O0000o0)) {
                hashMap.put("transformPivotX", Integer.valueOf(this.O0000OOo));
            }
            if (!Float.isNaN(this.O0000o0O)) {
                hashMap.put("transformPivotY", Integer.valueOf(this.O0000OOo));
            }
            if (!Float.isNaN(this.O0000oO)) {
                hashMap.put("translationX", Integer.valueOf(this.O0000OOo));
            }
            if (!Float.isNaN(this.O0000oOO)) {
                hashMap.put("translationY", Integer.valueOf(this.O0000OOo));
            }
            if (!Float.isNaN(this.O0000oOo)) {
                hashMap.put("translationZ", Integer.valueOf(this.O0000OOo));
            }
            if (!Float.isNaN(this.O0000o0o)) {
                hashMap.put("transitionPathRotate", Integer.valueOf(this.O0000OOo));
            }
            if (!Float.isNaN(this.O0000o)) {
                hashMap.put("scaleX", Integer.valueOf(this.O0000OOo));
            }
            if (!Float.isNaN(this.O0000oO0)) {
                hashMap.put("scaleY", Integer.valueOf(this.O0000OOo));
            }
            if (!Float.isNaN(this.O0000oo0)) {
                hashMap.put("progress", Integer.valueOf(this.O0000OOo));
            }
            if (this.O00000oo.size() > 0) {
                for (String valueOf : this.O00000oo.keySet()) {
                    hashMap.put("CUSTOM,".concat(String.valueOf(valueOf)), Integer.valueOf(this.O0000OOo));
                }
            }
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0054, code lost:
        if (r1.equals("transitionPathRotate") != false) goto L_0x00d9;
     */
    public final void O000000o(HashMap<String, oO0O0OoO> hashMap) {
        Iterator<String> it = hashMap.keySet().iterator();
        while (it.hasNext()) {
            String next = it.next();
            oO0O0OoO oo0o0ooo = hashMap.get(next);
            char c = 7;
            if (next.startsWith("CUSTOM")) {
                ConstraintAttribute constraintAttribute = (ConstraintAttribute) this.O00000oo.get(next.substring(7));
                if (constraintAttribute != null) {
                    ((oO0O0OoO.O00000Oo) oo0o0ooo).O000000o(this.O00000Oo, constraintAttribute);
                }
            } else {
                switch (next.hashCode()) {
                    case -1249320806:
                        if (next.equals("rotationX")) {
                            c = 3;
                            break;
                        }
                        c = 65535;
                        break;
                    case -1249320805:
                        if (next.equals("rotationY")) {
                            c = 4;
                            break;
                        }
                        c = 65535;
                        break;
                    case -1225497657:
                        if (next.equals("translationX")) {
                            c = 10;
                            break;
                        }
                        c = 65535;
                        break;
                    case -1225497656:
                        if (next.equals("translationY")) {
                            c = 11;
                            break;
                        }
                        c = 65535;
                        break;
                    case -1225497655:
                        if (next.equals("translationZ")) {
                            c = 12;
                            break;
                        }
                        c = 65535;
                        break;
                    case -1001078227:
                        if (next.equals("progress")) {
                            c = 13;
                            break;
                        }
                        c = 65535;
                        break;
                    case -908189618:
                        if (next.equals("scaleX")) {
                            c = 8;
                            break;
                        }
                        c = 65535;
                        break;
                    case -908189617:
                        if (next.equals("scaleY")) {
                            c = 9;
                            break;
                        }
                        c = 65535;
                        break;
                    case -760884510:
                        if (next.equals("transformPivotX")) {
                            c = 5;
                            break;
                        }
                        c = 65535;
                        break;
                    case -760884509:
                        if (next.equals("transformPivotY")) {
                            c = 6;
                            break;
                        }
                        c = 65535;
                        break;
                    case -40300674:
                        if (next.equals("rotation")) {
                            c = 2;
                            break;
                        }
                        c = 65535;
                        break;
                    case -4379043:
                        if (next.equals("elevation")) {
                            c = 1;
                            break;
                        }
                        c = 65535;
                        break;
                    case 37232917:
                        break;
                    case 92909918:
                        if (next.equals("alpha")) {
                            c = 0;
                            break;
                        }
                        c = 65535;
                        break;
                    default:
                        c = 65535;
                        break;
                }
                switch (c) {
                    case 0:
                        if (!Float.isNaN(this.O0000Oo0)) {
                            oo0o0ooo.O000000o(this.O00000Oo, this.O0000Oo0);
                            break;
                        } else {
                            continue;
                        }
                    case 1:
                        if (!Float.isNaN(this.O0000Oo)) {
                            oo0o0ooo.O000000o(this.O00000Oo, this.O0000Oo);
                            break;
                        } else {
                            continue;
                        }
                    case 2:
                        if (!Float.isNaN(this.O0000OoO)) {
                            oo0o0ooo.O000000o(this.O00000Oo, this.O0000OoO);
                            break;
                        } else {
                            continue;
                        }
                    case 3:
                        if (!Float.isNaN(this.O0000Ooo)) {
                            oo0o0ooo.O000000o(this.O00000Oo, this.O0000Ooo);
                            break;
                        } else {
                            continue;
                        }
                    case 4:
                        if (!Float.isNaN(this.O0000o00)) {
                            oo0o0ooo.O000000o(this.O00000Oo, this.O0000o00);
                            break;
                        } else {
                            continue;
                        }
                    case 5:
                        if (!Float.isNaN(this.O0000Ooo)) {
                            oo0o0ooo.O000000o(this.O00000Oo, this.O0000o0);
                            break;
                        } else {
                            continue;
                        }
                    case 6:
                        if (!Float.isNaN(this.O0000o00)) {
                            oo0o0ooo.O000000o(this.O00000Oo, this.O0000o0O);
                            break;
                        } else {
                            continue;
                        }
                    case 7:
                        if (!Float.isNaN(this.O0000o0o)) {
                            oo0o0ooo.O000000o(this.O00000Oo, this.O0000o0o);
                            break;
                        } else {
                            continue;
                        }
                    case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER /*8*/:
                        if (!Float.isNaN(this.O0000o)) {
                            oo0o0ooo.O000000o(this.O00000Oo, this.O0000o);
                            break;
                        } else {
                            continue;
                        }
                    case 9:
                        if (!Float.isNaN(this.O0000oO0)) {
                            oo0o0ooo.O000000o(this.O00000Oo, this.O0000oO0);
                            break;
                        } else {
                            continue;
                        }
                    case 10:
                        if (!Float.isNaN(this.O0000oO)) {
                            oo0o0ooo.O000000o(this.O00000Oo, this.O0000oO);
                            break;
                        } else {
                            continue;
                        }
                    case 11:
                        if (!Float.isNaN(this.O0000oOO)) {
                            oo0o0ooo.O000000o(this.O00000Oo, this.O0000oOO);
                            break;
                        } else {
                            continue;
                        }
                    case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                        if (!Float.isNaN(this.O0000oOo)) {
                            oo0o0ooo.O000000o(this.O00000Oo, this.O0000oOo);
                            break;
                        } else {
                            continue;
                        }
                    case 13:
                        if (!Float.isNaN(this.O0000oo0)) {
                            oo0o0ooo.O000000o(this.O00000Oo, this.O0000oo0);
                            break;
                        } else {
                            continue;
                        }
                    default:
                        Log.v("KeyAttributes", "UNKNOWN addValues \"" + next + jdn.f1779O000000o);
                        continue;
                }
            }
        }
    }

    static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        private static SparseIntArray f2265O000000o;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f2265O000000o = sparseIntArray;
            sparseIntArray.append(0, 1);
            f2265O000000o.append(11, 2);
            f2265O000000o.append(7, 4);
            f2265O000000o.append(8, 5);
            f2265O000000o.append(9, 6);
            f2265O000000o.append(1, 19);
            f2265O000000o.append(2, 20);
            f2265O000000o.append(5, 7);
            f2265O000000o.append(17, 8);
            f2265O000000o.append(16, 9);
            f2265O000000o.append(15, 10);
            f2265O000000o.append(13, 12);
            f2265O000000o.append(12, 13);
            f2265O000000o.append(6, 14);
            f2265O000000o.append(3, 15);
            f2265O000000o.append(4, 16);
            f2265O000000o.append(10, 17);
            f2265O000000o.append(14, 18);
        }

        public static void O000000o(oO000O0O oo000o0o, TypedArray typedArray) {
            int indexCount = typedArray.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = typedArray.getIndex(i);
                switch (f2265O000000o.get(index)) {
                    case 1:
                        oo000o0o.O0000Oo0 = typedArray.getFloat(index, oo000o0o.O0000Oo0);
                        break;
                    case 2:
                        oo000o0o.O0000Oo = typedArray.getDimension(index, oo000o0o.O0000Oo);
                        break;
                    case 3:
                    case 11:
                    default:
                        Log.e("KeyAttribute", "unused attribute 0x" + Integer.toHexString(index) + "   " + f2265O000000o.get(index));
                        break;
                    case 4:
                        oo000o0o.O0000OoO = typedArray.getFloat(index, oo000o0o.O0000OoO);
                        break;
                    case 5:
                        oo000o0o.O0000Ooo = typedArray.getFloat(index, oo000o0o.O0000Ooo);
                        break;
                    case 6:
                        oo000o0o.O0000o00 = typedArray.getFloat(index, oo000o0o.O0000o00);
                        break;
                    case 7:
                        oo000o0o.O0000o = typedArray.getFloat(index, oo000o0o.O0000o);
                        break;
                    case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER /*8*/:
                        oo000o0o.O0000o0o = typedArray.getFloat(index, oo000o0o.O0000o0o);
                        break;
                    case 9:
                        oo000o0o.O0000O0o = typedArray.getString(index);
                        break;
                    case 10:
                        if (!MotionLayout.f2778O000000o) {
                            if (typedArray.peekValue(index).type != 3) {
                                oo000o0o.O00000o0 = typedArray.getResourceId(index, oo000o0o.O00000o0);
                                break;
                            } else {
                                oo000o0o.O00000o = typedArray.getString(index);
                                break;
                            }
                        } else {
                            oo000o0o.O00000o0 = typedArray.getResourceId(index, oo000o0o.O00000o0);
                            if (oo000o0o.O00000o0 != -1) {
                                break;
                            } else {
                                oo000o0o.O00000o = typedArray.getString(index);
                                break;
                            }
                        }
                    case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                        oo000o0o.O00000Oo = typedArray.getInt(index, oo000o0o.O00000Oo);
                        break;
                    case 13:
                        oo000o0o.O0000OOo = typedArray.getInteger(index, oo000o0o.O0000OOo);
                        break;
                    case 14:
                        oo000o0o.O0000oO0 = typedArray.getFloat(index, oo000o0o.O0000oO0);
                        break;
                    case GmsLogger.MAX_PII_TAG_LENGTH /*15*/:
                        oo000o0o.O0000oO = typedArray.getDimension(index, oo000o0o.O0000oO);
                        break;
                    case 16:
                        oo000o0o.O0000oOO = typedArray.getDimension(index, oo000o0o.O0000oOO);
                        break;
                    case 17:
                        if (Build.VERSION.SDK_INT < 21) {
                            break;
                        } else {
                            oo000o0o.O0000oOo = typedArray.getDimension(index, oo000o0o.O0000oOo);
                            break;
                        }
                    case 18:
                        oo000o0o.O0000oo0 = typedArray.getFloat(index, oo000o0o.O0000oo0);
                        break;
                    case 19:
                        oo000o0o.O0000o0 = typedArray.getDimension(index, oo000o0o.O0000o0);
                        break;
                    case 20:
                        oo000o0o.O0000o0O = typedArray.getDimension(index, oo000o0o.O0000o0O);
                        break;
                }
            }
        }
    }
}
