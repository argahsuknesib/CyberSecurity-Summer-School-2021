package _m_j;

import androidx.constraintlayout.solver.widgets.analyzer.DependencyNode;
import androidx.constraintlayout.solver.widgets.analyzer.WidgetRun;

public class oOO00000 extends DependencyNode {
    public int O0000o00;

    public oOO00000(WidgetRun widgetRun) {
        super(widgetRun);
        if (widgetRun instanceof oOO0O000) {
            this.O00000oO = DependencyNode.Type.HORIZONTAL_DIMENSION;
        } else {
            this.O00000oO = DependencyNode.Type.VERTICAL_DIMENSION;
        }
    }

    public final void O000000o(int i) {
        if (!this.O0000Oo) {
            this.O0000Oo = true;
            this.O0000O0o = i;
            for (oO0o0000 O00000o : this.O0000OoO) {
                O00000o.O00000o();
            }
        }
    }
}
