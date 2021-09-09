package _m_j;

import _m_j.aki;
import com.fasterxml.jackson.databind.MapperFeature;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class aky {

    /* renamed from: O000000o  reason: collision with root package name */
    protected final ajq f12428O000000o;
    protected final boolean O00000Oo;
    protected List<amh> O00000o;
    protected final Map<String, alm> O00000o0 = new LinkedHashMap();
    protected HashMap<String, alm> O00000oO;
    protected HashSet<String> O00000oo;
    protected aln O0000O0o;
    protected alx O0000OOo;
    protected boolean O0000Oo;
    protected all O0000Oo0;
    protected ann O0000OoO;
    protected aki.O000000o O0000Ooo;

    public aky(ajq ajq, ajs ajs) {
        this.f12428O000000o = ajq;
        this.O00000Oo = ajs.O000000o(MapperFeature.DEFAULT_VIEW_INCLUSION);
    }

    public final void O000000o(alm alm) {
        this.O00000o0.put(alm.O00000o(), alm);
    }

    public final void O00000Oo(alm alm) {
        alm put = this.O00000o0.put(alm.O00000o(), alm);
        if (put != null && put != alm) {
            throw new IllegalArgumentException("Duplicate property '" + alm.O00000o() + "' for " + this.f12428O000000o.O000000o());
        }
    }

    public final void O000000o(String str, alm alm) {
        if (this.O00000oO == null) {
            this.O00000oO = new HashMap<>(4);
        }
        this.O00000oO.put(str, alm);
        Map<String, alm> map = this.O00000o0;
        if (map != null) {
            map.remove(alm.O00000o());
        }
    }

    public final void O000000o(String str, ajv ajv, ast ast, anm anm, Object obj) {
        if (this.O00000o == null) {
            this.O00000o = new ArrayList();
        }
        this.O00000o.add(new amh(str, ajv, ast, anm, obj));
    }

    public final void O000000o(String str) {
        if (this.O00000oo == null) {
            this.O00000oo = new HashSet<>();
        }
        this.O00000oo.add(str);
    }

    public final void O000000o(all all) {
        if (this.O0000Oo0 == null || all == null) {
            this.O0000Oo0 = all;
            return;
        }
        throw new IllegalStateException("_anySetter already set to non-null");
    }

    public final void O000000o(boolean z) {
        this.O0000Oo = z;
    }

    public final void O000000o(aln aln) {
        this.O0000O0o = aln;
    }

    public final void O000000o(alx alx) {
        this.O0000OOo = alx;
    }

    public final void O000000o(ann ann, aki.O000000o o000000o) {
        this.O0000OoO = ann;
        this.O0000Ooo = o000000o;
    }

    public final alm O00000Oo(String str) {
        return this.O00000o0.get(str);
    }

    public final all O000000o() {
        return this.O0000Oo0;
    }

    public final aln O00000Oo() {
        return this.O0000O0o;
    }

    public final List<amh> O00000o0() {
        return this.O00000o;
    }

    public final alx O00000o() {
        return this.O0000OOo;
    }

    public final ann O00000oO() {
        return this.O0000OoO;
    }

    public final akw O00000oo() {
        boolean z;
        Collection<alm> values = this.O00000o0.values();
        alp alp = new alp(values);
        alp.O000000o();
        boolean z2 = !this.O00000Oo;
        if (!z2) {
            Iterator<alm> it = values.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (it.next().O0000Oo()) {
                        z = true;
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        z = z2;
        alx alx = this.O0000OOo;
        if (alx != null) {
            alp = alp.O000000o(new aly(alx));
        }
        return new akw(this, this.f12428O000000o, alp, this.O00000oO, this.O00000oo, this.O0000Oo, z);
    }

    public final aku O0000O0o() {
        return new aku(this, this.f12428O000000o, this.O00000oO);
    }

    public final ajw<?> O000000o(ajv ajv, String str) {
        boolean z;
        ann ann = this.O0000OoO;
        if (ann != null) {
            Class<?> O0000o0O = ann.O0000o0O();
            if (ajv.O00000Oo().isAssignableFrom(O0000o0O)) {
                Collection<alm> values = this.O00000o0.values();
                alp alp = new alp(values);
                alp.O000000o();
                boolean z2 = !this.O00000Oo;
                if (!z2) {
                    Iterator<alm> it = values.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (it.next().O0000Oo()) {
                                z = true;
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                }
                z = z2;
                alx alx = this.O0000OOo;
                if (alx != null) {
                    alp = alp.O000000o(new aly(alx));
                }
                return new alb(this, this.f12428O000000o, alp, this.O00000oO, this.O00000oo, this.O0000Oo, z);
            }
            throw new IllegalArgumentException("Build method '" + this.O0000OoO.O0000Ooo() + " has bad return type (" + O0000o0O.getName() + "), not compatible with POJO type (" + ajv.O00000Oo().getName() + ")");
        }
        throw new IllegalArgumentException("Builder class " + this.f12428O000000o.O00000Oo().getName() + " does not have build method '" + str + "()'");
    }
}
