package _m_j;

import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import java.util.Arrays;
import java.util.HashMap;

public class oO0O00o0 extends ConstraintWidget implements oO0O00Oo {
    public ConstraintWidget[] O00O0OO = new ConstraintWidget[4];
    public int O00O0OOo = 0;

    public void c_() {
    }

    public final void O000000o(ConstraintWidget constraintWidget) {
        if (constraintWidget != this && constraintWidget != null) {
            int i = this.O00O0OOo + 1;
            ConstraintWidget[] constraintWidgetArr = this.O00O0OO;
            if (i > constraintWidgetArr.length) {
                this.O00O0OO = (ConstraintWidget[]) Arrays.copyOf(constraintWidgetArr, constraintWidgetArr.length * 2);
            }
            ConstraintWidget[] constraintWidgetArr2 = this.O00O0OO;
            int i2 = this.O00O0OOo;
            constraintWidgetArr2[i2] = constraintWidget;
            this.O00O0OOo = i2 + 1;
        }
    }

    public void O000000o(ConstraintWidget constraintWidget, HashMap<ConstraintWidget, ConstraintWidget> hashMap) {
        super.O000000o(constraintWidget, hashMap);
        oO0O00o0 oo0o00o0 = (oO0O00o0) constraintWidget;
        this.O00O0OOo = 0;
        int i = oo0o00o0.O00O0OOo;
        for (int i2 = 0; i2 < i; i2++) {
            O000000o(hashMap.get(oo0o00o0.O00O0OO[i2]));
        }
    }

    public final void d_() {
        this.O00O0OOo = 0;
        Arrays.fill(this.O00O0OO, (Object) null);
    }
}
