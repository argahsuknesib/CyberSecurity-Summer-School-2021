package com.typesafe.config.impl;

import _m_j.dsi;
import java.io.ObjectStreamException;
import java.io.Serializable;

public abstract class ConfigNumber extends AbstractConfigValue implements Serializable {
    private static final long serialVersionUID = 2;
    protected final String originalText;

    /* access modifiers changed from: protected */
    public abstract long O000000o();

    /* access modifiers changed from: protected */
    public abstract double O0000Ooo();

    /* renamed from: O0000o00 */
    public abstract Number O00000o();

    protected ConfigNumber(dsi dsi, String str) {
        super(dsi);
        this.originalText = str;
    }

    /* access modifiers changed from: package-private */
    public String O0000OoO() {
        return this.originalText;
    }

    private boolean O0000o0() {
        return ((double) O000000o()) == O0000Ooo();
    }

    /* access modifiers changed from: protected */
    public final boolean O00000Oo(Object obj) {
        return obj instanceof ConfigNumber;
    }

    public boolean equals(Object obj) {
        boolean z = obj instanceof ConfigNumber;
        if (z && z) {
            ConfigNumber configNumber = (ConfigNumber) obj;
            if (O0000o0()) {
                if (!configNumber.O0000o0() || O000000o() != configNumber.O000000o()) {
                    return false;
                }
                return true;
            } else if (configNumber.O0000o0() || O0000Ooo() != configNumber.O0000Ooo()) {
                return false;
            } else {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        long j;
        if (O0000o0()) {
            j = O000000o();
        } else {
            j = Double.doubleToLongBits(O0000Ooo());
        }
        return (int) (j ^ (j >>> 32));
    }

    public static ConfigNumber O000000o(dsi dsi, long j, String str) {
        if (j > 2147483647L || j < -2147483648L) {
            return new ConfigLong(dsi, j, str);
        }
        return new ConfigInt(dsi, (int) j, str);
    }

    public static ConfigNumber O000000o(dsi dsi, double d, String str) {
        long j = (long) d;
        if (((double) j) == d) {
            return O000000o(dsi, j, str);
        }
        return new ConfigDouble(dsi, d, str);
    }

    private Object writeReplace() throws ObjectStreamException {
        return new SerializedConfigValue(this);
    }
}
