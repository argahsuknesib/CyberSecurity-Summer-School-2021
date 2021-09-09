package androidx.constraintlayout.solver.widgets.analyzer;

import _m_j.oO0o0000;
import _m_j.oOO00000;
import java.util.ArrayList;
import java.util.List;

public class DependencyNode implements oO0o0000 {

    /* renamed from: O000000o  reason: collision with root package name */
    public oO0o0000 f2791O000000o = null;
    public boolean O00000Oo = false;
    public WidgetRun O00000o;
    public boolean O00000o0 = false;
    public Type O00000oO = Type.UNKNOWN;
    public int O00000oo;
    public int O0000O0o;
    int O0000OOo = 1;
    public boolean O0000Oo = false;
    oOO00000 O0000Oo0 = null;
    public List<oO0o0000> O0000OoO = new ArrayList();
    public List<DependencyNode> O0000Ooo = new ArrayList();

    public enum Type {
        UNKNOWN,
        HORIZONTAL_DIMENSION,
        VERTICAL_DIMENSION,
        LEFT,
        RIGHT,
        TOP,
        BOTTOM,
        BASELINE
    }

    public DependencyNode(WidgetRun widgetRun) {
        this.O00000o = widgetRun;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.O00000o.O00000o.O000o0OO);
        sb.append(":");
        sb.append(this.O00000oO);
        sb.append("(");
        sb.append(this.O0000Oo ? Integer.valueOf(this.O0000O0o) : "unresolved");
        sb.append(") <t=");
        sb.append(this.O0000Ooo.size());
        sb.append(":d=");
        sb.append(this.O0000OoO.size());
        sb.append(">");
        return sb.toString();
    }

    public void O000000o(int i) {
        if (!this.O0000Oo) {
            this.O0000Oo = true;
            this.O0000O0o = i;
            for (oO0o0000 O00000o2 : this.O0000OoO) {
                O00000o2.O00000o();
            }
        }
    }

    public final void O00000o() {
        for (DependencyNode dependencyNode : this.O0000Ooo) {
            if (!dependencyNode.O0000Oo) {
                return;
            }
        }
        this.O00000o0 = true;
        oO0o0000 oo0o0000 = this.f2791O000000o;
        if (oo0o0000 != null) {
            oo0o0000.O00000o();
        }
        if (this.O00000Oo) {
            this.O00000o.O00000o();
            return;
        }
        DependencyNode dependencyNode2 = null;
        int i = 0;
        for (DependencyNode next : this.O0000Ooo) {
            if (!(next instanceof oOO00000)) {
                i++;
                dependencyNode2 = next;
            }
        }
        if (dependencyNode2 != null && i == 1 && dependencyNode2.O0000Oo) {
            oOO00000 ooo00000 = this.O0000Oo0;
            if (ooo00000 != null) {
                if (ooo00000.O0000Oo) {
                    this.O00000oo = this.O0000OOo * this.O0000Oo0.O0000O0o;
                } else {
                    return;
                }
            }
            O000000o(dependencyNode2.O0000O0o + this.O00000oo);
        }
        oO0o0000 oo0o00002 = this.f2791O000000o;
        if (oo0o00002 != null) {
            oo0o00002.O00000o();
        }
    }

    public final void O000000o(oO0o0000 oo0o0000) {
        this.O0000OoO.add(oo0o0000);
        if (this.O0000Oo) {
            oo0o0000.O00000o();
        }
    }

    public final void O000000o() {
        this.O0000Ooo.clear();
        this.O0000OoO.clear();
        this.O0000Oo = false;
        this.O0000O0o = 0;
        this.O00000o0 = false;
        this.O00000Oo = false;
    }
}
