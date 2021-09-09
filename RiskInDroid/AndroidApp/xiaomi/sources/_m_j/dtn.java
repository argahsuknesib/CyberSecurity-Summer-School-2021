package _m_j;

import com.typesafe.config.ConfigException;
import com.typesafe.config.impl.TokenType;

public class dtn {

    /* renamed from: O000000o  reason: collision with root package name */
    private final TokenType f14929O000000o;
    private final String O00000Oo;
    private final dsi O00000o0;

    dtn(TokenType tokenType, dsi dsi) {
        this(tokenType, dsi, null);
    }

    private dtn(TokenType tokenType, dsi dsi, String str) {
        this.f14929O000000o = tokenType;
        this.O00000o0 = dsi;
        this.O00000Oo = str;
    }

    static dtn O000000o(TokenType tokenType, String str) {
        return new dtn(tokenType, null, str);
    }

    /* access modifiers changed from: package-private */
    public final dsi O000000o() {
        dsi dsi = this.O00000o0;
        if (dsi != null) {
            return dsi;
        }
        throw new ConfigException.BugOrBroken("tried to get origin from token that doesn't have one: ".concat(String.valueOf(this)));
    }

    /* access modifiers changed from: package-private */
    public final int O00000Oo() {
        dsi dsi = this.O00000o0;
        if (dsi != null) {
            return dsi.O00000Oo();
        }
        return -1;
    }

    public String toString() {
        String str = this.O00000Oo;
        if (str != null) {
            return str;
        }
        return this.f14929O000000o.name();
    }

    /* access modifiers changed from: protected */
    public boolean O000000o(Object obj) {
        return obj instanceof dtn;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof dtn) || !O000000o(obj) || this.f14929O000000o != ((dtn) obj).f14929O000000o) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.f14929O000000o.hashCode();
    }
}
