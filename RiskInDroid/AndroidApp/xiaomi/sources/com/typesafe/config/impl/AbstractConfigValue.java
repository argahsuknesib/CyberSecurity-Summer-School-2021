package com.typesafe.config.impl;

import _m_j.dsg;
import _m_j.dsh;
import _m_j.dsi;
import _m_j.dsl;
import _m_j.dsn;
import _m_j.dso;
import _m_j.dsq;
import _m_j.dst;
import _m_j.dsy;
import _m_j.dtb;
import _m_j.dtf;
import _m_j.dtj;
import _m_j.dtp;
import com.typesafe.config.ConfigException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public abstract class AbstractConfigValue implements dsn, dsy {
    public final dtj origin;

    public interface O000000o {
        AbstractConfigValue O000000o(String str, AbstractConfigValue abstractConfigValue) throws Exception;
    }

    /* access modifiers changed from: protected */
    public abstract AbstractConfigValue O000000o(dsi dsi);

    /* access modifiers changed from: protected */
    public AbstractConfigValue O00000Oo(dtb dtb) {
        return this;
    }

    public AbstractConfigValue O00000Oo(dtf dtf) throws NotPossibleToResolve {
        return this;
    }

    /* renamed from: O00000oO */
    public AbstractConfigValue O00000oo() {
        return this;
    }

    public String O0000OoO() {
        return null;
    }

    protected AbstractConfigValue(dsi dsi) {
        this.origin = (dtj) dsi;
    }

    public static class NotPossibleToResolve extends Exception {
        private static final long serialVersionUID = 1;
        public final String traceString;

        public NotPossibleToResolve(dtf dtf) {
            super("was not possible to resolve");
            this.traceString = dtf.O00000o0();
        }
    }

    public ResolveStatus O0000O0o() {
        return ResolveStatus.RESOLVED;
    }

    public abstract class O00000Oo implements O000000o {
        /* access modifiers changed from: package-private */
        public abstract AbstractConfigValue O000000o(AbstractConfigValue abstractConfigValue);

        protected O00000Oo() {
        }

        public final AbstractConfigValue O000000o(String str, AbstractConfigValue abstractConfigValue) throws Exception {
            try {
                return O000000o(abstractConfigValue);
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception e2) {
                throw new ConfigException.BugOrBroken("Unexpected exception", e2);
            }
        }
    }

    public boolean O0000OOo() {
        return O0000O0o() == ResolveStatus.RESOLVED;
    }

    /* access modifiers changed from: protected */
    public AbstractConfigValue O0000Oo0() {
        if (O0000OOo()) {
            return this;
        }
        throw new ConfigException.BugOrBroken("value class doesn't implement forced fallback-ignoring ".concat(String.valueOf(this)));
    }

    /* access modifiers changed from: protected */
    public final void O0000Oo() {
        if (O0000OOo()) {
            throw new ConfigException.BugOrBroken("method should not have been called with ignoresFallbacks=true " + getClass().getSimpleName());
        }
    }

    /* access modifiers changed from: protected */
    public AbstractConfigValue O000000o(dsi dsi, List<AbstractConfigValue> list) {
        return new dsq(dsi, list);
    }

    /* access modifiers changed from: protected */
    public final AbstractConfigValue O000000o(Collection<AbstractConfigValue> collection, dtp dtp) {
        O0000Oo();
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(collection);
        arrayList.addAll(dtp.h_());
        return O000000o(dso.O000000o((Collection<? extends AbstractConfigValue>) arrayList), arrayList);
    }

    private final AbstractConfigValue O00000Oo(Collection<AbstractConfigValue> collection, AbstractConfigValue abstractConfigValue) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(collection);
        arrayList.add(abstractConfigValue);
        return O000000o(dso.O000000o((Collection<? extends AbstractConfigValue>) arrayList), arrayList);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.typesafe.config.impl.AbstractConfigValue.O000000o(java.util.Collection<com.typesafe.config.impl.AbstractConfigValue>, com.typesafe.config.impl.AbstractConfigValue):com.typesafe.config.impl.AbstractConfigValue
     arg types: [java.util.Collection<com.typesafe.config.impl.AbstractConfigValue>, _m_j.dso]
     candidates:
      com.typesafe.config.impl.AbstractConfigValue.O000000o(_m_j.dsi, java.util.List<com.typesafe.config.impl.AbstractConfigValue>):com.typesafe.config.impl.AbstractConfigValue
      com.typesafe.config.impl.AbstractConfigValue.O000000o(java.util.Collection<com.typesafe.config.impl.AbstractConfigValue>, _m_j.dso):com.typesafe.config.impl.AbstractConfigValue
      com.typesafe.config.impl.AbstractConfigValue.O000000o(java.util.Collection<com.typesafe.config.impl.AbstractConfigValue>, _m_j.dtp):com.typesafe.config.impl.AbstractConfigValue
      com.typesafe.config.impl.AbstractConfigValue.O000000o(java.util.Collection<com.typesafe.config.impl.AbstractConfigValue>, com.typesafe.config.impl.AbstractConfigValue):com.typesafe.config.impl.AbstractConfigValue */
    /* access modifiers changed from: protected */
    public final AbstractConfigValue O000000o(Collection<AbstractConfigValue> collection, dso dso) {
        O0000Oo();
        if (!(this instanceof dso)) {
            return O000000o(collection, (AbstractConfigValue) dso);
        }
        throw new ConfigException.BugOrBroken("Objects must reimplement mergedWithObject");
    }

    /* access modifiers changed from: protected */
    public final AbstractConfigValue O000000o(Collection<AbstractConfigValue> collection, AbstractConfigValue abstractConfigValue) {
        O0000Oo();
        if (O0000O0o() == ResolveStatus.RESOLVED) {
            return O0000Oo0();
        }
        return O00000Oo(collection, abstractConfigValue);
    }

    /* access modifiers changed from: protected */
    public AbstractConfigValue O000000o(dtp dtp) {
        O0000Oo();
        return O000000o(Collections.singletonList(this), dtp);
    }

    /* access modifiers changed from: protected */
    public AbstractConfigValue O00000Oo(dso dso) {
        O0000Oo();
        return O000000o((Collection<AbstractConfigValue>) Collections.singletonList(this), dso);
    }

    /* access modifiers changed from: protected */
    public AbstractConfigValue O000000o(AbstractConfigValue abstractConfigValue) {
        O0000Oo();
        return O000000o(Collections.singletonList(this), abstractConfigValue);
    }

    public final AbstractConfigValue O00000Oo(dsi dsi) {
        if (this.origin == dsi) {
            return this;
        }
        return O000000o(dsi);
    }

    public AbstractConfigValue O00000o0(dsg dsg) {
        if (O0000OOo()) {
            return this;
        }
        dsn O00000oo = ((dsy) dsg).O00000oo();
        if (O00000oo instanceof dtp) {
            return O000000o((dtp) O00000oo);
        }
        if (O00000oo instanceof dso) {
            return O00000Oo((dso) O00000oo);
        }
        return O000000o((AbstractConfigValue) O00000oo);
    }

    /* access modifiers changed from: protected */
    public boolean O00000Oo(Object obj) {
        return obj instanceof dsn;
    }

    public boolean equals(Object obj) {
        if ((obj instanceof dsn) && O00000Oo(obj)) {
            dsn dsn = (dsn) obj;
            if (O00000o0() != dsn.O00000o0() || !dst.O000000o(O00000o(), dsn.O00000o())) {
                return false;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        Object O00000o = O00000o();
        if (O00000o == null) {
            return 0;
        }
        return O00000o.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        O000000o(sb, 0, true, null, new dsl());
        return getClass().getSimpleName() + "(" + sb.toString() + ")";
    }

    public void O000000o(StringBuilder sb, int i, boolean z, dsl dsl) {
        sb.append(O00000o().toString());
    }

    public static void O000000o(StringBuilder sb, int i, dsl dsl) {
        if (dsl.O00000o0) {
            while (i > 0) {
                sb.append("    ");
                i--;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void O000000o(StringBuilder sb, int i, boolean z, String str, dsl dsl) {
        String str2;
        if (str != null) {
            if (dsl.O00000o) {
                str2 = dst.O000000o(str);
            } else {
                str2 = dst.O00000Oo(str);
            }
            sb.append(str2);
            if (dsl.O00000o) {
                if (dsl.O00000o0) {
                    sb.append(" : ");
                } else {
                    sb.append(":");
                }
            } else if (!(this instanceof dsh)) {
                sb.append("=");
            } else if (dsl.O00000o0) {
                sb.append(' ');
            }
        }
        O000000o(sb, i, z, dsl);
    }

    public final /* bridge */ /* synthetic */ dsi O00000Oo() {
        return this.origin;
    }
}
