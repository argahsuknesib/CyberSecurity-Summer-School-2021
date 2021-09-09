package _m_j;

import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.analyzer.DependencyNode;
import androidx.constraintlayout.solver.widgets.analyzer.WidgetRun;

final class ooooO000 extends WidgetRun {
    public final boolean O000000o() {
        return false;
    }

    public ooooO000(ConstraintWidget constraintWidget) {
        super(constraintWidget);
    }

    public final void O00000o0() {
        this.O00000oO = null;
        this.O0000Oo.O000000o();
    }

    private void O000000o(DependencyNode dependencyNode) {
        this.O0000Oo.O0000OoO.add(dependencyNode);
        dependencyNode.O0000Ooo.add(this.O0000Oo);
    }

    public final void O00000oo() {
        if (this.O00000o instanceof oOo00ooO) {
            this.O0000Oo.O00000Oo = true;
            oOo00ooO ooo00ooo = (oOo00ooO) this.O00000o;
            int i = ooo00ooo.f2334O000000o;
            boolean z = ooo00ooo.O00000Oo;
            int i2 = 0;
            if (i == 0) {
                this.O0000Oo.O00000oO = DependencyNode.Type.LEFT;
                while (i2 < ooo00ooo.O00O0OOo) {
                    ConstraintWidget constraintWidget = ooo00ooo.O00O0OO[i2];
                    if (z || constraintWidget.O000o0O != 8) {
                        DependencyNode dependencyNode = constraintWidget.O0000OOo.O0000Oo;
                        dependencyNode.O0000OoO.add(this.O0000Oo);
                        this.O0000Oo.O0000Ooo.add(dependencyNode);
                    }
                    i2++;
                }
                O000000o(this.O00000o.O0000OOo.O0000Oo);
                O000000o(this.O00000o.O0000OOo.O0000OoO);
            } else if (i == 1) {
                this.O0000Oo.O00000oO = DependencyNode.Type.RIGHT;
                while (i2 < ooo00ooo.O00O0OOo) {
                    ConstraintWidget constraintWidget2 = ooo00ooo.O00O0OO[i2];
                    if (z || constraintWidget2.O000o0O != 8) {
                        DependencyNode dependencyNode2 = constraintWidget2.O0000OOo.O0000OoO;
                        dependencyNode2.O0000OoO.add(this.O0000Oo);
                        this.O0000Oo.O0000Ooo.add(dependencyNode2);
                    }
                    i2++;
                }
                O000000o(this.O00000o.O0000OOo.O0000Oo);
                O000000o(this.O00000o.O0000OOo.O0000OoO);
            } else if (i == 2) {
                this.O0000Oo.O00000oO = DependencyNode.Type.TOP;
                while (i2 < ooo00ooo.O00O0OOo) {
                    ConstraintWidget constraintWidget3 = ooo00ooo.O00O0OO[i2];
                    if (z || constraintWidget3.O000o0O != 8) {
                        DependencyNode dependencyNode3 = constraintWidget3.O0000Oo0.O0000Oo;
                        dependencyNode3.O0000OoO.add(this.O0000Oo);
                        this.O0000Oo.O0000Ooo.add(dependencyNode3);
                    }
                    i2++;
                }
                O000000o(this.O00000o.O0000Oo0.O0000Oo);
                O000000o(this.O00000o.O0000Oo0.O0000OoO);
            } else if (i == 3) {
                this.O0000Oo.O00000oO = DependencyNode.Type.BOTTOM;
                while (i2 < ooo00ooo.O00O0OOo) {
                    ConstraintWidget constraintWidget4 = ooo00ooo.O00O0OO[i2];
                    if (z || constraintWidget4.O000o0O != 8) {
                        DependencyNode dependencyNode4 = constraintWidget4.O0000Oo0.O0000OoO;
                        dependencyNode4.O0000OoO.add(this.O0000Oo);
                        this.O0000Oo.O0000Ooo.add(dependencyNode4);
                    }
                    i2++;
                }
                O000000o(this.O00000o.O0000Oo0.O0000Oo);
                O000000o(this.O00000o.O0000Oo0.O0000OoO);
            }
        }
    }

    public final void O00000o() {
        oOo00ooO ooo00ooo = (oOo00ooO) this.O00000o;
        int i = ooo00ooo.f2334O000000o;
        int i2 = -1;
        int i3 = 0;
        for (DependencyNode dependencyNode : this.O0000Oo.O0000Ooo) {
            int i4 = dependencyNode.O0000O0o;
            if (i2 == -1 || i4 < i2) {
                i2 = i4;
            }
            if (i3 < i4) {
                i3 = i4;
            }
        }
        if (i == 0 || i == 2) {
            this.O0000Oo.O000000o(i2 + ooo00ooo.O00000o0);
        } else {
            this.O0000Oo.O000000o(i3 + ooo00ooo.O00000o0);
        }
    }

    public final void O00000oO() {
        if (this.O00000o instanceof oOo00ooO) {
            int i = ((oOo00ooO) this.O00000o).f2334O000000o;
            if (i == 0 || i == 1) {
                this.O00000o.O00000o0(this.O0000Oo.O0000O0o);
            } else {
                this.O00000o.O00000o(this.O0000Oo.O0000O0o);
            }
        }
    }
}
