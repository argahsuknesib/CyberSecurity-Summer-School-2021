package _m_j;

import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import java.util.ArrayList;

public class oO0O0Oo0 extends ConstraintWidget {
    public ArrayList<ConstraintWidget> O00O0OoO = new ArrayList<>();

    public void O00000Oo() {
        this.O00O0OoO.clear();
        super.O00000Oo();
    }

    public final void O000000o(ConstraintWidget constraintWidget) {
        this.O00O0OoO.add(constraintWidget);
        if (constraintWidget.O000Oo0 != null) {
            ((oO0O0Oo0) constraintWidget.O000Oo0).O00000Oo(constraintWidget);
        }
        constraintWidget.O000Oo0 = this;
    }

    public final void O00000Oo(ConstraintWidget constraintWidget) {
        this.O00O0OoO.remove(constraintWidget);
        constraintWidget.O000Oo0 = null;
    }

    public void O0000oOO() {
        ArrayList<ConstraintWidget> arrayList = this.O00O0OoO;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                ConstraintWidget constraintWidget = this.O00O0OoO.get(i);
                if (constraintWidget instanceof oO0O0Oo0) {
                    ((oO0O0Oo0) constraintWidget).O0000oOO();
                }
            }
        }
    }

    public final void O000000o(oO00OOo0 oo00ooo0) {
        super.O000000o(oo00ooo0);
        int size = this.O00O0OoO.size();
        for (int i = 0; i < size; i++) {
            this.O00O0OoO.get(i).O000000o(oo00ooo0);
        }
    }
}
