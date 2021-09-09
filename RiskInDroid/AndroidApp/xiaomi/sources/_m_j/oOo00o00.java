package _m_j;

import _m_j.ooOOO0Oo;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.analyzer.DependencyNode;
import androidx.constraintlayout.solver.widgets.analyzer.WidgetRun;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public final class oOo00o00 {

    /* renamed from: O000000o  reason: collision with root package name */
    public oOo0000O f2332O000000o;
    public boolean O00000Oo = true;
    public oOo0000O O00000o;
    public boolean O00000o0 = true;
    public ArrayList<WidgetRun> O00000oO = new ArrayList<>();
    public ooOOO0Oo.O00000Oo O00000oo = null;
    ArrayList<oOO0O00O> O0000O0o = new ArrayList<>();
    private ArrayList<oOO0O00O> O0000OOo = new ArrayList<>();
    private ooOOO0Oo.O000000o O0000Oo0 = new ooOOO0Oo.O000000o();

    public oOo00o00(oOo0000O ooo0000o) {
        this.f2332O000000o = ooo0000o;
        this.O00000o = ooo0000o;
    }

    public final int O000000o(oOo0000O ooo0000o, int i) {
        int size = this.O0000O0o.size();
        long j = 0;
        for (int i2 = 0; i2 < size; i2++) {
            j = Math.max(j, this.O0000O0o.get(i2).O000000o(ooo0000o, i));
        }
        return (int) j;
    }

    private void O000000o(ConstraintWidget constraintWidget, ConstraintWidget.DimensionBehaviour dimensionBehaviour, int i, ConstraintWidget.DimensionBehaviour dimensionBehaviour2, int i2) {
        ooOOO0Oo.O000000o o000000o = this.O0000Oo0;
        o000000o.f2363O000000o = dimensionBehaviour;
        o000000o.O00000Oo = dimensionBehaviour2;
        o000000o.O00000o0 = i;
        o000000o.O00000o = i2;
        this.O00000oo.O000000o(constraintWidget, o000000o);
        constraintWidget.O00000oO(this.O0000Oo0.O00000oO);
        constraintWidget.O00000oo(this.O0000Oo0.O00000oo);
        constraintWidget.O000O0Oo = this.O0000Oo0.O0000OOo;
        constraintWidget.O0000Oo0(this.O0000Oo0.O0000O0o);
    }

    public final boolean O000000o(oOo0000O ooo0000o) {
        int i;
        int i2;
        Iterator it = ooo0000o.O00O0OoO.iterator();
        while (it.hasNext()) {
            ConstraintWidget constraintWidget = (ConstraintWidget) it.next();
            ConstraintWidget.DimensionBehaviour dimensionBehaviour = constraintWidget.O000Oo00[0];
            ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = constraintWidget.O000Oo00[1];
            if (constraintWidget.O000o0O == 8) {
                constraintWidget.O00000o = true;
            } else {
                if (constraintWidget.O0000oOO < 1.0f && dimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    constraintWidget.O0000o0O = 2;
                }
                if (constraintWidget.O0000oo < 1.0f && dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    constraintWidget.O0000o0o = 2;
                }
                if (constraintWidget.O000OoO0 > 0.0f) {
                    if (dimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && (dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.FIXED)) {
                        constraintWidget.O0000o0O = 3;
                    } else if (dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && (dimensionBehaviour == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || dimensionBehaviour == ConstraintWidget.DimensionBehaviour.FIXED)) {
                        constraintWidget.O0000o0o = 3;
                    } else if (dimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                        if (constraintWidget.O0000o0O == 0) {
                            constraintWidget.O0000o0O = 3;
                        }
                        if (constraintWidget.O0000o0o == 0) {
                            constraintWidget.O0000o0o = 3;
                        }
                    }
                }
                if (dimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.O0000o0O == 1 && (constraintWidget.O000O0o.O00000o0 == null || constraintWidget.O000O0oo.O00000o0 == null)) {
                    dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                }
                ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = dimensionBehaviour;
                ConstraintWidget.DimensionBehaviour dimensionBehaviour4 = (dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.O0000o0o == 1 && (constraintWidget.O000O0oO.O00000o0 == null || constraintWidget.O000OO00.O00000o0 == null)) ? ConstraintWidget.DimensionBehaviour.WRAP_CONTENT : dimensionBehaviour2;
                constraintWidget.O0000OOo.O00000oo = dimensionBehaviour3;
                constraintWidget.O0000OOo.O00000o0 = constraintWidget.O0000o0O;
                constraintWidget.O0000Oo0.O00000oo = dimensionBehaviour4;
                constraintWidget.O0000Oo0.O00000o0 = constraintWidget.O0000o0o;
                if ((dimensionBehaviour3 == ConstraintWidget.DimensionBehaviour.MATCH_PARENT || dimensionBehaviour3 == ConstraintWidget.DimensionBehaviour.FIXED || dimensionBehaviour3 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) && (dimensionBehaviour4 == ConstraintWidget.DimensionBehaviour.MATCH_PARENT || dimensionBehaviour4 == ConstraintWidget.DimensionBehaviour.FIXED || dimensionBehaviour4 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT)) {
                    int O00000oO2 = constraintWidget.O00000oO();
                    if (dimensionBehaviour3 == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
                        i = (ooo0000o.O00000oO() - constraintWidget.O000O0o.O00000o) - constraintWidget.O000O0oo.O00000o;
                        dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.FIXED;
                    } else {
                        i = O00000oO2;
                    }
                    int O00000oo2 = constraintWidget.O00000oo();
                    if (dimensionBehaviour4 == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
                        i2 = (ooo0000o.O00000oo() - constraintWidget.O000O0oO.O00000o) - constraintWidget.O000OO00.O00000o;
                        dimensionBehaviour4 = ConstraintWidget.DimensionBehaviour.FIXED;
                    } else {
                        i2 = O00000oo2;
                    }
                    O000000o(constraintWidget, dimensionBehaviour3, i, dimensionBehaviour4, i2);
                    constraintWidget.O0000OOo.O0000O0o.O000000o(constraintWidget.O00000oO());
                    constraintWidget.O0000Oo0.O0000O0o.O000000o(constraintWidget.O00000oo());
                    constraintWidget.O00000o = true;
                } else {
                    if (dimensionBehaviour3 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && (dimensionBehaviour4 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || dimensionBehaviour4 == ConstraintWidget.DimensionBehaviour.FIXED)) {
                        if (constraintWidget.O0000o0O == 3) {
                            if (dimensionBehaviour4 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                                O000000o(constraintWidget, ConstraintWidget.DimensionBehaviour.WRAP_CONTENT, 0, ConstraintWidget.DimensionBehaviour.WRAP_CONTENT, 0);
                            }
                            int O00000oo3 = constraintWidget.O00000oo();
                            ConstraintWidget.DimensionBehaviour dimensionBehaviour5 = ConstraintWidget.DimensionBehaviour.FIXED;
                            O000000o(constraintWidget, dimensionBehaviour5, (int) ((((float) O00000oo3) * constraintWidget.O000OoO0) + 0.5f), dimensionBehaviour5, O00000oo3);
                            constraintWidget.O0000OOo.O0000O0o.O000000o(constraintWidget.O00000oO());
                            constraintWidget.O0000Oo0.O0000O0o.O000000o(constraintWidget.O00000oo());
                            constraintWidget.O00000o = true;
                        } else if (constraintWidget.O0000o0O == 1) {
                            O000000o(constraintWidget, ConstraintWidget.DimensionBehaviour.WRAP_CONTENT, 0, dimensionBehaviour4, 0);
                            constraintWidget.O0000OOo.O0000O0o.O0000o00 = constraintWidget.O00000oO();
                        } else if (constraintWidget.O0000o0O == 2) {
                            if (ooo0000o.O000Oo00[0] == ConstraintWidget.DimensionBehaviour.FIXED || ooo0000o.O000Oo00[0] == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
                                ConstraintWidget constraintWidget2 = constraintWidget;
                                O000000o(constraintWidget2, ConstraintWidget.DimensionBehaviour.FIXED, (int) ((constraintWidget.O0000oOO * ((float) ooo0000o.O00000oO())) + 0.5f), dimensionBehaviour4, constraintWidget.O00000oo());
                                constraintWidget.O0000OOo.O0000O0o.O000000o(constraintWidget.O00000oO());
                                constraintWidget.O0000Oo0.O0000O0o.O000000o(constraintWidget.O00000oo());
                                constraintWidget.O00000o = true;
                            }
                        } else if (constraintWidget.O000OOo[0].O00000o0 == null || constraintWidget.O000OOo[1].O00000o0 == null) {
                            O000000o(constraintWidget, ConstraintWidget.DimensionBehaviour.WRAP_CONTENT, 0, dimensionBehaviour4, 0);
                            constraintWidget.O0000OOo.O0000O0o.O000000o(constraintWidget.O00000oO());
                            constraintWidget.O0000Oo0.O0000O0o.O000000o(constraintWidget.O00000oo());
                            constraintWidget.O00000o = true;
                        }
                    }
                    if (dimensionBehaviour4 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && (dimensionBehaviour3 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || dimensionBehaviour3 == ConstraintWidget.DimensionBehaviour.FIXED)) {
                        if (constraintWidget.O0000o0o == 3) {
                            if (dimensionBehaviour3 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                                O000000o(constraintWidget, ConstraintWidget.DimensionBehaviour.WRAP_CONTENT, 0, ConstraintWidget.DimensionBehaviour.WRAP_CONTENT, 0);
                            }
                            int O00000oO3 = constraintWidget.O00000oO();
                            float f = constraintWidget.O000OoO0;
                            if (constraintWidget.O0000OoO() == -1) {
                                f = 1.0f / f;
                            }
                            ConstraintWidget.DimensionBehaviour dimensionBehaviour6 = ConstraintWidget.DimensionBehaviour.FIXED;
                            O000000o(constraintWidget, dimensionBehaviour6, O00000oO3, dimensionBehaviour6, (int) ((((float) O00000oO3) * f) + 0.5f));
                            constraintWidget.O0000OOo.O0000O0o.O000000o(constraintWidget.O00000oO());
                            constraintWidget.O0000Oo0.O0000O0o.O000000o(constraintWidget.O00000oo());
                            constraintWidget.O00000o = true;
                        } else if (constraintWidget.O0000o0o == 1) {
                            O000000o(constraintWidget, dimensionBehaviour3, 0, ConstraintWidget.DimensionBehaviour.WRAP_CONTENT, 0);
                            constraintWidget.O0000Oo0.O0000O0o.O0000o00 = constraintWidget.O00000oo();
                        } else if (constraintWidget.O0000o0o == 2) {
                            if (ooo0000o.O000Oo00[1] == ConstraintWidget.DimensionBehaviour.FIXED || ooo0000o.O000Oo00[1] == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
                                ConstraintWidget constraintWidget3 = constraintWidget;
                                O000000o(constraintWidget3, dimensionBehaviour3, constraintWidget.O00000oO(), ConstraintWidget.DimensionBehaviour.FIXED, (int) ((constraintWidget.O0000oo * ((float) ooo0000o.O00000oo())) + 0.5f));
                                constraintWidget.O0000OOo.O0000O0o.O000000o(constraintWidget.O00000oO());
                                constraintWidget.O0000Oo0.O0000O0o.O000000o(constraintWidget.O00000oo());
                                constraintWidget.O00000o = true;
                            }
                        } else if (constraintWidget.O000OOo[2].O00000o0 == null || constraintWidget.O000OOo[3].O00000o0 == null) {
                            O000000o(constraintWidget, ConstraintWidget.DimensionBehaviour.WRAP_CONTENT, 0, dimensionBehaviour4, 0);
                            constraintWidget.O0000OOo.O0000O0o.O000000o(constraintWidget.O00000oO());
                            constraintWidget.O0000Oo0.O0000O0o.O000000o(constraintWidget.O00000oo());
                            constraintWidget.O00000o = true;
                        }
                    }
                    if (dimensionBehaviour3 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && dimensionBehaviour4 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                        if (constraintWidget.O0000o0O == 1 || constraintWidget.O0000o0o == 1) {
                            O000000o(constraintWidget, ConstraintWidget.DimensionBehaviour.WRAP_CONTENT, 0, ConstraintWidget.DimensionBehaviour.WRAP_CONTENT, 0);
                            constraintWidget.O0000OOo.O0000O0o.O0000o00 = constraintWidget.O00000oO();
                            constraintWidget.O0000Oo0.O0000O0o.O0000o00 = constraintWidget.O00000oo();
                        } else if (constraintWidget.O0000o0o == 2 && constraintWidget.O0000o0O == 2) {
                            if ((ooo0000o.O000Oo00[0] == ConstraintWidget.DimensionBehaviour.FIXED || ooo0000o.O000Oo00[0] == ConstraintWidget.DimensionBehaviour.FIXED) && (ooo0000o.O000Oo00[1] == ConstraintWidget.DimensionBehaviour.FIXED || ooo0000o.O000Oo00[1] == ConstraintWidget.DimensionBehaviour.FIXED)) {
                                float f2 = constraintWidget.O0000oOO;
                                float f3 = constraintWidget.O0000oo;
                                ConstraintWidget.DimensionBehaviour dimensionBehaviour7 = ConstraintWidget.DimensionBehaviour.FIXED;
                                O000000o(constraintWidget, dimensionBehaviour7, (int) ((f2 * ((float) ooo0000o.O00000oO())) + 0.5f), dimensionBehaviour7, (int) ((f3 * ((float) ooo0000o.O00000oo())) + 0.5f));
                                constraintWidget.O0000OOo.O0000O0o.O000000o(constraintWidget.O00000oO());
                                constraintWidget.O0000Oo0.O0000O0o.O000000o(constraintWidget.O00000oo());
                                constraintWidget.O00000o = true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public final void O000000o() {
        Iterator it = this.f2332O000000o.O00O0OoO.iterator();
        while (it.hasNext()) {
            ConstraintWidget constraintWidget = (ConstraintWidget) it.next();
            if (!constraintWidget.O00000o) {
                boolean z = false;
                ConstraintWidget.DimensionBehaviour dimensionBehaviour = constraintWidget.O000Oo00[0];
                ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = constraintWidget.O000Oo00[1];
                int i = constraintWidget.O0000o0O;
                int i2 = constraintWidget.O0000o0o;
                boolean z2 = dimensionBehaviour == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || (dimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && i == 1);
                if (dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || (dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && i2 == 1)) {
                    z = true;
                }
                boolean z3 = constraintWidget.O0000OOo.O0000O0o.O0000Oo;
                boolean z4 = constraintWidget.O0000Oo0.O0000O0o.O0000Oo;
                if (z3 && z4) {
                    O000000o(constraintWidget, ConstraintWidget.DimensionBehaviour.FIXED, constraintWidget.O0000OOo.O0000O0o.O0000O0o, ConstraintWidget.DimensionBehaviour.FIXED, constraintWidget.O0000Oo0.O0000O0o.O0000O0o);
                    constraintWidget.O00000o = true;
                } else if (z3 && z) {
                    O000000o(constraintWidget, ConstraintWidget.DimensionBehaviour.FIXED, constraintWidget.O0000OOo.O0000O0o.O0000O0o, ConstraintWidget.DimensionBehaviour.WRAP_CONTENT, constraintWidget.O0000Oo0.O0000O0o.O0000O0o);
                    if (dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                        constraintWidget.O0000Oo0.O0000O0o.O0000o00 = constraintWidget.O00000oo();
                    } else {
                        constraintWidget.O0000Oo0.O0000O0o.O000000o(constraintWidget.O00000oo());
                        constraintWidget.O00000o = true;
                    }
                } else if (z4 && z2) {
                    O000000o(constraintWidget, ConstraintWidget.DimensionBehaviour.WRAP_CONTENT, constraintWidget.O0000OOo.O0000O0o.O0000O0o, ConstraintWidget.DimensionBehaviour.FIXED, constraintWidget.O0000Oo0.O0000O0o.O0000O0o);
                    if (dimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                        constraintWidget.O0000OOo.O0000O0o.O0000o00 = constraintWidget.O00000oO();
                    } else {
                        constraintWidget.O0000OOo.O0000O0o.O000000o(constraintWidget.O00000oO());
                        constraintWidget.O00000o = true;
                    }
                }
                if (constraintWidget.O00000o && constraintWidget.O0000Oo0.O00000Oo != null) {
                    constraintWidget.O0000Oo0.O00000Oo.O000000o(constraintWidget.O000Oooo);
                }
            }
        }
    }

    public final void O00000Oo() {
        O000000o(this.O00000oO);
        this.O0000O0o.clear();
        oOO0O00O.f2297O000000o = 0;
        O000000o(this.f2332O000000o.O0000OOo, 0, this.O0000O0o);
        O000000o(this.f2332O000000o.O0000Oo0, 1, this.O0000O0o);
        this.O00000Oo = false;
    }

    private void O000000o(ArrayList<WidgetRun> arrayList) {
        arrayList.clear();
        this.O00000o.O0000OOo.O00000o0();
        this.O00000o.O0000Oo0.O00000o0();
        arrayList.add(this.O00000o.O0000OOo);
        arrayList.add(this.O00000o.O0000Oo0);
        Iterator it = this.O00000o.O00O0OoO.iterator();
        HashSet hashSet = null;
        while (it.hasNext()) {
            ConstraintWidget constraintWidget = (ConstraintWidget) it.next();
            if (constraintWidget instanceof oO0O000o) {
                arrayList.add(new ooooOO00(constraintWidget));
            } else {
                if (constraintWidget.O0000o00()) {
                    if (constraintWidget.O00000oo == null) {
                        constraintWidget.O00000oo = new ooOOO00O(constraintWidget, 0);
                    }
                    if (hashSet == null) {
                        hashSet = new HashSet();
                    }
                    hashSet.add(constraintWidget.O00000oo);
                } else {
                    arrayList.add(constraintWidget.O0000OOo);
                }
                if (constraintWidget.O0000o0()) {
                    if (constraintWidget.O0000O0o == null) {
                        constraintWidget.O0000O0o = new ooOOO00O(constraintWidget, 1);
                    }
                    if (hashSet == null) {
                        hashSet = new HashSet();
                    }
                    hashSet.add(constraintWidget.O0000O0o);
                } else {
                    arrayList.add(constraintWidget.O0000Oo0);
                }
                if (constraintWidget instanceof oO0O00o0) {
                    arrayList.add(new ooooO000(constraintWidget));
                }
            }
        }
        if (hashSet != null) {
            arrayList.addAll(hashSet);
        }
        Iterator<WidgetRun> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            it2.next().O00000o0();
        }
        Iterator<WidgetRun> it3 = arrayList.iterator();
        while (it3.hasNext()) {
            WidgetRun next = it3.next();
            if (next.O00000o != this.O00000o) {
                next.O00000oo();
            }
        }
    }

    private void O000000o(DependencyNode dependencyNode, int i, int i2, DependencyNode dependencyNode2, ArrayList<oOO0O00O> arrayList, oOO0O00O ooo0o00o) {
        WidgetRun widgetRun = dependencyNode.O00000o;
        if (widgetRun.O00000oO == null && widgetRun != this.f2332O000000o.O0000OOo && widgetRun != this.f2332O000000o.O0000Oo0) {
            if (ooo0o00o == null) {
                ooo0o00o = new oOO0O00O(widgetRun, i2);
                arrayList.add(ooo0o00o);
            }
            widgetRun.O00000oO = ooo0o00o;
            ooo0o00o.O00000oo.add(widgetRun);
            ooo0o00o.O00000oO = widgetRun;
            for (oO0o0000 next : widgetRun.O0000Oo.O0000OoO) {
                if (next instanceof DependencyNode) {
                    O000000o((DependencyNode) next, i, 0, dependencyNode2, arrayList, ooo0o00o);
                }
            }
            for (oO0o0000 next2 : widgetRun.O0000OoO.O0000OoO) {
                if (next2 instanceof DependencyNode) {
                    O000000o((DependencyNode) next2, i, 1, dependencyNode2, arrayList, ooo0o00o);
                }
            }
            if (i == 1 && (widgetRun instanceof oOO0O0O0)) {
                for (oO0o0000 next3 : ((oOO0O0O0) widgetRun).f2298O000000o.O0000OoO) {
                    if (next3 instanceof DependencyNode) {
                        O000000o((DependencyNode) next3, i, 2, dependencyNode2, arrayList, ooo0o00o);
                    }
                }
            }
            for (DependencyNode next4 : widgetRun.O0000Oo.O0000Ooo) {
                if (next4 == dependencyNode2) {
                    ooo0o00o.O00000o0 = true;
                }
                O000000o(next4, i, 0, dependencyNode2, arrayList, ooo0o00o);
            }
            for (DependencyNode next5 : widgetRun.O0000OoO.O0000Ooo) {
                if (next5 == dependencyNode2) {
                    ooo0o00o.O00000o0 = true;
                }
                O000000o(next5, i, 1, dependencyNode2, arrayList, ooo0o00o);
            }
            if (i == 1 && (widgetRun instanceof oOO0O0O0)) {
                for (DependencyNode O000000o2 : ((oOO0O0O0) widgetRun).f2298O000000o.O0000Ooo) {
                    O000000o(O000000o2, i, 2, dependencyNode2, arrayList, ooo0o00o);
                }
            }
        }
    }

    private void O000000o(WidgetRun widgetRun, int i, ArrayList<oOO0O00O> arrayList) {
        for (oO0o0000 next : widgetRun.O0000Oo.O0000OoO) {
            if (next instanceof DependencyNode) {
                O000000o((DependencyNode) next, i, 0, widgetRun.O0000OoO, arrayList, null);
            } else if (next instanceof WidgetRun) {
                O000000o(((WidgetRun) next).O0000Oo, i, 0, widgetRun.O0000OoO, arrayList, null);
            }
        }
        for (oO0o0000 next2 : widgetRun.O0000OoO.O0000OoO) {
            if (next2 instanceof DependencyNode) {
                O000000o((DependencyNode) next2, i, 1, widgetRun.O0000Oo, arrayList, null);
            } else if (next2 instanceof WidgetRun) {
                O000000o(((WidgetRun) next2).O0000OoO, i, 1, widgetRun.O0000Oo, arrayList, null);
            }
        }
        if (i == 1) {
            for (oO0o0000 next3 : ((oOO0O0O0) widgetRun).f2298O000000o.O0000OoO) {
                if (next3 instanceof DependencyNode) {
                    O000000o((DependencyNode) next3, i, 2, null, arrayList, null);
                }
            }
        }
    }
}
