package _m_j;

import _m_j.oO0O0OoO;
import _m_j.oOO0OOo0;
import android.util.Log;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.widget.ConstraintAttribute;
import com.google.android.exoplayer2.C;
import java.util.HashMap;
import java.util.LinkedHashMap;
import no.nordicsemi.android.dfu.DfuSettingsConstants;

public final class oO000o00 implements Comparable<oO000o00> {
    static String[] O0000oO0 = {"position", "x", "y", "width", "height", "pathRotate"};

    /* renamed from: O000000o  reason: collision with root package name */
    public float f2268O000000o = 1.0f;
    int O00000Oo = 0;
    public boolean O00000o = false;
    public int O00000o0;
    public float O00000oO = 0.0f;
    public float O00000oo = 0.0f;
    public float O0000O0o = 0.0f;
    public float O0000OOo = 0.0f;
    public float O0000Oo = 1.0f;
    public float O0000Oo0 = 1.0f;
    public float O0000OoO = Float.NaN;
    public float O0000Ooo = Float.NaN;
    float O0000o = Float.NaN;
    public float O0000o0 = 0.0f;
    public float O0000o00 = 0.0f;
    public float O0000o0O = 0.0f;
    float O0000o0o = Float.NaN;
    LinkedHashMap<String, ConstraintAttribute> O0000oO = new LinkedHashMap<>();
    int O0000oOO = 0;
    double[] O0000oOo = new double[18];
    private o0OO0o00 O0000oo;
    double[] O0000oo0 = new double[18];
    private int O0000ooO = 0;
    private float O0000ooo;
    private float O000O00o;
    private float O000O0OO;
    private float O00oOooO;
    private float O00oOooo;

    public final /* synthetic */ int compareTo(Object obj) {
        return Float.compare(this.O0000ooo, ((oO000o00) obj).O0000ooo);
    }

    static boolean O000000o(float f, float f2) {
        return (Float.isNaN(f) || Float.isNaN(f2)) ? Float.isNaN(f) != Float.isNaN(f2) : Math.abs(f - f2) > 1.0E-6f;
    }

    public final void O000000o(float f, float f2, float f3, float f4) {
        this.O00oOooO = f;
        this.O00oOooo = f2;
        this.O000O00o = f3;
        this.O000O0OO = f4;
    }

