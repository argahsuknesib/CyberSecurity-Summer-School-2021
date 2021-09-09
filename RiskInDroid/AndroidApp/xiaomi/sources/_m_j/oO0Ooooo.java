package _m_j;

import _m_j.oO0OoOO0;
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

public class oO0Ooooo extends oO0000o0 {
    public String O0000O0o = null;
    public int O0000OOo = 0;
    public float O0000Oo = Float.NaN;
    public int O0000Oo0 = -1;
    public float O0000OoO = 0.0f;
    public float O0000Ooo = Float.NaN;
    public float O0000o = Float.NaN;
    public float O0000o0 = Float.NaN;
    public int O0000o00 = -1;
    public float O0000o0O = Float.NaN;
    public float O0000o0o = Float.NaN;
    public float O0000oO = Float.NaN;
    public float O0000oO0 = Float.NaN;
    public float O0000oOO = Float.NaN;
    public float O0000oOo = Float.NaN;
    public float O0000oo = Float.NaN;
    public float O0000oo0 = Float.NaN;
    public float O0000ooO = Float.NaN;

    public oO0Ooooo() {
        this.O00000oO = 4;
        this.O00000oo = new HashMap();
    }

    public final void O000000o(Context context, AttributeSet attributeSet) {
        O000000o.O000000o(this, context.obtainStyledAttributes(attributeSet, new int[]{16843551, 16843554, 16843555, 16843556, 16843557, 16843558, 16843559, 16843560, 16843770, 16843840, R.attr.curveFit, R.attr.framePosition, R.attr.motionProgress, R.attr.motionTarget, R.attr.transitionEasing, R.attr.transitionPathRotate, R.attr.waveOffset, R.attr.wavePeriod, R.attr.waveShape, R.attr.waveVariesBy}));
    }

