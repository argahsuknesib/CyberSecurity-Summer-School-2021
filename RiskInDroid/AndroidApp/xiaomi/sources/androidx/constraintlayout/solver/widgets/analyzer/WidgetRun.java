package androidx.constraintlayout.solver.widgets.analyzer;

import _m_j.oO0o0000;
import _m_j.oOO00000;
import _m_j.oOO0O00O;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;

public abstract class WidgetRun implements oO0o0000 {
    public ConstraintWidget O00000o;
    public int O00000o0;
    public oOO0O00O O00000oO;
    public ConstraintWidget.DimensionBehaviour O00000oo;
    public oOO00000 O0000O0o = new oOO00000(this);
    public int O0000OOo = 0;
    public DependencyNode O0000Oo = new DependencyNode(this);
    public boolean O0000Oo0 = false;
    public DependencyNode O0000OoO = new DependencyNode(this);
    protected RunType O0000Ooo = RunType.NONE;

    public enum RunType {
        NONE,
        START,
        END,
        CENTER
    }

    public abstract boolean O000000o();

    public void O00000o() {
    }

    public abstract void O00000o0();

    public abstract void O00000oO();

    public abstract void O00000oo();

    public WidgetRun(ConstraintWidget constraintWidget) {
        this.O00000o = constraintWidget;
    }

    protected static DependencyNode O000000o(ConstraintAnchor constraintAnchor) {
        if (constraintAnchor.O00000o0 == null) {
            return null;
        }
        ConstraintWidget constraintWidget = constraintAnchor.O00000o0.f2787O000000o;
        int i = AnonymousClass1.f2792O000000o[constraintAnchor.O00000o0.O00000Oo.ordinal()];
        if (i == 1) {
            return constraintWidget.O0000OOo.O0000Oo;
        }
        if (i == 2) {
            return constraintWidget.O0000OOo.O0000OoO;
        }
        if (i == 3) {
            return constraintWidget.O0000Oo0.O0000Oo;
        }
        if (i == 4) {
            return constraintWidget.O0000Oo0.f2298O000000o;
        }
        if (i != 5) {
            return null;
        }
        return constraintWidget.O0000Oo0.O0000OoO;
    }

    /* renamed from: androidx.constraintlayout.solver.widgets.analyzer.WidgetRun$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: O000000o  reason: collision with root package name */
        static final /* synthetic */ int[] f2792O000000o = new int[ConstraintAnchor.Type.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0035 */
        static {
            f2792O000000o[ConstraintAnchor.Type.LEFT.ordinal()] = 1;
            f2792O000000o[ConstraintAnchor.Type.RIGHT.ordinal()] = 2;
            f2792O000000o[ConstraintAnchor.Type.TOP.ordinal()] = 3;
            f2792O000000o[ConstraintAnchor.Type.BASELINE.ordinal()] = 4;
            f2792O000000o[ConstraintAnchor.Type.BOTTOM.ordinal()] = 5;
        }
    }

