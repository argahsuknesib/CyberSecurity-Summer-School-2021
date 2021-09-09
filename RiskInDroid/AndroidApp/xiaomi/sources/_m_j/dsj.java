package _m_j;

import com.typesafe.config.ConfigSyntax;

public final class dsj {

    /* renamed from: O000000o  reason: collision with root package name */
    public final ConfigSyntax f14891O000000o;
    public final String O00000Oo;
    public final dsb O00000o;
    public final boolean O00000o0;
    final ClassLoader O00000oO;

    private dsj(ConfigSyntax configSyntax, String str, boolean z, dsb dsb, ClassLoader classLoader) {
        this.f14891O000000o = configSyntax;
        this.O00000Oo = str;
        this.O00000o0 = z;
        this.O00000o = dsb;
        this.O00000oO = classLoader;
    }

    public static dsj O000000o() {
        return new dsj(null, null, true, null, null);
    }

    public final dsj O000000o(ConfigSyntax configSyntax) {
        if (this.f14891O000000o == configSyntax) {
            return this;
        }
        return new dsj(configSyntax, this.O00000Oo, this.O00000o0, this.O00000o, this.O00000oO);
    }

    public final dsj O000000o(String str) {
        String str2 = this.O00000Oo;
        if (str2 == str) {
            return this;
        }
        if (str2 != null && str != null && str2.equals(str)) {
            return this;
        }
        return new dsj(this.f14891O000000o, str, this.O00000o0, this.O00000o, this.O00000oO);
    }

    public final dsj O000000o(boolean z) {
        if (this.O00000o0 == z) {
            return this;
        }
        return new dsj(this.f14891O000000o, this.O00000Oo, z, this.O00000o, this.O00000oO);
    }

    public final dsj O000000o(dsb dsb) {
        if (this.O00000o == dsb) {
            return this;
        }
        return new dsj(this.f14891O000000o, this.O00000Oo, this.O00000o0, dsb, this.O00000oO);
    }

    public final dsj O000000o(ClassLoader classLoader) {
        if (this.O00000oO == classLoader) {
            return this;
        }
        return new dsj(this.f14891O000000o, this.O00000Oo, this.O00000o0, this.O00000o, classLoader);
    }

    public final ClassLoader O00000Oo() {
        ClassLoader classLoader = this.O00000oO;
        return classLoader == null ? Thread.currentThread().getContextClassLoader() : classLoader;
    }
}
