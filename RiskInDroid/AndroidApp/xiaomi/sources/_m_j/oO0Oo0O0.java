package _m_j;

import _m_j.oO00O0o0;
import _m_j.oO0O0OoO;
import _m_j.oO0OoOO0;
import _m_j.oOO0OOo0;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.exoplayer2.C;
import com.google.android.gms.common.internal.GmsLogger;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import no.nordicsemi.android.dfu.DfuSettingsConstants;

public final class oO0Oo0O0 {

    /* renamed from: O000000o  reason: collision with root package name */
    public View f2287O000000o;
    int O00000Oo;
    public oO00O00o O00000o = new oO00O00o();
    String O00000o0;
    public oO00O00o O00000oO = new oO00O00o();
    public oO000o00 O00000oo = new oO000o00();
    public o0OOoOO0[] O0000O0o;
    public o0OOoOO0 O0000OOo;
    public float O0000Oo = 0.0f;
    public float O0000Oo0 = Float.NaN;
    public float O0000OoO = 1.0f;
    public int[] O0000Ooo;
    public HashMap<String, oO0O0OoO> O0000o;
    public double[] O0000o0;
    public double[] O0000o00;
    public float[] O0000o0O = new float[1];
    ArrayList<oO0000o0> O0000o0o = new ArrayList<>();
    public int O0000oO = oO0000o0.f2264O000000o;
    public HashMap<String, oO0OoOO0> O0000oO0;
    private int O0000oOO = -1;
    private oO000o00 O0000oOo = new oO000o00();
    private int[] O0000oo;
    private String[] O0000oo0;
    private int O0000ooO = 4;
    private float[] O0000ooo = new float[this.O0000ooO];
    private oO000Oo0[] O000O00o;
    private ArrayList<oO00O00o> O00oOooO = new ArrayList<>();
    private HashMap<String, oO00O0o0> O00oOooo;

    public final oO00O00o O000000o(int i) {
        return this.O00oOooO.get(i);
    }