    public final void O000000o(HashMap<String, oO0O0OoO> hashMap, int i) {
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
                        c = 11;
                        break;
                    }
                    break;
                case -1225497656:
                    if (next.equals("translationY")) {
                        c = 12;
                        break;
                    }
                    break;
                case -1225497655:
                    if (next.equals("translationZ")) {
                        c = 13;
                        break;
                    }
                    break;
                case -1001078227:
                    if (next.equals("progress")) {
                        c = 8;
                        break;
                    }
                    break;
                case -908189618:
                    if (next.equals("scaleX")) {
                        c = 9;
                        break;
                    }
                    break;
                case -908189617:
                    if (next.equals("scaleY")) {
                        c = 10;
                        break;
                    }
                    break;
                case -760884510:
                    if (next.equals("transformPivotX")) {
                        c = 5;
                        break;
                    }
                    break;
                case -760884509:
                    if (next.equals("transformPivotY")) {
                        c = 6;
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
                        c = 7;
                        break;
                    }
                    break;
                case 92909918:
                    if (next.equals("alpha")) {
                        c = 0;
                        break;
                    }
                    break;
            }
            float f = 1.0f;
            float f2 = 0.0f;
            switch (c) {
                case 0:
                    if (!Float.isNaN(this.f2268O000000o)) {
                        f = this.f2268O000000o;
                    }
                    oo0o0ooo.O000000o(i, f);
                    break;
                case 1:
                    if (!Float.isNaN(this.O00000oO)) {
                        f2 = this.O00000oO;
                    }
                    oo0o0ooo.O000000o(i, f2);
                    break;
                case 2:
                    if (!Float.isNaN(this.O00000oo)) {
                        f2 = this.O00000oo;
                    }
                    oo0o0ooo.O000000o(i, f2);
                    break;
                case 3:
                    if (!Float.isNaN(this.O0000O0o)) {
                        f2 = this.O0000O0o;
                    }
                    oo0o0ooo.O000000o(i, f2);
                    break;
                case 4:
                    if (!Float.isNaN(this.O0000OOo)) {
                        f2 = this.O0000OOo;
                    }
                    oo0o0ooo.O000000o(i, f2);
                    break;
                case 5:
                    if (!Float.isNaN(this.O0000OoO)) {
                        f2 = this.O0000OoO;
                    }
                    oo0o0ooo.O000000o(i, f2);
                    break;
                case 6:
                    if (!Float.isNaN(this.O0000Ooo)) {
                        f2 = this.O0000Ooo;
                    }
                    oo0o0ooo.O000000o(i, f2);
                    break;
                case 7:
                    if (!Float.isNaN(this.O0000o0o)) {
                        f2 = this.O0000o0o;
                    }
                    oo0o0ooo.O000000o(i, f2);
                    break;
                case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER /*8*/:
                    if (!Float.isNaN(this.O0000o)) {
                        f2 = this.O0000o;
                    }
                    oo0o0ooo.O000000o(i, f2);
                    break;
                case 9:
                    if (!Float.isNaN(this.O0000Oo0)) {
                        f = this.O0000Oo0;
                    }
                    oo0o0ooo.O000000o(i, f);
                    break;
                case 10:
                    if (!Float.isNaN(this.O0000Oo)) {
                        f = this.O0000Oo;
                    }
                    oo0o0ooo.O000000o(i, f);
                    break;
                case 11:
                    if (!Float.isNaN(this.O0000o00)) {
                        f2 = this.O0000o00;
                    }
                    oo0o0ooo.O000000o(i, f2);
                    break;
                case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                    if (!Float.isNaN(this.O0000o0)) {
                        f2 = this.O0000o0;
                    }
                    oo0o0ooo.O000000o(i, f2);
                    break;
                case 13:
                    if (!Float.isNaN(this.O0000o0O)) {
                        f2 = this.O0000o0O;
                    }
                    oo0o0ooo.O000000o(i, f2);
                    break;
                default:
                    if (!next.startsWith("CUSTOM")) {
                        Log.e("MotionPaths", "UNKNOWN spline ".concat(String.valueOf(next)));
                        break;
                    } else {
                        String str = next.split(",")[1];
                        if (!this.O0000oO.containsKey(str)) {
                            Log.e("MotionPaths", "UNKNOWN customName ".concat(String.valueOf(str)));
                            break;
                        } else {
                            ConstraintAttribute constraintAttribute = this.O0000oO.get(str);
                            if (!(oo0o0ooo instanceof oO0O0OoO.O00000Oo)) {
                                Log.e("MotionPaths", next + " splineSet not a CustomSet frame = " + i + ", value" + constraintAttribute.O00000Oo() + oo0o0ooo);
                                break;
                            } else {
                                ((oO0O0OoO.O00000Oo) oo0o0ooo).O000000o(i, constraintAttribute);
                                break;
                            }
                        }
                    }
            }
        }
    }

    public final void O000000o(ConstraintWidget constraintWidget, oOO0OOo0 ooo0ooo0, int i) {
        O000000o((float) constraintWidget.O00000o0(), (float) constraintWidget.O00000o(), (float) constraintWidget.O00000oO(), (float) constraintWidget.O00000oo());
        oOO0OOo0.O000000o O00000oo2 = ooo0ooo0.O00000oo(i);
        this.O00000Oo = O00000oo2.O00000Oo.O00000o0;
        this.O00000o0 = O00000oo2.O00000Oo.O00000Oo;
        this.f2268O000000o = (O00000oo2.O00000Oo.O00000Oo == 0 || this.O00000Oo != 0) ? O00000oo2.O00000Oo.O00000o : 0.0f;
        this.O00000o = O00000oo2.O00000oO.O0000Ooo;
        this.O00000oO = O00000oo2.O00000oO.O0000o00;
        this.O00000oo = O00000oo2.O00000oO.O00000Oo;
        this.O0000O0o = O00000oo2.O00000oO.O00000o0;
        this.O0000OOo = O00000oo2.O00000oO.O00000o;
        this.O0000Oo0 = O00000oo2.O00000oO.O00000oO;
        this.O0000Oo = O00000oo2.O00000oO.O00000oo;
        this.O0000OoO = O00000oo2.O00000oO.O0000O0o;
        this.O0000Ooo = O00000oo2.O00000oO.O0000OOo;
        this.O0000o00 = O00000oo2.O00000oO.O0000Oo0;
        this.O0000o0 = O00000oo2.O00000oO.O0000Oo;
        this.O0000o0O = O00000oo2.O00000oO.O0000OoO;
        this.O0000oo = o0OO0o00.O000000o(O00000oo2.O00000o0.O00000o0);
        this.O0000o0o = O00000oo2.O00000o0.O0000O0o;
        this.O0000ooO = O00000oo2.O00000o0.O00000oO;
        this.O0000o = O00000oo2.O00000Oo.O00000oO;
        for (String next : O00000oo2.O00000oo.keySet()) {
            ConstraintAttribute constraintAttribute = O00000oo2.O00000oo.get(next);
            if (constraintAttribute.O00000Oo != ConstraintAttribute.AttributeType.STRING_TYPE) {
                this.O0000oO.put(next, constraintAttribute);
            }
        }
    }
}
