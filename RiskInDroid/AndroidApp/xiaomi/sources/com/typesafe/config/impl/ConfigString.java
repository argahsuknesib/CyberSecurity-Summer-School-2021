package com.typesafe.config.impl;

import _m_j.dsi;
import _m_j.dsl;
import _m_j.dst;
import com.typesafe.config.ConfigValueType;
import java.io.ObjectStreamException;
import java.io.Serializable;

public final class ConfigString extends AbstractConfigValue implements Serializable {
    private static final long serialVersionUID = 2;
    final String value;

    public ConfigString(dsi dsi, String str) {
        super(dsi);
        this.value = str;
    }

    public final ConfigValueType O00000o0() {
        return ConfigValueType.STRING;
    }

    /* access modifiers changed from: package-private */
    public final String O0000OoO() {
        return this.value;
    }

    private Object writeReplace() throws ObjectStreamException {
        return new SerializedConfigValue(this);
    }

    /* access modifiers changed from: protected */
    public final void O000000o(StringBuilder sb, int i, boolean z, dsl dsl) {
        String str;
        if (dsl.O00000o) {
            str = dst.O000000o(this.value);
        } else {
            str = dst.O00000Oo(this.value);
        }
        sb.append(str);
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ AbstractConfigValue O000000o(dsi dsi) {
        return new ConfigString(dsi, this.value);
    }

    public final /* bridge */ /* synthetic */ Object O00000o() {
        return this.value;
    }
}