    public oO0Oo0O0(View view) {
        this.f2287O000000o = view;
        this.O00000Oo = view.getId();
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ConstraintLayout.LayoutParams) {
            this.O00000o0 = ((ConstraintLayout.LayoutParams) layoutParams).O000OoO0;
        }
    }

    public final void O000000o(float[] fArr, int i) {
        float[] fArr2 = fArr;
        int i2 = i;
        float f = 1.0f;
        float f2 = 1.0f / ((float) (i2 - 1));
        HashMap<String, oO0O0OoO> hashMap = this.O0000o;
        oO0OoOO0 oo0oooo0 = null;
        oO0O0OoO oo0o0ooo = hashMap == null ? null : hashMap.get("translationX");
        HashMap<String, oO0O0OoO> hashMap2 = this.O0000o;
        oO0O0OoO oo0o0ooo2 = hashMap2 == null ? null : hashMap2.get("translationY");
        HashMap<String, oO0OoOO0> hashMap3 = this.O0000oO0;
        oO0OoOO0 oo0oooo02 = hashMap3 == null ? null : hashMap3.get("translationX");
        HashMap<String, oO0OoOO0> hashMap4 = this.O0000oO0;
        if (hashMap4 != null) {
            oo0oooo0 = hashMap4.get("translationY");
        }
        int i3 = 0;
        while (i3 < i2) {
            float f3 = ((float) i3) * f2;
            float f4 = 0.0f;
            if (this.O0000OoO != f) {
                if (f3 < this.O0000Oo) {
                    f3 = 0.0f;
                }
                float f5 = this.O0000Oo;
                if (f3 > f5 && ((double) f3) < 1.0d) {
                    f3 = (f3 - f5) * this.O0000OoO;
                }
            }
            double d = (double) f3;
            o0OO0o00 o0oo0o00 = this.O00000o.O00000Oo;
            float f6 = Float.NaN;
            Iterator<oO00O00o> it = this.O00oOooO.iterator();
            while (it.hasNext()) {
                oO00O00o next = it.next();
                if (next.O00000Oo != null) {
                    if (next.O00000o < f3) {
                        o0oo0o00 = next.O00000Oo;
                        f4 = next.O00000o;
                    } else if (Float.isNaN(f6)) {
                        f6 = next.O00000o;
                    }
                }
            }
            if (o0oo0o00 != null) {
                if (Float.isNaN(f6)) {
                    f6 = 1.0f;
                }
                float f7 = f6 - f4;
                d = (double) ((((float) o0oo0o00.O000000o((double) ((f3 - f4) / f7))) * f7) + f4);
            }
            this.O0000O0o[0].O000000o(d, this.O0000o00);
            o0OOoOO0 o0ooooo0 = this.O0000OOo;
            if (o0ooooo0 != null) {
                double[] dArr = this.O0000o00;
                if (dArr.length > 0) {
                    o0ooooo0.O000000o(d, dArr);
                }
            }
            int i4 = i3 * 2;
            this.O00000o.O000000o(this.O0000Ooo, this.O0000o00, fArr2, i4);
            if (oo0oooo02 != null) {
                fArr2[i4] = fArr2[i4] + oo0oooo02.O000000o(f3);
            } else if (oo0o0ooo != null) {
                fArr2[i4] = fArr2[i4] + oo0o0ooo.O000000o(f3);
            }
            if (oo0oooo0 != null) {
                int i5 = i4 + 1;
                fArr2[i5] = fArr2[i5] + oo0oooo0.O000000o(f3);
            } else if (oo0o0ooo2 != null) {
                int i6 = i4 + 1;
                fArr2[i6] = fArr2[i6] + oo0o0ooo2.O000000o(f3);
            }
            i3++;
            i2 = i;
            f = 1.0f;
        }
    }

    private float O00000Oo() {
        float[] fArr = new float[2];
        double d = 0.0d;
        double d2 = 0.0d;
        float f = 0.0f;
        for (int i = 0; i < 100; i++) {
            float f2 = ((float) i) * 0.01010101f;
            double d3 = (double) f2;
            o0OO0o00 o0oo0o00 = this.O00000o.O00000Oo;
            float f3 = Float.NaN;
            Iterator<oO00O00o> it = this.O00oOooO.iterator();
            float f4 = 0.0f;
            while (it.hasNext()) {
                oO00O00o next = it.next();
                if (next.O00000Oo != null) {
                    if (next.O00000o < f2) {
                        o0oo0o00 = next.O00000Oo;
                        f4 = next.O00000o;
                    } else if (Float.isNaN(f3)) {
                        f3 = next.O00000o;
                    }
                }
            }
            if (o0oo0o00 != null) {
                if (Float.isNaN(f3)) {
                    f3 = 1.0f;
                }
                float f5 = f3 - f4;
                d3 = (double) ((((float) o0oo0o00.O000000o((double) ((f2 - f4) / f5))) * f5) + f4);
            }
            this.O0000O0o[0].O000000o(d3, this.O0000o00);
            this.O00000o.O000000o(this.O0000Ooo, this.O0000o00, fArr, 0);
            if (i > 0) {
                double d4 = (double) f;
                double d5 = (double) fArr[1];
                Double.isNaN(d5);
                double d6 = d2 - d5;
                double d7 = (double) fArr[0];
                Double.isNaN(d7);
                double hypot = Math.hypot(d6, d - d7);
                Double.isNaN(d4);
                f = (float) (d4 + hypot);
            }
            d = (double) fArr[0];
            d2 = (double) fArr[1];
        }
        return f;
    }

    public final int O000000o(float[] fArr, int[] iArr) {
        if (fArr == null) {
            return 0;
        }
        double[] O000000o2 = this.O0000O0o[0].O000000o();
        if (iArr != null) {
            Iterator<oO00O00o> it = this.O00oOooO.iterator();
            int i = 0;
            while (it.hasNext()) {
                iArr[i] = it.next().O0000o0;
                i++;
            }
        }
        int i2 = 0;
        for (double O000000o3 : O000000o2) {
            this.O0000O0o[0].O000000o(O000000o3, this.O0000o00);
            this.O00000o.O000000o(this.O0000Ooo, this.O0000o00, fArr, i2);
            i2 += 2;
        }
        return i2 / 2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v10, resolved type: _m_j.oO0OoOO0$O00000Oo} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v37, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v45, resolved type: double[][]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v164, resolved type: _m_j.oO0O0OoO$O00000Oo} */
    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Multi-variable type inference failed */
    public final void O000000o(int i, int i2, long j) {
        String str;
        String str2;
        ArrayList arrayList;
        String str3;
        String str4;
        String str5;
        String str6;
        Object obj;
        oO0OoOO0.O00000Oo o00000Oo;
        String str7;
        String str8;
        String str9;
        String str10;
        Object obj2;
        Object obj3;
        String str11;
        String str12;
        char c;
        oO0OoOO0 oo0oooo0;
        Object obj4;
        Object obj5;
        Object obj6;
        String str13;
        String str14;
        String str15;
        String str16;
        Iterator it;
        oO00O0o0 oo00o0o0;
        ConstraintAttribute constraintAttribute;
        Iterator<String> it2;
        int i3;
        Iterator it3;
        Object obj7;
        oO0O0OoO.O00000Oo o00000Oo2;
        String str17;
        String str18;
        String str19;
        String str20;
        char c2;
        Object obj8;
        oO0O0OoO oo0o0ooo;
        ConstraintAttribute constraintAttribute2;
        String str21;
        Iterator<oO0000o0> it4;
        String str22;
        new HashSet();
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        HashSet hashSet3 = new HashSet();
        HashMap hashMap = new HashMap();
        if (this.O0000oO != oO0000o0.f2264O000000o) {
            this.O00000o.O0000Ooo = this.O0000oO;
        }
        oO000o00 oo000o00 = this.O00000oo;
        oO000o00 oo000o002 = this.O0000oOo;
        if (oO000o00.O000000o(oo000o00.f2268O000000o, oo000o002.f2268O000000o)) {
            hashSet2.add("alpha");
        }
        String str23 = "elevation";
        if (oO000o00.O000000o(oo000o00.O00000oO, oo000o002.O00000oO)) {
            hashSet2.add(str23);
        }
        if (oo000o00.O00000o0 != oo000o002.O00000o0 && oo000o00.O00000Oo == 0 && (oo000o00.O00000o0 == 0 || oo000o002.O00000o0 == 0)) {
            hashSet2.add("alpha");
        }
        String str24 = "rotation";
        if (oO000o00.O000000o(oo000o00.O00000oo, oo000o002.O00000oo)) {
            hashSet2.add(str24);
        }
        if (!Float.isNaN(oo000o00.O0000o0o) || !Float.isNaN(oo000o002.O0000o0o)) {
            hashSet2.add("transitionPathRotate");
        }
        String str25 = "progress";
        if (!Float.isNaN(oo000o00.O0000o) || !Float.isNaN(oo000o002.O0000o)) {
            hashSet2.add(str25);
        }
        if (oO000o00.O000000o(oo000o00.O0000O0o, oo000o002.O0000O0o)) {
            hashSet2.add("rotationX");
        }
        if (oO000o00.O000000o(oo000o00.O0000OOo, oo000o002.O0000OOo)) {
            hashSet2.add("rotationY");
        }
        if (oO000o00.O000000o(oo000o00.O0000OoO, oo000o002.O0000OoO)) {
            hashSet2.add("transformPivotX");
        }
        if (oO000o00.O000000o(oo000o00.O0000Ooo, oo000o002.O0000Ooo)) {
            hashSet2.add("transformPivotY");
        }
        String str26 = "scaleX";
        if (oO000o00.O000000o(oo000o00.O0000Oo0, oo000o002.O0000Oo0)) {
            hashSet2.add(str26);
        }
        Object obj9 = "rotationX";
        String str27 = "scaleY";
        if (oO000o00.O000000o(oo000o00.O0000Oo, oo000o002.O0000Oo)) {
            hashSet2.add(str27);
        }
        Object obj10 = "rotationY";
        if (oO000o00.O000000o(oo000o00.O0000o00, oo000o002.O0000o00)) {
            hashSet2.add("translationX");
        }
        Object obj11 = "translationX";
        String str28 = "translationY";
        if (oO000o00.O000000o(oo000o00.O0000o0, oo000o002.O0000o0)) {
            hashSet2.add(str28);
        }
        if (oO000o00.O000000o(oo000o00.O0000o0O, oo000o002.O0000o0O)) {
            hashSet2.add("translationZ");
        }
        ArrayList<oO0000o0> arrayList2 = this.O0000o0o;
        if (arrayList2 != null) {
            Iterator<oO0000o0> it5 = arrayList2.iterator();
            ArrayList arrayList3 = null;
            while (it5.hasNext()) {
                oO0000o0 next = it5.next();
                if (next instanceof oO000OOO) {
                    oO000OOO oo000ooo = (oO000OOO) next;
                    it4 = it5;
                    str21 = str28;
                    oO00O00o oo00o00o = new oO00O00o(i, i2, oo000ooo, this.O00000o, this.O00000oO);
                    int binarySearch = Collections.binarySearch(this.O00oOooO, oo00o00o);
                    if (binarySearch == 0) {
                        str22 = str25;
                        Log.e("MotionController", " KeyPath positon \"" + oo00o00o.O00000oO + "\" outside of range");
                    } else {
                        str22 = str25;
                    }
                    this.O00oOooO.add((-binarySearch) - 1, oo00o00o);
                    if (oo000ooo.O0000o != oO0000o0.f2264O000000o) {
                        this.O0000oOO = oo000ooo.O0000o;
                    }
                } else {
                    it4 = it5;
                    str22 = str25;
                    str21 = str28;
                    if (next instanceof oO0Ooooo) {
                        next.O000000o(hashSet3);
                    } else if (next instanceof oO0OOo0o) {
                        next.O000000o(hashSet);
                    } else if (next instanceof oO000Oo0) {
                        if (arrayList3 == null) {
                            arrayList3 = new ArrayList();
                        }
                        ArrayList arrayList4 = arrayList3;
                        arrayList4.add((oO000Oo0) next);
                        arrayList3 = arrayList4;
                    } else {
                        next.O00000Oo(hashMap);
                        next.O000000o(hashSet2);
                    }
                }
                str25 = str22;
                it5 = it4;
                str28 = str21;
            }
            str2 = str25;
            str = str28;
            arrayList = arrayList3;
        } else {
            str2 = str25;
            str = str28;
            arrayList = null;
        }
        if (arrayList != null) {
            this.O000O00o = (oO000Oo0[]) arrayList.toArray(new oO000Oo0[0]);
        }
        if (!hashSet2.isEmpty()) {
            this.O0000o = new HashMap<>();
            Iterator it6 = hashSet2.iterator();
            while (it6.hasNext()) {
                String str29 = (String) it6.next();
                if (!str29.startsWith("CUSTOM,")) {
                    it3 = it6;
                    switch (str29.hashCode()) {
                        case -1249320806:
                            obj8 = obj9;
                            obj7 = obj11;
                            str18 = str2;
                            str17 = str;
                            if (str29.equals(obj8)) {
                                c2 = 3;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case -1249320805:
                            Object obj12 = obj10;
                            obj7 = obj11;
                            str18 = str2;
                            str17 = str;
                            if (!str29.equals(obj12)) {
                                obj10 = obj12;
                                obj8 = obj9;
                                c2 = 65535;
                                break;
                            } else {
                                obj10 = obj12;
                                obj8 = obj9;
                                c2 = 4;
                                break;
                            }
                        case -1225497657:
                            obj7 = obj11;
                            str18 = str2;
                            str17 = str;
                            if (str29.equals(obj7)) {
                                obj8 = obj9;
                                c2 = 12;
                                break;
                            }
                            obj8 = obj9;
                            c2 = 65535;
                            break;
                        case -1225497656:
                            str18 = str2;
                            str17 = str;
                            if (!str29.equals(str17)) {
                                obj8 = obj9;
                                obj7 = obj11;
                                c2 = 65535;
                                break;
                            } else {
                                obj8 = obj9;
                                obj7 = obj11;
                                c2 = 13;
                                break;
                            }
                        case -1225497655:
                            str18 = str2;
                            if (str29.equals("translationZ")) {
                                obj8 = obj9;
                                obj7 = obj11;
                                str17 = str;
                                c2 = 14;
                                break;
                            }
                            obj8 = obj9;
                            obj7 = obj11;
                            str17 = str;
                            c2 = 65535;
                            break;
                        case -1001078227:
                            str18 = str2;
                            if (str29.equals(str18)) {
                                obj8 = obj9;
                                obj7 = obj11;
                                str17 = str;
                                c2 = 15;
                                break;
                            }
                            obj8 = obj9;
                            obj7 = obj11;
                            str17 = str;
                            c2 = 65535;
                            break;
                        case -908189618:
                            if (str29.equals(str26)) {
                                obj8 = obj9;
                                obj7 = obj11;
                                str18 = str2;
                                str17 = str;
                                c2 = 8;
                                break;
                            }
                            obj8 = obj9;
                            obj7 = obj11;
                            str18 = str2;
                            str17 = str;
                            c2 = 65535;
                            break;
                        case -908189617:
                            if (str29.equals(str27)) {
                                obj8 = obj9;
                                obj7 = obj11;
                                str18 = str2;
                                str17 = str;
                                c2 = 9;
                                break;
                            }
                            obj8 = obj9;
                            obj7 = obj11;
                            str18 = str2;
                            str17 = str;
                            c2 = 65535;
                            break;
                        case -797520672:
                            if (str29.equals("waveVariesBy")) {
                                obj8 = obj9;
                                obj7 = obj11;
                                str18 = str2;
                                str17 = str;
                                c2 = 11;
                                break;
                            }
                            obj8 = obj9;
                            obj7 = obj11;
                            str18 = str2;
                            str17 = str;
                            c2 = 65535;
                            break;
                        case -760884510:
                            if (str29.equals("transformPivotX")) {
                                obj8 = obj9;
                                obj7 = obj11;
                                str18 = str2;
                                str17 = str;
                                c2 = 5;
                                break;
                            }
                            obj8 = obj9;
                            obj7 = obj11;
                            str18 = str2;
                            str17 = str;
                            c2 = 65535;
                            break;
                        case -760884509:
                            if (str29.equals("transformPivotY")) {
                                obj8 = obj9;
                                obj7 = obj11;
                                str18 = str2;
                                str17 = str;
                                c2 = 6;
                                break;
                            }
                            obj8 = obj9;
                            obj7 = obj11;
                            str18 = str2;
                            str17 = str;
                            c2 = 65535;
                            break;
                        case -40300674:
                            if (str29.equals(str24)) {
                                obj8 = obj9;
                                obj7 = obj11;
                                str18 = str2;
                                str17 = str;
                                c2 = 2;
                                break;
                            }
                            obj8 = obj9;
                            obj7 = obj11;
                            str18 = str2;
                            str17 = str;
                            c2 = 65535;
                            break;
                        case -4379043:
                            if (str29.equals(str23)) {
                                obj8 = obj9;
                                obj7 = obj11;
                                str18 = str2;
                                str17 = str;
                                c2 = 1;
                                break;
                            }
                            obj8 = obj9;
                            obj7 = obj11;
                            str18 = str2;
                            str17 = str;
                            c2 = 65535;
                            break;
                        case 37232917:
                            if (str29.equals("transitionPathRotate")) {
                                obj8 = obj9;
                                obj7 = obj11;
                                str18 = str2;
                                str17 = str;
                                c2 = 7;
                                break;
                            }
                            obj8 = obj9;
                            obj7 = obj11;
                            str18 = str2;
                            str17 = str;
                            c2 = 65535;
                            break;
                        case 92909918:
                            if (str29.equals("alpha")) {
                                obj8 = obj9;
                                obj7 = obj11;
                                str18 = str2;
                                str17 = str;
                                c2 = 0;
                                break;
                            }
                            obj8 = obj9;
                            obj7 = obj11;
                            str18 = str2;
                            str17 = str;
                            c2 = 65535;
                            break;
                        case 156108012:
                            if (str29.equals("waveOffset")) {
                                obj8 = obj9;
                                obj7 = obj11;
                                str18 = str2;
                                str17 = str;
                                c2 = 10;
                                break;
                            }
                            obj8 = obj9;
                            obj7 = obj11;
                            str18 = str2;
                            str17 = str;
                            c2 = 65535;
                            break;
                        default:
                            obj8 = obj9;
                            obj7 = obj11;
                            str18 = str2;
                            str17 = str;
                            c2 = 65535;
                            break;
                    }
                    switch (c2) {
                        case 0:
                            oo0o0ooo = new oO0O0OoO.O000000o();
                            oO0O0OoO oo0o0ooo2 = oo0o0ooo;
                            obj9 = obj8;
                            o00000Oo2 = oo0o0ooo2;
                            break;
                        case 1:
                            oo0o0ooo = new oO0O0OoO.O00000o0();
                            oO0O0OoO oo0o0ooo22 = oo0o0ooo;
                            obj9 = obj8;
                            o00000Oo2 = oo0o0ooo22;
                            break;
                        case 2:
                            oo0o0ooo = new oO0O0OoO.O0000Oo();
                            oO0O0OoO oo0o0ooo222 = oo0o0ooo;
                            obj9 = obj8;
                            o00000Oo2 = oo0o0ooo222;
                            break;
                        case 3:
                            oo0o0ooo = new oO0O0OoO.O0000o00();
                            oO0O0OoO oo0o0ooo2222 = oo0o0ooo;
                            obj9 = obj8;
                            o00000Oo2 = oo0o0ooo2222;
                            break;
                        case 4:
                            oo0o0ooo = new oO0O0OoO.O0000o0();
                            oO0O0OoO oo0o0ooo22222 = oo0o0ooo;
                            obj9 = obj8;
                            o00000Oo2 = oo0o0ooo22222;
                            break;
                        case 5:
                            oo0o0ooo = new oO0O0OoO.O0000O0o();
                            oO0O0OoO oo0o0ooo222222 = oo0o0ooo;
                            obj9 = obj8;
                            o00000Oo2 = oo0o0ooo222222;
                            break;
                        case 6:
                            oo0o0ooo = new oO0O0OoO.O0000OOo();
                            oO0O0OoO oo0o0ooo2222222 = oo0o0ooo;
                            obj9 = obj8;
                            o00000Oo2 = oo0o0ooo2222222;
                            break;
                        case 7:
                            oo0o0ooo = new oO0O0OoO.O00000o();
                            oO0O0OoO oo0o0ooo22222222 = oo0o0ooo;
                            obj9 = obj8;
                            o00000Oo2 = oo0o0ooo22222222;
                            break;
                        case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER /*8*/:
                            oo0o0ooo = new oO0O0OoO.O0000o();
                            oO0O0OoO oo0o0ooo222222222 = oo0o0ooo;
                            obj9 = obj8;
                            o00000Oo2 = oo0o0ooo222222222;
                            break;
                        case 9:
                            oo0o0ooo = new oO0O0OoO.O00oOooO();
                            oO0O0OoO oo0o0ooo2222222222 = oo0o0ooo;
                            obj9 = obj8;
                            o00000Oo2 = oo0o0ooo2222222222;
                            break;
                        case 10:
                            oo0o0ooo = new oO0O0OoO.O000000o();
                            oO0O0OoO oo0o0ooo22222222222 = oo0o0ooo;
                            obj9 = obj8;
                            o00000Oo2 = oo0o0ooo22222222222;
                            break;
                        case 11:
                            oo0o0ooo = new oO0O0OoO.O000000o();
                            oO0O0OoO oo0o0ooo222222222222 = oo0o0ooo;
                            obj9 = obj8;
                            o00000Oo2 = oo0o0ooo222222222222;
                            break;
                        case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                            oo0o0ooo = new oO0O0OoO.O000O0OO();
                            oO0O0OoO oo0o0ooo2222222222222 = oo0o0ooo;
                            obj9 = obj8;
                            o00000Oo2 = oo0o0ooo2222222222222;
                            break;
                        case 13:
                            oo0o0ooo = new oO0O0OoO.O000O0o0();
                            oO0O0OoO oo0o0ooo22222222222222 = oo0o0ooo;
                            obj9 = obj8;
                            o00000Oo2 = oo0o0ooo22222222222222;
                            break;
                        case 14:
                            oo0o0ooo = new oO0O0OoO.O000O0o();
                            oO0O0OoO oo0o0ooo222222222222222 = oo0o0ooo;
                            obj9 = obj8;
                            o00000Oo2 = oo0o0ooo222222222222222;
                            break;
                        case GmsLogger.MAX_PII_TAG_LENGTH /*15*/:
                            oo0o0ooo = new oO0O0OoO.O0000Oo0();
                            oO0O0OoO oo0o0ooo2222222222222222 = oo0o0ooo;
                            obj9 = obj8;
                            o00000Oo2 = oo0o0ooo2222222222222222;
                            break;
                        default:
                            obj9 = obj8;
                            o00000Oo2 = null;
                            break;
                    }
                } else {
                    SparseArray sparseArray = new SparseArray();
                    String str30 = str29.split(",")[1];
                    Iterator<oO0000o0> it7 = this.O0000o0o.iterator();
                    while (it7.hasNext()) {
                        Iterator it8 = it6;
                        oO0000o0 next2 = it7.next();
                        Iterator<oO0000o0> it9 = it7;
                        if (!(next2.O00000oo == null || (constraintAttribute2 = next2.O00000oo.get(str30)) == null)) {
                            sparseArray.append(next2.O00000Oo, constraintAttribute2);
                        }
                        it7 = it9;
                        it6 = it8;
                    }
                    it3 = it6;
                    o00000Oo2 = new oO0O0OoO.O00000Oo(str29, sparseArray);
                    obj7 = obj11;
                    str18 = str2;
                    str17 = str;
                }
                if (o00000Oo2 != null) {
                    o00000Oo2.O00000o = str29;
                    obj11 = obj7;
                    this.O0000o.put(str29, o00000Oo2);
                    str19 = str18;
                    str20 = str17;
                } else {
                    str19 = str18;
                    str20 = str17;
                    obj11 = obj7;
                }
                it6 = it3;
            }
            str4 = str2;
            str3 = str;
            ArrayList<oO0000o0> arrayList5 = this.O0000o0o;
            if (arrayList5 != null) {
                Iterator<oO0000o0> it10 = arrayList5.iterator();
                while (it10.hasNext()) {
                    oO0000o0 next3 = it10.next();
                    if (next3 instanceof oO000O0O) {
                        next3.O000000o(this.O0000o);
                    }
                }
            }
            this.O00000oo.O000000o(this.O0000o, 0);
            this.O0000oOo.O000000o(this.O0000o, 100);
            Iterator<String> it11 = this.O0000o.keySet().iterator();
            while (it11.hasNext()) {
                String next4 = it11.next();
                if (hashMap.containsKey(next4)) {
                    i3 = ((Integer) hashMap.get(next4)).intValue();
                    it2 = it11;
                } else {
                    it2 = it11;
                    i3 = 0;
                }
                this.O0000o.get(next4).O000000o(i3);
                it11 = it2;
            }
        } else {
            str4 = str2;
            str3 = str;
        }
        if (!hashSet.isEmpty()) {
            if (this.O00oOooo == null) {
                this.O00oOooo = new HashMap<>();
            }
            Iterator it12 = hashSet.iterator();
            while (it12.hasNext()) {
                String str31 = (String) it12.next();
                if (!this.O00oOooo.containsKey(str31)) {
                    if (str31.startsWith("CUSTOM,")) {
                        SparseArray sparseArray2 = new SparseArray();
                        String str32 = str31.split(",")[1];
                        it = it12;
                        Iterator<oO0000o0> it13 = this.O0000o0o.iterator();
                        while (it13.hasNext()) {
                            Iterator<oO0000o0> it14 = it13;
                            oO0000o0 next5 = it13.next();
                            String str33 = str3;
                            if (!(next5.O00000oo == null || (constraintAttribute = next5.O00000oo.get(str32)) == null)) {
                                sparseArray2.append(next5.O00000Oo, constraintAttribute);
                            }
                            it13 = it14;
                            str3 = str33;
                        }
                        str15 = str3;
                        oo00o0o0 = oO00O0o0.O000000o(str31, sparseArray2);
                        str16 = str4;
                    } else {
                        it = it12;
                        str16 = str4;
                        str15 = str3;
                        oo00o0o0 = oO00O0o0.O000000o(str31, j);
                    }
                    if (oo00o0o0 != null) {
                        oo00o0o0.O00000oO = str31;
                        this.O00oOooo.put(str31, oo00o0o0);
                    }
                    it12 = it;
                } else {
                    str16 = str4;
                    str15 = str3;
                }
                str4 = str16;
                str3 = str15;
            }
            str6 = str4;
            str5 = str3;
            ArrayList<oO0000o0> arrayList6 = this.O0000o0o;
            if (arrayList6 != null) {
                Iterator<oO0000o0> it15 = arrayList6.iterator();
                while (it15.hasNext()) {
                    oO0000o0 next6 = it15.next();
                    if (next6 instanceof oO0OOo0o) {
                        ((oO0OOo0o) next6).O00000o0(this.O00oOooo);
                    }
                }
            }
            for (String next7 : this.O00oOooo.keySet()) {
                this.O00oOooo.get(next7).O000000o(hashMap.containsKey(next7) ? ((Integer) hashMap.get(next7)).intValue() : 0);
            }
        } else {
            str6 = str4;
            str5 = str3;
        }
        oO00O00o[] oo00o00oArr = new oO00O00o[(this.O00oOooO.size() + 2)];
        oo00o00oArr[0] = this.O00000o;
        oo00o00oArr[oo00o00oArr.length - 1] = this.O00000oO;
        if (this.O00oOooO.size() > 0 && this.O0000oOO == -1) {
            this.O0000oOO = 0;
        }
        Iterator<oO00O00o> it16 = this.O00oOooO.iterator();
        int i4 = 1;
        while (it16.hasNext()) {
            oo00o00oArr[i4] = it16.next();
            i4++;
        }
        HashSet hashSet4 = new HashSet();
        for (String next8 : this.O00000oO.O0000o00.keySet()) {
            if (this.O00000o.O0000o00.containsKey(next8) && !hashSet2.contains("CUSTOM,".concat(String.valueOf(next8)))) {
                hashSet4.add(next8);
            }
        }
        this.O0000oo0 = (String[]) hashSet4.toArray(new String[0]);
        this.O0000oo = new int[this.O0000oo0.length];
        int i5 = 0;
        while (true) {
            String[] strArr = this.O0000oo0;
            if (i5 < strArr.length) {
                String str34 = strArr[i5];
                this.O0000oo[i5] = 0;
                int i6 = 0;
                while (true) {
                    if (i6 < oo00o00oArr.length) {
                        if (oo00o00oArr[i6].O0000o00.containsKey(str34)) {
                            int[] iArr = this.O0000oo;
                            iArr[i5] = iArr[i5] + oo00o00oArr[i6].O0000o00.get(str34).O000000o();
                        } else {
                            i6++;
                        }
                    }
                }
                i5++;
            } else {
                boolean z = oo00o00oArr[0].O0000Ooo != oO0000o0.f2264O000000o;
                boolean[] zArr = new boolean[(this.O0000oo0.length + 18)];
                int i7 = 1;
                while (i7 < oo00o00oArr.length) {
                    oO00O00o oo00o00o2 = oo00o00oArr[i7];
                    oO00O00o oo00o00o3 = oo00o00oArr[i7 - 1];
                    zArr[0] = oO00O00o.O000000o(oo00o00o2.O00000oO, oo00o00o3.O00000oO) | zArr[0];
                    zArr[1] = oO00O00o.O000000o(oo00o00o2.O00000oo, oo00o00o3.O00000oo) | z | zArr[1];
                    zArr[2] = oO00O00o.O000000o(oo00o00o2.O0000O0o, oo00o00o3.O0000O0o) | z | zArr[2];
                    zArr[3] = oO00O00o.O000000o(oo00o00o2.O0000OOo, oo00o00o3.O0000OOo) | zArr[3];
                    zArr[4] = oO00O00o.O000000o(oo00o00o2.O0000Oo0, oo00o00o3.O0000Oo0) | zArr[4];
                    i7++;
                    str26 = str26;
                }
                String str35 = str26;
                int i8 = 0;
                for (int i9 = 1; i9 < zArr.length; i9++) {
                    if (zArr[i9]) {
                        i8++;
                    }
                }
                this.O0000Ooo = new int[i8];
                int[] iArr2 = this.O0000Ooo;
                this.O0000o00 = new double[iArr2.length];
                this.O0000o0 = new double[iArr2.length];
                int i10 = 0;
                for (int i11 = 1; i11 < zArr.length; i11++) {
                    if (zArr[i11]) {
                        this.O0000Ooo[i10] = i11;
                        i10++;
                    }
                }
                double[][] dArr = (double[][]) Array.newInstance(double.class, oo00o00oArr.length, this.O0000Ooo.length);
                double[] dArr2 = new double[oo00o00oArr.length];
                for (int i12 = 0; i12 < oo00o00oArr.length; i12++) {
                    oo00o00oArr[i12].O000000o(dArr[i12], this.O0000Ooo);
                    dArr2[i12] = (double) oo00o00oArr[i12].O00000o;
                }
                int i13 = 0;
                while (true) {
                    int[] iArr3 = this.O0000Ooo;
                    if (i13 < iArr3.length) {
                        if (iArr3[i13] < oO00O00o.f2269O000000o.length) {
                            String str36 = oO00O00o.f2269O000000o[this.O0000Ooo[i13]] + " [";
                            for (int i14 = 0; i14 < oo00o00oArr.length; i14++) {
                                str36 = str36 + dArr[i14][i13];
                            }
                        }
                        i13++;
                    } else {
                        this.O0000O0o = new o0OOoOO0[(this.O0000oo0.length + 1)];
                        int i15 = 0;
                        while (true) {
                            String[] strArr2 = this.O0000oo0;
                            if (i15 < strArr2.length) {
                                String str37 = strArr2[i15];
                                String str38 = str27;
                                int i16 = 0;
                                double[] dArr3 = null;
                                int i17 = 0;
                                double[][] dArr4 = null;
                                while (i16 < oo00o00oArr.length) {
                                    if (oo00o00oArr[i16].O0000o00.containsKey(str37)) {
                                        if (dArr4 == null) {
                                            dArr3 = new double[oo00o00oArr.length];
                                            dArr4 = Array.newInstance(double.class, oo00o00oArr.length, oo00o00oArr[i16].O0000o00.get(str37).O000000o());
                                        }
                                        str14 = str23;
                                        str13 = str24;
                                        dArr3[i17] = (double) oo00o00oArr[i16].O00000o;
                                        oo00o00oArr[i16].O000000o(str37, dArr4[i17], 0);
                                        i17++;
                                    } else {
                                        str14 = str23;
                                        str13 = str24;
                                    }
                                    i16++;
                                    str23 = str14;
                                    str24 = str13;
                                }
                                i15++;
                                this.O0000O0o[i15] = o0OOoOO0.O000000o(this.O0000oOO, Arrays.copyOf(dArr3, i17), (double[][]) Arrays.copyOf(dArr4, i17));
                                str27 = str38;
                                str23 = str23;
                                str24 = str24;
                            } else {
                                String str39 = str23;
                                String str40 = str24;
                                String str41 = str27;
                                this.O0000O0o[0] = o0OOoOO0.O000000o(this.O0000oOO, dArr2, dArr);
                                if (oo00o00oArr[0].O0000Ooo != oO0000o0.f2264O000000o) {
                                    int length = oo00o00oArr.length;
                                    int[] iArr4 = new int[length];
                                    double[] dArr5 = new double[length];
                                    double[][] dArr6 = (double[][]) Array.newInstance(double.class, length, 2);
                                    for (int i18 = 0; i18 < length; i18++) {
                                        iArr4[i18] = oo00o00oArr[i18].O0000Ooo;
                                        dArr5[i18] = (double) oo00o00oArr[i18].O00000o;
                                        dArr6[i18][0] = (double) oo00o00oArr[i18].O00000oo;
                                        dArr6[i18][1] = (double) oo00o00oArr[i18].O0000O0o;
                                    }
                                    this.O0000OOo = new o0OO0OO0(iArr4, dArr5, dArr6);
                                }
                                float f = Float.NaN;
                                this.O0000oO0 = new HashMap<>();
                                if (this.O0000o0o != null) {
                                    Iterator it17 = hashSet3.iterator();
                                    while (it17.hasNext()) {
                                        String str42 = (String) it17.next();
                                        if (!str42.startsWith("CUSTOM")) {
                                            switch (str42.hashCode()) {
                                                case -1249320806:
                                                    obj2 = obj9;
                                                    obj3 = obj10;
                                                    obj = obj11;
                                                    str9 = str35;
                                                    str8 = str6;
                                                    str10 = str41;
                                                    str12 = str39;
                                                    str11 = str40;
                                                    str7 = str5;
                                                    if (str42.equals(obj2)) {
                                                        c = 3;
                                                        break;
                                                    }
                                                    c = 65535;
                                                    break;
                                                case -1249320805:
                                                    obj3 = obj10;
                                                    obj = obj11;
                                                    str9 = str35;
                                                    str8 = str6;
                                                    str10 = str41;
                                                    str12 = str39;
                                                    str11 = str40;
                                                    str7 = str5;
                                                    if (!str42.equals(obj3)) {
                                                        obj2 = obj9;
                                                        c = 65535;
                                                        break;
                                                    } else {
                                                        obj2 = obj9;
                                                        c = 4;
                                                        break;
                                                    }
                                                case -1225497657:
                                                    obj = obj11;
                                                    str9 = str35;
                                                    str8 = str6;
                                                    str10 = str41;
                                                    str12 = str39;
                                                    str11 = str40;
                                                    str7 = str5;
                                                    if (!str42.equals(obj)) {
                                                        obj2 = obj9;
                                                        obj3 = obj10;
                                                        c = 65535;
                                                        break;
                                                    } else {
                                                        obj2 = obj9;
                                                        obj3 = obj10;
                                                        c = 10;
                                                        break;
                                                    }
                                                case -1225497656:
                                                    str9 = str35;
                                                    str8 = str6;
                                                    str10 = str41;
                                                    str12 = str39;
                                                    str11 = str40;
                                                    str7 = str5;
                                                    if (!str42.equals(str7)) {
                                                        obj2 = obj9;
                                                        obj3 = obj10;
                                                        obj = obj11;
                                                        c = 65535;
                                                        break;
                                                    } else {
                                                        obj2 = obj9;
                                                        obj3 = obj10;
                                                        obj = obj11;
                                                        c = 11;
                                                        break;
                                                    }
                                                case -1225497655:
                                                    str9 = str35;
                                                    str8 = str6;
                                                    str10 = str41;
                                                    str12 = str39;
                                                    str11 = str40;
                                                    if (str42.equals("translationZ")) {
                                                        obj2 = obj9;
                                                        obj3 = obj10;
                                                        obj = obj11;
                                                        str7 = str5;
                                                        c = 12;
                                                        break;
                                                    }
                                                    obj2 = obj9;
                                                    obj3 = obj10;
                                                    obj = obj11;
                                                    str7 = str5;
                                                    c = 65535;
                                                    break;
                                                case -1001078227:
                                                    str9 = str35;
                                                    str8 = str6;
                                                    str10 = str41;
                                                    str12 = str39;
                                                    str11 = str40;
                                                    if (str42.equals(str8)) {
                                                        obj2 = obj9;
                                                        obj3 = obj10;
                                                        obj = obj11;
                                                        str7 = str5;
                                                        c = 13;
                                                        break;
                                                    }
                                                    obj2 = obj9;
                                                    obj3 = obj10;
                                                    obj = obj11;
                                                    str7 = str5;
                                                    c = 65535;
                                                    break;
                                                case -908189618:
                                                    str9 = str35;
                                                    str10 = str41;
                                                    str12 = str39;
                                                    str11 = str40;
                                                    if (!str42.equals(str9)) {
                                                        obj4 = obj9;
                                                        obj5 = obj10;
                                                        obj6 = obj11;
                                                        str8 = str6;
                                                        str7 = str5;
                                                        c = 65535;
                                                        break;
                                                    } else {
                                                        obj2 = obj9;
                                                        obj3 = obj10;
                                                        obj = obj11;
                                                        str8 = str6;
                                                        str7 = str5;
                                                        c = 6;
                                                        break;
                                                    }
                                                case -908189617:
                                                    str10 = str41;
                                                    str12 = str39;
                                                    str11 = str40;
                                                    if (!str42.equals(str10)) {
                                                        obj4 = obj9;
                                                        obj5 = obj10;
                                                        obj6 = obj11;
                                                        str9 = str35;
                                                        str8 = str6;
                                                        str7 = str5;
                                                        c = 65535;
                                                        break;
                                                    } else {
                                                        obj2 = obj9;
                                                        obj3 = obj10;
                                                        obj = obj11;
                                                        str9 = str35;
                                                        str8 = str6;
                                                        str7 = str5;
                                                        c = 7;
                                                        break;
                                                    }
                                                case -797520672:
                                                    str12 = str39;
                                                    str11 = str40;
                                                    if (str42.equals("waveVariesBy")) {
                                                        obj2 = obj9;
                                                        obj3 = obj10;
                                                        obj = obj11;
                                                        str9 = str35;
                                                        str8 = str6;
                                                        str10 = str41;
                                                        str7 = str5;
                                                        c = 9;
                                                        break;
                                                    }
                                                    obj2 = obj9;
                                                    obj3 = obj10;
                                                    obj = obj11;
                                                    str9 = str35;
                                                    str8 = str6;
                                                    str10 = str41;
                                                    str7 = str5;
                                                    c = 65535;
                                                    break;
                                                case -40300674:
                                                    str12 = str39;
                                                    str11 = str40;
                                                    if (str42.equals(str11)) {
                                                        obj2 = obj9;
                                                        obj3 = obj10;
                                                        obj = obj11;
                                                        str9 = str35;
                                                        str8 = str6;
                                                        str10 = str41;
                                                        str7 = str5;
                                                        c = 2;
                                                        break;
                                                    }
                                                    obj2 = obj9;
                                                    obj3 = obj10;
                                                    obj = obj11;
                                                    str9 = str35;
                                                    str8 = str6;
                                                    str10 = str41;
                                                    str7 = str5;
                                                    c = 65535;
                                                    break;
                                                case -4379043:
                                                    str12 = str39;
                                                    if (!str42.equals(str12)) {
                                                        obj2 = obj9;
                                                        obj3 = obj10;
                                                        obj = obj11;
                                                        str9 = str35;
                                                        str8 = str6;
                                                        str10 = str41;
                                                        str11 = str40;
                                                        str7 = str5;
                                                        c = 65535;
                                                        break;
                                                    } else {
                                                        obj2 = obj9;
                                                        obj3 = obj10;
                                                        obj = obj11;
                                                        str9 = str35;
                                                        str8 = str6;
                                                        str10 = str41;
                                                        str11 = str40;
                                                        str7 = str5;
                                                        c = 1;
                                                        break;
                                                    }
                                                case 37232917:
                                                    if (str42.equals("transitionPathRotate")) {
                                                        obj2 = obj9;
                                                        obj3 = obj10;
                                                        obj = obj11;
                                                        str9 = str35;
                                                        str8 = str6;
                                                        str10 = str41;
                                                        str12 = str39;
                                                        str11 = str40;
                                                        str7 = str5;
                                                        c = 5;
                                                        break;
                                                    }
                                                    obj2 = obj9;
                                                    obj3 = obj10;
                                                    obj = obj11;
                                                    str9 = str35;
                                                    str8 = str6;
                                                    str10 = str41;
                                                    str12 = str39;
                                                    str11 = str40;
                                                    str7 = str5;
                                                    c = 65535;
                                                    break;
                                                case 92909918:
                                                    if (str42.equals("alpha")) {
                                                        obj2 = obj9;
                                                        obj3 = obj10;
                                                        obj = obj11;
                                                        str9 = str35;
                                                        str8 = str6;
                                                        str10 = str41;
                                                        str12 = str39;
                                                        str11 = str40;
                                                        str7 = str5;
                                                        c = 0;
                                                        break;
                                                    }
                                                    obj2 = obj9;
                                                    obj3 = obj10;
                                                    obj = obj11;
                                                    str9 = str35;
                                                    str8 = str6;
                                                    str10 = str41;
                                                    str12 = str39;
                                                    str11 = str40;
                                                    str7 = str5;
                                                    c = 65535;
                                                    break;
                                                case 156108012:
                                                    if (str42.equals("waveOffset")) {
                                                        obj2 = obj9;
                                                        obj3 = obj10;
                                                        obj = obj11;
                                                        str9 = str35;
                                                        str8 = str6;
                                                        str10 = str41;
                                                        str12 = str39;
                                                        str11 = str40;
                                                        str7 = str5;
                                                        c = 8;
                                                        break;
                                                    }
                                                    obj2 = obj9;
                                                    obj3 = obj10;
                                                    obj = obj11;
                                                    str9 = str35;
                                                    str8 = str6;
                                                    str10 = str41;
                                                    str12 = str39;
                                                    str11 = str40;
                                                    str7 = str5;
                                                    c = 65535;
                                                    break;
                                                default:
                                                    obj2 = obj9;
                                                    obj3 = obj10;
                                                    obj = obj11;
                                                    str9 = str35;
                                                    str8 = str6;
                                                    str10 = str41;
                                                    str12 = str39;
                                                    str11 = str40;
                                                    str7 = str5;
                                                    c = 65535;
                                                    break;
                                            }
                                            switch (c) {
                                                case 0:
                                                    oo0oooo0 = new oO0OoOO0.O000000o();
                                                    o00000Oo = oo0oooo0;
                                                    break;
                                                case 1:
                                                    oo0oooo0 = new oO0OoOO0.O00000o();
                                                    o00000Oo = oo0oooo0;
                                                    break;
                                                case 2:
                                                    oo0oooo0 = new oO0OoOO0.O0000Oo0();
                                                    o00000Oo = oo0oooo0;
                                                    break;
                                                case 3:
                                                    oo0oooo0 = new oO0OoOO0.O0000Oo();
                                                    o00000Oo = oo0oooo0;
                                                    break;
                                                case 4:
                                                    oo0oooo0 = new oO0OoOO0.O0000o00();
                                                    o00000Oo = oo0oooo0;
                                                    break;
                                                case 5:
                                                    oo0oooo0 = new oO0OoOO0.O0000O0o();
                                                    o00000Oo = oo0oooo0;
                                                    break;
                                                case 6:
                                                    oo0oooo0 = new oO0OoOO0.O0000o0();
                                                    o00000Oo = oo0oooo0;
                                                    break;
                                                case 7:
                                                    oo0oooo0 = new oO0OoOO0.O0000o();
                                                    o00000Oo = oo0oooo0;
                                                    break;
                                                case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER /*8*/:
                                                    oo0oooo0 = new oO0OoOO0.O000000o();
                                                    o00000Oo = oo0oooo0;
                                                    break;
                                                case 9:
                                                    oo0oooo0 = new oO0OoOO0.O000000o();
                                                    o00000Oo = oo0oooo0;
                                                    break;
                                                case 10:
                                                    oo0oooo0 = new oO0OoOO0.O00oOooO();
                                                    o00000Oo = oo0oooo0;
                                                    break;
                                                case 11:
                                                    oo0oooo0 = new oO0OoOO0.O000O00o();
                                                    o00000Oo = oo0oooo0;
                                                    break;
                                                case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                                                    oo0oooo0 = new oO0OoOO0.O000O0OO();
                                                    o00000Oo = oo0oooo0;
                                                    break;
                                                case 13:
                                                    oo0oooo0 = new oO0OoOO0.O0000OOo();
                                                    o00000Oo = oo0oooo0;
                                                    break;
                                                default:
                                                    o00000Oo = null;
                                                    break;
                                            }
                                        } else {
                                            o00000Oo = new oO0OoOO0.O00000Oo();
                                            obj2 = obj9;
                                            obj3 = obj10;
                                            obj = obj11;
                                            str9 = str35;
                                            str8 = str6;
                                            str10 = str41;
                                            str12 = str39;
                                            str11 = str40;
                                            str7 = str5;
                                        }
                                        if (o00000Oo != null) {
                                            Iterator it18 = it17;
                                            str39 = str12;
                                            if ((o00000Oo.O00000o == 1) && Float.isNaN(f)) {
                                                f = O00000Oo();
                                            }
                                            o00000Oo.O00000Oo = str42;
                                            this.O0000oO0.put(str42, o00000Oo);
                                            it17 = it18;
                                        } else {
                                            str39 = str12;
                                        }
                                        str40 = str11;
                                        obj10 = obj3;
                                        obj9 = obj2;
                                        str41 = str10;
                                        str35 = str9;
                                        str6 = str8;
                                        str5 = str7;
                                        obj11 = obj;
                                    }
                                    Iterator<oO0000o0> it19 = this.O0000o0o.iterator();
                                    while (it19.hasNext()) {
                                        oO0000o0 next9 = it19.next();
                                        if (next9 instanceof oO0Ooooo) {
                                            ((oO0Ooooo) next9).O00000o0(this.O0000oO0);
                                        }
                                    }
                                    for (oO0OoOO0 O00000o02 : this.O0000oO0.values()) {
                                        O00000o02.O00000o0(f);
                                    }
                                    return;
                                }
                                return;
                            }
                        }
                    }
                }
            }
        }
    }

    public final String toString() {
        return " start: x: " + this.O00000o.O00000oo + " y: " + this.O00000o.O0000O0o + " end: x: " + this.O00000oO.O00000oo + " y: " + this.O00000oO.O0000O0o;
    }

    private void O000000o(oO00O00o oo00o00o) {
        oo00o00o.O000000o((float) ((int) this.f2287O000000o.getX()), (float) ((int) this.f2287O000000o.getY()), (float) this.f2287O000000o.getWidth(), (float) this.f2287O000000o.getHeight());
    }

    public final void O000000o(ConstraintWidget constraintWidget, oOO0OOo0 ooo0ooo0) {
        oO00O00o oo00o00o = this.O00000o;
        oo00o00o.O00000o = 0.0f;
        oo00o00o.O00000oO = 0.0f;
        O000000o(oo00o00o);
        this.O00000o.O000000o((float) constraintWidget.O00000o0(), (float) constraintWidget.O00000o(), (float) constraintWidget.O00000oO(), (float) constraintWidget.O00000oo());
        oOO0OOo0.O000000o O00000oo2 = ooo0ooo0.O00000oo(this.O00000Oo);
        this.O00000o.O000000o(O00000oo2);
        this.O0000Oo0 = O00000oo2.O00000o0.O00000oo;
        this.O00000oo.O000000o(constraintWidget, ooo0ooo0, this.O00000Oo);
    }

    public final void O00000Oo(ConstraintWidget constraintWidget, oOO0OOo0 ooo0ooo0) {
        oO00O00o oo00o00o = this.O00000oO;
        oo00o00o.O00000o = 1.0f;
        oo00o00o.O00000oO = 1.0f;
        O000000o(oo00o00o);
        this.O00000oO.O000000o((float) constraintWidget.O00000o0(), (float) constraintWidget.O00000o(), (float) constraintWidget.O00000oO(), (float) constraintWidget.O00000oo());
        this.O00000oO.O000000o(ooo0ooo0.O00000oo(this.O00000Oo));
        this.O0000oOo.O000000o(constraintWidget, ooo0ooo0, this.O00000Oo);
    }

    public final float O000000o(float f, float[] fArr) {
        float f2 = 0.0f;
        float f3 = 1.0f;
        if (fArr != null) {
            fArr[0] = 1.0f;
        } else if (((double) this.O0000OoO) != 1.0d) {
            if (f < this.O0000Oo) {
                f = 0.0f;
            }
            float f4 = this.O0000Oo;
            if (f > f4 && ((double) f) < 1.0d) {
                f = (f - f4) * this.O0000OoO;
            }
        }
        o0OO0o00 o0oo0o00 = this.O00000o.O00000Oo;
        float f5 = Float.NaN;
        Iterator<oO00O00o> it = this.O00oOooO.iterator();
        while (it.hasNext()) {
            oO00O00o next = it.next();
            if (next.O00000Oo != null) {
                if (next.O00000o < f) {
                    o0oo0o00 = next.O00000Oo;
                    f2 = next.O00000o;
                } else if (Float.isNaN(f5)) {
                    f5 = next.O00000o;
                }
            }
        }
        if (o0oo0o00 != null) {
            if (!Float.isNaN(f5)) {
                f3 = f5;
            }
            float f6 = f3 - f2;
            double d = (double) ((f - f2) / f6);
            f = (((float) o0oo0o00.O000000o(d)) * f6) + f2;
            if (fArr != null) {
                fArr[0] = (float) o0oo0o00.O00000Oo(d);
            }
        }
        return f;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v46, resolved type: _m_j.oO00O0o0} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v14, resolved type: _m_j.oO00O0o0$O00000o} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x0332  */
    /* JADX WARNING: Removed duplicated region for block: B:166:0x034b  */
    /* JADX WARNING: Removed duplicated region for block: B:210:0x0427 A[SYNTHETIC, Splitter:B:210:0x0427] */
    /* JADX WARNING: Removed duplicated region for block: B:223:0x049c A[SYNTHETIC, Splitter:B:223:0x049c] */
    public final boolean O000000o(View view, float f, long j, oO0Ooo00 oo0ooo00) {
        boolean z;
        boolean z2;
        View view2;
        float f2;
        boolean z3;
        double d;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        boolean z9;
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        boolean z15;
        oO00O00o oo00o00o;
        int i;
        View view3 = view;
        oO00O0o0.O00000o o00000o = null;
        float O000000o2 = O000000o(f, (float[]) null);
        HashMap<String, oO0O0OoO> hashMap = this.O0000o;
        if (hashMap != null) {
            for (oO0O0OoO O000000o3 : hashMap.values()) {
                O000000o3.O000000o(view3, O000000o2);
            }
        }
        HashMap<String, oO00O0o0> hashMap2 = this.O00oOooo;
        if (hashMap2 != null) {
            oO00O0o0.O00000o o00000o2 = null;
            boolean z16 = false;
            for (oO00O0o0 next : hashMap2.values()) {
                if (next instanceof oO00O0o0.O00000o) {
                    o00000o2 = next;
                } else {
                    z16 |= next.O000000o(view, O000000o2, j, oo0ooo00);
                }
            }
            z = z16;
            o00000o = o00000o2;
        } else {
            z = false;
        }
        o0OOoOO0[] o0ooooo0Arr = this.O0000O0o;
        if (o0ooooo0Arr != null) {
            double d2 = (double) O000000o2;
            o0ooooo0Arr[0].O000000o(d2, this.O0000o00);
            this.O0000O0o[0].O00000Oo(d2, this.O0000o0);
            o0OOoOO0 o0ooooo0 = this.O0000OOo;
            if (o0ooooo0 != null) {
                double[] dArr = this.O0000o00;
                if (dArr.length > 0) {
                    o0ooooo0.O000000o(d2, dArr);
                    this.O0000OOo.O00000Oo(d2, this.O0000o0);
                }
            }
            oO00O00o oo00o00o2 = this.O00000o;
            int[] iArr = this.O0000Ooo;
            double[] dArr2 = this.O0000o00;
            double[] dArr3 = this.O0000o0;
            float f3 = oo00o00o2.O00000oo;
            float f4 = oo00o00o2.O0000O0o;
            float f5 = oo00o00o2.O0000OOo;
            float f6 = oo00o00o2.O0000Oo0;
            if (iArr.length != 0) {
                f2 = f5;
                if (oo00o00o2.O0000o0O.length <= iArr[iArr.length - 1]) {
                    int i2 = iArr[iArr.length - 1] + 1;
                    oo00o00o2.O0000o0O = new double[i2];
                    oo00o00o2.O0000o0o = new double[i2];
                }
            } else {
                f2 = f5;
            }
            double d3 = d2;
            float f7 = f3;
            Arrays.fill(oo00o00o2.O0000o0O, Double.NaN);
            for (int i3 = 0; i3 < iArr.length; i3++) {
                oo00o00o2.O0000o0O[iArr[i3]] = dArr2[i3];
                oo00o00o2.O0000o0o[iArr[i3]] = dArr3[i3];
            }
            float f8 = f6;
            int i4 = 0;
            float f9 = Float.NaN;
            float f10 = 0.0f;
            float f11 = 0.0f;
            float f12 = 0.0f;
            float f13 = 0.0f;
            while (i4 < oo00o00o2.O0000o0O.length) {
                if (!Double.isNaN(oo00o00o2.O0000o0O[i4])) {
                    double d4 = 0.0d;
                    if (!Double.isNaN(oo00o00o2.O0000o0O[i4])) {
                        d4 = oo00o00o2.O0000o0O[i4] + 0.0d;
                    }
                    int i5 = i4;
                    oo00o00o = oo00o00o2;
                    float f14 = (float) d4;
                    float f15 = (float) oo00o00o2.O0000o0o[i5];
                    if (i5 != 0) {
                        i = i5;
                        if (i == 1) {
                            f10 = f15;
                            f7 = f14;
                        } else if (i == 2) {
                            f12 = f15;
                            f4 = f14;
                        } else if (i == 3) {
                            f11 = f15;
                            f2 = f14;
                        } else if (i == 4) {
                            f13 = f15;
                            f8 = f14;
                        } else if (i == 5) {
                            f9 = f14;
                        }
                    } else {
                        i = i5;
                    }
                } else {
                    oo00o00o = oo00o00o2;
                    i = i4;
                }
                i4 = i + 1;
                oo00o00o2 = oo00o00o;
            }
            if (Float.isNaN(f9)) {
                if (!Float.isNaN(Float.NaN)) {
                    view3.setRotation(Float.NaN);
                }
                z3 = z;
            } else {
                float f16 = Float.NaN;
                if (Float.isNaN(Float.NaN)) {
                    f16 = 0.0f;
                }
                double d5 = (double) f16;
                double d6 = (double) f9;
                z3 = z;
                double degrees = Math.toDegrees(Math.atan2((double) (f12 + (f13 / 2.0f)), (double) (f10 + (f11 / 2.0f))));
                Double.isNaN(d6);
                Double.isNaN(d5);
                view3.setRotation((float) (d5 + d6 + degrees));
            }
            float f17 = f7 + 0.5f;
            int i6 = (int) f17;
            float f18 = f4 + 0.5f;
            int i7 = (int) f18;
            int i8 = (int) (f17 + f2);
            int i9 = (int) (f18 + f8);
            int i10 = i8 - i6;
            int i11 = i9 - i7;
            if ((i10 == view.getMeasuredWidth() && i11 == view.getMeasuredHeight()) ? false : true) {
                view3.measure(View.MeasureSpec.makeMeasureSpec(i10, 1073741824), View.MeasureSpec.makeMeasureSpec(i11, 1073741824));
            }
            view3.layout(i6, i7, i8, i9);
            HashMap<String, oO0O0OoO> hashMap3 = this.O0000o;
            if (hashMap3 != null) {
                for (oO0O0OoO next2 : hashMap3.values()) {
                    if (next2 instanceof oO0O0OoO.O00000o) {
                        double[] dArr4 = this.O0000o0;
                        view3.setRotation(((oO0O0OoO.O00000o) next2).O000000o(O000000o2) + ((float) Math.toDegrees(Math.atan2(dArr4[1], dArr4[0]))));
                    }
                }
            }
            if (o00000o != null) {
                double[] dArr5 = this.O0000o0;
                d = d3;
                z4 = z3 | o00000o.O000000o(view, oo0ooo00, O000000o2, j, dArr5[0], dArr5[1]);
            } else {
                d = d3;
                z4 = z3;
            }
            int i12 = 1;
            while (true) {
                o0OOoOO0[] o0ooooo0Arr2 = this.O0000O0o;
                if (i12 >= o0ooooo0Arr2.length) {
                    break;
                }
                o0ooooo0Arr2[i12].O000000o(d, this.O0000ooo);
                this.O00000o.O0000o00.get(this.O0000oo0[i12 - 1]).O000000o(view3, this.O0000ooo);
                i12++;
            }
            if (this.O00000oo.O00000Oo == 0) {
                if (O000000o2 <= 0.0f) {
                    view3.setVisibility(this.O00000oo.O00000o0);
                } else if (O000000o2 >= 1.0f) {
                    view3.setVisibility(this.O0000oOo.O00000o0);
                } else if (this.O0000oOo.O00000o0 != this.O00000oo.O00000o0) {
                    view3.setVisibility(0);
                }
            }
            if (this.O000O00o != null) {
                int i13 = 0;
                while (true) {
                    oO000Oo0[] oo000oo0Arr = this.O000O00o;
                    if (i13 >= oo000oo0Arr.length) {
                        break;
                    }
                    oO000Oo0 oo000oo0 = oo000oo0Arr[i13];
                    if (oo000oo0.O0000Ooo != oO000Oo0.f2264O000000o) {
                        if (oo000oo0.O0000o00 == null) {
                            oo000oo0.O0000o00 = ((ViewGroup) view.getParent()).findViewById(oo000oo0.O0000Ooo);
                        }
                        oO000Oo0.O000000o(oo000oo0.O0000ooO, oo000oo0.O0000o00, oo000oo0.O0000oo);
                        oO000Oo0.O000000o(oo000oo0.O0000ooo, view3, oo000oo0.O0000oo);
                        if (oo000oo0.O0000ooO.intersect(oo000oo0.O0000ooo)) {
                            if (oo000oo0.O0000o0O) {
                                z13 = false;
                                oo000oo0.O0000o0O = false;
                                z6 = true;
                            } else {
                                z13 = false;
                                z6 = false;
                            }
                            if (oo000oo0.O0000o) {
                                oo000oo0.O0000o = z13;
                                z15 = true;
                                z14 = true;
                            } else {
                                z15 = true;
                                z14 = false;
                            }
                            oo000oo0.O0000o0o = z15;
                            z7 = z14;
                            z5 = false;
                        } else {
                            if (!oo000oo0.O0000o0O) {
                                oo000oo0.O0000o0O = true;
                                z12 = true;
                            } else {
                                z12 = false;
                            }
                            if (oo000oo0.O0000o0o) {
                                oo000oo0.O0000o0o = false;
                                z5 = true;
                            } else {
                                z5 = false;
                            }
                            oo000oo0.O0000o = true;
                            z7 = false;
                        }
                    } else {
                        if (oo000oo0.O0000o0O) {
                            if ((O000000o2 - oo000oo0.O0000oO0) * (oo000oo0.O0000oo0 - oo000oo0.O0000oO0) < 0.0f) {
                                oo000oo0.O0000o0O = false;
                                z11 = true;
                            } else {
                                z11 = false;
                            }
                            z10 = z11;
                        } else {
                            if (Math.abs(O000000o2 - oo000oo0.O0000oO0) > oo000oo0.O0000o0) {
                                oo000oo0.O0000o0O = true;
                            }
                            z10 = false;
                        }
                        if (oo000oo0.O0000o0o) {
                            float f19 = O000000o2 - oo000oo0.O0000oO0;
                            if ((oo000oo0.O0000oo0 - oo000oo0.O0000oO0) * f19 < 0.0f && f19 < 0.0f) {
                                oo000oo0.O0000o0o = false;
                                z9 = true;
                                if (!oo000oo0.O0000o) {
                                    float f20 = O000000o2 - oo000oo0.O0000oO0;
                                    if ((oo000oo0.O0000oo0 - oo000oo0.O0000oO0) * f20 < 0.0f && f20 > 0.0f) {
                                        oo000oo0.O0000o = false;
                                        z7 = true;
                                    }
                                } else if (Math.abs(O000000o2 - oo000oo0.O0000oO0) > oo000oo0.O0000o0) {
                                    oo000oo0.O0000o = true;
                                }
                                z7 = false;
                            }
                        } else if (Math.abs(O000000o2 - oo000oo0.O0000oO0) > oo000oo0.O0000o0) {
                            oo000oo0.O0000o0o = true;
                        }
                        z9 = false;
                        if (!oo000oo0.O0000o) {
                        }
                        z7 = false;
                    }
                    oo000oo0.O0000oo0 = O000000o2;
                    if (z5 || z6 || z7) {
                        MotionLayout motionLayout = (MotionLayout) view.getParent();
                        if (motionLayout.O000O0Oo != null) {
                            Iterator<MotionLayout.O0000Oo0> it = motionLayout.O000O0Oo.iterator();
                            while (it.hasNext()) {
                                it.next();
                            }
                        }
                    }
                    View findViewById = oo000oo0.O0000OOo == oO000Oo0.f2264O000000o ? view3 : ((MotionLayout) view.getParent()).findViewById(oo000oo0.O0000OOo);
                    if (!z5 || oo000oo0.O0000Oo0 == null) {
                        z8 = z4;
                    } else {
                        if (oo000oo0.O0000oOO == null) {
                            try {
                                z8 = z4;
                                try {
                                    oo000oo0.O0000oOO = findViewById.getClass().getMethod(oo000oo0.O0000Oo0, new Class[0]);
                                } catch (NoSuchMethodException unused) {
                                }
                            } catch (NoSuchMethodException unused2) {
                                z8 = z4;
                                Log.e("KeyTrigger", "Could not find method \"" + oo000oo0.O0000Oo0 + "\"on class " + findViewById.getClass().getSimpleName() + " " + oO00000o.O000000o(findViewById));
                                oo000oo0.O0000oOO.invoke(findViewById, new Object[0]);
                                if (oo000oo0.O0000oOo == null) {
                                }
                                try {
                                    oo000oo0.O0000oOo.invoke(findViewById, new Object[0]);
                                } catch (Exception unused3) {
                                    Log.e("KeyTrigger", "Exception in call \"" + oo000oo0.O0000Oo + "\"on class " + findViewById.getClass().getSimpleName() + " " + oO00000o.O000000o(findViewById));
                                }
                                if (oo000oo0.O0000oO == null) {
                                }
                                try {
                                    oo000oo0.O0000oO.invoke(findViewById, new Object[0]);
                                } catch (Exception unused4) {
                                    Log.e("KeyTrigger", "Exception in call \"" + oo000oo0.O0000O0o + "\"on class " + findViewById.getClass().getSimpleName() + " " + oO00000o.O000000o(findViewById));
                                }
                                i13++;
                                view3 = view;
                                z4 = z8;
                            }
                        } else {
                            z8 = z4;
                        }
                        try {
                            oo000oo0.O0000oOO.invoke(findViewById, new Object[0]);
                        } catch (Exception unused5) {
                            Log.e("KeyTrigger", "Exception in call \"" + oo000oo0.O0000Oo0 + "\"on class " + findViewById.getClass().getSimpleName() + " " + oO00000o.O000000o(findViewById));
                        }
                    }
                    if (z7 && oo000oo0.O0000Oo != null) {
                        if (oo000oo0.O0000oOo == null) {
                            try {
                                oo000oo0.O0000oOo = findViewById.getClass().getMethod(oo000oo0.O0000Oo, new Class[0]);
                            } catch (NoSuchMethodException unused6) {
                                Log.e("KeyTrigger", "Could not find method \"" + oo000oo0.O0000Oo + "\"on class " + findViewById.getClass().getSimpleName() + " " + oO00000o.O000000o(findViewById));
                            }
                        }
                        oo000oo0.O0000oOo.invoke(findViewById, new Object[0]);
                    }
                    if (z6 && oo000oo0.O0000O0o != null) {
                        if (oo000oo0.O0000oO == null) {
                            try {
                                oo000oo0.O0000oO = findViewById.getClass().getMethod(oo000oo0.O0000O0o, new Class[0]);
                            } catch (NoSuchMethodException unused7) {
                                Log.e("KeyTrigger", "Could not find method \"" + oo000oo0.O0000O0o + "\"on class " + findViewById.getClass().getSimpleName() + " " + oO00000o.O000000o(findViewById));
                            }
                        }
                        oo000oo0.O0000oO.invoke(findViewById, new Object[0]);
                    }
                    i13++;
                    view3 = view;
                    z4 = z8;
                }
            }
            view2 = view;
            z2 = z4;
        } else {
            z2 = z;
            float f21 = this.O00000o.O00000oo + ((this.O00000oO.O00000oo - this.O00000o.O00000oo) * O000000o2) + 0.5f;
            int i14 = (int) f21;
            float f22 = this.O00000o.O0000O0o + ((this.O00000oO.O0000O0o - this.O00000o.O0000O0o) * O000000o2) + 0.5f;
            int i15 = (int) f22;
            int i16 = (int) (f21 + this.O00000o.O0000OOo + ((this.O00000oO.O0000OOo - this.O00000o.O0000OOo) * O000000o2));
            int i17 = (int) (f22 + this.O00000o.O0000Oo0 + ((this.O00000oO.O0000Oo0 - this.O00000o.O0000Oo0) * O000000o2));
            int i18 = i16 - i14;
            int i19 = i17 - i15;
            if (this.O00000oO.O0000OOo == this.O00000o.O0000OOo && this.O00000oO.O0000Oo0 == this.O00000o.O0000Oo0) {
                view2 = view;
            } else {
                view2 = view;
                view2.measure(View.MeasureSpec.makeMeasureSpec(i18, 1073741824), View.MeasureSpec.makeMeasureSpec(i19, 1073741824));
            }
            view2.layout(i14, i15, i16, i17);
        }
        HashMap<String, oO0OoOO0> hashMap4 = this.O0000oO0;
        if (hashMap4 != null) {
            for (oO0OoOO0 next3 : hashMap4.values()) {
                if (next3 instanceof oO0OoOO0.O0000O0o) {
                    double[] dArr6 = this.O0000o0;
                    view2.setRotation(((oO0OoOO0.O0000O0o) next3).O000000o(O000000o2) + ((float) Math.toDegrees(Math.atan2(dArr6[1], dArr6[0]))));
                } else {
                    next3.O000000o(view2, O000000o2);
                }
            }
        }
        return z2;
    }

    public final void O000000o(float f, float f2, float f3, float[] fArr) {
        double[] dArr;
        float O000000o2 = O000000o(f, this.O0000o0O);
        o0OOoOO0[] o0ooooo0Arr = this.O0000O0o;
        int i = 0;
        if (o0ooooo0Arr != null) {
            double d = (double) O000000o2;
            o0ooooo0Arr[0].O00000Oo(d, this.O0000o0);
            this.O0000O0o[0].O000000o(d, this.O0000o00);
            float f4 = this.O0000o0O[0];
            while (true) {
                dArr = this.O0000o0;
                if (i >= dArr.length) {
                    break;
                }
                double d2 = dArr[i];
                double d3 = (double) f4;
                Double.isNaN(d3);
                dArr[i] = d2 * d3;
                i++;
            }
            o0OOoOO0 o0ooooo0 = this.O0000OOo;
            if (o0ooooo0 != null) {
                double[] dArr2 = this.O0000o00;
                if (dArr2.length > 0) {
                    o0ooooo0.O000000o(d, dArr2);
                    this.O0000OOo.O00000Oo(d, this.O0000o0);
                    oO00O00o.O000000o(f2, f3, fArr, this.O0000Ooo, this.O0000o0);
                    return;
                }
                return;
            }
            oO00O00o.O000000o(f2, f3, fArr, this.O0000Ooo, dArr);
            return;
        }
        float f5 = this.O00000oO.O00000oo - this.O00000o.O00000oo;
        float f6 = this.O00000oO.O0000O0o - this.O00000o.O0000O0o;
        float f7 = (this.O00000oO.O0000Oo0 - this.O00000o.O0000Oo0) + f6;
        fArr[0] = (f5 * (1.0f - f2)) + (((this.O00000oO.O0000OOo - this.O00000o.O0000OOo) + f5) * f2);
        fArr[1] = (f6 * (1.0f - f3)) + (f7 * f3);
    }

    public final int O000000o() {
        int i = this.O00000o.O00000o0;
        Iterator<oO00O00o> it = this.O00oOooO.iterator();
        while (it.hasNext()) {
            i = Math.max(i, it.next().O00000o0);
        }
        return Math.max(i, this.O00000oO.O00000o0);
    }
}
