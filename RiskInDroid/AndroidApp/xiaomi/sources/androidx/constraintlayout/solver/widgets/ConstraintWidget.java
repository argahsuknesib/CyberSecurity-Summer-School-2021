package androidx.constraintlayout.solver.widgets;

import _m_j.oO00OOOo;
import _m_j.oO00OOo0;
import _m_j.oO00Oo00;
import _m_j.oO0O000o;
import _m_j.oOO0O000;
import _m_j.oOO0O0O0;
import _m_j.oOo0000O;
import _m_j.oOo00ooO;
import _m_j.oOo0oooO;
import _m_j.ooOOO00O;
import androidx.constraintlayout.solver.SolverVariable;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.analyzer.WidgetRun;
import com.google.android.exoplayer2.C;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class ConstraintWidget {
    public static float O000o00O = 0.5f;

    /* renamed from: O000000o  reason: collision with root package name */
    private int f2789O000000o;
    private String O00000Oo;
    public boolean O00000o = false;
    public WidgetRun[] O00000oO = new WidgetRun[2];
    public ooOOO00O O00000oo;
    public ooOOO00O O0000O0o;
    public oOO0O000 O0000OOo = new oOO0O000(this);
    public boolean[] O0000Oo = {true, true};
    public oOO0O0O0 O0000Oo0 = new oOO0O0O0(this);
    public int[] O0000OoO = {0, 0, 0, 0};
    boolean O0000Ooo = false;
    public int[] O0000o = new int[2];
    public int O0000o0 = -1;
    public int O0000o00 = -1;
    public int O0000o0O = 0;
    public int O0000o0o = 0;
    public int O0000oO = 0;
    public int O0000oO0 = 0;
    public float O0000oOO = 1.0f;
    public int O0000oOo = 0;
    public float O0000oo = 1.0f;
    public int O0000oo0 = 0;
    public boolean O0000ooO;
    public boolean O0000ooo;
    public int[] O000O00o = {Integer.MAX_VALUE, Integer.MAX_VALUE};
    public float O000O0OO = 0.0f;
    public boolean O000O0Oo = false;
    public ConstraintAnchor O000O0o = new ConstraintAnchor(this, ConstraintAnchor.Type.LEFT);
    protected boolean O000O0o0 = false;
    public ConstraintAnchor O000O0oO = new ConstraintAnchor(this, ConstraintAnchor.Type.TOP);
    public ConstraintAnchor O000O0oo = new ConstraintAnchor(this, ConstraintAnchor.Type.RIGHT);
    ConstraintAnchor O000OO = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_X);
    public ConstraintAnchor O000OO00 = new ConstraintAnchor(this, ConstraintAnchor.Type.BOTTOM);
    public ConstraintAnchor O000OO0o = new ConstraintAnchor(this, ConstraintAnchor.Type.BASELINE);
    ConstraintAnchor O000OOOo = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_Y);
    public ConstraintAnchor[] O000OOo = {this.O000O0o, this.O000O0oo, this.O000O0oO, this.O000OO00, this.O000OO0o, this.O000OOo0};
    ConstraintAnchor O000OOo0 = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER);
    protected ArrayList<ConstraintAnchor> O000OOoO = new ArrayList<>();
    protected boolean[] O000OOoo = new boolean[2];
    public ConstraintWidget O000Oo0 = null;
    public DimensionBehaviour[] O000Oo00 = {DimensionBehaviour.FIXED, DimensionBehaviour.FIXED};
    int O000Oo0O = 0;
    int O000Oo0o = 0;
    protected int O000OoO = 0;
    public float O000OoO0 = 0.0f;
    protected int O000OoOO = 0;
    int O000OoOo = 0;
    protected int O000Ooo = 0;
    int O000Ooo0 = 0;
    protected int O000OooO = 0;
    public int O000Oooo = 0;
    boolean O000o;
    public float O000o0;
    protected int O000o00;
    protected int O000o000;
    public float O000o00o;
    public int O000o0O;
    public Object O000o0O0;
    public String O000o0OO;
    int O000o0Oo;
    int O000o0o;
    int O000o0o0;
    int O000o0oo;
    boolean O000oO;
    boolean O000oO0;
    boolean O000oO00;
    boolean O000oO0O;
    boolean O000oO0o;
    boolean O000oOO;
    boolean O000oOO0;
    public int O000oOOO;
    public int O000oOOo;
    boolean O000oOo;
    boolean O000oOo0;
    public float[] O000oOoO;
    public ConstraintWidget[] O000oOoo;
    public ConstraintWidget[] O000oo0;
    ConstraintWidget O000oo0O;
    ConstraintWidget O000oo0o;
    protected int O00O0Oo = -1;
    public boolean O00oOoOo;
    int O00oOooO = -1;
    float O00oOooo = 1.0f;

    public enum DimensionBehaviour {
        FIXED,
        WRAP_CONTENT,
        MATCH_CONSTRAINT,
        MATCH_PARENT
    }

    public final WidgetRun O000000o(int i) {
        if (i == 0) {
            return this.O0000OOo;
        }
        if (i == 1) {
            return this.O0000Oo0;
        }
        return null;
    }

    public void O00000Oo() {
        this.O000O0o.O00000o();
        this.O000O0oO.O00000o();
        this.O000O0oo.O00000o();
        this.O000OO00.O00000o();
        this.O000OO0o.O00000o();
        this.O000OO.O00000o();
        this.O000OOOo.O00000o();
        this.O000OOo0.O00000o();
        this.O000Oo0 = null;
        this.O000O0OO = 0.0f;
        this.O000Oo0O = 0;
        this.O000Oo0o = 0;
        this.O000OoO0 = 0.0f;
        this.O00O0Oo = -1;
        this.O000OoO = 0;
        this.O000OoOO = 0;
        this.O000Ooo = 0;
        this.O000OooO = 0;
        this.O000Oooo = 0;
        this.O000o000 = 0;
        this.O000o00 = 0;
        float f = O000o00O;
        this.O000o00o = f;
        this.O000o0 = f;
        this.O000Oo00[0] = DimensionBehaviour.FIXED;
        this.O000Oo00[1] = DimensionBehaviour.FIXED;
        this.O000o0O0 = null;
        this.f2789O000000o = 0;
        this.O000o0O = 0;
        this.O00000Oo = null;
        this.O000oO0o = false;
        this.O000oO = false;
        this.O000oOOO = 0;
        this.O000oOOo = 0;
        this.O000oOo0 = false;
        this.O000oOo = false;
        float[] fArr = this.O000oOoO;
        fArr[0] = -1.0f;
        fArr[1] = -1.0f;
        this.O0000o00 = -1;
        this.O0000o0 = -1;
        int[] iArr = this.O000O00o;
        iArr[0] = Integer.MAX_VALUE;
        iArr[1] = Integer.MAX_VALUE;
        this.O0000o0O = 0;
        this.O0000o0o = 0;
        this.O0000oOO = 1.0f;
        this.O0000oo = 1.0f;
        this.O0000oO = Integer.MAX_VALUE;
        this.O0000oo0 = Integer.MAX_VALUE;
        this.O0000oO0 = 0;
        this.O0000oOo = 0;
        this.O0000Ooo = false;
        this.O00oOooO = -1;
        this.O00oOooo = 1.0f;
        this.O000oOO0 = false;
        this.O000oOO = false;
        boolean[] zArr = this.O0000Oo;
        zArr[0] = true;
        zArr[1] = true;
        this.O000O0o0 = false;
        boolean[] zArr2 = this.O000OOoo;
        zArr2[0] = false;
        zArr2[1] = false;
    }

    public ConstraintWidget() {
        float f = O000o00O;
        this.O000o00o = f;
        this.O000o0 = f;
        this.f2789O000000o = 0;
        this.O000o0O = 0;
        this.O000o0OO = null;
        this.O00000Oo = null;
        this.O000oOO0 = false;
        this.O000oOO = false;
        this.O000oOOO = 0;
        this.O000oOOo = 0;
        this.O000oOoO = new float[]{-1.0f, -1.0f};
        this.O000oOoo = new ConstraintWidget[]{null, null};
        this.O000oo0 = new ConstraintWidget[]{null, null};
        this.O000oo0O = null;
        this.O000oo0o = null;
        this.O000OOoO.add(this.O000O0o);
        this.O000OOoO.add(this.O000O0oO);
        this.O000OOoO.add(this.O000O0oo);
        this.O000OOoO.add(this.O000OO00);
        this.O000OOoO.add(this.O000OO);
        this.O000OOoO.add(this.O000OOOo);
        this.O000OOoO.add(this.O000OOo0);
        this.O000OOoO.add(this.O000OO0o);
    }

    public void O000000o(oO00OOo0 oo00ooo0) {
        this.O000O0o.O00000Oo();
        this.O000O0oO.O00000Oo();
        this.O000O0oo.O00000Oo();
        this.O000OO00.O00000Oo();
        this.O000OO0o.O00000Oo();
        this.O000OOo0.O00000Oo();
        this.O000OO.O00000Oo();
        this.O000OOOo.O00000Oo();
    }

    public final void O00000Oo(oO00Oo00 oo00oo00) {
        oo00oo00.O000000o(this.O000O0o);
        oo00oo00.O000000o(this.O000O0oO);
        oo00oo00.O000000o(this.O000O0oo);
        oo00oo00.O000000o(this.O000OO00);
        if (this.O000Oooo > 0) {
            oo00oo00.O000000o(this.O000OO0o);
        }
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        String str2 = "";
        if (this.O00000Oo != null) {
            str = "type: " + this.O00000Oo + " ";
        } else {
            str = str2;
        }
        sb.append(str);
        if (this.O000o0OO != null) {
            str2 = "id: " + this.O000o0OO + " ";
        }
        sb.append(str2);
        sb.append("(");
        sb.append(this.O000OoO);
        sb.append(", ");
        sb.append(this.O000OoOO);
        sb.append(") - (");
        sb.append(this.O000Oo0O);
        sb.append(" x ");
        sb.append(this.O000Oo0o);
        sb.append(")");
        return sb.toString();
    }

    public final int O00000o0() {
        ConstraintWidget constraintWidget = this.O000Oo0;
        if (constraintWidget == null || !(constraintWidget instanceof oOo0000O)) {
            return this.O000OoO;
        }
        return ((oOo0000O) constraintWidget).O000ooOO + this.O000OoO;
    }

    public final int O00000o() {
        ConstraintWidget constraintWidget = this.O000Oo0;
        if (constraintWidget == null || !(constraintWidget instanceof oOo0000O)) {
            return this.O000OoOO;
        }
        return ((oOo0000O) constraintWidget).O000ooOo + this.O000OoOO;
    }

    public final int O00000oO() {
        if (this.O000o0O == 8) {
            return 0;
        }
        return this.O000Oo0O;
    }

    public final int O00000oo() {
        if (this.O000o0O == 8) {
            return 0;
        }
        return this.O000Oo0o;
    }

    public final int O0000O0o() {
        return this.O000o000;
    }

    public final int O0000OOo() {
        return this.O000o00;
    }

    public final int O0000Oo0() {
        return O00000o0() + this.O000Oo0O;
    }

    public final int O0000Oo() {
        return O00000o() + this.O000Oo0o;
    }

    public final float O00000Oo(int i) {
        if (i == 0) {
            return this.O000o00o;
        }
        if (i == 1) {
            return this.O000o0;
        }
        return -1.0f;
    }

    public final void O00000o0(int i) {
        this.O000OoO = i;
    }

    public final void O00000o(int i) {
        this.O000OoOO = i;
    }

    public final void O000000o(int i, int i2) {
        this.O000OoO = i;
        this.O000OoOO = i2;
    }

    public final void O00000oO(int i) {
        this.O000Oo0O = i;
        int i2 = this.O000Oo0O;
        int i3 = this.O000o000;
        if (i2 < i3) {
            this.O000Oo0O = i3;
        }
    }

    public final void O00000oo(int i) {
        this.O000Oo0o = i;
        int i2 = this.O000Oo0o;
        int i3 = this.O000o00;
        if (i2 < i3) {
            this.O000Oo0o = i3;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:43:? A[RETURN, SYNTHETIC] */
    public final void O000000o(String str) {
        float f;
        if (str == null || str.length() == 0) {
            this.O000OoO0 = 0.0f;
            return;
        }
        int i = -1;
        int length = str.length();
        int indexOf = str.indexOf(44);
        int i2 = 0;
        if (indexOf > 0 && indexOf < length - 1) {
            String substring = str.substring(0, indexOf);
            if (substring.equalsIgnoreCase("W")) {
                i = 0;
            } else if (substring.equalsIgnoreCase("H")) {
                i = 1;
            }
            i2 = indexOf + 1;
        }
        int indexOf2 = str.indexOf(58);
        if (indexOf2 < 0 || indexOf2 >= length - 1) {
            String substring2 = str.substring(i2);
            if (substring2.length() > 0) {
                f = Float.parseFloat(substring2);
                if (f > 0.0f) {
                    this.O000OoO0 = f;
                    this.O00O0Oo = i;
                    return;
                }
                return;
            }
        } else {
            String substring3 = str.substring(i2, indexOf2);
            String substring4 = str.substring(indexOf2 + 1);
            if (substring3.length() > 0 && substring4.length() > 0) {
                try {
                    float parseFloat = Float.parseFloat(substring3);
                    float parseFloat2 = Float.parseFloat(substring4);
                    if (parseFloat > 0.0f && parseFloat2 > 0.0f) {
                        f = i == 1 ? Math.abs(parseFloat2 / parseFloat) : Math.abs(parseFloat / parseFloat2);
                        if (f > 0.0f) {
                        }
                    }
                } catch (NumberFormatException unused) {
                }
            }
        }
        f = 0.0f;
        if (f > 0.0f) {
        }
    }

    public final int O0000OoO() {
        return this.O00O0Oo;
    }

    public final void O0000O0o(int i) {
        if (i < 0) {
            this.O000o000 = 0;
        } else {
            this.O000o000 = i;
        }
    }

    public final void O0000OOo(int i) {
        if (i < 0) {
            this.O000o00 = 0;
        } else {
            this.O000o00 = i;
        }
    }

    public final void O00000Oo(int i, int i2) {
        this.O000OoO = i;
        this.O000Oo0O = i2 - i;
        int i3 = this.O000Oo0O;
        int i4 = this.O000o000;
        if (i3 < i4) {
            this.O000Oo0O = i4;
        }
    }

    public final void O00000o0(int i, int i2) {
        this.O000OoOO = i;
        this.O000Oo0o = i2 - i;
        int i3 = this.O000Oo0o;
        int i4 = this.O000o00;
        if (i3 < i4) {
            this.O000Oo0o = i4;
        }
    }

    public final void O0000Oo0(int i) {
        this.O000Oooo = i;
        this.O000O0Oo = i > 0;
    }

    public boolean O000000o() {
        return this.O000o0O != 8;
    }

    public final void O000000o(ConstraintAnchor.Type type, ConstraintWidget constraintWidget, ConstraintAnchor.Type type2, int i, int i2) {
        O000000o(type).O000000o(constraintWidget.O000000o(type2), i, i2, true);
    }

    private void O000000o(ConstraintAnchor.Type type, ConstraintWidget constraintWidget, ConstraintAnchor.Type type2, int i) {
        boolean z;
        if (type == ConstraintAnchor.Type.CENTER) {
            if (type2 == ConstraintAnchor.Type.CENTER) {
                ConstraintAnchor O000000o2 = O000000o(ConstraintAnchor.Type.LEFT);
                ConstraintAnchor O000000o3 = O000000o(ConstraintAnchor.Type.RIGHT);
                ConstraintAnchor O000000o4 = O000000o(ConstraintAnchor.Type.TOP);
                ConstraintAnchor O000000o5 = O000000o(ConstraintAnchor.Type.BOTTOM);
                boolean z2 = true;
                if ((O000000o2 == null || !O000000o2.O00000oO()) && (O000000o3 == null || !O000000o3.O00000oO())) {
                    O000000o(ConstraintAnchor.Type.LEFT, constraintWidget, ConstraintAnchor.Type.LEFT, 0);
                    O000000o(ConstraintAnchor.Type.RIGHT, constraintWidget, ConstraintAnchor.Type.RIGHT, 0);
                    z = true;
                } else {
                    z = false;
                }
                if ((O000000o4 == null || !O000000o4.O00000oO()) && (O000000o5 == null || !O000000o5.O00000oO())) {
                    O000000o(ConstraintAnchor.Type.TOP, constraintWidget, ConstraintAnchor.Type.TOP, 0);
                    O000000o(ConstraintAnchor.Type.BOTTOM, constraintWidget, ConstraintAnchor.Type.BOTTOM, 0);
                } else {
                    z2 = false;
                }
                if (z && z2) {
                    O000000o(ConstraintAnchor.Type.CENTER).O000000o(constraintWidget.O000000o(ConstraintAnchor.Type.CENTER), 0);
                } else if (z) {
                    O000000o(ConstraintAnchor.Type.CENTER_X).O000000o(constraintWidget.O000000o(ConstraintAnchor.Type.CENTER_X), 0);
                } else if (z2) {
                    O000000o(ConstraintAnchor.Type.CENTER_Y).O000000o(constraintWidget.O000000o(ConstraintAnchor.Type.CENTER_Y), 0);
                }
            } else if (type2 == ConstraintAnchor.Type.LEFT || type2 == ConstraintAnchor.Type.RIGHT) {
                O000000o(ConstraintAnchor.Type.LEFT, constraintWidget, type2, 0);
                O000000o(ConstraintAnchor.Type.RIGHT, constraintWidget, type2, 0);
                O000000o(ConstraintAnchor.Type.CENTER).O000000o(constraintWidget.O000000o(type2), 0);
            } else if (type2 == ConstraintAnchor.Type.TOP || type2 == ConstraintAnchor.Type.BOTTOM) {
                O000000o(ConstraintAnchor.Type.TOP, constraintWidget, type2, 0);
                O000000o(ConstraintAnchor.Type.BOTTOM, constraintWidget, type2, 0);
                O000000o(ConstraintAnchor.Type.CENTER).O000000o(constraintWidget.O000000o(type2), 0);
            }
        } else if (type == ConstraintAnchor.Type.CENTER_X && (type2 == ConstraintAnchor.Type.LEFT || type2 == ConstraintAnchor.Type.RIGHT)) {
            ConstraintAnchor O000000o6 = O000000o(ConstraintAnchor.Type.LEFT);
            ConstraintAnchor O000000o7 = constraintWidget.O000000o(type2);
            ConstraintAnchor O000000o8 = O000000o(ConstraintAnchor.Type.RIGHT);
            O000000o6.O000000o(O000000o7, 0);
            O000000o8.O000000o(O000000o7, 0);
            O000000o(ConstraintAnchor.Type.CENTER_X).O000000o(O000000o7, 0);
        } else if (type == ConstraintAnchor.Type.CENTER_Y && (type2 == ConstraintAnchor.Type.TOP || type2 == ConstraintAnchor.Type.BOTTOM)) {
            ConstraintAnchor O000000o9 = constraintWidget.O000000o(type2);
            O000000o(ConstraintAnchor.Type.TOP).O000000o(O000000o9, 0);
            O000000o(ConstraintAnchor.Type.BOTTOM).O000000o(O000000o9, 0);
            O000000o(ConstraintAnchor.Type.CENTER_Y).O000000o(O000000o9, 0);
        } else if (type == ConstraintAnchor.Type.CENTER_X && type2 == ConstraintAnchor.Type.CENTER_X) {
            O000000o(ConstraintAnchor.Type.LEFT).O000000o(constraintWidget.O000000o(ConstraintAnchor.Type.LEFT), 0);
            O000000o(ConstraintAnchor.Type.RIGHT).O000000o(constraintWidget.O000000o(ConstraintAnchor.Type.RIGHT), 0);
            O000000o(ConstraintAnchor.Type.CENTER_X).O000000o(constraintWidget.O000000o(type2), 0);
        } else if (type == ConstraintAnchor.Type.CENTER_Y && type2 == ConstraintAnchor.Type.CENTER_Y) {
            O000000o(ConstraintAnchor.Type.TOP).O000000o(constraintWidget.O000000o(ConstraintAnchor.Type.TOP), 0);
            O000000o(ConstraintAnchor.Type.BOTTOM).O000000o(constraintWidget.O000000o(ConstraintAnchor.Type.BOTTOM), 0);
            O000000o(ConstraintAnchor.Type.CENTER_Y).O000000o(constraintWidget.O000000o(type2), 0);
        } else {
            ConstraintAnchor O000000o10 = O000000o(type);
            ConstraintAnchor O000000o11 = constraintWidget.O000000o(type2);
            if (O000000o10.O000000o(O000000o11)) {
                if (type == ConstraintAnchor.Type.BASELINE) {
                    ConstraintAnchor O000000o12 = O000000o(ConstraintAnchor.Type.TOP);
                    ConstraintAnchor O000000o13 = O000000o(ConstraintAnchor.Type.BOTTOM);
                    if (O000000o12 != null) {
                        O000000o12.O00000o();
                    }
                    if (O000000o13 != null) {
                        O000000o13.O00000o();
                    }
                    i = 0;
                } else if (type == ConstraintAnchor.Type.TOP || type == ConstraintAnchor.Type.BOTTOM) {
                    ConstraintAnchor O000000o14 = O000000o(ConstraintAnchor.Type.BASELINE);
                    if (O000000o14 != null) {
                        O000000o14.O00000o();
                    }
                    ConstraintAnchor O000000o15 = O000000o(ConstraintAnchor.Type.CENTER);
                    if (O000000o15.O00000o0 != O000000o11) {
                        O000000o15.O00000o();
                    }
                    ConstraintAnchor O00000oo2 = O000000o(type).O00000oo();
                    ConstraintAnchor O000000o16 = O000000o(ConstraintAnchor.Type.CENTER_Y);
                    if (O000000o16.O00000oO()) {
                        O00000oo2.O00000o();
                        O000000o16.O00000o();
                    }
                } else if (type == ConstraintAnchor.Type.LEFT || type == ConstraintAnchor.Type.RIGHT) {
                    ConstraintAnchor O000000o17 = O000000o(ConstraintAnchor.Type.CENTER);
                    if (O000000o17.O00000o0 != O000000o11) {
                        O000000o17.O00000o();
                    }
                    ConstraintAnchor O00000oo3 = O000000o(type).O00000oo();
                    ConstraintAnchor O000000o18 = O000000o(ConstraintAnchor.Type.CENTER_X);
                    if (O000000o18.O00000oO()) {
                        O00000oo3.O00000o();
                        O000000o18.O00000o();
                    }
                }
                O000000o10.O000000o(O000000o11, i);
            }
        }
    }

    public final void O0000Ooo() {
        int size = this.O000OOoO.size();
        for (int i = 0; i < size; i++) {
            this.O000OOoO.get(i).O00000o();
        }
    }

    public ConstraintAnchor O000000o(ConstraintAnchor.Type type) {
        switch (AnonymousClass1.f2790O000000o[type.ordinal()]) {
            case 1:
                return this.O000O0o;
            case 2:
                return this.O000O0oO;
            case 3:
                return this.O000O0oo;
            case 4:
                return this.O000OO00;
            case 5:
                return this.O000OO0o;
            case 6:
                return this.O000OOo0;
            case 7:
                return this.O000OO;
            case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER /*8*/:
                return this.O000OOOo;
            case 9:
                return null;
            default:
                throw new AssertionError(type.name());
        }
    }

    public final boolean O0000o00() {
        if (this.O000O0o.O00000o0 == null || this.O000O0o.O00000o0.O00000o0 != this.O000O0o) {
            return this.O000O0oo.O00000o0 != null && this.O000O0oo.O00000o0.O00000o0 == this.O000O0oo;
        }
        return true;
    }

    public final ConstraintWidget O0000OoO(int i) {
        ConstraintAnchor constraintAnchor;
        ConstraintAnchor constraintAnchor2;
        if (i == 0) {
            if (this.O000O0o.O00000o0 == null || this.O000O0o.O00000o0.O00000o0 != (constraintAnchor2 = this.O000O0o)) {
                return null;
            }
            return constraintAnchor2.O00000o0.f2787O000000o;
        } else if (i == 1 && this.O000O0oO.O00000o0 != null && this.O000O0oO.O00000o0.O00000o0 == (constraintAnchor = this.O000O0oO)) {
            return constraintAnchor.O00000o0.f2787O000000o;
        } else {
            return null;
        }
    }

    public final ConstraintWidget O0000Ooo(int i) {
        ConstraintAnchor constraintAnchor;
        ConstraintAnchor constraintAnchor2;
        if (i == 0) {
            if (this.O000O0oo.O00000o0 == null || this.O000O0oo.O00000o0.O00000o0 != (constraintAnchor2 = this.O000O0oo)) {
                return null;
            }
            return constraintAnchor2.O00000o0.f2787O000000o;
        } else if (i == 1 && this.O000OO00.O00000o0 != null && this.O000OO00.O00000o0.O00000o0 == (constraintAnchor = this.O000OO00)) {
            return constraintAnchor.O00000o0.f2787O000000o;
        } else {
            return null;
        }
    }

    public final boolean O0000o0() {
        if (this.O000O0oO.O00000o0 == null || this.O000O0oO.O00000o0.O00000o0 != this.O000O0oO) {
            return this.O000OO00.O00000o0 != null && this.O000OO00.O00000o0.O00000o0 == this.O000OO00;
        }
        return true;
    }

    private boolean O0000o00(int i) {
        int i2 = i * 2;
        if (this.O000OOo[i2].O00000o0 == null) {
            return false;
        }
        ConstraintAnchor constraintAnchor = this.O000OOo[i2].O00000o0.O00000o0;
        ConstraintAnchor[] constraintAnchorArr = this.O000OOo;
        if (constraintAnchor == constraintAnchorArr[i2]) {
            return false;
        }
        int i3 = i2 + 1;
        return constraintAnchorArr[i3].O00000o0 != null && this.O000OOo[i3].O00000o0.O00000o0 == this.O000OOo[i3];
    }

    /* JADX WARNING: Code restructure failed: missing block: B:198:0x033c, code lost:
        if (r5 == -1) goto L_0x0340;
     */
    /* JADX WARNING: Removed duplicated region for block: B:195:0x0337  */
    /* JADX WARNING: Removed duplicated region for block: B:201:0x0343  */
    /* JADX WARNING: Removed duplicated region for block: B:205:0x034e  */
    /* JADX WARNING: Removed duplicated region for block: B:210:0x0359  */
    /* JADX WARNING: Removed duplicated region for block: B:211:0x035c  */
    /* JADX WARNING: Removed duplicated region for block: B:214:0x0374  */
    /* JADX WARNING: Removed duplicated region for block: B:236:0x043d  */
    /* JADX WARNING: Removed duplicated region for block: B:240:0x0453  */
    /* JADX WARNING: Removed duplicated region for block: B:255:0x04b6  */
    /* JADX WARNING: Removed duplicated region for block: B:257:0x04b9  */
    /* JADX WARNING: Removed duplicated region for block: B:294:0x0576  */
    /* JADX WARNING: Removed duplicated region for block: B:296:0x057c  */
    /* JADX WARNING: Removed duplicated region for block: B:300:0x05a3  */
    /* JADX WARNING: Removed duplicated region for block: B:303:0x05ad  */
    /* JADX WARNING: Removed duplicated region for block: B:310:? A[RETURN, SYNTHETIC] */
    public void O000000o(oO00Oo00 oo00oo00) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        int i;
        int i2;
        int i3;
        int i4;
        boolean z5;
        boolean z6;
        SolverVariable solverVariable;
        SolverVariable solverVariable2;
        SolverVariable solverVariable3;
        SolverVariable solverVariable4;
        SolverVariable solverVariable5;
        boolean z7;
        boolean z8;
        oO00Oo00 oo00oo002;
        SolverVariable solverVariable6;
        SolverVariable solverVariable7;
        int i5;
        int i6;
        int i7;
        SolverVariable solverVariable8;
        SolverVariable solverVariable9;
        SolverVariable solverVariable10;
        ConstraintWidget constraintWidget;
        boolean z9;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        boolean z10;
        int i13;
        boolean z11;
        ConstraintWidget constraintWidget2 = this;
        oO00Oo00 oo00oo003 = oo00oo00;
        SolverVariable O000000o2 = oo00oo003.O000000o(constraintWidget2.O000O0o);
        SolverVariable O000000o3 = oo00oo003.O000000o(constraintWidget2.O000O0oo);
        SolverVariable O000000o4 = oo00oo003.O000000o(constraintWidget2.O000O0oO);
        SolverVariable O000000o5 = oo00oo003.O000000o(constraintWidget2.O000OO00);
        SolverVariable O000000o6 = oo00oo003.O000000o(constraintWidget2.O000OO0o);
        if (oO00Oo00.O0000Oo0 != null) {
            oO00Oo00.O0000Oo0.O0000ooo++;
        }
        if (!constraintWidget2.O0000OOo.O0000Oo.O0000Oo || !constraintWidget2.O0000OOo.O0000OoO.O0000Oo || !constraintWidget2.O0000Oo0.O0000Oo.O0000Oo || !constraintWidget2.O0000Oo0.O0000OoO.O0000Oo) {
            if (oO00Oo00.O0000Oo0 != null) {
                oO00Oo00.O0000Oo0.O0000oO++;
            }
            ConstraintWidget constraintWidget3 = constraintWidget2.O000Oo0;
            if (constraintWidget3 != null) {
                boolean z12 = constraintWidget3 != null && constraintWidget3.O000Oo00[0] == DimensionBehaviour.WRAP_CONTENT;
                ConstraintWidget constraintWidget4 = constraintWidget2.O000Oo0;
                boolean z13 = constraintWidget4 != null && constraintWidget4.O000Oo00[1] == DimensionBehaviour.WRAP_CONTENT;
                if (constraintWidget2.O0000o00(0)) {
                    ((oOo0000O) constraintWidget2.O000Oo0).O000000o(constraintWidget2, 0);
                    i13 = 1;
                    z10 = true;
                } else {
                    z10 = O0000o00();
                    i13 = 1;
                }
                if (constraintWidget2.O0000o00(i13)) {
                    ((oOo0000O) constraintWidget2.O000Oo0).O000000o(constraintWidget2, i13);
                    z11 = true;
                } else {
                    z11 = O0000o0();
                }
                if (!z10 && z12 && constraintWidget2.O000o0O != 8 && constraintWidget2.O000O0o.O00000o0 == null && constraintWidget2.O000O0oo.O00000o0 == null) {
                    oo00oo003.O000000o(oo00oo003.O000000o(constraintWidget2.O000Oo0.O000O0oo), O000000o3, 0, 1);
                }
                if (!z11 && z13 && constraintWidget2.O000o0O != 8 && constraintWidget2.O000O0oO.O00000o0 == null && constraintWidget2.O000OO00.O00000o0 == null && constraintWidget2.O000OO0o == null) {
                    oo00oo003.O000000o(oo00oo003.O000000o(constraintWidget2.O000Oo0.O000OO00), O000000o5, 0, 1);
                }
                z2 = z12;
                z = z13;
                z3 = z11;
                z4 = z10;
            } else {
                z4 = false;
                z3 = false;
                z2 = false;
                z = false;
            }
            int i14 = constraintWidget2.O000Oo0O;
            int i15 = constraintWidget2.O000o000;
            if (i14 < i15) {
                i14 = i15;
            }
            int i16 = constraintWidget2.O000Oo0o;
            int i17 = constraintWidget2.O000o00;
            if (i16 < i17) {
                i16 = i17;
            }
            boolean z14 = constraintWidget2.O000Oo00[0] != DimensionBehaviour.MATCH_CONSTRAINT;
            boolean z15 = constraintWidget2.O000Oo00[1] != DimensionBehaviour.MATCH_CONSTRAINT;
            constraintWidget2.O00oOooO = constraintWidget2.O00O0Oo;
            float f = constraintWidget2.O000OoO0;
            constraintWidget2.O00oOooo = f;
            int i18 = constraintWidget2.O0000o0O;
            int i19 = constraintWidget2.O0000o0o;
            int i20 = i16;
            if (f <= 0.0f || constraintWidget2.O000o0O == 8) {
                i9 = i14;
                i10 = i18;
                i11 = i19;
                i12 = i20;
            } else {
                if (constraintWidget2.O000Oo00[0] == DimensionBehaviour.MATCH_CONSTRAINT && i18 == 0) {
                    i18 = 3;
                }
                if (constraintWidget2.O000Oo00[1] == DimensionBehaviour.MATCH_CONSTRAINT && i19 == 0) {
                    i19 = 3;
                }
                if (constraintWidget2.O000Oo00[0] == DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget2.O000Oo00[1] == DimensionBehaviour.MATCH_CONSTRAINT && i18 == 3 && i19 == 3) {
                    if (constraintWidget2.O00oOooO == -1) {
                        if (z14 && !z15) {
                            constraintWidget2.O00oOooO = 0;
                        } else if (!z14 && z15) {
                            constraintWidget2.O00oOooO = 1;
                            if (constraintWidget2.O00O0Oo == -1) {
                                constraintWidget2.O00oOooo = 1.0f / constraintWidget2.O00oOooo;
                            }
                        }
                    }
                    if (constraintWidget2.O00oOooO == 0 && (!constraintWidget2.O000O0oO.O00000oO() || !constraintWidget2.O000OO00.O00000oO())) {
                        constraintWidget2.O00oOooO = 1;
                    } else if (constraintWidget2.O00oOooO == 1 && (!constraintWidget2.O000O0o.O00000oO() || !constraintWidget2.O000O0oo.O00000oO())) {
                        constraintWidget2.O00oOooO = 0;
                    }
                    if (constraintWidget2.O00oOooO == -1 && (!constraintWidget2.O000O0oO.O00000oO() || !constraintWidget2.O000OO00.O00000oO() || !constraintWidget2.O000O0o.O00000oO() || !constraintWidget2.O000O0oo.O00000oO())) {
                        if (constraintWidget2.O000O0oO.O00000oO() && constraintWidget2.O000OO00.O00000oO()) {
                            constraintWidget2.O00oOooO = 0;
                        } else if (constraintWidget2.O000O0o.O00000oO() && constraintWidget2.O000O0oo.O00000oO()) {
                            constraintWidget2.O00oOooo = 1.0f / constraintWidget2.O00oOooo;
                            constraintWidget2.O00oOooO = 1;
                        }
                    }
                    if (constraintWidget2.O00oOooO == -1) {
                        if (constraintWidget2.O0000oO0 > 0 && constraintWidget2.O0000oOo == 0) {
                            constraintWidget2.O00oOooO = 0;
                        } else if (constraintWidget2.O0000oO0 == 0 && constraintWidget2.O0000oOo > 0) {
                            constraintWidget2.O00oOooo = 1.0f / constraintWidget2.O00oOooo;
                            constraintWidget2.O00oOooO = 1;
                        }
                    }
                } else if (constraintWidget2.O000Oo00[0] == DimensionBehaviour.MATCH_CONSTRAINT && i18 == 3) {
                    constraintWidget2.O00oOooO = 0;
                    i14 = (int) (constraintWidget2.O00oOooo * ((float) constraintWidget2.O000Oo0o));
                    if (constraintWidget2.O000Oo00[1] != DimensionBehaviour.MATCH_CONSTRAINT) {
                        i4 = i14;
                        i2 = i19;
                        i = i20;
                        z5 = false;
                        i3 = 4;
                        int[] iArr = constraintWidget2.O0000o;
                        iArr[0] = i3;
                        iArr[1] = i2;
                        constraintWidget2.O0000Ooo = z5;
                        if (!z5) {
                        }
                        z6 = false;
                        if (constraintWidget2.O000Oo00[0] != DimensionBehaviour.WRAP_CONTENT) {
                        }
                        if (r19) {
                        }
                        boolean z16 = !constraintWidget2.O000OOo0.O00000oO();
                        boolean[] zArr = constraintWidget2.O000OOoo;
                        boolean z17 = zArr[0];
                        boolean z18 = zArr[1];
                        SolverVariable solverVariable11 = null;
                        if (constraintWidget2.O0000o00 == 2) {
                        }
                        constraintWidget2 = this;
                        if (constraintWidget2.O0000Oo0.O0000Oo.O0000Oo) {
                        }
                        oo00oo002 = oo00oo00;
                        solverVariable7 = solverVariable5;
                        solverVariable6 = solverVariable4;
                        solverVariable8 = solverVariable;
                        i7 = 8;
                        i6 = 0;
                        i5 = 1;
                        z8 = true;
                        if (constraintWidget2.O0000o0 == 2) {
                        }
                        if (!z8) {
                        }
                        if (!z7) {
                        }
                        if (!constraintWidget.O000OOo0.O00000oO()) {
                        }
                    }
                } else if (constraintWidget2.O000Oo00[1] == DimensionBehaviour.MATCH_CONSTRAINT && i19 == 3) {
                    constraintWidget2.O00oOooO = 1;
                    if (constraintWidget2.O00O0Oo == -1) {
                        constraintWidget2.O00oOooo = 1.0f / constraintWidget2.O00oOooo;
                    }
                    int i21 = (int) (constraintWidget2.O00oOooo * ((float) constraintWidget2.O000Oo0O));
                    if (constraintWidget2.O000Oo00[0] != DimensionBehaviour.MATCH_CONSTRAINT) {
                        i12 = i21;
                        i10 = i18;
                        i11 = 4;
                        i9 = i14;
                    } else {
                        i = i21;
                        i3 = i18;
                        i2 = i19;
                        i4 = i14;
                        z5 = true;
                        int[] iArr2 = constraintWidget2.O0000o;
                        iArr2[0] = i3;
                        iArr2[1] = i2;
                        constraintWidget2.O0000Ooo = z5;
                        if (!z5) {
                            int i22 = constraintWidget2.O00oOooO;
                            if (i22 != 0) {
                            }
                            z6 = true;
                            boolean z19 = constraintWidget2.O000Oo00[0] != DimensionBehaviour.WRAP_CONTENT && (constraintWidget2 instanceof oOo0000O);
                            int i23 = z19 ? 0 : i4;
                            boolean z162 = !constraintWidget2.O000OOo0.O00000oO();
                            boolean[] zArr2 = constraintWidget2.O000OOoo;
                            boolean z172 = zArr2[0];
                            boolean z182 = zArr2[1];
                            SolverVariable solverVariable112 = null;
                            if (constraintWidget2.O0000o00 == 2) {
                                z7 = z5;
                                solverVariable = O000000o6;
                                solverVariable5 = O000000o5;
                                solverVariable4 = O000000o4;
                                solverVariable3 = O000000o3;
                                solverVariable2 = O000000o2;
                            } else if (!constraintWidget2.O0000OOo.O0000Oo.O0000Oo || !constraintWidget2.O0000OOo.O0000OoO.O0000Oo) {
                                ConstraintWidget constraintWidget5 = constraintWidget2.O000Oo0;
                                SolverVariable O000000o7 = constraintWidget5 != null ? oo00oo003.O000000o(constraintWidget5.O000O0oo) : null;
                                ConstraintWidget constraintWidget6 = constraintWidget2.O000Oo0;
                                z7 = z5;
                                solverVariable5 = O000000o5;
                                solverVariable4 = O000000o4;
                                solverVariable3 = O000000o3;
                                solverVariable2 = O000000o2;
                                solverVariable = O000000o6;
                                O000000o(oo00oo00, true, z2, z, constraintWidget2.O0000Oo[0], constraintWidget6 != null ? oo00oo003.O000000o(constraintWidget6.O000O0o) : null, O000000o7, constraintWidget2.O000Oo00[0], z19, constraintWidget2.O000O0o, constraintWidget2.O000O0oo, constraintWidget2.O000OoO, i23, constraintWidget2.O000o000, constraintWidget2.O000O00o[0], constraintWidget2.O000o00o, z6, z4, z3, z172, i3, i2, constraintWidget2.O0000oO0, constraintWidget2.O0000oO, constraintWidget2.O0000oOO, z162);
                            } else {
                                oo00oo003.O000000o(O000000o2, constraintWidget2.O0000OOo.O0000Oo.O0000O0o);
                                oo00oo003.O000000o(O000000o3, constraintWidget2.O0000OOo.O0000OoO.O0000O0o);
                                if (constraintWidget2.O000Oo0 != null && z2 && constraintWidget2.O0000Oo[0] && !O0000o00()) {
                                    oo00oo003.O000000o(oo00oo003.O000000o(constraintWidget2.O000Oo0.O000O0oo), O000000o3, 0, 8);
                                }
                                z7 = z5;
                                solverVariable = O000000o6;
                                solverVariable5 = O000000o5;
                                solverVariable4 = O000000o4;
                                solverVariable3 = O000000o3;
                                solverVariable2 = O000000o2;
                                if (constraintWidget2.O0000Oo0.O0000Oo.O0000Oo || !constraintWidget2.O0000Oo0.O0000OoO.O0000Oo) {
                                    oo00oo002 = oo00oo00;
                                    solverVariable7 = solverVariable5;
                                    solverVariable6 = solverVariable4;
                                    solverVariable8 = solverVariable;
                                    i7 = 8;
                                    i6 = 0;
                                    i5 = 1;
                                    z8 = true;
                                } else {
                                    oo00oo002 = oo00oo00;
                                    solverVariable6 = solverVariable4;
                                    oo00oo002.O000000o(solverVariable6, constraintWidget2.O0000Oo0.O0000Oo.O0000O0o);
                                    solverVariable7 = solverVariable5;
                                    oo00oo002.O000000o(solverVariable7, constraintWidget2.O0000Oo0.O0000OoO.O0000O0o);
                                    solverVariable8 = solverVariable;
                                    oo00oo002.O000000o(solverVariable8, constraintWidget2.O0000Oo0.f2298O000000o.O0000O0o);
                                    ConstraintWidget constraintWidget7 = constraintWidget2.O000Oo0;
                                    if (constraintWidget7 == null || z3 || !z) {
                                        i7 = 8;
                                        i6 = 0;
                                        i5 = 1;
                                    } else {
                                        i5 = 1;
                                        if (constraintWidget2.O0000Oo[1]) {
                                            i7 = 8;
                                            i6 = 0;
                                            oo00oo002.O000000o(oo00oo002.O000000o(constraintWidget7.O000OO00), solverVariable7, 0, 8);
                                        } else {
                                            i7 = 8;
                                            i6 = 0;
                                        }
                                    }
                                    z8 = false;
                                }
                                if (constraintWidget2.O0000o0 == 2) {
                                    z8 = false;
                                }
                                if (!z8) {
                                    boolean z20 = constraintWidget2.O000Oo00[i5] == DimensionBehaviour.WRAP_CONTENT && (constraintWidget2 instanceof oOo0000O);
                                    if (z20) {
                                        i = 0;
                                    }
                                    boolean z21 = z7 && ((i8 = constraintWidget2.O00oOooO) == i5 || i8 == -1);
                                    ConstraintWidget constraintWidget8 = constraintWidget2.O000Oo0;
                                    SolverVariable O000000o8 = constraintWidget8 != null ? oo00oo002.O000000o(constraintWidget8.O000OO00) : null;
                                    ConstraintWidget constraintWidget9 = constraintWidget2.O000Oo0;
                                    if (constraintWidget9 != null) {
                                        solverVariable112 = oo00oo002.O000000o(constraintWidget9.O000O0oO);
                                    }
                                    if (constraintWidget2.O000Oooo > 0 || constraintWidget2.O000o0O == i7) {
                                        oo00oo002.O00000o0(solverVariable8, solverVariable6, constraintWidget2.O000Oooo, i7);
                                        if (constraintWidget2.O000OO0o.O00000o0 != null) {
                                            oo00oo002.O00000o0(solverVariable8, oo00oo002.O000000o(constraintWidget2.O000OO0o.O00000o0), i6, i7);
                                            if (z) {
                                                oo00oo002.O000000o(O000000o8, oo00oo002.O000000o(constraintWidget2.O000OO00), i6, 5);
                                            }
                                            z9 = false;
                                            boolean z22 = z2;
                                            solverVariable10 = solverVariable7;
                                            solverVariable9 = solverVariable6;
                                            O000000o(oo00oo00, false, z, z22, constraintWidget2.O0000Oo[i5], solverVariable112, O000000o8, constraintWidget2.O000Oo00[i5], z20, constraintWidget2.O000O0oO, constraintWidget2.O000OO00, constraintWidget2.O000OoOO, i, constraintWidget2.O000o00, constraintWidget2.O000O00o[i5], constraintWidget2.O000o0, z21, z3, z4, z182, i2, i3, constraintWidget2.O0000oOo, constraintWidget2.O0000oo0, constraintWidget2.O0000oo, z9);
                                        } else if (constraintWidget2.O000o0O == i7) {
                                            oo00oo002.O00000o0(solverVariable8, solverVariable6, i6, i7);
                                        }
                                    }
                                    z9 = z162;
                                    boolean z222 = z2;
                                    solverVariable10 = solverVariable7;
                                    solverVariable9 = solverVariable6;
                                    O000000o(oo00oo00, false, z, z222, constraintWidget2.O0000Oo[i5], solverVariable112, O000000o8, constraintWidget2.O000Oo00[i5], z20, constraintWidget2.O000O0oO, constraintWidget2.O000OO00, constraintWidget2.O000OoOO, i, constraintWidget2.O000o00, constraintWidget2.O000O00o[i5], constraintWidget2.O000o0, z21, z3, z4, z182, i2, i3, constraintWidget2.O0000oOo, constraintWidget2.O0000oo0, constraintWidget2.O0000oo, z9);
                                } else {
                                    solverVariable10 = solverVariable7;
                                    solverVariable9 = solverVariable6;
                                }
                                if (!z7) {
                                    constraintWidget = this;
                                    if (constraintWidget.O00oOooO == 1) {
                                        oo00oo00.O000000o(solverVariable10, solverVariable9, solverVariable3, solverVariable2, constraintWidget.O00oOooo);
                                    } else {
                                        oo00oo00.O000000o(solverVariable3, solverVariable2, solverVariable10, solverVariable9, constraintWidget.O00oOooo);
                                    }
                                } else {
                                    constraintWidget = this;
                                }
                                if (!constraintWidget.O000OOo0.O00000oO()) {
                                    ConstraintWidget constraintWidget10 = constraintWidget.O000OOo0.O00000o0.f2787O000000o;
                                    int O00000o0 = constraintWidget.O000OOo0.O00000o0();
                                    oO00Oo00 oo00oo004 = oo00oo00;
                                    SolverVariable O000000o9 = oo00oo004.O000000o(constraintWidget.O000000o(ConstraintAnchor.Type.LEFT));
                                    SolverVariable O000000o10 = oo00oo004.O000000o(constraintWidget.O000000o(ConstraintAnchor.Type.TOP));
                                    SolverVariable O000000o11 = oo00oo004.O000000o(constraintWidget.O000000o(ConstraintAnchor.Type.RIGHT));
                                    SolverVariable O000000o12 = oo00oo004.O000000o(constraintWidget.O000000o(ConstraintAnchor.Type.BOTTOM));
                                    SolverVariable O000000o13 = oo00oo004.O000000o(constraintWidget10.O000000o(ConstraintAnchor.Type.LEFT));
                                    SolverVariable O000000o14 = oo00oo004.O000000o(constraintWidget10.O000000o(ConstraintAnchor.Type.TOP));
                                    SolverVariable O000000o15 = oo00oo004.O000000o(constraintWidget10.O000000o(ConstraintAnchor.Type.RIGHT));
                                    SolverVariable O000000o16 = oo00oo004.O000000o(constraintWidget10.O000000o(ConstraintAnchor.Type.BOTTOM));
                                    oO00OOOo O00000o02 = oo00oo00.O00000o0();
                                    double radians = (double) ((float) Math.toRadians((double) (constraintWidget.O000O0OO + 90.0f)));
                                    double sin = Math.sin(radians);
                                    double d = (double) O00000o0;
                                    Double.isNaN(d);
                                    O00000o02.O00000Oo(O000000o10, O000000o12, O000000o14, O000000o16, (float) (sin * d));
                                    oo00oo004.O000000o(O00000o02);
                                    oO00OOOo O00000o03 = oo00oo00.O00000o0();
                                    double cos = Math.cos(radians);
                                    Double.isNaN(d);
                                    O00000o03.O00000Oo(O000000o9, O000000o11, O000000o13, O000000o15, (float) (cos * d));
                                    oo00oo004.O000000o(O00000o03);
                                    return;
                                }
                                return;
                            }
                            constraintWidget2 = this;
                            if (constraintWidget2.O0000Oo0.O0000Oo.O0000Oo) {
                            }
                            oo00oo002 = oo00oo00;
                            solverVariable7 = solverVariable5;
                            solverVariable6 = solverVariable4;
                            solverVariable8 = solverVariable;
                            i7 = 8;
                            i6 = 0;
                            i5 = 1;
                            z8 = true;
                            if (constraintWidget2.O0000o0 == 2) {
                            }
                            if (!z8) {
                            }
                            if (!z7) {
                            }
                            if (!constraintWidget.O000OOo0.O00000oO()) {
                            }
                        }
                        z6 = false;
                        if (constraintWidget2.O000Oo00[0] != DimensionBehaviour.WRAP_CONTENT) {
                        }
                        if (z19) {
                        }
                        boolean z1622 = !constraintWidget2.O000OOo0.O00000oO();
                        boolean[] zArr22 = constraintWidget2.O000OOoo;
                        boolean z1722 = zArr22[0];
                        boolean z1822 = zArr22[1];
                        SolverVariable solverVariable1122 = null;
                        if (constraintWidget2.O0000o00 == 2) {
                        }
                        constraintWidget2 = this;
                        if (constraintWidget2.O0000Oo0.O0000Oo.O0000Oo) {
                        }
                        oo00oo002 = oo00oo00;
                        solverVariable7 = solverVariable5;
                        solverVariable6 = solverVariable4;
                        solverVariable8 = solverVariable;
                        i7 = 8;
                        i6 = 0;
                        i5 = 1;
                        z8 = true;
                        if (constraintWidget2.O0000o0 == 2) {
                        }
                        if (!z8) {
                        }
                        if (!z7) {
                        }
                        if (!constraintWidget.O000OOo0.O00000oO()) {
                        }
                    }
                }
                i4 = i14;
                i3 = i18;
                i2 = i19;
                i = i20;
                z5 = true;
                int[] iArr22 = constraintWidget2.O0000o;
                iArr22[0] = i3;
                iArr22[1] = i2;
                constraintWidget2.O0000Ooo = z5;
                if (!z5) {
                }
                z6 = false;
                if (constraintWidget2.O000Oo00[0] != DimensionBehaviour.WRAP_CONTENT) {
                }
                if (z19) {
                }
                boolean z16222 = !constraintWidget2.O000OOo0.O00000oO();
                boolean[] zArr222 = constraintWidget2.O000OOoo;
                boolean z17222 = zArr222[0];
                boolean z18222 = zArr222[1];
                SolverVariable solverVariable11222 = null;
                if (constraintWidget2.O0000o00 == 2) {
                }
                constraintWidget2 = this;
                if (constraintWidget2.O0000Oo0.O0000Oo.O0000Oo) {
                }
                oo00oo002 = oo00oo00;
                solverVariable7 = solverVariable5;
                solverVariable6 = solverVariable4;
                solverVariable8 = solverVariable;
                i7 = 8;
                i6 = 0;
                i5 = 1;
                z8 = true;
                if (constraintWidget2.O0000o0 == 2) {
                }
                if (!z8) {
                }
                if (!z7) {
                }
                if (!constraintWidget.O000OOo0.O00000oO()) {
                }
            }
            z5 = false;
            int[] iArr222 = constraintWidget2.O0000o;
            iArr222[0] = i3;
            iArr222[1] = i2;
            constraintWidget2.O0000Ooo = z5;
            if (!z5) {
            }
            z6 = false;
            if (constraintWidget2.O000Oo00[0] != DimensionBehaviour.WRAP_CONTENT) {
            }
            if (z19) {
            }
            boolean z162222 = !constraintWidget2.O000OOo0.O00000oO();
            boolean[] zArr2222 = constraintWidget2.O000OOoo;
            boolean z172222 = zArr2222[0];
            boolean z182222 = zArr2222[1];
            SolverVariable solverVariable112222 = null;
            if (constraintWidget2.O0000o00 == 2) {
            }
            constraintWidget2 = this;
            if (constraintWidget2.O0000Oo0.O0000Oo.O0000Oo) {
            }
            oo00oo002 = oo00oo00;
            solverVariable7 = solverVariable5;
            solverVariable6 = solverVariable4;
            solverVariable8 = solverVariable;
            i7 = 8;
            i6 = 0;
            i5 = 1;
            z8 = true;
            if (constraintWidget2.O0000o0 == 2) {
            }
            if (!z8) {
            }
            if (!z7) {
            }
            if (!constraintWidget.O000OOo0.O00000oO()) {
            }
        } else {
            if (oO00Oo00.O0000Oo0 != null) {
                oO00Oo00.O0000Oo0.O0000oO0++;
            }
            oo00oo003.O000000o(O000000o2, constraintWidget2.O0000OOo.O0000Oo.O0000O0o);
            oo00oo003.O000000o(O000000o3, constraintWidget2.O0000OOo.O0000OoO.O0000O0o);
            oo00oo003.O000000o(O000000o4, constraintWidget2.O0000Oo0.O0000Oo.O0000O0o);
            oo00oo003.O000000o(O000000o5, constraintWidget2.O0000Oo0.O0000OoO.O0000O0o);
            oo00oo003.O000000o(O000000o6, constraintWidget2.O0000Oo0.f2298O000000o.O0000O0o);
            ConstraintWidget constraintWidget11 = constraintWidget2.O000Oo0;
            if (constraintWidget11 != null) {
                boolean z23 = constraintWidget11 != null && constraintWidget11.O000Oo00[0] == DimensionBehaviour.WRAP_CONTENT;
                ConstraintWidget constraintWidget12 = constraintWidget2.O000Oo0;
                boolean z24 = constraintWidget12 != null && constraintWidget12.O000Oo00[1] == DimensionBehaviour.WRAP_CONTENT;
                if (z23 && constraintWidget2.O0000Oo[0] && !O0000o00()) {
                    oo00oo003.O000000o(oo00oo003.O000000o(constraintWidget2.O000Oo0.O000O0oo), O000000o3, 0, 8);
                }
                if (z24 && constraintWidget2.O0000Oo[1] && !O0000o0()) {
                    oo00oo003.O000000o(oo00oo003.O000000o(constraintWidget2.O000Oo0.O000OO00), O000000o5, 0, 8);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public final boolean O0000o0O() {
        return (this instanceof oOo0oooO) || (this instanceof oO0O000o);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:202:0x035c, code lost:
        if ((r3 instanceof _m_j.oOo00ooO) != false) goto L_0x0361;
     */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x01dd  */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x029d  */
    /* JADX WARNING: Removed duplicated region for block: B:159:0x02a1  */
    /* JADX WARNING: Removed duplicated region for block: B:185:0x0302  */
    /* JADX WARNING: Removed duplicated region for block: B:190:0x0335  */
    /* JADX WARNING: Removed duplicated region for block: B:193:0x0347 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:194:0x0348  */
    /* JADX WARNING: Removed duplicated region for block: B:267:0x0418 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:274:0x042f  */
    /* JADX WARNING: Removed duplicated region for block: B:276:0x043e A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:298:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:302:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00b2  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00df  */
    private void O000000o(oO00Oo00 oo00oo00, boolean z, boolean z2, boolean z3, boolean z4, SolverVariable solverVariable, SolverVariable solverVariable2, DimensionBehaviour dimensionBehaviour, boolean z5, ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, int i, int i2, int i3, int i4, float f, boolean z6, boolean z7, boolean z8, boolean z9, int i5, int i6, int i7, int i8, float f2, boolean z10) {
        boolean z11;
        int i9;
        int i10;
        SolverVariable solverVariable3;
        int i11;
        boolean z12;
        int i12;
        int i13;
        SolverVariable solverVariable4;
        SolverVariable solverVariable5;
        SolverVariable solverVariable6;
        char c;
        int i14;
        SolverVariable solverVariable7;
        int i15;
        SolverVariable solverVariable8;
        SolverVariable solverVariable9;
        int i16;
        int i17;
        ConstraintAnchor constraintAnchor3;
        int i18;
        SolverVariable solverVariable10;
        int i19;
        int i20;
        boolean z13;
        boolean z14;
        boolean z15;
        int i21;
        boolean z16;
        SolverVariable solverVariable11;
        SolverVariable solverVariable12;
        SolverVariable solverVariable13;
        ConstraintWidget constraintWidget;
        ConstraintWidget constraintWidget2;
        int i22;
        SolverVariable solverVariable14;
        ConstraintWidget constraintWidget3;
        SolverVariable solverVariable15;
        int i23;
        int i24;
        ConstraintWidget constraintWidget4;
        SolverVariable solverVariable16;
        int i25;
        boolean z17;
        boolean z18;
        boolean z19;
        int i26;
        int i27;
        boolean z20;
        int i28;
        int i29;
        int i30;
        boolean z21;
        boolean z22;
        int i31;
        int i32;
        boolean z23;
        int i33;
        SolverVariable solverVariable17;
        SolverVariable solverVariable18;
        int i34;
        oO00Oo00 oo00oo002 = oo00oo00;
        ConstraintAnchor constraintAnchor4 = constraintAnchor;
        ConstraintAnchor constraintAnchor5 = constraintAnchor2;
        int i35 = i3;
        int i36 = i4;
        int i37 = i7;
        int i38 = i8;
        SolverVariable O000000o2 = oo00oo002.O000000o(constraintAnchor4);
        SolverVariable O000000o3 = oo00oo002.O000000o(constraintAnchor5);
        SolverVariable O000000o4 = oo00oo002.O000000o(constraintAnchor4.O00000o0);
        SolverVariable O000000o5 = oo00oo002.O000000o(constraintAnchor5.O00000o0);
        if (oO00Oo00.O000000o() != null) {
            oO00Oo00.O000000o().O0000oo++;
        }
        boolean O00000oO2 = constraintAnchor.O00000oO();
        boolean O00000oO3 = constraintAnchor2.O00000oO();
        boolean O00000oO4 = this.O000OOo0.O00000oO();
        int i39 = O00000oO2 ? 1 : 0;
        if (O00000oO3) {
            i39++;
        }
        if (O00000oO4) {
            i39++;
        }
        int i40 = i39;
        int i41 = z6 ? 3 : i5;
        int i42 = AnonymousClass1.O00000Oo[dimensionBehaviour.ordinal()];
        if (i42 == 1 || i42 == 2 || i42 == 3 || i42 != 4) {
            i9 = i41;
        } else {
            i9 = i41;
            if (i9 != 4) {
                z11 = true;
                if (this.O000o0O != 8) {
                    i10 = 0;
                    z11 = false;
                } else {
                    i10 = i2;
                }
                if (z10) {
                    if (!O00000oO2 && !O00000oO3 && !O00000oO4) {
                        oo00oo002.O000000o(O000000o2, i);
                    } else if (O00000oO2 && !O00000oO3) {
                        solverVariable3 = O000000o5;
                        oo00oo002.O00000o0(O000000o2, O000000o4, constraintAnchor.O00000o0(), 8);
                        if (!z11) {
                            if (z5) {
                                oo00oo002.O00000o0(O000000o3, O000000o2, 0, 3);
                                if (i35 > 0) {
                                    i34 = 8;
                                    oo00oo002.O000000o(O000000o3, O000000o2, i35, 8);
                                } else {
                                    i34 = 8;
                                }
                                if (i36 < Integer.MAX_VALUE) {
                                    oo00oo002.O00000Oo(O000000o3, O000000o2, i36, i34);
                                }
                            } else {
                                oo00oo002.O00000o0(O000000o3, O000000o2, i10, 8);
                            }
                            i13 = i9;
                            solverVariable6 = O000000o4;
                            solverVariable4 = O000000o3;
                            i12 = i40;
                            solverVariable5 = solverVariable3;
                            z12 = z4;
                        } else {
                            int i43 = i40;
                            if (i43 == 2 || z6 || !(i9 == 1 || i9 == 0)) {
                                if (i37 == -2) {
                                    i37 = i10;
                                }
                                int i44 = i38 == -2 ? i10 : i38;
                                if (i10 > 0 && i9 != 1) {
                                    i10 = 0;
                                }
                                if (i37 > 0) {
                                    oo00oo002.O000000o(O000000o3, O000000o2, i37, 8);
                                    i10 = Math.max(i10, i37);
                                }
                                if (i44 > 0) {
                                    if (!z2 || i9 != 1) {
                                        i33 = 8;
                                        oo00oo002.O00000Oo(O000000o3, O000000o2, i44, 8);
                                    } else {
                                        i33 = 8;
                                    }
                                    i10 = Math.min(i10, i44);
                                } else {
                                    i33 = 8;
                                }
                                if (i9 == 1) {
                                    if (z2) {
                                        oo00oo002.O00000o0(O000000o3, O000000o2, i10, i33);
                                    } else if (z7) {
                                        oo00oo002.O00000o0(O000000o3, O000000o2, i10, 5);
                                        oo00oo002.O00000Oo(O000000o3, O000000o2, i10, i33);
                                    } else {
                                        oo00oo002.O00000o0(O000000o3, O000000o2, i10, 5);
                                        oo00oo002.O00000Oo(O000000o3, O000000o2, i10, i33);
                                    }
                                    z12 = z4;
                                    i12 = i43;
                                    i38 = i44;
                                    i13 = i9;
                                    solverVariable6 = O000000o4;
                                    solverVariable4 = O000000o3;
                                    solverVariable5 = solverVariable3;
                                } else {
                                    if (i9 == 2) {
                                        if (constraintAnchor4.O00000Oo == ConstraintAnchor.Type.TOP || constraintAnchor4.O00000Oo == ConstraintAnchor.Type.BOTTOM) {
                                            solverVariable18 = oo00oo002.O000000o(this.O000Oo0.O000000o(ConstraintAnchor.Type.TOP));
                                            solverVariable17 = oo00oo002.O000000o(this.O000Oo0.O000000o(ConstraintAnchor.Type.BOTTOM));
                                        } else {
                                            solverVariable18 = oo00oo002.O000000o(this.O000Oo0.O000000o(ConstraintAnchor.Type.LEFT));
                                            solverVariable17 = oo00oo002.O000000o(this.O000Oo0.O000000o(ConstraintAnchor.Type.RIGHT));
                                        }
                                        int i45 = i44;
                                        i13 = i9;
                                        solverVariable5 = solverVariable3;
                                        i12 = i43;
                                        solverVariable6 = O000000o4;
                                        solverVariable4 = O000000o3;
                                        oo00oo002.O000000o(oo00oo00.O00000o0().O000000o(O000000o3, O000000o2, solverVariable17, solverVariable18, f2));
                                        i38 = i45;
                                        i11 = i37;
                                        z11 = false;
                                        z12 = z4;
                                    } else {
                                        i12 = i43;
                                        int i46 = i44;
                                        i13 = i9;
                                        solverVariable6 = O000000o4;
                                        solverVariable4 = O000000o3;
                                        solverVariable5 = solverVariable3;
                                        i38 = i46;
                                        i11 = i37;
                                        z12 = true;
                                    }
                                    if (z10) {
                                        solverVariable9 = solverVariable;
                                        solverVariable8 = solverVariable2;
                                        solverVariable7 = O000000o2;
                                        i17 = 0;
                                        i15 = 2;
                                        i14 = 8;
                                        c = 1;
                                        i16 = i12;
                                    } else if (z7) {
                                        solverVariable9 = solverVariable;
                                        solverVariable8 = solverVariable2;
                                        solverVariable7 = O000000o2;
                                        i16 = i12;
                                        i17 = 0;
                                        i15 = 2;
                                        i14 = 8;
                                        c = 1;
                                    } else {
                                        if ((O00000oO2 || O00000oO3 || O00000oO4) && (!O00000oO2 || O00000oO3)) {
                                            if (!O00000oO2 && O00000oO3) {
                                                oo00oo002.O00000o0(solverVariable4, solverVariable5, -constraintAnchor2.O00000o0(), 8);
                                                if (z2) {
                                                    oo00oo002.O000000o(O000000o2, solverVariable, 0, 5);
                                                }
                                            } else if (O00000oO2 && O00000oO3) {
                                                ConstraintWidget constraintWidget5 = constraintAnchor4.O00000o0.f2787O000000o;
                                                constraintAnchor3 = constraintAnchor2;
                                                ConstraintWidget constraintWidget6 = constraintAnchor3.O00000o0.f2787O000000o;
                                                ConstraintWidget constraintWidget7 = this.O000Oo0;
                                                int i47 = 6;
                                                if (z11) {
                                                    if (i13 == 0) {
                                                        if (i38 == 0 && i11 == 0) {
                                                            z15 = false;
                                                            z23 = true;
                                                            i32 = 8;
                                                            i20 = 8;
                                                        } else {
                                                            z15 = true;
                                                            z23 = false;
                                                            i32 = 5;
                                                            i20 = 5;
                                                        }
                                                        if ((constraintWidget5 instanceof oOo00ooO) || (constraintWidget6 instanceof oOo00ooO)) {
                                                            i19 = i32;
                                                            i21 = 6;
                                                            z14 = false;
                                                            i20 = 4;
                                                        } else {
                                                            i19 = i32;
                                                            i21 = 6;
                                                            z14 = false;
                                                        }
                                                        z13 = z23;
                                                    } else {
                                                        if (i13 == 1) {
                                                            i30 = 6;
                                                            z21 = true;
                                                            z22 = true;
                                                            z13 = false;
                                                            i31 = 4;
                                                        } else if (i13 != 3) {
                                                            i26 = 6;
                                                            z19 = false;
                                                            z18 = false;
                                                        } else if (this.O00oOooO == -1) {
                                                            i30 = z8 ? z2 ? 5 : 4 : 8;
                                                            z21 = true;
                                                            z22 = true;
                                                            z13 = true;
                                                            i31 = 5;
                                                        } else if (z6) {
                                                            int i48 = i6;
                                                            if (i48 != 2) {
                                                                if (i48 != 1) {
                                                                    z20 = false;
                                                                    if (z20) {
                                                                        i29 = 8;
                                                                        i28 = 5;
                                                                    } else {
                                                                        i29 = 5;
                                                                        i28 = 4;
                                                                    }
                                                                    i19 = i29;
                                                                    i20 = i28;
                                                                    i21 = 6;
                                                                    z15 = true;
                                                                    z14 = true;
                                                                    z13 = true;
                                                                }
                                                            }
                                                            z20 = true;
                                                            if (z20) {
                                                            }
                                                            i19 = i29;
                                                            i20 = i28;
                                                            i21 = 6;
                                                            z15 = true;
                                                            z14 = true;
                                                            z13 = true;
                                                        } else {
                                                            if (i38 > 0) {
                                                                i26 = 6;
                                                                z19 = true;
                                                                z18 = true;
                                                                z17 = true;
                                                                i27 = 5;
                                                            } else if (i38 != 0 || i11 != 0) {
                                                                i26 = 6;
                                                                z19 = true;
                                                                z18 = true;
                                                                z17 = true;
                                                                i27 = 4;
                                                            } else if (!z8) {
                                                                i26 = 6;
                                                                z19 = true;
                                                                z18 = true;
                                                                z17 = true;
                                                                i27 = 8;
                                                            } else {
                                                                i19 = (constraintWidget5 == constraintWidget7 || constraintWidget6 == constraintWidget7) ? 5 : 4;
                                                                i21 = 6;
                                                                z15 = true;
                                                                z14 = true;
                                                                z13 = true;
                                                                i20 = 4;
                                                            }
                                                            i19 = 5;
                                                        }
                                                        i19 = 8;
                                                    }
                                                    if (z14 || solverVariable6 != solverVariable5 || constraintWidget5 == constraintWidget7) {
                                                        z16 = true;
                                                    } else {
                                                        z14 = false;
                                                        z16 = false;
                                                    }
                                                    if (!z15) {
                                                        int i49 = this.O000o0O == 8 ? 4 : i21;
                                                        SolverVariable solverVariable19 = solverVariable6;
                                                        i22 = 8;
                                                        solverVariable11 = solverVariable19;
                                                        solverVariable12 = solverVariable5;
                                                        constraintWidget2 = constraintWidget7;
                                                        constraintWidget = constraintWidget6;
                                                        solverVariable13 = O000000o2;
                                                        oo00oo00.O000000o(O000000o2, solverVariable19, constraintAnchor.O00000o0(), f, solverVariable12, solverVariable4, constraintAnchor2.O00000o0(), i49);
                                                    } else {
                                                        solverVariable11 = solverVariable6;
                                                        solverVariable12 = solverVariable5;
                                                        constraintWidget2 = constraintWidget7;
                                                        constraintWidget = constraintWidget6;
                                                        solverVariable13 = O000000o2;
                                                        i22 = 8;
                                                    }
                                                    if (this.O000o0O == i22) {
                                                        if (z14) {
                                                            if (z2) {
                                                                solverVariable16 = solverVariable12;
                                                                solverVariable15 = solverVariable11;
                                                                if (solverVariable15 != solverVariable16 && !z11) {
                                                                    if (!(constraintWidget5 instanceof oOo00ooO)) {
                                                                        constraintWidget3 = constraintWidget;
                                                                    } else {
                                                                        constraintWidget3 = constraintWidget;
                                                                    }
                                                                    i25 = 6;
                                                                    solverVariable14 = solverVariable13;
                                                                    oo00oo002.O000000o(solverVariable14, solverVariable15, constraintAnchor.O00000o0(), i25);
                                                                    oo00oo002.O00000Oo(solverVariable4, solverVariable16, -constraintAnchor2.O00000o0(), i25);
                                                                    i19 = i25;
                                                                }
                                                            } else {
                                                                solverVariable16 = solverVariable12;
                                                                solverVariable15 = solverVariable11;
                                                            }
                                                            constraintWidget3 = constraintWidget;
                                                            i25 = i19;
                                                            solverVariable14 = solverVariable13;
                                                            oo00oo002.O000000o(solverVariable14, solverVariable15, constraintAnchor.O00000o0(), i25);
                                                            oo00oo002.O00000Oo(solverVariable4, solverVariable16, -constraintAnchor2.O00000o0(), i25);
                                                            i19 = i25;
                                                        } else {
                                                            solverVariable16 = solverVariable12;
                                                            solverVariable15 = solverVariable11;
                                                            constraintWidget3 = constraintWidget;
                                                            solverVariable14 = solverVariable13;
                                                        }
                                                        if (!z2 || !z9 || (constraintWidget5 instanceof oOo00ooO) || (constraintWidget3 instanceof oOo00ooO)) {
                                                            i24 = i20;
                                                            i23 = i19;
                                                        } else {
                                                            i24 = 6;
                                                            i23 = 6;
                                                            z16 = true;
                                                        }
                                                        if (z16) {
                                                            if (!z13 || (z8 && !z3)) {
                                                                constraintWidget4 = constraintWidget2;
                                                            } else {
                                                                constraintWidget4 = constraintWidget2;
                                                                if (!(constraintWidget5 == constraintWidget4 || constraintWidget3 == constraintWidget4)) {
                                                                    i47 = i24;
                                                                }
                                                                if ((constraintWidget5 instanceof oO0O000o) || (constraintWidget3 instanceof oO0O000o)) {
                                                                    i47 = 5;
                                                                }
                                                                if ((constraintWidget5 instanceof oOo00ooO) || (constraintWidget3 instanceof oOo00ooO)) {
                                                                    i47 = 5;
                                                                }
                                                                i24 = Math.max(z8 ? 5 : i47, i24);
                                                            }
                                                            if (z2) {
                                                                i24 = Math.min(i23, i24);
                                                                if (z6 && !z8 && (constraintWidget5 == constraintWidget4 || constraintWidget3 == constraintWidget4)) {
                                                                    i24 = 4;
                                                                }
                                                            }
                                                            oo00oo002.O00000o0(solverVariable14, solverVariable15, constraintAnchor.O00000o0(), i24);
                                                            oo00oo002.O00000o0(solverVariable4, solverVariable5, -constraintAnchor2.O00000o0(), i24);
                                                        }
                                                        if (z2) {
                                                            SolverVariable solverVariable20 = solverVariable;
                                                            int O00000o0 = solverVariable20 == solverVariable15 ? constraintAnchor.O00000o0() : 0;
                                                            if (solverVariable15 != solverVariable20) {
                                                                oo00oo002.O000000o(solverVariable14, solverVariable20, O00000o0, 5);
                                                            }
                                                        }
                                                        if (z2 && z11) {
                                                            int i50 = i13;
                                                            if (i3 == 0 && i11 == 0) {
                                                                if (!z11 || i50 != 3) {
                                                                    oo00oo002.O000000o(solverVariable4, solverVariable14, 0, 5);
                                                                } else {
                                                                    oo00oo002.O000000o(solverVariable4, solverVariable14, 0, i22);
                                                                }
                                                                if (!z2 && z12) {
                                                                    if (constraintAnchor3.O00000o0 != null) {
                                                                        i18 = constraintAnchor2.O00000o0();
                                                                        solverVariable10 = solverVariable2;
                                                                    } else {
                                                                        solverVariable10 = solverVariable2;
                                                                        i18 = 0;
                                                                    }
                                                                    if (solverVariable5 != solverVariable10) {
                                                                        oo00oo002.O000000o(solverVariable10, solverVariable4, i18, 5);
                                                                        return;
                                                                    }
                                                                    return;
                                                                }
                                                                return;
                                                            }
                                                        }
                                                        if (!z2) {
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                    return;
                                                }
                                                i26 = 6;
                                                z19 = true;
                                                z18 = true;
                                                z17 = false;
                                                i27 = 4;
                                                i19 = 5;
                                                if (z14) {
                                                }
                                                z16 = true;
                                                if (!z15) {
                                                }
                                                if (this.O000o0O == i22) {
                                                }
                                            }
                                        }
                                        constraintAnchor3 = constraintAnchor2;
                                        if (!z2) {
                                        }
                                    }
                                    if (i16 < i15 && z2 && z12) {
                                        oo00oo002.O000000o(solverVariable7, solverVariable9, i17, i14);
                                        boolean z24 = z || this.O000OO0o.O00000o0 == null;
                                        if (!z && this.O000OO0o.O00000o0 != null) {
                                            ConstraintWidget constraintWidget8 = this.O000OO0o.O00000o0.f2787O000000o;
                                            z24 = constraintWidget8.O000OoO0 != 0.0f && constraintWidget8.O000Oo00[i17] == DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget8.O000Oo00[c] == DimensionBehaviour.MATCH_CONSTRAINT;
                                        }
                                        if (z24) {
                                            oo00oo002.O000000o(solverVariable8, solverVariable4, i17, i14);
                                            return;
                                        }
                                        return;
                                    }
                                    return;
                                }
                            } else {
                                int max = Math.max(i37, i10);
                                if (i38 > 0) {
                                    max = Math.min(i38, max);
                                }
                                oo00oo002.O00000o0(O000000o3, O000000o2, max, 8);
                                z12 = z4;
                                i12 = i43;
                                i13 = i9;
                                solverVariable6 = O000000o4;
                                solverVariable4 = O000000o3;
                                solverVariable5 = solverVariable3;
                                z11 = false;
                            }
                        }
                        i11 = i37;
                        if (z10) {
                        }
                        if (i16 < i15) {
                            return;
                        }
                        return;
                    }
                }
                solverVariable3 = O000000o5;
                if (!z11) {
                }
                i11 = i37;
                if (z10) {
                }
                if (i16 < i15) {
                }
            }
        }
        z11 = false;
        if (this.O000o0O != 8) {
        }
        if (z10) {
        }
        solverVariable3 = O000000o5;
        if (!z11) {
        }
        i11 = i37;
        if (z10) {
        }
        if (i16 < i15) {
        }
    }

    /* renamed from: androidx.constraintlayout.solver.widgets.ConstraintWidget$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: O000000o  reason: collision with root package name */
        static final /* synthetic */ int[] f2790O000000o = new int[ConstraintAnchor.Type.values().length];
        static final /* synthetic */ int[] O00000Oo = new int[DimensionBehaviour.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(26:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|(3:33|34|36)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(28:0|1|2|3|(2:5|6)|7|(2:9|10)|11|13|14|15|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|(3:33|34|36)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(31:0|1|2|3|5|6|7|(2:9|10)|11|13|14|15|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|36) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0048 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0052 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x005c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0066 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0071 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x007c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x0087 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x0093 */
        static {
            try {
                O00000Oo[DimensionBehaviour.FIXED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                O00000Oo[DimensionBehaviour.WRAP_CONTENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                O00000Oo[DimensionBehaviour.MATCH_PARENT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                O00000Oo[DimensionBehaviour.MATCH_CONSTRAINT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f2790O000000o[ConstraintAnchor.Type.LEFT.ordinal()] = 1;
            f2790O000000o[ConstraintAnchor.Type.TOP.ordinal()] = 2;
            f2790O000000o[ConstraintAnchor.Type.RIGHT.ordinal()] = 3;
            f2790O000000o[ConstraintAnchor.Type.BOTTOM.ordinal()] = 4;
            f2790O000000o[ConstraintAnchor.Type.BASELINE.ordinal()] = 5;
            f2790O000000o[ConstraintAnchor.Type.CENTER.ordinal()] = 6;
            f2790O000000o[ConstraintAnchor.Type.CENTER_X.ordinal()] = 7;
            f2790O000000o[ConstraintAnchor.Type.CENTER_Y.ordinal()] = 8;
            try {
                f2790O000000o[ConstraintAnchor.Type.NONE.ordinal()] = 9;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public void O0000o0o() {
        int i;
        int i2;
        int O00000Oo2 = oO00Oo00.O00000Oo(this.O000O0o);
        int O00000Oo3 = oO00Oo00.O00000Oo(this.O000O0oO);
        int O00000Oo4 = oO00Oo00.O00000Oo(this.O000O0oo);
        int O00000Oo5 = oO00Oo00.O00000Oo(this.O000OO00);
        if (this.O0000OOo.O0000Oo.O0000Oo && this.O0000OOo.O0000OoO.O0000Oo) {
            O00000Oo2 = this.O0000OOo.O0000Oo.O0000O0o;
            O00000Oo4 = this.O0000OOo.O0000OoO.O0000O0o;
        }
        if (this.O0000Oo0.O0000Oo.O0000Oo && this.O0000Oo0.O0000OoO.O0000Oo) {
            O00000Oo3 = this.O0000Oo0.O0000Oo.O0000O0o;
            O00000Oo5 = this.O0000Oo0.O0000OoO.O0000O0o;
        }
        int i3 = O00000Oo5 - O00000Oo3;
        if (O00000Oo4 - O00000Oo2 < 0 || i3 < 0 || O00000Oo2 == Integer.MIN_VALUE || O00000Oo2 == Integer.MAX_VALUE || O00000Oo3 == Integer.MIN_VALUE || O00000Oo3 == Integer.MAX_VALUE || O00000Oo4 == Integer.MIN_VALUE || O00000Oo4 == Integer.MAX_VALUE || O00000Oo5 == Integer.MIN_VALUE || O00000Oo5 == Integer.MAX_VALUE) {
            O00000Oo2 = 0;
            O00000Oo3 = 0;
            O00000Oo4 = 0;
            O00000Oo5 = 0;
        }
        int i4 = O00000Oo4 - O00000Oo2;
        int i5 = O00000Oo5 - O00000Oo3;
        this.O000OoO = O00000Oo2;
        this.O000OoOO = O00000Oo3;
        if (this.O000o0O == 8) {
            this.O000Oo0O = 0;
            this.O000Oo0o = 0;
            return;
        }
        if (this.O000Oo00[0] != DimensionBehaviour.FIXED || i4 >= (i = this.O000Oo0O)) {
            i = i4;
        }
        if (this.O000Oo00[1] != DimensionBehaviour.FIXED || i5 >= (i2 = this.O000Oo0o)) {
            i2 = i5;
        }
        this.O000Oo0O = i;
        this.O000Oo0o = i2;
        int i6 = this.O000Oo0o;
        int i7 = this.O000o00;
        if (i6 < i7) {
            this.O000Oo0o = i7;
        }
        int i8 = this.O000Oo0O;
        int i9 = this.O000o000;
        if (i8 < i9) {
            this.O000Oo0O = i9;
        }
    }

    public void O000000o(ConstraintWidget constraintWidget, HashMap<ConstraintWidget, ConstraintWidget> hashMap) {
        this.O0000o00 = constraintWidget.O0000o00;
        this.O0000o0 = constraintWidget.O0000o0;
        this.O0000o0O = constraintWidget.O0000o0O;
        this.O0000o0o = constraintWidget.O0000o0o;
        int[] iArr = this.O0000o;
        int[] iArr2 = constraintWidget.O0000o;
        iArr[0] = iArr2[0];
        iArr[1] = iArr2[1];
        this.O0000oO0 = constraintWidget.O0000oO0;
        this.O0000oO = constraintWidget.O0000oO;
        this.O0000oOo = constraintWidget.O0000oOo;
        this.O0000oo0 = constraintWidget.O0000oo0;
        this.O0000oo = constraintWidget.O0000oo;
        this.O0000ooO = constraintWidget.O0000ooO;
        this.O0000ooo = constraintWidget.O0000ooo;
        this.O00oOooO = constraintWidget.O00oOooO;
        this.O00oOooo = constraintWidget.O00oOooo;
        int[] iArr3 = constraintWidget.O000O00o;
        this.O000O00o = Arrays.copyOf(iArr3, iArr3.length);
        this.O000O0OO = constraintWidget.O000O0OO;
        this.O000O0Oo = constraintWidget.O000O0Oo;
        this.O00oOoOo = constraintWidget.O00oOoOo;
        this.O000O0o.O00000o();
        this.O000O0oO.O00000o();
        this.O000O0oo.O00000o();
        this.O000OO00.O00000o();
        this.O000OO0o.O00000o();
        this.O000OO.O00000o();
        this.O000OOOo.O00000o();
        this.O000OOo0.O00000o();
        this.O000Oo00 = (DimensionBehaviour[]) Arrays.copyOf(this.O000Oo00, 2);
        ConstraintWidget constraintWidget2 = null;
        this.O000Oo0 = this.O000Oo0 == null ? null : hashMap.get(constraintWidget.O000Oo0);
        this.O000Oo0O = constraintWidget.O000Oo0O;
        this.O000Oo0o = constraintWidget.O000Oo0o;
        this.O000OoO0 = constraintWidget.O000OoO0;
        this.O00O0Oo = constraintWidget.O00O0Oo;
        this.O000OoO = constraintWidget.O000OoO;
        this.O000OoOO = constraintWidget.O000OoOO;
        this.O000OoOo = constraintWidget.O000OoOo;
        this.O000Ooo0 = constraintWidget.O000Ooo0;
        this.O000Ooo = constraintWidget.O000Ooo;
        this.O000OooO = constraintWidget.O000OooO;
        this.O000Oooo = constraintWidget.O000Oooo;
        this.O000o000 = constraintWidget.O000o000;
        this.O000o00 = constraintWidget.O000o00;
        this.O000o00o = constraintWidget.O000o00o;
        this.O000o0 = constraintWidget.O000o0;
        this.O000o0O0 = constraintWidget.O000o0O0;
        this.f2789O000000o = constraintWidget.f2789O000000o;
        this.O000o0O = constraintWidget.O000o0O;
        this.O000o0OO = constraintWidget.O000o0OO;
        this.O00000Oo = constraintWidget.O00000Oo;
        this.O000o0Oo = constraintWidget.O000o0Oo;
        this.O000o0o0 = constraintWidget.O000o0o0;
        this.O000o0o = constraintWidget.O000o0o;
        this.O000o0oo = constraintWidget.O000o0oo;
        this.O000o = constraintWidget.O000o;
        this.O000oO00 = constraintWidget.O000oO00;
        this.O000oO0 = constraintWidget.O000oO0;
        this.O000oO0O = constraintWidget.O000oO0O;
        this.O000oO0o = constraintWidget.O000oO0o;
        this.O000oO = constraintWidget.O000oO;
        this.O000oOO0 = constraintWidget.O000oOO0;
        this.O000oOO = constraintWidget.O000oOO;
        this.O000oOOO = constraintWidget.O000oOOO;
        this.O000oOOo = constraintWidget.O000oOOo;
        this.O000oOo0 = constraintWidget.O000oOo0;
        this.O000oOo = constraintWidget.O000oOo;
        float[] fArr = this.O000oOoO;
        float[] fArr2 = constraintWidget.O000oOoO;
        fArr[0] = fArr2[0];
        fArr[1] = fArr2[1];
        ConstraintWidget[] constraintWidgetArr = this.O000oOoo;
        ConstraintWidget[] constraintWidgetArr2 = constraintWidget.O000oOoo;
        constraintWidgetArr[0] = constraintWidgetArr2[0];
        constraintWidgetArr[1] = constraintWidgetArr2[1];
        ConstraintWidget[] constraintWidgetArr3 = this.O000oo0;
        ConstraintWidget[] constraintWidgetArr4 = constraintWidget.O000oo0;
        constraintWidgetArr3[0] = constraintWidgetArr4[0];
        constraintWidgetArr3[1] = constraintWidgetArr4[1];
        ConstraintWidget constraintWidget3 = constraintWidget.O000oo0O;
        this.O000oo0O = constraintWidget3 == null ? null : hashMap.get(constraintWidget3);
        ConstraintWidget constraintWidget4 = constraintWidget.O000oo0o;
        if (constraintWidget4 != null) {
            constraintWidget2 = hashMap.get(constraintWidget4);
        }
        this.O000oo0o = constraintWidget2;
    }

    public void O000000o(boolean z, boolean z2) {
        int i;
        int i2;
        boolean z3 = z & this.O0000OOo.O0000Oo0;
        boolean z4 = z2 & this.O0000Oo0.O0000Oo0;
        int i3 = this.O0000OOo.O0000Oo.O0000O0o;
        int i4 = this.O0000Oo0.O0000Oo.O0000O0o;
        int i5 = this.O0000OOo.O0000OoO.O0000O0o;
        int i6 = this.O0000Oo0.O0000OoO.O0000O0o;
        int i7 = i6 - i4;
        if (i5 - i3 < 0 || i7 < 0 || i3 == Integer.MIN_VALUE || i3 == Integer.MAX_VALUE || i4 == Integer.MIN_VALUE || i4 == Integer.MAX_VALUE || i5 == Integer.MIN_VALUE || i5 == Integer.MAX_VALUE || i6 == Integer.MIN_VALUE || i6 == Integer.MAX_VALUE) {
            i3 = 0;
            i4 = 0;
            i5 = 0;
            i6 = 0;
        }
        int i8 = i5 - i3;
        int i9 = i6 - i4;
        if (z3) {
            this.O000OoO = i3;
        }
        if (z4) {
            this.O000OoOO = i4;
        }
        if (this.O000o0O == 8) {
            this.O000Oo0O = 0;
            this.O000Oo0o = 0;
            return;
        }
        if (z3) {
            if (this.O000Oo00[0] != DimensionBehaviour.FIXED || i8 >= (i2 = this.O000Oo0O)) {
                i2 = i8;
            }
            this.O000Oo0O = i2;
            int i10 = this.O000Oo0O;
            int i11 = this.O000o000;
            if (i10 < i11) {
                this.O000Oo0O = i11;
            }
        }
        if (z4) {
            if (this.O000Oo00[1] != DimensionBehaviour.FIXED || i9 >= (i = this.O000Oo0o)) {
                i = i9;
            }
            this.O000Oo0o = i;
            int i12 = this.O000Oo0o;
            int i13 = this.O000o00;
            if (i12 < i13) {
                this.O000Oo0o = i13;
            }
        }
    }

    public final void O000000o(ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, int i) {
        if (constraintAnchor.f2787O000000o == this) {
            O000000o(constraintAnchor.O00000Oo, constraintAnchor2.f2787O000000o, constraintAnchor2.O00000Oo, i);
        }
    }

    public final DimensionBehaviour O0000Oo(int i) {
        if (i == 0) {
            return this.O000Oo00[0];
        }
        if (i == 1) {
            return this.O000Oo00[1];
        }
        return null;
    }
}
