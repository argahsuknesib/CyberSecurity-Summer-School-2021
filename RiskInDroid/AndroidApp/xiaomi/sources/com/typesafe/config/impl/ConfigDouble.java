package com.typesafe.config.impl;

import _m_j.dsi;
import com.typesafe.config.ConfigValueType;
import java.io.ObjectStreamException;
import java.io.Serializable;

public final class ConfigDouble extends ConfigNumber implements Serializable {
    private static final long serialVersionUID = 2;
    final double value;

    public ConfigDouble(dsi dsi, double d, String str) {
        super(dsi, str);
        this.value = d;
    }

    public final ConfigValueType O00000o0() {
        return ConfigValueType.NUMBER;
    }

    /* access modifiers changed from: package-private */
    public final String O0000OoO() {
        String O0000OoO = super.O0000OoO();
        return O0000OoO == null ? Double.toString(this.value) : O0000OoO;
    }

    /* access modifiers changed from: protected */
    public final long O000000o() {
        return (long) this.value;
    }

    /* access modifiers changed from: protected */
    public final double O0000Ooo() {
        return this.value;
    }

    private Object writeReplace() throws ObjectStreamException {
        return new SerializedConfigValue(this);
    }

    public final /* synthetic */ Number O0000o00() {
        return Double.valueOf(this.value);
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ AbstractConfigValue O000000o(dsi dsi) {
        return new ConfigDouble(dsi, this.value, this.originalText);
    }

    public final /* synthetic */ Object O00000o() {
        return Double.valueOf(this.value);
    }
}
