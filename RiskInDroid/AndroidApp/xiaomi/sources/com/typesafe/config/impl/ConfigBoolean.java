package com.typesafe.config.impl;

import _m_j.dsi;
import com.typesafe.config.ConfigValueType;
import java.io.ObjectStreamException;
import java.io.Serializable;

public final class ConfigBoolean extends AbstractConfigValue implements Serializable {
    private static final long serialVersionUID = 2;
    final boolean value;

    public ConfigBoolean(dsi dsi, boolean z) {
        super(dsi);
        this.value = z;
    }

    public final ConfigValueType O00000o0() {
        return ConfigValueType.BOOLEAN;
    }

    /* access modifiers changed from: package-private */
    public final String O0000OoO() {
        return this.value ? "true" : "false";
    }

    private Object writeReplace() throws ObjectStreamException {
        return new SerializedConfigValue(this);
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ AbstractConfigValue O000000o(dsi dsi) {
        return new ConfigBoolean(dsi, this.value);
    }

    public final /* synthetic */ Object O00000o() {
        return Boolean.valueOf(this.value);
    }
}