    public final void O000000o(HashSet<String> hashSet) {
        if (!Float.isNaN(this.O0000o0)) {
            hashSet.add("alpha");
        }
        if (!Float.isNaN(this.O0000o0O)) {
            hashSet.add("elevation");
        }
        if (!Float.isNaN(this.O0000o0o)) {
            hashSet.add("rotation");
        }
        if (!Float.isNaN(this.O0000oO0)) {
            hashSet.add("rotationX");
        }
        if (!Float.isNaN(this.O0000oO)) {
            hashSet.add("rotationY");
        }
        if (!Float.isNaN(this.O0000oOO)) {
            hashSet.add("scaleX");
        }
        if (!Float.isNaN(this.O0000oOo)) {
            hashSet.add("scaleY");
        }
        if (!Float.isNaN(this.O0000o)) {
            hashSet.add("transitionPathRotate");
        }
        if (!Float.isNaN(this.O0000oo0)) {
            hashSet.add("translationX");
        }
        if (!Float.isNaN(this.O0000oo)) {
            hashSet.add("translationY");
        }
        if (!Float.isNaN(this.O0000ooO)) {
            hashSet.add("translationZ");
        }
        if (this.O00000oo.size() > 0) {
            for (String valueOf : this.O00000oo.keySet()) {
                hashSet.add("CUSTOM,".concat(String.valueOf(valueOf)));
            }
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0090, code lost:
        if (r1.equals("scaleY") != false) goto L_0x00de;
     */
    public final void O00000o0(HashMap<String, oO0OoOO0> hashMap) {
        float f;
        Iterator<String> it = hashMap.keySet().iterator();
        while (it.hasNext()) {
            String next = it.next();
            char c = 7;
            if (next.startsWith("CUSTOM")) {
                ConstraintAttribute constraintAttribute = (ConstraintAttribute) this.O00000oo.get(next.substring(7));
                if (constraintAttribute != null && constraintAttribute.O00000Oo == ConstraintAttribute.AttributeType.FLOAT_TYPE) {
                    hashMap.get(next).O000000o(this.O00000Oo, this.O0000Oo0, this.O0000o00, this.O0000Oo, this.O0000OoO, constraintAttribute.O00000Oo(), constraintAttribute);
                }
            }
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
                        c = 8;
                        break;
                    }
                    c = 65535;
                    break;
                case -1225497656:
                    if (next.equals("translationY")) {
                        c = 9;
                        break;
                    }
                    c = 65535;
                    break;
                case -1225497655:
                    if (next.equals("translationZ")) {
                        c = 10;
                        break;
                    }
                    c = 65535;
                    break;
                case -1001078227:
                    if (next.equals("progress")) {
                        c = 12;
                        break;
                    }
                    c = 65535;
                    break;
                case -908189618:
                    if (next.equals("scaleX")) {
                        c = 6;
                        break;
                    }
                    c = 65535;
                    break;
                case -908189617:
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
                    if (next.equals("transitionPathRotate")) {
                        c = 5;
                        break;
                    }
                    c = 65535;
                    break;
                case 92909918:
                    if (next.equals("alpha")) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case 156108012:
                    if (next.equals("waveOffset")) {
                        c = 11;
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
                    f = this.O0000o0;
                    break;
                case 1:
                    f = this.O0000o0O;
                    break;
                case 2:
                    f = this.O0000o0o;
                    break;
                case 3:
                    f = this.O0000oO0;
                    break;
                case 4:
                    f = this.O0000oO;
                    break;
                case 5:
                    f = this.O0000o;
                    break;
                case 6:
                    f = this.O0000oOO;
                    break;
                case 7:
                    f = this.O0000oOo;
                    break;
                case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER /*8*/:
                    f = this.O0000oo0;
                    break;
                case 9:
                    f = this.O0000oo;
                    break;
                case 10:
                    f = this.O0000ooO;
                    break;
                case 11:
                    f = this.O0000OoO;
                    break;
                case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                    f = this.O0000Ooo;
                    break;
                default:
                    Log.v("WARNING! KeyCycle", "  UNKNOWN  ".concat(String.valueOf(next)));
                    f = Float.NaN;
                    break;
            }
            if (!Float.isNaN(f)) {
                oO0OoOO0 oo0oooo0 = hashMap.get(next);
                int i = this.O00000Oo;
                int i2 = this.O0000Oo0;
                int i3 = this.O0000o00;
                oo0oooo0.O00000oO.add(new oO0OoOO0.O000O0o0(i, this.O0000Oo, this.O0000OoO, f));
                if (i3 != -1) {
                    oo0oooo0.O00000o = i3;
                }
                oo0oooo0.O00000o0 = i2;
            }
        }
    }

    public final void O000000o(HashMap<String, oO0O0OoO> hashMap) {
        oO00000o.O000000o("KeyCycle", "add " + hashMap.size() + " values");
        for (String next : hashMap.keySet()) {
            oO0O0OoO oo0o0ooo = hashMap.get(next);
            char c = 65535;
            switch (next.hashCode()) {
                case -1249320806:
                    if (next.equals("rotationX")) {
                        c = 3;
                        break;
                    }
                    break;
                case -1249320805:
                    if (next.equals("rotationY")) {
                        c = 4;
                        break;
                    }
                    break;
                case -1225497657:
                    if (next.equals("translationX")) {
                        c = 8;
                        break;
                    }
                    break;
                case -1225497656:
                    if (next.equals("translationY")) {
                        c = 9;
                        break;
                    }
                    break;
                case -1225497655:
                    if (next.equals("translationZ")) {
                        c = 10;
                        break;
                    }
                    break;
                case -1001078227:
                    if (next.equals("progress")) {
                        c = 12;
                        break;
                    }
                    break;
                case -908189618:
                    if (next.equals("scaleX")) {
                        c = 6;
                        break;
                    }
                    break;
                case -908189617:
                    if (next.equals("scaleY")) {
                        c = 7;
                        break;
                    }
                    break;
                case -40300674:
                    if (next.equals("rotation")) {
                        c = 2;
                        break;
                    }
                    break;
                case -4379043:
                    if (next.equals("elevation")) {
                        c = 1;
                        break;
                    }
                    break;
                case 37232917:
                    if (next.equals("transitionPathRotate")) {
                        c = 5;
                        break;
                    }
                    break;
                case 92909918:
                    if (next.equals("alpha")) {
                        c = 0;
                        break;
                    }
                    break;
                case 156108012:
                    if (next.equals("waveOffset")) {
                        c = 11;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    oo0o0ooo.O000000o(this.O00000Oo, this.O0000o0);
                    break;
                case 1:
                    oo0o0ooo.O000000o(this.O00000Oo, this.O0000o0O);
                    break;
                case 2:
                    oo0o0ooo.O000000o(this.O00000Oo, this.O0000o0o);
                    break;
                case 3:
                    oo0o0ooo.O000000o(this.O00000Oo, this.O0000oO0);
                    break;
                case 4:
                    oo0o0ooo.O000000o(this.O00000Oo, this.O0000oO);
                    break;
                case 5:
                    oo0o0ooo.O000000o(this.O00000Oo, this.O0000o);
                    break;
                case 6:
                    oo0o0ooo.O000000o(this.O00000Oo, this.O0000oOO);
                    break;
                case 7:
                    oo0o0ooo.O000000o(this.O00000Oo, this.O0000oOo);
                    break;
                case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER /*8*/:
                    oo0o0ooo.O000000o(this.O00000Oo, this.O0000oo0);
                    break;
                case 9:
                    oo0o0ooo.O000000o(this.O00000Oo, this.O0000oo);
                    break;
                case 10:
                    oo0o0ooo.O000000o(this.O00000Oo, this.O0000ooO);
                    break;
                case 11:
                    oo0o0ooo.O000000o(this.O00000Oo, this.O0000OoO);
                    break;
                case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                    oo0o0ooo.O000000o(this.O00000Oo, this.O0000Ooo);
                    break;
                default:
                    Log.v("WARNING KeyCycle", "  UNKNOWN  ".concat(String.valueOf(next)));
                    break;
            }
        }
    }

    static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        private static SparseIntArray f2294O000000o;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f2294O000000o = sparseIntArray;
            sparseIntArray.append(13, 1);
            f2294O000000o.append(11, 2);
            f2294O000000o.append(14, 3);
            f2294O000000o.append(10, 4);
            f2294O000000o.append(18, 5);
            f2294O000000o.append(17, 6);
            f2294O000000o.append(16, 7);
            f2294O000000o.append(19, 8);
            f2294O000000o.append(0, 9);
            f2294O000000o.append(9, 10);
            f2294O000000o.append(5, 11);
            f2294O000000o.append(6, 12);
            f2294O000000o.append(7, 13);
            f2294O000000o.append(15, 14);
            f2294O000000o.append(3, 15);
            f2294O000000o.append(4, 16);
            f2294O000000o.append(1, 17);
            f2294O000000o.append(2, 18);
            f2294O000000o.append(8, 19);
            f2294O000000o.append(12, 20);
        }

        public static void O000000o(oO0Ooooo oo0ooooo, TypedArray typedArray) {
            int indexCount = typedArray.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = typedArray.getIndex(i);
                switch (f2294O000000o.get(index)) {
                    case 1:
                        if (!MotionLayout.f2778O000000o) {
                            if (typedArray.peekValue(index).type != 3) {
                                oo0ooooo.O00000o0 = typedArray.getResourceId(index, oo0ooooo.O00000o0);
                                break;
                            } else {
                                oo0ooooo.O00000o = typedArray.getString(index);
                                break;
                            }
                        } else {
                            oo0ooooo.O00000o0 = typedArray.getResourceId(index, oo0ooooo.O00000o0);
                            if (oo0ooooo.O00000o0 != -1) {
                                break;
                            } else {
                                oo0ooooo.O00000o = typedArray.getString(index);
                                break;
                            }
                        }
                    case 2:
                        oo0ooooo.O00000Oo = typedArray.getInt(index, oo0ooooo.O00000Oo);
                        break;
                    case 3:
                        oo0ooooo.O0000O0o = typedArray.getString(index);
                        break;
                    case 4:
                        oo0ooooo.O0000OOo = typedArray.getInteger(index, oo0ooooo.O0000OOo);
                        break;
                    case 5:
                        oo0ooooo.O0000Oo0 = typedArray.getInt(index, oo0ooooo.O0000Oo0);
                        break;
                    case 6:
                        oo0ooooo.O0000Oo = typedArray.getFloat(index, oo0ooooo.O0000Oo);
                        break;
                    case 7:
                        if (typedArray.peekValue(index).type != 5) {
                            oo0ooooo.O0000OoO = typedArray.getFloat(index, oo0ooooo.O0000OoO);
                            break;
                        } else {
                            oo0ooooo.O0000OoO = typedArray.getDimension(index, oo0ooooo.O0000OoO);
                            break;
                        }
                    case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER /*8*/:
                        oo0ooooo.O0000o00 = typedArray.getInt(index, oo0ooooo.O0000o00);
                        break;
                    case 9:
                        oo0ooooo.O0000o0 = typedArray.getFloat(index, oo0ooooo.O0000o0);
                        break;
                    case 10:
                        oo0ooooo.O0000o0O = typedArray.getDimension(index, oo0ooooo.O0000o0O);
                        break;
                    case 11:
                        oo0ooooo.O0000o0o = typedArray.getFloat(index, oo0ooooo.O0000o0o);
                        break;
                    case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                        oo0ooooo.O0000oO0 = typedArray.getFloat(index, oo0ooooo.O0000oO0);
                        break;
                    case 13:
                        oo0ooooo.O0000oO = typedArray.getFloat(index, oo0ooooo.O0000oO);
                        break;
                    case 14:
                        oo0ooooo.O0000o = typedArray.getFloat(index, oo0ooooo.O0000o);
                        break;
                    case GmsLogger.MAX_PII_TAG_LENGTH /*15*/:
                        oo0ooooo.O0000oOO = typedArray.getFloat(index, oo0ooooo.O0000oOO);
                        break;
                    case 16:
                        oo0ooooo.O0000oOo = typedArray.getFloat(index, oo0ooooo.O0000oOo);
                        break;
                    case 17:
                        oo0ooooo.O0000oo0 = typedArray.getDimension(index, oo0ooooo.O0000oo0);
                        break;
                    case 18:
                        oo0ooooo.O0000oo = typedArray.getDimension(index, oo0ooooo.O0000oo);
                        break;
                    case 19:
                        if (Build.VERSION.SDK_INT < 21) {
                            break;
                        } else {
                            oo0ooooo.O0000ooO = typedArray.getDimension(index, oo0ooooo.O0000ooO);
                            break;
                        }
                    case 20:
                        oo0ooooo.O0000Ooo = typedArray.getFloat(index, oo0ooooo.O0000Ooo);
                        break;
                    default:
                        Log.e("KeyCycle", "unused attribute 0x" + Integer.toHexString(index) + "   " + f2294O000000o.get(index));
                        break;
                }
            }
        }
    }
}
