package com.typesafe.config.impl;

import _m_j.dsi;
import _m_j.dsl;
import com.typesafe.config.ConfigValueType;
import java.io.ObjectStreamException;
import java.io.Serializable;

public final class ConfigNull extends AbstractConfigValue implements Serializable {
    private static final long serialVersionUID = 2;

    public final Object O00000o() {
        return null;
    }

    /* access modifiers changed from: package-private */
    public final String O0000OoO() {
        return "null";
    }

    public ConfigNull(dsi dsi) {
        super(dsi);
    }

    public final ConfigValueType O00000o0() {
        return ConfigValueType.NULL;
    }

    /* access modifiers changed from: protected */
    public final void O000000o(StringBuilder sb, int i, boolean z, dsl dsl) {
        sb.append("null");
    }

    private Object writeReplace() throws ObjectStreamException {
        return new SerializedConfigValue(this);
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ AbstractConfigValue O000000o(dsi dsi) {
        return new ConfigNull(dsi);
    }
}
