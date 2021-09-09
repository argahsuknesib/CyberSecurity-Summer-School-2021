package _m_j;

import androidx.constraintlayout.solver.widgets.analyzer.DependencyNode;
import androidx.constraintlayout.solver.widgets.analyzer.WidgetRun;
import java.util.ArrayList;

public final class oOO0O00O {

    /* renamed from: O000000o  reason: collision with root package name */
    public static int f2297O000000o;
    public int O00000Oo = 0;
    WidgetRun O00000o = null;
    public boolean O00000o0 = false;
    WidgetRun O00000oO = null;
    ArrayList<WidgetRun> O00000oo = new ArrayList<>();
    int O0000O0o = 0;
    int O0000OOo;

    public oOO0O00O(WidgetRun widgetRun, int i) {
        int i2 = f2297O000000o;
        this.O0000O0o = i2;
        f2297O000000o = i2 + 1;
        this.O00000o = widgetRun;
        this.O00000oO = widgetRun;
        this.O0000OOo = i;
    }

    private long O000000o(DependencyNode dependencyNode, long j) {
        WidgetRun widgetRun = dependencyNode.O00000o;
        if (widgetRun instanceof ooooO000) {
            return j;
        }
        int size = dependencyNode.O0000OoO.size();
        long j2 = j;
        for (int i = 0; i < size; i++) {
            oO0o0000 oo0o0000 = dependencyNode.O0000OoO.get(i);
            if (oo0o0000 instanceof DependencyNode) {
                DependencyNode dependencyNode2 = (DependencyNode) oo0o0000;
                if (dependencyNode2.O00000o != widgetRun) {
                    j2 = Math.max(j2, O000000o(dependencyNode2, ((long) dependencyNode2.O00000oo) + j));
                }
            }
        }
        if (dependencyNode != widgetRun.O0000Oo) {
            return j2;
        }
        long O00000Oo2 = j + widgetRun.O00000Oo();
        return Math.max(Math.max(j2, O000000o(widgetRun.O0000OoO, O00000Oo2)), O00000Oo2 - ((long) widgetRun.O0000OoO.O00000oo));
    }

    private long O00000Oo(DependencyNode dependencyNode, long j) {
        WidgetRun widgetRun = dependencyNode.O00000o;
        if (widgetRun instanceof ooooO000) {
            return j;
        }
        int size = dependencyNode.O0000OoO.size();
        long j2 = j;
        for (int i = 0; i < size; i++) {
            oO0o0000 oo0o0000 = dependencyNode.O0000OoO.get(i);
            if (oo0o0000 instanceof DependencyNode) {
                DependencyNode dependencyNode2 = (DependencyNode) oo0o0000;
                if (dependencyNode2.O00000o != widgetRun) {
                    j2 = Math.min(j2, O00000Oo(dependencyNode2, ((long) dependencyNode2.O00000oo) + j));
                }
            }
        }
        if (dependencyNode != widgetRun.O0000OoO) {
            return j2;
        }
        long O00000Oo2 = j - widgetRun.O00000Oo();
        return Math.min(Math.min(j2, O00000Oo(widgetRun.O0000Oo, O00000Oo2)), O00000Oo2 - ((long) widgetRun.O0000Oo.O00000oo));
    }

    public final long O000000o(oOo0000O ooo0000o, int i) {
        long j;
        int i2;
        WidgetRun widgetRun = this.O00000o;
        long j2 = 0;
        if (widgetRun instanceof ooOOO00O) {
            if (((ooOOO00O) widgetRun).O0000OOo != i) {
                return 0;
            }
        } else if (i == 0) {
            if (!(widgetRun instanceof oOO0O000)) {
                return 0;
            }
        } else if (!(widgetRun instanceof oOO0O0O0)) {
            return 0;
        }
        DependencyNode dependencyNode = i == 0 ? ooo0000o.O0000OOo.O0000Oo : ooo0000o.O0000Oo0.O0000Oo;
        DependencyNode dependencyNode2 = i == 0 ? ooo0000o.O0000OOo.O0000OoO : ooo0000o.O0000Oo0.O0000OoO;
        boolean contains = this.O00000o.O0000Oo.O0000Ooo.contains(dependencyNode);
        boolean contains2 = this.O00000o.O0000OoO.O0000Ooo.contains(dependencyNode2);
        long O00000Oo2 = this.O00000o.O00000Oo();
        if (contains && contains2) {
            long O000000o2 = O000000o(this.O00000o.O0000Oo, 0);
            long O00000Oo3 = O00000Oo(this.O00000o.O0000OoO, 0);
            long j3 = O000000o2 - O00000Oo2;
            if (j3 >= ((long) (-this.O00000o.O0000OoO.O00000oo))) {
                j3 += (long) this.O00000o.O0000OoO.O00000oo;
            }
            long j4 = ((-O00000Oo3) - O00000Oo2) - ((long) this.O00000o.O0000Oo.O00000oo);
            if (j4 >= ((long) this.O00000o.O0000Oo.O00000oo)) {
                j4 -= (long) this.O00000o.O0000Oo.O00000oo;
            }
            float O00000Oo4 = this.O00000o.O00000o.O00000Oo(i);
            if (O00000Oo4 > 0.0f) {
                j2 = (long) ((((float) j4) / O00000Oo4) + (((float) j3) / (1.0f - O00000Oo4)));
            }
            float f = (float) j2;
            j = ((long) this.O00000o.O0000Oo.O00000oo) + ((long) ((f * O00000Oo4) + 0.5f)) + O00000Oo2 + ((long) ((f * (1.0f - O00000Oo4)) + 0.5f));
            i2 = this.O00000o.O0000OoO.O00000oo;
        } else if (contains) {
            return Math.max(O000000o(this.O00000o.O0000Oo, (long) this.O00000o.O0000Oo.O00000oo), ((long) this.O00000o.O0000Oo.O00000oo) + O00000Oo2);
        } else {
            if (contains2) {
                return Math.max(-O00000Oo(this.O00000o.O0000OoO, (long) this.O00000o.O0000OoO.O00000oo), ((long) (-this.O00000o.O0000OoO.O00000oo)) + O00000Oo2);
            }
            j = ((long) this.O00000o.O0000Oo.O00000oo) + this.O00000o.O00000Oo();
            i2 = this.O00000o.O0000OoO.O00000oo;
        }
        return j - ((long) i2);
    }
}