    /* access modifiers changed from: protected */
    public final void O000000o(ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, int i) {
        float f;
        int i2;
        DependencyNode O000000o2 = O000000o(constraintAnchor);
        DependencyNode O000000o3 = O000000o(constraintAnchor2);
        if (O000000o2.O0000Oo && O000000o3.O0000Oo) {
            int O00000o02 = O000000o2.O0000O0o + constraintAnchor.O00000o0();
            int O00000o03 = O000000o3.O0000O0o - constraintAnchor2.O00000o0();
            int i3 = O00000o03 - O00000o02;
            if (!this.O0000O0o.O0000Oo && this.O00000oo == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                int i4 = this.O00000o0;
                if (i4 == 0) {
                    this.O0000O0o.O000000o(O000000o(i3, i));
                } else if (i4 == 1) {
                    this.O0000O0o.O000000o(Math.min(O000000o(this.O0000O0o.O0000o00, i), i3));
                } else if (i4 == 2) {
                    ConstraintWidget constraintWidget = this.O00000o.O000Oo0;
                    if (constraintWidget != null) {
                        WidgetRun widgetRun = i == 0 ? constraintWidget.O0000OOo : constraintWidget.O0000Oo0;
                        if (widgetRun.O0000O0o.O0000Oo) {
                            this.O0000O0o.O000000o(O000000o((int) ((((float) widgetRun.O0000O0o.O0000O0o) * (i == 0 ? this.O00000o.O0000oOO : this.O00000o.O0000oo)) + 0.5f), i));
                        }
                    }
                } else if (i4 == 3 && !(this.O00000o.O0000OOo.O00000oo == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && this.O00000o.O0000OOo.O00000o0 == 3 && this.O00000o.O0000Oo0.O00000oo == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && this.O00000o.O0000Oo0.O00000o0 == 3)) {
                    WidgetRun widgetRun2 = i == 0 ? this.O00000o.O0000Oo0 : this.O00000o.O0000OOo;
                    if (widgetRun2.O0000O0o.O0000Oo) {
                        float f2 = this.O00000o.O000OoO0;
                        if (i == 1) {
                            i2 = (int) ((((float) widgetRun2.O0000O0o.O0000O0o) / f2) + 0.5f);
                        } else {
                            i2 = (int) ((f2 * ((float) widgetRun2.O0000O0o.O0000O0o)) + 0.5f);
                        }
                        this.O0000O0o.O000000o(i2);
                    }
                }
            }
            if (this.O0000O0o.O0000Oo) {
                if (this.O0000O0o.O0000O0o == i3) {
                    this.O0000Oo.O000000o(O00000o02);
                    this.O0000OoO.O000000o(O00000o03);
                    return;
                }
                if (i == 0) {
                    f = this.O00000o.O000o00o;
                } else {
                    f = this.O00000o.O000o0;
                }
                if (O000000o2 == O000000o3) {
                    O00000o02 = O000000o2.O0000O0o;
                    O00000o03 = O000000o3.O0000O0o;
                    f = 0.5f;
                }
                this.O0000Oo.O000000o((int) (((float) O00000o02) + 0.5f + (((float) ((O00000o03 - O00000o02) - this.O0000O0o.O0000O0o)) * f)));
                this.O0000OoO.O000000o(this.O0000Oo.O0000O0o + this.O0000O0o.O0000O0o);
            }
        }
    }

    /* access modifiers changed from: protected */
    public final int O000000o(int i, int i2) {
        if (i2 == 0) {
            int i3 = this.O00000o.O0000oO;
            int max = Math.max(this.O00000o.O0000oO0, i);
            if (i3 > 0) {
                max = Math.min(i3, i);
            }
            if (max != i) {
                return max;
            }
            return i;
        }
        int i4 = this.O00000o.O0000oo0;
        int min = i4 > 0 ? Math.min(i4, i) : Math.max(this.O00000o.O0000oOo, i);
        return min != i ? min : i;
    }

    protected static DependencyNode O000000o(ConstraintAnchor constraintAnchor, int i) {
        if (constraintAnchor.O00000o0 == null) {
            return null;
        }
        ConstraintWidget constraintWidget = constraintAnchor.O00000o0.f2787O000000o;
        WidgetRun widgetRun = i == 0 ? constraintWidget.O0000OOo : constraintWidget.O0000Oo0;
        int i2 = AnonymousClass1.f2792O000000o[constraintAnchor.O00000o0.O00000Oo.ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    if (i2 != 5) {
                        return null;
                    }
                }
            }
            return widgetRun.O0000OoO;
        }
        return widgetRun.O0000Oo;
    }

    protected static void O000000o(DependencyNode dependencyNode, DependencyNode dependencyNode2, int i) {
        dependencyNode.O0000Ooo.add(dependencyNode2);
        dependencyNode.O00000oo = i;
        dependencyNode2.O0000OoO.add(dependencyNode);
    }

    /* access modifiers changed from: protected */
    public final void O000000o(DependencyNode dependencyNode, DependencyNode dependencyNode2, int i, oOO00000 ooo00000) {
        dependencyNode.O0000Ooo.add(dependencyNode2);
        dependencyNode.O0000Ooo.add(this.O0000O0o);
        dependencyNode.O0000OOo = i;
        dependencyNode.O0000Oo0 = ooo00000;
        dependencyNode2.O0000OoO.add(dependencyNode);
        ooo00000.O0000OoO.add(dependencyNode);
    }

    public long O00000Oo() {
        if (this.O0000O0o.O0000Oo) {
            return (long) this.O0000O0o.O0000O0o;
        }
        return 0;
    }
}
